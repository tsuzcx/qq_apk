package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  private com.tencent.mm.ai.f callback;
  public int nMZ;
  public long nNa;
  private final String odS;
  private final b rr;
  private int sceneType;
  public int tcT;
  public int tcU;
  public LinkedList<cjm> tcW;
  public LinkedList<cjn> tdp;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(25867);
    this.sceneType = 0;
    b.a locala = new b.a();
    this.sceneType = paramInt;
    locala.fsX = new zv();
    locala.fsY = new zw();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.funcId = 332;
    locala.reqCmdId = 147;
    locala.respCmdId = 1000000147;
    this.rr = locala.ado();
    ((zv)this.rr.fsV.fta).wQO = paramString;
    ((zv)this.rr.fsV.fta).Scene = paramInt;
    this.odS = paramString;
    AppMethodBeat.o(25867);
  }
  
  private static LinkedList<cjn> aw(LinkedList<cjn> paramLinkedList)
  {
    AppMethodBeat.i(25870);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cjn localcjn = (cjn)paramLinkedList.next();
      if (!bo.isNullOrNil(localcjn.jJA)) {
        localLinkedList.add(localcjn);
      }
    }
    AppMethodBeat.o(25870);
    return localLinkedList;
  }
  
  private static LinkedList<cjm> ax(LinkedList<cjm> paramLinkedList)
  {
    AppMethodBeat.i(25871);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((cjm)paramLinkedList.next());
    }
    AppMethodBeat.o(25871);
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
    AppMethodBeat.i(25868);
    ab.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25868);
    return i;
  }
  
  public final int getType()
  {
    return 332;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25869);
    ab.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25869);
      return;
    }
    paramq = (zw)this.rr.fsW.fta;
    ab.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { paramq.toString() });
    this.nMZ = paramq.wQP;
    this.nNa = paramq.wQQ;
    this.tcT = paramq.wQR;
    this.tcU = paramq.wQT;
    this.tdp = aw(paramq.wov);
    this.tcW = ax(paramq.wtb);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */