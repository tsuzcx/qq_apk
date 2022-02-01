package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import android.graphics.PointF;

public abstract interface i
{
  public abstract PointF a(PointF paramPointF, int paramInt1, int paramInt2);
  
  public abstract float ag(float paramFloat1, float paramFloat2);
  
  public abstract void bd(float paramFloat1, float paramFloat2);
  
  public abstract void be(float paramFloat1, float paramFloat2);
  
  public abstract PointF c(PointF paramPointF);
  
  public abstract float getDoubleTabScale();
  
  public abstract int getImageHeight();
  
  public abstract Matrix getImageMatrix();
  
  public abstract PointF getImageViewMatrixScale();
  
  public abstract PointF getImageViewMatrixTranslation();
  
  public abstract int getImageWidth();
  
  public abstract float getScale();
  
  public abstract float getScaleRate();
  
  public abstract boolean jlY();
  
  public abstract boolean jlZ();
  
  public abstract void jma();
  
  public abstract void jmb();
  
  public abstract void jmc();
  
  public abstract void jmd();
  
  public abstract void setCanRefresh(boolean paramBoolean);
  
  public abstract void setCustomScaleRate(Float paramFloat);
  
  public abstract void setImageViewMatrix(Matrix paramMatrix);
  
  public abstract void setMaxZoomLimit(float paramFloat);
  
  public abstract void setOnZoomScaleChangedListener(a parama);
  
  public abstract void x(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void zoomToWithAnimation(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public static abstract interface a
  {
    public abstract void onScaleChanged(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.i
 * JD-Core Version:    0.7.0.1
 */