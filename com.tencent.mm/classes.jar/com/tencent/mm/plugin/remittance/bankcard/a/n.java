package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b rr;
  private cum xSb;
  
  public n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(67388);
    this.TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    ad.i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    cul localcul = new cul();
    localcul.Hmi = new com.tencent.mm.bx.b(String.valueOf(paramString1).getBytes());
    localcul.GZy = paramString2;
    localcul.FLz = paramInt;
    locala.hNM = localcul;
    locala.hNN = new cum();
    locala.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
    locala.funcId = 2739;
    this.rr = locala.aDC();
    AppMethodBeat.o(67388);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67390);
    ad.i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.xSb = ((cum)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67390);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67389);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67389);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cum)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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