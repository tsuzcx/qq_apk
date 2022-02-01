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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class d
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private int AAj;
  private int AAu;
  private int AAv;
  private boolean AEV;
  private int AJn;
  private au AKA;
  com.tencent.mm.plugin.voip.video.b.a APZ;
  private boolean ATA;
  private View.OnClickListener ATB;
  private int ATC;
  boolean ATD;
  private com.tencent.mm.plugin.voip.ui.c ATt;
  BaseSmallView ATu;
  private au ATv;
  private boolean ATw;
  private long ATx;
  private boolean ATy;
  private boolean ATz;
  private com.tencent.mm.storage.ai AzG;
  private boolean AzH;
  public boolean AzI;
  private int AzM;
  private long AzN;
  private PowerManager.WakeLock gqI;
  private int mStatus;
  private CaptureView otK;
  private boolean uXC;
  
  public d(com.tencent.mm.plugin.voip.ui.c paramc, int paramInt, com.tencent.mm.storage.ai paramai, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(115802);
    this.ATw = false;
    this.mStatus = -1;
    this.AzN = -1L;
    this.AzM = 1;
    this.ATx = -1L;
    this.ATy = false;
    this.ATz = false;
    this.AEV = false;
    this.AAj = 0;
    this.AAu = 0;
    this.AAv = 0;
    this.uXC = false;
    this.ATA = false;
    this.ATB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115796);
        if (d.a(d.this) != null) {
          d.a(d.this).setOnClickListener(null);
        }
        paramAnonymousView = d.this;
        if (paramAnonymousView.ATu != null) {
          paramAnonymousView.ATu.elk();
        }
        paramAnonymousView = new Intent(com.tencent.mm.sdk.platformtools.ai.getContext(), VideoActivity.class);
        paramAnonymousView.setFlags(268435456);
        paramAnonymousView = PendingIntent.getActivity(com.tencent.mm.sdk.platformtools.ai.getContext(), 0, paramAnonymousView, 0);
        try
        {
          paramAnonymousView.send();
          ap.n(new Runnable()
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
            ac.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", paramAnonymousView, "send pending intent error: %s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    };
    this.ATC = -1;
    this.ATD = false;
    ac.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { j.SR(paramInt), paramai.field_username, Boolean.valueOf(paramBoolean1) });
    this.AzG = paramai;
    this.ATt = paramc;
    this.AzI = paramBoolean1;
    this.AzH = paramBoolean2;
    this.AEV = paramBoolean3;
    ih(0, paramInt);
    this.gqI = ((PowerManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
    this.gqI.acquire();
    paramc = t.AEB;
    t.ejA();
    AppMethodBeat.o(115802);
  }
  
  private static String Ky()
  {
    AppMethodBeat.i(115831);
    String str2 = ay.hnA.aw("login_weixin_username", "");
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = ay.hnA.aw("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(115831);
    return str1;
  }
  
  private void Tg(int paramInt)
  {
    AppMethodBeat.i(115804);
    switch (paramInt)
    {
    }
    for (;;)
    {
      releaseSurfaceTexture();
      tc(true);
      AppMethodBeat.o(115804);
      return;
      com.tencent.mm.sdk.platformtools.ai.getContext();
      continue;
      com.tencent.mm.sdk.platformtools.ai.getContext();
      continue;
      com.tencent.mm.sdk.platformtools.ai.getContext();
    }
  }
  
  private void Th(int paramInt)
  {
    AppMethodBeat.i(115809);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
    this.ATz = true;
    if (-1L == this.ATx) {
      this.ATx = System.currentTimeMillis();
    }
    if (2 == this.AzM) {
      com.tencent.mm.sdk.platformtools.ai.getContext();
    }
    if (this.ATt != null) {
      this.ATt.a(this, 2);
    }
    String str = enw();
    aF(str, v.wk(this.AzG.field_username), str);
    enu();
    if (4101 == paramInt) {
      com.tencent.mm.sdk.platformtools.ai.getContext();
    }
    AppMethodBeat.o(115809);
  }
  
  private static int dlN()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  private void elg()
  {
    AppMethodBeat.i(115806);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
    this.ATy = true;
    if (-1L == this.ATx) {
      this.ATx = System.currentTimeMillis();
    }
    if (this.ATt != null)
    {
      this.ATt.a(this, 2);
      this.ATt.ehv();
    }
    String str = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764932);
    aF(str, v.wk(this.AzG.field_username), str);
    enu();
    this.ATu = com.tencent.mm.plugin.voip.c.ehc().AKy;
    env();
    AppMethodBeat.o(115806);
  }
  
  private void ens()
  {
    AppMethodBeat.i(184109);
    if ((this.mStatus == 261) || (this.mStatus == 7) || (this.mStatus == 260) || (this.mStatus == 6))
    {
      this.ATD = true;
      if (this.ATv != null) {
        this.ATv.stopTimer();
      }
      this.ATv = new au("timerCounter", new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(184105);
          com.tencent.e.h.JZN.aQ(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(184104);
              com.tencent.mm.plugin.voip.c.ehc().ayB(d.this.ent());
              AppMethodBeat.o(184104);
            }
          });
          AppMethodBeat.o(184105);
          return true;
        }
      }, true);
      this.ATv.au(1000L, 1000L);
    }
    AppMethodBeat.o(184109);
  }
  
  private void enu()
  {
    AppMethodBeat.i(115811);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
    Intent localIntent = new Intent();
    localIntent.setClass(com.tencent.mm.sdk.platformtools.ai.getContext(), VideoActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.AzG.field_username);
    localIntent.putExtra("Voip_Outcall", this.AzH);
    localIntent.putExtra("Voip_VideoCall", this.AzI);
    localIntent.putExtra("Voip_Is_Talking", this.ATD);
    com.tencent.mm.plugin.voip.c.ehc().a(localIntent, this.AzI, false, new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(184107);
        if (paramAnonymousIntent.getBooleanExtra("Voip_Is_Talking", false)) {
          paramAnonymousBaseSmallView.ayB(d.this.ent());
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
          paramAnonymousBaseSmallView.ayC(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764885));
        }
      }
      
      public final boolean cTY()
      {
        AppMethodBeat.i(184106);
        if (d.c(d.this))
        {
          String str = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764932);
          d.this.aF(str, v.wk(d.d(d.this).field_username), str);
          if ((j.SW(d.e(d.this))) || (j.SU(d.e(d.this))))
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
        if ((j.SW(d.e(d.this))) || (j.SU(d.e(d.this))))
        {
          AppMethodBeat.o(184106);
          return true;
        }
        AppMethodBeat.o(184106);
        return false;
      }
    });
    if (!com.tencent.mm.plugin.voip.c.ehb().AER)
    {
      com.tencent.mm.plugin.voip.c.ehb().AER = true;
      long l = g.agR().agA().YH(327950);
      if (System.currentTimeMillis() - l > 86400000L) {
        yX("have not permission to showing floating window\n");
      }
    }
    AppMethodBeat.o(115811);
  }
  
  private void env()
  {
    AppMethodBeat.i(184110);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "setVideoTalkingView");
    if (this.ATu != null)
    {
      this.ATu.setStatus(this.mStatus);
      this.ATu.setConnectSec(this.AzN);
      this.ATu.setVoipUIListener(this.ATt);
      Context localContext = com.tencent.mm.sdk.platformtools.ai.getContext();
      com.tencent.mm.plugin.voip.c.ehb();
      u.sG(true);
      ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getHeight();
      this.ATu.enq();
      this.ATu.setOnClickListener(this.ATB);
      ac.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
      eny();
      ac.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.AJn), Integer.valueOf(this.AAj) });
      setHWDecMode(this.AJn);
      setVoipBeauty(this.AAj);
      if ((this.AAu != 0) && (this.AAv != 0)) {
        ie(this.AAu, this.AAv);
      }
    }
    AppMethodBeat.o(184110);
  }
  
  private static String enw()
  {
    AppMethodBeat.i(115812);
    String str = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764940);
    AppMethodBeat.o(115812);
    return str;
  }
  
  private void eny()
  {
    AppMethodBeat.i(184112);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
    if ((!j.SW(this.mStatus)) && (!j.SU(this.mStatus)) && (!j.SX(this.mStatus)))
    {
      ac.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
      AppMethodBeat.o(184112);
      return;
    }
    if (this.AKA != null) {
      this.AKA.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.otK != null)
    {
      if ((this.otK.getParent() != null) && ((this.otK.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.otK.getParent()).removeView(this.otK);
      }
      this.ATu.setCaptureView(this.otK);
    }
    this.ATu.setTag(Integer.valueOf(this.mStatus));
    AppMethodBeat.o(184112);
  }
  
  private void tc(boolean paramBoolean)
  {
    AppMethodBeat.i(115816);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView isFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    if (this.ATv != null) {
      this.ATv.stopTimer();
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.voip.c.ehc().elp();
    }
    for (;;)
    {
      if ((this.ATu != null) && (!paramBoolean))
      {
        this.ATu.uninit();
        if (this.ATu.getParent() != null) {
          ((ViewGroup)this.ATu.getParent()).removeAllViews();
        }
        this.ATu = null;
      }
      AppMethodBeat.o(115816);
      return;
      com.tencent.mm.plugin.voip.c.ehc().qD(false);
    }
  }
  
  private static void yX(String paramString)
  {
    AppMethodBeat.i(115830);
    g.agR().agA().setLong(327950, System.currentTimeMillis());
    ac.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.DIc).append("\n");
    localStringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.h.REV).append("\n");
    localStringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.h.TIME).append(":").append(com.tencent.mm.sdk.platformtools.h.HOSTNAME).append(":").append(com.tencent.mm.sdk.platformtools.i.cGY).append("\n");
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    localStringBuilder.append("#accinfo.uploadTime=" + localSimpleDateFormat.format((Date)localObject)).append("\n");
    localStringBuilder.append("#accinfo.content:\n");
    localObject = new Intent();
    ((Intent)localObject).setClassName(com.tencent.mm.sdk.platformtools.ai.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    ((Intent)localObject).setAction("uncatch_exception");
    ((Intent)localObject).putExtra("exceptionWriteSdcard", false);
    ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
    ((Intent)localObject).putExtra("userName", Ky());
    ((Intent)localObject).putExtra("tag", "float_window_permission");
    ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + paramString).getBytes(), 2));
    com.tencent.mm.sdk.platformtools.ai.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(115830);
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a SD(int paramInt)
  {
    AppMethodBeat.i(115832);
    if ((this.ATu != null) && (this.ATu.getBeautyData() != null)) {
      this.ATu.getBeautyData().a(paramInt, new a.b()
      {
        public final void a(com.tencent.mm.plugin.voip.video.b.a paramAnonymousa)
        {
          if (paramAnonymousa != null) {
            d.this.APZ = paramAnonymousa;
          }
        }
      });
    }
    com.tencent.mm.plugin.voip.video.b.a locala = this.APZ;
    AppMethodBeat.o(115832);
    return locala;
  }
  
  public final void SE(int paramInt) {}
  
  public final void SF(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd)
  {
    AppMethodBeat.i(115822);
    if (this.ATu != null) {
      this.ATu.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115822);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(208603);
    if (this.ATu != null) {
      this.ATu.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(208603);
  }
  
  public final void aF(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(184111);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:false");
    ac.l("MicroMsg.Voip.VoipSmallWindow", "breathEffect false", new Object[0]);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(com.tencent.mm.sdk.platformtools.ai.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_User", this.AzG.field_username);
    ((Intent)localObject).putExtra("Voip_Outcall", this.AzH);
    ((Intent)localObject).putExtra("Voip_VideoCall", this.AzI);
    localObject = PendingIntent.getActivity(com.tencent.mm.sdk.platformtools.ai.getContext(), 40, (Intent)localObject, 134217728);
    paramString1 = com.tencent.mm.bq.a.bE(com.tencent.mm.sdk.platformtools.ai.getContext(), "reminder_channel_id").i(paramString1).i(System.currentTimeMillis()).f(paramString2).g(paramString3);
    paramString1.Fu = ((PendingIntent)localObject);
    paramString1 = paramString1.as(dlN());
    paramString1.f(2, true);
    paramString1 = l.e(paramString1);
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramString1, false);
    AppMethodBeat.o(184111);
  }
  
  public final void ayA(String paramString) {}
  
  public final void cVN()
  {
    AppMethodBeat.i(184114);
    if (this.ATu != null) {
      this.ATu.sM(false);
    }
    AppMethodBeat.o(184114);
  }
  
  public final void cg(int paramInt, String paramString)
  {
    AppMethodBeat.i(115817);
    if (paramInt == 241) {
      com.tencent.mm.sdk.platformtools.ai.getContext();
    }
    ac.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(paramInt)));
    if (paramInt == 235) {
      paramInt = 2131764853;
    }
    while (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.ai.getContext();
      AppMethodBeat.o(115817);
      return;
      if (paramInt == 233)
      {
        com.tencent.mm.plugin.voip.c.ehb().ejP();
        paramInt = 2131764852;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.aw.b.aGf()) || (this.AzI)) {
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
    com.tencent.mm.sdk.platformtools.ai.getContext();
    AppMethodBeat.o(115817);
  }
  
  public final void dgi()
  {
    AppMethodBeat.i(184113);
    if (this.ATu != null) {
      this.ATu.dgi();
    }
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
    if (this.ATu != null) {
      this.ATu.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115818);
  }
  
  public final void ekW() {}
  
  public final Context ekX()
  {
    return null;
  }
  
  public final void ekY() {}
  
  public final void ekZ() {}
  
  public final void ela() {}
  
  public final String ent()
  {
    AppMethodBeat.i(115810);
    int i = (int)(System.currentTimeMillis() / 1000L - this.AzN);
    if (this.AzN == -1L) {
      i = 0;
    }
    String str1;
    if (i >= 3600) {
      str1 = String.format(Locale.US, "%d:%02d:%02d", new Object[] { Integer.valueOf(i / 3600), Integer.valueOf(i % 3600 / 60), Integer.valueOf(i % 60) });
    }
    for (;;)
    {
      String str2 = str1;
      if (bs.isNullOrNil(str1)) {
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
  
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115820);
    this.AAu = paramInt1;
    this.AAv = paramInt2;
    if (this.ATu != null) {
      this.ATu.ie(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115820);
  }
  
  public final void ih(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115803);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[] { j.SR(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      ac.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
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
      ens();
      if (!this.ATy)
      {
        elg();
        AppMethodBeat.o(115803);
        return;
        Tg(paramInt1);
        AppMethodBeat.o(115803);
        return;
        ens();
        if (!this.ATz) {
          Th(paramInt1);
        }
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115824);
    if (this.ATu != null) {
      this.ATu.releaseSurfaceTexture();
    }
    AppMethodBeat.o(115824);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115823);
    if (this.ATu != null) {
      this.ATu.requestRender();
    }
    AppMethodBeat.o(115823);
  }
  
  public final void sI(boolean paramBoolean)
  {
    AppMethodBeat.i(115828);
    if (this.ATu != null) {
      this.ATu.sM(true);
    }
    AppMethodBeat.o(115828);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(115829);
    this.otK = paramCaptureView;
    if ((this.ATu != null) && (this.otK != null))
    {
      if ((this.otK.getParent() != null) && ((this.otK.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.otK.getParent()).removeView(this.otK);
      }
      this.ATu.setCaptureView(paramCaptureView);
    }
    AppMethodBeat.o(115829);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(115827);
    this.AzN = paramLong;
    if (this.ATu != null)
    {
      this.ATu.setConnectSec(paramLong);
      AppMethodBeat.o(115827);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = enw();
      aF(str, v.wk(this.AzG.field_username), str);
    }
    AppMethodBeat.o(115827);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115821);
    if (this.ATu != null) {
      this.ATu.setHWDecMode(paramInt);
    }
    this.AJn = paramInt;
    AppMethodBeat.o(115821);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184108);
    if (this.ATt != null) {
      this.ATt.setVoicePlayDevice(paramInt);
    }
    if ((this.ATC != -1) && (this.ATC != paramInt))
    {
      if (this.ATu == null) {
        break label66;
      }
      this.ATu.setVoicePlayDevice(paramInt);
    }
    for (;;)
    {
      this.ATC = paramInt;
      AppMethodBeat.o(184108);
      return;
      label66:
      if (com.tencent.mm.plugin.voip.c.ehc().AKy != null) {
        com.tencent.mm.plugin.voip.c.ehc().AKy.setVoicePlayDevice(paramInt);
      }
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115819);
    if (this.ATu != null) {
      this.ATu.setVoipBeauty(paramInt);
    }
    this.AAj = paramInt;
    AppMethodBeat.o(115819);
  }
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(115826);
    ac.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
    Object localObject;
    long l;
    if (-1L != this.ATx)
    {
      localObject = com.tencent.mm.plugin.report.service.h.wUl;
      if (this.ATy) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.ATx) / 1000L;
      if (!this.AEV) {
        break label180;
      }
    }
    label180:
    for (int j = 1;; j = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.gqI != null) && (this.gqI.isHeld()))
      {
        ac.i("MicroMsg.Voip.VoipSmallWindow", "release waklock");
        this.gqI.release();
      }
      tc(false);
      this.ATA = true;
      if (this.ATv != null) {
        this.ATv.stopTimer();
      }
      ac.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
      this.otK = null;
      localObject = t.AEB;
      t.ejB();
      AppMethodBeat.o(115826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.d
 * JD-Core Version:    0.7.0.1
 */