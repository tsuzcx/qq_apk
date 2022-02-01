package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends b
{
  public dif CiU;
  private final String TAG;
  private i callback;
  private d rr;
  
  public m()
  {
    AppMethodBeat.i(67385);
    this.TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    d.a locala = new d.a();
    locala.iLN = new die();
    locala.iLO = new dif();
    locala.funcId = 1378;
    locala.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(67385);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(67387);
    Log.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.CiU = ((dif)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.CiU.dDN), this.CiU.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(67387);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67386);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(67386);
    return i;
  }
  
  public final void e(s params)
  {
    params = (dif)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 1378;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.m
 * JD-Core Version:    0.7.0.1
 */