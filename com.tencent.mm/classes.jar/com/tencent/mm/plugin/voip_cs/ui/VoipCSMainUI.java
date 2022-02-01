package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.support.v4.app.s.c;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.c.b.a.a;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.p;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.c.b, a.a
{
  private BroadcastReceiver BZH;
  private com.tencent.mm.network.n Bno;
  public String Cvr;
  private com.tencent.mm.plugin.voip_cs.c.a.a Cvx;
  private com.tencent.mm.plugin.voip_cs.c.a.b Cwc;
  private com.tencent.mm.plugin.voip_cs.a.a Cwd;
  public String Cwe;
  public String Cwf;
  public String Cwg;
  public boolean Cwh;
  private av Cwi;
  private String appId;
  private com.tencent.mm.compatible.util.b dbG;
  public String dxD;
  private ap gIf;
  public String jna;
  PhoneStateListener ljq;
  public String scene;
  public CharSequence tickerText;
  public CharSequence title;
  public String type;
  private TelephonyManager uJU;
  
  public VoipCSMainUI()
  {
    AppMethodBeat.i(125458);
    this.Cvr = "";
    this.appId = "";
    this.jna = "";
    this.Cwe = "";
    this.Cwf = "";
    this.Cwg = "";
    this.scene = "";
    this.type = "";
    this.Cwh = false;
    this.dxD = aj.getContext().getString(2131764837);
    this.tickerText = aj.getContext().getString(2131764837);
    this.title = aj.getContext().getString(2131764831);
    this.Cwi = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125457);
        Object localObject = new Intent(aj.getContext(), VoipCSMainUI.class);
        localObject = PendingIntent.getActivity(aj.getContext(), 44, (Intent)localObject, 134217728);
        s.c localc = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(VoipCSMainUI.this.tickerText).f(VoipCSMainUI.this.title).g(VoipCSMainUI.this.dxD);
        localc.Hl = ((PendingIntent)localObject);
        localc.f(2, true);
        localObject = localc.build();
        ((Notification)localObject).icon = com.tencent.mm.br.a.dwe();
        ((Notification)localObject).flags |= 0x20;
        ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
        AppMethodBeat.o(125457);
        return true;
      }
    }, true);
    this.BZH = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(192876);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)aj.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          ad.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
          VoipCSMainUI.c(VoipCSMainUI.this).dtm = false;
          AppMethodBeat.o(192876);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          ad.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
          VoipCSMainUI.c(VoipCSMainUI.this).dtm = false;
          if ((!VoipCSMainUI.d(VoipCSMainUI.this).cae()) && (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq == 2))
          {
            VoipCSMainUI.d(VoipCSMainUI.this).eBM();
            AppMethodBeat.o(192876);
          }
        }
        else if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          ad.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
          VoipCSMainUI.c(VoipCSMainUI.this).dtm = true;
          if (!VoipCSMainUI.d(VoipCSMainUI.this).cae()) {
            VoipCSMainUI.d(VoipCSMainUI.this).stopRing();
          }
        }
        AppMethodBeat.o(192876);
      }
    };
    this.ljq = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(192877);
        ad.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
        if (paramAnonymousInt == 2)
        {
          ad.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
          com.tencent.mm.plugin.voip_cs.c.c.eBD().CuK = 4;
          VoipCSMainUI.this.Vb(7);
        }
        AppMethodBeat.o(192877);
      }
    };
    this.Bno = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(192880);
        ad.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        com.tencent.mm.plugin.voip_cs.c.a locala;
        if ((com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq == 2) && ((paramAnonymousInt == 4) || (paramAnonymousInt == 6)))
        {
          localObject = com.tencent.mm.plugin.voip_cs.c.c.eBC();
          locala = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ;
          if (((com.tencent.mm.plugin.voip_cs.c.e)localObject).CaT == 0) {
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject).CaT = locala.Cfe;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.b.f.getNetType(aj.getContext());
          if (paramAnonymousInt != ((com.tencent.mm.plugin.voip_cs.c.e)localObject).CaT) {
            ad.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((com.tencent.mm.plugin.voip_cs.c.e)localObject).CaT + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locala.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            ad.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locala.uLA + ", roomkey=" + locala.uLt + "]");
          }
          duf localduf = new duf();
          localduf.HGZ = 3;
          localduf.HHa = new com.tencent.mm.bx.b(arrayOfByte, 0, 1);
          locala.SendRUDP(localduf.toByteArray(), localduf.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
          }
        }
        ((com.tencent.mm.plugin.voip_cs.c.e)localObject).CaT = paramAnonymousInt;
        Object localObject = com.tencent.mm.plugin.voip_cs.c.c.eBC();
        ad.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.Cfg + "roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.uLt);
        g.aiU().a(285, (com.tencent.mm.al.f)localObject);
        localObject = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ;
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.d(((v2protocal)localObject).Cfg, ((v2protocal)localObject).uLt);
        g.aiU().a((com.tencent.mm.al.n)localObject, 0);
        AppMethodBeat.o(192880);
      }
    };
    AppMethodBeat.o(125458);
  }
  
  private void eBY()
  {
    AppMethodBeat.i(125460);
    if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq <= 0)
    {
      this.Cwc.eBN();
      this.Cwc.eBO();
      com.tencent.mm.plugin.voip_cs.c.c.eBB().init();
      com.tencent.mm.plugin.voip_cs.c.c.eBC().aN(this.Cvr, this.appId, this.Cwg);
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq < 2) {
      this.Cvx.eBM();
    }
    this.Cwc.eBR();
    AppMethodBeat.o(125460);
  }
  
  private boolean eBZ()
  {
    AppMethodBeat.i(125471);
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", ""))
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
    ad.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this });
    if (!bool)
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    AppMethodBeat.o(125471);
    return true;
  }
  
  public final void Vb(int paramInt)
  {
    AppMethodBeat.i(125468);
    ad.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq);
    if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq == 0)
    {
      finish();
      AppMethodBeat.o(125468);
      return;
    }
    if (this.Cwc != null) {
      this.Cwc.Ve(paramInt);
    }
    AppMethodBeat.o(125468);
  }
  
  public final void ddd()
  {
    Object localObject2 = null;
    AppMethodBeat.i(125473);
    this.Cwc.ddd();
    this.Cwd.Ob();
    Object localObject1 = this.Cwd;
    if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).oWf != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).oWf;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((com.tencent.mm.audio.b.c)localObject1).PP());
        com.tencent.mm.plugin.voip_cs.c.c.eBD().CuP = 1;
        if (!p.i(localObject1, Boolean.TRUE)) {
          break label230;
        }
      }
    }
    com.tencent.mm.plugin.voip_cs.a.a locala;
    label230:
    for (int i = 1;; i = -1)
    {
      com.tencent.mm.plugin.voip_cs.c.c.eBD().Cvi = i;
      locala = this.Cwd;
      if (locala.Cbr != null) {
        break label235;
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eBB();
      p.g(localObject1, "SubCoreVoipCS.getVoipCSEngine()");
      ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).CvZ.Cfw = Math.abs(1);
      this.Cvx.stopRing();
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eBD();
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Cvd != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CuS = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Cvd);
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eBD();
      ad.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Cvg == 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Cvg = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eBD();
      ad.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Cvf != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CuU = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).Cvf);
      }
      AppMethodBeat.o(125473);
      return;
      localObject1 = null;
      break;
    }
    label235:
    com.tencent.mm.plugin.voip.model.c localc = locala.Cbr;
    localObject1 = localObject2;
    if (localc != null) {
      localObject1 = Integer.valueOf(localc.euS());
    }
    localObject2 = locala.Cbr;
    if (localObject2 != null) {}
    for (i = ((com.tencent.mm.plugin.voip.model.c)localObject2).euS();; i = 0)
    {
      if (i <= 0)
      {
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eBB();
        p.g(localObject2, "SubCoreVoipCS.getVoipCSEngine()");
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject2).CvZ.Cfw = Math.abs(1);
      }
      if (localObject1 == null) {
        break;
      }
      ((Integer)localObject1).intValue();
      break;
    }
  }
  
  public final void eBX()
  {
    AppMethodBeat.i(125474);
    ad.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.Cwc.Ve(5);
    AppMethodBeat.o(125474);
  }
  
  public int getLayoutId()
  {
    return 2131495878;
  }
  
  public final void ko(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125470);
    com.tencent.mm.plugin.voip_cs.c.a.b localb = this.Cwc;
    if ((localb.CvP.equals("")) && (bt.isNullOrNil(paramString2))) {
      if (localb.Cvy.Cwh) {
        localb.fOg.setText(2131764818);
      }
    }
    while ((localb.CvO.equals("")) && (bt.isNullOrNil(paramString1)) && ((localb.Cvy.jna == null) || (localb.Cvy.jna.equals(""))))
    {
      localb.CvE.setImageResource(2131231875);
      AppMethodBeat.o(125470);
      return;
      localb.fOg.setText(2131764817);
      continue;
      localb.setNickName(paramString2);
    }
    SharedPreferences localSharedPreferences = aj.fkD();
    if ((!bt.isNullOrNil(paramString1)) && (!localb.CvO.equals(paramString1)))
    {
      localb.aDN(paramString1);
      localSharedPreferences.edit().putString(localb.eBP(), paramString1).commit();
    }
    if ((!bt.isNullOrNil(paramString2)) && (!localb.CvP.equals(paramString2)))
    {
      localb.setNickName(paramString2);
      localSharedPreferences.edit().putString(localb.eBQ(), paramString2).commit();
    }
    AppMethodBeat.o(125470);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125459);
    ad.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    hideTitleView();
    this.Cvr = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.scene = bt.nullAsNil(getIntent().getStringExtra("voipCSScene"));
    this.type = bt.nullAsNil(getIntent().getStringExtra("voipCSType"));
    this.Cwe = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.Cwf = getIntent().getStringExtra("voipCSShowOther");
    this.jna = getIntent().getStringExtra("voipCSAvatarUrl");
    this.Cwg = getIntent().getStringExtra("voipCSContext");
    this.Cwh = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.gIf = new ap();
    paramBundle = com.tencent.mm.plugin.voip_cs.c.c.eBD();
    ad.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.dataType = 0;
    paramBundle.Cuu = 0;
    paramBundle.Cuv = 0;
    paramBundle.Cuw = 0;
    paramBundle.videoFps = 0;
    paramBundle.Cux = 0;
    paramBundle.Cuy = 0;
    paramBundle.Cuz = 0;
    paramBundle.CuA = 0;
    paramBundle.CuB = 0;
    paramBundle.CuC = 0;
    paramBundle.networkType = 0;
    paramBundle.CuD = 0;
    paramBundle.CuE = com.tencent.mm.plugin.voip_cs.c.d.Cur;
    paramBundle.gHR = 0;
    paramBundle.roomId = 0L;
    paramBundle.uLt = 0L;
    paramBundle.CuF = "";
    paramBundle.Cfe = 0;
    paramBundle.CuI = 0;
    paramBundle.CuJ = 0;
    paramBundle.CuK = 0;
    paramBundle.CfA = 0;
    paramBundle.Cfz = 0;
    paramBundle.CuL = 0;
    paramBundle.CuM = 0;
    paramBundle.CuN = 0;
    paramBundle.CuO = 0;
    paramBundle.CuP = 0;
    paramBundle.CuQ = 0;
    paramBundle.CuR = 0L;
    paramBundle.CuS = 0;
    paramBundle.CuT = 0L;
    paramBundle.CuU = 0L;
    paramBundle.CuV = 0L;
    paramBundle.uMH = 0L;
    paramBundle.CuW = 0;
    paramBundle.CuX = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.Chf = 0;
    paramBundle.CfB = 0;
    paramBundle.CuY = 0;
    paramBundle.CuZ = 0;
    paramBundle.uMR = "";
    paramBundle.uMQ = "";
    paramBundle.Cvd = 0;
    paramBundle.Cve = 0;
    paramBundle.Cvf = 0;
    paramBundle.Cvg = 0;
    paramBundle.Cvh = 0;
    this.uJU = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvr = this.Cvr;
    this.Cwc = new com.tencent.mm.plugin.voip_cs.c.a.b(this);
    this.Cwd = new com.tencent.mm.plugin.voip_cs.a.a();
    this.dbG = new com.tencent.mm.compatible.util.b(aj.getContext());
    this.Cvx = com.tencent.mm.plugin.voip_cs.c.a.a.eBK();
    com.tencent.mm.plugin.voip_cs.c.c.eBB().Cwa = this;
    com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvj = this;
    if ((com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq == 0) || (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq == 3)) {
      com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq = 0;
    }
    com.tencent.mm.booter.a.Wt().Wv();
    this.dbG.requestFocus();
    this.Cwd.Ob();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    aj.getContext().registerReceiver(this.BZH, paramBundle);
    g.ajB().a(this.Bno);
    if (this.Cwh) {
      if (this.scene.equals("1")) {
        if (this.type.equals("video"))
        {
          this.title = aj.getContext().getString(2131764829);
          this.tickerText = aj.getContext().getString(2131764833);
          this.dxD = aj.getContext().getString(2131764833);
          i = this.uJU.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1134;
          }
          ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          h.a(this, 2131764843, 2131755906, new VoipCSMainUI.1(this));
        }
      }
    }
    label1134:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label1139;
      }
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
      AppMethodBeat.o(125459);
      return;
      this.title = aj.getContext().getString(2131764830);
      this.tickerText = aj.getContext().getString(2131764834);
      this.dxD = aj.getContext().getString(2131764834);
      break;
      if (this.type.equals("video"))
      {
        this.title = aj.getContext().getString(2131764831);
        this.tickerText = aj.getContext().getString(2131764835);
        this.dxD = aj.getContext().getString(2131764835);
        break;
      }
      this.title = aj.getContext().getString(2131764830);
      this.tickerText = aj.getContext().getString(2131764834);
      this.dxD = aj.getContext().getString(2131764834);
      break;
      if (this.scene.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.title = aj.getContext().getString(2131764829);
          this.tickerText = aj.getContext().getString(2131764833);
          this.dxD = aj.getContext().getString(2131764833);
          break;
        }
        this.title = aj.getContext().getString(2131764830);
        this.tickerText = aj.getContext().getString(2131764837);
        this.dxD = aj.getContext().getString(2131764837);
        break;
      }
      if (this.type.equals("video"))
      {
        this.title = aj.getContext().getString(2131764831);
        this.tickerText = aj.getContext().getString(2131764837);
        this.dxD = aj.getContext().getString(2131764837);
        break;
      }
      this.title = aj.getContext().getString(2131764830);
      this.tickerText = aj.getContext().getString(2131764836);
      this.dxD = aj.getContext().getString(2131764836);
      break;
    }
    label1139:
    this.uJU.listen(this.ljq, 32);
    if (!ay.isNetworkConnected(this))
    {
      ad.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
      h.a(this, 2131764839, 2131764899, new VoipCSMainUI.13(this));
      i = 0;
    }
    while (i == 0)
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
      AppMethodBeat.o(125459);
      return;
      if ((ay.isWifi(this)) || (s.ewU()))
      {
        i = 1;
      }
      else
      {
        ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
        h.a(this, 2131764840, 2131764899, new DialogInterface.OnClickListener()new VoipCSMainUI.15
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125455);
            ad.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
            s.ewT();
            if (VoipCSMainUI.a(VoipCSMainUI.this)) {
              VoipCSMainUI.b(VoipCSMainUI.this);
            }
            AppMethodBeat.o(125455);
          }
        }, new VoipCSMainUI.15(this));
        i = 0;
      }
    }
    if (com.tencent.mm.plugin.voip.b.n.isVoipStarted())
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
      h.a(this, 2131760336, 2131755906, new VoipCSMainUI.9(this));
      i = 1;
    }
    while (i != 0)
    {
      ad.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
      AppMethodBeat.o(125459);
      return;
      if (com.tencent.mm.plugin.voip.b.n.eAe())
      {
        ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
        h.a(this, 2131760337, 2131755906, new VoipCSMainUI.10(this));
        i = 1;
      }
      else if (com.tencent.mm.s.a.adC())
      {
        ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
        h.a(this, 2131760331, 2131755906, new VoipCSMainUI.11(this));
        i = 1;
      }
      else if (com.tencent.mm.bi.e.aMj())
      {
        ad.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
        h.a(this, 2131760332, 2131755906, new VoipCSMainUI.12(this));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    if (eBZ()) {
      eBY();
    }
    AppMethodBeat.o(125459);
  }
  
  public void onDestroy()
  {
    int j = 2;
    AppMethodBeat.i(125467);
    ad.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.dbG != null) {
      this.dbG.abe();
    }
    Object localObject1 = new vr();
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvs == -1)
    {
      ((vr)localObject1).dKf.status = 3;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = this.Cwd;
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eBD();
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).Cbr == null) {
        break label1208;
      }
      localObject3 = com.tencent.mm.plugin.voip_cs.c.c.eBD();
      p.g(localObject3, "SubCoreVoipCS.getReporter()");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).CuP != 1) {
        break label1208;
      }
      localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).Cbr;
      if (localObject3 == null) {
        p.gfZ();
      }
    }
    label301:
    label1198:
    label1203:
    label1208:
    for (int i = ((com.tencent.mm.plugin.voip.model.c)localObject3).aNs();; i = 0)
    {
      float f = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).CuZ = ((int)(((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eBD();
      label213:
      label748:
      byte[] arrayOfByte;
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).oWf != null)
      {
        localObject3 = com.tencent.mm.plugin.voip_cs.c.c.eBD();
        p.g(localObject3, "SubCoreVoipCS.getReporter()");
        if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).CuP == 1)
        {
          localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).oWf;
          if (localObject3 == null) {
            p.gfZ();
          }
          i = ((com.tencent.mm.audio.b.c)localObject3).PS();
          ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).CfB = i;
          localObject2 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).oWf;
          if (localObject2 != null) {
            ((com.tencent.mm.audio.b.c)localObject2).PG();
          }
          localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).Cbr;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.voip.model.c)localObject1).euU();
          }
          this.Cvx.stopRing();
          if (this.Cwc != null)
          {
            localObject1 = this.Cwc;
            if (com.tencent.mm.plugin.voip_cs.c.c.eBD().dataType == 0)
            {
              if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq >= 2) {
                break label1158;
              }
              com.tencent.mm.plugin.voip_cs.c.c.eBD().dataType = 1;
            }
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).CjW.eAw();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).CjX.eAw();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).eBS();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).eBV();
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eBC();
            ad.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            g.aiU().b(823, (com.tencent.mm.al.f)localObject1);
            g.aiU().b(106, (com.tencent.mm.al.f)localObject1);
            g.aiU().b(818, (com.tencent.mm.al.f)localObject1);
            g.aiU().b(795, (com.tencent.mm.al.f)localObject1);
            g.aiU().b(285, (com.tencent.mm.al.f)localObject1);
            g.aiU().b(312, (com.tencent.mm.al.f)localObject1);
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvq = 3;
            if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvs != 823)
            {
              g.aiU().a(880, (com.tencent.mm.al.f)localObject1);
              if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvl != 0) {
                break label1168;
              }
              i = 1;
              label444:
              ad.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvr + ",inviteId：" + com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.uLv + ",csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.Cfg + ",roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.uLt + ",reason:" + i);
              localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.a(com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.uLv, com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.Cfg, com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.uLt, ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvr, i);
              g.aiU().a((com.tencent.mm.al.n)localObject2, 0);
            }
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvu.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvv.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvk = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CuG = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvl = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvm = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvn = null;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).uLC = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvo = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvq = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvr = "";
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvp = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvs = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvt = 999;
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eBB();
            ad.i("MicroMsg.VoipCSEngine", "now stop engine");
            ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).CvZ.tq(true);
            localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eBD();
            if ((bt.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uMR)) && (bt.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uMQ)))
            {
              localObject3 = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ;
              if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).CuN != 1) {
                break label1198;
              }
              i = 1;
              arrayOfByte = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).Cui;
              j = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).Cui.length;
              if (i == 0) {
                break label1203;
              }
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).getVoipcsChannelInfo(arrayOfByte, j, i);
        ad.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength) });
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uMR = new String(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).Cui, 0, ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength);
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uMQ = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.eBy();
        ad.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uMR });
        ad.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uMQ });
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eBC();
        g.aiU().a(312, (com.tencent.mm.al.f)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.e(com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.Cfg, com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.uLt);
        g.aiU().a((com.tencent.mm.al.n)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).CvZ.reset();
        r.ewQ().ewS();
        r.ewQ().a(null);
        this.Cwc = null;
        localObject1 = this.Cwd;
        com.tencent.mm.plugin.audio.b.a.a((com.tencent.mm.plugin.audio.b.a)localObject1, 0);
        ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).VJ("voipcs");
        aj.getContext().unregisterReceiver(this.BZH);
        g.ajB().b(this.Bno);
        if (this.Cwi != null) {
          this.Cwi.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if ((this.uJU != null) && (this.ljq != null))
        {
          this.uJU.listen(this.ljq, 0);
          this.ljq = null;
        }
        com.tencent.mm.plugin.voip_cs.a.a.unInit();
        this.Cwd = null;
        super.onDestroy();
        AppMethodBeat.o(125467);
        return;
        if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvs == 823)
        {
          ((vr)localObject1).dKf.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq <= 1)
        {
          ((vr)localObject1).dKf.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq < 2) {
          break;
        }
        ((vr)localObject1).dKf.status = 2;
        break;
        i = 0;
        break label213;
        com.tencent.mm.plugin.voip_cs.c.c.eBD().dataType = 3;
        break label301;
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvl == 2) {
          break label444;
        }
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).Cvl == 3)
        {
          i = 3;
          break label444;
        }
        i = 4;
        break label444;
        i = 0;
        break label748;
      }
    }
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(125469);
    if (this.Cwc != null)
    {
      ad.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(paramInt)));
      this.Cwc.Ve(paramInt);
    }
    AppMethodBeat.o(125469);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125461);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 25)
    {
      paramInt = this.Cwd.tN(this.Cvx.cae());
      this.Cwd.xm(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = this.Cwd.tN(this.Cvx.cae());
      this.Cwd.xl(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125461);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125464);
    super.onPause();
    if (!this.Cvx.cae()) {
      this.Cvx.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq == 1) || (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq == 2))
    {
      Object localObject = new Intent(aj.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.Cvr);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.scene);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.Cwe);
      ((Intent)localObject).putExtra("voipCSShowOther", this.Cwf);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.jna);
      ((Intent)localObject).putExtra("voipCSContext", this.Cwg);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.Cwh);
      localObject = PendingIntent.getActivity(aj.getContext(), 44, (Intent)localObject, 134217728);
      s.c localc = com.tencent.mm.br.a.bI(aj.getContext(), "reminder_channel_id").i(this.tickerText).i(System.currentTimeMillis()).f(this.title).g(this.dxD);
      localc.Hl = ((PendingIntent)localObject);
      localc.f(2, true);
      localObject = localc.build();
      ((Notification)localObject).icon = com.tencent.mm.br.a.dwe();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.Cwi != null) && (this.Cwi.fkZ())) {
        this.Cwi.az(5000L, 5000L);
      }
    }
    for (;;)
    {
      this.Cwc.eBS();
      this.Cwc.dtm = true;
      AppMethodBeat.o(125464);
      return;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
      if (this.Cwi != null) {
        this.Cwi.stopTimer();
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(125472);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      ad.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(125472);
      return;
    }
    ad.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(125472);
      return;
    case 82: 
      if (paramArrayOfInt[0] == 0)
      {
        ad.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
          eBY();
        }
        AppMethodBeat.o(125472);
        return;
      }
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new VoipCSMainUI.4(this), new VoipCSMainUI.5(this));
      AppMethodBeat.o(125472);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      eBY();
      AppMethodBeat.o(125472);
      return;
    }
    if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
    for (paramInt = 2131761860;; paramInt = 2131761871)
    {
      h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new VoipCSMainUI.6(this), new VoipCSMainUI.7(this));
      break;
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(125465);
    ad.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
    super.onRestart();
    if ((eBZ()) && (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq <= 1)) {
      eBY();
    }
    if (this.Cwc != null) {
      this.Cwc.dtm = false;
    }
    AppMethodBeat.o(125465);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125463);
    ad.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.Cwc != null)
    {
      this.Cwc.dtm = false;
      if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq > 1)
      {
        eBY();
        if ((this.Cwf != null) && (this.Cwf.equals("1"))) {
          this.Cwc.eBU();
        }
      }
    }
    if (this.Cwi != null) {
      this.Cwi.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
    AppMethodBeat.o(125463);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(125466);
    super.onStop();
    AppMethodBeat.o(125466);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI
 * JD-Core Version:    0.7.0.1
 */