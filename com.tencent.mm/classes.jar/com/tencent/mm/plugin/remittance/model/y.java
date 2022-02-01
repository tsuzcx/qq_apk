package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class y
  extends w
{
  private um Ojq;
  public un Ojr;
  private h callback;
  private final c rr;
  
  public y(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(288842);
    Log.i("MicroMsg.NetScenePersonalPayPlaceOrder", "appID = %s ，outPrepayId = %s ,,totalAmount = %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    c.a locala = new c.a();
    locala.otE = new um();
    locala.otF = new un();
    locala.funcId = 4304;
    locala.uri = "/cgi-bin/mmpay-bin/personalpayplaceorder";
    this.rr = locala.bEF();
    this.Ojq = ((um)c.b.b(this.rr.otB));
    this.Ojq.appid = paramString1;
    this.Ojq.Olk = paramString2;
    this.Ojq.Oll = paramLong;
    AppMethodBeat.o(288842);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(288849);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(288849);
    return i;
  }
  
  public final int getType()
  {
    return 4304;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288853);
    Log.i("MicroMsg.NetScenePersonalPayPlaceOrder", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.Ojr = ((un)c.c.b(((c)params).otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.y
 * JD-Core Version:    0.7.0.1
 */