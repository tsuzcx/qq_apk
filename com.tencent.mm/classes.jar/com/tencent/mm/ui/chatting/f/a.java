package com.tencent.mm.ui.chatting.f;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.l.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<bi>
{
  private SparseArray<bi> zOo;
  
  public a(SparseArray<bi> paramSparseArray)
  {
    this.zOo = paramSparseArray;
  }
  
  public final void a(d.a parama, e<bi> parame, d.d<bi> paramd, d.b paramb)
  {
    AppMethodBeat.i(32477);
    Object localObject = com.tencent.mm.ui.chatting.j.a.zPI;
    switch (com.tencent.mm.ui.chatting.j.a.1.zPK[paramd.zOE.ordinal()])
    {
    }
    while (parame == null)
    {
      ab.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.next();
      AppMethodBeat.o(32477);
      return;
      localObject = ((com.tencent.mm.ui.chatting.j.a)localObject).zPJ;
      localObject[0] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.j.a)localObject).zPJ;
      localObject[1] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.j.a)localObject).zPJ;
      localObject[2] += 1;
      continue;
      if ((paramd.zOD != null) && (paramd.zOD.getInt("SCENE") == 1))
      {
        localObject = ((com.tencent.mm.ui.chatting.j.a)localObject).zPJ;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((com.tencent.mm.ui.chatting.j.a)localObject).zPJ;
        localObject[4] += 1;
      }
    }
    parame.a(new a.1(this, parame, paramd, parama, paramb));
    AppMethodBeat.o(32477);
  }
  
  public final SparseArray<bi> fl(List<bi> paramList)
  {
    AppMethodBeat.i(32478);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      ab.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
    }
    this.zOo.clear();
    paramList = ((List)localObject).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      this.zOo.put(i, paramList.next());
      i += 1;
    }
    paramList = this.zOo;
    AppMethodBeat.o(32478);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.a
 * JD-Core Version:    0.7.0.1
 */