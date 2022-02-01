package com.tencent.mm.plugin.p;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Map;

public final class a
  implements com.tencent.mm.pluginsdk.wallet.b
{
  public final void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(106593);
    ad.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
    paramMap = new com.tencent.mm.wallet_core.c.q(paramMap, paramString1, paramString2, paramInt, parama);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramMap, 0);
    AppMethodBeat.o(106593);
  }
  
  public final cis dos()
  {
    AppMethodBeat.i(106594);
    cis localcis = k.dos();
    AppMethodBeat.o(106594);
    return localcis;
  }
  
  public final Typeface fP(Context paramContext)
  {
    AppMethodBeat.i(106592);
    paramContext = e.fP(paramContext);
    AppMethodBeat.o(106592);
    return paramContext;
  }
  
  public final void gD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106595);
    ad.i("MicroMsg.WxPaySevice", "reportLocation %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    k.Vy(paramInt1);
    if (k.eFo() != null) {
      com.tencent.mm.plugin.report.service.g.yhR.f(17162, new Object[] { Integer.valueOf(paramInt2), k.eFo().FsI, k.eFo().FsH, k.eFo().FsJ });
    }
    AppMethodBeat.o(106595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.p.a
 * JD-Core Version:    0.7.0.1
 */