package com.tencent.mm.ui.vas.c;

import android.animation.Animator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/page/VASPageAnim;", "", "mDuration", "", "(J)V", "getMDuration", "()J", "getAnimator", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "vWidth", "", "vHeight", "animParam", "Lcom/tencent/mm/ui/vas/page/VASPageAnimParam;", "getHideAnimator", "commonTitle", "Lcom/tencent/mm/ui/vas/page/ICommonAnimTitle;", "getShowAnimator", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class f
{
  public static final f.a afRh;
  private final long mDuration = 300L;
  
  static
  {
    AppMethodBeat.i(249966);
    afRh = new f.a((byte)0);
    AppMethodBeat.o(249966);
  }
  
  public Animator a(View paramView, int paramInt, g paramg)
  {
    AppMethodBeat.i(249975);
    s.u(paramView, "view");
    s.u(paramg, "animParam");
    AppMethodBeat.o(249975);
    return null;
  }
  
  public final long jEs()
  {
    return this.mDuration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.c.f
 * JD-Core Version:    0.7.0.1
 */