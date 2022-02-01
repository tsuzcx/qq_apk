package com.tencent.mm.plugin.shake.c.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.shake.c.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends BitmapDrawable
  implements r.a
{
  private static final Paint nOA;
  
  static
  {
    AppMethodBeat.i(28358);
    Paint localPaint = new Paint();
    nOA = localPaint;
    localPaint.setAntiAlias(true);
    nOA.setFilterBitmap(true);
    AppMethodBeat.o(28358);
  }
  
  public static String aRP(String paramString)
  {
    AppMethodBeat.i(28357);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
      AppMethodBeat.o(28357);
      return null;
    }
    String str = l.gXG();
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
      AppMethodBeat.o(28357);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { str, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(28357);
    return paramString;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(28354);
    AppMethodBeat.o(28354);
    throw null;
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(28356);
    AppMethodBeat.o(28356);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */