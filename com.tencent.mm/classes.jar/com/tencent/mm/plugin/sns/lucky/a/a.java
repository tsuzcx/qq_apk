package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import java.io.IOException;

public final class a
{
  public static n a(Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95175);
    paramBitmap = n.E(h.l(paramBitmap, paramInt2));
    if (paramBitmap == null) {
      ae.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
    }
    if (paramBitmap != null) {
      new Canvas(paramBitmap.ayU()).drawColor(paramInt1);
    }
    try
    {
      h.a(paramBitmap.ayU(), 70, Bitmap.CompressFormat.JPEG, paramString, false);
      ae.i("MicroMsg.BlurHelper", "blur done bitmap  ".concat(String.valueOf(paramBitmap)));
      AppMethodBeat.o(95175);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.BlurHelper", "error for exception " + paramString.getMessage());
        ae.printErrStackTrace("MicroMsg.BlurHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public static n jq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95174);
    int i = Color.argb(51, 255, 255, 255);
    paramString1 = r.azr(paramString1);
    if (paramString1 == null)
    {
      ae.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
      AppMethodBeat.o(95174);
      return null;
    }
    paramString1 = a(paramString1.ayU(), paramString2, i, 55);
    AppMethodBeat.o(95174);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.a
 * JD-Core Version:    0.7.0.1
 */