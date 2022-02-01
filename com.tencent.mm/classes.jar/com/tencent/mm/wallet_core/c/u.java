package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
  extends w
{
  public String DpO;
  public String DpP;
  private f callback;
  public String pFG;
  public final b rr;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(72797);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cmb();
    ((b.a)localObject).hNN = new cmc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preparepurchase";
    ((b.a)localObject).funcId = 422;
    ((b.a)localObject).hNO = 214;
    ((b.a)localObject).respCmdId = 1000000214;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cmb)this.rr.hNK.hNQ;
    this.pFG = paramString1;
    ((cmb)localObject).ProductID = paramString1;
    this.DpP = paramString2;
    ((cmb)localObject).Hfq = paramString2;
    this.DpO = paramString3;
    ((cmb)localObject).Hfr = paramString3;
    ((cmb)localObject).wDv = paramInt2;
    ((cmb)localObject).Hfs = paramInt1;
    ((cmb)localObject).ukw = paramString4;
    ad.d("MicroMsg.NetScenePreparePurchase", "productId:" + paramString1 + ",price:" + paramString2 + ",currencyType:" + paramString3 + ",payType:" + paramInt2);
    AppMethodBeat.o(72797);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(72799);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.u
 * JD-Core Version:    0.7.0.1
 */