package com.tencent.tavkit.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class MathUtils
{
  private static CGRect rect(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(204800);
    paramCGRect1 = size(paramCGRect1.size, paramCGRect2.size);
    paramCGRect1 = new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
    AppMethodBeat.o(204800);
    return paramCGRect1;
  }
  
  private static CGRect rectFill(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(204806);
    paramCGRect1 = sizeFill(paramCGRect1.size, paramCGRect2.size);
    paramCGRect1 = new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
    AppMethodBeat.o(204806);
    return paramCGRect1;
  }
  
  private static CGRect rectFit(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(204803);
    paramCGRect1 = sizeFit(paramCGRect1.size, paramCGRect2.size);
    paramCGRect1 = new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
    AppMethodBeat.o(204803);
    return paramCGRect1;
  }
  
  private static CGSize size(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(204801);
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 > f1) {
      paramCGSize1.width *= f2;
    }
    for (;;)
    {
      AppMethodBeat.o(204801);
      return localCGSize;
      if (f1 > f2) {
        localCGSize.height = (f1 * paramCGSize1.height);
      }
    }
  }
  
  private static CGSize sizeFill(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(204807);
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 > f1) {
      paramCGSize1.width *= f2;
    }
    for (;;)
    {
      AppMethodBeat.o(204807);
      return localCGSize;
      if (f1 > f2) {
        localCGSize.height = (f1 * paramCGSize1.height);
      }
    }
  }
  
  private static CGSize sizeFit(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(204804);
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 < f1) {
      localCGSize.width = Math.round(paramCGSize1.width * f2);
    }
    for (;;)
    {
      AppMethodBeat.o(204804);
      return localCGSize;
      if (f1 < f2) {
        localCGSize.height = Math.round(f1 * paramCGSize1.height);
      }
    }
  }
  
  public static Matrix transformBySourceRect(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(204799);
    paramCGRect2 = rect(paramCGRect1, paramCGRect2);
    float f1 = paramCGRect2.size.width / paramCGRect1.size.width;
    float f2 = paramCGRect2.size.height / paramCGRect1.size.height;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(paramCGRect2.origin.x - f1 * paramCGRect1.origin.x, paramCGRect2.origin.y - f2 * paramCGRect1.origin.y);
    AppMethodBeat.o(204799);
    return localMatrix;
  }
  
  public static Matrix transformBySourceRectFill(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(204805);
    paramCGRect2 = rectFill(paramCGRect1, paramCGRect2);
    float f1 = paramCGRect2.size.width / paramCGRect1.size.width;
    float f2 = paramCGRect2.size.height / paramCGRect1.size.height;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(paramCGRect2.origin.x - f1 * paramCGRect1.origin.x, paramCGRect2.origin.y - f2 * paramCGRect1.origin.y);
    AppMethodBeat.o(204805);
    return localMatrix;
  }
  
  public static Matrix transformBySourceRectFit(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(204802);
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
    AppMethodBeat.o(204802);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.utils.MathUtils
 * JD-Core Version:    0.7.0.1
 */