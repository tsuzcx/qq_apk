package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  private i callback;
  public d rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(72056);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dki();
    ((d.a)localObject).lBV = new dkj();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
    ((d.a)localObject).funcId = 1519;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dki)d.b.b(this.rr.lBR);
    ((dki)localObject).CQf = 10;
    ((dki)localObject).Sat = paramInt;
    Log.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:" + paramInt);
    AppMethodBeat.o(72056);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(72058);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72058);
    return i;
  }
  
  public final int gNi()
  {
    AppMethodBeat.i(192890);
    int i = ((dkj)d.c.b(this.rr.lBS)).TRK;
    AppMethodBeat.o(192890);
    return i;
  }
  
  public final int getType()
  {
    return 1519;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72057);
    Log.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((dkj)d.c.b(((d)params).lBS)).TRK);
    }
    AppMethodBeat.o(72057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.a
 * JD-Core Version:    0.7.0.1
 */