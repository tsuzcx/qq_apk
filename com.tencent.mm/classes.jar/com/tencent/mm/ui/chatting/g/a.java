package com.tencent.mm.ui.chatting.g;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.m.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<bo>
{
  private SparseArray<bo> IeI;
  private com.tencent.mm.ui.chatting.d.a cLy;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, SparseArray<bo> paramSparseArray)
  {
    this.cLy = parama;
    this.IeI = paramSparseArray;
  }
  
  public final void a(final d.a parama, final e<bo> parame, final d.d<bo> paramd, final d.b paramb)
  {
    AppMethodBeat.i(36418);
    Object localObject = com.tencent.mm.ui.chatting.k.a.Igd;
    switch (com.tencent.mm.ui.chatting.k.a.1.Igf[paramd.IeY.ordinal()])
    {
    }
    while (parame == null)
    {
      ac.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.next();
      AppMethodBeat.o(36418);
      return;
      localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).Ige;
      localObject[0] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).Ige;
      localObject[1] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).Ige;
      localObject[2] += 1;
      continue;
      if ((paramd.IeX != null) && (paramd.IeX.getInt("SCENE") == 1))
      {
        localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).Ige;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).Ige;
        localObject[4] += 1;
      }
    }
    parame.a(new d.b()
    {
      public final void next()
      {
        AppMethodBeat.i(36417);
        parame.ib(paramd.IeZ);
        parame.close();
        paramd.fAw = parame.eZx();
        paramd.Ifa = paramd.IeZ.size();
        ac.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + parama + " addCount:" + paramd.Ifa + " totalCount:" + paramd.fAw);
        paramb.next();
        AppMethodBeat.o(36417);
      }
    });
    AppMethodBeat.o(36418);
  }
  
  public final SparseArray<bo> hW(List<bo> paramList)
  {
    AppMethodBeat.i(36419);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      ac.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
    }
    try
    {
      if ((((List)localObject).size() > 0) && (this.cLy != null))
      {
        paramList = this.cLy.getTalkerUserName();
        localbo = (bo)((List)localObject).get(0);
        if ((localbo != null) && (!bs.isNullOrNil(paramList)) && (!bs.isNullOrNil(localbo.field_talker)) && (!bs.lr(localbo.field_talker, paramList)))
        {
          ac.i("MicroMsg.ChattingLoader.ChattingDataCallback", "talker not equal, chattingContextTalker:%s, msgInfoTalker:%s", new Object[] { localbo.field_talker, paramList });
          h.wUl.f(18264, new Object[] { localbo.field_talker, paramList });
          h.wUl.n(1151L, 0L, 1L);
          paramList = this.IeI;
          AppMethodBeat.o(36419);
          return paramList;
        }
      }
    }
    catch (Throwable paramList)
    {
      bo localbo;
      ac.printErrStackTrace("MicroMsg.ChattingLoader.ChattingDataCallback", paramList, "fillData Exception", new Object[0]);
      h.wUl.n(1151L, 1L, 1L);
      this.IeI.clear();
      paramList = ((List)localObject).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localObject = this.IeI;
        localbo = (bo)paramList.next();
        ((SparseArray)localObject).put(i, localbo);
        int j = i + 1;
        i = j;
        if (localbo != null)
        {
          i = j;
          if (localbo.isText())
          {
            i = j;
            if (localbo.field_content != null)
            {
              localbo.setContent(localbo.field_content.replaceAll("‮", ""));
              i = j;
            }
          }
        }
      }
      paramList = this.IeI;
      AppMethodBeat.o(36419);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */