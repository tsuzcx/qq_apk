package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.egu;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements com.tencent.mm.network.m
{
  d JmW;
  private i callback;
  private final com.tencent.mm.an.d rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    AppMethodBeat.i(28185);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new egu();
    ((d.a)localObject).lBV = new egv();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((d.a)localObject).funcId = 1250;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (egu)d.b.b(this.rr.lBR);
    ((egu)localObject).latitude = paramFloat2;
    ((egu)localObject).longitude = paramFloat1;
    ((egu)localObject).scene = paramInt;
    ((egu)localObject).Ujj = paramString;
    AppMethodBeat.o(28185);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28186);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28186);
    return i;
  }
  
  public final int getType()
  {
    return 1250;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28187);
    Log.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (egv)d.c.b(this.rr.lBS);
      if (params != null)
      {
        this.JmW = new d();
        this.JmW.tpK = params.tpK;
        this.JmW.tnX = params.tnX;
        this.JmW.fUM = params.fUM;
        this.JmW.title = params.title;
        this.JmW.tnY = params.tnY;
        this.JmW.tnZ = params.tnZ;
        this.JmW.jEi = params.jEi;
        this.JmW.llI = params.llI;
        this.JmW.lmL = params.lmL;
        this.JmW.JmX = params.JmX;
        this.JmW.Jna = params.Jna;
        this.JmW.Jnb = params.Jnb;
        this.JmW.Jnc = params.Jnc;
        this.JmW.Jnd = params.Jnd;
        this.JmW.Jne = params.Jne;
        this.JmW.end_time = params.end_time;
        this.JmW.Jnf = params.Jnf;
        this.JmW.Jng = params.Jng;
        com.tencent.mm.plugin.shake.b.m.fHu().JmZ = this.JmW.Jne;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28187);
      return;
      this.JmW = new d();
      this.JmW.tpK = 3;
      this.JmW.Jne = com.tencent.mm.plugin.shake.b.m.fHu().JmZ;
      continue;
      this.JmW = new d();
      this.JmW.tpK = 3;
      this.JmW.Jne = com.tencent.mm.plugin.shake.b.m.fHu().JmZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */