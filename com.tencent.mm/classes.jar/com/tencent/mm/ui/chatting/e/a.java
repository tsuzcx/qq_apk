package com.tencent.mm.ui.chatting.e;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.k.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<bi>
{
  private SparseArray<bi> vxT;
  
  public a(SparseArray<bi> paramSparseArray)
  {
    this.vxT = paramSparseArray;
  }
  
  public final void a(d.a parama, e<bi> parame, d.d<bi> paramd, d.b paramb)
  {
    Object localObject = com.tencent.mm.ui.chatting.i.a.vzl;
    switch (com.tencent.mm.ui.chatting.i.a.1.vzn[paramd.vyj.ordinal()])
    {
    }
    while (parame == null)
    {
      y.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.cN();
      return;
      localObject = ((com.tencent.mm.ui.chatting.i.a)localObject).vzm;
      localObject[0] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.i.a)localObject).vzm;
      localObject[1] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.i.a)localObject).vzm;
      localObject[2] += 1;
      continue;
      if ((paramd.vyi != null) && (paramd.vyi.getInt("SCENE") == 1))
      {
        localObject = ((com.tencent.mm.ui.chatting.i.a)localObject).vzm;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((com.tencent.mm.ui.chatting.i.a)localObject).vzm;
        localObject[4] += 1;
      }
    }
    parame.a(new a.1(this, parame, paramd, parama, paramb));
  }
  
  public final SparseArray<bi> eb(List<bi> paramList)
  {
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      y.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
    }
    this.vxT.clear();
    paramList = ((List)localObject).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      this.vxT.put(i, paramList.next());
      i += 1;
    }
    return this.vxT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.a
 * JD-Core Version:    0.7.0.1
 */