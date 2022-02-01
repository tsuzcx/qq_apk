package com.tencent.mm.plugin.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.protocal.protobuf.ebs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.q;
import com.tencent.threadpool.i;
import java.util.Map;

public final class a
  implements b
{
  public final void a(Map<String, Object> paramMap, String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(106593);
    Log.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
    paramMap = new q(paramMap, paramString1, paramString2, paramInt, parama);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramMap, 0);
    AppMethodBeat.o(106593);
  }
  
  public final ebs gdF()
  {
    AppMethodBeat.i(106594);
    ebs localebs = k.gdF();
    AppMethodBeat.o(106594);
    return localebs;
  }
  
  public final void jO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106595);
    Log.i("MicroMsg.WxPaySevice", "reportLocation %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.threadpool.h.ahAA.h(new a.1(this, paramInt1, paramInt2), "wxpay_report_location");
    AppMethodBeat.o(106595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.x.a
 * JD-Core Version:    0.7.0.1
 */