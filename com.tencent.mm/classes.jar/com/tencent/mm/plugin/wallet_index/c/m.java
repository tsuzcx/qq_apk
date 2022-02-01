package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class m
  extends w
{
  private g callback;
  public String dft;
  public int errCode;
  private b rr;
  
  public m(int paramInt1, int paramInt2, String paramString, bhj parambhj, bhi parambhi)
  {
    AppMethodBeat.i(71827);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new djc();
    ((b.a)localObject).gUV = new djd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
    ((b.a)localObject).funcId = 1306;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (djc)this.rr.gUS.gUX;
    ((djc)localObject).DqA = paramInt1;
    ((djc)localObject).dsC = paramInt2;
    this.dft = paramString;
    ((djc)localObject).DqG = parambhj;
    ((djc)localObject).DqF = parambhi;
    AppMethodBeat.o(71827);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71829);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71829);
    return i;
  }
  
  public final int getType()
  {
    return 1306;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71828);
    ad.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71828);
      return;
    }
    paramq = (djd)this.rr.gUT.gUX;
    ad.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + paramq.dmD + ",errMsg:" + paramq.dmE);
    paramInt1 = paramq.dmD;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
    AppMethodBeat.o(71828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.m
 * JD-Core Version:    0.7.0.1
 */