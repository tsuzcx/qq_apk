package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends f
{
  private com.tencent.mm.ai.f callback;
  private final String odS;
  private final b rr;
  private int sceneType;
  
  public e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(25882);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cjk();
    ((b.a)localObject).fsY = new cjl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talknoop";
    ((b.a)localObject).funcId = 335;
    ((b.a)localObject).reqCmdId = 149;
    ((b.a)localObject).respCmdId = 1000000149;
    this.rr = ((b.a)localObject).ado();
    localObject = (cjk)this.rr.fsV.fta;
    ((cjk)localObject).wQP = paramInt1;
    ((cjk)localObject).wQQ = paramLong;
    ((cjk)localObject).woF = ((int)bo.aox());
    this.odS = paramString;
    ((cjk)localObject).Scene = paramInt2;
    AppMethodBeat.o(25882);
  }
  
  public final String cHO()
  {
    return this.odS;
  }
  
  public final int cHP()
  {
    return this.sceneType;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(25883);
    ab.d("MicroMsg.NetSceneTalkNoop", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25883);
    return i;
  }
  
  public final int getType()
  {
    return 335;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25884);
    ab.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25884);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.e
 * JD-Core Version:    0.7.0.1
 */