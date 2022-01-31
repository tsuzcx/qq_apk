package com.tencent.mm.plugin.sns.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.b;
import com.tencent.mm.memory.l;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static Bitmap b(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(35786);
    long l = System.currentTimeMillis();
    try
    {
      Bitmap localBitmap = l.XQ().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = i.s(paramString, localBitmap);
      }
      ab.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      AppMethodBeat.o(35786);
      return paramOptions;
    }
    catch (OutOfMemoryError paramString)
    {
      b.dAs();
      ab.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(35786);
      return null;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SnsBitmapUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(35786);
    }
    return null;
  }
  
  public static n c(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(35785);
    long l = System.currentTimeMillis();
    try
    {
      Bitmap localBitmap = l.XQ().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = i.s(paramString, localBitmap);
      }
      ab.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      paramString = n.v(paramOptions);
      AppMethodBeat.o(35785);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      b.dAs();
      ab.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(35785);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.d.a
 * JD-Core Version:    0.7.0.1
 */