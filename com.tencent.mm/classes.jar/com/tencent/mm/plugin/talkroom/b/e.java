package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dgp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
  extends f
{
  private g callback;
  private final b rr;
  private int sceneType;
  private final String uaR;
  
  public e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(29564);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dgo();
    ((b.a)localObject).hvu = new dgp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talknoop";
    ((b.a)localObject).funcId = 335;
    ((b.a)localObject).reqCmdId = 149;
    ((b.a)localObject).respCmdId = 1000000149;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dgo)this.rr.hvr.hvw;
    ((dgo)localObject).Exf = paramInt1;
    ((dgo)localObject).Exg = paramLong;
    ((dgo)localObject).DPJ = ((int)bs.aNx());
    this.uaR = paramString;
    ((dgo)localObject).Scene = paramInt2;
    AppMethodBeat.o(29564);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(29565);
    ac.d("MicroMsg.NetSceneTalkNoop", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29565);
    return i;
  }
  
  public final String ebH()
  {
    return this.uaR;
  }
  
  public final int ebI()
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
    ac.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.e
 * JD-Core Version:    0.7.0.1
 */