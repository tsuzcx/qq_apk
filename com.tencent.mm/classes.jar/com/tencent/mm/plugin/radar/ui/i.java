package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.k;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"unsafeLazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "bind", "Landroid/view/View;", "Landroid/app/Activity;", "idRes", "", "plugin-radar_release"})
public final class i
{
  public static final <T extends View> f<T> ao(View paramView, final int paramInt)
  {
    AppMethodBeat.i(138793);
    p.h(paramView, "$this$bind");
    paramView = (a)new b(paramView, paramInt);
    paramView = g.a(k.MKc, paramView);
    AppMethodBeat.o(138793);
    return paramView;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
  static final class b
    extends q
    implements a<T>
  {
    b(View paramView, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.i
 * JD-Core Version:    0.7.0.1
 */