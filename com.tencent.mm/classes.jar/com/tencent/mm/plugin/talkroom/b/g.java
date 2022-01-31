package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public g(LinkedList<cjo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(25885);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cjp();
    ((b.a)localObject).fsY = new cjq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/talkstatreport";
    ((b.a)localObject).funcId = 373;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cjp)this.rr.fsV.fta;
    ((cjp)localObject).xTF = paramLinkedList.size();
    ((cjp)localObject).xTG = paramLinkedList;
    ((cjp)localObject).Scene = paramInt;
    AppMethodBeat.o(25885);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25886);
    ab.d("MicroMsg.NetSceneTalkStatReport", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25886);
    return i;
  }
  
  public final int getType()
  {
    return 373;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25887);
    ab.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25887);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.g
 * JD-Core Version:    0.7.0.1
 */