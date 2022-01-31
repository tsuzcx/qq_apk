package com.tencent.mm.plugin.o;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.c.a;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Map;

public final class a
  implements c
{
  public final void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, c.a parama)
  {
    AppMethodBeat.i(55856);
    ab.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
    paramMap = new o(paramMap, paramString1, paramString2, paramInt, parama);
    g.RM();
    g.RK().eHt.a(paramMap, 0);
    AppMethodBeat.o(55856);
  }
  
  public final bkx bSo()
  {
    AppMethodBeat.i(55857);
    bkx localbkx = m.bSo();
    AppMethodBeat.o(55857);
    return localbkx;
  }
  
  public final Typeface eA(Context paramContext)
  {
    AppMethodBeat.i(55855);
    paramContext = e.eA(paramContext);
    AppMethodBeat.o(55855);
    return paramContext;
  }
  
  public final void eJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55858);
    ab.i("MicroMsg.WxPaySevice", "reportLocation %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    m.Iy(paramInt1);
    if (m.cTC() != null) {
      h.qsU.e(17162, new Object[] { Integer.valueOf(paramInt2), m.cTC().wmT, m.cTC().wmS, m.cTC().wmU });
    }
    AppMethodBeat.o(55858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.o.a
 * JD-Core Version:    0.7.0.1
 */