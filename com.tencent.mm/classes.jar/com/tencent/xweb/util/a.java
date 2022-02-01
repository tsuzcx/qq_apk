package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.xwalk.core.Log;

public final class a
{
  private static String TAG = "AESUtil";
  
  public static String a(String paramString, SecretKey paramSecretKey)
  {
    AppMethodBeat.i(156985);
    paramString = a(aPp(paramString), paramSecretKey);
    if (paramString == null)
    {
      AppMethodBeat.o(156985);
      return "";
    }
    paramString = new String(paramString);
    AppMethodBeat.o(156985);
    return paramString;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, SecretKey paramSecretKey)
  {
    AppMethodBeat.i(156984);
    try
    {
      paramSecretKey = new SecretKeySpec(paramSecretKey.getEncoded(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      localCipher.init(2, paramSecretKey);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      AppMethodBeat.o(156984);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      Log.e(TAG, "decrypt exp:" + paramArrayOfByte.getMessage());
      AppMethodBeat.o(156984);
    }
    return null;
  }
  
  public static SecretKey aPo(String paramString)
  {
    AppMethodBeat.i(156983);
    try
    {
      paramString = new SecretKeySpec(aPp(paramString), "AES");
      AppMethodBeat.o(156983);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e(TAG, "makekey exp:" + paramString.getMessage());
      AppMethodBeat.o(156983);
    }
    return null;
  }
  
  private static byte[] aPp(String paramString)
  {
    AppMethodBeat.i(156986);
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    AppMethodBeat.o(156986);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.util.a
 * JD-Core Version:    0.7.0.1
 */