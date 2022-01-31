package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cji;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  extends f
{
  public int actionType;
  private com.tencent.mm.ai.f callback;
  private final String odS;
  private final b rr;
  private int sceneType;
  public int tcT;
  
  public d(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(25879);
    this.sceneType = 0;
    this.sceneType = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cji();
    ((b.a)localObject).fsY = new cjj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkmicaction";
    ((b.a)localObject).funcId = 334;
    ((b.a)localObject).reqCmdId = 146;
    ((b.a)localObject).respCmdId = 1000000146;
    this.rr = ((b.a)localObject).ado();
    localObject = (cji)this.rr.fsV.fta;
    ((cji)localObject).wQP = paramInt1;
    ((cji)localObject).wQQ = paramLong;
    ((cji)localObject).wzE = paramInt2;
    ((cji)localObject).woF = ((int)bo.aox());
    this.actionType = paramInt2;
    this.odS = paramString;
    ((cji)localObject).Scene = paramInt3;
    AppMethodBeat.o(25879);
  }
  
  public final String cHO()
  {
    return this.odS;
  }
  
  public final int cHP()
  {
    return this.sceneType;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(25880);
    ab.d("MicroMsg.NetSceneTalkMicAction", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25880);
    return i;
  }
  
  public final int getType()
  {
    return 334;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25881);
    ab.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25881);
      return;
    }
    this.tcT = ((cjj)this.rr.fsW.fta).wQR;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.d
 * JD-Core Version:    0.7.0.1
 */