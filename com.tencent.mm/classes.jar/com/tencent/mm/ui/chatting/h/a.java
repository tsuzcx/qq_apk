package com.tencent.mm.ui.chatting.h;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.n.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<bu>
{
  private SparseArray<bu> JUV;
  private com.tencent.mm.ui.chatting.e.a cWM;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, SparseArray<bu> paramSparseArray)
  {
    this.cWM = parama;
    this.JUV = paramSparseArray;
  }
  
  public final void a(final d.a parama, final e<bu> parame, final d.d<bu> paramd, final d.b paramb)
  {
    AppMethodBeat.i(36418);
    Object localObject = com.tencent.mm.ui.chatting.l.a.JWq;
    switch (com.tencent.mm.ui.chatting.l.a.1.JWs[paramd.JVl.ordinal()])
    {
    }
    while (parame == null)
    {
      ad.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.next();
      AppMethodBeat.o(36418);
      return;
      localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).JWr;
      localObject[0] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).JWr;
      localObject[1] += 1;
      continue;
      localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).JWr;
      localObject[2] += 1;
      continue;
      if ((paramd.JVk != null) && (paramd.JVk.getInt("SCENE") == 1))
      {
        localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).JWr;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((com.tencent.mm.ui.chatting.l.a)localObject).JWr;
        localObject[4] += 1;
      }
    }
    parame.a(new d.b()
    {
      public final void next()
      {
        AppMethodBeat.i(36417);
        parame.in(paramd.JVm);
        parame.close();
        paramd.fTM = parame.fpw();
        paramd.JVn = paramd.JVm.size();
        ad.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + parama + " addCount:" + paramd.JVn + " totalCount:" + paramd.fTM);
        paramb.next();
        AppMethodBeat.o(36417);
      }
    });
    AppMethodBeat.o(36418);
  }
  
  public final SparseArray<bu> ii(List<bu> paramList)
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
      if ((((List)localObject).size() > 0) && (this.cWM != null))
      {
        paramList = this.cWM.getTalkerUserName();
        localbu = (bu)((List)localObject).get(0);
        if ((localbu != null) && (!bt.isNullOrNil(paramList)) && (!bt.isNullOrNil(localbu.field_talker)) && (!bt.lQ(localbu.field_talker, paramList)))
        {
          ad.i("MicroMsg.ChattingLoader.ChattingDataCallback", "talker not equal, chattingContextTalker:%s, msgInfoTalker:%s", new Object[] { localbu.field_talker, paramList });
          g.yhR.f(18264, new Object[] { localbu.field_talker, paramList });
          g.yhR.n(1151L, 0L, 1L);
          paramList = this.JUV;
          AppMethodBeat.o(36419);
          return paramList;
        }
      }
    }
    catch (Throwable paramList)
    {
      bu localbu;
      ad.printErrStackTrace("MicroMsg.ChattingLoader.ChattingDataCallback", paramList, "fillData Exception", new Object[0]);
      g.yhR.n(1151L, 1L, 1L);
      this.JUV.clear();
      paramList = ((List)localObject).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localObject = this.JUV;
        localbu = (bu)paramList.next();
        ((SparseArray)localObject).put(i, localbu);
        int j = i + 1;
        i = j;
        if (localbu != null)
        {
          i = j;
          if (localbu.isText())
          {
            i = j;
            if (localbu.field_content != null)
            {
              localbu.setContent(localbu.field_content.replaceAll("‮", ""));
              i = j;
            }
          }
        }
      }
      paramList = this.JUV;
      AppMethodBeat.o(36419);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */