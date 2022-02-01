package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.dvf;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.w;

public final class m
  extends w
{
  private f callback;
  public String dpp;
  public int errCode;
  private b rr;
  
  public m(int paramInt1, int paramInt2, String paramString, bqd parambqd, bqc parambqc)
  {
    AppMethodBeat.i(71827);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dvf();
    ((b.a)localObject).hQG = new dvg();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
    ((b.a)localObject).funcId = 1306;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dvf)this.rr.hQD.hQJ;
    ((dvf)localObject).GOf = paramInt1;
    ((dvf)localObject).dDe = paramInt2;
    this.dpp = paramString;
    ((dvf)localObject).GOl = parambqd;
    ((dvf)localObject).GOk = parambqc;
    AppMethodBeat.o(71827);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71829);
    this.callback = paramf;
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
    ae.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71828);
      return;
    }
    paramq = (dvg)this.rr.hQE.hQJ;
    ae.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + paramq.dxd + ",errMsg:" + paramq.dxe);
    paramInt1 = paramq.dxd;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
    AppMethodBeat.o(71828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.m
 * JD-Core Version:    0.7.0.1
 */