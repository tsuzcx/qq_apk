package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import java.io.ByteArrayOutputStream;

public final class p
{
  private static final int[] FaY = { 480, 448, 320, 240 };
  
  private static byte[] a(String paramString, int paramInt1, int paramInt2, a parama)
  {
    int j = -1;
    AppMethodBeat.i(224243);
    label301:
    for (;;)
    {
      try
      {
        Bitmap localBitmap = eU(paramString, paramInt1);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          if (Math.min(localBitmap.getWidth(), localBitmap.getHeight()) >= paramInt1) {
            break label301;
          }
          i = 100;
          Object localObject = m(localBitmap, i);
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
                  paramString = m(localBitmap, 70);
                }
              }
            }
          }
          int k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          if (paramString != null)
          {
            paramInt2 = paramString.length;
            ae.i("MicroMsg.ScanImageCompressUtils", "alvinluo compressImage decode bitmap width: %d, height: %d, firstCompressQuality: %d, data: %d, targetSize: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
            localObject = paramString;
            if (paramString != null)
            {
              localObject = paramString;
              if (paramString.length > 122880)
              {
                localObject = paramString;
                if (!localBitmap.isRecycled())
                {
                  localObject = m(localBitmap, 50);
                  paramInt1 = j;
                  if (localObject != null) {
                    paramInt1 = localObject.length;
                  }
                  ae.i("MicroMsg.ScanImageCompressUtils", "alvinluo compressImage compressed data: %d", new Object[] { Integer.valueOf(paramInt1) });
                }
              }
            }
            localBitmap.recycle();
            if (parama != null) {
              parama.a(true, (byte[])localObject);
            }
            AppMethodBeat.o(224243);
            return localObject;
          }
          paramInt2 = -1;
          continue;
        }
        int i = 70;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.ScanImageCompressUtils", paramString, "alvinluo compressImage exception", new Object[0]);
        if (parama != null) {
          parama.a(false, null);
        }
        AppMethodBeat.o(224243);
        return null;
      }
    }
  }
  
  public static byte[] a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(224242);
    byte[] arrayOfByte1 = null;
    int[] arrayOfInt = FaY;
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
        AppMethodBeat.o(224242);
        return arrayOfByte1;
      }
      i += 1;
    }
    AppMethodBeat.o(224242);
    return arrayOfByte2;
  }
  
  public static byte[] aWc(String paramString)
  {
    AppMethodBeat.i(224241);
    paramString = a(paramString, -1, null);
    AppMethodBeat.o(224241);
    return paramString;
  }
  
  private static Bitmap eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(224245);
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      h.decodeFile(paramString, (BitmapFactory.Options)localObject);
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
        ((BitmapFactory.Options)localObject).inSampleSize = h.O(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, paramInt, i);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        ae.i("MicroMsg.ScanImageCompressUtils", "alvinluo resizeImage width: %d, height: %d, targetWidth: %d, targetHeight: %d, sampleSize: %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(((BitmapFactory.Options)localObject).inSampleSize) });
        localObject = h.decodeFile(paramString, (BitmapFactory.Options)localObject);
        paramString = (String)localObject;
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (!((Bitmap)localObject).isRecycled())
          {
            paramString = (String)localObject;
            if (((Bitmap)localObject).getWidth() > paramInt) {
              paramString = h.a((Bitmap)localObject, i, paramInt, false, true);
            }
          }
        }
        AppMethodBeat.o(224245);
        return paramString;
        j = (int)(j * 1.0F * paramInt / i);
        i = paramInt;
        paramInt = j;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.ScanImageCompressUtils", paramString, "alvinluo resizeImage exception", new Object[0]);
      AppMethodBeat.o(224245);
    }
  }
  
  private static byte[] m(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(224244);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
      paramBitmap = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      AppMethodBeat.o(224244);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      ae.printErrStackTrace("MicroMsg.ScanImageCompressUtils", paramBitmap, "compressImageByQuality exception", new Object[0]);
      AppMethodBeat.o(224244);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.p
 * JD-Core Version:    0.7.0.1
 */