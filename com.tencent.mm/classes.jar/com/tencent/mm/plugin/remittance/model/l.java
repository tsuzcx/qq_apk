package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.d.d;

public final class l
  extends n
  implements k, j, d
{
  private g callback;
  public String dac;
  private b gvE;
  public boolean hasRetried;
  public boolean pnm;
  public pg wKr;
  private pf wKs;
  
  public l(dhy paramdhy, dj paramdj, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67860);
    this.pnm = false;
    this.hasRetried = false;
    b.a locala = new b.a();
    locala.hvt = new pf();
    locala.hvu = new pg();
    locala.funcId = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.wKs = ((pf)this.gvE.hvr.hvw);
    this.wKs.EeP = paramdj;
    this.wKs.Efl = paramdhy;
    this.wKs.Efm = paramString1;
    this.wKs.EfJ = paramInt;
    this.wKs.token = paramString2;
    this.dac = paramString3;
    ac.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, a.a(paramdj), paramString1 });
    AppMethodBeat.o(67860);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67861);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wKr = ((pg)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.wKr.nWx), this.wKr.nWy });
    if (this.callback != null) {
      if (this.wKr.EfK != 1) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      this.pnm = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(67862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.l
 * JD-Core Version:    0.7.0.1
 */