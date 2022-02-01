package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"unsafeLazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "bind", "Landroid/view/View;", "Landroid/app/Activity;", "idRes", "", "plugin-radar_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final <T extends View> j<T> aM(View paramView, final int paramInt)
  {
    AppMethodBeat.i(138793);
    s.u(paramView, "<this>");
    paramView = (a)new b(paramView, paramInt);
    paramView = k.a(o.aiuH, paramView);
    AppMethodBeat.o(138793);
    return paramView;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<T>
  {
    a(Activity paramActivity, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<T>
  {
    b(View paramView, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.e
 * JD-Core Version:    0.7.0.1
 */