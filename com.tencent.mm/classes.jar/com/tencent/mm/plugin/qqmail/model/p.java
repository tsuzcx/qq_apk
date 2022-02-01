package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private ArrayList<Long> NjX;
  private h callback;
  private c rr;
  
  public p(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(122712);
    this.NjX = paramArrayList;
    paramArrayList = new c.a();
    paramArrayList.otE = new a();
    paramArrayList.otF = new b();
    paramArrayList.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
    paramArrayList.funcId = 483;
    paramArrayList.otG = 0;
    paramArrayList.respCmdId = 0;
    this.rr = paramArrayList.bEF();
    AppMethodBeat.o(122712);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(122714);
    this.callback = paramh;
    paramh = (a)c.b.b(this.rr.otB);
    paramh.vgN = this.NjX.size();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.NjX.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      f localf = new f();
      localf.Njv = l;
      localLinkedList.add(localf);
      Log.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[] { Long.valueOf(l) });
    }
    paramh.Njk = localLinkedList;
    Log.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[] { Integer.valueOf(paramh.vgN), Integer.valueOf(paramh.Njk.size()) });
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(122714);
    return i;
  }
  
  public final LinkedList<e> gDY()
  {
    AppMethodBeat.i(267077);
    LinkedList localLinkedList = ((b)c.c.b(this.rr.otC)).Njl;
    AppMethodBeat.o(267077);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.p
 * JD-Core Version:    0.7.0.1
 */