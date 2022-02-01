package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bu;

final class PluginPriority$3
  implements n.b
{
  PluginPriority$3(PluginPriority paramPluginPriority) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(87767);
    paramn = (String)paramObject;
    if (bu.isNullOrNil(paramn))
    {
      AppMethodBeat.o(87767);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(87767);
      return;
      if (this.xaD.getPriorityTaskRunner() != null) {
        this.xaD.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.d(paramn));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority.3
 * JD-Core Version:    0.7.0.1
 */