package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import android.graphics.PointF;

public abstract interface g
{
  public abstract float A(float paramFloat1, float paramFloat2);
  
  public abstract PointF a(PointF paramPointF, int paramInt1, int paramInt2);
  
  public abstract void ay(float paramFloat1, float paramFloat2);
  
  public abstract void az(float paramFloat1, float paramFloat2);
  
  public abstract PointF d(PointF paramPointF);
  
  public abstract float getDoubleTabScale();
  
  public abstract int getImageHeight();
  
  public abstract Matrix getImageMatrix();
  
  public abstract PointF getImageViewMatrixScale();
  
  public abstract PointF getImageViewMatrixTranslation();
  
  public abstract int getImageWidth();
  
  public abstract float getScale();
  
  public abstract float getScaleRate();
  
  public abstract void hJA();
  
  public abstract boolean hJv();
  
  public abstract boolean hJw();
  
  public abstract void hJx();
  
  public abstract void hJy();
  
  public abstract void hJz();
  
  public abstract void m(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void s(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setCanRefresh(boolean paramBoolean);
  
  public abstract void setCustomScaleRate(Float paramFloat);
  
  public abstract void setImageViewMatrix(Matrix paramMatrix);
  
  public abstract void setMaxZoomLimit(float paramFloat);
  
  public abstract void setOnZoomScaleChangedListener(a parama);
  
  public static abstract interface a
  {
    public abstract void ak(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.g
 * JD-Core Version:    0.7.0.1
 */