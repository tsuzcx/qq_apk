package com.tencent.mm.plugin.voip.video.camera.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rw;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.a;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.c;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.d;
import com.tencent.mm.media.widget.camerarecordview.d.b.a.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.e;
import com.tencent.mm.plugin.voip.video.camera.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/camera/v2/CommonCaptureRenderer;", "Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "Lcom/tencent/mm/plugin/voip/video/camera/common/DeviceOrientationHelp$DeviceOrientationListener;", "context", "Landroid/content/Context;", "w", "", "h", "(Landroid/content/Context;II)V", "cameraFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "displayOrientation", "getH", "()I", "setH", "(I)V", "mAutoFocusTimeOut", "", "getMAutoFocusTimeOut", "()J", "setMAutoFocusTimeOut", "(J)V", "mCamera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "mCameraDeviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "mCameraErr", "mCameraOpen", "", "mCameraOpenFaild", "mDeviceOrientationHelp", "Lcom/tencent/mm/plugin/voip/video/camera/common/DeviceOrientationHelp;", "mGetCameraDataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "()Z", "setMIsCameraNoParamAutoFocus", "(Z)V", "mIsCameraRemote180", "mIsContinuousVideoMode", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsLastAutoFocusFaceCamera", "getMIsLastAutoFocusFaceCamera", "setMIsLastAutoFocusFaceCamera", "mLastAutoFocusTimestamp", "getMLastAutoFocusTimestamp", "setMLastAutoFocusTimestamp", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mScreenRotation", "mSensorOrientation", "mSize", "Landroid/util/Size;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getMSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setMSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getW", "setW", "bind", "", "surfaceTexture", "exchangeCapture", "focusOnFace", "faceLocation", "isClickScreen", "getCameraConfig", "getCameraErrCode", "getCameraFps", "getCurrentCameraIsFace", "getDisplayOrientation", "getPreviewSize", "getRecordScene", "getResolutionLimit", "getRotateAngle", "initCamera", "bFace", "initCameraConfig", "initCapture", "dataCallback", "bFaceFirst", "initFocusStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "cameraId", "initFormatStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "initSizeStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "mCameraId", "isCameraRemote180", "isMirror", "isPreviewing", "onOrientationChange", "rotation", "onSensorOrientationChanged", "orientation", "setDisplayOrientation", "startCapture", "stopCapture", "unInit", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.voip.video.camera.a.a
  implements com.tencent.mm.media.widget.camerarecordview.d.b, com.tencent.mm.plugin.voip.video.camera.a.b.a
{
  public static final a.a UOS;
  private long LpN;
  private boolean LpS;
  private boolean LpT;
  private com.tencent.mm.plugin.voip.video.camera.a.c LpV;
  private int Lqa;
  private boolean Lqd;
  private com.tencent.mm.plugin.voip.video.camera.a.b Lwy;
  private int UOA;
  private int[] UOE;
  private int UOP;
  private Size UOQ;
  private com.tencent.mm.media.widget.a.f UOT;
  private com.tencent.mm.media.widget.camerarecordview.d.b.a UOU;
  private g UOV;
  private boolean UOv;
  private boolean UOw;
  private boolean UOx;
  private long UOz;
  private Context context;
  private int h;
  private SurfaceTexture mSurfaceTexture;
  private boolean nGD;
  private int nHi;
  private int w;
  
  static
  {
    AppMethodBeat.i(292984);
    UOS = new a.a((byte)0);
    AppMethodBeat.o(292984);
  }
  
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292929);
    this.context = paramContext;
    this.w = paramInt1;
    this.h = paramInt2;
    this.UOV = new a..ExternalSyntheticLambda0(this);
    com.tencent.mm.plugin.voip.video.camera.a.d.kC(this.context);
    bfb();
    Log.d("MicroMsg.CommonCaptureRenderer", "width: %d, height: %d", new Object[] { Integer.valueOf(this.w), Integer.valueOf(this.h) });
    this.nGD = true;
    this.LpN = 30000L;
    AppMethodBeat.o(292929);
  }
  
  private static final boolean a(a parama, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    AppMethodBeat.i(292979);
    s.u(parama, "this$0");
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label87;
      }
    }
    label87:
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 3L, 1L, false);
      if (parama.LpV != null)
      {
        parama = parama.LpV;
        if (parama != null) {
          parama.dre();
        }
      }
      AppMethodBeat.o(292979);
      return false;
    }
    int j;
    int k;
    if (parama.icu())
    {
      i = com.tencent.mm.plugin.voip.video.camera.a.d.UOl;
      j = i;
      if (!af.lXY.lSW) {
        break label431;
      }
      j = i;
      if (af.lXY.lSV.hYK == 0) {
        break label431;
      }
      k = 1;
      j = i;
      i = k;
    }
    for (;;)
    {
      label144:
      Object localObject1;
      label209:
      long l;
      if (j > 0)
      {
        k = 32;
        boolean bool1 = bool2;
        if (i == 0)
        {
          bool1 = bool2;
          if (j > 0) {
            bool1 = true;
          }
        }
        parama.UOv = bool1;
        if ((parama.LpV != null) && (parama.UOT != null))
        {
          Object localObject3 = (Map)parama.icL().nKS;
          localObject1 = parama.UOT;
          if (localObject1 != null) {
            break label395;
          }
          localObject1 = null;
          if ((((Map)localObject3).get(localObject1) != null) && (parama.hq() != null))
          {
            localObject1 = parama.LpV;
            if (localObject1 != null)
            {
              l = paramArrayOfByte.length;
              localObject3 = parama.hq();
              s.checkNotNull(localObject3);
              i = ((Size)localObject3).getWidth();
              localObject3 = parama.hq();
              s.checkNotNull(localObject3);
              j = ((Size)localObject3).getHeight();
              localObject3 = (Map)parama.icL().nKS;
              parama = parama.UOT;
              if (parama != null) {
                break label410;
              }
              parama = null;
              label301:
              parama = (b.a.d)((Map)localObject3).get(parama);
              if (parama != null) {
                break label423;
              }
            }
          }
        }
      }
      label395:
      label410:
      label423:
      for (parama = localObject2;; parama = parama.nKZ)
      {
        s.checkNotNull(parama);
        ((com.tencent.mm.plugin.voip.video.camera.a.c)localObject1).a(paramArrayOfByte, l, i, j, parama.intValue(), k);
        AppMethodBeat.o(292979);
        return true;
        k = com.tencent.mm.plugin.voip.video.camera.a.d.UOm;
        j = k;
        if (!af.lXY.lSY) {
          break label431;
        }
        j = k;
        if (af.lXY.lSX.hYK == 0) {
          break label431;
        }
        i = 1;
        j = k;
        break;
        k = 0;
        break label144;
        localObject1 = Integer.valueOf(((com.tencent.mm.media.widget.a.f)localObject1).btf());
        break label209;
        parama = Integer.valueOf(parama.btf());
        break label301;
      }
      label431:
      i = 0;
    }
  }
  
  private static b.a.b arp(int paramInt)
  {
    AppMethodBeat.i(292957);
    b.a.b localb = new b.a.b((byte)0);
    ArrayList localArrayList;
    if ((af.lXY.lTy == 0) && (paramInt == 1))
    {
      localArrayList = localb.nKU;
      if (localArrayList != null) {
        localArrayList.add(b.b.but());
      }
      localArrayList = localb.nKU;
      if (localArrayList != null) {
        localArrayList.add(b.b.bur());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(292957);
      return localb;
      if ((af.lXY.lTy == 1) || (paramInt == 0))
      {
        localArrayList = localb.nKU;
        if (localArrayList != null) {
          localArrayList.add(b.b.bur());
        }
        localArrayList = localb.nKU;
        if (localArrayList != null) {
          localArrayList.add(b.b.but());
        }
      }
    }
  }
  
  private static b.a.e arq(int paramInt)
  {
    AppMethodBeat.i(292970);
    b.a.e locale = new b.a.e();
    if (paramInt == 1) {}
    for (Point localPoint = com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UON;; localPoint = com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UOO)
    {
      if (localPoint != null)
      {
        locale.nLa = Integer.valueOf(localPoint.x);
        locale.nLb = Integer.valueOf(localPoint.y);
        Log.i("MicroMsg.CommonCaptureRenderer", "getCameraSize from table:" + locale.nLa + ',' + locale.nLb);
      }
      AppMethodBeat.o(292970);
      return locale;
    }
  }
  
  private void bfb()
  {
    AppMethodBeat.i(292950);
    b.a.a locala = new b.a.a();
    com.tencent.mm.compatible.c.a locala1 = com.tencent.mm.compatible.c.a.lQF;
    int j = com.tencent.mm.compatible.c.a.aOk();
    int i;
    if (j >= 0) {
      i = 0;
    }
    for (;;)
    {
      locala.a(new r[] { new r(Integer.valueOf(i), arp(i)) });
      locala.b(new r[] { new r(Integer.valueOf(i), icN()) });
      locala.c(new r[] { new r(Integer.valueOf(i), arq(i)) });
      locala.d(new r[] { new r(Integer.valueOf(i), icM()) });
      locala.h(new String[] { b.b.buu() });
      if (i == j)
      {
        locala.scene = 12;
        this.UOU = locala.buq();
        AppMethodBeat.o(292950);
        return;
      }
      i += 1;
    }
  }
  
  private com.tencent.mm.media.widget.camerarecordview.d.b.a icL()
  {
    AppMethodBeat.i(292945);
    if (this.UOU != null)
    {
      locala = this.UOU;
      s.checkNotNull(locala);
      AppMethodBeat.o(292945);
      return locala;
    }
    bfb();
    com.tencent.mm.media.widget.camerarecordview.d.b.a locala = this.UOU;
    s.checkNotNull(locala);
    AppMethodBeat.o(292945);
    return locala;
  }
  
  private static b.a.d icM()
  {
    AppMethodBeat.i(292954);
    b.a.d locald = new b.a.d();
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOn <= 0) {}
    for (Integer localInteger = Integer.valueOf(7);; localInteger = Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.d.UOn))
    {
      locald.nKZ = localInteger;
      AppMethodBeat.o(292954);
      return locald;
    }
  }
  
  private static b.a.c icN()
  {
    AppMethodBeat.i(292964);
    b.a.c localc = new b.a.c();
    int k = com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UOI;
    Log.i("MicroMsg.CommonCaptureRenderer", "safeSetFps: %s", new Object[] { Integer.valueOf(k) });
    if (MMApplicationContext.isMainProcess()) {}
    for (int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("VoipCaptureRenderFpsRangeMinApiLevel", 26);; i = 26)
    {
      Log.i("MicroMsg.CommonCaptureRenderer", "setFpsRange minApiLevel:%s", new Object[] { Integer.valueOf(i) });
      if ((l.isSamsung()) || (com.tencent.mm.compatible.util.d.rb(i)))
      {
        i = -1;
        if (af.lXY == null) {
          break label378;
        }
        i = af.lXY.lTD * 1000;
      }
      label378:
      for (int j = af.lXY.lTE * 1000;; j = 0)
      {
        boolean bool;
        if ((i > 0) && (j > 0) && (j >= i))
        {
          localc.nKY = Boolean.FALSE;
          localc.nKV = Integer.valueOf(i);
          localc.nKW = Integer.valueOf(j);
          localc.nKX = Integer.valueOf(k);
          bool = true;
          Log.i("MicroMsg.CommonCaptureRenderer", "steve: dkfps get fit  [%d %d], target fps %d, matchTargetFPS:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) });
        }
        for (;;)
        {
          AppMethodBeat.o(292964);
          return localc;
          if ((i == 0) && (j == 0))
          {
            localc.nKY = Boolean.TRUE;
            localc.nKV = Integer.valueOf(k);
            localc.nKW = Integer.valueOf(k);
            localc.nKX = Integer.valueOf(k);
            bool = false;
            i = -2147483648;
            j = -2147483648;
            break;
          }
          localc.nKX = Integer.valueOf(k);
          localc.nKW = Integer.valueOf(Math.min(k + 5, 30));
          localc.nKV = Integer.valueOf(Math.max(k - 5, 5));
          bool = false;
          i = -2147483648;
          j = -2147483648;
          break;
          localc.nKY = Boolean.TRUE;
          localc.nKV = Integer.valueOf(k);
          localc.nKW = Integer.valueOf(k);
          localc.nKX = Integer.valueOf(k);
        }
      }
    }
  }
  
  private final int o(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Integer localInteger2 = null;
    AppMethodBeat.i(292940);
    Log.i("MicroMsg.CommonCaptureRenderer", s.X("try open camera, face: ", Boolean.valueOf(paramBoolean)));
    this.LpT = false;
    boolean bool;
    label176:
    label199:
    label204:
    Object localObject3;
    if (this.UOT != null)
    {
      if (icu() != paramBoolean)
      {
        localObject1 = this.UOT;
        if (localObject1 == null) {
          break label822;
        }
        ((com.tencent.mm.media.widget.a.f)localObject1).release();
        bool = true;
        if (!bool) {
          break label204;
        }
        if (!com.tencent.mm.plugin.voip.f.h.ibA()) {
          break label176;
        }
        this.UOT = ((com.tencent.mm.media.widget.a.f)new com.tencent.mm.media.widget.b.f(this.context, paramInt1, paramInt2));
        if (com.tencent.mm.media.widget.d.c.uz(getRecordScene()))
        {
          localObject1 = this.UOT;
          if (localObject1 != null) {
            ((com.tencent.mm.media.widget.a.f)localObject1).bsE();
          }
        }
      }
      for (;;)
      {
        localObject1 = this.UOT;
        if (localObject1 != null) {
          ((com.tencent.mm.media.widget.a.f)localObject1).a(icL());
        }
        if (this.UOT != null) {
          break label199;
        }
        this.LpS = false;
        AppMethodBeat.o(292940);
        return -1;
        bool = this.Lqd;
        break;
        this.UOT = ((com.tencent.mm.media.widget.a.f)new com.tencent.mm.media.widget.a.h(this.context, paramInt1, paramInt2));
      }
      this.Lqd = false;
      Object localObject1 = this.UOT;
      if (localObject1 != null)
      {
        localObject3 = this.context;
        if (!paramBoolean)
        {
          paramBoolean = true;
          ((com.tencent.mm.media.widget.a.f)localObject1).A((Context)localObject3, paramBoolean);
        }
      }
      else
      {
        localObject1 = this.UOT;
        if (localObject1 == null) {
          break label404;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.media.widget.a.f)localObject1).uh(getRecordScene()));
        if (((Boolean)localObject1).booleanValue()) {
          break label363;
        }
        paramInt1 = 1;
        label275:
        if (paramInt1 == 0) {
          break label368;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label404;
        }
        ((Boolean)localObject1).booleanValue();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 0L, 1L, false);
        if (this.LpV != null) {}
        try
        {
          localObject1 = this.LpV;
          s.checkNotNull(localObject1);
          ((com.tencent.mm.plugin.voip.video.camera.a.c)localObject1).dre();
          this.Lqd = true;
          localObject1 = this.UOT;
          if (localObject1 != null) {
            ((com.tencent.mm.media.widget.a.f)localObject1).release();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.CommonCaptureRenderer", (Throwable)localException1, "Camera open failed2, error:%s", new Object[] { localException1.getMessage() });
          }
        }
        AppMethodBeat.o(292940);
        return -1;
        paramBoolean = false;
        break;
        label363:
        paramInt1 = 0;
        break label275;
        label368:
        localObject1 = null;
      }
      label404:
      this.LpS = true;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject2 = this.UOT;
        if (localObject2 == null) {
          paramInt1 = 0;
        }
      }
      catch (Exception localException2)
      {
        Object localObject2;
        label534:
        Log.e("MicroMsg.CommonCaptureRenderer", "getPreviewFrameRate failed: %s", new Object[] { localException2.getMessage() });
        paramInt1 = 0;
        continue;
        if (icu())
        {
          paramInt2 = com.tencent.mm.plugin.voip.video.camera.a.d.UOj;
          paramInt2 = localException2.ev(paramInt2, this.UOP);
          continue;
        }
        paramInt2 = com.tencent.mm.plugin.voip.video.camera.a.d.UOk;
        continue;
        i = com.tencent.mm.plugin.voip.video.camera.a.d.UOm;
        paramInt2 = i;
        if (!af.lXY.lSY) {}
      }
      try
      {
        localObject2 = this.UOT;
        if (localObject2 != null) {
          continue;
        }
        paramInt2 = 0;
        this.Lqa = paramInt2;
        Log.i("MicroMsg.CommonCaptureRenderer", "mIsCurrentFaceCamera is %s, %s,%s,", new Object[] { Integer.valueOf(this.UOP), Boolean.valueOf(icu()), Integer.valueOf(this.Lqa) });
        if (!icu()) {
          continue;
        }
        i = com.tencent.mm.plugin.voip.video.camera.a.d.UOl;
        paramInt2 = i;
        if (!af.lXY.lSW) {
          break label816;
        }
        paramInt2 = i;
        if (af.lXY.lSV.hYK == 0) {
          break label816;
        }
        j = 1;
        paramInt2 = i;
        i = j;
      }
      catch (Exception localException3)
      {
        Log.e("MicroMsg.CommonCaptureRenderer", "setDisplayOrientation failed: %s", new Object[] { localException3.getMessage() });
        continue;
        localInteger1 = Integer.valueOf(localException3.getWidth());
        continue;
        localInteger2 = Integer.valueOf(((Size)localObject3).getHeight());
        continue;
        i = 0;
      }
      this.UOv = paramBoolean;
      if ((this.Lqa != 90) && (i != 0)) {
        this.UOv = false;
      }
      localObject2 = this.UOQ;
      if (localObject2 == null)
      {
        localObject2 = null;
        localObject3 = this.UOQ;
        if (localObject3 != null) {
          break label803;
        }
        Log.i("MicroMsg.CommonCaptureRenderer", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d,  IsRotate180: %d, displayOrientation: %d", new Object[] { Integer.valueOf(paramInt1), localObject2, localInteger2, Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.d.UOl), Integer.valueOf(this.Lqa) });
        AppMethodBeat.o(292940);
        return 1;
        paramInt1 = ((com.tencent.mm.media.widget.a.f)localObject2).bsG();
        continue;
        j = af.lXY.lSX.hYK;
        paramInt2 = i;
        if (j == 0) {
          break label816;
        }
        j = 1;
        paramInt2 = i;
        i = j;
      }
      label803:
      label816:
      label822:
      while ((i != 0) || (paramInt2 <= 0))
      {
        paramBoolean = false;
        break label534;
        Integer localInteger1;
        bool = true;
        break;
      }
      paramBoolean = true;
    }
  }
  
  public final void Jd(int paramInt)
  {
    AppMethodBeat.i(293098);
    this.nHi = paramInt;
    com.tencent.mm.plugin.voip.video.camera.a.c localc = this.LpV;
    if (localc != null) {
      localc.Jd(this.nHi);
    }
    AppMethodBeat.o(293098);
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(293026);
    s.u(paramc, "dataCallback");
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP <= 0)
    {
      this.UOA = 1;
      AppMethodBeat.o(293026);
      return -1;
    }
    if (paramBoolean) {
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UOJ) {
        paramBoolean = false;
      }
    }
    for (;;)
    {
      this.LpV = paramc;
      if (o(paramBoolean, this.w, this.h) > 0) {
        break;
      }
      int i = o(paramBoolean, this.w, this.h);
      if (i > 0) {
        break;
      }
      this.UOA = 1;
      AppMethodBeat.o(293026);
      return i;
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UOK) {
        paramBoolean = true;
      }
    }
    this.UOA = 0;
    AppMethodBeat.o(293026);
    return 1;
  }
  
  public final boolean boa()
  {
    AppMethodBeat.i(292999);
    com.tencent.mm.media.widget.a.f localf = this.UOT;
    if (localf == null)
    {
      AppMethodBeat.o(292999);
      return false;
    }
    boolean bool = localf.bsD();
    AppMethodBeat.o(292999);
    return bool;
  }
  
  public final boolean bqb()
  {
    AppMethodBeat.i(293088);
    if (icu()) {}
    for (int i = OpenGlRender.FLAG_Mirror; i == OpenGlRender.FLAG_Mirror; i = 0)
    {
      AppMethodBeat.o(293088);
      return true;
    }
    AppMethodBeat.o(293088);
    return false;
  }
  
  public final int getRecordScene()
  {
    return 12;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(293036);
    if (v2protocal.UDp)
    {
      Log.i("MicroMsg.VoIPRenderMgr", "jcchen: 1280 capture!");
      locala = e.UOq;
      i = e.icI();
      AppMethodBeat.o(293036);
      return i;
    }
    e.a locala = e.UOq;
    int i = e.icH();
    AppMethodBeat.o(293036);
    return i;
  }
  
  public final void ggH()
  {
    AppMethodBeat.i(293059);
    Object localObject = this.UOT;
    int i;
    if (localObject == null)
    {
      localObject = null;
      Log.d("MicroMsg.CommonCaptureRenderer", s.X("StopCapture....mIsInCapture = ", localObject));
      localObject = this.UOT;
      if ((localObject == null) || (((com.tencent.mm.media.widget.a.f)localObject).bsD() != true)) {
        break label193;
      }
      i = 1;
      label50:
      if ((i != 0) && (this.UOT != null))
      {
        localObject = this.UOT;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.f)localObject).release();
        }
      }
      if (1 == this.UOA)
      {
        localObject = new rw();
        ((rw)localObject).hUY.type = 2;
        ((rw)localObject).publish();
      }
      Log.d("MicroMsg.CommonCaptureRenderer", s.X("UnInitCapture....mCameraOpen = ", Boolean.valueOf(this.LpS)));
      if (!this.LpS) {
        break label198;
      }
      this.UOA = 0;
      localObject = this.UOT;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.a.f)localObject).release();
      }
    }
    for (;;)
    {
      this.LpT = false;
      localObject = this.Lwy;
      if (localObject != null) {
        ((com.tencent.mm.plugin.voip.video.camera.a.b)localObject).unInit();
      }
      this.Lwy = null;
      AppMethodBeat.o(293059);
      return;
      localObject = Boolean.valueOf(((com.tencent.mm.media.widget.a.f)localObject).bsD());
      break;
      label193:
      i = 0;
      break label50;
      label198:
      if (this.UOT != null)
      {
        localObject = this.UOT;
        if (localObject != null) {
          ((com.tencent.mm.media.widget.a.f)localObject).release();
        }
      }
    }
  }
  
  public final Size hq()
  {
    AppMethodBeat.i(293074);
    if (this.UOQ != null)
    {
      localSize = this.UOQ;
      s.checkNotNull(localSize);
      AppMethodBeat.o(293074);
      return localSize;
    }
    Size localSize = new Size(this.w, this.h);
    AppMethodBeat.o(293074);
    return localSize;
  }
  
  public final int icA()
  {
    return this.Lqa;
  }
  
  public final void icB()
  {
    boolean bool3 = true;
    AppMethodBeat.i(293052);
    if ((af.lXY.lTy == 1) && (this.LpT))
    {
      AppMethodBeat.o(293052);
      return;
    }
    if (af.lXY.lTx > 2000) {
      this.LpN = af.lXY.lTx;
    }
    Log.e("MicroMsg.CommonCaptureRenderer", "focusOnFace error, faceLocation is null");
    boolean bool1;
    if (System.currentTimeMillis() - this.UOz > this.LpN) {
      bool1 = true;
    }
    for (;;)
    {
      if ((this.UOw) && (!bool1)) {
        icu();
      }
      Object localObject = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
      boolean bool2;
      if (!this.UOw)
      {
        bool2 = true;
        label118:
        localObject = ((StringBuilder)localObject).append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.LpN).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
        if (this.UOx == icu()) {
          break label272;
        }
        bool1 = bool3;
        label168:
        Log.i("MicroMsg.CommonCaptureRenderer", bool1 + ",isClickScreen :true");
      }
      try
      {
        localObject = this.UOT;
        if (localObject != null)
        {
          localObject = Boolean.valueOf(((com.tencent.mm.media.widget.a.f)localObject).bsH());
          if (((Boolean)localObject).booleanValue()) {}
          for (;;)
          {
            if (localObject == null) {
              break label298;
            }
            ((Boolean)localObject).booleanValue();
            this.UOE = null;
            this.UOz = System.currentTimeMillis();
            this.UOw = true;
            this.UOx = icu();
            AppMethodBeat.o(293052);
            return;
            bool1 = false;
            break;
            bool2 = false;
            break label118;
            label272:
            bool1 = false;
            break label168;
            localObject = null;
          }
        }
        label298:
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CommonCaptureRenderer", s.X("mCamera.getParameters() or autoFocus fail!", localException));
        AppMethodBeat.o(293052);
      }
    }
  }
  
  public final int icC()
  {
    return 0;
  }
  
  public final boolean icu()
  {
    AppMethodBeat.i(293031);
    com.tencent.mm.media.widget.a.f localf = this.UOT;
    if ((localf != null) && (localf.btf() == 1))
    {
      AppMethodBeat.o(293031);
      return true;
    }
    AppMethodBeat.o(293031);
    return false;
  }
  
  public final boolean icv()
  {
    return this.UOv;
  }
  
  public final int icw()
  {
    return this.UOA;
  }
  
  /* Error */
  public final int icx()
  {
    // Byte code:
    //   0: ldc_w 824
    //   3: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 627	com/tencent/mm/plugin/voip/video/camera/b/a:LpS	Z
    //   10: ifne +24 -> 34
    //   13: ldc 219
    //   15: ldc_w 826
    //   18: invokestatic 781	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 696	com/tencent/mm/plugin/voip/video/camera/b/a:UOA	I
    //   26: ldc_w 824
    //   29: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_m1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 295	com/tencent/mm/plugin/voip/video/camera/b/a:UOT	Lcom/tencent/mm/media/widget/a/f;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +35 -> 75
    //   43: aload_2
    //   44: invokeinterface 709 1 0
    //   49: iconst_1
    //   50: if_icmpne +25 -> 75
    //   53: iconst_1
    //   54: istore_1
    //   55: iload_1
    //   56: ifeq +24 -> 80
    //   59: ldc 219
    //   61: ldc_w 828
    //   64: invokestatic 781	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: ldc_w 824
    //   70: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_m1
    //   74: ireturn
    //   75: iconst_0
    //   76: istore_1
    //   77: goto -22 -> 55
    //   80: aload_0
    //   81: getfield 830	com/tencent/mm/plugin/voip/video/camera/b/a:mSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   84: ifnull +178 -> 262
    //   87: aload_0
    //   88: getfield 295	com/tencent/mm/plugin/voip/video/camera/b/a:UOT	Lcom/tencent/mm/media/widget/a/f;
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +18 -> 111
    //   96: aload_2
    //   97: aload_0
    //   98: getfield 830	com/tencent/mm/plugin/voip/video/camera/b/a:mSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   101: iconst_0
    //   102: aload_0
    //   103: invokevirtual 832	com/tencent/mm/plugin/voip/video/camera/b/a:getResolutionLimit	()I
    //   106: invokeinterface 835 4 0
    //   111: aload_0
    //   112: getfield 295	com/tencent/mm/plugin/voip/video/camera/b/a:UOT	Lcom/tencent/mm/media/widget/a/f;
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +145 -> 262
    //   120: aload_2
    //   121: iconst_0
    //   122: invokeinterface 839 2 0
    //   127: astore_2
    //   128: aload_2
    //   129: ifnull +133 -> 262
    //   132: aload_0
    //   133: new 321	android/util/Size
    //   136: dup
    //   137: aload_2
    //   138: getfield 402	android/graphics/Point:x	I
    //   141: aload_2
    //   142: getfield 408	android/graphics/Point:y	I
    //   145: invokespecial 771	android/util/Size:<init>	(II)V
    //   148: putfield 661	com/tencent/mm/plugin/voip/video/camera/b/a:UOQ	Landroid/util/Size;
    //   151: aload_0
    //   152: getfield 260	com/tencent/mm/plugin/voip/video/camera/b/a:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   155: astore_3
    //   156: aload_3
    //   157: ifnull +17 -> 174
    //   160: aload_3
    //   161: aload_2
    //   162: getfield 402	android/graphics/Point:x	I
    //   165: aload_2
    //   166: getfield 408	android/graphics/Point:y	I
    //   169: invokeinterface 842 3 0
    //   174: new 413	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 844
    //   181: invokespecial 418	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: getfield 199	com/tencent/mm/plugin/voip/video/camera/b/a:w	I
    //   188: invokevirtual 847	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: bipush 44
    //   193: invokevirtual 425	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 201	com/tencent/mm/plugin/voip/video/camera/b/a:h	I
    //   200: invokevirtual 847	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: ldc_w 849
    //   206: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: astore_3
    //   210: aload_0
    //   211: getfield 661	com/tencent/mm/plugin/voip/video/camera/b/a:UOQ	Landroid/util/Size;
    //   214: astore_2
    //   215: aload_2
    //   216: ifnonnull +142 -> 358
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_3
    //   222: aload_2
    //   223: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: ldc_w 851
    //   229: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: astore_3
    //   233: aload_0
    //   234: getfield 661	com/tencent/mm/plugin/voip/video/camera/b/a:UOQ	Landroid/util/Size;
    //   237: astore_2
    //   238: aload_2
    //   239: ifnonnull +130 -> 369
    //   242: aconst_null
    //   243: astore_2
    //   244: ldc 219
    //   246: aload_3
    //   247: aload_2
    //   248: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: bipush 32
    //   253: invokevirtual 425	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   256: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 431	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_0
    //   263: getfield 763	com/tencent/mm/plugin/voip/video/camera/b/a:Lwy	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   266: ifnonnull +18 -> 284
    //   269: aload_0
    //   270: new 765	com/tencent/mm/plugin/voip/video/camera/a/b
    //   273: dup
    //   274: aload_0
    //   275: checkcast 8	com/tencent/mm/plugin/voip/video/camera/a/b$a
    //   278: invokespecial 854	com/tencent/mm/plugin/voip/video/camera/a/b:<init>	(Lcom/tencent/mm/plugin/voip/video/camera/a/b$a;)V
    //   281: putfield 763	com/tencent/mm/plugin/voip/video/camera/b/a:Lwy	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   284: aload_0
    //   285: getfield 260	com/tencent/mm/plugin/voip/video/camera/b/a:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   288: astore_2
    //   289: aload_2
    //   290: ifnull +13 -> 303
    //   293: aload_2
    //   294: aload_0
    //   295: getfield 686	com/tencent/mm/plugin/voip/video/camera/b/a:nHi	I
    //   298: invokeinterface 688 2 0
    //   303: ldc_w 824
    //   306: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: iconst_1
    //   310: ireturn
    //   311: astore_2
    //   312: getstatic 250	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   315: ldc2_w 251
    //   318: lconst_0
    //   319: lconst_1
    //   320: iconst_0
    //   321: invokevirtual 256	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   324: getstatic 250	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   327: ldc2_w 251
    //   330: ldc2_w 855
    //   333: lconst_1
    //   334: iconst_0
    //   335: invokevirtual 256	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   338: aload_0
    //   339: iconst_1
    //   340: putfield 696	com/tencent/mm/plugin/voip/video/camera/b/a:UOA	I
    //   343: ldc 219
    //   345: ldc_w 858
    //   348: aload_2
    //   349: invokestatic 598	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   352: invokestatic 781	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: goto -244 -> 111
    //   358: aload_2
    //   359: invokevirtual 324	android/util/Size:getWidth	()I
    //   362: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: astore_2
    //   366: goto -145 -> 221
    //   369: aload_2
    //   370: invokevirtual 327	android/util/Size:getHeight	()I
    //   373: istore_1
    //   374: iload_1
    //   375: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   378: astore_2
    //   379: goto -135 -> 244
    //   382: astore_2
    //   383: getstatic 250	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   386: ldc2_w 251
    //   389: lconst_0
    //   390: lconst_1
    //   391: iconst_0
    //   392: invokevirtual 256	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   395: ldc 219
    //   397: ldc_w 860
    //   400: iconst_1
    //   401: anewarray 223	java/lang/Object
    //   404: dup
    //   405: iconst_0
    //   406: aload_2
    //   407: invokevirtual 649	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   410: aastore
    //   411: invokestatic 671	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: ldc_w 824
    //   417: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: iconst_m1
    //   421: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	a
    //   54	321	1	i	int
    //   38	256	2	localObject1	Object
    //   311	48	2	localException1	Exception
    //   365	14	2	localInteger	Integer
    //   382	25	2	localException2	Exception
    //   155	92	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   87	92	311	java/lang/Exception
    //   96	111	311	java/lang/Exception
    //   111	116	382	java/lang/Exception
    //   120	128	382	java/lang/Exception
    //   132	156	382	java/lang/Exception
    //   160	174	382	java/lang/Exception
    //   174	215	382	java/lang/Exception
    //   221	238	382	java/lang/Exception
    //   244	262	382	java/lang/Exception
    //   358	366	382	java/lang/Exception
    //   369	374	382	java/lang/Exception
  }
  
  public final void icy()
  {
    AppMethodBeat.i(293093);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP < 2)
    {
      Log.e("MicroMsg.CommonCaptureRenderer", s.X("ExchangeCapture...gCameraNum= ", Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP)));
      AppMethodBeat.o(293093);
      return;
    }
    Log.i("MicroMsg.CommonCaptureRenderer", s.X("ExchangeCapture start, gCameraNum= ", Integer.valueOf(com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP)));
    Object localObject = this.UOT;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.a.f)localObject).bsC();
    }
    SubCoreVoip.hVp().aqt(this.UOA);
    this.nGD = true;
    localObject = this.LpV;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.video.camera.a.c)localObject).Jd(this.nHi);
    }
    AppMethodBeat.o(293093);
  }
  
  public final int icz()
  {
    boolean bool = true;
    AppMethodBeat.i(293082);
    int k;
    int i;
    int j;
    if (icu())
    {
      k = com.tencent.mm.plugin.voip.video.camera.a.d.UOl;
      i = k;
      if (!af.lXY.lSW) {
        break label151;
      }
      i = k;
      if (af.lXY.lSV.hYK == 0) {
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
        this.UOv = bool;
        if (!this.UOv) {
          break label134;
        }
      }
      label134:
      for (i = OpenGlRender.FLAG_Angle270;; i = OpenGlRender.FLAG_Angle90)
      {
        if (i != OpenGlRender.FLAG_Angle270) {
          break label141;
        }
        AppMethodBeat.o(293082);
        return 90;
        j = com.tencent.mm.plugin.voip.video.camera.a.d.UOm;
        i = j;
        if (!af.lXY.lSY) {
          break label151;
        }
        i = j;
        if (af.lXY.lSX.hYK == 0) {
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
      AppMethodBeat.o(293082);
      return 270;
      label151:
      j = 0;
    }
  }
  
  public final void onOrientationChange(int paramInt)
  {
    this.UOP = paramInt;
  }
  
  public final void unInit() {}
  
  public final void v(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(292996);
    s.u(paramSurfaceTexture, "surfaceTexture");
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(292996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.b.a
 * JD-Core Version:    0.7.0.1
 */