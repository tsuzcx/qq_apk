package com.tencent.mm.plugin.sns.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.k;
import com.tencent.mm.memory.m;
import com.tencent.mm.plugin.performance.watchdogs.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    AppMethodBeat.i(306276);
    a(paramOptions1, paramOptions2);
    long l = System.currentTimeMillis();
    try
    {
      paramOptions2 = k.bvO().a(paramString, paramOptions1);
      paramOptions1 = paramOptions2;
      if (paramOptions2 != null) {
        paramOptions1 = t.t(paramString, paramOptions2);
      }
      Log.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions1 });
      AppMethodBeat.o(306276);
      return paramOptions1;
    }
    catch (OutOfMemoryError paramString)
    {
      Log.e("MicroMsg.SnsBitmapUtil", "%s", new Object[] { d.gzs().af(true, 0) });
      Log.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(306276);
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SnsBitmapUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(306276);
    }
    return null;
  }
  
  private static void a(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    AppMethodBeat.i(306280);
    if ((Build.VERSION.SDK_INT > 26) && (paramOptions2 != null) && ((paramOptions2.outColorSpace == ColorSpace.get(ColorSpace.Named.DCI_P3)) || (paramOptions2.outColorSpace == ColorSpace.get(ColorSpace.Named.DISPLAY_P3)))) {
      paramOptions1.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
    }
    AppMethodBeat.o(306280);
  }
  
  public static m c(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(95063);
    a(paramOptions, paramOptions);
    long l = System.currentTimeMillis();
    try
    {
      Bitmap localBitmap = k.bvO().a(paramString, paramOptions);
      paramOptions = localBitmap;
      if (localBitmap != null) {
        paramOptions = t.t(paramString, localBitmap);
      }
      Log.d("MicroMsg.SnsBitmapUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramOptions });
      paramString = m.O(paramOptions);
      AppMethodBeat.o(95063);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      Log.e("MicroMsg.SnsBitmapUtil", "%s", new Object[] { d.gzs().af(true, 0) });
      Log.e("MicroMsg.SnsBitmapUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(95063);
    }
    return null;
  }
  
  public static Bitmap m(String paramString, float paramFloat)
  {
    Object localObject = null;
    AppMethodBeat.i(306266);
    long l = System.currentTimeMillis();
    Bitmap localBitmap = k.bvO().a(paramString, null);
    if (paramFloat == 0.0F)
    {
      Log.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap });
      AppMethodBeat.o(306266);
      return localBitmap;
    }
    paramString = localObject;
    if (localBitmap != null)
    {
      paramString = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, localBitmap.getWidth() * paramFloat);
      Log.d("MicroMsg.SnsBitmapUtil", "decode used %dms %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localBitmap });
    }
    AppMethodBeat.o(306266);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.a
 * JD-Core Version:    0.7.0.1
 */