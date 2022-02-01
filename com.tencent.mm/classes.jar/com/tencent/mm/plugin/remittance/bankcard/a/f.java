package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends b
{
  public String CiJ;
  public agu CiN;
  private final String TAG;
  private i callback;
  private d rr;
  
  public f(String paramString)
  {
    AppMethodBeat.i(67364);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    d.a locala = new d.a();
    locala.iLN = new agt();
    locala.iLO = new agu();
    locala.funcId = 1395;
    locala.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((agt)this.rr.iLK.iLR).Cjt = paramString;
    this.CiJ = paramString;
    AppMethodBeat.o(67364);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67366);
    Log.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiN = ((agu)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiN.dDN), this.CiN.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67366);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67365);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67365);
    return i;
  }
  
  public final void e(s params)
  {
    params = (agu)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
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