package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.performance.c.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;

public final class a
{
  public static Bitmap b(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(95064);
    long l = System.currentTimeMillis();
    try
    {
      Bitmap localBitmap = l.ayS().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = r.t(paramString, localBitmap);
      }
      ae.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      AppMethodBeat.o(95064);
      return paramOptions;
    }
    catch (OutOfMemoryError paramString)
    {
      ae.e("MicroMsg.SnsBitmapUtil", "%s", new Object[] { c.dCq().P(true, 0) });
      ae.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(95064);
      return null;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.SnsBitmapUtil", paramString, "", new Object[0]);
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
      Bitmap localBitmap = l.ayS().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = r.t(paramString, localBitmap);
      }
      ae.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      paramString = n.E(paramOptions);
      AppMethodBeat.o(95063);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      ae.e("MicroMsg.SnsBitmapUtil", "%s", new Object[] { c.dCq().P(true, 0) });
      ae.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(95063);
    }
    return null;
  }
  
  public static Bitmap m(String paramString, float paramFloat)
  {
    Object localObject = null;
    AppMethodBeat.i(219212);
    long l = System.currentTimeMillis();
    Bitmap localBitmap = l.ayS().a(paramString, null);
    if (paramFloat == 0.0F)
    {
      ae.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap });
      AppMethodBeat.o(219212);
      return localBitmap;
    }
    paramString = localObject;
    if (localBitmap != null)
    {
      paramString = h.a(localBitmap, true, localBitmap.getWidth() * paramFloat);
      ae.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap });
    }
    AppMethodBeat.o(219212);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d.a
 * JD-Core Version:    0.7.0.1
 */