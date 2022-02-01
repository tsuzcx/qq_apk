package com.tencent.mm.plugin.remittance.bankcard.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class k
  extends b
{
  public dzb Ock;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public k()
  {
    AppMethodBeat.i(67379);
    c.a locala = new c.a();
    locala.otE = new dza();
    locala.otF = new dzb();
    locala.funcId = 1280;
    locala.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(67379);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67381);
    Log.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ock = ((dzb)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.Ock.hAV), this.Ock.wYI });
    if ((!this.oaK) && (!this.wZR))
    {
      Log.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[] { Integer.valueOf(this.Ock.abdR), Integer.valueOf(this.Ock.abdS) });
      if (this.Ock.abdR >= 0) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUv, Integer.valueOf(this.Ock.abdR));
      }
      if (this.Ock.abdS > 0) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUw, Integer.valueOf(this.Ock.abdS));
      }
      if (!Util.isNullOrNil(this.Ock.abdT)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUx, this.Ock.abdT);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67381);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(67380);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67380);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288721);
    params = (dzb)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288721);
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.k
 * JD-Core Version:    0.7.0.1
 */