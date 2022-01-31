package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m$b
{
  public String mQn;
  public String obb;
  public String thumbUrl;
  public String title;
  
  public static b Mx(String paramString)
  {
    paramString = bn.s(paramString, "nativepay");
    if (paramString != null) {
      try
      {
        b localb = new b();
        localb.title = bk.pm((String)paramString.get(".nativepay.title"));
        localb.thumbUrl = bk.pm((String)paramString.get(".nativepay.thumburl"));
        localb.obb = bk.pm((String)paramString.get(".nativepay.wx_pay_url"));
        localb.mQn = bk.pm((String)paramString.get(".nativepay.price"));
        return localb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.b
 * JD-Core Version:    0.7.0.1
 */