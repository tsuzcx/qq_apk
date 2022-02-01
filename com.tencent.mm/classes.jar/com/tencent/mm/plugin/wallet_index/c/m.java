package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;

public final class m
  extends w
{
  private g callback;
  public String dcO;
  public int errCode;
  private b rr;
  
  public m(int paramInt1, int paramInt2, String paramString, blb paramblb, bla parambla)
  {
    AppMethodBeat.i(71827);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dor();
    ((b.a)localObject).hvu = new dos();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
    ((b.a)localObject).funcId = 1306;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dor)this.rr.hvr.hvw;
    ((dor)localObject).ELC = paramInt1;
    ((dor)localObject).dqm = paramInt2;
    this.dcO = paramString;
    ((dor)localObject).ELI = paramblb;
    ((dor)localObject).ELH = parambla;
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
    ac.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71828);
      return;
    }
    paramq = (dos)this.rr.hvs.hvw;
    ac.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + paramq.dkl + ",errMsg:" + paramq.dkm);
    paramInt1 = paramq.dkl;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
    AppMethodBeat.o(71828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.m
 * JD-Core Version:    0.7.0.1
 */