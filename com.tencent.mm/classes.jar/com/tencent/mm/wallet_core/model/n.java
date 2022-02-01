package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;

public final class n
  extends w
{
  private h callback;
  private c rr;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72778);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new vg();
    ((c.a)localObject).otF = new vh();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/cancelqrpay";
    ((c.a)localObject).funcId = 410;
    ((c.a)localObject).otG = 198;
    ((c.a)localObject).respCmdId = 1000000198;
    ((c.a)localObject).routeInfo = i.bEV(paramString2);
    this.rr = ((c.a)localObject).bEF();
    localObject = (vg)c.b.b(this.rr.otB);
    ((vg)localObject).Zbh = paramString1;
    ((vg)localObject).YIV = paramString2;
    ((vg)localObject).Zbi = k.iis();
    AppMethodBeat.o(72778);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(72780);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72780);
    return i;
  }
  
  public final int getType()
  {
    return 410;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72779);
    Log.d("MicroMsg.NetSceneCancelQRPay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.n
 * JD-Core Version:    0.7.0.1
 */