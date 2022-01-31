package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ag
{
  protected static char[] bUg;
  protected static ThreadLocal<MessageDigest> cic;
  
  static
  {
    AppMethodBeat.i(52057);
    bUg = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    cic = new ThreadLocal()
    {
      private static MessageDigest zK()
      {
        AppMethodBeat.i(52051);
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          AppMethodBeat.o(52051);
          return localMessageDigest;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          RuntimeException localRuntimeException = new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
          AppMethodBeat.o(52051);
          throw localRuntimeException;
        }
      }
    };
    AppMethodBeat.o(52057);
  }
  
  private static String U(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(52055);
    StringBuffer localStringBuffer = new StringBuffer(paramInt * 2);
    int i = 0;
    while (i < paramInt + 0)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(52055);
    return paramArrayOfByte;
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(52056);
    char c1 = bUg[((paramByte & 0xF0) >> 4)];
    char c2 = bUg[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
    AppMethodBeat.o(52056);
  }
  
  public static String cE(String paramString)
  {
    AppMethodBeat.i(52053);
    paramString = v(paramString.getBytes());
    AppMethodBeat.o(52053);
    return paramString;
  }
  
  public static String v(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52054);
    paramArrayOfByte = ((MessageDigest)cic.get()).digest(paramArrayOfByte);
    paramArrayOfByte = U(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(52054);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ag
 * JD-Core Version:    0.7.0.1
 */