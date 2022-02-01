package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class m$d
{
  public String thumbUrl;
  public String title;
  public String username;
  public String zel;
  
  public static d ayG(String paramString)
  {
    AppMethodBeat.i(28344);
    Map localMap = bx.M(paramString, "tempsession");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new d();
        paramString.title = bu.nullAsNil((String)localMap.get(".tempsession.title"));
        paramString.thumbUrl = bu.nullAsNil((String)localMap.get(".tempsession.thumburl"));
        paramString.username = bu.nullAsNil((String)localMap.get(".tempsession.username"));
        paramString.zel = bu.nullAsNil((String)localMap.get(".tempsession.deeplinkjumpurl"));
        AppMethodBeat.o(28344);
        return paramString;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        paramString = null;
        continue;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.d
 * JD-Core Version:    0.7.0.1
 */