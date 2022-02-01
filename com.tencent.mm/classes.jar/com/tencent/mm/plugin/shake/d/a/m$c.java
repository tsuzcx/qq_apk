package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class m$c
{
  public String id;
  public String thumbUrl;
  public String title;
  
  public static c asp(String paramString)
  {
    AppMethodBeat.i(28343);
    Map localMap = bv.L(paramString, "product");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new c();
        paramString.title = bs.nullAsNil((String)localMap.get(".product.title"));
        paramString.thumbUrl = bs.nullAsNil((String)localMap.get(".product.thumburl"));
        paramString.id = bs.nullAsNil((String)localMap.get(".product.product_id"));
        AppMethodBeat.o(28343);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.c
 * JD-Core Version:    0.7.0.1
 */