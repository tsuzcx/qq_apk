package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class m$a
{
  public String path;
  public String thumbUrl;
  public String title;
  public String username;
  public int version;
  
  public static a aXW(String paramString)
  {
    AppMethodBeat.i(28341);
    Map localMap = XmlParser.parseXml(paramString, "program", null);
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new a();
        paramString.title = Util.nullAsNil((String)localMap.get(".program.title"));
        paramString.thumbUrl = Util.nullAsNil((String)localMap.get(".program.thumburl"));
        paramString.username = Util.nullAsNil((String)localMap.get(".program.username"));
        paramString.path = Util.nullAsNil((String)localMap.get(".program.path"));
        paramString.version = Util.getInt((String)localMap.get(".program.version"), 0);
        AppMethodBeat.o(28341);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.a
 * JD-Core Version:    0.7.0.1
 */