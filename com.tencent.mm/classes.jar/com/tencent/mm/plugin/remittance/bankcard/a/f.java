package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends b
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.ak.b rr;
  public String wEi;
  public ach wEm;
  
  public f(String paramString)
  {
    AppMethodBeat.i(67364);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    b.a locala = new b.a();
    locala.hvt = new acg();
    locala.hvu = new ach();
    locala.funcId = 1395;
    locala.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((acg)this.rr.hvr.hvw).wES = paramString;
    this.wEi = paramString;
    AppMethodBeat.o(67364);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67366);
    ac.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEm = ((ach)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEm.dae), this.wEm.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67366);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67365);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67365);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (ach)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1395;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.f
 * JD-Core Version:    0.7.0.1
 */