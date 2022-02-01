package com.tencent.mm.ui.vas.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.anim.e.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/page/RightOut;", "Lcom/tencent/mm/ui/vas/page/VASPageAnim;", "()V", "getAnimator", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "vWidth", "", "vHeight", "animParam", "Lcom/tencent/mm/ui/vas/page/VASPageAnimParam;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f
{
  public static final e afRg;
  
  static
  {
    AppMethodBeat.i(249958);
    afRg = new e();
    AppMethodBeat.o(249958);
  }
  
  private e()
  {
    super((byte)0);
  }
  
  public final Animator a(View paramView, int paramInt, g paramg)
  {
    AppMethodBeat.i(249963);
    s.u(paramView, "view");
    s.u(paramg, "animParam");
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramInt });
    paramView.setDuration(afRg.jEs());
    paramg = c.adMR;
    paramView.setInterpolator((TimeInterpolator)c.jlM());
    paramView = (Animator)paramView;
    AppMethodBeat.o(249963);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.c.e
 * JD-Core Version:    0.7.0.1
 */