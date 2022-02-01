package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends f
{
  public int Bog;
  public int actionType;
  private com.tencent.mm.al.f callback;
  private final b rr;
  private int sceneType;
  private final String vdA;
  
  public d(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(29561);
    this.sceneType = 0;
    this.sceneType = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dlz();
    ((b.a)localObject).hNN = new dma();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkmicaction";
    ((b.a)localObject).funcId = 334;
    ((b.a)localObject).hNO = 146;
    ((b.a)localObject).respCmdId = 1000000146;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dlz)this.rr.hNK.hNQ;
    ((dlz)localObject).GeI = paramInt1;
    ((dlz)localObject).GeJ = paramLong;
    ((dlz)localObject).FJz = paramInt2;
    ((dlz)localObject).FuY = ((int)bt.aQJ());
    this.actionType = paramInt2;
    this.vdA = paramString;
    ((dlz)localObject).Scene = paramInt3;
    AppMethodBeat.o(29561);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(29562);
    ad.d("MicroMsg.NetSceneTalkMicAction", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29562);
    return i;
  }
  
  public final String enY()
  {
    return this.vdA;
  }
  
  public final int enZ()
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
    ad.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29563);
      return;
    }
    this.Bog = ((dma)this.rr.hNL.hNQ).GeK;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.d
 * JD-Core Version:    0.7.0.1
 */