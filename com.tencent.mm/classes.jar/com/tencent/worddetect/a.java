package com.tencent.worddetect;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class a
{
  private static WordDetectNative IMc;
  
  private static byte[] aG(Bitmap paramBitmap)
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
  
  public static int cy(Context paramContext, String paramString)
  {
    AppMethodBeat.i(91188);
    if (IMc == null) {}
    Object localObject;
    try
    {
      if (IMc == null)
      {
        localObject = new WordDetectNative();
        IMc = (WordDetectNative)localObject;
        ((WordDetectNative)localObject).init(kT(paramContext));
      }
      if ((paramString == null) || (paramString.length() <= 0))
      {
        ad.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
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
      f.decodeFile(paramString, paramContext);
      localObject = new BitmapFactory.Options();
      int i = paramContext.outWidth * paramContext.outHeight * 3;
      float f = 1.0F * paramContext.outHeight / paramContext.outWidth;
      if (i > 52428800)
      {
        ad.w("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, quit", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        AppMethodBeat.o(91188);
        return 0;
      }
      if ((f > 10.0F) || (f < 0.1F))
      {
        ad.w("MicroMsg.WordDetectModHelper", "bitmap width_height ratio too large %f, quit", new Object[] { Float.valueOf(f) });
        AppMethodBeat.o(91188);
        return 0;
      }
      if (i > 10485760)
      {
        ad.i("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
        ((BitmapFactory.Options)localObject).inSampleSize = 2;
      }
      paramContext = f.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramContext == null)
      {
        ad.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
        AppMethodBeat.o(91188);
        return 0;
      }
      paramString = aG(paramContext);
      boolean bool = bt.cw(paramString);
      if (bool)
      {
        AppMethodBeat.o(91188);
        return 0;
      }
      i = paramContext.getWidth();
      int j = paramContext.getHeight();
      int k = IMc.scanImage(paramString, i, j, 3);
      ad.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", new Object[] { Integer.valueOf(paramString.length), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (k != 0)
      {
        AppMethodBeat.o(91188);
        return 0;
      }
      i = IMc.getResult();
      ad.i("MicroMsg.WordDetectModHelper", "decodeFile ret = %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(91188);
      return i;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(91188);
      return 0;
    }
    catch (Error paramContext)
    {
      for (;;)
      {
        ad.e("MicroMsg.WordDetectModHelper", "System Error， error: %s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  private static WordDetectNative.ConfigParam kT(Context paramContext)
  {
    AppMethodBeat.i(91186);
    try
    {
      Object localObject = new e(b.ahY().replace("/data/user/0", "/data/data") + "files/", "word_detect");
      if (!((e)localObject).exists()) {
        ((e)localObject).mkdirs();
      }
      String str = q.B(((e)localObject).fhU());
      localObject = str + "/net_fc.bin";
      str = str + "/net_fc.param";
      SharedPreferences localSharedPreferences = aj.eFE();
      boolean bool = localSharedPreferences.getBoolean("word_detect_mode_version_2", false);
      if (!bool)
      {
        i.deleteFile((String)localObject);
        i.deleteFile(str);
        localSharedPreferences.edit().putBoolean("word_detect_mode_version_2", true).apply();
      }
      if ((!bool) || (!i.eK((String)localObject)))
      {
        o.Q(paramContext, "qbar/net_fc.bin", (String)localObject);
        o.Q(paramContext, "qbar/net_fc.param", str);
      }
      paramContext = new WordDetectNative.ConfigParam();
      paramContext.detect_model_bin = ((String)localObject);
      paramContext.detect_model_param = str;
      AppMethodBeat.o(91186);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ad.w("MicroMsg.WordDetectModHelper", "getWordDetectParam err %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(91186);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.worddetect.a
 * JD-Core Version:    0.7.0.1
 */