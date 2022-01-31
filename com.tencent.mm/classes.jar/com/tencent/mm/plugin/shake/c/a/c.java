package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  e qNx;
  private final b rr;
  
  public c(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    AppMethodBeat.i(24514);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cbh();
    ((b.a)localObject).fsY = new cbi();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((b.a)localObject).funcId = 1250;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cbh)this.rr.fsV.fta;
    ((cbh)localObject).cyV = paramFloat2;
    ((cbh)localObject).cAH = paramFloat1;
    ((cbh)localObject).scene = paramInt;
    ((cbh)localObject).xLZ = paramString;
    AppMethodBeat.o(24514);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(24515);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24515);
    return i;
  }
  
  public final int getType()
  {
    return 1250;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24516);
    ab.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cbi)this.rr.fsW.fta;
      if (paramq != null)
      {
        this.qNx = new e();
        this.qNx.knS = paramq.knS;
        this.qNx.kml = paramq.kml;
        this.qNx.cHo = paramq.cHo;
        this.qNx.title = paramq.title;
        this.qNx.kmn = paramq.kmn;
        this.qNx.kmo = paramq.kmo;
        this.qNx.knw = paramq.knw;
        this.qNx.kmm = paramq.kmm;
        this.qNx.color = paramq.color;
        this.qNx.qNy = paramq.qNy;
        this.qNx.qNB = paramq.qNB;
        this.qNx.qNC = paramq.qNC;
        this.qNx.qND = paramq.qND;
        this.qNx.qNE = paramq.qNE;
        this.qNx.qNF = paramq.qNF;
        this.qNx.kmq = paramq.kmq;
        this.qNx.qNG = paramq.qNG;
        this.qNx.qNH = paramq.qNH;
        com.tencent.mm.plugin.shake.b.m.clt().qNA = this.qNx.qNF;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(24516);
      return;
      this.qNx = new e();
      this.qNx.knS = 3;
      this.qNx.qNF = com.tencent.mm.plugin.shake.b.m.clt().qNA;
      continue;
      this.qNx = new e();
      this.qNx.knS = 3;
      this.qNx.qNF = com.tencent.mm.plugin.shake.b.m.clt().qNA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */