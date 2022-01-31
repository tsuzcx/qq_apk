package com.tencent.mm.plugin.mmsight.ui;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.h.a.ly;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.c.a;
import com.tencent.mm.plugin.mmsight.model.e.a;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.u.a.a;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.plugin.u.a.h;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class SightCaptureUI
  extends MMActivity
  implements d.a, c.a
{
  private String bZs = "";
  private b eLi;
  private com.tencent.mm.remoteservice.d eMh = new com.tencent.mm.remoteservice.d(ae.getContext());
  private com.tencent.mm.plugin.mmsight.model.a.d fvQ;
  private ObservableTextureView fwT;
  private int goN = -1;
  private boolean goO = false;
  private long goP = -1L;
  private SurfaceTexture jof;
  private MMSightCaptureTouchView jpi;
  private View lIH;
  private int mfq = 2;
  private VideoTransPara mfr;
  private SightParams mjk;
  private f.a mlB = new SightCaptureUI.19(this);
  private VideoPlayerTextureView mlw;
  private VideoSeekBarEditorView mlx;
  private int mpJ = 1;
  private boolean mpK = true;
  private com.tencent.mm.plugin.mmsight.model.e mpL;
  private ViewGroup mpM;
  private MMSightRecordButton mpN;
  private View mpO;
  private View mpP;
  private ViewGroup mpQ;
  private ViewGroup mpR;
  private ImageView mpS;
  private ImageView mpT;
  CameraFrontSightView mpU;
  private ViewGroup mpV;
  private ImageView mpW;
  private MMSightCameraGLSurfaceView mpX;
  private com.tencent.mm.plugin.mmsight.ui.cameraglview.a mpY;
  private TextView mpZ;
  private Runnable mqA = new SightCaptureUI.18(this);
  private View mqa;
  private a mqb;
  private boolean mqc = true;
  private avn mqd = new avn();
  private byte[] mqe;
  private int mqf;
  private int mqg;
  private int mqh;
  private int mqi;
  private byte[] mqj;
  private int mqk;
  private com.tencent.mm.plugin.mmsight.model.c mql;
  private boolean mqm = false;
  private boolean mqn = false;
  private boolean mqo = false;
  private int mqp = 0;
  private int mqq = 0;
  private Thread mqr = null;
  private long mqs = -1L;
  private boolean mqt = false;
  private boolean mqu = false;
  private Runnable mqv = new SightCaptureUI.17(this);
  private String mqw;
  private String mqx;
  private boolean mqy;
  private Bundle mqz;
  
  private String aL(String paramString, boolean paramBoolean)
  {
    boolean bool1 = CaptureMMProxy.getInstance().getBoolean(ac.a.uuF, true);
    boolean bool2 = CaptureMMProxy.getInstance().getBoolean(ac.a.uuG, true);
    if (paramBoolean) {}
    for (String str = com.tencent.mm.plugin.mmsight.d.pd("jpg");; str = com.tencent.mm.plugin.mmsight.d.pd("mp4"))
    {
      if (((bool1) && (paramBoolean)) || ((bool2) && (!paramBoolean)))
      {
        y.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[] { paramString, str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.vfs.e.r(paramString, str);
        q.a(str, this);
      }
      return str;
    }
  }
  
  private void bkd()
  {
    updateState(0);
    this.mqq = 0;
    this.goO = false;
    this.mqu = false;
    if (this.mlw != null)
    {
      this.mlw.stop();
      this.mlw.setVideoCallback(null);
    }
    try
    {
      ViewGroup.LayoutParams localLayoutParams = this.mlw.getLayoutParams();
      this.mpQ.removeView(this.mlw);
      this.mpQ.addView(this.mlw, 0, localLayoutParams);
      if (this.mqb != null)
      {
        this.mqb.release();
        this.mqb = null;
      }
      this.mpX.setVisibility(0);
      this.mpW.setImageBitmap(null);
      bki();
      this.mpL = new com.tencent.mm.plugin.mmsight.model.e(this.mfr, this.mjk.scene);
      this.mpL.a(this.mpY.mqZ);
      if (!this.mpL.r(this, this.mqc))
      {
        updateState(8);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[] { localException.getMessage() });
      }
    }
    if (this.fwT.isAvailable())
    {
      this.jof = this.fwT.getSurfaceTexture();
      y.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[] { this.jof });
      if (hz(false)) {
        updateState(1);
      }
    }
    for (;;)
    {
      if ((this.mpZ != null) && (this.mpK))
      {
        this.mpZ.setAlpha(1.0F);
        this.mpZ.setVisibility(0);
      }
      com.tencent.mm.plugin.mmsight.model.c localc = this.mql;
      y.i("MicroMsg.DeviceOrientationListener", "reset");
      localc.mgq = -1;
      localc.orientation = -1;
      localc.mgp = -1;
      this.mqm = false;
      this.mqn = false;
      return;
      updateState(8);
      continue;
      this.fwT.setTextureChangeCallback(new SightCaptureUI.7(this));
    }
  }
  
  private int bke()
  {
    y.i("MicroMsg.SightCaptureUI", "startRecordImpl");
    int i = this.fvQ.d(this.mpL.getOrientation(), this.mql.biH(), this.mql.getOrientation());
    y.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[] { Integer.valueOf(i) });
    if (i >= 0) {
      this.mpL.a(e.a.mhh);
    }
    return i;
  }
  
  private void bkf()
  {
    this.mqu = true;
    updateState(8);
    if (this.fvQ != null) {}
    try
    {
      this.fvQ.cancel();
      this.fvQ = null;
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "", new Object[0]);
    }
  }
  
  private void bkg()
  {
    k.bjA();
    if (!k.isDebug()) {
      return;
    }
    TextView localTextView = (TextView)findViewById(a.e.video_debug_info);
    localTextView.setVisibility(8);
    localTextView.setText("");
  }
  
  private void bkh()
  {
    k.bjA();
    if (!k.isDebug()) {
      return;
    }
    y.i("MicroMsg.SightCaptureUI", "test for debug " + bk.csb().toString());
    i.L(new SightCaptureUI.13(this));
  }
  
  private void bki()
  {
    if (this.fwT != null) {
      this.fwT.setTextureChangeCallback(null);
    }
    if (this.mpL != null)
    {
      this.mqc = this.mpL.mhe;
      this.mpL.biN();
      this.mqs = -1L;
      this.goP = -1L;
    }
  }
  
  private boolean bkj()
  {
    return (this.goN == 4) || (this.goN == 3) || (this.goN == 1) || (this.goN == 8) || (this.goN == 9);
  }
  
  private void hA(boolean paramBoolean)
  {
    y.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[] { Boolean.valueOf(paramBoolean), this.mqx, this.mqw });
    if ((!bk.bl(this.mqx)) && (paramBoolean)) {
      com.tencent.mm.vfs.e.deleteFile(this.mqx);
    }
    if (!bk.bl(this.mqw)) {
      com.tencent.mm.vfs.e.deleteFile(this.mqw);
    }
    this.mqx = null;
    this.mqw = null;
    ly locally = new ly();
    locally.bVe.bHz = 0;
    com.tencent.mm.sdk.b.a.udP.m(locally);
  }
  
  private boolean hz(boolean paramBoolean)
  {
    y.b("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[] { this.jof });
    this.mqu = false;
    if (this.fvQ != null)
    {
      if (this.mpL != null) {
        this.mpL.b(this.fvQ.bjp());
      }
      this.fvQ.cancel();
    }
    if (this.mpL == null) {}
    do
    {
      while (this.mpL.mgG == null) {
        do
        {
          return false;
          this.mqd = new avn();
          this.mqd.tra = true;
          this.mqd.tqZ = com.tencent.mm.plugin.mmsight.model.j.mhB.mhO;
          if (this.mjk != null) {
            this.mqd.trc = this.mjk.scene;
          }
          if (paramBoolean) {
            break;
          }
        } while (this.mpL.a(this.jof, true) < 0);
      }
      k.bjA();
      this.fvQ = k.d(this.mfr);
      if (this.fvQ != null) {
        break;
      }
      y.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
      this.mqu = true;
      return false;
      paramBoolean = this.mpL.a(this, this.jof, true);
      this.mqc = this.mpL.mhe;
    } while (paramBoolean);
    return false;
    com.tencent.mm.plugin.mmsight.d.a(this.fvQ, this.mjk);
    this.fvQ.a(this);
    this.mpL.a(this.fvQ.bjp());
    if (this.mpY != null) {
      this.mpY.P(this.mpL.getPreviewWidth(), this.mpL.getPreviewHeight(), this.mpL.getOrientation());
    }
    this.fvQ.u(this.mpL.getPreviewWidth(), this.mpL.getPreviewHeight(), this.mpL.mgG.x, this.mpL.mgG.y);
    paramBoolean = this.fvQ.ua(this.mpL.getOrientation());
    y.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.mqu = true;
    }
    return paramBoolean;
  }
  
  private void stopRecord()
  {
    y.l("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[] { Integer.valueOf(this.goN) });
    if (this.goN == 2)
    {
      updateState(7);
      this.mpN.setTouchEnable(false);
      int i = this.mpL.getPreviewWidth();
      int j = this.mpL.getPreviewHeight();
      this.fvQ.M(new SightCaptureUI.9(this, i, j));
    }
  }
  
  private static String uj(int paramInt)
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
  
  private void updateState(int paramInt)
  {
    y.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[] { Integer.valueOf(this.goN), uj(this.goN), Integer.valueOf(paramInt), uj(paramInt) });
    y.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[] { Integer.valueOf(this.goN), uj(this.goN), Integer.valueOf(paramInt), uj(paramInt), bk.csb().toString() });
    if (paramInt == this.goN) {}
    do
    {
      do
      {
        return;
        com.tencent.mm.plugin.mmsight.d.Il("TIME_RECODER_2_PLAY");
        this.goN = paramInt;
        if (this.goN != 7) {
          ai.S(this.mqv);
        }
        if (this.goN != 0) {
          break;
        }
        this.mpQ.setVisibility(8);
        this.mpT.setVisibility(8);
        this.mpR.setVisibility(8);
        this.mpW.setVisibility(8);
        this.mpV.setVisibility(0);
        if (this.mqp > 1) {
          this.mpS.setVisibility(0);
        }
        if (this.mpL != null) {
          this.mpL.a(e.a.mhg);
        }
        com.tencent.mm.plugin.mmsight.model.a.reset();
      } while (this.mqr == null);
      try
      {
        this.mqr.interrupt();
        this.mqr = null;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SightCaptureUI", localException, "update to state init, interrupt failed: %s", new Object[] { localException.getMessage() });
        }
      }
      Object localObject;
      if ((this.goN == 1) || (this.goN == 2))
      {
        this.mpQ.setVisibility(0);
        this.mpT.setVisibility(8);
        this.mpR.setVisibility(0);
        this.mpR.setClipChildren(false);
        this.mpO.setVisibility(8);
        this.lIH.setVisibility(8);
        this.mpP.setVisibility(0);
        this.mpN.setVisibility(0);
        this.mlw.setVisibility(8);
        if (this.goN == 1) {
          this.mpN.reset();
        }
        for (;;)
        {
          this.mqa.setVisibility(8);
          this.mpW.setVisibility(8);
          this.jpi.setVisibility(0);
          if (this.mqp > 1) {
            this.mpS.setVisibility(0);
          }
          this.jpi.bringToFront();
          this.mpS.bringToFront();
          bkg();
          bkh();
          return;
          this.mpN.setTouchEnable(true);
          localObject = this.mpN;
          y.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
          ((MMSightRecordButton)localObject).moA.setVisibility(8);
        }
      }
      if ((this.goN == 4) || (this.goN == 3))
      {
        this.mpQ.setVisibility(0);
        this.mpR.setVisibility(8);
        this.mpR.setClipChildren(false);
        this.mpO.setVisibility(0);
        this.lIH.setVisibility(0);
        this.mpP.setVisibility(8);
        this.mpN.setVisibility(8);
        if (this.goN == 3)
        {
          this.mpT.setVisibility(0);
          this.mpW.setVisibility(0);
          this.mlw.setVisibility(8);
        }
        for (;;)
        {
          this.jpi.setVisibility(8);
          return;
          this.mpW.setVisibility(8);
          this.mlw.setVisibility(0);
          this.mlw.setForceScaleFullScreen(true);
          localObject = this.mlw.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = -1;
          ((ViewGroup.LayoutParams)localObject).height = -1;
          this.mlw.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (this.fvQ.biH()) {
            this.mpY.aKW();
          }
          this.mpV.setVisibility(8);
        }
      }
      if (this.goN == 6)
      {
        this.mpO.setVisibility(8);
        this.lIH.setVisibility(8);
        this.mpT.setVisibility(8);
        this.mpP.setVisibility(8);
        this.mpN.setVisibility(8);
        return;
      }
      if (this.goN == 7)
      {
        this.mpO.setVisibility(8);
        this.lIH.setVisibility(8);
        this.mpP.setVisibility(8);
        this.mpS.setVisibility(8);
        this.mpT.setVisibility(8);
        this.mpN.setTouchEnable(false);
        ai.l(this.mqv, 1500L);
        this.mpN.bka();
        return;
      }
      if (this.goN == 8)
      {
        this.mpQ.setVisibility(0);
        this.mpR.setVisibility(0);
        this.mpR.setClipChildren(false);
        this.mpO.setVisibility(8);
        this.lIH.setVisibility(8);
        this.mpT.setVisibility(8);
        this.mpP.setVisibility(0);
        if (this.mqp > 1) {
          this.mpS.setVisibility(0);
        }
        this.mpN.setVisibility(0);
        this.jpi.setVisibility(0);
        this.mlw.setVisibility(8);
        this.mqa.setVisibility(8);
        this.mpW.setVisibility(8);
        if (this.mqu) {
          Toast.makeText(this, a.h.mmsight_capture_codec_init_error, 1).show();
        }
        for (;;)
        {
          this.mpN.setTouchEnable(false);
          this.mpN.setEnabled(false);
          return;
          Toast.makeText(this, a.h.mmsight_capture_init_error, 1).show();
        }
      }
    } while (this.goN != 9);
    this.mpO.setVisibility(8);
    this.lIH.setVisibility(8);
    this.mpT.setVisibility(8);
    this.mpP.setVisibility(0);
    this.mpS.setVisibility(8);
    this.mpN.reset();
    this.mpN.setTouchEnable(false);
    this.mpN.setEnabled(false);
    Toast.makeText(this, a.h.mmsight_capture_finish_error, 1).show();
  }
  
  public final void Zf()
  {
    y.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[] { Integer.valueOf(1) });
    try
    {
      if (this.fvQ != null) {
        this.fvQ.reset();
      }
      updateState(9);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.f.big_sight_capture_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      bool = true;
      y.i("MicroMsg.SightCaptureUI", "[onActivityResult] requestCode:%s  resultCode:%s data is null?:", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
      bool = false;
      break;
      y.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[] { Integer.valueOf(paramInt2) });
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.fvQ == null));
    this.mqy = true;
    this.mqz = paramIntent.getBundleExtra("report_info");
    this.mqw = paramIntent.getStringExtra("before_photo_edit");
    this.mqx = paramIntent.getStringExtra("after_photo_edit");
    boolean bool = CaptureMMProxy.getInstance().getBoolean(ac.a.uuF, true);
    y.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[] { this.mqw, this.mqx, Boolean.valueOf(bool) });
    if (!bool)
    {
      paramIntent = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
      y.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[] { paramIntent });
      com.tencent.mm.vfs.e.r(this.mqx, paramIntent);
      com.tencent.mm.vfs.e.deleteFile(this.mqx);
      q.a(this.mqx, this);
      this.fvQ.Io(paramIntent);
      this.mqx = paramIntent;
    }
    for (;;)
    {
      paramIntent = new BitmapFactory.Options();
      paramIntent.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.mqx, paramIntent);
      y.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[] { Integer.valueOf(paramIntent.outWidth), Integer.valueOf(paramIntent.outHeight) });
      paramIntent = com.tencent.mm.sdk.platformtools.c.k(this.mqx, paramIntent.outHeight, paramIntent.outWidth, 0);
      this.mpW.setVisibility(0);
      this.mpW.setImageBitmap(paramIntent);
      this.mpX.setVisibility(8);
      return;
      this.fvQ.Io(this.mqx);
    }
  }
  
  public void onBackPressed()
  {
    y.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[] { Integer.valueOf(this.goN) });
    if ((this.mqb != null) && (this.mqb.qc())) {}
    do
    {
      return;
      if (this.mqb != null)
      {
        this.mqb.release();
        this.mqb = null;
        FS(8);
        this.mpO.setVisibility(0);
        this.lIH.setVisibility(0);
        this.mpT.setVisibility(0);
        return;
      }
    } while (!bkj());
    super.onBackPressed();
    overridePendingTransition(-1, a.a.sight_slide_bottom_out);
    hA(true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.mjk = ((SightParams)getIntent().getParcelableExtra("KEY_SIGHT_PARAMS"));
    if (this.mjk == null)
    {
      y.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
      return;
    }
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.eMh));
    long l = bk.UZ();
    this.eMh.connect(new SightCaptureUI.1(this, l));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.SightCaptureUI", "onDestroy");
    this.eMh.release();
    if (this.fvQ != null)
    {
      this.fvQ.M(null);
      this.fvQ.clear();
    }
    if (this.goN == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        bki();
        if (this.mlw != null)
        {
          this.mlw.stop();
          this.mlw.setVideoCallback(null);
        }
        if (this.eLi != null) {
          this.eLi.zE();
        }
        if (this.mqb != null)
        {
          this.mqb.release();
          this.mqb = null;
        }
      }
      if (this.mql != null)
      {
        this.mql.disable();
        this.mql = null;
      }
      com.tencent.mm.plugin.mmsight.model.a.j.mji.ET();
      return;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    y.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[] { uj(this.goN) });
    if (this.goN == 2) {
      stopRecord();
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(2);
      return;
      if (this.goN == 1) {
        bki();
      } else if ((this.goN == 4) && (this.mlw != null)) {
        this.mlw.pause();
      }
    }
  }
  
  protected void onResume()
  {
    boolean bool2 = false;
    super.onResume();
    FS(8);
    String str = uj(this.goN);
    boolean bool1 = bool2;
    if (this.fwT != null)
    {
      bool1 = bool2;
      if (this.fwT.isAvailable()) {
        bool1 = true;
      }
    }
    y.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s, textureview available: %s", new Object[] { str, Boolean.valueOf(bool1) });
    if ((this.goN == 2) || (this.goN == 1)) {
      bkd();
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(1);
      return;
      if (this.goN == 4)
      {
        if (this.fwT != null)
        {
          if (!this.fwT.isAvailable()) {
            break label142;
          }
          this.mpY.aKW();
        }
        for (;;)
        {
          if (this.mlw == null) {
            break label158;
          }
          this.mlw.start();
          break;
          label142:
          this.fwT.setTextureChangeCallback(new SightCaptureUI.12(this));
        }
      }
      else
      {
        label158:
        if (this.goN == 3)
        {
          if (this.fwT != null) {
            this.fwT.setTextureChangeCallback(null);
          }
          this.mpY.a(this.mqj, this.mqo, this.mqk);
        }
      }
    }
  }
  
  public final void tX(int paramInt)
  {
    if (this.mqp <= 1) {
      break label8;
    }
    for (;;)
    {
      label8:
      return;
      if (this.goN != 2)
      {
        y.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 0) {
          break;
        }
        float f;
        if ((paramInt == 90) || (paramInt == 270)) {
          if (paramInt == 270) {
            f = 90.0F;
          }
        }
        while (this.mpS.getRotation() != f)
        {
          this.mpS.animate().rotation(f).setDuration(100L).start();
          return;
          f = -90.0F;
          continue;
          f = paramInt;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI
 * JD-Core Version:    0.7.0.1
 */