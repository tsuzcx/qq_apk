package com.tencent.mm.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

public abstract class c
{
  public static int a(c paramc)
  {
    return paramc.a(0, new Object[0]);
  }
  
  protected static Paint a(Paint paramPaint, Looper paramLooper)
  {
    return b.a(paramLooper, paramPaint);
  }
  
  public static void a(c paramc, Canvas paramCanvas, Looper paramLooper)
  {
    paramc.a(2, new Object[] { paramCanvas, paramLooper });
  }
  
  protected static float[] a(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (paramArrayOfFloat != null)
    {
      paramArrayOfFloat[0] = paramFloat1;
      paramArrayOfFloat[1] = paramFloat2;
      paramArrayOfFloat[2] = paramFloat3;
      paramArrayOfFloat[3] = paramFloat4;
      paramArrayOfFloat[4] = paramFloat5;
      paramArrayOfFloat[5] = paramFloat6;
      paramArrayOfFloat[6] = 0.0F;
      paramArrayOfFloat[7] = 0.0F;
      paramArrayOfFloat[8] = 1.0F;
    }
    return paramArrayOfFloat;
  }
  
  public static int b(c paramc)
  {
    return paramc.a(1, new Object[0]);
  }
  
  protected static float[] i(Looper paramLooper)
  {
    return b.i(paramLooper);
  }
  
  protected static Matrix j(Looper paramLooper)
  {
    return b.j(paramLooper);
  }
  
  protected static void l(Looper paramLooper)
  {
    if (paramLooper != null) {
      b.h(paramLooper);
    }
  }
  
  protected static Paint m(Looper paramLooper)
  {
    return b.a(paramLooper, null);
  }
  
  protected static Path n(Looper paramLooper)
  {
    return b.k(paramLooper);
  }
  
  protected abstract int a(int paramInt, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.c
 * JD-Core Version:    0.7.0.1
 */