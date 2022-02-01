package com.tencent.mm.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/WeUISlideAnimHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "HEIGHT", "", "getHEIGHT", "()F", "WIDTH", "getWIDTH", "mContext", "getMContext", "()Landroid/content/Context;", "slideFromLeftAnim", "Landroid/animation/ObjectAnimator;", "slideFromLeftListener", "Lcom/tencent/mm/ui/HorizontalAnimationListener;", "slideFromRightAnim", "slideFromRightListener", "slideToBottomAnim", "slideToBottomListener", "Lcom/tencent/mm/ui/VerticalAnimationListener;", "slideToLeftAnim", "slideToLeftListener", "slideToRightAnim", "slideToRightListener", "printDebugMsg", "", "tag", "", "msg", "slideFromLeft", "view", "Landroid/view/View;", "animEndCallback", "Lkotlin/Function0;", "width", "slideFromRight", "slideToBottom", "slideToLeft", "slideToRight", "Companion", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
{
  public static final be.a adLc;
  public ObjectAnimator GCf;
  private ObjectAnimator GCh;
  public m adLd;
  private m adLe;
  public ObjectAnimator adLf;
  public m adLg;
  public ObjectAnimator adLh;
  public m adLi;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(249380);
    adLc = new be.a((byte)0);
    AppMethodBeat.o(249380);
  }
  
  public be(Context paramContext)
  {
    AppMethodBeat.i(249375);
    this.mContext = paramContext;
    AppMethodBeat.o(249375);
  }
  
  public static void hQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249378);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    bc.i(s.X(paramString1, "(Debug)"), paramString2, new Object[0]);
    AppMethodBeat.o(249378);
  }
  
  public final void a(View paramView, a<ah> parama, float paramFloat)
  {
    AppMethodBeat.i(249385);
    s.u(paramView, "view");
    Object localObject;
    if (this.GCh != null)
    {
      localObject = this.GCh;
      if (localObject == null)
      {
        localObject = null;
        if (!(localObject instanceof View)) {
          break label132;
        }
      }
      label132:
      for (localObject = (View)localObject;; localObject = null)
      {
        if (!s.p(localObject, paramView)) {
          break label138;
        }
        hQ("WeUISlideAnimHelper", "slideToRightAnim view:" + paramView.hashCode() + " reuseAnim");
        localObject = this.adLe;
        if (localObject != null) {
          ((m)localObject).b(paramView, parama);
        }
        paramView = this.GCh;
        if (paramView != null) {
          paramView.start();
        }
        AppMethodBeat.o(249385);
        return;
        localObject = ((ObjectAnimator)localObject).getTarget();
        break;
      }
    }
    label138:
    if (paramFloat == 0.0F) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramFloat = getWIDTH();
      }
      this.GCh = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramFloat });
      m localm = this.adLe;
      localObject = localm;
      if (localm == null) {
        localObject = new m();
      }
      this.adLe = ((m)localObject);
      localObject = this.GCh;
      if (localObject != null) {
        ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)this.adLe);
      }
      localObject = this.GCh;
      if (localObject == null) {
        break;
      }
      ((ObjectAnimator)localObject).setTarget(paramView);
      break;
    }
  }
  
  public final float getWIDTH()
  {
    AppMethodBeat.i(249381);
    float f = bf.bf(this.mContext).x;
    AppMethodBeat.o(249381);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.be
 * JD-Core Version:    0.7.0.1
 */