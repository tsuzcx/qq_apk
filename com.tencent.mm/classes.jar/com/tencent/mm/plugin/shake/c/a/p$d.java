package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class p$d
{
  public String PBG;
  public String thumbUrl;
  public String title;
  public String username;
  
  public static d aVQ(String paramString)
  {
    AppMethodBeat.i(28344);
    Map localMap = XmlParser.parseXml(paramString, "tempsession", null);
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new d();
        paramString.title = Util.nullAsNil((String)localMap.get(".tempsession.title"));
        paramString.thumbUrl = Util.nullAsNil((String)localMap.get(".tempsession.thumburl"));
        paramString.username = Util.nullAsNil((String)localMap.get(".tempsession.username"));
        paramString.PBG = Util.nullAsNil((String)localMap.get(".tempsession.deeplinkjumpurl"));
        AppMethodBeat.o(28344);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        paramString = null;
        continue;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.p.d
 * JD-Core Version:    0.7.0.1
 */