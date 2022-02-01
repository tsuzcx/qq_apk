package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.b.l;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class ad
{
  private static final Pattern GrA;
  private final af<String, String> GrB = new af(256);
  public final bp GrC;
  private byte[] key;
  
  static
  {
    char c = (char)("⍆[0-9]+@".charAt(0) ^ 0xDCBA);
    GrA = Pattern.compile(c + "⍆[0-9]+@".substring(1));
  }
  
  public ad(String paramString)
  {
    try
    {
      this.key = paramString.getBytes("UTF-8");
      this.GrC = new bp(paramString);
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
  
  public final String fJ(String paramString, int paramInt)
  {
    String str = paramString.substring(0, paramInt);
    if (this.GrB.aL(str)) {
      return (String)this.GrB.get(str);
    }
    paramInt = paramString.indexOf('@', 1);
    int i = paramInt + 1;
    paramString = paramString.substring(i, Integer.parseInt(paramString.substring(1, paramInt)) + i);
    try
    {
      paramString = new String(l.d(Base64.decode(paramString, 0), this.key), "UTF-8");
      this.GrB.put(str, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.LogDecryptor", paramString, "", new Object[0]);
    }
    return "[TD]".concat(String.valueOf(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ad
 * JD-Core Version:    0.7.0.1
 */