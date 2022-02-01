package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dmw;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
  extends f
{
  public int BFF;
  public int actionType;
  private com.tencent.mm.ak.f callback;
  private final b rr;
  private int sceneType;
  private final String vpL;
  
  public d(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(29561);
    this.sceneType = 0;
    this.sceneType = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dmw();
    ((b.a)localObject).hQG = new dmx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkmicaction";
    ((b.a)localObject).funcId = 334;
    ((b.a)localObject).hQH = 146;
    ((b.a)localObject).respCmdId = 1000000146;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dmw)this.rr.hQD.hQJ;
    ((dmw)localObject).Gxq = paramInt1;
    ((dmw)localObject).Gxr = paramLong;
    ((dmw)localObject).GbY = paramInt2;
    ((dmw)localObject).FNw = ((int)bu.aRi());
    this.actionType = paramInt2;
    this.vpL = paramString;
    ((dmw)localObject).Scene = paramInt3;
    AppMethodBeat.o(29561);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(29562);
    ae.d("MicroMsg.NetSceneTalkMicAction", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29562);
    return i;
  }
  
  public final String erF()
  {
    return this.vpL;
  }
  
  public final int erG()
  {
    return this.sceneType;
  }
  
  public final int getType()
  {
    return 334;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29563);
    ae.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29563);
      return;
    }
    this.BFF = ((dmx)this.rr.hQE.hQJ).Gxs;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.d
 * JD-Core Version:    0.7.0.1
 */