package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b rr;
  public cpm xSa;
  
  public m()
  {
    AppMethodBeat.i(67385);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    b.a locala = new b.a();
    locala.hNM = new cpl();
    locala.hNN = new cpm();
    locala.funcId = 1378;
    locala.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(67385);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67387);
    ad.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xSa = ((cpm)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xSa.dlw), this.xSa.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67387);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67386);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67386);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cpm)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 1378;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.m
 * JD-Core Version:    0.7.0.1
 */