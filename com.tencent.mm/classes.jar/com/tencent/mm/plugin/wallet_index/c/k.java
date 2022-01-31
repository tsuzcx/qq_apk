package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class k
  extends u
{
  private f callback;
  public String cqx;
  public int errCode;
  private b rr;
  
  public k(int paramInt1, int paramInt2, String paramString, awe paramawe, awd paramawd)
  {
    AppMethodBeat.i(48192);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cpr();
    ((b.a)localObject).fsY = new cps();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
    ((b.a)localObject).funcId = 1306;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cpr)this.rr.fsV.fta;
    ((cpr)localObject).wYN = paramInt1;
    ((cpr)localObject).cCd = paramInt2;
    this.cqx = paramString;
    ((cpr)localObject).wYT = paramawe;
    ((cpr)localObject).wYS = paramawd;
    AppMethodBeat.o(48192);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48194);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48194);
    return i;
  }
  
  public final int getType()
  {
    return 1306;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142582);
    ab.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(142582);
      return;
    }
    paramq = (cps)this.rr.fsW.fta;
    ab.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + paramq.cxa + ",errMsg:" + paramq.cxb);
    paramInt1 = paramq.cxa;
    this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
    AppMethodBeat.o(142582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.k
 * JD-Core Version:    0.7.0.1
 */