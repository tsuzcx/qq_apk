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
import com.tencent.mm.g.a.uy;
import com.tencent.mm.model.aq;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.c.b.a.a;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.k;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.c.b, a.a
{
  private BroadcastReceiver AAI;
  private com.tencent.mm.plugin.voip_cs.c.a.b AVU;
  private com.tencent.mm.plugin.voip_cs.a.a AVV;
  public String AVW;
  public String AVX;
  public String AVY;
  public boolean AVZ;
  public String AVj;
  private com.tencent.mm.plugin.voip_cs.c.a.a AVp;
  private au AWa;
  private String appId;
  private com.tencent.mm.compatible.util.b cQq;
  public String dlQ;
  private ao gox;
  public String iTS;
  PhoneStateListener kMN;
  public String scene;
  private TelephonyManager tHh;
  public CharSequence tickerText;
  public CharSequence title;
  public String type;
  private com.tencent.mm.network.n zVK;
  
  public VoipCSMainUI()
  {
    AppMethodBeat.i(125458);
    this.AVj = "";
    this.appId = "";
    this.iTS = "";
    this.AVW = "";
    this.AVX = "";
    this.AVY = "";
    this.scene = "";
    this.type = "";
    this.AVZ = false;
    this.dlQ = ai.getContext().getString(2131764837);
    this.tickerText = ai.getContext().getString(2131764837);
    this.title = ai.getContext().getString(2131764831);
    this.AWa = new au(Looper.getMainLooper(), new VoipCSMainUI.16(this), true);
    this.AAI = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(205744);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)ai.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          ac.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
          VoipCSMainUI.c(VoipCSMainUI.this).dhO = false;
          AppMethodBeat.o(205744);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          ac.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
          VoipCSMainUI.c(VoipCSMainUI.this).dhO = false;
          if ((!VoipCSMainUI.d(VoipCSMainUI.this).bVB()) && (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi == 2))
          {
            VoipCSMainUI.d(VoipCSMainUI.this).enN();
            AppMethodBeat.o(205744);
          }
        }
        else if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          ac.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
          VoipCSMainUI.c(VoipCSMainUI.this).dhO = true;
          if (!VoipCSMainUI.d(VoipCSMainUI.this).bVB()) {
            VoipCSMainUI.d(VoipCSMainUI.this).stopRing();
          }
        }
        AppMethodBeat.o(205744);
      }
    };
    this.kMN = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(205745);
        ac.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
        if (paramAnonymousInt == 2)
        {
          ac.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
          com.tencent.mm.plugin.voip_cs.c.c.enE().AUC = 4;
          VoipCSMainUI.this.Ti(7);
        }
        AppMethodBeat.o(205745);
      }
    };
    this.zVK = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(205748);
        ac.d("MicroMsg.voipcs.VoipCSMainUI", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        com.tencent.mm.plugin.voip_cs.c.a locala;
        if ((com.tencent.mm.plugin.voip_cs.c.c.enD().AVi == 2) && ((paramAnonymousInt == 4) || (paramAnonymousInt == 6)))
        {
          localObject = com.tencent.mm.plugin.voip_cs.c.c.enD();
          locala = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR;
          if (((com.tencent.mm.plugin.voip_cs.c.e)localObject).ABU == 0) {
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject).ABU = locala.AGe;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext());
          if (paramAnonymousInt != ((com.tencent.mm.plugin.voip_cs.c.e)localObject).ABU) {
            ac.i("MicroMsg.voipcs.VoipCSService", "steve: onVoipLocalNetTypeChange: local network type change from " + ((com.tencent.mm.plugin.voip_cs.c.e)localObject).ABU + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locala.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            ac.i("MicroMsg.voipcs.VoipCSService", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locala.tIN + ", roomkey=" + locala.tIG + "]");
          }
          doo localdoo = new doo();
          localdoo.FWj = 3;
          localdoo.FWk = new com.tencent.mm.bw.b(arrayOfByte, 0, 1);
          locala.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.voipcs.VoipCSService", "onVoipLocalNetTypeChange Error");
          }
        }
        ((com.tencent.mm.plugin.voip_cs.c.e)localObject).ABU = paramAnonymousInt;
        Object localObject = com.tencent.mm.plugin.voip_cs.c.c.enD();
        ac.i("MicroMsg.voipcs.VoipCSService", "now doRedirect+,csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.AGg + "roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.tIG);
        com.tencent.mm.kernel.g.agi().a(285, (com.tencent.mm.ak.g)localObject);
        localObject = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR;
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.d(((v2protocal)localObject).AGg, ((v2protocal)localObject).tIG);
        com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
        AppMethodBeat.o(205748);
      }
    };
    AppMethodBeat.o(125458);
  }
  
  private void enZ()
  {
    AppMethodBeat.i(125460);
    if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi <= 0)
    {
      this.AVU.enO();
      this.AVU.enP();
      com.tencent.mm.plugin.voip_cs.c.c.enC().init();
      com.tencent.mm.plugin.voip_cs.c.c.enD().aG(this.AVj, this.appId, this.AVY);
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi < 2) {
      this.AVp.enN();
    }
    this.AVU.enS();
    AppMethodBeat.o(125460);
  }
  
  private boolean eoa()
  {
    AppMethodBeat.i(125471);
    if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", ""))
    {
      ac.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "");
    ac.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this });
    if (!bool)
    {
      ac.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
      AppMethodBeat.o(125471);
      return false;
    }
    AppMethodBeat.o(125471);
    return true;
  }
  
  public final void Ti(int paramInt)
  {
    AppMethodBeat.i(125468);
    ac.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.c.c.enD().AVi);
    if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi == 0)
    {
      finish();
      AppMethodBeat.o(125468);
      return;
    }
    if (this.AVU != null) {
      this.AVU.Tl(paramInt);
    }
    AppMethodBeat.o(125468);
  }
  
  public final void cTS()
  {
    Object localObject2 = null;
    AppMethodBeat.i(125473);
    this.AVU.cTS();
    this.AVV.Ms();
    Object localObject1 = this.AVV;
    if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).osJ != null)
    {
      localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).osJ;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((com.tencent.mm.audio.b.c)localObject1).Og());
        com.tencent.mm.plugin.voip_cs.c.c.enE().AUH = 1;
        if (!k.g(localObject1, Boolean.TRUE)) {
          break label230;
        }
      }
    }
    com.tencent.mm.plugin.voip_cs.a.a locala;
    label230:
    for (int i = 1;; i = -1)
    {
      com.tencent.mm.plugin.voip_cs.c.c.enE().AVa = i;
      locala = this.AVV;
      if (locala.ACs != null) {
        break label235;
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.enC();
      k.g(localObject1, "SubCoreVoipCS.getVoipCSEngine()");
      ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).AVR.AGw = Math.abs(1);
      this.AVp.stopRing();
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.enE();
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).AUV != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).AUK = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).AUV);
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.enE();
      ac.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).AUY == 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).AUY = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.c.c.enE();
      ac.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject1).AUX != 0) {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).AUM = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.c.d)localObject1).AUX);
      }
      AppMethodBeat.o(125473);
      return;
      localObject1 = null;
      break;
    }
    label235:
    com.tencent.mm.plugin.voip.model.c localc = locala.ACs;
    localObject1 = localObject2;
    if (localc != null) {
      localObject1 = Integer.valueOf(localc.ehg());
    }
    localObject2 = locala.ACs;
    if (localObject2 != null) {}
    for (i = ((com.tencent.mm.plugin.voip.model.c)localObject2).ehg();; i = 0)
    {
      if (i <= 0)
      {
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.enC();
        k.g(localObject2, "SubCoreVoipCS.getVoipCSEngine()");
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject2).AVR.AGw = Math.abs(1);
      }
      if (localObject1 == null) {
        break;
      }
      ((Integer)localObject1).intValue();
      break;
    }
  }
  
  public final void enY()
  {
    AppMethodBeat.i(125474);
    ac.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.AVU.Tl(5);
    AppMethodBeat.o(125474);
  }
  
  public int getLayoutId()
  {
    return 2131495878;
  }
  
  public final void jU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125470);
    com.tencent.mm.plugin.voip_cs.c.a.b localb = this.AVU;
    if ((localb.AVH.equals("")) && (bs.isNullOrNil(paramString2))) {
      if (localb.AVq.AVZ) {
        localb.fuZ.setText(2131764818);
      }
    }
    while ((localb.AVG.equals("")) && (bs.isNullOrNil(paramString1)) && ((localb.AVq.iTS == null) || (localb.AVq.iTS.equals(""))))
    {
      localb.AVw.setImageResource(2131231875);
      AppMethodBeat.o(125470);
      return;
      localb.fuZ.setText(2131764817);
      continue;
      localb.setNickName(paramString2);
    }
    SharedPreferences localSharedPreferences = ai.eUY();
    if ((!bs.isNullOrNil(paramString1)) && (!localb.AVG.equals(paramString1)))
    {
      localb.ayF(paramString1);
      localSharedPreferences.edit().putString(localb.enQ(), paramString1).commit();
    }
    if ((!bs.isNullOrNil(paramString2)) && (!localb.AVH.equals(paramString2)))
    {
      localb.setNickName(paramString2);
      localSharedPreferences.edit().putString(localb.enR(), paramString2).commit();
    }
    AppMethodBeat.o(125470);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125459);
    ac.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    hideTitleView();
    this.AVj = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.scene = bs.nullAsNil(getIntent().getStringExtra("voipCSScene"));
    this.type = bs.nullAsNil(getIntent().getStringExtra("voipCSType"));
    this.AVW = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.AVX = getIntent().getStringExtra("voipCSShowOther");
    this.iTS = getIntent().getStringExtra("voipCSAvatarUrl");
    this.AVY = getIntent().getStringExtra("voipCSContext");
    this.AVZ = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.gox = new ao();
    paramBundle = com.tencent.mm.plugin.voip_cs.c.c.enE();
    ac.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.dataType = 0;
    paramBundle.AUm = 0;
    paramBundle.AUn = 0;
    paramBundle.AUo = 0;
    paramBundle.videoFps = 0;
    paramBundle.AUp = 0;
    paramBundle.AUq = 0;
    paramBundle.AUr = 0;
    paramBundle.AUs = 0;
    paramBundle.AUt = 0;
    paramBundle.AUu = 0;
    paramBundle.networkType = 0;
    paramBundle.AUv = 0;
    paramBundle.AUw = com.tencent.mm.plugin.voip_cs.c.d.AUj;
    paramBundle.goi = 0;
    paramBundle.roomId = 0L;
    paramBundle.tIG = 0L;
    paramBundle.AUx = "";
    paramBundle.AGe = 0;
    paramBundle.AUA = 0;
    paramBundle.AUB = 0;
    paramBundle.AUC = 0;
    paramBundle.AGA = 0;
    paramBundle.AGz = 0;
    paramBundle.AUD = 0;
    paramBundle.AUE = 0;
    paramBundle.AUF = 0;
    paramBundle.AUG = 0;
    paramBundle.AUH = 0;
    paramBundle.AUI = 0;
    paramBundle.AUJ = 0L;
    paramBundle.AUK = 0;
    paramBundle.AUL = 0L;
    paramBundle.AUM = 0L;
    paramBundle.AUN = 0L;
    paramBundle.tJU = 0L;
    paramBundle.AUO = 0;
    paramBundle.AUP = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.AIe = 0;
    paramBundle.AGB = 0;
    paramBundle.AUQ = 0;
    paramBundle.AUR = 0;
    paramBundle.tKe = "";
    paramBundle.tKd = "";
    paramBundle.AUV = 0;
    paramBundle.AUW = 0;
    paramBundle.AUX = 0;
    paramBundle.AUY = 0;
    paramBundle.AUZ = 0;
    this.tHh = ((TelephonyManager)ai.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.c.c.enD().AVj = this.AVj;
    this.AVU = new com.tencent.mm.plugin.voip_cs.c.a.b(this);
    this.AVV = new com.tencent.mm.plugin.voip_cs.a.a();
    this.cQq = new com.tencent.mm.compatible.util.b(ai.getContext());
    this.AVp = com.tencent.mm.plugin.voip_cs.c.a.a.enL();
    com.tencent.mm.plugin.voip_cs.c.c.enC().AVS = this;
    com.tencent.mm.plugin.voip_cs.c.c.enD().AVb = this;
    if ((com.tencent.mm.plugin.voip_cs.c.c.enD().AVi == 0) || (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi == 3)) {
      com.tencent.mm.plugin.voip_cs.c.c.enD().AVi = 0;
    }
    com.tencent.mm.booter.a.Uc().Ue();
    this.cQq.requestFocus();
    this.AVV.Ms();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    ai.getContext().registerReceiver(this.AAI, paramBundle);
    com.tencent.mm.kernel.g.agQ().a(this.zVK);
    if (this.AVZ) {
      if (this.scene.equals("1")) {
        if (this.type.equals("video"))
        {
          this.title = ai.getContext().getString(2131764829);
          this.tickerText = ai.getContext().getString(2131764833);
          this.dlQ = ai.getContext().getString(2131764833);
          i = this.tHh.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1134;
          }
          ac.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          h.a(this, 2131764843, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125440);
              paramAnonymousDialogInterface.dismiss();
              VoipCSMainUI.this.Ti(0);
              AppMethodBeat.o(125440);
            }
          });
        }
      }
    }
    label1134:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label1139;
      }
      ac.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
      AppMethodBeat.o(125459);
      return;
      this.title = ai.getContext().getString(2131764830);
      this.tickerText = ai.getContext().getString(2131764834);
      this.dlQ = ai.getContext().getString(2131764834);
      break;
      if (this.type.equals("video"))
      {
        this.title = ai.getContext().getString(2131764831);
        this.tickerText = ai.getContext().getString(2131764835);
        this.dlQ = ai.getContext().getString(2131764835);
        break;
      }
      this.title = ai.getContext().getString(2131764830);
      this.tickerText = ai.getContext().getString(2131764834);
      this.dlQ = ai.getContext().getString(2131764834);
      break;
      if (this.scene.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.title = ai.getContext().getString(2131764829);
          this.tickerText = ai.getContext().getString(2131764833);
          this.dlQ = ai.getContext().getString(2131764833);
          break;
        }
        this.title = ai.getContext().getString(2131764830);
        this.tickerText = ai.getContext().getString(2131764837);
        this.dlQ = ai.getContext().getString(2131764837);
        break;
      }
      if (this.type.equals("video"))
      {
        this.title = ai.getContext().getString(2131764831);
        this.tickerText = ai.getContext().getString(2131764837);
        this.dlQ = ai.getContext().getString(2131764837);
        break;
      }
      this.title = ai.getContext().getString(2131764830);
      this.tickerText = ai.getContext().getString(2131764836);
      this.dlQ = ai.getContext().getString(2131764836);
      break;
    }
    label1139:
    this.tHh.listen(this.kMN, 32);
    if (!ax.isNetworkConnected(this))
    {
      ac.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
      h.a(this, 2131764839, 2131764899, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125454);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.Ti(9);
          AppMethodBeat.o(125454);
        }
      });
      i = 0;
    }
    while (i == 0)
    {
      ac.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
      AppMethodBeat.o(125459);
      return;
      if ((ax.isWifi(this)) || (s.ejj()))
      {
        i = 1;
      }
      else
      {
        ac.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
        h.a(this, 2131764840, 2131764899, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125455);
            ac.i("MicroMsg.voipcs.VoipCSMainUI", " start voip by user choose continue call  in not wifi network!");
            s.eji();
            if (VoipCSMainUI.a(VoipCSMainUI.this)) {
              VoipCSMainUI.b(VoipCSMainUI.this);
            }
            AppMethodBeat.o(125455);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125456);
            ac.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.Ti(8);
            AppMethodBeat.o(125456);
          }
        });
        i = 0;
      }
    }
    if (l.isVoipStarted())
    {
      ac.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
      h.a(this, 2131760336, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125450);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.Ti(0);
          AppMethodBeat.o(125450);
        }
      });
      i = 1;
    }
    while (i != 0)
    {
      ac.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
      AppMethodBeat.o(125459);
      return;
      if (l.emj())
      {
        ac.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
        h.a(this, 2131760337, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125451);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.Ti(0);
            AppMethodBeat.o(125451);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.r.a.aaZ())
      {
        ac.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
        h.a(this, 2131760331, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125452);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.Ti(0);
            AppMethodBeat.o(125452);
          }
        });
        i = 1;
      }
      else if (com.tencent.mm.bh.e.aIZ())
      {
        ac.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
        h.a(this, 2131760332, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(125453);
            paramAnonymousDialogInterface.dismiss();
            VoipCSMainUI.this.Ti(0);
            AppMethodBeat.o(125453);
          }
        });
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    if (eoa()) {
      enZ();
    }
    AppMethodBeat.o(125459);
  }
  
  public void onDestroy()
  {
    int j = 2;
    AppMethodBeat.i(125467);
    ac.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.cQq != null) {
      this.cQq.YC();
    }
    Object localObject1 = new uy();
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVk == -1)
    {
      ((uy)localObject1).dxS.status = 3;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = this.AVV;
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.enE();
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).ACs == null) {
        break label1208;
      }
      localObject3 = com.tencent.mm.plugin.voip_cs.c.c.enE();
      k.g(localObject3, "SubCoreVoipCS.getReporter()");
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUH != 1) {
        break label1208;
      }
      localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).ACs;
      if (localObject3 == null) {
        k.fOy();
      }
    }
    label301:
    label1198:
    label1203:
    label1208:
    for (int i = ((com.tencent.mm.plugin.voip.model.c)localObject3).aKj();; i = 0)
    {
      float f = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUR = ((int)(((com.tencent.mm.plugin.voip_cs.a.a)localObject1).getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.enE();
      label213:
      label748:
      byte[] arrayOfByte;
      if (((com.tencent.mm.plugin.voip_cs.a.a)localObject1).osJ != null)
      {
        localObject3 = com.tencent.mm.plugin.voip_cs.c.c.enE();
        k.g(localObject3, "SubCoreVoipCS.getReporter()");
        if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUH == 1)
        {
          localObject3 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).osJ;
          if (localObject3 == null) {
            k.fOy();
          }
          i = ((com.tencent.mm.audio.b.c)localObject3).Oj();
          ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AGB = i;
          localObject2 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).osJ;
          if (localObject2 != null) {
            ((com.tencent.mm.audio.b.c)localObject2).NX();
          }
          localObject1 = ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).ACs;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.voip.model.c)localObject1).ehi();
          }
          this.AVp.stopRing();
          if (this.AVU != null)
          {
            localObject1 = this.AVU;
            if (com.tencent.mm.plugin.voip_cs.c.c.enE().dataType == 0)
            {
              if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi >= 2) {
                break label1158;
              }
              com.tencent.mm.plugin.voip_cs.c.c.enE().dataType = 1;
            }
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).AKU.emA();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).AKV.emA();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).enT();
            ((com.tencent.mm.plugin.voip_cs.c.a.b)localObject1).enW();
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.enD();
            ac.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            com.tencent.mm.kernel.g.agi().b(823, (com.tencent.mm.ak.g)localObject1);
            com.tencent.mm.kernel.g.agi().b(106, (com.tencent.mm.ak.g)localObject1);
            com.tencent.mm.kernel.g.agi().b(818, (com.tencent.mm.ak.g)localObject1);
            com.tencent.mm.kernel.g.agi().b(795, (com.tencent.mm.ak.g)localObject1);
            com.tencent.mm.kernel.g.agi().b(285, (com.tencent.mm.ak.g)localObject1);
            com.tencent.mm.kernel.g.agi().b(312, (com.tencent.mm.ak.g)localObject1);
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVi = 3;
            if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVk != 823)
            {
              com.tencent.mm.kernel.g.agi().a(880, (com.tencent.mm.ak.g)localObject1);
              if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVd != 0) {
                break label1168;
              }
              i = 1;
              label444:
              ac.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVj + ",inviteId：" + com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.tII + ",csroomId:" + com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.AGg + ",roomkey:" + com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.tIG + ",reason:" + i);
              localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.a(com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.tII, com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.AGg, com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.tIG, ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVj, i);
              com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject2, 0);
            }
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVm.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVn.stopTimer();
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVc = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AUy = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVd = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVe = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVf = null;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).tIP = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVg = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVi = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVj = "";
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVh = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVk = 0;
            ((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVl = 999;
            localObject1 = com.tencent.mm.plugin.voip_cs.c.c.enC();
            ac.i("MicroMsg.VoipCSEngine", "now stop engine");
            ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).AVR.sH(true);
            localObject2 = com.tencent.mm.plugin.voip_cs.c.c.enE();
            if ((bs.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).tKe)) && (bs.isNullOrNil(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).tKd)))
            {
              localObject3 = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR;
              if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUF != 1) {
                break label1198;
              }
              i = 1;
              arrayOfByte = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).AUa;
              j = ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).AUa.length;
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
        ac.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength) });
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).tKe = new String(((com.tencent.mm.plugin.voip_cs.c.a)localObject3).AUa, 0, ((com.tencent.mm.plugin.voip_cs.c.a)localObject3).field_voipcsChannelInfoLength);
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).tKd = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.enz();
        ac.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).tKe });
        ac.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).tKd });
        localObject2 = com.tencent.mm.plugin.voip_cs.c.c.enD();
        com.tencent.mm.kernel.g.agi().a(312, (com.tencent.mm.ak.g)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.c.c.e(com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.AGg, com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.tIG);
        com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.c.b.a)localObject1).AVR.reset();
        r.ejf().ejh();
        r.ejf().a(null);
        this.AVU = null;
        localObject1 = this.AVV;
        com.tencent.mm.plugin.audio.b.a.a((com.tencent.mm.plugin.audio.b.a)localObject1, 0);
        ((com.tencent.mm.plugin.voip_cs.a.a)localObject1).Sl("voipcs");
        ai.getContext().unregisterReceiver(this.AAI);
        com.tencent.mm.kernel.g.agQ().b(this.zVK);
        if (this.AWa != null) {
          this.AWa.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if ((this.tHh != null) && (this.kMN != null))
        {
          this.tHh.listen(this.kMN, 0);
          this.kMN = null;
        }
        com.tencent.mm.plugin.voip_cs.a.a.unInit();
        this.AVV = null;
        super.onDestroy();
        AppMethodBeat.o(125467);
        return;
        if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVk == 823)
        {
          ((uy)localObject1).dxS.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi <= 1)
        {
          ((uy)localObject1).dxS.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi < 2) {
          break;
        }
        ((uy)localObject1).dxS.status = 2;
        break;
        i = 0;
        break label213;
        com.tencent.mm.plugin.voip_cs.c.c.enE().dataType = 3;
        break label301;
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVd == 2) {
          break label444;
        }
        if (((com.tencent.mm.plugin.voip_cs.c.e)localObject1).AVd == 3)
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
    if (this.AVU != null)
    {
      ac.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:".concat(String.valueOf(paramInt)));
      this.AVU.Tl(paramInt);
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
      paramInt = this.AVV.td(this.AVp.bVB());
      this.AVV.wG(paramInt);
      AppMethodBeat.o(125461);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = this.AVV.td(this.AVp.bVB());
      this.AVV.wF(paramInt);
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
    if (!this.AVp.bVB()) {
      this.AVp.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.c.c.enD().AVi == 1) || (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi == 2))
    {
      Object localObject = new Intent(ai.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.AVj);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.scene);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.AVW);
      ((Intent)localObject).putExtra("voipCSShowOther", this.AVX);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.iTS);
      ((Intent)localObject).putExtra("voipCSContext", this.AVY);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.AVZ);
      localObject = PendingIntent.getActivity(ai.getContext(), 44, (Intent)localObject, 134217728);
      s.c localc = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i(this.tickerText).i(System.currentTimeMillis()).f(this.title).g(this.dlQ);
      localc.Fu = ((PendingIntent)localObject);
      localc.f(2, true);
      localObject = localc.build();
      ((Notification)localObject).icon = com.tencent.mm.bq.a.dlN();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.AWa != null) && (this.AWa.eVs())) {
        this.AWa.au(5000L, 5000L);
      }
    }
    for (;;)
    {
      this.AVU.enT();
      this.AVU.dhO = true;
      AppMethodBeat.o(125464);
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
      if (this.AWa != null) {
        this.AWa.stopTimer();
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(125472);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      ac.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(125472);
      return;
    }
    ac.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(125472);
      return;
    case 82: 
      if (paramArrayOfInt[0] == 0)
      {
        ac.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
          enZ();
        }
        AppMethodBeat.o(125472);
        return;
      }
      h.a(this, getString(2131761871), getString(2131761885), getString(2131760598), getString(2131755691), false, new VoipCSMainUI.4(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(205747);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.Ti(2);
          AppMethodBeat.o(205747);
        }
      });
      AppMethodBeat.o(125472);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      enZ();
      AppMethodBeat.o(125472);
      return;
    }
    if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
    for (paramInt = 2131761860;; paramInt = 2131761871)
    {
      h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new VoipCSMainUI.6(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(125446);
          paramAnonymousDialogInterface.dismiss();
          VoipCSMainUI.this.Ti(3);
          AppMethodBeat.o(125446);
        }
      });
      break;
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(125465);
    ac.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
    super.onRestart();
    if ((eoa()) && (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi <= 1)) {
      enZ();
    }
    if (this.AVU != null) {
      this.AVU.dhO = false;
    }
    AppMethodBeat.o(125465);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125463);
    ac.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.AVU != null)
    {
      this.AVU.dhO = false;
      if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi > 1)
      {
        enZ();
        if ((this.AVX != null) && (this.AVX.equals("1"))) {
          this.AVU.enV();
        }
      }
    }
    if (this.AWa != null) {
      this.AWa.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
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