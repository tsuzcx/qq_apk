package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public abstract interface b
  extends Serializable
{
  public abstract int RZ(int paramInt);
  
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat);
  
  public abstract float[] dTq();
  
  public abstract RectF dTr();
  
  public abstract RectF dTs();
  
  public abstract float dTt();
  
  public abstract boolean dTu();
  
  public abstract float dTv();
  
  public abstract float dTw();
  
  public abstract int getEnd();
  
  public abstract float getHeight();
  
  public abstract float getPrimaryHorizontal(int paramInt);
  
  public abstract int getStart();
  
  public abstract float getWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.b
 * JD-Core Version:    0.7.0.1
 */