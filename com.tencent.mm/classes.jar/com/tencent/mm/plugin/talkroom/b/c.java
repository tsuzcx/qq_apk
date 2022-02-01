package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.fly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends f
{
  private final String Kgc;
  public int SNS;
  public LinkedList<fly> SOm;
  private h callback;
  private final com.tencent.mm.am.c rr;
  private int sceneType;
  
  public c(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(29557);
    this.sceneType = 0;
    this.sceneType = paramInt2;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cth();
    ((c.a)localObject).otF = new cti();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/gettalkroommember";
    ((c.a)localObject).funcId = 336;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cth)c.b.b(this.rr.otB);
    ((cth)localObject).Zvz = paramInt1;
    ((cth)localObject).ZvA = paramLong;
    this.Kgc = paramString;
    ((cth)localObject).IJG = paramInt2;
    AppMethodBeat.o(29557);
  }
  
  private static LinkedList<fly> bW(LinkedList<fly> paramLinkedList)
  {
    AppMethodBeat.i(29560);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      fly localfly = (fly)paramLinkedList.next();
      if (!Util.isNullOrNil(localfly.UserName)) {
        localLinkedList.add(localfly);
      }
    }
    AppMethodBeat.o(29560);
    return localLinkedList;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29558);
    Log.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29558);
    return i;
  }
  
  public final int getType()
  {
    return 336;
  }
  
  public final String hCL()
  {
    return this.Kgc;
  }
  
  public final int hCM()
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
    params = (cti)c.c.b(this.rr.otC);
    Log.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[] { params.toString() });
    this.SNS = params.ZvB;
    this.SOm = bW(params.YFm);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.c
 * JD-Core Version:    0.7.0.1
 */