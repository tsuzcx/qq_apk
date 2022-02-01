package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.equ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  private final String Enu;
  public LinkedList<equ> MkS;
  public int Mkx;
  private i callback;
  private final d rr;
  private int sceneType;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29557);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cdr();
    ((d.a)localObject).lBV = new cds();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((d.a)localObject).funcId = 336;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cdr)d.b.b(this.rr.lBR);
    ((cdr)localObject).Svu = paramInt1;
    ((cdr)localObject).Svv = paramLong;
    this.Enu = paramString;
    ((cdr)localObject).CPw = paramInt2;
    AppMethodBeat.o(29557);
  }
  
  private static LinkedList<equ> bN(LinkedList<equ> paramLinkedList)
  {
    AppMethodBeat.i(29560);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      equ localequ = (equ)paramLinkedList.next();
      if (!Util.isNullOrNil(localequ.UserName)) {
        localLinkedList.add(localequ);
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
  
  public final int getType()
  {
    return 336;
  }
  
  public final String giK()
  {
    return this.Enu;
  }
  
  public final int giL()
  {
    return this.sceneType;
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
    params = (cds)d.c.b(this.rr.lBS);
    Log.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { params.toString() });
    this.Mkx = params.Svw;
    this.MkS = bN(params.RIk);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */