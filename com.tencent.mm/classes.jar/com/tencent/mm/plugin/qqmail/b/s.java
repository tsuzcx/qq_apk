package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private b rr;
  private ArrayList<Long> vUG;
  
  public s(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(122712);
    this.vUG = paramArrayList;
    paramArrayList = new b.a();
    paramArrayList.hvt = new c();
    paramArrayList.hvu = new d();
    paramArrayList.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
    paramArrayList.funcId = 483;
    paramArrayList.reqCmdId = 0;
    paramArrayList.respCmdId = 0;
    this.rr = paramArrayList.aAz();
    AppMethodBeat.o(122712);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(122714);
    this.callback = paramg;
    paramg = (c)this.rr.hvr.hvw;
    paramg.ncL = this.vUG.size();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.vUG.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      h localh = new h();
      localh.vTQ = l;
      localLinkedList.add(localh);
      ac.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[] { Long.valueOf(l) });
    }
    paramg.vTF = localLinkedList;
    ac.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[] { Integer.valueOf(paramg.ncL), Integer.valueOf(paramg.vTF.size()) });
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(122714);
    return i;
  }
  
  public final LinkedList<g> drI()
  {
    return ((d)this.rr.hvs.hvw).vTG;
  }
  
  public final int getType()
  {
    return 483;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122713);
    ac.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.s
 * JD-Core Version:    0.7.0.1
 */