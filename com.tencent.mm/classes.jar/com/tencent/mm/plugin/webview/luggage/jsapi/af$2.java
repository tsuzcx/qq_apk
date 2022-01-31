package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class af$2
  implements b.a
{
  af$2(af paramaf, a.a parama, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(6335);
    ab.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.njN.a("fail", null);
      AppMethodBeat.o(6335);
      return;
    }
    if (this.hoJ == 2)
    {
      ab.d("MicroMsg.JsApiLogin", "press reject button");
      this.njN.a("fail", null);
      AppMethodBeat.o(6335);
      return;
    }
    paramString = (axv)paramb.fsW.fta;
    if ((paramString == null) || (paramString.xmS == null))
    {
      this.njN.a("fail", null);
      AppMethodBeat.o(6335);
      return;
    }
    paramInt1 = paramString.xmS.csV;
    paramb = paramString.xmS.csW;
    ab.i("MicroMsg.JsApiLogin", "jsErrcode = %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0)
    {
      paramString = paramString.xmZ;
      new HashMap().put("code", paramString);
      this.njN.a("", null);
      ab.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramString });
      AppMethodBeat.o(6335);
      return;
    }
    this.njN.a("fail", null);
    ab.e("MicroMsg.JsApiLogin", "errMsg = %s", new Object[] { paramb });
    AppMethodBeat.o(6335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.af.2
 * JD-Core Version:    0.7.0.1
 */