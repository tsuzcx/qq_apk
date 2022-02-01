package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanYuvUtils;", "", "()V", "STORAGE_TMP_PATH", "", "TAG", "compressAndRotateYUVToJpeg", "Lkotlin/Pair;", "", "Landroid/graphics/Point;", "yuv", "format", "", "imageSize", "cropRectFactor", "Landroid/graphics/RectF;", "rotation", "quality", "convertRGBA2WxamInner", "rgba", "dest", "width", "height", "convertRGBAToWxam", "convertYUVToJpeg", "targetSize", "rect", "Landroid/graphics/Rect;", "convertYUVToWxam", "yuvFormat", "yuvSize", "encodeYUV420SP", "", "yuv420sp", "argb", "", "getNV21", "inputWidth", "inputHeight", "scaled", "Landroid/graphics/Bitmap;", "getTmpPath", "file", "rotateYUV", "inputCropRectFactor", "rotateYUV420Degree180", "data", "imageWidth", "imageHeight", "rotateYUV420Degree270", "rotateYUV420Degree90", "saveYUVToJpeg", "savedFilePath", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r PjN;
  
  static
  {
    AppMethodBeat.i(161063);
    PjN = new r();
    String str = s.X(h.baE().mCJ, "scan_product_tmp/");
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    AppMethodBeat.o(161063);
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt, Point paramPoint)
  {
    AppMethodBeat.i(314144);
    s.u(paramArrayOfByte, "yuv");
    s.u(paramPoint, "targetSize");
    long l1 = System.currentTimeMillis();
    Rect localRect = new Rect(0, 0, paramPoint.x, paramPoint.y);
    paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramPoint.x, paramPoint.y, null);
    paramPoint = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte.compressToJpeg(localRect, 70, (OutputStream)paramPoint);
      paramPoint.flush();
      paramPoint.close();
      long l2 = System.currentTimeMillis();
      paramArrayOfByte = paramPoint.toByteArray();
      Log.d("MicroMsg.ScanYuvUtils", "convertYUVToJpeg cost: %s ms, jpgSize: %s", new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(314144);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.ScanYuvUtils", (Throwable)paramArrayOfByte, "convertYUVToJpeg exception %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(314144);
    }
    return null;
  }
  
  private static String aVl(String paramString)
  {
    AppMethodBeat.i(314175);
    paramString = h.baE().mCJ + "scan_product_tmp/" + paramString;
    AppMethodBeat.o(314175);
    return paramString;
  }
  
  public static final byte[] b(byte[] paramArrayOfByte, Point paramPoint)
  {
    AppMethodBeat.i(314164);
    s.u(paramArrayOfByte, "yuv");
    s.u(paramPoint, "yuvSize");
    long l1 = System.currentTimeMillis();
    paramPoint = a(paramArrayOfByte, 17, paramPoint);
    Log.i("MicroMsg.ScanYuvUtils", "convertYUVToWxam yuv2jpg cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    if (paramPoint != null)
    {
      String str1 = aVl("temp_" + System.currentTimeMillis() + ".jpg");
      y.f(str1, paramPoint, paramPoint.length);
      l1 = System.currentTimeMillis();
      String str2 = aVl("temp_" + System.currentTimeMillis() + ".wxam");
      int i = ((c)h.ax(c.class)).gG(str1, str2);
      long l2 = System.currentTimeMillis();
      if (i == 0)
      {
        paramArrayOfByte = y.bi(str2, 0, -1);
        int j = paramPoint.length;
        if (paramArrayOfByte == null)
        {
          paramPoint = null;
          label171:
          Log.i("MicroMsg.ScanYuvUtils", "convertYUVToWxam pic2Wxam cost: %s, jpgSize: %s, wxamSize: %s, ret: %s", new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(j), paramPoint, Integer.valueOf(i) });
          y.deleteFile(str1);
          y.deleteFile(str2);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(314164);
      return paramArrayOfByte;
      paramPoint = Integer.valueOf(paramArrayOfByte.length);
      break label171;
      paramArrayOfByte = null;
      break;
      paramArrayOfByte = null;
    }
  }
  
  public static final byte[] c(byte[] paramArrayOfByte, Point paramPoint)
  {
    AppMethodBeat.i(314185);
    s.u(paramArrayOfByte, "rgba");
    s.u(paramPoint, "imageSize");
    String str = aVl("temp_" + System.currentTimeMillis() + ".wxam");
    long l1 = System.currentTimeMillis();
    int k = paramPoint.x;
    int m = paramPoint.y;
    int j = MMWXGFJNI.getErrorCode();
    int i = j;
    if (j == 0)
    {
      i = MMWXGFJNI.pic2WxamWithWH(y.n(str, true), paramArrayOfByte, paramArrayOfByte.length, 7, 37, k, m, k, m);
      if (y.bEl(str) <= 0L) {
        i = -10;
      }
    }
    long l2 = System.currentTimeMillis();
    if (i == 0) {}
    for (byte[] arrayOfByte = y.bi(str, 0, -1);; arrayOfByte = null)
    {
      j = paramArrayOfByte.length;
      if (arrayOfByte == null) {}
      for (paramArrayOfByte = null;; paramArrayOfByte = Integer.valueOf(arrayOfByte.length))
      {
        Log.d("MicroMsg.ScanYuvUtils", "convertRGBAToWxam pic2wxam cost: %s, rgbaSize: %s, wxamSize: %s, ret: %s, imageSize: %s", new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(j), paramArrayOfByte, Integer.valueOf(i), paramPoint });
        y.deleteFile(str);
        AppMethodBeat.o(314185);
        return arrayOfByte;
      }
    }
  }
  
  public static final byte[] getNV21(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(161062);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(161062);
      return null;
    }
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt1 * paramInt2 * 3 / 2];
    int i = paramInt1 * paramInt2;
    int k = 0;
    int j = 0;
    int m;
    int i2;
    int i3;
    int n;
    int i1;
    label89:
    int i5;
    int i6;
    int i4;
    if (paramInt2 > 0)
    {
      m = 0;
      i2 = m + 1;
      i3 = 0;
      if (paramInt1 <= 0) {
        break label417;
      }
      n = i;
      i1 = k;
      k = i3;
      i3 = k + 1;
      i = (arrayOfInt[j] & 0xFF0000) >> 16;
      k = (arrayOfInt[j] & 0xFF00) >> 8;
      i5 = (arrayOfInt[j] & 0xFF) >> 0;
      i6 = (i * 66 + k * 129 + i5 * 25 + 128 >> 8) + 16;
      i4 = (i * -38 - k * 74 + i5 * 112 + 128 >> 8) + 128;
      i5 = (i * 112 - k * 94 - i5 * 18 + 128 >> 8) + 128;
      k = i1 + 1;
      if (i6 >= 0) {
        break label336;
      }
      i = 0;
      label235:
      arrayOfByte[i1] = ((byte)i);
      i = n;
      if (m % 2 == 0)
      {
        i = n;
        if (j % 2 == 0)
        {
          i1 = n + 1;
          if (i5 >= 0) {
            break label354;
          }
          i = 0;
          label275:
          arrayOfByte[n] = ((byte)i);
          n = i1 + 1;
          if (i4 >= 0) {
            break label375;
          }
          i = 0;
          label295:
          arrayOfByte[i1] = ((byte)i);
          i = n;
        }
      }
      j += 1;
      if (i3 < paramInt1) {
        break label403;
      }
    }
    label403:
    label417:
    for (;;)
    {
      if (i2 >= paramInt2)
      {
        paramBitmap.recycle();
        AppMethodBeat.o(161062);
        return arrayOfByte;
        label336:
        i = i6;
        if (i6 <= 255) {
          break label235;
        }
        i = 255;
        break label235;
        label354:
        if (i5 > 255)
        {
          i = 255;
          break label275;
        }
        i = i5;
        break label275;
        label375:
        if (i4 > 255)
        {
          i = 255;
          break label295;
        }
        i = i4;
        break label295;
      }
      m = i2;
      break;
      i1 = k;
      k = i3;
      n = i;
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.r
 * JD-Core Version:    0.7.0.1
 */