package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  extends b
{
  private g callback;
  public int limit;
  private com.tencent.mm.ak.b rr;
  public ckd wEp;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67373);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ckc();
    ((b.a)localObject).hvu = new ckd();
    ((b.a)localObject).funcId = 1511;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ckc)this.rr.hvr.hvw;
    ((ckc)localObject).limit = paramInt1;
    ((ckc)localObject).offset = paramInt2;
    this.limit = paramInt1;
    ac.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(67373);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67375);
    ac.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wEp = ((ckd)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wEp.dae), this.wEp.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67375);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67374);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67374);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (ckd)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1511;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.i
 * JD-Core Version:    0.7.0.1
 */