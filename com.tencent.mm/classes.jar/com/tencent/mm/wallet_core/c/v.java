package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dvs;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class v
  extends w
{
  public int DIb;
  private f callback;
  public int errCode;
  public String pMk;
  public String pMm;
  private final b rr;
  
  public v(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72800);
    this.pMk = null;
    this.DIb = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dvs();
    ((b.a)localObject).hQG = new dvt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((b.a)localObject).funcId = 414;
    ((b.a)localObject).hQH = 215;
    ((b.a)localObject).respCmdId = 1000000215;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dvs)this.rr.hQD.hQJ;
    this.pMk = paramString1;
    ((dvs)localObject).ProductID = paramString1;
    ((dvs)localObject).Iba = paramInt1;
    ((dvs)localObject).HyS = paramInt3;
    ((dvs)localObject).wTg = paramInt2;
    if (!bu.isNullOrNil(paramString6))
    {
      ((dvs)localObject).HyQ = paramString6;
      ((dvs)localObject).HyR = paramString5;
    }
    ((dvs)localObject).HyT = paramString2;
    ((dvs)localObject).Ibc = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((dvs)localObject).IaZ = new SKBuiltinBuffer_t().setBuffer(paramString1);; ((dvs)localObject).IaZ = new SKBuiltinBuffer_t())
    {
      ((dvs)localObject).Ibb = ((int)bu.aRi());
      ae.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.pMk + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
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
    ae.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    this.errCode = 0;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.errCode = -1;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72801);
      return;
    }
    paramq = (dvt)((b)paramq).hQE.hQJ;
    if (paramq.BaseResponse != null)
    {
      this.DIb = paramq.Ibe;
      ae.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + paramq.SeriesID);
      ae.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + paramq.Ibd);
      this.pMm = paramq.SeriesID;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */