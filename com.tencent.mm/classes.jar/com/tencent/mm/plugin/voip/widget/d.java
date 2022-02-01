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
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class d
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private am BYG;
  private boolean BYH;
  public boolean BYI;
  private int BYM;
  private long BYN;
  private int BZj;
  private int BZu;
  private int BZv;
  private boolean CdV;
  private int Cio;
  com.tencent.mm.plugin.voip.video.b.a Cpr;
  private com.tencent.mm.plugin.voip.ui.c CtB;
  BaseSmallView CtC;
  private av CtD;
  private boolean CtE;
  private long CtF;
  private boolean CtG;
  private boolean CtH;
  private View.OnClickListener CtJ;
  private int CtK;
  boolean CtL;
  private PowerManager.WakeLock gKs;
  private int mStatus;
  private CaptureView oXg;
  
  public d(com.tencent.mm.plugin.voip.ui.c paramc, int paramInt, am paramam, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(115802);
    this.CtE = false;
    this.mStatus = -1;
    this.BYN = -1L;
    this.BYM = 1;
    this.CtF = -1L;
    this.CtG = false;
    this.CtH = false;
    this.CdV = false;
    this.BZj = 0;
    this.BZu = 0;
    this.BZv = 0;
    this.CtJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115796);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/widget/VoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (d.a(d.this) != null) {
          d.a(d.this).setOnClickListener(null);
        }
        paramAnonymousView = d.this;
        if (paramAnonymousView.CtC != null) {
          paramAnonymousView.CtC.eyU();
        }
        paramAnonymousView = new Intent(aj.getContext(), VideoActivity.class);
        paramAnonymousView.setFlags(268435456);
        localObject = com.tencent.mm.plugin.voip.b.e.Cln;
        com.tencent.mm.plugin.voip.b.e.ezC();
        paramAnonymousView = PendingIntent.getActivity(aj.getContext(), 0, paramAnonymousView, 0);
        try
        {
          paramAnonymousView.send();
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184103);
              d.b(d.this);
              AppMethodBeat.o(184103);
            }
          }, 200L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/VoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.CtK = -1;
    this.CtL = false;
    ad.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { l.UK(paramInt), paramam.field_username, Boolean.valueOf(paramBoolean1) });
    this.BYG = paramam;
    this.CtB = paramc;
    this.BYI = paramBoolean1;
    this.BYH = paramBoolean2;
    this.CdV = paramBoolean3;
    iu(0, paramInt);
    this.gKs = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
    this.gKs.acquire();
    paramc = t.CdB;
    t.exl();
    AppMethodBeat.o(115802);
  }
  
  private static void BW(String paramString)
  {
    AppMethodBeat.i(115830);
    com.tencent.mm.kernel.g.ajC().ajl().setLong(327950, System.currentTimeMillis());
    ad.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.Fnj).append("\n");
    localStringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.i.REV).append("\n");
    localStringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.i.TIME).append(":").append(com.tencent.mm.sdk.platformtools.i.HOSTNAME).append(":").append(j.cSc).append("\n");
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    localStringBuilder.append("#accinfo.uploadTime=" + localSimpleDateFormat.format((Date)localObject)).append("\n");
    localStringBuilder.append("#accinfo.content:\n");
    localObject = new Intent();
    ((Intent)localObject).setClassName(aj.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    ((Intent)localObject).setAction("uncatch_exception");
    ((Intent)localObject).putExtra("exceptionWriteSdcard", false);
    ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
    ((Intent)localObject).putExtra("userName", Mc());
    ((Intent)localObject).putExtra("tag", "float_window_permission");
    ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + paramString).getBytes(), 2));
    aj.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(115830);
  }
  
  private static String Mc()
  {
    AppMethodBeat.i(115831);
    String str2 = az.hFS.ax("login_weixin_username", "");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = az.hFS.ax("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(115831);
    return str1;
  }
  
  private void UZ(int paramInt)
  {
    AppMethodBeat.i(115804);
    switch (paramInt)
    {
    }
    for (;;)
    {
      releaseSurfaceTexture();
      tM(true);
      AppMethodBeat.o(115804);
      return;
      aj.getContext();
      continue;
      aj.getContext();
      continue;
      aj.getContext();
    }
  }
  
  private void Va(int paramInt)
  {
    AppMethodBeat.i(115809);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
    this.CtH = true;
    if (-1L == this.CtF) {
      this.CtF = System.currentTimeMillis();
    }
    if (2 == this.BYM) {
      aj.getContext();
    }
    if (this.CtB != null) {
      this.CtB.a(this, 2);
    }
    Object localObject = eBv();
    aM((String)localObject, v.zf(this.BYG.field_username), (String)localObject);
    eBt();
    this.CtC = com.tencent.mm.plugin.voip.c.euN().ay(false, this.CtG);
    if (this.CtG)
    {
      localObject = a.a.BXw;
      com.tencent.mm.plugin.voip.a.a.euP();
    }
    if (4101 == paramInt) {
      aj.getContext();
    }
    AppMethodBeat.o(115809);
  }
  
  private static int dwe()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  private void eBr()
  {
    AppMethodBeat.i(184109);
    if ((this.mStatus == 261) || (this.mStatus == 7) || (this.mStatus == 260) || (this.mStatus == 6))
    {
      this.CtL = true;
      if (this.CtD != null) {
        this.CtD.stopTimer();
      }
      this.CtD = new av("timerCounter", new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(184105);
          h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184104);
              com.tencent.mm.plugin.voip.c.euN().aDJ(d.this.eBs());
              AppMethodBeat.o(184104);
            }
          });
          AppMethodBeat.o(184105);
          return true;
        }
      }, true);
      this.CtD.az(1000L, 1000L);
    }
    AppMethodBeat.o(184109);
  }
  
  private void eBt()
  {
    AppMethodBeat.i(115811);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
    Intent localIntent = new Intent();
    localIntent.setClass(aj.getContext(), VideoActivity.class);
    localIntent.putExtra("Voip_Call_From", 3);
    localIntent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.euM().exx());
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.BYG.field_username);
    localIntent.putExtra("Voip_Outcall", this.BYH);
    localIntent.putExtra("Voip_VideoCall", this.BYI);
    localIntent.putExtra("Voip_Is_Talking", this.CtL);
    com.tencent.mm.plugin.voip.c.euN().a(localIntent, this.BYI, false, new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(184107);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          com.tencent.mm.plugin.voip.c.euN().aDJ(d.this.eBs());
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
          com.tencent.mm.plugin.voip.c.euN().aDK(aj.getContext().getString(2131764885));
        }
      }
      
      public final boolean ddj()
      {
        AppMethodBeat.i(184106);
        if (d.c(d.this))
        {
          String str = aj.getContext().getString(2131764932);
          d.this.aM(str, v.zf(d.d(d.this).field_username), str);
          if ((l.UP(d.e(d.this))) || (l.UN(d.e(d.this))))
          {
            d.a(d.this, true);
            AppMethodBeat.o(184106);
            return true;
          }
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          d.b(d.this);
          AppMethodBeat.o(184106);
          return false;
        }
        if ((l.UP(d.e(d.this))) || (l.UN(d.e(d.this))))
        {
          AppMethodBeat.o(184106);
          return true;
        }
        AppMethodBeat.o(184106);
        return false;
      }
    });
    if (!com.tencent.mm.plugin.voip.c.euM().CdR)
    {
      com.tencent.mm.plugin.voip.c.euM().CdR = true;
      long l = com.tencent.mm.kernel.g.ajC().ajl().aaQ(327950);
      if (System.currentTimeMillis() - l > 86400000L) {
        BW("have not permission to showing floating window\n");
      }
    }
    AppMethodBeat.o(115811);
  }
  
  private void eBu()
  {
    AppMethodBeat.i(184110);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "setVideoTalkingView");
    if (this.CtC != null)
    {
      this.CtC.setStatus(this.mStatus);
      this.CtC.setConnectSec(this.BYN);
      this.CtC.setVoipUIListener(this.CtB);
      Context localContext = aj.getContext();
      com.tencent.mm.plugin.voip.c.euM();
      u.tp(true);
      ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getHeight();
      this.CtC.eBp();
      this.CtC.setOnClickListener(this.CtJ);
      ad.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
      eBx();
      ad.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.Cio), Integer.valueOf(this.BZj) });
      setHWDecMode(this.Cio);
      setVoipBeauty(this.BZj);
      if ((this.BZu != 0) && (this.BZv != 0)) {
        ir(this.BZu, this.BZv);
      }
    }
    AppMethodBeat.o(184110);
  }
  
  private static String eBv()
  {
    AppMethodBeat.i(115812);
    String str = aj.getContext().getString(2131764940);
    AppMethodBeat.o(115812);
    return str;
  }
  
  private void eBx()
  {
    AppMethodBeat.i(184112);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
    if ((!l.UP(this.mStatus)) && (!l.UN(this.mStatus)) && (!l.UQ(this.mStatus)))
    {
      ad.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
      AppMethodBeat.o(184112);
      return;
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.oXg != null)
    {
      if ((this.oXg.getParent() != null) && ((this.oXg.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.oXg.getParent()).removeView(this.oXg);
      }
      this.CtC.setCaptureView(this.oXg);
    }
    this.CtC.setTag(Integer.valueOf(this.mStatus));
    AppMethodBeat.o(184112);
  }
  
  private void eyQ()
  {
    AppMethodBeat.i(115806);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
    this.CtG = true;
    if (-1L == this.CtF) {
      this.CtF = System.currentTimeMillis();
    }
    if (this.CtB != null)
    {
      this.CtB.a(this, 2);
      this.CtB.evf();
    }
    String str = aj.getContext().getString(2131764932);
    aM(str, v.zf(this.BYG.field_username), str);
    eBt();
    this.CtC = com.tencent.mm.plugin.voip.c.euN().ay(true, false);
    eBu();
    AppMethodBeat.o(115806);
  }
  
  private void tM(boolean paramBoolean)
  {
    AppMethodBeat.i(115816);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView isFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.CtD != null) {
      this.CtD.stopTimer();
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.euN().eyZ();
    }
    for (;;)
    {
      if ((this.CtC != null) && (!paramBoolean))
      {
        this.CtC.uninit();
        if (this.CtC.getParent() != null) {
          ((ViewGroup)this.CtC.getParent()).removeAllViews();
        }
        this.CtC = null;
      }
      AppMethodBeat.o(115816);
      return;
      com.tencent.mm.plugin.voip.c.euN().rf(false);
    }
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a Uu(int paramInt)
  {
    AppMethodBeat.i(115832);
    if ((this.CtC != null) && (this.CtC.getBeautyData() != null)) {
      this.CtC.getBeautyData().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            d.this.Cpr = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.Cpr;
    AppMethodBeat.o(115832);
    return locala;
  }
  
  public final void Uv(int paramInt) {}
  
  public final void Uw(int paramInt) {}
  
  public final void Ux(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115822);
    if (this.CtC != null) {
      this.CtC.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115822);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(216651);
    if (this.CtC != null) {
      this.CtC.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(216651);
  }
  
  public final void aDI(String paramString) {}
  
  public final void aM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(184111);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:false");
    ad.l("MicroMsg.Voip.VoipSmallWindow", "breathEffect false", new Object[0]);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(aj.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_Call_From", 3);
    ((Intent)localObject).putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.euM().exx());
    ((Intent)localObject).putExtra("Voip_User", this.BYG.field_username);
    ((Intent)localObject).putExtra("Voip_Outcall", this.BYH);
    ((Intent)localObject).putExtra("Voip_VideoCall", this.BYI);
    localObject = PendingIntent.getActivity(aj.getContext(), 40, (Intent)localObject, 134217728);
    paramString1 = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(paramString1).i(System.currentTimeMillis()).f(paramString2).g(paramString3);
    paramString1.Hl = ((PendingIntent)localObject);
    paramString1 = paramString1.as(dwe());
    paramString1.f(2, true);
    paramString1 = n.e(paramString1);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramString1, false);
    AppMethodBeat.o(184111);
  }
  
  public final void co(int paramInt, String paramString)
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
        com.tencent.mm.plugin.voip.c.euM().exA();
        paramInt = 2131764852;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.ax.b.aJo()) || (this.BYI)) {
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
  
  public final void deY()
  {
    AppMethodBeat.i(184114);
    com.tencent.mm.plugin.voip.c.euN().tv(false);
    AppMethodBeat.o(184114);
  }
  
  public final void dqh()
  {
    AppMethodBeat.i(184113);
    com.tencent.mm.plugin.voip.c.euN().dqh();
    AppMethodBeat.o(184113);
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115818);
    if ((260 != this.mStatus) && (6 != this.mStatus))
    {
      AppMethodBeat.o(115818);
      return;
    }
    if (this.CtC != null) {
      this.CtC.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115818);
  }
  
  public final String eBs()
  {
    AppMethodBeat.i(115810);
    int i = (int)(System.currentTimeMillis() / 1000L - this.BYN);
    if (this.BYN == -1L) {
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
  
  public final void evo() {}
  
  public final void eyH() {}
  
  public final Context eyI()
  {
    return null;
  }
  
  public final void eyJ() {}
  
  public final void eyK() {}
  
  public final void ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115820);
    this.BZu = paramInt1;
    this.BZv = paramInt2;
    if (this.CtC != null) {
      this.CtC.ir(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115820);
  }
  
  public final void iu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115803);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[] { l.UK(paramInt2) });
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
      eBr();
      if (!this.CtG)
      {
        eyQ();
        AppMethodBeat.o(115803);
        return;
        UZ(paramInt1);
        AppMethodBeat.o(115803);
        return;
        eBr();
        if (!this.CtH) {
          Va(paramInt1);
        }
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115824);
    if (this.CtC != null) {
      this.CtC.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115824);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115823);
    if (this.CtC != null) {
      this.CtC.requestRender();
    }
    AppMethodBeat.o(115823);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115829);
    this.oXg = paramCaptureView;
    if ((this.CtC != null) && (this.oXg != null))
    {
      if ((this.oXg.getParent() != null) && ((this.oXg.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.oXg.getParent()).removeView(this.oXg);
      }
      this.CtC.setCaptureView(paramCaptureView);
    }
    AppMethodBeat.o(115829);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115827);
    this.BYN = paramLong;
    if (this.CtC != null)
    {
      this.CtC.setConnectSec(paramLong);
      AppMethodBeat.o(115827);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = eBv();
      aM(str, v.zf(this.BYG.field_username), str);
    }
    AppMethodBeat.o(115827);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115821);
    if (this.CtC != null) {
      this.CtC.setHWDecMode(paramInt);
    }
    this.Cio = paramInt;
    AppMethodBeat.o(115821);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184108);
    if (this.CtB != null) {
      this.CtB.setVoicePlayDevice(paramInt);
    }
    if ((this.CtK != -1) && (this.CtK != paramInt)) {
      com.tencent.mm.plugin.voip.c.euN().setVoicePlayDevice(paramInt);
    }
    this.CtK = paramInt;
    AppMethodBeat.o(184108);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115819);
    if (this.CtC != null) {
      this.CtC.setVoipBeauty(paramInt);
    }
    this.BZj = paramInt;
    AppMethodBeat.o(115819);
  }
  
  public final void tr(boolean paramBoolean)
  {
    AppMethodBeat.i(115828);
    com.tencent.mm.plugin.voip.c.euN().tv(true);
    AppMethodBeat.o(115828);
  }
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(115826);
    ad.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
    Object localObject;
    long l;
    if (-1L != this.CtF)
    {
      localObject = com.tencent.mm.plugin.report.service.g.yhR;
      if (this.CtG) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.CtF) / 1000L;
      if (!this.CdV) {
        break label175;
      }
    }
    label175:
    for (int j = 1;; j = 2)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.gKs != null) && (this.gKs.isHeld()))
      {
        ad.i("MicroMsg.Voip.VoipSmallWindow", "release waklock");
        this.gKs.release();
      }
      tM(false);
      if (this.CtD != null) {
        this.CtD.stopTimer();
      }
      ad.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
      this.oXg = null;
      localObject = t.CdB;
      t.exm();
      AppMethodBeat.o(115826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.d
 * JD-Core Version:    0.7.0.1
 */