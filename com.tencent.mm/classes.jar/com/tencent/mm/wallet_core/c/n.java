package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends w
{
  private i callback;
  private d rr;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72778);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new tp();
    ((d.a)localObject).lBV = new tq();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/cancelqrpay";
    ((d.a)localObject).funcId = 410;
    ((d.a)localObject).lBW = 198;
    ((d.a)localObject).respCmdId = 1000000198;
    ((d.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.g.bCx(paramString2);
    this.rr = ((d.a)localObject).bgN();
    localObject = (tp)d.b.b(this.rr.lBR);
    ((tp)localObject).Sdo = paramString1;
    ((tp)localObject).RLK = paramString2;
    ((tp)localObject).Sdp = k.gJe();
    AppMethodBeat.o(72778);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(72780);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */