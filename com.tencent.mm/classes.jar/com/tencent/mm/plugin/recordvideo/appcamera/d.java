package com.tencent.mm.plugin.recordvideo.appcamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.e;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView.c;
import com.tencent.mm.plugin.api.recordView.g.a;
import com.tencent.mm.plugin.api.recordView.h;
import com.tencent.mm.plugin.api.recordView.i.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppRecordViewImpl;", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$MMSightRecordViewDelegate;", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightMediaRecorder$ErrorCallback;", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "()V", "cameraPluginLayout", "Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "displayRatio", "", "isDragZoomEnable", "", "isTouchFocusEnable", "lastPointerDistance", "lastTouchDownTime", "", "mDisplayScreenSize", "Landroid/util/Size;", "mZoomMultipleToRatio", "", "previewSizeLimit", "", "videoPath", "", "videoSizeRatio", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "Landroid/graphics/Point;", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomMultiple", "getVideoFilePath", "getVideoSize", "handlePluginTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "init", "context", "Landroid/content/Context;", "view", "Landroid/view/ViewGroup;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "initRecorder", "isClipPictureSize", "isClipVideoSize", "isEnableDragZoom", "isEnableTouchFocus", "isFrontCamera", "onDoubleClick", "onError", "errorCode", "onFrameData", "data", "", "onTouchDown", "x", "y", "onZoomIn", "onZoomOut", "pointerDistance", "event", "release", "set34PreviewVideoSize", "setClipPictureSize", "clip", "setClipVideoSize", "setDisplayRatio", "size", "setDisplayScreenSize", "screenSize", "setEnableDragZoom", "enable", "setEnableTouchFocus", "setFlashMode", "flashMode", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", "listener", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "setHalfPreviewVideoSize", "setInitDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "setInitErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "setPreviewMode", "mode", "setPreviewSizeLimit", "limit", "setRGBSizeLimit", "setUseBackCamera", "back", "setVideoFilePath", "filePath", "setVideoPara", "maxDuration", "videoBitrate", "fps", "audioBitrate", "audioSampleRate", "setZoomMultiple", "multiple", "startPreview", "startRecord", "stopRecord", "stopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "switchCamera", "takePicture", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "openFlash", "Companion", "plugin-recordvideo_release"})
public final class d
  extends MMSightRecordView.e
  implements g.a, com.tencent.mm.plugin.mmsight.model.a.d.a, g
{
  private static final int HGh = 400;
  private static final int HGi = 15;
  public static final a HGj;
  private static final String TAG = "MicroMsg.AppRecordViewImpl";
  private VideoTransPara EZB;
  private a HGf;
  private float[] HGg;
  private float laP;
  private boolean nrE = true;
  private boolean nrF = true;
  private float nrL = 1.0F;
  private long nrW = -1L;
  private float nrX = -1.0F;
  private int nrq;
  private Size oLL;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(75151);
    HGj = new a((byte)0);
    TAG = "MicroMsg.AppRecordViewImpl";
    HGh = 400;
    HGi = 15;
    AppMethodBeat.o(75151);
  }
  
  private static float y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(75148);
    try
    {
      float f3 = paramMotionEvent.getX(0);
      float f1 = paramMotionEvent.getY(0);
      float f4 = paramMotionEvent.getX(1);
      float f2 = paramMotionEvent.getY(1);
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      AppMethodBeat.o(75148);
      return f3 + f1;
    }
    catch (Exception paramMotionEvent)
    {
      Log.e(TAG, "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(75148);
    }
    return 0.0F;
  }
  
  public final void J(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75145);
    if (this.nrF)
    {
      Bundle localBundle = new Bundle();
      localBundle.putFloat("PARAM_POINT_X", paramFloat1);
      localBundle.putFloat("PARAM_POINT_Y", paramFloat2);
      a locala = this.HGf;
      if (locala != null)
      {
        locala.a(d.c.HRf, localBundle);
        AppMethodBeat.o(75145);
        return;
      }
    }
    AppMethodBeat.o(75145);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75114);
    p.k(paramContext, "context");
    p.k(paramViewGroup, "view");
    this.HGf = new a(paramContext);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    }
    a locala = this.HGf;
    if (locala != null)
    {
      p.k(paramContext, "context");
      p.k(paramViewGroup, "view");
      Log.i(a.TAG, "surface is %s", new Object[] { paramSurfaceTexture });
      if (paramSurfaceTexture == null) {
        p.iCn();
      }
      locala.ALD = ((CameraPreviewGLSurfaceView)new com.tencent.mm.media.widget.camerarecordview.b(paramContext, paramSurfaceTexture, paramInt1, paramInt2));
      locala.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(paramContext, (byte)0);
      paramSurfaceTexture = locala.orientationEventListener;
      if (paramSurfaceTexture == null) {
        p.iCn();
      }
      paramSurfaceTexture.enable();
      locala.nrw = new MMSightCameraGLSurfaceView(paramContext);
      paramContext = locala.nrw;
      if (paramContext != null) {
        paramContext.setBackgroundColor(Color.argb(0, 0, 0, 0));
      }
      paramContext = new ViewGroup.MarginLayoutParams(-1, -1);
      paramViewGroup.addView((View)locala.nrw, (ViewGroup.LayoutParams)paramContext);
    }
    this.EZB = new VideoTransPara();
    AppMethodBeat.o(75114);
  }
  
  public final void a(MMSightRecordView.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(75125);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.HFT = paramg;
      locala.HFX = paramBoolean;
    }
    paramg = this.HGf;
    if (paramg != null)
    {
      d.b.a(paramg, d.c.HRo);
      AppMethodBeat.o(75125);
      return;
    }
    AppMethodBeat.o(75125);
  }
  
  public final void a(MMSightRecordView.h paramh)
  {
    AppMethodBeat.i(75124);
    a locala = this.HGf;
    if (locala != null) {
      locala.setRecordCallback(paramh);
    }
    paramh = this.HGf;
    if (paramh != null)
    {
      d.b.a(paramh, d.c.HRh);
      AppMethodBeat.o(75124);
      return;
    }
    AppMethodBeat.o(75124);
  }
  
  public final void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(75142);
    a locala = this.HGf;
    if (locala != null)
    {
      if ((paramf == null) && (paramByteBuffer == null))
      {
        if (locala.nrM != null)
        {
          paramByteBuffer = locala.nrM;
          if (paramByteBuffer != null) {
            paramByteBuffer.release();
          }
          locala.nrM = null;
          paramByteBuffer = locala.nrw;
          if (paramByteBuffer != null)
          {
            paramByteBuffer.setVisibility(8);
            AppMethodBeat.o(75142);
            return;
          }
        }
        AppMethodBeat.o(75142);
        return;
      }
      if (locala.nrM == null)
      {
        locala.nrM = new h();
        locala.bBH();
        h localh = locala.nrM;
        if (localh != null) {
          localh.a((i.a)new a.h(paramf, paramByteBuffer));
        }
        paramByteBuffer = locala.HFS;
        if (paramByteBuffer != null)
        {
          paramByteBuffer = Boolean.valueOf(paramByteBuffer.knu.aXQ());
          if (paramByteBuffer == null) {
            p.iCn();
          }
          if (!paramByteBuffer.booleanValue()) {
            break label257;
          }
          paramByteBuffer = locala.nrw;
          if (paramByteBuffer == null) {
            break label257;
          }
          if (paramByteBuffer.getEglContext() == null) {
            break label222;
          }
          paramf = locala.nrM;
          if (paramf != null) {
            paramf.b(paramByteBuffer.getEglContext());
          }
        }
        for (;;)
        {
          paramByteBuffer = locala.nrw;
          if (paramByteBuffer == null) {
            break label250;
          }
          paramByteBuffer.setVisibility(0);
          AppMethodBeat.o(75142);
          return;
          paramByteBuffer = null;
          break;
          label222:
          paramf = locala.nrw;
          if (paramf != null) {
            paramf.setOnEglEnableListener((MMSightCameraGLSurfaceView.c)new a.g(paramByteBuffer, locala));
          }
        }
        label250:
        AppMethodBeat.o(75142);
        return;
      }
      label257:
      AppMethodBeat.o(75142);
      return;
    }
    AppMethodBeat.o(75142);
  }
  
  public final boolean aD(float paramFloat)
  {
    AppMethodBeat.i(75137);
    int i;
    if (this.HGg != null)
    {
      localObject = this.HGg;
      if ((localObject == null) || (localObject.length != 0))
      {
        localObject = this.HGg;
        if (localObject == null) {
          break label111;
        }
        p.k(localObject, "$this$indexOf");
        int j = localObject.length;
        i = 0;
        if (i >= j) {
          break label106;
        }
        if (paramFloat != localObject[i]) {
          break label99;
        }
      }
    }
    label69:
    label99:
    label106:
    label111:
    for (Object localObject = Integer.valueOf(i);; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      if (((Integer)localObject).intValue() >= 0) {
        break label117;
      }
      AppMethodBeat.o(75137);
      return false;
      i += 1;
      break;
      i = -1;
      break label69;
    }
    label117:
    localObject = this.HGf;
    if (localObject != null) {
      ((a)localObject).setForceZoomTargetRatio(paramFloat);
    }
    AppMethodBeat.o(75137);
    return true;
  }
  
  public final boolean aeU()
  {
    AppMethodBeat.i(75123);
    a locala = this.HGf;
    if (locala != null) {
      d.b.a(locala, d.c.HRg);
    }
    AppMethodBeat.o(75123);
    return true;
  }
  
  public final boolean ar(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75143);
    a locala = this.HGf;
    if (locala != null)
    {
      boolean bool = locala.ar(paramArrayOfByte);
      AppMethodBeat.o(75143);
      return bool;
    }
    AppMethodBeat.o(75143);
    return false;
  }
  
  public final void ave()
  {
    AppMethodBeat.i(75120);
    if ((this.laP > 0.0F) && (this.nrq > 0))
    {
      localObject1 = this.EZB;
      if (localObject1 != null) {
        ((VideoTransPara)localObject1).width = this.nrq;
      }
      localObject1 = this.EZB;
      if (localObject1 != null) {
        ((VideoTransPara)localObject1).height = ((int)(this.nrq / this.laP));
      }
    }
    Object localObject1 = this.HGf;
    if (localObject1 != null)
    {
      Object localObject3 = this.EZB;
      if (localObject3 == null) {
        p.iCn();
      }
      Object localObject4 = this.videoPath;
      if (localObject4 == null) {
        p.iCn();
      }
      Object localObject2 = this.oLL;
      p.k(localObject3, "para");
      p.k(localObject4, "videoPath");
      CameraPreviewGLSurfaceView localCameraPreviewGLSurfaceView = ((a)localObject1).ALD;
      if (localCameraPreviewGLSurfaceView == null) {
        p.iCn();
      }
      ((a)localObject1).HFR = new com.tencent.mm.plugin.recordvideo.b.a((VideoTransPara)localObject3, localCameraPreviewGLSurfaceView, (String)localObject4);
      localObject3 = ((a)localObject1).HFR;
      if (localObject3 == null) {
        p.iCn();
      }
      ((a)localObject1).HFS = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)localObject3);
      localObject3 = ((a)localObject1).HFS;
      if ((localObject3 != null) && (true != ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).leI))
      {
        ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).leI = true;
        if (!((com.tencent.mm.media.widget.camerarecordview.a)localObject3).leI)
        {
          localObject4 = ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).leG;
          if ((((com.tencent.mm.media.widget.camerarecordview.a)localObject3).ley) || (!((com.tencent.mm.media.widget.camerarecordview.a)localObject3).leM.aZp())) {
            break label348;
          }
        }
      }
      label348:
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject4).a(bool, ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).knu.aYf());
        localObject3 = ((a)localObject1).HFS;
        if (localObject3 != null) {
          ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).knu.setDisplayScreenSize((Size)localObject2);
        }
        localObject2 = ((a)localObject1).HFS;
        if (localObject2 != null) {
          ((com.tencent.mm.media.widget.camerarecordview.a)localObject2).q((kotlin.g.a.b)new a.c((a)localObject1));
        }
        localObject2 = ((a)localObject1).HFS;
        if (localObject2 == null) {
          p.iCn();
        }
        com.tencent.mm.media.widget.camerarecordview.a.a((com.tencent.mm.media.widget.camerarecordview.a)localObject2, ((a)localObject1).HFW, null, (kotlin.g.a.b)new a.d((a)localObject1), 2);
        AppMethodBeat.o(75120);
        return;
      }
    }
    AppMethodBeat.o(75120);
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75113);
    p.k(paramContext, "context");
    p.k(paramViewGroup, "view");
    this.HGf = new a(paramContext);
    a locala = this.HGf;
    if (locala != null) {
      locala.setTouchListener((g.a)this);
    }
    locala = this.HGf;
    if (locala != null)
    {
      p.k(paramContext, "context");
      p.k(paramViewGroup, "viewGroup");
      Object localObject = new ViewGroup.MarginLayoutParams(-1, -1);
      locala.ALD = new CameraPreviewGLSurfaceView(paramContext, null);
      CameraPreviewGLSurfaceView localCameraPreviewGLSurfaceView = locala.ALD;
      if (localCameraPreviewGLSurfaceView != null) {
        localCameraPreviewGLSurfaceView.setOnTouchListener((View.OnTouchListener)locala.nrH);
      }
      paramViewGroup.addView((View)locala.ALD, (ViewGroup.LayoutParams)localObject);
      locala.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(paramContext, (byte)0);
      localObject = locala.orientationEventListener;
      if (localObject == null) {
        p.iCn();
      }
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).enable();
      locala.nrw = new MMSightCameraGLSurfaceView(paramContext);
      paramContext = locala.nrw;
      if (paramContext != null) {
        paramContext.setBackgroundColor(Color.argb(0, 0, 0, 0));
      }
      paramContext = new ViewGroup.MarginLayoutParams(1, 1);
      paramViewGroup.addView((View)locala.nrw, (ViewGroup.LayoutParams)paramContext);
    }
    this.EZB = new VideoTransPara();
    AppMethodBeat.o(75113);
  }
  
  public final void bBC()
  {
    AppMethodBeat.i(75138);
    Log.i(TAG, "setHalfPreviewVideoSize");
    this.nrL = 0.5F;
    AppMethodBeat.o(75138);
  }
  
  public final void bBD()
  {
    AppMethodBeat.i(75139);
    Log.i(TAG, "set34PreviewVideoSize");
    this.nrL = 0.75F;
    AppMethodBeat.o(75139);
  }
  
  public final void bBE()
  {
    AppMethodBeat.i(75144);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.reset();
      AppMethodBeat.o(75144);
      return;
    }
    AppMethodBeat.o(75144);
  }
  
  public final void bBF()
  {
    AppMethodBeat.i(75146);
    if (this.nrE)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
      a locala = this.HGf;
      if (locala != null)
      {
        locala.a(d.c.HRd, localBundle);
        AppMethodBeat.o(75146);
        return;
      }
    }
    AppMethodBeat.o(75146);
  }
  
  public final void bBG()
  {
    AppMethodBeat.i(75147);
    if (this.nrE)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
      a locala = this.HGf;
      if (locala != null)
      {
        locala.a(d.c.HRd, localBundle);
        AppMethodBeat.o(75147);
        return;
      }
    }
    AppMethodBeat.o(75147);
  }
  
  public final void bBx() {}
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(75132);
    if (this.HGf != null)
    {
      a locala = this.HGf;
      if (locala == null) {
        p.iCn();
      }
      int i = locala.getCameraRotation();
      AppMethodBeat.o(75132);
      return i;
    }
    AppMethodBeat.o(75132);
    return 0;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(75140);
    Object localObject = this.HGf;
    if (localObject != null)
    {
      localObject = ((a)localObject).getCurrentFramePicture();
      AppMethodBeat.o(75140);
      return localObject;
    }
    AppMethodBeat.o(75140);
    return null;
  }
  
  public final Point getDrawSizePoint()
  {
    AppMethodBeat.i(75130);
    Object localObject = this.HGf;
    if (localObject != null)
    {
      Point localPoint = ((a)localObject).getDrawSizePoint();
      localObject = localPoint;
      if (localPoint != null) {}
    }
    else
    {
      localObject = new Point();
    }
    AppMethodBeat.o(75130);
    return localObject;
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(75135);
    a locala = this.HGf;
    if (locala != null)
    {
      int i = locala.getFlashMode();
      AppMethodBeat.o(75135);
      return i;
    }
    AppMethodBeat.o(75135);
    return 0;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(75127);
    Object localObject = this.HGf;
    if (localObject != null)
    {
      Point localPoint = ((a)localObject).getPictureSize();
      localObject = localPoint;
      if (localPoint != null) {}
    }
    else
    {
      localObject = new Point();
    }
    AppMethodBeat.o(75127);
    return localObject;
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(75129);
    Object localObject = this.HGf;
    if (localObject != null)
    {
      Point localPoint = ((a)localObject).getPreviewSize();
      localObject = localPoint;
      if (localPoint != null) {}
    }
    else
    {
      localObject = new Point();
    }
    AppMethodBeat.o(75129);
    return localObject;
  }
  
  public final float[] getSupportZoomMultiple()
  {
    AppMethodBeat.i(75136);
    if ((this.HGg == null) && (this.HGf != null))
    {
      localObject = this.HGf;
      if (localObject == null) {
        p.iCn();
      }
      this.HGg = ((a)localObject).getSupportZoomRatios();
    }
    Object localObject = this.HGg;
    AppMethodBeat.o(75136);
    return localObject;
  }
  
  public final String getVideoFilePath()
  {
    String str2 = this.videoPath;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final Point getVideoSize()
  {
    AppMethodBeat.i(75128);
    Object localObject = this.HGf;
    if (localObject != null)
    {
      Point localPoint = ((a)localObject).getVideoSize();
      localObject = localPoint;
      if (localPoint != null) {}
    }
    else
    {
      localObject = new Point();
    }
    AppMethodBeat.o(75128);
    return localObject;
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(75149);
    Integer localInteger;
    if (paramMotionEvent != null)
    {
      localInteger = Integer.valueOf(paramMotionEvent.getAction());
      if (localInteger != null) {
        break label50;
      }
      label22:
      if (localInteger != null) {
        break label123;
      }
      label26:
      if (localInteger != null) {
        break label147;
      }
      label30:
      if (localInteger != null) {
        break label172;
      }
    }
    for (;;)
    {
      if (localInteger == null)
      {
        AppMethodBeat.o(75149);
        return;
        localInteger = null;
        break;
        label50:
        if (localInteger.intValue() != 0) {
          break label22;
        }
        Log.d(TAG, "ACTION_DOWN");
        if ((this.nrW <= 0L) || (SystemClock.elapsedRealtime() - this.nrW >= HGh)) {
          J(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        this.nrW = SystemClock.elapsedRealtime();
        this.nrX = -1.0F;
        AppMethodBeat.o(75149);
        return;
        label123:
        if (localInteger.intValue() != 5) {
          break label26;
        }
        Log.d(TAG, "ACTION_POINTER_DOWN");
        AppMethodBeat.o(75149);
        return;
        label147:
        if (localInteger.intValue() != 6) {
          break label30;
        }
        Log.d(TAG, "ACTION_POINTER_UP");
        AppMethodBeat.o(75149);
        return;
        label172:
        if (localInteger.intValue() == 1)
        {
          Log.d(TAG, "ACTION_UP");
          this.nrX = -1.0F;
          AppMethodBeat.o(75149);
          return;
        }
      }
    }
    float f;
    if ((localInteger.intValue() == 2) && (paramMotionEvent.getPointerCount() >= 2))
    {
      f = y(paramMotionEvent);
      Log.v(TAG, "distance: %s", new Object[] { Float.valueOf(f) });
      if (f > 0.0F) {
        if (this.nrX > 0.0F)
        {
          if (Math.abs(f - this.nrX) <= HGi) {
            break label302;
          }
          if (f <= this.nrX) {
            break label309;
          }
          Log.d(TAG, "zoom out");
          bBF();
        }
      }
    }
    for (;;)
    {
      this.nrX = f;
      label302:
      AppMethodBeat.o(75149);
      return;
      label309:
      Log.d(TAG, "zoom in");
      bBG();
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75141);
    a locala = this.HGf;
    if (locala != null) {
      locala.release();
    }
    this.HGg = null;
    AppMethodBeat.o(75141);
  }
  
  public final void setClipPictureSize(boolean paramBoolean) {}
  
  public final void setClipVideoSize(boolean paramBoolean) {}
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(75117);
    Object localObject = MMApplicationContext.getContext().getSystemService("window");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(75117);
      throw ((Throwable)localObject);
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.j(localObject, "display");
    int i;
    switch (((Display)localObject).getRotation())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      Log.i(TAG, "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
      this.laP = paramFloat;
      if ((i == 90) || (i == 270)) {
        this.laP = (1.0F / this.laP);
      }
      localObject = this.HGf;
      if (localObject == null) {
        break;
      }
      ((a)localObject).setDisplayRatio(this.laP);
      AppMethodBeat.o(75117);
      return;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
    AppMethodBeat.o(75117);
  }
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.oLL = paramSize;
  }
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.nrE = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.nrF = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(75134);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.setFlashMode(paramInt);
      AppMethodBeat.o(75134);
      return;
    }
    AppMethodBeat.o(75134);
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    AppMethodBeat.i(75131);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.setFrameDataCallback(parama);
      AppMethodBeat.o(75131);
      return;
    }
    AppMethodBeat.o(75131);
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    AppMethodBeat.i(75116);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.setInitDoneCallback(paramc);
      AppMethodBeat.o(75116);
      return;
    }
    AppMethodBeat.o(75116);
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    AppMethodBeat.i(75115);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.setInitErrorCallback(paramd);
      AppMethodBeat.o(75115);
      return;
    }
    AppMethodBeat.o(75115);
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(75150);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.setPreviewMode(paramInt);
      AppMethodBeat.o(75150);
      return;
    }
    AppMethodBeat.o(75150);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(75118);
    Log.i(TAG, "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nrq = paramInt;
    AppMethodBeat.o(75118);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(75119);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.setRGBSizeLimit(paramInt);
      AppMethodBeat.o(75119);
      return;
    }
    AppMethodBeat.o(75119);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(75126);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.setUseBackCamera(paramBoolean);
      AppMethodBeat.o(75126);
      return;
    }
    AppMethodBeat.o(75126);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(75122);
    this.videoPath = paramString;
    if (paramString != null)
    {
      Object localObject = this.HGf;
      if (localObject != null)
      {
        p.k(paramString, "path");
        localObject = ((a)localObject).HFR;
        if (localObject != null)
        {
          p.k(paramString, "<set-?>");
          ((com.tencent.mm.plugin.recordvideo.b.a)localObject).videoPath = paramString;
        }
      }
    }
    Log.i(TAG, "video path has been set %s", new Object[] { paramString });
    AppMethodBeat.o(75122);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(75133);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_IGNORE_FLIP_CHECK_BOOLEAN", true);
    a locala = this.HGf;
    if (locala != null)
    {
      locala.a(d.c.HRe, localBundle);
      AppMethodBeat.o(75133);
      return;
    }
    AppMethodBeat.o(75133);
  }
  
  public final void yJ(int paramInt)
  {
    AppMethodBeat.i(75121);
    VideoTransPara localVideoTransPara = this.EZB;
    if (localVideoTransPara != null) {
      localVideoTransPara.duration = paramInt;
    }
    localVideoTransPara = this.EZB;
    if (localVideoTransPara != null) {
      localVideoTransPara.videoBitrate = 4800000;
    }
    localVideoTransPara = this.EZB;
    if (localVideoTransPara != null) {
      localVideoTransPara.fps = 30;
    }
    localVideoTransPara = this.EZB;
    if (localVideoTransPara != null) {
      localVideoTransPara.audioBitrate = 64000;
    }
    localVideoTransPara = this.EZB;
    if (localVideoTransPara != null) {
      localVideoTransPara.audioSampleRate = 44100;
    }
    if (this.EZB != null)
    {
      Object localObject = this.HGf;
      if (localObject != null)
      {
        localVideoTransPara = this.EZB;
        if (localVideoTransPara == null) {
          p.iCn();
        }
        p.k(localVideoTransPara, "para");
        localObject = ((a)localObject).HFR;
        if (localObject != null)
        {
          p.k(localVideoTransPara, "<set-?>");
          ((com.tencent.mm.plugin.recordvideo.b.a)localObject).HJp = localVideoTransPara;
          AppMethodBeat.o(75121);
          return;
        }
        AppMethodBeat.o(75121);
        return;
      }
    }
    AppMethodBeat.o(75121);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppRecordViewImpl$Companion;", "", "()V", "DOUBLE_CLICK_TIME_LIMIT", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "ZOOM_DISTANCE_THREASHOLD", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.d
 * JD-Core Version:    0.7.0.1
 */