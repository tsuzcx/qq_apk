package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  private g callback;
  private final b rr;
  e xxD;
  
  public c(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    AppMethodBeat.i(28185);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cxi();
    ((b.a)localObject).hvu = new cxj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((b.a)localObject).funcId = 1250;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cxi)this.rr.hvr.hvw;
    ((cxi)localObject).dmL = paramFloat2;
    ((cxi)localObject).doB = paramFloat1;
    ((cxi)localObject).scene = paramInt;
    ((cxi)localObject).FGV = paramString;
    AppMethodBeat.o(28185);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(28186);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cxj)this.rr.hvs.hvw;
      if (paramq != null)
      {
        this.xxD = new e();
        this.xxD.nWg = paramq.nWg;
        this.xxD.nUr = paramq.nUr;
        this.xxD.dvP = paramq.dvP;
        this.xxD.title = paramq.title;
        this.xxD.nUs = paramq.nUs;
        this.xxD.nUt = paramq.nUt;
        this.xxD.nVK = paramq.nVK;
        this.xxD.hhs = paramq.hhs;
        this.xxD.hiu = paramq.hiu;
        this.xxD.xxE = paramq.xxE;
        this.xxD.xxH = paramq.xxH;
        this.xxD.xxI = paramq.xxI;
        this.xxD.xxJ = paramq.xxJ;
        this.xxD.xxK = paramq.xxK;
        this.xxD.xxL = paramq.xxL;
        this.xxD.nUv = paramq.nUv;
        this.xxD.xxM = paramq.xxM;
        this.xxD.xxN = paramq.xxN;
        m.dDr().xxG = this.xxD.xxL;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28187);
      return;
      this.xxD = new e();
      this.xxD.nWg = 3;
      this.xxD.xxL = m.dDr().xxG;
      continue;
      this.xxD = new e();
      this.xxD.nWg = 3;
      this.xxD.xxL = m.dDr().xxG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */