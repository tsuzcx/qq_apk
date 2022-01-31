package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m$c
{
  public String id;
  public String thumbUrl;
  public String title;
  
  public static c My(String paramString)
  {
    paramString = bn.s(paramString, "product");
    if (paramString != null) {
      try
      {
        c localc = new c();
        localc.title = bk.pm((String)paramString.get(".product.title"));
        localc.thumbUrl = bk.pm((String)paramString.get(".product.thumburl"));
        localc.id = bk.pm((String)paramString.get(".product.product_id"));
        return localc;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.c
 * JD-Core Version:    0.7.0.1
 */