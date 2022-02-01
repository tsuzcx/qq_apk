package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class k
{
  public static int vUa = 100;
  private int maxCount;
  public String vUb;
  
  public k(String paramString, int paramInt)
  {
    AppMethodBeat.i(122667);
    this.vUb = null;
    this.maxCount = vUa;
    ac.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + paramString + ", maxCount = " + paramInt);
    this.vUb = paramString;
    i.aSh(this.vUb);
    if (paramInt > 0) {}
    for (;;)
    {
      this.maxCount = paramInt;
      AppMethodBeat.o(122667);
      return;
      paramInt = vUa;
    }
  }
  
  private static String C(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(122670);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    if (paramMap != null)
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        Object localObject = (Map.Entry)paramString.next();
        paramMap = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        localStringBuffer.append(paramMap);
        localStringBuffer.append((String)localObject);
      }
    }
    paramString = g.getMessageDigest(localStringBuffer.toString().getBytes());
    AppMethodBeat.o(122670);
    return paramString;
  }
  
  private static byte[] apQ(String paramString)
  {
    AppMethodBeat.i(122671);
    paramString = g.getMessageDigest(paramString.toString().getBytes()).substring(8, 16).getBytes();
    AppMethodBeat.o(122671);
    return paramString;
  }
  
  private static int apR(String paramString)
  {
    AppMethodBeat.i(122672);
    paramString = new e(paramString).list();
    if (paramString != null)
    {
      int i = paramString.length;
      AppMethodBeat.o(122672);
      return i;
    }
    AppMethodBeat.o(122672);
    return 0;
  }
  
  private static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(122675);
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(122675);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        ac.printErrStackTrace("Msg.Plugin.HttpRequestCache", paramArrayOfByte1, "", new Object[0]);
        paramArrayOfByte1 = null;
      }
    }
  }
  
  private static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(122674);
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(122674);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        ac.printErrStackTrace("Msg.Plugin.HttpRequestCache", paramArrayOfByte1, "", new Object[0]);
        paramArrayOfByte1 = null;
      }
    }
  }
  
  public static byte[] readFromFile(String paramString)
  {
    AppMethodBeat.i(210496);
    paramString = i.aU(paramString, 0, -1);
    AppMethodBeat.o(210496);
    return paramString;
  }
  
  public static boolean t(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122677);
    if (bs.jl(i.f(paramString, paramArrayOfByte, paramArrayOfByte.length), 0))
    {
      AppMethodBeat.o(122677);
      return true;
    }
    AppMethodBeat.o(122677);
    return false;
  }
  
  public final byte[] B(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(122668);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
      AppMethodBeat.o(122668);
      return null;
    }
    paramString = C(paramString, paramMap);
    paramMap = i.aU(this.vUb + paramString, 0, -1);
    if (paramMap == null)
    {
      ac.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
      AppMethodBeat.o(122668);
      return null;
    }
    paramString = decrypt(paramMap, apQ(paramString));
    if (paramString == null)
    {
      ac.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
      AppMethodBeat.o(122668);
      return null;
    }
    AppMethodBeat.o(122668);
    return paramString;
  }
  
  public final boolean a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122669);
    if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ac.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
      AppMethodBeat.o(122669);
      return false;
    }
    drC();
    paramString = C(paramString, paramMap);
    paramMap = encrypt(paramArrayOfByte, apQ(paramString));
    if (paramMap == null)
    {
      ac.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
      AppMethodBeat.o(122669);
      return false;
    }
    boolean bool = t(this.vUb + paramString, paramMap);
    AppMethodBeat.o(122669);
    return bool;
  }
  
  public final void drC()
  {
    AppMethodBeat.i(122673);
    if (apR(this.vUb) < this.maxCount)
    {
      AppMethodBeat.o(122673);
      return;
    }
    String[] arrayOfString = new e(this.vUb).list();
    e locale = null;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      locale = new e(arrayOfString[i]);
      locale.lastModified();
      i += 1;
    }
    if (locale.exists()) {
      locale.delete();
    }
    AppMethodBeat.o(122673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.k
 * JD-Core Version:    0.7.0.1
 */