package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class h$c
  implements q.f
{
  h$c(h paramh) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(241400);
    paramo.a(1201, (CharSequence)this.Gjb.getContext().getString(b.h.FZP), b.g.bottomsheet_icon_star, this.Gjb.getContext().getResources().getColor(b.b.Brand), false);
    paramo.a(1202, (CharSequence)this.Gjb.getContext().getString(b.h.FZQ), b.g.bottomsheet_icon_star, this.Gjb.getContext().getResources().getColor(b.b.Brand), false);
    AppMethodBeat.o(241400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.h.c
 * JD-Core Version:    0.7.0.1
 */