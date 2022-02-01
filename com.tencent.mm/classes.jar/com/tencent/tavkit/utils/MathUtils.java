package com.tencent.tavkit.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class MathUtils
{
  public static CGRect rect(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(197675);
    paramCGRect1 = size(paramCGRect1.size, paramCGRect2.size);
    paramCGRect1 = new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
    AppMethodBeat.o(197675);
    return paramCGRect1;
  }
  
  public static CGRect rectFill(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(197681);
    paramCGRect1 = sizeFill(paramCGRect1.size, paramCGRect2.size);
    paramCGRect1 = new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
    AppMethodBeat.o(197681);
    return paramCGRect1;
  }
  
  public static CGRect rectFit(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(197678);
    paramCGRect1 = sizeFit(paramCGRect1.size, paramCGRect2.size);
    paramCGRect1 = new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
    AppMethodBeat.o(197678);
    return paramCGRect1;
  }
  
  public static CGSize size(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(197676);
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 > f1) {
      paramCGSize1.width *= f2;
    }
    for (;;)
    {
      AppMethodBeat.o(197676);
      return localCGSize;
      if (f1 > f2) {
        localCGSize.height = (f1 * paramCGSize1.height);
      }
    }
  }
  
  public static CGSize sizeFill(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(197682);
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 > f1) {
      paramCGSize1.width *= f2;
    }
    for (;;)
    {
      AppMethodBeat.o(197682);
      return localCGSize;
      if (f1 > f2) {
        localCGSize.height = (f1 * paramCGSize1.height);
      }
    }
  }
  
  public static CGSize sizeFit(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(197679);
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 < f1) {
      localCGSize.width = Math.round(paramCGSize1.width * f2);
    }
    for (;;)
    {
      AppMethodBeat.o(197679);
      return localCGSize;
      if (f1 < f2) {
        localCGSize.height = Math.round(f1 * paramCGSize1.height);
      }
    }
  }
  
  public static CGSize sizeScale(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    return paramCGSize2;
  }
  
  public static Matrix transformBySourceRect(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(197674);
    paramCGRect2 = rect(paramCGRect1, paramCGRect2);
    float f1 = paramCGRect2.size.width / paramCGRect1.size.width;
    float f2 = paramCGRect2.size.height / paramCGRect1.size.height;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(paramCGRect2.origin.x - f1 * paramCGRect1.origin.x, paramCGRect2.origin.y - f2 * paramCGRect1.origin.y);
    AppMethodBeat.o(197674);
    return localMatrix;
  }
  
  public static Matrix transformBySourceRectFill(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(197680);
    paramCGRect2 = rectFill(paramCGRect1, paramCGRect2);
    float f1 = paramCGRect2.size.width / paramCGRect1.size.width;
    float f2 = paramCGRect2.size.height / paramCGRect1.size.height;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(paramCGRect2.origin.x - f1 * paramCGRect1.origin.x, paramCGRect2.origin.y - f2 * paramCGRect1.origin.y);
    AppMethodBeat.o(197680);
    return localMatrix;
  }
  
  public static Matrix transformBySourceRectFit(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    AppMethodBeat.i(197677);
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
    AppMethodBeat.o(197677);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.utils.MathUtils
 * JD-Core Version:    0.7.0.1
 */