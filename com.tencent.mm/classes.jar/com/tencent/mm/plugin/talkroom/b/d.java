package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.protocal.protobuf.ego;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends f
{
  public int FQw;
  public int actionType;
  private i callback;
  private final com.tencent.mm.ak.d rr;
  private int sceneType;
  private final String yJB;
  
  public d(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(29561);
    this.sceneType = 0;
    this.sceneType = paramInt3;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new egn();
    ((d.a)localObject).iLO = new ego();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/talkmicaction";
    ((d.a)localObject).funcId = 334;
    ((d.a)localObject).iLP = 146;
    ((d.a)localObject).respCmdId = 1000000146;
    this.rr = ((d.a)localObject).aXF();
    localObject = (egn)this.rr.iLK.iLR;
    ((egn)localObject).LsZ = paramInt1;
    ((egn)localObject).Lta = paramLong;
    ((egn)localObject).KWb = paramInt2;
    ((egn)localObject).KHb = ((int)Util.nowSecond());
    this.actionType = paramInt2;
    this.yJB = paramString;
    ((egn)localObject).Scene = paramInt3;
    AppMethodBeat.o(29561);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29562);
    Log.d("MicroMsg.NetSceneTalkMicAction", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29562);
    return i;
  }
  
  public final String fui()
  {
    return this.yJB;
  }
  
  public final int fuj()
  {
    return this.sceneType;
  }
  
  public final int getType()
  {
    return 334;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29563);
    Log.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29563);
      return;
    }
    this.FQw = ((ego)this.rr.iLL.iLR).Ltb;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.d
 * JD-Core Version:    0.7.0.1
 */