package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  public LinkedList<egs> FQR;
  public int FQw;
  private i callback;
  private final d rr;
  private int sceneType;
  private final String yJB;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29557);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bvz();
    ((d.a)localObject).iLO = new bwa();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((d.a)localObject).funcId = 336;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bvz)this.rr.iLK.iLR;
    ((bvz)localObject).LsZ = paramInt1;
    ((bvz)localObject).Lta = paramLong;
    this.yJB = paramString;
    ((bvz)localObject).Scene = paramInt2;
    AppMethodBeat.o(29557);
  }
  
  private static LinkedList<egs> bs(LinkedList<egs> paramLinkedList)
  {
    AppMethodBeat.i(29560);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      egs localegs = (egs)paramLinkedList.next();
      if (!Util.isNullOrNil(localegs.UserName)) {
        localLinkedList.add(localegs);
      }
    }
    AppMethodBeat.o(29560);
    return localLinkedList;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29558);
    Log.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29558);
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
    return 336;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29559);
    Log.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29559);
      return;
    }
    params = (bwa)this.rr.iLL.iLR;
    Log.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { params.toString() });
    this.FQw = params.Ltb;
    this.FQR = bs(params.KGQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */