package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends b
{
  public bqj IfI;
  private final String TAG;
  private i callback;
  private d rr;
  
  public h()
  {
    AppMethodBeat.i(67370);
    this.TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    d.a locala = new d.a();
    locala.lBU = new bqi();
    locala.lBV = new bqj();
    locala.funcId = 1399;
    locala.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    d.b.b(this.rr.lBR);
    AppMethodBeat.o(67370);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67372);
    Log.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.IfI = ((bqj)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.IfI.fwx), this.IfI.tVo });
    if ((!this.tWx) && (this.IfI.fwx != 0)) {
      this.tWy = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67372);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67371);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67371);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(188156);
    params = (bqj)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(188156);
  }
  
  public final int getType()
  {
    return 1399;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.h
 * JD-Core Version:    0.7.0.1
 */