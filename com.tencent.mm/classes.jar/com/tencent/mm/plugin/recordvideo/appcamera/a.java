package com.tencent.mm.plugin.recordvideo.appcamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MODE_CROP_CENTER", "", "MODE_CROP_TOP", "cropMode", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "drawSizePoint", "Landroid/graphics/Point;", "frameDataImageCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "initDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "initErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "mIsUseBackCamera", "", "mOpenFlash", "mPictureCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "mRecordStopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "recordTextureView", "Lcom/tencent/mm/plugin/api/recordView/MMSightCameraGLSurfaceView;", "renderToRBGBufferThread", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRBGBufferThread;", "rgbSizeLimit", "touchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener;", "windowManager", "Landroid/view/WindowManager;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomRatios", "", "getVideoSize", "initLogic", "", "para", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoPath", "", "displayScreenSize", "Landroid/util/Size;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "initView", "viewGroup", "Landroid/view/ViewGroup;", "view", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "isFrontCamera", "onFrameData", "data", "", "onPause", "onResume", "release", "resetVideoPara", "resetVideoPath", "path", "setFlashMode", "flashMode", "setForceZoomTargetRatio", "ratio", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", "listener", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "setInitDoneCallback", "setInitErrorCallback", "setPictureCallback", "openFlash", "setPreviewMode", "mode", "setRGBSizeLimit", "limit", "setRecordCallback", "stopCallback", "setRenderThreadFrameInfo", "setTouchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "setUseBackCamera", "back", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class a
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final a.a BJO;
  static final String TAG = "MicroMsg.AppBrandCameraPluginLayout";
  private final int BJF;
  private final int BJG;
  com.tencent.mm.plugin.recordvideo.b.a BJH;
  com.tencent.mm.media.widget.camerarecordview.a BJI;
  MMSightRecordView.g BJJ;
  private MMSightRecordView.h BJK;
  private MMSightRecordView.a BJL;
  boolean BJM;
  boolean BJN;
  private float ilP;
  g kyH;
  private MMSightRecordView.d kyI;
  private MMSightRecordView.c kyJ;
  h kyM;
  private final Point kyN;
  private int kyr;
  private int kys;
  MMSightCameraGLSurfaceView kyw;
  com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  CameraPreviewGLSurfaceView wcV;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(75110);
    BJO = new a.a((byte)0);
    TAG = "MicroMsg.AppBrandCameraPluginLayout";
    AppMethodBeat.o(75110);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(75109);
    this.BJG = 1;
    this.kys = this.BJF;
    this.BJM = true;
    this.kyN = new Point(0, 0);
    AppMethodBeat.o(75109);
  }
  
  private final int getScreenRotation()
  {
    AppMethodBeat.i(75108);
    if (this.windowManager == null)
    {
      localObject = MMApplicationContext.getContext().getSystemService("window");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.WindowManager");
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
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75092);
      return;
      paramc = this.BJI;
      if (paramc == null) {
        p.hyc();
      }
      paramBundle = this.orientationEventListener;
      if (paramBundle == null) {
        p.hyc();
      }
      bool = paramBundle.isLandscape();
      paramBundle = this.orientationEventListener;
      if (paramBundle == null) {
        p.hyc();
      }
      if (!paramc.j(bool, paramBundle.getOrientation()))
      {
        paramc = this.kyI;
        if (paramc != null)
        {
          paramc.bFW();
          AppMethodBeat.o(75092);
          return;
        }
        AppMethodBeat.o(75092);
        return;
        paramc = this.BJI;
        if (paramc == null) {
          p.hyc();
        }
        if (!paramc.p((kotlin.g.a.b)new j(this)))
        {
          paramc = this.BJK;
          if (paramc != null) {
            paramc.hs(true);
          }
          paramc = this.BJI;
          if (paramc != null)
          {
            paramc.aQf();
            AppMethodBeat.o(75092);
            return;
          }
          AppMethodBeat.o(75092);
          return;
          if (paramBundle != null)
          {
            paramc = this.BJI;
            if (paramc == null) {
              p.hyc();
            }
            paramc.rz(paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
            AppMethodBeat.o(75092);
            return;
            if (paramBundle != null)
            {
              paramc = this.BJI;
              if (paramc == null) {
                p.hyc();
              }
              bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
              paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
              paramc.i(bool, paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
              AppMethodBeat.o(75092);
              return;
              if (paramBundle != null) {
                bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_IGNORE_FLIP_CHECK_BOOLEAN", false);
              }
              paramc = this.BJI;
              if (paramc == null) {
                p.hyc();
              }
              paramc.fh(bool);
              bqS();
              AppMethodBeat.o(75092);
              return;
              if (paramBundle != null)
              {
                float f1 = paramBundle.getFloat("PARAM_POINT_X");
                float f2 = paramBundle.getFloat("PARAM_POINT_Y");
                paramc = this.BJI;
                if (paramc == null) {
                  p.hyc();
                }
                paramBundle = this.wcV;
                if (paramBundle == null) {
                  p.hyc();
                }
                int i = paramBundle.getWidth();
                paramBundle = this.wcV;
                if (paramBundle == null) {
                  p.hyc();
                }
                paramc.b(f1, f2, i, paramBundle.getHeight());
                AppMethodBeat.o(75092);
                return;
                paramc = this.BJI;
                if (paramc == null) {
                  p.hyc();
                }
                paramc.fj(this.BJN);
                paramc = this.BJI;
                if (paramc == null) {
                  p.hyc();
                }
                paramc.r((kotlin.g.a.b)new i(this));
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean ai(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75107);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(75107);
      return false;
    }
    Object localObject;
    if (this.kyM != null)
    {
      int i = getScreenRotation();
      localObject = this.kyM;
      if (localObject != null) {
        ((h)localObject).E(paramArrayOfByte, i);
      }
    }
    if (this.BJL != null)
    {
      localObject = getPreviewSize();
      MMSightRecordView.a locala = this.BJL;
      if (locala != null) {
        locala.C(paramArrayOfByte, ((Point)localObject).x, ((Point)localObject).y);
      }
    }
    AppMethodBeat.o(75107);
    return true;
  }
  
  final void bqS()
  {
    AppMethodBeat.i(75091);
    Object localObject = getPreviewSize();
    this.kyN.y = this.kyr;
    this.kyN.x = (((Point)localObject).x * this.kyr / ((Point)localObject).y);
    int i;
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      i = this.kyN.y;
      this.kyN.y = this.kyN.x;
      this.kyN.x = i;
    }
    h localh = this.kyM;
    if (localh != null)
    {
      int j = ((Point)localObject).x;
      int k = ((Point)localObject).y;
      localObject = this.BJI;
      if (localObject != null) {}
      for (i = ((com.tencent.mm.media.widget.camerarecordview.a)localObject).aQh();; i = 0)
      {
        localh.i(j, k, i, this.kyN.x, this.kyN.y);
        AppMethodBeat.o(75091);
        return;
      }
    }
    AppMethodBeat.o(75091);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(75096);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.BJI;
    if (locala != null)
    {
      int i = locala.aQh();
      AppMethodBeat.o(75096);
      return i;
    }
    AppMethodBeat.o(75096);
    return 90;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(75098);
    Object localObject = new z.f();
    ((z.f)localObject).SYG = null;
    com.tencent.mm.media.widget.camerarecordview.a locala = this.BJI;
    if (locala == null) {
      p.hyc();
    }
    locala.r((kotlin.g.a.b)new b(this, (z.f)localObject));
    localObject = (Bitmap)((z.f)localObject).SYG;
    AppMethodBeat.o(75098);
    return localObject;
  }
  
  public final float getDisplayRatio()
  {
    return this.ilP;
  }
  
  public final Point getDrawSizePoint()
  {
    return this.kyN;
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(75105);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.BJI;
    if (locala != null)
    {
      int i = locala.hAt.getFlashMode();
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
    Object localObject = this.BJH;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getPreviewRenderer();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.j.a)localObject).hEp;; i = 0)
    {
      localObject = this.BJH;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getPreviewRenderer();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.j.a)localObject).hEq;
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
    Object localObject = this.BJI;
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
    Object localObject = this.BJI;
    if (localObject != null)
    {
      if (((com.tencent.mm.media.widget.camerarecordview.a)localObject).currentState == 0)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.a)localObject).hAt.getSupportZoomRatios();
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
    Object localObject = this.BJH;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getRecordRenderer();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.j.a)localObject).hEp;; i = 0)
    {
      localObject = this.BJH;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getRecordRenderer();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.j.a)localObject).hEq;
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
    Log.i(TAG, "onPause");
    Object localObject = this.BJI;
    if (localObject == null) {
      p.hyc();
    }
    ((com.tencent.mm.media.widget.camerarecordview.a)localObject).stopPreview();
    localObject = this.orientationEventListener;
    if (localObject == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
    AppMethodBeat.o(75094);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(75093);
    super.onResume();
    Object localObject = this.orientationEventListener;
    if (localObject == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.mmsight.model.d)localObject).enable();
    localObject = this.BJI;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).q((kotlin.g.a.b)new e(this));
    }
    localObject = this.BJI;
    if (localObject == null) {
      p.hyc();
    }
    ((com.tencent.mm.media.widget.camerarecordview.a)localObject).a(this.BJM, (kotlin.g.a.b)new f(this));
    AppMethodBeat.o(75093);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75095);
    super.release();
    Object localObject = this.wcV;
    if (localObject != null) {
      ((CameraPreviewGLSurfaceView)localObject).setOnTouchListener(null);
    }
    localObject = this.wcV;
    if (localObject != null) {
      ((CameraPreviewGLSurfaceView)localObject).release();
    }
    this.wcV = null;
    localObject = this.BJI;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).release();
    }
    this.BJI = null;
    localObject = this.orientationEventListener;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
    }
    localObject = this.orientationEventListener;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
    }
    this.orientationEventListener = null;
    this.BJH = null;
    AppMethodBeat.o(75095);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    this.ilP = paramFloat;
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(75104);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.BJI;
    if (locala != null)
    {
      locala.hAt.setFlashMode(paramInt);
      AppMethodBeat.o(75104);
      return;
    }
    AppMethodBeat.o(75104);
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(75100);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.BJI;
    if (locala != null)
    {
      if (locala.currentState == 0) {
        locala.hAt.setForceZoomTargetRatio(paramFloat);
      }
      AppMethodBeat.o(75100);
      return;
    }
    AppMethodBeat.o(75100);
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.BJL = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.kyJ = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.kyI = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    this.kys = paramInt;
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    this.kyr = paramInt;
  }
  
  public final void setRecordCallback(MMSightRecordView.h paramh)
  {
    this.BJK = paramh;
  }
  
  public final void setTouchListener(g.a parama)
  {
    AppMethodBeat.i(75097);
    p.h(parama, "callback");
    this.kyH = new g();
    g localg = this.kyH;
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
    this.BJM = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    b(a parama, z.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "enable", "com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$2$1"})
  static final class g
    implements MMSightCameraGLSurfaceView.c
  {
    g(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView, a parama) {}
    
    public final void enable()
    {
      AppMethodBeat.i(75086);
      Object localObject = a.c(this.BJP);
      if (localObject != null) {
        ((h)localObject).b(this.BJS.getEglContext());
      }
      localObject = a.b(this.BJP);
      if (localObject != null)
      {
        ((MMSightCameraGLSurfaceView)localObject).setOnEglEnableListener(null);
        AppMethodBeat.o(75086);
        return;
      }
      AppMethodBeat.o(75086);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$1", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRGBBufferRenderer$DrawRGBABufferCallback;", "getBuffer", "Ljava/nio/ByteBuffer;", "onFrameDraw", "", "plugin-recordvideo_release"})
  public static final class h
    implements i.a
  {
    h(MMSightRecordView.f paramf, ByteBuffer paramByteBuffer) {}
    
    public final void bqT()
    {
      AppMethodBeat.i(75087);
      MMSightRecordView.f localf = this.BJT;
      if (localf != null)
      {
        localf.bGa();
        AppMethodBeat.o(75087);
        return;
      }
      AppMethodBeat.o(75087);
    }
    
    public final ByteBuffer getBuffer()
    {
      AppMethodBeat.i(75088);
      ByteBuffer localByteBuffer = this.BJU;
      if (localByteBuffer == null) {
        p.hyc();
      }
      AppMethodBeat.o(75088);
      return localByteBuffer;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, x>
  {
    j(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.a
 * JD-Core Version:    0.7.0.1
 */