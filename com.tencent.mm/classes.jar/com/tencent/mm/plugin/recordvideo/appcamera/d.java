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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.v;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppRecordViewImpl;", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$MMSightRecordViewDelegate;", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightMediaRecorder$ErrorCallback;", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "()V", "cameraPluginLayout", "Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "displayRatio", "", "isDragZoomEnable", "", "isTouchFocusEnable", "lastPointerDistance", "lastTouchDownTime", "", "mDisplayScreenSize", "Landroid/util/Size;", "mZoomMultipleToRatio", "", "previewSizeLimit", "", "videoPath", "", "videoSizeRatio", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "Landroid/graphics/Point;", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomMultiple", "getVideoFilePath", "getVideoSize", "handlePluginTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "init", "context", "Landroid/content/Context;", "view", "Landroid/view/ViewGroup;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "initRecorder", "isClipPictureSize", "isClipVideoSize", "isEnableDragZoom", "isEnableTouchFocus", "isFrontCamera", "onDoubleClick", "onError", "errorCode", "onFrameData", "data", "", "onTouchDown", "x", "y", "onZoomIn", "onZoomOut", "pointerDistance", "event", "release", "set34PreviewVideoSize", "setClipPictureSize", "clip", "setClipVideoSize", "setDisplayRatio", "size", "setDisplayScreenSize", "screenSize", "setEnableDragZoom", "enable", "setEnableTouchFocus", "setFlashMode", "flashMode", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", "listener", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "setHalfPreviewVideoSize", "setInitDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "setInitErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "setPreviewMode", "mode", "setPreviewSizeLimit", "limit", "setRGBSizeLimit", "setUseBackCamera", "back", "setVideoFilePath", "filePath", "setVideoPara", "maxDuration", "videoBitrate", "fps", "audioBitrate", "audioSampleRate", "setZoomMultiple", "multiple", "startPreview", "startRecord", "stopRecord", "stopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "switchCamera", "takePicture", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "openFlash", "Companion", "plugin-recordvideo_release"})
public final class d
  extends MMSightRecordView.e
  implements g.a, com.tencent.mm.plugin.mmsight.model.a.d.a, g
{
  private static final String TAG = "MicroMsg.AppRecordViewImpl";
  private static final int xJT = 400;
  private static final int xJU = 15;
  public static final d.a xJV;
  private float hrT;
  private int jxH;
  private boolean jxV = true;
  private boolean jxW = true;
  private float jyc = 1.0F;
  private long jyn = -1L;
  private float jyo = -1.0F;
  private Size kKL;
  private VideoTransPara vZX;
  private String videoPath;
  private a xJR;
  private float[] xJS;
  
  static
  {
    AppMethodBeat.i(75151);
    xJV = new d.a((byte)0);
    TAG = "MicroMsg.AppRecordViewImpl";
    xJT = 400;
    xJU = 15;
    AppMethodBeat.o(75151);
  }
  
  private static float t(MotionEvent paramMotionEvent)
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
      ae.e(TAG, "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(75148);
    }
    return 0.0F;
  }
  
  public final void E(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75145);
    if (this.jxW)
    {
      Bundle localBundle = new Bundle();
      localBundle.putFloat("PARAM_POINT_X", paramFloat1);
      localBundle.putFloat("PARAM_POINT_Y", paramFloat2);
      a locala = this.xJR;
      if (locala != null)
      {
        locala.a(d.c.xTV, localBundle);
        AppMethodBeat.o(75145);
        return;
      }
    }
    AppMethodBeat.o(75145);
  }
  
  public final boolean PO()
  {
    AppMethodBeat.i(75123);
    a locala = this.xJR;
    if (locala != null) {
      d.b.a(locala, d.c.xTW);
    }
    AppMethodBeat.o(75123);
    return true;
  }
  
  public final boolean U(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75143);
    a locala = this.xJR;
    if (locala != null)
    {
      boolean bool = locala.U(paramArrayOfByte);
      AppMethodBeat.o(75143);
      return bool;
    }
    AppMethodBeat.o(75143);
    return false;
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75114);
    p.h(paramContext, "context");
    p.h(paramViewGroup, "view");
    this.xJR = new a(paramContext);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    }
    a locala = this.xJR;
    if (locala != null)
    {
      p.h(paramContext, "context");
      p.h(paramViewGroup, "view");
      ae.i(a.TAG, "surface is %s", new Object[] { paramSurfaceTexture });
      if (paramSurfaceTexture == null) {
        p.gkB();
      }
      locala.sYF = ((CameraPreviewGLSurfaceView)new com.tencent.mm.media.widget.camerarecordview.b(paramContext, paramSurfaceTexture, paramInt1, paramInt2));
      locala.haJ = new com.tencent.mm.plugin.mmsight.model.d(paramContext, (byte)0);
      paramSurfaceTexture = locala.haJ;
      if (paramSurfaceTexture == null) {
        p.gkB();
      }
      paramSurfaceTexture.enable();
      locala.jxN = new MMSightCameraGLSurfaceView(paramContext);
      paramContext = locala.jxN;
      if (paramContext != null) {
        paramContext.setBackgroundColor(Color.argb(0, 0, 0, 0));
      }
      paramContext = new ViewGroup.MarginLayoutParams(-1, -1);
      paramViewGroup.addView((View)locala.jxN, (ViewGroup.LayoutParams)paramContext);
    }
    this.vZX = new VideoTransPara();
    AppMethodBeat.o(75114);
  }
  
  public final void a(MMSightRecordView.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(75125);
    a locala = this.xJR;
    if (locala != null)
    {
      locala.xJF = paramg;
      locala.xJJ = paramBoolean;
    }
    paramg = this.xJR;
    if (paramg != null)
    {
      d.b.a(paramg, d.c.xUe);
      AppMethodBeat.o(75125);
      return;
    }
    AppMethodBeat.o(75125);
  }
  
  public final void a(MMSightRecordView.h paramh)
  {
    AppMethodBeat.i(75124);
    a locala = this.xJR;
    if (locala != null) {
      locala.setRecordCallback(paramh);
    }
    paramh = this.xJR;
    if (paramh != null)
    {
      d.b.a(paramh, d.c.xTX);
      AppMethodBeat.o(75124);
      return;
    }
    AppMethodBeat.o(75124);
  }
  
  public final void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(75142);
    a locala = this.xJR;
    if (locala != null)
    {
      if ((paramf == null) && (paramByteBuffer == null))
      {
        if (locala.jyd != null)
        {
          paramByteBuffer = locala.jyd;
          if (paramByteBuffer != null) {
            paramByteBuffer.release();
          }
          locala.jyd = null;
          paramByteBuffer = locala.jxN;
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
      if (locala.jyd == null)
      {
        locala.jyd = new h();
        locala.aVV();
        h localh = locala.jyd;
        if (localh != null) {
          localh.a((i.a)new a.h(paramf, paramByteBuffer));
        }
        paramByteBuffer = locala.xJE;
        if (paramByteBuffer != null)
        {
          paramByteBuffer = Boolean.valueOf(paramByteBuffer.gKX.awp());
          if (paramByteBuffer == null) {
            p.gkB();
          }
          if (!paramByteBuffer.booleanValue()) {
            break label257;
          }
          paramByteBuffer = locala.jxN;
          if (paramByteBuffer == null) {
            break label257;
          }
          if (paramByteBuffer.getEglContext() == null) {
            break label222;
          }
          paramf = locala.jyd;
          if (paramf != null) {
            paramf.b(paramByteBuffer.getEglContext());
          }
        }
        for (;;)
        {
          paramByteBuffer = locala.jxN;
          if (paramByteBuffer == null) {
            break label250;
          }
          paramByteBuffer.setVisibility(0);
          AppMethodBeat.o(75142);
          return;
          paramByteBuffer = null;
          break;
          label222:
          paramf = locala.jxN;
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
  
  public final void aVL() {}
  
  public final void aVQ()
  {
    AppMethodBeat.i(75138);
    ae.i(TAG, "setHalfPreviewVideoSize");
    this.jyc = 0.5F;
    AppMethodBeat.o(75138);
  }
  
  public final void aVR()
  {
    AppMethodBeat.i(75139);
    ae.i(TAG, "set34PreviewVideoSize");
    this.jyc = 0.75F;
    AppMethodBeat.o(75139);
  }
  
  public final void aVS()
  {
    AppMethodBeat.i(75144);
    a locala = this.xJR;
    if (locala != null)
    {
      locala.reset();
      AppMethodBeat.o(75144);
      return;
    }
    AppMethodBeat.o(75144);
  }
  
  public final void aVT()
  {
    AppMethodBeat.i(75146);
    if (this.jxV)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
      a locala = this.xJR;
      if (locala != null)
      {
        locala.a(d.c.xTT, localBundle);
        AppMethodBeat.o(75146);
        return;
      }
    }
    AppMethodBeat.o(75146);
  }
  
  public final void aVU()
  {
    AppMethodBeat.i(75147);
    if (this.jxV)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
      a locala = this.xJR;
      if (locala != null)
      {
        locala.a(d.c.xTT, localBundle);
        AppMethodBeat.o(75147);
        return;
      }
    }
    AppMethodBeat.o(75147);
  }
  
  public final boolean at(float paramFloat)
  {
    AppMethodBeat.i(75137);
    int i;
    if (this.xJS != null)
    {
      localObject = this.xJS;
      if ((localObject == null) || (localObject.length != 0))
      {
        localObject = this.xJS;
        if (localObject == null) {
          break label111;
        }
        p.h(localObject, "$this$indexOf");
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
        p.gkB();
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
    localObject = this.xJR;
    if (localObject != null) {
      ((a)localObject).setForceZoomTargetRatio(paramFloat);
    }
    AppMethodBeat.o(75137);
    return true;
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75113);
    p.h(paramContext, "context");
    p.h(paramViewGroup, "view");
    this.xJR = new a(paramContext);
    a locala = this.xJR;
    if (locala != null) {
      locala.setTouchListener((g.a)this);
    }
    locala = this.xJR;
    if (locala != null)
    {
      p.h(paramContext, "context");
      p.h(paramViewGroup, "viewGroup");
      Object localObject = new ViewGroup.MarginLayoutParams(-1, -1);
      locala.sYF = new CameraPreviewGLSurfaceView(paramContext, null);
      CameraPreviewGLSurfaceView localCameraPreviewGLSurfaceView = locala.sYF;
      if (localCameraPreviewGLSurfaceView != null) {
        localCameraPreviewGLSurfaceView.setOnTouchListener((View.OnTouchListener)locala.jxY);
      }
      paramViewGroup.addView((View)locala.sYF, (ViewGroup.LayoutParams)localObject);
      locala.haJ = new com.tencent.mm.plugin.mmsight.model.d(paramContext, (byte)0);
      localObject = locala.haJ;
      if (localObject == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.mmsight.model.d)localObject).enable();
      locala.jxN = new MMSightCameraGLSurfaceView(paramContext);
      paramContext = locala.jxN;
      if (paramContext != null) {
        paramContext.setBackgroundColor(Color.argb(0, 0, 0, 0));
      }
      paramContext = new ViewGroup.MarginLayoutParams(1, 1);
      paramViewGroup.addView((View)locala.jxN, (ViewGroup.LayoutParams)paramContext);
    }
    this.vZX = new VideoTransPara();
    AppMethodBeat.o(75113);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(75132);
    if (this.xJR != null)
    {
      a locala = this.xJR;
      if (locala == null) {
        p.gkB();
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
    Object localObject = this.xJR;
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
    Object localObject = this.xJR;
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
    a locala = this.xJR;
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
    Object localObject = this.xJR;
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
    Object localObject = this.xJR;
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
    if ((this.xJS == null) && (this.xJR != null))
    {
      localObject = this.xJR;
      if (localObject == null) {
        p.gkB();
      }
      this.xJS = ((a)localObject).getSupportZoomRatios();
    }
    Object localObject = this.xJS;
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
    Object localObject = this.xJR;
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
  
  public final void l(MotionEvent paramMotionEvent)
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
        ae.d(TAG, "ACTION_DOWN");
        if ((this.jyn <= 0L) || (SystemClock.elapsedRealtime() - this.jyn >= xJT)) {
          E(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        this.jyn = SystemClock.elapsedRealtime();
        this.jyo = -1.0F;
        AppMethodBeat.o(75149);
        return;
        label123:
        if (localInteger.intValue() != 5) {
          break label26;
        }
        ae.d(TAG, "ACTION_POINTER_DOWN");
        AppMethodBeat.o(75149);
        return;
        label147:
        if (localInteger.intValue() != 6) {
          break label30;
        }
        ae.d(TAG, "ACTION_POINTER_UP");
        AppMethodBeat.o(75149);
        return;
        label172:
        if (localInteger.intValue() == 1)
        {
          ae.d(TAG, "ACTION_UP");
          this.jyo = -1.0F;
          AppMethodBeat.o(75149);
          return;
        }
      }
    }
    float f;
    if ((localInteger.intValue() == 2) && (paramMotionEvent.getPointerCount() >= 2))
    {
      f = t(paramMotionEvent);
      ae.v(TAG, "distance: %s", new Object[] { Float.valueOf(f) });
      if (f > 0.0F) {
        if (this.jyo > 0.0F)
        {
          if (Math.abs(f - this.jyo) <= xJU) {
            break label302;
          }
          if (f <= this.jyo) {
            break label309;
          }
          ae.d(TAG, "zoom out");
          aVT();
        }
      }
    }
    for (;;)
    {
      this.jyo = f;
      label302:
      AppMethodBeat.o(75149);
      return;
      label309:
      ae.d(TAG, "zoom in");
      aVU();
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75141);
    a locala = this.xJR;
    if (locala != null) {
      locala.release();
    }
    this.xJS = null;
    AppMethodBeat.o(75141);
  }
  
  public final void setClipPictureSize(boolean paramBoolean) {}
  
  public final void setClipVideoSize(boolean paramBoolean) {}
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(75117);
    Object localObject = ak.getContext().getSystemService("window");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(75117);
      throw ((Throwable)localObject);
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.g(localObject, "display");
    int i;
    switch (((Display)localObject).getRotation())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ae.i(TAG, "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
      this.hrT = paramFloat;
      if ((i == 90) || (i == 270)) {
        this.hrT = (1.0F / this.hrT);
      }
      localObject = this.xJR;
      if (localObject == null) {
        break;
      }
      ((a)localObject).setDisplayRatio(this.hrT);
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
    this.kKL = paramSize;
  }
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.jxV = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.jxW = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(75134);
    a locala = this.xJR;
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
    a locala = this.xJR;
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
    a locala = this.xJR;
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
    a locala = this.xJR;
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
    a locala = this.xJR;
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
    ae.i(TAG, "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.jxH = paramInt;
    AppMethodBeat.o(75118);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(75119);
    a locala = this.xJR;
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
    a locala = this.xJR;
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
      Object localObject = this.xJR;
      if (localObject != null)
      {
        p.h(paramString, "path");
        localObject = ((a)localObject).xJD;
        if (localObject != null)
        {
          p.h(paramString, "<set-?>");
          ((com.tencent.mm.plugin.recordvideo.b.a)localObject).videoPath = paramString;
        }
      }
    }
    ae.i(TAG, "video path has been set %s", new Object[] { paramString });
    AppMethodBeat.o(75122);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(75121);
    VideoTransPara localVideoTransPara = this.vZX;
    if (localVideoTransPara != null) {
      localVideoTransPara.duration = paramInt;
    }
    localVideoTransPara = this.vZX;
    if (localVideoTransPara != null) {
      localVideoTransPara.videoBitrate = 4800000;
    }
    localVideoTransPara = this.vZX;
    if (localVideoTransPara != null) {
      localVideoTransPara.fps = 30;
    }
    localVideoTransPara = this.vZX;
    if (localVideoTransPara != null) {
      localVideoTransPara.audioBitrate = 64000;
    }
    localVideoTransPara = this.vZX;
    if (localVideoTransPara != null) {
      localVideoTransPara.audioSampleRate = 44100;
    }
    if (this.vZX != null)
    {
      Object localObject = this.xJR;
      if (localObject != null)
      {
        localVideoTransPara = this.vZX;
        if (localVideoTransPara == null) {
          p.gkB();
        }
        p.h(localVideoTransPara, "para");
        localObject = ((a)localObject).xJD;
        if (localObject != null)
        {
          p.h(localVideoTransPara, "<set-?>");
          ((com.tencent.mm.plugin.recordvideo.b.a)localObject).xMD = localVideoTransPara;
          AppMethodBeat.o(75121);
          return;
        }
        AppMethodBeat.o(75121);
        return;
      }
    }
    AppMethodBeat.o(75121);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(75120);
    if ((this.hrT > 0.0F) && (this.jxH > 0))
    {
      localObject1 = this.vZX;
      if (localObject1 != null) {
        ((VideoTransPara)localObject1).width = this.jxH;
      }
      localObject1 = this.vZX;
      if (localObject1 != null) {
        ((VideoTransPara)localObject1).height = ((int)(this.jxH / this.hrT));
      }
    }
    Object localObject1 = this.xJR;
    if (localObject1 != null)
    {
      Object localObject3 = this.vZX;
      if (localObject3 == null) {
        p.gkB();
      }
      Object localObject4 = this.videoPath;
      if (localObject4 == null) {
        p.gkB();
      }
      Object localObject2 = this.kKL;
      p.h(localObject3, "para");
      p.h(localObject4, "videoPath");
      CameraPreviewGLSurfaceView localCameraPreviewGLSurfaceView = ((a)localObject1).sYF;
      if (localCameraPreviewGLSurfaceView == null) {
        p.gkB();
      }
      ((a)localObject1).xJD = new com.tencent.mm.plugin.recordvideo.b.a((VideoTransPara)localObject3, localCameraPreviewGLSurfaceView, (String)localObject4);
      localObject3 = ((a)localObject1).xJD;
      if (localObject3 == null) {
        p.gkB();
      }
      ((a)localObject1).xJE = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)localObject3);
      localObject3 = ((a)localObject1).xJE;
      if ((localObject3 != null) && (true != ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).hwd))
      {
        ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).hwd = true;
        if (!((com.tencent.mm.media.widget.camerarecordview.a)localObject3).hwd)
        {
          localObject4 = ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).hwb;
          if ((((com.tencent.mm.media.widget.camerarecordview.a)localObject3).hvS) || (!((com.tencent.mm.media.widget.camerarecordview.a)localObject3).hwf.axZ())) {
            break label346;
          }
        }
      }
      label346:
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject4).a(bool, ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).gKX.awA());
        localObject3 = ((a)localObject1).xJE;
        if (localObject3 != null) {
          ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).gKX.setDisplayScreenSize((Size)localObject2);
        }
        localObject2 = ((a)localObject1).xJE;
        if (localObject2 != null) {
          ((com.tencent.mm.media.widget.camerarecordview.a)localObject2).q((d.g.a.b)new a.c((a)localObject1));
        }
        localObject2 = ((a)localObject1).xJE;
        if (localObject2 == null) {
          p.gkB();
        }
        ((com.tencent.mm.media.widget.camerarecordview.a)localObject2).a(((a)localObject1).xJI, (d.g.a.b)new a.d((a)localObject1));
        AppMethodBeat.o(75120);
        return;
      }
    }
    AppMethodBeat.o(75120);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(75133);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_PREPARE_CAMERA_IGNORE_FLIP_CHECK_BOOLEAN", true);
    a locala = this.xJR;
    if (locala != null)
    {
      locala.a(d.c.xTU, localBundle);
      AppMethodBeat.o(75133);
      return;
    }
    AppMethodBeat.o(75133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.d
 * JD-Core Version:    0.7.0.1
 */