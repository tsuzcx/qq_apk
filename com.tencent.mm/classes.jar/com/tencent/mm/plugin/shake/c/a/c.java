package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dwu;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements com.tencent.mm.network.m
{
  e Dhq;
  private i callback;
  private final com.tencent.mm.ak.d rr;
  
  public c(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    AppMethodBeat.i(28185);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dwt();
    ((d.a)localObject).iLO = new dwu();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((d.a)localObject).funcId = 1250;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dwt)this.rr.iLK.iLR;
    ((dwt)localObject).latitude = paramFloat2;
    ((dwt)localObject).dTj = paramFloat1;
    ((dwt)localObject).scene = paramInt;
    ((dwt)localObject).MWO = paramString;
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
      params = (dwu)this.rr.iLL.iLR;
      if (params != null)
      {
        this.Dhq = new e();
        this.Dhq.pTI = params.pTI;
        this.Dhq.pRX = params.pRX;
        this.Dhq.eaP = params.eaP;
        this.Dhq.title = params.title;
        this.Dhq.pRY = params.pRY;
        this.Dhq.pRZ = params.pRZ;
        this.Dhq.gTG = params.gTG;
        this.Dhq.iwv = params.iwv;
        this.Dhq.ixw = params.ixw;
        this.Dhq.Dhr = params.Dhr;
        this.Dhq.Dhu = params.Dhu;
        this.Dhq.Dhv = params.Dhv;
        this.Dhq.Dhw = params.Dhw;
        this.Dhq.Dhx = params.Dhx;
        this.Dhq.Dhy = params.Dhy;
        this.Dhq.pSb = params.pSb;
        this.Dhq.Dhz = params.Dhz;
        this.Dhq.DhA = params.DhA;
        com.tencent.mm.plugin.shake.b.m.eUs().Dht = this.Dhq.Dhy;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28187);
      return;
      this.Dhq = new e();
      this.Dhq.pTI = 3;
      this.Dhq.Dhy = com.tencent.mm.plugin.shake.b.m.eUs().Dht;
      continue;
      this.Dhq = new e();
      this.Dhq.pTI = 3;
      this.Dhq.Dhy = com.tencent.mm.plugin.shake.b.m.eUs().Dht;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */