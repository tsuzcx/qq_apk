package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.c.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUITest
  extends MMActivity
  implements com.tencent.mm.media.widget.camerarecordview.c.a, d.a, c.a
{
  private String cHH;
  private com.tencent.mm.remoteservice.d evl;
  private String fcq;
  private VideoTransPara fcu;
  private com.tencent.mm.compatible.util.b gaP;
  private int hIJ;
  private boolean hIK;
  private long hIL;
  private MMSightCaptureTouchView lyi;
  private com.tencent.mm.media.widget.camerarecordview.a lyn;
  private int oFP;
  private SightParams oJr;
  private VideoPlayerTextureView oKC;
  private VideoSeekBarEditorView oKD;
  private e.a oKJ;
  private View oPA;
  private b oPC;
  private boolean oPD;
  private bby oPE;
  private com.tencent.mm.plugin.mmsight.model.c oPM;
  private boolean oPN;
  private boolean oPO;
  private boolean oPP;
  private int oPQ;
  private int oPR;
  private Thread oPS;
  private long oPT;
  private boolean oPU;
  private boolean oPV;
  private Boolean oPW;
  private Point oPX;
  private com.tencent.mm.sdk.b.c oPY;
  private Runnable oPZ;
  private int oPi;
  private boolean oPj;
  private ViewGroup oPl;
  private MMSightRecordButton oPm;
  private View oPn;
  private View oPo;
  private ViewGroup oPp;
  private ViewGroup oPq;
  private ImageView oPr;
  private ImageView oPs;
  CameraFrontSightView oPu;
  private ViewGroup oPv;
  private ImageView oPw;
  private TextView oPz;
  private String oQa;
  private String oQb;
  private boolean oQc;
  private Bundle oQd;
  private Runnable oQe;
  private CameraPreviewGLSurfaceView oQo;
  private com.tencent.mm.media.widget.camerarecordview.a.b oQp;
  private View ofU;
  
  public SightCaptureUITest()
  {
    AppMethodBeat.i(150490);
    this.oPi = 1;
    this.oFP = 2;
    this.oPj = true;
    this.hIJ = -1;
    this.oPD = true;
    this.oPE = new bby();
    this.evl = new com.tencent.mm.remoteservice.d(ah.getContext());
    this.oPN = false;
    this.oPO = false;
    this.oPP = false;
    this.oPQ = 0;
    this.hIK = false;
    this.oPR = 0;
    this.oPS = null;
    this.oPT = -1L;
    this.hIL = -1L;
    this.oPU = false;
    this.oPV = false;
    this.cHH = "";
    this.oPW = Boolean.FALSE;
    this.oPY = new com.tencent.mm.sdk.b.c() {};
    this.oPZ = new SightCaptureUITest.14(this);
    this.oQe = new SightCaptureUITest.15(this);
    this.oKJ = new SightCaptureUITest.16(this);
    AppMethodBeat.o(150490);
  }
  
  private boolean Et()
  {
    AppMethodBeat.i(150500);
    long l = bo.yB();
    updateState(7);
    boolean bool = this.lyn.c(new SightCaptureUITest.8(this, l));
    AppMethodBeat.o(150500);
    return bool;
  }
  
  private void bSa()
  {
    AppMethodBeat.i(150501);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.oKC.getLayoutParams();
      this.oPp.removeView(this.oKC);
      this.oPp.addView(this.oKC, 0, localLayoutParams);
      AppMethodBeat.o(150501);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(150501);
    }
  }
  
  private void bSb()
  {
    AppMethodBeat.i(150502);
    ab.i("MicroMsg.SightCaptureUI", "resetCapture");
    this.oPE = new bby();
    this.oPE.xra = true;
    this.oPE.xqZ = false;
    if (this.oJr != null) {
      this.oPE.xrc = this.oJr.scene;
    }
    this.lyn.a(this.oPD, new SightCaptureUITest.9(this));
    updateState(0);
    this.oPR = 0;
    this.hIK = false;
    this.oPV = false;
    if (this.oKC != null)
    {
      this.oKC.stop();
      this.oKC.setVideoCallback(null);
      bSa();
    }
    if (this.oPC != null)
    {
      this.oPC.release();
      this.oPC = null;
    }
    if (this.oQo != null) {
      this.oQo.setVisibility(0);
    }
    this.oPw.setImageBitmap(null);
    updateState(1);
    if ((this.oPz != null) && (this.oPj))
    {
      this.oPz.setAlpha(1.0F);
      this.oPz.setVisibility(0);
    }
    this.oPM.reset();
    this.oPN = false;
    this.oPO = false;
    AppMethodBeat.o(150502);
  }
  
  private void bSf()
  {
    AppMethodBeat.i(150503);
    k.bRq();
    if (!k.isDebug())
    {
      AppMethodBeat.o(150503);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131821751);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(150503);
  }
  
  private String ba(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150504);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(ac.a.yEI, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(ac.a.yEJ, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.TY("jpg");; str = com.tencent.mm.plugin.mmsight.d.TY("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        ab.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        e.C(paramString, str);
        com.tencent.mm.sdk.f.b.a(str, this);
      }
      AppMethodBeat.o(150504);
      return str;
    }
  }
  
  private void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(150508);
    ab.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.oQb, this.oQa });
    if ((!bo.isNullOrNil(this.oQb)) && (paramBoolean)) {
      e.deleteFile(this.oQb);
    }
    if (!bo.isNullOrNil(this.oQa)) {
      e.deleteFile(this.oQa);
    }
    this.oQb = null;
    this.oQa = null;
    mp localmp = new mp();
    localmp.cCM.coO = 0;
    com.tencent.mm.sdk.b.a.ymk.l(localmp);
    AppMethodBeat.o(150508);
  }
  
  private void updateState(int paramInt)
  {
    AppMethodBeat.i(150507);
    ab.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.hIJ), zz(this.hIJ), Integer.valueOf(paramInt), zz(paramInt) });
    ab.i("MicroMsg.SightCaptureUIEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.hIJ), zz(this.hIJ), Integer.valueOf(paramInt), zz(paramInt), bo.dtY().toString() });
    if (paramInt == this.hIJ)
    {
      AppMethodBeat.o(150507);
      return;
    }
    if (this.oPp == null)
    {
      AppMethodBeat.o(150507);
      return;
    }
    com.tencent.mm.plugin.mmsight.d.TZ("TIME_RECODER_2_PLAY");
    this.hIJ = paramInt;
    if (this.hIJ != 7) {
      al.ae(this.oPZ);
    }
    if (this.hIJ == 0)
    {
      this.oPp.setVisibility(8);
      this.oPs.setVisibility(8);
      this.oPq.setVisibility(8);
      this.oPw.setVisibility(8);
      this.oPv.setVisibility(0);
      if (this.oPQ > 1) {
        this.oPr.setVisibility(0);
      }
      com.tencent.mm.plugin.mmsight.model.a.reset();
      if (this.oPS == null) {
        break label1095;
      }
      try
      {
        this.oPS.interrupt();
        this.oPS = null;
        AppMethodBeat.o(150507);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "update to state init, interrupt failed: %s", new Object[] { localException.getMessage() });
        }
      }
    }
    if ((this.hIJ == 1) || (this.hIJ == 2))
    {
      this.oPp.setVisibility(0);
      this.oPs.setVisibility(8);
      this.oPq.setVisibility(0);
      this.oPq.setClipChildren(false);
      this.oPn.setVisibility(8);
      this.ofU.setVisibility(8);
      this.oPo.setVisibility(0);
      this.oPm.setVisibility(0);
      this.oKC.setVisibility(8);
      if (this.hIJ == 1) {
        this.oPm.reset();
      }
      for (;;)
      {
        this.oPA.setVisibility(8);
        this.oPw.setVisibility(8);
        this.lyi.setVisibility(0);
        if (this.oPQ > 1) {
          this.oPr.setVisibility(0);
        }
        this.lyi.bringToFront();
        this.oPr.bringToFront();
        bSf();
        AppMethodBeat.o(150507);
        return;
        this.oPm.setTouchEnable(true);
        this.oPm.bRO();
      }
    }
    if ((this.hIJ == 4) || (this.hIJ == 3))
    {
      this.oPp.setVisibility(0);
      this.oPq.setVisibility(8);
      this.oPq.setClipChildren(false);
      this.oPn.setVisibility(0);
      this.ofU.setVisibility(0);
      this.oPo.setVisibility(8);
      this.oPm.setVisibility(8);
      if (this.hIJ == 3)
      {
        this.oPs.setVisibility(0);
        this.oPw.setVisibility(0);
        this.oKC.setVisibility(8);
      }
      for (;;)
      {
        if (this.oQo != null) {
          this.oQo.setVisibility(8);
        }
        this.lyi.setVisibility(8);
        AppMethodBeat.o(150507);
        return;
        this.oPw.setVisibility(8);
        this.oKC.setVisibility(0);
        this.oKC.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.oKC.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.oKC.setLayoutParams(localLayoutParams);
        this.oPv.setVisibility(8);
      }
    }
    if (this.hIJ == 6)
    {
      this.oPn.setVisibility(8);
      this.ofU.setVisibility(8);
      this.oPs.setVisibility(8);
      this.oPo.setVisibility(8);
      this.oPm.setVisibility(8);
      AppMethodBeat.o(150507);
      return;
    }
    if (this.hIJ == 7)
    {
      this.oPn.setVisibility(8);
      this.ofU.setVisibility(8);
      this.oPo.setVisibility(8);
      this.oPr.setVisibility(8);
      this.oPs.setVisibility(8);
      this.oPm.setTouchEnable(false);
      al.p(this.oPZ, 1500L);
      this.oPm.hideProgress();
      AppMethodBeat.o(150507);
      return;
    }
    if (this.hIJ == 8)
    {
      this.oPp.setVisibility(0);
      this.oPq.setVisibility(0);
      this.oPq.setClipChildren(false);
      this.oPn.setVisibility(8);
      this.ofU.setVisibility(8);
      this.oPs.setVisibility(8);
      this.oPo.setVisibility(0);
      if (this.oPQ > 1) {
        this.oPr.setVisibility(0);
      }
      this.oPm.setVisibility(0);
      this.lyi.setVisibility(0);
      this.oKC.setVisibility(8);
      this.oPA.setVisibility(8);
      this.oPw.setVisibility(8);
      if (this.oPV) {
        Toast.makeText(this, 2131301564, 1).show();
      }
      for (;;)
      {
        this.oPm.setTouchEnable(false);
        this.oPm.setEnabled(false);
        AppMethodBeat.o(150507);
        return;
        Toast.makeText(this, 2131301569, 1).show();
      }
    }
    if (this.hIJ == 9)
    {
      this.oPn.setVisibility(8);
      this.ofU.setVisibility(8);
      this.oPs.setVisibility(8);
      this.oPo.setVisibility(0);
      this.oPr.setVisibility(8);
      this.oPm.reset();
      this.oPm.setTouchEnable(false);
      this.oPm.setEnabled(false);
      Toast.makeText(this, 2131301565, 1).show();
    }
    label1095:
    AppMethodBeat.o(150507);
  }
  
  private static String zz(int paramInt)
  {
    if (paramInt == -1) {
      return "CAPTURE_STATE_BINGDING";
    }
    if (paramInt == 0) {
      return "CAPTURE_STATE_INIT";
    }
    if (paramInt == 1) {
      return "CAPTURE_STATE_CAPTURING";
    }
    if (paramInt == 2) {
      return "CAPTURE_STATE_RECORDING";
    }
    if (paramInt == 3) {
      return "CAPTURE_STATE_PREVIEW_PICTURE";
    }
    if (paramInt == 4) {
      return "CAPTURE_STATE_PREVIEW_VIDEO";
    }
    if (paramInt == 6) {
      return "CAPTURE_STATE_SUPERMAN";
    }
    if (paramInt == 7) {
      return "CAPTURE_STATE_WAIT_TO_PREVIEW";
    }
    if (paramInt == 8) {
      return "CAPTURE_STATE_INIT_ERROR";
    }
    if (paramInt == 9) {
      return "CAPTURE_STATE_STOP_ERROR";
    }
    return "UNKNOW";
  }
  
  public final boolean DP()
  {
    return false;
  }
  
  public final boolean Xn()
  {
    AppMethodBeat.i(150493);
    com.tencent.mm.plugin.recordvideo.b.c localc = com.tencent.mm.plugin.recordvideo.b.c.qbf;
    boolean bool = com.tencent.mm.plugin.recordvideo.b.c.cgm();
    AppMethodBeat.o(150493);
    return bool;
  }
  
  public final boolean Xo()
  {
    return false;
  }
  
  public final void asO()
  {
    AppMethodBeat.i(150511);
    ab.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    updateState(9);
    AppMethodBeat.o(150511);
  }
  
  public com.tencent.mm.media.widget.camerarecordview.preview.c getCameraPreviewView()
  {
    return this.oQo;
  }
  
  public com.tencent.mm.media.widget.camerarecordview.a.a getEncodeConfig()
  {
    AppMethodBeat.i(150495);
    SightCaptureUITest.18 local18 = new SightCaptureUITest.18(this);
    AppMethodBeat.o(150495);
    return local18;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130968839;
  }
  
  public com.tencent.mm.media.h.a getPreviewRenderer()
  {
    return null;
  }
  
  public com.tencent.mm.media.h.a getRecordRenderer()
  {
    return null;
  }
  
  public com.tencent.mm.media.widget.b.b getRecorder()
  {
    return null;
  }
  
  public int getResolutionLimit()
  {
    AppMethodBeat.i(150494);
    com.tencent.mm.plugin.recordvideo.b.c localc = com.tencent.mm.plugin.recordvideo.b.c.qbf;
    int i = com.tencent.mm.plugin.recordvideo.b.c.cgl();
    AppMethodBeat.o(150494);
    return i;
  }
  
  public VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(150496);
    Object localObject = com.tencent.mm.plugin.recordvideo.b.c.qbf;
    localObject = com.tencent.mm.plugin.recordvideo.b.c.cgj();
    AppMethodBeat.o(150496);
    return localObject;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(150506);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      ab.i("MicroMsg.SightCaptureUI", "[onActivityResult] requestCode:%s  resultCode:%s data is null?:", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(150506);
      return;
      bool = false;
      break;
      ab.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[] { Integer.valueOf(paramInt2) });
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.oQc = true;
        this.oQd = paramIntent.getBundleExtra("report_info");
        this.oQa = paramIntent.getStringExtra("raw_photo_path");
        this.oQb = paramIntent.getStringExtra("after_photo_edit");
        bool = CaptureMMProxy.getInstance().getBoolean(ac.a.yEI, true);
        ab.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.oQa, this.oQb, Boolean.valueOf(bool) });
        if (!bool)
        {
          paramIntent = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
          ab.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
          e.C(this.oQb, paramIntent);
          e.deleteFile(this.oQb);
          com.tencent.mm.sdk.f.b.a(this.oQb, this);
          this.oQb = paramIntent;
        }
        this.fcq = this.oQb;
        paramIntent = new BitmapFactory.Options();
        paramIntent.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.oQb, paramIntent);
        ab.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
        paramIntent = com.tencent.mm.sdk.platformtools.d.az(this.oQb, paramIntent.outHeight, paramIntent.outWidth);
        this.oPw.setVisibility(0);
        this.oPw.setImageBitmap(paramIntent);
        this.oQo.setVisibility(8);
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(150509);
    ab.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.hIJ) });
    if ((this.oPC != null) && (this.oPC.onBackPressed()))
    {
      AppMethodBeat.o(150509);
      return;
    }
    if (this.oPC != null)
    {
      this.oPC.release();
      this.oPC = null;
      setSelfNavigationBarVisible(8);
      this.oPn.setVisibility(0);
      this.ofU.setVisibility(0);
      this.oPs.setVisibility(0);
      AppMethodBeat.o(150509);
      return;
    }
    super.onBackPressed();
    overridePendingTransition(-1, 2131034260);
    jt(true);
    AppMethodBeat.o(150509);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(150499);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.oPW.booleanValue()) && (com.tencent.mm.compatible.util.d.fv(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.oPX == null) || (!this.oPX.equals(paramConfiguration)))
      {
        this.oPX = paramConfiguration;
        bSb();
      }
    }
    AppMethodBeat.o(150499);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(150491);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.oJr = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.oJr == null)
    {
      ab.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(150491);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.evl));
    long l = bo.yB();
    this.evl.connect(new SightCaptureUITest.1(this, l));
    com.tencent.mm.sdk.b.a.ymk.c(this.oPY);
    AppMethodBeat.o(150491);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(150505);
    super.onDestroy();
    ab.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.evl.release();
    if (this.lyn != null) {
      this.lyn.release();
    }
    if (this.hIJ == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.oKC != null)
        {
          this.oKC.stop();
          this.oKC.setVideoCallback(null);
        }
        if (this.gaP != null) {
          this.gaP.Mh();
        }
        if (this.oPC != null)
        {
          this.oPC.release();
          this.oPC = null;
        }
      }
      if (this.oPM != null)
      {
        this.oPM.disable();
        this.oPM.oGS = null;
        this.oPM = null;
      }
      j.oJp.XJ();
      com.tencent.mm.sdk.b.a.ymk.d(this.oPY);
      AppMethodBeat.o(150505);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(150492);
    if ((ac.eru.enT == 1) && (paramInt == 700) && (this.oPD)) {
      this.lyn.WN();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(150492);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(150497);
    super.onPause();
    ab.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { zz(this.hIJ) });
    if (this.hIJ == 2) {
      Et();
    }
    for (;;)
    {
      o.La(2);
      AppMethodBeat.o(150497);
      return;
      if ((this.hIJ != 1) && (this.hIJ == 4) && (this.oKC != null)) {
        this.oKC.pause();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(150498);
    super.onResume();
    setSelfNavigationBarVisible(8);
    ab.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available:", new Object[] { zz(this.hIJ) });
    if ((this.hIJ == 2) || (this.hIJ == 1)) {
      bSb();
    }
    for (;;)
    {
      o.La(1);
      AppMethodBeat.o(150498);
      return;
      if ((this.hIJ == 4) && (this.oKC != null)) {
        this.oKC.start();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void zr(int paramInt)
  {
    AppMethodBeat.i(150510);
    if (this.oPQ <= 1)
    {
      AppMethodBeat.o(150510);
      return;
    }
    if (this.hIJ == 2)
    {
      AppMethodBeat.o(150510);
      return;
    }
    if (paramInt < 0)
    {
      AppMethodBeat.o(150510);
      return;
    }
    float f;
    if ((paramInt == 90) || (paramInt == 270)) {
      if (paramInt == 270) {
        f = 90.0F;
      }
    }
    while (this.oPr.getRotation() == f)
    {
      AppMethodBeat.o(150510);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    ab.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[] { Integer.valueOf(paramInt) });
    this.oPr.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(150510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest
 * JD-Core Version:    0.7.0.1
 */