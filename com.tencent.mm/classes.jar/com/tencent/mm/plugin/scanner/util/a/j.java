package com.tencent.mm.plugin.scanner.util.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

public final class j
{
  private static final int[] PjZ = { 480, 448, 320, 240 };
  
  private static byte[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, a parama)
  {
    int i = -1;
    AppMethodBeat.i(314184);
    label306:
    for (;;)
    {
      try
      {
        paramString = gK(paramString, paramInt2);
        if ((paramString != null) && (!paramString.isRecycled()))
        {
          Bitmap localBitmap = BitmapUtil.rotate(paramString, paramInt1);
          if (Math.min(localBitmap.getWidth(), localBitmap.getHeight()) >= paramInt2) {
            break label306;
          }
          paramInt1 = 100;
          Object localObject = k(localBitmap, paramInt1);
          paramString = (String)localObject;
          if (paramInt3 > 0)
          {
            paramString = (String)localObject;
            if (paramInt1 == 100)
            {
              paramString = (String)localObject;
              if (localObject != null)
              {
                paramString = (String)localObject;
                if (localObject.length > paramInt3) {
                  paramString = k(localBitmap, 70);
                }
              }
            }
          }
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          if (paramString != null)
          {
            paramInt3 = paramString.length;
            Log.i("MicroMsg.ScanImageJpegCompressUtils", "alvinluo compressImage decode bitmap width: %d, height: %d, firstCompressQuality: %d, data: %d, targetSize: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
            localObject = paramString;
            if (paramString != null)
            {
              localObject = paramString;
              if (paramString.length > 122880)
              {
                localObject = paramString;
                if (!localBitmap.isRecycled())
                {
                  localObject = k(localBitmap, 50);
                  paramInt1 = i;
                  if (localObject != null) {
                    paramInt1 = localObject.length;
                  }
                  Log.i("MicroMsg.ScanImageJpegCompressUtils", "alvinluo compressImage compressed data: %d", new Object[] { Integer.valueOf(paramInt1) });
                }
              }
            }
            localBitmap.recycle();
            if (parama != null) {
              parama.onCompressEnd(true, (byte[])localObject);
            }
            AppMethodBeat.o(314184);
            return localObject;
          }
          paramInt3 = -1;
          continue;
        }
        paramInt1 = 70;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.ScanImageJpegCompressUtils", paramString, "alvinluo compressImage exception", new Object[0]);
        if (parama != null) {
          parama.onCompressEnd(false, null);
        }
        AppMethodBeat.o(314184);
        return null;
      }
    }
  }
  
  public static byte[] a(String paramString, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(314179);
    byte[] arrayOfByte1 = null;
    int[] arrayOfInt = PjZ;
    int j = arrayOfInt.length;
    int i = 0;
    byte[] arrayOfByte2;
    for (;;)
    {
      arrayOfByte2 = arrayOfByte1;
      if (i >= j) {
        break;
      }
      arrayOfByte1 = a(paramString, paramInt1, arrayOfInt[i], paramInt2, parama);
      arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null) {
        break;
      }
      if (arrayOfByte1.length <= 122880)
      {
        AppMethodBeat.o(314179);
        return arrayOfByte1;
      }
      i += 1;
    }
    AppMethodBeat.o(314179);
    return arrayOfByte2;
  }
  
  public static byte[] a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(314170);
    paramString = a(paramString, 0, paramInt, parama);
    AppMethodBeat.o(314170);
    return paramString;
  }
  
  public static byte[] aVo(String paramString)
  {
    AppMethodBeat.i(314162);
    paramString = a(paramString, 0, -1, null);
    AppMethodBeat.o(314162);
    return paramString;
  }
  
  private static Bitmap gK(String paramString, int paramInt)
  {
    AppMethodBeat.i(314201);
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int i = ((BitmapFactory.Options)localObject).outWidth;
      int j = ((BitmapFactory.Options)localObject).outHeight;
      if (i > j) {
        i = (int)(i * 1.0F * paramInt / j);
      }
      for (;;)
      {
        Point localPoint = new Point(i, paramInt);
        paramInt = localPoint.x;
        i = localPoint.y;
        ((BitmapFactory.Options)localObject).inSampleSize = BitmapUtil.calculateInSampleSize(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, paramInt, i);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        Log.i("MicroMsg.ScanImageJpegCompressUtils", "alvinluo resizeImage width: %d, height: %d, targetWidth: %d, targetHeight: %d, sampleSize: %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(((BitmapFactory.Options)localObject).inSampleSize) });
        localObject = BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject);
        paramString = (String)localObject;
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (!((Bitmap)localObject).isRecycled())
          {
            paramString = (String)localObject;
            if (((Bitmap)localObject).getWidth() > paramInt) {
              paramString = BitmapUtil.extractThumbNail((Bitmap)localObject, i, paramInt, false, true);
            }
          }
        }
        AppMethodBeat.o(314201);
        return paramString;
        j = (int)(j * 1.0F * paramInt / i);
        i = paramInt;
        paramInt = j;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScanImageJpegCompressUtils", paramString, "alvinluo resizeImage exception", new Object[0]);
      AppMethodBeat.o(314201);
    }
  }
  
  private static byte[] k(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(314190);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
      paramBitmap = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      AppMethodBeat.o(314190);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      Log.printErrStackTrace("MicroMsg.ScanImageJpegCompressUtils", paramBitmap, "compressImageByQuality exception", new Object[0]);
      AppMethodBeat.o(314190);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void onCompressEnd(boolean paramBoolean, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a.j
 * JD-Core Version:    0.7.0.1
 */