package com.tencent.scanlib.a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;

public abstract interface f
{
  public abstract void a(Camera.PreviewCallback paramPreviewCallback);
  
  public abstract void ahq(int paramInt);
  
  public abstract void autoFocus(Camera.AutoFocusCallback paramAutoFocusCallback);
  
  public abstract boolean cOB();
  
  public abstract void close();
  
  public abstract Point fYJ();
  
  public abstract Point fYK();
  
  public abstract float fYL();
  
  public abstract int getCameraRotation();
  
  public abstract String getFocusMode();
  
  public abstract boolean isOpen();
  
  public abstract void m(Point paramPoint);
  
  public abstract void p(SurfaceTexture paramSurfaceTexture);
  
  public abstract void setFocusMode(String paramString);
  
  public abstract void stopPreview();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.a.f
 * JD-Core Version:    0.7.0.1
 */