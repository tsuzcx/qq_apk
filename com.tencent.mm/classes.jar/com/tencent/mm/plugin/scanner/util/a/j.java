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
  private static final int[] Jah = { 480, 448, 320, 240 };
  
  private static byte[] a(String paramString, int paramInt1, int paramInt2, a parama)
  {
    int j = -1;
    AppMethodBeat.i(193572);
    label301:
    for (;;)
    {
      try
      {
        Bitmap localBitmap = fR(paramString, paramInt1);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          if (Math.min(localBitmap.getWidth(), localBitmap.getHeight()) >= paramInt1) {
            break label301;
          }
          i = 100;
          Object localObject = l(localBitmap, i);
          paramString = (String)localObject;
          if (paramInt2 > 0)
          {
            paramString = (String)localObject;
            if (i == 100)
            {
              paramString = (String)localObject;
              if (localObject != null)
              {
                paramString = (String)localObject;
                if (localObject.length > paramInt2) {
                  paramString = l(localBitmap, 70);
                }
              }
            }
          }
          int k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          if (paramString != null)
          {
            paramInt2 = paramString.length;
            Log.i("MicroMsg.ScanImageJpegCompressUtils", "alvinluo compressImage decode bitmap width: %d, height: %d, firstCompressQuality: %d, data: %d, targetSize: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
            localObject = paramString;
            if (paramString != null)
            {
              localObject = paramString;
              if (paramString.length > 122880)
              {
                localObject = paramString;
                if (!localBitmap.isRecycled())
                {
                  localObject = l(localBitmap, 50);
                  paramInt1 = j;
                  if (localObject != null) {
                    paramInt1 = localObject.length;
                  }
                  Log.i("MicroMsg.ScanImageJpegCompressUtils", "alvinluo compressImage compressed data: %d", new Object[] { Integer.valueOf(paramInt1) });
                }
              }
            }
            localBitmap.recycle();
            if (parama != null) {
              parama.a(true, (byte[])localObject);
            }
            AppMethodBeat.o(193572);
            return localObject;
          }
          paramInt2 = -1;
          continue;
        }
        int i = 70;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.ScanImageJpegCompressUtils", paramString, "alvinluo compressImage exception", new Object[0]);
        if (parama != null) {
          parama.a(false, null);
        }
        AppMethodBeat.o(193572);
        return null;
      }
    }
  }
  
  public static byte[] a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(193569);
    byte[] arrayOfByte1 = null;
    int[] arrayOfInt = Jah;
    int j = arrayOfInt.length;
    int i = 0;
    byte[] arrayOfByte2;
    for (;;)
    {
      arrayOfByte2 = arrayOfByte1;
      if (i >= j) {
        break;
      }
      arrayOfByte1 = a(paramString, arrayOfInt[i], paramInt, parama);
      arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null) {
        break;
      }
      if (arrayOfByte1.length <= 122880)
      {
        AppMethodBeat.o(193569);
        return arrayOfByte1;
      }
      i += 1;
    }
    AppMethodBeat.o(193569);
    return arrayOfByte2;
  }
  
  public static byte[] aXF(String paramString)
  {
    AppMethodBeat.i(193568);
    paramString = a(paramString, -1, null);
    AppMethodBeat.o(193568);
    return paramString;
  }
  
  private static Bitmap fR(String paramString, int paramInt)
  {
    AppMethodBeat.i(193576);
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
        AppMethodBeat.o(193576);
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
      AppMethodBeat.o(193576);
    }
  }
  
  private static byte[] l(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(193573);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
      paramBitmap = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      AppMethodBeat.o(193573);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      Log.printErrStackTrace("MicroMsg.ScanImageJpegCompressUtils", paramBitmap, "compressImageByQuality exception", new Object[0]);
      AppMethodBeat.o(193573);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a.j
 * JD-Core Version:    0.7.0.1
 */