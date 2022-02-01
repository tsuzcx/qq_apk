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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.c.b.a.a;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.p;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.c.b, a.a
{
  private com.tencent.mm.network.n BEN;
  public String CMW;
  private com.tencent.mm.plugin.voip_cs.c.a.b CNH;
  private com.tencent.mm.plugin.voip_cs.a.a CNI;
  public String CNJ;
  public String CNK;
  public String CNL;
  public boolean CNM;
  private aw CNN;
  private com.tencent.mm.plugin.voip_cs.c.a.a CNc;
  private BroadcastReceiver Cri;
  private String appId;
  private com.tencent.mm.compatible.util.b dcI;
  public String dyI;
  private aq gKO;
  public String jpU;
  PhoneStateListener lnc;
  public String scene;
  public CharSequence tickerText;
  public CharSequence title;
  public String type;
  private TelephonyManager uVH;
  
  public VoipCSMainUI()
  {
    AppMethodBeat.i(125458);
    this.CMW = "";
    this.appId = "";
    this.jpU = "";
    this.CNJ = "";
    this.CNK = "";
    this.CNL = "";
    this.scene = "";
    this.type = "";
    this.CNM = false;
    this.dyI = ak.getContext().getString(2131764837);
    this.tickerText = ak.getContext().getString(2131764837);
    this.title = ak.getContext().getString(2131764831);
    this.CNN = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125457);
        Object localObject = new Intent(ak.getContext(), VoipCSMainUI.class);
        localObject = PendingIntent.getActivity(ak.getContext(), 44, (Intent)localObject, 134217728);
        s.c localc = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(VoipCSMainUI.this.tickerText).f(VoipCSMainUI.this.title).g(VoipCSMainUI.this.dyI);
        localc.Hl = ((PendingIntent)localObject);
        localc.f(2, true);
        localObject = localc.build();
        ((Notification)localObject).icon = com.tencent.mm.bq.a.dzu();
        ((Notification)localObject).flags |= 0x20;
        ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
        AppMethodBeat.o(125457);
        return true;
      }
    }, true);
    this.Cri = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(193487);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)ak.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          ae.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
          VoipCSMainUI.c(VoipCSMainUI.this).dus = false;
          AppMethodBeat.o(193487);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          ae.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
          VoipCSMainUI.c(VoipCSMainUI.this).dus = false;
          if ((!VoipCSMainUI.d(VoipCSMainUI.this).cbt()) && (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV == 2))
          {
            VoipCSMainUI.d(VoipCSMainUI.this).eFu();
            AppMethodBeat.o(193487);
          }
        }
        else if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          ae.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
          VoipCSMainUI.c(VoipCSMainUI.this).dus = true;
          if (!VoipCSMainUI.d(VoipCSMainUI.this).cbt()) {
            VoipCSMainUI.d(VoipCSMainUI.this).stopRing();
          }
        }
        AppMethodBeat.o(193487);
      }
    };
    this.lnc = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(193488);
        ae.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
        if (paramAnonymousInt == 2)
        {
          ae.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
          com.tencent.mm.plugin.voip_cs.c.c.eFl().CMp = 4;
          VoipCSMainUI.this.VI(7);
        }
        AppMethodBeat.o(193488);
      }
    };
    this.BEN = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(193491);
        ae.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        com.tencent.mm.plugin.voip_cs.c.a locala;
        if ((com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV == 2) && ((paramAnonymousInt == 4) || (paramAnonymousInt == 6)))
        {
          localObject = com.tencent.mm.plugin.voip_cs.c.c.eFk();
          locala = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE;
          if (((com.tencent.mm.plugin.voip_cs.c.e)localObject).Csu == 0) {
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject).Csu = locala.CwF;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext());
          if (paramAnonymousInt != ((com.tencent.mm.plugin.voip_cs.c.e)localObject).Csu) {
            ae.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((com.tencent.mm.plugin.voip_cs.c.e)localObject).Csu + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locala.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            ae.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locala.uXn + ", roomkey=" + locala.uXg + "]");
          }
          dvc localdvc = new dvc();
          localdvc.IaM = 3;
          localdvc.IaN = new com.tencent.mm.bw.b(arrayOfByte, 0, 1);
          locala.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
          }
        }
        ((com.tencent.mm.plugin.voip_cs.c.e)localObject).Csu = paramAnonymousInt;
        Object localObject = com.tencent.mm.plugin.voip_cs.c.c.eFk();
        ae.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.CwH + "roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.uXg);
        g.ajj().a(285, (com.tencent.mm.ak.f)localObject);
        localObject = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE;
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.d(((v2protocal)localObject).CwH, ((v2protocal)localObject).uXg);
        g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
        AppMethodBeat.o(193491);
      }
    };
    AppMethodBeat.o(125458);
  }
  
  private void eFG()
  {
    AppMethodBeat.i(125460);
    if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV <= 0)
    {
      this.CNH.eFv();
      this.CNH.eFw();
      com.tencent.mm.plugin.voip_cs.c.c.eFj().init();
      com.tencent.mm.plugin.voip_cs.c.c.eFk().aN(this.CMW, this.appId, this.CNL);
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV < 2) {
      this.CNc.eFu();
    }
    this.CNH.eFz();
    AppMethodBeat.o(125460);
  }
  
  private boolean eFH()
  {
    AppMethodBeat.i(125471);
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", ""))
    {
      ae.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
    ae.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
    if (!bool)
    {
      ae.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    AppMethodBeat.o(125471);
    return true;
  }
  
  public final void VI(int paramInt)
  {
    AppMethodBeat.i(125468);
    ae.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV);
    if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV == 0)
    {
      finish();
      AppMethodBeat.o(125468);
      return;
    }
    if (this.CNH != null) {
      this.CNH.VL(paramInt);
    }
    AppMethodBeat.o(125468);
  }
  
  public final void dfV()
  {
    Object localObject2 = null;
    AppMethodBeat.i(125473);
    this.CNH.dfV();
    this.CNI.NZ();
    Object localObject1 = this.CNI;
    if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).pcI != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).pcI;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((com.tencent.mm.audio.b.c)localObject1).PO());
        com.tencent.mm.plugin.voip_cs.c.c.eFl().CMu = 1;
        if (!p.i(localObject1, Boolean.TRUE)) {
          break label230;
        }
      }
    }
    com.tencent.mm.plugin.voip_cs.a.a locala;
    label230:
    for (int i = 1;; i = -1)
    {
      com.tencent.mm.plugin.voip_cs.c.c.eFl().CMN = i;
      locala = this.CNI;
      if (locala.CsS != null) {
        break label235;
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eFj();
      p.g(localObject1, "SubCoreVoipCS.getVoipCSEngine()");
      ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).CNE.CwX = Math.abs(1);
      this.CNc.stopRing();
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eFl();
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CMI != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CMx = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CMI);
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eFl();
      ae.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CML == 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CML = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eFl();
      ae.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CMK != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CMz = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).CMK);
      }
      AppMethodBeat.o(125473);
      return;
      localObject1 = null;
      break;
    }
    label235:
    com.tencent.mm.plugin.voip.model.c localc = locala.CsS;
    localObject1 = localObject2;
    if (localc != null) {
      localObject1 = Integer.valueOf(localc.eyy());
    }
    localObject2 = locala.CsS;
    if (localObject2 != null) {}
    for (i = ((com.tencent.mm.plugin.voip.model.c)localObject2).eyy();; i = 0)
    {
      if (i <= 0)
      {
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eFj();
        p.g(localObject2, "SubCoreVoipCS.getVoipCSEngine()");
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject2).CNE.CwX = Math.abs(1);
      }
      if (localObject1 == null) {
        break;
      }
      ((Integer)localObject1).intValue();
      break;
    }
  }
  
  public final void eFF()
  {
    AppMethodBeat.i(125474);
    ae.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.CNH.VL(5);
    AppMethodBeat.o(125474);
  }
  
  public int getLayoutId()
  {
    return 2131495878;
  }
  
  public final void kv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125470);
    com.tencent.mm.plugin.voip_cs.c.a.b localb = this.CNH;
    if ((localb.CNu.equals("")) && (bu.isNullOrNil(paramString2))) {
      if (localb.CNd.CNM) {
        localb.fQm.setText(2131764818);
      }
    }
    while ((localb.CNt.equals("")) && (bu.isNullOrNil(paramString1)) && ((localb.CNd.jpU == null) || (localb.CNd.jpU.equals(""))))
    {
      localb.CNj.setImageResource(2131231875);
      AppMethodBeat.o(125470);
      return;
      localb.fQm.setText(2131764817);
      continue;
      localb.setNickName(paramString2);
    }
    SharedPreferences localSharedPreferences = ak.fox();
    if ((!bu.isNullOrNil(paramString1)) && (!localb.CNt.equals(paramString1)))
    {
      localb.aFg(paramString1);
      localSharedPreferences.edit().putString(localb.eFx(), paramString1).commit();
    }
    if ((!bu.isNullOrNil(paramString2)) && (!localb.CNu.equals(paramString2)))
    {
      localb.setNickName(paramString2);
      localSharedPreferences.edit().putString(localb.eFy(), paramString2).commit();
    }
    AppMethodBeat.o(125470);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125459);
    ae.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    hideTitleView();
    this.CMW = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.scene = bu.nullAsNil(getIntent().getStringExtra("voipCSScene"));
    this.type = bu.nullAsNil(getIntent().getStringExtra("voipCSType"));
    this.CNJ = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.CNK = getIntent().getStringExtra("voipCSShowOther");
    this.jpU = getIntent().getStringExtra("voipCSAvatarUrl");
    this.CNL = getIntent().getStringExtra("voipCSContext");
    this.CNM = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.gKO = new aq();
    paramBundle = com.tencent.mm.plugin.voip_cs.c.c.eFl();
    ae.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.dataType = 0;
    paramBundle.CLZ = 0;
    paramBundle.CMa = 0;
    paramBundle.CMb = 0;
    paramBundle.videoFps = 0;
    paramBundle.CMc = 0;
    paramBundle.CMd = 0;
    paramBundle.CMe = 0;
    paramBundle.CMf = 0;
    paramBundle.CMg = 0;
    paramBundle.CMh = 0;
    paramBundle.networkType = 0;
    paramBundle.CMi = 0;
    paramBundle.CMj = com.tencent.mm.plugin.voip_cs.c.d.CLW;
    paramBundle.gKA = 0;
    paramBundle.roomId = 0L;
    paramBundle.uXg = 0L;
    paramBundle.CMk = "";
    paramBundle.CwF = 0;
    paramBundle.CMn = 0;
    paramBundle.CMo = 0;
    paramBundle.CMp = 0;
    paramBundle.Cxb = 0;
    paramBundle.Cxa = 0;
    paramBundle.CMq = 0;
    paramBundle.CMr = 0;
    paramBundle.CMs = 0;
    paramBundle.CMt = 0;
    paramBundle.CMu = 0;
    paramBundle.CMv = 0;
    paramBundle.CMw = 0L;
    paramBundle.CMx = 0;
    paramBundle.CMy = 0L;
    paramBundle.CMz = 0L;
    paramBundle.CMA = 0L;
    paramBundle.uYu = 0L;
    paramBundle.CMB = 0;
    paramBundle.CMC = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.CyG = 0;
    paramBundle.Cxc = 0;
    paramBundle.CMD = 0;
    paramBundle.CME = 0;
    paramBundle.uYE = "";
    paramBundle.uYD = "";
    paramBundle.CMI = 0;
    paramBundle.CMJ = 0;
    paramBundle.CMK = 0;
    paramBundle.CML = 0;
    paramBundle.CMM = 0;
    this.uVH = ((TelephonyManager)ak.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.c.c.eFk().CMW = this.CMW;
    this.CNH = new com.tencent.mm.plugin.voip_cs.c.a.b(this);
    this.CNI = new com.tencent.mm.plugin.voip_cs.a.a();
    this.dcI = new com.tencent.mm.compatible.util.b(ak.getContext());
    this.CNc = com.tencent.mm.plugin.voip_cs.c.a.a.eFs();
    com.tencent.mm.plugin.voip_cs.c.c.eFj().CNF = this;
    com.tencent.mm.plugin.voip_cs.c.c.eFk().CMO = this;
    if ((com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV == 0) || (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV == 3)) {
      com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV = 0;
    }
    com.tencent.mm.booter.a.WB().WD();
    this.dcI.requestFocus();
    this.CNI.NZ();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    ak.getContext().registerReceiver(this.Cri, paramBundle);
    g.ajQ().a(this.BEN);
    if (this.CNM) {
      if (this.scene.equals("1")) {
        if (this.type.equals("video"))
        {
          this.title = ak.getContext().getString(2131764829);
          this.tickerText = ak.getContext().getString(2131764833);
          this.dyI = ak.getContext().getString(2131764833);
          i = this.uVH.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1134;
          }
          ae.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
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
      ae.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
      AppMethodBeat.o(125459);
      return;
      this.title = ak.getContext().getString(2131764830);
      this.tickerText = ak.getContext().getString(2131764834);
      this.dyI = ak.getContext().getString(2131764834);
      break;
      if (this.type.equals("video"))
      {
        this.title = ak.getContext().getString(2131764831);
        this.tickerText = ak.getContext().getString(2131764835);
        this.dyI = ak.getContext().getString(2131764835);
        break;
      }
      this.title = ak.getContext().getString(2131764830);
      this.tickerText = ak.getContext().getString(2131764834);
      this.dyI = ak.getContext().getString(2131764834);
      break;
      if (this.scene.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.title = ak.getContext().getString(2131764829);
          this.tickerText = ak.getContext().getString(2131764833);
          this.dyI = ak.getContext().getString(2131764833);
          break;
        }
        this.title = ak.getContext().getString(2131764830);
        this.tickerText = ak.getContext().getString(2131764837);
        this.dyI = ak.getContext().getString(2131764837);
        break;
      }
      if (this.type.equals("video"))
      {
        this.title = ak.getContext().getString(2131764831);
        this.tickerText = ak.getContext().getString(2131764837);
        this.dyI = ak.getContext().getString(2131764837);
        break;
      }
      this.title = ak.getContext().getString(2131764830);
      this.tickerText = ak.getContext().getString(2131764836);
      this.dyI = ak.getContext().getString(2131764836);
      break;
    }
    label1139:
    this.uVH.listen(this.lnc, 32);
    if (!az.isNetworkConnected(this))
    {
      ae.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
      h.a(this, 2131764839, 2131764899, new VoipCSMainUI.13(this));
      i = 0;
    }
    while (i == 0)
    {
      ae.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
      AppMethodBeat.o(125459);
      return;
      if ((az.isWifi(this)) || (s.eAB()))
      {
        i = 1;
      }
      else
      {
        ae.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
        h.a(this, 2131764840, 2131764899, new DialogInterface.OnClickListener()new VoipCSMainUI.15
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125455);
            ae.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
            s.eAA();
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
      ae.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
      h.a(this, 2131760336, 2131755906, new VoipCSMainUI.9(this));
      i = 1;
    }
    while (i != 0)
    {
      ae.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
      AppMethodBeat.o(125459);
      return;
      if (com.tencent.mm.plugin.voip.b.n.eDM())
      {
        ae.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
        h.a(this, 2131760337, 2131755906, new VoipCSMainUI.10(this));
        i = 1;
      }
      else if (com.tencent.mm.r.a.adO())
      {
        ae.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
        h.a(this, 2131760331, 2131755906, new VoipCSMainUI.11(this));
        i = 1;
      }
      else if (com.tencent.mm.bh.e.aMG())
      {
        ae.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
        h.a(this, 2131760332, 2131755906, new VoipCSMainUI.12(this));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    if (eFH()) {
      eFG();
    }
    AppMethodBeat.o(125459);
  }
  
  public void onDestroy()
  {
    int j = 2;
    AppMethodBeat.i(125467);
    ae.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.dcI != null) {
      this.dcI.abn();
    }
    Object localObject1 = new vv();
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMX == -1)
    {
      ((vv)localObject1).dLu.status = 3;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = this.CNI;
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eFl();
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).CsS == null) {
        break label1208;
      }
      localObject3 = com.tencent.mm.plugin.voip_cs.c.c.eFl();
      p.g(localObject3, "SubCoreVoipCS.getReporter()");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).CMu != 1) {
        break label1208;
      }
      localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).CsS;
      if (localObject3 == null) {
        p.gkB();
      }
    }
    label301:
    label1198:
    label1203:
    label1208:
    for (int i = ((com.tencent.mm.plugin.voip.model.c)localObject3).aNQ();; i = 0)
    {
      float f = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).CME = ((int)(((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eFl();
      label213:
      label748:
      byte[] arrayOfByte;
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).pcI != null)
      {
        localObject3 = com.tencent.mm.plugin.voip_cs.c.c.eFl();
        p.g(localObject3, "SubCoreVoipCS.getReporter()");
        if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).CMu == 1)
        {
          localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).pcI;
          if (localObject3 == null) {
            p.gkB();
          }
          i = ((com.tencent.mm.audio.b.c)localObject3).PR();
          ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).Cxc = i;
          localObject2 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).pcI;
          if (localObject2 != null) {
            ((com.tencent.mm.audio.b.c)localObject2).PF();
          }
          localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).CsS;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.voip.model.c)localObject1).eyA();
          }
          this.CNc.stopRing();
          if (this.CNH != null)
          {
            localObject1 = this.CNH;
            if (com.tencent.mm.plugin.voip_cs.c.c.eFl().dataType == 0)
            {
              if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV >= 2) {
                break label1158;
              }
              com.tencent.mm.plugin.voip_cs.c.c.eFl().dataType = 1;
            }
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).CBA.eEe();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).CBB.eEe();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).eFA();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).eFD();
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eFk();
            ae.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            g.ajj().b(823, (com.tencent.mm.ak.f)localObject1);
            g.ajj().b(106, (com.tencent.mm.ak.f)localObject1);
            g.ajj().b(818, (com.tencent.mm.ak.f)localObject1);
            g.ajj().b(795, (com.tencent.mm.ak.f)localObject1);
            g.ajj().b(285, (com.tencent.mm.ak.f)localObject1);
            g.ajj().b(312, (com.tencent.mm.ak.f)localObject1);
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMV = 3;
            if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMX != 823)
            {
              g.ajj().a(880, (com.tencent.mm.ak.f)localObject1);
              if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMQ != 0) {
                break label1168;
              }
              i = 1;
              label444:
              ae.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMW + ",inviteId：" + com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.uXi + ",csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.CwH + ",roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.uXg + ",reason:" + i);
              localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.a(com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.uXi, com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.CwH, com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.uXg, ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMW, i);
              g.ajj().a((com.tencent.mm.ak.n)localObject2, 0);
            }
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMZ.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CNa.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMP = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMl = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMQ = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMR = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMS = null;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).uXp = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMT = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMV = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMW = "";
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMU = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMX = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMY = 999;
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.eFj();
            ae.i("MicroMsg.VoipCSEngine", "now stop engine");
            ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).CNE.tx(true);
            localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eFl();
            if ((bu.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uYE)) && (bu.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uYD)))
            {
              localObject3 = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE;
              if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).CMs != 1) {
                break label1198;
              }
              i = 1;
              arrayOfByte = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).CLM;
              j = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).CLM.length;
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
        ae.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength) });
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uYE = new String(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).CLM, 0, ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength);
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uYD = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.eFg();
        ae.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uYE });
        ae.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).uYD });
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.eFk();
        g.ajj().a(312, (com.tencent.mm.ak.f)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.e(com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.CwH, com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.uXg);
        g.ajj().a((com.tencent.mm.ak.n)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).CNE.reset();
        r.eAx().eAz();
        r.eAx().a(null);
        this.CNH = null;
        localObject1 = this.CNI;
        com.tencent.mm.plugin.audio.b.a.a((com.tencent.mm.plugin.audio.b.a)localObject1, 0);
        ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).Wv("voipcs");
        ak.getContext().unregisterReceiver(this.Cri);
        g.ajQ().b(this.BEN);
        if (this.CNN != null) {
          this.CNN.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if ((this.uVH != null) && (this.lnc != null))
        {
          this.uVH.listen(this.lnc, 0);
          this.lnc = null;
        }
        com.tencent.mm.plugin.voip_cs.a.a.unInit();
        this.CNI = null;
        super.onDestroy();
        AppMethodBeat.o(125467);
        return;
        if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMX == 823)
        {
          ((vv)localObject1).dLu.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV <= 1)
        {
          ((vv)localObject1).dLu.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV < 2) {
          break;
        }
        ((vv)localObject1).dLu.status = 2;
        break;
        i = 0;
        break label213;
        com.tencent.mm.plugin.voip_cs.c.c.eFl().dataType = 3;
        break label301;
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMQ == 2) {
          break label444;
        }
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).CMQ == 3)
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
    if (this.CNH != null)
    {
      ae.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(paramInt)));
      this.CNH.VL(paramInt);
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
      paramInt = this.CNI.tU(this.CNc.cbt());
      this.CNI.xr(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = this.CNI.tU(this.CNc.cbt());
      this.CNI.xq(paramInt);
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
    if (!this.CNc.cbt()) {
      this.CNc.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV == 1) || (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV == 2))
    {
      Object localObject = new Intent(ak.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.CMW);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.scene);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.CNJ);
      ((Intent)localObject).putExtra("voipCSShowOther", this.CNK);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.jpU);
      ((Intent)localObject).putExtra("voipCSContext", this.CNL);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.CNM);
      localObject = PendingIntent.getActivity(ak.getContext(), 44, (Intent)localObject, 134217728);
      s.c localc = com.tencent.mm.bq.a.bJ(ak.getContext(), "reminder_channel_id").i(this.tickerText).i(System.currentTimeMillis()).f(this.title).g(this.dyI);
      localc.Hl = ((PendingIntent)localObject);
      localc.f(2, true);
      localObject = localc.build();
      ((Notification)localObject).icon = com.tencent.mm.bq.a.dzu();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.CNN != null) && (this.CNN.foU())) {
        this.CNN.ay(5000L, 5000L);
      }
    }
    for (;;)
    {
      this.CNH.eFA();
      this.CNH.dus = true;
      AppMethodBeat.o(125464);
      return;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
      if (this.CNN != null) {
        this.CNN.stopTimer();
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(125472);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      ae.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(125472);
      return;
    }
    ae.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(125472);
      return;
    case 82: 
      if (paramArrayOfInt[0] == 0)
      {
        ae.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
          eFG();
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
      eFG();
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
    ae.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
    super.onRestart();
    if ((eFH()) && (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV <= 1)) {
      eFG();
    }
    if (this.CNH != null) {
      this.CNH.dus = false;
    }
    AppMethodBeat.o(125465);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125463);
    ae.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.CNH != null)
    {
      this.CNH.dus = false;
      if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV > 1)
      {
        eFG();
        if ((this.CNK != null) && (this.CNK.equals("1"))) {
          this.CNH.eFC();
        }
      }
    }
    if (this.CNN != null) {
      this.CNN.stopTimer();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI
 * JD-Core Version:    0.7.0.1
 */