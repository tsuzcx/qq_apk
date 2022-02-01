package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class m$e
{
  public String dta;
  public String link;
  public String thumbUrl;
  public String title;
  
  public static e ani(String paramString)
  {
    AppMethodBeat.i(28345);
    Map localMap = bw.K(paramString, "h5url");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new e();
        paramString.title = bt.nullAsNil((String)localMap.get(".h5url.title"));
        paramString.thumbUrl = bt.nullAsNil((String)localMap.get(".h5url.thumburl"));
        paramString.link = bt.nullAsNil((String)localMap.get(".h5url.link"));
        paramString.dta = bt.nullAsNil((String)localMap.get(".h5url.username"));
        AppMethodBeat.o(28345);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.e
 * JD-Core Version:    0.7.0.1
 */