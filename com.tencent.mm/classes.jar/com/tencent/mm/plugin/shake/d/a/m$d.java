package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m$d
{
  public String obc;
  public String thumbUrl;
  public String title;
  public String username;
  
  public static d Mz(String paramString)
  {
    paramString = bn.s(paramString, "tempsession");
    if (paramString != null) {
      try
      {
        d locald = new d();
        locald.title = bk.pm((String)paramString.get(".tempsession.title"));
        locald.thumbUrl = bk.pm((String)paramString.get(".tempsession.thumburl"));
        locald.username = bk.pm((String)paramString.get(".tempsession.username"));
        locald.obc = bk.pm((String)paramString.get(".tempsession.deeplinkjumpurl"));
        return locald;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.d
 * JD-Core Version:    0.7.0.1
 */