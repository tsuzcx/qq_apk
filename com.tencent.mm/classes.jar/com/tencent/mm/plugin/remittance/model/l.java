package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.d.d;

public final class l
  extends n
  implements k, j, d
{
  private f callback;
  public String dmw;
  private b gRX;
  public boolean hasRetried;
  public boolean pXr;
  public qn ynQ;
  private qm ynR;
  
  public l(dok paramdok, dk paramdk, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67860);
    this.pXr = false;
    this.hasRetried = false;
    b.a locala = new b.a();
    locala.hQF = new qm();
    locala.hQG = new qn();
    locala.funcId = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.ynR = ((qm)this.gRX.hQD.hQJ);
    this.ynR.GdN = paramdk;
    this.ynR.Gej = paramdok;
    this.ynR.Gek = paramString1;
    this.ynR.GeH = paramInt;
    this.ynR.token = paramString2;
    this.dmw = paramString3;
    ae.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, a.a(paramdk), paramString1 });
    AppMethodBeat.o(67860);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67861);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(67861);
    return i;
  }
  
  public final boolean getHasRetried()
  {
    return this.hasRetried;
  }
  
  public final int getType()
  {
    return 2682;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67862);
    ae.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.ynQ = ((qn)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.ynQ.oGt), this.ynQ.oGu });
    if (this.callback != null) {
      if (this.ynQ.GeI != 1) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      this.pXr = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(67862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.l
 * JD-Core Version:    0.7.0.1
 */