package com.tencent.worddetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class a
{
  private static WordDetectNative MLw;
  
  private static byte[] aL(Bitmap paramBitmap)
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
  
  public static int cF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(91188);
    if (MLw == null) {}
    Object localObject;
    try
    {
      if (MLw == null)
      {
        localObject = new WordDetectNative();
        MLw = (WordDetectNative)localObject;
        ((WordDetectNative)localObject).init(lA(paramContext));
      }
      if ((paramString == null) || (paramString.length() <= 0))
      {
        ae.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
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
      h.decodeFile(paramString, paramContext);
      localObject = new BitmapFactory.Options();
      int i = paramContext.outWidth * paramContext.outHeight * 3;
      float f = 1.0F * paramContext.outHeight / paramContext.outWidth;
      if (i > 52428800)
      {
        ae.w("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, quit", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        AppMethodBeat.o(91188);
        return 0;
      }
      if ((f > 10.0F) || (f < 0.1F))
      {
        ae.w("MicroMsg.WordDetectModHelper", "bitmap width_height ratio too large %f, quit", new Object[] { Float.valueOf(f) });
        AppMethodBeat.o(91188);
        return 0;
      }
      if (i > 10485760)
      {
        ae.i("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        ((BitmapFactory.Options)localObject).inSampleSize = 2;
      }
      paramContext = h.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramContext == null)
      {
        ae.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
        AppMethodBeat.o(91188);
        return 0;
      }
      paramString = aL(paramContext);
      boolean bool = bu.cF(paramString);
      if (bool)
      {
        AppMethodBeat.o(91188);
        return 0;
      }
      i = paramContext.getWidth();
      int j = paramContext.getHeight();
      int k = MLw.scanImage(paramString, i, j, 3);
      ae.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", new Object[] { Integer.valueOf(paramString.length), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (k != 0)
      {
        AppMethodBeat.o(91188);
        return 0;
      }
      i = MLw.getResult();
      ae.i("MicroMsg.WordDetectModHelper", "decodeFile ret = %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(91188);
      return i;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(91188);
      return 0;
    }
    catch (Error paramContext)
    {
      for (;;)
      {
        ae.e("MicroMsg.WordDetectModHelper", "System Error， error: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public static WordDetectNative.WordDetectDetailResult cG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(196701);
    if (MLw == null) {}
    Object localObject;
    try
    {
      if (MLw == null)
      {
        localObject = new WordDetectNative();
        MLw = (WordDetectNative)localObject;
        ((WordDetectNative)localObject).init(lA(paramContext));
      }
      if ((paramString == null) || (paramString.length() <= 0))
      {
        ae.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
        paramContext = a.MLx;
        AppMethodBeat.o(196701);
        return paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(196701);
    }
    try
    {
      long l = System.currentTimeMillis();
      paramContext = new BitmapFactory.Options();
      paramContext.inJustDecodeBounds = true;
      h.decodeFile(paramString, paramContext);
      localObject = new BitmapFactory.Options();
      int i = paramContext.outWidth * paramContext.outHeight * 3;
      float f = 1.0F * paramContext.outHeight / paramContext.outWidth;
      if (i > 52428800)
      {
        ae.w("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, quit", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        paramContext = a.MLx;
        AppMethodBeat.o(196701);
        return paramContext;
      }
      if ((f > 10.0F) || (f < 0.1F))
      {
        ae.w("MicroMsg.WordDetectModHelper", "bitmap width_height ratio too large %f, quit", new Object[] { Float.valueOf(f) });
        paramContext = a.MLx;
        AppMethodBeat.o(196701);
        return paramContext;
      }
      if (i > 10485760)
      {
        ae.i("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        ((BitmapFactory.Options)localObject).inSampleSize = 2;
      }
      paramContext = h.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramContext == null)
      {
        ae.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
        paramContext = a.MLx;
        AppMethodBeat.o(196701);
        return paramContext;
      }
      paramString = aL(paramContext);
      if (bu.cF(paramString))
      {
        paramContext = a.MLx;
        AppMethodBeat.o(196701);
        return paramContext;
      }
      i = paramContext.getWidth();
      int j = paramContext.getHeight();
      int k = MLw.scanImage(paramString, i, j, 3);
      ae.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", new Object[] { Integer.valueOf(paramString.length), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (k != 0)
      {
        paramContext = a.MLx;
        AppMethodBeat.o(196701);
        return paramContext;
      }
      paramContext = new WordDetectNative.WordDetectDetailResult();
      if (MLw.getDetailResult(paramContext) != 0)
      {
        paramContext = a.MLx;
        AppMethodBeat.o(196701);
        return paramContext;
      }
      ae.i("MicroMsg.WordDetectModHelper", "decodeFile result %s, cost %d", new Object[] { paramContext.rate_lang, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(196701);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", new Object[] { paramContext.getMessage() });
      paramContext = a.MLx;
      AppMethodBeat.o(196701);
      return paramContext;
    }
    catch (Error paramContext)
    {
      for (;;)
      {
        ae.e("MicroMsg.WordDetectModHelper", "System Error， error: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  private static WordDetectNative.ConfigParam lA(Context paramContext)
  {
    AppMethodBeat.i(91186);
    try
    {
      Object localObject = new k(b.asa().replace("/data/user/0", "/data/data") + "files/", "word_detect");
      if (!((k)localObject).exists()) {
        ((k)localObject).mkdirs();
      }
      String str = w.B(((k)localObject).fTh());
      localObject = str + "/net_fc.bin";
      str = str + "/net_fc.param";
      ay localay = ay.aRW("word_detect_mode_lib");
      boolean bool = localay.getBoolean("word_detect_mode_version_2", false);
      if (!bool)
      {
        o.deleteFile((String)localObject);
        o.deleteFile(str);
        localay.putBoolean("word_detect_mode_version_2", true);
      }
      if ((!bool) || (!o.fB((String)localObject)))
      {
        q.S(paramContext, "qbar/net_fc.bin", (String)localObject);
        q.S(paramContext, "qbar/net_fc.param", str);
      }
      paramContext = new WordDetectNative.ConfigParam();
      paramContext.detect_model_bin = ((String)localObject);
      paramContext.detect_model_param = str;
      AppMethodBeat.o(91186);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ae.w("MicroMsg.WordDetectModHelper", "getWordDetectParam err %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(91186);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public static final WordDetectNative.WordDetectDetailResult MLx = new WordDetectNative.WordDetectDetailResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.worddetect.a
 * JD-Core Version:    0.7.0.1
 */