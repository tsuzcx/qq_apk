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
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.b;
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

public final class d
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  com.tencent.mm.plugin.voip.video.b.a CGV;
  private com.tencent.mm.plugin.voip.ui.c CLf;
  BaseSmallView CLg;
  private com.tencent.mm.sdk.platformtools.aw CLh;
  private boolean CLi;
  private long CLj;
  private boolean CLk;
  private boolean CLl;
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
  private CaptureView pdJ;
  
  public d(com.tencent.mm.plugin.voip.ui.c paramc, int paramInt, an paraman, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(115802);
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
    this.CLn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115796);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/widget/VoipSmallWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (d.a(d.this) != null) {
          d.a(d.this).setOnClickListener(null);
        }
        paramAnonymousView = d.this;
        if (paramAnonymousView.CLg != null) {
          paramAnonymousView.CLg.eCC();
        }
        paramAnonymousView = new Intent(ak.getContext(), VideoActivity.class);
        paramAnonymousView.setFlags(268435456);
        localObject = com.tencent.mm.plugin.voip.b.e.CCR;
        com.tencent.mm.plugin.voip.b.e.eDk();
        paramAnonymousView = PendingIntent.getActivity(ak.getContext(), 0, paramAnonymousView, 0);
        try
        {
          paramAnonymousView.send();
          ar.o(new Runnable()
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
            ae.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", paramAnonymousView, "send pending intent error: %s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    };
    this.CLo = -1;
    this.CLp = false;
    ae.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { l.Vr(paramInt), paraman.field_username, Boolean.valueOf(paramBoolean1) });
    this.Cqh = paraman;
    this.CLf = paramc;
    this.Cqj = paramBoolean1;
    this.Cqi = paramBoolean2;
    this.Cvw = paramBoolean3;
    iy(0, paramInt);
    this.gNb = ((PowerManager)ak.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
    this.gNb.acquire();
    paramc = t.Cvc;
    t.eAS();
    AppMethodBeat.o(115802);
  }
  
  private static void Cy(String paramString)
  {
    AppMethodBeat.i(115830);
    com.tencent.mm.kernel.g.ajR().ajA().setLong(327950, System.currentTimeMillis());
    ae.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + paramString.length());
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
    AppMethodBeat.o(115830);
  }
  
  private static String Mk()
  {
    AppMethodBeat.i(115831);
    String str2 = bb.hIK.ay("login_weixin_username", "");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = bb.hIK.ay("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(115831);
    return str1;
  }
  
  private void VG(int paramInt)
  {
    AppMethodBeat.i(115804);
    switch (paramInt)
    {
    }
    for (;;)
    {
      releaseSurfaceTexture();
      tT(true);
      AppMethodBeat.o(115804);
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
    AppMethodBeat.i(115809);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
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
    AppMethodBeat.o(115809);
  }
  
  private static int dzu()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  private void eCy()
  {
    AppMethodBeat.i(115806);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
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
    AppMethodBeat.o(115806);
  }
  
  private void eEZ()
  {
    AppMethodBeat.i(184109);
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
          AppMethodBeat.i(184105);
          h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184104);
              com.tencent.mm.plugin.voip.c.eyt().aFc(d.this.eFa());
              AppMethodBeat.o(184104);
            }
          });
          AppMethodBeat.o(184105);
          return true;
        }
      }, true);
      this.CLh.ay(1000L, 1000L);
    }
    AppMethodBeat.o(184109);
  }
  
  private void eFb()
  {
    AppMethodBeat.i(115811);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
    Intent localIntent = new Intent();
    localIntent.setClass(ak.getContext(), VideoActivity.class);
    localIntent.putExtra("Voip_Call_From", 3);
    localIntent.putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.eys().eBe());
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.Cqh.field_username);
    localIntent.putExtra("Voip_Outcall", this.Cqi);
    localIntent.putExtra("Voip_VideoCall", this.Cqj);
    localIntent.putExtra("Voip_Is_Talking", this.CLp);
    com.tencent.mm.plugin.voip.c.eyt().a(localIntent, this.Cqj, false, new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(184107);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          com.tencent.mm.plugin.voip.c.eyt().aFc(d.this.eFa());
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
          com.tencent.mm.plugin.voip.c.eyt().aFd(ak.getContext().getString(2131764885));
        }
      }
      
      public final boolean dgb()
      {
        AppMethodBeat.i(184106);
        if (d.c(d.this))
        {
          String str = ak.getContext().getString(2131764932);
          d.this.aM(str, w.zP(d.d(d.this).field_username), str);
          if ((l.Vw(d.e(d.this))) || (l.Vu(d.e(d.this))))
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
        if ((l.Vw(d.e(d.this))) || (l.Vu(d.e(d.this))))
        {
          AppMethodBeat.o(184106);
          return true;
        }
        AppMethodBeat.o(184106);
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
    AppMethodBeat.o(115811);
  }
  
  private void eFc()
  {
    AppMethodBeat.i(184110);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "setVideoTalkingView");
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
      ae.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
      eFf();
      ae.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.CzS), Integer.valueOf(this.CqK) });
      setHWDecMode(this.CzS);
      setVoipBeauty(this.CqK);
      if ((this.CqV != 0) && (this.CqW != 0)) {
        iv(this.CqV, this.CqW);
      }
    }
    AppMethodBeat.o(184110);
  }
  
  private static String eFd()
  {
    AppMethodBeat.i(115812);
    String str = ak.getContext().getString(2131764940);
    AppMethodBeat.o(115812);
    return str;
  }
  
  private void eFf()
  {
    AppMethodBeat.i(184112);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
    if ((!l.Vw(this.mStatus)) && (!l.Vu(this.mStatus)) && (!l.Vx(this.mStatus)))
    {
      ae.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
      AppMethodBeat.o(184112);
      return;
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.pdJ != null)
    {
      if ((this.pdJ.getParent() != null) && ((this.pdJ.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.pdJ.getParent()).removeView(this.pdJ);
      }
      this.CLg.setCaptureView(this.pdJ);
    }
    this.CLg.setTag(Integer.valueOf(this.mStatus));
    AppMethodBeat.o(184112);
  }
  
  private void tT(boolean paramBoolean)
  {
    AppMethodBeat.i(115816);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView isFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
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
      AppMethodBeat.o(115816);
      return;
      com.tencent.mm.plugin.voip.c.eyt().rm(false);
    }
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a Vb(int paramInt)
  {
    AppMethodBeat.i(115832);
    if ((this.CLg != null) && (this.CLg.getBeautyData() != null)) {
      this.CLg.getBeautyData().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            d.this.CGV = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.CGV;
    AppMethodBeat.o(115832);
    return locala;
  }
  
  public final void Vc(int paramInt) {}
  
  public final void Vd(int paramInt) {}
  
  public final void Ve(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115822);
    if (this.CLg != null) {
      this.CLg.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115822);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(210330);
    if (this.CLg != null) {
      this.CLg.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(210330);
  }
  
  public final void aFb(String paramString) {}
  
  public final void aM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(184111);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:false");
    ae.l("MicroMsg.Voip.VoipSmallWindow", "breathEffect false", new Object[0]);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(ak.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_Call_From", 3);
    ((Intent)localObject).putExtra("Voip_CallRoomKey", com.tencent.mm.plugin.voip.c.eys().eBe());
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
    AppMethodBeat.o(184111);
  }
  
  public final void co(int paramInt, String paramString)
  {
    AppMethodBeat.i(115817);
    if (paramInt == 241) {
      ak.getContext();
    }
    ae.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(paramInt)));
    if (paramInt == 235) {
      paramInt = 2131764853;
    }
    while (paramInt == 0)
    {
      ak.getContext();
      AppMethodBeat.o(115817);
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
    AppMethodBeat.o(115817);
  }
  
  public final void dhQ()
  {
    AppMethodBeat.i(184114);
    com.tencent.mm.plugin.voip.c.eyt().tC(false);
    AppMethodBeat.o(184114);
  }
  
  public final void dtu()
  {
    AppMethodBeat.i(184113);
    com.tencent.mm.plugin.voip.c.eyt().dtu();
    AppMethodBeat.o(184113);
  }
  
  public final void eCp() {}
  
  public final Context eCq()
  {
    return null;
  }
  
  public final void eCr() {}
  
  public final void eCs() {}
  
  public final String eFa()
  {
    AppMethodBeat.i(115810);
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
      AppMethodBeat.o(115810);
      return str2;
      if (i >= 600) {
        str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      } else {
        str1 = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
      }
    }
  }
  
  public final void eyV() {}
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115818);
    if ((260 != this.mStatus) && (6 != this.mStatus))
    {
      AppMethodBeat.o(115818);
      return;
    }
    if (this.CLg != null) {
      this.CLg.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115818);
  }
  
  public final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115820);
    this.CqV = paramInt1;
    this.CqW = paramInt2;
    if (this.CLg != null) {
      this.CLg.iv(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115820);
  }
  
  public final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115803);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[] { l.Vr(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      ae.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
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
      eEZ();
      if (!this.CLk)
      {
        eCy();
        AppMethodBeat.o(115803);
        return;
        VG(paramInt1);
        AppMethodBeat.o(115803);
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
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115824);
    if (this.CLg != null) {
      this.CLg.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115824);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115823);
    if (this.CLg != null) {
      this.CLg.requestRender();
    }
    AppMethodBeat.o(115823);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115829);
    this.pdJ = paramCaptureView;
    if ((this.CLg != null) && (this.pdJ != null))
    {
      if ((this.pdJ.getParent() != null) && ((this.pdJ.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.pdJ.getParent()).removeView(this.pdJ);
      }
      this.CLg.setCaptureView(paramCaptureView);
    }
    AppMethodBeat.o(115829);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115827);
    this.Cqo = paramLong;
    if (this.CLg != null)
    {
      this.CLg.setConnectSec(paramLong);
      AppMethodBeat.o(115827);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = eFd();
      aM(str, w.zP(this.Cqh.field_username), str);
    }
    AppMethodBeat.o(115827);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115821);
    if (this.CLg != null) {
      this.CLg.setHWDecMode(paramInt);
    }
    this.CzS = paramInt;
    AppMethodBeat.o(115821);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184108);
    if (this.CLf != null) {
      this.CLf.setVoicePlayDevice(paramInt);
    }
    if ((this.CLo != -1) && (this.CLo != paramInt)) {
      com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(paramInt);
    }
    this.CLo = paramInt;
    AppMethodBeat.o(184108);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115819);
    if (this.CLg != null) {
      this.CLg.setVoipBeauty(paramInt);
    }
    this.CqK = paramInt;
    AppMethodBeat.o(115819);
  }
  
  public final void ty(boolean paramBoolean)
  {
    AppMethodBeat.i(115828);
    com.tencent.mm.plugin.voip.c.eyt().tC(true);
    AppMethodBeat.o(115828);
  }
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(115826);
    ae.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
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
        ae.i("MicroMsg.Voip.VoipSmallWindow", "release waklock");
        this.gNb.release();
      }
      tT(false);
      if (this.CLh != null) {
        this.CLh.stopTimer();
      }
      ae.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
      this.pdJ = null;
      localObject = t.Cvc;
      t.eAT();
      AppMethodBeat.o(115826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.d
 * JD-Core Version:    0.7.0.1
 */