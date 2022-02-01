package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.dnn;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.d.d;

public final class l
  extends n
  implements k, j, d
{
  private f callback;
  public String dlu;
  private b gPp;
  public boolean hasRetried;
  public boolean pQM;
  public ql xXY;
  private qk xXZ;
  
  public l(dnn paramdnn, dk paramdk, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67860);
    this.pQM = false;
    this.hasRetried = false;
    b.a locala = new b.a();
    locala.hNM = new qk();
    locala.hNN = new ql();
    locala.funcId = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.xXZ = ((qk)this.gPp.hNK.hNQ);
    this.xXZ.FLo = paramdk;
    this.xXZ.FLK = paramdnn;
    this.xXZ.FLL = paramString1;
    this.xXZ.FMi = paramInt;
    this.xXZ.token = paramString2;
    this.dlu = paramString3;
    ad.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, a.a(paramdk), paramString1 });
    AppMethodBeat.o(67860);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67861);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    ad.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.xXY = ((ql)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xXY.ozR), this.xXY.ozS });
    if (this.callback != null) {
      if (this.xXY.FMj != 1) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      this.pQM = bool;
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