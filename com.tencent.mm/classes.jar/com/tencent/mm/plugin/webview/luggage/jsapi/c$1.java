package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class c$1
  implements b.a
{
  c$1(c paramc, a.a parama, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(6279);
    ab.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.njN.a("fail", null);
      AppMethodBeat.o(6279);
      return;
    }
    paramString = (axt)paramb.fsW.fta;
    if ((paramString == null) || (paramString.xmS == null))
    {
      this.njN.a("fail", null);
      AppMethodBeat.o(6279);
      return;
    }
    paramInt1 = paramString.xmS.csV;
    paramb = paramString.xmS.csW;
    ab.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == -12000)
    {
      al.d(new c.1.1(this, paramString.wYt, paramString.ntp, paramString.wnz));
      AppMethodBeat.o(6279);
      return;
    }
    if (paramInt1 == 0)
    {
      this.njN.a("", null);
      AppMethodBeat.o(6279);
      return;
    }
    ab.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramb });
    this.njN.a("fail", null);
    AppMethodBeat.o(6279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c.1
 * JD-Core Version:    0.7.0.1
 */