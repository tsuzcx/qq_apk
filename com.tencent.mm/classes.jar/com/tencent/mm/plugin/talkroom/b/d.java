package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  extends f
{
  public int actionType;
  private g callback;
  private final b rr;
  private int sceneType;
  private final String uaR;
  public int zWC;
  
  public d(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(29561);
    this.sceneType = 0;
    this.sceneType = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dgm();
    ((b.a)localObject).hvu = new dgn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkmicaction";
    ((b.a)localObject).funcId = 334;
    ((b.a)localObject).reqCmdId = 146;
    ((b.a)localObject).respCmdId = 1000000146;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dgm)this.rr.hvr.hvw;
    ((dgm)localObject).Exf = paramInt1;
    ((dgm)localObject).Exg = paramLong;
    ((dgm)localObject).Edq = paramInt2;
    ((dgm)localObject).DPJ = ((int)bs.aNx());
    this.actionType = paramInt2;
    this.uaR = paramString;
    ((dgm)localObject).Scene = paramInt3;
    AppMethodBeat.o(29561);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29562);
    ac.d("MicroMsg.NetSceneTalkMicAction", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29562);
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
    return 334;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29563);
    ac.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29563);
      return;
    }
    this.zWC = ((dgn)this.rr.hvs.hvw).Exh;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.d
 * JD-Core Version:    0.7.0.1
 */