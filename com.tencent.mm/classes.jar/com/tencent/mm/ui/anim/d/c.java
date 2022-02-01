package com.tencent.mm.ui.anim.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/inout/AnimOutAction;", "Lcom/tencent/mm/ui/anim/inout/AnimVisibilityAction;", "outEndStatus", "", "(I)V", "getOutEndStatus", "()I", "afterAnim", "", "beforeAnim", "checkAnimEnd", "", "getInterpolator", "Landroid/view/animation/Interpolator;", "inAnimate", "viewPropertyAnimator", "Landroid/view/ViewPropertyAnimator;", "plus", "otherAction", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends d
{
  private final int adMI;
  
  public c(int paramInt)
  {
    this.adMI = paramInt;
  }
  
  public final c a(c paramc)
  {
    s.u(paramc, "otherAction");
    Object localObject2 = jlI();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramc.jlI();
    }
    a((e)localObject1);
    localObject2 = jlJ();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramc.jlJ();
    }
    a((h)localObject1);
    localObject2 = jlK();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramc.jlK();
    }
    a((o)localObject1);
    return this;
  }
  
  public final void a(ViewPropertyAnimator paramViewPropertyAnimator)
  {
    s.u(paramViewPropertyAnimator, "viewPropertyAnimator");
    Object localObject = jlI();
    if (localObject != null) {
      paramViewPropertyAnimator.alpha(((e)localObject).alpha);
    }
    localObject = jlJ();
    if (localObject != null)
    {
      paramViewPropertyAnimator.scaleX(((h)localObject).scaleX);
      paramViewPropertyAnimator.scaleY(((h)localObject).scaleY);
    }
    if (jlK() != null) {
      throw null;
    }
  }
  
  public final void aUj() {}
  
  public final Interpolator getInterpolator()
  {
    return super.getInterpolator();
  }
  
  public final boolean jlF()
  {
    View localView = getView();
    return (localView != null) && (localView.getVisibility() == this.adMI);
  }
  
  public final void jlH()
  {
    View localView = getView();
    if (localView != null) {
      localView.setVisibility(this.adMI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.anim.d.c
 * JD-Core Version:    0.7.0.1
 */