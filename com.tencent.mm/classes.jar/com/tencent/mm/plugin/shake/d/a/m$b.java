package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class m$b
{
  public String thumbUrl;
  public String title;
  public String vyy;
  public String xzq;
  
  public static b aso(String paramString)
  {
    AppMethodBeat.i(28342);
    Map localMap = bv.L(paramString, "nativepay");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new b();
        paramString.title = bs.nullAsNil((String)localMap.get(".nativepay.title"));
        paramString.thumbUrl = bs.nullAsNil((String)localMap.get(".nativepay.thumburl"));
        paramString.xzq = bs.nullAsNil((String)localMap.get(".nativepay.wx_pay_url"));
        paramString.vyy = bs.nullAsNil((String)localMap.get(".nativepay.price"));
        AppMethodBeat.o(28342);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.b
 * JD-Core Version:    0.7.0.1
 */