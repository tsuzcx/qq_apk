package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
  private static final String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
  
  public static String GetMD5Code(String paramString)
  {
    AppMethodBeat.i(49790);
    for (;;)
    {
      try
      {
        String str = new String(paramString);
        LogUtils.e(localNoSuchAlgorithmException1);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
      {
        try
        {
          paramString = byteToString(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
          AppMethodBeat.o(49790);
          return paramString;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
        {
          for (;;)
          {
            paramString = localNoSuchAlgorithmException1;
            Object localObject = localNoSuchAlgorithmException2;
          }
        }
        localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
        paramString = null;
      }
    }
  }
  
  private static String byteToArrayString(byte paramByte)
  {
    AppMethodBeat.i(49787);
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    String str = strDigits[paramByte] + strDigits[(i % 16)];
    AppMethodBeat.o(49787);
    return str;
  }
  
  private static String byteToNum(byte paramByte)
  {
    AppMethodBeat.i(49788);
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    AppMethodBeat.o(49788);
    return String.valueOf(i);
  }
  
  private static String byteToString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(49789);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(byteToArrayString(paramArrayOfByte[i]));
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(49789);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.MD5Util
 * JD-Core Version:    0.7.0.1
 */