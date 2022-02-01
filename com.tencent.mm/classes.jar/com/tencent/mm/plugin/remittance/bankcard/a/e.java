package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends b
{
  private final String TAG;
  private g callback;
  public String ows;
  private com.tencent.mm.ak.b rr;
  public acd wEl;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67361);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    b.a locala = new b.a();
    locala.hvt = new acc();
    locala.hvu = new acd();
    locala.funcId = 1737;
    locala.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((acc)this.rr.hvr.hvw).EfL = paramString;
    this.ows = paramString;
    AppMethodBeat.o(67361);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67363);
    ac.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEl = ((acd)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEl.dae), this.wEl.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67363);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(67362);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67362);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (acd)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1737;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.e
 * JD-Core Version:    0.7.0.1
 */