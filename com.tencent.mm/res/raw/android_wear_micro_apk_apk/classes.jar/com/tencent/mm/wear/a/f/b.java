package com.tencent.mm.wear.a.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.DisplayMetrics;
import com.tencent.mm.wear.app.MMApplication;
import java.io.InputStream;

public final class b
{
  private static DisplayMetrics amN = null;
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    paramContext = RenderScript.create(paramContext);
    Allocation localAllocation = Allocation.createFromBitmap(paramContext, paramBitmap);
    ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(paramContext, localAllocation.getElement());
    localScriptIntrinsicBlur.setRadius(paramInt);
    localScriptIntrinsicBlur.setInput(localAllocation);
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    localAllocation = Allocation.createFromBitmap(paramContext, paramBitmap);
    localScriptIntrinsicBlur.forEach(localAllocation);
    localAllocation.copyTo(paramBitmap);
    paramContext.destroy();
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888, false);
    } while (localBitmap == null);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public static Bitmap a(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      try
      {
        paramInputStream = BitmapFactory.decodeStream(paramInputStream, null, localOptions);
        return paramInputStream;
      }
      catch (OutOfMemoryError paramInputStream) {}
    }
    return null;
  }
  
  public static Bitmap c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    if ((i > paramInt1) || (j > paramInt2)) {
      localOptions.inSampleSize = ((int)Math.max(i / paramInt1, j / paramInt2));
    }
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
  }
  
  private static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (IncompatibleClassChangeError paramConfig)
    {
      throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(paramConfig));
    }
    catch (Throwable paramConfig)
    {
      try
      {
        if (amN == null) {
          amN = MMApplication.getContext().getResources().getDisplayMetrics();
        }
        paramConfig = amN;
        int j = paramInt1;
        int i = paramInt2;
        if (paramInt1 > paramConfig.widthPixels)
        {
          j = paramInt1;
          i = paramInt2;
          if (paramInt2 > paramConfig.heightPixels)
          {
            j = paramConfig.widthPixels;
            i = paramConfig.heightPixels;
          }
        }
        paramConfig = Bitmap.createBitmap(j, i, Bitmap.Config.RGB_565);
        return paramConfig;
      }
      catch (IncompatibleClassChangeError paramConfig)
      {
        throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(paramConfig));
      }
      catch (Throwable paramConfig) {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.f.b
 * JD-Core Version:    0.7.0.1
 */