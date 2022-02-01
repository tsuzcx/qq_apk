package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends b
{
  public agq CiM;
  private final String TAG;
  private i callback;
  public String qvC;
  private d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(67361);
    this.TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    d.a locala = new d.a();
    locala.iLN = new agp();
    locala.iLO = new agq();
    locala.funcId = 1737;
    locala.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((agp)this.rr.iLK.iLR).KZa = paramString;
    this.qvC = paramString;
    AppMethodBeat.o(67361);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67363);
    Log.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiM = ((agq)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiM.dDN), this.CiM.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67363);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67362);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67362);
    return i;
  }
  
  public final void e(s params)
  {
    params = (agq)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 1737;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.e
 * JD-Core Version:    0.7.0.1
 */