package com.tencent.mm.plugin.shake.shakecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements com.tencent.mm.network.m
{
  d PzM;
  private h callback;
  private final com.tencent.mm.am.c rr;
  
  public b(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    AppMethodBeat.i(28185);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fau();
    ((c.a)localObject).otF = new fav();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((c.a)localObject).funcId = 1250;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fau)c.b.b(this.rr.otB);
    ((fau)localObject).latitude = paramFloat2;
    ((fau)localObject).longitude = paramFloat1;
    ((fau)localObject).scene = paramInt;
    ((fau)localObject).abAO = paramString;
    AppMethodBeat.o(28185);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(28186);
    this.callback = paramh;
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
      params = (fav)c.c.b(this.rr.otC);
      if (params != null)
      {
        this.PzM = new d();
        this.PzM.wuj = params.wuj;
        this.PzM.wsy = params.wsy;
        this.PzM.iaJ = params.iaJ;
        this.PzM.title = params.title;
        this.PzM.wsz = params.wsz;
        this.PzM.wsA = params.wsA;
        this.PzM.mee = params.mee;
        this.PzM.nQG = params.nQG;
        this.PzM.nRQ = params.nRQ;
        this.PzM.PzN = params.PzN;
        this.PzM.PzQ = params.PzQ;
        this.PzM.PzR = params.PzR;
        this.PzM.PzS = params.PzS;
        this.PzM.PzT = params.PzT;
        this.PzM.PzU = params.PzU;
        this.PzM.end_time = params.end_time;
        this.PzM.PzV = params.PzV;
        this.PzM.PzW = params.PzW;
        com.tencent.mm.plugin.shake.model.m.gXj().PzP = this.PzM.PzU;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28187);
      return;
      this.PzM = new d();
      this.PzM.wuj = 3;
      this.PzM.PzU = com.tencent.mm.plugin.shake.model.m.gXj().PzP;
      continue;
      this.PzM = new d();
      this.PzM.wuj = 3;
      this.PzM.PzU = com.tencent.mm.plugin.shake.model.m.gXj().PzP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.shakecard.a.b
 * JD-Core Version:    0.7.0.1
 */