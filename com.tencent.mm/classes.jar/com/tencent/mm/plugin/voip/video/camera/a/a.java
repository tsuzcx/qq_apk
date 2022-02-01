package com.tencent.mm.plugin.voip.video.camera.a;

import android.graphics.SurfaceTexture;
import com.tencent.mm.compatible.deviceinfo.ad;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/camera/common/BaseCaptureRenderer;", "", "()V", "bind", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "exchangeCapture", "focusOnFace", "faceLocation", "", "isClickScreen", "", "getCameraErrCode", "", "getCurrentCameraIsFace", "getDisplayOrientation", "getPreviewSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "getRotateAngle", "initCapture", "dataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "bFaceFirst", "isCameraRemote180", "isMirror", "isPreviewing", "onOrientationChange", "rotation", "setDisplayOrientation", "startCapture", "stopCapture", "plugin-voip_release"})
public abstract class a
{
  public abstract int a(c paramc, boolean paramBoolean);
  
  public abstract void eXS();
  
  public abstract boolean egx();
  
  public abstract int gDA();
  
  public abstract int gDB();
  
  public abstract ad gDC();
  
  public abstract void gDD();
  
  public abstract int gDE();
  
  public abstract boolean gDF();
  
  public abstract void gDG();
  
  public abstract int gDH();
  
  public abstract void gDI();
  
  public abstract boolean gDy();
  
  public abstract boolean gDz();
  
  public abstract void onOrientationChange(int paramInt);
  
  public abstract void t(SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.a.a
 * JD-Core Version:    0.7.0.1
 */