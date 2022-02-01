package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class m$c
{
  public String id;
  public String thumbUrl;
  public String title;
  
  public static c ang(String paramString)
  {
    AppMethodBeat.i(28343);
    Map localMap = bw.K(paramString, "product");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new c();
        paramString.title = bt.nullAsNil((String)localMap.get(".product.title"));
        paramString.thumbUrl = bt.nullAsNil((String)localMap.get(".product.thumburl"));
        paramString.id = bt.nullAsNil((String)localMap.get(".product.product_id"));
        AppMethodBeat.o(28343);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.c
 * JD-Core Version:    0.7.0.1
 */