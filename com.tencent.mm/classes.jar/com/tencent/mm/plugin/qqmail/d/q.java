package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private ArrayList<Long> Hmj;
  private i callback;
  private d rr;
  
  public q(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(122712);
    this.Hmj = paramArrayList;
    paramArrayList = new d.a();
    paramArrayList.lBU = new b();
    paramArrayList.lBV = new c();
    paramArrayList.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
    paramArrayList.funcId = 483;
    paramArrayList.lBW = 0;
    paramArrayList.respCmdId = 0;
    this.rr = paramArrayList.bgN();
    AppMethodBeat.o(122712);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(122714);
    this.callback = parami;
    parami = (b)d.b.b(this.rr.lBR);
    parami.rVx = this.Hmj.size();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.Hmj.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      g localg = new g();
      localg.HlH = l;
      localLinkedList.add(localg);
      Log.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[] { Long.valueOf(l) });
    }
    parami.Hlw = localLinkedList;
    Log.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[] { Integer.valueOf(parami.rVx), Integer.valueOf(parami.Hlw.size()) });
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(122714);
    return i;
  }
  
  public final LinkedList<f> fsq()
  {
    AppMethodBeat.i(249743);
    LinkedList localLinkedList = ((c)d.c.b(this.rr.lBS)).Hlx;
    AppMethodBeat.o(249743);
    return localLinkedList;
  }
  
  public final int getType()
  {
    return 483;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122713);
    Log.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.callback != null))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(122713);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(122713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.q
 * JD-Core Version:    0.7.0.1
 */