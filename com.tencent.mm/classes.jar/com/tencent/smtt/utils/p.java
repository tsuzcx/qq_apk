package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.a.a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public class p
{
  private static final char[] a;
  private static p b;
  private String c;
  private String d;
  private String e;
  
  static
  {
    AppMethodBeat.i(65282);
    a = "0123456789abcdef".toCharArray();
    AppMethodBeat.o(65282);
  }
  
  private p()
  {
    AppMethodBeat.i(65275);
    int i = new Random().nextInt(89999999);
    int j = new Random().nextInt(89999999);
    this.e = String.valueOf(i + 10000000);
    this.c = (this.e + String.valueOf(j + 10000000));
    AppMethodBeat.o(65275);
  }
  
  public static p a()
  {
    try
    {
      AppMethodBeat.i(65276);
      if (b == null) {
        b = new p();
      }
      p localp = b;
      AppMethodBeat.o(65276);
      return localp;
    }
    finally {}
  }
  
  private String b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65281);
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = a[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(65281);
    return paramArrayOfByte;
  }
  
  public String a(String paramString)
  {
    AppMethodBeat.i(65279);
    byte[] arrayOfByte = paramString.getBytes();
    paramString = null;
    try
    {
      localObject = Cipher.getInstance("RSA/ECB/NoPadding");
      paramString = (String)localObject;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          b();
          Cipher localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
          paramString = localCipher;
        }
        catch (Exception localException2) {}
      }
    }
    localObject = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
    paramString.init(1, KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject));
    paramString = b(paramString.doFinal(arrayOfByte));
    AppMethodBeat.o(65279);
    return paramString;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65280);
    paramArrayOfByte = a.a(this.e.getBytes(), paramArrayOfByte, 1);
    AppMethodBeat.o(65280);
    return paramArrayOfByte;
  }
  
  public void b()
  {
    AppMethodBeat.i(65277);
    Security.addProvider((Provider)Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    AppMethodBeat.o(65277);
  }
  
  public String c()
  {
    AppMethodBeat.i(65278);
    byte[] arrayOfByte;
    if (this.d == null)
    {
      arrayOfByte = this.c.getBytes();
      localObject1 = null;
    }
    try
    {
      localObject2 = Cipher.getInstance("RSA/ECB/NoPadding");
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2;
          b();
          Cipher localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
          localObject1 = localCipher;
        }
        catch (Exception localException2) {}
      }
    }
    localObject2 = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
    ((Cipher)localObject1).init(1, KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject2));
    this.d = b(((Cipher)localObject1).doFinal(arrayOfByte));
    localObject1 = this.d;
    AppMethodBeat.o(65278);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.p
 * JD-Core Version:    0.7.0.1
 */