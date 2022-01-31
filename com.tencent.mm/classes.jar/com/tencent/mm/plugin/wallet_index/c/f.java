package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class f
  extends u
{
  private com.tencent.mm.ai.f callback;
  public int errCode;
  private b rr;
  public awd uAh;
  public awe uAi;
  
  public f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(48184);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new afr();
    ((b.a)localObject).fsY = new afs();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((b.a)localObject).funcId = 1130;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (afr)this.rr.fsV.fta;
    ((afr)localObject).cwc = paramString1;
    ((afr)localObject).wYN = paramInt1;
    ((afr)localObject).wYO = Integer.parseInt(paramString2);
    ((afr)localObject).desc = paramString3;
    ((afr)localObject).count = paramInt2;
    ((afr)localObject).scene = 13;
    ((afr)localObject).wYP = paramString4;
    ((afr)localObject).wYQ = paramString5;
    ((afr)localObject).sign = paramString6;
    ((afr)localObject).wYR = paramString7;
    AppMethodBeat.o(48184);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(48186);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48186);
    return i;
  }
  
  public final int getType()
  {
    return 1130;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142580);
    ab.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(142580);
      return;
    }
    paramString = (afs)this.rr.fsW.fta;
    ab.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.cxa + ",errMsg:" + paramString.cxb);
    paramInt1 = paramString.cxa;
    paramq = paramString.cxb;
    if (paramInt1 == 0)
    {
      this.uAh = paramString.wYS;
      this.uAi = paramString.wYT;
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(142580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.f
 * JD-Core Version:    0.7.0.1
 */