package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  public int BFF;
  public int BFG;
  public LinkedList<dna> BFI;
  public LinkedList<dnb> BGa;
  private com.tencent.mm.ak.f callback;
  public int roomId;
  private final b rr;
  private int sceneType;
  public long uXg;
  private final String vpL;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(29549);
    this.sceneType = 0;
    b.a locala = new b.a();
    this.sceneType = paramInt;
    locala.hQF = new ahb();
    locala.hQG = new ahc();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.funcId = 332;
    locala.hQH = 147;
    locala.respCmdId = 1000000147;
    this.rr = locala.aDS();
    ((ahb)this.rr.hQD.hQJ).Gxp = paramString;
    ((ahb)this.rr.hQD.hQJ).Scene = paramInt;
    this.vpL = paramString;
    AppMethodBeat.o(29549);
  }
  
  private static LinkedList<dnb> aW(LinkedList<dnb> paramLinkedList)
  {
    AppMethodBeat.i(29552);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dnb localdnb = (dnb)paramLinkedList.next();
      if (!bu.isNullOrNil(localdnb.nIJ)) {
        localLinkedList.add(localdnb);
      }
    }
    AppMethodBeat.o(29552);
    return localLinkedList;
  }
  
  private static LinkedList<dna> aX(LinkedList<dna> paramLinkedList)
  {
    AppMethodBeat.i(29553);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((dna)paramLinkedList.next());
    }
    AppMethodBeat.o(29553);
    return localLinkedList;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(29550);
    ae.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29550);
    return i;
  }
  
  public final String erF()
  {
    return this.vpL;
  }
  
  public final int erG()
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
    ae.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29551);
      return;
    }
    paramq = (ahc)this.rr.hQE.hQJ;
    ae.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { paramq.toString() });
    this.roomId = paramq.Gxq;
    this.uXg = paramq.Gxr;
    this.BFF = paramq.Gxs;
    this.BFG = paramq.Gxu;
    this.BGa = aW(paramq.FNl);
    this.BFI = aX(paramq.FSU);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */