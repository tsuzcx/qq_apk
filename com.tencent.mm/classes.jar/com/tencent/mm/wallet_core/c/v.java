package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpe;
import com.tencent.mm.protocal.protobuf.dpf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class v
  extends w
{
  public int BQd;
  private g callback;
  public int errCode;
  public String pbW;
  public String pbY;
  private final b rr;
  
  public v(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72800);
    this.pbW = null;
    this.BQd = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dpe();
    ((b.a)localObject).hvu = new dpf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((b.a)localObject).funcId = 414;
    ((b.a)localObject).reqCmdId = 215;
    ((b.a)localObject).respCmdId = 1000000215;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dpe)this.rr.hvr.hvw;
    this.pbW = paramString1;
    ((dpe)localObject).ProductID = paramString1;
    ((dpe)localObject).FWx = paramInt1;
    ((dpe)localObject).Fvn = paramInt3;
    ((dpe)localObject).vyb = paramInt2;
    if (!bs.isNullOrNil(paramString6))
    {
      ((dpe)localObject).Fvl = paramString6;
      ((dpe)localObject).Fvm = paramString5;
    }
    ((dpe)localObject).Fvo = paramString2;
    ((dpe)localObject).FWz = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((dpe)localObject).FWw = new SKBuiltinBuffer_t().setBuffer(paramString1);; ((dpe)localObject).FWw = new SKBuiltinBuffer_t())
    {
      ((dpe)localObject).FWy = ((int)bs.aNx());
      ac.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.pbW + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
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
    ac.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    this.errCode = 0;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.errCode = -1;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72801);
      return;
    }
    paramq = (dpf)((b)paramq).hvs.hvw;
    if (paramq.BaseResponse != null)
    {
      this.BQd = paramq.FWB;
      ac.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + paramq.SeriesID);
      ac.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + paramq.FWA);
      this.pbY = paramq.SeriesID;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */