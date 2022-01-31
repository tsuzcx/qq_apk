package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m$e
{
  public String bUU;
  public String eAl;
  public String thumbUrl;
  public String title;
  
  public static e MA(String paramString)
  {
    paramString = bn.s(paramString, "h5url");
    if (paramString != null) {
      try
      {
        e locale = new e();
        locale.title = bk.pm((String)paramString.get(".h5url.title"));
        locale.thumbUrl = bk.pm((String)paramString.get(".h5url.thumburl"));
        locale.eAl = bk.pm((String)paramString.get(".h5url.link"));
        locale.bUU = bk.pm((String)paramString.get(".h5url.username"));
        return locale;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.e
 * JD-Core Version:    0.7.0.1
 */