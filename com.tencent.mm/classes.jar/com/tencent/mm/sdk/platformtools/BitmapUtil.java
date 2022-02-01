package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.s;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class BitmapUtil
{
  private static final int ANDROID_API_LEVEL_11 = 11;
  private static final int DEFAULT_DECODE_MARK_SIZE = 8388608;
  private static final int DEFAULT_TARGET_WIDTH = 2500;
  public static final int MAX_DECODE_PICTURE_SIZE = 2764800;
  public static final double SCALE_HORIZONTAL = 1.2D;
  private static final String TAG = "MicroMsg.BitmapUtil";
  public static boolean hasNoInNativeField;
  private static DisplayMetrics metrics = null;
  
  public static byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156153);
    paramBitmap = Bitmap2Bytes(paramBitmap, 100);
    AppMethodBeat.o(156153);
    return paramBitmap;
  }
  
  public static byte[] Bitmap2Bytes(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(156154);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(156154);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    compress(paramBitmap, Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(156154);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      }
    }
  }
  
  public static byte[] Bitmap2PngBytes(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156155);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(156155);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    compress(paramBitmap, Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(156155);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      }
    }
  }
  
  public static void bindlowMemeryOption(BitmapFactory.Options paramOptions) {}
  
  public static Bitmap blendBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, RectF paramRectF)
  {
    AppMethodBeat.i(215342);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, null, new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight()), null);
    Rect localRect = new Rect();
    paramRectF.round(localRect);
    localCanvas.drawBitmap(paramBitmap2, localRect, new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight()), null);
    AppMethodBeat.o(215342);
    return localBitmap;
  }
  
  public static int calculateInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156103);
    int j = 1;
    if ((paramInt1 > paramInt4) || (paramInt2 > paramInt3))
    {
      if (paramInt2 > paramInt1) {}
      for (int i = Math.round(paramInt1 / paramInt4 + 0.5F);; i = Math.round(paramInt2 / paramInt3 + 0.5F))
      {
        float f1 = paramInt2 * paramInt1;
        float f2 = paramInt3 * paramInt4 * 2;
        for (;;)
        {
          j = i;
          if (f1 / (i * i) <= f2) {
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(156103);
    return j;
  }
  
  public static int checkDegree(String paramString)
  {
    AppMethodBeat.i(169231);
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    AppMethodBeat.o(169231);
    return i;
  }
  
  private static boolean checkTimeout(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(215340);
    if (paramLong2 != -1L)
    {
      if (System.currentTimeMillis() - paramLong1 > paramLong2)
      {
        AppMethodBeat.o(215340);
        return true;
      }
      AppMethodBeat.o(215340);
      return false;
    }
    AppMethodBeat.o(215340);
    return false;
  }
  
  public static boolean compress(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(156173);
    if (paramBitmap == null)
    {
      Log.e("MicroMsg.BitmapUtil", "bitmap error %s", new Object[] { paramBitmap });
      AppMethodBeat.o(156173);
      return false;
    }
    boolean bool = paramBitmap.compress(paramCompressFormat, paramInt, paramOutputStream);
    if (!bool) {
      Log.e("MicroMsg.BitmapUtil", "compress error %s", new Object[] { Util.getStack().toString() });
    }
    AppMethodBeat.o(156173);
    return bool;
  }
  
  public static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(186110);
    paramConfig = createBitmap(paramInt1, paramInt2, paramConfig, false);
    AppMethodBeat.o(186110);
    return paramConfig;
  }
  
  public static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(156124);
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      setBitmapDensity(paramConfig);
      paramConfig = BitmapTracer.trace(paramConfig);
      AppMethodBeat.o(156124);
      return paramConfig;
    }
    catch (Throwable paramConfig)
    {
      for (;;)
      {
        if (paramBoolean)
        {
          AppMethodBeat.o(156124);
          return null;
        }
        try
        {
          paramConfig = getDefaultDisplayMetrics();
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
        }
        catch (Throwable paramConfig)
        {
          paramConfig = localObject;
        }
      }
    }
  }
  
  public static Bitmap createBitmapByPixels(int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(156165);
    paramConfig = createBitmap(paramInt1, paramInt2, paramConfig);
    if (paramConfig != null)
    {
      if ((paramInt1 == paramConfig.getWidth()) && (paramInt2 == paramConfig.getHeight())) {
        paramConfig.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      }
    }
    else
    {
      setBitmapDensity(paramConfig);
      paramArrayOfInt = BitmapTracer.trace(paramConfig);
      AppMethodBeat.o(156165);
      return paramArrayOfInt;
    }
    AppMethodBeat.o(156165);
    return null;
  }
  
  public static Bitmap createChattingImage(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(156161);
    Log.d("MicroMsg.BitmapUtil", "begin createChattingImage");
    long l1 = System.currentTimeMillis();
    if (paramBitmap == null)
    {
      Log.w("MicroMsg.BitmapUtil", "sourceBitmap is null .");
      AppMethodBeat.o(156161);
      return null;
    }
    setBitmapDensity(paramBitmap);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      Log.w("MicroMsg.BitmapUtil", "sourceBitmap width or height is 0.");
      AppMethodBeat.o(156161);
      return null;
    }
    long l2 = System.currentTimeMillis();
    Bitmap localBitmap;
    try
    {
      localBitmap = createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = (NinePatchDrawable)MMApplicationContext.getContext().getResources().getDrawable(paramInt);
      ((NinePatchDrawable)localObject).setBounds(0, 0, i, j);
      ((NinePatchDrawable)localObject).draw(new Canvas(localBitmap));
      Log.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l2));
      if (localBitmap == null)
      {
        Log.e("MicroMsg.BitmapUtil", "[createChattingImage] maskBitmap is null.");
        AppMethodBeat.o(156161);
        return null;
      }
    }
    catch (Exception paramBitmap)
    {
      Log.e("MicroMsg.BitmapUtil", "[createChattingImage] create nine pathc bitmap faild.");
      AppMethodBeat.o(156161);
      return null;
    }
    paramInt = localBitmap.getWidth();
    int k = localBitmap.getHeight();
    if ((paramInt <= 0) || (k <= 0))
    {
      Log.w("MicroMsg.BitmapUtil", "maskBitmap width or height is 0.");
      AppMethodBeat.o(156161);
      return null;
    }
    if ((k != j) || (paramInt != i))
    {
      Log.e("MicroMsg.BitmapUtil", "maskHeiht maskWidth != height width.");
      AppMethodBeat.o(156161);
      return null;
    }
    Object localObject = new int[i * j];
    int[] arrayOfInt = new int[paramInt * k];
    paramBitmap.getPixels((int[])localObject, 0, i, 0, 0, i, j);
    localBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    l2 = System.currentTimeMillis();
    paramInt = 0;
    for (;;)
    {
      try
      {
        if (paramInt < arrayOfInt.length)
        {
          if (arrayOfInt[paramInt] == -16777216) {
            break label480;
          }
          if (arrayOfInt[paramInt] == 0) {
            localObject[paramInt] = 0;
          } else if (arrayOfInt[paramInt] != -1) {
            localObject[paramInt] &= arrayOfInt[paramInt];
          }
        }
      }
      catch (Exception paramBitmap)
      {
        Log.e("MicroMsg.BitmapUtil", paramBitmap.toString());
        Log.d("MicroMsg.BitmapUtil", "meger pixels  " + (System.currentTimeMillis() - l2));
        l2 = System.currentTimeMillis();
        localBitmap.setPixels((int[])localObject, 0, i, 0, 0, i, j);
        Log.d("MicroMsg.BitmapUtil", "setPixels " + (System.currentTimeMillis() - l2));
        Log.d("MicroMsg.BitmapUtil", "createTime" + (System.currentTimeMillis() - l1));
        setBitmapDensity(localBitmap);
        paramBitmap = BitmapTracer.trace(localBitmap);
        AppMethodBeat.o(156161);
        return paramBitmap;
      }
      label480:
      paramInt += 1;
    }
  }
  
  public static Bitmap createColorBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156100);
    try
    {
      Bitmap localBitmap = createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawColor(paramInt1);
      localBitmap = BitmapTracer.trace(localBitmap);
      AppMethodBeat.o(156100);
      return localBitmap;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      AppMethodBeat.o(156100);
    }
    return null;
  }
  
  public static Bitmap createLayerBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    int m = 0;
    AppMethodBeat.i(215336);
    label22:
    int k;
    if (paramBitmap1 == null)
    {
      i = 0;
      if (paramBitmap1 != null) {
        break label100;
      }
      j = 0;
      if (paramBitmap2 != null) {
        break label109;
      }
      k = 0;
      label29:
      if (paramBitmap2 != null) {
        break label118;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BitmapUtil", "src(%d,%d) background(%d,%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      if ((paramBitmap1 != null) && (paramBitmap2 != null)) {
        break label127;
      }
      AppMethodBeat.o(215336);
      return null;
      i = paramBitmap1.getWidth();
      break;
      label100:
      j = paramBitmap1.getHeight();
      break label22;
      label109:
      k = paramBitmap2.getWidth();
      break label29;
      label118:
      m = paramBitmap2.getHeight();
    }
    label127:
    int i = Math.max(paramBitmap1.getWidth(), paramBitmap2.getWidth());
    int j = Math.max(paramBitmap1.getHeight(), paramBitmap2.getHeight());
    Bitmap localBitmap = BitmapTracer.trace(createBitmap(i, j, Bitmap.Config.ARGB_8888));
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap2, (i - paramBitmap2.getWidth()) / 2.0F, (j - paramBitmap2.getHeight()) / 2.0F, new Paint());
    localCanvas.drawBitmap(paramBitmap1, (i - paramBitmap1.getWidth()) / 2.0F, (j - paramBitmap1.getHeight()) / 2.0F, new Paint());
    if (paramBoolean)
    {
      paramBitmap2.recycle();
      paramBitmap1.recycle();
    }
    AppMethodBeat.o(215336);
    return localBitmap;
  }
  
  public static Bitmap createLocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(215335);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0))
    {
      Log.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
      AppMethodBeat.o(215335);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = BitmapTracer.trace(createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888));
    setBitmapDensity(localBitmap);
    NinePatchDrawable localNinePatchDrawable = (NinePatchDrawable)MMApplicationContext.getContext().getResources().getDrawable(paramInt1);
    localNinePatchDrawable.setBounds(0, 0, paramInt3, paramInt4);
    localNinePatchDrawable.draw(new Canvas(localBitmap));
    Log.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    localBitmap = createChattingImage(localBitmap, paramInt2);
    AppMethodBeat.o(215335);
    return localBitmap;
  }
  
  public static Bitmap createLocation(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156163);
    if ((paramString == null) || (paramString.equals("")) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      Log.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
      AppMethodBeat.o(156163);
      return null;
    }
    paramString = BitmapTracer.trace(decodeByteArray(s.aW(paramString, 0, -1)), paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(156163);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = BitmapTracer.trace(createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888));
    setBitmapDensity(localBitmap);
    Canvas localCanvas = new Canvas(localBitmap);
    Log.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    localCanvas.drawBitmap(paramString, null, new Rect(0, 0, paramInt2, paramInt3), new Paint());
    Log.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    paramString = createChattingImage(localBitmap, paramInt1);
    AppMethodBeat.o(156163);
    return paramString;
  }
  
  public static Bitmap createMaskImage(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156164);
    if ((paramBitmap == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(156164);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = BitmapTracer.trace(createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888));
    Canvas localCanvas = new Canvas(localBitmap);
    Log.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, paramInt2, paramInt3), new Paint());
    Log.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    paramBitmap = createChattingImage(localBitmap, paramInt1);
    AppMethodBeat.o(156164);
    return paramBitmap;
  }
  
  public static Path createRoundedRectPath(RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(215331);
    Path localPath = new Path();
    float f = paramFloat1;
    if (paramFloat1 < 0.0F) {
      f = 0.0F;
    }
    paramFloat1 = paramFloat2;
    if (paramFloat2 < 0.0F) {
      paramFloat1 = 0.0F;
    }
    paramFloat2 = paramFloat4;
    if (paramFloat4 < 0.0F) {
      paramFloat2 = 0.0F;
    }
    paramFloat4 = paramFloat3;
    if (paramFloat3 < 0.0F) {
      paramFloat4 = 0.0F;
    }
    localPath.moveTo(paramRectF.left + f, paramRectF.top);
    localPath.lineTo(paramRectF.right - paramFloat1, paramRectF.top);
    localPath.quadTo(paramRectF.right, paramRectF.top, paramRectF.right, paramRectF.top + paramFloat1);
    localPath.lineTo(paramRectF.right, paramRectF.bottom - paramFloat4);
    localPath.quadTo(paramRectF.right, paramRectF.bottom, paramRectF.right - paramFloat4, paramRectF.bottom);
    localPath.lineTo(paramRectF.left + paramFloat2, paramRectF.bottom);
    localPath.quadTo(paramRectF.left, paramRectF.bottom, paramRectF.left, paramRectF.bottom - paramFloat2);
    localPath.lineTo(paramRectF.left, paramRectF.top + f);
    localPath.quadTo(paramRectF.left, paramRectF.top, paramRectF.left + f, paramRectF.top);
    localPath.close();
    AppMethodBeat.o(215331);
    return localPath;
  }
  
  public static Bitmap createShareAppImage(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215337);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      Log.w("MicroMsg.BitmapUtil", "createShareAppImage fail. srcResId or maskResId is null");
      AppMethodBeat.o(215337);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = BitmapTracer.trace(getBitmapNative(paramInt1));
    Log.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    localBitmap = createChattingImage(localBitmap, paramInt2);
    AppMethodBeat.o(215337);
    return localBitmap;
  }
  
  public static Bitmap createThumbBitmap(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215309);
    paramString = createThumbBitmap(paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2, 0);
    AppMethodBeat.o(215309);
    return paramString;
  }
  
  public static Bitmap createThumbBitmap(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    AppMethodBeat.i(215310);
    Object localObject = extractThumbNail(paramString, paramInt1, paramInt2, paramBoolean2);
    if (localObject == null)
    {
      AppMethodBeat.o(215310);
      return null;
    }
    Bitmap localBitmap = drawBackgroundInNeed((Bitmap)localObject, paramString, paramInt3);
    localObject = localBitmap;
    if (paramBoolean1)
    {
      paramInt1 = Exif.fromFile(paramString).getOrientationInDegree();
      Log.d("MicroMsg.BitmapUtil", "degress:%d", new Object[] { Integer.valueOf(paramInt1) });
      localObject = rotate(localBitmap, paramInt1);
    }
    AppMethodBeat.o(215310);
    return localObject;
  }
  
  public static Bitmap createThumbCropBitmap(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(215311);
    Bitmap localBitmap2 = decodeFile(paramString);
    if (localBitmap2 == null)
    {
      AppMethodBeat.o(215311);
      return null;
    }
    Bitmap localBitmap1 = localBitmap2;
    if (paramBoolean)
    {
      int i = Exif.fromFile(paramString).getOrientationInDegree();
      Log.d("MicroMsg.BitmapUtil", "degress:%d", new Object[] { Integer.valueOf(i) });
      localBitmap1 = rotate(localBitmap2, i);
    }
    paramString = extractThumbNail(localBitmap1, paramInt2, paramInt1, true, true);
    AppMethodBeat.o(215311);
    return paramString;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(156102);
    boolean bool = createThumbNail(false, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, false);
    AppMethodBeat.o(156102);
    return bool;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156101);
    boolean bool = createThumbNail(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramString3, false);
    AppMethodBeat.o(156101);
    return bool;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(215299);
    paramBoolean = createThumbNail(false, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2 + paramString3, paramBoolean);
    AppMethodBeat.o(215299);
    return paramBoolean;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215298);
    paramBoolean1 = createThumbNail(false, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2 + paramString3, paramBoolean1, new PInt(), new PInt(), paramBoolean2, null, 0);
    AppMethodBeat.o(215298);
    return paramBoolean1;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(215302);
    paramBoolean = createThumbNail(false, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramBoolean, new PInt(), new PInt());
    AppMethodBeat.o(215302);
    return paramBoolean;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(215304);
    paramBoolean = createThumbNail(false, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramBoolean, paramPInt1, paramPInt2, false, null, 0);
    AppMethodBeat.o(215304);
    return paramBoolean;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean1, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(215305);
    paramBoolean1 = createThumbNail(false, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramBoolean1, paramPInt1, paramPInt2, paramBoolean2, null, 0);
    AppMethodBeat.o(215305);
    return paramBoolean1;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean1, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(215306);
    paramBoolean1 = createThumbNail(false, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramBoolean1, paramPInt1, paramPInt2, paramBoolean2, null, paramInt4);
    AppMethodBeat.o(215306);
    return paramBoolean1;
  }
  
  public static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean1, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    AppMethodBeat.i(215312);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.BitmapUtil", "file path is null.");
      AppMethodBeat.o(215312);
      return false;
    }
    if (!s.YS(paramString1))
    {
      Log.w("MicroMsg.BitmapUtil", "file did not exists.");
      AppMethodBeat.o(215312);
      return false;
    }
    int i = 0;
    if (paramBoolean1)
    {
      i = Exif.fromFile(paramString1).getOrientationInDegree();
      Log.d("MicroMsg.BitmapUtil", "degress:%d", new Object[] { Integer.valueOf(i) });
    }
    Bitmap localBitmap2;
    Bitmap localBitmap1;
    if ((i == 90) || (i == 270))
    {
      localBitmap2 = extractThumbNail(paramString1, paramInt2, paramInt1, paramBoolean2);
      localBitmap1 = localBitmap2;
      if (paramBoolean1) {
        localBitmap1 = rotate(localBitmap2, i);
      }
    }
    while (localBitmap1 == null)
    {
      AppMethodBeat.o(215312);
      return false;
      localBitmap2 = extractThumbNail(paramString1, paramInt1, paramInt2, paramBoolean2);
      localBitmap1 = localBitmap2;
      if (paramBoolean1) {
        localBitmap1 = rotate(localBitmap2, i);
      }
    }
    paramString1 = drawBackgroundInNeed(localBitmap1, paramString1, paramInt4);
    try
    {
      paramPInt1.value = paramString1.getWidth();
      paramPInt2.value = paramString1.getHeight();
      saveBitmapToImage(paramString1, paramInt3, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(215312);
      return true;
    }
    catch (IOException paramString1)
    {
      Log.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(215312);
    }
    return false;
  }
  
  public static boolean createThumbNail(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(215300);
    paramBoolean = createThumbNail(paramBoolean, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, false);
    AppMethodBeat.o(215300);
    return paramBoolean;
  }
  
  public static boolean createThumbNail(boolean paramBoolean1, String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(215301);
    paramBoolean1 = createThumbNail(paramBoolean1, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramBoolean2, new PInt(), new PInt());
    AppMethodBeat.o(215301);
    return paramBoolean1;
  }
  
  public static boolean createThumbNail(boolean paramBoolean1, String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(215303);
    paramBoolean1 = createThumbNail(paramBoolean1, paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramBoolean2, paramPInt1, paramPInt2, false, null, 0);
    AppMethodBeat.o(215303);
    return paramBoolean1;
  }
  
  public static boolean createThumbNail(boolean paramBoolean1, String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean3, b paramb, int paramInt4)
  {
    AppMethodBeat.i(215307);
    try
    {
      Bitmap localBitmap1 = extractThumbNail(paramString1, paramInt1, paramInt2, paramBoolean3);
      if (localBitmap1 == null)
      {
        AppMethodBeat.o(215307);
        return false;
      }
      Bitmap localBitmap2 = localBitmap1;
      if (paramBoolean2) {
        localBitmap2 = rotate(localBitmap1, Exif.fromFile(paramString1).getOrientationInDegree());
      }
      if (paramb != null) {
        paramb.Ur();
      }
      paramPInt1.value = localBitmap2.getWidth();
      paramPInt2.value = localBitmap2.getHeight();
      paramString1 = drawBackgroundInNeed(localBitmap2, paramString1, paramInt4);
      if (!paramBoolean1) {
        break label205;
      }
      paramInt1 = ImageOptimLib.compressByQualityOptim(paramString1, paramInt3, false, paramString2);
      Log.i("MicroMsg.BitmapUtil", "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()), paramString2 });
      if (paramInt1 == 1)
      {
        AppMethodBeat.o(215307);
        return true;
      }
    }
    catch (Throwable paramString1)
    {
      Log.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(215307);
      return false;
    }
    AppMethodBeat.o(215307);
    return false;
    label205:
    saveBitmapToImage(paramString1, paramInt3, paramCompressFormat, paramString2, true);
    AppMethodBeat.o(215307);
    return true;
  }
  
  public static int createThumbNailMayUseOpt(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, b paramb, int paramInt4)
  {
    AppMethodBeat.i(215308);
    Bitmap localBitmap = extractThumbNail(paramString1, paramInt1, paramInt2, false);
    if (localBitmap == null)
    {
      AppMethodBeat.o(215308);
      return -1;
    }
    localBitmap = rotate(localBitmap, Exif.fromFile(paramString1).getOrientationInDegree());
    if (paramb != null) {
      paramb.Ur();
    }
    paramString1 = drawBackgroundInNeed(localBitmap, paramString1, paramInt4);
    if (paramBoolean) {}
    try
    {
      paramInt1 = ImageOptimLib.compressByQualityOptim(paramString1, paramInt3, false, paramString2);
      Log.i("MicroMsg.BitmapUtil", "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()), paramString2 });
      AppMethodBeat.o(215308);
      return paramInt1;
    }
    catch (IOException paramString1)
    {
      Log.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(215308);
    }
    saveBitmapToImage(paramString1, paramInt3, paramCompressFormat, paramString2, true);
    AppMethodBeat.o(215308);
    return 1;
    return -2;
  }
  
  /* Error */
  public static Bitmap createVideoThumbnail(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 536
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 538	com/tencent/mm/compatible/i/d
    //   9: dup
    //   10: invokespecial 539	com/tencent/mm/compatible/i/d:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: aload_0
    //   18: invokevirtual 542	com/tencent/mm/compatible/i/d:setDataSource	(Ljava/lang/String;)V
    //   21: aload 5
    //   23: ldc2_w 158
    //   26: invokevirtual 546	com/tencent/mm/compatible/i/d:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   29: astore_0
    //   30: aload 5
    //   32: invokevirtual 549	com/tencent/mm/compatible/i/d:release	()V
    //   35: aload_0
    //   36: ifnonnull +59 -> 95
    //   39: ldc_w 536
    //   42: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload 5
    //   50: invokevirtual 549	com/tencent/mm/compatible/i/d:release	()V
    //   53: aconst_null
    //   54: astore_0
    //   55: goto -20 -> 35
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_0
    //   61: goto -26 -> 35
    //   64: astore_0
    //   65: aload 5
    //   67: invokevirtual 549	com/tencent/mm/compatible/i/d:release	()V
    //   70: aconst_null
    //   71: astore_0
    //   72: goto -37 -> 35
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_0
    //   78: goto -43 -> 35
    //   81: astore_0
    //   82: aload 5
    //   84: invokevirtual 549	com/tencent/mm/compatible/i/d:release	()V
    //   87: ldc_w 536
    //   90: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_0
    //   94: athrow
    //   95: iload_1
    //   96: iconst_1
    //   97: if_icmpne +69 -> 166
    //   100: aload_0
    //   101: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   104: istore_1
    //   105: aload_0
    //   106: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   109: istore_3
    //   110: iload_1
    //   111: iload_3
    //   112: invokestatic 327	java/lang/Math:max	(II)I
    //   115: istore 4
    //   117: aload_0
    //   118: astore 5
    //   120: iload 4
    //   122: sipush 512
    //   125: if_icmple +32 -> 157
    //   128: ldc_w 550
    //   131: iload 4
    //   133: i2f
    //   134: fdiv
    //   135: fstore_2
    //   136: aload_0
    //   137: iload_1
    //   138: i2f
    //   139: fload_2
    //   140: fmul
    //   141: invokestatic 142	java/lang/Math:round	(F)I
    //   144: iload_3
    //   145: i2f
    //   146: fload_2
    //   147: fmul
    //   148: invokestatic 142	java/lang/Math:round	(F)I
    //   151: iconst_1
    //   152: invokestatic 554	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   155: astore 5
    //   157: ldc_w 536
    //   160: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 5
    //   165: areturn
    //   166: aload_0
    //   167: astore 5
    //   169: iload_1
    //   170: iconst_3
    //   171: if_icmpne -14 -> 157
    //   174: aload_0
    //   175: bipush 96
    //   177: bipush 96
    //   179: iconst_2
    //   180: invokestatic 559	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   183: astore 5
    //   185: goto -28 -> 157
    //   188: astore 5
    //   190: goto -155 -> 35
    //   193: astore 5
    //   195: goto -108 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   0	198	1	paramInt	int
    //   135	12	2	f	float
    //   109	36	3	i	int
    //   115	17	4	j	int
    //   13	171	5	localObject	Object
    //   188	1	5	localRuntimeException1	java.lang.RuntimeException
    //   193	1	5	localRuntimeException2	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   15	30	47	java/lang/IllegalArgumentException
    //   48	53	58	java/lang/RuntimeException
    //   15	30	64	java/lang/RuntimeException
    //   65	70	75	java/lang/RuntimeException
    //   15	30	81	finally
    //   30	35	188	java/lang/RuntimeException
    //   82	87	193	java/lang/RuntimeException
  }
  
  public static Bitmap cropBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(215319);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, Math.min(paramInt3, paramBitmap.getWidth() - paramInt1), Math.min(paramInt4, paramBitmap.getHeight() - paramInt2));
      if ((paramBitmap != localBitmap) && (paramBoolean)) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(215319);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      if ((paramBoolean) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(215319);
    }
    return null;
  }
  
  /* Error */
  private static Bitmap decodeBitmap(BitmapFactory.Options paramOptions, byte[] paramArrayOfByte, String paramString, Uri paramUri, InputStream paramInputStream, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aconst_null
    //   4: astore 10
    //   6: ldc_w 571
    //   9: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload 10
    //   14: astore 9
    //   16: aload_1
    //   17: invokestatic 574	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   20: ifeq +44 -> 64
    //   23: aload 10
    //   25: astore 9
    //   27: aload_2
    //   28: invokestatic 484	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   31: istore 8
    //   33: iload 8
    //   35: ifeq +29 -> 64
    //   38: aload_3
    //   39: ifnonnull +25 -> 64
    //   42: iload 6
    //   44: ifgt +20 -> 64
    //   47: aload 4
    //   49: ifnonnull +15 -> 64
    //   52: aconst_null
    //   53: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   56: ldc_w 571
    //   59: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload 10
    //   66: astore 9
    //   68: aload_1
    //   69: invokestatic 574	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   72: ifne +6 -> 78
    //   75: iconst_1
    //   76: istore 7
    //   78: iload 7
    //   80: ifeq +33 -> 113
    //   83: aload 10
    //   85: astore 9
    //   87: aload_1
    //   88: iconst_0
    //   89: aload_1
    //   90: arraylength
    //   91: aload_0
    //   92: invokestatic 579	com/tencent/mm/graphics/MMBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   95: astore_0
    //   96: aload_0
    //   97: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   100: aload_0
    //   101: invokestatic 205	com/tencent/mm/sdk/platformtools/BitmapTracer:trace	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   104: astore_0
    //   105: ldc_w 571
    //   108: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: areturn
    //   113: iload 6
    //   115: ifle +23 -> 138
    //   118: aload 10
    //   120: astore 9
    //   122: invokestatic 250	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   125: invokevirtual 256	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   128: iload 6
    //   130: aload_0
    //   131: invokestatic 585	com/tencent/mm/compatible/f/a:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   134: astore_0
    //   135: goto -39 -> 96
    //   138: aload 4
    //   140: ifnull +18 -> 158
    //   143: aload 10
    //   145: astore 9
    //   147: aload 4
    //   149: aconst_null
    //   150: aload_0
    //   151: invokestatic 589	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   154: astore_0
    //   155: goto -59 -> 96
    //   158: iload 5
    //   160: ifeq +68 -> 228
    //   163: aload_2
    //   164: invokestatic 484	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   167: istore 5
    //   169: iload 5
    //   171: ifeq +15 -> 186
    //   174: aconst_null
    //   175: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   178: ldc_w 571
    //   181: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aconst_null
    //   185: areturn
    //   186: invokestatic 250	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   189: invokevirtual 593	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   192: aload_2
    //   193: invokevirtual 599	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   196: astore_1
    //   197: aload_1
    //   198: aconst_null
    //   199: aload_0
    //   200: invokestatic 589	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   203: astore_2
    //   204: aload_2
    //   205: astore_0
    //   206: aload_1
    //   207: ifnull -111 -> 96
    //   210: aload_2
    //   211: astore 9
    //   213: aload_1
    //   214: invokevirtual 602	java/io/InputStream:close	()V
    //   217: aload_2
    //   218: astore_0
    //   219: goto -123 -> 96
    //   222: astore_0
    //   223: aload_2
    //   224: astore_0
    //   225: goto -129 -> 96
    //   228: aload_3
    //   229: ifnull +17 -> 246
    //   232: invokestatic 250	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   235: invokevirtual 606	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   238: aload_3
    //   239: invokevirtual 612	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   242: astore_1
    //   243: goto -46 -> 197
    //   246: aload_2
    //   247: invokestatic 615	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   250: astore_1
    //   251: goto -54 -> 197
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: ifnull +11 -> 269
    //   261: aload 10
    //   263: astore 9
    //   265: aload_1
    //   266: invokevirtual 602	java/io/InputStream:close	()V
    //   269: aload 10
    //   271: astore 9
    //   273: ldc_w 571
    //   276: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload 10
    //   281: astore 9
    //   283: aload_0
    //   284: athrow
    //   285: astore_0
    //   286: aload 9
    //   288: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   291: ldc_w 571
    //   294: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: aload_0
    //   298: athrow
    //   299: astore_1
    //   300: goto -31 -> 269
    //   303: astore_0
    //   304: goto -47 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramOptions	BitmapFactory.Options
    //   0	307	1	paramArrayOfByte	byte[]
    //   0	307	2	paramString	String
    //   0	307	3	paramUri	Uri
    //   0	307	4	paramInputStream	InputStream
    //   0	307	5	paramBoolean	boolean
    //   0	307	6	paramInt	int
    //   1	78	7	i	int
    //   31	3	8	bool	boolean
    //   14	273	9	localObject1	Object
    //   4	276	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   213	217	222	java/io/IOException
    //   163	169	254	finally
    //   186	197	254	finally
    //   232	243	254	finally
    //   246	251	254	finally
    //   16	23	285	finally
    //   27	33	285	finally
    //   68	75	285	finally
    //   87	96	285	finally
    //   122	135	285	finally
    //   147	155	285	finally
    //   213	217	285	finally
    //   265	269	285	finally
    //   273	279	285	finally
    //   283	285	285	finally
    //   265	269	299	java/io/IOException
    //   197	204	303	finally
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156127);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, 0, 0);
    AppMethodBeat.o(156127);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156126);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.w("MicroMsg.BitmapUtil", "error input: data is null");
      AppMethodBeat.o(156126);
      return null;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      Log.w("MicroMsg.BitmapUtil", "error input: targetWidth %d, targetHeight %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(156126);
      return null;
    }
    paramArrayOfByte = getBitmapNative(0, null, paramArrayOfByte, null, false, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(156126);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArrayDisplayMetrics(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215321);
    DisplayMetrics localDisplayMetrics = getDefaultDisplayMetrics();
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    AppMethodBeat.o(215321);
    return paramArrayOfByte;
  }
  
  @Deprecated
  public static Bitmap decodeFile(String paramString)
  {
    AppMethodBeat.i(186111);
    paramString = decodeFile(paramString, null);
    AppMethodBeat.o(186111);
    return paramString;
  }
  
  /* Error */
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc_w 638
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: astore_3
    //   8: aload_1
    //   9: ifnonnull +11 -> 20
    //   12: new 640	android/graphics/BitmapFactory$Options
    //   15: dup
    //   16: invokespecial 641	android/graphics/BitmapFactory$Options:<init>	()V
    //   19: astore_3
    //   20: aload_0
    //   21: invokestatic 615	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_3
    //   28: invokestatic 643	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: aconst_null
    //   35: aload_3
    //   36: invokestatic 589	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: astore_3
    //   40: aload_2
    //   41: ifnull +7 -> 48
    //   44: aload_2
    //   45: invokevirtual 602	java/io/InputStream:close	()V
    //   48: ldc_w 638
    //   51: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_3
    //   55: areturn
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: astore_1
    //   61: ldc 21
    //   63: ldc_w 645
    //   66: iconst_2
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_0
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_3
    //   77: invokevirtual 648	java/io/IOException:getMessage	()Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 602	java/io/InputStream:close	()V
    //   92: ldc_w 638
    //   95: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 602	java/io/InputStream:close	()V
    //   111: ldc_w 638
    //   114: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: athrow
    //   119: astore_0
    //   120: goto -72 -> 48
    //   123: astore_0
    //   124: goto -32 -> 92
    //   127: astore_1
    //   128: goto -17 -> 111
    //   131: astore_0
    //   132: goto -29 -> 103
    //   135: astore_3
    //   136: goto -77 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   0	139	1	paramOptions	BitmapFactory.Options
    //   24	65	2	localInputStream	InputStream
    //   7	48	3	localObject	Object
    //   56	21	3	localIOException1	IOException
    //   135	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   20	25	56	java/io/IOException
    //   20	25	100	finally
    //   44	48	119	java/io/IOException
    //   88	92	123	java/io/IOException
    //   107	111	127	java/io/IOException
    //   27	31	131	finally
    //   33	40	131	finally
    //   61	84	131	finally
    //   27	31	135	java/io/IOException
    //   33	40	135	java/io/IOException
  }
  
  public static Bitmap decodeFileWithSample(String paramString)
  {
    AppMethodBeat.i(156129);
    paramString = decodeFileWithSample(paramString, 2500, 2500);
    AppMethodBeat.o(156129);
    return paramString;
  }
  
  public static Bitmap decodeFileWithSample(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215320);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    paramString = decodeFile(paramString, localOptions);
    AppMethodBeat.o(215320);
    return paramString;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(156133);
    paramInputStream = decodeStream(paramInputStream, 0.0F, 0, 0);
    AppMethodBeat.o(156133);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, float paramFloat)
  {
    AppMethodBeat.i(156132);
    paramInputStream = decodeStream(paramInputStream, paramFloat, 0, 0);
    AppMethodBeat.o(156132);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156131);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (paramFloat != 0.0F) {
      localOptions.inDensity = ((int)(160.0F * paramFloat));
    }
    Object localObject;
    int i;
    int j;
    if (paramInt1 == 0)
    {
      localObject = paramInputStream;
      if (paramInt2 == 0) {}
    }
    else
    {
      i = paramInt1;
      if (paramInt1 == 0) {
        i = 2147483647;
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 2147483647;
      }
      if (!(paramInputStream instanceof FileInputStream)) {
        break label219;
      }
      localObject = new FileSeekingInputStream((FileInputStream)paramInputStream);
      ((InputStream)localObject).mark(25165824);
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
      paramInt2 = localOptions.outWidth;
      j = localOptions.outHeight;
      if (((i <= paramInt1) || (paramInt2 >= j)) && ((i >= paramInt1) || (paramInt2 <= j))) {
        break label302;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((j > i) || (paramInt2 > paramInt1)) {
          localOptions.inSampleSize = ((int)Math.max(j / i, paramInt2 / paramInt1));
        }
        localOptions.inJustDecodeBounds = false;
        try
        {
          ((InputStream)localObject).reset();
          localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
          bindlowMemeryOption(localOptions);
        }
        catch (IOException paramInputStream)
        {
          try
          {
            paramInputStream = MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
            AppMethodBeat.o(156131);
            return paramInputStream;
            label219:
            localObject = paramInputStream;
            if (paramInputStream.markSupported()) {
              break;
            }
            localObject = new BufferedInputStream(paramInputStream, 65536);
            break;
            paramInputStream = paramInputStream;
            Log.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "Failed seeking InputStream.", new Object[0]);
          }
          catch (OutOfMemoryError paramInputStream)
          {
            for (;;)
            {
              localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
              bindlowMemeryOption(localOptions);
              try
              {
                paramInputStream = MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
              }
              catch (OutOfMemoryError paramInputStream)
              {
                Log.e("MicroMsg.BitmapUtil", "decodeStream OutOfMemoryError return null");
                paramInputStream = null;
              }
            }
          }
        }
      }
      label302:
      int k = paramInt2;
      paramInt2 = j;
      j = k;
    }
  }
  
  public static Bitmap drawBackgroundInNeed(Bitmap paramBitmap, String paramString, int paramInt)
  {
    AppMethodBeat.i(215343);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(215343);
      return paramBitmap;
    }
    if (Color.alpha(paramInt) == 0)
    {
      AppMethodBeat.o(215343);
      return paramBitmap;
    }
    if (!".png".equals(ImgUtil.identifyImgType(paramString)))
    {
      AppMethodBeat.o(215343);
      return paramBitmap;
    }
    try
    {
      paramString = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
      Canvas localCanvas = new Canvas(paramString);
      localCanvas.drawColor(paramInt);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      paramBitmap.recycle();
      paramString = BitmapTracer.trace(paramString);
      AppMethodBeat.o(215343);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      AppMethodBeat.o(215343);
    }
    return paramBitmap;
  }
  
  public static Bitmap extractDrawableThumbNail(Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215332);
    paramDrawable = extractThumbNail(transformDrawableToBitmap(paramDrawable), paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(215332);
    return paramDrawable;
  }
  
  /* Error */
  public static Bitmap extractThumbNail(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 742
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: ldc 21
    //   12: ldc_w 744
    //   15: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc_w 742
    //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: iload_1
    //   27: ifle +7 -> 34
    //   30: iload_2
    //   31: ifgt +47 -> 78
    //   34: ldc 21
    //   36: new 273	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 746
    //   43: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: iload_1
    //   47: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 751
    //   53: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_2
    //   57: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   70: ldc_w 742
    //   73: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aconst_null
    //   77: areturn
    //   78: new 640	android/graphics/BitmapFactory$Options
    //   81: dup
    //   82: invokespecial 641	android/graphics/BitmapFactory$Options:<init>	()V
    //   85: astore 13
    //   87: aload 13
    //   89: invokestatic 643	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   92: aload 13
    //   94: aload_0
    //   95: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   98: putfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   101: aload 13
    //   103: aload_0
    //   104: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   107: putfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   110: ldc 21
    //   112: new 273	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 753
    //   119: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: iload_2
    //   123: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 755
    //   129: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_1
    //   133: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc_w 757
    //   139: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload_3
    //   143: invokevirtual 760	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   146: ldc_w 762
    //   149: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: iload 4
    //   154: invokevirtual 760	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   157: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 764	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload 13
    //   165: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   168: i2d
    //   169: dconst_1
    //   170: dmul
    //   171: iload_1
    //   172: i2d
    //   173: ddiv
    //   174: dstore 7
    //   176: aload 13
    //   178: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   181: i2d
    //   182: dconst_1
    //   183: dmul
    //   184: iload_2
    //   185: i2d
    //   186: ddiv
    //   187: dstore 9
    //   189: ldc 21
    //   191: new 273	java/lang/StringBuilder
    //   194: dup
    //   195: ldc_w 766
    //   198: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   201: dload 9
    //   203: invokevirtual 769	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   206: ldc_w 771
    //   209: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: dload 7
    //   214: invokevirtual 769	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   217: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: iload_3
    //   224: ifeq +109 -> 333
    //   227: dload 7
    //   229: dload 9
    //   231: dcmpl
    //   232: ifle +94 -> 326
    //   235: dload 9
    //   237: dstore 5
    //   239: aload 13
    //   241: dload 5
    //   243: d2i
    //   244: putfield 668	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   247: aload 13
    //   249: getfield 668	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   252: iconst_1
    //   253: if_icmpgt +9 -> 262
    //   256: aload 13
    //   258: iconst_1
    //   259: putfield 668	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   262: aload 13
    //   264: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   267: aload 13
    //   269: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   272: imul
    //   273: aload 13
    //   275: getfield 668	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   278: idiv
    //   279: aload 13
    //   281: getfield 668	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   284: idiv
    //   285: ldc 13
    //   287: if_icmple +68 -> 355
    //   290: aload 13
    //   292: aload 13
    //   294: getfield 668	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   297: iconst_1
    //   298: iadd
    //   299: putfield 668	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   302: goto -40 -> 262
    //   305: astore 14
    //   307: aload_0
    //   308: astore 13
    //   310: aload 14
    //   312: astore_0
    //   313: aload 13
    //   315: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   318: ldc_w 742
    //   321: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_0
    //   325: athrow
    //   326: dload 7
    //   328: dstore 5
    //   330: goto -91 -> 239
    //   333: dload 7
    //   335: dload 9
    //   337: dcmpg
    //   338: ifge +10 -> 348
    //   341: dload 9
    //   343: dstore 5
    //   345: goto -106 -> 239
    //   348: dload 7
    //   350: dstore 5
    //   352: goto -113 -> 239
    //   355: iload_3
    //   356: ifeq +363 -> 719
    //   359: dload 7
    //   361: dload 9
    //   363: dcmpl
    //   364: ifle +321 -> 685
    //   367: iload_2
    //   368: i2d
    //   369: dstore 5
    //   371: dload 5
    //   373: dconst_1
    //   374: dmul
    //   375: aload 13
    //   377: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   380: i2d
    //   381: dmul
    //   382: aload 13
    //   384: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   387: i2d
    //   388: ddiv
    //   389: invokestatic 775	java/lang/Math:ceil	(D)D
    //   392: d2i
    //   393: istore 12
    //   395: iload_2
    //   396: istore 11
    //   398: aload 13
    //   400: iconst_0
    //   401: putfield 657	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   404: ldc 21
    //   406: new 273	java/lang/StringBuilder
    //   409: dup
    //   410: ldc_w 777
    //   413: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: iload 11
    //   418: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: ldc_w 755
    //   424: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: iload 12
    //   429: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 779
    //   435: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 13
    //   440: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   443: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   446: ldc_w 755
    //   449: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload 13
    //   454: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   457: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc_w 781
    //   463: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload 13
    //   468: getfield 668	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   471: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 764	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_0
    //   481: iload 11
    //   483: iload 12
    //   485: iconst_1
    //   486: invokestatic 554	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   489: astore 14
    //   491: aload 14
    //   493: ifnull +406 -> 899
    //   496: aload 14
    //   498: astore 13
    //   500: iload 4
    //   502: ifeq +37 -> 539
    //   505: aload 14
    //   507: astore 13
    //   509: aload_0
    //   510: aload 14
    //   512: if_acmpeq +27 -> 539
    //   515: ldc 21
    //   517: ldc_w 783
    //   520: iconst_1
    //   521: anewarray 4	java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: aload_0
    //   527: aastore
    //   528: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: aload_0
    //   532: invokevirtual 336	android/graphics/Bitmap:recycle	()V
    //   535: aload 14
    //   537: astore 13
    //   539: iload_3
    //   540: ifeq +353 -> 893
    //   543: iload_2
    //   544: istore 11
    //   546: aload 13
    //   548: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   551: iload_2
    //   552: if_icmpge +40 -> 592
    //   555: ldc 21
    //   557: ldc_w 785
    //   560: iconst_2
    //   561: anewarray 4	java/lang/Object
    //   564: dup
    //   565: iconst_0
    //   566: aload 13
    //   568: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   571: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: aastore
    //   575: dup
    //   576: iconst_1
    //   577: iload_2
    //   578: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   581: aastore
    //   582: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   585: aload 13
    //   587: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   590: istore 11
    //   592: iload_1
    //   593: istore_2
    //   594: aload 13
    //   596: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   599: iload_1
    //   600: if_icmpge +39 -> 639
    //   603: ldc 21
    //   605: ldc_w 787
    //   608: iconst_2
    //   609: anewarray 4	java/lang/Object
    //   612: dup
    //   613: iconst_0
    //   614: aload 13
    //   616: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   619: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: aastore
    //   623: dup
    //   624: iconst_1
    //   625: iload_1
    //   626: invokestatic 321	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   629: aastore
    //   630: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   633: aload 13
    //   635: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   638: istore_2
    //   639: aload 13
    //   641: aload 13
    //   643: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   646: iload 11
    //   648: isub
    //   649: iconst_1
    //   650: ishr
    //   651: aload 13
    //   653: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   656: iload_2
    //   657: isub
    //   658: iconst_1
    //   659: ishr
    //   660: iload 11
    //   662: iload_2
    //   663: invokestatic 568	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   666: astore_0
    //   667: aload_0
    //   668: ifnonnull +123 -> 791
    //   671: aload 13
    //   673: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   676: ldc_w 742
    //   679: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   682: aload 13
    //   684: areturn
    //   685: iload_1
    //   686: i2d
    //   687: dstore 5
    //   689: dload 5
    //   691: dconst_1
    //   692: dmul
    //   693: aload 13
    //   695: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   698: i2d
    //   699: dmul
    //   700: aload 13
    //   702: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   705: i2d
    //   706: ddiv
    //   707: invokestatic 775	java/lang/Math:ceil	(D)D
    //   710: d2i
    //   711: istore 11
    //   713: iload_1
    //   714: istore 12
    //   716: goto -318 -> 398
    //   719: dload 7
    //   721: dload 9
    //   723: dcmpg
    //   724: ifge +33 -> 757
    //   727: iload_2
    //   728: i2d
    //   729: dconst_1
    //   730: dmul
    //   731: aload 13
    //   733: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   736: i2d
    //   737: dmul
    //   738: aload 13
    //   740: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   743: i2d
    //   744: ddiv
    //   745: invokestatic 775	java/lang/Math:ceil	(D)D
    //   748: d2i
    //   749: istore 12
    //   751: iload_2
    //   752: istore 11
    //   754: goto -356 -> 398
    //   757: iload_1
    //   758: i2d
    //   759: dconst_1
    //   760: dmul
    //   761: aload 13
    //   763: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   766: i2d
    //   767: dmul
    //   768: aload 13
    //   770: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   773: i2d
    //   774: ddiv
    //   775: invokestatic 775	java/lang/Math:ceil	(D)D
    //   778: dstore 5
    //   780: dload 5
    //   782: d2i
    //   783: istore 11
    //   785: iload_1
    //   786: istore 12
    //   788: goto -390 -> 398
    //   791: iload 4
    //   793: ifeq +31 -> 824
    //   796: aload 13
    //   798: aload_0
    //   799: if_acmpeq +25 -> 824
    //   802: ldc 21
    //   804: ldc_w 789
    //   807: iconst_1
    //   808: anewarray 4	java/lang/Object
    //   811: dup
    //   812: iconst_0
    //   813: aload 13
    //   815: aastore
    //   816: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   819: aload 13
    //   821: invokevirtual 336	android/graphics/Bitmap:recycle	()V
    //   824: ldc 21
    //   826: new 273	java/lang/StringBuilder
    //   829: dup
    //   830: ldc_w 791
    //   833: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   836: aload_0
    //   837: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   840: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc_w 755
    //   846: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_0
    //   850: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   853: invokevirtual 749	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   862: aload_0
    //   863: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   866: ldc_w 742
    //   869: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: aload_0
    //   873: areturn
    //   874: astore_0
    //   875: goto -562 -> 313
    //   878: astore 13
    //   880: aload_0
    //   881: astore 14
    //   883: aload 13
    //   885: astore_0
    //   886: aload 14
    //   888: astore 13
    //   890: goto -577 -> 313
    //   893: aload 13
    //   895: astore_0
    //   896: goto -34 -> 862
    //   899: aload_0
    //   900: astore 13
    //   902: goto -363 -> 539
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	905	0	paramBitmap	Bitmap
    //   0	905	1	paramInt1	int
    //   0	905	2	paramInt2	int
    //   0	905	3	paramBoolean1	boolean
    //   0	905	4	paramBoolean2	boolean
    //   237	544	5	d1	double
    //   174	546	7	d2	double
    //   187	535	9	d3	double
    //   396	388	11	i	int
    //   393	394	12	j	int
    //   85	735	13	localObject1	Object
    //   878	6	13	localObject2	Object
    //   888	13	13	localObject3	Object
    //   305	6	14	localObject4	Object
    //   489	398	14	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   34	66	305	finally
    //   78	223	305	finally
    //   239	262	305	finally
    //   262	302	305	finally
    //   371	395	305	finally
    //   398	491	305	finally
    //   515	535	305	finally
    //   689	713	305	finally
    //   727	751	305	finally
    //   757	780	305	finally
    //   546	592	874	finally
    //   594	639	874	finally
    //   639	667	874	finally
    //   802	824	874	finally
    //   824	862	878	finally
  }
  
  /* Error */
  public static Bitmap extractThumbNail(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 794
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 484	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 21
    //   15: ldc_w 796
    //   18: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 794
    //   24: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: aload_0
    //   30: invokestatic 800	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   33: astore 4
    //   35: aload_0
    //   36: invokestatic 615	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_0
    //   40: aload_0
    //   41: aload 4
    //   43: aload 4
    //   45: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   48: aload 4
    //   50: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   53: iload_2
    //   54: iload_1
    //   55: iload_3
    //   56: invokestatic 804	com/tencent/mm/sdk/platformtools/BitmapUtil:extractThumbNailFromStream	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;IIIIZ)Landroid/graphics/Bitmap;
    //   59: astore 4
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 602	java/io/InputStream:close	()V
    //   69: ldc_w 794
    //   72: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload 4
    //   77: areturn
    //   78: astore 4
    //   80: aconst_null
    //   81: astore_0
    //   82: ldc 21
    //   84: aload 4
    //   86: ldc_w 806
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 602	java/io/InputStream:close	()V
    //   104: ldc_w 794
    //   107: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 602	java/io/InputStream:close	()V
    //   124: ldc_w 794
    //   127: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload 4
    //   132: athrow
    //   133: astore_0
    //   134: goto -65 -> 69
    //   137: astore_0
    //   138: goto -34 -> 104
    //   141: astore_0
    //   142: goto -18 -> 124
    //   145: astore 4
    //   147: goto -31 -> 116
    //   150: astore 4
    //   152: goto -36 -> 116
    //   155: astore 4
    //   157: goto -75 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramString	String
    //   0	160	1	paramInt1	int
    //   0	160	2	paramInt2	int
    //   0	160	3	paramBoolean	boolean
    //   33	43	4	localObject1	Object
    //   78	7	4	localFileNotFoundException1	FileNotFoundException
    //   112	19	4	localObject2	Object
    //   145	1	4	localObject3	Object
    //   150	1	4	localObject4	Object
    //   155	1	4	localFileNotFoundException2	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   29	40	78	java/io/FileNotFoundException
    //   29	40	112	finally
    //   65	69	133	java/io/IOException
    //   100	104	137	java/io/IOException
    //   120	124	141	java/io/IOException
    //   40	61	145	finally
    //   82	96	150	finally
    //   40	61	155	java/io/FileNotFoundException
  }
  
  public static Bitmap extractThumbNailAssets(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215324);
    paramInputStream = getBitmapNative(0, null, null, null, paramInputStream, true, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(215324);
    return paramInputStream;
  }
  
  public static Bitmap extractThumbNailAssets(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156141);
    paramString = getBitmapNative(0, paramString, null, null, true, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(156141);
    return paramString;
  }
  
  @TargetApi(11)
  public static Bitmap extractThumbNailFromStream(InputStream paramInputStream, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(215323);
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      Log.e("MicroMsg.BitmapUtil", "extractThumbNail height:" + paramInt2 + " width:" + paramInt1);
      AppMethodBeat.o(215323);
      return null;
    }
    localObject = paramInputStream;
    if (!paramInputStream.markSupported())
    {
      if (!(paramInputStream instanceof FileInputStream)) {
        break label204;
      }
      localObject = new FileSeekingInputStream((FileInputStream)paramInputStream);
    }
    for (;;)
    {
      paramInputStream = new BitmapFactory.Options();
      try
      {
        paramInputStream.inJustDecodeBounds = true;
        ((InputStream)localObject).mark(8388608);
        localBitmap = MMBitmapFactory.decodeStream((InputStream)localObject, null, paramInputStream);
        ((InputStream)localObject).reset();
        if (localBitmap != null)
        {
          Log.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle, adsf. %s", new Object[] { localBitmap });
          localBitmap.recycle();
        }
        if ((paramInputStream.outHeight <= 0) || (paramInputStream.outWidth <= 0))
        {
          Log.e("MicroMsg.BitmapUtil", "decode[%s] error, outHeight[%d] outWidth[%d]", new Object[] { localObject, Integer.valueOf(paramInputStream.outHeight), Integer.valueOf(paramInputStream.outWidth) });
          AppMethodBeat.o(215323);
          return null;
          label204:
          localObject = paramInputStream;
          if (!paramInputStream.markSupported()) {
            localObject = new BufferedInputStream(paramInputStream);
          }
        }
        else
        {
          Log.i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + paramInt1 + "x" + paramInt2 + ", crop=" + paramBoolean);
          d2 = paramInputStream.outHeight * 1.0D / paramInt2;
          d3 = paramInputStream.outWidth * 1.0D / paramInt1;
          Log.d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d3 + ", beY = " + d2);
          if (!paramBoolean) {
            break label441;
          }
          if (d2 <= d3) {
            break label434;
          }
          d1 = d3;
        }
      }
      catch (OutOfMemoryError paramInputStream)
      {
        double d2;
        double d3;
        for (;;)
        {
          Log.e("MicroMsg.BitmapUtil", "decode bitmap failed: " + paramInputStream.getMessage());
          AppMethodBeat.o(215323);
          return null;
          d1 = d2;
          continue;
          if (d2 < d3) {
            d1 = d3;
          } else {
            d1 = d2;
          }
        }
        if (!paramBoolean) {
          break label662;
        }
        if (d2 <= d3) {
          break label630;
        }
        double d1 = paramInt1;
        j = (int)Math.ceil(d1 * 1.0D * paramInputStream.outHeight / paramInputStream.outWidth);
        i = paramInt1;
        break label1143;
        paramInputStream.inJustDecodeBounds = false;
        if (Build.VERSION.SDK_INT < 11) {
          break label525;
        }
        paramInputStream.inMutable = true;
        Log.i("MicroMsg.BitmapUtil", "bitmap required size=" + i + "x" + j + ", orig=" + paramInputStream.outWidth + "x" + paramInputStream.outHeight + ", sample=" + paramInputStream.inSampleSize);
        bindlowMemeryOption(paramInputStream);
        paramInputStream = MMBitmapFactory.decodeStream((InputStream)localObject, null, paramInputStream);
        if (paramInputStream != null) {
          break label726;
        }
        Log.e("MicroMsg.BitmapUtil", "bitmap decode failed");
        AppMethodBeat.o(215323);
        return null;
        d1 = paramInt2;
        i = (int)Math.ceil(d1 * 1.0D * paramInputStream.outWidth / paramInputStream.outHeight);
        j = paramInt2;
        break label1143;
        if (d2 >= d3) {
          break label698;
        }
        j = (int)Math.ceil(paramInt1 * 1.0D * paramInputStream.outHeight / paramInputStream.outWidth);
        i = paramInt1;
        break label1143;
        i = (int)Math.ceil(paramInt2 * 1.0D * paramInputStream.outWidth / paramInputStream.outHeight);
        j = paramInt2;
        break label1143;
        Log.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + paramInputStream.getWidth() + "x" + paramInputStream.getHeight());
        localObject = Bitmap.createScaledBitmap(paramInputStream, i, j, true);
        if ((paramInputStream == localObject) || (localObject == null)) {
          break label1140;
        }
        Log.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfad. %s", new Object[] { paramInputStream });
        paramInputStream.recycle();
        paramInputStream = (InputStream)localObject;
        localObject = paramInputStream;
        if (!paramBoolean) {
          break label1104;
        }
        i = paramInt1;
        if (paramInputStream.getWidth() >= paramInt1) {
          break label862;
        }
        Log.e("MicroMsg.BitmapUtil", "bmw < width %d %d", new Object[] { Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInt1) });
        i = paramInputStream.getWidth();
        j = paramInt2;
        if (paramInputStream.getHeight() >= paramInt2) {
          break label908;
        }
        Log.e("MicroMsg.BitmapUtil", "bmh < height %d %d", new Object[] { Integer.valueOf(paramInputStream.getHeight()), Integer.valueOf(paramInt2) });
        j = paramInputStream.getHeight();
        paramInt2 = paramInputStream.getWidth() - i >> 1;
        n = paramInputStream.getHeight() - j >> 1;
        if (paramInt2 < 0) {
          break label945;
        }
        k = n;
        m = paramInt2;
        if (n >= 0) {
          break label1004;
        }
        Log.e("MicroMsg.BitmapUtil", "fix crop image error %d %d %d %d", new Object[] { Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInputStream.getHeight()), Integer.valueOf(i), Integer.valueOf(j) });
        paramInt1 = paramInt2;
        if (paramInt2 >= 0) {
          break label1168;
        }
        paramInt1 = 0;
        break label1168;
        Bitmap localBitmap = Bitmap.createBitmap(paramInputStream, m, k, i, j);
        if (localBitmap != null) {
          break label1031;
        }
        AppMethodBeat.o(215323);
        return paramInputStream;
        localObject = paramInputStream;
        if (localBitmap == paramInputStream) {
          break label1064;
        }
        Log.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfaasdfad. %s", new Object[] { paramInputStream });
        paramInputStream.recycle();
        localObject = localBitmap;
        Log.d("MicroMsg.BitmapUtil", "bitmap croped size=" + ((Bitmap)localObject).getWidth() + "x" + ((Bitmap)localObject).getHeight());
        setBitmapDensity((Bitmap)localObject);
        paramInputStream = BitmapTracer.trace((Bitmap)localObject);
        AppMethodBeat.o(215323);
        return paramInputStream;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          int j;
          int n;
          Log.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "Failed decode bitmap", new Object[0]);
          continue;
          continue;
          if (j > 0) {}
          for (;;)
          {
            if (i <= 0) {
              break label1162;
            }
            break;
            j = 1;
          }
          int i = 1;
          continue;
          int k = n;
          int m = paramInt1;
          if (n < 0)
          {
            k = 0;
            m = paramInt1;
          }
        }
      }
    }
    paramInputStream.inSampleSize = ((int)d1);
    if (paramInputStream.inSampleSize <= 1) {}
    for (paramInputStream.inSampleSize = 1; paramInputStream.outHeight * paramInputStream.outWidth / paramInputStream.inSampleSize / paramInputStream.inSampleSize > 2764800; paramInputStream.inSampleSize += 1) {}
  }
  
  @TargetApi(11)
  public static Bitmap extractThumbNailFromStream(InputStream paramInputStream, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(215322);
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      Log.e("MicroMsg.BitmapUtil", "extractThumbNail height:" + paramInt4 + " width:" + paramInt3);
      AppMethodBeat.o(215322);
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      Log.e("MicroMsg.BitmapUtil", "decode[%s] error, outHeight[%d] outWidth[%d]", new Object[] { paramInputStream, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(215322);
      return null;
    }
    Object localObject;
    double d2;
    double d3;
    double d1;
    for (;;)
    {
      try
      {
        localObject = new BitmapFactory.Options();
        if ((Build.VERSION.SDK_INT > 26) && (paramOptions != null) && ((paramOptions.outColorSpace == ColorSpace.get(ColorSpace.Named.DCI_P3)) || (paramOptions.outColorSpace == ColorSpace.get(ColorSpace.Named.DISPLAY_P3)))) {
          ((BitmapFactory.Options)localObject).inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Log.i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + paramInt3 + "x" + paramInt4 + ", crop=" + paramBoolean);
        d2 = paramInt2 * 1.0D / paramInt4;
        d3 = paramInt1 * 1.0D / paramInt3;
        Log.d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d3 + ", beY = " + d2);
        if (!paramBoolean) {
          break label377;
        }
        if (d2 > d3)
        {
          d1 = d3;
          ((BitmapFactory.Options)localObject).inSampleSize = ((int)d1);
          if (((BitmapFactory.Options)localObject).inSampleSize <= 1) {
            ((BitmapFactory.Options)localObject).inSampleSize = 1;
          }
          if (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject).inSampleSize / ((BitmapFactory.Options)localObject).inSampleSize <= 2764800) {
            break;
          }
          ((BitmapFactory.Options)localObject).inSampleSize += 1;
          continue;
        }
        d1 = d2;
      }
      catch (OutOfMemoryError paramInputStream)
      {
        Log.e("MicroMsg.BitmapUtil", "decode bitmap failed: " + paramInputStream.getMessage());
        AppMethodBeat.o(215322);
        return null;
      }
      continue;
      label377:
      if (d2 < d3) {
        d1 = d3;
      } else {
        d1 = d2;
      }
    }
    int j;
    int i;
    if (paramBoolean)
    {
      if (d2 > d3)
      {
        d1 = paramInt3 * 1.0D * paramInt2 / paramInt1;
        j = (int)Math.ceil(d1);
        i = paramInt3;
        break label1035;
        if (Build.VERSION.SDK_INT >= 11) {
          ((BitmapFactory.Options)localObject).inMutable = true;
        }
        Log.i("MicroMsg.BitmapUtil", "bitmap required size=" + i + "x" + j + ", orig=" + paramInt1 + "x" + paramInt2 + ", sample=" + ((BitmapFactory.Options)localObject).inSampleSize);
        bindlowMemeryOption((BitmapFactory.Options)localObject);
        paramInputStream = MMBitmapFactory.decodeStream(paramInputStream, null, (BitmapFactory.Options)localObject);
        if (paramInputStream == null)
        {
          Log.e("MicroMsg.BitmapUtil", "bitmap decode failed");
          AppMethodBeat.o(215322);
          return null;
        }
      }
      else
      {
        d1 = paramInt4 * 1.0D * paramInt1 / paramInt2;
        i = (int)Math.ceil(d1);
        j = paramInt4;
        break label1035;
      }
    }
    else
    {
      if (d2 < d3)
      {
        j = (int)Math.ceil(paramInt3 * 1.0D * paramInt2 / paramInt1);
        i = paramInt3;
        break label1035;
      }
      i = (int)Math.ceil(paramInt4 * 1.0D * paramInt1 / paramInt2);
      j = paramInt4;
      break label1035;
    }
    Log.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + paramInputStream.getWidth() + "x" + paramInputStream.getHeight());
    paramOptions = Bitmap.createScaledBitmap(paramInputStream, i, j, true);
    label718:
    int k;
    if ((paramInputStream != paramOptions) && (paramOptions != null))
    {
      Log.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfad. %s", new Object[] { paramInputStream });
      paramInputStream.recycle();
      paramInputStream = paramOptions;
      paramOptions = paramInputStream;
      if (paramBoolean)
      {
        paramInt2 = paramInt3;
        if (paramInputStream.getWidth() < paramInt3)
        {
          Log.e("MicroMsg.BitmapUtil", "bmw < width %d %d", new Object[] { Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInt3) });
          paramInt2 = paramInputStream.getWidth();
        }
        paramInt3 = paramInt4;
        if (paramInputStream.getHeight() < paramInt4)
        {
          Log.e("MicroMsg.BitmapUtil", "bmh < height %d %d", new Object[] { Integer.valueOf(paramInputStream.getHeight()), Integer.valueOf(paramInt4) });
          paramInt3 = paramInputStream.getHeight();
        }
        paramInt4 = paramInputStream.getWidth() - paramInt2 >> 1;
        k = paramInputStream.getHeight() - paramInt3 >> 1;
        if (paramInt4 >= 0)
        {
          i = k;
          j = paramInt4;
          if (k >= 0) {}
        }
        else
        {
          Log.e("MicroMsg.BitmapUtil", "fix crop image error %d %d %d %d", new Object[] { Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInputStream.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramInt1 = paramInt4;
          if (paramInt4 >= 0) {
            break label1060;
          }
          paramInt1 = 0;
          break label1060;
        }
      }
    }
    for (;;)
    {
      localObject = Bitmap.createBitmap(paramInputStream, j, i, paramInt2, paramInt3);
      if (localObject == null)
      {
        AppMethodBeat.o(215322);
        return paramInputStream;
      }
      paramOptions = paramInputStream;
      if (localObject != paramInputStream)
      {
        Log.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfaasdfad. %s", new Object[] { paramInputStream });
        paramInputStream.recycle();
        paramOptions = (BitmapFactory.Options)localObject;
      }
      Log.d("MicroMsg.BitmapUtil", "bitmap croped size=" + paramOptions.getWidth() + "x" + paramOptions.getHeight());
      setBitmapDensity(paramOptions);
      paramInputStream = BitmapTracer.trace(paramOptions);
      AppMethodBeat.o(215322);
      return paramInputStream;
      break label718;
      label1035:
      if (j > 0) {}
      for (;;)
      {
        if (i <= 0) {
          break label1054;
        }
        break;
        j = 1;
      }
      label1054:
      i = 1;
      break;
      label1060:
      i = k;
      j = paramInt1;
      if (k < 0)
      {
        i = 0;
        j = paramInt1;
      }
    }
  }
  
  public static Bitmap extractThumeNail(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    float f1 = 2.5F;
    AppMethodBeat.i(215313);
    float f2;
    int i;
    int j;
    Bitmap localBitmap;
    if (paramBitmap.getHeight() >= paramBitmap.getWidth())
    {
      f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      if (f2 <= 2.0F)
      {
        i = (int)(paramInt1 * 1.0D * paramBitmap.getWidth() / paramBitmap.getHeight());
        j = paramInt1;
        Log.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + paramBitmap.getWidth() + "x" + paramBitmap.getHeight());
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
        if ((localBitmap == null) || (paramBitmap == localBitmap)) {
          break label439;
        }
        Log.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle. %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
        paramBitmap = localBitmap;
        label147:
        if (!paramBoolean) {
          break label436;
        }
        localBitmap = Bitmap.createBitmap(paramBitmap, paramBitmap.getWidth() - paramInt2 >> 1, paramBitmap.getHeight() - paramInt1 >> 1, paramInt2, paramInt1);
        if (localBitmap != null) {
          break label359;
        }
        AppMethodBeat.o(215313);
        return paramBitmap;
      }
      if (f2 <= 2.5D) {
        break label449;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, (paramBitmap.getHeight() - (int)(paramBitmap.getWidth() * 2.5F)) / 2, paramBitmap.getWidth(), (int)(paramBitmap.getWidth() * 2.5F));
    }
    for (;;)
    {
      j = (int)(f1 * 56.0F);
      i = 56;
      break;
      f2 = paramBitmap.getWidth() / paramBitmap.getHeight();
      if (f2 <= 2.0F)
      {
        j = (int)(paramInt2 * 1.0D * paramBitmap.getHeight() / paramBitmap.getWidth());
        i = paramInt2;
        break;
      }
      if (f2 > 2.5D) {
        paramBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - (int)(paramBitmap.getHeight() * 2.5F)) / 2, 0, (int)(paramBitmap.getHeight() * 2.5F), paramBitmap.getHeight());
      }
      for (;;)
      {
        i = (int)(f1 * 56.0F);
        j = 56;
        break;
        label359:
        if (paramBitmap != localBitmap)
        {
          Log.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle 2. %s", new Object[] { paramBitmap });
          paramBitmap.recycle();
        }
        Log.d("MicroMsg.BitmapUtil", "bitmap croped size=" + localBitmap.getWidth() + "x" + localBitmap.getHeight());
        paramBitmap = localBitmap;
        label436:
        for (;;)
        {
          AppMethodBeat.o(215313);
          return paramBitmap;
        }
        label439:
        break label147;
        f1 = f2;
      }
      label449:
      f1 = f2;
    }
  }
  
  public static Bitmap fastBlurBitmap(Bitmap paramBitmap, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(215338);
    paramBitmap = fastBlurBitmap(paramBitmap, paramFloat, paramInt, false, -1L);
    AppMethodBeat.o(215338);
    return paramBitmap;
  }
  
  public static Bitmap fastBlurBitmap(Bitmap paramBitmap, float paramFloat, int paramInt, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(215339);
    long l = System.currentTimeMillis();
    int j = Math.round(paramBitmap.getWidth() * paramFloat);
    int k = Math.round(paramBitmap.getHeight() * paramFloat);
    if (j > 10)
    {
      i = k;
      if (k > 10) {}
    }
    else
    {
      j = paramBitmap.getWidth();
      i = paramBitmap.getHeight();
    }
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, j, i, false);
    paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(215339);
      return null;
    }
    int i13 = paramBitmap.getWidth();
    int i14 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i13 * i14];
    Log.d("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap w: %d, h: %d, length: %d", new Object[] { Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(arrayOfInt1.length) });
    paramBitmap.getPixels(arrayOfInt1, 0, i13, 0, 0, i13, i14);
    int i18 = i13 - 1;
    int i15 = i14 - 1;
    if ((i18 <= 0) || (i15 <= 0))
    {
      AppMethodBeat.o(215339);
      return null;
    }
    int i = i13 * i14;
    int i16 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i13, i14)];
    i = i16 + 1 >> 1;
    j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i16, 3 });
    int i17 = paramInt + 1;
    int i6 = 0;
    int i5 = 0;
    int i7 = 0;
    int i8;
    int i4;
    int i2;
    int m;
    int i3;
    int n;
    int i1;
    int i9;
    int[] arrayOfInt7;
    int i12;
    int i10;
    int i11;
    while (i6 < i14)
    {
      if ((paramBoolean) && (checkTimeout(l, paramLong)))
      {
        Log.e("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap timeOut and return null");
        AppMethodBeat.o(215339);
        return null;
      }
      i8 = -paramInt;
      i4 = 0;
      i2 = 0;
      m = 0;
      i3 = 0;
      n = 0;
      k = 0;
      i = 0;
      j = 0;
      i1 = 0;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i18, Math.max(i8, 0)) + i7)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i17 - Math.abs(i8);
        i1 += arrayOfInt7[0] * i9;
        i += arrayOfInt7[1] * i9;
        j += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          i4 += arrayOfInt7[0];
          i2 += arrayOfInt7[1];
          m += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i3 += arrayOfInt7[0];
          n += arrayOfInt7[1];
          k += arrayOfInt7[2];
        }
      }
      if ((paramBoolean) && (checkTimeout(l, paramLong)))
      {
        Log.e("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap timeOut and return null");
        AppMethodBeat.o(215339);
        return null;
      }
      i12 = 0;
      i9 = i4;
      i8 = i2;
      i4 = m;
      i10 = i3;
      i11 = n;
      n = paramInt;
      i3 = i1;
      i1 = j;
      i2 = i;
      m = k;
      i = i11;
      j = i10;
      k = i12;
      while (k < i13)
      {
        arrayOfInt2[i7] = arrayOfInt6[i3];
        arrayOfInt3[i7] = arrayOfInt6[i2];
        arrayOfInt4[i7] = arrayOfInt6[i1];
        arrayOfInt7 = arrayOfInt[((n - paramInt + i16) % i16)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        int i20 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[k] = Math.min(k + paramInt + 1, i18);
        }
        i12 = arrayOfInt1[(arrayOfInt5[k] + i5)];
        arrayOfInt7[0] = ((0xFF0000 & i12) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i12) >> 8);
        arrayOfInt7[2] = (i12 & 0xFF);
        i9 += arrayOfInt7[0];
        i8 += arrayOfInt7[1];
        i4 = arrayOfInt7[2] + i4;
        i3 = i3 - j + i9;
        i2 = i2 - i + i8;
        i1 = i1 - m + i4;
        n = (n + 1) % i16;
        arrayOfInt7 = arrayOfInt[(n % i16)];
        int i19 = arrayOfInt7[0];
        i12 = arrayOfInt7[1];
        m = m - i20 + arrayOfInt7[2];
        int i22 = arrayOfInt7[0];
        int i21 = arrayOfInt7[1];
        i20 = arrayOfInt7[2];
        i7 += 1;
        k += 1;
        i9 -= i22;
        i8 -= i21;
        i4 -= i20;
        j = j - i11 + i19;
        i = i - i10 + i12;
      }
      i6 += 1;
      i5 += i13;
    }
    i = 0;
    while (i < i13)
    {
      i7 = -paramInt * i13;
      if ((paramBoolean) && (checkTimeout(l, paramLong)))
      {
        Log.e("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap timeOut and return null");
        AppMethodBeat.o(215339);
        return null;
      }
      i6 = -paramInt;
      i4 = 0;
      k = 0;
      j = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i5 = 0;
      if (i6 <= paramInt)
      {
        i9 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i9];
        arrayOfInt7[1] = arrayOfInt3[i9];
        arrayOfInt7[2] = arrayOfInt4[i9];
        i10 = i17 - Math.abs(i6);
        i5 += arrayOfInt2[i9] * i10;
        i8 = i2 + arrayOfInt3[i9] * i10;
        i3 += arrayOfInt4[i9] * i10;
        if (i6 > 0)
        {
          i4 += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i2 = i7;
          if (i6 < i15) {
            i2 = i7 + i13;
          }
          i6 += 1;
          i7 = i2;
          i2 = i8;
          break;
          m += arrayOfInt7[0];
          n += arrayOfInt7[1];
          i1 += arrayOfInt7[2];
        }
      }
      if ((paramBoolean) && (checkTimeout(l, paramLong)))
      {
        Log.e("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap timeOut and return null");
        AppMethodBeat.o(215339);
        return null;
      }
      i9 = 0;
      i8 = i4;
      i4 = i;
      i6 = paramInt;
      i7 = i5;
      i5 = i4;
      i4 = i9;
      while (i4 < i14)
      {
        arrayOfInt1[i5] = (0xFF000000 & arrayOfInt1[i5] | arrayOfInt6[i7] << 16 | arrayOfInt6[i2] << 8 | arrayOfInt6[i3]);
        arrayOfInt7 = arrayOfInt[((i6 - paramInt + i16) % i16)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[i4] = (Math.min(i4 + i17, i15) * i13);
        }
        i12 = arrayOfInt5[i4] + i;
        arrayOfInt7[0] = arrayOfInt2[i12];
        arrayOfInt7[1] = arrayOfInt3[i12];
        arrayOfInt7[2] = arrayOfInt4[i12];
        i8 += arrayOfInt7[0];
        k += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i7 = i7 - m + i8;
        i2 = i2 - n + k;
        i3 = i3 - i1 + j;
        i6 = (i6 + 1) % i16;
        arrayOfInt7 = arrayOfInt[i6];
        m = m - i11 + arrayOfInt7[0];
        n = n - i10 + arrayOfInt7[1];
        i1 = i1 - i9 + arrayOfInt7[2];
        i8 -= arrayOfInt7[0];
        i9 = arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i5 += i13;
        i4 += 1;
        k -= i9;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i13, 0, 0, i13, i14);
    AppMethodBeat.o(215339);
    return paramBitmap;
  }
  
  public static Bitmap fastblur(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(156166);
    if (paramBitmap == null)
    {
      Log.w("MicroMsg.BitmapUtil", "fastblur: but sentBitmap is null");
      AppMethodBeat.o(156166);
      return null;
    }
    paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(156166);
      return null;
    }
    int i13 = paramBitmap.getWidth();
    int i14 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i13 * i14];
    Log.e("pix", i13 + " " + i14 + " " + arrayOfInt1.length);
    paramBitmap.getPixels(arrayOfInt1, 0, i13, 0, 0, i13, i14);
    int i19 = i13 - 1;
    int i15 = i14 - 1;
    int i16 = i13 * i14;
    int i17 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i16];
    int[] arrayOfInt3 = new int[i16];
    int[] arrayOfInt4 = new int[i16];
    int[] arrayOfInt5 = new int[Math.max(i13, i14)];
    int i = i17 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i17, 3 });
    int i18 = paramInt + 1;
    int i6 = 0;
    int i5 = 0;
    int i7 = 0;
    int i8;
    int i4;
    int i2;
    int m;
    int i3;
    int n;
    int k;
    int i1;
    int i9;
    int[] arrayOfInt7;
    int i12;
    int i10;
    int i11;
    while (i6 < i14)
    {
      i8 = -paramInt;
      i4 = 0;
      i2 = 0;
      m = 0;
      i3 = 0;
      n = 0;
      k = 0;
      i = 0;
      j = 0;
      i1 = 0;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i19, Math.max(i8, 0)) + i7)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i18 - Math.abs(i8);
        i1 += arrayOfInt7[0] * i9;
        i += arrayOfInt7[1] * i9;
        j += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          i4 += arrayOfInt7[0];
          i2 += arrayOfInt7[1];
          m += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i3 += arrayOfInt7[0];
          n += arrayOfInt7[1];
          k += arrayOfInt7[2];
        }
      }
      i12 = 0;
      i9 = i4;
      i8 = i2;
      i4 = m;
      i10 = i3;
      i11 = n;
      n = paramInt;
      i3 = i1;
      i1 = j;
      i2 = i;
      m = k;
      i = i11;
      j = i10;
      k = i12;
      while (k < i13)
      {
        arrayOfInt2[i7] = arrayOfInt6[i3];
        arrayOfInt3[i7] = arrayOfInt6[i2];
        arrayOfInt4[i7] = arrayOfInt6[i1];
        arrayOfInt7 = arrayOfInt[((n - paramInt + i17) % i17)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        int i21 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[k] = Math.min(k + paramInt + 1, i19);
        }
        i12 = arrayOfInt1[(arrayOfInt5[k] + i5)];
        arrayOfInt7[0] = ((0xFF0000 & i12) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i12) >> 8);
        arrayOfInt7[2] = (i12 & 0xFF);
        i9 += arrayOfInt7[0];
        i8 += arrayOfInt7[1];
        i4 = arrayOfInt7[2] + i4;
        i3 = i3 - j + i9;
        i2 = i2 - i + i8;
        i1 = i1 - m + i4;
        n = (n + 1) % i17;
        arrayOfInt7 = arrayOfInt[(n % i17)];
        int i20 = arrayOfInt7[0];
        i12 = arrayOfInt7[1];
        m = m - i21 + arrayOfInt7[2];
        int i23 = arrayOfInt7[0];
        int i22 = arrayOfInt7[1];
        i21 = arrayOfInt7[2];
        i7 += 1;
        k += 1;
        i9 -= i23;
        i8 -= i22;
        i4 -= i21;
        j = j - i11 + i20;
        i = i - i10 + i12;
      }
      i6 += 1;
      i5 += i13;
    }
    i = 0;
    while (i < i13)
    {
      i7 = -paramInt * i13;
      i6 = -paramInt;
      i4 = 0;
      k = 0;
      j = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i5 = 0;
      if (i6 <= paramInt)
      {
        i9 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i9];
        arrayOfInt7[1] = arrayOfInt3[i9];
        arrayOfInt7[2] = arrayOfInt4[i9];
        i10 = i18 - Math.abs(i6);
        i5 += arrayOfInt2[i9] * i10;
        i8 = i2 + arrayOfInt3[i9] * i10;
        i3 += arrayOfInt4[i9] * i10;
        if (i6 > 0)
        {
          i4 += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i2 = i7;
          if (i6 < i15) {
            i2 = i7 + i13;
          }
          i6 += 1;
          i7 = i2;
          i2 = i8;
          break;
          m += arrayOfInt7[0];
          n += arrayOfInt7[1];
          i1 += arrayOfInt7[2];
        }
      }
      i9 = 0;
      i8 = i4;
      i4 = i;
      i6 = paramInt;
      i7 = i5;
      i5 = i4;
      i4 = i9;
      while (i4 < i14)
      {
        arrayOfInt1[i5] = (0xFF000000 & arrayOfInt1[i5] | arrayOfInt6[i7] << 16 | arrayOfInt6[i2] << 8 | arrayOfInt6[i3]);
        arrayOfInt7 = arrayOfInt[((i6 - paramInt + i17) % i17)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[i4] = (Math.min(i4 + i18, i15) * i13);
        }
        i12 = arrayOfInt5[i4] + i;
        arrayOfInt7[0] = arrayOfInt2[i12];
        arrayOfInt7[1] = arrayOfInt3[i12];
        arrayOfInt7[2] = arrayOfInt4[i12];
        i8 += arrayOfInt7[0];
        k += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i7 = i7 - m + i8;
        i2 = i2 - n + k;
        i3 = i3 - i1 + j;
        i6 = (i6 + 1) % i17;
        arrayOfInt7 = arrayOfInt[i6];
        m = m - i11 + arrayOfInt7[0];
        n = n - i10 + arrayOfInt7[1];
        i1 = i1 - i9 + arrayOfInt7[2];
        i8 -= arrayOfInt7[0];
        i9 = arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i5 += i13;
        i4 += 1;
        k -= i9;
      }
      i += 1;
    }
    Log.e("pix", i13 + " " + i14 + " " + i16);
    paramBitmap.setPixels(arrayOfInt1, 0, i13, 0, 0, i13, i14);
    setBitmapDensity(paramBitmap);
    paramBitmap = BitmapTracer.trace(paramBitmap);
    AppMethodBeat.o(156166);
    return paramBitmap;
  }
  
  public static Bitmap getBitmapFromRect(Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(215327);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(215327);
      return null;
    }
    setBitmapDensity(paramBitmap);
    try
    {
      paramRect = Bitmap.createBitmap(paramBitmap, 0, 0, paramRect.width(), paramRect.height(), null, false);
      if (paramBoolean)
      {
        Log.i("MicroMsg.BitmapUtil", "getBitmapFromRect bitmap recycle %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      setBitmapDensity(paramRect);
      paramBitmap = BitmapTracer.trace(paramRect);
      AppMethodBeat.o(215327);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      Log.printErrStackTrace("MicroMsg.BitmapUtil", paramBitmap, "getBitmapFromRect exception", new Object[0]);
      AppMethodBeat.o(215327);
    }
    return null;
  }
  
  public static Bitmap getBitmapFromView(View paramView)
  {
    AppMethodBeat.i(156157);
    if (paramView == null)
    {
      AppMethodBeat.o(156157);
      return null;
    }
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0))
    {
      AppMethodBeat.o(156157);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    }
    paramView.draw(localCanvas);
    setBitmapDensity(localBitmap);
    paramView = BitmapTracer.trace(localBitmap);
    AppMethodBeat.o(156157);
    return paramView;
  }
  
  public static Bitmap getBitmapNative(int paramInt)
  {
    AppMethodBeat.i(156116);
    Bitmap localBitmap = getBitmapNative(paramInt, null, null, null, false, 0.0F, 0, 0);
    AppMethodBeat.o(156116);
    return localBitmap;
  }
  
  public static Bitmap getBitmapNative(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(156117);
    Bitmap localBitmap = getBitmapNative(paramInt, null, null, null, false, paramFloat, 0, 0);
    AppMethodBeat.o(156117);
    return localBitmap;
  }
  
  public static Bitmap getBitmapNative(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156118);
    Bitmap localBitmap = getBitmapNative(paramInt1, null, null, null, false, 0.0F, paramInt2, paramInt3);
    AppMethodBeat.o(156118);
    return localBitmap;
  }
  
  private static Bitmap getBitmapNative(int paramInt1, String paramString, byte[] paramArrayOfByte, Uri paramUri, InputStream paramInputStream, boolean paramBoolean, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156136);
    int i2 = 0;
    int i1 = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    for (int k = 1; (paramInt2 < 0) || (paramInt3 < 0); k = 0)
    {
      AppMethodBeat.o(156136);
      return null;
    }
    if (paramInputStream != null) {}
    for (;;)
    {
      int i;
      BitmapFactory.Options localOptions2;
      int j;
      int m;
      int n;
      try
      {
        if (paramInputStream.markSupported()) {
          break label485;
        }
        if ((paramInputStream instanceof FileInputStream))
        {
          localObject1 = new FileSeekingInputStream((FileInputStream)paramInputStream);
          paramInputStream = (InputStream)localObject1;
          i = i2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        paramInt2 = 0;
        Log.printErrStackTrace("MicroMsg.BitmapUtil", localThrowable1, "", new Object[0]);
        BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
        if (paramFloat != 0.0F) {
          localOptions1.inDensity = ((int)(160.0F * paramFloat));
        }
        localOptions1.inPreferredConfig = Bitmap.Config.RGB_565;
        if ((k == 0) && (paramInt2 != 0)) {
          localOptions1.inSampleSize = paramInt2;
        }
        bindlowMemeryOption(localOptions1);
        try
        {
          paramString = decodeBitmap(localOptions1, paramArrayOfByte, paramString, paramUri, paramInputStream, paramBoolean, paramInt1);
        }
        catch (Throwable paramString)
        {
          Log.printErrStackTrace("MicroMsg.BitmapUtil", paramString, "", new Object[0]);
          paramString = null;
        }
        continue;
      }
      finally
      {
        setBitmapDensity(null);
        AppMethodBeat.o(156136);
      }
      try
      {
        localOptions2 = new BitmapFactory.Options();
        if (paramFloat != 0.0F)
        {
          i = i2;
          localOptions2.inDensity = ((int)(160.0F * paramFloat));
        }
        localObject1 = localOptions2;
        j = i1;
        if (k == 0)
        {
          i = i2;
          localOptions2.inJustDecodeBounds = true;
          i = i2;
          decodeBitmap(localOptions2, paramArrayOfByte, paramString, paramUri, paramInputStream, paramBoolean, paramInt1);
          i = i2;
          j = localOptions2.outWidth;
          i = i2;
          m = localOptions2.outHeight;
          i = i2;
          localOptions2 = new BitmapFactory.Options();
          i = i2;
          localOptions2.inPreferredConfig = Bitmap.Config.ARGB_8888;
          if (paramInt2 <= paramInt3) {
            break label488;
          }
          if (j < m) {
            break label502;
          }
          break label488;
          i = i2;
          localOptions2.inSampleSize = ((int)Math.max(n / paramInt2, m / paramInt3));
          i = i2;
          j = localOptions2.inSampleSize;
          localObject1 = localOptions2;
        }
        i = j;
        bindlowMemeryOption((BitmapFactory.Options)localObject1);
        i = j;
        localObject1 = decodeBitmap((BitmapFactory.Options)localObject1, paramArrayOfByte, paramString, paramUri, paramInputStream, paramBoolean, paramInt1);
        paramString = (String)localObject1;
        setBitmapDensity(paramString);
        paramString = BitmapTracer.trace(paramString);
        AppMethodBeat.o(156136);
        return paramString;
      }
      catch (Throwable localThrowable2)
      {
        paramInt2 = i;
        continue;
      }
      if (!paramInputStream.markSupported())
      {
        localObject1 = new BufferedInputStream(paramInputStream);
        paramInputStream = (InputStream)localObject1;
      }
      else
      {
        label485:
        label488:
        while ((paramInt2 >= paramInt3) || (j <= m))
        {
          n = j;
          break label510;
          break;
        }
        label502:
        n = m;
        m = j;
        label510:
        if (n <= paramInt2)
        {
          Object localObject2 = localOptions2;
          j = i1;
          if (m <= paramInt3) {}
        }
      }
    }
  }
  
  private static Bitmap getBitmapNative(int paramInt1, String paramString, byte[] paramArrayOfByte, Uri paramUri, boolean paramBoolean, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156135);
    paramString = getBitmapNative(paramInt1, paramString, paramArrayOfByte, paramUri, null, paramBoolean, paramFloat, paramInt2, paramInt3);
    AppMethodBeat.o(156135);
    return paramString;
  }
  
  public static Bitmap getBitmapNative(Uri paramUri)
  {
    AppMethodBeat.i(156123);
    paramUri = getBitmapNative(paramUri, 0, 0);
    AppMethodBeat.o(156123);
    return paramUri;
  }
  
  public static Bitmap getBitmapNative(Uri paramUri, float paramFloat)
  {
    AppMethodBeat.i(215316);
    paramUri = getBitmapNative(0, null, null, paramUri, false, paramFloat, 0, 0);
    AppMethodBeat.o(215316);
    return paramUri;
  }
  
  public static Bitmap getBitmapNative(Uri paramUri, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215317);
    paramUri = getBitmapNative(paramUri, paramInt1, paramInt2, 0.0F);
    AppMethodBeat.o(215317);
    return paramUri;
  }
  
  public static Bitmap getBitmapNative(Uri paramUri, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(215315);
    paramUri = getBitmapNative(0, null, null, paramUri, false, paramFloat, paramInt1, paramInt2);
    AppMethodBeat.o(215315);
    return paramUri;
  }
  
  public static Bitmap getBitmapNative(InputStream paramInputStream)
  {
    AppMethodBeat.i(156115);
    paramInputStream = getBitmapNative(0, null, null, null, paramInputStream, false, 0.0F, 0, 0);
    AppMethodBeat.o(156115);
    return paramInputStream;
  }
  
  public static Bitmap getBitmapNative(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156121);
    paramInputStream = getBitmapNative(0, null, null, null, paramInputStream, false, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(156121);
    return paramInputStream;
  }
  
  public static Bitmap getBitmapNative(String paramString)
  {
    AppMethodBeat.i(156114);
    paramString = getBitmapNative(paramString, 0, 0, 0.0F);
    AppMethodBeat.o(156114);
    return paramString;
  }
  
  public static Bitmap getBitmapNative(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156119);
    paramString = getBitmapNative(paramString, 0, 0, paramFloat);
    AppMethodBeat.o(156119);
    return paramString;
  }
  
  public static Bitmap getBitmapNative(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156120);
    paramString = getBitmapNative(paramString, paramInt1, paramInt2, 0.0F);
    AppMethodBeat.o(156120);
    return paramString;
  }
  
  public static Bitmap getBitmapNative(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(156122);
    paramString = getBitmapNative(0, paramString, null, null, false, paramFloat, paramInt1, paramInt2);
    AppMethodBeat.o(156122);
    return paramString;
  }
  
  public static Bitmap getBitmapNativeDisplayMetrics(int paramInt)
  {
    AppMethodBeat.i(215314);
    Object localObject = getDefaultDisplayMetrics();
    localObject = getBitmapNative(paramInt, null, null, null, false, 0.0F, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    AppMethodBeat.o(215314);
    return localObject;
  }
  
  public static Bitmap getBitmapNativeDisplayMetrics(String paramString)
  {
    AppMethodBeat.i(215318);
    DisplayMetrics localDisplayMetrics = getDefaultDisplayMetrics();
    paramString = getBitmapNative(paramString, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    AppMethodBeat.o(215318);
    return paramString;
  }
  
  public static Bitmap getCenterCropBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(156148);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(156148);
      return null;
    }
    setBitmapDensity(paramBitmap);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f2 = Math.max(paramInt1 / i, paramInt2 / j);
    float f1 = i * f2;
    f2 = j * f2;
    float f3 = (paramInt1 - f1) / 2.0F;
    float f4 = (paramInt2 - f2) / 2.0F;
    RectF localRectF = new RectF(f3, f4, f1 + f3, f2 + f4);
    Bitmap.Config localConfig = paramBitmap.getConfig();
    Object localObject = localConfig;
    if (localConfig == null)
    {
      Log.w("MicroMsg.BitmapUtil", "get center crop bitmap, config is null");
      localObject = Bitmap.Config.ARGB_8888;
    }
    try
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
      new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, null, localRectF, null);
      if (paramBoolean)
      {
        Log.i("MicroMsg.BitmapUtil", "getCenterCropBitmap bitmap recycle %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      setBitmapDensity((Bitmap)localObject);
      paramBitmap = BitmapTracer.trace((Bitmap)localObject);
      AppMethodBeat.o(156148);
      return paramBitmap;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      }
      catch (Throwable localThrowable2)
      {
        Log.e("MicroMsg.BitmapUtil", "BitmapUtil decode getCenterCropBitmap fail");
        AppMethodBeat.o(156148);
      }
    }
    return paramBitmap;
  }
  
  public static DisplayMetrics getDefaultDisplayMetrics()
  {
    AppMethodBeat.i(156134);
    if (metrics == null) {
      metrics = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    }
    DisplayMetrics localDisplayMetrics = metrics;
    AppMethodBeat.o(156134);
    return localDisplayMetrics;
  }
  
  public static BitmapFactory.Options getImageOptions(InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(169229);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    bindlowMemeryOption(localOptions);
    if (paramInputStream == null)
    {
      Log.e("MicroMsg.BitmapUtil", "getImageOptions decode stream is null!!");
      AppMethodBeat.o(169229);
      return localOptions;
    }
    Object localObject = paramInputStream;
    if (!paramBoolean)
    {
      localObject = paramInputStream;
      if (!paramInputStream.markSupported())
      {
        if (!(paramInputStream instanceof FileInputStream)) {
          break label130;
        }
        localObject = new FileSeekingInputStream((FileInputStream)paramInputStream);
      }
      ((InputStream)localObject).mark(8388608);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramInputStream = MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
          if (paramInputStream != null)
          {
            Log.i("MicroMsg.BitmapUtil", "getImageOptions bitmap recycle. %s", new Object[] { paramInputStream });
            paramInputStream.recycle();
          }
        }
        catch (OutOfMemoryError paramInputStream)
        {
          label130:
          Log.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "Decode bitmap failed.", new Object[0]);
          if (!paramBoolean) {
            continue;
          }
          try
          {
            ((InputStream)localObject).close();
          }
          catch (IOException paramInputStream)
          {
            Log.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream close failed ", new Object[0]);
          }
          continue;
          Log.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
          try
          {
            ((InputStream)localObject).reset();
          }
          catch (Exception paramInputStream)
          {
            Log.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream reset failed", new Object[0]);
          }
          continue;
        }
        finally
        {
          if (!paramBoolean) {
            break label299;
          }
        }
        try
        {
          ((InputStream)localObject).close();
          AppMethodBeat.o(169229);
          return localOptions;
          localObject = new BufferedInputStream(paramInputStream);
        }
        catch (IOException paramInputStream)
        {
          Log.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream close failed ", new Object[0]);
        }
      }
      Log.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
      try
      {
        ((InputStream)localObject).reset();
      }
      catch (Exception paramInputStream)
      {
        Log.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream reset failed", new Object[0]);
      }
    }
    for (;;)
    {
      try
      {
        ((InputStream)localObject).close();
        AppMethodBeat.o(169229);
        throw paramInputStream;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.BitmapUtil", localIOException, "hy: stream close failed ", new Object[0]);
        continue;
      }
      label299:
      Log.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
      try
      {
        localIOException.reset();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BitmapUtil", localException, "hy: stream reset failed", new Object[0]);
      }
    }
  }
  
  public static BitmapFactory.Options getImageOptions(String paramString)
  {
    AppMethodBeat.i(156099);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.BitmapUtil", "getImageOptions invalid path");
      AppMethodBeat.o(156099);
      return null;
    }
    try
    {
      paramString = s.openRead(paramString);
      paramString = getImageOptions(paramString, true);
      AppMethodBeat.o(156099);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      Log.printErrStackTrace("MicroMsg.BitmapUtil", paramString, "Decode bitmap failed.", new Object[0]);
      paramString = new BitmapFactory.Options();
      AppMethodBeat.o(156099);
    }
    return paramString;
  }
  
  public static Point getPictureSize(String paramString)
  {
    AppMethodBeat.i(156104);
    paramString = getImageOptions(paramString);
    if (paramString != null)
    {
      paramString = new Point(paramString.outWidth, paramString.outHeight);
      AppMethodBeat.o(156104);
      return paramString;
    }
    AppMethodBeat.o(156104);
    return null;
  }
  
  /* Error */
  public static void getRent(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 1038
    //   6: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 640	android/graphics/BitmapFactory$Options
    //   12: dup
    //   13: invokespecial 641	android/graphics/BitmapFactory$Options:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: iconst_1
    //   21: putfield 657	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload 5
    //   26: invokestatic 643	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   29: aload_0
    //   30: invokestatic 615	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore_0
    //   34: aload_0
    //   35: aconst_null
    //   36: aload 5
    //   38: invokestatic 589	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   41: astore_3
    //   42: aload_3
    //   43: astore 4
    //   45: aload 4
    //   47: astore_3
    //   48: aload_0
    //   49: ifnull +10 -> 59
    //   52: aload_0
    //   53: invokevirtual 602	java/io/InputStream:close	()V
    //   56: aload 4
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +23 -> 83
    //   63: ldc 21
    //   65: ldc_w 1040
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_3
    //   75: aastore
    //   76: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload_3
    //   80: invokevirtual 336	android/graphics/Bitmap:recycle	()V
    //   83: aload_1
    //   84: aload 5
    //   86: getfield 660	android/graphics/BitmapFactory$Options:outWidth	I
    //   89: putfield 494	com/tencent/mm/pointers/PInt:value	I
    //   92: aload_2
    //   93: aload 5
    //   95: getfield 663	android/graphics/BitmapFactory$Options:outHeight	I
    //   98: putfield 494	com/tencent/mm/pointers/PInt:value	I
    //   101: ldc_w 1038
    //   104: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore_0
    //   109: ldc 21
    //   111: aload_0
    //   112: ldc 79
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload 4
    //   123: astore_3
    //   124: goto -65 -> 59
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_0
    //   130: aload 4
    //   132: astore_3
    //   133: aload_0
    //   134: ifnull -75 -> 59
    //   137: aload_0
    //   138: invokevirtual 602	java/io/InputStream:close	()V
    //   141: aload 4
    //   143: astore_3
    //   144: goto -85 -> 59
    //   147: astore_0
    //   148: ldc 21
    //   150: aload_0
    //   151: ldc 79
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload 4
    //   162: astore_3
    //   163: goto -104 -> 59
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 602	java/io/InputStream:close	()V
    //   177: ldc_w 1038
    //   180: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_0
    //   184: athrow
    //   185: astore_1
    //   186: ldc 21
    //   188: aload_1
    //   189: ldc 79
    //   191: iconst_0
    //   192: anewarray 4	java/lang/Object
    //   195: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: goto -21 -> 177
    //   201: astore_1
    //   202: aload_0
    //   203: astore_2
    //   204: aload_1
    //   205: astore_0
    //   206: aload_2
    //   207: astore_1
    //   208: goto -39 -> 169
    //   211: astore_3
    //   212: goto -82 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   0	215	1	paramPInt1	PInt
    //   0	215	2	paramPInt2	PInt
    //   41	122	3	localObject1	Object
    //   211	1	3	localFileNotFoundException	FileNotFoundException
    //   1	160	4	localObject2	Object
    //   16	78	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   52	56	108	java/io/IOException
    //   29	34	127	java/io/FileNotFoundException
    //   137	141	147	java/io/IOException
    //   29	34	166	finally
    //   173	177	185	java/io/IOException
    //   34	42	201	finally
    //   34	42	211	java/io/FileNotFoundException
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(156150);
    paramBitmap = getRoundedCornerBitmap(paramBitmap, paramBoolean, paramFloat, false, null);
    AppMethodBeat.o(156150);
    return paramBitmap;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(156149);
    paramBitmap = getRoundedCornerBitmap(paramBitmap, paramBoolean1, paramFloat, paramBoolean2, null);
    AppMethodBeat.o(156149);
    return paramBitmap;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(215328);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      Log.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
      AppMethodBeat.o(215328);
      return null;
    }
    setBitmapDensity(paramBitmap);
    Object localObject = paramArrayOfInt;
    if (paramArrayOfInt == null)
    {
      localObject = new int[2];
      localObject[0] = paramBitmap.getWidth();
      localObject[1] = paramBitmap.getHeight();
    }
    paramArrayOfInt = createBitmap(localObject[0], localObject[1], Bitmap.Config.ARGB_8888, paramBoolean2);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(215328);
      return null;
    }
    localObject = new Canvas(paramArrayOfInt);
    Paint localPaint = new Paint();
    Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    Rect localRect2 = new Rect(0, 0, paramArrayOfInt.getWidth(), paramArrayOfInt.getHeight());
    RectF localRectF = new RectF(localRect2);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    ((Canvas)localObject).drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    ((Canvas)localObject).drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject).drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
    if (paramBoolean1)
    {
      Log.i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    setBitmapDensity(paramArrayOfInt);
    paramBitmap = BitmapTracer.trace(paramArrayOfInt);
    AppMethodBeat.o(215328);
    return paramBitmap;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, boolean paramBoolean, float paramFloat, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(215329);
    paramBitmap = getRoundedCornerBitmap(paramBitmap, paramBoolean, paramFloat, false, paramArrayOfInt);
    AppMethodBeat.o(215329);
    return paramBitmap;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, boolean paramBoolean1, float[] paramArrayOfFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(215330);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      Log.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
      AppMethodBeat.o(215330);
      return null;
    }
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 4))
    {
      Log.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap roundPxArray invalid");
      AppMethodBeat.o(215330);
      return null;
    }
    setBitmapDensity(paramBitmap);
    Bitmap localBitmap = createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888, paramBoolean2);
    if (localBitmap == null)
    {
      AppMethodBeat.o(215330);
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localPaint.setStyle(Paint.Style.FILL);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    localCanvas.drawPath(createRoundedRectPath(localRectF, paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]), localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    if (paramBoolean1)
    {
      Log.i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    setBitmapDensity(localBitmap);
    paramBitmap = BitmapTracer.trace(localBitmap);
    AppMethodBeat.o(215330);
    return paramBitmap;
  }
  
  public static String getYUVType(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156172);
    int i = 0;
    if (i < paramArrayOfByte.length - 1)
    {
      if ((paramArrayOfByte[i] & 0xFF) != 255) {
        break label159;
      }
      j = paramArrayOfByte[(i + 1)];
      if (((j & 0xFF) < 192) || ((j & 0xFF) > 207)) {
        break label159;
      }
      Log.d("MicroMsg.BitmapUtil", "match 0xff-" + Integer.toHexString(j & 0xFF) + "  at:" + i);
      if (i + 1 + 17 >= paramArrayOfByte.length) {
        Log.d("MicroMsg.BitmapUtil", "not engouht len at ".concat(String.valueOf(i)));
      }
    }
    else
    {
      AppMethodBeat.o(156172);
      return null;
    }
    int j = i + 2;
    if (paramArrayOfByte[(j + 7)] != 3) {
      Log.d("MicroMsg.BitmapUtil", "num != 3 at ".concat(String.valueOf(i)));
    }
    label159:
    int k;
    int m;
    label224:
    int i1;
    do
    {
      int n;
      int i2;
      do
      {
        do
        {
          for (;;)
          {
            i += 1;
            break;
            k = paramArrayOfByte[(j + 8)];
            m = paramArrayOfByte[(j + 11)];
            n = paramArrayOfByte[(j + 14)];
            if ((k == 1) || (m == 2) || (n == 3)) {
              break label224;
            }
            Log.d("MicroMsg.BitmapUtil", "Y/Cb/Cr Tag is not right at ".concat(String.valueOf(i)));
          }
          m = paramArrayOfByte[(j + 9)];
          i1 = paramArrayOfByte[(j + 12)];
          k = paramArrayOfByte[(j + 15)];
        } while ((m == 0) || (i1 == 0) || (k == 0));
        if ((m == i1) && (m == k))
        {
          AppMethodBeat.o(156172);
          return "YUV444";
        }
        j = (m & 0xFF) >> 4 & 0xF;
        m &= 0xF;
        n = (i1 & 0xFF) >> 4 & 0xF;
        i1 &= 0xF;
        i2 = (k & 0xFF) >> 4 & 0xF;
        k &= 0xF;
      } while ((n == 0) || (i2 == 0) || (i1 == 0) || (k == 0) || (j / n != 2) || (j / i2 != 2));
      if ((m / i1 == 2) && (m / k == 2))
      {
        AppMethodBeat.o(156172);
        return "YUV420";
      }
    } while ((m != i1) || (m != k));
    AppMethodBeat.o(156172);
    return "YUV422";
  }
  
  public static Bitmap handleDegree(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(169230);
    paramBitmap = rotate(paramBitmap, paramInt);
    AppMethodBeat.o(169230);
    return paramBitmap;
  }
  
  private static void megerPixels(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    AppMethodBeat.i(215334);
    if (paramArrayOfInt1[paramInt] != -16777216) {
      if (paramArrayOfInt1[paramInt] == 0) {
        paramArrayOfInt2[paramInt] = 0;
      }
    }
    try
    {
      AppMethodBeat.o(215334);
      return;
    }
    catch (Exception paramArrayOfInt1)
    {
      Log.e("MicroMsg.BitmapUtil", "megerPixels:%s", new Object[] { paramArrayOfInt1.toString() });
      AppMethodBeat.o(215334);
    }
    if (paramArrayOfInt1[paramInt] != -1)
    {
      paramArrayOfInt2[paramInt] &= paramArrayOfInt1[paramInt];
      paramArrayOfInt2[paramInt] &= paramArrayOfInt1[paramInt];
    }
    AppMethodBeat.o(215334);
    return;
  }
  
  /* Error */
  public static Bitmap rotate(Bitmap paramBitmap, float paramFloat)
  {
    // Byte code:
    //   0: ldc_w 1147
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +13 -> 20
    //   10: fload_1
    //   11: ldc_w 1148
    //   14: frem
    //   15: fconst_0
    //   16: fcmpl
    //   17: ifne +11 -> 28
    //   20: ldc_w 1147
    //   23: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: areturn
    //   28: new 1150	android/graphics/Matrix
    //   31: dup
    //   32: invokespecial 1151	android/graphics/Matrix:<init>	()V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 1152	android/graphics/Matrix:reset	()V
    //   40: aload_3
    //   41: fload_1
    //   42: aload_0
    //   43: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   46: iconst_2
    //   47: idiv
    //   48: i2f
    //   49: aload_0
    //   50: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   53: iconst_2
    //   54: idiv
    //   55: i2f
    //   56: invokevirtual 1156	android/graphics/Matrix:setRotate	(FFF)V
    //   59: aload_0
    //   60: iconst_0
    //   61: iconst_0
    //   62: aload_0
    //   63: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   66: aload_0
    //   67: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   70: aload_3
    //   71: iconst_1
    //   72: invokestatic 937	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   75: astore_3
    //   76: aload_3
    //   77: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   80: new 273	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 1158
    //   87: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: astore 4
    //   92: aload_3
    //   93: ifnonnull +101 -> 194
    //   96: iconst_1
    //   97: istore_2
    //   98: ldc 21
    //   100: aload 4
    //   102: iload_2
    //   103: invokevirtual 760	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc_w 1160
    //   109: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: fload_1
    //   113: invokevirtual 1163	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   116: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: aload_3
    //   124: if_acmpeq +23 -> 147
    //   127: ldc 21
    //   129: ldc_w 1165
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_0
    //   139: aastore
    //   140: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: invokevirtual 336	android/graphics/Bitmap:recycle	()V
    //   147: aload_3
    //   148: invokestatic 205	com/tencent/mm/sdk/platformtools/BitmapTracer:trace	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   151: astore_0
    //   152: ldc_w 1147
    //   155: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_0
    //   159: areturn
    //   160: astore 4
    //   162: aload_0
    //   163: astore_3
    //   164: aload 4
    //   166: astore_0
    //   167: ldc 21
    //   169: ldc_w 1167
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokestatic 1171	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: ldc_w 1147
    //   189: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_3
    //   193: areturn
    //   194: iconst_0
    //   195: istore_2
    //   196: goto -98 -> 98
    //   199: astore_0
    //   200: goto -33 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramBitmap	Bitmap
    //   0	203	1	paramFloat	float
    //   97	99	2	bool	boolean
    //   35	158	3	localObject	Object
    //   90	11	4	localStringBuilder	StringBuilder
    //   160	5	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   59	76	160	java/lang/Throwable
    //   76	80	199	java/lang/Throwable
  }
  
  /* Error */
  public static Bitmap rotate(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1173
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +13 -> 20
    //   10: fload_1
    //   11: ldc_w 1148
    //   14: frem
    //   15: fconst_0
    //   16: fcmpl
    //   17: ifne +11 -> 28
    //   20: ldc_w 1173
    //   23: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: areturn
    //   28: new 1150	android/graphics/Matrix
    //   31: dup
    //   32: invokespecial 1151	android/graphics/Matrix:<init>	()V
    //   35: astore 4
    //   37: aload 4
    //   39: invokevirtual 1152	android/graphics/Matrix:reset	()V
    //   42: aload 4
    //   44: fload_1
    //   45: aload_0
    //   46: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   49: iconst_2
    //   50: idiv
    //   51: i2f
    //   52: aload_0
    //   53: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   56: iconst_2
    //   57: idiv
    //   58: i2f
    //   59: invokevirtual 1156	android/graphics/Matrix:setRotate	(FFF)V
    //   62: aload_0
    //   63: iconst_0
    //   64: iconst_0
    //   65: aload_0
    //   66: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   69: aload_0
    //   70: invokevirtual 102	android/graphics/Bitmap:getHeight	()I
    //   73: aload 4
    //   75: iconst_1
    //   76: invokestatic 937	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   79: astore 4
    //   81: aload 4
    //   83: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:setBitmapDensity	(Landroid/graphics/Bitmap;)V
    //   86: new 273	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 1158
    //   93: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: astore 5
    //   98: aload 4
    //   100: ifnonnull +109 -> 209
    //   103: iconst_1
    //   104: istore_3
    //   105: ldc 21
    //   107: aload 5
    //   109: iload_3
    //   110: invokevirtual 760	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   113: ldc_w 1160
    //   116: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: fload_1
    //   120: invokevirtual 1163	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   123: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: iload_2
    //   130: ifeq +29 -> 159
    //   133: aload_0
    //   134: aload 4
    //   136: if_acmpeq +23 -> 159
    //   139: ldc 21
    //   141: ldc_w 1165
    //   144: iconst_1
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_0
    //   151: aastore
    //   152: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_0
    //   156: invokevirtual 336	android/graphics/Bitmap:recycle	()V
    //   159: aload 4
    //   161: invokestatic 205	com/tencent/mm/sdk/platformtools/BitmapTracer:trace	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   164: astore_0
    //   165: ldc_w 1173
    //   168: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_0
    //   172: areturn
    //   173: astore 5
    //   175: aload_0
    //   176: astore 4
    //   178: aload 5
    //   180: astore_0
    //   181: ldc 21
    //   183: ldc_w 1167
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_0
    //   193: invokestatic 1171	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   196: aastore
    //   197: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: ldc_w 1173
    //   203: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload 4
    //   208: areturn
    //   209: iconst_0
    //   210: istore_3
    //   211: goto -106 -> 105
    //   214: astore_0
    //   215: goto -34 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramBitmap	Bitmap
    //   0	218	1	paramFloat	float
    //   0	218	2	paramBoolean	boolean
    //   104	107	3	bool	boolean
    //   35	172	4	localObject	Object
    //   96	12	5	localStringBuilder	StringBuilder
    //   173	6	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   62	81	173	java/lang/Throwable
    //   81	86	214	java/lang/Throwable
  }
  
  public static boolean rotate(String paramString1, int paramInt1, Bitmap.CompressFormat paramCompressFormat, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(156144);
    paramString1 = getBitmapNative(paramString1);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.BitmapUtil", "rotate: create bitmap fialed");
      AppMethodBeat.o(156144);
      return false;
    }
    float f1 = paramString1.getWidth();
    float f2 = paramString1.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(paramInt1, f1 / 2.0F, f2 / 2.0F);
    localObject = Bitmap.createBitmap(paramString1, 0, 0, (int)f1, (int)f2, (Matrix)localObject, true);
    if (paramString1 != localObject)
    {
      Log.i("MicroMsg.BitmapUtil", "rotate bitmap recycle adjfjads fadsj fsadjf dsa. %s", new Object[] { paramString1.toString() });
      paramString1.recycle();
    }
    try
    {
      saveBitmapToImage((Bitmap)localObject, paramInt2, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(156144);
      return true;
    }
    catch (IOException paramString1)
    {
      Log.printErrStackTrace("MicroMsg.BitmapUtil", paramString1, "create %s from orig failed: ".concat(String.valueOf(paramString2)), new Object[0]);
      AppMethodBeat.o(156144);
    }
    return false;
  }
  
  public static boolean rotate(String paramString1, int paramInt1, Bitmap.CompressFormat paramCompressFormat, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(215326);
    boolean bool = rotate(paramString1, paramInt1, paramCompressFormat, paramInt2, paramString2 + paramString3);
    AppMethodBeat.o(215326);
    return bool;
  }
  
  public static Bitmap rotateAndScale(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(156142);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(156142);
      return null;
    }
    if ((paramFloat1 == 0.0F) && (paramFloat2 > 0.999D) && (paramFloat2 < 1.001D) && (paramFloat3 > 0.999D) && (paramFloat3 < 1.001D))
    {
      AppMethodBeat.o(156142);
      return paramBitmap;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    if (paramFloat1 != 0.0F) {
      ((Matrix)localObject).setRotate(paramFloat1, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    }
    if ((paramFloat2 < 0.999D) || (paramFloat2 > 1.001D) || (paramFloat3 < 0.999D) || (paramFloat3 > 1.001D)) {
      ((Matrix)localObject).postScale(paramFloat2, paramFloat3);
    }
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    setBitmapDensity((Bitmap)localObject);
    StringBuilder localStringBuilder = new StringBuilder("resultBmp is null: ");
    if (localObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.BitmapUtil", bool + "  degree:" + paramFloat1);
      if (paramBitmap != localObject)
      {
        Log.i("MicroMsg.BitmapUtil", "rotateAndScale bitmap recycle asdfasdjfjasdfjsadfjdsa. %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      paramBitmap = BitmapTracer.trace((Bitmap)localObject);
      AppMethodBeat.o(156142);
      return paramBitmap;
    }
  }
  
  /* Error */
  public static boolean saveBitmapToImage(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1202
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: invokestatic 484	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +22 -> 32
    //   13: new 479	java/io/IOException
    //   16: dup
    //   17: ldc_w 1204
    //   20: invokespecial 1205	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: ldc_w 1202
    //   27: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: athrow
    //   32: ldc 21
    //   34: ldc_w 1207
    //   37: aload_3
    //   38: invokestatic 503	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokevirtual 507	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 764	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore 7
    //   50: aconst_null
    //   51: astore 6
    //   53: aload_3
    //   54: invokestatic 1210	com/tencent/mm/vfs/s:boZ	(Ljava/lang/String;)Ljava/lang/String;
    //   57: invokestatic 1213	com/tencent/mm/vfs/s:boN	(Ljava/lang/String;)Z
    //   60: pop
    //   61: aload_3
    //   62: iconst_0
    //   63: invokestatic 1217	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   66: astore 8
    //   68: aload 8
    //   70: astore 6
    //   72: aload 8
    //   74: astore 7
    //   76: aload_0
    //   77: iload_1
    //   78: aload_2
    //   79: aload 8
    //   81: iload 4
    //   83: invokestatic 1221	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToStream	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/io/OutputStream;Z)Z
    //   86: istore 5
    //   88: iload 4
    //   90: ifeq +26 -> 116
    //   93: ldc 21
    //   95: ldc_w 1223
    //   98: iconst_1
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_0
    //   105: invokevirtual 1182	java/lang/Object:toString	()Ljava/lang/String;
    //   108: aastore
    //   109: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_0
    //   113: invokevirtual 336	android/graphics/Bitmap:recycle	()V
    //   116: aload 8
    //   118: ifnull +8 -> 126
    //   121: aload 8
    //   123: invokevirtual 1226	java/io/OutputStream:close	()V
    //   126: ldc_w 1202
    //   129: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iload 5
    //   134: ireturn
    //   135: astore_2
    //   136: aload 6
    //   138: astore 7
    //   140: ldc 21
    //   142: aload_2
    //   143: ldc_w 1228
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_3
    //   153: aastore
    //   154: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload 6
    //   159: astore 7
    //   161: new 479	java/io/IOException
    //   164: dup
    //   165: aload_2
    //   166: invokespecial 1231	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   169: astore_2
    //   170: aload 6
    //   172: astore 7
    //   174: ldc_w 1202
    //   177: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload 6
    //   182: astore 7
    //   184: aload_2
    //   185: athrow
    //   186: astore_2
    //   187: iload 4
    //   189: ifeq +26 -> 215
    //   192: ldc 21
    //   194: ldc_w 1223
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_0
    //   204: invokevirtual 1182	java/lang/Object:toString	()Ljava/lang/String;
    //   207: aastore
    //   208: invokestatic 323	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload_0
    //   212: invokevirtual 336	android/graphics/Bitmap:recycle	()V
    //   215: aload 7
    //   217: ifnull +8 -> 225
    //   220: aload 7
    //   222: invokevirtual 1226	java/io/OutputStream:close	()V
    //   225: ldc_w 1202
    //   228: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_2
    //   232: athrow
    //   233: astore_0
    //   234: goto -108 -> 126
    //   237: astore_0
    //   238: goto -13 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramBitmap	Bitmap
    //   0	241	1	paramInt	int
    //   0	241	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	241	3	paramString	String
    //   0	241	4	paramBoolean	boolean
    //   86	47	5	bool	boolean
    //   51	130	6	localObject1	Object
    //   48	173	7	localObject2	Object
    //   66	56	8	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   61	68	135	java/lang/Exception
    //   76	88	135	java/lang/Exception
    //   61	68	186	finally
    //   76	88	186	finally
    //   140	157	186	finally
    //   161	170	186	finally
    //   174	180	186	finally
    //   184	186	186	finally
    //   121	126	233	java/io/IOException
    //   220	225	237	java/io/IOException
  }
  
  public static boolean saveBitmapToStream(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat, OutputStream paramOutputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(169235);
    boolean bool = compress(paramBitmap, paramCompressFormat, paramInt, paramOutputStream);
    if (paramBoolean)
    {
      Log.i("MicroMsg.BitmapUtil", "saveBitmapToStream bitmap recycle. %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    AppMethodBeat.o(169235);
    return bool;
  }
  
  public static void setAllDrawingCacheEnable(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(215333);
    if (paramView == null)
    {
      AppMethodBeat.o(215333);
      return;
    }
    paramView.setDrawingCacheEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      int j = ((ViewGroup)paramView).getChildCount();
      int i = 0;
      while (i < j)
      {
        setAllDrawingCacheEnable(((ViewGroup)paramView).getChildAt(i), paramBoolean);
        i += 1;
      }
    }
    AppMethodBeat.o(215333);
  }
  
  public static Bitmap setAlpha(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(156169);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawARGB(0, 0, 0, 0);
    Paint localPaint = new Paint();
    localPaint.setAlpha((int)(255.0F * paramFloat));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    setBitmapDensity(localBitmap);
    paramBitmap = BitmapTracer.trace(localBitmap);
    AppMethodBeat.o(156169);
    return paramBitmap;
  }
  
  public static void setBitmapDensity(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156174);
    if (paramBitmap != null)
    {
      paramBitmap.setDensity(MMApplicationContext.getContext().getResources().getDisplayMetrics().densityDpi);
      try
      {
        paramBitmap = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        paramBitmap.setAccessible(true);
        paramBitmap.invoke(null, new Object[] { Integer.valueOf(MMApplicationContext.getContext().getResources().getDisplayMetrics().densityDpi) });
        AppMethodBeat.o(156174);
        return;
      }
      catch (Exception paramBitmap)
      {
        Log.e("MicroMsg.BitmapUtil", "Exception:%s", new Object[] { paramBitmap });
      }
    }
    AppMethodBeat.o(156174);
  }
  
  public static Bitmap setContrast(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(215341);
    int i = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.set(new float[] { paramFloat, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, paramFloat, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, paramFloat, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    setBitmapDensity(localBitmap);
    paramBitmap = BitmapTracer.trace(localBitmap);
    AppMethodBeat.o(215341);
    return paramBitmap;
  }
  
  public static Bitmap setGrayscale(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156170);
    int i = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    setBitmapDensity(localBitmap);
    paramBitmap = BitmapTracer.trace(localBitmap);
    AppMethodBeat.o(156170);
    return paramBitmap;
  }
  
  public static Bitmap transformDrawableToBitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(156152);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(156152);
      return paramDrawable;
    }
    Bitmap localBitmap = createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    setBitmapDensity(localBitmap);
    paramDrawable = BitmapTracer.trace(localBitmap);
    AppMethodBeat.o(156152);
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */