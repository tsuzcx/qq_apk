package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends w
{
  private com.tencent.mm.ak.f callback;
  private b rr;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72778);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new sk();
    ((b.a)localObject).hQG = new sl();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/cancelqrpay";
    ((b.a)localObject).funcId = 410;
    ((b.a)localObject).hQH = 198;
    ((b.a)localObject).respCmdId = 1000000198;
    ((b.a)localObject).routeInfo = com.tencent.mm.wallet_core.ui.f.bas(paramString2);
    this.rr = ((b.a)localObject).aDS();
    localObject = (sk)this.rr.hQD.hQJ;
    ((sk)localObject).Ghy = paramString1;
    ((sk)localObject).FRk = paramString2;
    ((sk)localObject).Ghz = k.eIV();
    AppMethodBeat.o(72778);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(72780);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72780);
    return i;
  }
  
  public final int getType()
  {
    return 410;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72779);
    ae.d("MicroMsg.NetSceneCancelQRPay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */