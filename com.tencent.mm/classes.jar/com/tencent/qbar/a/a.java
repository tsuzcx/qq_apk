package com.tencent.qbar.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.qbar.a.a;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static List<a.a> a(Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91184);
    com.tencent.scanlib.b.a locala = new com.tencent.scanlib.b.a("MicroMsg.ScanImageUtil");
    locala.a(1, com.tencent.scanlib.a.lg(ak.getContext()));
    if (locala.hasInited()) {
      locala.M(paramArrayOfInt);
    }
    paramArrayOfInt = null;
    if (paramBitmap != null)
    {
      String.format("%s,%s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      paramArrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
      paramBitmap.getPixels(paramArrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      paramArrayOfInt = locala.a(paramArrayOfInt, new Point(paramBitmap.getWidth(), paramBitmap.getHeight()));
      if (paramArrayOfInt == null) {}
      for (int i = 0;; i = paramArrayOfInt.size())
      {
        String.format("get %d decode results", new Object[] { Integer.valueOf(i) });
        paramBitmap = paramArrayOfInt.iterator();
        while (paramBitmap.hasNext())
        {
          a.a locala1 = (a.a)paramBitmap.next();
          new StringBuilder("result ").append(locala1.typeName).append(",").append(locala1.data);
        }
      }
    }
    locala.release();
    AppMethodBeat.o(91184);
    return paramArrayOfInt;
  }
  
  public static a.a b(Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91185);
    paramBitmap = a(paramBitmap, paramArrayOfInt);
    if ((paramBitmap != null) && (paramBitmap.size() > 0))
    {
      paramBitmap = (a.a)paramBitmap.get(0);
      AppMethodBeat.o(91185);
      return paramBitmap;
    }
    AppMethodBeat.o(91185);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.a.a
 * JD-Core Version:    0.7.0.1
 */