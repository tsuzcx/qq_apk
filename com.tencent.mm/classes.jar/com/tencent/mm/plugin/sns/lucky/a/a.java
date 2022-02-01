package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class a
{
  public static n a(Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95175);
    paramBitmap = n.D(f.l(paramBitmap, paramInt2));
    if (paramBitmap == null) {
      ac.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
    }
    if (paramBitmap != null) {
      new Canvas(paramBitmap.avS()).drawColor(paramInt1);
    }
    try
    {
      f.a(paramBitmap.avS(), 70, Bitmap.CompressFormat.JPEG, paramString, false);
      ac.i("MicroMsg.BlurHelper", "blur done bitmap  ".concat(String.valueOf(paramBitmap)));
      AppMethodBeat.o(95175);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.BlurHelper", "error for exception " + paramString.getMessage());
        ac.printErrStackTrace("MicroMsg.BlurHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public static n iX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95174);
    int i = Color.argb(51, 255, 255, 255);
    paramString1 = q.asV(paramString1);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
      AppMethodBeat.o(95174);
      return null;
    }
    paramString1 = a(paramString1.avS(), paramString2, i, 55);
    AppMethodBeat.o(95174);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.a
 * JD-Core Version:    0.7.0.1
 */