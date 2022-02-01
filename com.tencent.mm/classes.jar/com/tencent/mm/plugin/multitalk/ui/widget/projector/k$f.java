package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.Iterator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class k$f
  implements o.f
{
  k$f(k paramk) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(240015);
    Object localObject = this.zWS.zQw;
    if (localObject != null)
    {
      localObject = ((e)localObject).zWf;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          e.c localc = (e.c)((Iterator)localObject).next();
          paramm.a(localc.zWi, -1, (CharSequence)localc.name);
        }
        AppMethodBeat.o(240015);
        return;
      }
    }
    AppMethodBeat.o(240015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.k.f
 * JD-Core Version:    0.7.0.1
 */