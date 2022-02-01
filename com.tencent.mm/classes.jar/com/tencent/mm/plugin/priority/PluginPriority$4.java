package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bu;

final class PluginPriority$4
  implements n.b
{
  PluginPriority$4(PluginPriority paramPluginPriority) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(87768);
    paramn = (String)paramObject;
    if (bu.isNullOrNil(paramn))
    {
      AppMethodBeat.o(87768);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(87768);
      return;
      if (this.xaD.getPriorityTaskRunner() != null) {
        this.xaD.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.d(paramn));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority.4
 * JD-Core Version:    0.7.0.1
 */