package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.e.a.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements b.a
{
  c$1(c paramc, a.a parama, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    y.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.kNj.a("fail", null);
      return;
    }
    paramString = (aro)paramb.ecF.ecN;
    if ((paramString == null) || (paramString.tnb == null))
    {
      this.kNj.a("fail", null);
      return;
    }
    paramInt1 = paramString.tnb.bLB;
    paramb = paramString.tnb.bLC;
    y.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == -12000)
    {
      ai.d(new c.1.1(this, paramString.tab, paramString.kVn, paramString.suv));
      return;
    }
    if (paramInt1 == 0)
    {
      this.kNj.a("", null);
      return;
    }
    y.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramb });
    this.kNj.a("fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c.1
 * JD-Core Version:    0.7.0.1
 */