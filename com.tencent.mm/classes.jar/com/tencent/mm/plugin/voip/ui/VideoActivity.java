package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.support.v7.app.ActionBar;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.tencent.mm.h.a.ik;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.model.o.12;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.k;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.kernel.j
@com.tencent.mm.ui.base.a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity
  extends MMActivity
  implements ServiceConnection, b, d.d
{
  private String djD;
  private ah hcZ;
  private boolean jUx = false;
  private boolean mIsMute = false;
  private int mStatus;
  private CaptureView pRW;
  private ad pSb;
  private boolean pSc;
  private boolean pSd;
  private int pSh = 1;
  private long pWA = -1L;
  private long pWB = 0L;
  private boolean pWC = false;
  private int pWD = 1;
  private boolean pWE = false;
  private boolean pWF = false;
  private boolean pWG = false;
  private VideoActivity.ScreenActionReceiver pWH;
  private byte[] pWI;
  private com.tencent.mm.sdk.b.c pWJ = new VideoActivity.1(this);
  private TelephonyManager pWK = null;
  private long pWL;
  private d pWy;
  private WeakReference<c> pWz;
  private ah pzE = new VideoActivity.9(this);
  
  private void bQG()
  {
    this.hcZ.postDelayed(new VideoActivity.7(this), 2000L);
  }
  
  private void bRW()
  {
    y.b("MicroMsg.Voip.VideoActivity", "unbindVoiceServiceIfNeed", new Object[0]);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    try
    {
      if ((com.tencent.mm.compatible.util.d.gF(28)) && (this.pWG))
      {
        ae.getContext().unbindService(this);
        this.pWG = false;
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Voip.VideoActivity", localException, "unBind vidoeforeground error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  private void bRX()
  {
    if ((com.tencent.mm.compatible.util.d.gF(28)) && (this.pWH != null)) {}
    try
    {
      ae.getContext().unregisterReceiver(this.pWH);
      this.pWH = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.i("MicroMsg.Voip.VideoActivity", "unregisterBatteryChange err:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private int bcy()
  {
    if (com.tencent.mm.compatible.b.f.yi().yn()) {
      return com.tencent.mm.compatible.b.f.yi().yz();
    }
    int i;
    if (!com.tencent.mm.plugin.voip.a.b.Aw(this.mStatus))
    {
      i = 2;
      if (this.pSc) {
        if (!this.pSd)
        {
          if (com.tencent.mm.compatible.e.q.dye.dvt < 0) {
            break label195;
          }
          i = com.tencent.mm.compatible.e.q.dye.dvt;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.compatible.b.f.yi().yn())
      {
        j = i;
        if (com.tencent.mm.compatible.e.q.dye.dvv < 0) {}
      }
      for (j = com.tencent.mm.compatible.e.q.dye.dvv;; j = com.tencent.mm.plugin.voip.b.bPx().bPH())
      {
        y.d("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        return j;
        i = 3;
        if (com.tencent.mm.compatible.b.f.yi().yt())
        {
          if (com.tencent.mm.compatible.e.q.dye.dvt < 0) {
            break label195;
          }
          i = com.tencent.mm.compatible.e.q.dye.dvt;
          break;
        }
        if (com.tencent.mm.compatible.e.q.dye.dvq < 0) {
          break;
        }
        i = com.tencent.mm.compatible.e.q.dye.dvq;
        break;
        if (!com.tencent.mm.compatible.b.f.yi().yt()) {
          break;
        }
        if (com.tencent.mm.compatible.e.q.dye.dvt < 0) {
          break label195;
        }
        i = com.tencent.mm.compatible.e.q.dye.dvt;
        break;
      }
      label195:
      i = 0;
    }
  }
  
  private static boolean blr()
  {
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)ae.getContext().getSystemService("phone");
        if (localTelephonyManager == null) {
          break label109;
        }
        i = localTelephonyManager.getCallState();
        switch (i)
        {
        default: 
          bool = false;
        }
      }
      catch (Exception localException1)
      {
        int i;
        boolean bool = false;
        y.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        return bool;
      }
      try
      {
        y.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool = false;
      continue;
      bool = true;
    }
    label109:
    return false;
  }
  
  public final void Ap(int paramInt)
  {
    this.pSh = paramInt;
    if (this.pWy != null) {
      this.pWy.Ap(paramInt);
    }
  }
  
  public final void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.pWC = paramBoolean2;
    if (paramBoolean1)
    {
      bQG();
      return;
    }
    finish();
  }
  
  public final void Qa(String paramString)
  {
    if (this.pWy != null) {
      this.hcZ.post(new VideoActivity.12(this, paramString));
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.pWy != null) {
      this.pWy.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }
  
  public final void aN(final int paramInt, String paramString)
  {
    y.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.pSd) });
    this.jUx = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.h.b(this, paramString, null, true);
      return;
    }
    this.hcZ.post(new Runnable()
    {
      public final void run()
      {
        VideoActivity.a(VideoActivity.this, paramInt);
      }
    });
  }
  
  public final void bQK()
  {
    if (this.pWy != null) {
      this.pWy.bQK();
    }
  }
  
  public final Context bRR()
  {
    return this.mController.uMN;
  }
  
  public final void bRS()
  {
    if ((this.pWy instanceof e)) {
      ((e)this.pWy).bRS();
    }
  }
  
  public final void bRT()
  {
    y.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning");
    if (this.pWy != null) {
      this.pWy.bRY();
    }
  }
  
  public final byte[] bRU()
  {
    if ((this.pWy != null) && (this.pWy.getFilterData() != null)) {
      this.pWy.getFilterData().a(new VideoActivity.10(this));
    }
    return this.pWI;
  }
  
  public final void bRV()
  {
    y.i("MicroMsg.Voip.VideoActivity", "bindVoiceServiceIfNeed");
    try
    {
      if (com.tencent.mm.compatible.util.d.gF(28))
      {
        this.pzE.sendEmptyMessageDelayed(1, 2000L);
        this.pWG = true;
        Intent localIntent = new Intent();
        localIntent.setClass(ae.getContext(), VoipForegroundService.class);
        ae.getContext().bindService(localIntent, this, 1);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Voip.VideoActivity", localException, "bindVoiceServiceIfNeed error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void bdl()
  {
    y.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
    if (this.pWy != null) {
      this.pWy.bRZ();
    }
  }
  
  public final void c(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (this.pWy != null) {
      this.pWy.c(paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  protected final void dealContentView(View paramView)
  {
    ak.g(ak.a(getWindow(), null), this.mController.uMz);
    ((ViewGroup)getWindow().getDecorView()).addView(paramView, 0);
  }
  
  public final void en(int paramInt1, int paramInt2)
  {
    this.mStatus = paramInt2;
    if ((1 != this.pWD) && (paramInt2 != 8) && (paramInt2 != 262)) {
      y.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
    }
    do
    {
      return;
      if (this.pWy == null)
      {
        y.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
        return;
      }
      this.pWy.en(paramInt1, paramInt2);
      switch (paramInt2)
      {
      default: 
        return;
      }
    } while ((this.pWy != null) && ((this.pWy instanceof f)));
    if (this.pWy != null)
    {
      this.pWy.uninit();
      getSupportFragmentManager().bP().a(this.pWy).commit();
      this.pWy = null;
    }
    y.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_username", this.pSb.field_username);
    ((Bundle)localObject).putBoolean("key_isoutcall", this.pSc);
    ((Bundle)localObject).putInt("key_status", this.mStatus);
    this.pWy = new f();
    this.pWy.setArguments((Bundle)localObject);
    this.pWy.setVoipUIListener((c)this.pWz.get());
    this.pWy.gK(this.pWA);
    this.pWy.a(this);
    this.pWy.Ap(this.pSh);
    this.pWy.setMute(this.mIsMute);
    this.pWy.a(this.pRW);
    getSupportFragmentManager().bP().b(a.b.voip_container, this.pWy).commit();
    return;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      bQG();
      return;
      d locald;
      if (this.pSc)
      {
        locald = this.pWy;
        if (!this.pSd) {
          break label455;
        }
      }
      label455:
      for (localObject = getString(a.e.voip_video_call_rejected);; localObject = getString(a.e.voip_audio_call_rejected))
      {
        locald.cD((String)localObject, -1);
        bQG();
        break;
      }
      this.hcZ.post(new VideoActivity.13(this));
      continue;
      this.hcZ.post(new VideoActivity.2(this));
      continue;
      this.hcZ.postDelayed(new VideoActivity.8(this), 50L);
      continue;
      bQG();
      continue;
      finish();
    }
  }
  
  public void finish()
  {
    this.pWD = 3;
    y.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.pWC), com.tencent.mm.plugin.voip.a.b.At(this.mStatus) });
    Object localObject;
    if ((!this.pWC) && (com.tencent.mm.plugin.voip.a.b.Aw(this.mStatus)) && (4 != this.pWD))
    {
      y.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.djD);
      com.tencent.mm.plugin.voip.c.eUR.e((Intent)localObject, this);
    }
    setScreenEnable(true);
    bRW();
    bRX();
    int i;
    if (this.pWy != null) {
      if (this.pWy.pWT == 4105)
      {
        i = 1;
        this.pWy.uninit();
        this.pWy = null;
      }
    }
    for (;;)
    {
      this.pWz = null;
      this.pRW = null;
      this.pWF = true;
      super.finish();
      if (i != 0)
      {
        localObject = new ik();
        ((ik)localObject).bQF.bQI = true;
        ((ik)localObject).bQF.bQH = this.pWL;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        d.pWU = -1;
        return;
        localObject = new ik();
        ((ik)localObject).bQF.bQI = false;
        ((ik)localObject).bQF.bQH = 0L;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.c.voip_main;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!com.tencent.mm.plugin.voip.a.d.en(this.mController.uMN)) {
      com.tencent.mm.plugin.voip.a.d.eo(this.mController.uMN);
    }
    y.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
    getSupportActionBar().hide();
    getWindow().setSoftInputMode(3);
    getWindow().addFlags(6815872);
    if (com.tencent.mm.kernel.g.DK()) {
      com.tencent.mm.plugin.voip.b.bPx().H(false, false);
    }
    this.hcZ = new ah();
    PBool localPBool1 = new PBool();
    PBool localPBool2 = new PBool();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    localPString.value = getIntent().getStringExtra("Voip_User");
    localPBool1.value = getIntent().getBooleanExtra("Voip_Outcall", true);
    localPBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
    this.pWL = getIntent().getLongExtra("Voip_LastPage_Hash", 0L);
    localPInt.value = com.tencent.mm.plugin.voip.a.b.K(localPBool1.value, localPBool2.value);
    this.pWI = null;
    if (localPBool1.value) {
      try
      {
        if (blr())
        {
          Toast.makeText(this, a.e.voip_in_phone_tip, 0).show();
          y.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
          super.finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        y.e("MicroMsg.Voip.VideoActivity", "not ready now!");
      }
    }
    r localr = com.tencent.mm.plugin.voip.b.bPx();
    if (localr.pTr != null)
    {
      y.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
      localPString.value = localr.pTr.djD;
      localPBool1.value = localr.pTr.pSc;
      localPBool2.value = localr.pTr.pSd;
      localPInt.value = localr.pTr.pRS.mState;
      paramBundle = localr.pTr;
    }
    label424:
    label464:
    boolean bool1;
    while (paramBundle == null)
    {
      y.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
      super.finish();
      return;
      if (localPString.value == null)
      {
        y.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
        paramBundle = null;
      }
      else
      {
        if ((!localPBool1.value) && (!localr.pTq.bPW()))
        {
          y.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
          localObject1 = localPString.value;
          if (localPBool2.value)
          {
            paramBundle = bi.uBQ;
            if (!localPBool1.value) {
              break label464;
            }
          }
          for (i = 1;; i = 0)
          {
            com.tencent.mm.plugin.voip.model.q.a((String)localObject1, paramBundle, i, 4, ae.getContext().getString(a.e.voip_call_cancel_msg_from));
            paramBundle = null;
            break;
            paramBundle = bi.uBP;
            break label424;
          }
        }
        localr.pTr = new com.tencent.mm.plugin.voip.model.o();
        com.tencent.mm.plugin.voip.model.o localo = localr.pTr;
        paramBundle = localPString.value;
        boolean bool2 = localPBool1.value;
        boolean bool3 = localPBool2.value;
        y.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramBundle, Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        localo.pSv = true;
        localo.djD = paramBundle;
        localo.pSc = bool2;
        localo.pSd = bool3;
        localo.pSb = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(localo.djD);
        localo.hcZ = new ah(Looper.getMainLooper());
        if (localo.pSB == null) {
          localo.pSB = new com.tencent.mm.plugin.voip.video.e();
        }
        localo.pSC = 0;
        localo.pSD = 0;
        label662:
        int j;
        if (bk.getInt(com.tencent.mm.m.g.AA().getValue("VOIPCameraSwitch"), 1) == 0)
        {
          bool1 = true;
          localo.pSe = bool1;
          if (!localo.pSd) {
            localo.pSe = false;
          }
          j = com.tencent.mm.plugin.voip.a.b.K(bool2, bool3);
          i = j;
          if (localo.pSe)
          {
            if (j != 0) {
              break label1051;
            }
            i = 1;
          }
          label707:
          if (!bool2) {
            break label1067;
          }
          localo.pRS = com.tencent.mm.plugin.voip.a.b.Av(i);
          label721:
          bool1 = com.tencent.mm.compatible.f.b.zA();
          bool2 = com.tencent.mm.compatible.f.b.zB();
          if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
          {
            if (!bool1)
            {
              paramBundle = com.tencent.mm.plugin.report.service.h.nFQ;
              if (!localo.pSd) {
                break label1079;
              }
              i = 0;
              label762:
              paramBundle.f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
            }
            if (!bool2)
            {
              paramBundle = com.tencent.mm.plugin.report.service.h.nFQ;
              if (!localo.pSd) {
                break label1084;
              }
              i = 0;
              label806:
              paramBundle.f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
            }
          }
          if ((!bool2) || (!bool1))
          {
            paramBundle = null;
            localObject1 = null;
            if ((bool1) || (bool2)) {
              break label1089;
            }
            paramBundle = getString(a.e.voip_special_no_audio_camera_permission);
            localObject1 = getString(a.e.voip_need_audio_and_camera_title);
            label873:
            com.tencent.mm.ui.base.h.a(this, paramBundle, (String)localObject1, getString(a.e.voip_need_show_settings_button), true, new o.12(localo, this));
          }
          y.i("MicroMsg.Voip.VoipMgr", "initMgr");
          com.tencent.mm.booter.a.vR().vT();
          com.tencent.mm.compatible.b.f.yi().b(localo);
          com.tencent.mm.compatible.b.f.yi().a(localo);
          com.tencent.mm.compatible.b.f.yi().yk();
          localo.bDz = new com.tencent.mm.compatible.util.b(ae.getContext());
          localo.bDz.requestFocus();
          if (!localo.pSd) {
            break label1139;
          }
          com.tencent.mm.plugin.voip.b.bPx().a(true, true, localo.djD);
          label982:
          if (!localo.pSc) {
            break label1183;
          }
          com.tencent.mm.plugin.voip.b.bPx().pTq.bRr();
          if (!localo.pSd) {
            break label1155;
          }
          paramBundle = com.tencent.mm.plugin.voip.b.bPx();
          localObject1 = localo.pSb.field_username;
        }
        for (int i = paramBundle.pTq.cC((String)localObject1, 0);; i = paramBundle.pTq.cC((String)localObject1, 1))
        {
          if (i >= 0) {
            break label1183;
          }
          localo.jW(false);
          break;
          bool1 = false;
          break label662;
          label1051:
          i = j;
          if (256 != j) {
            break label707;
          }
          i = 257;
          break label707;
          label1067:
          localo.pRS = com.tencent.mm.plugin.voip.a.b.Au(i);
          break label721;
          label1079:
          i = 1;
          break label762;
          label1084:
          i = 1;
          break label806;
          label1089:
          if (!bool1)
          {
            paramBundle = getString(a.e.voip_special_no_record_audio_permission);
            localObject1 = getString(a.e.voip_need_audio_title);
            break label873;
          }
          if (bool2) {
            break label873;
          }
          paramBundle = getString(a.e.voip_special_no_open_camera_permission);
          localObject1 = getString(a.e.voip_need_camera_title);
          break label873;
          label1139:
          com.tencent.mm.plugin.voip.b.bPx().a(true, false, localo.djD);
          break label982;
          label1155:
          paramBundle = com.tencent.mm.plugin.voip.b.bPx();
          localObject1 = localo.pSb.field_username;
        }
        label1183:
        localo.pRT = new HeadsetPlugReceiver();
        localo.pRT.a(ae.getContext(), localo.pSN);
        Object localObject1 = com.tencent.mm.plugin.voip.b.bPx();
        paramBundle = ae.getContext();
        localObject1 = ((r)localObject1).pTq;
        ((com.tencent.mm.plugin.voip.model.s)localObject1).pNq.hxz = paramBundle;
        ((com.tencent.mm.plugin.voip.model.s)localObject1).pNq.pQf = localo;
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
        localo.loj = ((TelephonyManager)ae.getContext().getSystemService("phone"));
        localo.loj.listen(localo.lok, 32);
        label1297:
        label1323:
        Object localObject2;
        if (localo.pSd)
        {
          i = 0;
          com.tencent.mm.plugin.voip.b.bPx().l(a.d.phonering, i, localo.pSc);
          if (!com.tencent.mm.compatible.b.f.yi().yt()) {
            break label1634;
          }
          i = 3;
          localo.pSh = i;
          localo.pSA = false;
          localo.pSk = localo.pSd;
          paramBundle = "voip_recent_contact" + com.tencent.mm.model.q.Gj();
          localObject1 = ae.getContext().getSharedPreferences("voip_plugin_prefs", 0);
          localObject2 = ((SharedPreferences)localObject1).getString(paramBundle, null);
          if (localObject2 == null) {
            break label1685;
          }
          localObject2 = bk.G(((String)localObject2).split(";"));
          if (localObject2 == null) {
            break label1685;
          }
          i = ((List)localObject2).size();
          if (!((List)localObject2).contains(localo.djD)) {
            break label1666;
          }
          if (i > 1)
          {
            ((List)localObject2).remove(localo.djD);
            label1452:
            ((List)localObject2).add(0, localo.djD);
          }
          localObject2 = bk.c((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramBundle, (String)localObject2).commit();
        }
        for (;;)
        {
          com.tencent.mm.sdk.b.a.udP.c(localo.pSO);
          com.tencent.mm.sdk.b.a.udP.c(localo.lol);
          paramBundle = localo.pSo;
          if (!paramBundle.hUi.contains(localo)) {
            paramBundle.hUi.add(localo);
          }
          paramBundle = new IntentFilter();
          paramBundle.addAction("android.intent.action.SCREEN_ON");
          paramBundle.addAction("android.intent.action.SCREEN_OFF");
          paramBundle.addAction("android.intent.action.USER_PRESENT");
          ae.getContext().registerReceiver(localo.pSM, paramBundle);
          localo.iah = new SensorController(localo.getContext());
          y.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
          localo.iah.a(localo);
          break;
          i = 1;
          break label1297;
          label1634:
          if (com.tencent.mm.compatible.b.f.yi().yn())
          {
            i = 4;
            break label1323;
          }
          if (localo.pSd)
          {
            i = 1;
            break label1323;
          }
          i = 2;
          break label1323;
          label1666:
          if (4 != i) {
            break label1452;
          }
          ((List)localObject2).remove(i - 1);
          break label1452;
          label1685:
          localObject2 = new ArrayList();
          ((List)localObject2).add(0, localo.djD);
          localObject2 = bk.c((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramBundle, (String)localObject2).commit();
        }
      }
    }
    this.pWz = new WeakReference(paramBundle);
    this.djD = localPString.value;
    this.pSd = localPBool2.value;
    this.pSc = localPBool1.value;
    this.mStatus = localPInt.value;
    this.pSb = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.djD);
    paramBundle = new Bundle();
    paramBundle.putString("key_username", this.pSb.field_username);
    paramBundle.putBoolean("key_isoutcall", this.pSc);
    paramBundle.putInt("key_status", com.tencent.mm.plugin.voip.a.b.K(this.pSc, this.pSd));
    if (com.tencent.mm.plugin.voip.a.b.Ax(this.mStatus))
    {
      this.pWy = new e();
      label1888:
      this.pWy.setArguments(paramBundle);
      getSupportFragmentManager().bP().b(a.b.voip_container, this.pWy).commit();
      setTitleVisibility(8);
      if ((com.tencent.mm.plugin.voip.a.b.Ay(this.mStatus)) && (this.pSc)) {
        this.hcZ.postDelayed(new VideoActivity.6(this), 20000L);
      }
      this.pWy.setVoipUIListener((c)this.pWz.get());
      this.pWy.a(this);
      this.pWy.Ap(this.pSh);
      this.pWy.setMute(this.mIsMute);
      if (com.tencent.mm.plugin.voip.b.bPx().pTr.pSz != null) {
        Qa(com.tencent.mm.plugin.voip.b.bPx().pTr.pSz);
      }
      if ((this.pWz != null) && (this.pWz.get() != null)) {
        ((c)this.pWz.get()).a(this, 1);
      }
      y.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[] { Boolean.valueOf(this.pSc), Boolean.valueOf(this.pSd), this.djD, Integer.valueOf(this.mStatus) });
      if (!com.tencent.mm.plugin.voip.a.b.Ax(this.mStatus)) {
        break label2314;
      }
      bool1 = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "");
      y.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool1), bk.csb(), this });
      if (!bool1) {
        ((c)this.pWz.get()).bQw();
      }
      y.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bk.csb(), this });
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.udP.c(this.pWJ);
      if (!com.tencent.mm.compatible.util.d.gF(28)) {
        break;
      }
      this.pWH = new VideoActivity.ScreenActionReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      ae.getContext().registerReceiver(this.pWH, paramBundle);
      return;
      this.pWy = new f();
      break label1888;
      label2314:
      y.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bk.csb(), this });
    }
  }
  
  protected void onDestroy()
  {
    this.pWD = 4;
    y.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.At(this.mStatus) });
    if (!this.pWF) {
      finish();
    }
    if ((this.pWz != null) && (this.pWz.get() != null)) {
      ((c)this.pWz.get()).a(this);
    }
    com.tencent.mm.sdk.b.a.udP.d(this.pWJ);
    setScreenEnable(true);
    bRW();
    bRX();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4) {
      return true;
    }
    y.i("czf", "keycode " + paramInt);
    if (paramInt == 25)
    {
      if ((!com.tencent.mm.plugin.voip.b.bPx().bRj()) && (!this.pSc))
      {
        com.tencent.mm.plugin.voip.b.bPx().stopRing();
        return true;
      }
      if (com.tencent.mm.compatible.b.f.yi().yn()) {}
      for (paramInt = com.tencent.mm.compatible.b.f.yi().yz();; paramInt = bcy())
      {
        com.tencent.mm.compatible.b.f.yi().gr(paramInt);
        break;
      }
    }
    if (paramInt == 24)
    {
      if ((!com.tencent.mm.plugin.voip.b.bPx().bRj()) && (!this.pSc))
      {
        com.tencent.mm.plugin.voip.b.bPx().stopRing();
        return true;
      }
      if (com.tencent.mm.compatible.b.f.yi().yn()) {}
      for (paramInt = com.tencent.mm.compatible.b.f.yi().yz();; paramInt = bcy())
      {
        com.tencent.mm.compatible.b.f.yi().gq(paramInt);
        break;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)ae.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ae.getContext().getSystemService("power");
    boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool3 = hasWindowFocus();
    boolean bool4 = localPowerManager.isScreenOn();
    if (((bool3) || (!bool2)) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.pWE = bool1;
      y.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.At(this.mStatus), Boolean.valueOf(this.pWE), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(2);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      y.e("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult %d data is invalid", new Object[] { Integer.valueOf(paramInt) });
    }
    do
    {
      do
      {
        return;
        y.i("MicroMsg.Voip.VideoActivity", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
        switch (paramInt)
        {
        default: 
          return;
        }
      } while (paramArrayOfInt[0] == 0);
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = a.e.permission_camera_request_again_msg;; paramInt = a.e.permission_microphone_request_again_msg)
      {
        com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(a.e.permission_tips_title), getString(a.e.jump_to_settings), getString(a.e.app_cancel), false, new VideoActivity.3(this), new VideoActivity.4(this));
        return;
      }
    } while (paramArrayOfInt[0] == 0);
    com.tencent.mm.ui.base.h.a(this, getString(a.e.permission_microphone_request_again_msg), getString(a.e.permission_tips_title), getString(a.e.jump_to_settings), getString(a.e.app_cancel), false, new VideoActivity.5(this), null);
  }
  
  public void onResume()
  {
    y.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.At(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    com.tencent.mm.plugin.voip.model.j localj = com.tencent.mm.plugin.voip.b.bPx().pTq.pNq;
    if (localj.pPQ) {
      localj.pPQ = false;
    }
    super.onResume();
    setScreenEnable(true);
    this.pWB = bk.UZ();
    if ((this.pSc) && (com.tencent.mm.plugin.voip.a.b.Ay(this.mStatus)) && (com.tencent.mm.plugin.voip.b.bPx().bRj())) {
      if (!this.pSd) {
        break label134;
      }
    }
    label134:
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.bPx().l(a.d.phonering, i, this.pSc);
      com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(1);
      return;
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStart()
  {
    super.onStart();
    if (!this.pWF)
    {
      y.i("MicroMsg.Voip.VideoActivity", "onStart");
      this.pWD = 1;
      en(4096, this.mStatus);
    }
  }
  
  protected void onStop()
  {
    this.pWD = 2;
    y.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.At(this.mStatus) });
    super.onStop();
    com.tencent.mm.plugin.report.service.h localh;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.pWE) && (!this.pWF) && (this.pWz != null) && (this.pWz.get() != null) && (((c)this.pWz.get()).jX(false)))
    {
      J(false, true);
      if (com.tencent.mm.plugin.voip.a.b.Aw(this.mStatus))
      {
        localh = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!com.tencent.mm.plugin.voip.a.b.Ax(this.mStatus)) {
          break label158;
        }
      }
    }
    label158:
    for (int i = 2;; i = 3)
    {
      localh.f(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      return;
    }
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    this.pRW = paramCaptureView;
    if (this.pWy != null) {
      this.pWy.a(paramCaptureView);
    }
  }
  
  public final void setConnectSec(long paramLong)
  {
    this.pWA = paramLong;
    if (this.pWy != null) {
      this.pWy.gK(this.pWA);
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    if (this.pWy != null) {
      this.pWy.setHWDecMode(paramInt);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
    if (this.pWy != null) {
      this.pWy.setMute(paramBoolean);
    }
  }
  
  public final void setScreenEnable(boolean paramBoolean)
  {
    super.setScreenEnable(paramBoolean);
    if ((!paramBoolean) && (!this.pWG)) {
      bRV();
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    if (this.pWy != null) {
      this.pWy.setVoipBeauty(paramInt);
    }
  }
  
  public final void uninit()
  {
    if (this.pWy != null) {
      this.pWy.uninit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */