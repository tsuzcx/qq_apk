package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class m$d
{
  public String thumbUrl;
  public String title;
  public String username;
  public String xzr;
  
  public static d asq(String paramString)
  {
    AppMethodBeat.i(28344);
    Map localMap = bv.L(paramString, "tempsession");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new d();
        paramString.title = bs.nullAsNil((String)localMap.get(".tempsession.title"));
        paramString.thumbUrl = bs.nullAsNil((String)localMap.get(".tempsession.thumburl"));
        paramString.username = bs.nullAsNil((String)localMap.get(".tempsession.username"));
        paramString.xzr = bs.nullAsNil((String)localMap.get(".tempsession.deeplinkjumpurl"));
        AppMethodBeat.o(28344);
        return paramString;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
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