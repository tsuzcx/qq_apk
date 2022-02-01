package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.protocal.protobuf.flx;
import com.tencent.mm.protocal.protobuf.fly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  public long Hnt;
  private final String Kgc;
  public int SNS;
  public int SNT;
  public LinkedList<flx> SNV;
  public LinkedList<fly> SOm;
  private h callback;
  public int roomId;
  private final c rr;
  private int sceneType;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(29549);
    this.sceneType = 0;
    c.a locala = new c.a();
    this.sceneType = paramInt;
    locala.otE = new any();
    locala.otF = new anz();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.funcId = 332;
    locala.otG = 147;
    locala.respCmdId = 1000000147;
    this.rr = locala.bEF();
    ((any)c.b.b(this.rr.otB)).Zvy = paramString;
    ((any)c.b.b(this.rr.otB)).IJG = paramInt;
    this.Kgc = paramString;
    AppMethodBeat.o(29549);
  }
  
  private static LinkedList<fly> bW(LinkedList<fly> paramLinkedList)
  {
    AppMethodBeat.i(29552);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      fly localfly = (fly)paramLinkedList.next();
      if (!Util.isNullOrNil(localfly.UserName)) {
        localLinkedList.add(localfly);
      }
    }
    AppMethodBeat.o(29552);
    return localLinkedList;
  }
  
  private static LinkedList<flx> bX(LinkedList<flx> paramLinkedList)
  {
    AppMethodBeat.i(29553);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((flx)paramLinkedList.next());
    }
    AppMethodBeat.o(29553);
    return localLinkedList;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29550);
    Log.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[] { Integer.valueOf(this.sceneType) });
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29550);
    return i;
  }
  
  public final int getType()
  {
    return 332;
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
    AppMethodBeat.i(29551);
    Log.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29551);
      return;
    }
    params = (anz)c.c.b(this.rr.otC);
    Log.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { params.toString() });
    this.roomId = params.Zvz;
    this.Hnt = params.ZvA;
    this.SNS = params.ZvB;
    this.SNT = params.ZvD;
    this.SOm = bW(params.YFm);
    this.SNV = bX(params.YKL);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */