package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.c;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "errIconLocation", "", "errorIcon", "Landroid/view/View;", "hasGetErrIconLocation", "", "hasGetLoadingIconLocation", "isLoadingShow", "isNoNetworkShowing", "loadingAnimation", "Landroid/view/animation/Animation;", "loadingIcon", "loadingIconLocation", "loadingLayout", "needAnimateWeakNetworkView", "noNetworkLayout", "pendingShowLoading", "pendingShowNoNetwork", "root", "successMark", "init", "", "isShowLoadingView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setSuccessMarkView", "showBadNetworkViewInternal", "withAnimation", "showBadNetworkViewWithAnimation", "showLoadingView", "show", "showLoadingViewInternal", "showNoNetworkView", "showTips", "showWeakNetworkView", "updateNoNetworkTipsLayout", "Companion", "plugin-scan_release"})
public final class ScanNetworkMaskView
  extends LinearLayout
{
  public static final ScanNetworkMaskView.a yOp;
  private View fQH;
  public View tLc;
  public boolean yDQ;
  public View yOc;
  private View yOd;
  public int[] yOe;
  public Animation yOf;
  private boolean yOg;
  public View yOh;
  private View yOi;
  public int[] yOj;
  private boolean yOk;
  public boolean yOl;
  private boolean yOm;
  public boolean yOn;
  public boolean yOo;
  
  static
  {
    AppMethodBeat.i(52422);
    yOp = new ScanNetworkMaskView.a((byte)0);
    AppMethodBeat.o(52422);
  }
  
  public ScanNetworkMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52420);
    AppMethodBeat.o(52420);
  }
  
  public ScanNetworkMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52421);
    this.yOe = new int[2];
    this.yOj = new int[2];
    this.yOo = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494568, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131304241);
    p.g(paramAttributeSet, "view.findViewById(R.id.root_container)");
    this.fQH = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304316);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_layout)");
    this.tLc = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304315);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_icon)");
    this.yOd = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304325);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_no_network_layout)");
    this.yOh = paramAttributeSet;
    paramContext = paramContext.findViewById(2131304324);
    p.g(paramContext, "view.findViewById(R.id.scan_no_network_error_icon)");
    this.yOi = paramContext;
    paramContext = this.fQH;
    if (paramContext == null) {
      p.bdF("root");
    }
    paramContext.setOnTouchListener((View.OnTouchListener)ScanNetworkMaskView.b.yOq);
    AppMethodBeat.o(52421);
  }
  
  private final void dPS()
  {
    AppMethodBeat.i(52417);
    ae.i("MicroMsg.ScanNetworkMaskView", "alvinluo showBadNetworkViewWithAnimation");
    Object localObject = this.yOc;
    if (localObject == null) {
      p.gkB();
    }
    final float f1 = ((View)localObject).getTranslationX() - this.yOj[0];
    localObject = this.yOc;
    if (localObject == null) {
      p.gkB();
    }
    final float f2 = ((View)localObject).getTranslationY() - this.yOj[1];
    localObject = this.yOi;
    if (localObject == null) {
      p.bdF("errorIcon");
    }
    ((View)localObject).setTranslationX(f1);
    localObject = this.yOi;
    if (localObject == null) {
      p.bdF("errorIcon");
    }
    ((View)localObject).setTranslationY(f2);
    localObject = this.yOh;
    if (localObject == null) {
      p.bdF("noNetworkLayout");
    }
    ((View)localObject).setAlpha(0.0F);
    localObject = this.yOc;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((View)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(this.yOj[1]);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationX(this.yOj[0]);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setListener(null);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this, f1, f2));
                if (localObject != null)
                {
                  ((ViewPropertyAnimator)localObject).start();
                  AppMethodBeat.o(52417);
                  return;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(52417);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52415);
    super.onMeasure(paramInt1, paramInt2);
    View localView;
    if (!this.yOk)
    {
      localView = this.yOi;
      if (localView == null) {
        p.bdF("errorIcon");
      }
      localView.getLocationInWindow(this.yOj);
    }
    if (!this.yOg)
    {
      localView = this.yOd;
      if (localView == null) {
        p.bdF("loadingIcon");
      }
      localView.getLocationInWindow(this.yOe);
    }
    ae.d("MicroMsg.ScanNetworkMaskView", "alvinluo onMeasure errorIcon location: %d, %d, loadingIcon location: %d, %d, pendingShowNoNetwork: %b, pendingShowLoading: %b", new Object[] { Integer.valueOf(this.yOj[0]), Integer.valueOf(this.yOj[1]), Integer.valueOf(this.yOe[0]), Integer.valueOf(this.yOe[1]), Boolean.valueOf(this.yOl), Boolean.valueOf(this.yOn) });
    if ((this.yOj[0] != 0) || (this.yOj[1] != 0))
    {
      this.yOk = true;
      if (!this.yOl) {
        break label228;
      }
      qK(true);
    }
    while ((this.yOe[0] != 0) || (this.yOe[1] != 0))
    {
      this.yOg = true;
      if (this.yOn)
      {
        qL(true);
        AppMethodBeat.o(52415);
        return;
        label228:
        if (!this.yOm)
        {
          localView = this.yOh;
          if (localView == null) {
            p.bdF("noNetworkLayout");
          }
          localView.setVisibility(8);
        }
      }
      else if (!this.yDQ)
      {
        localView = this.tLc;
        if (localView == null) {
          p.bdF("loadingLayout");
        }
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(52415);
  }
  
  public final void qJ(boolean paramBoolean)
  {
    AppMethodBeat.i(189696);
    Object localObject = this.yOh;
    if (localObject == null) {
      p.bdF("noNetworkLayout");
    }
    localObject = (TextView)((View)localObject).findViewById(2131308191);
    if (localObject != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((TextView)localObject).setVisibility(i);
        AppMethodBeat.o(189696);
        return;
      }
    }
    AppMethodBeat.o(189696);
  }
  
  public final void qK(boolean paramBoolean)
  {
    AppMethodBeat.i(52416);
    this.yOl = false;
    this.yOm = true;
    setVisibility(0);
    View localView = this.yOh;
    if (localView == null) {
      p.bdF("noNetworkLayout");
    }
    localView.setVisibility(0);
    localView = this.tLc;
    if (localView == null) {
      p.bdF("loadingLayout");
    }
    localView.setVisibility(8);
    if (!paramBoolean)
    {
      setVisibility(0);
      localView = this.yOh;
      if (localView == null) {
        p.bdF("noNetworkLayout");
      }
      localView.setAlpha(1.0F);
      AppMethodBeat.o(52416);
      return;
    }
    dPS();
    AppMethodBeat.o(52416);
  }
  
  public final void qL(final boolean paramBoolean)
  {
    AppMethodBeat.i(52419);
    ae.d("MicroMsg.ScanNetworkMaskView", "alvinluo showLoadingViewInternal withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.yOn = false;
    this.yDQ = true;
    this.yOo = false;
    Object localObject1 = (a)new f(this);
    setVisibility(0);
    Object localObject2 = this.yOh;
    if (localObject2 == null) {
      p.bdF("noNetworkLayout");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = this.tLc;
    if (localObject2 == null) {
      p.bdF("loadingLayout");
    }
    ((View)localObject2).setVisibility(0);
    localObject2 = this.yOf;
    if (localObject2 != null) {
      ((Animation)localObject2).cancel();
    }
    if (!paramBoolean)
    {
      localObject2 = this.tLc;
      if (localObject2 == null) {
        p.bdF("loadingLayout");
      }
      ((View)localObject2).setAlpha(1.0F);
      ((a)localObject1).invoke();
      AppMethodBeat.o(52419);
      return;
    }
    localObject2 = this.tLc;
    if (localObject2 == null) {
      p.bdF("loadingLayout");
    }
    ((View)localObject2).setAlpha(0.0F);
    localObject2 = this.yOc;
    if (localObject2 == null) {
      p.gkB();
    }
    final y.c localc;
    Object localObject3;
    if (((View)localObject2).getVisibility() == 0)
    {
      paramBoolean = true;
      localObject2 = new y.c();
      ((y.c)localObject2).NiV = 0.0F;
      localc = new y.c();
      localc.NiV = 0.0F;
      if (!paramBoolean) {
        break label532;
      }
      localObject3 = this.yOc;
      if (localObject3 == null) {
        p.gkB();
      }
      ((y.c)localObject2).NiV = (((View)localObject3).getTranslationX() - this.yOe[0]);
      localObject3 = this.yOc;
      if (localObject3 == null) {
        p.gkB();
      }
      localc.NiV = (((View)localObject3).getTranslationY() - this.yOe[1]);
      localObject3 = this.yOd;
      if (localObject3 == null) {
        p.bdF("loadingIcon");
      }
      ((View)localObject3).setTranslationX(((y.c)localObject2).NiV);
      localObject3 = this.yOd;
      if (localObject3 == null) {
        p.bdF("loadingIcon");
      }
      ((View)localObject3).setTranslationY(localc.NiV);
    }
    for (;;)
    {
      ae.d("MicroMsg.ScanNetworkMaskView", "alvinluo showLoadingViewInternal needDoTranslation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject3 = this.yOc;
      if (localObject3 == null) {
        p.gkB();
      }
      localObject3 = ((View)localObject3).animate();
      if (localObject3 == null) {
        break label542;
      }
      if (paramBoolean)
      {
        Object localObject4 = this.yOc;
        if (localObject4 == null) {
          p.gkB();
        }
        ((View)localObject4).setVisibility(0);
        localObject4 = ((ViewPropertyAnimator)localObject3).translationY(this.yOj[1]);
        if (localObject4 != null) {
          ((ViewPropertyAnimator)localObject4).translationX(this.yOj[0]);
        }
      }
      if (localObject3 == null) {
        break label542;
      }
      localObject3 = ((ViewPropertyAnimator)localObject3).alpha(0.0F);
      if (localObject3 == null) {
        break label542;
      }
      localObject3 = ((ViewPropertyAnimator)localObject3).setDuration(300L);
      if (localObject3 == null) {
        break label542;
      }
      localObject1 = ((ViewPropertyAnimator)localObject3).setListener((Animator.AnimatorListener)new d(this, paramBoolean, (a)localObject1));
      if (localObject1 == null) {
        break label542;
      }
      localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this, paramBoolean, (y.c)localObject2, localc));
      if (localObject1 == null) {
        break label542;
      }
      ((ViewPropertyAnimator)localObject1).start();
      AppMethodBeat.o(52419);
      return;
      paramBoolean = false;
      break;
      label532:
      ((a)localObject1).invoke();
    }
    label542:
    AppMethodBeat.o(52419);
  }
  
  public final void setSuccessMarkView(View paramView)
  {
    this.yOc = paramView;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(ScanNetworkMaskView paramScanNetworkMaskView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52411);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52411);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      ScanNetworkMaskView.a(this.yOr).setAlpha(f1);
      float f2 = f1;
      float f3 = f1;
      float f4 = f2;
      float f5 = f2;
      ScanNetworkMaskView.b(this.yOr).setTranslationX(f2 + (0.0F - f3) * f1);
      ScanNetworkMaskView.b(this.yOr).setTranslationY(f1 * (0.0F - f5) + f4);
      AppMethodBeat.o(52411);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView$showLoadingViewInternal$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean, a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52412);
      paramAnimator = ScanNetworkMaskView.e(this.yOr);
      if (paramAnimator == null) {
        p.gkB();
      }
      paramAnimator.setVisibility(8);
      if (paramBoolean) {
        this.yOv.invoke();
      }
      AppMethodBeat.o(52412);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(ScanNetworkMaskView paramScanNetworkMaskView, boolean paramBoolean, y.c paramc1, y.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52413);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52413);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      ScanNetworkMaskView.f(this.yOr).setAlpha(f1);
      if (paramBoolean)
      {
        float f2 = this.yOw.NiV;
        float f3 = this.yOw.NiV;
        float f4 = localc.NiV;
        float f5 = localc.NiV;
        ScanNetworkMaskView.d(this.yOr).setTranslationX(f2 + (0.0F - f3) * f1);
        ScanNetworkMaskView.d(this.yOr).setTranslationY(f1 * (0.0F - f5) + f4);
      }
      AppMethodBeat.o(52413);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<z>
  {
    f(ScanNetworkMaskView paramScanNetworkMaskView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanNetworkMaskView
 * JD-Core Version:    0.7.0.1
 */