package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.protocal.protobuf.of;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24508);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new oe();
    ((b.a)localObject).fsY = new of();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
    ((b.a)localObject).funcId = 1252;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (oe)this.rr.fsV.fta;
    ((oe)localObject).kml = paramString1;
    ((oe)localObject).cHo = paramString2;
    AppMethodBeat.o(24508);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24509);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24509);
    return i;
  }
  
  public final int getType()
  {
    return 1252;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24510);
    ab.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.a
 * JD-Core Version:    0.7.0.1
 */