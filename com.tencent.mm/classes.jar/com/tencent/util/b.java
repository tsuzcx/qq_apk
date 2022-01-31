package com.tencent.util;

import java.security.Key;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class b
{
  public static byte[] encode(byte[] paramArrayOfByte)
  {
    Object localObject = new DESedeKeySpec(Coffee.cRi().getBytes());
    localObject = SecretKeyFactory.getInstance("desede").generateSecret((KeySpec)localObject);
    Cipher localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
    localCipher.init(1, (Key)localObject, new IvParameterSpec("68881999".getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.util.b
 * JD-Core Version:    0.7.0.1
 */