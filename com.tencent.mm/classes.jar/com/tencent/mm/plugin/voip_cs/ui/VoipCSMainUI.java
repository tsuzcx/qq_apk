package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.e.c.a;
import com.tencent.mm.h.a.rf;
import com.tencent.mm.model.al;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.a.c;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.Arrays;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(3)
public class VoipCSMainUI
  extends MMActivity
  implements com.tencent.mm.plugin.voip_cs.b.b, com.tencent.mm.plugin.voip_cs.b.b.a.a
{
  private String appId = "";
  private com.tencent.mm.compatible.util.b bDz;
  public String bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording_mp_video);
  public String bso = "";
  private ah dPi;
  public String foS = "";
  private TelephonyManager loj;
  PhoneStateListener lok = new VoipCSMainUI.5(this);
  private n nIV = new VoipCSMainUI.10(this);
  private HeadsetPlugReceiver pRT = null;
  private BroadcastReceiver pSM = new VoipCSMainUI.4(this);
  private HeadsetPlugReceiver.a pSN = new VoipCSMainUI.3(this);
  private com.tencent.mm.plugin.voip_cs.b.a.b qeO;
  private com.tencent.mm.plugin.voip_cs.b.a.c qeP;
  private boolean qeQ = false;
  public String qeR = "";
  public String qeS = "";
  public String qeT = "";
  public boolean qeU = false;
  private am qeV = new am(Looper.getMainLooper(), new VoipCSMainUI.18(this), true);
  f.a qeW = new VoipCSMainUI.2(this);
  public String qec = "";
  private com.tencent.mm.plugin.voip_cs.b.a.a qei;
  public CharSequence tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording_mp_video);
  public CharSequence title = ae.getContext().getString(a.e.voip_cs_func_name_appbrand_video);
  public String type = "";
  
  private void bTf()
  {
    Object localObject1;
    Object localObject2;
    boolean bool1;
    boolean bool2;
    label319:
    boolean bool3;
    label331:
    int i;
    label528:
    int j;
    int k;
    int m;
    Object localObject3;
    Object localObject4;
    if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb <= 0)
    {
      localObject1 = this.qeO;
      if (((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qeB.crl())
      {
        localObject2 = ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qeB;
        l = ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qew;
        ((am)localObject2).S(l, l);
      }
      localObject1 = this.qeO;
      if (((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qeC.crl())
      {
        localObject2 = ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qeC;
        l = ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qex;
        ((am)localObject2).S(l, l);
      }
      localObject1 = com.tencent.mm.plugin.voip_cs.b.c.bSO();
      ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).lqJ = false;
      ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).lqI = false;
      if (((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).qeL.isInited)
      {
        y.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
        ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).qeL.kb(false);
        ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).qeL.reset();
      }
      ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).qeL.pUz = 1;
      long l = System.currentTimeMillis();
      localObject1 = ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).qeL;
      ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).netType = com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext());
      ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).pUy = ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).netType;
      com.tencent.mm.plugin.voip_cs.b.c.bSQ().pUy = ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).netType;
      if (((com.tencent.mm.plugin.voip_cs.b.a)localObject1).netType == 5) {
        ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).netType = 4;
      }
      if ((((com.tencent.mm.plugin.voip_cs.b.a)localObject1).pUy >= 4) && ((com.tencent.mm.plugin.voip_cs.b.a.cpuFlag0 & 0x400) != 0) && ((com.tencent.mm.plugin.voip_cs.b.a.cpuFlag0 & 0xFF) >= 30))
      {
        bool1 = true;
        if ((com.tencent.mm.compatible.e.q.dyd.dwA != 1) || (com.tencent.mm.compatible.e.q.dyd.dwc.width < 480) || (com.tencent.mm.compatible.e.q.dyd.dwc.height < 360) || (com.tencent.mm.compatible.e.q.dyd.dwe.width < 480) || (com.tencent.mm.compatible.e.q.dyd.dwe.height < 360)) {
          break label1392;
        }
        bool2 = true;
        if (com.tencent.mm.compatible.e.q.dyd.dwA != 0) {
          break label1398;
        }
        bool3 = true;
        if (((bool1) || (bool2)) && (!bool3))
        {
          ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).defaultWidth = 480;
          ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).defaultHeight = 360;
          com.tencent.mm.plugin.voip_cs.b.a.pUv = true;
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).defaultWidth + "x" + ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).defaultHeight);
        }
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (com.tencent.mm.plugin.voip_cs.b.a.cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool1 + ", bEnable480FromSvr:" + bool2 + ", bDisable480FromSvr:" + bool3);
        ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).pVv = new int[((com.tencent.mm.plugin.voip_cs.b.a)localObject1).defaultWidth * ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).defaultHeight];
        com.tencent.mm.kernel.g.DN();
        ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).pUx = com.tencent.mm.kernel.a.CK();
        if ((com.tencent.mm.plugin.voip_cs.b.a.cpuFlag0 & 0x400) == 0) {
          break label1404;
        }
        com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v7a.so");
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.CSV2protocal", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
        i = Build.VERSION.SDK_INT;
        j = OpenGlRender.getGLVersion();
        localObject2 = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay();
        k = ((Display)localObject2).getWidth();
        m = ((Display)localObject2).getHeight();
        i = ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).init(((com.tencent.mm.plugin.voip_cs.b.a)localObject1).netType, 2, ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).defaultWidth << 16 | ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).defaultHeight, k << 16 | m, ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).pUx, i << 16 | j << 24 | com.tencent.mm.plugin.voip_cs.b.a.cpuFlag0, com.tencent.mm.compatible.util.e.dOO + "app_lib/", 8);
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.CSV2protocal", "protocal init ret :" + i + ",uin= " + ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).pUx);
        ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).isInited = true;
        if (i < 0) {
          ((com.tencent.mm.plugin.voip_cs.b.a)localObject1).reset();
        }
        y.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
        if (i < 0) {
          y.e("MicroMsg.VoipCSEngine", "engine init failed!");
        }
        localObject3 = com.tencent.mm.plugin.voip_cs.b.c.bSP();
        localObject4 = this.qec;
        String str1 = this.appId;
        String str2 = this.qeT;
        y.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + (String)localObject4 + ",appid:" + str1 + ",voipCSContext:" + str2);
        ((com.tencent.mm.plugin.voip_cs.b.e)localObject3).qec = ((String)localObject4);
        ((com.tencent.mm.plugin.voip_cs.b.e)localObject3).qeb = 1;
        localObject1 = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
        y.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
        if (((com.tencent.mm.plugin.voip_cs.b.d)localObject1).qdO == 0) {
          ((com.tencent.mm.plugin.voip_cs.b.d)localObject1).qdO = ((int)(System.currentTimeMillis() / 1000L));
        }
        localObject2 = null;
        localObject1 = localObject2;
        if (str2 != null)
        {
          localObject1 = localObject2;
          if (!str2.equals("")) {
            localObject1 = str2.getBytes();
          }
        }
        com.tencent.mm.kernel.g.Dk().a(823, (com.tencent.mm.ah.f)localObject3);
        com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.lpG = ((int)(System.currentTimeMillis() / 1000L));
        localObject1 = new com.tencent.mm.plugin.voip_cs.b.c.c(com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.lpG, (String)localObject4, com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.netType, (byte[])localObject1, com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.field_capInfo, str1);
        y.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.field_capInfo));
        com.tencent.mm.kernel.g.Dk().a((m)localObject1, 0);
      }
    }
    else
    {
      if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb < 2) {
        this.qei.bSX();
      }
      localObject1 = this.qeO;
      y.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
      if (((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).mws == null)
      {
        y.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
        ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).mws = new ObservableTextureView(((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qej);
        localObject2 = new RelativeLayout.LayoutParams(1, 1);
        ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).mws.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qek.addView(((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).mws, new RelativeLayout.LayoutParams(1, 1));
        ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).mws.setVisibility(0);
      }
      if (((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer == null)
      {
        j = 320;
        i = 240;
        com.tencent.mm.plugin.voip_cs.b.c.bSO();
        if (com.tencent.mm.plugin.voip_cs.b.a.pUv)
        {
          j = 640;
          i = 480;
        }
        y.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
        ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer = new com.tencent.mm.plugin.voip_cs.c.a(j, i);
        ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer.a((com.tencent.mm.plugin.voip.video.g)localObject1, true);
        ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer.a(((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).mws);
        com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.pUN = ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer.bSw();
        ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer.bSr();
        localObject2 = ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer;
      }
    }
    for (;;)
    {
      try
      {
        if (((com.tencent.mm.plugin.voip_cs.c.a)localObject2).pZU != null)
        {
          localObject3 = ((com.tencent.mm.plugin.voip_cs.c.a)localObject2).pZU.getPreviewSize();
          localObject4 = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
          if (!((com.tencent.mm.plugin.voip_cs.c.a)localObject2).pZX) {
            continue;
          }
          i = 1;
          ((com.tencent.mm.plugin.voip_cs.c.a)localObject2).pZU.getPreviewFrameRate();
          j = ((com.tencent.mm.plugin.voip_cs.c.a)localObject2).qak;
          k = ((com.tencent.mm.plugin.voip_cs.c.a)localObject2).qal;
          m = ((Camera.Size)localObject3).width;
          int n = ((Camera.Size)localObject3).height;
          y.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
          ((com.tencent.mm.plugin.voip_cs.b.d)localObject4).qdl = i;
          ((com.tencent.mm.plugin.voip_cs.b.d)localObject4).qdh = j;
          ((com.tencent.mm.plugin.voip_cs.b.d)localObject4).qdi = k;
          ((com.tencent.mm.plugin.voip_cs.b.d)localObject4).qdj = m;
          ((com.tencent.mm.plugin.voip_cs.b.d)localObject4).qdk = n;
        }
      }
      catch (Exception localException)
      {
        label1392:
        label1398:
        label1404:
        y.e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + localException.getMessage());
        continue;
      }
      y.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer.bSu()), Boolean.valueOf(((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).qer.bSv()) });
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label319;
      bool3 = false;
      break label331;
      if ((com.tencent.mm.plugin.voip_cs.b.a.cpuFlag0 & 0x200) != 0)
      {
        com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec.so");
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.CSV2protocal", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
        break label528;
      }
      com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v5.so");
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.CSV2protocal", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
      Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
      break label528;
      i = 0;
    }
  }
  
  private boolean bTg()
  {
    if (!com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", ""))
    {
      y.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "");
    y.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
    if (!bool)
    {
      y.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
      return false;
    }
    return true;
  }
  
  private int bcy()
  {
    int i = 2;
    if (com.tencent.mm.compatible.b.f.yi().yn()) {
      i = com.tencent.mm.compatible.b.f.yi().yz();
    }
    for (;;)
    {
      y.d("MicroMsg.voipcs.VoipCSMainUI", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      return i;
      if (this.qei.bRj())
      {
        if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb != 2)
        {
          com.tencent.mm.plugin.voip_cs.b.a.c localc = this.qeP;
          if (localc.pQB != null)
          {
            i = localc.pQB.bPH();
            continue;
          }
        }
        i = 0;
      }
    }
  }
  
  public final void AB(int paramInt)
  {
    y.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + paramInt + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb);
    if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb == 0) {
      finish();
    }
    while (this.qeO == null) {
      return;
    }
    this.qeO.AE(paramInt);
  }
  
  public final void bTe()
  {
    y.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
    this.qeO.AE(5);
  }
  
  public final void bbF()
  {
    this.qeO.bbF();
    Object localObject;
    int i;
    if ((com.tencent.mm.compatible.b.f.yi().yt()) || (com.tencent.mm.compatible.b.f.yi().yn()))
    {
      this.qeP.kj(false);
      localObject = this.qeP;
      if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).iEq == null) {
        break label215;
      }
      boolean bool = ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).iEq.uq();
      com.tencent.mm.plugin.voip_cs.b.c.bSQ().qdA = 1;
      if (!bool) {
        break label215;
      }
      i = 1;
      label66:
      com.tencent.mm.plugin.voip_cs.b.c.bSQ().qdT = i;
      localObject = this.qeP;
      if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).pQB != null) {
        break label220;
      }
      com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.pUO = Math.abs(1);
    }
    for (;;)
    {
      this.qei.stopRing();
      localObject = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
      if (((com.tencent.mm.plugin.voip_cs.b.d)localObject).qdO != 0) {
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject).qdD = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.b.d)localObject).qdO);
      }
      localObject = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
      y.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
      if (((com.tencent.mm.plugin.voip_cs.b.d)localObject).qdR == 0) {
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject).qdR = ((int)(System.currentTimeMillis() / 1000L));
      }
      localObject = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
      y.d("MicroMsg.VoipCSReportHelper", "markConnect");
      if (((com.tencent.mm.plugin.voip_cs.b.d)localObject).qdQ != 0) {
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject).qdF = ((int)(System.currentTimeMillis() / 1000L) - ((com.tencent.mm.plugin.voip_cs.b.d)localObject).qdQ);
      }
      return;
      this.qeP.kj(true);
      break;
      label215:
      i = -1;
      break label66;
      label220:
      ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).pQB.bPD();
      if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject).pQB.bPD() <= 0) {
        com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.pUO = Math.abs(1);
      }
    }
  }
  
  public final void fd(String paramString1, String paramString2)
  {
    com.tencent.mm.plugin.voip_cs.b.a.b localb = this.qeO;
    if ((localb.qeA.equals("")) && (bk.bl(paramString2))) {
      if (localb.qej.qeU)
      {
        localb.doV.setText(a.e.voip_cs_biz_user_name_appbrand);
        if ((!localb.qez.equals("")) || (!bk.bl(paramString1)) || ((localb.qej.foS != null) && (!localb.qej.foS.equals("")))) {
          break label120;
        }
        localb.qep.setImageResource(com.tencent.mm.plugin.voip_cs.a.a.default_avatar);
      }
    }
    label120:
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localb.doV.setText(a.e.voip_cs_biz_user_name);
      break;
      localb.Qe(paramString2);
      break;
      localSharedPreferences = ae.cqS();
      if ((!bk.bl(paramString1)) && (!localb.qez.equals(paramString1)))
      {
        localb.Qf(paramString1);
        localSharedPreferences.edit().putString(localb.bSY(), paramString1).commit();
      }
    } while ((bk.bl(paramString2)) || (localb.qeA.equals(paramString2)));
    localb.Qe(paramString2);
    localSharedPreferences.edit().putString(localb.bSZ(), paramString2).commit();
  }
  
  protected final int getLayoutId()
  {
    return a.c.voip_cs_main;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    y.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.qec = getIntent().getStringExtra("voipCSBizId");
    this.appId = getIntent().getStringExtra("voipCSAppId");
    this.bso = bk.pm(getIntent().getStringExtra("voipCSScene"));
    this.type = bk.pm(getIntent().getStringExtra("voipCSType"));
    this.qeR = getIntent().getStringExtra("voipCSAllowBackCamera");
    this.qeS = getIntent().getStringExtra("voipCSShowOther");
    this.foS = getIntent().getStringExtra("voipCSAvatarUrl");
    this.qeT = getIntent().getStringExtra("voipCSContext");
    this.qeU = getIntent().getBooleanExtra("launch_from_appbrand", false);
    getWindow().addFlags(6946944);
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().addFlags(67108864);
    }
    this.dPi = new ah();
    paramBundle = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
    y.d("MicroMsg.VoipCSReportHelper", "reset");
    paramBundle.aYU = 0;
    paramBundle.qdd = 0;
    paramBundle.qde = 0;
    paramBundle.qdf = 0;
    paramBundle.videoFps = 0;
    paramBundle.qdg = 0;
    paramBundle.qdh = 0;
    paramBundle.qdi = 0;
    paramBundle.qdj = 0;
    paramBundle.qdk = 0;
    paramBundle.qdl = 0;
    paramBundle.networkType = 0;
    paramBundle.qdm = 0;
    paramBundle.qdn = com.tencent.mm.plugin.voip_cs.b.d.qdb;
    paramBundle.qdo = 0;
    paramBundle.qdp = 0L;
    paramBundle.lpE = 0L;
    paramBundle.qdq = "";
    paramBundle.pUy = 0;
    paramBundle.qdt = 0;
    paramBundle.qdu = 0;
    paramBundle.qdv = 0;
    paramBundle.pUS = 0;
    paramBundle.pUR = 0;
    paramBundle.qdw = 0;
    paramBundle.qdx = 0;
    paramBundle.qdy = 0;
    paramBundle.qdz = 0;
    paramBundle.qdA = 0;
    paramBundle.qdB = 0;
    paramBundle.qdC = 0L;
    paramBundle.qdD = 0;
    paramBundle.qdE = 0L;
    paramBundle.qdF = 0L;
    paramBundle.qdG = 0L;
    paramBundle.lqV = 0L;
    paramBundle.qdH = 0;
    paramBundle.qdI = 0;
    paramBundle.channelStrategy = 1;
    paramBundle.pWh = 0;
    paramBundle.pUT = 0;
    paramBundle.qdJ = 0;
    paramBundle.qdK = 0;
    paramBundle.lrf = "";
    paramBundle.lre = "";
    paramBundle.qdO = 0;
    paramBundle.qdP = 0;
    paramBundle.qdQ = 0;
    paramBundle.qdR = 0;
    paramBundle.qdS = 0;
    this.loj = ((TelephonyManager)ae.getContext().getSystemService("phone"));
    com.tencent.mm.plugin.voip_cs.b.c.bSP().qec = this.qec;
    this.qeO = new com.tencent.mm.plugin.voip_cs.b.a.b(this);
    this.qeP = new com.tencent.mm.plugin.voip_cs.b.a.c();
    this.bDz = new com.tencent.mm.compatible.util.b(ae.getContext());
    this.qei = com.tencent.mm.plugin.voip_cs.b.a.a.bSV();
    com.tencent.mm.plugin.voip_cs.b.c.bSO().qeM = this;
    com.tencent.mm.plugin.voip_cs.b.c.bSP().qdU = this;
    if ((com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb == 0) || (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb == 3)) {
      com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb = 0;
    }
    com.tencent.mm.booter.a.vR().vT();
    this.bDz.requestFocus();
    com.tencent.mm.compatible.b.f.yi().yk();
    com.tencent.mm.compatible.b.f.yi().a(this.qeW);
    this.pRT = new HeadsetPlugReceiver();
    this.pRT.a(ae.getContext(), this.pSN);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.USER_PRESENT");
    ae.getContext().registerReceiver(this.pSM, paramBundle);
    com.tencent.mm.kernel.g.DO().a(this.nIV);
    int i;
    if (this.qeU) {
      if (this.bso.equals("1")) {
        if (this.type.equals("video"))
        {
          this.title = ae.getContext().getString(a.e.voip_cs_func_name);
          this.tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording);
          this.bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording);
          i = this.loj.getCallState();
          if ((i != 2) && (i != 1)) {
            break label1169;
          }
          y.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          h.a(this, a.e.voip_cs_phone_in_use, a.e.app_tip, new VoipCSMainUI.1(this));
          i = 1;
          label809:
          if (i == 0) {
            break label1174;
          }
          y.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
        }
      }
    }
    label1169:
    label1174:
    do
    {
      return;
      this.title = ae.getContext().getString(a.e.voip_cs_func_name_appbrand_audio);
      this.tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording_appbrand_audio);
      this.bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording_appbrand_audio);
      break;
      if (this.type.equals("video"))
      {
        this.title = ae.getContext().getString(a.e.voip_cs_func_name_appbrand_video);
        this.tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording_appbrand_video);
        this.bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording_appbrand_video);
        break;
      }
      this.title = ae.getContext().getString(a.e.voip_cs_func_name_appbrand_audio);
      this.tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording_appbrand_audio);
      this.bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording_appbrand_audio);
      break;
      if (this.bso.equals("1"))
      {
        if (this.type.equals("video"))
        {
          this.title = ae.getContext().getString(a.e.voip_cs_func_name);
          this.tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording);
          this.bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording);
          break;
        }
        this.title = ae.getContext().getString(a.e.voip_cs_func_name_appbrand_audio);
        this.tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording_mp_video);
        this.bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording_mp_video);
        break;
      }
      if (this.type.equals("video"))
      {
        this.title = ae.getContext().getString(a.e.voip_cs_func_name_appbrand_video);
        this.tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording_mp_video);
        this.bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording_mp_video);
        break;
      }
      this.title = ae.getContext().getString(a.e.voip_cs_func_name_appbrand_audio);
      this.tickerText = ae.getContext().getString(a.e.voip_cs_minimize_wording_mp_audio);
      this.bQZ = ae.getContext().getString(a.e.voip_cs_minimize_wording_mp_audio);
      break;
      i = 0;
      break label809;
      this.loj.listen(this.lok, 32);
      if (!aq.isNetworkConnected(this))
      {
        y.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
        h.a(this, a.e.voip_cs_net_unavailable, a.e.voip_not_wifi_warnning_title, new VoipCSMainUI.15(this));
        i = 0;
      }
      while (i == 0)
      {
        y.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
        return;
        if ((aq.isWifi(this)) || (com.tencent.mm.plugin.voip.model.q.bQY()))
        {
          i = 1;
        }
        else
        {
          y.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
          h.a(this, a.e.voip_cs_not_wifi_warnning_message, a.e.voip_not_wifi_warnning_title, new VoipCSMainUI.16(this), new VoipCSMainUI.17(this));
          i = 0;
        }
      }
      if (com.tencent.mm.plugin.voip.a.d.bSm())
      {
        y.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
        h.a(this, a.e.in_voip_tip, a.e.app_tip, new VoipCSMainUI.11(this));
        i = 1;
      }
      while (i != 0)
      {
        y.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
        return;
        if (com.tencent.mm.plugin.voip.a.d.bSl())
        {
          y.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
          h.a(this, a.e.in_wechat_out_tip, a.e.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              paramAnonymousDialogInterface.dismiss();
              VoipCSMainUI.this.AB(0);
            }
          });
          i = 1;
        }
        else if (com.tencent.mm.r.a.Bv())
        {
          y.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
          h.a(this, a.e.in_multitalk_tip, a.e.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              paramAnonymousDialogInterface.dismiss();
              VoipCSMainUI.this.AB(0);
            }
          });
          i = 1;
        }
        else if (com.tencent.mm.bf.e.RT())
        {
          y.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
          h.a(this, a.e.in_new_share_location_tip, a.e.app_tip, new VoipCSMainUI.14(this));
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    } while (!bTg());
    bTf();
  }
  
  protected void onDestroy()
  {
    int j = 2;
    y.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
    if (this.bDz != null) {
      this.bDz.zE();
    }
    Object localObject1 = new rf();
    Object localObject2;
    if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qed == -1)
    {
      ((rf)localObject1).caN.status = 3;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = this.qeP;
      localObject2 = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
      if ((((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).pQB == null) || (com.tencent.mm.plugin.voip_cs.b.c.bSQ().qdA != 1)) {
        break label1351;
      }
    }
    label162:
    label694:
    label1341:
    label1346:
    label1351:
    for (int i = ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).pQB.bPH();; i = 0)
    {
      float f = com.tencent.mm.compatible.b.f.yi().getStreamMaxVolume(i);
      ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).qdK = ((int)(com.tencent.mm.compatible.b.f.yi().getStreamVolume(i) / f * 100.0F));
      localObject2 = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
      label248:
      Object localObject3;
      byte[] arrayOfByte;
      if ((((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).iEq != null) && (com.tencent.mm.plugin.voip_cs.b.c.bSQ().qdA == 1))
      {
        i = ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).iEq.us();
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).pUT = i;
        if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).iEq != null) {
          ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).iEq.uh();
        }
        if (((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).pQB != null) {
          ((com.tencent.mm.plugin.voip_cs.b.a.c)localObject1).pQB.bPF();
        }
        this.qei.stopRing();
        if (this.qeO != null)
        {
          localObject1 = this.qeO;
          if (com.tencent.mm.plugin.voip_cs.b.c.bSQ().aYU == 0)
          {
            if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb >= 2) {
              break label1301;
            }
            com.tencent.mm.plugin.voip_cs.b.c.bSQ().aYU = 1;
          }
          ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).pXw.bSy();
          ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).pXx.bSy();
          ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).bTa();
          ((com.tencent.mm.plugin.voip_cs.b.a.b)localObject1).bTd();
          localObject1 = com.tencent.mm.plugin.voip_cs.b.c.bSP();
          y.i("MicroMsg.voipcs.VoipCSService", "now stop service");
          com.tencent.mm.kernel.g.Dk().b(823, (com.tencent.mm.ah.f)localObject1);
          com.tencent.mm.kernel.g.Dk().b(106, (com.tencent.mm.ah.f)localObject1);
          com.tencent.mm.kernel.g.Dk().b(818, (com.tencent.mm.ah.f)localObject1);
          com.tencent.mm.kernel.g.Dk().b(795, (com.tencent.mm.ah.f)localObject1);
          com.tencent.mm.kernel.g.Dk().b(285, (com.tencent.mm.ah.f)localObject1);
          com.tencent.mm.kernel.g.Dk().b(312, (com.tencent.mm.ah.f)localObject1);
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qeb = 3;
          if (((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qed != 823)
          {
            com.tencent.mm.kernel.g.Dk().a(880, (com.tencent.mm.ah.f)localObject1);
            if (((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdW != 0) {
              break label1311;
            }
            i = 1;
            y.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qec + ",inviteId：" + com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.lpG + ",csroomId:" + com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.pUA + ",roomkey:" + com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.lpE + ",reason:" + i);
            localObject2 = new com.tencent.mm.plugin.voip_cs.b.c.a(com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.lpG, com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.pUA, com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.lpE, ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qec, i);
            com.tencent.mm.kernel.g.Dk().a((m)localObject2, 0);
          }
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qef.stopTimer();
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qeg.stopTimer();
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdV = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdr = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdW = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdX = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdY = null;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).lpN = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdZ = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qeb = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qec = "";
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qea = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qed = 0;
          ((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qee = 999;
          localObject1 = com.tencent.mm.plugin.voip_cs.b.c.bSO();
          y.i("MicroMsg.VoipCSEngine", "now stop engine");
          ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).qeL.kb(true);
          localObject2 = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
          if ((bk.bl(((com.tencent.mm.plugin.voip_cs.b.d)localObject2).lrf)) && (bk.bl(((com.tencent.mm.plugin.voip_cs.b.d)localObject2).lre)))
          {
            localObject3 = com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL;
            if (((com.tencent.mm.plugin.voip_cs.b.d)localObject2).qdy != 1) {
              break label1341;
            }
            i = 1;
            arrayOfByte = ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).qcS;
            j = ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).qcS.length;
            if (i == 0) {
              break label1346;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).getVoipcsChannelInfo(arrayOfByte, j, i);
        y.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.b.a)localObject3).field_voipcsChannelInfoLength) });
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).lrf = new String(((com.tencent.mm.plugin.voip_cs.b.a)localObject3).qcS, 0, ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).field_voipcsChannelInfoLength);
        localObject3 = com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL;
        ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).getVoipcsEngineInfo(((com.tencent.mm.plugin.voip_cs.b.a)localObject3).qcT, ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).qcT.length);
        y.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.b.a)localObject3).field_voipcsEngineInfoLength) });
        localObject3 = ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).lpL + "," + ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).lpE + "," + ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).pUA + "," + com.tencent.mm.plugin.voip_cs.b.c.bSQ().qdA + "," + ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).pUN + "," + ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).pUO + ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).bRG() + new String(((com.tencent.mm.plugin.voip_cs.b.a)localObject3).qcT, 0, ((com.tencent.mm.plugin.voip_cs.b.a)localObject3).field_voipcsEngineInfoLength);
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:" + (String)localObject3);
        ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).lre = ((String)localObject3);
        y.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).lrf });
        y.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.voip_cs.b.d)localObject2).lre });
        localObject2 = com.tencent.mm.plugin.voip_cs.b.c.bSP();
        com.tencent.mm.kernel.g.Dk().a(312, (com.tencent.mm.ah.f)localObject2);
        localObject2 = new com.tencent.mm.plugin.voip_cs.b.c.e(com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.pUA, com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.lpE);
        com.tencent.mm.kernel.g.Dk().a((m)localObject2, 0);
        ((com.tencent.mm.plugin.voip_cs.b.b.a)localObject1).qeL.reset();
        com.tencent.mm.plugin.voip.model.p.bQU().bQW();
        com.tencent.mm.plugin.voip.model.p.bQU().pTc = null;
        this.qeO = null;
        this.qeP = null;
        com.tencent.mm.compatible.b.f.yi().setMode(0);
        ae.getContext().unregisterReceiver(this.pSM);
        com.tencent.mm.compatible.b.f.yi().b(this.qeW);
        com.tencent.mm.compatible.b.f.yi().yl();
        if (this.pRT != null) {
          this.pRT.ek(ae.getContext());
        }
        com.tencent.mm.kernel.g.DO().b(this.nIV);
        if (this.qeV != null) {
          this.qeV.stopTimer();
        }
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
        if ((this.loj != null) && (this.lok != null))
        {
          this.loj.listen(this.lok, 0);
          this.lok = null;
        }
        super.onDestroy();
        return;
        if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qed == 823)
        {
          ((rf)localObject1).caN.status = 4;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb <= 1)
        {
          ((rf)localObject1).caN.status = 1;
          break;
        }
        if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb < 2) {
          break;
        }
        ((rf)localObject1).caN.status = 2;
        break;
        i = 0;
        break label162;
        com.tencent.mm.plugin.voip_cs.b.c.bSQ().aYU = 3;
        break label248;
        i = j;
        if (((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdW == 2) {
          break label391;
        }
        if (((com.tencent.mm.plugin.voip_cs.b.e)localObject1).qdW == 3)
        {
          i = 3;
          break label391;
        }
        i = 4;
        break label391;
        i = 0;
        break label694;
      }
    }
  }
  
  public final void onError(int paramInt)
  {
    if (this.qeO != null)
    {
      y.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:" + paramInt);
      this.qeO.AE(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4) {
      return true;
    }
    if (paramInt == 25)
    {
      paramInt = bcy();
      com.tencent.mm.compatible.b.f.yi().gr(paramInt);
      return true;
    }
    if (paramInt == 24)
    {
      paramInt = bcy();
      com.tencent.mm.compatible.b.f.yi().gq(paramInt);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (!this.qei.bRj()) {
      this.qei.stopRing();
    }
    if ((com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb == 1) || (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb == 2))
    {
      Object localObject = new Intent(ae.getContext(), VoipCSMainUI.class);
      ((Intent)localObject).putExtra("voipCSBizId", this.qec);
      ((Intent)localObject).putExtra("voipCSAppId", this.appId);
      ((Intent)localObject).putExtra("voipCSScene", this.bso);
      ((Intent)localObject).putExtra("voipCSType", this.type);
      ((Intent)localObject).putExtra("voipCSAllowBackCamera", this.qeR);
      ((Intent)localObject).putExtra("voipCSShowOther", this.qeS);
      ((Intent)localObject).putExtra("voipCSAvatarUrl", this.foS);
      ((Intent)localObject).putExtra("voipCSContext", this.qeT);
      ((Intent)localObject).putExtra("launch_from_appbrand", this.qeU);
      localObject = PendingIntent.getActivity(ae.getContext(), 44, (Intent)localObject, 134217728);
      localObject = new Notification.Builder(ae.getContext()).setTicker(this.tickerText).setWhen(System.currentTimeMillis()).setContentTitle(this.title).setContentText(this.bQZ).setContentIntent((PendingIntent)localObject).setOngoing(true).getNotification();
      ((Notification)localObject).icon = com.tencent.mm.bq.a.bSL();
      ((Notification)localObject).flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(44, (Notification)localObject, false);
      if ((this.qeV != null) && (this.qeV.crl())) {
        this.qeV.S(5000L, 5000L);
      }
    }
    for (;;)
    {
      this.qeO.bTa();
      this.qeO.bNW = true;
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
      if (this.qeV != null) {
        this.qeV.stopTimer();
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      y.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
    }
    do
    {
      return;
      y.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      case 19: 
        if (paramArrayOfInt[0] != 0) {
          break;
        }
        bTf();
        return;
      case 82: 
        if (paramArrayOfInt[0] != 0) {
          break label156;
        }
        y.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
      }
    } while (!com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", ""));
    bTf();
    return;
    label156:
    h.a(this, getString(a.e.permission_microphone_request_again_msg), getString(a.e.permission_tips_title), getString(a.e.jump_to_settings), getString(a.e.app_cancel), false, new VoipCSMainUI.6(this), new VoipCSMainUI.7(this));
    return;
    if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
    for (paramInt = a.e.permission_camera_request_again_msg;; paramInt = a.e.permission_microphone_request_again_msg)
    {
      h.a(this, getString(paramInt), getString(a.e.permission_tips_title), getString(a.e.jump_to_settings), getString(a.e.app_cancel), false, new VoipCSMainUI.8(this), new VoipCSMainUI.9(this));
      return;
    }
  }
  
  protected void onRestart()
  {
    y.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
    super.onRestart();
    if ((bTg()) && (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb <= 1)) {
      bTf();
    }
    if (this.qeO != null) {
      this.qeO.bNW = false;
    }
  }
  
  protected void onResume()
  {
    y.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
    super.onResume();
    if (this.qeO != null)
    {
      this.qeO.bNW = false;
      if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb > 1)
      {
        bTf();
        if ((this.qeS != null) && (this.qeS.equals("1"))) {
          this.qeO.bTc();
        }
      }
    }
    if (this.qeV != null) {
      this.qeV.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(44);
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI
 * JD-Core Version:    0.7.0.1
 */