package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends b
{
  private final String TAG;
  private f callback;
  public String kMM;
  public xw qfN;
  private com.tencent.mm.ai.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(44452);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    b.a locala = new b.a();
    locala.fsX = new xv();
    locala.fsY = new xw();
    locala.funcId = 1737;
    locala.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((xv)this.rr.fsV.fta).wBQ = paramString;
    this.kMM = paramString;
    AppMethodBeat.o(44452);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44454);
    ab.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfN = ((xw)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfN.cnK), this.qfN.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44454);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(44453);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44453);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (xw)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1737;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.e
 * JD-Core Version:    0.7.0.1
 */