package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class m$b
{
  public String thumbUrl;
  public String title;
  public String wTD;
  public String zek;
  
  public static b ayE(String paramString)
  {
    AppMethodBeat.i(28342);
    Map localMap = bx.M(paramString, "nativepay");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new b();
        paramString.title = bu.nullAsNil((String)localMap.get(".nativepay.title"));
        paramString.thumbUrl = bu.nullAsNil((String)localMap.get(".nativepay.thumburl"));
        paramString.zek = bu.nullAsNil((String)localMap.get(".nativepay.wx_pay_url"));
        paramString.wTD = bu.nullAsNil((String)localMap.get(".nativepay.price"));
        AppMethodBeat.o(28342);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.b
 * JD-Core Version:    0.7.0.1
 */