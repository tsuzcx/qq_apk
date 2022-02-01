package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends b
{
  private final String TAG;
  private com.tencent.mm.al.f callback;
  private com.tencent.mm.al.b rr;
  public String xRP;
  public aeh xRT;
  
  public f(String paramString)
  {
    AppMethodBeat.i(67364);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    b.a locala = new b.a();
    locala.hNM = new aeg();
    locala.hNN = new aeh();
    locala.funcId = 1395;
    locala.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((aeg)this.rr.hNK.hNQ).xSz = paramString;
    this.xRP = paramString;
    AppMethodBeat.o(67364);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67366);
    ad.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xRT = ((aeh)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.xRT.dlw), this.xRT.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67366);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(67365);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67365);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (aeh)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 1395;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.f
 * JD-Core Version:    0.7.0.1
 */