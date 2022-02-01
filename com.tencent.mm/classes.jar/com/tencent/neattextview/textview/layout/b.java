package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public abstract interface b
  extends Serializable
{
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat);
  
  public abstract int aqs(int paramInt);
  
  public abstract int getEnd();
  
  public abstract float getHeight();
  
  public abstract float getPrimaryHorizontal(int paramInt);
  
  public abstract int getStart();
  
  public abstract float getWidth();
  
  public abstract float[] hiI();
  
  public abstract RectF hiJ();
  
  public abstract RectF hiK();
  
  public abstract float hiL();
  
  public abstract boolean hiM();
  
  public abstract float hiN();
  
  public abstract float hiO();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.b
 * JD-Core Version:    0.7.0.1
 */