package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
  extends b
{
  private final String TAG;
  private f callback;
  public bqb qfU;
  private com.tencent.mm.ai.b rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(44473);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    b.a locala = new b.a();
    locala.fsX = new bqa();
    locala.fsY = new bqb();
    locala.funcId = 1579;
    locala.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((bqa)this.rr.fsV.fta).wBQ = paramString;
    ab.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", new Object[] { paramString });
    AppMethodBeat.o(44473);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44475);
    ab.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfU = ((bqb)((com.tencent.mm.ai.b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44475);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44474);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44474);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (bqb)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.l
 * JD-Core Version:    0.7.0.1
 */