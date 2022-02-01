package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.pluginsdk.model.app.ao.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  implements f
{
  public final boolean g(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27805);
    Object localObject = n.aqs(paramString1);
    if (localObject == null)
    {
      ac.w("MicroMsg.RecordMsgHelpService", "get record msg data error, empty");
      AppMethodBeat.o(27805);
      return false;
    }
    paramString1 = null;
    Iterator localIterator = ((c)localObject).hkS.iterator();
    if (localIterator.hasNext())
    {
      localObject = (agx)localIterator.next();
      if (!((agx)localObject).dhw.equals(paramString2)) {
        break label102;
      }
      paramString1 = (String)localObject;
    }
    label102:
    for (;;)
    {
      break;
      boolean bool = n.b(paramString1, paramLong, true);
      AppMethodBeat.o(27805);
      return bool;
    }
  }
  
  public final void wq(long paramLong)
  {
    AppMethodBeat.i(27804);
    ap.eLn();
    ao.a.wq(paramLong);
    AppMethodBeat.o(27804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k
 * JD-Core Version:    0.7.0.1
 */