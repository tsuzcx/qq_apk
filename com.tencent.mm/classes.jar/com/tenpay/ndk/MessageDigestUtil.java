package com.tenpay.ndk;

public class MessageDigestUtil
{
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private native byte[] doSHA256(byte[] paramArrayOfByte);
  
  public String getSHA256Hex(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = doSHA256(paramArrayOfByte);
      localObject1 = localObject2;
      if (paramArrayOfByte != null) {
        localObject1 = bytesToHex(paramArrayOfByte);
      }
      return localObject1;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tenpay.ndk.MessageDigestUtil
 * JD-Core Version:    0.7.0.1
 */