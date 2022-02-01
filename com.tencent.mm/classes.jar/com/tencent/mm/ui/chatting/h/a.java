package com.tencent.mm.ui.chatting.h;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.l.b;
import com.tencent.mm.ui.chatting.n.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<ca>
{
  private SparseArray<ca> PDv;
  private com.tencent.mm.ui.chatting.e.a dom;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, SparseArray<ca> paramSparseArray)
  {
    this.dom = parama;
    this.PDv = paramSparseArray;
  }
  
  public final void a(final d.a parama, final f<ca> paramf, final d.d<ca> paramd, final d.b paramb)
  {
    AppMethodBeat.i(36418);
    Object localObject = b.PEW;
    switch (com.tencent.mm.ui.chatting.l.b.1.PEY[paramd.PDL.ordinal()])
    {
    }
    while (paramf == null)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.next();
      AppMethodBeat.o(36418);
      return;
      localObject = ((b)localObject).PEX;
      localObject[0] += 1;
      continue;
      localObject = ((b)localObject).PEX;
      localObject[1] += 1;
      continue;
      localObject = ((b)localObject).PEX;
      localObject[2] += 1;
      continue;
      if ((paramd.PDK != null) && (paramd.PDK.getInt("SCENE") == 1))
      {
        localObject = ((b)localObject).PEX;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((b)localObject).PEX;
        localObject[4] += 1;
      }
    }
    paramf.a(new d.b()
    {
      public final void next()
      {
        AppMethodBeat.i(36417);
        paramf.jA(paramd.PDM);
        paramf.close();
        paramd.gAZ = paramf.cZm();
        paramd.PDN = paramd.PDM.size();
        Log.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + parama + " addCount:" + paramd.PDN + " totalCount:" + paramd.gAZ);
        paramb.next();
        AppMethodBeat.o(36417);
      }
    });
    AppMethodBeat.o(36418);
  }
  
  public final SparseArray<ca> jv(List<ca> paramList)
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
      if ((((List)localObject).size() > 0) && (this.dom != null))
      {
        paramList = this.dom.getTalkerUserName();
        localca = (ca)((List)localObject).get(0);
        if ((localca != null) && (!Util.isNullOrNil(paramList)) && (!Util.isNullOrNil(localca.field_talker)) && (!Util.isEqual(localca.field_talker, paramList)))
        {
          Log.i("MicroMsg.ChattingLoader.ChattingDataCallback", "talker not equal, chattingContextTalker:%s, msgInfoTalker:%s", new Object[] { localca.field_talker, paramList });
          h.CyF.a(18264, new Object[] { localca.field_talker, paramList });
          h.CyF.n(1151L, 0L, 1L);
          paramList = this.PDv;
          AppMethodBeat.o(36419);
          return paramList;
        }
      }
    }
    catch (Throwable paramList)
    {
      ca localca;
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingDataCallback", paramList, "fillData Exception", new Object[0]);
      h.CyF.n(1151L, 1L, 1L);
      this.PDv.clear();
      paramList = ((List)localObject).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localObject = this.PDv;
        localca = (ca)paramList.next();
        ((SparseArray)localObject).put(i, localca);
        int j = i + 1;
        i = j;
        if (localca != null)
        {
          i = j;
          if (localca.isText())
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
      paramList = this.PDv;
      AppMethodBeat.o(36419);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */