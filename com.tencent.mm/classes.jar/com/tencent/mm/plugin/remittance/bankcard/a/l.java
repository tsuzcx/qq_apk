package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b rr;
  public coz xRZ;
  
  public l(String paramString)
  {
    AppMethodBeat.i(67382);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    b.a locala = new b.a();
    locala.hNM = new coy();
    locala.hNN = new coz();
    locala.funcId = 1579;
    locala.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((coy)this.rr.hNK.hNQ).FMk = paramString;
    ad.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", new Object[] { paramString });
    AppMethodBeat.o(67382);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67384);
    ad.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRZ = ((coz)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67384);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67383);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67383);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (coz)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 1579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.l
 * JD-Core Version:    0.7.0.1
 */