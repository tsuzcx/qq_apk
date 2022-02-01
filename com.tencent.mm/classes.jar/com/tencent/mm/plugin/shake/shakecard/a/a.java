package com.tencent.mm.plugin.shake.shakecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28179);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new vi();
    ((c.a)localObject).otF = new vj();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
    ((c.a)localObject).funcId = 1252;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (vi)c.b.b(this.rr.otB);
    ((vi)localObject).wsy = paramString1;
    ((vi)localObject).iaJ = paramString2;
    AppMethodBeat.o(28179);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(28180);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.shake.shakecard.a.a
 * JD-Core Version:    0.7.0.1
 */