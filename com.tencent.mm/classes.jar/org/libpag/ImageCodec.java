package org.libpag;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class ImageCodec
{
  private static int[] GetSizeFromBytes(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194858);
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
          AppMethodBeat.o(194858);
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
    AppMethodBeat.i(194856);
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
          AppMethodBeat.o(194856);
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
  
  private static boolean ReadPixelsFromBytes(byte[] paramArrayOfByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(194860);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.getConfig() != Bitmap.Config.ARGB_8888))
    {
      AppMethodBeat.o(194860);
      return false;
    }
    paramArrayOfByte.copyPixelsToBuffer(paramByteBuffer);
    AppMethodBeat.o(194860);
    return true;
  }
  
  private static boolean ReadPixelsFromPath(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(194859);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramString = BitmapFactory.decodeFile(paramString, localOptions);
    if ((paramString == null) || (paramString.getConfig() != Bitmap.Config.ARGB_8888))
    {
      AppMethodBeat.o(194859);
      return false;
    }
    paramString.copyPixelsToBuffer(paramByteBuffer);
    AppMethodBeat.o(194859);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.libpag.ImageCodec
 * JD-Core Version:    0.7.0.1
 */