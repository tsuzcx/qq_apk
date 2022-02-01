package com.tencent.mm.c.b.a;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  public static final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(2, paramArrayOfByte2);
    return localCipher.doFinal(paramArrayOfByte1);
  }
  
  public static final byte[] lj()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */