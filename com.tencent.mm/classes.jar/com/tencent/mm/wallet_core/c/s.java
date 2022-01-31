package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends u
{
  private f callback;
  public String liu;
  public final b rr;
  public String uAa;
  public String uAb;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(49077);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bno();
    ((b.a)localObject).fsY = new bnp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preparepurchase";
    ((b.a)localObject).funcId = 422;
    ((b.a)localObject).reqCmdId = 214;
    ((b.a)localObject).respCmdId = 1000000214;
    this.rr = ((b.a)localObject).ado();
    localObject = (bno)this.rr.fsV.fta;
    this.liu = paramString1;
    ((bno)localObject).ProductID = paramString1;
    this.uAb = paramString2;
    ((bno)localObject).xBK = paramString2;
    this.uAa = paramString3;
    ((bno)localObject).xBL = paramString3;
    ((bno)localObject).pqf = paramInt2;
    ((bno)localObject).xBM = paramInt1;
    ((bno)localObject).nuz = paramString4;
    ab.d("MicroMsg.NetScenePreparePurchase", "productId:" + paramString1 + ",price:" + paramString2 + ",currencyType:" + paramString3 + ",payType:" + paramInt2);
    AppMethodBeat.o(49077);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(49079);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(49079);
    return i;
  }
  
  public final int getType()
  {
    return 422;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142657);
    ab.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(142657);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.s
 * JD-Core Version:    0.7.0.1
 */