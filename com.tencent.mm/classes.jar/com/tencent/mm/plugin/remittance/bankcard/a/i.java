package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends b
{
  private f callback;
  public int limit;
  private com.tencent.mm.al.b rr;
  public cpd xRW;
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67373);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cpc();
    ((b.a)localObject).hNN = new cpd();
    ((b.a)localObject).funcId = 1511;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cpc)this.rr.hNK.hNQ;
    ((cpc)localObject).limit = paramInt1;
    ((cpc)localObject).offset = paramInt2;
    this.limit = paramInt1;
    ad.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(67373);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67375);
    ad.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRW = ((cpd)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xRW.dlw), this.xRW.paA });
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
    paramq = (cpd)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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