package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cj.b;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;

public final class a
{
  public static Bitmap b(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(95064);
    long l = System.currentTimeMillis();
    try
    {
      Bitmap localBitmap = l.avQ().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = q.t(paramString, localBitmap);
      }
      ac.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      AppMethodBeat.o(95064);
      return paramOptions;
    }
    catch (OutOfMemoryError paramString)
    {
      b.fep();
      ac.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(95064);
      return null;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.SnsBitmapUtil", paramString, "", new Object[0]);
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
      Bitmap localBitmap = l.avQ().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = q.t(paramString, localBitmap);
      }
      ac.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      paramString = n.D(paramOptions);
      AppMethodBeat.o(95063);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      b.fep();
      ac.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(95063);
    }
    return null;
  }
  
  public static Bitmap l(String paramString, float paramFloat)
  {
    Object localObject = null;
    AppMethodBeat.i(200032);
    long l = System.currentTimeMillis();
    Bitmap localBitmap = l.avQ().a(paramString, null);
    if (paramFloat == 0.0F)
    {
      ac.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap });
      AppMethodBeat.o(200032);
      return localBitmap;
    }
    paramString = localObject;
    if (localBitmap != null)
    {
      paramString = f.a(localBitmap, true, localBitmap.getWidth() * paramFloat);
      ac.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap });
    }
    AppMethodBeat.o(200032);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d.a
 * JD-Core Version:    0.7.0.1
 */