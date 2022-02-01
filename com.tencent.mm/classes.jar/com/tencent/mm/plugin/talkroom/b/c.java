package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  private g callback;
  private final b rr;
  private int sceneType;
  private final String uaR;
  public int zWC;
  public LinkedList<dgr> zWX;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29557);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new beu();
    ((b.a)localObject).hvu = new bev();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((b.a)localObject).funcId = 336;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (beu)this.rr.hvr.hvw;
    ((beu)localObject).Exf = paramInt1;
    ((beu)localObject).Exg = paramLong;
    this.uaR = paramString;
    ((beu)localObject).Scene = paramInt2;
    AppMethodBeat.o(29557);
  }
  
  private static LinkedList<dgr> aU(LinkedList<dgr> paramLinkedList)
  {
    AppMethodBeat.i(29560);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dgr localdgr = (dgr)paramLinkedList.next();
      if (!bs.isNullOrNil(localdgr.ncR)) {
        localLinkedList.add(localdgr);
      }
    }
    AppMethodBeat.o(29560);
    return localLinkedList;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29558);
    ac.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29558);
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
    return 336;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29559);
    ac.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29559);
      return;
    }
    paramq = (bev)this.rr.hvs.hvw;
    ac.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { paramq.toString() });
    this.zWC = paramq.Exh;
    this.zWX = aU(paramq.DPz);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */