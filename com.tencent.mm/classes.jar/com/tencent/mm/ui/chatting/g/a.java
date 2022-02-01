package com.tencent.mm.ui.chatting.g;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.m.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<bl>
{
  private SparseArray<bl> GEL;
  private com.tencent.mm.ui.chatting.d.a cOd;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, SparseArray<bl> paramSparseArray)
  {
    this.cOd = parama;
    this.GEL = paramSparseArray;
  }
  
  public final void a(final d.a parama, final e<bl> parame, final d.d<bl> paramd, final d.b paramb)
  {
    AppMethodBeat.i(36418);
    Object localObject = com.tencent.mm.ui.chatting.k.a.GGh;
    switch (com.tencent.mm.ui.chatting.k.a.1.GGj[paramd.GFc.ordinal()])
    {
    }
    while (parame == null)
    {
      ad.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.next();
      AppMethodBeat.o(36418);
      return;
      localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).GGi;
      localObject[0] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).GGi;
      localObject[1] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).GGi;
      localObject[2] += 1;
      continue;
      if ((paramd.GFb != null) && (paramd.GFb.getInt("SCENE") == 1))
      {
        localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).GGi;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((com.tencent.mm.ui.chatting.k.a)localObject).GGi;
        localObject[4] += 1;
      }
    }
    parame.a(new d.b()
    {
      public final void next()
      {
        AppMethodBeat.i(36417);
        parame.hO(paramd.GFd);
        parame.close();
        paramd.fwP = parame.eKa();
        paramd.GFe = paramd.GFd.size();
        ad.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + parama + " addCount:" + paramd.GFe + " totalCount:" + paramd.fwP);
        paramb.next();
        AppMethodBeat.o(36417);
      }
    });
    AppMethodBeat.o(36418);
  }
  
  public final SparseArray<bl> hJ(List<bl> paramList)
  {
    AppMethodBeat.i(36419);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      ad.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
    }
    try
    {
      if ((((List)localObject).size() > 0) && (this.cOd != null))
      {
        paramList = this.cOd.getTalkerUserName();
        localbl = (bl)((List)localObject).get(0);
        if ((localbl != null) && (!bt.isNullOrNil(paramList)) && (!bt.isNullOrNil(localbl.field_talker)) && (!bt.kU(localbl.field_talker, paramList)))
        {
          ad.i("MicroMsg.ChattingLoader.ChattingDataCallback", "talker not equal, chattingContextTalker:%s, msgInfoTalker:%s", new Object[] { localbl.field_talker, paramList });
          h.vKh.f(18264, new Object[] { localbl.field_talker, paramList });
          h.vKh.m(1151L, 0L, 1L);
          paramList = this.GEL;
          AppMethodBeat.o(36419);
          return paramList;
        }
      }
    }
    catch (Throwable paramList)
    {
      bl localbl;
      ad.printErrStackTrace("MicroMsg.ChattingLoader.ChattingDataCallback", paramList, "fillData Exception", new Object[0]);
      h.vKh.m(1151L, 1L, 1L);
      this.GEL.clear();
      paramList = ((List)localObject).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localObject = this.GEL;
        localbl = (bl)paramList.next();
        ((SparseArray)localObject).put(i, localbl);
        int j = i + 1;
        i = j;
        if (localbl != null)
        {
          i = j;
          if (localbl.isText())
          {
            i = j;
            if (localbl.field_content != null)
            {
              localbl.setContent(localbl.field_content.replaceAll("‮", ""));
              i = j;
            }
          }
        }
      }
      paramList = this.GEL;
      AppMethodBeat.o(36419);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */