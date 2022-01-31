package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class m$a
{
  public String path;
  public String thumbUrl;
  public String title;
  public String username;
  public int version;
  
  public static a Ze(String paramString)
  {
    AppMethodBeat.i(24671);
    Map localMap = br.F(paramString, "program");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new a();
        paramString.title = bo.nullAsNil((String)localMap.get(".program.title"));
        paramString.thumbUrl = bo.nullAsNil((String)localMap.get(".program.thumburl"));
        paramString.username = bo.nullAsNil((String)localMap.get(".program.username"));
        paramString.path = bo.nullAsNil((String)localMap.get(".program.path"));
        paramString.version = bo.getInt((String)localMap.get(".program.version"), 0);
        AppMethodBeat.o(24671);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.a
 * JD-Core Version:    0.7.0.1
 */