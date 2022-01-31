package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ch.b;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static Bitmap b(String paramString, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    long l = System.currentTimeMillis();
    try
    {
      paramDecodeResultLogger = l.Fb().a(paramString, paramOptions, paramDecodeResultLogger);
      paramOptions = paramDecodeResultLogger;
      if (paramDecodeResultLogger != null) {
        paramOptions = i.q(paramString, paramDecodeResultLogger);
      }
      y.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      return paramOptions;
    }
    catch (OutOfMemoryError paramString)
    {
      b.cxz();
      y.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      return null;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.SnsBitmapUtil", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static n c(String paramString, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    long l = System.currentTimeMillis();
    try
    {
      paramDecodeResultLogger = l.Fb().a(paramString, paramOptions, paramDecodeResultLogger);
      paramOptions = paramDecodeResultLogger;
      if (paramDecodeResultLogger != null) {
        paramOptions = i.q(paramString, paramDecodeResultLogger);
      }
      y.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      paramString = n.o(paramOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      b.cxz();
      y.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d.a
 * JD-Core Version:    0.7.0.1
 */