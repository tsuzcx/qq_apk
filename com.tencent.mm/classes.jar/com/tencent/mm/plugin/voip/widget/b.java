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
import android.support.v4.app.s.c;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.b.m;
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
  private int GUC;
  private int GUD;
  private int GUK;
  private int GUL;
  private as GUe;
  private boolean GUf;
  public boolean GUg;
  private int GUk;
  private long GUl;
  private boolean GZi;
  private int HdK;
  private com.tencent.mm.plugin.voip.ui.c HpU;
  private BaseSmallView HpV;
  private MTimerHandler HpW;
  private boolean HpX;
  private long HpY;
  private boolean HpZ;
  private boolean Hqa;
  private boolean Hqb;
  private View.OnClickListener Hqc;
  private int Hqd;
  boolean Hqe;
  private PowerManager.WakeLock hCN;
  private int mStatus;
  private boolean zMU;
  
  public b(com.tencent.mm.plugin.voip.ui.c paramc, int paramInt, as paramas, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(235939);
    this.HpX = false;
    this.mStatus = -1;
    this.GUl = -1L;
    this.GUk = 1;
    this.HpY = -1L;
    this.HpZ = false;
    this.Hqa = false;
    this.GZi = false;
    this.GUC = 0;
    this.GUD = 0;
    this.GUK = 0;
    this.GUL = 0;
    this.zMU = false;
    this.Hqb = false;
    this.Hqc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235934);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        b.a(b.this).fFJ();
        if (b.b(b.this) != null) {
          b.b(b.this).setOnClickListener(null);
        }
        paramAnonymousView = new Intent(MMApplicationContext.getContext(), VideoActivity.class);
        paramAnonymousView.putExtra("Voip_Call_From", 3);
        localObject = com.tencent.mm.plugin.voip.b.d.HgU;
        com.tencent.mm.plugin.voip.b.d.fJW();
        paramAnonymousView.setFlags(268435456);
        paramAnonymousView = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramAnonymousView, 0);
        try
        {
          paramAnonymousView.send();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235933);
              b.c(b.this);
              AppMethodBeat.o(235933);
            }
          }, 200L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235934);
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
    this.Hqd = -1;
    this.Hqe = false;
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { k.adM(paramInt), paramas.field_username, Boolean.valueOf(paramBoolean1) });
    this.GUe = paramas;
    this.HpU = paramc;
    this.GUg = paramBoolean1;
    this.GUf = paramBoolean2;
    this.GZi = paramBoolean3;
    jD(0, paramInt);
    this.hCN = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.NewVoipSmallWindow");
    this.hCN.acquire();
    paramc = t.GYO;
    t.fHJ();
    AppMethodBeat.o(235939);
  }
  
  private static void Lj(String paramString)
  {
    AppMethodBeat.i(235959);
    g.aAh().azQ().setLong(327950, System.currentTimeMillis());
    Log.d("MicroMsg.Voip.NewVoipSmallWindow", "reportRawMessage, len: " + paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.KyO).append("\n");
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
    ((Intent)localObject).putExtra("userName", Wv());
    ((Intent)localObject).putExtra("tag", "float_window_permission");
    ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + paramString).getBytes(), 2));
    MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(235959);
  }
  
  private static String Wv()
  {
    AppMethodBeat.i(235960);
    String str2 = bf.iDu.aA("login_weixin_username", "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = bf.iDu.aA("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(235960);
    return str1;
  }
  
  private void aef(int paramInt)
  {
    AppMethodBeat.i(235943);
    switch (paramInt)
    {
    }
    for (;;)
    {
      xB(true);
      AppMethodBeat.o(235943);
      return;
      MMApplicationContext.getContext();
      continue;
      MMApplicationContext.getContext();
      continue;
      MMApplicationContext.getContext();
    }
  }
  
  private void aeg(int paramInt)
  {
    AppMethodBeat.i(235945);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showVoiceTalking");
    this.Hqa = true;
    if (-1L == this.HpY) {
      this.HpY = System.currentTimeMillis();
    }
    if (2 == this.GUk) {
      MMApplicationContext.getContext();
    }
    if (this.HpU != null) {
      this.HpU.a(this, 2);
    }
    String str = fMl();
    aX(str, aa.getDisplayName(this.GUe.field_username), str);
    fMj();
    this.HpV = com.tencent.mm.plugin.voip.c.fFh().aJ(false, this.HpZ);
    if (this.HpZ) {
      a.a.GST.fFl();
    }
    if (4101 == paramInt) {
      MMApplicationContext.getContext();
    }
    AppMethodBeat.o(235945);
  }
  
  public static int ezb()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131234303;
    }
    return 2131234305;
  }
  
  private void fJt()
  {
    AppMethodBeat.i(235944);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showVideoTalking");
    this.HpZ = true;
    if (-1L == this.HpY) {
      this.HpY = System.currentTimeMillis();
    }
    if (this.HpU != null)
    {
      this.HpU.a(this, 2);
      this.HpU.fFC();
    }
    String str = MMApplicationContext.getContext().getString(2131767373);
    aX(str, aa.getDisplayName(this.GUe.field_username), str);
    fMj();
    this.HpV = com.tencent.mm.plugin.voip.c.fFh().aJ(true, false);
    fMk();
    AppMethodBeat.o(235944);
  }
  
  private void fMh()
  {
    AppMethodBeat.i(235941);
    if ((this.mStatus == 261) || (this.mStatus == 7) || (this.mStatus == 260) || (this.mStatus == 6))
    {
      this.Hqe = true;
      if (this.HpW != null) {
        this.HpW.stopTimer();
      }
      this.HpW = new MTimerHandler("timerCounter", new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(235936);
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235935);
              com.tencent.mm.plugin.voip.c.fFh().aGy(b.this.fMi());
              AppMethodBeat.o(235935);
            }
          });
          AppMethodBeat.o(235936);
          return true;
        }
      }, true);
      this.HpW.startTimer(1000L);
    }
    AppMethodBeat.o(235941);
  }
  
  private void fMj()
  {
    AppMethodBeat.i(235947);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showMini");
    Intent localIntent = new Intent();
    localIntent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.GUe.field_username);
    localIntent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.fFg().fHV());
    localIntent.putExtra("Voip_Outcall", this.GUf);
    localIntent.putExtra("Voip_VideoCall", this.GUg);
    localIntent.putExtra("Voip_Is_Talking", this.Hqe);
    com.tencent.mm.plugin.voip.c.fFh().a(localIntent, this.GUg, new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(235938);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          com.tencent.mm.plugin.voip.c.fFh().aGy(b.this.fMi());
        }
        for (;;)
        {
          if ((b.d(b.this)) && (b.g(b.this)))
          {
            b.a(b.this, false);
            b.a(b.this, paramAnonymousBaseSmallView);
            b.h(b.this);
          }
          AppMethodBeat.o(235938);
          return;
          com.tencent.mm.plugin.voip.c.fFh().aGx(MMApplicationContext.getContext().getString(2131767324));
        }
      }
      
      public final boolean dZV()
      {
        AppMethodBeat.i(235937);
        if (b.d(b.this))
        {
          String str = MMApplicationContext.getContext().getString(2131767373);
          b.this.aX(str, aa.getDisplayName(b.e(b.this).field_username), str);
          if ((k.adR(b.f(b.this))) || (k.adP(b.f(b.this))))
          {
            b.a(b.this, true);
            AppMethodBeat.o(235937);
            return true;
          }
          ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          b.c(b.this);
          AppMethodBeat.o(235937);
          return false;
        }
        if ((k.adR(b.f(b.this))) || (k.adP(b.f(b.this))))
        {
          AppMethodBeat.o(235937);
          return true;
        }
        AppMethodBeat.o(235937);
        return false;
      }
    });
    if (!com.tencent.mm.plugin.voip.c.fFg().GZe)
    {
      com.tencent.mm.plugin.voip.c.fFg().GZe = true;
      long l = g.aAh().azQ().akg(327950);
      if (System.currentTimeMillis() - l > 86400000L) {
        Lj("have not permission to showing floating window\n");
      }
    }
    AppMethodBeat.o(235947);
  }
  
  private void fMk()
  {
    AppMethodBeat.i(235948);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "setVideoTalkingView");
    if (this.HpV != null)
    {
      this.HpV.setStatus(this.mStatus);
      this.HpV.setConnectSec(this.GUl);
      this.HpV.setVoipUIListener(this.HpU);
      Context localContext = MMApplicationContext.getContext();
      com.tencent.mm.plugin.voip.c.fFg();
      u.xg(true);
      ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getHeight();
      this.HpV.fMf();
      this.HpV.setOnClickListener(this.Hqc);
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "now add to view..");
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.HdK), Integer.valueOf(this.GUC) });
    }
    AppMethodBeat.o(235948);
  }
  
  private static String fMl()
  {
    AppMethodBeat.i(235949);
    String str = MMApplicationContext.getContext().getString(2131767381);
    AppMethodBeat.o(235949);
    return str;
  }
  
  private void xB(boolean paramBoolean)
  {
    AppMethodBeat.i(235951);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "removeSmallView isFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.HpW != null) {
      this.HpW.stopTimer();
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.fFh().eoN();
    }
    for (;;)
    {
      if ((this.HpV != null) && (!paramBoolean))
      {
        this.HpV.uninit();
        if (this.HpV.getParent() != null) {
          ((ViewGroup)this.HpV.getParent()).removeAllViews();
        }
        this.HpV = null;
      }
      AppMethodBeat.o(235951);
      return;
      com.tencent.mm.plugin.voip.c.fFh().rX(false);
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void aUB(String paramString) {}
  
  public final void aX(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(235950);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:false");
    Log.printDebugStack("MicroMsg.Voip.NewVoipSmallWindow", "breathEffect false", new Object[0]);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(MMApplicationContext.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.fFg().fHV());
    ((Intent)localObject).putExtra("Voip_Call_From", 3);
    ((Intent)localObject).putExtra("Voip_User", this.GUe.field_username);
    ((Intent)localObject).putExtra("Voip_Outcall", this.GUf);
    ((Intent)localObject).putExtra("Voip_VideoCall", this.GUg);
    localObject = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, (Intent)localObject, 134217728);
    paramString1 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(paramString1).i(System.currentTimeMillis()).f(paramString2).g(paramString3);
    paramString1.Hv = ((PendingIntent)localObject);
    paramString1 = paramString1.as(ezb());
    paramString1.g(2, true);
    paramString1 = m.e(paramString1);
    ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramString1, false);
    AppMethodBeat.o(235950);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a adw(int paramInt)
  {
    return null;
  }
  
  public final void adx(int paramInt) {}
  
  public final void ady(int paramInt) {}
  
  public final void adz(int paramInt) {}
  
  public final void cF(int paramInt, String paramString)
  {
    AppMethodBeat.i(235952);
    if (paramInt == 241) {
      MMApplicationContext.getContext();
    }
    Log.d("MicroMsg.Voip.NewVoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(paramInt)));
    if (paramInt == 235) {
      paramInt = 2131767292;
    }
    while (paramInt == 0)
    {
      MMApplicationContext.getContext();
      AppMethodBeat.o(235952);
      return;
      if (paramInt == 233)
      {
        com.tencent.mm.plugin.voip.c.fFg().fHY();
        paramInt = 2131767291;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.aw.b.isOverseasUser()) || (this.GUg)) {
          paramInt = 2131767293;
        } else {
          paramInt = 2131767295;
        }
      }
      else if (paramInt == 236)
      {
        paramInt = 2131767309;
      }
      else if (paramInt == 211)
      {
        paramInt = 2131767294;
      }
      else
      {
        paramInt = 0;
      }
    }
    MMApplicationContext.getContext();
    AppMethodBeat.o(235952);
  }
  
  public final void ebH()
  {
    AppMethodBeat.i(235958);
    com.tencent.mm.plugin.voip.c.fFh().xm(false);
    AppMethodBeat.o(235958);
  }
  
  public final void enR()
  {
    AppMethodBeat.i(235954);
    com.tencent.mm.plugin.voip.c.fFh().enR();
    AppMethodBeat.o(235954);
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public final void fFL() {}
  
  public final void fJj() {}
  
  public final com.tencent.mm.plugin.voip.video.d.b fJk()
  {
    return null;
  }
  
  public final Context fJl()
  {
    return null;
  }
  
  public final void fJm()
  {
    AppMethodBeat.i(235953);
    if (this.HpV != null) {
      this.HpV.fJm();
    }
    AppMethodBeat.o(235953);
  }
  
  public final void fJn() {}
  
  public final String fMi()
  {
    AppMethodBeat.i(235946);
    int i = (int)(System.currentTimeMillis() / 1000L - this.GUl);
    if (this.GUl == -1L) {
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
      AppMethodBeat.o(235946);
      return str2;
      if (i >= 600) {
        str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      } else {
        str1 = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      }
    }
  }
  
  public final void jA(int paramInt1, int paramInt2) {}
  
  public final void jD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235942);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "newState: %s ", new Object[] { k.adM(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "state unchange");
      AppMethodBeat.o(235942);
      return;
    }
    this.mStatus = paramInt2;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(235942);
      return;
      fMh();
      if (!this.HpZ)
      {
        fJt();
        AppMethodBeat.o(235942);
        return;
        aef(paramInt1);
        AppMethodBeat.o(235942);
        return;
        fMh();
        if (!this.Hqa) {
          aeg(paramInt1);
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
    AppMethodBeat.i(235956);
    this.GUl = paramLong;
    if (this.HpV != null)
    {
      this.HpV.setConnectSec(paramLong);
      AppMethodBeat.o(235956);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = fMl();
      aX(str, aa.getDisplayName(this.GUe.field_username), str);
    }
    AppMethodBeat.o(235956);
  }
  
  public final void setHWDecMode(int paramInt) {}
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setSpatiotemporalDenosing(int paramInt) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(235940);
    if ((this.Hqd != -1) && (this.Hqd != paramInt)) {
      com.tencent.mm.plugin.voip.c.fFh().setVoicePlayDevice(paramInt);
    }
    this.Hqd = paramInt;
    AppMethodBeat.o(235940);
  }
  
  public final void setVoipBeauty(int paramInt) {}
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(235955);
    Log.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit");
    Object localObject;
    long l;
    if (-1L != this.HpY)
    {
      localObject = com.tencent.mm.plugin.report.service.h.CyF;
      if (this.HpZ) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.HpY) / 1000L;
      if (!this.GZi) {
        break label175;
      }
    }
    label175:
    for (int j = 1;; j = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.hCN != null) && (this.hCN.isHeld()))
      {
        Log.i("MicroMsg.Voip.NewVoipSmallWindow", "release waklock");
        this.hCN.release();
      }
      xB(false);
      this.Hqb = true;
      if (this.HpW != null) {
        this.HpW.stopTimer();
      }
      Log.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit..cancel notification..");
      localObject = t.GYO;
      t.fHK();
      AppMethodBeat.o(235955);
      return;
    }
  }
  
  public final void xi(boolean paramBoolean)
  {
    AppMethodBeat.i(235957);
    com.tencent.mm.plugin.voip.c.fFh().xm(true);
    AppMethodBeat.o(235957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b
 * JD-Core Version:    0.7.0.1
 */