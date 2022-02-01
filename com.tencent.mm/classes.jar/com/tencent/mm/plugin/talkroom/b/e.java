package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.dmc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends f
{
  private com.tencent.mm.al.f callback;
  private final b rr;
  private int sceneType;
  private final String vdA;
  
  public e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(29564);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dmb();
    ((b.a)localObject).hNN = new dmc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talknoop";
    ((b.a)localObject).funcId = 335;
    ((b.a)localObject).hNO = 149;
    ((b.a)localObject).respCmdId = 1000000149;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dmb)this.rr.hNK.hNQ;
    ((dmb)localObject).GeI = paramInt1;
    ((dmb)localObject).GeJ = paramLong;
    ((dmb)localObject).FuY = ((int)bt.aQJ());
    this.vdA = paramString;
    ((dmb)localObject).Scene = paramInt2;
    AppMethodBeat.o(29564);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(29565);
    ad.d("MicroMsg.NetSceneTalkNoop", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29565);
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
    return 335;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29566);
    ad.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29566);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.e
 * JD-Core Version:    0.7.0.1
 */