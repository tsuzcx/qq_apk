package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  public axq yhO;
  
  public h()
  {
    AppMethodBeat.i(67370);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    b.a locala = new b.a();
    locala.hQF = new axp();
    locala.hQG = new axq();
    locala.funcId = 1399;
    locala.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(67370);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67372);
    ae.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhO = ((axq)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhO.dmy), this.yhO.phe });
    if ((!this.pil) && (this.yhO.dmy != 0)) {
      this.pim = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67372);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67371);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67371);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (axq)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1399;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.h
 * JD-Core Version:    0.7.0.1
 */