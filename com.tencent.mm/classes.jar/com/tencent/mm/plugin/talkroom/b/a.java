package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  private g callback;
  public int roomId;
  private final b rr;
  private int sceneType;
  public long tIG;
  private final String uaR;
  public int zWC;
  public int zWD;
  public LinkedList<dgq> zWF;
  public LinkedList<dgr> zWX;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(29549);
    this.sceneType = 0;
    b.a locala = new b.a();
    this.sceneType = paramInt;
    locala.hvt = new aei();
    locala.hvu = new aej();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.funcId = 332;
    locala.reqCmdId = 147;
    locala.respCmdId = 1000000147;
    this.rr = locala.aAz();
    ((aei)this.rr.hvr.hvw).Exe = paramString;
    ((aei)this.rr.hvr.hvw).Scene = paramInt;
    this.uaR = paramString;
    AppMethodBeat.o(29549);
  }
  
  private static LinkedList<dgr> aU(LinkedList<dgr> paramLinkedList)
  {
    AppMethodBeat.i(29552);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dgr localdgr = (dgr)paramLinkedList.next();
      if (!bs.isNullOrNil(localdgr.ncR)) {
        localLinkedList.add(localdgr);
      }
    }
    AppMethodBeat.o(29552);
    return localLinkedList;
  }
  
  private static LinkedList<dgq> aV(LinkedList<dgq> paramLinkedList)
  {
    AppMethodBeat.i(29553);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((dgq)paramLinkedList.next());
    }
    AppMethodBeat.o(29553);
    return localLinkedList;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29550);
    ac.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29550);
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
    return 332;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29551);
    ac.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29551);
      return;
    }
    paramq = (aej)this.rr.hvs.hvw;
    ac.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { paramq.toString() });
    this.roomId = paramq.Exf;
    this.tIG = paramq.Exg;
    this.zWC = paramq.Exh;
    this.zWD = paramq.Exj;
    this.zWX = aU(paramq.DPz);
    this.zWF = aV(paramq.DVd);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */