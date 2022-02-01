package com.tencent.mm.plugin.voip.widget;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.app.f.d;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.a.a;
import com.tencent.mm.plugin.voip.f.k;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.ui.j;
import com.tencent.mm.plugin.voip.ui.j.4;
import com.tencent.mm.plugin.voip.ui.j.5;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.threadpool.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private boolean LoC;
  private boolean UBV;
  private int UII;
  private c UVg;
  private BaseSmallView UVh;
  private MTimerHandler UVi;
  private boolean UVj;
  private long UVk;
  private boolean UVl;
  private boolean UVm;
  private boolean UVn;
  private View.OnClickListener UVo;
  private int UVp;
  boolean UVq;
  private WakerLock UVr;
  private int UxA;
  private int UxE;
  private int UxF;
  private au Uxa;
  private boolean Uxb;
  public boolean Uxc;
  private int Uxg;
  private long Uxh;
  private int Uxz;
  private int mStatus;
  private PowerManager.WakeLock mUJ;
  
  public b(c paramc, int paramInt, au paramau, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(293454);
    this.UVj = false;
    this.mStatus = -1;
    this.Uxh = -1L;
    this.Uxg = 1;
    this.UVk = -1L;
    this.UVl = false;
    this.UVm = false;
    this.UBV = false;
    this.Uxz = 0;
    this.UxA = 0;
    this.UxE = 0;
    this.UxF = 0;
    this.LoC = false;
    this.UVn = false;
    this.UVo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(293482);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        b.a(b.this).hVX();
        if (!com.tencent.mm.plugin.voip.f.h.ibz()) {
          paramAnonymousView = b.idM();
        }
        for (;;)
        {
          if (paramAnonymousView != null)
          {
            paramAnonymousView.setFlags(268435456);
            paramAnonymousView = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramAnonymousView, 0);
          }
          try
          {
            paramAnonymousView.send();
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(293444);
                b.b(b.this);
                AppMethodBeat.o(293444);
              }
            }, 200L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(293482);
            return;
            paramAnonymousView = b.idN();
          }
          catch (PendingIntent.CanceledException paramAnonymousView)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Voip.NewVoipSmallWindow", paramAnonymousView, "send pending intent error: %s", new Object[] { paramAnonymousView.getMessage() });
            }
          }
        }
      }
    };
    this.UVp = -1;
    this.UVq = false;
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { k.arg(paramInt), paramau.field_username, Boolean.valueOf(paramBoolean1) });
    this.Uxa = paramau;
    this.UVg = paramc;
    this.Uxc = paramBoolean1;
    this.Uxb = paramBoolean2;
    this.UBV = paramBoolean3;
    iU(0, paramInt);
    this.mUJ = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.NewVoipSmallWindow");
    paramc = this.mUJ;
    com.tencent.mm.hellhoundlib.a.a.b(paramc, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow", "<init>", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUIListener;ILcom/tencent/mm/storage/Contact;ZZZ)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    paramc.acquire();
    com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow", "<init>", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUIListener;ILcom/tencent/mm/storage/Contact;ZZZ)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    paramc = t.UBA;
    t.hYe();
    AppMethodBeat.o(293454);
  }
  
  private void Hb(boolean paramBoolean)
  {
    AppMethodBeat.i(293519);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "removeSmallView isFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
    if (this.UVi != null) {
      this.UVi.stopTimer();
    }
    if (paramBoolean) {
      SubCoreVoip.hVq().ghz();
    }
    for (;;)
    {
      if ((this.UVh != null) && (!paramBoolean))
      {
        this.UVh.uninit();
        if (this.UVh.getParent() != null) {
          ((ViewGroup)this.UVh.getParent()).removeAllViews();
        }
        this.UVh = null;
      }
      AppMethodBeat.o(293519);
      return;
      SubCoreVoip.hVq().jb(false);
    }
  }
  
  private static void KE(String paramString)
  {
    AppMethodBeat.i(293523);
    com.tencent.mm.kernel.h.baE().ban().setLong(327950, System.currentTimeMillis());
    Log.d("MicroMsg.Voip.NewVoipSmallWindow", "reportRawMessage, len: " + paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n#client.version=").append(d.Yxh).append("\n");
    localStringBuilder.append("#accinfo.revision=").append(BuildInfo.REV).append("\n");
    localStringBuilder.append("#accinfo.build=").append(BuildInfo.TIME).append(":").append(BuildInfo.HOSTNAME).append(":").append(ChannelUtil.channelId).append("\n");
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    localStringBuilder.append("#accinfo.uploadTime=" + localSimpleDateFormat.format((Date)localObject)).append("\n");
    localStringBuilder.append("#accinfo.content:\n");
    localObject = new Intent();
    ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    ((Intent)localObject).setAction("uncatch_exception");
    ((Intent)localObject).putExtra("exceptionWriteSdcard", false);
    ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
    ((Intent)localObject).putExtra("userName", aCz());
    ((Intent)localObject).putExtra("tag", "float_window_permission");
    ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + paramString).getBytes(), 2));
    MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(293523);
  }
  
  private static String aCz()
  {
    AppMethodBeat.i(293525);
    String str2 = bg.okT.aM("login_weixin_username", "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = bg.okT.aM("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(293525);
    return str1;
  }
  
  private void arA(int paramInt)
  {
    AppMethodBeat.i(293474);
    switch (paramInt)
    {
    }
    for (;;)
    {
      Hb(true);
      AppMethodBeat.o(293474);
      return;
      MMApplicationContext.getContext();
      continue;
      MMApplicationContext.getContext();
      continue;
      MMApplicationContext.getContext();
    }
  }
  
  private void arB(int paramInt)
  {
    AppMethodBeat.i(293494);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showVoiceTalking");
    this.UVm = true;
    if (-1L == this.UVk) {
      this.UVk = System.currentTimeMillis();
    }
    if (2 == this.Uxg) {
      MMApplicationContext.getContext();
    }
    String str = idS();
    bj(str, aa.getDisplayName(this.Uxa.field_username), str);
    idQ();
    this.UVh = SubCoreVoip.hVq().br(false, this.UVl);
    if (this.UVl) {
      a.a.Uvh.hVu();
    }
    if (4101 == paramInt) {
      MMApplicationContext.getContext();
    }
    AppMethodBeat.o(293494);
  }
  
  public static int guX()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return b.c.notification_icon;
    }
    return b.c.notification_icon_gray;
  }
  
  private void iam()
  {
    AppMethodBeat.i(293481);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showVideoTalking");
    this.UVl = true;
    if (-1L == this.UVk) {
      this.UVk = System.currentTimeMillis();
    }
    if (this.UVg != null) {
      this.UVg.hVP();
    }
    String str = MMApplicationContext.getContext().getString(b.g.voip_video_is_talking_tip);
    bj(str, aa.getDisplayName(this.Uxa.field_username), str);
    idQ();
    this.UVh = SubCoreVoip.hVq().br(true, false);
    idR();
    AppMethodBeat.o(293481);
  }
  
  public static Intent idM()
  {
    AppMethodBeat.i(293433);
    Intent localIntent = new Intent();
    localIntent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
    localIntent.putExtra("Voip_Call_From", 3);
    com.tencent.mm.plugin.voip.f.f localf = com.tencent.mm.plugin.voip.f.f.ULF;
    com.tencent.mm.plugin.voip.f.f.ibk();
    AppMethodBeat.o(293433);
    return localIntent;
  }
  
  public static Intent idN()
  {
    AppMethodBeat.i(293441);
    Object localObject = SubCoreVoip.hVp().UBE.toUser;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.w("MicroMsg.Voip.NewVoipSmallWindow", "null talkName");
      AppMethodBeat.o(293441);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.flutter.voip.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class)).aQ(MMApplicationContext.getContext(), (String)localObject);
    AppMethodBeat.o(293441);
    return localObject;
  }
  
  private void idO()
  {
    AppMethodBeat.i(293465);
    if ((this.mStatus == 261) || (this.mStatus == 7) || (this.mStatus == 260) || (this.mStatus == 6))
    {
      this.UVq = true;
      if (this.UVi != null) {
        this.UVi.stopTimer();
      }
      this.UVi = new MTimerHandler("timerCounter", new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(293473);
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(293498);
              SubCoreVoip.hVq().aNF(b.this.idP());
              AppMethodBeat.o(293498);
            }
          });
          AppMethodBeat.o(293473);
          return true;
        }
      }, true);
      this.UVi.startTimer(1000L);
    }
    AppMethodBeat.o(293465);
  }
  
  private void idQ()
  {
    AppMethodBeat.i(293500);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showMini");
    if (com.tencent.mm.plugin.voip.f.h.ibz()) {}
    for (Intent localIntent = idN(); localIntent == null; localIntent = idM())
    {
      AppMethodBeat.o(293500);
      return;
    }
    localIntent.putExtra("Voip_User", this.Uxa.field_username);
    localIntent.putExtra("Voip_CallRoomKey", SubCoreVoip.hVp().hVw());
    localIntent.putExtra("Voip_Outcall", this.Uxb);
    localIntent.putExtra("Voip_VideoCall", this.Uxc);
    localIntent.putExtra("Voip_Is_Talking", this.UVq);
    SubCoreVoip.hVq().a(localIntent, this.Uxc, new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(293488);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          SubCoreVoip.hVq().aNF(b.this.idP());
        }
        for (;;)
        {
          if ((b.c(b.this)) && (b.f(b.this)))
          {
            b.a(b.this, false);
            b.a(b.this, paramAnonymousBaseSmallView);
            b.g(b.this);
          }
          AppMethodBeat.o(293488);
          return;
          SubCoreVoip.hVq().updateText(MMApplicationContext.getContext().getString(b.g.voip_multitalk_waiting_wording));
        }
      }
      
      public final boolean fQS()
      {
        AppMethodBeat.i(293480);
        if (b.c(b.this))
        {
          String str = MMApplicationContext.getContext().getString(b.g.voip_video_is_talking_tip);
          b.this.bj(str, aa.getDisplayName(b.d(b.this).field_username), str);
          if ((k.arl(b.e(b.this))) || (k.arj(b.e(b.this))))
          {
            b.a(b.this, true);
            AppMethodBeat.o(293480);
            return true;
          }
          ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
          b.b(b.this);
          AppMethodBeat.o(293480);
          return false;
        }
        if ((k.arl(b.e(b.this))) || (k.arj(b.e(b.this))))
        {
          AppMethodBeat.o(293480);
          return true;
        }
        AppMethodBeat.o(293480);
        return false;
      }
      
      public final void fQT()
      {
        AppMethodBeat.i(293495);
        if (b.a(b.this) != null) {
          b.a(b.this).b(b.this);
        }
        AppMethodBeat.o(293495);
      }
      
      public final void fQU()
      {
        AppMethodBeat.i(293496);
        if (b.a(b.this) != null) {
          b.a(b.this).hWh();
        }
        AppMethodBeat.o(293496);
      }
    });
    if (!SubCoreVoip.hVp().UBR)
    {
      SubCoreVoip.hVp().UBR = true;
      long l = com.tencent.mm.kernel.h.baE().ban().amW(327950);
      if (System.currentTimeMillis() - l > 86400000L) {
        KE("have not permission to showing floating window\n");
      }
    }
    AppMethodBeat.o(293500);
  }
  
  private void idR()
  {
    AppMethodBeat.i(293509);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "setVideoTalkingView");
    if (this.UVh != null)
    {
      this.UVh.setStatus(this.mStatus);
      this.UVh.setConnectSec(this.Uxh);
      this.UVh.setVoipUIListener(this.UVg);
      Context localContext = MMApplicationContext.getContext();
      SubCoreVoip.hVp();
      u.Gv(true);
      ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getHeight();
      this.UVh.idK();
      this.UVh.setOnClickListener(this.UVo);
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "now add to view..");
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.UII), Integer.valueOf(this.Uxz) });
    }
    AppMethodBeat.o(293509);
  }
  
  private static String idS()
  {
    AppMethodBeat.i(293511);
    String str = MMApplicationContext.getContext().getString(b.g.voip_voice_is_talking_tip);
    AppMethodBeat.o(293511);
    return str;
  }
  
  public final void VR(int paramInt) {}
  
  public final void VV(int paramInt) {}
  
  public final void VW(int paramInt) {}
  
  public final void VX(int paramInt) {}
  
  public final void VY(int paramInt) {}
  
  public final void aDJ(String paramString) {}
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void bX(int paramInt, String paramString)
  {
    AppMethodBeat.i(293571);
    if (paramInt == 241) {
      MMApplicationContext.getContext();
    }
    Log.d("MicroMsg.Voip.NewVoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(paramInt)));
    if (paramInt == 235) {
      paramInt = b.g.voip_errorhint_notsupport;
    }
    while (paramInt == 0)
    {
      MMApplicationContext.getContext();
      AppMethodBeat.o(293571);
      return;
      if (paramInt == 233)
      {
        SubCoreVoip.hVp().hYu();
        paramInt = b.g.voip_errorhint_notcontact;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.au.b.isOverseasUser()) || (this.Uxc)) {
          paramInt = b.g.voip_errorhint_plugclose;
        } else {
          paramInt = b.g.voip_errorhint_voice_plugclose_for_oversea;
        }
      }
      else if (paramInt == 236)
      {
        paramInt = b.g.voip_inblacklist;
      }
      else if (paramInt == 211)
      {
        paramInt = b.g.voip_errorhint_userbusy;
      }
      else
      {
        paramInt = 0;
      }
    }
    MMApplicationContext.getContext();
    AppMethodBeat.o(293571);
  }
  
  public final void bj(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(293569);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:false");
    Log.printDebugStack("MicroMsg.Voip.NewVoipSmallWindow", "breathEffect false", new Object[0]);
    Object localObject1 = null;
    if (com.tencent.mm.plugin.voip.f.h.ibz()) {
      localObject1 = idN();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(MMApplicationContext.getContext(), VideoActivity.class);
    }
    ((Intent)localObject2).putExtra("Voip_CallRoomKey", SubCoreVoip.hVp().hVw());
    ((Intent)localObject2).putExtra("Voip_Call_From", 3);
    ((Intent)localObject2).putExtra("Voip_User", this.Uxa.field_username);
    ((Intent)localObject2).putExtra("Voip_Outcall", this.Uxb);
    ((Intent)localObject2).putExtra("Voip_VideoCall", this.Uxc);
    localObject1 = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, (Intent)localObject2, 134217728);
    paramString1 = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(paramString1).bt(System.currentTimeMillis()).l(paramString2).m(paramString3);
    paramString1.bor = ((PendingIntent)localObject1);
    paramString1 = paramString1.eb(guX());
    paramString1.q(2, true);
    paramString1 = m.e(paramString1);
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().a(40, paramString1, false);
    AppMethodBeat.o(293569);
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(293600);
    j localj = SubCoreVoip.hVq();
    if ((localj.UKx != null) && (!localj.Lvy))
    {
      com.tencent.threadpool.h.ahAA.bFQ("showIcon");
      com.tencent.threadpool.h.ahAA.g(new j.4(localj), "showIcon");
    }
    AppMethodBeat.o(293600);
  }
  
  public final void fwq()
  {
    AppMethodBeat.i(293575);
    if (this.UVh != null) {
      this.UVh.fwq();
    }
    AppMethodBeat.o(293575);
  }
  
  public final Context fwr()
  {
    return null;
  }
  
  public final void fws() {}
  
  public final void fwv() {}
  
  public final void fww()
  {
    AppMethodBeat.i(293645);
    SubCoreVoip.hVq().GH(false);
    AppMethodBeat.o(293645);
  }
  
  public final void fwx() {}
  
  public final void iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293560);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "newState: %s ", new Object[] { k.arg(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "state unchange");
      AppMethodBeat.o(293560);
      return;
    }
    this.mStatus = paramInt2;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(293560);
      return;
      idO();
      if (!this.UVl)
      {
        iam();
        AppMethodBeat.o(293560);
        return;
        arA(paramInt1);
        AppMethodBeat.o(293560);
        return;
        idO();
        if (!this.UVm) {
          arB(paramInt1);
        }
      }
    }
  }
  
  public final String idP()
  {
    AppMethodBeat.i(293564);
    int i = (int)(System.currentTimeMillis() / 1000L - this.Uxh);
    if (this.Uxh == -1L) {
      i = 0;
    }
    String str1;
    if (i >= 3600) {
      str1 = String.format(Locale.US, "%d:%02d:%02d", new Object[] { Integer.valueOf(i / 3600), Integer.valueOf(i % 3600 / 60), Integer.valueOf(i % 60) });
    }
    for (;;)
    {
      String str2 = str1;
      if (Util.isNullOrNil(str1)) {
        str2 = "00:00";
      }
      AppMethodBeat.o(293564);
      return str2;
      if (i >= 600) {
        str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      } else {
        str1 = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(293633);
    this.Uxh = paramLong;
    if (this.UVh != null)
    {
      this.UVh.setConnectSec(paramLong);
      AppMethodBeat.o(293633);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = idS();
      bj(str, aa.getDisplayName(this.Uxa.field_username), str);
    }
    AppMethodBeat.o(293633);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(293597);
    Log.w("MicroMsg.Voip.NewVoipSmallWindow", "setScreenEnable: ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      if (this.UVr == null) {
        this.UVr = new WakerLock(MMApplicationContext.getContext(), "wechat:screen small-window-lock", 32);
      }
      if (!this.UVr.isLocking())
      {
        this.UVr.lock();
        AppMethodBeat.o(293597);
      }
    }
    else if ((this.UVr != null) && (this.UVr.isLocking()))
    {
      this.UVr.unLock();
    }
    AppMethodBeat.o(293597);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(293554);
    if ((this.UVp != -1) && (this.UVp != paramInt))
    {
      j localj = SubCoreVoip.hVq();
      if ((localj.UKx != null) && (!localj.Lvy))
      {
        com.tencent.threadpool.h.ahAA.bFQ("showIcon");
        com.tencent.threadpool.h.ahAA.g(new j.5(localj, paramInt), "showIcon");
      }
    }
    this.UVp = paramInt;
    AppMethodBeat.o(293554);
  }
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(293628);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit");
    if (this.UVn)
    {
      AppMethodBeat.o(293628);
      return;
    }
    this.UVn = true;
    Object localObject;
    long l;
    if (-1L != this.UVk)
    {
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (this.UVl) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.UVk) / 1000L;
      if (!this.UBV) {
        break label255;
      }
    }
    label255:
    for (int j = 1;; j = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).b(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.mUJ != null) && (this.mUJ.isHeld()))
      {
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "release waklock");
        localObject = this.mUJ;
        com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow", "uninit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        ((PowerManager.WakeLock)localObject).release();
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow", "uninit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      }
      Hb(false);
      if (this.UVi != null) {
        this.UVi.stopTimer();
      }
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit..cancel notification..");
      localObject = t.UBA;
      t.hYf();
      if ((this.UVr != null) && (this.UVr.isLocking())) {
        this.UVr.unLock();
      }
      AppMethodBeat.o(293628);
      return;
    }
  }
  
  public final void vJ(boolean paramBoolean)
  {
    AppMethodBeat.i(293641);
    SubCoreVoip.hVq().GH(true);
    AppMethodBeat.o(293641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b
 * JD-Core Version:    0.7.0.1
 */