package com.tencent.scanlib.a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;

public abstract interface f
{
  public abstract void TL();
  
  public abstract void a(Camera.AutoFocusCallback paramAutoFocusCallback);
  
  public abstract void aAq(int paramInt);
  
  public abstract void bCY(String paramString);
  
  public abstract void c(Camera.PreviewCallback paramPreviewCallback);
  
  public abstract void close();
  
  public abstract boolean egx();
  
  public abstract int getCameraRotation();
  
  public abstract Point ios();
  
  public abstract Point iot();
  
  public abstract float iou();
  
  public abstract String iow();
  
  public abstract boolean isOpen();
  
  public abstract void o(Point paramPoint);
  
  public abstract void u(SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.scanlib.a.f
 * JD-Core Version:    0.7.0.1
 */