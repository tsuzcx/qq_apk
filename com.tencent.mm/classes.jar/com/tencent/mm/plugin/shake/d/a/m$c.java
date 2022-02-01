package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class m$c
{
  public String id;
  public String thumbUrl;
  public String title;
  
  public static c aXY(String paramString)
  {
    AppMethodBeat.i(28343);
    Map localMap = XmlParser.parseXml(paramString, "product", null);
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new c();
        paramString.title = Util.nullAsNil((String)localMap.get(".product.title"));
        paramString.thumbUrl = Util.nullAsNil((String)localMap.get(".product.thumburl"));
        paramString.id = Util.nullAsNil((String)localMap.get(".product.product_id"));
        AppMethodBeat.o(28343);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.c
 * JD-Core Version:    0.7.0.1
 */