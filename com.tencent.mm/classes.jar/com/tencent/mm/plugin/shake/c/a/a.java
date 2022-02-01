package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28179);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new tp();
    ((d.a)localObject).iLO = new tq();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
    ((d.a)localObject).funcId = 1252;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (tp)this.rr.iLK.iLR;
    ((tp)localObject).pRX = paramString1;
    ((tp)localObject).eaP = paramString2;
    AppMethodBeat.o(28179);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28180);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28180);
    return i;
  }
  
  public final int getType()
  {
    return 1252;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28181);
    Log.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.a
 * JD-Core Version:    0.7.0.1
 */