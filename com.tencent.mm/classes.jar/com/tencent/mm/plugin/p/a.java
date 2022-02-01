package com.tencent.mm.plugin.p;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Map;

public final class a
  implements com.tencent.mm.pluginsdk.wallet.b
{
  public final void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(106593);
    ae.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
    paramMap = new com.tencent.mm.wallet_core.c.q(paramMap, paramString1, paramString2, paramInt, parama);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramMap, 0);
    AppMethodBeat.o(106593);
  }
  
  public final cjm drq()
  {
    AppMethodBeat.i(106594);
    cjm localcjm = k.drq();
    AppMethodBeat.o(106594);
    return localcjm;
  }
  
  public final Typeface fV(Context paramContext)
  {
    AppMethodBeat.i(106592);
    paramContext = f.fV(paramContext);
    AppMethodBeat.o(106592);
    return paramContext;
  }
  
  public final void gD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106595);
    ae.i("MicroMsg.WxPaySevice", "reportLocation %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    k.Wf(paramInt1);
    if (k.eIV() != null) {
      com.tencent.mm.plugin.report.service.g.yxI.f(17162, new Object[] { Integer.valueOf(paramInt2), k.eIV().FLg, k.eIV().FLf, k.eIV().FLh });
    }
    AppMethodBeat.o(106595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.p.a
 * JD-Core Version:    0.7.0.1
 */