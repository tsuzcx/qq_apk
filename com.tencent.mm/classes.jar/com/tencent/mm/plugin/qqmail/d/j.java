package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class j
{
  public static int xrt = 100;
  private int maxCount;
  public String xru;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(122667);
    this.xru = null;
    this.maxCount = xrt;
    ae.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + paramString + ", maxCount = " + paramInt);
    this.xru = paramString;
    o.aZI(this.xru);
    if (paramInt > 0) {}
    for (;;)
    {
      this.maxCount = paramInt;
      AppMethodBeat.o(122667);
      return;
      paramInt = xrt;
    }
  }
  
  static String E(String paramString, Map<String, String> paramMap)
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
  
  static byte[] awk(String paramString)
  {
    AppMethodBeat.i(122671);
    paramString = g.getMessageDigest(paramString.toString().getBytes()).substring(8, 16).getBytes();
    AppMethodBeat.o(122671);
    return paramString;
  }
  
  static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
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
        ae.printErrStackTrace("Msg.Plugin.HttpRequestCache", paramArrayOfByte1, "", new Object[0]);
        paramArrayOfByte1 = null;
      }
    }
  }
  
  static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
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
        ae.printErrStackTrace("Msg.Plugin.HttpRequestCache", paramArrayOfByte1, "", new Object[0]);
        paramArrayOfByte1 = null;
      }
    }
  }
  
  public static byte[] readFromFile(String paramString)
  {
    AppMethodBeat.i(185979);
    paramString = o.bb(paramString, 0, -1);
    AppMethodBeat.o(185979);
    return paramString;
  }
  
  public static boolean u(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122677);
    if (bu.jB(o.f(paramString, paramArrayOfByte, paramArrayOfByte.length), 0))
    {
      AppMethodBeat.o(122677);
      return true;
    }
    AppMethodBeat.o(122677);
    return false;
  }
  
  public final void dFx()
  {
    int j = 0;
    AppMethodBeat.i(122673);
    Object localObject = new k(this.xru).list();
    if (localObject != null) {}
    for (int i = localObject.length; i < this.maxCount; i = 0)
    {
      AppMethodBeat.o(122673);
      return;
    }
    String[] arrayOfString = new k(this.xru).list();
    localObject = null;
    int k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      localObject = new k(arrayOfString[i]);
      ((k)localObject).lastModified();
      i += 1;
    }
    if (((k)localObject).exists()) {
      ((k)localObject).delete();
    }
    AppMethodBeat.o(122673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.j
 * JD-Core Version:    0.7.0.1
 */