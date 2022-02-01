package com.tenpay.ndk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MessageDigestUtil
{
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73325);
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(73325);
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
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(73325);
    return paramArrayOfByte;
  }
  
  private native byte[] doSHA256(byte[] paramArrayOfByte);
  
  public String getSHA256Hex(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73326);
    localObject2 = null;
    localObject1 = localObject2;
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = doSHA256(paramArrayOfByte);
      localObject1 = localObject2;
      if (paramArrayOfByte != null) {
        localObject1 = bytesToHex(paramArrayOfByte);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    AppMethodBeat.o(73326);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tenpay.ndk.MessageDigestUtil
 * JD-Core Version:    0.7.0.1
 */