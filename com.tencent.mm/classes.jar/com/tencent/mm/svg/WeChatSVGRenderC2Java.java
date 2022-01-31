package com.tencent.mm.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatSVGRenderC2Java
{
  public static void addPath(Path paramPath1, Matrix paramMatrix, Path paramPath2, boolean paramBoolean)
  {
    AppMethodBeat.i(70068);
    if (paramBoolean) {
      paramPath1.setFillType(paramPath2.getFillType());
    }
    paramPath1.addPath(paramPath2, paramMatrix);
    AppMethodBeat.o(70068);
  }
  
  public static void addTextPath(Paint paramPaint, Path paramPath, String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(70071);
    Path localPath = new Path();
    paramPaint.getTextPath(paramString, 0, paramString.length(), paramFloat1, paramFloat2, localPath);
    paramPath.addPath(localPath);
    AppMethodBeat.o(70071);
  }
  
  public static Bitmap checkForImageDataURL(String paramString)
  {
    return null;
  }
  
  public static float[] computePathBound(Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(70072);
    if (paramMatrix != null) {
      paramPath.transform(paramMatrix);
    }
    paramMatrix = new RectF();
    paramPath.computeBounds(paramMatrix, true);
    float f1 = paramMatrix.left;
    float f2 = paramMatrix.top;
    float f3 = paramMatrix.right;
    float f4 = paramMatrix.bottom;
    AppMethodBeat.o(70072);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static void doNonScalingStroke(Canvas paramCanvas, Path paramPath, Paint paramPaint)
  {
    AppMethodBeat.i(70065);
    Matrix localMatrix1 = paramCanvas.getMatrix();
    Path localPath = new Path();
    paramPath.transform(localMatrix1, localPath);
    paramCanvas.setMatrix(new Matrix());
    paramPath = paramPaint.getShader();
    Matrix localMatrix2 = new Matrix();
    if (paramPath != null)
    {
      paramPath.getLocalMatrix(localMatrix2);
      Matrix localMatrix3 = new Matrix(localMatrix2);
      localMatrix3.postConcat(localMatrix1);
      paramPath.setLocalMatrix(localMatrix3);
    }
    paramCanvas.drawPath(localPath, paramPaint);
    paramCanvas.setMatrix(localMatrix1);
    if (paramPath != null) {
      paramPath.setLocalMatrix(localMatrix2);
    }
    AppMethodBeat.o(70065);
  }
  
  public static float getPathMeasureLength(Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(70069);
    if (paramMatrix != null) {
      paramPath.transform(paramMatrix);
    }
    float f = new PathMeasure(paramPath, false).getLength();
    AppMethodBeat.o(70069);
    return f;
  }
  
  public static float[] getTextBounds(Paint paramPaint, String paramString)
  {
    AppMethodBeat.i(70073);
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    paramPaint = new RectF(localRect);
    float f1 = paramPaint.left;
    float f2 = paramPaint.top;
    float f3 = paramPaint.right;
    float f4 = paramPaint.bottom;
    AppMethodBeat.o(70073);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static void invert(Matrix paramMatrix1, Matrix paramMatrix2)
  {
    AppMethodBeat.i(70064);
    paramMatrix1.invert(paramMatrix2);
    AppMethodBeat.o(70064);
  }
  
  public static void setFillType(Path paramPath, int paramInt)
  {
    AppMethodBeat.i(70070);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(70070);
      return;
      paramPath.setFillType(Path.FillType.WINDING);
      AppMethodBeat.o(70070);
      return;
      paramPath.setFillType(Path.FillType.EVEN_ODD);
    }
  }
  
  public static void setLinearGradient(Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfInt, float[] paramArrayOfFloat, Matrix paramMatrix, int paramInt)
  {
    AppMethodBeat.i(70067);
    Shader.TileMode localTileMode2 = Shader.TileMode.CLAMP;
    Shader.TileMode localTileMode1 = localTileMode2;
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        break label70;
      }
      localTileMode1 = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      paramArrayOfInt = new LinearGradient(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramArrayOfInt, paramArrayOfFloat, localTileMode1);
      paramArrayOfInt.setLocalMatrix(paramMatrix);
      paramPaint.setShader(paramArrayOfInt);
      AppMethodBeat.o(70067);
      return;
      label70:
      localTileMode1 = localTileMode2;
      if (paramInt == 3) {
        localTileMode1 = Shader.TileMode.REPEAT;
      }
    }
  }
  
  public static void setRadialGradient(Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, int[] paramArrayOfInt, float[] paramArrayOfFloat, Matrix paramMatrix, int paramInt)
  {
    AppMethodBeat.i(70066);
    Shader.TileMode localTileMode2 = Shader.TileMode.CLAMP;
    Shader.TileMode localTileMode1 = localTileMode2;
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        break label68;
      }
      localTileMode1 = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      paramArrayOfInt = new RadialGradient(paramFloat1, paramFloat2, paramFloat3, paramArrayOfInt, paramArrayOfFloat, localTileMode1);
      paramArrayOfInt.setLocalMatrix(paramMatrix);
      paramPaint.setShader(paramArrayOfInt);
      AppMethodBeat.o(70066);
      return;
      label68:
      localTileMode1 = localTileMode2;
      if (paramInt == 3) {
        localTileMode1 = Shader.TileMode.REPEAT;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.svg.WeChatSVGRenderC2Java
 * JD-Core Version:    0.7.0.1
 */