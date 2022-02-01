package com.tencent.mm.plugin.remittance.bankcard.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.equ;
import com.tencent.mm.protocal.protobuf.eqv;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends b
{
  private eqv Ocn;
  private final String TAG;
  private h callback;
  private c rr;
  
  public n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(67388);
    this.TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    Log.i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    c.a locala = new c.a();
    equ localequ = new equ();
    localequ.abut = new com.tencent.mm.bx.b(String.valueOf(paramString1).getBytes());
    localequ.abdU = paramString2;
    localequ.YXw = paramInt;
    locala.otE = localequ;
    locala.otF = new eqv();
    locala.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
    locala.funcId = 2739;
    this.rr = locala.bEF();
    AppMethodBeat.o(67388);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67390);
    Log.i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.Ocn = ((eqv)c.c.b(((c)params).otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67390);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67389);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67389);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(288710);
    params = (eqv)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(288710);
  }
  
  public final int getType()
  {
    return 2739;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.b.n
 * JD-Core Version:    0.7.0.1
 */