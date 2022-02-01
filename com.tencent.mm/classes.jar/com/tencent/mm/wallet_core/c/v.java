package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.epu;
import com.tencent.mm.protocal.protobuf.epv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v
  extends w
{
  public int Irs;
  private i callback;
  public int errCode;
  public String rcD;
  public String rcF;
  private final d rr;
  
  public v(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72800);
    this.rcD = null;
    this.Irs = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new epu();
    ((d.a)localObject).iLO = new epv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((d.a)localObject).funcId = 414;
    ((d.a)localObject).iLP = 215;
    ((d.a)localObject).respCmdId = 1000000215;
    this.rr = ((d.a)localObject).aXF();
    localObject = (epu)this.rr.iLK.iLR;
    this.rcD = paramString1;
    ((epu)localObject).ProductID = paramString1;
    ((epu)localObject).Nnp = paramInt1;
    ((epu)localObject).MJB = paramInt3;
    ((epu)localObject).APa = paramInt2;
    if (!Util.isNullOrNil(paramString6))
    {
      ((epu)localObject).MJz = paramString6;
      ((epu)localObject).MJA = paramString5;
    }
    ((epu)localObject).MJC = paramString2;
    ((epu)localObject).Nnr = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((epu)localObject).Nno = new SKBuiltinBuffer_t().setBuffer(paramString1);; ((epu)localObject).Nno = new SKBuiltinBuffer_t())
    {
      ((epu)localObject).Nnq = ((int)Util.nowSecond());
      Log.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.rcD + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
      AppMethodBeat.o(72800);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(72802);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72802);
    return i;
  }
  
  public final int getType()
  {
    return 414;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72801);
    Log.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    this.errCode = 0;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.errCode = -1;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(72801);
      return;
    }
    params = (epv)((d)params).iLL.iLR;
    if (params.BaseResponse != null)
    {
      this.Irs = params.Nnt;
      Log.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + params.SeriesID);
      Log.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + params.Nns);
      this.rcF = params.SeriesID;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */