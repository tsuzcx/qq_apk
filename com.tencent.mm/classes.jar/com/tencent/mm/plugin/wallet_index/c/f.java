package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class f
  extends w
{
  public bhi Axj;
  public bhj Axk;
  private g callback;
  public int errCode;
  private b rr;
  
  public f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71819);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aow();
    ((b.a)localObject).gUV = new aox();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((b.a)localObject).funcId = 1130;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (aow)this.rr.gUS.gUX;
    ((aow)localObject).dlB = paramString1;
    ((aow)localObject).DqA = paramInt1;
    ((aow)localObject).DqB = Integer.parseInt(paramString2);
    ((aow)localObject).desc = paramString3;
    ((aow)localObject).count = paramInt2;
    ((aow)localObject).scene = 13;
    ((aow)localObject).DqC = paramString4;
    ((aow)localObject).DqD = paramString5;
    ((aow)localObject).sign = paramString6;
    ((aow)localObject).DqE = paramString7;
    AppMethodBeat.o(71819);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71821);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71821);
    return i;
  }
  
  public final int getType()
  {
    return 1130;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71820);
    ad.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71820);
      return;
    }
    paramString = (aox)this.rr.gUT.gUX;
    ad.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.dmD + ",errMsg:" + paramString.dmE);
    paramInt1 = paramString.dmD;
    paramq = paramString.dmE;
    if (paramInt1 == 0)
    {
      this.Axj = paramString.DqF;
      this.Axk = paramString.DqG;
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.f
 * JD-Core Version:    0.7.0.1
 */