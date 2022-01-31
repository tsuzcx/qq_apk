package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  private com.tencent.mm.ai.f callback;
  private final String odS;
  private final b rr;
  private int sceneType;
  public int tcT;
  public LinkedList<cjn> tdp;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(25875);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aqn();
    ((b.a)localObject).fsY = new aqo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((b.a)localObject).funcId = 336;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aqn)this.rr.fsV.fta;
    ((aqn)localObject).wQP = paramInt1;
    ((aqn)localObject).wQQ = paramLong;
    this.odS = paramString;
    ((aqn)localObject).Scene = paramInt2;
    AppMethodBeat.o(25875);
  }
  
  private static LinkedList<cjn> aw(LinkedList<cjn> paramLinkedList)
  {
    AppMethodBeat.i(25878);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cjn localcjn = (cjn)paramLinkedList.next();
      if (!bo.isNullOrNil(localcjn.jJA)) {
        localLinkedList.add(localcjn);
      }
    }
    AppMethodBeat.o(25878);
    return localLinkedList;
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
    AppMethodBeat.i(25876);
    ab.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25876);
    return i;
  }
  
  public final int getType()
  {
    return 336;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25877);
    ab.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25877);
      return;
    }
    paramq = (aqo)this.rr.fsW.fta;
    ab.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { paramq.toString() });
    this.tcT = paramq.wQR;
    this.tdp = aw(paramq.wov);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */