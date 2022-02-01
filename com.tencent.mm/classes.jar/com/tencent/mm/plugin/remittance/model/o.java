package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.w;

public final class o
  extends w
  implements d, j
{
  public ss OiZ;
  private sr Oja;
  private h callback;
  public String hAT;
  public boolean hasRetried;
  private c nao;
  public boolean ygJ;
  
  public o(fnr paramfnr, eh parameh, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67860);
    this.ygJ = false;
    this.hasRetried = false;
    c.a locala = new c.a();
    locala.otE = new sr();
    locala.otF = new ss();
    locala.funcId = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.Oja = ((sr)c.b.b(this.nao.otB));
    this.Oja.YXl = parameh;
    this.Oja.YXI = paramfnr;
    this.Oja.YXJ = paramString1;
    this.Oja.YYg = paramInt;
    this.Oja.token = paramString2;
    this.hAT = paramString3;
    Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, b.a(parameh), paramString1 });
    AppMethodBeat.o(67860);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67861);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288840);
    Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.OiZ = ((ss)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.OiZ.wuz), this.OiZ.wuA });
    if (this.callback != null) {
      if (this.OiZ.YYh != 1) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      this.ygJ = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(288840);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.o
 * JD-Core Version:    0.7.0.1
 */