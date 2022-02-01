package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.eqt;
import com.tencent.mm.protocal.protobuf.equ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends f
{
  public long DPJ;
  private final String Enu;
  public LinkedList<eqt> MkA;
  public LinkedList<equ> MkS;
  public int Mkx;
  public int Mky;
  private i callback;
  public int roomId;
  private final d rr;
  private int sceneType;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(29549);
    this.sceneType = 0;
    d.a locala = new d.a();
    this.sceneType = paramInt;
    locala.lBU = new ako();
    locala.lBV = new akp();
    locala.uri = "/cgi-bin/micromsg-bin/entertalkroom";
    locala.funcId = 332;
    locala.lBW = 147;
    locala.respCmdId = 1000000147;
    this.rr = locala.bgN();
    ((ako)d.b.b(this.rr.lBR)).Svt = paramString;
    ((ako)d.b.b(this.rr.lBR)).CPw = paramInt;
    this.Enu = paramString;
    AppMethodBeat.o(29549);
  }
  
  private static LinkedList<equ> bN(LinkedList<equ> paramLinkedList)
  {
    AppMethodBeat.i(29552);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      equ localequ = (equ)paramLinkedList.next();
      if (!Util.isNullOrNil(localequ.UserName)) {
        localLinkedList.add(localequ);
      }
    }
    AppMethodBeat.o(29552);
    return localLinkedList;
  }
  
  private static LinkedList<eqt> bO(LinkedList<eqt> paramLinkedList)
  {
    AppMethodBeat.i(29553);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add((eqt)paramLinkedList.next());
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
  
  public final int getType()
  {
    return 332;
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
    AppMethodBeat.i(29551);
    Log.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29551);
      return;
    }
    params = (akp)d.c.b(this.rr.lBS);
    Log.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[] { params.toString() });
    this.roomId = params.Svu;
    this.DPJ = params.Svv;
    this.Mkx = params.Svw;
    this.Mky = params.Svy;
    this.MkS = bN(params.RIk);
    this.MkA = bO(params.RNx);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.a
 * JD-Core Version:    0.7.0.1
 */