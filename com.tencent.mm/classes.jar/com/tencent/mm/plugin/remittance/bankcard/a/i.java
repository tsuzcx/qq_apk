package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends b
{
  private f callback;
  public int limit;
  private com.tencent.mm.ak.b rr;
  public cpx yhP;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67373);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cpw();
    ((b.a)localObject).hQG = new cpx();
    ((b.a)localObject).funcId = 1511;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cpw)this.rr.hQD.hQJ;
    ((cpw)localObject).limit = paramInt1;
    ((cpw)localObject).offset = paramInt2;
    this.limit = paramInt1;
    ae.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(67373);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67375);
    ae.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhP = ((cpx)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.yhP.dmy), this.yhP.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67375);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67374);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67374);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cpx)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1511;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.i
 * JD-Core Version:    0.7.0.1
 */