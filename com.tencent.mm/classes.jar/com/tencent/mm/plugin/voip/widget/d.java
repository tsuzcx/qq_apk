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
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.b;
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

public final class d
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private int mStatus;
  private boolean tPa;
  private com.tencent.mm.plugin.voip.ui.c zBf;
  BaseSmallView zBg;
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
  private CaptureView zlf;
  private boolean zmh;
  private PowerManager.WakeLock zqF;
  private int zqz;
  private av zrP;
  com.tencent.mm.plugin.voip.video.b.a zxg;
  
  public d(com.tencent.mm.plugin.voip.ui.c paramc, int paramInt, af paramaf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(115802);
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
        AppMethodBeat.i(115796);
        if (d.a(d.this) != null) {
          d.a(d.this).setOnClickListener(null);
        }
        paramAnonymousView = d.this;
        if (paramAnonymousView.zBg != null) {
          paramAnonymousView.zBg.dVY();
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
              AppMethodBeat.i(184103);
              d.b(d.this);
              AppMethodBeat.o(184103);
            }
          }, 200L);
          AppMethodBeat.o(115796);
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
    AppMethodBeat.o(115802);
  }
  
  private static String KN()
  {
    AppMethodBeat.i(115831);
    String str2 = ay.gNa.ao("login_weixin_username", "");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = ay.gNa.ao("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(115831);
    return str1;
  }
  
  private void QX(int paramInt)
  {
    AppMethodBeat.i(115804);
    switch (paramInt)
    {
    }
    for (;;)
    {
      releaseSurfaceTexture();
      sb(true);
      AppMethodBeat.o(115804);
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
    AppMethodBeat.i(115809);
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
    AppMethodBeat.o(115809);
  }
  
  private static int cYf()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  private void dVU()
  {
    AppMethodBeat.i(115806);
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
    AppMethodBeat.o(115806);
  }
  
  private void dXW()
  {
    AppMethodBeat.i(184109);
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
          AppMethodBeat.i(184105);
          com.tencent.e.h.Iye.aN(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184104);
              com.tencent.mm.plugin.voip.c.dRR().atk(d.this.dXX());
              AppMethodBeat.o(184104);
            }
          });
          AppMethodBeat.o(184105);
          return true;
        }
      }, true);
      this.zBh.av(1000L, 1000L);
    }
    AppMethodBeat.o(184109);
  }
  
  private void dXY()
  {
    AppMethodBeat.i(115811);
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
        AppMethodBeat.i(184107);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          paramAnonymousBaseSmallView.atk(d.this.dXX());
        }
        for (;;)
        {
          if ((d.c(d.this)) && (d.f(d.this)))
          {
            d.a(d.this, false);
            d.a(d.this, paramAnonymousBaseSmallView);
            d.g(d.this);
          }
          AppMethodBeat.o(184107);
          return;
          paramAnonymousBaseSmallView.atl(aj.getContext().getString(2131764885));
        }
      }
      
      public final boolean cGN()
      {
        AppMethodBeat.i(184106);
        if (d.c(d.this))
        {
          String str = aj.getContext().getString(2131764932);
          d.this.aD(str, v.sh(d.d(d.this).field_username), str);
          if ((com.tencent.mm.plugin.voip.b.i.QN(d.e(d.this))) || (com.tencent.mm.plugin.voip.b.i.QL(d.e(d.this))))
          {
            d.a(d.this, true);
            AppMethodBeat.o(184106);
            return true;
          }
          ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          d.b(d.this);
          AppMethodBeat.o(184106);
          return false;
        }
        if ((com.tencent.mm.plugin.voip.b.i.QN(d.e(d.this))) || (com.tencent.mm.plugin.voip.b.i.QL(d.e(d.this))))
        {
          AppMethodBeat.o(184106);
          return true;
        }
        AppMethodBeat.o(184106);
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
    AppMethodBeat.o(115811);
  }
  
  private void dXZ()
  {
    AppMethodBeat.i(184110);
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
      dYc();
      ad.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.zqz), Integer.valueOf(this.zhA) });
      setHWDecMode(this.zqz);
      setVoipBeauty(this.zhA);
      if ((this.zhL != 0) && (this.zhM != 0)) {
        hP(this.zhL, this.zhM);
      }
    }
    AppMethodBeat.o(184110);
  }
  
  private static String dYa()
  {
    AppMethodBeat.i(115812);
    String str = aj.getContext().getString(2131764940);
    AppMethodBeat.o(115812);
    return str;
  }
  
  private void dYc()
  {
    AppMethodBeat.i(184112);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
    if ((!com.tencent.mm.plugin.voip.b.i.QN(this.mStatus)) && (!com.tencent.mm.plugin.voip.b.i.QL(this.mStatus)) && (!com.tencent.mm.plugin.voip.b.i.QO(this.mStatus)))
    {
      ad.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
      AppMethodBeat.o(184112);
      return;
    }
    if (this.zrP != null) {
      this.zrP.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.zlf != null)
    {
      if ((this.zlf.getParent() != null) && ((this.zlf.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.zlf.getParent()).removeView(this.zlf);
      }
      this.zBg.setCaptureView(this.zlf);
    }
    this.zBg.setTag(Integer.valueOf(this.mStatus));
    AppMethodBeat.o(184112);
  }
  
  private void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(115816);
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
      AppMethodBeat.o(115816);
      return;
      com.tencent.mm.plugin.voip.c.dRR().pE(false);
    }
  }
  
  private static void uR(String paramString)
  {
    AppMethodBeat.i(115830);
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
    AppMethodBeat.o(115830);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a Qu(int paramInt)
  {
    AppMethodBeat.i(115832);
    if ((this.zBg != null) && (this.zBg.getBeautyData() != null)) {
      this.zBg.getBeautyData().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            d.this.zxg = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.zxg;
    AppMethodBeat.o(115832);
    return locala;
  }
  
  public final void Qv(int paramInt) {}
  
  public final void Qw(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd)
  {
    AppMethodBeat.i(115822);
    if (this.zBg != null) {
      this.zBg.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115822);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(192265);
    if (this.zBg != null) {
      this.zBg.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(192265);
  }
  
  public final void aD(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(184111);
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
    AppMethodBeat.o(184111);
  }
  
  public final void atj(String paramString) {}
  
  public final void cIC()
  {
    AppMethodBeat.i(184114);
    if (this.zBg != null) {
      this.zBg.rL(false);
    }
    AppMethodBeat.o(184114);
  }
  
  public final void cSz()
  {
    AppMethodBeat.i(184113);
    if (this.zBg != null) {
      this.zBg.cSz();
    }
    AppMethodBeat.o(184113);
  }
  
  public final void cd(int paramInt, String paramString)
  {
    AppMethodBeat.i(115817);
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
      AppMethodBeat.o(115817);
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
    AppMethodBeat.o(115817);
  }
  
  public final void dVK() {}
  
  public final Context dVM()
  {
    return null;
  }
  
  public final void dVN() {}
  
  public final void dVO() {}
  
  public final String dXX()
  {
    AppMethodBeat.i(115810);
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
      AppMethodBeat.o(115810);
      return str2;
      if (i >= 600) {
        str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      } else {
        str1 = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      }
    }
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115818);
    if ((260 != this.mStatus) && (6 != this.mStatus))
    {
      AppMethodBeat.o(115818);
      return;
    }
    if (this.zBg != null) {
      this.zBg.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115818);
  }
  
  public final void hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115820);
    this.zhL = paramInt1;
    this.zhM = paramInt2;
    if (this.zBg != null) {
      this.zBg.hP(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115820);
  }
  
  public final void hS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115803);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      ad.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
      AppMethodBeat.o(115803);
      return;
    }
    this.mStatus = paramInt2;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115803);
      return;
      dXW();
      if (!this.zBk)
      {
        dVU();
        AppMethodBeat.o(115803);
        return;
        QX(paramInt1);
        AppMethodBeat.o(115803);
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
    AppMethodBeat.i(115828);
    if (this.zBg != null) {
      this.zBg.rL(true);
    }
    AppMethodBeat.o(115828);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115824);
    if (this.zBg != null) {
      this.zBg.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115824);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115823);
    if (this.zBg != null) {
      this.zBg.requestRender();
    }
    AppMethodBeat.o(115823);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115829);
    this.zlf = paramCaptureView;
    if ((this.zBg != null) && (this.zlf != null))
    {
      if ((this.zlf.getParent() != null) && ((this.zlf.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.zlf.getParent()).removeView(this.zlf);
      }
      this.zBg.setCaptureView(paramCaptureView);
    }
    AppMethodBeat.o(115829);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115827);
    this.zhe = paramLong;
    if (this.zBg != null)
    {
      this.zBg.setConnectSec(paramLong);
      AppMethodBeat.o(115827);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = dYa();
      aD(str, v.sh(this.zgX.field_username), str);
    }
    AppMethodBeat.o(115827);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115821);
    if (this.zBg != null) {
      this.zBg.setHWDecMode(paramInt);
    }
    this.zqz = paramInt;
    AppMethodBeat.o(115821);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184108);
    if (this.zBf != null) {
      this.zBf.setVoicePlayDevice(paramInt);
    }
    if ((this.zBo != -1) && (this.zBo != paramInt))
    {
      if (this.zBg == null) {
        break label66;
      }
      this.zBg.setVoicePlayDevice(paramInt);
    }
    for (;;)
    {
      this.zBo = paramInt;
      AppMethodBeat.o(184108);
      return;
      label66:
      if (com.tencent.mm.plugin.voip.c.dRR().zrN != null) {
        com.tencent.mm.plugin.voip.c.dRR().zrN.setVoicePlayDevice(paramInt);
      }
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115819);
    if (this.zBg != null) {
      this.zBg.setVoipBeauty(paramInt);
    }
    this.zhA = paramInt;
    AppMethodBeat.o(115819);
  }
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(115826);
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
        break label180;
      }
    }
    label180:
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
      this.zlf = null;
      localObject = t.zlN;
      t.dUp();
      AppMethodBeat.o(115826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.d
 * JD-Core Version:    0.7.0.1
 */