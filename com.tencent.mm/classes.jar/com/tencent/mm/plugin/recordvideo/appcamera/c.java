package com.tencent.mm.plugin.recordvideo.appcamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.a.f;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.api.recordView.g.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppRecordViewImpl;", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$MMSightRecordViewDelegate;", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightMediaRecorder$ErrorCallback;", "Lcom/tencent/mm/plugin/api/recordView/MMSightRecordViewTouchListener$TouchCallback;", "()V", "cameraPluginLayout", "Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandCameraPluginLayout;", "displayRatio", "", "isDragZoomEnable", "", "isTouchFocusEnable", "lastPointerDistance", "lastTouchDownTime", "", "mDisplayScreenSize", "Landroid/util/Size;", "mZoomMultipleToRatio", "", "previewSizeLimit", "", "videoPath", "", "videoSizeRatio", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getCameraRotation", "getCurrentFramePicture", "Landroid/graphics/Bitmap;", "getDrawSizePoint", "Landroid/graphics/Point;", "getFlashMode", "getPictureSize", "getPreviewSize", "getScreenRotation", "getSupportZoomMultiple", "getVideoFilePath", "getVideoSize", "handlePluginTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "init", "context", "Landroid/content/Context;", "view", "Landroid/view/ViewGroup;", "surface", "Landroid/view/Surface;", "width", "height", "initRecorder", "isClipPictureSize", "isClipVideoSize", "isEnableDragZoom", "isEnableTouchFocus", "isFrontCamera", "onDoubleClick", "onError", "errorCode", "onFrameData", "data", "", "onTouchDown", "x", "y", "onZoomIn", "onZoomOut", "pointerDistance", "event", "release", "set34PreviewVideoSize", "setClipPictureSize", "clip", "setClipVideoSize", "setDisplayRatio", "size", "setDisplayScreenSize", "screenSize", "setEnableDragZoom", "enable", "setEnableTouchFocus", "setFlashMode", "flashMode", "setFrameBuffer", "buffer", "Ljava/nio/ByteBuffer;", "listener", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$OnDateUpdateListener;", "setFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$CameraFrameDataCallback;", "setHalfPreviewVideoSize", "setInitDoneCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitDoneCallback;", "setInitErrorCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$InitErrorCallback;", "setPreviewMode", "mode", "setPreviewSizeLimit", "limit", "setRGBSizeLimit", "setUseBackCamera", "back", "setVideoFilePath", "filePath", "setVideoPara", "maxDuration", "videoBitrate", "fps", "audioBitrate", "audioSampleRate", "setZoomMultiple", "multiple", "startPreview", "startRecord", "needMirror", "stopRecord", "stopCallback", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$StopRecordCallback;", "switchCamera", "takePicture", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$PictureTakenCallback;", "openFlash", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MMSightRecordView.e
  implements g.a, d.a, g
{
  public static final c.a NDG;
  private static final int NDJ;
  private static final int NDK;
  private static final String TAG;
  private VideoTransPara KVn;
  private a NDH;
  private float[] NDI;
  private float nFU;
  private float nwV = -1.0F;
  private int qpX;
  private long qqD = -1L;
  private boolean qql = true;
  private boolean qqm = true;
  private float qqs = 1.0F;
  private Size rPG;
  private String videoPath;
  
  static
  {
    AppMethodBeat.i(75151);
    NDG = new c.a((byte)0);
    TAG = "MicroMsg.AppRecordViewImpl";
    NDJ = 400;
    NDK = 15;
    AppMethodBeat.o(75151);
  }
  
  private static float x(MotionEvent paramMotionEvent)
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
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(281187);
    s.u(paramContext, "context");
    s.u(paramViewGroup, "view");
    this.NDH = new a(paramContext);
    a locala = this.NDH;
    if (locala != null)
    {
      s.u(paramContext, "context");
      s.u(paramViewGroup, "view");
      Log.i(a.TAG, "surface is %s", new Object[] { paramSurface });
      s.checkNotNull(paramSurface);
      locala.GoC = ((CameraPreviewGLSurfaceView)new com.tencent.mm.media.widget.camerarecordview.b(paramContext, paramSurface, paramInt1, paramInt2));
      locala.orientationEventListener = new d(paramContext, (byte)0);
      paramSurface = locala.orientationEventListener;
      s.checkNotNull(paramSurface);
      paramSurface.enable();
      locala.qqd = new MMSightCameraGLSurfaceView(paramContext);
      paramContext = locala.qqd;
      if (paramContext != null) {
        paramContext.setBackgroundColor(Color.argb(0, 0, 0, 0));
      }
      paramContext = new ViewGroup.MarginLayoutParams(-1, -1);
      paramViewGroup.addView((View)locala.qqd, (ViewGroup.LayoutParams)paramContext);
    }
    this.KVn = new VideoTransPara();
    AppMethodBeat.o(281187);
  }
  
  public final void a(MMSightRecordView.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(75125);
    a locala = this.NDH;
    if (locala != null)
    {
      locala.NDx = paramg;
      locala.NDB = paramBoolean;
    }
    paramg = this.NDH;
    if (paramg != null) {
      a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)paramg, a.c.NNU);
    }
    AppMethodBeat.o(75125);
  }
  
  public final void a(MMSightRecordView.h paramh)
  {
    AppMethodBeat.i(75124);
    a locala = this.NDH;
    if (locala != null) {
      locala.setRecordCallback(paramh);
    }
    paramh = this.NDH;
    if (paramh != null) {
      a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)paramh, a.c.NNN);
    }
    AppMethodBeat.o(75124);
  }
  
  public final void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(75142);
    a locala = this.NDH;
    if (locala != null) {
      locala.a(paramByteBuffer, paramf);
    }
    AppMethodBeat.o(75142);
  }
  
  public final void aPz()
  {
    AppMethodBeat.i(75120);
    if ((this.nFU > 0.0F) && (this.qpX > 0))
    {
      localObject1 = this.KVn;
      if (localObject1 != null) {
        ((VideoTransPara)localObject1).width = this.qpX;
      }
      localObject1 = this.KVn;
      if (localObject1 != null) {
        ((VideoTransPara)localObject1).height = ((int)(this.qpX / this.nFU));
      }
    }
    Object localObject1 = this.NDH;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = this.KVn;
      s.checkNotNull(localObject3);
      localObject4 = this.videoPath;
      s.checkNotNull(localObject4);
      localObject2 = this.rPG;
      s.u(localObject3, "para");
      s.u(localObject4, "videoPath");
      CameraPreviewGLSurfaceView localCameraPreviewGLSurfaceView = ((a)localObject1).GoC;
      s.checkNotNull(localCameraPreviewGLSurfaceView);
      ((a)localObject1).NDv = new com.tencent.mm.plugin.recordvideo.c.a((VideoTransPara)localObject3, localCameraPreviewGLSurfaceView, (String)localObject4);
      localObject3 = ((a)localObject1).NDv;
      s.checkNotNull(localObject3);
      ((a)localObject1).NDw = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.d.a)localObject3);
      localObject3 = ((a)localObject1).NDw;
      if ((localObject3 != null) && (true != ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).nJu))
      {
        ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).nJu = true;
        if (!((com.tencent.mm.media.widget.camerarecordview.a)localObject3).nJu)
        {
          localObject4 = ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).nJs;
          if ((((com.tencent.mm.media.widget.camerarecordview.a)localObject3).nJk) || (!((com.tencent.mm.media.widget.camerarecordview.a)localObject3).nJh.buo())) {
            break label333;
          }
        }
      }
    }
    label333:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.media.widget.camerarecordview.c.a)localObject4).a(bool, ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).mRu.btc());
      localObject3 = ((a)localObject1).NDw;
      if (localObject3 != null) {
        ((com.tencent.mm.media.widget.camerarecordview.a)localObject3).mRu.setDisplayScreenSize((Size)localObject2);
      }
      localObject2 = ((a)localObject1).NDw;
      if (localObject2 != null) {
        ((com.tencent.mm.media.widget.camerarecordview.a)localObject2).K((kotlin.g.a.b)new a.d((a)localObject1));
      }
      localObject2 = ((a)localObject1).NDw;
      s.checkNotNull(localObject2);
      com.tencent.mm.media.widget.camerarecordview.a.a((com.tencent.mm.media.widget.camerarecordview.a)localObject2, ((a)localObject1).NDA, null, (kotlin.g.a.b)new a.e((a)localObject1), 2);
      AppMethodBeat.o(75120);
      return;
    }
  }
  
  public final void al(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75145);
    if (this.qqm)
    {
      Bundle localBundle = new Bundle();
      localBundle.putFloat("PARAM_POINT_X", paramFloat1);
      localBundle.putFloat("PARAM_POINT_Y", paramFloat2);
      a locala = this.NDH;
      if (locala != null) {
        locala.a(a.c.NNL, localBundle);
      }
    }
    AppMethodBeat.o(75145);
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(75113);
    s.u(paramContext, "context");
    s.u(paramViewGroup, "view");
    this.NDH = new a(paramContext);
    a locala = this.NDH;
    if (locala != null) {
      locala.setTouchListener((g.a)this);
    }
    locala = this.NDH;
    if (locala != null)
    {
      s.u(paramContext, "context");
      s.u(paramViewGroup, "viewGroup");
      Object localObject = new ViewGroup.MarginLayoutParams(-1, -1);
      locala.GoC = new CameraPreviewGLSurfaceView(paramContext, null);
      CameraPreviewGLSurfaceView localCameraPreviewGLSurfaceView = locala.GoC;
      if (localCameraPreviewGLSurfaceView != null) {
        localCameraPreviewGLSurfaceView.setOnTouchListener((View.OnTouchListener)locala.qqo);
      }
      paramViewGroup.addView((View)locala.GoC, (ViewGroup.LayoutParams)localObject);
      locala.orientationEventListener = new d(paramContext, (byte)0);
      localObject = locala.orientationEventListener;
      s.checkNotNull(localObject);
      ((d)localObject).enable();
      locala.qqd = new MMSightCameraGLSurfaceView(paramContext);
      paramContext = locala.qqd;
      if (paramContext != null) {
        paramContext.setBackgroundColor(Color.argb(0, 0, 0, 0));
      }
      paramContext = new ViewGroup.MarginLayoutParams(1, 1);
      paramViewGroup.addView((View)locala.qqd, (ViewGroup.LayoutParams)paramContext);
    }
    this.KVn = new VideoTransPara();
    AppMethodBeat.o(75113);
  }
  
  public final boolean bB(float paramFloat)
  {
    AppMethodBeat.i(75137);
    if (this.NDI != null)
    {
      localObject = this.NDI;
      if ((localObject == null) || (localObject.length != 0)) {
        break label71;
      }
    }
    label71:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.NDI;
        if (localObject != null) {
          break;
        }
        localObject = null;
        s.checkNotNull(localObject);
        if (((Integer)localObject).intValue() >= 0) {
          break label125;
        }
      }
      AppMethodBeat.o(75137);
      return false;
    }
    s.u(localObject, "$this$indexOf");
    int j = localObject.length;
    i = 0;
    label90:
    if (i < j) {
      if (paramFloat != localObject[i]) {}
    }
    for (;;)
    {
      localObject = Integer.valueOf(i);
      break;
      i += 1;
      break label90;
      i = -1;
    }
    label125:
    Object localObject = this.NDH;
    if (localObject != null) {
      ((a)localObject).setForceZoomTargetRatio(paramFloat);
    }
    AppMethodBeat.o(75137);
    return true;
  }
  
  public final void bof()
  {
    AppMethodBeat.i(75146);
    if (this.qql)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", true);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
      a locala = this.NDH;
      if (locala != null) {
        locala.a(a.c.NNJ, localBundle);
      }
    }
    AppMethodBeat.o(75146);
  }
  
  public final void bog()
  {
    AppMethodBeat.i(75147);
    if (this.qql)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
      localBundle.putBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", false);
      localBundle.putInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT", 1);
      a locala = this.NDH;
      if (locala != null) {
        locala.a(a.c.NNJ, localBundle);
      }
    }
    AppMethodBeat.o(75147);
  }
  
  public final void caT() {}
  
  public final void caY()
  {
    AppMethodBeat.i(75138);
    Log.i(TAG, "setHalfPreviewVideoSize");
    this.qqs = 0.5F;
    AppMethodBeat.o(75138);
  }
  
  public final void caZ()
  {
    AppMethodBeat.i(75139);
    Log.i(TAG, "set34PreviewVideoSize");
    this.qqs = 0.75F;
    AppMethodBeat.o(75139);
  }
  
  public final void cba()
  {
    AppMethodBeat.i(75144);
    a locala = this.NDH;
    if (locala != null) {
      locala.reset();
    }
    AppMethodBeat.o(75144);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(75132);
    if (this.NDH != null)
    {
      a locala = this.NDH;
      s.checkNotNull(locala);
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
    Object localObject = this.NDH;
    if (localObject == null)
    {
      AppMethodBeat.o(75140);
      return null;
    }
    localObject = ((a)localObject).getCurrentFramePicture();
    AppMethodBeat.o(75140);
    return localObject;
  }
  
  public final Point getDrawSizePoint()
  {
    AppMethodBeat.i(75130);
    Object localObject = this.NDH;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((a)localObject).getDrawSizePoint())
    {
      localObject = new Point();
      AppMethodBeat.o(75130);
      return localObject;
    }
    AppMethodBeat.o(75130);
    return localObject;
  }
  
  public final int getFlashMode()
  {
    AppMethodBeat.i(75135);
    a locala = this.NDH;
    if (locala == null)
    {
      AppMethodBeat.o(75135);
      return 0;
    }
    int i = locala.getFlashMode();
    AppMethodBeat.o(75135);
    return i;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(75127);
    Object localObject = this.NDH;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((a)localObject).getPictureSize())
    {
      localObject = new Point();
      AppMethodBeat.o(75127);
      return localObject;
    }
    AppMethodBeat.o(75127);
    return localObject;
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(75129);
    Object localObject = this.NDH;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((a)localObject).getPreviewSize())
    {
      localObject = new Point();
      AppMethodBeat.o(75129);
      return localObject;
    }
    AppMethodBeat.o(75129);
    return localObject;
  }
  
  public final float[] getSupportZoomMultiple()
  {
    AppMethodBeat.i(75136);
    if ((this.NDI == null) && (this.NDH != null))
    {
      localObject = this.NDH;
      s.checkNotNull(localObject);
      this.NDI = ((a)localObject).getSupportZoomRatios();
    }
    Object localObject = this.NDI;
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
    Object localObject = this.NDH;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((a)localObject).getVideoSize())
    {
      localObject = new Point();
      AppMethodBeat.o(75128);
      return localObject;
    }
    AppMethodBeat.o(75128);
    return localObject;
  }
  
  public final boolean hT(boolean paramBoolean)
  {
    AppMethodBeat.i(281221);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_RECORD_RESULT_MIRROR_BOOLEAN", paramBoolean);
    a locala = this.NDH;
    if (locala != null) {
      locala.a(a.c.NNM, localBundle);
    }
    AppMethodBeat.o(281221);
    return true;
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(75149);
    Integer localInteger;
    if (paramMotionEvent == null)
    {
      localInteger = null;
      if (localInteger != null) {
        break label50;
      }
      label16:
      if (localInteger != null) {
        break label123;
      }
      label20:
      if (localInteger != null) {
        break label147;
      }
      label24:
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
        localInteger = Integer.valueOf(paramMotionEvent.getAction());
        break;
        label50:
        if (localInteger.intValue() != 0) {
          break label16;
        }
        Log.d(TAG, "ACTION_DOWN");
        if ((this.qqD <= 0L) || (SystemClock.elapsedRealtime() - this.qqD >= NDJ)) {
          al(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        this.qqD = SystemClock.elapsedRealtime();
        this.nwV = -1.0F;
        AppMethodBeat.o(75149);
        return;
        label123:
        if (localInteger.intValue() != 5) {
          break label20;
        }
        Log.d(TAG, "ACTION_POINTER_DOWN");
        AppMethodBeat.o(75149);
        return;
        label147:
        if (localInteger.intValue() != 6) {
          break label24;
        }
        Log.d(TAG, "ACTION_POINTER_UP");
        AppMethodBeat.o(75149);
        return;
        label172:
        if (localInteger.intValue() == 1)
        {
          Log.d(TAG, "ACTION_UP");
          this.nwV = -1.0F;
          AppMethodBeat.o(75149);
          return;
        }
      }
    }
    float f;
    if ((localInteger.intValue() == 2) && (paramMotionEvent.getPointerCount() >= 2))
    {
      f = x(paramMotionEvent);
      Log.v(TAG, "distance: %s", new Object[] { Float.valueOf(f) });
      if (f > 0.0F) {
        if (this.nwV > 0.0F)
        {
          if (Math.abs(f - this.nwV) <= NDK) {
            break label302;
          }
          if (f <= this.nwV) {
            break label309;
          }
          Log.d(TAG, "zoom out");
          bof();
        }
      }
    }
    for (;;)
    {
      this.nwV = f;
      label302:
      AppMethodBeat.o(75149);
      return;
      label309:
      Log.d(TAG, "zoom in");
      bog();
    }
  }
  
  public final boolean onFrameData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75143);
    a locala = this.NDH;
    if (locala == null)
    {
      AppMethodBeat.o(75143);
      return false;
    }
    boolean bool = locala.onFrameData(paramArrayOfByte);
    AppMethodBeat.o(75143);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(75141);
    a locala = this.NDH;
    if (locala != null) {
      locala.release();
    }
    this.NDI = null;
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
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(75117);
      throw ((Throwable)localObject);
    }
    int i;
    switch (((WindowManager)localObject).getDefaultDisplay().getRotation())
    {
    default: 
      i = 0;
      Log.i(TAG, "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
      this.nFU = paramFloat;
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      localObject = this.NDH;
      if (localObject != null) {
        ((a)localObject).setDisplayRatio(this.nFU);
      }
      AppMethodBeat.o(75117);
      return;
      i = 0;
      break;
      i = 90;
      break;
      i = 180;
      break;
      i = 270;
      break;
      this.nFU = (1.0F / this.nFU);
    }
  }
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.rPG = paramSize;
  }
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.qql = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.qqm = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(75134);
    a locala = this.NDH;
    if (locala != null) {
      locala.setFlashMode(paramInt);
    }
    AppMethodBeat.o(75134);
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    AppMethodBeat.i(75131);
    a locala = this.NDH;
    if (locala != null) {
      locala.setFrameDataCallback(parama);
    }
    AppMethodBeat.o(75131);
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    AppMethodBeat.i(75116);
    a locala = this.NDH;
    if (locala != null) {
      locala.setInitDoneCallback(paramc);
    }
    AppMethodBeat.o(75116);
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    AppMethodBeat.i(75115);
    a locala = this.NDH;
    if (locala != null) {
      locala.setInitErrorCallback(paramd);
    }
    AppMethodBeat.o(75115);
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(75150);
    a locala = this.NDH;
    if (locala != null) {
      locala.setPreviewMode(paramInt);
    }
    AppMethodBeat.o(75150);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(75118);
    Log.i(TAG, "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.qpX = paramInt;
    AppMethodBeat.o(75118);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(75119);
    a locala = this.NDH;
    if (locala != null) {
      locala.setRGBSizeLimit(paramInt);
    }
    AppMethodBeat.o(75119);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(75126);
    a locala = this.NDH;
    if (locala != null) {
      locala.setUseBackCamera(paramBoolean);
    }
    AppMethodBeat.o(75126);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(75122);
    this.videoPath = paramString;
    if (paramString != null)
    {
      Object localObject = this.NDH;
      if (localObject != null)
      {
        s.u(paramString, "path");
        localObject = ((a)localObject).NDv;
        if (localObject != null)
        {
          s.u(paramString, "<set-?>");
          ((com.tencent.mm.plugin.recordvideo.c.a)localObject).videoPath = paramString;
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
    a locala = this.NDH;
    if (locala != null) {
      locala.a(a.c.NNK, localBundle);
    }
    AppMethodBeat.o(75133);
  }
  
  public final void yR(int paramInt)
  {
    AppMethodBeat.i(75121);
    VideoTransPara localVideoTransPara = this.KVn;
    if (localVideoTransPara != null) {
      localVideoTransPara.duration = paramInt;
    }
    localVideoTransPara = this.KVn;
    if (localVideoTransPara != null) {
      localVideoTransPara.videoBitrate = 4800000;
    }
    localVideoTransPara = this.KVn;
    if (localVideoTransPara != null) {
      localVideoTransPara.fps = 30;
    }
    localVideoTransPara = this.KVn;
    if (localVideoTransPara != null) {
      localVideoTransPara.audioBitrate = 64000;
    }
    localVideoTransPara = this.KVn;
    if (localVideoTransPara != null) {
      localVideoTransPara.audioSampleRate = 44100;
    }
    if (this.KVn != null)
    {
      Object localObject = this.NDH;
      if (localObject != null)
      {
        localVideoTransPara = this.KVn;
        s.checkNotNull(localVideoTransPara);
        s.u(localVideoTransPara, "para");
        localObject = ((a)localObject).NDv;
        if (localObject != null)
        {
          s.u(localVideoTransPara, "<set-?>");
          ((com.tencent.mm.plugin.recordvideo.c.a)localObject).NGp = localVideoTransPara;
        }
      }
    }
    AppMethodBeat.o(75121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.appcamera.c
 * JD-Core Version:    0.7.0.1
 */