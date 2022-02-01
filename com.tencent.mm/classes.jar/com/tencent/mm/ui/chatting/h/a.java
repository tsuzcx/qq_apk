package com.tencent.mm.ui.chatting.h;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.m.b;
import com.tencent.mm.ui.chatting.o.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<ca>
{
  private SparseArray<ca> WYi;
  private com.tencent.mm.ui.chatting.e.a fgR;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, SparseArray<ca> paramSparseArray)
  {
    this.fgR = parama;
    this.WYi = paramSparseArray;
  }
  
  public final void a(final d.a parama, final g<ca> paramg, final d.d<ca> paramd, final d.b paramb)
  {
    AppMethodBeat.i(36418);
    Object localObject = b.WZI;
    switch (com.tencent.mm.ui.chatting.m.b.1.WZK[paramd.WYy.ordinal()])
    {
    }
    while (paramg == null)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.next();
      AppMethodBeat.o(36418);
      return;
      localObject = ((b)localObject).WZJ;
      localObject[0] += 1;
      continue;
      localObject = ((b)localObject).WZJ;
      localObject[1] += 1;
      continue;
      localObject = ((b)localObject).WZJ;
      localObject[2] += 1;
      continue;
      if ((paramd.WYx != null) && (paramd.WYx.getInt("SCENE") == 1))
      {
        localObject = ((b)localObject).WZJ;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((b)localObject).WZJ;
        localObject[4] += 1;
      }
    }
    paramg.a(new d.b()
    {
      public final void next()
      {
        AppMethodBeat.i(36417);
        paramg.ks(paramd.WYz);
        paramg.close();
        paramd.jlf = paramg.dpe();
        paramd.WYA = paramd.WYz.size();
        Log.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + parama + " addCount:" + paramd.WYA + " totalCount:" + paramd.jlf);
        paramb.next();
        AppMethodBeat.o(36417);
      }
    });
    AppMethodBeat.o(36418);
  }
  
  public final SparseArray<ca> kn(List<ca> paramList)
  {
    AppMethodBeat.i(36419);
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new LinkedList();
      Log.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
    }
    try
    {
      if ((((List)localObject).size() > 0) && (this.fgR != null))
      {
        paramList = this.fgR.getTalkerUserName();
        localca = (ca)((List)localObject).get(0);
        if ((localca != null) && (!Util.isNullOrNil(paramList)) && (!Util.isNullOrNil(localca.field_talker)) && (!Util.isEqual(localca.field_talker, paramList)))
        {
          Log.i("MicroMsg.ChattingLoader.ChattingDataCallback", "talker not equal, chattingContextTalker:%s, msgInfoTalker:%s", new Object[] { localca.field_talker, paramList });
          h.IzE.a(18264, new Object[] { localca.field_talker, paramList });
          h.IzE.p(1151L, 0L, 1L);
          paramList = this.WYi;
          AppMethodBeat.o(36419);
          return paramList;
        }
      }
    }
    catch (Throwable paramList)
    {
      ca localca;
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingDataCallback", paramList, "fillData Exception", new Object[0]);
      h.IzE.p(1151L, 1L, 1L);
      this.WYi.clear();
      paramList = ((List)localObject).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localObject = this.WYi;
        localca = (ca)paramList.next();
        ((SparseArray)localObject).put(i, localca);
        int j = i + 1;
        i = j;
        if (localca != null)
        {
          i = j;
          if (localca.hwH())
          {
            i = j;
            if (localca.field_content != null)
            {
              localca.setContent(localca.field_content.replaceAll("‮", ""));
              i = j;
            }
          }
        }
      }
      paramList = this.WYi;
      AppMethodBeat.o(36419);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */