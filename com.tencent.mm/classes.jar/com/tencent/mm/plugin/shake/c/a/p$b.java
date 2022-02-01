package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class p$b
{
  public String PBF;
  public String price;
  public String thumbUrl;
  public String title;
  
  public static b aVO(String paramString)
  {
    AppMethodBeat.i(28342);
    Map localMap = XmlParser.parseXml(paramString, "nativepay", null);
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new b();
        paramString.title = Util.nullAsNil((String)localMap.get(".nativepay.title"));
        paramString.thumbUrl = Util.nullAsNil((String)localMap.get(".nativepay.thumburl"));
        paramString.PBF = Util.nullAsNil((String)localMap.get(".nativepay.wx_pay_url"));
        paramString.price = Util.nullAsNil((String)localMap.get(".nativepay.price"));
        AppMethodBeat.o(28342);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.p.b
 * JD-Core Version:    0.7.0.1
 */