package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class p$e
{
  public String hUQ;
  public String link;
  public String thumbUrl;
  public String title;
  
  public static e aVR(String paramString)
  {
    AppMethodBeat.i(28345);
    Map localMap = XmlParser.parseXml(paramString, "h5url", null);
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new e();
        paramString.title = Util.nullAsNil((String)localMap.get(".h5url.title"));
        paramString.thumbUrl = Util.nullAsNil((String)localMap.get(".h5url.thumburl"));
        paramString.link = Util.nullAsNil((String)localMap.get(".h5url.link"));
        paramString.hUQ = Util.nullAsNil((String)localMap.get(".h5url.username"));
        AppMethodBeat.o(28345);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.p.e
 * JD-Core Version:    0.7.0.1
 */