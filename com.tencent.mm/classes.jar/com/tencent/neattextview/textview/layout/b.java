package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public abstract interface b
  extends Serializable
{
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat);
  
  public abstract int abD(int paramInt);
  
  public abstract float[] fkX();
  
  public abstract RectF fkY();
  
  public abstract RectF fkZ();
  
  public abstract float fla();
  
  public abstract boolean flb();
  
  public abstract float flc();
  
  public abstract float fld();
  
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