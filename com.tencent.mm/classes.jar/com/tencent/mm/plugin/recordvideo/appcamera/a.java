package com.tencent.mm.plugin.recordvideo.appcamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.f;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.g;
import com.tencent.mm.plugin.api.recordView.g.a;
import com.tencent.mm.plugin.api.recordView.h;
import com.tencent.mm.plugin.api.recordView.i.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MODE_CROP_CENTER", "", "MODE_CROP_TOP", "cropMode", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "drawSizePoint", "Landroid/graphics/Point;", "frameDataImageCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "initDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "initErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "mIsUseBackCamera", "", "mOpenFlash", "mPictureCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "mRecordStopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "recordTextureView", "Lcom/tencent/mm/plugin/api/recordView/MMSightCameraGLSurfaceView;", "renderToRBGBufferThread", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRBGBufferThread;", "rgbSizeLimit", "touchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener;", "windowManager", "Landroid/view/WindowManager;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomRatios", "", "getVideoSize", "initLogic", "", "para", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoPath", "", "displayScreenSize", "Landroid/util/Size;", "initView", "viewGroup", "Landroid/view/ViewGroup;", "view", "surface", "Landroid/view/Surface;", "width", "height", "isFrontCamera", "onFrameData", "data", "", "onPause", "onResume", "release", "resetVideoPara", "resetVideoPath", "path", "setFlashMode", "flashMode", "setForceZoomTargetRatio", "ratio", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", "listener", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "setInitDoneCallback", "setInitErrorCallback", "setPictureCallback", "openFlash", "setPreviewMode", "mode", "setRGBSizeLimit", "limit", "setRecordCallback", "stopCallback", "setRenderThreadFrameInfo", "setTouchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "setUseBackCamera", "back", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.a
{
  public static final a.a NDs;
  static final String TAG;
  CameraPreviewGLSurfaceView GoC;
  boolean NDA;
  boolean NDB;
  private final int NDt;
  private final int NDu;
  com.tencent.mm.plugin.recordvideo.c.a NDv;
  com.tencent.mm.media.widget.camerarecordview.a NDw;
  MMSightRecordView.g NDx;
  private MMSightRecordView.h NDy;
  private MMSightRecordView.a NDz;
  private float nFU;
  d orientationEventListener;
  private int qpY;
  private int qpZ;
  MMSightCameraGLSurfaceView qqd;
  g qqo;
  private MMSightRecordView.d qqp;
  private MMSightRecordView.c qqq;
  private h qqt;
  private final Point qqu;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(75110);
    NDs = new a.a((byte)0);
    TAG = "MicroMsg.AppBrandCameraPluginLayout";
    AppMethodBeat.o(75110);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(75109);
    this.NDu = 1;
    this.qpZ = this.NDt;
    this.NDA = true;
    this.qqu = new Point(0, 0);
    AppMethodBeat.o(75109);
  }
  
  private static final void a(a parama, MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView)
  {
    AppMethodBeat.i(281199);
    s.u(parama, "this$0");
    s.u(paramMMSightCameraGLSurfaceView, "$this_apply");
    h localh = parama.qqt;
    if (localh != null) {
      localh.c(paramMMSightCameraGLSurfaceView.getEglContext());
    }
    parama = parama.qqd;
    if (parama != null) {
      parama.setOnEglEnableListener(null);
    }
    AppMethodBeat.o(281199);
  }
  
  private final void cbb()
  {
    AppMethodBeat.i(75091);
    Object localObject = getPreviewSize();
    this.qqu.y = this.qpY;
    this.qqu.x = (((Point)localObject).x * this.qpY / ((Point)localObject).y);
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      i = this.qqu.y;
      this.qqu.y = this.qqu.x;
      this.qqu.x = i;
    }
    h localh = this.qqt;
    int j;
    int k;
    if (localh != null)
    {
      j = ((Point)localObject).x;
      k = ((Point)localObject).y;
      localObject = this.NDw;
      if (localObject != null) {
        break label158;
      }
    }
    label158:
    for (int i = 0;; i = ((com.tencent.mm.media.widget.camerarecordview.a)localObject).btX())
    {
      localh.l(j, k, i, this.qqu.x, this.qqu.y);
      AppMethodBeat.o(75091);
      return;
    }
  }
  
  private final int getScreenRotation()
  {
    AppMethodBeat.i(75108);
    if (this.windowManager == null)
    {
      localObject = MMApplicationContext.getContext().getSystemService("window");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(75108);
        throw ((Throwable)localObject);
      }
      this.windowManager = ((WindowManager)localObject);
    }
    if (this.windowManager == null)
    {
      AppMethodBeat.o(75108);
      return 0;
    }
    Object localObject = this.windowManager;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label120;
      }
      localObject = null;
      label86:
      if (localObject != null) {
        break label131;
      }
      label90:
      if (localObject != null) {
        break label141;
      }
      label94:
      if (localObject != null) {
        break label158;
      }
      label98:
      if (localObject != null) {
        break label176;
      }
    }
    label120:
    while (((Integer)localObject).intValue() != 3)
    {
      do
      {
        AppMethodBeat.o(75108);
        return 0;
        localObject = ((WindowManager)localObject).getDefaultDisplay();
        break;
        localObject = Integer.valueOf(((Display)localObject).getRotation());
        break label86;
      } while (((Integer)localObject).intValue() == 0);
      break label90;
      if (((Integer)localObject).intValue() != 1) {
        break label94;
      }
      AppMethodBeat.o(75108);
      return 90;
      if (((Integer)localObject).intValue() != 2) {
        break label98;
      }
      AppMethodBeat.o(75108);
      return 180;
    }
    label131:
    label141:
    label158:
    label176:
    AppMethodBeat.o(75108);
    return 270;
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(75092);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75092);
      return;
      if (paramBundle == null) {}
      for (bool = true;; bool = paramBundle.getBoolean("PARAM_RECORD_RESULT_MIRROR_BOOLEAN", true))
      {
        paramc = this.NDw;
        if (paramc != null) {
          paramc.nJw = bool;
        }
        paramc = this.NDw;
        s.checkNotNull(paramc);
        paramBundle = this.orientationEventListener;
        s.checkNotNull(paramBundle);
        bool = paramBundle.isLandscape();
        paramBundle = this.orientationEventListener;
        s.checkNotNull(paramBundle);
        if (paramc.i(bool, paramBundle.getOrientation())) {
          break;
        }
        paramc = this.qqp;
        if (paramc == null) {
          break;
        }
        paramc.crK();
        AppMethodBeat.o(75092);
        return;
      }
      paramc = this.NDw;
      s.checkNotNull(paramc);
      if (!paramc.J((kotlin.g.a.b)new j(this)))
      {
        paramc = this.NDy;
        if (paramc != null) {
          paramc.jn(true);
        }
        paramc = this.NDw;
        if (paramc != null)
        {
          paramc.btV();
          AppMethodBeat.o(75092);
          return;
          if (paramBundle != null)
          {
            paramc = this.NDw;
            s.checkNotNull(paramc);
            paramc.ut(paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
            AppMethodBeat.o(75092);
            return;
            if (paramBundle != null)
            {
              paramc = this.NDw;
              s.checkNotNull(paramc);
              bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
              paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
              paramc.h(bool, paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
              AppMethodBeat.o(75092);
              return;
              if (paramBundle != null) {
                bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_IGNORE_FLIP_CHECK_BOOLEAN", false);
              }
              paramc = this.NDw;
              s.checkNotNull(paramc);
              paramc.gF(bool);
              cbb();
              AppMethodBeat.o(75092);
              return;
              if (paramBundle != null)
              {
                float f1 = paramBundle.getFloat("PARAM_POINT_X");
                float f2 = paramBundle.getFloat("PARAM_POINT_Y");
                paramc = this.NDw;
                s.checkNotNull(paramc);
                paramBundle = this.GoC;
                s.checkNotNull(paramBundle);
                int i = paramBundle.getWidth();
                paramBundle = this.GoC;
                s.checkNotNull(paramBundle);
                paramc.b(f1, f2, i, paramBundle.getHeight());
                AppMethodBeat.o(75092);
                return;
                paramc = this.NDw;
                s.checkNotNull(paramc);
                paramc.gH(this.NDB);
                paramc = this.NDw;
                s.checkNotNull(paramc);
                paramc.L((kotlin.g.a.b)new i(this));
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(281461);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this, paramv);
    AppMethodBeat.o(281461);
  }
  
  public final void a(final ByteBuffer paramByteBuffer, MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(281455);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.qqt != null)
      {
        paramByteBuffer = this.qqt;
        if (paramByteBuffer != null) {
          paramByteBuffer.release();
        }
        this.qqt = null;
        paramByteBuffer = this.qqd;
        if (paramByteBuffer != null) {
          paramByteBuffer.setVisibility(8);
        }
      }
      AppMethodBeat.o(281455);
      return;
    }
    if (this.qqt == null)
    {
      this.qqt = new h();
      cbb();
      h localh = this.qqt;
      if (localh != null) {
        localh.qqG = ((i.a)new h(paramf, paramByteBuffer));
      }
      paramByteBuffer = this.NDw;
      if (paramByteBuffer != null) {
        break label184;
      }
      paramByteBuffer = null;
      s.checkNotNull(paramByteBuffer);
      if (paramByteBuffer.booleanValue())
      {
        paramByteBuffer = this.qqd;
        if (paramByteBuffer != null)
        {
          if (paramByteBuffer.getEglContext() == null) {
            break label200;
          }
          paramf = this.qqt;
          if (paramf != null) {
            paramf.c(paramByteBuffer.getEglContext());
          }
        }
      }
    }
    for (;;)
    {
      paramByteBuffer = this.qqd;
      if (paramByteBuffer != null) {
        paramByteBuffer.setVisibility(0);
      }
      AppMethodBeat.o(281455);
      return;
      label184:
      paramByteBuffer = Boolean.valueOf(paramByteBuffer.mRu.bsD());
      break;
      label200:
      paramf = this.qqd;
      if (paramf != null) {
        paramf.setOnEglEnableListener(new a..ExternalSyntheticLambda0(this, paramByteBuffer));
      }
    }
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(75096);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.NDw;
    if (locala == null)
    {
      AppMethodBeat.o(75096);
      return 90;
    }
    int i = locala.btX();
    AppMethodBeat.o(75096);
    return i;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(75098);
    Object localObject = new ah.f();
    com.tencent.mm.media.widget.camerarecordview.a locala = this.NDw;
    s.checkNotNull(locala);
    locala.L((kotlin.g.a.b)new c(this, (ah.f)localObject));
    localObject = (Bitmap)((ah.f)localObject).aqH;
    AppMethodBeat.o(75098);
    return localObject;
  }
  
  public final float getDisplayRatio()
  {
    return this.nFU;
  }
  
  public final Point getDrawSizePoint()
  {
    return this.qqu;
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(75105);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.NDw;
    if (locala == null)
    {
      AppMethodBeat.o(75105);
      return 0;
    }
    int i = locala.mRu.getFlashMode();
    AppMethodBeat.o(75105);
    return i;
  }
  
  public final Point getPictureSize()
  {
    int j = 0;
    AppMethodBeat.i(75101);
    Object localObject = this.NDv;
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = this.NDv;
      if (localObject != null) {
        break label68;
      }
    }
    for (;;)
    {
      localObject = new Point(i, j);
      AppMethodBeat.o(75101);
      return localObject;
      localObject = ((com.tencent.mm.plugin.recordvideo.c.a)localObject).getPreviewRenderer();
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((com.tencent.mm.media.j.a)localObject).mWn;
      break;
      label68:
      localObject = ((com.tencent.mm.plugin.recordvideo.c.a)localObject).getPreviewRenderer();
      if (localObject != null) {
        j = ((com.tencent.mm.media.j.a)localObject).mWo;
      }
    }
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(75103);
    Object localObject = this.NDw;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = com.tencent.mm.media.widget.camerarecordview.a.c((com.tencent.mm.media.widget.camerarecordview.a)localObject))
    {
      localObject = new Point();
      AppMethodBeat.o(75103);
      return localObject;
    }
    AppMethodBeat.o(75103);
    return localObject;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(75099);
    Object localObject = this.NDw;
    if ((localObject != null) && (((com.tencent.mm.media.widget.camerarecordview.a)localObject).currentState == 0))
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.a)localObject).mRu.getSupportZoomRatios();
      AppMethodBeat.o(75099);
      return localObject;
    }
    AppMethodBeat.o(75099);
    return null;
  }
  
  public final Point getVideoSize()
  {
    int j = 0;
    AppMethodBeat.i(75102);
    Object localObject = this.NDv;
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = this.NDv;
      if (localObject != null) {
        break label68;
      }
    }
    for (;;)
    {
      localObject = new Point(i, j);
      AppMethodBeat.o(75102);
      return localObject;
      localObject = ((com.tencent.mm.plugin.recordvideo.c.a)localObject).getRecordRenderer();
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((com.tencent.mm.media.j.a)localObject).mWn;
      break;
      label68:
      localObject = ((com.tencent.mm.plugin.recordvideo.c.a)localObject).getRecordRenderer();
      if (localObject != null) {
        j = ((com.tencent.mm.media.j.a)localObject).mWo;
      }
    }
  }
  
  public final boolean onFrameData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75107);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(75107);
      return false;
    }
    Object localObject;
    if (this.qqt != null)
    {
      int i = getScreenRotation();
      localObject = this.qqt;
      if (localObject != null) {
        ((h)localObject).C(paramArrayOfByte, i);
      }
    }
    if (this.NDz != null)
    {
      localObject = getPreviewSize();
      MMSightRecordView.a locala = this.NDz;
      if (locala != null) {
        locala.B(paramArrayOfByte, ((Point)localObject).x, ((Point)localObject).y);
      }
    }
    AppMethodBeat.o(75107);
    return true;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(75094);
    super.onPause();
    Log.i(TAG, "onPause");
    Object localObject = this.NDw;
    s.checkNotNull(localObject);
    ((com.tencent.mm.media.widget.camerarecordview.a)localObject).auq();
    localObject = this.orientationEventListener;
    s.checkNotNull(localObject);
    ((d)localObject).disable();
    AppMethodBeat.o(75094);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75093);
    super.onResume();
    Object localObject = this.orientationEventListener;
    s.checkNotNull(localObject);
    ((d)localObject).enable();
    localObject = this.NDw;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).K((kotlin.g.a.b)new f(this));
    }
    localObject = this.NDw;
    s.checkNotNull(localObject);
    com.tencent.mm.media.widget.camerarecordview.a.a((com.tencent.mm.media.widget.camerarecordview.a)localObject, this.NDA, null, (kotlin.g.a.b)new g(this), 2);
    AppMethodBeat.o(75093);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75095);
    super.release();
    Object localObject = this.GoC;
    if (localObject != null) {
      ((CameraPreviewGLSurfaceView)localObject).setOnTouchListener(null);
    }
    localObject = this.GoC;
    if (localObject != null) {
      ((CameraPreviewGLSurfaceView)localObject).release();
    }
    this.GoC = null;
    localObject = this.NDw;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).release();
    }
    this.NDw = null;
    localObject = this.orientationEventListener;
    if (localObject != null) {
      ((d)localObject).KUU = null;
    }
    localObject = this.orientationEventListener;
    if (localObject != null) {
      ((d)localObject).disable();
    }
    this.orientationEventListener = null;
    this.NDv = null;
    AppMethodBeat.o(75095);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    this.nFU = paramFloat;
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(75104);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.NDw;
    if (locala != null) {
      locala.mRu.setFlashMode(paramInt);
    }
    AppMethodBeat.o(75104);
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(75100);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.NDw;
    if ((locala != null) && (locala.currentState == 0)) {
      locala.mRu.setForceZoomTargetRatio(paramFloat);
    }
    AppMethodBeat.o(75100);
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.NDz = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.qqq = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.qqp = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    this.qpZ = paramInt;
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    this.qpY = paramInt;
  }
  
  public final void setRecordCallback(MMSightRecordView.h paramh)
  {
    this.NDy = paramh;
  }
  
  public final void setTouchListener(g.a parama)
  {
    AppMethodBeat.i(75097);
    s.u(parama, "callback");
    this.qqo = new g();
    g localg = this.qqo;
    if (localg != null) {
      localg.qqE = parama;
    }
    AppMethodBeat.o(75097);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    this.NDA = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    c(a parama, ah.f<Bitmap> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "data", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<byte[], ah>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    e(a parama)
    {
      super();
    }
    
    private static final void l(a parama)
    {
      AppMethodBeat.i(281157);
      s.u(parama, "this$0");
      Object localObject;
      if (a.c(parama) != null)
      {
        h localh = a.c(parama);
        if (localh != null)
        {
          localObject = a.b(parama);
          if (localObject == null)
          {
            localObject = null;
            localh.c((EGLContext)localObject);
          }
        }
        else
        {
          localObject = a.b(parama);
          if (localObject != null) {
            ((MMSightCameraGLSurfaceView)localObject).setVisibility(0);
          }
        }
      }
      for (;;)
      {
        parama = a.b(parama);
        if (parama != null) {
          parama.setOnEglEnableListener(null);
        }
        AppMethodBeat.o(281157);
        return;
        localObject = ((MMSightCameraGLSurfaceView)localObject).getEglContext();
        break;
        localObject = a.b(parama);
        if (localObject != null) {
          ((MMSightCameraGLSurfaceView)localObject).setVisibility(8);
        }
      }
    }
    
    private static final void m(a parama)
    {
      AppMethodBeat.i(281159);
      s.u(parama, "this$0");
      parama = a.e(parama);
      if (parama != null) {
        parama.crL();
      }
      AppMethodBeat.o(281159);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "data", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<byte[], ah>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$1", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRGBBufferRenderer$DrawRGBABufferCallback;", "getBuffer", "Ljava/nio/ByteBuffer;", "onFrameDraw", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements i.a
  {
    h(MMSightRecordView.f paramf, ByteBuffer paramByteBuffer) {}
    
    public final void cbc()
    {
      AppMethodBeat.i(75087);
      MMSightRecordView.f localf = this.NDE;
      if (localf != null) {
        localf.crP();
      }
      AppMethodBeat.o(75087);
    }
    
    public final ByteBuffer getBuffer()
    {
      AppMethodBeat.i(75088);
      ByteBuffer localByteBuffer = paramByteBuffer;
      s.checkNotNull(localByteBuffer);
      AppMethodBeat.o(75088);
      return localByteBuffer;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, ah>
  {
    j(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.a
 * JD-Core Version:    0.7.0.1
 */