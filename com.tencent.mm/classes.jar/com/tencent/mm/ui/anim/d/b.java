package com.tencent.mm.ui.anim.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/inout/AnimInAction;", "Lcom/tencent/mm/ui/anim/inout/AnimVisibilityAction;", "()V", "afterAnim", "", "beforeAnim", "beforeAnimExt", "checkAnimEnd", "", "inAnimate", "viewPropertyAnimator", "Landroid/view/ViewPropertyAnimator;", "plus", "otherAction", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends d
{
  public final b a(b paramb)
  {
    s.u(paramb, "otherAction");
    Object localObject2 = jlI();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramb.jlI();
    }
    a((e)localObject1);
    localObject2 = jlJ();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramb.jlJ();
    }
    a((h)localObject1);
    localObject2 = jlK();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramb.jlK();
    }
    a((o)localObject1);
    return this;
  }
  
  public final void a(ViewPropertyAnimator paramViewPropertyAnimator)
  {
    s.u(paramViewPropertyAnimator, "viewPropertyAnimator");
    paramViewPropertyAnimator.alpha(1.0F);
    paramViewPropertyAnimator.scaleX(1.0F);
    paramViewPropertyAnimator.scaleY(1.0F);
    paramViewPropertyAnimator.translationX(0.0F);
    paramViewPropertyAnimator.translationY(0.0F);
  }
  
  public final void aUj()
  {
    View localView = getView();
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = getView();
    if (localView != null)
    {
      Object localObject = jlI();
      if (localObject != null) {
        localView.setAlpha(((e)localObject).alpha);
      }
      localObject = jlJ();
      if (localObject != null)
      {
        localView.setScaleX(((h)localObject).scaleX);
        localView.setScaleY(((h)localObject).scaleY);
      }
    }
  }
  
  public final boolean jlF()
  {
    return false;
  }
  
  public final void jlG()
  {
    super.jlG();
    if (getView() != null)
    {
      View localView = getView();
      if (localView != null) {
        localView.getMeasuredWidth();
      }
      localView = getView();
      if (localView != null) {
        localView.getMeasuredHeight();
      }
      if (jlK() != null) {
        throw null;
      }
    }
  }
  
  public final void jlH() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.anim.d.b
 * JD-Core Version:    0.7.0.1
 */