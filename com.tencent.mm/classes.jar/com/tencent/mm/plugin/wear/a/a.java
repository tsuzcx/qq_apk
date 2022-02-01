package com.tencent.mm.plugin.wear.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  public static final HashMap<String, Object> iof()
  {
    AppMethodBeat.i(131327);
    Object localObject1 = KeyPairGenerator.getInstance("RSA");
    ((KeyPairGenerator)localObject1).initialize(1024);
    Object localObject2 = ((KeyPairGenerator)localObject1).generateKeyPair();
    localObject1 = (RSAPublicKey)((KeyPair)localObject2).getPublic();
    localObject2 = (RSAPrivateKey)((KeyPair)localObject2).getPrivate();
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("RSAPublicKey", localObject1);
    localHashMap.put("RSAPrivateKey", localObject2);
    AppMethodBeat.o(131327);
    return localHashMap;
  }
  
  public static final byte[] iog()
  {
    AppMethodBeat.i(131329);
    try
    {
      Object localObject = KeyGenerator.getInstance("AES");
      ((KeyGenerator)localObject).init(128);
      localObject = ((KeyGenerator)localObject).generateKey().getEncoded();
      AppMethodBeat.o(131329);
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      AppMethodBeat.o(131329);
    }
    return null;
  }
  
  public static final byte[] n(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(131328);
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, paramArrayOfByte2);
    paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
    AppMethodBeat.o(131328);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.a.a
 * JD-Core Version:    0.7.0.1
 */