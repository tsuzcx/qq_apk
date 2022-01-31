package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends m
  implements k
{
  private f callback;
  private ArrayList<Long> pJx;
  private b rr;
  
  public r(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(67978);
    this.pJx = paramArrayList;
    paramArrayList = new b.a();
    paramArrayList.fsX = new c();
    paramArrayList.fsY = new d();
    paramArrayList.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
    paramArrayList.funcId = 483;
    paramArrayList.reqCmdId = 0;
    paramArrayList.respCmdId = 0;
    this.rr = paramArrayList.ado();
    AppMethodBeat.o(67978);
  }
  
  public final LinkedList<g> cdI()
  {
    return ((d)this.rr.fsW.fta).pIv;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67980);
    this.callback = paramf;
    paramf = (c)this.rr.fsV.fta;
    paramf.jJu = this.pJx.size();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.pJx.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      h localh = new h();
      localh.pIG = l;
      localLinkedList.add(localh);
      ab.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[] { Long.valueOf(l) });
    }
    paramf.pIu = localLinkedList;
    ab.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[] { Integer.valueOf(paramf.jJu), Integer.valueOf(paramf.pIu.size()) });
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(67980);
    return i;
  }
  
  public final int getType()
  {
    return 483;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67979);
    ab.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.callback != null))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(67979);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.r
 * JD-Core Version:    0.7.0.1
 */