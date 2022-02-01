package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class m$a
{
  public String path;
  public String thumbUrl;
  public String title;
  public String username;
  public int version;
  
  public static a asn(String paramString)
  {
    AppMethodBeat.i(28341);
    Map localMap = bv.L(paramString, "program");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new a();
        paramString.title = bs.nullAsNil((String)localMap.get(".program.title"));
        paramString.thumbUrl = bs.nullAsNil((String)localMap.get(".program.thumburl"));
        paramString.username = bs.nullAsNil((String)localMap.get(".program.username"));
        paramString.path = bs.nullAsNil((String)localMap.get(".program.path"));
        paramString.version = bs.getInt((String)localMap.get(".program.version"), 0);
        AppMethodBeat.o(28341);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.a
 * JD-Core Version:    0.7.0.1
 */