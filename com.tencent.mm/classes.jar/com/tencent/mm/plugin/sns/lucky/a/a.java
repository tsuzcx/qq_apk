package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a
{
  public static m a(Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95175);
    paramBitmap = m.O(BitmapUtil.fastblur(paramBitmap, paramInt2));
    if (paramBitmap == null) {
      Log.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
    }
    if (paramBitmap != null) {
      new Canvas(paramBitmap.bvQ()).drawColor(paramInt1);
    }
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap.bvQ(), 70, Bitmap.CompressFormat.JPEG, paramString, false);
      Log.i("MicroMsg.BlurHelper", "blur done bitmap  ".concat(String.valueOf(paramBitmap)));
      AppMethodBeat.o(95175);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.BlurHelper", "error for exception " + paramString.getMessage());
        Log.printErrStackTrace("MicroMsg.BlurHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public static m mb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95174);
    int i = Color.argb(51, 255, 255, 255);
    paramString1 = t.aXv(paramString1);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
      AppMethodBeat.o(95174);
      return null;
    }
    paramString1 = a(paramString1.bvQ(), paramString2, i, 55);
    AppMethodBeat.o(95174);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.a
 * JD-Core Version:    0.7.0.1
 */