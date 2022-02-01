package com.tencent.worddetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class a
{
  private static WordDetectNative SxA;
  private static int Sxz;
  
  static
  {
    AppMethodBeat.i(194841);
    Sxz = 11;
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seC, 0);
    if ((i >= 10) && (i <= 15)) {
      Sxz = i;
    }
    Log.i("MicroMsg.WordDetectModHelper", "alvinluo initWordDetectHelper ratioLimit: %s, config: %s", new Object[] { Integer.valueOf(Sxz), Integer.valueOf(i) });
    AppMethodBeat.o(194841);
  }
  
  private static byte[] aP(Bitmap paramBitmap)
  {
    AppMethodBeat.i(91187);
    try
    {
      Object localObject = ByteBuffer.allocate(paramBitmap.getByteCount());
      paramBitmap.copyPixelsToBuffer((Buffer)localObject);
      paramBitmap = ((ByteBuffer)localObject).array();
      localObject = new byte[paramBitmap.length / 4 * 3];
      int i = 0;
      while (i < paramBitmap.length / 4)
      {
        localObject[(i * 3)] = paramBitmap[(i * 4 + 2)];
        localObject[(i * 3 + 1)] = paramBitmap[(i * 4 + 1)];
        localObject[(i * 3 + 2)] = paramBitmap[(i * 4)];
        i += 1;
      }
      AppMethodBeat.o(91187);
      return localObject;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      AppMethodBeat.o(91187);
    }
    return null;
  }
  
  public static int cZ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(91188);
    if (SxA == null) {}
    Object localObject;
    try
    {
      if (SxA == null)
      {
        localObject = new WordDetectNative();
        SxA = (WordDetectNative)localObject;
        ((WordDetectNative)localObject).init(lz(paramContext));
      }
      if ((paramString == null) || (paramString.length() <= 0))
      {
        Log.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
        AppMethodBeat.o(91188);
        return 0;
      }
    }
    finally
    {
      AppMethodBeat.o(91188);
    }
    try
    {
      long l = System.currentTimeMillis();
      paramContext = new BitmapFactory.Options();
      paramContext.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(paramString, paramContext);
      localObject = new BitmapFactory.Options();
      int i = paramContext.outWidth * paramContext.outHeight * 3;
      float f = paramContext.outHeight * 1.0F / paramContext.outWidth;
      if (i > 52428800)
      {
        Log.w("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, quit", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        AppMethodBeat.o(91188);
        return 0;
      }
      if ((f > Sxz) || (f < 1.0F / Sxz))
      {
        Log.w("MicroMsg.WordDetectModHelper", "bitmap width_height ratio too large %f, quit", new Object[] { Float.valueOf(f) });
        AppMethodBeat.o(91188);
        return 0;
      }
      if (i > 10485760)
      {
        Log.i("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        ((BitmapFactory.Options)localObject).inSampleSize = 2;
      }
      paramContext = BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramContext == null)
      {
        Log.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
        AppMethodBeat.o(91188);
        return 0;
      }
      paramString = aP(paramContext);
      boolean bool = Util.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(91188);
        return 0;
      }
      i = paramContext.getWidth();
      int j = paramContext.getHeight();
      int k = SxA.scanImage(paramString, i, j, 3);
      Log.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", new Object[] { Integer.valueOf(paramString.length), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (k != 0)
      {
        AppMethodBeat.o(91188);
        return 0;
      }
      i = SxA.getResult();
      Log.i("MicroMsg.WordDetectModHelper", "decodeFile ret = %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(91188);
      return i;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(91188);
      return 0;
    }
    catch (Error paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.WordDetectModHelper", "System Error， error: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public static WordDetectNative.WordDetectDetailResult da(Context paramContext, String paramString)
  {
    AppMethodBeat.i(194840);
    if (SxA == null) {}
    Object localObject;
    try
    {
      if (SxA == null)
      {
        localObject = new WordDetectNative();
        SxA = (WordDetectNative)localObject;
        ((WordDetectNative)localObject).init(lz(paramContext));
      }
      if ((paramString == null) || (paramString.length() <= 0))
      {
        Log.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
        paramContext = a.SxB;
        AppMethodBeat.o(194840);
        return paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(194840);
    }
    try
    {
      long l = System.currentTimeMillis();
      paramContext = new BitmapFactory.Options();
      paramContext.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(paramString, paramContext);
      localObject = new BitmapFactory.Options();
      int i = paramContext.outWidth * paramContext.outHeight * 3;
      float f = paramContext.outHeight * 1.0F / paramContext.outWidth;
      if (i > 52428800)
      {
        Log.w("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, quit", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        paramContext = a.SxB;
        AppMethodBeat.o(194840);
        return paramContext;
      }
      if ((f > Sxz) || (f < 1.0F / Sxz))
      {
        Log.w("MicroMsg.WordDetectModHelper", "bitmap width_height ratio too large %f, quit", new Object[] { Float.valueOf(f) });
        paramContext = a.SxB;
        AppMethodBeat.o(194840);
        return paramContext;
      }
      if (i > 10485760)
      {
        Log.i("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        ((BitmapFactory.Options)localObject).inSampleSize = 2;
      }
      paramContext = BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramContext == null)
      {
        Log.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
        paramContext = a.SxB;
        AppMethodBeat.o(194840);
        return paramContext;
      }
      paramString = aP(paramContext);
      if (Util.isNullOrNil(paramString))
      {
        paramContext = a.SxB;
        AppMethodBeat.o(194840);
        return paramContext;
      }
      i = paramContext.getWidth();
      int j = paramContext.getHeight();
      int k = SxA.scanImage(paramString, i, j, 3);
      Log.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", new Object[] { Integer.valueOf(paramString.length), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (k != 0)
      {
        paramContext = a.SxB;
        AppMethodBeat.o(194840);
        return paramContext;
      }
      paramContext = new WordDetectNative.WordDetectDetailResult();
      if (SxA.getDetailResult(paramContext) != 0)
      {
        paramContext = a.SxB;
        AppMethodBeat.o(194840);
        return paramContext;
      }
      Log.i("MicroMsg.WordDetectModHelper", "decodeFile result %s, cost %d", new Object[] { paramContext.rate_lang, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(194840);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", new Object[] { paramContext.getMessage() });
      paramContext = a.SxB;
      AppMethodBeat.o(194840);
      return paramContext;
    }
    catch (Error paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.WordDetectModHelper", "System Error， error: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  private static WordDetectNative.ConfigParam lz(Context paramContext)
  {
    AppMethodBeat.i(91186);
    try
    {
      Object localObject = new o(com.tencent.mm.loader.j.b.aKA().replace("/data/user/0", "/data/data") + "files/", "word_detect");
      if (!((o)localObject).exists()) {
        ((o)localObject).mkdirs();
      }
      String str = aa.z(((o)localObject).her());
      localObject = str + "/net_fc.bin";
      str = str + "/net_fc.param";
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("word_detect_mode_lib");
      boolean bool = localMultiProcessMMKV.getBoolean("word_detect_mode_version_2", false);
      if (!bool)
      {
        s.deleteFile((String)localObject);
        s.deleteFile(str);
        localMultiProcessMMKV.putBoolean("word_detect_mode_version_2", true);
      }
      if ((!bool) || (!s.YS((String)localObject)))
      {
        FilesCopy.copyAssets(paramContext, "qbar/net_fc.bin", (String)localObject);
        FilesCopy.copyAssets(paramContext, "qbar/net_fc.param", str);
      }
      paramContext = new WordDetectNative.ConfigParam();
      paramContext.detect_model_bin = ((String)localObject);
      paramContext.detect_model_param = str;
      AppMethodBeat.o(91186);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.w("MicroMsg.WordDetectModHelper", "getWordDetectParam err %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(91186);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public static final WordDetectNative.WordDetectDetailResult SxB = new WordDetectNative.WordDetectDetailResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.worddetect.a
 * JD-Core Version:    0.7.0.1
 */