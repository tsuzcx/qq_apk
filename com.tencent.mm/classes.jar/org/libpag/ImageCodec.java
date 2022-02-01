package org.libpag;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class ImageCodec
{
  private static final int ALPHA_8 = 1;
  private static final int ARGB_8888_PREMULTIPLIED = 2;
  private static final int ARGB_8888_UNPREMULTIPLIED = 3;
  
  private static int[] GetSizeFromBytes(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187360);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    label57:
    for (;;)
    {
      try
      {
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        int i = localOptions.outWidth;
        int j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          j = localOptions.outHeight;
          AppMethodBeat.o(187360);
          return new int[] { i, j };
        }
        catch (Exception paramArrayOfByte)
        {
          break label57;
        }
        paramArrayOfByte = paramArrayOfByte;
        i = 0;
      }
    }
  }
  
  private static int[] GetSizeFromPath(String paramString)
  {
    AppMethodBeat.i(187351);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    label54:
    for (;;)
    {
      try
      {
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = localOptions.outWidth;
        int j = 0;
      }
      catch (Exception paramString)
      {
        try
        {
          j = localOptions.outHeight;
          AppMethodBeat.o(187351);
          return new int[] { i, j };
        }
        catch (Exception paramString)
        {
          break label54;
        }
        paramString = paramString;
        i = 0;
      }
    }
  }
  
  private static BitmapFactory.Options MakeOptions(int paramInt)
  {
    AppMethodBeat.i(187366);
    BitmapFactory.Options localOptions = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(187366);
      return localOptions;
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.ALPHA_8;
      continue;
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      continue;
      if (Build.VERSION.SDK_INT >= 19)
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inPremultiplied = false;
      }
    }
  }
  
  private static boolean ReadPixelsFromBytes(byte[] paramArrayOfByte, int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(187377);
    BitmapFactory.Options localOptions = MakeOptions(paramInt);
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.getConfig() != Bitmap.Config.ARGB_8888))
    {
      AppMethodBeat.o(187377);
      return false;
    }
    paramArrayOfByte.copyPixelsToBuffer(paramByteBuffer);
    AppMethodBeat.o(187377);
    return true;
  }
  
  private static boolean ReadPixelsFromPath(String paramString, int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(187371);
    paramString = BitmapFactory.decodeFile(paramString, MakeOptions(paramInt));
    if ((paramString == null) || (paramString.getConfig() != Bitmap.Config.ARGB_8888))
    {
      AppMethodBeat.o(187371);
      return false;
    }
    paramString.copyPixelsToBuffer(paramByteBuffer);
    AppMethodBeat.o(187371);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.libpag.ImageCodec
 * JD-Core Version:    0.7.0.1
 */