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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private int mStatus;
  private boolean tPa;
  private com.tencent.mm.plugin.voip.ui.c zBf;
  private BaseSmallView zBg;
  private av zBh;
  private boolean zBi;
  private long zBj;
  private boolean zBk;
  private boolean zBl;
  private boolean zBm;
  private View.OnClickListener zBn;
  private int zBo;
  boolean zBp;
  private af zgX;
  private boolean zgY;
  public boolean zgZ;
  private int zhA;
  private int zhL;
  private int zhM;
  private int zhd;
  private long zhe;
  private boolean zmh;
  private PowerManager.WakeLock zqF;
  private int zqz;
  
  public b(com.tencent.mm.plugin.voip.ui.c paramc, int paramInt, af paramaf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(192229);
    this.zBi = false;
    this.mStatus = -1;
    this.zhe = -1L;
    this.zhd = 1;
    this.zBj = -1L;
    this.zBk = false;
    this.zBl = false;
    this.zmh = false;
    this.zhA = 0;
    this.zhL = 0;
    this.zhM = 0;
    this.tPa = false;
    this.zBm = false;
    this.zBn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192224);
        b.a(b.this).dSq();
        if (b.b(b.this) != null) {
          b.b(b.this).setOnClickListener(null);
        }
        paramAnonymousView = new Intent(aj.getContext(), VideoActivity.class);
        paramAnonymousView.setFlags(268435456);
        paramAnonymousView = PendingIntent.getActivity(aj.getContext(), 0, paramAnonymousView, 0);
        try
        {
          paramAnonymousView.send();
          com.tencent.mm.sdk.platformtools.aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192223);
              b.c(b.this);
              AppMethodBeat.o(192223);
            }
          }, 200L);
          AppMethodBeat.o(192224);
          return;
        }
        catch (PendingIntent.CanceledException paramAnonymousView)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", paramAnonymousView, "send pending intent error: %s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    };
    this.zBo = -1;
    this.zBp = false;
    ad.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(paramInt), paramaf.field_username, Boolean.valueOf(paramBoolean1) });
    this.zgX = paramaf;
    this.zBf = paramc;
    this.zgZ = paramBoolean1;
    this.zgY = paramBoolean2;
    this.zmh = paramBoolean3;
    hS(0, paramInt);
    this.zqF = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
    this.zqF.acquire();
    paramc = t.zlN;
    t.dUo();
    AppMethodBeat.o(192229);
  }
  
  private static String KN()
  {
    AppMethodBeat.i(192250);
    String str2 = ay.gNa.ao("login_weixin_username", "");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = ay.gNa.ao("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(192250);
    return str1;
  }
  
  private void QX(int paramInt)
  {
    AppMethodBeat.i(192233);
    switch (paramInt)
    {
    }
    for (;;)
    {
      sb(true);
      AppMethodBeat.o(192233);
      return;
      aj.getContext();
      continue;
      aj.getContext();
      continue;
      aj.getContext();
    }
  }
  
  private void QY(int paramInt)
  {
    AppMethodBeat.i(192235);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
    this.zBl = true;
    if (-1L == this.zBj) {
      this.zBj = System.currentTimeMillis();
    }
    if (2 == this.zhd) {
      aj.getContext();
    }
    if (this.zBf != null) {
      this.zBf.a(this, 2);
    }
    String str = dYa();
    aD(str, v.sh(this.zgX.field_username), str);
    dXY();
    if (4101 == paramInt) {
      aj.getContext();
    }
    AppMethodBeat.o(192235);
  }
  
  public static int cYf()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  private void dVU()
  {
    AppMethodBeat.i(192234);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
    this.zBk = true;
    if (-1L == this.zBj) {
      this.zBj = System.currentTimeMillis();
    }
    if (this.zBf != null)
    {
      this.zBf.a(this, 2);
      this.zBf.dSj();
    }
    String str = aj.getContext().getString(2131764932);
    aD(str, v.sh(this.zgX.field_username), str);
    dXY();
    this.zBg = com.tencent.mm.plugin.voip.c.dRR().zrN;
    dXZ();
    AppMethodBeat.o(192234);
  }
  
  private void dXW()
  {
    AppMethodBeat.i(192231);
    if ((this.mStatus == 261) || (this.mStatus == 7) || (this.mStatus == 260) || (this.mStatus == 6))
    {
      this.zBp = true;
      if (this.zBh != null) {
        this.zBh.stopTimer();
      }
      this.zBh = new av("timerCounter", new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(192226);
          com.tencent.e.h.Iye.aN(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192225);
              com.tencent.mm.plugin.voip.c.dRR().atk(b.this.dXX());
              AppMethodBeat.o(192225);
            }
          });
          AppMethodBeat.o(192226);
          return true;
        }
      }, true);
      this.zBh.av(1000L, 1000L);
    }
    AppMethodBeat.o(192231);
  }
  
  private void dXY()
  {
    AppMethodBeat.i(192237);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
    Intent localIntent = new Intent();
    localIntent.setClass(aj.getContext(), VideoActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.zgX.field_username);
    localIntent.putExtra("Voip_Outcall", this.zgY);
    localIntent.putExtra("Voip_VideoCall", this.zgZ);
    localIntent.putExtra("Voip_Is_Talking", this.zBp);
    com.tencent.mm.plugin.voip.c.dRR().a(localIntent, this.zgZ, false, new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(192228);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          paramAnonymousBaseSmallView.atk(b.this.dXX());
        }
        for (;;)
        {
          if ((b.d(b.this)) && (b.g(b.this)))
          {
            b.a(b.this, false);
            b.a(b.this, paramAnonymousBaseSmallView);
            b.h(b.this);
          }
          AppMethodBeat.o(192228);
          return;
          paramAnonymousBaseSmallView.atl(aj.getContext().getString(2131764885));
        }
      }
      
      public final boolean cGN()
      {
        AppMethodBeat.i(192227);
        if (b.d(b.this))
        {
          String str = aj.getContext().getString(2131764932);
          b.this.aD(str, v.sh(b.e(b.this).field_username), str);
          if ((com.tencent.mm.plugin.voip.b.i.QN(b.f(b.this))) || (com.tencent.mm.plugin.voip.b.i.QL(b.f(b.this))))
          {
            b.a(b.this, true);
            AppMethodBeat.o(192227);
            return true;
          }
          ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          b.c(b.this);
          AppMethodBeat.o(192227);
          return false;
        }
        if ((com.tencent.mm.plugin.voip.b.i.QN(b.f(b.this))) || (com.tencent.mm.plugin.voip.b.i.QL(b.f(b.this))))
        {
          AppMethodBeat.o(192227);
          return true;
        }
        AppMethodBeat.o(192227);
        return false;
      }
    });
    if (!com.tencent.mm.plugin.voip.c.dRQ().zmd)
    {
      com.tencent.mm.plugin.voip.c.dRQ().zmd = true;
      long l = g.afB().afk().Wx(327950);
      if (System.currentTimeMillis() - l > 86400000L) {
        uR("have not permission to showing floating window\n");
      }
    }
    AppMethodBeat.o(192237);
  }
  
  private void dXZ()
  {
    AppMethodBeat.i(192238);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "setVideoTalkingView");
    if (this.zBg != null)
    {
      this.zBg.setStatus(this.mStatus);
      this.zBg.setConnectSec(this.zhe);
      this.zBg.setVoipUIListener(this.zBf);
      Context localContext = aj.getContext();
      com.tencent.mm.plugin.voip.c.dRQ();
      u.rF(true);
      ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getHeight();
      this.zBg.dXU();
      this.zBg.setOnClickListener(this.zBn);
      ad.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
      ad.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.zqz), Integer.valueOf(this.zhA) });
    }
    AppMethodBeat.o(192238);
  }
  
  private static String dYa()
  {
    AppMethodBeat.i(192239);
    String str = aj.getContext().getString(2131764940);
    AppMethodBeat.o(192239);
    return str;
  }
  
  private void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(192241);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView isFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.zBh != null) {
      this.zBh.stopTimer();
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.dRR().dWd();
    }
    for (;;)
    {
      if ((this.zBg != null) && (!paramBoolean))
      {
        this.zBg.uninit();
        if (this.zBg.getParent() != null) {
          ((ViewGroup)this.zBg.getParent()).removeAllViews();
        }
        this.zBg = null;
      }
      AppMethodBeat.o(192241);
      return;
      com.tencent.mm.plugin.voip.c.dRR().pE(false);
    }
  }
  
  private static void uR(String paramString)
  {
    AppMethodBeat.i(192249);
    g.afB().afk().setLong(327950, System.currentTimeMillis());
    ad.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.CpK).append("\n");
    localStringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.h.REV).append("\n");
    localStringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.h.TIME).append(":").append(com.tencent.mm.sdk.platformtools.h.HOSTNAME).append(":").append(com.tencent.mm.sdk.platformtools.i.cJR).append("\n");
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    localStringBuilder.append("#accinfo.uploadTime=" + localSimpleDateFormat.format((Date)localObject)).append("\n");
    localStringBuilder.append("#accinfo.content:\n");
    localObject = new Intent();
    ((Intent)localObject).setClassName(aj.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    ((Intent)localObject).setAction("uncatch_exception");
    ((Intent)localObject).putExtra("exceptionWriteSdcard", false);
    ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
    ((Intent)localObject).putExtra("userName", KN());
    ((Intent)localObject).putExtra("tag", "float_window_permission");
    ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + paramString).getBytes(), 2));
    aj.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(192249);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a Qu(int paramInt)
  {
    return null;
  }
  
  public final void Qv(int paramInt) {}
  
  public final void Qw(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void aD(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(192240);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:false");
    ad.l("MicroMsg.Voip.VoipSmallWindow", "breathEffect false", new Object[0]);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(aj.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_User", this.zgX.field_username);
    ((Intent)localObject).putExtra("Voip_Outcall", this.zgY);
    ((Intent)localObject).putExtra("Voip_VideoCall", this.zgZ);
    localObject = PendingIntent.getActivity(aj.getContext(), 40, (Intent)localObject, 134217728);
    paramString1 = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(paramString1).g(System.currentTimeMillis()).f(paramString2).g(paramString3);
    paramString1.Ew = ((PendingIntent)localObject);
    paramString1 = paramString1.as(cYf());
    paramString1.f(2, true);
    paramString1 = k.c(paramString1);
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramString1, false);
    AppMethodBeat.o(192240);
  }
  
  public final void atj(String paramString) {}
  
  public final void cIC()
  {
    AppMethodBeat.i(192248);
    if (this.zBg != null) {
      this.zBg.rL(false);
    }
    AppMethodBeat.o(192248);
  }
  
  public final void cSz()
  {
    AppMethodBeat.i(192244);
    if (this.zBg != null) {
      this.zBg.cSz();
    }
    AppMethodBeat.o(192244);
  }
  
  public final void cd(int paramInt, String paramString)
  {
    AppMethodBeat.i(192242);
    if (paramInt == 241) {
      aj.getContext();
    }
    ad.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(paramInt)));
    if (paramInt == 235) {
      paramInt = 2131764853;
    }
    while (paramInt == 0)
    {
      aj.getContext();
      AppMethodBeat.o(192242);
      return;
      if (paramInt == 233)
      {
        com.tencent.mm.plugin.voip.c.dRQ().dUD();
        paramInt = 2131764852;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.ax.b.azo()) || (this.zgZ)) {
          paramInt = 2131764854;
        } else {
          paramInt = 2131764856;
        }
      }
      else if (paramInt == 236)
      {
        paramInt = 2131764870;
      }
      else if (paramInt == 211)
      {
        paramInt = 2131764855;
      }
      else
      {
        paramInt = 0;
      }
    }
    aj.getContext();
    AppMethodBeat.o(192242);
  }
  
  public final void dVK() {}
  
  public final Context dVM()
  {
    return null;
  }
  
  public final void dVN()
  {
    AppMethodBeat.i(192243);
    if (this.zBg != null) {
      this.zBg.dVN();
    }
    AppMethodBeat.o(192243);
  }
  
  public final void dVO() {}
  
  public final String dXX()
  {
    AppMethodBeat.i(192236);
    int i = (int)(System.currentTimeMillis() / 1000L - this.zhe);
    if (this.zhe == -1L) {
      i = 0;
    }
    String str1;
    if (i >= 3600) {
      str1 = String.format(Locale.US, "%d:%02d:%02d", new Object[] { Integer.valueOf(i / 3600), Integer.valueOf(i % 3600 / 60), Integer.valueOf(i % 60) });
    }
    for (;;)
    {
      String str2 = str1;
      if (bt.isNullOrNil(str1)) {
        str2 = "00:00";
      }
      AppMethodBeat.o(192236);
      return str2;
      if (i >= 600) {
        str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      } else {
        str1 = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      }
    }
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public final void hP(int paramInt1, int paramInt2) {}
  
  public final void hS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192232);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      ad.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
      AppMethodBeat.o(192232);
      return;
    }
    this.mStatus = paramInt2;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192232);
      return;
      dXW();
      if (!this.zBk)
      {
        dVU();
        AppMethodBeat.o(192232);
        return;
        QX(paramInt1);
        AppMethodBeat.o(192232);
        return;
        dXW();
        if (!this.zBl) {
          QY(paramInt1);
        }
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void rH(boolean paramBoolean)
  {
    AppMethodBeat.i(192247);
    if (this.zBg != null) {
      this.zBg.rL(true);
    }
    AppMethodBeat.o(192247);
  }
  
  public final void releaseSurfaceTexture() {}
  
  public final void requestRender() {}
  
  public final void setCaptureView(CaptureView paramCaptureView) {}
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(192246);
    this.zhe = paramLong;
    if (this.zBg != null)
    {
      this.zBg.setConnectSec(paramLong);
      AppMethodBeat.o(192246);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = dYa();
      aD(str, v.sh(this.zgX.field_username), str);
    }
    AppMethodBeat.o(192246);
  }
  
  public final void setHWDecMode(int paramInt) {}
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(192230);
    if ((this.zBo != -1) && (this.zBo != paramInt))
    {
      if (this.zBg == null) {
        break label49;
      }
      this.zBg.setVoicePlayDevice(paramInt);
    }
    for (;;)
    {
      this.zBo = paramInt;
      AppMethodBeat.o(192230);
      return;
      label49:
      if (com.tencent.mm.plugin.voip.c.dRR().zrN != null) {
        com.tencent.mm.plugin.voip.c.dRR().zrN.setVoicePlayDevice(paramInt);
      }
    }
  }
  
  public final void setVoipBeauty(int paramInt) {}
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(192245);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
    Object localObject;
    long l;
    if (-1L != this.zBj)
    {
      localObject = com.tencent.mm.plugin.report.service.h.vKh;
      if (this.zBk) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.zBj) / 1000L;
      if (!this.zmh) {
        break label175;
      }
    }
    label175:
    for (int j = 1;; j = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.zqF != null) && (this.zqF.isHeld()))
      {
        ad.i("MicroMsg.Voip.VoipSmallWindow", "release waklock");
        this.zqF.release();
      }
      sb(false);
      this.zBm = true;
      if (this.zBh != null) {
        this.zBh.stopTimer();
      }
      ad.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
      localObject = t.zlN;
      t.dUp();
      AppMethodBeat.o(192245);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b
 * JD-Core Version:    0.7.0.1
 */