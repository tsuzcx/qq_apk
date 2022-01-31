package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class m$e
{
  public String cCC;
  public String link;
  public String thumbUrl;
  public String title;
  
  public static e Zi(String paramString)
  {
    AppMethodBeat.i(24675);
    Map localMap = br.F(paramString, "h5url");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new e();
        paramString.title = bo.nullAsNil((String)localMap.get(".h5url.title"));
        paramString.thumbUrl = bo.nullAsNil((String)localMap.get(".h5url.thumburl"));
        paramString.link = bo.nullAsNil((String)localMap.get(".h5url.link"));
        paramString.cCC = bo.nullAsNil((String)localMap.get(".h5url.username"));
        AppMethodBeat.o(24675);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.e
 * JD-Core Version:    0.7.0.1
 */