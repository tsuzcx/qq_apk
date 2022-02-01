package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends b
{
  private dnz CiV;
  private final String TAG;
  private i callback;
  private d rr;
  
  public n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(67388);
    this.TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    Log.i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    d.a locala = new d.a();
    dny localdny = new dny();
    localdny.MQS = new com.tencent.mm.bw.b(String.valueOf(paramString1).getBytes());
    localdny.MBV = paramString2;
    localdny.KYp = paramInt;
    locala.iLN = localdny;
    locala.iLO = new dnz();
    locala.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
    locala.funcId = 2739;
    this.rr = locala.aXF();
    AppMethodBeat.o(67388);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67390);
    Log.i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiV = ((dnz)((d)params).iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67390);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67389);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67389);
    return i;
  }
  
  public final void e(s params)
  {
    params = (dnz)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
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