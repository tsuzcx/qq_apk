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
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MODE_CROP_CENTER", "", "MODE_CROP_TOP", "cropMode", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "drawSizePoint", "Landroid/graphics/Point;", "frameDataImageCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "initDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "initErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "mIsUseBackCamera", "", "mOpenFlash", "mPictureCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "mRecordStopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/recordvideo/config/AppCameraContainerProcess;", "recordTextureView", "Lcom/tencent/mm/plugin/api/recordView/MMSightCameraGLSurfaceView;", "renderToRBGBufferThread", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRBGBufferThread;", "rgbSizeLimit", "touchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener;", "windowManager", "Landroid/view/WindowManager;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomRatios", "", "getVideoSize", "initLogic", "", "para", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoPath", "", "displayScreenSize", "Landroid/util/Size;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "initView", "viewGroup", "Landroid/view/ViewGroup;", "view", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "isFrontCamera", "onFrameData", "data", "", "onPause", "onResume", "release", "resetVideoPara", "resetVideoPath", "path", "setFlashMode", "flashMode", "setForceZoomTargetRatio", "ratio", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", "listener", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "setInitDoneCallback", "setInitErrorCallback", "setPictureCallback", "openFlash", "setPreviewMode", "mode", "setRGBSizeLimit", "limit", "setRecordCallback", "stopCallback", "setRenderThreadFrameInfo", "setTouchListener", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "setUseBackCamera", "back", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class a
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final a HFY;
  static final String TAG = "MicroMsg.AppBrandCameraPluginLayout";
  CameraPreviewGLSurfaceView ALD;
  private final int HFP;
  private final int HFQ;
  com.tencent.mm.plugin.recordvideo.b.a HFR;
  com.tencent.mm.media.widget.camerarecordview.a HFS;
  MMSightRecordView.g HFT;
  private MMSightRecordView.h HFU;
  private MMSightRecordView.a HFV;
  boolean HFW;
  boolean HFX;
  private float laP;
  g nrH;
  private MMSightRecordView.d nrI;
  private MMSightRecordView.c nrJ;
  h nrM;
  private final Point nrN;
  private int nrr;
  private int nrs;
  MMSightCameraGLSurfaceView nrw;
  com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private WindowManager windowManager;
  
  static
  {
    AppMethodBeat.i(75110);
    HFY = new a((byte)0);
    TAG = "MicroMsg.AppBrandCameraPluginLayout";
    AppMethodBeat.o(75110);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(75109);
    this.HFQ = 1;
    this.nrs = this.HFP;
    this.HFW = true;
    this.nrN = new Point(0, 0);
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
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    AppMethodBeat.o(75106);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(75092);
    p.k(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75092);
      return;
      paramc = this.HFS;
      if (paramc == null) {
        p.iCn();
      }
      paramBundle = this.orientationEventListener;
      if (paramBundle == null) {
        p.iCn();
      }
      bool = paramBundle.isLandscape();
      paramBundle = this.orientationEventListener;
      if (paramBundle == null) {
        p.iCn();
      }
      if (!paramc.l(bool, paramBundle.getOrientation()))
      {
        paramc = this.nrI;
        if (paramc != null)
        {
          paramc.bRF();
          AppMethodBeat.o(75092);
          return;
        }
        AppMethodBeat.o(75092);
        return;
        paramc = this.HFS;
        if (paramc == null) {
          p.iCn();
        }
        if (!paramc.p((kotlin.g.a.b)new j(this)))
        {
          paramc = this.HFU;
          if (paramc != null) {
            paramc.ij(true);
          }
          paramc = this.HFS;
          if (paramc != null)
          {
            paramc.aYW();
            AppMethodBeat.o(75092);
            return;
          }
          AppMethodBeat.o(75092);
          return;
          if (paramBundle != null)
          {
            paramc = this.HFS;
            if (paramc == null) {
              p.iCn();
            }
            paramc.ut(paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
            AppMethodBeat.o(75092);
            return;
            if (paramBundle != null)
            {
              paramc = this.HFS;
              if (paramc == null) {
                p.iCn();
              }
              bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
              paramBundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
              paramc.k(bool, paramBundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
              AppMethodBeat.o(75092);
              return;
              if (paramBundle != null) {
                bool = paramBundle.getBoolean("PARAM_PREPARE_CAMERA_IGNORE_FLIP_CHECK_BOOLEAN", false);
              }
              paramc = this.HFS;
              if (paramc == null) {
                p.iCn();
              }
              paramc.fR(bool);
              bBH();
              AppMethodBeat.o(75092);
              return;
              if (paramBundle != null)
              {
                float f1 = paramBundle.getFloat("PARAM_POINT_X");
                float f2 = paramBundle.getFloat("PARAM_POINT_Y");
                paramc = this.HFS;
                if (paramc == null) {
                  p.iCn();
                }
                paramBundle = this.ALD;
                if (paramBundle == null) {
                  p.iCn();
                }
                int i = paramBundle.getWidth();
                paramBundle = this.ALD;
                if (paramBundle == null) {
                  p.iCn();
                }
                paramc.b(f1, f2, i, paramBundle.getHeight());
                AppMethodBeat.o(75092);
                return;
                paramc = this.HFS;
                if (paramc == null) {
                  p.iCn();
                }
                paramc.fT(this.HFX);
                paramc = this.HFS;
                if (paramc == null) {
                  p.iCn();
                }
                paramc.r((kotlin.g.a.b)new i(this));
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(219989);
    p.k(paramu, "plugin");
    p.k(paramu, "plugin");
    AppMethodBeat.o(219989);
  }
  
  public final boolean ar(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75107);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(75107);
      return false;
    }
    Object localObject;
    if (this.nrM != null)
    {
      int i = getScreenRotation();
      localObject = this.nrM;
      if (localObject != null) {
        ((h)localObject).D(paramArrayOfByte, i);
      }
    }
    if (this.HFV != null)
    {
      localObject = getPreviewSize();
      MMSightRecordView.a locala = this.HFV;
      if (locala != null) {
        locala.D(paramArrayOfByte, ((Point)localObject).x, ((Point)localObject).y);
      }
    }
    AppMethodBeat.o(75107);
    return true;
  }
  
  final void bBH()
  {
    AppMethodBeat.i(75091);
    Object localObject = getPreviewSize();
    this.nrN.y = this.nrr;
    this.nrN.x = (((Point)localObject).x * this.nrr / ((Point)localObject).y);
    int i;
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      i = this.nrN.y;
      this.nrN.y = this.nrN.x;
      this.nrN.x = i;
    }
    h localh = this.nrM;
    if (localh != null)
    {
      int j = ((Point)localObject).x;
      int k = ((Point)localObject).y;
      localObject = this.HFS;
      if (localObject != null) {}
      for (i = ((com.tencent.mm.media.widget.camerarecordview.a)localObject).aYY();; i = 0)
      {
        localh.k(j, k, i, this.nrN.x, this.nrN.y);
        AppMethodBeat.o(75091);
        return;
      }
    }
    AppMethodBeat.o(75091);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(75096);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.HFS;
    if (locala != null)
    {
      int i = locala.aYY();
      AppMethodBeat.o(75096);
      return i;
    }
    AppMethodBeat.o(75096);
    return 90;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(75098);
    Object localObject = new aa.f();
    ((aa.f)localObject).aaBC = null;
    com.tencent.mm.media.widget.camerarecordview.a locala = this.HFS;
    if (locala == null) {
      p.iCn();
    }
    locala.r((kotlin.g.a.b)new b(this, (aa.f)localObject));
    localObject = (Bitmap)((aa.f)localObject).aaBC;
    AppMethodBeat.o(75098);
    return localObject;
  }
  
  public final float getDisplayRatio()
  {
    return this.laP;
  }
  
  public final Point getDrawSizePoint()
  {
    return this.nrN;
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(75105);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.HFS;
    if (locala != null)
    {
      int i = locala.knu.getFlashMode();
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
    Object localObject = this.HFR;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getPreviewRenderer();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.j.a)localObject).ksu;; i = 0)
    {
      localObject = this.HFR;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getPreviewRenderer();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.j.a)localObject).ksv;
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
    Object localObject = this.HFS;
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
    Object localObject = this.HFS;
    if (localObject != null)
    {
      if (((com.tencent.mm.media.widget.camerarecordview.a)localObject).currentState == 0)
      {
        localObject = ((com.tencent.mm.media.widget.camerarecordview.a)localObject).knu.getSupportZoomRatios();
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
    Object localObject = this.HFR;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getRecordRenderer();
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.media.j.a)localObject).ksu;; i = 0)
    {
      localObject = this.HFR;
      int j = k;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.recordvideo.b.a)localObject).getRecordRenderer();
        j = k;
        if (localObject != null) {
          j = ((com.tencent.mm.media.j.a)localObject).ksv;
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
    Object localObject = this.HFS;
    if (localObject == null) {
      p.iCn();
    }
    ((com.tencent.mm.media.widget.camerarecordview.a)localObject).TL();
    localObject = this.orientationEventListener;
    if (localObject == null) {
      p.iCn();
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
      p.iCn();
    }
    ((com.tencent.mm.plugin.mmsight.model.d)localObject).enable();
    localObject = this.HFS;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).q((kotlin.g.a.b)new e(this));
    }
    localObject = this.HFS;
    if (localObject == null) {
      p.iCn();
    }
    com.tencent.mm.media.widget.camerarecordview.a.a((com.tencent.mm.media.widget.camerarecordview.a)localObject, this.HFW, null, (kotlin.g.a.b)new f(this), 2);
    AppMethodBeat.o(75093);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75095);
    super.release();
    Object localObject = this.ALD;
    if (localObject != null) {
      ((CameraPreviewGLSurfaceView)localObject).setOnTouchListener(null);
    }
    localObject = this.ALD;
    if (localObject != null) {
      ((CameraPreviewGLSurfaceView)localObject).release();
    }
    this.ALD = null;
    localObject = this.HFS;
    if (localObject != null) {
      ((com.tencent.mm.media.widget.camerarecordview.a)localObject).release();
    }
    this.HFS = null;
    localObject = this.orientationEventListener;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).a(null);
    }
    localObject = this.orientationEventListener;
    if (localObject != null) {
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).disable();
    }
    this.orientationEventListener = null;
    this.HFR = null;
    AppMethodBeat.o(75095);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    this.laP = paramFloat;
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(75104);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.HFS;
    if (locala != null)
    {
      locala.knu.setFlashMode(paramInt);
      AppMethodBeat.o(75104);
      return;
    }
    AppMethodBeat.o(75104);
  }
  
  public final void setForceZoomTargetRatio(float paramFloat)
  {
    AppMethodBeat.i(75100);
    com.tencent.mm.media.widget.camerarecordview.a locala = this.HFS;
    if (locala != null)
    {
      if (locala.currentState == 0) {
        locala.knu.setForceZoomTargetRatio(paramFloat);
      }
      AppMethodBeat.o(75100);
      return;
    }
    AppMethodBeat.o(75100);
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.HFV = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.nrJ = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.nrI = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    this.nrs = paramInt;
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    this.nrr = paramInt;
  }
  
  public final void setRecordCallback(MMSightRecordView.h paramh)
  {
    this.HFU = paramh;
  }
  
  public final void setTouchListener(g.a parama)
  {
    AppMethodBeat.i(75097);
    p.k(parama, "callback");
    this.nrH = new g();
    g localg = this.nrH;
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
    this.HFW = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    b(a parama, aa.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "enable", "com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$2$1"})
  static final class g
    implements MMSightCameraGLSurfaceView.c
  {
    g(MMSightCameraGLSurfaceView paramMMSightCameraGLSurfaceView, a parama) {}
    
    public final void enable()
    {
      AppMethodBeat.i(75086);
      Object localObject = a.c(this.HFZ);
      if (localObject != null) {
        ((h)localObject).b(this.HGc.getEglContext());
      }
      localObject = a.b(this.HFZ);
      if (localObject != null)
      {
        ((MMSightCameraGLSurfaceView)localObject).setOnEglEnableListener(null);
        AppMethodBeat.o(75086);
        return;
      }
      AppMethodBeat.o(75086);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout$setFrameBuffer$1", "Lcom/tencent/mm/plugin/api/recordView/YUVDateRenderToRGBBufferRenderer$DrawRGBABufferCallback;", "getBuffer", "Ljava/nio/ByteBuffer;", "onFrameDraw", "", "plugin-recordvideo_release"})
  public static final class h
    implements i.a
  {
    h(MMSightRecordView.f paramf, ByteBuffer paramByteBuffer) {}
    
    public final void bBI()
    {
      AppMethodBeat.i(75087);
      MMSightRecordView.f localf = this.HGd;
      if (localf != null)
      {
        localf.bRK();
        AppMethodBeat.o(75087);
        return;
      }
      AppMethodBeat.o(75087);
    }
    
    public final ByteBuffer getBuffer()
    {
      AppMethodBeat.i(75088);
      ByteBuffer localByteBuffer = this.HGe;
      if (localByteBuffer == null) {
        p.iCn();
      }
      AppMethodBeat.o(75088);
      return localByteBuffer;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.a
 * JD-Core Version:    0.7.0.1
 */