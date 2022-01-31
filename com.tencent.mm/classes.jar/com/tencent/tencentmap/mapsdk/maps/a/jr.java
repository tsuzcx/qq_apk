package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public class jr
{
  protected static Paint a;
  private static final String b;
  
  static
  {
    AppMethodBeat.i(148734);
    b = Bitmap.class.getCanonicalName();
    Paint localPaint = new Paint();
    a = localPaint;
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(148734);
  }
  
  private static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(148731);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      paramConfig = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      }
      catch (OutOfMemoryError paramConfig)
      {
        AppMethodBeat.o(148731);
      }
    }
    AppMethodBeat.o(148731);
    return paramConfig;
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148727);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(148727);
      return null;
    }
    paramBitmap = a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    AppMethodBeat.o(148727);
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(148732);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(148732);
      return paramBitmap;
    }
    if (paramFloat == 1.0F)
    {
      AppMethodBeat.o(148732);
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
    AppMethodBeat.o(148732);
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148728);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(148728);
      return null;
    }
    Bitmap localBitmap = a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.setDensity(paramBitmap.getDensity());
    if (localBitmap == null)
    {
      AppMethodBeat.o(148728);
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    localBitmap.eraseColor(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, a);
    AppMethodBeat.o(148728);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148729);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(148729);
      return null;
    }
    int i = paramInt1;
    if (paramInt1 > 2048) {
      i = 2048;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > 2048) {
      paramInt1 = 2048;
    }
    Bitmap localBitmap = a(i, paramInt1, Bitmap.Config.ARGB_8888);
    if (localBitmap == null)
    {
      AppMethodBeat.o(148729);
      return null;
    }
    localBitmap.eraseColor(0);
    Canvas localCanvas = new Canvas(localBitmap);
    paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
    paramBitmap.setBounds(0, 0, i, paramInt1);
    paramBitmap.draw(localCanvas);
    AppMethodBeat.o(148729);
    return localBitmap;
  }
  
  public static Bitmap a(View paramView)
  {
    AppMethodBeat.i(148726);
    if (paramView != null) {
      try
      {
        try
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
          paramView.setDrawingCacheEnabled(true);
          paramView.buildDrawingCache();
          Bitmap localBitmap = a(paramView.getDrawingCache());
          paramView.destroyDrawingCache();
          return localBitmap;
        }
        finally
        {
          AppMethodBeat.o(148726);
        }
        AppMethodBeat.o(148726);
      }
      catch (Throwable paramView)
      {
        new StringBuilder("BitmapUtil.convertToBitmap errorDetail:").append(Log.getStackTraceString(paramView));
      }
    }
    return null;
  }
  
  public static byte[] a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(148733);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(148733);
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(paramCompressFormat, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(148733);
    return paramBitmap;
  }
  
  public static Drawable b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148730);
    paramBitmap = new BitmapDrawable(paramBitmap);
    AppMethodBeat.o(148730);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jr
 * JD-Core Version:    0.7.0.1
 */