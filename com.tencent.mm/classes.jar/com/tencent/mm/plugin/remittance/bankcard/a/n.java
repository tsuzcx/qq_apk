package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
  extends b
{
  private final String TAG;
  private f callback;
  private buj qfW;
  private com.tencent.mm.ai.b rr;
  
  public n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(44479);
    this.TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    ab.i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    bui localbui = new bui();
    localbui.xHB = new com.tencent.mm.bv.b(String.valueOf(paramString1).getBytes());
    localbui.xxV = paramString2;
    localbui.wBk = paramInt;
    locala.fsX = localbui;
    locala.fsY = new buj();
    locala.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
    locala.funcId = 2739;
    this.rr = locala.ado();
    AppMethodBeat.o(44479);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(44481);
    ab.i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qfW = ((buj)((com.tencent.mm.ai.b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(44481);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(44480);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(44480);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (buj)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 2739;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.n
 * JD-Core Version:    0.7.0.1
 */