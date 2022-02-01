package com.tencent.thumbplayer.core.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public class TPNativePlayerSurface
  extends Surface
{
  private ITPNativePlayerSurfaceCallback mSurfaceCallback;
  
  public TPNativePlayerSurface(SurfaceTexture paramSurfaceTexture)
  {
    super(paramSurfaceTexture);
  }
  
  public void setTPSurfaceCallback(ITPNativePlayerSurfaceCallback paramITPNativePlayerSurfaceCallback)
  {
    this.mSurfaceCallback = paramITPNativePlayerSurfaceCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayerSurface
 * JD-Core Version:    0.7.0.1
 */