package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ecs;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class a
  extends w
{
  private h callback;
  public c rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(72056);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ecs();
    ((c.a)localObject).otF = new ect();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
    ((c.a)localObject).funcId = 1519;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ecs)c.b.b(this.rr.otB);
    ((ecs)localObject).IKp = 10;
    ((ecs)localObject).YYs = paramInt;
    Log.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:" + paramInt);
    AppMethodBeat.o(72056);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(72058);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72058);
    return i;
  }
  
  public final int getType()
  {
    return 1519;
  }
  
  public final int imx()
  {
    AppMethodBeat.i(270829);
    int i = ((ect)c.c.b(this.rr.otC)).abij;
    AppMethodBeat.o(270829);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72057);
    Log.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((ect)c.c.b(((c)params).otC)).abij);
    }
    AppMethodBeat.o(72057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.a
 * JD-Core Version:    0.7.0.1
 */