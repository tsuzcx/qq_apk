package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.duv;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class v
  extends w
{
  public int Dqv;
  private f callback;
  public int errCode;
  public String pFG;
  public String pFI;
  private final b rr;
  
  public v(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72800);
    this.pFG = null;
    this.Dqv = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new duv();
    ((b.a)localObject).hNN = new duw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((b.a)localObject).funcId = 414;
    ((b.a)localObject).hNO = 215;
    ((b.a)localObject).respCmdId = 1000000215;
    this.rr = ((b.a)localObject).aDC();
    localObject = (duv)this.rr.hNK.hNQ;
    this.pFG = paramString1;
    ((duv)localObject).ProductID = paramString1;
    ((duv)localObject).HHn = paramInt1;
    ((duv)localObject).Hfs = paramInt3;
    ((duv)localObject).wDv = paramInt2;
    if (!bt.isNullOrNil(paramString6))
    {
      ((duv)localObject).Hfq = paramString6;
      ((duv)localObject).Hfr = paramString5;
    }
    ((duv)localObject).Hft = paramString2;
    ((duv)localObject).HHp = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((duv)localObject).HHm = new SKBuiltinBuffer_t().setBuffer(paramString1);; ((duv)localObject).HHm = new SKBuiltinBuffer_t())
    {
      ((duv)localObject).HHo = ((int)bt.aQJ());
      ad.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.pFG + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
      AppMethodBeat.o(72800);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(72802);
    this.callback = paramf;
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
    paramq = (duw)((b)paramq).hNL.hNQ;
    if (paramq.BaseResponse != null)
    {
      this.Dqv = paramq.HHr;
      ad.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + paramq.SeriesID);
      ad.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + paramq.HHq);
      this.pFI = paramq.SeriesID;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */