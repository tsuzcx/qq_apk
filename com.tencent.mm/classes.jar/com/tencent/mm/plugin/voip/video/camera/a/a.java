package com.tencent.mm.plugin.voip.video.camera.a;

import android.graphics.SurfaceTexture;
import android.util.Size;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "", "()V", "bind", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "exchangeCapture", "focusOnFace", "faceLocation", "", "isClickScreen", "", "getCameraErrCode", "", "getCameraFps", "getCurrentCameraIsFace", "getDisplayOrientation", "getPreviewSize", "Landroid/util/Size;", "getRotateAngle", "initCapture", "dataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "bFaceFirst", "isCameraRemote180", "isMirror", "isPreviewing", "onOrientationChange", "rotation", "setDisplayOrientation", "startCapture", "stopCapture", "unInit", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public abstract int a(c paramc, boolean paramBoolean);
  
  public abstract boolean boa();
  
  public abstract boolean bqb();
  
  public abstract void ggH();
  
  public abstract Size hq();
  
  public abstract int icA();
  
  public abstract void icB();
  
  public abstract int icC();
  
  public abstract boolean icu();
  
  public abstract boolean icv();
  
  public abstract int icw();
  
  public abstract int icx();
  
  public abstract void icy();
  
  public abstract int icz();
  
  public abstract void onOrientationChange(int paramInt);
  
  public abstract void unInit();
  
  public abstract void v(SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.a.a
 * JD-Core Version:    0.7.0.1
 */