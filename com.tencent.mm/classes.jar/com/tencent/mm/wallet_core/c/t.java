package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class t
  extends u
{
  private f callback;
  public int errCode;
  public String liu;
  public String liw;
  private final b rr;
  public int uAE;
  
  public t(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(49080);
    this.liu = null;
    this.uAE = 0;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cqe();
    ((b.a)localObject).fsY = new cqf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((b.a)localObject).funcId = 414;
    ((b.a)localObject).reqCmdId = 215;
    ((b.a)localObject).respCmdId = 1000000215;
    this.rr = ((b.a)localObject).ado();
    localObject = (cqe)this.rr.fsV.fta;
    this.liu = paramString1;
    ((cqe)localObject).ProductID = paramString1;
    ((cqe)localObject).xYJ = paramInt1;
    ((cqe)localObject).xBM = paramInt3;
    ((cqe)localObject).pqf = paramInt2;
    if (!bo.isNullOrNil(paramString6))
    {
      ((cqe)localObject).xBK = paramString6;
      ((cqe)localObject).xBL = paramString5;
    }
    ((cqe)localObject).xBN = paramString2;
    ((cqe)localObject).xYL = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((cqe)localObject).xYI = new SKBuiltinBuffer_t().setBuffer(paramString1);; ((cqe)localObject).xYI = new SKBuiltinBuffer_t())
    {
      ((cqe)localObject).xYK = ((int)bo.aox());
      ab.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.liu + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
      AppMethodBeat.o(49080);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(49082);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(49082);
    return i;
  }
  
  public final int getType()
  {
    return 414;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142658);
    ab.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    this.errCode = 0;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.errCode = -1;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(142658);
      return;
    }
    paramq = (cqf)((b)paramq).fsW.fta;
    if (paramq.BaseResponse != null)
    {
      this.uAE = paramq.xYN;
      ab.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + paramq.SeriesID);
      ab.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + paramq.xYM);
      this.liw = paramq.SeriesID;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */