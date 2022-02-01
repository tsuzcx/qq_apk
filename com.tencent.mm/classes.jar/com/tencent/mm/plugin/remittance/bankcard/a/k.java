package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class k
  extends b
{
  private f callback;
  private com.tencent.mm.al.b rr;
  public cgj xRY;
  
  public k()
  {
    AppMethodBeat.i(67379);
    b.a locala = new b.a();
    locala.hNM = new cgi();
    locala.hNN = new cgj();
    locala.funcId = 1280;
    locala.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(67379);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67381);
    ad.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRY = ((cgj)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xRY.dlw), this.xRY.paA });
    if ((!this.pbG) && (!this.pbH))
    {
      ad.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[] { Integer.valueOf(this.xRY.GZv), Integer.valueOf(this.xRY.GZw) });
      if (this.xRY.GZv >= 0) {
        g.ajC().ajl().set(al.a.IBO, Integer.valueOf(this.xRY.GZv));
      }
      if (this.xRY.GZw > 0) {
        g.ajC().ajl().set(al.a.IBP, Integer.valueOf(this.xRY.GZw));
      }
      if (!bt.isNullOrNil(this.xRY.GZx)) {
        g.ajC().ajl().set(al.a.IBQ, this.xRY.GZx);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67381);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(67380);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67380);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cgj)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 1280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.k
 * JD-Core Version:    0.7.0.1
 */