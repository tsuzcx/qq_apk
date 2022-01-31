package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class o
{
  protected static final char[] a;
  private static String b;
  private static byte[] c;
  private static o f;
  private static String g;
  private Cipher d;
  private Cipher e;
  
  static
  {
    AppMethodBeat.i(65274);
    b = "";
    c = null;
    a = "0123456789abcdef".toCharArray();
    f = null;
    AppMethodBeat.o(65274);
  }
  
  private o()
  {
    AppMethodBeat.i(65267);
    this.d = null;
    this.e = null;
    g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
    Object localObject = "00000000";
    int i = 0;
    while (i < 12)
    {
      localObject = (String)localObject + String.valueOf(new Random().nextInt(89999999) + 10000000);
      i += 1;
    }
    c = ((String)localObject + g).getBytes();
    this.d = Cipher.getInstance("RSA/ECB/NoPadding");
    localObject = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0));
    localObject = KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject);
    this.d.init(1, (Key)localObject);
    b = b(this.d.doFinal(c));
    localObject = new DESedeKeySpec(g.getBytes());
    localObject = SecretKeyFactory.getInstance("DESede").generateSecret((KeySpec)localObject);
    this.e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    this.e.init(1, (Key)localObject);
    AppMethodBeat.o(65267);
  }
  
  public static o a()
  {
    AppMethodBeat.i(65268);
    try
    {
      if (f == null) {
        f = new o();
      }
      o localo = f;
      AppMethodBeat.o(65268);
      return localo;
    }
    catch (Exception localException)
    {
      f = null;
      AppMethodBeat.o(65268);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(65272);
    paramString = new DESedeKeySpec(paramString.getBytes());
    paramString = SecretKeyFactory.getInstance("DESede").generateSecret(paramString);
    Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    localCipher.init(1, paramString);
    paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
    AppMethodBeat.o(65272);
    return paramArrayOfByte;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65270);
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
    AppMethodBeat.o(65270);
    return paramArrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(65273);
    try
    {
      paramString = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(paramString.getBytes()));
      Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      localCipher.init(2, paramString);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      AppMethodBeat.o(65273);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(65273);
    }
    return null;
  }
  
  public static String c()
  {
    return g;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65269);
    paramArrayOfByte = this.e.doFinal(paramArrayOfByte);
    AppMethodBeat.o(65269);
    return paramArrayOfByte;
  }
  
  public String b()
  {
    return b;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65271);
    Object localObject = g.getBytes();
    try
    {
      localObject = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec((byte[])localObject));
      Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      localCipher.init(2, (Key)localObject);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      AppMethodBeat.o(65271);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(65271);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.o
 * JD-Core Version:    0.7.0.1
 */