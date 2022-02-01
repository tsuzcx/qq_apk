package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends b
{
  private final String TAG;
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b rr;
  public String yhI;
  public aeq yhM;
  
  public f(String paramString)
  {
    AppMethodBeat.i(67364);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    b.a locala = new b.a();
    locala.hQF = new aep();
    locala.hQG = new aeq();
    locala.funcId = 1395;
    locala.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((aep)this.rr.hQD.hQJ).yis = paramString;
    this.yhI = paramString;
    AppMethodBeat.o(67364);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67366);
    ae.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhM = ((aeq)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhM.dmy), this.yhM.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67366);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(67365);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67365);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (aeq)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1395;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.f
 * JD-Core Version:    0.7.0.1
 */