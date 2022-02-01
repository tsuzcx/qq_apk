package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class m
  extends w
{
  private f callback;
  public String dok;
  public int errCode;
  private b rr;
  
  public m(int paramInt1, int paramInt2, String paramString, bpl parambpl, bpk parambpk)
  {
    AppMethodBeat.i(71827);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dui();
    ((b.a)localObject).hNN = new duj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
    ((b.a)localObject).funcId = 1306;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dui)this.rr.hNK.hNQ;
    ((dui)localObject).GuG = paramInt1;
    ((dui)localObject).dBZ = paramInt2;
    this.dok = paramString;
    ((dui)localObject).GuM = parambpl;
    ((dui)localObject).GuL = parambpk;
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
    ad.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71828);
      return;
    }
    paramq = (duj)this.rr.hNL.hNQ;
    ad.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + paramq.dvY + ",errMsg:" + paramq.dvZ);
    paramInt1 = paramq.dvY;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
    AppMethodBeat.o(71828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.m
 * JD-Core Version:    0.7.0.1
 */