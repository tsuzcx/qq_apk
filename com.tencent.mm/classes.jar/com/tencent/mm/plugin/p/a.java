package com.tencent.mm.plugin.p;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.byx;
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
    g.afC();
    g.afA().gcy.a(paramMap, 0);
    AppMethodBeat.o(106593);
  }
  
  public final byx cRk()
  {
    AppMethodBeat.i(106594);
    byx localbyx = k.cRk();
    AppMethodBeat.o(106594);
    return localbyx;
  }
  
  public final Typeface fy(Context paramContext)
  {
    AppMethodBeat.i(106592);
    paramContext = e.fy(paramContext);
    AppMethodBeat.o(106592);
    return paramContext;
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106595);
    ad.i("MicroMsg.WxPaySevice", "reportLocation %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    k.Rx(paramInt1);
    if (k.ebS() != null) {
      h.vKh.f(17162, new Object[] { Integer.valueOf(paramInt2), k.ebS().Cvi, k.ebS().Cvh, k.ebS().Cvj });
    }
    AppMethodBeat.o(106595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.p.a
 * JD-Core Version:    0.7.0.1
 */