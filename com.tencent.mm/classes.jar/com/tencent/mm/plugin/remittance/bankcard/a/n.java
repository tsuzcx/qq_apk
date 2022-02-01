package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends b
{
  private final String TAG;
  private g callback;
  private com.tencent.mm.al.b rr;
  private cka vup;
  
  public n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(67388);
    this.TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    ad.i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    cjz localcjz = new cjz();
    localcjz.EeT = new com.tencent.mm.bx.b(String.valueOf(paramString1).getBytes());
    localcjz.DTs = paramString2;
    localcjz.CMy = paramInt;
    locala.gUU = localcjz;
    locala.gUV = new cka();
    locala.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
    locala.funcId = 2739;
    this.rr = locala.atI();
    AppMethodBeat.o(67388);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67390);
    ad.i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.vup = ((cka)((com.tencent.mm.al.b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67390);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67389);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67389);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cka)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.IdO = paramq.dcG;
    this.IdP = paramq.nTK;
  }
  
  public final int getType()
  {
    return 2739;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.n
 * JD-Core Version:    0.7.0.1
 */