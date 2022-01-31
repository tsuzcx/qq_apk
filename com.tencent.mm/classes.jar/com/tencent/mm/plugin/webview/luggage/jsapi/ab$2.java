package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.e.a.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class ab$2
  implements b.a
{
  ab$2(ab paramab, a.a parama, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    y.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.kNj.a("fail", null);
      return;
    }
    if (this.fVh == 2)
    {
      y.d("MicroMsg.JsApiLogin", "press reject button");
      this.kNj.a("fail", null);
      return;
    }
    paramString = (arq)paramb.ecF.ecN;
    if ((paramString == null) || (paramString.tnb == null))
    {
      this.kNj.a("fail", null);
      return;
    }
    paramInt1 = paramString.tnb.bLB;
    paramb = paramString.tnb.bLC;
    y.i("MicroMsg.JsApiLogin", "jsErrcode = %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0)
    {
      paramString = paramString.tne;
      new HashMap().put("code", paramString);
      this.kNj.a("", null);
      y.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramString });
      return;
    }
    this.kNj.a("fail", null);
    y.e("MicroMsg.JsApiLogin", "errMsg = %s", new Object[] { paramb });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ab.2
 * JD-Core Version:    0.7.0.1
 */