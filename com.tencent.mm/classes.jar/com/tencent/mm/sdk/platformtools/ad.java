package com.tencent.mm.sdk.platformtools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ad
{
  protected static char[] bsU = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected static ThreadLocal<MessageDigest> ufg = new ThreadLocal()
  {
    private static MessageDigest ru()
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
      }
    }
  };
  
  public static String bB(String paramString)
  {
    return n(paramString.getBytes());
  }
  
  public static String n(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ((MessageDigest)ufg.get()).digest(paramArrayOfByte);
    int j = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer(j * 2);
    int i = 0;
    while (i < j + 0)
    {
      int k = paramArrayOfByte[i];
      char c1 = bsU[((k & 0xF0) >> 4)];
      char c2 = bsU[(k & 0xF)];
      localStringBuffer.append(c1);
      localStringBuffer.append(c2);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ad
 * JD-Core Version:    0.7.0.1
 */