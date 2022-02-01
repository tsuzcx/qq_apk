package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ah
{
  protected static ThreadLocal<MessageDigest> cUy;
  protected static char[] hexDigits;
  
  static
  {
    AppMethodBeat.i(157614);
    hexDigits = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    cUy = new ThreadLocal()
    {
      private static MessageDigest Ia()
      {
        AppMethodBeat.i(157608);
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          AppMethodBeat.o(157608);
          return localMessageDigest;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          RuntimeException localRuntimeException = new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
          AppMethodBeat.o(157608);
          throw localRuntimeException;
        }
      }
    };
    AppMethodBeat.o(157614);
  }
  
  public static String B(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157611);
    paramArrayOfByte = ((MessageDigest)cUy.get()).digest(paramArrayOfByte);
    paramArrayOfByte = X(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(157611);
    return paramArrayOfByte;
  }
  
  private static String X(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(157612);
    StringBuffer localStringBuffer = new StringBuffer(paramInt * 2);
    int i = 0;
    while (i < paramInt + 0)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(157612);
    return paramArrayOfByte;
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(157613);
    char c1 = hexDigits[((paramByte & 0xF0) >> 4)];
    char c2 = hexDigits[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
    AppMethodBeat.o(157613);
  }
  
  public static String dg(String paramString)
  {
    AppMethodBeat.i(157610);
    paramString = B(paramString.getBytes());
    AppMethodBeat.o(157610);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ah
 * JD-Core Version:    0.7.0.1
 */