package com.tencent.mm.ui.vas;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.vas.c.f;
import com.tencent.mm.ui.vas.c.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASPageAnimManager;", "", "()V", "TAG", "", "isPopEnterNoAnim", "", "()Z", "setPopEnterNoAnim", "(Z)V", "isPopExitNoAnim", "setPopExitNoAnim", "lastExitActionBarData", "Lcom/tencent/mm/ui/vas/actionbar/VasActionBarData;", "getLastExitActionBarData", "()Lcom/tencent/mm/ui/vas/actionbar/VasActionBarData;", "setLastExitActionBarData", "(Lcom/tencent/mm/ui/vas/actionbar/VasActionBarData;)V", "createAnimForFragment", "Landroid/animation/Animator;", "Lcom/tencent/mm/ui/vas/VASCommonFragment;", "transit", "", "enter", "nextAnim", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e afQO;
  private static com.tencent.mm.ui.vas.a.a afQP;
  private static boolean afQQ;
  private static boolean afQR;
  
  static
  {
    AppMethodBeat.i(249926);
    afQO = new e();
    AppMethodBeat.o(249926);
  }
  
  public static Animator a(final VASCommonFragment paramVASCommonFragment, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(249921);
    s.u(paramVASCommonFragment, "<this>");
    Object localObject3 = paramVASCommonFragment.jEo().getParent();
    if (localObject3 == null)
    {
      paramVASCommonFragment = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(249921);
      throw paramVASCommonFragment;
    }
    int i = ((View)localObject3).getMeasuredWidth();
    localObject3 = paramVASCommonFragment.jEo().getParent();
    if (localObject3 == null)
    {
      paramVASCommonFragment = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(249921);
      throw paramVASCommonFragment;
    }
    ((View)localObject3).getMeasuredHeight();
    if (paramInt == a.a.vas_anim_enter_holder)
    {
      s.X("createAnimForFragment() vas_anim_enter_holder enterAnim:", paramVASCommonFragment.afQp);
      localObject1 = paramVASCommonFragment.afQn;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = new g();
        ((g)localObject2).afRk = ((com.tencent.mm.ui.vas.a.a)localObject1);
        ((g)localObject2).afRj = afQP;
        ((g)localObject2).afRl = paramVASCommonFragment.jEm();
        localObject1 = paramVASCommonFragment.afQp.a(paramVASCommonFragment.jEo(), i, (g)localObject2);
      }
    }
    do
    {
      if ((localObject1 instanceof ValueAnimator)) {
        ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new a(paramInt, paramVASCommonFragment, (Animator)localObject1));
      }
      AppMethodBeat.o(249921);
      return localObject1;
      localObject1 = ((VASActivity)localObject1).getActionBarData();
      break;
      if (paramInt == a.a.vas_anim_exit_holder)
      {
        s.X("createAnimForFragment() vas_anim_exit_holder exitAnim:", paramVASCommonFragment.afQq);
        localObject2 = paramVASCommonFragment.afQn;
        if (localObject2 == null) {}
        for (;;)
        {
          afQP = (com.tencent.mm.ui.vas.a.a)localObject1;
          localObject1 = f.a(paramVASCommonFragment.afQq, paramVASCommonFragment.jEo(), i);
          break;
          localObject1 = ((VASActivity)localObject2).getActionBarData();
        }
      }
      if (paramInt == a.a.vas_anim_pop_enter_holder)
      {
        s.X("createAnimForFragment() vas_anim_pop_enter_holder popEnterAnim:", paramVASCommonFragment.afQr);
        localObject1 = paramVASCommonFragment.afQn;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((VASActivity)localObject1).getActionBarData())
        {
          localObject3 = new g();
          ((g)localObject3).afRk = ((com.tencent.mm.ui.vas.a.a)localObject1);
          ((g)localObject3).afRj = afQP;
          ((g)localObject3).afRl = paramVASCommonFragment.jEm();
          localObject3 = paramVASCommonFragment.afQr.a(paramVASCommonFragment.jEo(), i, (g)localObject3);
          localObject1 = localObject2;
          if (localObject3 == null) {
            break;
          }
          if (afQQ)
          {
            afQQ = false;
            ((Animator)localObject3).setDuration(0L);
          }
          localObject1 = localObject3;
          break;
        }
      }
      localObject1 = localObject2;
    } while (paramInt != a.a.vas_anim_pop_exit_holder);
    localObject1 = paramVASCommonFragment.afQn;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((VASActivity)localObject1).getActionBarData())
    {
      afQP = (com.tencent.mm.ui.vas.a.a)localObject1;
      s.X("createAnimForFragment() vas_anim_pop_exit_holder popExitAnim:", paramVASCommonFragment.afQs);
      localObject3 = f.a(paramVASCommonFragment.afQs, paramVASCommonFragment.jEo(), i);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      if (afQR)
      {
        afQR = false;
        ((Animator)localObject3).setDuration(0L);
      }
      localObject1 = localObject3;
      break;
    }
  }
  
  public static void jEp()
  {
    afQQ = true;
  }
  
  public static void jEq()
  {
    afQR = true;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/vas/VASPageAnimManager$createAnimForFragment$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(int paramInt, VASCommonFragment paramVASCommonFragment, Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(249992);
      super.onAnimationEnd(paramAnimator, paramBoolean);
      new StringBuilder("onAnimationEnd() called with: animation = ").append(paramAnimator).append(", isReverse = ").append(paramBoolean);
      com.tencent.mm.ui.vas.d.a locala;
      if (this.afQS == a.a.vas_anim_enter_holder)
      {
        locala = MMFragmentActivity.aReporter;
        paramAnimator = paramVASCommonFragment.afQn;
        if (paramAnimator != null) {
          break label105;
        }
      }
      label105:
      for (paramAnimator = null;; paramAnimator = paramAnimator.getIntent())
      {
        locala.bt(paramAnimator);
        paramAnimator = paramVASCommonFragment.afQn;
        if (paramAnimator != null) {
          paramAnimator.onPageAnimEnd();
        }
        ((ValueAnimator)this.afQU).removeListener((Animator.AnimatorListener)this);
        AppMethodBeat.o(249992);
        return;
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(249985);
      super.onAnimationStart(paramAnimator, paramBoolean);
      com.tencent.mm.ui.vas.d.a locala;
      if (this.afQS == a.a.vas_anim_enter_holder)
      {
        locala = MMFragmentActivity.aReporter;
        paramAnimator = paramVASCommonFragment.afQn;
        if (paramAnimator != null) {
          break label71;
        }
      }
      label71:
      for (paramAnimator = null;; paramAnimator = paramAnimator.getIntent())
      {
        locala.a(paramAnimator, System.currentTimeMillis());
        paramAnimator = paramVASCommonFragment.afQn;
        if (paramAnimator != null) {
          paramAnimator.onPageAnimStart();
        }
        AppMethodBeat.o(249985);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.e
 * JD-Core Version:    0.7.0.1
 */