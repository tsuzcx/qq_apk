package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.g;
import a.l;
import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"unsafeLazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "bind", "Landroid/view/View;", "Landroid/app/Activity;", "idRes", "", "plugin-radar_release"})
public final class i
{
  public static final <T extends View> f<T> ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(103140);
    j.q(paramView, "receiver$0");
    paramView = (a)new i.b(paramView, paramInt);
    paramView = g.a(a.k.BLV, paramView);
    AppMethodBeat.o(103140);
    return paramView;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
  static final class a
    extends a.f.b.k
    implements a<T>
  {
    a(Activity paramActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.i
 * JD-Core Version:    0.7.0.1
 */