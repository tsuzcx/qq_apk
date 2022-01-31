package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;

final class PluginPriority$1
  implements h.a
{
  PluginPriority$1(PluginPriority paramPluginPriority) {}
  
  public final void a(h paramh, h.c paramc)
  {
    AppMethodBeat.i(54866);
    if (paramc.oDP.equals("insert"))
    {
      int i = 0;
      if (i < paramc.oDQ.size())
      {
        paramh = (bi)paramc.oDQ.get(i);
        if ((paramh.field_isSend != 1) && (paramh.dvX())) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            ((b)g.E(b.class)).U(paramh);
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(54866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority.1
 * JD-Core Version:    0.7.0.1
 */