package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.a.l;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class ac
{
  private static final Pattern yny;
  private byte[] key;
  public final bl ynA;
  private final ae<String, String> ynz = new ae(256);
  
  static
  {
    char c = (char)("⍆[0-9]+@".charAt(0) ^ 0xDCBA);
    yny = Pattern.compile(c + "⍆[0-9]+@".substring(1));
  }
  
  public ac(String paramString)
  {
    try
    {
      this.key = paramString.getBytes("UTF-8");
      this.ynA = new bl(paramString);
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
  
  public final String et(String paramString, int paramInt)
  {
    String str = paramString.substring(0, paramInt);
    if (this.ynz.aa(str)) {
      return (String)this.ynz.get(str);
    }
    paramInt = paramString.indexOf('@', 1);
    int i = paramInt + 1;
    paramString = paramString.substring(i, Integer.parseInt(paramString.substring(1, paramInt)) + i);
    try
    {
      paramString = new String(l.c(Base64.decode(paramString, 0), this.key), "UTF-8");
      this.ynz.put(str, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.LogDecryptor", paramString, "", new Object[0]);
    }
    return "[TD]".concat(String.valueOf(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ac
 * JD-Core Version:    0.7.0.1
 */