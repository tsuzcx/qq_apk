package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/CommTeenModeService;", "Lcom/tencent/mm/plugin/comm/api/ICommTeenModeService;", "()V", "isTeenMode", "", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public final boolean aBu()
  {
    AppMethodBeat.i(278879);
    if (h.baz())
    {
      boolean bool = ((d)h.ax(d.class)).aBu();
      AppMethodBeat.o(278879);
      return bool;
    }
    AppMethodBeat.o(278879);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.b
 * JD-Core Version:    0.7.0.1
 */