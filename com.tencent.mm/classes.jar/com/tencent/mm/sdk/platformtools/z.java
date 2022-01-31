package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.a.k;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class z
{
  private static final Pattern ueX;
  private byte[] key;
  private final ab<String, String> ueY = new ab(256);
  public final bh ueZ;
  
  static
  {
    char c = (char)("⍆[0-9]+@".charAt(0) ^ 0xDCBA);
    ueX = Pattern.compile(c + "⍆[0-9]+@".substring(1));
  }
  
  public z(String paramString)
  {
    try
    {
      this.key = paramString.getBytes("UTF-8");
      this.ueZ = new bh(paramString);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        this.key = paramString.getBytes();
      }
    }
  }
  
  public final String jdMethod_do(String paramString, int paramInt)
  {
    String str = paramString.substring(0, paramInt);
    if (this.ueY.bR(str)) {
      return (String)this.ueY.get(str);
    }
    paramInt = paramString.indexOf('@', 1);
    int i = paramInt + 1;
    paramString = paramString.substring(i, Integer.parseInt(paramString.substring(1, paramInt)) + i);
    try
    {
      paramString = new String(k.a(Base64.decode(paramString, 0), this.key), "UTF-8");
      this.ueY.put(str, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.LogDecryptor", paramString, "", new Object[0]);
    }
    return "[TD]" + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.z
 * JD-Core Version:    0.7.0.1
 */