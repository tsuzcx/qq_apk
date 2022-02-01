package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddq;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  private final b rr;
  e zcy;
  
  public c(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    AppMethodBeat.i(28185);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ddp();
    ((b.a)localObject).hQG = new ddq();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((b.a)localObject).funcId = 1250;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ddp)this.rr.hQD.hQJ;
    ((ddp)localObject).dzE = paramFloat2;
    ((ddp)localObject).dBu = paramFloat1;
    ((ddp)localObject).scene = paramInt;
    ((ddp)localObject).HLf = paramString;
    AppMethodBeat.o(28185);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(28186);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28186);
    return i;
  }
  
  public final int getType()
  {
    return 1250;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28187);
    ae.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ddq)this.rr.hQE.hQJ;
      if (paramq != null)
      {
        this.zcy = new e();
        this.zcy.oGc = paramq.oGc;
        this.zcy.oEo = paramq.oEo;
        this.zcy.dJc = paramq.dJc;
        this.zcy.title = paramq.title;
        this.zcy.oEp = paramq.oEp;
        this.zcy.oEq = paramq.oEq;
        this.zcy.oFG = paramq.oFG;
        this.zcy.hCp = paramq.hCp;
        this.zcy.hDr = paramq.hDr;
        this.zcy.zcz = paramq.zcz;
        this.zcy.zcC = paramq.zcC;
        this.zcy.zcD = paramq.zcD;
        this.zcy.zcE = paramq.zcE;
        this.zcy.zcF = paramq.zcF;
        this.zcy.zcG = paramq.zcG;
        this.zcy.oEs = paramq.oEs;
        this.zcy.zcH = paramq.zcH;
        this.zcy.zcI = paramq.zcI;
        m.dSr().zcB = this.zcy.zcG;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28187);
      return;
      this.zcy = new e();
      this.zcy.oGc = 3;
      this.zcy.zcG = m.dSr().zcB;
      continue;
      this.zcy = new e();
      this.zcy.oGc = 3;
      this.zcy.zcG = m.dSr().zcB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */