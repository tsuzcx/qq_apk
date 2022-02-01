package com.tencent.thumbplayer.core.thirdparties;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

class LocalCache$Utils
{
  private static final char mSeparator = ' ';
  
  private static byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    AppMethodBeat.i(197683);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(197683);
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(197683);
    return paramBitmap;
  }
  
  private static Bitmap Bytes2Bimap(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {}
    return null;
  }
  
  private static Drawable bitmap2Drawable(Bitmap paramBitmap)
  {
    AppMethodBeat.i(197685);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(197685);
      return null;
    }
    paramBitmap = new BitmapDrawable(paramBitmap);
    AppMethodBeat.o(197685);
    return paramBitmap;
  }
  
  private static String clearDateInfo(String paramString)
  {
    AppMethodBeat.i(197677);
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (hasDateInfo(paramString.getBytes())) {
        str = paramString.substring(paramString.indexOf(' ') + 1, paramString.length());
      }
    }
    AppMethodBeat.o(197677);
    return str;
  }
  
  private static byte[] clearDateInfo(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197678);
    if (hasDateInfo(paramArrayOfByte))
    {
      paramArrayOfByte = copyOfRange(paramArrayOfByte, indexOf(paramArrayOfByte, ' ') + 1, paramArrayOfByte.length);
      AppMethodBeat.o(197678);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(197678);
    return paramArrayOfByte;
  }
  
  private static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197681);
    int i = paramInt2 - paramInt1;
    if (i < 0)
    {
      paramArrayOfByte = new IllegalArgumentException(paramInt1 + " > " + paramInt2);
      AppMethodBeat.o(197681);
      throw paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfByte.length - paramInt1, i));
    AppMethodBeat.o(197681);
    return arrayOfByte;
  }
  
  private static String createDateInfo(int paramInt)
  {
    AppMethodBeat.i(197682);
    for (String str = System.currentTimeMillis(); str.length() < 13; str = "0".concat(String.valueOf(str))) {}
    str = str + "-" + paramInt + ' ';
    AppMethodBeat.o(197682);
    return str;
  }
  
  private static Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(197684);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(197684);
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      AppMethodBeat.o(197684);
      return localObject;
    }
  }
  
  private static String[] getDateInfoFromDate(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197680);
    if (hasDateInfo(paramArrayOfByte))
    {
      String str = new String(copyOfRange(paramArrayOfByte, 0, 13));
      paramArrayOfByte = new String(copyOfRange(paramArrayOfByte, 14, indexOf(paramArrayOfByte, ' ')));
      AppMethodBeat.o(197680);
      return new String[] { str, paramArrayOfByte };
    }
    AppMethodBeat.o(197680);
    return null;
  }
  
  private static boolean hasDateInfo(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197679);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 15) && (paramArrayOfByte[13] == 45) && (indexOf(paramArrayOfByte, ' ') > 14))
    {
      AppMethodBeat.o(197679);
      return true;
    }
    AppMethodBeat.o(197679);
    return false;
  }
  
  private static int indexOf(byte[] paramArrayOfByte, char paramChar)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[i] == paramChar) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private static boolean isDue(String paramString)
  {
    AppMethodBeat.i(197673);
    boolean bool = isDue(paramString.getBytes());
    AppMethodBeat.o(197673);
    return bool;
  }
  
  private static boolean isDue(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197674);
    String[] arrayOfString = getDateInfoFromDate(paramArrayOfByte);
    if ((arrayOfString != null) && (arrayOfString.length == 2))
    {
      for (paramArrayOfByte = arrayOfString[0]; paramArrayOfByte.startsWith("0"); paramArrayOfByte = paramArrayOfByte.substring(1, paramArrayOfByte.length())) {}
      try
      {
        long l1 = Long.valueOf(paramArrayOfByte).longValue();
        long l2 = Long.valueOf(arrayOfString[1]).longValue();
        long l3 = System.currentTimeMillis();
        if (l3 > l1 + l2 * 1000L)
        {
          AppMethodBeat.o(197674);
          return true;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        AppMethodBeat.o(197674);
        return false;
      }
    }
    AppMethodBeat.o(197674);
    return false;
  }
  
  private static byte[] newByteArrayWithDateInfo(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197676);
    byte[] arrayOfByte1 = createDateInfo(paramInt).getBytes();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    AppMethodBeat.o(197676);
    return arrayOfByte2;
  }
  
  private static String newStringWithDateInfo(int paramInt, String paramString)
  {
    AppMethodBeat.i(197675);
    paramString = createDateInfo(paramInt) + paramString;
    AppMethodBeat.o(197675);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.thirdparties.LocalCache.Utils
 * JD-Core Version:    0.7.0.1
 */