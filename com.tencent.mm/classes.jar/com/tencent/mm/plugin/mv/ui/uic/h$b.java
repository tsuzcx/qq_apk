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
final class h$b
  implements q.f
{
  h$b(h paramh) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(239895);
    paramo.a(1101, (CharSequence)this.Gjb.getContext().getString(b.h.FZR), b.g.bottomsheet_icon_star, this.Gjb.getContext().getResources().getColor(b.b.Brand), false);
    paramo.a(1102, (CharSequence)this.Gjb.getContext().getString(b.h.FZT), b.g.bottomsheet_icon_star, this.Gjb.getContext().getResources().getColor(b.b.Brand), false);
    paramo.a(1103, (CharSequence)this.Gjb.getContext().getString(b.h.FZV), b.g.bottomsheet_icon_star, this.Gjb.getContext().getResources().getColor(b.b.Brand), false);
    paramo.a(1104, (CharSequence)this.Gjb.getContext().getString(b.h.FZU), b.g.bottomsheet_icon_star, this.Gjb.getContext().getResources().getColor(b.b.Brand), false);
    paramo.a(1105, (CharSequence)this.Gjb.getContext().getString(b.h.FZS), b.g.bottomsheet_icon_star, this.Gjb.getContext().getResources().getColor(b.b.Brand), false);
    AppMethodBeat.o(239895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.h.b
 * JD-Core Version:    0.7.0.1
 */