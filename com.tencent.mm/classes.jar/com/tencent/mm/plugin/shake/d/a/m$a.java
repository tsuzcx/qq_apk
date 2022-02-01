package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class m$a
{
  public String path;
  public String thumbUrl;
  public String title;
  public String username;
  public int version;
  
  public static a ayD(String paramString)
  {
    AppMethodBeat.i(28341);
    Map localMap = bx.M(paramString, "program");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new a();
        paramString.title = bu.nullAsNil((String)localMap.get(".program.title"));
        paramString.thumbUrl = bu.nullAsNil((String)localMap.get(".program.thumburl"));
        paramString.username = bu.nullAsNil((String)localMap.get(".program.username"));
        paramString.path = bu.nullAsNil((String)localMap.get(".program.path"));
        paramString.version = bu.getInt((String)localMap.get(".program.version"), 0);
        AppMethodBeat.o(28341);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.a
 * JD-Core Version:    0.7.0.1
 */