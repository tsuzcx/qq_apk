package com.tencent.scanlib.a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;

public abstract interface f
{
  public abstract void a(Camera.AutoFocusCallback paramAutoFocusCallback);
  
  public abstract void aHb(int paramInt);
  
  public abstract void auq();
  
  public abstract void bFD(String paramString);
  
  public abstract boolean boa();
  
  public abstract void c(Camera.PreviewCallback paramPreviewCallback);
  
  public abstract void close();
  
  public abstract int getCameraRotation();
  
  public abstract boolean isOpen();
  
  public abstract Point jXF();
  
  public abstract Point jXG();
  
  public abstract float jXH();
  
  public abstract String jXJ();
  
  public abstract void q(Point paramPoint);
  
  public abstract void w(SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.scanlib.a.f
 * JD-Core Version:    0.7.0.1
 */