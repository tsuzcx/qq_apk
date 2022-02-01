package com.tencent.mm.plugin.textstatus.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/third/DemoSingleton;", "Lcom/tencent/mm/plugin/textstatus/third/ISpecialViewSingleton;", "()V", "getView", "Landroid/view/View;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getViewAndRefresh", "refreshCallback", "Lkotlin/Function0;", "", "release", "plugin-textstatus_release"})
public final class a
  implements b
{
  public final View a(r paramr)
  {
    AppMethodBeat.i(216329);
    p.h(paramr, "jumpInfo");
    paramr = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216329);
    throw paramr;
  }
  
  public final View a(r paramr, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(216330);
    p.h(paramr, "jumpInfo");
    p.h(parama, "refreshCallback");
    paramr = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216330);
    throw paramr;
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(216331);
    p.h(paramr, "jumpInfo");
    paramr = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216331);
    throw paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.a
 * JD-Core Version:    0.7.0.1
 */