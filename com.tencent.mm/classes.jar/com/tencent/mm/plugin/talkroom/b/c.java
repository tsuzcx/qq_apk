package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  private g callback;
  private final b rr;
  private final String sSF;
  private int sceneType;
  public LinkedList<dbf> yJK;
  public int yJp;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29557);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bbc();
    ((b.a)localObject).gUV = new bbd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((b.a)localObject).funcId = 336;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bbc)this.rr.gUS.gUX;
    ((bbc)localObject).DdZ = paramInt1;
    ((bbc)localObject).Dea = paramLong;
    this.sSF = paramString;
    ((bbc)localObject).Scene = paramInt2;
    AppMethodBeat.o(29557);
  }
  
  private static LinkedList<dbf> aN(LinkedList<dbf> paramLinkedList)
  {
    AppMethodBeat.i(29560);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dbf localdbf = (dbf)paramLinkedList.next();
      if (!bt.isNullOrNil(localdbf.mAQ)) {
        localLinkedList.add(localdbf);
      }
    }
    AppMethodBeat.o(29560);
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
    AppMethodBeat.i(29558);
    ad.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29558);
    return i;
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
    paramq = (bbd)this.rr.gUT.gUX;
    ad.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { paramq.toString() });
    this.yJp = paramq.Deb;
    this.yJK = aN(paramq.Cxd);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */