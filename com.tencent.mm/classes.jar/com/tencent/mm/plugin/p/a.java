package com.tencent.mm.plugin.p;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Map;

public final class a
  implements com.tencent.mm.pluginsdk.wallet.b
{
  public final void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(106593);
    ac.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
    paramMap = new com.tencent.mm.wallet_core.c.q(paramMap, paramString1, paramString2, paramInt, parama);
    g.agS();
    g.agQ().ghe.a(paramMap, 0);
    AppMethodBeat.o(106593);
  }
  
  public final cdt deU()
  {
    AppMethodBeat.i(106594);
    cdt localcdt = k.deU();
    AppMethodBeat.o(106594);
    return localcdt;
  }
  
  public final Typeface fK(Context paramContext)
  {
    AppMethodBeat.i(106592);
    paramContext = e.fK(paramContext);
    AppMethodBeat.o(106592);
    return paramContext;
  }
  
  public final void gm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106595);
    ac.i("MicroMsg.WxPaySevice", "reportLocation %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    k.TG(paramInt1);
    if (k.ero() != null) {
      h.wUl.f(17162, new Object[] { Integer.valueOf(paramInt2), k.ero().DND, k.ero().DNC, k.ero().DNE });
    }
    AppMethodBeat.o(106595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.p.a
 * JD-Core Version:    0.7.0.1
 */