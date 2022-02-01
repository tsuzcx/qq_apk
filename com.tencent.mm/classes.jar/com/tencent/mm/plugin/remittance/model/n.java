package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;

public final class n
  extends q
  implements m, j, com.tencent.mm.wallet_core.d.d
{
  public rh IlI;
  private rg IlJ;
  private i callback;
  public String fwv;
  public boolean hasRetried;
  private com.tencent.mm.an.d kwO;
  public boolean uTW;
  
  public n(esi paramesi, ds paramds, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67860);
    this.uTW = false;
    this.hasRetried = false;
    d.a locala = new d.a();
    locala.lBU = new rg();
    locala.lBV = new rh();
    locala.funcId = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.IlJ = ((rg)d.b.b(this.kwO.lBR));
    this.IlJ.RZn = paramds;
    this.IlJ.RZJ = paramesi;
    this.IlJ.RZK = paramString1;
    this.IlJ.Sah = paramInt;
    this.IlJ.token = paramString2;
    this.fwv = paramString3;
    Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, a.a(paramds), paramString1 });
    AppMethodBeat.o(67860);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67861);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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
    this.IlI = ((rh)d.c.b(((com.tencent.mm.an.d)params).lBS));
    Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.IlI.tqa), this.IlI.tqb });
    if (this.callback != null) {
      if (this.IlI.Sai != 1) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      this.uTW = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(67862);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.n
 * JD-Core Version:    0.7.0.1
 */