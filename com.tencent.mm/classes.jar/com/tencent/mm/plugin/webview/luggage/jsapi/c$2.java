package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements b.a
{
  c$2(c paramc, a.a parama, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(6280);
    ab.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.njN.a("fail", null);
      AppMethodBeat.o(6280);
      return;
    }
    if (this.hoJ == 2)
    {
      ab.d("MicroMsg.JsApiAuthorize", "press reject button");
      this.njN.a("fail", null);
      AppMethodBeat.o(6280);
      return;
    }
    paramString = (axr)paramb.fsW.fta;
    if ((paramString == null) || (paramString.xmS == null))
    {
      this.njN.a("fail", null);
      AppMethodBeat.o(6280);
      return;
    }
    paramInt1 = paramString.xmS.csV;
    paramString = paramString.xmS.csW;
    ab.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0)
    {
      this.njN.a("", null);
      AppMethodBeat.o(6280);
      return;
    }
    ab.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramString });
    this.njN.a("fail", null);
    AppMethodBeat.o(6280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c.2
 * JD-Core Version:    0.7.0.1
 */