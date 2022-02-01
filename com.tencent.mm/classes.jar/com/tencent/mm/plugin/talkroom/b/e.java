package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dmy;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
  extends f
{
  private com.tencent.mm.ak.f callback;
  private final b rr;
  private int sceneType;
  private final String vpL;
  
  public e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(29564);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dmy();
    ((b.a)localObject).hQG = new dmz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talknoop";
    ((b.a)localObject).funcId = 335;
    ((b.a)localObject).hQH = 149;
    ((b.a)localObject).respCmdId = 1000000149;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dmy)this.rr.hQD.hQJ;
    ((dmy)localObject).Gxq = paramInt1;
    ((dmy)localObject).Gxr = paramLong;
    ((dmy)localObject).FNw = ((int)bu.aRi());
    this.vpL = paramString;
    ((dmy)localObject).Scene = paramInt2;
    AppMethodBeat.o(29564);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(29565);
    ae.d("MicroMsg.NetSceneTalkNoop", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29565);
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
    return 335;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29566);
    ae.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
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