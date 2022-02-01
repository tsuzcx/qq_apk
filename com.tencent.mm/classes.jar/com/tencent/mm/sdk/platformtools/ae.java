package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.b.l;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class ae
{
  private static final Pattern Idq;
  private final ag<String, String> Idr = new ag(256);
  public final bq Ids;
  private byte[] key;
  
  static
  {
    char c = (char)("⍆[0-9]+@".charAt(0) ^ 0xDCBA);
    Idq = Pattern.compile(c + "⍆[0-9]+@".substring(1));
  }
  
  public ae(String paramString)
  {
    try
    {
      this.key = paramString.getBytes("UTF-8");
      this.Ids = new bq(paramString);
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
  
  public final String gg(String paramString, int paramInt)
  {
    String str = paramString.substring(0, paramInt);
    if (this.Idr.aN(str)) {
      return (String)this.Idr.get(str);
    }
    paramInt = paramString.indexOf('@', 1);
    int i = paramInt + 1;
    paramString = paramString.substring(i, Integer.parseInt(paramString.substring(1, paramInt)) + i);
    try
    {
      paramString = new String(l.d(Base64.decode(paramString, 0), this.key), "UTF-8");
      this.Idr.put(str, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.LogDecryptor", paramString, "", new Object[0]);
    }
    return "[TD]".concat(String.valueOf(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ae
 * JD-Core Version:    0.7.0.1
 */