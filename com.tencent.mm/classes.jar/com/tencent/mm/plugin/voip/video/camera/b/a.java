package com.tencent.mm.plugin.voip.video.camera.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.media.widget.b.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.d;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.d.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/camera/v2/CommonCaptureRenderer;", "Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "context", "Landroid/content/Context;", "w", "", "h", "(Landroid/content/Context;II)V", "cameraFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "displayOrientation", "getH", "()I", "setH", "(I)V", "mAutoFocusTimeOut", "", "getMAutoFocusTimeOut", "()J", "setMAutoFocusTimeOut", "(J)V", "mCamera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "mCameraDeviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "mCameraErr", "mCameraOpen", "", "mCameraOpenFaild", "mGetCameraDataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "()Z", "setMIsCameraNoParamAutoFocus", "(Z)V", "mIsCameraRemote180", "mIsContinuousVideoMode", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsLastAutoFocusFaceCamera", "getMIsLastAutoFocusFaceCamera", "setMIsLastAutoFocusFaceCamera", "mLastAutoFocusTimestamp", "getMLastAutoFocusTimestamp", "setMLastAutoFocusTimestamp", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mScreenRotation", "mSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getMSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setMSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getW", "setW", "bind", "", "surfaceTexture", "exchangeCapture", "focusOnFace", "faceLocation", "isClickScreen", "getCameraConfig", "getCameraErrCode", "getCurrentCameraIsFace", "getDisplayOrientation", "getPreviewSize", "getRecordScene", "getResolutionLimit", "getRotateAngle", "initCamera", "bFace", "initCameraConfig", "initCapture", "dataCallback", "bFaceFirst", "initFocusStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "cameraId", "initFormatStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "initSizeStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "mCameraId", "isCameraRemote180", "isMirror", "isPreviewing", "onOrientationChange", "rotation", "setDisplayOrientation", "startCapture", "stopCapture", "Companion", "plugin-voip_release"})
public final class a
  extends com.tencent.mm.plugin.voip.video.camera.a.a
  implements com.tencent.mm.media.widget.camerarecordview.d.b
{
  public static final a.a Hki;
  private boolean HjJ;
  private boolean HjK;
  private boolean HjL;
  private long HjN;
  private int HjO;
  private ac HjP;
  private int[] HjS;
  private int Hkd;
  private com.tencent.mm.media.widget.a.d Hkf;
  private b.a Hkg;
  private com.tencent.mm.plugin.mmsight.model.g Hkh;
  private Context context;
  private int h;
  private boolean imy;
  private SurfaceTexture mSurfaceTexture;
  private int w;
  private long zNW;
  private boolean zOb;
  private boolean zOc;
  private com.tencent.mm.plugin.voip.video.camera.a.b zOe;
  private int zOj;
  private boolean zOm;
  
  static
  {
    AppMethodBeat.i(236166);
    Hki = new a.a((byte)0);
    AppMethodBeat.o(236166);
  }
  
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236165);
    this.context = paramContext;
    this.w = paramInt1;
    this.h = paramInt2;
    this.Hkh = ((com.tencent.mm.plugin.mmsight.model.g)new b(this));
    com.tencent.mm.plugin.voip.video.camera.a.c.hH(this.context);
    aDz();
    Log.d("MicroMsg.CommonCaptureRenderer", "width: %d, height: %d", new Object[] { Integer.valueOf(this.w), Integer.valueOf(this.h) });
    this.imy = true;
    this.zNW = 30000L;
    AppMethodBeat.o(236165);
  }
  
  private void aDz()
  {
    AppMethodBeat.i(236153);
    b.a.a locala = new b.a.a();
    com.tencent.mm.compatible.c.a locala1 = com.tencent.mm.compatible.c.a.gDs;
    int j = com.tencent.mm.compatible.c.a.anJ();
    if (j >= 0)
    {
      int i = 0;
      locala.a(new o[] { new o(Integer.valueOf(i), adV(i)) });
      locala.b(new o[] { new o(Integer.valueOf(i), fLx()) });
      locala.c(new o[] { new o(Integer.valueOf(i), adW(i)) });
      locala.d(new o[] { new o(Integer.valueOf(i), fLw()) });
      if (!com.tencent.mm.plugin.voip.b.g.fKg())
      {
        locala.j(new String[] { b.b.aQE() });
        Log.i("MicroMsg.CommonCaptureRenderer", "current device and user were set to previewCallback");
      }
      for (;;)
      {
        if (i == j) {
          break label201;
        }
        i += 1;
        break;
        locala.j(new String[] { b.b.aQD() });
        Log.i("MicroMsg.CommonCaptureRenderer", "current device and user were set to remove previewCallback");
      }
    }
    label201:
    locala.scene = 12;
    this.Hkg = locala.aQz();
    AppMethodBeat.o(236153);
  }
  
  private static b.a.b adV(int paramInt)
  {
    AppMethodBeat.i(236155);
    b.a.b localb = new b.a.b((byte)0);
    ArrayList localArrayList;
    if ((ae.gKt.gGg == 0) && (paramInt == 1))
    {
      localArrayList = localb.irf;
      if (localArrayList != null) {
        localArrayList.add(b.b.aQC());
      }
      localArrayList = localb.irf;
      if (localArrayList != null) {
        localArrayList.add(b.b.aQA());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(236155);
      return localb;
      if ((ae.gKt.gGg == 1) || (paramInt == 0))
      {
        localArrayList = localb.irf;
        if (localArrayList != null) {
          localArrayList.add(b.b.aQA());
        }
        localArrayList = localb.irf;
        if (localArrayList != null) {
          localArrayList.add(b.b.aQC());
        }
      }
    }
  }
  
  private static b.a.e adW(int paramInt)
  {
    AppMethodBeat.i(236157);
    b.a.e locale = new b.a.e();
    if (paramInt == 1)
    {
      localObject = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
      p.g(localObject, "VoipCameraCompatible.gVoipCameraInfo");
    }
    for (Object localObject = ((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).fLq();; localObject = ((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).fLr())
    {
      if (localObject != null)
      {
        locale.irl = Integer.valueOf(((Point)localObject).x);
        locale.irm = Integer.valueOf(((Point)localObject).y);
        Log.i("MicroMsg.CommonCaptureRenderer", "getCameraSize from table:" + locale.irl + "," + locale.irm);
      }
      AppMethodBeat.o(236157);
      return locale;
      localObject = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
      p.g(localObject, "VoipCameraCompatible.gVoipCameraInfo");
    }
  }
  
  private static b.a.d fLw()
  {
    AppMethodBeat.i(236154);
    b.a.d locald = new b.a.d();
    if (com.tencent.mm.plugin.voip.video.camera.a.c.HjB <= 0) {}
    for (Integer localInteger = Integer.valueOf(7);; localInteger = Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.c.HjB))
    {
      locald.irk = localInteger;
      AppMethodBeat.o(236154);
      return locald;
    }
  }
  
  private static b.a.c fLx()
  {
    AppMethodBeat.i(236156);
    b.a.c localc = new b.a.c();
    Object localObject = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
    p.g(localObject, "VoipCameraCompatible.gVoipCameraInfo");
    int k = ((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).fLs();
    Log.i("MicroMsg.CommonCaptureRenderer", "safeSetFps: %s", new Object[] { Integer.valueOf(k) });
    if (MMApplicationContext.isMainProcess())
    {
      localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
      p.g(localObject, "MMKernel.service(IConfigService::class.java)");
    }
    for (int i = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getInt("VoipCaptureRenderFpsRangeMinApiLevel", 26);; i = 26)
    {
      Log.i("MicroMsg.CommonCaptureRenderer", "setFpsRange minApiLevel:%s", new Object[] { Integer.valueOf(i) });
      int j;
      if ((k.alh()) || (com.tencent.mm.compatible.util.d.oD(i)))
      {
        j = -1;
        if (ae.gKt == null) {
          break label402;
        }
        j = ae.gKt.gGk * 1000;
      }
      label402:
      for (i = ae.gKt.gGl * 1000;; i = 0)
      {
        boolean bool;
        if ((j > 0) && (i > 0) && (i >= j))
        {
          localc.irj = Boolean.FALSE;
          localc.irg = Integer.valueOf(j);
          localc.irh = Integer.valueOf(i);
          localc.iri = Integer.valueOf(k);
          bool = true;
          Log.i("MicroMsg.CommonCaptureRenderer", "steve: dkfps get fit  [%d %d], target fps %d, matchTargetFPS:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(bool) });
        }
        for (;;)
        {
          AppMethodBeat.o(236156);
          return localc;
          if ((j == 0) && (i == 0))
          {
            localc.irj = Boolean.TRUE;
            localc.irg = Integer.valueOf(k);
            localc.irh = Integer.valueOf(k);
            localc.iri = Integer.valueOf(k);
            bool = false;
            i = -2147483648;
            j = -2147483648;
            break;
          }
          localc.iri = Integer.valueOf(k);
          localc.irh = Integer.valueOf(Math.min(k + 5, 30));
          localc.irg = Integer.valueOf(Math.max(k - 5, 5));
          bool = false;
          i = -2147483648;
          j = -2147483648;
          break;
          localc.irj = Boolean.TRUE;
          localc.irg = Integer.valueOf(k);
          localc.irh = Integer.valueOf(k);
          localc.iri = Integer.valueOf(k);
        }
      }
    }
  }
  
  private final int h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Integer localInteger = null;
    AppMethodBeat.i(236148);
    Log.i("MicroMsg.CommonCaptureRenderer", "try open camera, face: ".concat(String.valueOf(paramBoolean)));
    this.zOc = false;
    Object localObject1;
    boolean bool;
    if (this.Hkf != null) {
      if (fKY() != paramBoolean)
      {
        localObject1 = this.Hkf;
        if (localObject1 != null)
        {
          ((com.tencent.mm.media.widget.a.d)localObject1).release();
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        if ((com.tencent.mm.media.widget.d.b.rG(getRecordScene())) || (com.tencent.mm.plugin.voip.b.g.fKf()))
        {
          this.Hkf = ((com.tencent.mm.media.widget.a.d)new e(this.context, paramInt1, paramInt2));
          if (com.tencent.mm.media.widget.d.b.rH(getRecordScene()))
          {
            localObject1 = this.Hkf;
            if (localObject1 != null) {
              ((com.tencent.mm.media.widget.a.d)localObject1).aPd();
            }
          }
        }
        for (;;)
        {
          localObject1 = this.Hkf;
          if (localObject1 != null) {
            ((com.tencent.mm.media.widget.a.d)localObject1).a(fLv());
          }
          if (this.Hkf != null) {
            break label215;
          }
          this.zOb = false;
          AppMethodBeat.o(236148);
          return -1;
          bool = true;
          break;
          bool = this.zOm;
          break;
          this.Hkf = ((com.tencent.mm.media.widget.a.d)new com.tencent.mm.media.widget.a.f(this.context, paramInt1, paramInt2));
        }
        label215:
        this.zOm = false;
      }
      localObject1 = this.Hkf;
      Object localObject4;
      if (localObject1 != null)
      {
        localObject4 = this.context;
        if (!paramBoolean)
        {
          paramBoolean = true;
          ((com.tencent.mm.media.widget.a.d)localObject1).v((Context)localObject4, paramBoolean);
        }
      }
      else
      {
        localObject1 = this.Hkf;
        if (localObject1 == null) {
          break label423;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.media.widget.a.d)localObject1).rp(getRecordScene()));
        if (((Boolean)localObject1).booleanValue()) {
          break label382;
        }
        paramInt1 = 1;
        label291:
        if (paramInt1 == 0) {
          break label387;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label423;
        }
        ((Boolean)localObject1).booleanValue();
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        if (this.zOe != null) {}
        try
        {
          localObject1 = this.zOe;
          if (localObject1 == null) {
            p.hyc();
          }
          ((com.tencent.mm.plugin.voip.video.camera.a.b)localObject1).cza();
          this.zOm = true;
          localObject1 = this.Hkf;
          if (localObject1 != null) {
            ((com.tencent.mm.media.widget.a.d)localObject1).release();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.CommonCaptureRenderer", (Throwable)localException1, "Camera open failed2, error:%s", new Object[] { localException1.getMessage() });
          }
        }
        AppMethodBeat.o(236148);
        return -1;
        paramBoolean = false;
        break;
        label382:
        paramInt1 = 0;
        break label291;
        label387:
        localObject1 = null;
      }
      label423:
      this.zOb = true;
      try
      {
        Object localObject2 = this.Hkf;
        if (localObject2 != null) {
          paramInt1 = ((com.tencent.mm.media.widget.a.d)localObject2).aPf();
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
            fLg();
            localObject2 = this.HjP;
            if (localObject2 == null) {
              break;
            }
            localObject2 = Integer.valueOf(((ac)localObject2).width);
            localObject4 = this.HjP;
            if (localObject4 != null) {
              localInteger = Integer.valueOf(((ac)localObject4).height);
            }
            Log.i("MicroMsg.CommonCaptureRenderer", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d,  IsRotate180: %d, displayOrientation: %d", new Object[] { Integer.valueOf(paramInt1), localObject2, localInteger, Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.c.Hjz), Integer.valueOf(this.zOj) });
            AppMethodBeat.o(236148);
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
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(236147);
    p.h(paramb, "dataCallback");
    com.tencent.mm.plugin.voip.video.camera.prev.b localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
    p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
    if (localb.aRA() <= 0)
    {
      this.HjO = 1;
      AppMethodBeat.o(236147);
      return -1;
    }
    if (paramBoolean)
    {
      localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
      p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
      if (!localb.fLt()) {
        paramBoolean = false;
      }
    }
    for (;;)
    {
      this.zOe = paramb;
      if (h(paramBoolean, this.w, this.h) > 0) {
        break;
      }
      int i = h(paramBoolean, this.w, this.h);
      if (i > 0) {
        break;
      }
      this.HjO = 1;
      AppMethodBeat.o(236147);
      return i;
      localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
      p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
      if (!localb.fLu()) {
        paramBoolean = true;
      }
    }
    if ((!com.tencent.mm.plugin.voip.b.g.fKg()) && (!com.tencent.mm.media.widget.d.b.rG(getRecordScene())))
    {
      paramb = this.Hkf;
      if (paramb != null) {
        paramb.a(this.Hkh);
      }
    }
    for (;;)
    {
      this.HjO = 0;
      AppMethodBeat.o(236147);
      return 1;
      j.fKE();
    }
  }
  
  public final boolean dEO()
  {
    AppMethodBeat.i(236146);
    com.tencent.mm.media.widget.a.d locald = this.Hkf;
    if (locald != null)
    {
      boolean bool = locald.aPc();
      AppMethodBeat.o(236146);
      return bool;
    }
    AppMethodBeat.o(236146);
    return false;
  }
  
  public final void eoc()
  {
    AppMethodBeat.i(236159);
    StringBuilder localStringBuilder = new StringBuilder("StopCapture....mIsInCapture = ");
    Object localObject = this.Hkf;
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((com.tencent.mm.media.widget.a.d)localObject).aPc());
      Log.d("MicroMsg.CommonCaptureRenderer", localObject);
      localObject = this.Hkf;
      if ((localObject != null) && (((com.tencent.mm.media.widget.a.d)localObject).aPc() == true) && (this.Hkf != null))
      {
        localObject = this.Hkf;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.d)localObject).release();
        }
      }
      if (1 == this.HjO)
      {
        localObject = new pl();
        ((pl)localObject).dVC.type = 2;
        EventCenter.instance.publish((IEvent)localObject);
      }
      Log.d("MicroMsg.CommonCaptureRenderer", "UnInitCapture....mCameraOpen = " + this.zOb);
      if (!this.zOb) {
        break label194;
      }
      this.HjO = 0;
      localObject = this.Hkf;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.a.d)localObject).release();
      }
    }
    for (;;)
    {
      this.zOc = false;
      AppMethodBeat.o(236159);
      return;
      localObject = null;
      break;
      label194:
      if (this.Hkf != null)
      {
        localObject = this.Hkf;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.d)localObject).release();
        }
      }
    }
  }
  
  public final boolean fKY()
  {
    AppMethodBeat.i(236150);
    com.tencent.mm.media.widget.a.d locald = this.Hkf;
    if ((locald != null) && (locald.aPu() == 1))
    {
      AppMethodBeat.o(236150);
      return true;
    }
    AppMethodBeat.o(236150);
    return false;
  }
  
  public final boolean fKZ()
  {
    return this.HjJ;
  }
  
  public final int fLa()
  {
    return this.HjO;
  }
  
  /* Error */
  public final int fLb()
  {
    // Byte code:
    //   0: ldc_w 701
    //   3: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 553	com/tencent/mm/plugin/voip/video/camera/b/a:zOb	Z
    //   10: ifne +24 -> 34
    //   13: ldc 199
    //   15: ldc_w 703
    //   18: invokestatic 705	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 637	com/tencent/mm/plugin/voip/video/camera/b/a:HjO	I
    //   26: ldc_w 701
    //   29: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_m1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 399	com/tencent/mm/plugin/voip/video/camera/b/a:Hkf	Lcom/tencent/mm/media/widget/a/d;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +29 -> 69
    //   43: aload_1
    //   44: invokeinterface 658 1 0
    //   49: iconst_1
    //   50: if_icmpne +19 -> 69
    //   53: ldc 199
    //   55: ldc_w 707
    //   58: invokestatic 705	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: ldc_w 701
    //   64: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: iconst_m1
    //   68: ireturn
    //   69: aload_0
    //   70: getfield 709	com/tencent/mm/plugin/voip/video/camera/b/a:mSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   73: ifnull +190 -> 263
    //   76: aload_0
    //   77: getfield 399	com/tencent/mm/plugin/voip/video/camera/b/a:Hkf	Lcom/tencent/mm/media/widget/a/d;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +18 -> 100
    //   85: aload_1
    //   86: aload_0
    //   87: getfield 709	com/tencent/mm/plugin/voip/video/camera/b/a:mSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   90: iconst_0
    //   91: aload_0
    //   92: invokevirtual 711	com/tencent/mm/plugin/voip/video/camera/b/a:getResolutionLimit	()I
    //   95: invokeinterface 714 4 0
    //   100: aload_0
    //   101: getfield 399	com/tencent/mm/plugin/voip/video/camera/b/a:Hkf	Lcom/tencent/mm/media/widget/a/d;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +157 -> 263
    //   109: aload_1
    //   110: iconst_0
    //   111: invokeinterface 718 2 0
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +145 -> 263
    //   121: aload_0
    //   122: new 609	com/tencent/mm/compatible/deviceinfo/ac
    //   125: dup
    //   126: aload_1
    //   127: getfield 364	android/graphics/Point:x	I
    //   130: aload_1
    //   131: getfield 371	android/graphics/Point:y	I
    //   134: invokespecial 721	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   137: putfield 607	com/tencent/mm/plugin/voip/video/camera/b/a:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   140: aload_0
    //   141: getfield 225	com/tencent/mm/plugin/voip/video/camera/b/a:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +17 -> 163
    //   149: aload_2
    //   150: aload_1
    //   151: getfield 364	android/graphics/Point:x	I
    //   154: aload_1
    //   155: getfield 371	android/graphics/Point:y	I
    //   158: invokeinterface 724 3 0
    //   163: new 376	java/lang/StringBuilder
    //   166: dup
    //   167: ldc_w 726
    //   170: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: getfield 179	com/tencent/mm/plugin/voip/video/camera/b/a:w	I
    //   177: invokevirtual 729	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: bipush 44
    //   182: invokevirtual 732	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: getfield 181	com/tencent/mm/plugin/voip/video/camera/b/a:h	I
    //   189: invokevirtual 729	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc_w 734
    //   195: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: astore_2
    //   199: aload_0
    //   200: getfield 607	com/tencent/mm/plugin/voip/video/camera/b/a:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   203: astore_1
    //   204: aload_1
    //   205: ifnull +116 -> 321
    //   208: aload_1
    //   209: getfield 612	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   212: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: astore_1
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: ldc_w 736
    //   224: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: astore_2
    //   228: aload_0
    //   229: getfield 607	com/tencent/mm/plugin/voip/video/camera/b/a:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   232: astore_1
    //   233: aload_1
    //   234: ifnull +92 -> 326
    //   237: aload_1
    //   238: getfield 615	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   241: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: astore_1
    //   245: ldc 199
    //   247: aload_2
    //   248: aload_1
    //   249: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   252: bipush 32
    //   254: invokevirtual 732	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   257: invokevirtual 393	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: ldc_w 701
    //   266: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: iconst_1
    //   270: ireturn
    //   271: astore_1
    //   272: getstatic 574	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   275: ldc2_w 575
    //   278: lconst_0
    //   279: lconst_1
    //   280: iconst_0
    //   281: invokevirtual 580	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   284: getstatic 574	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   287: ldc2_w 575
    //   290: ldc2_w 737
    //   293: lconst_1
    //   294: iconst_0
    //   295: invokevirtual 580	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   298: aload_0
    //   299: iconst_1
    //   300: putfield 637	com/tencent/mm/plugin/voip/video/camera/b/a:HjO	I
    //   303: ldc 199
    //   305: ldc_w 740
    //   308: aload_1
    //   309: invokestatic 743	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   312: invokevirtual 515	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokestatic 705	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: goto -218 -> 100
    //   321: aconst_null
    //   322: astore_1
    //   323: goto -107 -> 216
    //   326: aconst_null
    //   327: astore_1
    //   328: goto -83 -> 245
    //   331: astore_1
    //   332: getstatic 574	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   335: ldc2_w 575
    //   338: lconst_0
    //   339: lconst_1
    //   340: iconst_0
    //   341: invokevirtual 580	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   344: ldc 199
    //   346: ldc_w 745
    //   349: iconst_1
    //   350: anewarray 203	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload_1
    //   356: invokevirtual 595	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   359: aastore
    //   360: invokestatic 627	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   363: ldc_w 701
    //   366: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: iconst_m1
    //   370: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	a
    //   38	211	1	localObject1	Object
    //   271	38	1	localException1	Exception
    //   322	6	1	localObject2	Object
    //   331	25	1	localException2	Exception
    //   144	104	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   76	81	271	java/lang/Exception
    //   85	100	271	java/lang/Exception
    //   100	105	331	java/lang/Exception
    //   109	117	331	java/lang/Exception
    //   121	145	331	java/lang/Exception
    //   149	163	331	java/lang/Exception
    //   163	204	331	java/lang/Exception
    //   208	216	331	java/lang/Exception
    //   216	233	331	java/lang/Exception
    //   237	245	331	java/lang/Exception
    //   245	263	331	java/lang/Exception
  }
  
  public final ac fLc()
  {
    AppMethodBeat.i(236161);
    ac localac1;
    if (this.HjP != null)
    {
      ac localac2 = this.HjP;
      localac1 = localac2;
      if (localac2 == null)
      {
        p.hyc();
        AppMethodBeat.o(236161);
        return localac2;
      }
    }
    else
    {
      localac1 = new ac(this.w, this.h);
    }
    AppMethodBeat.o(236161);
    return localac1;
  }
  
  public final void fLd()
  {
    AppMethodBeat.i(236164);
    Object localObject = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
    p.g(localObject, "VoipCameraCompatible.gVoipCameraInfo");
    if (((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject).aRA() < 2)
    {
      localObject = new StringBuilder("ExchangeCapture...gCameraNum= ");
      localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
      p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
      Log.e("MicroMsg.CommonCaptureRenderer", localb.aRA());
      AppMethodBeat.o(236164);
      return;
    }
    localObject = new StringBuilder("ExchangeCapture start, gCameraNum= ");
    com.tencent.mm.plugin.voip.video.camera.prev.b localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
    p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
    Log.i("MicroMsg.CommonCaptureRenderer", localb.aRA());
    localObject = this.Hkf;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.a.d)localObject).aPb();
    }
    com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
    this.imy = true;
    AppMethodBeat.o(236164);
  }
  
  public final int fLe()
  {
    boolean bool = true;
    AppMethodBeat.i(236162);
    int k;
    int i;
    int j;
    if (fKY())
    {
      k = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
      i = k;
      if (!ae.gKt.gFF) {
        break label151;
      }
      i = k;
      if (ae.gKt.gFE.dYT == 0) {
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
        this.HjJ = bool;
        if (!this.HjJ) {
          break label134;
        }
      }
      label134:
      for (i = OpenGlRender.FLAG_Angle270;; i = OpenGlRender.FLAG_Angle90)
      {
        if (i != OpenGlRender.FLAG_Angle270) {
          break label141;
        }
        AppMethodBeat.o(236162);
        return 90;
        j = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
        i = j;
        if (!ae.gKt.gFH) {
          break label151;
        }
        i = j;
        if (ae.gKt.gFG.dYT == 0) {
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
      AppMethodBeat.o(236162);
      return 270;
      label151:
      j = 0;
    }
  }
  
  public final boolean fLf()
  {
    AppMethodBeat.i(236163);
    if (fKY()) {}
    for (int i = OpenGlRender.FLAG_Mirror; i == OpenGlRender.FLAG_Mirror; i = 0)
    {
      AppMethodBeat.o(236163);
      return true;
    }
    AppMethodBeat.o(236163);
    return false;
  }
  
  public final void fLg()
  {
    AppMethodBeat.i(236149);
    com.tencent.mm.media.widget.a.d locald = this.Hkf;
    int i;
    label41:
    int k;
    int j;
    if (locald != null) {
      if (fKY())
      {
        i = com.tencent.mm.plugin.voip.video.camera.a.c.Hjx;
        i = locald.df(i, this.Hkd);
        this.zOj = i;
        Log.i("MicroMsg.CommonCaptureRenderer", "mIsCurrentFaceCamera is %s, %s,%s,", new Object[] { Integer.valueOf(this.Hkd), Boolean.valueOf(fKY()), Integer.valueOf(this.zOj) });
        if (!fKY()) {
          break label182;
        }
        k = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
        i = k;
        if (!ae.gKt.gFF) {
          break label226;
        }
        i = k;
        if (ae.gKt.gFE.dYT == 0) {
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
        this.HjJ = bool;
        if ((this.zOj != 90) && (j != 0)) {
          this.HjJ = false;
        }
        AppMethodBeat.o(236149);
        return;
        i = com.tencent.mm.plugin.voip.video.camera.a.c.Hjy;
        break;
        i = 0;
        break label41;
        label182:
        j = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
        i = j;
        if (!ae.gKt.gFH) {
          break label226;
        }
        i = j;
        if (ae.gKt.gFG.dYT == 0) {
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
  
  public final int fLh()
  {
    return this.zOj;
  }
  
  public final void fLi()
  {
    boolean bool3 = true;
    AppMethodBeat.i(236158);
    if ((ae.gKt.gGg == 1) && (this.zOc))
    {
      AppMethodBeat.o(236158);
      return;
    }
    if (ae.gKt.gGf > 2000) {
      this.zNW = ae.gKt.gGf;
    }
    Log.e("MicroMsg.CommonCaptureRenderer", "focusOnFace error, faceLocation is null");
    boolean bool1;
    Object localObject1;
    boolean bool2;
    if (System.currentTimeMillis() - this.HjN > this.zNW)
    {
      bool1 = true;
      if ((this.HjK) && (!bool1)) {
        fKY();
      }
      localObject1 = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
      if (this.HjK) {
        break label292;
      }
      bool2 = true;
      label118:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.zNW).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
      if (this.HjL == fKY()) {
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
        localObject1 = this.Hkf;
        if (localObject1 == null) {
          break label308;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.media.widget.a.d)localObject1).aPg());
        if (!((Boolean)localObject1).booleanValue()) {
          break label302;
        }
        if (localObject1 == null) {
          break label308;
        }
        ((Boolean)localObject1).booleanValue();
        this.HjS = null;
        this.HjN = System.currentTimeMillis();
        this.HjK = true;
        this.HjL = fKY();
        AppMethodBeat.o(236158);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CommonCaptureRenderer", "mCamera.getParameters() or autoFocus fail!".concat(String.valueOf(localException)));
        AppMethodBeat.o(236158);
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
    AppMethodBeat.o(236158);
  }
  
  public final b.a fLv()
  {
    AppMethodBeat.i(236152);
    b.a locala2;
    b.a locala1;
    if (this.Hkg != null)
    {
      locala2 = this.Hkg;
      locala1 = locala2;
      if (locala2 == null)
      {
        p.hyc();
        AppMethodBeat.o(236152);
        return locala2;
      }
    }
    else
    {
      aDz();
      locala2 = this.Hkg;
      locala1 = locala2;
      if (locala2 == null)
      {
        p.hyc();
        locala1 = locala2;
      }
    }
    AppMethodBeat.o(236152);
    return locala1;
  }
  
  public final int getRecordScene()
  {
    return 12;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(236151);
    if (v2protocal.Har)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
      locala = com.tencent.mm.plugin.voip.video.camera.a.d.HjH;
      i = com.tencent.mm.plugin.voip.video.camera.a.d.fLo();
      AppMethodBeat.o(236151);
      return i;
    }
    d.a locala = com.tencent.mm.plugin.voip.video.camera.a.d.HjH;
    int i = com.tencent.mm.plugin.voip.video.camera.a.d.fLn();
    AppMethodBeat.o(236151);
    return i;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    this.Hkd = paramInt;
  }
  
  public final void q(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(236145);
    p.h(paramSurfaceTexture, "surfaceTexture");
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(236145);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFrameData"})
  static final class b
    implements com.tencent.mm.plugin.mmsight.model.g
  {
    b(a parama) {}
    
    public final boolean ai(byte[] paramArrayOfByte)
    {
      Object localObject2 = null;
      boolean bool2 = false;
      AppMethodBeat.i(236144);
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.length != 0) {
          break label87;
        }
      }
      label87:
      for (int i = 1; i != 0; i = 0)
      {
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        h.CyF.idkeyStat(159L, 3L, 1L, false);
        if (a.a(this.Hkj) != null)
        {
          paramArrayOfByte = a.a(this.Hkj);
          if (paramArrayOfByte != null) {
            paramArrayOfByte.cza();
          }
        }
        AppMethodBeat.o(236144);
        return false;
      }
      int k;
      int j;
      if (this.Hkj.fKY())
      {
        k = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
        i = k;
        if (!ae.gKt.gFF) {
          break label490;
        }
        i = k;
        if (ae.gKt.gFE.dYT == 0) {
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
          localObject1 = this.Hkj;
          boolean bool1 = bool2;
          if (j == 0)
          {
            bool1 = bool2;
            if (i > 0) {
              bool1 = true;
            }
          }
          a.a((a)localObject1, bool1);
          if ((a.a(this.Hkj) != null) && (a.b(this.Hkj) != null))
          {
            localObject3 = (Map)this.Hkj.fLv().ird;
            localObject1 = a.b(this.Hkj);
            if (localObject1 == null) {
              break label478;
            }
            localObject1 = Integer.valueOf(((com.tencent.mm.media.widget.a.d)localObject1).aPu());
            if ((((Map)localObject3).get(localObject1) != null) && (this.Hkj.fLc() != null))
            {
              localObject3 = a.a(this.Hkj);
              if (localObject3 != null)
              {
                l = paramArrayOfByte.length;
                localObject1 = this.Hkj.fLc();
                if (localObject1 == null) {
                  p.hyc();
                }
                i = ((ac)localObject1).width;
                localObject1 = this.Hkj.fLc();
                if (localObject1 == null) {
                  p.hyc();
                }
                j = ((ac)localObject1).height;
                localObject4 = (Map)this.Hkj.fLv().ird;
                localObject1 = a.b(this.Hkj);
                if (localObject1 == null) {
                  break label484;
                }
              }
            }
          }
        }
        label478:
        label484:
        for (Object localObject1 = Integer.valueOf(((com.tencent.mm.media.widget.a.d)localObject1).aPu());; localObject1 = null)
        {
          localObject4 = (b.a.d)((Map)localObject4).get(localObject1);
          localObject1 = localObject2;
          if (localObject4 != null) {
            localObject1 = ((b.a.d)localObject4).irk;
          }
          if (localObject1 == null) {
            p.hyc();
          }
          ((com.tencent.mm.plugin.voip.video.camera.a.b)localObject3).a(paramArrayOfByte, l, i, j, ((Integer)localObject1).intValue(), k);
          AppMethodBeat.o(236144);
          return true;
          j = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
          i = j;
          if (!ae.gKt.gFH) {
            break label490;
          }
          i = j;
          if (ae.gKt.gFG.dYT == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.b.a
 * JD-Core Version:    0.7.0.1
 */