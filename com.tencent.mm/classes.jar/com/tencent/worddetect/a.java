package com.tencent.worddetect;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.m;
import java.io.File;
import java.nio.ByteBuffer;

public class a
{
  private static WordDetectNative BCO;
  
  public static int ch(Context paramContext, String paramString)
  {
    AppMethodBeat.i(138530);
    if (BCO == null) {}
    Object localObject;
    try
    {
      if (BCO == null)
      {
        localObject = new WordDetectNative();
        BCO = (WordDetectNative)localObject;
        ((WordDetectNative)localObject).init(jP(paramContext));
      }
      if ((paramString == null) || (paramString.length() <= 0))
      {
        ab.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
        AppMethodBeat.o(138530);
        return 0;
      }
    }
    finally
    {
      AppMethodBeat.o(138530);
    }
    try
    {
      long l = System.currentTimeMillis();
      paramContext = d.aoT(paramString);
      if (paramContext != null)
      {
        paramContext.inJustDecodeBounds = false;
        if (paramContext.outWidth * paramContext.outHeight * 8 * 4L > 268435456L)
        {
          ab.i("MicroMsg.WordDetectModHelper", "initial width %d, initial height %d", new Object[] { Integer.valueOf(paramContext.outWidth), Integer.valueOf(paramContext.outHeight) });
          paramContext.inSampleSize = 4;
        }
      }
      paramContext = d.decodeFile(paramString, paramContext);
      if (paramContext == null)
      {
        ab.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
        AppMethodBeat.o(138530);
        return 0;
      }
      paramString = ByteBuffer.allocate(paramContext.getByteCount());
      paramContext.copyPixelsToBuffer(paramString);
      paramString = paramString.array();
      localObject = new byte[paramString.length / 4 * 3];
      int i = 0;
      while (i < paramString.length / 4)
      {
        localObject[(i * 3)] = paramString[(i * 4 + 2)];
        localObject[(i * 3 + 1)] = paramString[(i * 4 + 1)];
        localObject[(i * 3 + 2)] = paramString[(i * 4)];
        i += 1;
      }
      i = paramContext.getWidth();
      int j = paramContext.getHeight();
      int k = BCO.scanImage((byte[])localObject, i, j, 3);
      ab.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (k != 0)
      {
        AppMethodBeat.o(138530);
        return 0;
      }
      i = BCO.getResult();
      ab.i("MicroMsg.WordDetectModHelper", "decodeFile ret = %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(138530);
      return i;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(138530);
    }
    return 0;
  }
  
  private static WordDetectNative.ConfigParam jP(Context paramContext)
  {
    AppMethodBeat.i(138529);
    try
    {
      Object localObject = new File(com.tencent.mm.compatible.util.e.eQu.replace("/data/user/0", "/data/data") + "files/", "word_detect");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str = ((File)localObject).getAbsolutePath();
      localObject = str + "/net_fc.bin";
      str = str + "/net_fc.param";
      SharedPreferences localSharedPreferences = ah.dsQ();
      boolean bool = localSharedPreferences.getBoolean("word_detect_mode_version_2", false);
      if (!bool)
      {
        com.tencent.mm.a.e.deleteFile((String)localObject);
        com.tencent.mm.a.e.deleteFile(str);
        localSharedPreferences.edit().putBoolean("word_detect_mode_version_2", true).apply();
      }
      if ((!bool) || (!com.tencent.mm.a.e.cN((String)localObject)))
      {
        m.copyAssets(paramContext, "qbar/net_fc.bin", (String)localObject);
        m.copyAssets(paramContext, "qbar/net_fc.param", str);
      }
      paramContext = new WordDetectNative.ConfigParam();
      paramContext.detect_model_bin = ((String)localObject);
      paramContext.detect_model_param = str;
      AppMethodBeat.o(138529);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.w("MicroMsg.WordDetectModHelper", "getWordDetectParam err %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(138529);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.worddetect.a
 * JD-Core Version:    0.7.0.1
 */