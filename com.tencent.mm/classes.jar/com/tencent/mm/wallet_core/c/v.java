package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.faf;
import com.tencent.mm.protocal.protobuf.fag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v
  extends w
{
  public int Pkb;
  private i callback;
  public int errCode;
  private final d rr;
  public String uFI;
  public String uFK;
  
  public v(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(72800);
    this.uFI = null;
    this.Pkb = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new faf();
    ((d.a)localObject).lBV = new fag();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((d.a)localObject).funcId = 414;
    ((d.a)localObject).lBW = 215;
    ((d.a)localObject).respCmdId = 1000000215;
    this.rr = ((d.a)localObject).bgN();
    localObject = (faf)d.b.b(this.rr.lBR);
    this.uFI = paramString1;
    ((faf)localObject).ProductID = paramString1;
    ((faf)localObject).UAg = paramInt1;
    ((faf)localObject).TVq = paramInt3;
    ((faf)localObject).GIo = paramInt2;
    if (!Util.isNullOrNil(paramString6))
    {
      ((faf)localObject).TVo = paramString6;
      ((faf)localObject).TVp = paramString5;
    }
    ((faf)localObject).TVr = paramString2;
    ((faf)localObject).UAi = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((faf)localObject).UAf = new eae().dc(paramString1);; ((faf)localObject).UAf = new eae())
    {
      ((faf)localObject).UAh = ((int)Util.nowSecond());
      Log.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.uFI + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
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
    params = (fag)d.c.b(((d)params).lBS);
    if (params.BaseResponse != null)
    {
      this.Pkb = params.UAk;
      Log.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + params.SvE);
      Log.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + params.UAj);
      this.uFK = params.SvE;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */