package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class v
  extends w
{
  public int AxH;
  private g callback;
  public int errCode;
  public String oyw;
  public String oyy;
  private final b rr;
  
  public v(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72800);
    this.oyw = null;
    this.AxH = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new djp();
    ((b.a)localObject).gUV = new djq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((b.a)localObject).funcId = 414;
    ((b.a)localObject).reqCmdId = 215;
    ((b.a)localObject).respCmdId = 1000000215;
    this.rr = ((b.a)localObject).atI();
    localObject = (djp)this.rr.gUS.gUX;
    this.oyw = paramString1;
    ((djp)localObject).ProductID = paramString1;
    ((djp)localObject).Ezt = paramInt1;
    ((djp)localObject).DYt = paramInt3;
    ((djp)localObject).upf = paramInt2;
    if (!bt.isNullOrNil(paramString6))
    {
      ((djp)localObject).DYr = paramString6;
      ((djp)localObject).DYs = paramString5;
    }
    ((djp)localObject).DYu = paramString2;
    ((djp)localObject).Ezv = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((djp)localObject).Ezs = new SKBuiltinBuffer_t().setBuffer(paramString1);; ((djp)localObject).Ezs = new SKBuiltinBuffer_t())
    {
      ((djp)localObject).Ezu = ((int)bt.aGK());
      ad.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.oyw + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
      AppMethodBeat.o(72800);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(72802);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72802);
    return i;
  }
  
  public final int getType()
  {
    return 414;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72801);
    ad.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    this.errCode = 0;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.errCode = -1;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72801);
      return;
    }
    paramq = (djq)((b)paramq).gUT.gUX;
    if (paramq.BaseResponse != null)
    {
      this.AxH = paramq.Ezx;
      ad.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + paramq.SeriesID);
      ad.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + paramq.Ezw);
      this.oyy = paramq.SeriesID;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */