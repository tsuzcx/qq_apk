package com.tencent.mm.plugin.wear.a;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  public static final byte[] bZc()
  {
    try
    {
      Object localObject = KeyGenerator.getInstance("AES");
      ((KeyGenerator)localObject).init(128);
      localObject = ((KeyGenerator)localObject).generateKey().getEncoded();
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return null;
  }
  
  public static final byte[] f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, paramArrayOfByte2);
    return localCipher.doFinal(paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.a.a
 * JD-Core Version:    0.7.0.1
 */