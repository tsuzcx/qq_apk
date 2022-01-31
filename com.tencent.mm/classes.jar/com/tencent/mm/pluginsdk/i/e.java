package com.tencent.mm.pluginsdk.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.OutputStream;

public final class e
{
  public static void a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (int i = 1; i != 0; i = 0) {
      throw new IOException("saveBitmapToImage pathName null or nil");
    }
    Object localObject = null;
    String str = null;
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.vfs.e.I(paramString, false);
        str = paramString;
        localObject = paramString;
        paramBitmap.compress(paramCompressFormat, 60, paramString);
        str = paramString;
        localObject = paramString;
        paramString.flush();
      }
      catch (Exception paramCompressFormat)
      {
        localObject = str;
        y.printErrStackTrace("MicroMsg.VideoUtil", paramCompressFormat, "", new Object[0]);
        if (str == null) {
          continue;
        }
        try
        {
          str.close();
          if (!paramBoolean) {
            continue;
          }
          y.i("MicroMsg.VideoUtil", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          return;
        }
        catch (IOException paramCompressFormat)
        {
          y.printErrStackTrace("MicroMsg.VideoUtil", paramCompressFormat, "", new Object[0]);
          continue;
        }
      }
      finally
      {
        if (localObject == null) {
          break label204;
        }
      }
      try
      {
        paramString.close();
        if (paramBoolean)
        {
          y.i("MicroMsg.VideoUtil", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
        }
        return;
      }
      catch (IOException paramCompressFormat)
      {
        y.printErrStackTrace("MicroMsg.VideoUtil", paramCompressFormat, "", new Object[0]);
      }
    }
    try
    {
      ((OutputStream)localObject).close();
      label204:
      if (paramBoolean)
      {
        y.i("MicroMsg.VideoUtil", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
      }
      throw paramCompressFormat;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.VideoUtil", paramString, "", new Object[0]);
      }
    }
  }
  
  public static String jL(int paramInt)
  {
    return String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.e
 * JD-Core Version:    0.7.0.1
 */