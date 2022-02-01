package com.tencent.tav.coremedia;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Transform
{
  public float degrees = 0.0F;
  public final float scaleX;
  public final float scaleY;
  public final float translateX;
  public final float translateY;
  
  public Transform(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    this.translateX = paramFloat3;
    this.translateY = paramFloat4;
    this.degrees = paramFloat5;
  }
  
  public static Transform instanceFromScale(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(203151);
    Transform localTransform = new Transform(paramFloat1, paramFloat2, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(203151);
    return localTransform;
  }
  
  public static Transform instanceFromTranslate(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(203152);
    Transform localTransform = new Transform(1.0F, 1.0F, paramFloat1, paramFloat2, 0.0F);
    AppMethodBeat.o(203152);
    return localTransform;
  }
  
  public Matrix toMatrix()
  {
    AppMethodBeat.i(203155);
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(this.degrees);
    localMatrix.postScale(this.scaleX, this.scaleY);
    localMatrix.postTranslate(this.translateX, this.translateY);
    AppMethodBeat.o(203155);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.Transform
 * JD-Core Version:    0.7.0.1
 */