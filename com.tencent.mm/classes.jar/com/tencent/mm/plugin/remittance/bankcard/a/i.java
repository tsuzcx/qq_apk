package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.bqf;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends b
{
  private f callback;
  public int limit;
  public bqf qfR;
  private com.tencent.mm.ai.b rr;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44464);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bqe();
    ((b.a)localObject).fsY = new bqf();
    ((b.a)localObject).funcId = 1511;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bqe)this.rr.fsV.fta;
    ((bqe)localObject).limit = paramInt1;
    ((bqe)localObject).offset = paramInt2;
    this.limit = paramInt1;
    ab.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(44464);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44466);
    ab.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfR = ((bqf)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qfR.cnK), this.qfR.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44466);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44465);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44465);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (bqf)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1511;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.i
 * JD-Core Version:    0.7.0.1
 */