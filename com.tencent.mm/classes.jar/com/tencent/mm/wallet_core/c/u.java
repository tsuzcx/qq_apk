package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
  extends w
{
  public String Axc;
  public String Axd;
  private g callback;
  public String oyw;
  public final b rr;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(72797);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cca();
    ((b.a)localObject).gUV = new ccb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preparepurchase";
    ((b.a)localObject).funcId = 422;
    ((b.a)localObject).reqCmdId = 214;
    ((b.a)localObject).respCmdId = 1000000214;
    this.rr = ((b.a)localObject).atI();
    localObject = (cca)this.rr.gUS.gUX;
    this.oyw = paramString1;
    ((cca)localObject).ProductID = paramString1;
    this.Axd = paramString2;
    ((cca)localObject).DYr = paramString2;
    this.Axc = paramString3;
    ((cca)localObject).DYs = paramString3;
    ((cca)localObject).upf = paramInt2;
    ((cca)localObject).DYt = paramInt1;
    ((cca)localObject).sed = paramString4;
    ad.d("MicroMsg.NetScenePreparePurchase", "productId:" + paramString1 + ",price:" + paramString2 + ",currencyType:" + paramString3 + ",payType:" + paramInt2);
    AppMethodBeat.o(72797);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(72799);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72799);
    return i;
  }
  
  public final int getType()
  {
    return 422;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72798);
    ad.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72798);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.u
 * JD-Core Version:    0.7.0.1
 */