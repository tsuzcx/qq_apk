package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"unsafeLazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "bind", "Landroid/view/View;", "Landroid/app/Activity;", "idRes", "", "plugin-radar_release"})
public final class i
{
  public static final <T extends View> f<T> am(View paramView, final int paramInt)
  {
    AppMethodBeat.i(138793);
    d.g.b.k.h(paramView, "$this$bind");
    paramView = (a)new b(paramView, paramInt);
    paramView = g.a(d.k.JfK, paramView);
    AppMethodBeat.o(138793);
    return paramView;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
  static final class b
    extends d.g.b.l
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