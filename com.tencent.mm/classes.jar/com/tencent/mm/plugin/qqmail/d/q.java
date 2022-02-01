package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b rr;
  private ArrayList<Long> xrO;
  
  public q(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(122712);
    this.xrO = paramArrayList;
    paramArrayList = new b.a();
    paramArrayList.hQF = new b();
    paramArrayList.hQG = new c();
    paramArrayList.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
    paramArrayList.funcId = 483;
    paramArrayList.hQH = 0;
    paramArrayList.respCmdId = 0;
    this.rr = paramArrayList.aDS();
    AppMethodBeat.o(122712);
  }
  
  public final LinkedList<f> dFA()
  {
    return ((c)this.rr.hQE.hQJ).xrb;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(122714);
    this.callback = paramf;
    paramf = (b)this.rr.hQD.hQJ;
    paramf.nID = this.xrO.size();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.xrO.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      g localg = new g();
      localg.xrk = l;
      localLinkedList.add(localg);
      ae.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[] { Long.valueOf(l) });
    }
    paramf.xra = localLinkedList;
    ae.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[] { Integer.valueOf(paramf.nID), Integer.valueOf(paramf.xra.size()) });
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(122714);
    return i;
  }
  
  public final int getType()
  {
    return 483;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122713);
    ae.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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