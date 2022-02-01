package com.tencent.tav.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class CGMathFunctions
{
  public static CGRect initGLViewportDefault(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(215469);
    paramCGSize1 = new CGRect(new PointF((paramCGSize1.width - paramCGSize2.width) / 2.0F, (paramCGSize1.height - paramCGSize2.height) / 2.0F), paramCGSize2);
    AppMethodBeat.o(215469);
    return paramCGSize1;
  }
  
  public static CGRect initGLViewportFill(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(215476);
    float f2 = paramCGSize2.height;
    float f3 = paramCGSize2.width;
    float f4 = paramCGSize1.height;
    float f1 = paramCGSize1.width;
    if (f1 / f4 > f3 / f2)
    {
      f3 = f2 * f1 / f3;
      f2 = (f4 - f3) / 2.0F;
      float f5 = 0.0F;
      f4 = f3;
      f3 = f5;
    }
    for (;;)
    {
      paramCGSize1 = new CGRect(new PointF(f3, f2), new CGSize(f1, f4));
      AppMethodBeat.o(215476);
      return paramCGSize1;
      f2 = f3 * f4 / f2;
      f3 = (f1 - f2) / 2.0F;
      f1 = f2;
      f2 = 0.0F;
    }
  }
  
  public static CGRect initGLViewportFit(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(215485);
    float f1 = paramCGSize2.height;
    float f3 = paramCGSize2.width;
    float f4 = paramCGSize1.height;
    float f2 = paramCGSize1.width;
    if (f2 / f4 > f3 / f1)
    {
      f1 = f3 * f4 / f1;
      f3 = (f2 - f1) / 2.0F;
      f2 = 0.0F;
    }
    for (;;)
    {
      paramCGSize1 = new CGRect(new PointF(f3, f2), new CGSize(f1, f4));
      AppMethodBeat.o(215485);
      return paramCGSize1;
      float f6 = f1 * f2 / f3;
      f3 = (f4 - f6) / 2.0F;
      f1 = f2;
      float f5 = 0.0F;
      f4 = f6;
      f2 = f3;
      f3 = f5;
    }
  }
  
  private static CGRect rectFill(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(215451);
    paramCGRect1 = sizeFill(paramCGRect1.size, paramCGRect2.size);
    paramCGRect1 = new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
    AppMethodBeat.o(215451);
    return paramCGRect1;
  }
  
  private static CGRect rectFit(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(215436);
    paramCGRect1 = sizeFit(paramCGRect1.size, paramCGRect2.size);
    paramCGRect1 = new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
    AppMethodBeat.o(215436);
    return paramCGRect1;
  }
  
  private static CGSize sizeFill(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(215455);
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 > f1) {
      paramCGSize1.width *= f2;
    }
    for (;;)
    {
      AppMethodBeat.o(215455);
      return localCGSize;
      if (f1 > f2) {
        localCGSize.height = (f1 * paramCGSize1.height);
      }
    }
  }
  
  static CGSize sizeFit(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(215440);
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 < f1) {
      localCGSize.width = Math.round(paramCGSize1.width * f2);
    }
    for (;;)
    {
      AppMethodBeat.o(215440);
      return localCGSize;
      if (f1 < f2) {
        localCGSize.height = Math.round(f1 * paramCGSize1.height);
      }
    }
  }
  
  public static Matrix transformByScaleFitRect(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(215461);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramCGRect2.size.width / paramCGRect1.size.width, paramCGRect2.size.height / paramCGRect1.size.height);
    AppMethodBeat.o(215461);
    return localMatrix;
  }
  
  public static Matrix transformBySourceRectFill(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(215446);
    paramCGRect2 = rectFill(paramCGRect1, paramCGRect2);
    float f1 = paramCGRect2.size.width / paramCGRect1.size.width;
    float f2 = paramCGRect2.size.height / paramCGRect1.size.height;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(paramCGRect2.origin.x - f1 * paramCGRect1.origin.x, paramCGRect2.origin.y - f2 * paramCGRect1.origin.y);
    AppMethodBeat.o(215446);
    return localMatrix;
  }
  
  public static Matrix transformBySourceRectFit(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(215429);
    paramCGRect2 = rectFit(paramCGRect1, paramCGRect2);
    float f1 = paramCGRect2.size.width / paramCGRect1.size.width;
    float f2 = paramCGRect2.size.height / paramCGRect1.size.height;
    Matrix localMatrix = new Matrix();
    float f3 = paramCGRect2.origin.x;
    float f4 = paramCGRect1.origin.x;
    float f5 = paramCGRect2.origin.y;
    float f6 = paramCGRect1.origin.y;
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(f3 - f4 * f1, f5 - f6 * f2);
    AppMethodBeat.o(215429);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.CGMathFunctions
 * JD-Core Version:    0.7.0.1
 */