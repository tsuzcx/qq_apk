package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  public LinkedList<egs> FQR;
  public int FQw;
  public int FQx;
  public LinkedList<egr> FQz;
  private i callback;
  public int roomId;
  private final d rr;
  private int sceneType;
  private final String yJB;
  public long ypH;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(29549);
    this.sceneType = 0;
    d.a locala = new d.a();
    this.sceneType = paramInt;
    locala.iLN = new ajn();
    locala.iLO = new ajo();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.funcId = 332;
    locala.iLP = 147;
    locala.respCmdId = 1000000147;
    this.rr = locala.aXF();
    ((ajn)this.rr.iLK.iLR).LsY = paramString;
    ((ajn)this.rr.iLK.iLR).Scene = paramInt;
    this.yJB = paramString;
    AppMethodBeat.o(29549);
  }
  
  private static LinkedList<egs> bs(LinkedList<egs> paramLinkedList)
  {
    AppMethodBeat.i(29552);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      egs localegs = (egs)paramLinkedList.next();
      if (!Util.isNullOrNil(localegs.UserName)) {
        localLinkedList.add(localegs);
      }
    }
    AppMethodBeat.o(29552);
    return localLinkedList;
  }
  
  private static LinkedList<egr> bt(LinkedList<egr> paramLinkedList)
  {
    AppMethodBeat.i(29553);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((egr)paramLinkedList.next());
    }
    AppMethodBeat.o(29553);
    return localLinkedList;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29550);
    Log.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29550);
    return i;
  }
  
  public final String fui()
  {
    return this.yJB;
  }
  
  public final int fuj()
  {
    return this.sceneType;
  }
  
  public final int getType()
  {
    return 332;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29551);
    Log.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29551);
      return;
    }
    params = (ajo)this.rr.iLL.iLR;
    Log.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { params.toString() });
    this.roomId = params.LsZ;
    this.ypH = params.Lta;
    this.FQw = params.Ltb;
    this.FQx = params.Ltd;
    this.FQR = bs(params.KGQ);
    this.FQz = bt(params.KMD);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */