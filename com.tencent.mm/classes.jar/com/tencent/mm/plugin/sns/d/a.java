package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.performance.watchdogs.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static Bitmap b(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(95064);
    long l = System.currentTimeMillis();
    try
    {
      Bitmap localBitmap = l.baT().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = t.t(paramString, localBitmap);
      }
      Log.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      AppMethodBeat.o(95064);
      return paramOptions;
    }
    catch (OutOfMemoryError paramString)
    {
      Log.e("MicroMsg.SnsBitmapUtil", "%s", new Object[] { c.fou().ad(true, 0) });
      Log.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(95064);
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SnsBitmapUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(95064);
    }
    return null;
  }
  
  public static n c(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(95063);
    long l = System.currentTimeMillis();
    try
    {
      Bitmap localBitmap = l.baT().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = t.t(paramString, localBitmap);
      }
      Log.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      paramString = n.F(paramOptions);
      AppMethodBeat.o(95063);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      Log.e("MicroMsg.SnsBitmapUtil", "%s", new Object[] { c.fou().ad(true, 0) });
      Log.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(95063);
    }
    return null;
  }
  
  public static Bitmap l(String paramString, float paramFloat)
  {
    Object localObject = null;
    AppMethodBeat.i(231999);
    long l = System.currentTimeMillis();
    Bitmap localBitmap = l.baT().a(paramString, null);
    if (paramFloat == 0.0F)
    {
      Log.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap });
      AppMethodBeat.o(231999);
      return localBitmap;
    }
    paramString = localObject;
    if (localBitmap != null)
    {
      paramString = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, localBitmap.getWidth() * paramFloat);
      Log.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap });
    }
    AppMethodBeat.o(231999);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d.a
 * JD-Core Version:    0.7.0.1
 */