package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends m
  implements k
{
  b dmK;
  private f dmL;
  private ArrayList<Long> neh;
  
  public r(ArrayList<Long> paramArrayList)
  {
    this.neh = paramArrayList;
    paramArrayList = new b.a();
    paramArrayList.ecH = new c();
    paramArrayList.ecI = new d();
    paramArrayList.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
    paramArrayList.ecG = 483;
    paramArrayList.ecJ = 0;
    paramArrayList.ecK = 0;
    this.dmK = paramArrayList.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (c)this.dmK.ecE.ecN;
    paramf.hPS = this.neh.size();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.neh.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      h localh = new h();
      localh.ndp = l;
      localLinkedList.add(localh);
      y.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[] { Long.valueOf(l) });
    }
    paramf.ndc = localLinkedList;
    y.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[] { Integer.valueOf(paramf.hPS), Integer.valueOf(paramf.ndc.size()) });
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.dmL != null)) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    while (this.dmL == null) {
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 483;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.r
 * JD-Core Version:    0.7.0.1
 */