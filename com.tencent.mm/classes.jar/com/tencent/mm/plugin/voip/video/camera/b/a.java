package com.tencent.mm.plugin.voip.video.camera.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a.qj;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.d;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.voip.c.j;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.e.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/camera/v2/CommonCaptureRenderer;", "Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "Lcom/tencent/mm/plugin/voip/video/camera/common/DeviceOrientationHelp$DeviceOrientationListener;", "context", "Landroid/content/Context;", "w", "", "h", "(Landroid/content/Context;II)V", "cameraFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "displayOrientation", "getH", "()I", "setH", "(I)V", "mAutoFocusTimeOut", "", "getMAutoFocusTimeOut", "()J", "setMAutoFocusTimeOut", "(J)V", "mCamera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "mCameraDeviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "mCameraErr", "mCameraOpen", "", "mCameraOpenFaild", "mDeviceOrientationHelp", "Lcom/tencent/mm/plugin/voip/video/camera/common/DeviceOrientationHelp;", "mGetCameraDataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "()Z", "setMIsCameraNoParamAutoFocus", "(Z)V", "mIsCameraRemote180", "mIsContinuousVideoMode", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsLastAutoFocusFaceCamera", "getMIsLastAutoFocusFaceCamera", "setMIsLastAutoFocusFaceCamera", "mLastAutoFocusTimestamp", "getMLastAutoFocusTimestamp", "setMLastAutoFocusTimestamp", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mScreenRotation", "mSensorOrientation", "mSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getMSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setMSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getW", "setW", "bind", "", "surfaceTexture", "exchangeCapture", "focusOnFace", "faceLocation", "isClickScreen", "getCameraConfig", "getCameraErrCode", "getCurrentCameraIsFace", "getDisplayOrientation", "getPreviewSize", "getRecordScene", "getResolutionLimit", "getRotateAngle", "initCamera", "bFace", "initCameraConfig", "initCapture", "dataCallback", "bFaceFirst", "initFocusStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "cameraId", "initFormatStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "initSizeStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "mCameraId", "isCameraRemote180", "isMirror", "isPreviewing", "onOrientationChange", "rotation", "onSensorOrientationChanged", "orientation", "setDisplayOrientation", "startCapture", "stopCapture", "Companion", "plugin-voip_release"})
public final class a
  extends com.tencent.mm.plugin.voip.video.camera.a.a
  implements com.tencent.mm.media.widget.camerarecordview.d.b, com.tencent.mm.plugin.voip.video.camera.a.b.a
{
  public static final a.a OaX;
  private com.tencent.mm.plugin.voip.video.camera.a.b FAu;
  private com.tencent.mm.plugin.voip.video.camera.a.c FtB;
  private int FtG;
  private boolean FtJ;
  private long Ftt;
  private boolean Fty;
  private boolean Ftz;
  private boolean OaA;
  private long OaC;
  private int OaD;
  private ad OaE;
  private int[] OaH;
  private int OaS;
  private com.tencent.mm.media.widget.a.e OaU;
  private com.tencent.mm.media.widget.camerarecordview.d.b.a OaV;
  private com.tencent.mm.plugin.mmsight.model.g OaW;
  private boolean Oay;
  private boolean Oaz;
  private Context context;
  private int h;
  private boolean lbz;
  private int lcs;
  private SurfaceTexture mSurfaceTexture;
  private int w;
  
  static
  {
    AppMethodBeat.i(237915);
    OaX = new a.a((byte)0);
    AppMethodBeat.o(237915);
  }
  
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237914);
    this.context = paramContext;
    this.w = paramInt1;
    this.h = paramInt2;
    this.OaW = ((com.tencent.mm.plugin.mmsight.model.g)new b(this));
    com.tencent.mm.plugin.voip.video.camera.a.d.iL(this.context);
    aLC();
    Log.d("MicroMsg.CommonCaptureRenderer", "width: %d, height: %d", new Object[] { Integer.valueOf(this.w), Integer.valueOf(this.h) });
    this.lbz = true;
    this.Ftt = 30000L;
    AppMethodBeat.o(237914);
  }
  
  private void aLC()
  {
    AppMethodBeat.i(237897);
    b.a.a locala = new b.a.a();
    com.tencent.mm.compatible.c.a locala1 = com.tencent.mm.compatible.c.a.jnC;
    int j = com.tencent.mm.compatible.c.a.atL();
    if (j >= 0)
    {
      int i = 0;
      locala.a(new o[] { new o(Integer.valueOf(i), alI(i)) });
      locala.b(new o[] { new o(Integer.valueOf(i), gDX()) });
      locala.c(new o[] { new o(Integer.valueOf(i), alJ(i)) });
      locala.d(new o[] { new o(Integer.valueOf(i), gDW()) });
      if (!com.tencent.mm.plugin.voip.c.g.gCF())
      {
        locala.h(new String[] { b.b.aZw() });
        Log.i("MicroMsg.CommonCaptureRenderer", "current device and user were set to previewCallback");
      }
      for (;;)
      {
        if (i == j) {
          break label201;
        }
        i += 1;
        break;
        locala.h(new String[] { b.b.aZv() });
        Log.i("MicroMsg.CommonCaptureRenderer", "current device and user were set to remove previewCallback");
      }
    }
    label201:
    locala.scene = 12;
    this.OaV = locala.aZr();
    AppMethodBeat.o(237897);
  }
  
  private static b.a.b alI(int paramInt)
  {
    AppMethodBeat.i(237899);
    b.a.b localb = new b.a.b((byte)0);
    ArrayList localArrayList;
    if ((af.juH.jqr == 0) && (paramInt == 1))
    {
      localArrayList = localb.lgk;
      if (localArrayList != null) {
        localArrayList.add(b.b.aZu());
      }
      localArrayList = localb.lgk;
      if (localArrayList != null) {
        localArrayList.add(b.b.aZs());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(237899);
      return localb;
      if ((af.juH.jqr == 1) || (paramInt == 0))
      {
        localArrayList = localb.lgk;
        if (localArrayList != null) {
          localArrayList.add(b.b.aZs());
        }
        localArrayList = localb.lgk;
        if (localArrayList != null) {
          localArrayList.add(b.b.aZu());
        }
      }
    }
  }
  
  private static b.a.e alJ(int paramInt)
  {
    AppMethodBeat.i(237901);
    b.a.e locale = new b.a.e();
    if (paramInt == 1)
    {
      localObject = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
      p.j(localObject, "VoipCameraCompatible.gVoipCameraInfo");
    }
    for (Object localObject = ((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).gDQ();; localObject = ((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).gDR())
    {
      if (localObject != null)
      {
        locale.lgq = Integer.valueOf(((Point)localObject).x);
        locale.lgr = Integer.valueOf(((Point)localObject).y);
        Log.i("MicroMsg.CommonCaptureRenderer", "getCameraSize from table:" + locale.lgq + "," + locale.lgr);
      }
      AppMethodBeat.o(237901);
      return locale;
      localObject = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
      p.j(localObject, "VoipCameraCompatible.gVoipCameraInfo");
    }
  }
  
  private static b.a.d gDW()
  {
    AppMethodBeat.i(237898);
    b.a.d locald = new b.a.d();
    if (com.tencent.mm.plugin.voip.video.camera.a.d.Oaq <= 0) {}
    for (Integer localInteger = Integer.valueOf(7);; localInteger = Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.d.Oaq))
    {
      locald.lgp = localInteger;
      AppMethodBeat.o(237898);
      return locald;
    }
  }
  
  private static b.a.c gDX()
  {
    AppMethodBeat.i(237900);
    b.a.c localc = new b.a.c();
    Object localObject = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
    p.j(localObject, "VoipCameraCompatible.gVoipCameraInfo");
    int k = ((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).gDS();
    Log.i("MicroMsg.CommonCaptureRenderer", "safeSetFps: %s", new Object[] { Integer.valueOf(k) });
    if (MMApplicationContext.isMainProcess())
    {
      localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
      p.j(localObject, "MMKernel.service(IConfigService::class.java)");
    }
    for (int i = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getInt("VoipCaptureRenderFpsRangeMinApiLevel", 26);; i = 26)
    {
      Log.i("MicroMsg.CommonCaptureRenderer", "setFpsRange minApiLevel:%s", new Object[] { Integer.valueOf(i) });
      int j;
      if ((k.are()) || (com.tencent.mm.compatible.util.d.qV(i)))
      {
        j = -1;
        if (af.juH == null) {
          break label402;
        }
        j = af.juH.jqw * 1000;
      }
      label402:
      for (i = af.juH.jqx * 1000;; i = 0)
      {
        boolean bool;
        if ((j > 0) && (i > 0) && (i >= j))
        {
          localc.lgo = Boolean.FALSE;
          localc.lgl = Integer.valueOf(j);
          localc.lgm = Integer.valueOf(i);
          localc.lgn = Integer.valueOf(k);
          bool = true;
          Log.i("MicroMsg.CommonCaptureRenderer", "steve: dkfps get fit  [%d %d], target fps %d, matchTargetFPS:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(bool) });
        }
        for (;;)
        {
          AppMethodBeat.o(237900);
          return localc;
          if ((j == 0) && (i == 0))
          {
            localc.lgo = Boolean.TRUE;
            localc.lgl = Integer.valueOf(k);
            localc.lgm = Integer.valueOf(k);
            localc.lgn = Integer.valueOf(k);
            bool = false;
            i = -2147483648;
            j = -2147483648;
            break;
          }
          localc.lgn = Integer.valueOf(k);
          localc.lgm = Integer.valueOf(Math.min(k + 5, 30));
          localc.lgl = Integer.valueOf(Math.max(k - 5, 5));
          bool = false;
          i = -2147483648;
          j = -2147483648;
          break;
          localc.lgo = Boolean.TRUE;
          localc.lgl = Integer.valueOf(k);
          localc.lgm = Integer.valueOf(k);
          localc.lgn = Integer.valueOf(k);
        }
      }
    }
  }
  
  private final int l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Integer localInteger = null;
    AppMethodBeat.i(237891);
    Log.i("MicroMsg.CommonCaptureRenderer", "try open camera, face: ".concat(String.valueOf(paramBoolean)));
    this.Ftz = false;
    Object localObject1;
    boolean bool;
    if (this.OaU != null) {
      if (gDy() != paramBoolean)
      {
        localObject1 = this.OaU;
        if (localObject1 != null)
        {
          ((com.tencent.mm.media.widget.a.e)localObject1).release();
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        if (com.tencent.mm.plugin.voip.c.g.gCE())
        {
          this.OaU = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.b.f(this.context, paramInt1, paramInt2));
          if (com.tencent.mm.media.widget.d.c.uA(getRecordScene()))
          {
            localObject1 = this.OaU;
            if (localObject1 != null) {
              ((com.tencent.mm.media.widget.a.e)localObject1).aXR();
            }
          }
        }
        for (;;)
        {
          localObject1 = this.OaU;
          if (localObject1 != null) {
            ((com.tencent.mm.media.widget.a.e)localObject1).a(gDV());
          }
          if (this.OaU != null) {
            break label205;
          }
          this.Fty = false;
          AppMethodBeat.o(237891);
          return -1;
          bool = true;
          break;
          bool = this.FtJ;
          break;
          this.OaU = ((com.tencent.mm.media.widget.a.e)new com.tencent.mm.media.widget.a.g(this.context, paramInt1, paramInt2));
        }
        label205:
        this.FtJ = false;
      }
      localObject1 = this.OaU;
      Object localObject4;
      if (localObject1 != null)
      {
        localObject4 = this.context;
        if (!paramBoolean)
        {
          paramBoolean = true;
          ((com.tencent.mm.media.widget.a.e)localObject1).y((Context)localObject4, paramBoolean);
        }
      }
      else
      {
        localObject1 = this.OaU;
        if (localObject1 == null) {
          break label413;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.media.widget.a.e)localObject1).ui(getRecordScene()));
        if (((Boolean)localObject1).booleanValue()) {
          break label372;
        }
        paramInt1 = 1;
        label281:
        if (paramInt1 == 0) {
          break label377;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label413;
        }
        ((Boolean)localObject1).booleanValue();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(159L, 0L, 1L, false);
        if (this.FtB != null) {}
        try
        {
          localObject1 = this.FtB;
          if (localObject1 == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.voip.video.camera.a.c)localObject1).cNy();
          this.FtJ = true;
          localObject1 = this.OaU;
          if (localObject1 != null) {
            ((com.tencent.mm.media.widget.a.e)localObject1).release();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.CommonCaptureRenderer", (Throwable)localException1, "Camera open failed2, error:%s", new Object[] { localException1.getMessage() });
          }
        }
        AppMethodBeat.o(237891);
        return -1;
        paramBoolean = false;
        break;
        label372:
        paramInt1 = 0;
        break label281;
        label377:
        localObject1 = null;
      }
      label413:
      this.Fty = true;
      try
      {
        Object localObject2 = this.OaU;
        if (localObject2 != null) {
          paramInt1 = ((com.tencent.mm.media.widget.a.e)localObject2).aXT();
        }
        Object localObject3;
        bool = true;
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            gDG();
            localObject2 = this.OaE;
            if (localObject2 == null) {
              break;
            }
            localObject2 = Integer.valueOf(((ad)localObject2).width);
            localObject4 = this.OaE;
            if (localObject4 != null) {
              localInteger = Integer.valueOf(((ad)localObject4).height);
            }
            Log.i("MicroMsg.CommonCaptureRenderer", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d,  IsRotate180: %d, displayOrientation: %d", new Object[] { Integer.valueOf(paramInt1), localObject2, localInteger, Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.d.Oao), Integer.valueOf(this.FtG) });
            AppMethodBeat.o(237891);
            return 1;
            paramInt1 = 0;
            continue;
            localException2 = localException2;
            Log.e("MicroMsg.CommonCaptureRenderer", "getPreviewFrameRate failed: %s", new Object[] { localException2.getMessage() });
            paramInt1 = 0;
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Log.e("MicroMsg.CommonCaptureRenderer", "setDisplayOrientation failed: %s", new Object[] { localException3.getMessage() });
            continue;
            localObject3 = null;
          }
        }
      }
    }
  }
  
  public final void IA(int paramInt)
  {
    AppMethodBeat.i(237913);
    this.lcs = paramInt;
    com.tencent.mm.plugin.voip.video.camera.a.c localc = this.FtB;
    if (localc != null)
    {
      localc.IA(this.lcs);
      AppMethodBeat.o(237913);
      return;
    }
    AppMethodBeat.o(237913);
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(237889);
    p.k(paramc, "dataCallback");
    com.tencent.mm.plugin.voip.video.camera.prev.b localb = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
    p.j(localb, "VoipCameraCompatible.gVoipCameraInfo");
    if (localb.bau() <= 0)
    {
      this.OaD = 1;
      AppMethodBeat.o(237889);
      return -1;
    }
    if (paramBoolean)
    {
      localb = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
      p.j(localb, "VoipCameraCompatible.gVoipCameraInfo");
      if (!localb.gDT()) {
        paramBoolean = false;
      }
    }
    for (;;)
    {
      this.FtB = paramc;
      if (l(paramBoolean, this.w, this.h) > 0) {
        break;
      }
      int i = l(paramBoolean, this.w, this.h);
      if (i > 0) {
        break;
      }
      this.OaD = 1;
      AppMethodBeat.o(237889);
      return i;
      localb = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
      p.j(localb, "VoipCameraCompatible.gVoipCameraInfo");
      if (!localb.gDU()) {
        paramBoolean = true;
      }
    }
    if ((!com.tencent.mm.plugin.voip.c.g.gCF()) && (!com.tencent.mm.plugin.voip.c.g.gCE()))
    {
      paramc = this.OaU;
      if (paramc != null) {
        paramc.a(this.OaW);
      }
    }
    for (;;)
    {
      this.OaD = 0;
      AppMethodBeat.o(237889);
      return 1;
      j.gDe();
    }
  }
  
  public final void eXS()
  {
    AppMethodBeat.i(237903);
    StringBuilder localStringBuilder = new StringBuilder("StopCapture....mIsInCapture = ");
    Object localObject = this.OaU;
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((com.tencent.mm.media.widget.a.e)localObject).aXQ());
      Log.d("MicroMsg.CommonCaptureRenderer", localObject);
      localObject = this.OaU;
      if ((localObject != null) && (((com.tencent.mm.media.widget.a.e)localObject).aXQ() == true) && (this.OaU != null))
      {
        localObject = this.OaU;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.e)localObject).release();
        }
      }
      if (1 == this.OaD)
      {
        localObject = new qj();
        ((qj)localObject).fPf.type = 2;
        EventCenter.instance.publish((IEvent)localObject);
      }
      Log.d("MicroMsg.CommonCaptureRenderer", "UnInitCapture....mCameraOpen = " + this.Fty);
      if (!this.Fty) {
        break label212;
      }
      this.OaD = 0;
      localObject = this.OaU;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.a.e)localObject).release();
      }
    }
    for (;;)
    {
      this.Ftz = false;
      localObject = this.FAu;
      if (localObject != null) {
        ((com.tencent.mm.plugin.voip.video.camera.a.b)localObject).unInit();
      }
      this.FAu = null;
      AppMethodBeat.o(237903);
      return;
      localObject = null;
      break;
      label212:
      if (this.OaU != null)
      {
        localObject = this.OaU;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.e)localObject).release();
        }
      }
    }
  }
  
  public final boolean egx()
  {
    AppMethodBeat.i(237888);
    com.tencent.mm.media.widget.a.e locale = this.OaU;
    if (locale != null)
    {
      boolean bool = locale.aXQ();
      AppMethodBeat.o(237888);
      return bool;
    }
    AppMethodBeat.o(237888);
    return false;
  }
  
  public final int gDA()
  {
    return this.OaD;
  }
  
  /* Error */
  public final int gDB()
  {
    // Byte code:
    //   0: ldc_w 717
    //   3: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 562	com/tencent/mm/plugin/voip/video/camera/b/a:Fty	Z
    //   10: ifne +24 -> 34
    //   13: ldc 211
    //   15: ldc_w 719
    //   18: invokestatic 721	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 651	com/tencent/mm/plugin/voip/video/camera/b/a:OaD	I
    //   26: ldc_w 717
    //   29: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_m1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 410	com/tencent/mm/plugin/voip/video/camera/b/a:OaU	Lcom/tencent/mm/media/widget/a/e;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +29 -> 69
    //   43: aload_1
    //   44: invokeinterface 674 1 0
    //   49: iconst_1
    //   50: if_icmpne +19 -> 69
    //   53: ldc 211
    //   55: ldc_w 723
    //   58: invokestatic 721	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: ldc_w 717
    //   64: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: iconst_m1
    //   68: ireturn
    //   69: aload_0
    //   70: getfield 725	com/tencent/mm/plugin/voip/video/camera/b/a:mSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   73: ifnull +190 -> 263
    //   76: aload_0
    //   77: getfield 410	com/tencent/mm/plugin/voip/video/camera/b/a:OaU	Lcom/tencent/mm/media/widget/a/e;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +18 -> 100
    //   85: aload_1
    //   86: aload_0
    //   87: getfield 725	com/tencent/mm/plugin/voip/video/camera/b/a:mSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   90: iconst_0
    //   91: aload_0
    //   92: invokevirtual 727	com/tencent/mm/plugin/voip/video/camera/b/a:getResolutionLimit	()I
    //   95: invokeinterface 730 4 0
    //   100: aload_0
    //   101: getfield 410	com/tencent/mm/plugin/voip/video/camera/b/a:OaU	Lcom/tencent/mm/media/widget/a/e;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +157 -> 263
    //   109: aload_1
    //   110: iconst_0
    //   111: invokeinterface 734 2 0
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +145 -> 263
    //   121: aload_0
    //   122: new 617	com/tencent/mm/compatible/deviceinfo/ad
    //   125: dup
    //   126: aload_1
    //   127: getfield 375	android/graphics/Point:x	I
    //   130: aload_1
    //   131: getfield 382	android/graphics/Point:y	I
    //   134: invokespecial 737	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   137: putfield 615	com/tencent/mm/plugin/voip/video/camera/b/a:OaE	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   140: aload_0
    //   141: getfield 237	com/tencent/mm/plugin/voip/video/camera/b/a:FtB	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +17 -> 163
    //   149: aload_2
    //   150: aload_1
    //   151: getfield 375	android/graphics/Point:x	I
    //   154: aload_1
    //   155: getfield 382	android/graphics/Point:y	I
    //   158: invokeinterface 740 3 0
    //   163: new 387	java/lang/StringBuilder
    //   166: dup
    //   167: ldc_w 742
    //   170: invokespecial 392	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: getfield 191	com/tencent/mm/plugin/voip/video/camera/b/a:w	I
    //   177: invokevirtual 745	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: bipush 44
    //   182: invokevirtual 748	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: getfield 193	com/tencent/mm/plugin/voip/video/camera/b/a:h	I
    //   189: invokevirtual 745	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc_w 750
    //   195: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: astore_2
    //   199: aload_0
    //   200: getfield 615	com/tencent/mm/plugin/voip/video/camera/b/a:OaE	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   203: astore_1
    //   204: aload_1
    //   205: ifnull +157 -> 362
    //   208: aload_1
    //   209: getfield 620	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   212: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: astore_1
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: ldc_w 752
    //   224: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: astore_2
    //   228: aload_0
    //   229: getfield 615	com/tencent/mm/plugin/voip/video/camera/b/a:OaE	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   232: astore_1
    //   233: aload_1
    //   234: ifnull +133 -> 367
    //   237: aload_1
    //   238: getfield 623	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   241: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: astore_1
    //   245: ldc 211
    //   247: aload_2
    //   248: aload_1
    //   249: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   252: bipush 32
    //   254: invokevirtual 748	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   257: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 707	com/tencent/mm/plugin/voip/video/camera/b/a:FAu	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   267: ifnonnull +18 -> 285
    //   270: aload_0
    //   271: new 709	com/tencent/mm/plugin/voip/video/camera/a/b
    //   274: dup
    //   275: aload_0
    //   276: checkcast 8	com/tencent/mm/plugin/voip/video/camera/a/b$a
    //   279: invokespecial 755	com/tencent/mm/plugin/voip/video/camera/a/b:<init>	(Lcom/tencent/mm/plugin/voip/video/camera/a/b$a;)V
    //   282: putfield 707	com/tencent/mm/plugin/voip/video/camera/b/a:FAu	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   285: aload_0
    //   286: getfield 237	com/tencent/mm/plugin/voip/video/camera/b/a:FtB	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   289: astore_1
    //   290: aload_1
    //   291: ifnull +13 -> 304
    //   294: aload_1
    //   295: aload_0
    //   296: getfield 641	com/tencent/mm/plugin/voip/video/camera/b/a:lcs	I
    //   299: invokeinterface 643 2 0
    //   304: ldc_w 717
    //   307: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: iconst_1
    //   311: ireturn
    //   312: astore_1
    //   313: getstatic 582	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   316: ldc2_w 583
    //   319: lconst_0
    //   320: lconst_1
    //   321: iconst_0
    //   322: invokevirtual 588	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   325: getstatic 582	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   328: ldc2_w 583
    //   331: ldc2_w 756
    //   334: lconst_1
    //   335: iconst_0
    //   336: invokevirtual 588	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   339: aload_0
    //   340: iconst_1
    //   341: putfield 651	com/tencent/mm/plugin/voip/video/camera/b/a:OaD	I
    //   344: ldc 211
    //   346: ldc_w 759
    //   349: aload_1
    //   350: invokestatic 762	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   353: invokevirtual 527	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   356: invokestatic 721	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: goto -259 -> 100
    //   362: aconst_null
    //   363: astore_1
    //   364: goto -148 -> 216
    //   367: aconst_null
    //   368: astore_1
    //   369: goto -124 -> 245
    //   372: astore_1
    //   373: getstatic 582	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   376: ldc2_w 583
    //   379: lconst_0
    //   380: lconst_1
    //   381: iconst_0
    //   382: invokevirtual 588	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   385: ldc 211
    //   387: ldc_w 764
    //   390: iconst_1
    //   391: anewarray 215	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload_1
    //   397: invokevirtual 603	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   400: aastore
    //   401: invokestatic 635	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: ldc_w 717
    //   407: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: iconst_m1
    //   411: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	a
    //   38	257	1	localObject1	Object
    //   312	38	1	localException1	Exception
    //   363	6	1	localObject2	Object
    //   372	25	1	localException2	Exception
    //   144	104	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   76	81	312	java/lang/Exception
    //   85	100	312	java/lang/Exception
    //   100	105	372	java/lang/Exception
    //   109	117	372	java/lang/Exception
    //   121	145	372	java/lang/Exception
    //   149	163	372	java/lang/Exception
    //   163	204	372	java/lang/Exception
    //   208	216	372	java/lang/Exception
    //   216	233	372	java/lang/Exception
    //   237	245	372	java/lang/Exception
    //   245	263	372	java/lang/Exception
  }
  
  public final ad gDC()
  {
    AppMethodBeat.i(237908);
    ad localad1;
    if (this.OaE != null)
    {
      ad localad2 = this.OaE;
      localad1 = localad2;
      if (localad2 == null)
      {
        p.iCn();
        AppMethodBeat.o(237908);
        return localad2;
      }
    }
    else
    {
      localad1 = new ad(this.w, this.h);
    }
    AppMethodBeat.o(237908);
    return localad1;
  }
  
  public final void gDD()
  {
    AppMethodBeat.i(237912);
    Object localObject = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
    p.j(localObject, "VoipCameraCompatible.gVoipCameraInfo");
    if (((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).bau() < 2)
    {
      localObject = new StringBuilder("ExchangeCapture...gCameraNum= ");
      localb = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
      p.j(localb, "VoipCameraCompatible.gVoipCameraInfo");
      Log.e("MicroMsg.CommonCaptureRenderer", localb.bau());
      AppMethodBeat.o(237912);
      return;
    }
    localObject = new StringBuilder("ExchangeCapture start, gCameraNum= ");
    com.tencent.mm.plugin.voip.video.camera.prev.b localb = com.tencent.mm.plugin.voip.video.camera.a.d.Oal;
    p.j(localb, "VoipCameraCompatible.gVoipCameraInfo");
    Log.i("MicroMsg.CommonCaptureRenderer", localb.bau());
    localObject = this.OaU;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.a.e)localObject).aXP();
    }
    com.tencent.mm.plugin.voip.c.gxs().akX(this.OaD);
    this.lbz = true;
    localObject = this.FtB;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.voip.video.camera.a.c)localObject).IA(this.lcs);
      AppMethodBeat.o(237912);
      return;
    }
    AppMethodBeat.o(237912);
  }
  
  public final int gDE()
  {
    boolean bool = true;
    AppMethodBeat.i(237910);
    int k;
    int i;
    int j;
    if (gDy())
    {
      k = com.tencent.mm.plugin.voip.video.camera.a.d.Oao;
      i = k;
      if (!af.juH.jpP) {
        break label151;
      }
      i = k;
      if (af.juH.jpO.fSM == 0) {
        break label151;
      }
      j = 1;
      i = k;
    }
    for (;;)
    {
      if ((j == 0) && (i > 0))
      {
        label57:
        this.Oay = bool;
        if (!this.Oay) {
          break label134;
        }
      }
      label134:
      for (i = OpenGlRender.FLAG_Angle270;; i = OpenGlRender.FLAG_Angle90)
      {
        if (i != OpenGlRender.FLAG_Angle270) {
          break label141;
        }
        AppMethodBeat.o(237910);
        return 90;
        j = com.tencent.mm.plugin.voip.video.camera.a.d.Oap;
        i = j;
        if (!af.juH.jpR) {
          break label151;
        }
        i = j;
        if (af.juH.jpQ.fSM == 0) {
          break label151;
        }
        k = 1;
        i = j;
        j = k;
        break;
        bool = false;
        break label57;
      }
      label141:
      AppMethodBeat.o(237910);
      return 270;
      label151:
      j = 0;
    }
  }
  
  public final boolean gDF()
  {
    AppMethodBeat.i(237911);
    if (gDy()) {}
    for (int i = OpenGlRender.FLAG_Mirror; i == OpenGlRender.FLAG_Mirror; i = 0)
    {
      AppMethodBeat.o(237911);
      return true;
    }
    AppMethodBeat.o(237911);
    return false;
  }
  
  public final void gDG()
  {
    AppMethodBeat.i(237892);
    com.tencent.mm.media.widget.a.e locale = this.OaU;
    int i;
    label41:
    int k;
    int j;
    if (locale != null) {
      if (gDy())
      {
        i = com.tencent.mm.plugin.voip.video.camera.a.d.Oam;
        i = locale.dB(i, this.OaS);
        this.FtG = i;
        Log.i("MicroMsg.CommonCaptureRenderer", "mIsCurrentFaceCamera is %s, %s,%s,", new Object[] { Integer.valueOf(this.OaS), Boolean.valueOf(gDy()), Integer.valueOf(this.FtG) });
        if (!gDy()) {
          break label182;
        }
        k = com.tencent.mm.plugin.voip.video.camera.a.d.Oao;
        i = k;
        if (!af.juH.jpP) {
          break label226;
        }
        i = k;
        if (af.juH.jpO.fSM == 0) {
          break label226;
        }
        j = 1;
        i = k;
      }
    }
    for (;;)
    {
      label128:
      if ((j == 0) && (i > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.Oay = bool;
        if ((this.FtG != 90) && (j != 0)) {
          this.Oay = false;
        }
        AppMethodBeat.o(237892);
        return;
        i = com.tencent.mm.plugin.voip.video.camera.a.d.Oan;
        break;
        i = 0;
        break label41;
        label182:
        j = com.tencent.mm.plugin.voip.video.camera.a.d.Oap;
        i = j;
        if (!af.juH.jpR) {
          break label226;
        }
        i = j;
        if (af.juH.jpQ.fSM == 0) {
          break label226;
        }
        k = 1;
        i = j;
        j = k;
        break label128;
      }
      label226:
      j = 0;
    }
  }
  
  public final int gDH()
  {
    return this.FtG;
  }
  
  public final void gDI()
  {
    boolean bool3 = true;
    AppMethodBeat.i(237902);
    if ((af.juH.jqr == 1) && (this.Ftz))
    {
      AppMethodBeat.o(237902);
      return;
    }
    if (af.juH.jqq > 2000) {
      this.Ftt = af.juH.jqq;
    }
    Log.e("MicroMsg.CommonCaptureRenderer", "focusOnFace error, faceLocation is null");
    boolean bool1;
    Object localObject1;
    boolean bool2;
    if (System.currentTimeMillis() - this.OaC > this.Ftt)
    {
      bool1 = true;
      if ((this.Oaz) && (!bool1)) {
        gDy();
      }
      localObject1 = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
      if (this.Oaz) {
        break label292;
      }
      bool2 = true;
      label118:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.Ftt).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
      if (this.OaA == gDy()) {
        break label297;
      }
      bool1 = bool3;
      label168:
      Log.i("MicroMsg.CommonCaptureRenderer", bool1 + ",isClickScreen :true");
    }
    for (;;)
    {
      try
      {
        localObject1 = this.OaU;
        if (localObject1 == null) {
          break label308;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.media.widget.a.e)localObject1).aXU());
        if (!((Boolean)localObject1).booleanValue()) {
          break label302;
        }
        if (localObject1 == null) {
          break label308;
        }
        ((Boolean)localObject1).booleanValue();
        this.OaH = null;
        this.OaC = System.currentTimeMillis();
        this.Oaz = true;
        this.OaA = gDy();
        AppMethodBeat.o(237902);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CommonCaptureRenderer", "mCamera.getParameters() or autoFocus fail!".concat(String.valueOf(localException)));
        AppMethodBeat.o(237902);
        return;
      }
      bool1 = false;
      break;
      label292:
      bool2 = false;
      break label118;
      label297:
      bool1 = false;
      break label168;
      label302:
      Object localObject2 = null;
    }
    label308:
    AppMethodBeat.o(237902);
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.d.b.a gDV()
  {
    AppMethodBeat.i(237896);
    com.tencent.mm.media.widget.camerarecordview.d.b.a locala2;
    com.tencent.mm.media.widget.camerarecordview.d.b.a locala1;
    if (this.OaV != null)
    {
      locala2 = this.OaV;
      locala1 = locala2;
      if (locala2 == null)
      {
        p.iCn();
        AppMethodBeat.o(237896);
        return locala2;
      }
    }
    else
    {
      aLC();
      locala2 = this.OaV;
      locala1 = locala2;
      if (locala2 == null)
      {
        p.iCn();
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(237896);
    return locala1;
  }
  
  public final boolean gDy()
  {
    AppMethodBeat.i(237893);
    com.tencent.mm.media.widget.a.e locale = this.OaU;
    if ((locale != null) && (locale.aYi() == 1))
    {
      AppMethodBeat.o(237893);
      return true;
    }
    AppMethodBeat.o(237893);
    return false;
  }
  
  public final boolean gDz()
  {
    return this.Oay;
  }
  
  public final int getRecordScene()
  {
    return 12;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(237895);
    if (v2protocal.NQD)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
      locala = com.tencent.mm.plugin.voip.video.camera.a.e.Oaw;
      i = com.tencent.mm.plugin.voip.video.camera.a.e.gDO();
      AppMethodBeat.o(237895);
      return i;
    }
    e.a locala = com.tencent.mm.plugin.voip.video.camera.a.e.Oaw;
    int i = com.tencent.mm.plugin.voip.video.camera.a.e.gDN();
    AppMethodBeat.o(237895);
    return i;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    this.OaS = paramInt;
  }
  
  public final void t(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(237887);
    p.k(paramSurfaceTexture, "surfaceTexture");
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(237887);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
  static final class b
    implements com.tencent.mm.plugin.mmsight.model.g
  {
    b(a parama) {}
    
    public final boolean ar(byte[] paramArrayOfByte)
    {
      Object localObject2 = null;
      boolean bool2 = false;
      AppMethodBeat.i(234623);
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length != 0) {
          break label87;
        }
      }
      label87:
      for (int i = 1; i != 0; i = 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(159L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(159L, 3L, 1L, false);
        if (a.a(this.OaY) != null)
        {
          paramArrayOfByte = a.a(this.OaY);
          if (paramArrayOfByte != null) {
            paramArrayOfByte.cNy();
          }
        }
        AppMethodBeat.o(234623);
        return false;
      }
      int k;
      int j;
      if (this.OaY.gDy())
      {
        k = com.tencent.mm.plugin.voip.video.camera.a.d.Oao;
        i = k;
        if (!af.juH.jpP) {
          break label490;
        }
        i = k;
        if (af.juH.jpO.fSM == 0) {
          break label490;
        }
        j = 1;
        i = k;
      }
      for (;;)
      {
        label147:
        Object localObject3;
        label240:
        long l;
        Object localObject4;
        if (i > 0)
        {
          k = 32;
          localObject1 = this.OaY;
          boolean bool1 = bool2;
          if (j == 0)
          {
            bool1 = bool2;
            if (i > 0) {
              bool1 = true;
            }
          }
          a.a((a)localObject1, bool1);
          if ((a.a(this.OaY) != null) && (a.b(this.OaY) != null))
          {
            localObject3 = (Map)this.OaY.gDV().lgi;
            localObject1 = a.b(this.OaY);
            if (localObject1 == null) {
              break label478;
            }
            localObject1 = Integer.valueOf(((com.tencent.mm.media.widget.a.e)localObject1).aYi());
            if ((((Map)localObject3).get(localObject1) != null) && (this.OaY.gDC() != null))
            {
              localObject3 = a.a(this.OaY);
              if (localObject3 != null)
              {
                l = paramArrayOfByte.length;
                localObject1 = this.OaY.gDC();
                if (localObject1 == null) {
                  p.iCn();
                }
                i = ((ad)localObject1).width;
                localObject1 = this.OaY.gDC();
                if (localObject1 == null) {
                  p.iCn();
                }
                j = ((ad)localObject1).height;
                localObject4 = (Map)this.OaY.gDV().lgi;
                localObject1 = a.b(this.OaY);
                if (localObject1 == null) {
                  break label484;
                }
              }
            }
          }
        }
        label478:
        label484:
        for (Object localObject1 = Integer.valueOf(((com.tencent.mm.media.widget.a.e)localObject1).aYi());; localObject1 = null)
        {
          localObject4 = (b.a.d)((Map)localObject4).get(localObject1);
          localObject1 = localObject2;
          if (localObject4 != null) {
            localObject1 = ((b.a.d)localObject4).lgp;
          }
          if (localObject1 == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.voip.video.camera.a.c)localObject3).a(paramArrayOfByte, l, i, j, ((Integer)localObject1).intValue(), k);
          AppMethodBeat.o(234623);
          return true;
          j = com.tencent.mm.plugin.voip.video.camera.a.d.Oap;
          i = j;
          if (!af.juH.jpR) {
            break label490;
          }
          i = j;
          if (af.juH.jpQ.fSM == 0) {
            break label490;
          }
          k = 1;
          i = j;
          j = k;
          break;
          k = 0;
          break label147;
          localObject1 = null;
          break label240;
        }
        label490:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.b.a
 * JD-Core Version:    0.7.0.1
 */