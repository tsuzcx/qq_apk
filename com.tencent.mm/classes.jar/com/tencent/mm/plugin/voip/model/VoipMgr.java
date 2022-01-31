package com.tencent.mm.plugin.voip.model;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.a;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.video.j;
import com.tencent.mm.plugin.voip.video.j.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Map;
import java.util.Timer;

public final class VoipMgr
  implements SurfaceTexture.OnFrameAvailableListener, g.a, q.a, w, com.tencent.mm.plugin.voip.ui.c, f, j.a, SensorController.a
{
  static int ihF = 0;
  static int[] tyg = new int[2];
  com.tencent.mm.compatible.util.b cko;
  String eaX;
  ak iMP;
  private long mII;
  private boolean mIsMute;
  SurfaceTexture mSurfaceTexture;
  private int mUIType;
  SensorController mub;
  TelephonyManager nLF;
  PhoneStateListener nLG;
  com.tencent.mm.sdk.b.c nLH;
  private long nNQ;
  private boolean oHm;
  long twM;
  long twN;
  private boolean txA;
  private boolean txB;
  private int txC;
  private boolean txD;
  boolean txE;
  private com.tencent.mm.plugin.voip.widget.b txF;
  private boolean txG;
  private boolean txH;
  public String txI;
  private boolean txJ;
  boolean txK;
  public int txL;
  public int txM;
  private long txN;
  private boolean txO;
  private long txP;
  private long txQ;
  int txR;
  boolean txS;
  boolean txT;
  private int txU;
  private byte[] txV;
  private int txW;
  private boolean txX;
  public int txY;
  public int txZ;
  com.tencent.mm.plugin.voip.a.c txa;
  HeadsetPlugReceiver txb;
  volatile com.tencent.mm.plugin.voip.ui.b txc;
  private com.tencent.mm.plugin.voip.video.a txd;
  private CaptureView txe;
  private VoipMgr.a txf;
  private boolean txg;
  private boolean txh;
  private Object txi;
  ad txj;
  boolean txk;
  boolean txl;
  boolean txm;
  private int txn;
  private boolean txo;
  int txp;
  private long txq;
  private boolean txr;
  boolean txs;
  private boolean txt;
  private boolean txu;
  private int txv;
  private int txw;
  j txx;
  private ap txy;
  private al txz;
  int tya;
  boolean tyb;
  VoipMgr.NetChangedBroadcastReceiver tyc;
  PhoneStateListener tyd;
  al tye;
  ak tyf;
  TelephonyManager tyh;
  private long tyi;
  private boolean tyj;
  BroadcastReceiver tyk;
  HeadsetPlugReceiver.a tyl;
  int tym;
  com.tencent.mm.sdk.b.c tyn;
  
  public VoipMgr()
  {
    AppMethodBeat.i(4485);
    this.txf = null;
    this.txg = false;
    this.txh = false;
    this.txi = new Object();
    this.txm = false;
    this.txn = 4096;
    this.txo = false;
    this.txp = 1;
    this.mIsMute = false;
    this.txq = -1L;
    this.txr = false;
    this.txs = false;
    this.txt = false;
    this.oHm = false;
    this.txu = false;
    this.txv = 0;
    this.txw = 0;
    this.txx = new j();
    this.txy = null;
    this.txA = false;
    this.txB = false;
    this.txC = 0;
    this.txD = false;
    this.txE = false;
    this.txG = false;
    this.txH = false;
    this.txI = null;
    this.txJ = true;
    this.txK = false;
    this.txL = -1;
    this.txM = 0;
    this.txN = -1L;
    this.txO = false;
    this.txP = 0L;
    this.txQ = -1L;
    this.twM = 0L;
    this.twN = 0L;
    this.txR = 0;
    this.txS = false;
    this.txT = false;
    this.txU = 0;
    this.txV = null;
    this.txW = 0;
    this.txX = true;
    this.txY = 0;
    this.txZ = 0;
    this.mSurfaceTexture = null;
    this.tya = 0;
    this.tyb = false;
    this.tye = new al("getSignalStrength");
    this.tyf = new ak(this.tye.oNc.getLooper());
    this.tyh = null;
    this.mII = 0L;
    this.tyi = 0L;
    this.tyj = false;
    this.tyk = new VoipMgr.1(this);
    this.nLH = new com.tencent.mm.sdk.b.c() {};
    this.tyl = new VoipMgr.16(this);
    this.tym = 0;
    this.nNQ = 0L;
    this.nLG = new VoipMgr.5(this);
    this.tyn = new VoipMgr.14(this);
    AppMethodBeat.o(4485);
  }
  
  private void Hr(int paramInt)
  {
    AppMethodBeat.i(4489);
    ab.b("MicroMsg.Voip.VoipMgr", "switchVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt) });
    this.txp = paramInt;
    if (this.txc != null) {
      this.txc.HF(this.txp);
    }
    AppMethodBeat.o(4489);
  }
  
  private void Ht(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(4509);
    ab.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
    if (true == cNi()) {
      this.txn = paramInt;
    }
    Object localObject = ah.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState))
    {
      localObject = ((Context)localObject).getString(2131304627, new Object[] { ha(bo.gz(this.txq)) });
      str2 = this.txj.field_username;
      if (!this.txl) {
        break label256;
      }
    }
    label256:
    for (String str1 = bi.yOc;; str1 = bi.yOb)
    {
      if (this.txk) {
        i = 1;
      }
      r.a(str2, str1, i, 6, (String)localObject);
      if ((!this.txk) || (com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState))) {
        break label264;
      }
      com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
      if ((this.txk) && (!com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState)))
      {
        ab.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.b.cLC().tyR.cOf();
      }
      ab.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.b.cLC().tyR.cOi();
      if (4096 != this.txn) {
        break label317;
      }
      oq(paramInt);
      cMY();
      AppMethodBeat.o(4509);
      return;
      if (this.txk)
      {
        localObject = ((Context)localObject).getString(2131304622);
        break;
      }
      localObject = ((Context)localObject).getString(2131304621);
      break;
    }
    label264:
    com.tencent.mm.sdk.g.d.post(new VoipMgr.20(this), "VoipMgr_play_end_sound");
    this.txg = true;
    this.txh = true;
    com.tencent.mm.plugin.voip.b.cLC().tyR.cOi();
    if (4096 == this.txn)
    {
      oq(paramInt);
      cMY();
    }
    label317:
    AppMethodBeat.o(4509);
  }
  
  private boolean Hu(int paramInt)
  {
    AppMethodBeat.i(4515);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(4515);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState)) || (this.txk)))
    {
      AppMethodBeat.o(4515);
      return true;
    }
    AppMethodBeat.o(4515);
    return false;
  }
  
  private static void Hv(int paramInt)
  {
    AppMethodBeat.i(4516);
    vy localvy = new vy();
    localvy.cNn.coO = paramInt;
    com.tencent.mm.sdk.b.a.ymk.l(localvy);
    AppMethodBeat.o(4516);
  }
  
  private void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(4491);
    ab.b("MicroMsg.Voip.VoipMgr", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.txr = paramBoolean1;
    this.txs = paramBoolean1;
    ab.i("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + com.tencent.mm.compatible.b.g.KC().KL());
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      bool = paramBoolean1;
      if (com.tencent.mm.compatible.b.g.KC().KH()) {
        bool = false;
      }
    }
    if (ac.erv.emD)
    {
      ac.erv.dump();
      if (ac.erv.emE > 0) {
        com.tencent.mm.plugin.voip.b.cLC().mJ(bool);
      }
    }
    if ((ac.erv.enh >= 0) || (ac.erv.eni >= 0)) {
      com.tencent.mm.plugin.voip.b.cLC().mJ(bool);
    }
    int i = com.tencent.mm.plugin.voip.b.cLC().tyR.cLL();
    com.tencent.mm.compatible.b.g.KC().b(bool, i, paramBoolean2);
    com.tencent.mm.plugin.voip.b.cLC().mP(bool);
    this.txt = bool;
    AppMethodBeat.o(4491);
  }
  
  private void cMH()
  {
    AppMethodBeat.i(4488);
    boolean bool2 = com.tencent.mm.compatible.b.g.KC().KN();
    boolean bool3 = this.txK;
    boolean bool4 = com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState);
    boolean bool5 = com.tencent.mm.plugin.voip.b.cLC().tyR.cOm();
    boolean bool6 = this.txs;
    boolean bool1;
    if (2 == this.mUIType)
    {
      bool1 = true;
      ab.i("MicroMsg.Voip.VoipMgr", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!this.txK)
      {
        if (!com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState)) {
          break label221;
        }
        if (com.tencent.mm.plugin.voip.b.cLC().tyR.cOm()) {
          break label190;
        }
        mR(false);
        this.txp = 2;
      }
    }
    for (;;)
    {
      Hr(this.txp);
      this.txK = true;
      com.tencent.mm.plugin.voip.b.cLC().jA(false);
      AppMethodBeat.o(4488);
      return;
      bool1 = false;
      break;
      label190:
      if (!bool2)
      {
        R(true, true);
        this.txp = 1;
      }
      else
      {
        mR(false);
        this.txp = 2;
        continue;
        label221:
        if (com.tencent.mm.plugin.voip.b.cLC().tyR.cOm()) {
          break label246;
        }
        mR(false);
        this.txp = 2;
      }
    }
    label246:
    if (((this.txs) || (2 == this.mUIType)) && (!bool2))
    {
      R(true, true);
      this.txp = 1;
    }
    for (;;)
    {
      this.txs = false;
      break;
      if (bool2) {
        this.txp = 3;
      } else {
        this.txp = 2;
      }
    }
  }
  
  private boolean cMW()
  {
    AppMethodBeat.i(4512);
    if (!this.txa.HT(4101))
    {
      AppMethodBeat.o(4512);
      return false;
    }
    oq(4101);
    Object localObject1;
    int j;
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    Object localObject2;
    if ((261 == this.txa.mState) || (7 == this.txa.mState))
    {
      com.tencent.mm.plugin.voip.b.cLC().Hk(1);
      localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
      long l = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa;
      j = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ;
      if (this.txk)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).e(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
        localh = com.tencent.mm.plugin.report.service.h.qsU;
        j = 11080;
        localObject2 = new Object[3];
        localObject2[0] = Integer.valueOf(2);
        localObject2[1] = Integer.valueOf(0);
        i = 2;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      int k = 0;
      for (;;)
      {
        localObject1[i] = Integer.valueOf(k);
        localh.e(j, (Object[])localObject2);
        do
        {
          com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMg();
          com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMh();
          this.txl = false;
          AppMethodBeat.o(4512);
          return true;
          i = 0;
          break;
        } while ((1 != this.txa.mState) && (3 != this.txa.mState));
        com.tencent.mm.plugin.voip.b.cLC().Hk(1);
        localh = com.tencent.mm.plugin.report.service.h.qsU;
        j = 11046;
        localObject1 = new Object[5];
        localObject1[0] = Integer.valueOf(1);
        localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa);
        localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ);
        localObject1[3] = Integer.valueOf(0);
        i = 4;
        if (!this.txk) {
          break label394;
        }
        k = 1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      label394:
      localObject2 = localObject1;
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private void cMY()
  {
    AppMethodBeat.i(4520);
    ab.d("MicroMsg.Voip.VoipMgr", "delayFinish");
    this.txI = null;
    if (this.iMP != null) {
      this.iMP.postDelayed(new VoipMgr.2(this), 500L);
    }
    AppMethodBeat.o(4520);
  }
  
  private void cNe()
  {
    AppMethodBeat.i(4533);
    if ((com.tencent.mm.compatible.util.d.fv(28)) && (this.txl) && (this.txd != null) && (!this.txd.bQT()) && (this.txc != null))
    {
      ab.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      this.txd.cPA();
      this.txc.cOP();
      int k = 320;
      int m = 240;
      int j = m;
      int i = k;
      if (this.txd == null)
      {
        j = m;
        i = k;
        if (com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState))
        {
          this.txe = new CaptureView(ah.getContext());
          j = m;
          i = k;
          if (v2protocal.tzX)
          {
            ab.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
            i = 640;
            j = 480;
          }
        }
      }
      this.txd = new com.tencent.mm.plugin.voip.video.a(i, j);
      this.txd.a(this, true);
      this.txd.a(this.txe);
      this.txd.cPz();
    }
    AppMethodBeat.o(4533);
  }
  
  private void cNg()
  {
    AppMethodBeat.i(4537);
    synchronized (this.txi)
    {
      com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
      cNh();
      com.tencent.mm.compatible.b.g.KC().setMode(0);
      if (this.cko != null) {
        this.cko.Mh();
      }
      AppMethodBeat.o(4537);
      return;
    }
  }
  
  private void cNh()
  {
    AppMethodBeat.i(4538);
    ab.a("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
    if (this.txd != null) {
      cNn();
    }
    try
    {
      this.txd.cPA();
      this.txd = null;
      AppMethodBeat.o(4538);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + localException.toString());
      }
    }
  }
  
  private boolean cNi()
  {
    AppMethodBeat.i(4541);
    if (com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = d(localSharedPreferences);
        AppMethodBeat.o(4541);
        return bool;
      }
    }
    AppMethodBeat.o(4541);
    return false;
  }
  
  private void cNj()
  {
    AppMethodBeat.i(4545);
    Context localContext = getContext();
    View localView = View.inflate(localContext, 2130970141, null);
    CheckBox localCheckBox = (CheckBox)localView.findViewById(2131826141);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(2131826140);
    if (1 == bo.getInt(com.tencent.mm.m.g.Nq().getValue("VOIPCallType"), 0)) {
      localTextView.setText(2131304610);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(localContext, false, localContext.getString(2131297087), localView, localContext.getString(2131297115), localContext.getString(2131297014), new VoipMgr.6(this), new VoipMgr.7(this, localCheckBox));
      AppMethodBeat.o(4545);
      return;
      localTextView.setText(2131304611);
    }
  }
  
  private void cNn()
  {
    AppMethodBeat.i(4551);
    if (this.txx != null) {
      this.txx.a(this);
    }
    if (this.txy != null)
    {
      ab.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
      this.txy.stopTimer();
    }
    if ((this.txz != null) && (this.txz.oNc.getLooper() != null))
    {
      ab.d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
      this.txz.oNc.getLooper().quit();
    }
    AppMethodBeat.o(4551);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(4542);
    String str = com.tencent.mm.m.g.Nq().getValue("VOIPShortcutAutoadd");
    ab.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bo.gz(this.txq) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        cNj();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(4542);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bo.gz(this.txq) > 15L))
    {
      e(paramSharedPreferences);
      AppMethodBeat.o(4542);
      return false;
    }
    AppMethodBeat.o(4542);
    return false;
  }
  
  private void e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(4543);
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
    localIntent2.addFlags(67108864);
    if (1 == bo.getInt(com.tencent.mm.m.g.Nq().getValue("VOIPCallType"), 0))
    {
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131296952));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2130840746));
      localIntent1.putExtra("shortcut_icon_resource_id", 2130840746);
    }
    for (;;)
    {
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      com.tencent.mm.plugin.base.model.b.p(getContext(), localIntent1);
      paramSharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
      AppMethodBeat.o(4543);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131296954));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2130840782));
      localIntent1.putExtra("shortcut_icon_resource_id", 2130840782);
    }
  }
  
  private static String ha(long paramLong)
  {
    AppMethodBeat.i(4535);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(4535);
    return str;
  }
  
  private void mR(boolean paramBoolean)
  {
    AppMethodBeat.i(4490);
    R(paramBoolean, this.txS);
    AppMethodBeat.o(4490);
  }
  
  private void mT(boolean paramBoolean)
  {
    AppMethodBeat.i(4505);
    if (this.txl)
    {
      ab.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      int j = 320;
      int i = 240;
      if (v2protocal.tzX)
      {
        ab.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
        j = 640;
        i = 480;
      }
      if (this.txd == null) {
        this.txd = new com.tencent.mm.plugin.voip.video.a(j, i);
      }
      if (this.txd.a(this, paramBoolean) != 1) {
        break label175;
      }
    }
    label175:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.txX = paramBoolean;
      if ((this.txX) && (this.txe != null))
      {
        this.txd.a(this.txe);
        com.tencent.mm.plugin.voip.b.cLC().Hz(this.txd.cPD());
        if (this.iMP != null) {
          this.iMP.postDelayed(new VoipMgr.19(this), 50L);
        }
      }
      AppMethodBeat.o(4505);
      return;
    }
  }
  
  private void oq(int paramInt)
  {
    AppMethodBeat.i(4514);
    ab.a("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.HN(paramInt), com.tencent.mm.plugin.voip.a.b.HN(this.txa.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState)))
    {
      cNh();
      this.txl = false;
    }
    if ((Hu(paramInt)) && (1 == this.mUIType) && (1 == this.txp))
    {
      this.txH = true;
      mR(false);
      Hr(2);
    }
    this.txa.HU(paramInt);
    if (this.iMP != null) {
      this.iMP.post(new VoipMgr.21(this, paramInt));
    }
    switch (this.txa.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(4514);
      return;
      Hv(5);
      AppMethodBeat.o(4514);
      return;
      Hv(6);
    }
  }
  
  final void Hs(int paramInt)
  {
    AppMethodBeat.i(4503);
    if (paramInt == 5)
    {
      ihF += tyg[0];
      this.tym += 1;
      ab.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + tyg[0] + " and index is " + this.tym);
      AppMethodBeat.o(4503);
      return;
    }
    if (paramInt == 4)
    {
      WifiManager localWifiManager = (WifiManager)ah.getContext().getApplicationContext().getSystemService("wifi");
      if ((localWifiManager != null) && (localWifiManager.getConnectionInfo() != null))
      {
        ihF += localWifiManager.getConnectionInfo().getRssi();
        tyg[1] = localWifiManager.getConnectionInfo().getRssi();
        this.tym += 1;
        ab.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + localWifiManager.getConnectionInfo().getRssi() + " and index is " + this.tym);
      }
    }
    AppMethodBeat.o(4503);
  }
  
  public final void Hw(int paramInt)
  {
    AppMethodBeat.i(4526);
    ab.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt))
    {
      oq(4101);
      com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMg();
      com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMh();
    }
    AppMethodBeat.o(4526);
  }
  
  public final void Hx(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(4531);
    ab.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.txa.HT(4110))
    {
      AppMethodBeat.o(4531);
      return;
    }
    t localt = com.tencent.mm.plugin.voip.b.cLC();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localt.T(bool1, bool2);
      com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState))) {
        oq(4101);
      }
      oq(4110);
      AppMethodBeat.o(4531);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(4506);
    ab.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    if (this.txc == paramb)
    {
      ab.d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
      this.txc = null;
    }
    if (this.iMP != null) {
      this.iMP = null;
    }
    AppMethodBeat.o(4506);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(4502);
    ab.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s, mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), this.txd, Integer.valueOf(this.txp) });
    if ((1 == paramInt) && (this.txc != null)) {
      this.txc.uninit();
    }
    this.txc = paramb;
    this.mUIType = paramInt;
    if ((this.txd == null) && (com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState))) {
      this.txe = new CaptureView(ah.getContext());
    }
    this.txc.gl(-1, this.txa.mState);
    this.txc.setConnectSec(this.txq);
    this.txc.HF(this.txp);
    this.txc.setMute(this.mIsMute);
    ab.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.txL), Integer.valueOf(this.txM) });
    if (this.txL != -1)
    {
      this.txc.setHWDecMode(this.txL);
      ab.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[] { Integer.valueOf(this.txL) });
    }
    this.txc.setVoipBeauty(this.txM);
    com.tencent.mm.plugin.voip.video.b.d.cPX().tII = new VoipMgr.17(this);
    if ((this.txY != 0) && (this.txZ != 0)) {
      gj(this.txY, this.txZ);
    }
    AppMethodBeat.o(4502);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(4536);
    if (this.txu)
    {
      AppMethodBeat.o(4536);
      return;
    }
    if (this.txd == null)
    {
      ab.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
      AppMethodBeat.o(4536);
      return;
    }
    int m;
    int n;
    label73:
    int i1;
    int k;
    int j;
    label107:
    int i;
    label120:
    byte[] arrayOfByte;
    label150:
    long l;
    if (this.txd.cPB())
    {
      m = OpenGlRender.FLAG_Mirror;
      if (!this.txd.cPC()) {
        break label338;
      }
      n = OpenGlRender.FLAG_Angle270;
      if (this.txc != null)
      {
        i1 = paramInt3 + paramInt4;
        k = 0;
        if ((OpenGlRender.getGLVersion() != 2) || (this.txM == 0)) {
          break label346;
        }
        j = 1;
        if ((this.txM & 0x8) == 0) {
          break label352;
        }
        i = 1;
        if (j == 0) {
          break label443;
        }
        if ((i != 0) || (this.txc.cOR() == null)) {
          break label358;
        }
        i = 1;
        this.txW = 0;
        if ((!this.txd.cPB()) || (j == 0) || (i == 0)) {
          break label543;
        }
        if (i != 1) {
          break label449;
        }
        arrayOfByte = this.txc.cOR();
        i = 4;
        l = arrayOfByte.length;
        this.txV = arrayOfByte;
        k = paramInt2;
        j = paramInt1;
      }
    }
    for (;;)
    {
      label210:
      Object localObject = com.tencent.mm.plugin.voip.b.cLC();
      i1 = (int)l;
      i = ((t)localObject).tyR.ttm.tvl.b(arrayOfByte, i1, i, j, k);
      this.txc.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, m, n, i);
      boolean bool;
      if (m == OpenGlRender.FLAG_Mirror)
      {
        bool = true;
        label283:
        this.txB = bool;
        if (n != OpenGlRender.FLAG_Angle270) {
          break label573;
        }
      }
      label443:
      label573:
      for (paramInt3 = 270;; paramInt3 = 90)
      {
        this.txC = paramInt3;
        paramArrayOfByte = this.txx;
        paramArrayOfByte.tHH = paramInt2;
        paramArrayOfByte.tHG = paramInt1;
        AppMethodBeat.o(4536);
        return;
        m = 0;
        break;
        label338:
        n = OpenGlRender.FLAG_Angle90;
        break label73;
        label346:
        j = 0;
        break label107;
        label352:
        i = 0;
        break label120;
        label358:
        if ((i != 0) && (this.txc.cOS() != null) && (this.txc.cOS().tIs != null))
        {
          i = 2;
          this.txW = 0;
          break label150;
        }
        if ((this.txV != null) && (this.txW <= 10))
        {
          i = 3;
          this.txW += 1;
          break label150;
        }
        j = 0;
        i = k;
        break label150;
        i = 0;
        break label150;
        label449:
        if (i == 2)
        {
          localObject = this.txc.cOS();
          arrayOfByte = ((a.a)localObject).tIs;
          i = 4;
          l = arrayOfByte.length;
          j = ((a.a)localObject).width;
          k = ((a.a)localObject).height;
          this.txV = arrayOfByte;
          break label210;
        }
        if (i != 3) {
          break label580;
        }
        arrayOfByte = this.txV;
        i = 4;
        l = arrayOfByte.length;
        this.txV = arrayOfByte;
        k = paramInt2;
        j = paramInt1;
        break label210;
        i = paramInt3 + paramInt4;
        l = paramLong;
        k = paramInt2;
        j = paramInt1;
        arrayOfByte = paramArrayOfByte;
        break label210;
        bool = false;
        break label283;
      }
      label543:
      label580:
      l = paramLong;
      k = paramInt2;
      j = paramInt1;
      arrayOfByte = null;
      i = i1;
    }
  }
  
  public final void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(4552);
    if ((!this.txX) && (this.txl))
    {
      mT(true);
      this.txX = true;
    }
    al.d(new VoipMgr.13(this, paramArrayOfInt, paramBoolean, paramInt));
    AppMethodBeat.o(4552);
  }
  
  public final void bII()
  {
    AppMethodBeat.i(4518);
    ab.i("MicroMsg.Voip.VoipMgr", "on accept");
    com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
    oq(4100);
    AppMethodBeat.o(4518);
  }
  
  public final void bIO()
  {
    AppMethodBeat.i(4540);
    ab.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    if (this.txc != null) {
      this.txc.bKF();
    }
    AppMethodBeat.o(4540);
  }
  
  public final void bho()
  {
    AppMethodBeat.i(4550);
    if ((true == this.oHm) || (this.txc == null) || (this.txc.cOO() == null))
    {
      ab.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
      AppMethodBeat.o(4550);
      return;
    }
    if (this.txd.bQT())
    {
      AppMethodBeat.o(4550);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.f.b.Me()))
    {
      ab.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(4550);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.fv(28)) && (((KeyguardManager)ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      ab.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(4550);
      return;
    }
    ab.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
    Object localObject = com.tencent.mm.plugin.report.service.h.qsU;
    if (this.txl) {}
    for (int i = 0;; i = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).e(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      localObject = com.tencent.mm.ui.base.h.h(this.txc.cOO(), 2131304714, 2131297087);
      if (localObject != null) {
        break;
      }
      ab.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
      AppMethodBeat.o(4550);
      return;
    }
    ((com.tencent.mm.ui.widget.b.c)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.b.c)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.b.c)localObject).show();
    this.oHm = true;
    AppMethodBeat.o(4550);
  }
  
  public final boolean cMI()
  {
    AppMethodBeat.i(4494);
    if (!this.txa.HT(4103))
    {
      AppMethodBeat.o(4494);
      return false;
    }
    Ht(4103);
    com.tencent.mm.plugin.voip.b.cLC().cOa();
    AppMethodBeat.o(4494);
    return true;
  }
  
  public final boolean cMJ()
  {
    AppMethodBeat.i(4495);
    if (!this.txa.HT(4101))
    {
      AppMethodBeat.o(4495);
      return false;
    }
    com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
    com.tencent.mm.plugin.voip.b.cLC().Hk(1);
    com.tencent.mm.plugin.voip.b.cLC().T(true, this.txl);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    long l = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa;
    int j = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ;
    if (this.txk) {}
    for (int i = 1;; i = 0)
    {
      localh.e(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.qsU.e(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      oq(4111);
      oq(4101);
      oq(4100);
      AppMethodBeat.o(4495);
      return true;
    }
  }
  
  public final boolean cMK()
  {
    int i = 0;
    AppMethodBeat.i(4496);
    if (!this.txa.HT(4099))
    {
      AppMethodBeat.o(4496);
      return false;
    }
    String str2 = this.txj.field_username;
    if (this.txl) {}
    for (String str1 = bi.yOc;; str1 = bi.yOb)
    {
      if (this.txk) {
        i = 1;
      }
      r.a(str2, str1, i, 6, ah.getContext().getString(2131304631));
      com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
      com.tencent.mm.plugin.voip.b.cLC().tyR.cOh();
      oq(4099);
      cMY();
      AppMethodBeat.o(4496);
      return true;
    }
  }
  
  public final boolean cML()
  {
    AppMethodBeat.i(4497);
    if (!this.txa.HT(4100))
    {
      AppMethodBeat.o(4497);
      return false;
    }
    if ((ac.eru.enS == 1) && (this.txl)) {
      mT(true);
    }
    if (((!this.txX) || (ac.eru.enS == 1) || (ac.eru.enT == 1)) && (this.txl)) {
      if ((this.txd != null) && (!this.txd.cPB())) {
        break label157;
      }
    }
    label157:
    for (boolean bool = true;; bool = false)
    {
      mT(bool);
      this.txX = true;
      ab.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
      com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
      com.tencent.mm.plugin.voip.b.cLC().T(false, this.txl);
      oq(4100);
      AppMethodBeat.o(4497);
      return true;
    }
  }
  
  public final void cMM()
  {
    this.txX = false;
  }
  
  public final boolean cMN()
  {
    int i = 0;
    AppMethodBeat.i(4498);
    if (!this.txa.HT(4099))
    {
      AppMethodBeat.o(4498);
      return false;
    }
    ab.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
    String str2 = this.txj.field_username;
    if (this.txl) {}
    for (String str1 = bi.yOc;; str1 = bi.yOb)
    {
      if (this.txk) {
        i = 1;
      }
      r.a(str2, str1, i, 6, ah.getContext().getString(2131304631));
      com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
      com.tencent.mm.plugin.voip.b.cLC().tyR.cOh();
      oq(4099);
      cMY();
      AppMethodBeat.o(4498);
      return true;
    }
  }
  
  public final boolean cMO()
  {
    AppMethodBeat.i(4499);
    if (!this.txa.HT(4100))
    {
      AppMethodBeat.o(4499);
      return false;
    }
    ab.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
    com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
    com.tencent.mm.plugin.voip.b.cLC().T(true, this.txl);
    oq(4111);
    oq(4100);
    AppMethodBeat.o(4499);
    return true;
  }
  
  public final boolean cMP()
  {
    AppMethodBeat.i(4500);
    if (!this.txa.HT(4098))
    {
      AppMethodBeat.o(4500);
      return false;
    }
    ab.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
    Ht(4098);
    com.tencent.mm.plugin.voip.b.cLC().cOa();
    AppMethodBeat.o(4500);
    return true;
  }
  
  public final boolean cMQ()
  {
    AppMethodBeat.i(4501);
    if (!this.txa.HT(4098))
    {
      AppMethodBeat.o(4501);
      return false;
    }
    ab.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
    Ht(4098);
    com.tencent.mm.plugin.voip.b.cLC().cOa();
    AppMethodBeat.o(4501);
    return true;
  }
  
  public final void cMR()
  {
    AppMethodBeat.i(140157);
    if ((this.txl) && (this.txc != null))
    {
      this.txc.setCaptureView(this.txe);
      if (ac.eru.enS == 0) {
        if ((this.txd != null) && (!this.txd.cPB())) {
          break label73;
        }
      }
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      mT(bool);
      AppMethodBeat.o(140157);
      return;
    }
  }
  
  public final void cMS()
  {
    AppMethodBeat.i(4504);
    ab.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
    this.tyc = new VoipMgr.NetChangedBroadcastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ah.getContext().registerReceiver(this.tyc, localIntentFilter);
    this.tyh = ((TelephonyManager)ah.getContext().getSystemService("phone"));
    this.tya = com.tencent.mm.plugin.voip.a.a.getNetType(getContext());
    this.tyd = new VoipMgr.18(this);
    this.tyh.listen(this.tyd, 256);
    AppMethodBeat.o(4504);
  }
  
  public final void cMT()
  {
    AppMethodBeat.i(4507);
    ab.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    if (this.txd != null) {
      this.txd.cPy();
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(11079, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(4507);
  }
  
  public final void cMU()
  {
    AppMethodBeat.i(4508);
    if (true != this.txd.cPB()) {
      cMT();
    }
    AppMethodBeat.o(4508);
  }
  
  public final boolean cMV()
  {
    AppMethodBeat.i(4511);
    if (com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ == 0)
    {
      this.txo = true;
      AppMethodBeat.o(4511);
      return true;
    }
    boolean bool = cMW();
    AppMethodBeat.o(4511);
    return bool;
  }
  
  public final void cMX()
  {
    AppMethodBeat.i(4513);
    ab.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    if ((this.txo) && (com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ != 0))
    {
      this.txo = false;
      cMW();
    }
    if (this.txk) {
      oq(4097);
    }
    AppMethodBeat.o(4513);
  }
  
  public final void cMZ()
  {
    AppMethodBeat.i(4522);
    ab.i("MicroMsg.Voip.VoipMgr", "onNoResp");
    oq(4105);
    String str2 = this.txj.field_username;
    String str1;
    if (this.txl)
    {
      str1 = bi.yOc;
      if (!this.txk) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      r.a(str2, str1, i, 4, ah.getContext().getString(2131304634));
      com.tencent.mm.plugin.report.service.h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMb()), Integer.valueOf(6), Integer.valueOf(at.getNetWorkType(getContext())) });
      cMY();
      AppMethodBeat.o(4522);
      return;
      str1 = bi.yOb;
      break;
    }
  }
  
  public final void cNa()
  {
    int j = 0;
    AppMethodBeat.i(4524);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    int k = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ;
    long l1 = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa;
    long l2 = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMb();
    if (this.txk)
    {
      i = 0;
      localh.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ;
      l1 = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa;
      if (!this.txk) {
        break label198;
      }
    }
    label198:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.a.a.c(k, l1, i, 3);
      this.tyf.post(new VoipMgr.3(this));
      AppMethodBeat.o(4524);
      return;
      i = 1;
      break;
    }
  }
  
  public final void cNb()
  {
    int j = 0;
    AppMethodBeat.i(4525);
    ab.i("MicroMsg.Voip.VoipMgr", "onShutDown");
    String str1;
    String str2;
    label99:
    label108:
    int k;
    label135:
    label163:
    long l;
    if (com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState))
    {
      str1 = ah.getContext().getString(2131304627, new Object[] { ha(bo.gz(this.txq)) });
      if ((this.txk) || (com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState)))
      {
        String str3 = this.txj.field_username;
        if (!this.txl) {
          break label252;
        }
        str2 = bi.yOc;
        if (!this.txk) {
          break label260;
        }
        i = 1;
        r.a(str3, str2, i, 6, str1);
      }
      if (!this.txl) {
        break label265;
      }
      com.tencent.mm.plugin.voip.b.cLC().HA(0);
      this.txh = com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState);
      if (!cNi()) {
        break label275;
      }
      this.txn = 4106;
      com.tencent.mm.plugin.voip.b.cLC().cOa();
      if (!this.txT)
      {
        k = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ;
        l = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa;
        if (!this.txk) {
          break label289;
        }
      }
    }
    label260:
    label265:
    label275:
    label289:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.a.a.c(k, l, i, 4);
      this.txT = true;
      AppMethodBeat.o(4525);
      return;
      str1 = ah.getContext().getString(2131304623);
      break;
      label252:
      str2 = bi.yOb;
      break label99;
      i = 0;
      break label108;
      com.tencent.mm.plugin.voip.b.cLC().HA(1);
      break label135;
      oq(4106);
      cMY();
      break label163;
    }
  }
  
  public final void cNc()
  {
    AppMethodBeat.i(4528);
    if (this.txc != null) {
      this.txc.cNc();
    }
    AppMethodBeat.o(4528);
  }
  
  public final void cNd()
  {
    boolean bool2 = false;
    AppMethodBeat.i(4532);
    ab.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    boolean bool1;
    if ((com.tencent.mm.compatible.b.g.KC().KN()) || (com.tencent.mm.compatible.b.g.KC().KH()))
    {
      mR(false);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        al.d(new VoipMgr.4(this));
        AppMethodBeat.o(4532);
      }
    }
    else if (1 == this.txp)
    {
      bool1 = true;
      label77:
      if (!this.txH) {
        break label99;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      mR(bool1);
      break;
      bool1 = false;
      break label77;
      label99:
      if (this.txl)
      {
        bool1 = true;
        continue;
        cNe();
        AppMethodBeat.o(4532);
        return;
      }
    }
  }
  
  public final long cNf()
  {
    AppMethodBeat.i(4534);
    ab.b("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.txP) });
    long l = this.txP / 1000L;
    AppMethodBeat.o(4534);
    return l;
  }
  
  public final void cNk()
  {
    AppMethodBeat.i(4547);
    if ((256 != this.txa.mState) && (257 != this.txa.mState))
    {
      AppMethodBeat.o(4547);
      return;
    }
    if ((com.tencent.mm.kernel.g.RL().Ru().getInt(327945, 0) == 0) && (this.txc.cOO() != null))
    {
      com.tencent.mm.kernel.g.RL().Ru().setInt(327945, 1);
      com.tencent.mm.ui.widget.b.c localc = com.tencent.mm.ui.base.h.a(this.txc.cOO(), 2131304692, 2131297087, new VoipMgr.9(this));
      localc.setCancelable(false);
      localc.setCanceledOnTouchOutside(false);
      localc.show();
      AppMethodBeat.o(4547);
      return;
    }
    com.tencent.mm.plugin.voip.a.d.fn(ah.getContext());
    cNm();
    AppMethodBeat.o(4547);
  }
  
  public final void cNl()
  {
    AppMethodBeat.i(4548);
    if (!this.txA) {}
    for (boolean bool = true;; bool = false)
    {
      this.txA = bool;
      if (!this.txA) {
        break;
      }
      this.txy.stopTimer();
      AppMethodBeat.o(4548);
      return;
    }
    if (this.txy == null)
    {
      this.txz = new al("faceDetect");
      this.txy = new ap(this.txz.oNc.getLooper(), new VoipMgr.11(this), true);
    }
    this.txy.ag(2000L, 2000L);
    this.txA = false;
    AppMethodBeat.o(4548);
  }
  
  public final void cNm()
  {
    AppMethodBeat.i(4549);
    com.tencent.mm.plugin.voip.b.cLC().tyX = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ;
    String str2 = this.txj.field_username;
    String str1;
    if (this.txl)
    {
      str1 = bi.yOc;
      if (!this.txk) {
        break label129;
      }
    }
    label129:
    for (int i = 1;; i = 0)
    {
      r.a(str2, str1, i, 6, ah.getContext().getString(2131304630));
      com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
      oq(4108);
      if (this.iMP != null) {
        this.iMP.postDelayed(new VoipMgr.10(this), 2000L);
      }
      AppMethodBeat.o(4549);
      return;
      str1 = bi.yOb;
      break;
    }
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140158);
    if (this.txc != null) {
      this.txc.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(140158);
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(4544);
    Context localContext1 = null;
    if (this.txc != null) {
      localContext1 = this.txc.cOO();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = ah.getContext();
    }
    AppMethodBeat.o(4544);
    return localContext2;
  }
  
  public final void gj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140159);
    ab.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.txY = paramInt1;
    this.txZ = paramInt2;
    if (this.txc != null) {
      this.txc.gj(paramInt1, paramInt2);
    }
    AppMethodBeat.o(140159);
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(4487);
    ab.i("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b, isHeadsetPlugged: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.txs), Boolean.valueOf(com.tencent.mm.compatible.b.g.KC().KN()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(4487);
      return;
      com.tencent.mm.compatible.b.g.KC().KE();
      this.txK = false;
      AppMethodBeat.o(4487);
      return;
      com.tencent.mm.compatible.b.g.KC().KF();
      com.tencent.mm.compatible.b.g.KC().KD();
      cMH();
      AppMethodBeat.o(4487);
      return;
      if (!com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState)) {
        if (1 != this.txp) {
          break label224;
        }
      }
      label224:
      for (boolean bool = true;; bool = false)
      {
        this.txs = bool;
        paramInt = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cLL();
        com.tencent.mm.compatible.b.g.KC().b(false, paramInt, false);
        com.tencent.mm.plugin.voip.b.cLC().mJ(false);
        com.tencent.mm.plugin.voip.b.cLC().mP(false);
        Hr(4);
        this.txK = false;
        com.tencent.mm.plugin.voip.b.cLC().jA(true);
        AppMethodBeat.o(4487);
        return;
      }
      if (!this.tyj)
      {
        com.tencent.mm.compatible.b.g.KC().KF();
        cMH();
        this.txS = true;
        AppMethodBeat.o(4487);
        return;
        com.tencent.mm.compatible.b.g.KC().KE();
      }
    }
  }
  
  public final void hv(boolean paramBoolean)
  {
    AppMethodBeat.i(4486);
    ab.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.txO), Long.valueOf(this.txN) });
    if (this.txa == null)
    {
      ab.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(4486);
      return;
    }
    if ((Math.abs(bo.yB() - this.txQ) < 500L) && (this.txQ != -1L))
    {
      ab.d("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(4486);
      return;
    }
    if ((com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState)) && ((this.txO != paramBoolean) || (this.txN == -1L)))
    {
      if ((!this.txO) && (paramBoolean) && (!com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState)) && (this.mUIType != 2) && (this.txN != -1L))
      {
        long l = bo.av(this.txN);
        ab.i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.txP = (l + this.txP);
      }
      this.txN = bo.yB();
      this.txO = paramBoolean;
    }
    if (this.txc == null)
    {
      ab.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(4486);
      return;
    }
    if (((this.txk) || (com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState))) && (!com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState)) && (this.mUIType != 2))
    {
      ab.d("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.txc.setScreenEnable(paramBoolean);
      this.txQ = bo.yB();
    }
    AppMethodBeat.o(4486);
  }
  
  public final void iw(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(4539);
    ab.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
    if (this.txc != null) {
      this.txc.mY(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState)) && (!this.txt))
    {
      l = System.currentTimeMillis();
      if (l - this.nNQ > 30000L)
      {
        this.nNQ = l;
        com.tencent.mm.plugin.voip.b.cLC().tyR.cOl();
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ab.i("MicroMsg.Voip.VoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.qsU;
      l = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(4539);
      return;
    }
  }
  
  public final void jx(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(4493);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvl;
      if (((m)localObject).kJB != null) {
        ((m)localObject).kJB.bB(true);
      }
      com.tencent.mm.plugin.voip.b.cLC().Hk(9);
      com.tencent.mm.plugin.voip.b.cLC().mO(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      localObject = com.tencent.mm.plugin.report.service.h.qsU;
      if (paramBoolean) {
        i = 2;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).e(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(4493);
      return;
      localObject = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvl;
      if (((m)localObject).kJB != null) {
        ((m)localObject).kJB.bB(false);
      }
      com.tencent.mm.plugin.voip.b.cLC().Hk(8);
      com.tencent.mm.plugin.voip.b.cLC().mO(false);
    }
  }
  
  public final void mS(boolean paramBoolean)
  {
    AppMethodBeat.i(4492);
    ab.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (!com.tencent.mm.plugin.voip.b.cLC().tyR.cOm())
    {
      localObject = com.tencent.mm.plugin.voip.b.cLC().tyR;
      if (((u)localObject).tzl != null) {
        ((u)localObject).tzl.nf(paramBoolean);
      }
      if (!paramBoolean) {
        break label128;
      }
      i = 1;
      label66:
      Hr(i);
      localObject = com.tencent.mm.plugin.report.service.h.qsU;
      if (!paramBoolean) {
        break label133;
      }
    }
    label128:
    label133:
    for (int i = 1;; i = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).e(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(4492);
      return;
      mR(paramBoolean);
      break;
      i = 2;
      break label66;
    }
  }
  
  final void mU(boolean paramBoolean)
  {
    AppMethodBeat.i(4521);
    ab.i("MicroMsg.Voip.VoipMgr", "finish");
    this.txE = false;
    this.txG = false;
    if (this.txv != -1)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11700, new Object[] { Integer.valueOf(this.txv), Long.valueOf(bo.gz(this.txq)) });
      this.txv = -1;
    }
    try
    {
      ah.getContext().unregisterReceiver(this.tyk);
      label84:
      com.tencent.mm.sdk.b.a.ymk.d(this.nLH);
      com.tencent.mm.sdk.b.a.ymk.d(this.tyn);
      ab.i("MicroMsg.Voip.VoipMgr", "uninitSurfaceTexture!");
      if (this.txc != null) {
        this.txc.cOQ();
      }
      if (this.txc != null)
      {
        this.txc.uninit();
        this.txc = null;
      }
      this.txe = null;
      com.tencent.mm.compatible.b.g.KC().b(this);
      com.tencent.mm.compatible.b.g.KC().KF();
      label218:
      Object localObject2;
      Object localObject1;
      label269:
      label330:
      long l1;
      label566:
      int j;
      if (com.tencent.mm.plugin.voip.b.cLC() != null)
      {
        com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
        if (paramBoolean)
        {
          com.tencent.mm.plugin.voip.b.cLC().tyR.cOk();
          if (!this.txl) {
            break label910;
          }
          com.tencent.mm.plugin.voip.b.cLC().b(false, true, this.eaX);
          localObject2 = com.tencent.mm.plugin.voip.b.cLC();
          localObject1 = ah.getContext();
          localObject2 = ((t)localObject2).tyR;
          if ((localObject1 == ((u)localObject2).ttm.jpJ) && (this == ((u)localObject2).ttm.tvk)) {
            break label925;
          }
          com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
        }
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.voip.b.cLC();
        ((t)localObject1).tyS = null;
        ((t)localObject1).tza = null;
        ((t)localObject1).tzb = false;
        ((t)localObject1).tzg = false;
        t.cNY();
        if (!this.txg) {
          break label960;
        }
        this.txf = new VoipMgr.a(this);
        com.tencent.mm.sdk.g.d.post(this.txf, "VoipMgr_clean");
        if ((this.nLF != null) && (this.nLG != null))
        {
          this.nLF.listen(this.nLG, 0);
          this.nLG = null;
        }
        if (this.txb != null) {
          this.txb.fg(ah.getContext());
        }
        this.nLF = null;
        com.tencent.mm.booter.a.Ia().Ib();
        q.cNr().cNt();
        q.cNr().a(null);
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        if (this.mub != null)
        {
          ab.d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
          this.mub.dtJ();
          this.mub = null;
          this.txO = false;
          this.txP = 0L;
          this.txN = -1L;
        }
        this.txQ = -1L;
        com.tencent.mm.plugin.voip.b.cLC().cOa();
        ab.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.txh) });
        if (this.txh)
        {
          localObject1 = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvv;
          com.tencent.mm.kernel.g.RM();
          long l2 = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKy, Long.valueOf(-1L))).longValue();
          if (l2 <= 0L) {
            break label967;
          }
          l1 = l2;
          ((VoipScoreState)localObject1).tyQ = l1;
          l1 = bf.aaM();
          ab.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((VoipScoreState)localObject1).tyP) });
          if ((bo.isNullOrNil(((VoipScoreState)localObject1).tyO)) || (((VoipScoreState)localObject1).tyP <= 0) || ((l2 > 0L) && (l1 - l2 <= ((VoipScoreState)localObject1).tyP * 86400000L))) {
            break label973;
          }
          ab.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
          i = 1;
          label674:
          if (i != 0)
          {
            com.tencent.mm.plugin.voip.b.cLC();
            VoipScoreState.cNR();
            localObject1 = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject1).putExtra("key_score_state", com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvv);
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject1).addFlags(268435456);
            }
            getContext().startActivity((Intent)localObject1);
          }
        }
        com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvv = new VoipScoreState();
        localObject1 = new ux();
        ((ux)localObject1).cLs.cut = 11;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        if (!this.txT)
        {
          j = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ;
          l1 = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa;
          if (!this.txk) {
            break label978;
          }
        }
      }
      label910:
      label925:
      label960:
      label967:
      label973:
      label978:
      for (int i = 0;; i = 1)
      {
        com.tencent.mm.plugin.voip.a.a.c(j, l1, i, 4);
        this.txT = true;
        this.txV = null;
        this.txW = 0;
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        AppMethodBeat.o(4521);
        return;
        com.tencent.mm.plugin.voip.b.cLC().tyR.cOi();
        break;
        com.tencent.mm.plugin.voip.b.cLC().b(false, false, this.eaX);
        break label218;
        ((u)localObject2).ttm.jpJ = null;
        ((u)localObject2).ttm.tvk = w.tzF;
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
        com.tencent.mm.plugin.voip.a.a.flushLogFile();
        break label269;
        cNg();
        break label330;
        l1 = 0L;
        break label566;
        i = 0;
        break label674;
      }
    }
    catch (Exception localException)
    {
      break label84;
    }
  }
  
  public final boolean mV(boolean paramBoolean)
  {
    AppMethodBeat.i(4546);
    if ((this.txG) && (!paramBoolean))
    {
      ab.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(4546);
      return false;
    }
    ab.a("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ab.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
    if (this.txc != null)
    {
      this.txc.uninit();
      this.txc = null;
    }
    if (this.iMP != null) {
      this.iMP.post(new VoipMgr.8(this, paramBoolean));
    }
    AppMethodBeat.o(4546);
    return true;
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(4523);
    oq(4102);
    this.txq = bo.aox();
    if (this.txc != null) {
      this.txc.setConnectSec(this.txq);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMd();
    boolean bool2 = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMc();
    if ((this.txl) && (this.txk) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.b.cLC().Hk(1);
    }
    if (!com.tencent.mm.plugin.voip.a.b.HR(this.txa.mState)) {
      com.tencent.mm.plugin.report.service.h.qsU.e(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    bo.z(ah.getContext(), true);
    Object localObject = com.tencent.mm.plugin.voip.b.cLC();
    int i = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.tAn;
    localObject = ((t)localObject).tyR;
    ((u)localObject).bsO = null;
    ((u)localObject).tzs = null;
    ((u)localObject).tzq = 0;
    if (i > 0) {
      u.tzo = i;
    }
    ((u)localObject).bsO = ((WifiManager)ah.getContext().getApplicationContext().getSystemService("wifi"));
    ((u)localObject).tzr = new Timer();
    ((u)localObject).tzr.schedule(new u.6((u)localObject), 0L, u.tzo * 1000);
    TelephonyManager localTelephonyManager = (TelephonyManager)ah.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      localTelephonyManager.listen(new u.5((u)localObject, localTelephonyManager), 256);
    }
    q.cNr().cNs();
    q.cNr().a(this);
    AppMethodBeat.o(4523);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(4517);
    String str1;
    if (this.txl)
    {
      com.tencent.mm.plugin.voip.b.cLC().HA(0);
      str1 = paramString;
      if (paramInt == 241)
      {
        str1 = paramString;
        if (bo.isNullOrNil(paramString)) {
          str1 = getContext().getString(2131304721);
        }
      }
      if (this.txc != null) {
        this.txc.br(paramInt, str1);
      }
      oq(4109);
      ab.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ) });
      paramString = ah.getContext();
      ab.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
      if (paramInt != 235) {
        break label348;
      }
      paramString = paramString.getString(2131304633);
      label154:
      if ((com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ == 0) || (com.tencent.mm.plugin.voip.b.cLC().tyW.get(Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ)) != null)) {
        break label444;
      }
      str2 = this.txj.field_username;
      if (!this.txl) {
        break label431;
      }
      str1 = bi.yOc;
      if (!this.txk) {
        break label439;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState)) {
        paramString = ah.getContext().getString(2131304628, new Object[] { ha(bo.gz(this.txq)) });
      }
      l = r.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.b.cLC().tyW.put(Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(l));
    }
    label348:
    while (com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.b.cLC().cOa();
        cMY();
        AppMethodBeat.o(4517);
        return;
        com.tencent.mm.plugin.voip.b.cLC().HA(1);
        break;
        if (paramInt == 233)
        {
          paramString = paramString.getString(2131304624);
          break label154;
        }
        if (paramInt == 237)
        {
          paramString = paramString.getString(2131304633);
          break label154;
        }
        if (paramInt == 236)
        {
          paramString = paramString.getString(2131304624);
          break label154;
        }
        if (paramInt == 211)
        {
          paramString = paramString.getString(2131304632);
          break label154;
        }
        paramString = paramString.getString(2131304623);
        break label154;
        str1 = bi.yOb;
        continue;
        paramInt = 0;
      }
    }
    label431:
    label439:
    label444:
    String str2 = this.txj.field_username;
    if (this.txl)
    {
      str1 = bi.yOc;
      label483:
      if (!this.txk) {
        break label556;
      }
    }
    label556:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.a.b.HQ(this.txa.mState)) {
        paramString = ah.getContext().getString(2131304628, new Object[] { ha(bo.gz(this.txq)) });
      }
      r.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = bi.yOb;
      break label483;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(140160);
    if (this.txc != null) {
      this.txc.requestRender();
    }
    AppMethodBeat.o(140160);
  }
  
  public final void onReject()
  {
    AppMethodBeat.i(4519);
    ab.i("MicroMsg.Voip.VoipMgr", "onReject");
    oq(4099);
    String str2 = this.txj.field_username;
    String str1;
    if (this.txl)
    {
      str1 = bi.yOc;
      if (!this.txk) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      r.a(str2, str1, i, 6, ah.getContext().getString(2131304635));
      cMY();
      AppMethodBeat.o(4519);
      return;
      str1 = bi.yOb;
      break;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(4530);
    this.txL = paramInt;
    if (this.txc != null) {
      this.txc.setHWDecMode(paramInt);
    }
    AppMethodBeat.o(4530);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(4529);
    ab.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + paramInt + "，mVoipUI: " + this.txc);
    if (this.txc != null) {
      this.txc.setVoipBeauty(paramInt);
    }
    if ((paramInt != 0) && (this.txM != paramInt)) {
      com.tencent.mm.plugin.report.service.h.qsU.j(914L, 20L, 1L);
    }
    this.txM = paramInt;
    AppMethodBeat.o(4529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr
 * JD-Core Version:    0.7.0.1
 */