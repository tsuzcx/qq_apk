package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  public LinkedList<dme> BoB;
  public int Bog;
  private com.tencent.mm.al.f callback;
  private final b rr;
  private int sceneType;
  private final String vdA;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29557);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bjc();
    ((b.a)localObject).hNN = new bjd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((b.a)localObject).funcId = 336;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bjc)this.rr.hNK.hNQ;
    ((bjc)localObject).GeI = paramInt1;
    ((bjc)localObject).GeJ = paramLong;
    this.vdA = paramString;
    ((bjc)localObject).Scene = paramInt2;
    AppMethodBeat.o(29557);
  }
  
  private static LinkedList<dme> aV(LinkedList<dme> paramLinkedList)
  {
    AppMethodBeat.i(29560);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dme localdme = (dme)paramLinkedList.next();
      if (!bt.isNullOrNil(localdme.nDo)) {
        localLinkedList.add(localdme);
      }
    }
    AppMethodBeat.o(29560);
    return localLinkedList;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(29558);
    ad.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29558);
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
    return 336;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29559);
    ad.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29559);
      return;
    }
    paramq = (bjd)this.rr.hNL.hNQ;
    ad.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { paramq.toString() });
    this.Bog = paramq.GeK;
    this.BoB = aV(paramq.FuN);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */