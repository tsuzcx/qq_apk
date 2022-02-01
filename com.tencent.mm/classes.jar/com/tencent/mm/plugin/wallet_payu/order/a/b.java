package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.protocal.protobuf.ecv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;

public final class b
  extends w
{
  private h callback;
  private c rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(72059);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ecu();
    ((c.a)localObject).otF = new ecv();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/payudeluserroll";
    ((c.a)localObject).funcId = 1544;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ecu)c.b.b(this.rr.otB);
    if (!Util.isNullOrNil(paramString)) {
      ((ecu)localObject).MEX = paramString;
    }
    AppMethodBeat.o(72059);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(72061);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72061);
    return i;
  }
  
  public final int getType()
  {
    return 1544;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72060);
    Log.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.b
 * JD-Core Version:    0.7.0.1
 */