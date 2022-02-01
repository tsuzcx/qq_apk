package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  public LinkedList<dme> BoB;
  public int Bog;
  public int Boh;
  public LinkedList<dmd> Boj;
  private com.tencent.mm.al.f callback;
  public int roomId;
  private final b rr;
  private int sceneType;
  public long uLt;
  private final String vdA;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(29549);
    this.sceneType = 0;
    b.a locala = new b.a();
    this.sceneType = paramInt;
    locala.hNM = new agr();
    locala.hNN = new ags();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.funcId = 332;
    locala.hNO = 147;
    locala.respCmdId = 1000000147;
    this.rr = locala.aDC();
    ((agr)this.rr.hNK.hNQ).GeH = paramString;
    ((agr)this.rr.hNK.hNQ).Scene = paramInt;
    this.vdA = paramString;
    AppMethodBeat.o(29549);
  }
  
  private static LinkedList<dme> aV(LinkedList<dme> paramLinkedList)
  {
    AppMethodBeat.i(29552);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dme localdme = (dme)paramLinkedList.next();
      if (!bt.isNullOrNil(localdme.nDo)) {
        localLinkedList.add(localdme);
      }
    }
    AppMethodBeat.o(29552);
    return localLinkedList;
  }
  
  private static LinkedList<dmd> aW(LinkedList<dmd> paramLinkedList)
  {
    AppMethodBeat.i(29553);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((dmd)paramLinkedList.next());
    }
    AppMethodBeat.o(29553);
    return localLinkedList;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(29550);
    ad.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29550);
    return i;
  }
  
  public final String enY()
  {
    return this.vdA;
  }
  
  public final int enZ()
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
    ad.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29551);
      return;
    }
    paramq = (ags)this.rr.hNL.hNQ;
    ad.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { paramq.toString() });
    this.roomId = paramq.GeI;
    this.uLt = paramq.GeJ;
    this.Bog = paramq.GeK;
    this.Boh = paramq.GeM;
    this.BoB = aV(paramq.FuN);
    this.Boj = aW(paramq.FAy);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */