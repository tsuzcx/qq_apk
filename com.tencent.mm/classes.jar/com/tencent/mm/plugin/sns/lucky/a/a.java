package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class a
{
  public static n a(Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    paramBitmap = n.o(c.f(paramBitmap, paramInt2));
    if (paramBitmap == null) {
      y.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
    }
    if (paramBitmap != null) {
      new Canvas(paramBitmap.Fd()).drawColor(paramInt1);
    }
    try
    {
      c.a(paramBitmap.Fd(), 70, Bitmap.CompressFormat.JPEG, paramString, false);
      y.i("MicroMsg.BlurHelper", "blur done bitmap  " + paramBitmap);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.BlurHelper", "error for exception " + paramString.getMessage());
        y.printErrStackTrace("MicroMsg.BlurHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public static n eF(String paramString1, String paramString2)
  {
    int i = Color.argb(51, 255, 255, 255);
    paramString1 = i.MY(paramString1);
    if (paramString1 == null)
    {
      y.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
      return null;
    }
    return a(paramString1.Fd(), paramString2, i, 55);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.a
 * JD-Core Version:    0.7.0.1
 */