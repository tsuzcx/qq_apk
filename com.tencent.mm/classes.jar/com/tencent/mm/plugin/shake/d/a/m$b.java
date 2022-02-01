package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class m$b
{
  public String thumbUrl;
  public String title;
  public String wDS;
  public String yOa;
  
  public static b axo(String paramString)
  {
    AppMethodBeat.i(28342);
    Map localMap = bw.M(paramString, "nativepay");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new b();
        paramString.title = bt.nullAsNil((String)localMap.get(".nativepay.title"));
        paramString.thumbUrl = bt.nullAsNil((String)localMap.get(".nativepay.thumburl"));
        paramString.yOa = bt.nullAsNil((String)localMap.get(".nativepay.wx_pay_url"));
        paramString.wDS = bt.nullAsNil((String)localMap.get(".nativepay.price"));
        AppMethodBeat.o(28342);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.b
 * JD-Core Version:    0.7.0.1
 */