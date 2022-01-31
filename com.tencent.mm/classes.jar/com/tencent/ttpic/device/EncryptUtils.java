package com.tencent.ttpic.device;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class EncryptUtils
{
  private static final byte[] BUILD_FINGERPRINT_AND_DEVICE_SERIAL = ;
  public static final String DEFAULT_ALGORITHM = "DES";
  
  public static byte[] decrypt(byte[] paramArrayOfByte, String paramString)
  {
    paramString = toKey(Base64.decode(paramString, 0));
    Cipher localCipher = Cipher.getInstance("DES");
    localCipher.init(2, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte, String paramString)
  {
    paramString = toKey(Base64.decode(paramString, 0));
    Cipher localCipher = Cipher.getInstance("DES");
    localCipher.init(1, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private static byte[] generateSeed()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(System.currentTimeMillis());
      localDataOutputStream.writeLong(System.nanoTime());
      localDataOutputStream.writeInt(Process.myPid());
      localDataOutputStream.writeInt(Process.myUid());
      localDataOutputStream.write(BUILD_FINGERPRINT_AND_DEVICE_SERIAL);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new SecurityException("Failed to generate seed", localIOException);
    }
  }
  
  private static byte[] getBuildFingerprintAndDeviceSerial()
  {
    Object localObject = new StringBuilder();
    String str = Build.FINGERPRINT;
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    str = getDeviceSerialNumber();
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    try
    {
      localObject = ((StringBuilder)localObject).toString().getBytes("UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 encoding not supported");
    }
  }
  
  private static String getDeviceSerialNumber()
  {
    try
    {
      String str = (String)Build.class.getField("SERIAL").get(null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String initKey()
  {
    return initKey(null);
  }
  
  public static String initKey(String paramString)
  {
    
    if (paramString != null) {}
    for (paramString = new SecureRandom(generateSeed());; paramString = new SecureRandom())
    {
      KeyGenerator localKeyGenerator = KeyGenerator.getInstance("DES");
      localKeyGenerator.init(paramString);
      return Base64.encodeToString(localKeyGenerator.generateKey().getEncoded(), 0);
    }
  }
  
  private static void installLinuxPRNGSecureRandom()
  {
    if (Build.VERSION.SDK_INT > 18) {}
    for (;;)
    {
      return;
      Object localObject = Security.getProviders("SecureRandom.SHA1PRNG");
      if ((localObject == null) || (localObject.length <= 0) || (!EncryptUtils.LinuxPRNGSecureRandomProvider.class.equals(localObject[0].getClass()))) {
        Security.insertProviderAt(new EncryptUtils.LinuxPRNGSecureRandomProvider(), 1);
      }
      localObject = new SecureRandom();
      if (!EncryptUtils.LinuxPRNGSecureRandomProvider.class.equals(((SecureRandom)localObject).getProvider().getClass())) {
        throw new SecurityException("new SecureRandom() backed by wrong Provider: " + ((SecureRandom)localObject).getProvider().getClass());
      }
      try
      {
        localObject = SecureRandom.getInstance("SHA1PRNG");
        if (EncryptUtils.LinuxPRNGSecureRandomProvider.class.equals(((SecureRandom)localObject).getProvider().getClass())) {
          continue;
        }
        throw new SecurityException("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: " + ((SecureRandom)localObject).getProvider().getClass());
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new SecurityException("SHA1PRNG not available", localNoSuchAlgorithmException);
      }
    }
  }
  
  private static Key toKey(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new DESKeySpec(paramArrayOfByte);
    return SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.device.EncryptUtils
 * JD-Core Version:    0.7.0.1
 */