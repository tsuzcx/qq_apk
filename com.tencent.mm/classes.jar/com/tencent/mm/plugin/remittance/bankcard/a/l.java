package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpt;
import com.tencent.mm.sdk.platformtools.ae;

public final class l
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  public cpt yhS;
  
  public l(String paramString)
  {
    AppMethodBeat.i(67382);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    b.a locala = new b.a();
    locala.hQF = new cps();
    locala.hQG = new cpt();
    locala.funcId = 1579;
    locala.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((cps)this.rr.hQD.hQJ).GeJ = paramString;
    ae.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", new Object[] { paramString });
    AppMethodBeat.o(67382);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67384);
    ae.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhS = ((cpt)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67384);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67383);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67383);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cpt)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.l
 * JD-Core Version:    0.7.0.1
 */