package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private int sceneType;
  
  public b(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29554);
    this.sceneType = paramInt2;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ajy();
    ((d.a)localObject).iLO = new ajz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/exittalkroom";
    ((d.a)localObject).funcId = 333;
    ((d.a)localObject).iLP = 148;
    ((d.a)localObject).respCmdId = 1000000148;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ajy)this.rr.iLK.iLR;
    ((ajy)localObject).LsY = paramString;
    ((ajy)localObject).LsZ = paramInt1;
    ((ajy)localObject).Lta = paramLong;
    ((ajy)localObject).Scene = paramInt2;
    AppMethodBeat.o(29554);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29555);
    Log.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29555);
    return i;
  }
  
  public final int getType()
  {
    return 333;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29556);
    Log.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29556);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.b
 * JD-Core Version:    0.7.0.1
 */