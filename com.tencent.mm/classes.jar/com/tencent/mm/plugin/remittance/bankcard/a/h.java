package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends b
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.ak.b rr;
  public atc wEo;
  
  public h()
  {
    AppMethodBeat.i(67370);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    b.a locala = new b.a();
    locala.hvt = new atb();
    locala.hvu = new atc();
    locala.funcId = 1399;
    locala.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(67370);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67372);
    ac.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEo = ((atc)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEo.dae), this.wEo.oxf });
    if ((!this.oyl) && (this.wEo.dae != 0)) {
      this.oym = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67372);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67371);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67371);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (atc)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1399;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.h
 * JD-Core Version:    0.7.0.1
 */