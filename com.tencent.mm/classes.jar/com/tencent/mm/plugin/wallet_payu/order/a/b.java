package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class b
  extends w
{
  private i callback;
  private d rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(72059);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new daw();
    ((d.a)localObject).iLO = new dax();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payudeluserroll";
    ((d.a)localObject).funcId = 1544;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (daw)this.rr.iLK.iLR;
    if (!Util.isNullOrNil(paramString)) {
      ((daw)localObject).AOT = paramString;
    }
    AppMethodBeat.o(72059);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(72061);
    this.callback = parami;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.b
 * JD-Core Version:    0.7.0.1
 */