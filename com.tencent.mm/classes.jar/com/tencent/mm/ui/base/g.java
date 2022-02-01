package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import android.graphics.PointF;

public abstract interface g
{
  public abstract PointF a(PointF paramPointF, int paramInt1, int paramInt2);
  
  public abstract void at(float paramFloat1, float paramFloat2);
  
  public abstract void au(float paramFloat1, float paramFloat2);
  
  public abstract PointF c(PointF paramPointF);
  
  public abstract void gKA();
  
  public abstract void gKB();
  
  public abstract boolean gKw();
  
  public abstract boolean gKx();
  
  public abstract void gKy();
  
  public abstract void gKz();
  
  public abstract float getDoubleTabScale();
  
  public abstract int getImageHeight();
  
  public abstract Matrix getImageMatrix();
  
  public abstract PointF getImageViewMatrixScale();
  
  public abstract PointF getImageViewMatrixTranslation();
  
  public abstract int getImageWidth();
  
  public abstract float getScale();
  
  public abstract float getScaleRate();
  
  public abstract void l(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void r(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setCustomScaleRate(Float paramFloat);
  
  public abstract void setImageViewMatrix(Matrix paramMatrix);
  
  public abstract void setMaxZoomLimit(float paramFloat);
  
  public abstract void setOnZoomScaleChangedListener(g.a parama);
  
  public abstract float y(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.g
 * JD-Core Version:    0.7.0.1
 */