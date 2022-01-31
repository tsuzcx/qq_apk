package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m$a
{
  public String path;
  public String thumbUrl;
  public String title;
  public String username;
  public int version;
  
  public static a Mw(String paramString)
  {
    paramString = bn.s(paramString, "program");
    if (paramString != null) {
      try
      {
        a locala = new a();
        locala.title = bk.pm((String)paramString.get(".program.title"));
        locala.thumbUrl = bk.pm((String)paramString.get(".program.thumburl"));
        locala.username = bk.pm((String)paramString.get(".program.username"));
        locala.path = bk.pm((String)paramString.get(".program.path"));
        locala.version = bk.getInt((String)paramString.get(".program.version"), 0);
        return locala;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.a
 * JD-Core Version:    0.7.0.1
 */