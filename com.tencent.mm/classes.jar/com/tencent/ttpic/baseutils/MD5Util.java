package com.tencent.ttpic.baseutils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
  private static final String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
  
  public static String GetMD5Code(String paramString)
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
    return paramString;
  }
  
  private static String byteToArrayString(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    return strDigits[paramByte] + strDigits[(i % 16)];
  }
  
  private static String byteToNum(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    return String.valueOf(i);
  }
  
  private static String byteToString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(byteToArrayString(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.MD5Util
 * JD-Core Version:    0.7.0.1
 */