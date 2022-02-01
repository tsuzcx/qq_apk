package com.tencent.mm.plugin.remittance.bankcard.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekg;
import com.tencent.mm.protocal.protobuf.ekh;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends b
{
  public ekh Ocl;
  private final String TAG;
  private h callback;
  private c rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(67382);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    c.a locala = new c.a();
    locala.otE = new ekg();
    locala.otF = new ekh();
    locala.funcId = 1579;
    locala.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((ekg)c.b.b(this.rr.otB)).YYi = paramString;
    Log.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", new Object[] { paramString });
    AppMethodBeat.o(67382);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67384);
    Log.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ocl = ((ekh)c.c.b(((c)params).otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67384);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67383);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67383);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288711);
    params = (ekh)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288711);
  }
  
  public final int getType()
  {
    return 1579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.l
 * JD-Core Version:    0.7.0.1
 */