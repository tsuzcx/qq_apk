package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.vfs.u;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
  protected static ThreadLocal<MessageDigest> TLS_digest;
  protected static char[] hexDigits;
  
  static
  {
    AppMethodBeat.i(157614);
    hexDigits = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    TLS_digest = new ThreadLocal()
    {
      protected MessageDigest initialValue()
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
  
  private static void appendHexPair(byte paramByte, StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(157613);
    char c1 = hexDigits[((paramByte & 0xF0) >> 4)];
    char c2 = hexDigits[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
    AppMethodBeat.o(157613);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(243764);
    paramArrayOfByte = bufferToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(243764);
    return paramArrayOfByte;
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243769);
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      appendHexPair(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(243769);
    return paramArrayOfByte;
  }
  
  public static boolean checkPassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243776);
    boolean bool = getMD5String(paramString1).equals(paramString2);
    AppMethodBeat.o(243776);
    return bool;
  }
  
  @Deprecated
  public static String getFileMD5String(u paramu)
  {
    AppMethodBeat.i(243755);
    paramu = g.a(paramu, 102400);
    AppMethodBeat.o(243755);
    return paramu;
  }
  
  public static String getMD5String(String paramString)
  {
    AppMethodBeat.i(157610);
    paramString = getMD5String(paramString.getBytes());
    AppMethodBeat.o(157610);
    return paramString;
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157611);
    paramArrayOfByte = bufferToHex(((MessageDigest)TLS_digest.get()).digest(paramArrayOfByte));
    AppMethodBeat.o(157611);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MD5Util
 * JD-Core Version:    0.7.0.1
 */