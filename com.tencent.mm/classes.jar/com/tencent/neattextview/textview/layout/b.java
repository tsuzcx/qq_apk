package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public abstract interface b
  extends Serializable
{
  public abstract void a(Canvas paramCanvas, TextPaint paramTextPaint, float paramFloat);
  
  public abstract int aGO(int paramInt);
  
  public abstract float dv(int paramInt);
  
  public abstract int getEnd();
  
  public abstract float getHeight();
  
  public abstract int getStart();
  
  public abstract float getWidth();
  
  public abstract float[] jQJ();
  
  public abstract RectF jQK();
  
  public abstract RectF jQL();
  
  public abstract float jQM();
  
  public abstract boolean jQN();
  
  public abstract float jQO();
  
  public abstract float jQP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.b
 * JD-Core Version:    0.7.0.1
 */