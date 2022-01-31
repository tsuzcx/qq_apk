package com.tencent.mm.plugin.voip.model;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.uc;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip.video.k;
import com.tencent.mm.plugin.voip.video.k.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;

public final class o
  implements f.a, p.a, u, com.tencent.mm.plugin.voip.ui.c, com.tencent.mm.plugin.voip.video.g, k.a, SensorController.a
{
  public com.tencent.mm.compatible.util.b bDz;
  public String djD;
  public ah hcZ;
  public SensorController iah;
  public TelephonyManager loj;
  public PhoneStateListener lok = new o.2(this);
  public com.tencent.mm.sdk.b.c lol = new o.11(this);
  private long lqu = 0L;
  private boolean mIsMute = false;
  private int mUIType;
  private boolean mha = false;
  long pRF = 0L;
  long pRG = 0L;
  public com.tencent.mm.plugin.voip.a.c pRS;
  public HeadsetPlugReceiver pRT;
  com.tencent.mm.plugin.voip.ui.b pRU;
  private com.tencent.mm.plugin.voip.video.a pRV;
  private CaptureView pRW;
  private o.a pRX = null;
  private boolean pRY = false;
  private boolean pRZ = false;
  public boolean pSA = false;
  public com.tencent.mm.plugin.voip.video.e pSB = null;
  public int pSC = -1;
  public int pSD = 0;
  private long pSE = -1L;
  private boolean pSF = false;
  private long pSG = 0L;
  private long pSH = -1L;
  int pSI = 0;
  private int pSJ = 0;
  private byte[] pSK = null;
  private boolean pSL = true;
  public BroadcastReceiver pSM = new o.1(this);
  public HeadsetPlugReceiver.a pSN = new o.13(this);
  public com.tencent.mm.sdk.b.c pSO = new o.10(this);
  private Object pSa = new Object();
  public ad pSb;
  public boolean pSc;
  public boolean pSd;
  public boolean pSe = false;
  private int pSf = 4096;
  private boolean pSg = false;
  public int pSh = 1;
  private long pSi = -1L;
  private boolean pSj = false;
  public boolean pSk = false;
  private boolean pSl = false;
  private boolean pSm = false;
  private int pSn = 0;
  public k pSo = new k();
  private am pSp = null;
  private ai pSq;
  private boolean pSr = false;
  private boolean pSs = false;
  private int pSt = 0;
  private boolean pSu = false;
  public boolean pSv = false;
  private com.tencent.mm.plugin.voip.widget.b pSw;
  private boolean pSx = false;
  private boolean pSy = false;
  public String pSz = null;
  
  private void Ae(int paramInt)
  {
    this.pSh = paramInt;
    if (this.pRU != null) {
      this.pRU.Ap(this.pSh);
    }
  }
  
  private void Af(int paramInt)
  {
    y.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
    if (true == bQQ()) {
      this.pSf = paramInt;
    }
    Object localObject1 = ae.getContext();
    Object localObject2;
    label86:
    int i;
    if (com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState))
    {
      localObject1 = ((Context)localObject1).getString(a.e.voip_call_msg_chat_time, new Object[] { ce(bk.cn(this.pSi)) });
      String str = this.pSb.field_username;
      if (!this.pSd) {
        break label304;
      }
      localObject2 = bi.uBQ;
      if (!this.pSc) {
        break label312;
      }
      i = 1;
      label95:
      q.a(str, (String)localObject2, i, 6, (String)localObject1);
      if ((!this.pSc) || (com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState))) {
        break label519;
      }
      com.tencent.mm.plugin.voip.b.bPx().stopRing();
      if ((this.pSc) && (!com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState)))
      {
        y.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
        localObject1 = com.tencent.mm.plugin.voip.b.bPx().pTq;
        y.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + ((s)localObject1).pNq.pQe.lpD);
        if ((((s)localObject1).pNq.pQe.lpD != 0) || (((s)localObject1).pNq.pQe.lpG != 0)) {
          break label317;
        }
        ((s)localObject1).reset();
      }
      y.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.b.bPx().bRc();
      if (4096 == this.pSf)
      {
        lI(paramInt);
        bQG();
      }
    }
    label304:
    label312:
    label317:
    do
    {
      return;
      if (this.pSc)
      {
        localObject1 = ((Context)localObject1).getString(a.e.voip_call_cancel_msg_to);
        break;
      }
      localObject1 = ((Context)localObject1).getString(a.e.voip_call_cancel_msg_from);
      break;
      localObject2 = bi.uBP;
      break label86;
      i = 0;
      break label95;
      ((s)localObject1).pNq.pQe.pWi.pQU = ((s)localObject1).pNq.bPU();
      ((s)localObject1).pNq.pQe.pWi.pRg = 3;
      if (((s)localObject1).pNq.mStatus < 6) {
        ((s)localObject1).pNq.pQe.pWi.pRi = 1;
      }
      localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
      int j = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD;
      long l1 = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE;
      long l2 = com.tencent.mm.plugin.voip.b.bPx().bRf();
      if (((s)localObject1).pNq.mStatus == 5) {}
      for (i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject2).a(11521, true, true, new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
        ((s)localObject1).bRs();
        break;
      }
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.plugin.voip.b.bPx().stopRing();
          if (o.e(o.this))
          {
            com.tencent.mm.plugin.voip.b.bPx().el(a.d.playend, 0);
            return;
          }
          com.tencent.mm.plugin.voip.b.bPx().el(a.d.playend, 1);
        }
      }, "VoipMgr_play_end_sound");
      this.pRY = true;
      this.pRZ = true;
      com.tencent.mm.plugin.voip.b.bPx().bRc();
    } while (4096 != this.pSf);
    label519:
    lI(paramInt);
    bQG();
  }
  
  private static void Ag(int paramInt)
  {
    uc localuc = new uc();
    localuc.ceA.bHz = paramInt;
    com.tencent.mm.sdk.b.a.udP.m(localuc);
  }
  
  private void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.b("MicroMsg.Voip.VoipMgr", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.pSj = paramBoolean1;
    this.pSk = paramBoolean1;
    y.d("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + f.yi().yr());
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      bool = paramBoolean1;
      if (f.yi().yn()) {
        bool = false;
      }
    }
    if (com.tencent.mm.compatible.e.q.dye.duN)
    {
      com.tencent.mm.compatible.e.q.dye.dump();
      if (com.tencent.mm.compatible.e.q.dye.duO > 0) {
        com.tencent.mm.plugin.voip.b.bPx().jQ(bool);
      }
    }
    if ((com.tencent.mm.compatible.e.q.dye.dvq >= 0) || (com.tencent.mm.compatible.e.q.dye.dvr >= 0)) {
      com.tencent.mm.plugin.voip.b.bPx().jQ(bool);
    }
    int i = com.tencent.mm.plugin.voip.b.bPx().bPH();
    f.yi().b(bool, i, paramBoolean2);
    com.tencent.mm.plugin.voip.b.bPx().jZ(bool);
    this.pSl = bool;
  }
  
  private void aNZ()
  {
    if (this.pSp == null)
    {
      this.pSq = new ai("faceDetect");
      this.pSp = new am(this.pSq.mnU.getLooper(), new o.8(this), true);
    }
    this.pSp.S(2000L, 2000L);
    this.pSr = false;
  }
  
  private boolean bQE()
  {
    int k = 4;
    int m = 0;
    if (!this.pRS.Az(4101)) {
      return false;
    }
    lI(4101);
    Object localObject1;
    int j;
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    Object localObject2;
    if ((261 == this.pRS.mState) || (7 == this.pRS.mState))
    {
      com.tencent.mm.plugin.voip.b.bPx().zY(1);
      localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
      long l = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE;
      j = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD;
      if (this.pSc)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        localObject2 = new Object[3];
        localObject2[0] = Integer.valueOf(2);
        localObject2[1] = Integer.valueOf(0);
        j = 2;
        localObject1 = localObject2;
        i = 11080;
      }
    }
    for (;;)
    {
      k = j;
      j = m;
      for (;;)
      {
        localObject1[k] = Integer.valueOf(j);
        localh.f(i, (Object[])localObject2);
        do
        {
          com.tencent.mm.plugin.voip.b.bPx().bRg();
          com.tencent.mm.plugin.voip.b.bPx().bRh();
          return true;
          i = 0;
          break;
        } while ((1 != this.pRS.mState) && (3 != this.pRS.mState));
        com.tencent.mm.plugin.voip.b.bPx().zY(1);
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        i = 11046;
        localObject1 = new Object[5];
        localObject1[0] = Integer.valueOf(1);
        localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE);
        localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD);
        localObject1[3] = Integer.valueOf(0);
        if (!this.pSc) {
          break label365;
        }
        j = 1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      label365:
      j = 4;
      localObject2 = localObject1;
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private void bQG()
  {
    y.d("MicroMsg.Voip.VoipMgr", "delayFinish");
    this.pSz = null;
    if (this.hcZ != null) {
      this.hcZ.postDelayed(new o.17(this), 2000L);
    }
  }
  
  private void bQM()
  {
    if ((com.tencent.mm.compatible.util.d.gF(28)) && (this.pSd) && (this.pRV != null) && (!this.pRV.biR()) && (this.pRU != null))
    {
      y.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      this.pRV.bSs();
      com.tencent.mm.plugin.voip.video.a.bSt();
      this.pRU.bRS();
      int k = 320;
      int m = 240;
      int j = m;
      int i = k;
      if (this.pRV == null)
      {
        j = m;
        i = k;
        if (com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState))
        {
          this.pRW = new CaptureView(ae.getContext());
          j = m;
          i = k;
          if (v2protocal.pUv)
          {
            y.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
            i = 640;
            j = 480;
          }
        }
      }
      this.pRV = new com.tencent.mm.plugin.voip.video.a(i, j);
      this.pRV.a(this, true);
      this.pRV.a(this.pRW);
      this.pRV.bSr();
    }
  }
  
  private void bQO()
  {
    synchronized (this.pSa)
    {
      com.tencent.mm.plugin.voip.b.bPx().stopRing();
      bQP();
      f.yi().setMode(0);
      if (this.bDz != null) {
        this.bDz.zE();
      }
      return;
    }
  }
  
  private void bQP()
  {
    y.b("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
    if (this.pRV != null)
    {
      if (this.pSo != null)
      {
        k localk = this.pSo;
        if (localk.hUi.contains(this)) {
          localk.hUi.remove(this);
        }
      }
      if (this.pSp != null)
      {
        y.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
        this.pSp.stopTimer();
      }
      if ((this.pSq != null) && (this.pSq.mnU.getLooper() != null))
      {
        y.d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
        this.pSq.mnU.getLooper().quit();
      }
    }
    try
    {
      this.pRV.bSs();
      com.tencent.mm.plugin.voip.video.a.bSt();
      this.pRV = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + localException.toString());
      }
    }
  }
  
  private boolean bQQ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    SharedPreferences localSharedPreferences;
    Object localObject;
    TextView localTextView;
    if (com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState))
    {
      localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      bool1 = bool2;
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        localObject = com.tencent.mm.m.g.AA().getValue("VOIPShortcutAutoadd");
        y.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[] { localObject });
        if ((localObject == null) || (!((String)localObject).equals("0")) || (bk.cn(this.pSi) <= 30L)) {
          break label307;
        }
        int i = localSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
        boolean bool3 = localSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
        bool1 = bool2;
        if (i < 3)
        {
          bool1 = bool2;
          if (!bool3)
          {
            localObject = getContext();
            View localView = View.inflate((Context)localObject, a.c.mm_alert_checkbox, null);
            CheckBox localCheckBox = (CheckBox)localView.findViewById(a.b.mm_alert_dialog_cb);
            localCheckBox.setChecked(false);
            localTextView = (TextView)localView.findViewById(a.b.mm_alert_dialog_info);
            if (1 != bk.getInt(com.tencent.mm.m.g.AA().getValue("VOIPCallType"), 0)) {
              break label296;
            }
            localTextView.setText(a.e.voip_add_short_cut_tip);
            com.tencent.mm.ui.base.h.a((Context)localObject, false, ((Context)localObject).getString(a.e.app_tip), localView, ((Context)localObject).getString(a.e.app_yes), ((Context)localObject).getString(a.e.app_no), new DialogInterface.OnClickListener()new o.4
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                paramAnonymousDialogInterface = o.g(o.this).getSharedPreferences("voip_plugin_prefs", 0);
                o.a(o.this, paramAnonymousDialogInterface);
                if (4096 != o.v(o.this))
                {
                  o.d(o.this, o.v(o.this));
                  o.w(o.this);
                }
                if (o.x(o.this) != null) {
                  o.x(o.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      o.k(o.this);
                    }
                  });
                }
              }
            }, new o.4(this, localCheckBox));
            localSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
            bool1 = true;
          }
        }
      }
    }
    label296:
    label307:
    do
    {
      do
      {
        do
        {
          return bool1;
          localTextView.setText(a.e.voip_add_short_cut_tip_audio);
          break;
          bool1 = bool2;
        } while (localObject == null);
        bool1 = bool2;
      } while (!((String)localObject).equals("1"));
      bool1 = bool2;
    } while (bk.cn(this.pSi) <= 15L);
    c(localSharedPreferences);
    return false;
  }
  
  private void bQr()
  {
    boolean bool2 = f.yi().yt();
    boolean bool3 = this.pSA;
    boolean bool4 = com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState);
    boolean bool5 = com.tencent.mm.plugin.voip.b.bPx().bRj();
    boolean bool6 = this.pSk;
    boolean bool1;
    if (2 == this.mUIType)
    {
      bool1 = true;
      y.i("MicroMsg.Voip.VoipMgr", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!this.pSA)
      {
        if (!com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState)) {
          break label204;
        }
        if (com.tencent.mm.plugin.voip.b.bPx().bRj()) {
          break label172;
        }
        G(false, false);
        this.pSh = 2;
      }
    }
    for (;;)
    {
      Ae(this.pSh);
      this.pSA = true;
      com.tencent.mm.plugin.voip.b.bPx().hH(false);
      return;
      bool1 = false;
      break;
      label172:
      if (!bool2)
      {
        G(true, true);
        this.pSh = 1;
      }
      else
      {
        G(false, false);
        this.pSh = 2;
        continue;
        label204:
        if (com.tencent.mm.plugin.voip.b.bPx().bRj()) {
          break label227;
        }
        G(false, false);
        this.pSh = 2;
      }
    }
    label227:
    if (((this.pSk) || (2 == this.mUIType)) && (!bool2)) {
      G(true, true);
    }
    for (this.pSh = 1;; this.pSh = 2)
    {
      this.pSk = false;
      break;
    }
  }
  
  private void c(SharedPreferences paramSharedPreferences)
  {
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
    localIntent2.addFlags(67108864);
    if (1 == bk.getInt(com.tencent.mm.m.g.AA().getValue("VOIPCallType"), 0))
    {
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(a.e.app_field_voip));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), a.a.voip_camerachat));
      localIntent1.putExtra("shortcut_icon_resource_id", a.a.voip_camerachat);
    }
    for (;;)
    {
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      com.tencent.mm.plugin.base.model.b.n(getContext(), localIntent1);
      paramSharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(a.e.app_field_voipaudio));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), a.a.voip_voicechat));
      localIntent1.putExtra("shortcut_icon_resource_id", a.a.voip_voicechat);
    }
  }
  
  private static String ce(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private void lI(int paramInt)
  {
    y.b("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.At(paramInt), com.tencent.mm.plugin.voip.a.b.At(this.pRS.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState))) {
      bQP();
    }
    int i;
    label65:
    com.tencent.mm.plugin.voip.a.c localc;
    if (4111 == paramInt)
    {
      i = 1;
      if ((i != 0) && (1 == this.mUIType) && (1 == this.pSh))
      {
        this.pSy = true;
        G(false, false);
        Ae(2);
      }
      localc = this.pRS;
      if (localc.Az(paramInt)) {
        break label254;
      }
      y.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
    }
    for (;;)
    {
      if (this.hcZ != null) {
        this.hcZ.post(new o.16(this, paramInt));
      }
      if ((6 == this.pRS.mState) || (260 == this.pRS.mState)) {
        aNZ();
      }
      switch (this.pRS.mState)
      {
      case 260: 
      case 261: 
      default: 
        return;
        if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState)) || (this.pSc)))
        {
          i = 1;
          break label65;
        }
        i = 0;
        break label65;
        label254:
        i = ((Integer)((Map)localc.pZH.get(Integer.valueOf(localc.mState))).get(Integer.valueOf(paramInt))).intValue();
        y.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.At(localc.mState), com.tencent.mm.plugin.voip.a.b.At(i), com.tencent.mm.plugin.voip.a.b.At(paramInt) });
        localc.mState = i;
      }
    }
    Ag(5);
    return;
    Ag(6);
  }
  
  private void ob(boolean paramBoolean)
  {
    if (this.pSd)
    {
      y.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      int j = 320;
      int i = 240;
      if (v2protocal.pUv)
      {
        y.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
        j = 640;
        i = 480;
      }
      this.pRV = new com.tencent.mm.plugin.voip.video.a(j, i);
      if (this.pRV.a(this, paramBoolean) != 1) {
        break label147;
      }
    }
    label147:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.pSL = paramBoolean;
      if (this.pSL)
      {
        this.pRV.a(this.pRW);
        com.tencent.mm.plugin.voip.b.bPx().Ak(this.pRV.bSw());
        if (this.hcZ != null) {
          this.hcZ.postDelayed(new o.14(this), 50L);
        }
      }
      return;
    }
  }
  
  public final void Ah(int paramInt)
  {
    y.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt))
    {
      lI(4101);
      com.tencent.mm.plugin.voip.b.bPx().bRg();
      com.tencent.mm.plugin.voip.b.bPx().bRh();
    }
  }
  
  public final void Ai(int paramInt)
  {
    boolean bool2 = false;
    y.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: " + paramInt);
    if (!this.pRS.Az(4110)) {
      return;
    }
    r localr = com.tencent.mm.plugin.voip.b.bPx();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localr.I(bool1, bool2);
      com.tencent.mm.plugin.voip.b.bPx().stopRing();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState))) {
        lI(4101);
      }
      lI(4110);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    y.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    if (this.pRU == paramb)
    {
      y.d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
      this.pRU = null;
    }
    if (this.hcZ != null) {
      this.hcZ = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    y.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s", new Object[] { Integer.valueOf(paramInt), this.pRV });
    if ((1 == paramInt) && (this.pRU != null)) {
      this.pRU.uninit();
    }
    this.pRU = paramb;
    this.mUIType = paramInt;
    if ((this.pRV == null) && (com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState))) {
      this.pRW = new CaptureView(ae.getContext());
    }
    if (this.pSd)
    {
      this.pRU.setCaptureView(this.pRW);
      if ((this.pRV != null) && (!this.pRV.bSu())) {
        break label284;
      }
    }
    label284:
    for (boolean bool = true;; bool = false)
    {
      bQP();
      ob(bool);
      this.pRU.en(-1, this.pRS.mState);
      this.pRU.setConnectSec(this.pSi);
      this.pRU.Ap(this.pSh);
      this.pRU.setMute(this.mIsMute);
      y.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.pSC), Integer.valueOf(this.pSD) });
      if (this.pSC != -1)
      {
        this.pRU.setHWDecMode(this.pSC);
        y.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[] { Integer.valueOf(this.pSC) });
      }
      this.pRU.setVoipBeauty(this.pSD);
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.pSm) {
      return;
    }
    if (this.pRV == null)
    {
      y.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
      return;
    }
    int j;
    int k;
    label54:
    int i;
    Object localObject1;
    label150:
    boolean bool;
    if (this.pRV.bSu())
    {
      j = OpenGlRender.FLAG_Mirror;
      if (!this.pRV.bSv()) {
        break label291;
      }
      k = OpenGlRender.FLAG_Angle270;
      if (this.pRU != null)
      {
        i = paramInt3 + paramInt4;
        localObject1 = null;
        if (this.pRV.bSu())
        {
          if ((OpenGlRender.getGLVersion() != 1) && (this.pRU.bRU() != null) && (this.pRU.bRU().length == paramInt1 * paramInt2 * 4)) {
            break label312;
          }
          if ((OpenGlRender.getGLVersion() != 2) || (this.pSK == null) || (this.pSD == 0)) {
            break label299;
          }
          localObject1 = this.pSK;
          i = 4;
        }
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          i = paramInt3 + paramInt4;
          localObject2 = paramArrayOfByte;
        }
        localObject1 = com.tencent.mm.plugin.voip.b.bPx();
        int m = localObject2.length;
        i = ((r)localObject1).pTq.pNq.pQg.b((byte[])localObject2, m, i, paramInt1, paramInt2);
        this.pRU.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, j, k, i);
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label335;
      }
      bool = true;
      label242:
      this.pSs = bool;
      if (k != OpenGlRender.FLAG_Angle270) {
        break label341;
      }
    }
    label291:
    label299:
    label312:
    label335:
    label341:
    for (paramInt3 = 270;; paramInt3 = 90)
    {
      this.pSt = paramInt3;
      paramArrayOfByte = this.pSo;
      paramArrayOfByte.qbV = paramInt2;
      paramArrayOfByte.qbU = paramInt1;
      return;
      j = 0;
      break;
      k = OpenGlRender.FLAG_Angle90;
      break label54;
      i = paramInt3 + paramInt4;
      localObject1 = paramArrayOfByte;
      break label150;
      localObject1 = this.pRU.bRU();
      i = 4;
      this.pSK = ((byte[])localObject1);
      break label150;
      bool = false;
      break label242;
    }
  }
  
  public final void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt)
  {
    if ((!this.pSL) && (this.pSd)) {
      if ((this.pRV != null) && (!this.pRV.bSu())) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      ob(bool);
      ai.d(new o.9(this, paramArrayOfInt, paramBoolean, paramInt));
      return;
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (this.pRU != null) {
      this.pRU.c(paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  public final void b(MMTextureView paramMMTextureView)
  {
    if (this.pSB != null)
    {
      com.tencent.mm.plugin.voip.video.e locale = this.pSB;
      y.i("DecodeTextureView", "steve: init hwview, recreateView: " + paramMMTextureView);
      locale.jXi = paramMMTextureView;
      locale.jXi.setSurfaceTextureListener(locale);
      if ((locale.qau != null) && (locale.qau != paramMMTextureView.getSurfaceTexture()))
      {
        y.i("DecodeTextureView", "using saved st=" + locale.qau);
        paramMMTextureView.setSurfaceTexture(locale.qau);
      }
    }
  }
  
  public final boolean bQA()
  {
    if (!this.pRS.Az(4098)) {
      return false;
    }
    y.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
    Af(4098);
    com.tencent.mm.plugin.voip.b.bPx().bRo();
    return true;
  }
  
  public final void bQC()
  {
    y.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    if (this.pRV != null) {
      this.pRV.bSq();
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11079, new Object[] { Integer.valueOf(1) });
  }
  
  public final boolean bQD()
  {
    if (com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD == 0)
    {
      this.pSg = true;
      return true;
    }
    return bQE();
  }
  
  public final void bQF()
  {
    y.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    if ((this.pSg) && (com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD != 0))
    {
      this.pSg = false;
      bQE();
    }
    if (this.pSc) {
      lI(4097);
    }
  }
  
  public final void bQH()
  {
    y.i("MicroMsg.Voip.VoipMgr", "onNoResp");
    lI(4105);
    String str2 = this.pSb.field_username;
    String str1;
    if (this.pSd)
    {
      str1 = bi.uBQ;
      if (!this.pSc) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      q.a(str2, str1, i, 4, ae.getContext().getString(a.e.voip_callout_no_resp));
      com.tencent.mm.plugin.report.service.h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(6), Integer.valueOf(aq.getNetWorkType(getContext())) });
      bQG();
      return;
      str1 = bi.uBP;
      break;
    }
  }
  
  public final void bQI()
  {
    int i = 0;
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    int j = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD;
    long l1 = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE;
    long l2 = com.tencent.mm.plugin.voip.b.bPx().bRf();
    if (this.pSc) {}
    for (;;)
    {
      localh.a(11522, true, true, new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      return;
      i = 1;
    }
  }
  
  public final void bQJ()
  {
    y.i("MicroMsg.Voip.VoipMgr", "onShutDown");
    String str1;
    String str2;
    label88:
    int i;
    if (com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState))
    {
      str1 = ae.getContext().getString(a.e.voip_call_msg_chat_time, new Object[] { ce(bk.cn(this.pSi)) });
      if ((this.pSc) || (com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState)))
      {
        String str3 = this.pSb.field_username;
        if (!this.pSd) {
          break label173;
        }
        str2 = bi.uBQ;
        if (!this.pSc) {
          break label180;
        }
        i = 1;
        label97:
        q.a(str3, str2, i, 6, str1);
      }
      if (!this.pSd) {
        break label185;
      }
      com.tencent.mm.plugin.voip.b.bPx().el(a.d.playend, 0);
      label125:
      this.pRZ = com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState);
      if (!bQQ()) {
        break label198;
      }
      this.pSf = 4106;
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.b.bPx().bRo();
      return;
      str1 = ae.getContext().getString(a.e.voip_call_connection_failed);
      break;
      label173:
      str2 = bi.uBP;
      break label88;
      label180:
      i = 0;
      break label97;
      label185:
      com.tencent.mm.plugin.voip.b.bPx().el(a.d.playend, 1);
      break label125;
      label198:
      lI(4106);
      bQG();
    }
  }
  
  public final void bQK()
  {
    if (this.pRU != null) {
      this.pRU.bQK();
    }
  }
  
  public final void bQL()
  {
    boolean bool2 = true;
    y.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    if ((f.yi().yt()) || (f.yi().yn()))
    {
      G(false, false);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        ai.d(new o.18(this));
      }
    }
    else
    {
      boolean bool1;
      if (1 == this.pSh)
      {
        bool1 = true;
        label65:
        if (!this.pSy) {
          break label88;
        }
        bool2 = false;
      }
      for (;;)
      {
        G(bool2, false);
        break;
        bool1 = false;
        break label65;
        label88:
        if (!this.pSd) {
          bool2 = bool1;
        }
      }
    }
    bQM();
  }
  
  public final long bQN()
  {
    y.l("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.pSG) });
    return this.pSG / 1000L;
  }
  
  public final void bQR()
  {
    if ((256 != this.pRS.mState) && (257 != this.pRS.mState)) {
      return;
    }
    if ((com.tencent.mm.kernel.g.DP().Dz().getInt(327945, 0) == 0) && (this.pRU.bRR() != null))
    {
      com.tencent.mm.kernel.g.DP().Dz().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.c localc = com.tencent.mm.ui.base.h.a(this.pRU.bRR(), a.e.voip_ignore_warning, a.e.app_tip, new o.6(this));
      localc.setCancelable(false);
      localc.setCanceledOnTouchOutside(false);
      localc.show();
      return;
    }
    com.tencent.mm.plugin.voip.a.d.M(ae.getContext(), a.e.voip_ignore_warning);
    bQT();
  }
  
  public final void bQS()
  {
    if (!this.pSr) {}
    for (boolean bool = true;; bool = false)
    {
      this.pSr = bool;
      if (!this.pSr) {
        break;
      }
      this.pSp.stopTimer();
      return;
    }
    aNZ();
  }
  
  public final void bQT()
  {
    com.tencent.mm.plugin.voip.b.bPx().pTw = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD;
    String str2 = this.pSb.field_username;
    String str1;
    if (this.pSd)
    {
      str1 = bi.uBQ;
      if (!this.pSc) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 0)
    {
      q.a(str2, str1, i, 6, ae.getContext().getString(a.e.voip_callfrom_ignore_msg));
      com.tencent.mm.plugin.voip.b.bPx().stopRing();
      lI(4108);
      if (this.hcZ != null) {
        this.hcZ.postDelayed(new o.7(this), 2000L);
      }
      return;
      str1 = bi.uBP;
      break;
    }
  }
  
  public final boolean bQs()
  {
    if (!this.pRS.Az(4103)) {
      return false;
    }
    Af(4103);
    com.tencent.mm.plugin.voip.b.bPx().bRo();
    return true;
  }
  
  public final boolean bQt()
  {
    if (!this.pRS.Az(4101)) {
      return false;
    }
    com.tencent.mm.plugin.voip.b.bPx().stopRing();
    com.tencent.mm.plugin.voip.b.bPx().zY(1);
    com.tencent.mm.plugin.voip.b.bPx().I(true, this.pSd);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    long l = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE;
    int j = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD;
    if (this.pSc) {}
    for (int i = 1;; i = 0)
    {
      localh.f(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      lI(4111);
      lI(4101);
      lI(4100);
      return true;
    }
  }
  
  public final boolean bQu()
  {
    int i = 0;
    if (!this.pRS.Az(4099)) {
      return false;
    }
    String str2 = this.pSb.field_username;
    if (this.pSd) {}
    for (String str1 = bi.uBQ;; str1 = bi.uBP)
    {
      if (this.pSc) {
        i = 1;
      }
      q.a(str2, str1, i, 6, ae.getContext().getString(a.e.voip_callfrom_reject_msg));
      com.tencent.mm.plugin.voip.b.bPx().stopRing();
      com.tencent.mm.plugin.voip.b.bPx().pTq.bRt();
      lI(4099);
      bQG();
      return true;
    }
  }
  
  public final boolean bQv()
  {
    if (!this.pRS.Az(4100)) {
      return false;
    }
    if ((!this.pSL) && (this.pSd)) {
      if ((this.pRV != null) && (!this.pRV.bSu())) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      ob(bool);
      this.pSL = true;
      y.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
      com.tencent.mm.plugin.voip.b.bPx().stopRing();
      com.tencent.mm.plugin.voip.b.bPx().I(false, this.pSd);
      lI(4100);
      return true;
    }
  }
  
  public final void bQw()
  {
    this.pSL = false;
  }
  
  public final boolean bQx()
  {
    int i = 0;
    if (!this.pRS.Az(4099)) {
      return false;
    }
    y.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
    String str2 = this.pSb.field_username;
    if (this.pSd) {}
    for (String str1 = bi.uBQ;; str1 = bi.uBP)
    {
      if (this.pSc) {
        i = 1;
      }
      q.a(str2, str1, i, 6, ae.getContext().getString(a.e.voip_callfrom_reject_msg));
      com.tencent.mm.plugin.voip.b.bPx().stopRing();
      com.tencent.mm.plugin.voip.b.bPx().pTq.bRt();
      lI(4099);
      bQG();
      return true;
    }
  }
  
  public final boolean bQy()
  {
    if (!this.pRS.Az(4100)) {
      return false;
    }
    y.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
    com.tencent.mm.plugin.voip.b.bPx().stopRing();
    com.tencent.mm.plugin.voip.b.bPx().I(true, this.pSd);
    lI(4111);
    lI(4100);
    return true;
  }
  
  public final boolean bQz()
  {
    if (!this.pRS.Az(4098)) {
      return false;
    }
    y.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
    Af(4098);
    com.tencent.mm.plugin.voip.b.bPx().bRo();
    return true;
  }
  
  public final void bbA()
  {
    y.i("MicroMsg.Voip.VoipMgr", "on accept");
    com.tencent.mm.plugin.voip.b.bPx().stopRing();
    lI(4100);
  }
  
  public final void bbG()
  {
    y.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
    if (this.pRU != null) {
      this.pRU.bRT();
    }
    if ((!com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState)) && (!this.pSl))
    {
      long l = System.currentTimeMillis();
      if (l - this.lqu > 30000L)
      {
        this.lqu = l;
        com.tencent.mm.plugin.voip.b.bPx().Al(a.d.voip_bad_netstatus_hint);
      }
    }
  }
  
  public final void bbH()
  {
    y.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    if (this.pRU != null) {
      this.pRU.bdl();
    }
  }
  
  public final void blN()
  {
    if ((true == this.mha) || (this.pRU == null) || (this.pRU.bRR() == null))
    {
      y.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.f.b.zB()))
    {
      y.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
      return;
    }
    if ((com.tencent.mm.compatible.util.d.gF(28)) && (((KeyguardManager)ae.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      y.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      return;
    }
    y.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
    Object localObject = com.tencent.mm.plugin.report.service.h.nFQ;
    if (this.pSd) {}
    for (int i = 0;; i = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      localObject = com.tencent.mm.ui.base.h.h(this.pRU.bRR(), a.e.voip_no_record_video_permission, a.e.app_tip);
      if (localObject != null) {
        break;
      }
      y.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
      return;
    }
    ((com.tencent.mm.ui.widget.a.c)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.c)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.c)localObject).show();
    this.mha = true;
  }
  
  public final void eq(boolean paramBoolean)
  {
    y.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.pSF), Long.valueOf(this.pSE) });
    if (this.pRS == null) {
      y.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
    }
    do
    {
      return;
      if ((Math.abs(bk.UZ() - this.pSH) < 500L) && (this.pSH != -1L))
      {
        y.d("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
        return;
      }
      if ((com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState)) && ((this.pSF != paramBoolean) || (this.pSE == -1L)))
      {
        if ((!this.pSF) && (paramBoolean) && (!com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState)) && (this.mUIType != 2) && (this.pSE != -1L))
        {
          long l = bk.cp(this.pSE);
          y.i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
          this.pSG = (l + this.pSG);
        }
        this.pSE = bk.UZ();
        this.pSF = paramBoolean;
      }
      if (this.pRU == null)
      {
        y.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
        return;
      }
    } while (((!this.pSc) && (!com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState))) || (com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState)) || (this.mUIType == 2));
    y.d("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: " + paramBoolean);
    this.pRU.setScreenEnable(paramBoolean);
    this.pSH = bk.UZ();
  }
  
  public final void ew(int paramInt)
  {
    y.i("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b, isHeadsetPlugged: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.pSk), Boolean.valueOf(f.yi().yt()) });
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      f.yi().yk();
      this.pSA = false;
      return;
    case 4: 
      f.yi().yl();
      f.yi().yj();
      bQr();
      return;
    case 1: 
      if (!com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState)) {
        if (1 != this.pSh) {
          break label182;
        }
      }
      label182:
      for (boolean bool = true;; bool = false)
      {
        this.pSk = bool;
        paramInt = com.tencent.mm.plugin.voip.b.bPx().bPH();
        f.yi().b(false, paramInt, false);
        com.tencent.mm.plugin.voip.b.bPx().jQ(false);
        com.tencent.mm.plugin.voip.b.bPx().jZ(false);
        Ae(4);
        this.pSA = false;
        com.tencent.mm.plugin.voip.b.bPx().hH(true);
        return;
      }
    }
    f.yi().yl();
    bQr();
  }
  
  public final Context getContext()
  {
    Context localContext1 = null;
    if (this.pRU != null) {
      localContext1 = this.pRU.bRR();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = ae.getContext();
    }
    return localContext2;
  }
  
  public final void hE(boolean paramBoolean)
  {
    int i = 1;
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQg;
      if (((l)localObject).iEq != null) {
        ((l)localObject).iEq.aZ(true);
      }
      com.tencent.mm.plugin.voip.b.bPx().zY(9);
      com.tencent.mm.plugin.voip.b.bPx().jY(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      localObject = com.tencent.mm.plugin.report.service.h.nFQ;
      if (paramBoolean) {
        i = 2;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      return;
      localObject = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQg;
      if (((l)localObject).iEq != null) {
        ((l)localObject).iEq.aZ(false);
      }
      com.tencent.mm.plugin.voip.b.bPx().zY(8);
      com.tencent.mm.plugin.voip.b.bPx().jY(false);
    }
  }
  
  public final void jV(boolean paramBoolean)
  {
    y.d("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (!com.tencent.mm.plugin.voip.b.bPx().bRj())
    {
      localObject = com.tencent.mm.plugin.voip.b.bPx().pTq;
      if (((s)localObject).pTJ != null) {
        ((s)localObject).pTJ.kg(paramBoolean);
      }
      if (!paramBoolean) {
        break label113;
      }
      i = 1;
      label56:
      Ae(i);
      localObject = com.tencent.mm.plugin.report.service.h.nFQ;
      if (!paramBoolean) {
        break label118;
      }
    }
    label113:
    label118:
    for (int i = 1;; i = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      return;
      G(paramBoolean, false);
      break;
      i = 2;
      break label56;
    }
  }
  
  public final void jW(boolean paramBoolean)
  {
    y.i("MicroMsg.Voip.VoipMgr", "finish");
    this.pSv = false;
    this.pSx = false;
    if (this.pSn != -1)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11700, new Object[] { Integer.valueOf(this.pSn), Long.valueOf(bk.cn(this.pSi)) });
      this.pSn = -1;
    }
    try
    {
      ae.getContext().unregisterReceiver(this.pSM);
      label77:
      com.tencent.mm.sdk.b.a.udP.d(this.lol);
      com.tencent.mm.sdk.b.a.udP.d(this.pSO);
      if (this.pRU != null)
      {
        this.pRU.uninit();
        this.pRU = null;
      }
      this.pRW = null;
      this.pSB = null;
      f.yi().b(this);
      f.yi().yl();
      label188:
      Object localObject2;
      Object localObject1;
      label239:
      long l1;
      if (com.tencent.mm.plugin.voip.b.bPx() != null)
      {
        com.tencent.mm.plugin.voip.b.bPx().stopRing();
        if (paramBoolean)
        {
          com.tencent.mm.plugin.voip.b.bPx().pTq.bRv();
          if (!this.pSd) {
            break label767;
          }
          com.tencent.mm.plugin.voip.b.bPx().a(false, true, this.djD);
          localObject2 = com.tencent.mm.plugin.voip.b.bPx();
          localObject1 = ae.getContext();
          localObject2 = ((r)localObject2).pTq;
          if ((localObject1 == ((s)localObject2).pNq.hxz) && (this == ((s)localObject2).pNq.pQf)) {
            break label782;
          }
          com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
        }
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.voip.b.bPx();
        ((r)localObject1).pTr = null;
        ((r)localObject1).pTz = null;
        ((r)localObject1).pTA = false;
        if (!this.pRY) {
          break label817;
        }
        this.pRX = new o.a(this);
        com.tencent.mm.sdk.f.e.post(this.pRX, "VoipMgr_clean");
        label291:
        if ((this.loj != null) && (this.lok != null))
        {
          this.loj.listen(this.lok, 0);
          this.lok = null;
        }
        if (this.pRT != null) {
          this.pRT.ek(ae.getContext());
        }
        this.loj = null;
        com.tencent.mm.booter.a.vR().vS();
        p.bQU().bQW();
        p.bQU().pTc = null;
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        if (this.iah != null)
        {
          y.d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
          this.iah.crJ();
          this.iah = null;
          this.pSF = false;
          this.pSG = 0L;
          this.pSE = -1L;
        }
        this.pSH = -1L;
        com.tencent.mm.plugin.voip.b.bPx().bRo();
        y.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.pRZ) });
        if (this.pRZ)
        {
          localObject1 = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQq;
          com.tencent.mm.kernel.g.DQ();
          long l2 = ((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzG, Long.valueOf(-1L))).longValue();
          if (l2 <= 0L) {
            break label824;
          }
          l1 = l2;
          label524:
          ((VoipScoreState)localObject1).pTp = l1;
          l1 = bd.HM();
          y.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((VoipScoreState)localObject1).pTo) });
          if ((bk.bl(((VoipScoreState)localObject1).pTn)) || (((VoipScoreState)localObject1).pTo <= 0) || ((l2 > 0L) && (l1 - l2 <= ((VoipScoreState)localObject1).pTo * 86400000L))) {
            break label829;
          }
          y.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
        }
      }
      label782:
      label817:
      label824:
      label829:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          com.tencent.mm.plugin.voip.b.bPx();
          VoipScoreState.bRa();
          localObject1 = new Intent(getContext(), VoipScoreDialog.class);
          ((Intent)localObject1).putExtra("key_score_state", com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQq);
          if (!(getContext() instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          getContext().startActivity((Intent)localObject1);
        }
        com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQq = new VoipScoreState();
        localObject1 = new td();
        ((td)localObject1).ccJ.bNb = 11;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        this.pSK = null;
        return;
        com.tencent.mm.plugin.voip.b.bPx().bRc();
        break;
        label767:
        com.tencent.mm.plugin.voip.b.bPx().a(false, false, this.djD);
        break label188;
        ((s)localObject2).pNq.hxz = null;
        ((s)localObject2).pNq.pQf = u.pUd;
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
        com.tencent.mm.plugin.voip.a.a.flushLogFile();
        break label239;
        bQO();
        break label291;
        l1 = 0L;
        break label524;
      }
    }
    catch (Exception localException)
    {
      break label77;
    }
  }
  
  public final boolean jX(boolean paramBoolean)
  {
    if ((this.pSx) && (!paramBoolean))
    {
      y.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
      return false;
    }
    y.b("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    y.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
    if (this.pRU != null)
    {
      this.pRU.uninit();
      this.pRU = null;
    }
    if (this.hcZ != null) {
      this.hcZ.post(new o.5(this, paramBoolean));
    }
    return true;
  }
  
  public final void onConnected()
  {
    lI(4102);
    this.pSi = bk.UX();
    if (this.pRU != null) {
      this.pRU.setConnectSec(this.pSi);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.bPY();
    boolean bool2 = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.bPX();
    if ((this.pSd) && (this.pSc) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.b.bPx().zY(1);
    }
    if (!com.tencent.mm.plugin.voip.a.b.Ax(this.pRS.mState)) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    Object localObject = com.tencent.mm.plugin.voip.b.bPx().pTq;
    if (((s)localObject).pTJ != null)
    {
      localObject = ((s)localObject).pTJ;
      bool1 = ((i)localObject).mContext.getSharedPreferences(ae.cqR(), 0).getBoolean("settings_shake", true);
      bk.v(((i)localObject).mContext, bool1);
    }
    localObject = com.tencent.mm.plugin.voip.b.bPx();
    int i = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.pUL;
    localObject = ((r)localObject).pTq;
    ((s)localObject).bci = null;
    ((s)localObject).pTQ = null;
    ((s)localObject).pTO = 0;
    if (i > 0) {
      s.pTM = i;
    }
    ((s)localObject).bci = ((WifiManager)ae.getContext().getApplicationContext().getSystemService("wifi"));
    ((s)localObject).pTP = new Timer();
    ((s)localObject).pTP.schedule(new s.6((s)localObject), 0L, s.pTM * 1000);
    TelephonyManager localTelephonyManager = (TelephonyManager)ae.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      localTelephonyManager.listen(new s.5((s)localObject, localTelephonyManager), 256);
    }
    p.bQU().bQV();
    p.bQU().pTc = this;
  }
  
  public final void onError(int paramInt, String paramString)
  {
    String str1;
    if (this.pSd)
    {
      com.tencent.mm.plugin.voip.b.bPx().el(a.d.playend, 0);
      str1 = paramString;
      if (paramInt == 241)
      {
        str1 = paramString;
        if (bk.bl(paramString)) {
          str1 = getContext().getString(a.e.voip_overload_protection_default_wording);
        }
      }
      if (this.pRU != null) {
        this.pRU.aN(paramInt, str1);
      }
      lI(4109);
      y.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD) });
      paramString = ae.getContext();
      y.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode" + paramInt);
      if (paramInt != 235) {
        break label347;
      }
      paramString = paramString.getString(a.e.voip_callout_error_msg_unsupport);
      label156:
      if ((com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD == 0) || (com.tencent.mm.plugin.voip.b.bPx().pTv.get(Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD)) != null)) {
        break label443;
      }
      str2 = this.pSb.field_username;
      if (!this.pSd) {
        break label430;
      }
      str1 = bi.uBQ;
      if (!this.pSc) {
        break label438;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState)) {
        paramString = ae.getContext().getString(a.e.voip_call_msg_chat_time_interrupt_by_err, new Object[] { ce(bk.cn(this.pSi)) });
      }
      l = q.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.b.bPx().pTv.put(Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(l));
    }
    label347:
    while (com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.b.bPx().bRo();
        bQG();
        return;
        com.tencent.mm.plugin.voip.b.bPx().el(a.d.playend, 1);
        break;
        if (paramInt == 233)
        {
          paramString = paramString.getString(a.e.voip_call_fail);
          break label156;
        }
        if (paramInt == 237)
        {
          paramString = paramString.getString(a.e.voip_callout_error_msg_unsupport);
          break label156;
        }
        if (paramInt == 236)
        {
          paramString = paramString.getString(a.e.voip_call_fail);
          break label156;
        }
        if (paramInt == 211)
        {
          paramString = paramString.getString(a.e.voip_callout_error_msg_busy);
          break label156;
        }
        paramString = paramString.getString(a.e.voip_call_connection_failed);
        break label156;
        str1 = bi.uBP;
        continue;
        paramInt = 0;
      }
    }
    label430:
    label438:
    label443:
    String str2 = this.pSb.field_username;
    if (this.pSd)
    {
      str1 = bi.uBQ;
      label482:
      if (!this.pSc) {
        break label555;
      }
    }
    label555:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.a.b.Aw(this.pRS.mState)) {
        paramString = ae.getContext().getString(a.e.voip_call_msg_chat_time_interrupt_by_err, new Object[] { ce(bk.cn(this.pSi)) });
      }
      q.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = bi.uBP;
      break label482;
    }
  }
  
  public final void onReject()
  {
    y.i("MicroMsg.Voip.VoipMgr", "onReject");
    lI(4099);
    String str2 = this.pSb.field_username;
    String str1;
    if (this.pSd)
    {
      str1 = bi.uBQ;
      if (!this.pSc) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      q.a(str2, str1, i, 6, ae.getContext().getString(a.e.voip_callout_reject_msg));
      bQG();
      return;
      str1 = bi.uBP;
      break;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    this.pSC = paramInt;
    if (this.pRU != null) {
      this.pRU.setHWDecMode(paramInt);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    y.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + paramInt + "，mVoipUI: " + this.pRU);
    if (this.pRU != null) {
      this.pRU.setVoipBeauty(paramInt);
    }
    if ((paramInt != 0) && (this.pSD != paramInt)) {
      com.tencent.mm.plugin.report.service.h.nFQ.h(914L, 20L, 1L);
    }
    this.pSD = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o
 * JD-Core Version:    0.7.0.1
 */