package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"unsafeLazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "bind", "Landroid/view/View;", "Landroid/app/Activity;", "idRes", "", "plugin-radar_release"})
public final class i
{
  public static final <T extends View> f<T> an(View paramView, final int paramInt)
  {
    AppMethodBeat.i(138793);
    d.g.b.k.h(paramView, "$this$bind");
    paramView = (a)new b(paramView, paramInt);
    paramView = g.a(d.k.KTe, paramView);
    AppMethodBeat.o(138793);
    return paramView;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
  static final class a
    extends d.g.b.l
    implements a<T>
  {
    a(Activity paramActivity)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.i
 * JD-Core Version:    0.7.0.1
 */