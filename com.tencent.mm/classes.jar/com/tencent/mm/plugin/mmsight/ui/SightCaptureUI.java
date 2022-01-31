package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
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
import com.tencent.mm.g.a.mp;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.c.a;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements d.a, c.a
{
  private String cHH;
  private com.tencent.mm.remoteservice.d evl;
  private VideoTransPara fcu;
  private ObservableTextureView gNV;
  private com.tencent.mm.plugin.mmsight.model.a.d gNw;
  private com.tencent.mm.compatible.util.b gaP;
  private int hIJ;
  private boolean hIK;
  private long hIL;
  private MMSightCaptureTouchView lyi;
  private int oFP;
  private SightParams oJr;
  private VideoPlayerTextureView oKC;
  private VideoSeekBarEditorView oKD;
  private com.tencent.mm.pluginsdk.ui.tools.e.a oKJ;
  private View oPA;
  private MMSightTopCountdownCoverView oPB;
  private b oPC;
  private boolean oPD;
  private bby oPE;
  private byte[] oPF;
  private int oPG;
  private int oPH;
  private int oPI;
  private int oPJ;
  private byte[] oPK;
  private int oPL;
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
  private com.tencent.mm.plugin.mmsight.model.e oPk;
  private ViewGroup oPl;
  private MMSightRecordButton oPm;
  private View oPn;
  private View oPo;
  private ViewGroup oPp;
  private ViewGroup oPq;
  private ImageView oPr;
  private ImageView oPs;
  private SurfaceTexture oPt;
  CameraFrontSightView oPu;
  private ViewGroup oPv;
  private ImageView oPw;
  private MMSightCameraGLSurfaceView oPx;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a oPy;
  private TextView oPz;
  private String oQa;
  private String oQb;
  private boolean oQc;
  private Bundle oQd;
  private Runnable oQe;
  private View ofU;
  
  public SightCaptureUI()
  {
    AppMethodBeat.i(55228);
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
    this.oPY = new SightCaptureUI.12(this);
    this.oPZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(55211);
        if ((SightCaptureUI.g(SightCaptureUI.this) == 7) && (SightCaptureUI.k(SightCaptureUI.this) != null))
        {
          ab.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
          SightCaptureUI.k(SightCaptureUI.this).bRN();
        }
        AppMethodBeat.o(55211);
      }
    };
    this.oQe = new SightCaptureUI.19(this);
    this.oKJ = new SightCaptureUI.20(this);
    AppMethodBeat.o(55228);
  }
  
  private void bRZ()
  {
    AppMethodBeat.i(55234);
    if ((this.oPT > 0L) && (bo.av(this.oPT) <= 500L))
    {
      ab.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
      AppMethodBeat.o(55234);
      return;
    }
    ab.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[] { bo.dtY().toString(), Integer.valueOf(this.hIJ) });
    bSf();
    this.oPN = true;
    if (this.hIJ == 2) {
      if ((this.gNw == null) || (!this.gNw.XA())) {
        ab.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
      }
    }
    for (;;)
    {
      bSg();
      this.oPT = bo.yB();
      AppMethodBeat.o(55234);
      return;
      bSi();
      this.oPO = true;
      continue;
      if (this.hIJ == 1)
      {
        updateState(6);
        if (js(true)) {
          updateState(1);
        }
      }
    }
  }
  
  private void bSa()
  {
    AppMethodBeat.i(55236);
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.oKC.getLayoutParams();
      this.oPp.removeView(this.oKC);
      this.oPp.addView(this.oKC, 0, localLayoutParams);
      AppMethodBeat.o(55236);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(55236);
    }
  }
  
  private void bSb()
  {
    AppMethodBeat.i(55237);
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
    if (this.oPx != null) {
      this.oPx.setVisibility(0);
    }
    this.oPw.setImageBitmap(null);
    bSh();
    this.oPk = new com.tencent.mm.plugin.mmsight.model.e(this.fcu, this.oJr.scene);
    this.oPk.a(this.oPy.fbW);
    this.oPB.setVisibility(8);
    if (!this.oPk.v(this, this.oPD))
    {
      updateState(8);
      AppMethodBeat.o(55237);
      return;
    }
    if (this.gNV.isAvailable())
    {
      this.oPt = this.gNV.getSurfaceTexture();
      ab.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.oPt });
      if (js(false)) {
        updateState(1);
      }
    }
    for (;;)
    {
      if ((this.oPz != null) && (this.oPj))
      {
        this.oPz.setAlpha(1.0F);
        this.oPz.setVisibility(0);
      }
      this.oPM.reset();
      this.oPN = false;
      this.oPO = false;
      AppMethodBeat.o(55237);
      return;
      updateState(8);
      continue;
      this.gNV.setTextureChangeCallback(new SightCaptureUI.8(this));
    }
  }
  
  private int bSc()
  {
    AppMethodBeat.i(55239);
    ab.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.gNw.b(this.oPk.getOrientation(), this.oPM.isLandscape(), this.oPM.getOrientation());
    ab.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.oPk.a(com.tencent.mm.plugin.mmsight.model.e.a.oHr);
    }
    AppMethodBeat.o(55239);
    return i;
  }
  
  private void bSd()
  {
    AppMethodBeat.i(55240);
    this.oPV = true;
    updateState(8);
    if (this.gNw != null) {
      try
      {
        this.gNw.cancel();
        this.gNw = null;
        AppMethodBeat.o(55240);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(55240);
  }
  
  private void bSe()
  {
    AppMethodBeat.i(55241);
    updateState(7);
    this.oPm.setTouchEnable(false);
    if (this.oJr.oFZ) {
      this.oPB.bRQ();
    }
    int i = this.oPk.getPreviewWidth();
    int j = this.oPk.getPreviewHeight();
    this.gNw.u(new SightCaptureUI.10(this, i, j));
    AppMethodBeat.o(55241);
  }
  
  private void bSf()
  {
    AppMethodBeat.i(55242);
    k.bRq();
    if (!k.isDebug())
    {
      AppMethodBeat.o(55242);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131821751);
    localTextView.setVisibility(8);
    localTextView.setText("");
    AppMethodBeat.o(55242);
  }
  
  private void bSg()
  {
    AppMethodBeat.i(55243);
    k.bRq();
    if (!k.isDebug())
    {
      AppMethodBeat.o(55243);
      return;
    }
    ab.i("MicroMsg.SightCaptureUI", "test for debug " + bo.dtY().toString());
    i.P(new SightCaptureUI.14(this));
    AppMethodBeat.o(55243);
  }
  
  private void bSh()
  {
    AppMethodBeat.i(55245);
    if (this.gNV != null) {
      this.gNV.setTextureChangeCallback(null);
    }
    if (this.oPk != null)
    {
      this.oPD = this.oPk.bQU();
      this.oPk.bQP();
      this.oPT = -1L;
      this.hIL = -1L;
    }
    AppMethodBeat.o(55245);
  }
  
  private void bSi()
  {
    AppMethodBeat.i(55246);
    int i = this.hIJ;
    if (this.gNw != null) {}
    for (Object localObject = this.gNw.Xw();; localObject = "")
    {
      ab.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s", new Object[] { Integer.valueOf(i), localObject });
      if ((this.hIJ != 2) || (this.gNw == null) || (this.gNw.Xw() != d.c.oIG)) {
        break label402;
      }
      this.gNw.pause();
      this.oPk.a(this, this.oPt, false);
      this.oPD = this.oPk.bQU();
      if (this.oPy != null) {
        this.oPy.aa(this.oPk.getPreviewWidth(), this.oPk.getPreviewHeight(), this.oPk.getOrientation());
      }
      if (this.gNw.Xw() == d.c.oIO) {
        break;
      }
      ab.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[] { this.gNw.Xw() });
      AppMethodBeat.o(55246);
      return;
    }
    i = this.oPk.getPreviewWidth();
    int j = this.oPk.getPreviewHeight();
    int k = this.oPk.getOrientation();
    localObject = this.gNw.Xy();
    int m = this.gNw.Xz();
    ab.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(m) });
    if ((m != k) || (((Point)localObject).x != i) || (((Point)localObject).y != j)) {
      ab.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
    }
    this.gNw.s(this.oPk.getPreviewWidth(), this.oPk.getPreviewHeight(), this.oPk.getEncodeVideoBestSize().x, this.oPk.getEncodeVideoBestSize().y);
    this.gNw.G(k, this.oPk.getEncodeVideoBestSize().x, this.oPk.getEncodeVideoBestSize().y);
    label402:
    AppMethodBeat.o(55246);
  }
  
  private boolean bSj()
  {
    return (this.hIJ == 4) || (this.hIJ == 3) || (this.hIJ == 1) || (this.hIJ == 8) || (this.hIJ == 9);
  }
  
  private String ba(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55244);
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(ac.a.yEI, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(ac.a.yEJ, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.TY("jpg");; str = com.tencent.mm.plugin.mmsight.d.TY("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        ab.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.vfs.e.C(paramString, str);
        com.tencent.mm.sdk.f.b.a(str, this);
      }
      AppMethodBeat.o(55244);
      return str;
    }
  }
  
  private boolean js(boolean paramBoolean)
  {
    AppMethodBeat.i(55238);
    ab.a("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.oPt });
    this.oPV = false;
    if (this.gNw != null)
    {
      if (this.oPk != null) {
        this.oPk.b(this.gNw.getFrameDataCallback());
      }
      this.gNw.cancel();
    }
    if (this.oPk == null)
    {
      AppMethodBeat.o(55238);
      return false;
    }
    this.oPE = new bby();
    this.oPE.xra = true;
    this.oPE.xqZ = com.tencent.mm.plugin.mmsight.model.j.oHG.oHU;
    if (this.oJr != null) {
      this.oPE.xrc = this.oJr.scene;
    }
    if (!paramBoolean)
    {
      if (this.oPk.a(this.oPt, true) < 0)
      {
        AppMethodBeat.o(55238);
        return false;
      }
    }
    else
    {
      paramBoolean = this.oPk.a(this, this.oPt, true);
      this.oPD = this.oPk.bQU();
      if (!paramBoolean)
      {
        AppMethodBeat.o(55238);
        return false;
      }
    }
    if (this.oPk.getEncodeVideoBestSize() == null)
    {
      AppMethodBeat.o(55238);
      return false;
    }
    k.bRq();
    this.gNw = k.q(this.fcu);
    if (this.gNw == null)
    {
      ab.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.oPV = true;
      AppMethodBeat.o(55238);
      return false;
    }
    com.tencent.mm.plugin.mmsight.d.a(this.gNw, this.oJr);
    this.gNw.a(this);
    this.oPk.a(this.gNw.getFrameDataCallback());
    if (this.oPy != null) {
      this.oPy.aa(this.oPk.getPreviewWidth(), this.oPk.getPreviewHeight(), this.oPk.getOrientation());
    }
    this.gNw.s(this.oPk.getPreviewWidth(), this.oPk.getPreviewHeight(), this.oPk.getEncodeVideoBestSize().x, this.oPk.getEncodeVideoBestSize().y);
    paramBoolean = this.gNw.km(this.oPk.getOrientation());
    ab.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.oPV = true;
    }
    AppMethodBeat.o(55238);
    return paramBoolean;
  }
  
  private void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(55250);
    ab.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.oQb, this.oQa });
    if ((!bo.isNullOrNil(this.oQb)) && (paramBoolean)) {
      com.tencent.mm.vfs.e.deleteFile(this.oQb);
    }
    if (!bo.isNullOrNil(this.oQa)) {
      com.tencent.mm.vfs.e.deleteFile(this.oQa);
    }
    this.oQb = null;
    this.oQa = null;
    mp localmp = new mp();
    localmp.cCM.coO = 0;
    com.tencent.mm.sdk.b.a.ymk.l(localmp);
    AppMethodBeat.o(55250);
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(55235);
    ab.b("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.hIJ) });
    if (this.hIJ == 2) {
      bSe();
    }
    AppMethodBeat.o(55235);
  }
  
  private void updateState(int paramInt)
  {
    AppMethodBeat.i(55249);
    ab.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.hIJ), zz(this.hIJ), Integer.valueOf(paramInt), zz(paramInt) });
    ab.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.hIJ), zz(this.hIJ), Integer.valueOf(paramInt), zz(paramInt), bo.dtY().toString() });
    if (paramInt == this.hIJ)
    {
      AppMethodBeat.o(55249);
      return;
    }
    if (this.oPp == null)
    {
      AppMethodBeat.o(55249);
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
      if (this.oPk != null) {
        this.oPk.a(com.tencent.mm.plugin.mmsight.model.e.a.oHq);
      }
      com.tencent.mm.plugin.mmsight.model.a.reset();
      if (this.oPS == null) {
        break label1119;
      }
      try
      {
        this.oPS.interrupt();
        this.oPS = null;
        AppMethodBeat.o(55249);
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
        bSg();
        AppMethodBeat.o(55249);
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
        this.lyi.setVisibility(8);
        AppMethodBeat.o(55249);
        return;
        this.oPw.setVisibility(8);
        this.oKC.setVisibility(0);
        this.oKC.setForceScaleFullScreen(true);
        ViewGroup.LayoutParams localLayoutParams = this.oKC.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.oKC.setLayoutParams(localLayoutParams);
        if (this.gNw.isLandscape()) {
          this.oPy.Xl();
        }
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
      AppMethodBeat.o(55249);
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
      AppMethodBeat.o(55249);
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
        AppMethodBeat.o(55249);
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
    label1119:
    AppMethodBeat.o(55249);
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
  
  public final void asO()
  {
    AppMethodBeat.i(55253);
    ab.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.gNw != null) {
        this.gNw.reset();
      }
      updateState(9);
      AppMethodBeat.o(55253);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130968838;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(55248);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      bool = true;
      ab.i("MicroMsg.SightCaptureUI", "[onActivityResult] requestCode:%s  resultCode:%s data is null?:", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      switch (paramInt1)
      {
      }
    }
    do
    {
      AppMethodBeat.o(55248);
      return;
      bool = false;
      break;
      ab.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[] { Integer.valueOf(paramInt2) });
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.gNw == null));
    this.oQc = true;
    this.oQd = paramIntent.getBundleExtra("report_info");
    this.oQa = paramIntent.getStringExtra("raw_photo_path");
    this.oQb = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(ac.a.yEI, true);
    ab.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.oQa, this.oQb, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
      ab.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      com.tencent.mm.vfs.e.C(this.oQb, paramIntent);
      com.tencent.mm.vfs.e.deleteFile(this.oQb);
      com.tencent.mm.sdk.f.b.a(this.oQb, this);
      this.gNw.mW(paramIntent);
      this.oQb = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.oQb, paramIntent);
      ab.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = com.tencent.mm.sdk.platformtools.d.az(this.oQb, paramIntent.outHeight, paramIntent.outWidth);
      this.oPw.setVisibility(0);
      this.oPw.setImageBitmap(paramIntent);
      this.oPx.setVisibility(8);
      break;
      this.gNw.mW(this.oQb);
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(55251);
    ab.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.hIJ) });
    if ((this.oPC != null) && (this.oPC.onBackPressed()))
    {
      AppMethodBeat.o(55251);
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
      AppMethodBeat.o(55251);
      return;
    }
    if (bSj())
    {
      super.onBackPressed();
      overridePendingTransition(-1, 2131034260);
      jt(true);
    }
    AppMethodBeat.o(55251);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(55233);
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
    AppMethodBeat.o(55233);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55229);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.oJr = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.oJr == null)
    {
      ab.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      AppMethodBeat.o(55229);
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.evl));
    long l = bo.yB();
    this.evl.connect(new SightCaptureUI.1(this, l));
    com.tencent.mm.sdk.b.a.ymk.c(this.oPY);
    AppMethodBeat.o(55229);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55247);
    super.onDestroy();
    ab.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.evl.release();
    if (this.gNw != null)
    {
      this.gNw.a(null);
      this.gNw.u(null);
      this.gNw.clear();
    }
    if (this.hIJ == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        bSh();
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
      com.tencent.mm.plugin.mmsight.model.a.j.oJp.XJ();
      com.tencent.mm.sdk.b.a.ymk.d(this.oPY);
      AppMethodBeat.o(55247);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(55230);
    if ((ac.eru.enT == 1) && (paramInt == 700) && (this.oPD)) {
      bRZ();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(55230);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(55231);
    super.onPause();
    ab.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { zz(this.hIJ) });
    if (this.hIJ == 2) {
      stopRecord();
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.o.La(2);
      AppMethodBeat.o(55231);
      return;
      if (this.hIJ == 1) {
        bSh();
      } else if ((this.hIJ == 4) && (this.oKC != null)) {
        this.oKC.pause();
      }
    }
  }
  
  public void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(55232);
    super.onResume();
    setSelfNavigationBarVisible(8);
    String str = zz(this.hIJ);
    boolean bool1 = bool2;
    if (this.gNV != null)
    {
      bool1 = bool2;
      if (this.gNV.isAvailable()) {
        bool1 = true;
      }
    }
    ab.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.hIJ == 2) || (this.hIJ == 1)) {
      bSb();
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.o.La(1);
      AppMethodBeat.o(55232);
      return;
      if (this.hIJ == 4)
      {
        if (this.gNV != null)
        {
          if (!this.gNV.isAvailable()) {
            break label153;
          }
          this.oPy.Xl();
        }
        for (;;)
        {
          if (this.oKC == null) {
            break label169;
          }
          this.oKC.start();
          break;
          label153:
          this.gNV.setTextureChangeCallback(new SightCaptureUI.21(this));
        }
      }
      else
      {
        label169:
        if (this.hIJ == 3)
        {
          if (this.gNV != null) {
            this.gNV.setTextureChangeCallback(null);
          }
          this.oPy.a(this.oPK, this.oPP, this.oPL);
        }
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
    AppMethodBeat.i(55252);
    if (this.oPQ <= 1)
    {
      AppMethodBeat.o(55252);
      return;
    }
    if (this.hIJ == 2)
    {
      AppMethodBeat.o(55252);
      return;
    }
    ab.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(55252);
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
      AppMethodBeat.o(55252);
      return;
      f = -90.0F;
      continue;
      f = paramInt;
    }
    this.oPr.animate().rotation(f).setDuration(100L).start();
    AppMethodBeat.o(55252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI
 * JD-Core Version:    0.7.0.1
 */