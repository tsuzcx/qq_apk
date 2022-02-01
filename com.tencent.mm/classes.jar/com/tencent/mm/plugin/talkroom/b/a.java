package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adj;
import com.tencent.mm.protocal.protobuf.adk;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  private g callback;
  public int roomId;
  private final b rr;
  public long sAY;
  private final String sSF;
  private int sceneType;
  public LinkedList<dbf> yJK;
  public int yJp;
  public int yJq;
  public LinkedList<dbe> yJs;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(29549);
    this.sceneType = 0;
    b.a locala = new b.a();
    this.sceneType = paramInt;
    locala.gUU = new adj();
    locala.gUV = new adk();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.funcId = 332;
    locala.reqCmdId = 147;
    locala.respCmdId = 1000000147;
    this.rr = locala.atI();
    ((adj)this.rr.gUS.gUX).DdY = paramString;
    ((adj)this.rr.gUS.gUX).Scene = paramInt;
    this.sSF = paramString;
    AppMethodBeat.o(29549);
  }
  
  private static LinkedList<dbf> aN(LinkedList<dbf> paramLinkedList)
  {
    AppMethodBeat.i(29552);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dbf localdbf = (dbf)paramLinkedList.next();
      if (!bt.isNullOrNil(localdbf.mAQ)) {
        localLinkedList.add(localdbf);
      }
    }
    AppMethodBeat.o(29552);
    return localLinkedList;
  }
  
  private static LinkedList<dbe> aO(LinkedList<dbe> paramLinkedList)
  {
    AppMethodBeat.i(29553);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((dbe)paramLinkedList.next());
    }
    AppMethodBeat.o(29553);
    return localLinkedList;
  }
  
  public final String dNh()
  {
    return this.sSF;
  }
  
  public final int dNi()
  {
    return this.sceneType;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29550);
    ad.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29550);
    return i;
  }
  
  public final int getType()
  {
    return 332;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29551);
    ad.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29551);
      return;
    }
    paramq = (adk)this.rr.gUT.gUX;
    ad.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { paramq.toString() });
    this.roomId = paramq.DdZ;
    this.sAY = paramq.Dea;
    this.yJp = paramq.Deb;
    this.yJq = paramq.Ded;
    this.yJK = aN(paramq.Cxd);
    this.yJs = aO(paramq.CCG);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */