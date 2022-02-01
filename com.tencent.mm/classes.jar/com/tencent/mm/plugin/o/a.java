package com.tencent.mm.plugin.o;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Map;

public final class a
  implements com.tencent.mm.pluginsdk.wallet.b
{
  public final void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(106593);
    Log.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
    paramMap = new q(paramMap, paramString1, paramString2, paramInt, parama);
    g.aAi();
    g.aAg().hqi.a(paramMap, 0);
    AppMethodBeat.o(106593);
  }
  
  public final czu elk()
  {
    AppMethodBeat.i(106594);
    czu localczu = k.elk();
    AppMethodBeat.o(106594);
    return localczu;
  }
  
  public final Typeface gA(Context paramContext)
  {
    AppMethodBeat.i(106592);
    paramContext = f.gA(paramContext);
    AppMethodBeat.o(106592);
    return paramContext;
  }
  
  public final void he(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106595);
    Log.i("MicroMsg.WxPaySevice", "reportLocation %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.RTc.c(new a.1(this, paramInt1, paramInt2), "wxpay_report_location");
    AppMethodBeat.o(106595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.o.a
 * JD-Core Version:    0.7.0.1
 */