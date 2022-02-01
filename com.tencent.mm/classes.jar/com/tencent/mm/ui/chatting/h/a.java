package com.tencent.mm.ui.chatting.h;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.n.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<bv>
{
  private SparseArray<bv> Krn;
  private com.tencent.mm.ui.chatting.e.a cXJ;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, SparseArray<bv> paramSparseArray)
  {
    this.cXJ = parama;
    this.Krn = paramSparseArray;
  }
  
  public final void a(final d.a parama, final e<bv> parame, final d.d<bv> paramd, final d.b paramb)
  {
    AppMethodBeat.i(36418);
    Object localObject = com.tencent.mm.ui.chatting.l.a.KsH;
    switch (com.tencent.mm.ui.chatting.l.a.1.KsJ[paramd.KrD.ordinal()])
    {
    }
    while (parame == null)
    {
      ae.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.next();
      AppMethodBeat.o(36418);
      return;
      localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).KsI;
      localObject[0] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).KsI;
      localObject[1] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).KsI;
      localObject[2] += 1;
      continue;
      if ((paramd.KrC != null) && (paramd.KrC.getInt("SCENE") == 1))
      {
        localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).KsI;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).KsI;
        localObject[4] += 1;
      }
    }
    parame.a(new d.b()
    {
      public final void next()
      {
        AppMethodBeat.i(36417);
        parame.ix(paramd.KrE);
        parame.close();
        paramd.fVS = parame.ftv();
        paramd.KrF = paramd.KrE.size();
        ae.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + parama + " addCount:" + paramd.KrF + " totalCount:" + paramd.fVS);
        paramb.next();
        AppMethodBeat.o(36417);
      }
    });
    AppMethodBeat.o(36418);
  }
  
  public final SparseArray<bv> is(List<bv> paramList)
  {
    AppMethodBeat.i(36419);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      ae.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
    }
    try
    {
      if ((((List)localObject).size() > 0) && (this.cXJ != null))
      {
        paramList = this.cXJ.getTalkerUserName();
        localbv = (bv)((List)localObject).get(0);
        if ((localbv != null) && (!bu.isNullOrNil(paramList)) && (!bu.isNullOrNil(localbv.field_talker)) && (!bu.lX(localbv.field_talker, paramList)))
        {
          ae.i("MicroMsg.ChattingLoader.ChattingDataCallback", "talker not equal, chattingContextTalker:%s, msgInfoTalker:%s", new Object[] { localbv.field_talker, paramList });
          g.yxI.f(18264, new Object[] { localbv.field_talker, paramList });
          g.yxI.n(1151L, 0L, 1L);
          paramList = this.Krn;
          AppMethodBeat.o(36419);
          return paramList;
        }
      }
    }
    catch (Throwable paramList)
    {
      bv localbv;
      ae.printErrStackTrace("MicroMsg.ChattingLoader.ChattingDataCallback", paramList, "fillData Exception", new Object[0]);
      g.yxI.n(1151L, 1L, 1L);
      this.Krn.clear();
      paramList = ((List)localObject).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localObject = this.Krn;
        localbv = (bv)paramList.next();
        ((SparseArray)localObject).put(i, localbv);
        int j = i + 1;
        i = j;
        if (localbv != null)
        {
          i = j;
          if (localbv.isText())
          {
            i = j;
            if (localbv.field_content != null)
            {
              localbv.setContent(localbv.field_content.replaceAll("‮", ""));
              i = j;
            }
          }
        }
      }
      paramList = this.Krn;
      AppMethodBeat.o(36419);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */