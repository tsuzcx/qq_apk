package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public abstract interface a
  extends Serializable
{
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat);
  
  public abstract float[] cNG();
  
  public abstract RectF cNH();
  
  public abstract float cNI();
  
  public abstract boolean cNJ();
  
  public abstract float cNK();
  
  public abstract int getEnd();
  
  public abstract float getHeight();
  
  public abstract int getStart();
  
  public abstract float getWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.a
 * JD-Core Version:    0.7.0.1
 */