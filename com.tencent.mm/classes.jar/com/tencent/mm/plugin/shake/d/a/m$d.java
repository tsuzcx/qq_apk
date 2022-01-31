package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class m$d
{
  public String qPl;
  public String thumbUrl;
  public String title;
  public String username;
  
  public static d Zh(String paramString)
  {
    AppMethodBeat.i(24674);
    Map localMap = br.F(paramString, "tempsession");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new d();
        paramString.title = bo.nullAsNil((String)localMap.get(".tempsession.title"));
        paramString.thumbUrl = bo.nullAsNil((String)localMap.get(".tempsession.thumburl"));
        paramString.username = bo.nullAsNil((String)localMap.get(".tempsession.username"));
        paramString.qPl = bo.nullAsNil((String)localMap.get(".tempsession.deeplinkjumpurl"));
        AppMethodBeat.o(24674);
        return paramString;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        paramString = null;
        continue;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.d
 * JD-Core Version:    0.7.0.1
 */