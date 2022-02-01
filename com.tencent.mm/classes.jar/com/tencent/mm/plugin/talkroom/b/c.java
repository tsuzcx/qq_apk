package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  public int BFF;
  public LinkedList<dnb> BGa;
  private com.tencent.mm.ak.f callback;
  private final b rr;
  private int sceneType;
  private final String vpL;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29557);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bju();
    ((b.a)localObject).hQG = new bjv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((b.a)localObject).funcId = 336;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bju)this.rr.hQD.hQJ;
    ((bju)localObject).Gxq = paramInt1;
    ((bju)localObject).Gxr = paramLong;
    this.vpL = paramString;
    ((bju)localObject).Scene = paramInt2;
    AppMethodBeat.o(29557);
  }
  
  private static LinkedList<dnb> aW(LinkedList<dnb> paramLinkedList)
  {
    AppMethodBeat.i(29560);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dnb localdnb = (dnb)paramLinkedList.next();
      if (!bu.isNullOrNil(localdnb.nIJ)) {
        localLinkedList.add(localdnb);
      }
    }
    AppMethodBeat.o(29560);
    return localLinkedList;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(29558);
    ae.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29558);
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
    return 336;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29559);
    ae.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29559);
      return;
    }
    paramq = (bjv)this.rr.hQE.hQJ;
    ae.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { paramq.toString() });
    this.BFF = paramq.Gxs;
    this.BGa = aW(paramq.FNl);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */