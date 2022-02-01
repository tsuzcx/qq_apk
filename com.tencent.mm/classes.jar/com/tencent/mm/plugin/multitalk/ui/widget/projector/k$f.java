package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class k$f
  implements q.f
{
  k$f(k paramk) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(199719);
    Object localObject = this.FCA.FvZ;
    if (localObject != null)
    {
      localObject = ((e)localObject).FBO;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          e.c localc = (e.c)((Iterator)localObject).next();
          paramo.a(localc.FBR, -1, (CharSequence)localc.name);
        }
        AppMethodBeat.o(199719);
        return;
      }
    }
    AppMethodBeat.o(199719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.k.f
 * JD-Core Version:    0.7.0.1
 */