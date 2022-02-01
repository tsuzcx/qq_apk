package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends b
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rr;
  private cvg yhU;
  
  public n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(67388);
    this.TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    ae.i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    cvf localcvf = new cvf();
    localcvf.HFI = new com.tencent.mm.bw.b(String.valueOf(paramString1).getBytes());
    localcvf.HsZ = paramString2;
    localcvf.GdY = paramInt;
    locala.hQF = localcvf;
    locala.hQG = new cvg();
    locala.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
    locala.funcId = 2739;
    this.rr = locala.aDS();
    AppMethodBeat.o(67388);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(67390);
    ae.i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.yhU = ((cvg)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
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
    paramq = (cvg)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
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