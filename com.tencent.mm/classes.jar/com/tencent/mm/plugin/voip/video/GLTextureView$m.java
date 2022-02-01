package com.tencent.mm.plugin.voip.video;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract interface GLTextureView$m
{
  public abstract void onDrawFrame(GL10 paramGL10);
  
  public abstract void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2);
  
  public abstract void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.GLTextureView.m
 * JD-Core Version:    0.7.0.1
 */