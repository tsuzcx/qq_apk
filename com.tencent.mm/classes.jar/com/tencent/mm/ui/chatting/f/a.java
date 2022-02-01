package com.tencent.mm.ui.chatting.f;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.i.b;
import com.tencent.mm.ui.chatting.k.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements c<cc>
{
  private SparseArray<cc> aeHI;
  private com.tencent.mm.ui.chatting.d.a hlc;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, SparseArray<cc> paramSparseArray)
  {
    this.hlc = parama;
    this.aeHI = paramSparseArray;
  }
  
  public final void a(final d.a parama, final g<cc> paramg, final d.d<cc> paramd, final d.b paramb)
  {
    AppMethodBeat.i(36418);
    Object localObject = b.aeJi;
    switch (com.tencent.mm.ui.chatting.i.b.1.aeJk[paramd.aeHY.ordinal()])
    {
    }
    while (paramg == null)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
      paramb.next();
      AppMethodBeat.o(36418);
      return;
      localObject = ((b)localObject).aeJj;
      localObject[0] += 1;
      continue;
      localObject = ((b)localObject).aeJj;
      localObject[1] += 1;
      continue;
      localObject = ((b)localObject).aeJj;
      localObject[2] += 1;
      continue;
      if ((paramd.aeHX != null) && (paramd.aeHX.getInt("SCENE") == 1))
      {
        localObject = ((b)localObject).aeJj;
        localObject[3] += 1;
      }
      else
      {
        localObject = ((b)localObject).aeJj;
        localObject[4] += 1;
      }
    }
    paramg.a(new d.b()
    {
      public final void next()
      {
        AppMethodBeat.i(36417);
        paramg.nI(paramd.aeHZ);
        paramg.close();
        paramd.lNX = paramg.dWF();
        paramd.aeIa = paramd.aeHZ.size();
        Log.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + parama + " addCount:" + paramd.aeIa + " totalCount:" + paramd.lNX);
        paramb.next();
        AppMethodBeat.o(36417);
      }
    });
    AppMethodBeat.o(36418);
  }
  
  public final SparseArray<cc> nD(List<cc> paramList)
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
      if ((((List)localObject).size() > 0) && (this.hlc != null))
      {
        paramList = this.hlc.getTalkerUserName();
        localcc = (cc)((List)localObject).get(0);
        if ((localcc != null) && (!Util.isNullOrNil(paramList)) && (!Util.isNullOrNil(localcc.field_talker)) && (!Util.isEqual(localcc.field_talker, paramList)))
        {
          Log.i("MicroMsg.ChattingLoader.ChattingDataCallback", "talker not equal, chattingContextTalker:%s, msgInfoTalker:%s", new Object[] { localcc.field_talker, paramList });
          h.OAn.b(18264, new Object[] { localcc.field_talker, paramList });
          h.OAn.p(1151L, 0L, 1L);
          paramList = this.aeHI;
          AppMethodBeat.o(36419);
          return paramList;
        }
      }
    }
    finally
    {
      cc localcc;
      Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingDataCallback", paramList, "fillData Exception", new Object[0]);
      h.OAn.p(1151L, 1L, 1L);
      this.aeHI.clear();
      paramList = ((List)localObject).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localObject = this.aeHI;
        localcc = (cc)paramList.next();
        ((SparseArray)localObject).put(i, localcc);
        int j = i + 1;
        i = j;
        if (localcc != null)
        {
          i = j;
          if (localcc.iYl())
          {
            i = j;
            if (localcc.field_content != null)
            {
              localcc.setContent(localcc.field_content.replaceAll("‮", ""));
              i = j;
            }
          }
        }
      }
      paramList = this.aeHI;
      AppMethodBeat.o(36419);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.a
 * JD-Core Version:    0.7.0.1
 */