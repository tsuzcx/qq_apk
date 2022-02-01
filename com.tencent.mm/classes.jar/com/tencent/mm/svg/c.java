package com.tencent.mm.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

public abstract class c
{
  public static final int GetHeight = 1;
  public static final int GetWidth = 0;
  public static final int Render = 2;
  
  protected static void done(Looper paramLooper)
  {
    if (paramLooper != null) {
      b.k(paramLooper);
    }
  }
  
  public static int getHeight(c paramc)
  {
    return paramc.doCommand(1, new Object[0]);
  }
  
  public static int getWidth(c paramc)
  {
    return paramc.doCommand(0, new Object[0]);
  }
  
  protected static Matrix instanceMatrix(Looper paramLooper)
  {
    return b.instanceMatrix(paramLooper);
  }
  
  protected static float[] instanceMatrixArray(Looper paramLooper)
  {
    return b.instanceMatrixArray(paramLooper);
  }
  
  protected static Paint instancePaint(Paint paramPaint, Looper paramLooper)
  {
    return b.a(paramLooper, paramPaint);
  }
  
  protected static Paint instancePaint(Looper paramLooper)
  {
    return b.a(paramLooper, null);
  }
  
  protected static Path instancePath(Path paramPath, Looper paramLooper)
  {
    return b.a(paramLooper, paramPath);
  }
  
  protected static Path instancePath(Looper paramLooper)
  {
    return b.a(paramLooper, null);
  }
  
  public static void render(c paramc, Canvas paramCanvas, Looper paramLooper)
  {
    paramc.doCommand(2, new Object[] { paramCanvas, paramLooper });
  }
  
  protected static float[] setMatrixFloatArray(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    if (paramArrayOfFloat != null)
    {
      paramArrayOfFloat[0] = paramFloat1;
      paramArrayOfFloat[1] = paramFloat2;
      paramArrayOfFloat[2] = paramFloat3;
      paramArrayOfFloat[3] = paramFloat4;
      paramArrayOfFloat[4] = paramFloat5;
      paramArrayOfFloat[5] = paramFloat6;
      paramArrayOfFloat[6] = paramFloat7;
      paramArrayOfFloat[7] = paramFloat8;
      paramArrayOfFloat[8] = paramFloat9;
    }
    return paramArrayOfFloat;
  }
  
  protected abstract int doCommand(int paramInt, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.svg.c
 * JD-Core Version:    0.7.0.1
 */