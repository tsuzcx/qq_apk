package com.tencent.mm.plugin.voip.video.camera.a;

import android.graphics.SurfaceTexture;
import com.tencent.mm.compatible.deviceinfo.ac;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "", "()V", "bind", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "exchangeCapture", "focusOnFace", "faceLocation", "", "isClickScreen", "", "getCameraErrCode", "", "getCurrentCameraIsFace", "getDisplayOrientation", "getPreviewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "getRotateAngle", "initCapture", "dataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "bFaceFirst", "isCameraRemote180", "isMirror", "isPreviewing", "onOrientationChange", "rotation", "setDisplayOrientation", "startCapture", "stopCapture", "plugin-voip_release"})
public abstract class a
{
  public abstract int a(b paramb, boolean paramBoolean);
  
  public abstract boolean dEO();
  
  public abstract void eoc();
  
  public abstract boolean fKY();
  
  public abstract boolean fKZ();
  
  public abstract int fLa();
  
  public abstract int fLb();
  
  public abstract ac fLc();
  
  public abstract void fLd();
  
  public abstract int fLe();
  
  public abstract boolean fLf();
  
  public abstract void fLg();
  
  public abstract int fLh();
  
  public abstract void fLi();
  
  public abstract void onOrientationChange(int paramInt);
  
  public abstract void q(SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.a.a
 * JD-Core Version:    0.7.0.1
 */