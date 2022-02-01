package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  implements g
{
  public final void HR(long paramLong)
  {
    AppMethodBeat.i(27804);
    ao.gnh();
    an.a.HR(paramLong);
    AppMethodBeat.o(27804);
  }
  
  public final boolean h(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27805);
    Object localObject = p.aKY(paramString1);
    if (localObject == null)
    {
      Log.w("MicroMsg.RecordMsgHelpService", "get record msg data error, empty");
      AppMethodBeat.o(27805);
      return false;
    }
    paramString1 = null;
    Iterator localIterator = ((c)localObject).iAd.iterator();
    if (localIterator.hasNext())
    {
      localObject = (aml)localIterator.next();
      if (!((aml)localObject).dLl.equals(paramString2)) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.m
 * JD-Core Version:    0.7.0.1
 */