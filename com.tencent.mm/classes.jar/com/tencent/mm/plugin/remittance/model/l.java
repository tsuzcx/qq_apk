package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;

public final class l
  extends q
  implements m, j, com.tencent.mm.wallet_core.d.d
{
  public ro CoG;
  private rn CoH;
  private i callback;
  public String dDL;
  private com.tencent.mm.ak.d hJu;
  public boolean hasRetried;
  public boolean rop;
  
  public l(eig parameig, du paramdu, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67860);
    this.rop = false;
    this.hasRetried = false;
    d.a locala = new d.a();
    locala.iLN = new rn();
    locala.iLO = new ro();
    locala.funcId = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.CoH = ((rn)this.hJu.iLK.iLR);
    this.CoH.KYe = paramdu;
    this.CoH.KYA = parameig;
    this.CoH.KYB = paramString1;
    this.CoH.KYY = paramInt;
    this.CoH.token = paramString2;
    this.dDL = paramString3;
    Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, a.a(paramdu), paramString1 });
    AppMethodBeat.o(67860);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67861);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67862);
    Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.CoG = ((ro)((com.tencent.mm.ak.d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.CoG.pTZ), this.CoG.pUa });
    if (this.callback != null) {
      if (this.CoG.KYZ != 1) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      this.rop = bool;
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