package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.pluginsdk.model.app.ak.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  implements f
{
  public final boolean c(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(154671);
    Object localObject = n.XS(paramString1);
    if (localObject == null)
    {
      ab.w("MicroMsg.RecordMsgHelpService", "get record msg data error, empty");
      AppMethodBeat.o(154671);
      return false;
    }
    paramString1 = null;
    Iterator localIterator = ((c)localObject).fjy.iterator();
    if (localIterator.hasNext())
    {
      localObject = (aca)localIterator.next();
      if (!((aca)localObject).mBq.equals(paramString2)) {
        break label99;
      }
      paramString1 = (String)localObject;
    }
    label99:
    for (;;)
    {
      break;
      boolean bool = n.b(paramString1, paramLong, true);
      AppMethodBeat.o(154671);
      return bool;
    }
  }
  
  public final void kW(long paramLong)
  {
    AppMethodBeat.i(24167);
    al.dlN();
    ak.a.kW(paramLong);
    AppMethodBeat.o(24167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k
 * JD-Core Version:    0.7.0.1
 */