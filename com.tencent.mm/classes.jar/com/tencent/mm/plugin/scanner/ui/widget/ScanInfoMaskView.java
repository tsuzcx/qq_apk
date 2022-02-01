package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.g.b.aa.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasGetInfoIconLocation", "", "hasGetLoadingIconLocation", "infoIcon", "Landroid/widget/ImageView;", "infoIconLocation", "", "infoLayout", "Landroid/view/View;", "isInfoLayoutShowing", "isLoadingShow", "loadingAnimation", "Landroid/view/animation/Animation;", "loadingIcon", "loadingIconLocation", "loadingIconTranslating", "loadingLayout", "needTranslateInfoIcon", "opButton", "Landroid/widget/TextView;", "pendingShowInfoLayout", "pendingShowLoading", "pendingShowLoadingWithAnimation", "root", "successMark", "animateSwitch", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "animateViewAlpha", "view", "show", "duration", "", "cancelLoadingAnimation", "dismissInfoView", "withAnimation", "init", "isShowLoadingView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "showInfoView", "viewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "showInfoViewInternal", "showInfoViewWithAnimation", "showLoadingView", "showLoadingViewInternal", "updateInfoLayout", "updateOpButton", "Companion", "plugin-scan_release"})
public final class ScanInfoMaskView
  extends LinearLayout
  implements com.tencent.mm.plugin.scanner.view.a
{
  public static final ScanInfoMaskView.a IXy;
  public View BOd;
  public View HyS;
  public boolean ILR;
  private View IXk;
  private View IXl;
  public TextView IXm;
  private int[] IXn;
  private Animation IXo;
  public boolean IXp;
  private boolean IXq;
  private int[] IXr;
  public boolean IXs;
  public boolean IXt;
  private boolean IXu;
  public boolean IXv;
  public boolean IXw;
  public boolean IXx;
  private View jac;
  public ImageView mrD;
  
  static
  {
    AppMethodBeat.i(218335);
    IXy = new ScanInfoMaskView.a((byte)0);
    AppMethodBeat.o(218335);
  }
  
  public ScanInfoMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(218331);
    AppMethodBeat.o(218331);
  }
  
  public ScanInfoMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(218334);
    this.IXn = new int[2];
    this.IXr = new int[2];
    this.IXx = true;
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.IDZ, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(l.f.root_container);
    p.j(paramAttributeSet, "view.findViewById(R.id.root_container)");
    this.jac = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.IDo);
    p.j(paramAttributeSet, "view.findViewById(R.id.scan_loading_layout)");
    this.BOd = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.IDn);
    p.j(paramAttributeSet, "view.findViewById(R.id.scan_loading_icon)");
    this.IXl = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.IDs);
    p.j(paramAttributeSet, "view.findViewById(R.id.scan_result_info_layout)");
    this.HyS = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.IDr);
    p.j(paramAttributeSet, "view.findViewById(R.id.scan_result_info_icon)");
    this.mrD = ((ImageView)paramAttributeSet);
    paramContext = paramContext.findViewById(l.f.IDt);
    p.j(paramContext, "view.findViewById(R.id.scan_result_info_op_button)");
    this.IXm = ((TextView)paramContext);
    paramContext = this.jac;
    if (paramContext == null) {
      p.bGy("root");
    }
    paramContext.setOnTouchListener((View.OnTouchListener)ScanInfoMaskView.c.IXA);
    paramContext = this.HyS;
    if (paramContext == null) {
      p.bGy("infoLayout");
    }
    paramContext = (TextView)paramContext.findViewById(l.f.IDv);
    if (paramContext != null) {
      ar.a((Paint)paramContext.getPaint(), 0.8F);
    }
    paramContext = this.IXm;
    if (paramContext == null) {
      p.bGy("opButton");
    }
    ar.a((Paint)paramContext.getPaint(), 0.8F);
    AppMethodBeat.o(218334);
  }
  
  public static void a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(218323);
    paramView.setAlpha(1.0F);
    Log.i("MicroMsg.ScanInfoMaskView", "alvinluo animateViewAlpha view: %s, show: %b", new Object[] { paramView, Boolean.FALSE });
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator = localViewPropertyAnimator.alpha(0.0F);
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.setDuration(150L);
        if (localViewPropertyAnimator != null)
        {
          paramView = localViewPropertyAnimator.setListener((Animator.AnimatorListener)new ScanInfoMaskView.b(paramView, paramAnimatorListenerAdapter));
          if (paramView != null)
          {
            paramView.start();
            AppMethodBeat.o(218323);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(218323);
  }
  
  private final void fEA()
  {
    AppMethodBeat.i(218327);
    Log.v("MicroMsg.ScanInfoMaskView", "alvinluo showInfoViewWithAnimation");
    if (this.IXk == null)
    {
      AppMethodBeat.o(218327);
      return;
    }
    Object localObject = this.IXk;
    if (localObject == null) {
      p.iCn();
    }
    final float f1 = ((View)localObject).getTranslationX();
    final float f2 = this.IXr[0];
    localObject = this.IXk;
    if (localObject == null) {
      p.iCn();
    }
    f1 = ((View)localObject).getPaddingLeft() + (f1 - f2);
    localObject = this.IXk;
    if (localObject == null) {
      p.iCn();
    }
    f2 = ((View)localObject).getTranslationY();
    float f3 = this.IXr[1];
    localObject = this.IXk;
    if (localObject == null) {
      p.iCn();
    }
    f2 = ((View)localObject).getPaddingTop() + (f2 - f3);
    localObject = this.mrD;
    if (localObject == null) {
      p.bGy("infoIcon");
    }
    ((ImageView)localObject).setTranslationX(f1);
    localObject = this.mrD;
    if (localObject == null) {
      p.bGy("infoIcon");
    }
    ((ImageView)localObject).setTranslationY(f2);
    localObject = this.HyS;
    if (localObject == null) {
      p.bGy("infoLayout");
    }
    ((View)localObject).setAlpha(0.0F);
    localObject = this.IXk;
    if (localObject == null) {
      p.iCn();
    }
    ((View)localObject).setVisibility(0);
    ((View)localObject).setAlpha(1.0F);
    ((View)localObject).setScaleX(1.0F);
    ((View)localObject).setScaleY(1.0F);
    localObject = this.IXk;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((View)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
      if (localObject != null)
      {
        f3 = this.IXr[1];
        View localView = this.IXk;
        if (localView == null) {
          p.iCn();
        }
        localObject = ((ViewPropertyAnimator)localObject).translationY(f3 - localView.getPaddingTop());
        if (localObject != null)
        {
          f3 = this.IXr[0];
          localView = this.IXk;
          if (localView == null) {
            p.iCn();
          }
          localObject = ((ViewPropertyAnimator)localObject).translationX(f3 - localView.getPaddingLeft());
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setListener(null);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this, f1, f2));
                if (localObject != null)
                {
                  ((ViewPropertyAnimator)localObject).start();
                  AppMethodBeat.o(218327);
                  return;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(218327);
  }
  
  public final void fEB()
  {
    AppMethodBeat.i(218328);
    Object localObject = this.IXo;
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    localObject = this.IXl;
    if (localObject == null) {
      p.bGy("loadingIcon");
    }
    ((View)localObject).clearAnimation();
    AppMethodBeat.o(218328);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218321);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject;
    if (!this.IXs)
    {
      localObject = this.mrD;
      if (localObject == null) {
        p.bGy("infoIcon");
      }
      ((ImageView)localObject).getLocationInWindow(this.IXr);
    }
    if (!this.IXp)
    {
      localObject = this.IXl;
      if (localObject == null) {
        p.bGy("loadingIcon");
      }
      ((View)localObject).getLocationInWindow(this.IXn);
    }
    Log.d("MicroMsg.ScanInfoMaskView", "alvinluo onMeasure infoIcon location: %d, %d, loadingIcon location: %d, %d, pendingShowInfoLayout: %b, pendingShowLoading: %b, hasGetInfoIconLocation: %b, hasGetLoadingIconLocation: %b", new Object[] { Integer.valueOf(this.IXr[0]), Integer.valueOf(this.IXr[1]), Integer.valueOf(this.IXn[0]), Integer.valueOf(this.IXn[1]), Boolean.valueOf(this.IXt), Boolean.valueOf(this.IXv), Boolean.valueOf(this.IXs), Boolean.valueOf(this.IXp) });
    if ((this.IXr[0] != 0) || (this.IXr[1] != 0))
    {
      this.IXs = true;
      if (!this.IXt) {
        break label256;
      }
      xB(true);
    }
    while ((this.IXn[0] != 0) || (this.IXn[1] != 0))
    {
      this.IXp = true;
      if (this.IXv)
      {
        xC(this.IXw);
        AppMethodBeat.o(218321);
        return;
        label256:
        if (!this.IXu)
        {
          localObject = this.HyS;
          if (localObject == null) {
            p.bGy("infoLayout");
          }
          ((View)localObject).setVisibility(8);
        }
      }
      else if (!this.ILR)
      {
        localObject = this.BOd;
        if (localObject == null) {
          p.bGy("loadingLayout");
        }
        ((View)localObject).setVisibility(8);
      }
    }
    AppMethodBeat.o(218321);
  }
  
  public final void setAnchorView(View paramView)
  {
    this.IXk = paramView;
  }
  
  public final void xB(boolean paramBoolean)
  {
    AppMethodBeat.i(218324);
    this.IXt = false;
    this.IXu = true;
    setVisibility(0);
    View localView = this.HyS;
    if (localView == null) {
      p.bGy("infoLayout");
    }
    localView.setVisibility(0);
    localView = this.BOd;
    if (localView == null) {
      p.bGy("loadingLayout");
    }
    localView.setVisibility(8);
    localView = this.IXk;
    if (localView != null) {
      localView.setVisibility(8);
    }
    if (!paramBoolean)
    {
      setVisibility(0);
      localView = this.HyS;
      if (localView == null) {
        p.bGy("infoLayout");
      }
      localView.setAlpha(1.0F);
      AppMethodBeat.o(218324);
      return;
    }
    fEA();
    AppMethodBeat.o(218324);
  }
  
  public final void xC(final boolean paramBoolean)
  {
    AppMethodBeat.i(218329);
    Log.d("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingViewInternal withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.IXv = false;
    this.IXw = false;
    this.ILR = true;
    this.IXx = false;
    Object localObject1 = (kotlin.g.a.a)new i(this);
    setVisibility(0);
    Object localObject2 = this.HyS;
    if (localObject2 == null) {
      p.bGy("infoLayout");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = this.BOd;
    if (localObject2 == null) {
      p.bGy("loadingLayout");
    }
    ((View)localObject2).setVisibility(0);
    localObject2 = this.IXo;
    if (localObject2 != null) {
      ((Animation)localObject2).cancel();
    }
    if (!paramBoolean)
    {
      localObject2 = this.BOd;
      if (localObject2 == null) {
        p.bGy("loadingLayout");
      }
      ((View)localObject2).setAlpha(1.0F);
      if (!this.IXq) {
        ((kotlin.g.a.a)localObject1).invoke();
      }
      AppMethodBeat.o(218329);
      return;
    }
    localObject2 = this.BOd;
    if (localObject2 == null) {
      p.bGy("loadingLayout");
    }
    ((View)localObject2).setAlpha(0.0F);
    final aa.c localc;
    Object localObject3;
    float f1;
    if (this.IXk != null)
    {
      localObject2 = this.IXk;
      if (localObject2 == null) {
        p.iCn();
      }
      if (((View)localObject2).getVisibility() == 0)
      {
        paramBoolean = true;
        localObject2 = new aa.c();
        ((aa.c)localObject2).aaBz = 0.0F;
        localc = new aa.c();
        localc.aaBz = 0.0F;
        if (!paramBoolean) {
          break label723;
        }
        localObject3 = this.IXk;
        if (localObject3 == null) {
          p.iCn();
        }
        f1 = ((View)localObject3).getTranslationX();
        float f2 = this.IXn[0];
        localObject3 = this.IXk;
        if (localObject3 == null) {
          p.iCn();
        }
        ((aa.c)localObject2).aaBz = (f1 - f2 + ((View)localObject3).getPaddingLeft());
        localObject3 = this.IXk;
        if (localObject3 == null) {
          p.iCn();
        }
        f1 = ((View)localObject3).getTranslationY();
        f2 = this.IXn[1];
        localObject3 = this.IXk;
        if (localObject3 == null) {
          p.iCn();
        }
        localc.aaBz = (f1 - f2 + ((View)localObject3).getPaddingTop());
        localObject3 = this.IXl;
        if (localObject3 == null) {
          p.bGy("loadingIcon");
        }
        ((View)localObject3).setTranslationX(((aa.c)localObject2).aaBz);
        localObject3 = this.IXl;
        if (localObject3 == null) {
          p.bGy("loadingIcon");
        }
        ((View)localObject3).setTranslationY(localc.aaBz);
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingViewInternal needDoTranslation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject3 = this.IXk;
      if (localObject3 != null)
      {
        ((View)localObject3).setVisibility(0);
        ((View)localObject3).setAlpha(1.0F);
        ((View)localObject3).setScaleX(1.0F);
        ((View)localObject3).setScaleY(1.0F);
      }
      localObject3 = this.IXk;
      if (localObject3 != null)
      {
        localObject3 = ((View)localObject3).animate();
        if (localObject3 != null) {
          ((ViewPropertyAnimator)localObject3).cancel();
        }
      }
      localObject3 = this.IXk;
      if (localObject3 == null) {
        break label734;
      }
      localObject3 = ((View)localObject3).animate();
      if (localObject3 == null) {
        break label734;
      }
      if (paramBoolean)
      {
        f1 = this.IXn[1];
        Object localObject4 = this.IXk;
        if (localObject4 == null) {
          p.iCn();
        }
        localObject4 = ((ViewPropertyAnimator)localObject3).translationY(f1 - ((View)localObject4).getPaddingTop());
        if (localObject4 != null)
        {
          f1 = this.IXn[0];
          View localView = this.IXk;
          if (localView == null) {
            p.iCn();
          }
          ((ViewPropertyAnimator)localObject4).translationX(f1 - localView.getPaddingLeft());
        }
      }
      if (localObject3 == null) {
        break label734;
      }
      localObject3 = ((ViewPropertyAnimator)localObject3).alpha(0.0F);
      if (localObject3 == null) {
        break label734;
      }
      localObject3 = ((ViewPropertyAnimator)localObject3).setDuration(300L);
      if (localObject3 == null) {
        break label734;
      }
      localObject1 = ((ViewPropertyAnimator)localObject3).setListener((Animator.AnimatorListener)new g(this, paramBoolean, (kotlin.g.a.a)localObject1));
      if (localObject1 == null) {
        break label734;
      }
      localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new h(this, paramBoolean, (aa.c)localObject2, localc));
      if (localObject1 == null) {
        break label734;
      }
      ((ViewPropertyAnimator)localObject1).start();
      AppMethodBeat.o(218329);
      return;
      paramBoolean = false;
      break;
      label723:
      ((kotlin.g.a.a)localObject1).invoke();
    }
    label734:
    AppMethodBeat.o(218329);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(ScanInfoMaskView paramScanInfoMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(217940);
      this.IXB.requestLayout();
      AppMethodBeat.o(217940);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(ScanInfoMaskView paramScanInfoMaskView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(218112);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(218112);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      ScanInfoMaskView.a(this.IXB).setAlpha(f1);
      ScanInfoMaskView.b(this.IXB).setAlpha(f1);
      float f2 = f1;
      float f3 = f1;
      float f4 = f2;
      float f5 = f2;
      ScanInfoMaskView.c(this.IXB).setTranslationX(f2 + (0.0F - f3) * f1);
      ScanInfoMaskView.c(this.IXB).setTranslationY(f1 * (0.0F - f5) + f4);
      AppMethodBeat.o(218112);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(ScanInfoMaskView paramScanInfoMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(218008);
      this.IXB.requestLayout();
      AppMethodBeat.o(218008);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$showLoadingViewInternal$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-scan_release"})
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(boolean paramBoolean, kotlin.g.a.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(218996);
      super.onAnimationCancel(paramAnimator);
      ScanInfoMaskView.a(this.IXB, false);
      AppMethodBeat.o(218996);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(218994);
      paramAnimator = ScanInfoMaskView.g(this.IXB);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = ScanInfoMaskView.g(this.IXB);
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.animate();
        if (paramAnimator != null) {
          paramAnimator.setListener(null);
        }
      }
      ScanInfoMaskView.a(this.IXB, false);
      if (paramBoolean) {
        this.IXE.invoke();
      }
      AppMethodBeat.o(218994);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(ScanInfoMaskView paramScanInfoMaskView, boolean paramBoolean, aa.c paramc1, aa.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(219292);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(219292);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      ScanInfoMaskView.h(this.IXB).setAlpha(f1);
      paramValueAnimator = ScanInfoMaskView.g(this.IXB);
      if (paramValueAnimator != null) {
        paramValueAnimator.setVisibility(0);
      }
      if (paramBoolean)
      {
        ScanInfoMaskView.a(this.IXB, true);
        float f2 = this.IXF.aaBz;
        float f3 = this.IXF.aaBz;
        float f4 = localc.aaBz;
        float f5 = localc.aaBz;
        ScanInfoMaskView.f(this.IXB).setTranslationX(f2 + (0.0F - f3) * f1);
        ScanInfoMaskView.f(this.IXB).setTranslationY(f1 * (0.0F - f5) + f4);
      }
      AppMethodBeat.o(219292);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(ScanInfoMaskView paramScanInfoMaskView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView
 * JD-Core Version:    0.7.0.1
 */