package com.tencent.mm.ui.anim.b;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.e.a.b.b;
import androidx.e.a.d;
import androidx.e.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"fade", "", "Landroid/view/View;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "endListener", "Lkotlin/Function0;", "scaleHorizontally", "slideHorizontally", "Lkotlin/ranges/IntRange;", "spring", "property", "Lcom/tencent/mm/ui/anim/basic/SpringProperty;", "startVelocity", "", "finalPosition", "dampingRatio", "stiffness", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationEndListener;", "weui-native-android-lib_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void a(View paramView, b paramb, float paramFloat, b.b paramb1)
  {
    AppMethodBeat.i(251200);
    s.u(paramView, "<this>");
    s.u(paramb, "property");
    e locale = new e(1.0F).ax(0.5F).aw(200.0F);
    int i = bd.fromDPToPix(paramView.getContext(), (int)paramFloat);
    paramView = (d)new d(paramView, paramb.jly()).au(paramb.jlz());
    paramView.bzy = locale;
    paramView.bzn = i;
    paramView = (d)paramView;
    if (paramb1 != null) {
      paramView.a(paramb1);
    }
    paramView.start();
    AppMethodBeat.o(251200);
  }
  
  public static final void a(View paramView, kotlin.k.c<Double> paramc, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(251189);
    s.u(paramView, "<this>");
    s.u(paramc, "range");
    paramView.setAlpha((float)((Number)paramc.klJ()).doubleValue());
    paramView = paramView.animate().alpha((float)((Number)paramc.klK()).doubleValue());
    paramc = com.tencent.mm.ui.anim.e.c.adMR;
    paramc = paramView.setInterpolator((TimeInterpolator)com.tencent.mm.ui.anim.e.c.jlL());
    if (parama == null) {}
    for (paramView = null;; paramView = new a..ExternalSyntheticLambda0(parama))
    {
      paramc.withEndAction(paramView).start();
      AppMethodBeat.o(251189);
      return;
    }
  }
  
  private static final void cd(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(251202);
    parama.invoke();
    AppMethodBeat.o(251202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.anim.b.a
 * JD-Core Version:    0.7.0.1
 */