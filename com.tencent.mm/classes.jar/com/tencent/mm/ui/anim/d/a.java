package com.tencent.mm.ui.anim.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"animIn", "", "Landroid/view/View;", "animInAction", "Lcom/tencent/mm/ui/anim/inout/AnimInAction;", "duration", "", "endListener", "Lkotlin/Function0;", "animOut", "animOutAction", "Lcom/tencent/mm/ui/anim/inout/AnimOutAction;", "crossFade", "target", "crossScale", "crossSlide", "fadeIn", "initAlpha", "", "fadeOut", "outEndStatus", "", "scaleIn", "initScaleX", "initScaleY", "scaleOut", "slideIn", "slideOut", "weui-native-android-lib_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  private static void a(View paramView, b paramb, long paramLong, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(251177);
    s.u(paramView, "<this>");
    s.u(paramb, "animInAction");
    paramb.lb(paramView).a(null, paramLong);
    AppMethodBeat.o(251177);
  }
  
  private static void a(View paramView, c paramc, long paramLong, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(251180);
    s.u(paramView, "<this>");
    s.u(paramc, "animOutAction");
    paramc.lb(paramView).a(null, paramLong);
    AppMethodBeat.o(251180);
  }
  
  public static void kZ(View paramView)
  {
    AppMethodBeat.i(251184);
    s.u(paramView, "<this>");
    a(paramView, (b)new f(0.0F), 300L, null);
    AppMethodBeat.o(251184);
  }
  
  public static void la(View paramView)
  {
    AppMethodBeat.i(251190);
    s.u(paramView, "<this>");
    a(paramView, (c)new g(4), 300L, null);
    AppMethodBeat.o(251190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.anim.d.a
 * JD-Core Version:    0.7.0.1
 */