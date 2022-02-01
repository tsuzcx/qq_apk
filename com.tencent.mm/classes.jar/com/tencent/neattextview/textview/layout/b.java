package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public abstract interface b
  extends Serializable
{
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat);
  
  public abstract int aAb(int paramInt);
  
  public abstract float azU(int paramInt);
  
  public abstract int getEnd();
  
  public abstract float getHeight();
  
  public abstract int getStart();
  
  public abstract float getWidth();
  
  public abstract float[] ikr();
  
  public abstract RectF iks();
  
  public abstract RectF ikt();
  
  public abstract float iku();
  
  public abstract boolean ikv();
  
  public abstract float ikw();
  
  public abstract float ikx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.b
 * JD-Core Version:    0.7.0.1
 */