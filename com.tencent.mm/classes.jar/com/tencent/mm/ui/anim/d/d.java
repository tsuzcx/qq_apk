package com.tencent.mm.ui.anim.d;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.tencent.mm.ui.anim.e.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/inout/AnimVisibilityAction;", "", "()V", "fadeData", "Lcom/tencent/mm/ui/anim/inout/FadeData;", "getFadeData", "()Lcom/tencent/mm/ui/anim/inout/FadeData;", "setFadeData", "(Lcom/tencent/mm/ui/anim/inout/FadeData;)V", "scaleData", "Lcom/tencent/mm/ui/anim/inout/ScaleData;", "getScaleData", "()Lcom/tencent/mm/ui/anim/inout/ScaleData;", "setScaleData", "(Lcom/tencent/mm/ui/anim/inout/ScaleData;)V", "slideData", "Lcom/tencent/mm/ui/anim/inout/SlideData;", "getSlideData", "()Lcom/tencent/mm/ui/anim/inout/SlideData;", "setSlideData", "(Lcom/tencent/mm/ui/anim/inout/SlideData;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "afterAnim", "", "anim", "endListener", "Lkotlin/Function0;", "duration", "", "beforeAnim", "beforeAnimExt", "bindView", "checkAnimEnd", "", "getInterpolator", "Landroid/view/animation/Interpolator;", "inAnimate", "viewPropertyAnimator", "Landroid/view/ViewPropertyAnimator;", "Companion", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  public static final d.a adMJ = new d.a((byte)0);
  private e adMK;
  private h adML;
  private o adMM;
  private View view;
  
  private static final void a(d paramd, long paramLong, a parama)
  {
    s.u(paramd, "this$0");
    paramd.jlG();
    Object localObject = paramd.view;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate().setInterpolator((TimeInterpolator)paramd.getInterpolator());
      new StringBuilder("anim() called fadeData:").append(paramd.adMK).append(" scaleData:").append(paramd.adML).append(" slideData:").append(paramd.adMM);
      s.s(localObject, "this");
      paramd.a((ViewPropertyAnimator)localObject);
      ((ViewPropertyAnimator)localObject).withEndAction(new d..ExternalSyntheticLambda1(paramd, parama)).setDuration(paramLong).start();
    }
  }
  
  private static final void a(d paramd, a parama)
  {
    s.u(paramd, "this$0");
    paramd.jlH();
    if (parama != null) {
      parama.invoke();
    }
  }
  
  public abstract void a(ViewPropertyAnimator paramViewPropertyAnimator);
  
  protected final void a(e parame)
  {
    this.adMK = parame;
  }
  
  protected final void a(h paramh)
  {
    this.adML = paramh;
  }
  
  protected final void a(o paramo)
  {
    this.adMM = paramo;
  }
  
  public final void a(a<ah> parama, long paramLong)
  {
    boolean bool = jlF();
    new StringBuilder("anim() called with: endListener = ").append(parama).append(", duration = ").append(paramLong).append(", checkAnimEnd = ").append(bool).append(", obj:").append(this);
    if (bool) {
      if (parama != null) {
        parama.invoke();
      }
    }
    View localView;
    do
    {
      return;
      aUj();
      localView = this.view;
    } while (localView == null);
    localView.post(new d..ExternalSyntheticLambda0(this, paramLong, parama));
  }
  
  public abstract void aUj();
  
  public Interpolator getInterpolator()
  {
    c localc = c.adMR;
    return c.jlL();
  }
  
  protected final View getView()
  {
    return this.view;
  }
  
  public abstract boolean jlF();
  
  public void jlG()
  {
    View localView = this.view;
    float f1;
    float f2;
    label22:
    Object localObject;
    if (localView == null)
    {
      f1 = 0.0F;
      localView = this.view;
      if (localView != null) {
        break label84;
      }
      f2 = 0.0F;
      localView = this.view;
      if (localView != null)
      {
        localObject = this.adML;
        if (localObject != null)
        {
          localObject = ((h)localObject).adMN;
          if (!s.p(localObject, j.adMP)) {
            break label93;
          }
          localView.setPivotX(f1 / 2.0F);
          localView.setPivotY(f2 / 2.0F);
        }
      }
    }
    label84:
    label93:
    do
    {
      return;
      f1 = localView.getMeasuredWidth();
      break;
      f2 = localView.getMeasuredHeight();
      break label22;
      if (s.p(localObject, i.adMO))
      {
        localView.setPivotX(f1 / 2.0F);
        localView.setPivotY(f2);
        return;
      }
    } while (!s.p(localObject, k.adMQ));
    localView.setPivotX(f1 / 2.0F);
    localView.setPivotY(0.0F);
  }
  
  public abstract void jlH();
  
  protected final e jlI()
  {
    return this.adMK;
  }
  
  protected final h jlJ()
  {
    return this.adML;
  }
  
  protected final o jlK()
  {
    return this.adMM;
  }
  
  public final d lb(View paramView)
  {
    s.u(paramView, "view");
    this.view = paramView;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.anim.d.d
 * JD-Core Version:    0.7.0.1
 */