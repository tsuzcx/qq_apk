package com.tencent.mm.ui.vas.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/page/LeftOut;", "Lcom/tencent/mm/ui/vas/page/VASPageAnim;", "()V", "getAnimator", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "vWidth", "", "vHeight", "animParam", "Lcom/tencent/mm/ui/vas/page/VASPageAnimParam;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f
{
  public static final c afRe;
  
  static
  {
    AppMethodBeat.i(249964);
    afRe = new c();
    AppMethodBeat.o(249964);
  }
  
  private c()
  {
    super((byte)0);
  }
  
  public final Animator a(View paramView, int paramInt, g paramg)
  {
    AppMethodBeat.i(249970);
    s.u(paramView, "view");
    s.u(paramg, "animParam");
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, -paramInt * 0.3F });
    paramView.setDuration(afRe.jEs());
    paramg = com.tencent.mm.ui.anim.e.c.adMR;
    paramView.setInterpolator((TimeInterpolator)com.tencent.mm.ui.anim.e.c.jlM());
    paramView = (Animator)paramView;
    AppMethodBeat.o(249970);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.c.c
 * JD-Core Version:    0.7.0.1
 */