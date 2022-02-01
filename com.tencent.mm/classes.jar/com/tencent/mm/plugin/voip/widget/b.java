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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.voip.a.a.a;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private com.tencent.mm.plugin.voip.ui.c CLf;
  private BaseSmallView CLg;
  private com.tencent.mm.sdk.platformtools.aw CLh;
  private boolean CLi;
  private long CLj;
  private boolean CLk;
  private boolean CLl;
  private boolean CLm;
  private View.OnClickListener CLn;
  private int CLo;
  boolean CLp;
  private int CqK;
  private int CqV;
  private int CqW;
  private an Cqh;
  private boolean Cqi;
  public boolean Cqj;
  private int Cqn;
  private long Cqo;
  private boolean Cvw;
  private int CzS;
  private PowerManager.WakeLock gNb;
  private int mStatus;
  private boolean wrk;
  
  public b(com.tencent.mm.plugin.voip.ui.c paramc, int paramInt, an paraman, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(210294);
    this.CLi = false;
    this.mStatus = -1;
    this.Cqo = -1L;
    this.Cqn = 1;
    this.CLj = -1L;
    this.CLk = false;
    this.CLl = false;
    this.Cvw = false;
    this.CqK = 0;
    this.CqV = 0;
    this.CqW = 0;
    this.wrk = false;
    this.CLm = false;
    this.CLn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210289);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        b.a(b.this).eyT();
        if (b.b(b.this) != null) {
          b.b(b.this).setOnClickListener(null);
        }
        paramAnonymousView = new Intent(ak.getContext(), VideoActivity.class);
        paramAnonymousView.putExtra("Voip_Call_From", 3);
        localObject = com.tencent.mm.plugin.voip.b.e.CCR;
        com.tencent.mm.plugin.voip.b.e.eDk();
        paramAnonymousView.setFlags(268435456);
        paramAnonymousView = PendingIntent.getActivity(ak.getContext(), 0, paramAnonymousView, 0);
        try
        {
          paramAnonymousView.send();
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(210288);
              b.c(b.this);
              AppMethodBeat.o(210288);
            }
          }, 200L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/widget/NewVoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210289);
          return;
        }
        catch (PendingIntent.CanceledException paramAnonymousView)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Voip.NewVoipSmallWindow", paramAnonymousView, "send pending intent error: %s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    };
    this.CLo = -1;
    this.CLp = false;
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { l.Vr(paramInt), paraman.field_username, Boolean.valueOf(paramBoolean1) });
    this.Cqh = paraman;
    this.CLf = paramc;
    this.Cqj = paramBoolean1;
    this.Cqi = paramBoolean2;
    this.Cvw = paramBoolean3;
    iy(0, paramInt);
    this.gNb = ((PowerManager)ak.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.NewVoipSmallWindow");
    this.gNb.acquire();
    paramc = t.Cvc;
    t.eAS();
    AppMethodBeat.o(210294);
  }
  
  private static void Cy(String paramString)
  {
    AppMethodBeat.i(210314);
    com.tencent.mm.kernel.g.ajR().ajA().setLong(327950, System.currentTimeMillis());
    ae.d("MicroMsg.Voip.NewVoipSmallWindow", "reportRawMessage, len: " + paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.FFH).append("\n");
    localStringBuilder.append("#accinfo.revision=").append(j.REV).append("\n");
    localStringBuilder.append("#accinfo.build=").append(j.TIME).append(":").append(j.HOSTNAME).append(":").append(k.cSM).append("\n");
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    localStringBuilder.append("#accinfo.uploadTime=" + localSimpleDateFormat.format((Date)localObject)).append("\n");
    localStringBuilder.append("#accinfo.content:\n");
    localObject = new Intent();
    ((Intent)localObject).setClassName(ak.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    ((Intent)localObject).setAction("uncatch_exception");
    ((Intent)localObject).putExtra("exceptionWriteSdcard", false);
    ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
    ((Intent)localObject).putExtra("userName", Mk());
    ((Intent)localObject).putExtra("tag", "float_window_permission");
    ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + paramString).getBytes(), 2));
    ak.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(210314);
  }
  
  private static String Mk()
  {
    AppMethodBeat.i(210315);
    String str2 = bb.hIK.ay("login_weixin_username", "");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = bb.hIK.ay("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(210315);
    return str1;
  }
  
  private void VG(int paramInt)
  {
    AppMethodBeat.i(210298);
    switch (paramInt)
    {
    }
    for (;;)
    {
      tT(true);
      AppMethodBeat.o(210298);
      return;
      ak.getContext();
      continue;
      ak.getContext();
      continue;
      ak.getContext();
    }
  }
  
  private void VH(int paramInt)
  {
    AppMethodBeat.i(210300);
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "showVoiceTalking");
    this.CLl = true;
    if (-1L == this.CLj) {
      this.CLj = System.currentTimeMillis();
    }
    if (2 == this.Cqn) {
      ak.getContext();
    }
    if (this.CLf != null) {
      this.CLf.a(this, 2);
    }
    String str = eFd();
    aM(str, w.zP(this.Cqh.field_username), str);
    eFb();
    this.CLg = com.tencent.mm.plugin.voip.c.eyt().ax(false, this.CLk);
    if (this.CLk) {
      a.a.CoX.eyv();
    }
    if (4101 == paramInt) {
      ak.getContext();
    }
    AppMethodBeat.o(210300);
  }
  
  public static int dzu()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  private void eCy()
  {
    AppMethodBeat.i(210299);
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "showVideoTalking");
    this.CLk = true;
    if (-1L == this.CLj) {
      this.CLj = System.currentTimeMillis();
    }
    if (this.CLf != null)
    {
      this.CLf.a(this, 2);
      this.CLf.eyM();
    }
    String str = ak.getContext().getString(2131764932);
    aM(str, w.zP(this.Cqh.field_username), str);
    eFb();
    this.CLg = com.tencent.mm.plugin.voip.c.eyt().ax(true, false);
    eFc();
    AppMethodBeat.o(210299);
  }
  
  private void eEZ()
  {
    AppMethodBeat.i(210296);
    if ((this.mStatus == 261) || (this.mStatus == 7) || (this.mStatus == 260) || (this.mStatus == 6))
    {
      this.CLp = true;
      if (this.CLh != null) {
        this.CLh.stopTimer();
      }
      this.CLh = new com.tencent.mm.sdk.platformtools.aw("timerCounter", new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(210291);
          h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(210290);
              com.tencent.mm.plugin.voip.c.eyt().aFc(b.this.eFa());
              AppMethodBeat.o(210290);
            }
          });
          AppMethodBeat.o(210291);
          return true;
        }
      }, true);
      this.CLh.ay(1000L, 1000L);
    }
    AppMethodBeat.o(210296);
  }
  
  private void eFb()
  {
    AppMethodBeat.i(210302);
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "showMini");
    Intent localIntent = new Intent();
    localIntent.setClass(ak.getContext(), VideoActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.Cqh.field_username);
    localIntent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.eys().eBe());
    localIntent.putExtra("Voip_Outcall", this.Cqi);
    localIntent.putExtra("Voip_VideoCall", this.Cqj);
    localIntent.putExtra("Voip_Is_Talking", this.CLp);
    com.tencent.mm.plugin.voip.c.eyt().a(localIntent, this.Cqj, false, new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(210293);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          com.tencent.mm.plugin.voip.c.eyt().aFc(b.this.eFa());
        }
        for (;;)
        {
          if ((b.d(b.this)) && (b.g(b.this)))
          {
            b.a(b.this, false);
            b.a(b.this, paramAnonymousBaseSmallView);
            b.h(b.this);
          }
          AppMethodBeat.o(210293);
          return;
          com.tencent.mm.plugin.voip.c.eyt().aFd(ak.getContext().getString(2131764885));
        }
      }
      
      public final boolean dgb()
      {
        AppMethodBeat.i(210292);
        if (b.d(b.this))
        {
          String str = ak.getContext().getString(2131764932);
          b.this.aM(str, w.zP(b.e(b.this).field_username), str);
          if ((l.Vw(b.f(b.this))) || (l.Vu(b.f(b.this))))
          {
            b.a(b.this, true);
            AppMethodBeat.o(210292);
            return true;
          }
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          b.c(b.this);
          AppMethodBeat.o(210292);
          return false;
        }
        if ((l.Vw(b.f(b.this))) || (l.Vu(b.f(b.this))))
        {
          AppMethodBeat.o(210292);
          return true;
        }
        AppMethodBeat.o(210292);
        return false;
      }
    });
    if (!com.tencent.mm.plugin.voip.c.eys().Cvs)
    {
      com.tencent.mm.plugin.voip.c.eys().Cvs = true;
      long l = com.tencent.mm.kernel.g.ajR().ajA().aby(327950);
      if (System.currentTimeMillis() - l > 86400000L) {
        Cy("have not permission to showing floating window\n");
      }
    }
    AppMethodBeat.o(210302);
  }
  
  private void eFc()
  {
    AppMethodBeat.i(210303);
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "setVideoTalkingView");
    if (this.CLg != null)
    {
      this.CLg.setStatus(this.mStatus);
      this.CLg.setConnectSec(this.Cqo);
      this.CLg.setVoipUIListener(this.CLf);
      Context localContext = ak.getContext();
      com.tencent.mm.plugin.voip.c.eys();
      u.tw(true);
      ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getHeight();
      this.CLg.eEX();
      this.CLg.setOnClickListener(this.CLn);
      ae.i("MicroMsg.Voip.NewVoipSmallWindow", "now add to view..");
      ae.i("MicroMsg.Voip.NewVoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.CzS), Integer.valueOf(this.CqK) });
    }
    AppMethodBeat.o(210303);
  }
  
  private static String eFd()
  {
    AppMethodBeat.i(210304);
    String str = ak.getContext().getString(2131764940);
    AppMethodBeat.o(210304);
    return str;
  }
  
  private void tT(boolean paramBoolean)
  {
    AppMethodBeat.i(210306);
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "removeSmallView isFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.CLh != null) {
      this.CLh.stopTimer();
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.eyt().eCH();
    }
    for (;;)
    {
      if ((this.CLg != null) && (!paramBoolean))
      {
        this.CLg.uninit();
        if (this.CLg.getParent() != null) {
          ((ViewGroup)this.CLg.getParent()).removeAllViews();
        }
        this.CLg = null;
      }
      AppMethodBeat.o(210306);
      return;
      com.tencent.mm.plugin.voip.c.eyt().rm(false);
    }
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a Vb(int paramInt)
  {
    return null;
  }
  
  public final void Vc(int paramInt) {}
  
  public final void Vd(int paramInt) {}
  
  public final void Ve(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void aFb(String paramString) {}
  
  public final void aM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(210305);
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:false");
    ae.l("MicroMsg.Voip.NewVoipSmallWindow", "breathEffect false", new Object[0]);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(ak.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.eys().eBe());
    ((Intent)localObject).putExtra("Voip_Call_From", 3);
    ((Intent)localObject).putExtra("Voip_User", this.Cqh.field_username);
    ((Intent)localObject).putExtra("Voip_Outcall", this.Cqi);
    ((Intent)localObject).putExtra("Voip_VideoCall", this.Cqj);
    localObject = PendingIntent.getActivity(ak.getContext(), 40, (Intent)localObject, 134217728);
    paramString1 = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(paramString1).i(System.currentTimeMillis()).f(paramString2).g(paramString3);
    paramString1.Hl = ((PendingIntent)localObject);
    paramString1 = paramString1.as(dzu());
    paramString1.f(2, true);
    paramString1 = n.e(paramString1);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramString1, false);
    AppMethodBeat.o(210305);
  }
  
  public final void co(int paramInt, String paramString)
  {
    AppMethodBeat.i(210307);
    if (paramInt == 241) {
      ak.getContext();
    }
    ae.d("MicroMsg.Voip.NewVoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(paramInt)));
    if (paramInt == 235) {
      paramInt = 2131764853;
    }
    while (paramInt == 0)
    {
      ak.getContext();
      AppMethodBeat.o(210307);
      return;
      if (paramInt == 233)
      {
        com.tencent.mm.plugin.voip.c.eys().eBh();
        paramInt = 2131764852;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.aw.b.aJG()) || (this.Cqj)) {
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
    ak.getContext();
    AppMethodBeat.o(210307);
  }
  
  public final void dhQ()
  {
    AppMethodBeat.i(210313);
    com.tencent.mm.plugin.voip.c.eyt().tC(false);
    AppMethodBeat.o(210313);
  }
  
  public final void dtu()
  {
    AppMethodBeat.i(210309);
    com.tencent.mm.plugin.voip.c.eyt().dtu();
    AppMethodBeat.o(210309);
  }
  
  public final void eCp() {}
  
  public final Context eCq()
  {
    return null;
  }
  
  public final void eCr()
  {
    AppMethodBeat.i(210308);
    if (this.CLg != null) {
      this.CLg.eCr();
    }
    AppMethodBeat.o(210308);
  }
  
  public final void eCs() {}
  
  public final String eFa()
  {
    AppMethodBeat.i(210301);
    int i = (int)(System.currentTimeMillis() / 1000L - this.Cqo);
    if (this.Cqo == -1L) {
      i = 0;
    }
    String str1;
    if (i >= 3600) {
      str1 = String.format(Locale.US, "%d:%02d:%02d", new Object[] { Integer.valueOf(i / 3600), Integer.valueOf(i % 3600 / 60), Integer.valueOf(i % 60) });
    }
    for (;;)
    {
      String str2 = str1;
      if (bu.isNullOrNil(str1)) {
        str2 = "00:00";
      }
      AppMethodBeat.o(210301);
      return str2;
      if (i >= 600) {
        str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      } else {
        str1 = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      }
    }
  }
  
  public final void eyV() {}
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public final void iv(int paramInt1, int paramInt2) {}
  
  public final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210297);
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "newState: %s ", new Object[] { l.Vr(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      ae.i("MicroMsg.Voip.NewVoipSmallWindow", "state unchange");
      AppMethodBeat.o(210297);
      return;
    }
    this.mStatus = paramInt2;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210297);
      return;
      eEZ();
      if (!this.CLk)
      {
        eCy();
        AppMethodBeat.o(210297);
        return;
        VG(paramInt1);
        AppMethodBeat.o(210297);
        return;
        eEZ();
        if (!this.CLl) {
          VH(paramInt1);
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
    AppMethodBeat.i(210311);
    this.Cqo = paramLong;
    if (this.CLg != null)
    {
      this.CLg.setConnectSec(paramLong);
      AppMethodBeat.o(210311);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = eFd();
      aM(str, w.zP(this.Cqh.field_username), str);
    }
    AppMethodBeat.o(210311);
  }
  
  public final void setHWDecMode(int paramInt) {}
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(210295);
    if ((this.CLo != -1) && (this.CLo != paramInt)) {
      com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(paramInt);
    }
    this.CLo = paramInt;
    AppMethodBeat.o(210295);
  }
  
  public final void setVoipBeauty(int paramInt) {}
  
  public final void ty(boolean paramBoolean)
  {
    AppMethodBeat.i(210312);
    com.tencent.mm.plugin.voip.c.eyt().tC(true);
    AppMethodBeat.o(210312);
  }
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(210310);
    ae.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit");
    Object localObject;
    long l;
    if (-1L != this.CLj)
    {
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      if (this.CLk) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.CLj) / 1000L;
      if (!this.Cvw) {
        break label175;
      }
    }
    label175:
    for (int j = 1;; j = 2)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.gNb != null) && (this.gNb.isHeld()))
      {
        ae.i("MicroMsg.Voip.NewVoipSmallWindow", "release waklock");
        this.gNb.release();
      }
      tT(false);
      this.CLm = true;
      if (this.CLh != null) {
        this.CLh.stopTimer();
      }
      ae.i("MicroMsg.Voip.NewVoipSmallWindow", "uninit..cancel notification..");
      localObject = t.Cvc;
      t.eAT();
      AppMethodBeat.o(210310);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b
 * JD-Core Version:    0.7.0.1
 */