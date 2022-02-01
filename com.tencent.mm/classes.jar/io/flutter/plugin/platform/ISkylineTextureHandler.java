package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lio/flutter/plugin/platform/ISkylineTextureHandler;", "", "onTextureDestroy", "", "type", "", "id", "", "onTextureReady", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onTextureTouch", "motionEvent", "Landroid/view/MotionEvent;", "onTextureUpdate", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public abstract interface ISkylineTextureHandler
{
  public abstract void onTextureDestroy(String paramString, int paramInt);
  
  public abstract void onTextureReady(String paramString, int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3);
  
  public abstract void onTextureTouch(String paramString, int paramInt, MotionEvent paramMotionEvent);
  
  public abstract void onTextureUpdate(String paramString, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.platform.ISkylineTextureHandler
 * JD-Core Version:    0.7.0.1
 */