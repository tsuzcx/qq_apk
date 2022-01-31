package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends b
{
  private final String TAG;
  private f callback;
  public bqk qfV;
  private com.tencent.mm.ai.b rr;
  
  public m()
  {
    AppMethodBeat.i(44476);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    b.a locala = new b.a();
    locala.fsX = new bqj();
    locala.fsY = new bqk();
    locala.funcId = 1378;
    locala.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(44476);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44478);
    ab.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfV = ((bqk)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfV.cnK), this.qfV.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44478);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44477);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44477);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (bqk)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1378;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.m
 * JD-Core Version:    0.7.0.1
 */