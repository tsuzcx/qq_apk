package com.tencent.mm.pluginsdk.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.OutputStream;

public final class f
{
  public static void a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31184);
    if (isNullOrNil(paramString))
    {
      paramBitmap = new IOException("saveBitmapToImage pathName null or nil");
      AppMethodBeat.o(31184);
      throw paramBitmap;
    }
    Object localObject = null;
    String str = null;
    try
    {
      paramString = i.cX(paramString, false);
      str = paramString;
      localObject = paramString;
      paramBitmap.compress(paramCompressFormat, 60, paramString);
      str = paramString;
      localObject = paramString;
      paramString.flush();
      if (paramString != null) {}
      try
      {
        paramString.close();
        if (paramBoolean)
        {
          ad.i("MicroMsg.VideoUtil", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          AppMethodBeat.o(31184);
          return;
        }
      }
      catch (IOException paramCompressFormat)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.VideoUtil", paramCompressFormat, "", new Object[0]);
        }
      }
      return;
    }
    catch (Exception paramCompressFormat)
    {
      localObject = str;
      ad.printErrStackTrace("MicroMsg.VideoUtil", paramCompressFormat, "", new Object[0]);
      if (str != null) {}
      try
      {
        str.close();
        if (paramBoolean)
        {
          ad.i("MicroMsg.VideoUtil", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          AppMethodBeat.o(31184);
          return;
        }
      }
      catch (IOException paramCompressFormat)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.VideoUtil", paramCompressFormat, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject != null) {}
      try
      {
        ((OutputStream)localObject).close();
        if (paramBoolean)
        {
          ad.i("MicroMsg.VideoUtil", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
        }
        AppMethodBeat.o(31184);
        throw paramCompressFormat;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.VideoUtil", paramString, "", new Object[0]);
        }
      }
      AppMethodBeat.o(31184);
    }
  }
  
  private static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(31183);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(31183);
      return true;
    }
    AppMethodBeat.o(31183);
    return false;
  }
  
  public static String qY(int paramInt)
  {
    AppMethodBeat.i(31182);
    String str = String.format("%d:%02d", new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) });
    AppMethodBeat.o(31182);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.f
 * JD-Core Version:    0.7.0.1
 */