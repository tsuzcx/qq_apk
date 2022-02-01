package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  implements g
{
  public final boolean g(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27805);
    Object localObject = p.awG(paramString1);
    if (localObject == null)
    {
      ae.w("MicroMsg.RecordMsgHelpService", "get record msg data error, empty");
      AppMethodBeat.o(27805);
      return false;
    }
    paramString1 = null;
    Iterator localIterator = ((c)localObject).hFT.iterator();
    if (localIterator.hasNext())
    {
      localObject = (ajx)localIterator.next();
      if (!((ajx)localObject).dua.equals(paramString2)) {
        break label102;
      }
      paramString1 = (String)localObject;
    }
    label102:
    for (;;)
    {
      break;
      boolean bool = p.b(paramString1, paramLong, true);
      AppMethodBeat.o(27805);
      return bool;
    }
  }
  
  public final void zb(long paramLong)
  {
    AppMethodBeat.i(27804);
    ao.fdW();
    an.a.zb(paramLong);
    AppMethodBeat.o(27804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.m
 * JD-Core Version:    0.7.0.1
 */