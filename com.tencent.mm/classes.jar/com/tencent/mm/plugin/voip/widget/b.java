package com.tencent.mm.plugin.voip.widget;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.app.e.d;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.k;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private boolean Fso;
  private int NKO;
  private int NKP;
  private int NKW;
  private int NKX;
  private as NKq;
  private boolean NKr;
  public boolean NKs;
  private int NKw;
  private long NKx;
  private boolean NPw;
  private int NUC;
  private com.tencent.mm.plugin.voip.ui.c OgN;
  private BaseSmallView OgO;
  private MTimerHandler OgP;
  private boolean OgQ;
  private long OgR;
  private boolean OgS;
  private boolean OgT;
  private boolean OgU;
  private View.OnClickListener OgV;
  private int OgW;
  boolean OgX;
  private PowerManager.WakeLock kqO;
  private int mStatus;
  
  public b(com.tencent.mm.plugin.voip.ui.c paramc, int paramInt, as paramas, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(242526);
    this.OgQ = false;
    this.mStatus = -1;
    this.NKx = -1L;
    this.NKw = 1;
    this.OgR = -1L;
    this.OgS = false;
    this.OgT = false;
    this.NPw = false;
    this.NKO = 0;
    this.NKP = 0;
    this.NKW = 0;
    this.NKX = 0;
    this.Fso = false;
    this.OgU = false;
    this.OgV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(238112);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        b.a(b.this).gxV();
        paramAnonymousView = new Intent(MMApplicationContext.getContext(), VideoActivity.class);
        paramAnonymousView.putExtra("Voip_Call_From", 3);
        localObject = com.tencent.mm.plugin.voip.c.d.NXJ;
        com.tencent.mm.plugin.voip.c.d.gCu();
        paramAnonymousView.setFlags(268435456);
        paramAnonymousView = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramAnonymousView, 0);
        try
        {
          paramAnonymousView.send();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(241681);
              b.b(b.this);
              AppMethodBeat.o(241681);
            }
          }, 200L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(238112);
          return;
        }
        catch (PendingIntent.CanceledException paramAnonymousView)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Voip.NewVoipSmallWindow", paramAnonymousView, "send pending intent error: %s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    };
    this.OgW = -1;
    this.OgX = false;
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { k.alz(paramInt), paramas.field_username, Boolean.valueOf(paramBoolean1) });
    this.NKq = paramas;
    this.OgN = paramc;
    this.NKs = paramBoolean1;
    this.NKr = paramBoolean2;
    this.NPw = paramBoolean3;
    kR(0, paramInt);
    this.kqO = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.NewVoipSmallWindow");
    paramc = this.kqO;
    com.tencent.mm.hellhoundlib.a.a.b(paramc, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow", "<init>", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUIListener;ILcom/tencent/mm/storage/Contact;ZZZ)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    paramc.acquire();
    com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow", "<init>", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUIListener;ILcom/tencent/mm/storage/Contact;ZZZ)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    paramc = t.NPb;
    t.gzX();
    AppMethodBeat.o(242526);
  }
  
  private void Bv(boolean paramBoolean)
  {
    AppMethodBeat.i(242562);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "removeSmallView isFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.OgP != null) {
      this.OgP.stopTimer();
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.gxt().eYE();
    }
    for (;;)
    {
      if ((this.OgO != null) && (!paramBoolean))
      {
        this.OgO.uninit();
        if (this.OgO.getParent() != null) {
          ((ViewGroup)this.OgO.getParent()).removeAllViews();
        }
        this.OgO = null;
      }
      AppMethodBeat.o(242562);
      return;
      com.tencent.mm.plugin.voip.c.gxt().ic(false);
    }
  }
  
  private static void SC(String paramString)
  {
    AppMethodBeat.i(242573);
    com.tencent.mm.kernel.h.aHG().aHp().setLong(327950, System.currentTimeMillis());
    Log.d("MicroMsg.Voip.NewVoipSmallWindow", "reportRawMessage, len: " + paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.RAD).append("\n");
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
    ((Intent)localObject).putExtra("userName", aaQ());
    ((Intent)localObject).putExtra("tag", "float_window_permission");
    ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + paramString).getBytes(), 2));
    MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(242573);
  }
  
  private static String aaQ()
  {
    AppMethodBeat.i(242574);
    String str2 = bg.ltv.aD("login_weixin_username", "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = bg.ltv.aD("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(242574);
    return str1;
  }
  
  private void alS(int paramInt)
  {
    AppMethodBeat.i(242541);
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bv(true);
      AppMethodBeat.o(242541);
      return;
      MMApplicationContext.getContext();
      continue;
      MMApplicationContext.getContext();
      continue;
      MMApplicationContext.getContext();
    }
  }
  
  private void alT(int paramInt)
  {
    AppMethodBeat.i(242547);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showVoiceTalking");
    this.OgT = true;
    if (-1L == this.OgR) {
      this.OgR = System.currentTimeMillis();
    }
    if (2 == this.NKw) {
      MMApplicationContext.getContext();
    }
    if (this.OgN != null) {
      this.OgN.a(this, 2);
    }
    String str = gEP();
    aR(str, aa.PJ(this.NKq.field_username), str);
    gEN();
    this.OgO = com.tencent.mm.plugin.voip.c.gxt().aV(false, this.OgS);
    if (this.OgS) {
      a.a.NJe.gxx();
    }
    if (4101 == paramInt) {
      MMApplicationContext.getContext();
    }
    AppMethodBeat.o(242547);
  }
  
  public static int fkG()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return b.c.notification_icon;
    }
    return b.c.notification_icon_gray;
  }
  
  private void gBP()
  {
    AppMethodBeat.i(242544);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showVideoTalking");
    this.OgS = true;
    if (-1L == this.OgR) {
      this.OgR = System.currentTimeMillis();
    }
    if (this.OgN != null)
    {
      this.OgN.a(this, 2);
      this.OgN.gxO();
    }
    String str = MMApplicationContext.getContext().getString(b.g.voip_video_is_talking_tip);
    aR(str, aa.PJ(this.NKq.field_username), str);
    gEN();
    this.OgO = com.tencent.mm.plugin.voip.c.gxt().aV(true, false);
    gEO();
    AppMethodBeat.o(242544);
  }
  
  private void gEL()
  {
    AppMethodBeat.i(242536);
    if ((this.mStatus == 261) || (this.mStatus == 7) || (this.mStatus == 260) || (this.mStatus == 6))
    {
      this.OgX = true;
      if (this.OgP != null) {
        this.OgP.stopTimer();
      }
      this.OgP = new MTimerHandler("timerCounter", new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(238189);
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(237246);
              com.tencent.mm.plugin.voip.c.gxt().aQN(b.this.gEM());
              AppMethodBeat.o(237246);
            }
          });
          AppMethodBeat.o(238189);
          return true;
        }
      }, true);
      this.OgP.startTimer(1000L);
    }
    AppMethodBeat.o(242536);
  }
  
  private void gEN()
  {
    AppMethodBeat.i(242554);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showMini");
    Intent localIntent = new Intent();
    localIntent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.NKq.field_username);
    localIntent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.gxs().gAo());
    localIntent.putExtra("Voip_Outcall", this.NKr);
    localIntent.putExtra("Voip_VideoCall", this.NKs);
    localIntent.putExtra("Voip_Is_Talking", this.OgX);
    com.tencent.mm.plugin.voip.c.gxt().a(localIntent, this.NKs, new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(234023);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          com.tencent.mm.plugin.voip.c.gxt().aQN(b.this.gEM());
        }
        for (;;)
        {
          if ((b.c(b.this)) && (b.f(b.this)))
          {
            b.a(b.this, false);
            b.a(b.this, paramAnonymousBaseSmallView);
            b.g(b.this);
          }
          AppMethodBeat.o(234023);
          return;
          com.tencent.mm.plugin.voip.c.gxt().aQM(MMApplicationContext.getContext().getString(b.g.voip_multitalk_waiting_wording));
        }
      }
      
      public final boolean eIT()
      {
        AppMethodBeat.i(234019);
        if (b.c(b.this))
        {
          String str = MMApplicationContext.getContext().getString(b.g.voip_video_is_talking_tip);
          b.this.aR(str, aa.PJ(b.d(b.this).field_username), str);
          if ((k.alE(b.e(b.this))) || (k.alC(b.e(b.this))))
          {
            b.a(b.this, true);
            AppMethodBeat.o(234019);
            return true;
          }
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          b.b(b.this);
          AppMethodBeat.o(234019);
          return false;
        }
        if ((k.alE(b.e(b.this))) || (k.alC(b.e(b.this))))
        {
          AppMethodBeat.o(234019);
          return true;
        }
        AppMethodBeat.o(234019);
        return false;
      }
    });
    if (!com.tencent.mm.plugin.voip.c.gxs().NPs)
    {
      com.tencent.mm.plugin.voip.c.gxs().NPs = true;
      long l = com.tencent.mm.kernel.h.aHG().aHp().ahV(327950);
      if (System.currentTimeMillis() - l > 86400000L) {
        SC("have not permission to showing floating window\n");
      }
    }
    AppMethodBeat.o(242554);
  }
  
  private void gEO()
  {
    AppMethodBeat.i(242556);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "setVideoTalkingView");
    if (this.OgO != null)
    {
      this.OgO.setStatus(this.mStatus);
      this.OgO.setConnectSec(this.NKx);
      this.OgO.setVoipUIListener(this.OgN);
      Context localContext = MMApplicationContext.getContext();
      com.tencent.mm.plugin.voip.c.gxs();
      u.AY(true);
      ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getHeight();
      this.OgO.gEJ();
      this.OgO.setOnClickListener(this.OgV);
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "now add to view..");
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.NUC), Integer.valueOf(this.NKO) });
    }
    AppMethodBeat.o(242556);
  }
  
  private static String gEP()
  {
    AppMethodBeat.i(242559);
    String str = MMApplicationContext.getContext().getString(b.g.voip_voice_is_talking_tip);
    AppMethodBeat.o(242559);
    return str;
  }
  
  public final void Ba(boolean paramBoolean)
  {
    AppMethodBeat.i(242571);
    com.tencent.mm.plugin.voip.c.gxt().Be(true);
    AppMethodBeat.o(242571);
  }
  
  public final void XB(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void aR(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(242561);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:false");
    Log.printDebugStack("MicroMsg.Voip.NewVoipSmallWindow", "breathEffect false", new Object[0]);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(MMApplicationContext.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.gxs().gAo());
    ((Intent)localObject).putExtra("Voip_Call_From", 3);
    ((Intent)localObject).putExtra("Voip_User", this.NKq.field_username);
    ((Intent)localObject).putExtra("Voip_Outcall", this.NKr);
    ((Intent)localObject).putExtra("Voip_VideoCall", this.NKs);
    localObject = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, (Intent)localObject, 134217728);
    paramString1 = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(paramString1).e(System.currentTimeMillis()).k(paramString2).l(paramString3);
    paramString1.Ip = ((PendingIntent)localObject);
    paramString1 = paramString1.bn(fkG());
    paramString1.e(2, true);
    paramString1 = m.e(paramString1);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramString1, false);
    AppMethodBeat.o(242561);
  }
  
  public final void akB(int paramInt) {}
  
  public final com.tencent.mm.plugin.voip.video.b.a alh(int paramInt)
  {
    return null;
  }
  
  public final void ali(int paramInt) {}
  
  public final void alj(int paramInt) {}
  
  public final void alk(int paramInt) {}
  
  public final void bgj(String paramString) {}
  
  public final void cG(int paramInt, String paramString)
  {
    AppMethodBeat.i(242563);
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
      AppMethodBeat.o(242563);
      return;
      if (paramInt == 233)
      {
        com.tencent.mm.plugin.voip.c.gxs().gAr();
        paramInt = b.g.voip_errorhint_notcontact;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.az.b.isOverseasUser()) || (this.NKs)) {
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
    AppMethodBeat.o(242563);
  }
  
  public final void eIO() {}
  
  public final void eKF()
  {
    AppMethodBeat.i(242572);
    com.tencent.mm.plugin.voip.c.gxt().Be(false);
    AppMethodBeat.o(242572);
  }
  
  public final void eXH()
  {
    AppMethodBeat.i(242567);
    com.tencent.mm.plugin.voip.c.gxt().eXH();
    AppMethodBeat.o(242567);
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public final void gBG() {}
  
  public final com.tencent.mm.plugin.voip.video.d.b gBH()
  {
    return null;
  }
  
  public final Context gBI()
  {
    return null;
  }
  
  public final void gBJ()
  {
    AppMethodBeat.i(242565);
    if (this.OgO != null) {
      this.OgO.gBJ();
    }
    AppMethodBeat.o(242565);
  }
  
  public final void gBK() {}
  
  public final String gEM()
  {
    AppMethodBeat.i(242549);
    int i = (int)(System.currentTimeMillis() / 1000L - this.NKx);
    if (this.NKx == -1L) {
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
      AppMethodBeat.o(242549);
      return str2;
      if (i >= 600) {
        str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      } else {
        str1 = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      }
    }
  }
  
  public final void kN(int paramInt1, int paramInt2) {}
  
  public final void kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242539);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "newState: %s ", new Object[] { k.alz(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "state unchange");
      AppMethodBeat.o(242539);
      return;
    }
    this.mStatus = paramInt2;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(242539);
      return;
      gEL();
      if (!this.OgS)
      {
        gBP();
        AppMethodBeat.o(242539);
        return;
        alS(paramInt1);
        AppMethodBeat.o(242539);
        return;
        gEL();
        if (!this.OgT) {
          alT(paramInt1);
        }
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void releaseSurfaceTexture() {}
  
  public final void requestRender() {}
  
  public final void setCaptureView(CaptureView paramCaptureView) {}
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(242570);
    this.NKx = paramLong;
    if (this.OgO != null)
    {
      this.OgO.setConnectSec(paramLong);
      AppMethodBeat.o(242570);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = gEP();
      aR(str, aa.PJ(this.NKq.field_username), str);
    }
    AppMethodBeat.o(242570);
  }
  
  public final void setHWDecMode(int paramInt) {}
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setSpatiotemporalDenosing(int paramInt) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(242529);
    if ((this.OgW != -1) && (this.OgW != paramInt)) {
      com.tencent.mm.plugin.voip.c.gxt().setVoicePlayDevice(paramInt);
    }
    this.OgW = paramInt;
    AppMethodBeat.o(242529);
  }
  
  public final void setVoipBeauty(int paramInt) {}
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(242569);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit");
    Object localObject;
    long l;
    if (-1L != this.OgR)
    {
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (this.OgS) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.OgR) / 1000L;
      if (!this.NPw) {
        break label217;
      }
    }
    label217:
    for (int j = 1;; j = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.kqO != null) && (this.kqO.isHeld()))
      {
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "release waklock");
        localObject = this.kqO;
        com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow", "uninit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        ((PowerManager.WakeLock)localObject).release();
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow", "uninit", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      }
      Bv(false);
      this.OgU = true;
      if (this.OgP != null) {
        this.OgP.stopTimer();
      }
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit..cancel notification..");
      localObject = t.NPb;
      t.gzY();
      AppMethodBeat.o(242569);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b
 * JD-Core Version:    0.7.0.1
 */