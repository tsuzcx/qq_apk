package com.tencent.mm.plugin.recordvideo.appcamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.e;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView.c;
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
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MODE_CROP_CENTER", "", "MODE_CROP_TOP", "cropMode", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "drawSizePoint", "Landroid/graphics/Point;", "frameDataImageCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "initDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "initErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "mIsUseBackCamera", "", "mOpenFlash", "mPictureCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "mRecordStopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "recordTextureView", "Lcom/tencent/mm/plugin/api/recordView/MMSightCameraGLSurfaceView;", "renderToRBGBufferThread", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRBGBufferThread;", "rgbSizeLimit", "touchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener;", "windowManager", "Landroid/view/WindowManager;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomRatios", "", "getVideoSize", "initLogic", "", "para", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoPath", "", "displayScreenSize", "Landroid/util/Size;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "initView", "viewGroup", "Landroid/view/ViewGroup;", "view", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "isFrontCamera", "onFrameData", "data", "", "onPause", "onResume", "release", "resetVideoPara", "resetVideoPath", "path", "setFlashMode", "flashMode", "setForceZoomTargetRatio", "ratio", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", "listener", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "setInitDoneCallback", "setInitErrorCallback", "setPictureCallback", "openFlash", "setPreviewMode", "mode", "setRGBSizeLimit", "limit", "setRecordCallback", "stopCallback", "setRenderThreadFrameInfo", "setTouchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "setUseBackCamera", "back", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class a
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  static final String TAG = "MicroMsg.AppBrandCameraPluginLayout";
  public static final a.a xJK;
  com.tencent.mm.plugin.mmsight.model.d haJ;
  private float hrT;
  private int jxI;
  private int jxJ;
  MMSightCameraGLSurfaceView jxN;
  g jxY;
  private MMSightRecordView.d jxZ;
  private MMSightRecordView.c jya;
  h jyd;
  private final Point jye;
  CameraPreviewGLSurfaceView sYF;
  private WindowManager windowManager;
  private final int xJB;
  private final int xJC;
  com.tencent.mm.plugin.recordvideo.b.a xJD;
  com.tencent.mm.media.widget.camerarecordview.a xJE;
  MMSightRecordView.g xJF;
  private MMSightRecordView.h xJG;
  private MMSightRecordView.a xJH;
  boolean xJI;
  boolean xJJ;
  
  static
  {
    AppMethodBeat.i(75110);
    xJK = new a.a((byte)0);
    TAG = "MicroMsg.AppBrandCameraPluginLayout";
    AppMethodBeat.o(75110);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(75109);
    this.xJC = 1;
    this.jxJ = this.xJB;
    this.xJI = true;
    this.jye = new Point(0, 0);
    AppMethodBeat.o(75109);
  }
  
  private final int getScreenRotation()
  {
    AppMethodBeat.i(75108);
    if (this.windowManager == null)
    {
      localObject = ak.getContext().getSystemService("window");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
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
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if (localObject == null) {
        break label126;
      }
      localObject = Integer.valueOf(((Display)localObject).getRotation());
      label97:
      if (localObject != null) {
        break label131;
      }
      label101:
      if (localObject != null) {
        break label141;
      }
      label105:
      if (localObject != null) {
        break label158;
      }
      label109:
      if (localObject != null) {
        break label176;
      }
    }
    label126:
    while (((Integer)localObject).intValue() != 3)
    {
      do
      {
        AppMethodBeat.o(75108);
        return 0;
        localObject = null;
        break;
        localObject = null;
        break label97;
      } while (((Integer)localObject).intValue() == 0);
      break label101;
      if (((Integer)localObject).intValue() != 1) {
        break label105;
      }
      AppMethodBeat.o(75108);
      return 90;
      if (((Integer)localObject).intValue() != 2) {
        break label109;
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
  
  public final boolean U(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75107);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(75107);
      return false;
    }
    Object localObject;
    if (this.jyd != null)
    {
      int i = getScreenRotation();
      localObject = this.jyd;
      if (localObject != null) {
        ((h)localObject).C(paramArrayOfByte, i);
      }
    }
    if (this.xJH != null)
    {
      localObject = getPreviewSize();
      MMSightRecordView.a locala = this.xJH;
      if (locala != null) {
        locala.s(paramArrayOfByte, ((Point)localObject).x, ((Point)localObject).y);
      }
    }
    AppMethodBeat.o(75107);
    return true;
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75106);
    p.h(parama, "navigator");
    p.h(paramRecordConfigProvider, "configProvider");
    AppMethodBeat.o(75106);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(75092);
    p.h(paramc, "status");
    switch (b.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75092);
      return;
      paramc = this.xJE;
      if (paramc == null) {
        p.gkB();
      }
      paramBundle = this.haJ;
      if (paramBundle == null) {
        p.gkB();
      }
      bool = paramBundle.aoA();
      paramBundle = this.haJ;
      if (paramBundle == null) {
        p.gkB();
      }
      if (!paramc.k(bool, paramBundle.getOrientation()))
      {
        paramc = this.jxZ;
        if (paramc != null)
        {
          paramc.bkA();
          AppMethodBeat.o(75092);
          return;
        }
        AppMethodBeat.o(75092);
        return;
        paramc = this.xJE;
        if (paramc == null) {
          p.gkB();
        }
        if (!paramc.p((d.g.a.b)new j(this)))
        {
          paramc = this.xJG;
          if (paramc != null) {
            paramc.gu(true);
          }
          paramc = this.xJE;
          if (paramc != null)
          {
            paramc.axH();
            AppMethodBeat.o(75092);
            return;
          }
          AppMethodBeat.o(75092);
          return;
          if (paramBundle != null)
          {
            paramc = this.xJE;
            if (paramc == null) {
              p.gkB();
            }
            paramc.od(paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
            AppMethodBeat.o(75092);
            return;
            if (paramBundle != null)
            {
              paramc = this.xJE;
              if (paramc == null) {
                p.gkB();
              }
              bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
              paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
              paramc.j(bool, paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
              AppMethodBeat.o(75092);
              return;
              if (paramBundle != null) {
                bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_IGNORE_FLIP_CHECK_BOOLEAN", false);
              }
              paramc = this.xJE;
              if (paramc == null) {
                p.gkB();
              }
              paramc.er(bool);
              aVV();
              AppMethodBeat.o(75092);
              return;
              if (paramBundle != null)
              {
                float f1 = paramBundle.getFloat("PARAM_POINT_X");
                float f2 = paramBundle.getFloat("PARAM_POINT_Y");
                paramc = this.xJE;
                if (paramc == null) {
                  p.gkB();
                }
                paramBundle = this.sYF;
                if (paramBundle == null) {
                  p.gkB();
                }
                int i = paramBundle.getWidth();
                paramBundle = this.sYF;
                if (paramBundle == null) {
                  p.gkB();
                }
                paramc.b(f1, f2, i, paramBundle.getHeight());
                AppMethodBeat.o(75092);
                return;
                paramc = this.xJE;
                if (paramc == null) {
                  p.gkB();
                }
                paramc.et(this.xJJ);
                paramc = this.xJE;
                if (paramc == null) {
                  p.gkB();
                }
                paramc.r((d.g.a.b)new i(this));
              }
            }
          }
        }
      }
    }
  }
  
  final void aVV()
  {
    AppMethodBeat.i(75091);
    Object localObject = getPreviewSize();
    this.jye.y = this.jxI;
    this.jye.x = (((Point)localObject).x * this.jxI / ((Point)localObject).y);
    int i;
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      i = this.jye.y;
      this.jye.y = this.jye.x;
      this.jye.x = i;
    }
    h localh = this.jyd;
    if (localh != null)
    {
      int j = ((Point)localObject).x;
      int k = ((Point)localObject).y;
      localObject = this.xJE;
      if (localObject != null) {}
      for (i = ((com.tencent.mm.media.widget.camerarecordview.a)localObject).axJ();; i = 0)
      {
        localh.i(j, k, i, this.jye.x, this.jye.y);
        AppMethodBeat.o(75091);
        return;
      }
    }
    AppMethodBeat.o(75091);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(75096);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.xJE;
    if (locala != null)
    {
      int i = locala.axJ();
      AppMethodBeat.o(75096);
      return i;
    }
    AppMethodBeat.o(75096);
    return 90;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(75098);
    Object localObject = new y.f();
    ((y.f)localObject).NiY = null;
    com.tencent.mm.media.widget.camerarecordview.a locala = this.xJE;
    if (locala == null) {
      p.gkB();
    }
    locala.r((d.g.a.b)new b(this, (y.f)localObject));
    localObject = (Bitmap)((y.f)localObject).NiY;
    AppMethodBeat.o(75098);
    return localObject;
  }
  
  public final float getDisplayRatio()
  {
    return this.hrT;
  }
  
  public final Point getDrawSizePoint()
  {
    return this.jye;
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(75105);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.xJE;
    if (locala != null)
    {
      int i = locala.gKX.getFlashMode();
      AppMethodBeat.o(75105);
      return i;
    }
    AppMethodBeat.o(75105);
    return 0;
  }
  
  public final Point getPictureSize()
  {
    int k = 0;
    AppMethodBeat.i(75101);
    Object localObject = this.xJD;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getPreviewRenderer();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.j.a)localObject).gOm;; i = 0)
    {
      localObject = this.xJD;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getPreviewRenderer();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.j.a)localObject).gOn;
        }
      }
      localObject = new Point(i, j);
      AppMethodBeat.o(75101);
      return localObject;
    }
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(75103);
    Object localObject = this.xJE;
    if (localObject != null)
    {
      Point localPoint = com.tencent.mm.media.widget.camerarecordview.a.c((com.tencent.mm.media.widget.camerarecordview.a)localObject);
      localObject = localPoint;
      if (localPoint != null) {}
    }
    else
    {
      localObject = new Point();
    }
    AppMethodBeat.o(75103);
    return localObject;
  }
  
  public final float[] getSupportZoomRatios()
  {
    AppMethodBeat.i(75099);
    Object localObject = this.xJE;
    if (localObject != null)
    {
      if (((com.tencent.mm.media.widget.camerarecordview.a)localObject).currentState == 0)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.a)localObject).gKX.getSupportZoomRatios();
        AppMethodBeat.o(75099);
        return localObject;
      }
      AppMethodBeat.o(75099);
      return null;
    }
    AppMethodBeat.o(75099);
    return null;
  }
  
  public final Point getVideoSize()
  {
    int k = 0;
    AppMethodBeat.i(75102);
    Object localObject = this.xJD;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getRecordRenderer();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.j.a)localObject).gOm;; i = 0)
    {
      localObject = this.xJD;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getRecordRenderer();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.j.a)localObject).gOn;
        }
      }
      localObject = new Point(i, j);
      AppMethodBeat.o(75102);
      return localObject;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(75094);
    super.onPause();
    ae.i(TAG, "onPause");
    Object localObject = this.xJE;
    if (localObject == null) {
      p.gkB();
    }
    ((com.tencent.mm.media.widget.camerarecordview.a)localObject).stopPreview();
    localObject = this.haJ;
    if (localObject == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
    AppMethodBeat.o(75094);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75093);
    super.onResume();
    Object localObject = this.haJ;
    if (localObject == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.mmsight.model.d)localObject).enable();
    localObject = this.xJE;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).q((d.g.a.b)new e(this));
    }
    localObject = this.xJE;
    if (localObject == null) {
      p.gkB();
    }
    ((com.tencent.mm.media.widget.camerarecordview.a)localObject).a(this.xJI, (d.g.a.b)new f(this));
    AppMethodBeat.o(75093);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75095);
    super.release();
    Object localObject = this.sYF;
    if (localObject != null) {
      ((CameraPreviewGLSurfaceView)localObject).setOnTouchListener(null);
    }
    localObject = this.sYF;
    if (localObject != null) {
      ((CameraPreviewGLSurfaceView)localObject).release();
    }
    this.sYF = null;
    localObject = this.xJE;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).release();
    }
    this.xJE = null;
    localObject = this.haJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
    }
    localObject = this.haJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
    }
    this.haJ = null;
    this.xJD = null;
    AppMethodBeat.o(75095);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    this.hrT = paramFloat;
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(75104);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.xJE;
    if (locala != null)
    {
      locala.gKX.setFlashMode(paramInt);
      AppMethodBeat.o(75104);
      return;
    }
    AppMethodBeat.o(75104);
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(75100);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.xJE;
    if (locala != null)
    {
      if (locala.currentState == 0) {
        locala.gKX.setForceZoomTargetRatio(paramFloat);
      }
      AppMethodBeat.o(75100);
      return;
    }
    AppMethodBeat.o(75100);
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.xJH = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.jya = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.jxZ = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    this.jxJ = paramInt;
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    this.jxI = paramInt;
  }
  
  public final void setRecordCallback(MMSightRecordView.h paramh)
  {
    this.xJG = paramh;
  }
  
  public final void setTouchListener(g.a parama)
  {
    AppMethodBeat.i(75097);
    p.h(parama, "callback");
    this.jxY = new g();
    g localg = this.jxY;
    if (localg != null)
    {
      localg.a(parama);
      AppMethodBeat.o(75097);
      return;
    }
    AppMethodBeat.o(75097);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    this.xJI = paramBoolean;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Bitmap, z>
  {
    b(a parama, y.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.b
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<Boolean, z>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "enable", "com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$2$1"})
  static final class g
    implements MMSightCameraGLSurfaceView.c
  {
    g(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView, a parama) {}
    
    public final void enable()
    {
      AppMethodBeat.i(75086);
      Object localObject = a.c(this.xJL);
      if (localObject != null) {
        ((h)localObject).b(this.xJO.getEglContext());
      }
      localObject = a.b(this.xJL);
      if (localObject != null)
      {
        ((MMSightCameraGLSurfaceView)localObject).setOnEglEnableListener(null);
        AppMethodBeat.o(75086);
        return;
      }
      AppMethodBeat.o(75086);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$1", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRGBBufferRenderer$DrawRGBABufferCallback;", "getBuffer", "Ljava/nio/ByteBuffer;", "onFrameDraw", "", "plugin-recordvideo_release"})
  public static final class h
    implements i.a
  {
    h(MMSightRecordView.f paramf, ByteBuffer paramByteBuffer) {}
    
    public final void aVW()
    {
      AppMethodBeat.i(75087);
      MMSightRecordView.f localf = this.xJP;
      if (localf != null)
      {
        localf.bkE();
        AppMethodBeat.o(75087);
        return;
      }
      AppMethodBeat.o(75087);
    }
    
    public final ByteBuffer getBuffer()
    {
      AppMethodBeat.i(75088);
      ByteBuffer localByteBuffer = this.xJQ;
      if (localByteBuffer == null) {
        p.gkB();
      }
      AppMethodBeat.o(75088);
      return localByteBuffer;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class i
    extends q
    implements d.g.a.b<Bitmap, z>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, z>
  {
    j(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.a
 * JD-Core Version:    0.7.0.1
 */