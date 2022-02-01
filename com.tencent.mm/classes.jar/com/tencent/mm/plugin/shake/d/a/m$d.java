package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class m$d
{
  public String thumbUrl;
  public String title;
  public String username;
  public String woa;
  
  public static d anh(String paramString)
  {
    AppMethodBeat.i(28344);
    Map localMap = bw.K(paramString, "tempsession");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new d();
        paramString.title = bt.nullAsNil((String)localMap.get(".tempsession.title"));
        paramString.thumbUrl = bt.nullAsNil((String)localMap.get(".tempsession.thumburl"));
        paramString.username = bt.nullAsNil((String)localMap.get(".tempsession.username"));
        paramString.woa = bt.nullAsNil((String)localMap.get(".tempsession.deeplinkjumpurl"));
        AppMethodBeat.o(28344);
        return paramString;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
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