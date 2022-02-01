package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private com.tencent.mm.al.b rr;
  private ArrayList<Long> xbX;
  
  public q(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(122712);
    this.xbX = paramArrayList;
    paramArrayList = new b.a();
    paramArrayList.hNM = new b();
    paramArrayList.hNN = new c();
    paramArrayList.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
    paramArrayList.funcId = 483;
    paramArrayList.hNO = 0;
    paramArrayList.respCmdId = 0;
    this.rr = paramArrayList.aDC();
    AppMethodBeat.o(122712);
  }
  
  public final LinkedList<f> dCj()
  {
    return ((c)this.rr.hNL.hNQ).xbk;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(122714);
    this.callback = paramf;
    paramf = (b)this.rr.hNK.hNQ;
    paramf.nDi = this.xbX.size();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.xbX.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      g localg = new g();
      localg.xbt = l;
      localLinkedList.add(localg);
      ad.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[] { Long.valueOf(l) });
    }
    paramf.xbj = localLinkedList;
    ad.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[] { Integer.valueOf(paramf.nDi), Integer.valueOf(paramf.xbj.size()) });
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
    ad.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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