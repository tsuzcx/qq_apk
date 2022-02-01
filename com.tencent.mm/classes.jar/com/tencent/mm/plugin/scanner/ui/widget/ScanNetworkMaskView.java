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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.g.b.k;
import d.g.b.v.c;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "errIconLocation", "", "errorIcon", "Landroid/view/View;", "hasGetErrIconLocation", "", "hasGetLoadingIconLocation", "isLoadingShow", "isNoNetworkShowing", "loadingAnimation", "Landroid/view/animation/Animation;", "loadingIcon", "loadingIconLocation", "loadingLayout", "needAnimateWeakNetworkView", "noNetworkLayout", "pendingShowLoading", "pendingShowNoNetwork", "root", "successMark", "init", "", "isShowLoadingView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setSuccessMarkView", "showBadNetworkViewInternal", "withAnimation", "showBadNetworkViewWithAnimation", "showLoadingView", "show", "showLoadingViewInternal", "showNoNetworkView", "showWeakNetworkView", "Companion", "plugin-scan_release"})
public final class ScanNetworkMaskView
  extends LinearLayout
{
  public static final ScanNetworkMaskView.a xkn;
  private View fvu;
  public View sDw;
  public boolean wZS;
  public View xka;
  private View xkb;
  public int[] xkc;
  public Animation xkd;
  private boolean xke;
  public View xkf;
  private View xkg;
  public int[] xkh;
  private boolean xki;
  public boolean xkj;
  private boolean xkk;
  public boolean xkl;
  public boolean xkm;
  
  static
  {
    AppMethodBeat.i(52422);
    xkn = new ScanNetworkMaskView.a((byte)0);
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
    this.xkc = new int[2];
    this.xkh = new int[2];
    this.xkm = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494568, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131304241);
    k.g(paramAttributeSet, "view.findViewById(R.id.root_container)");
    this.fvu = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304316);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_layout)");
    this.sDw = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304315);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_icon)");
    this.xkb = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304325);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_no_network_layout)");
    this.xkf = paramAttributeSet;
    paramContext = paramContext.findViewById(2131304324);
    k.g(paramContext, "view.findViewById(R.id.scan_no_network_error_icon)");
    this.xkg = paramContext;
    paramContext = this.fvu;
    if (paramContext == null) {
      k.aVY("root");
    }
    paramContext.setOnTouchListener((View.OnTouchListener)ScanNetworkMaskView.b.xko);
    AppMethodBeat.o(52421);
  }
  
  private final void dBb()
  {
    AppMethodBeat.i(52417);
    ac.i("MicroMsg.ScanNetworkMaskView", "alvinluo showBadNetworkViewWithAnimation");
    Object localObject = this.xka;
    if (localObject == null) {
      k.fOy();
    }
    final float f1 = ((View)localObject).getTranslationX() - this.xkh[0];
    localObject = this.xka;
    if (localObject == null) {
      k.fOy();
    }
    final float f2 = ((View)localObject).getTranslationY() - this.xkh[1];
    localObject = this.xkg;
    if (localObject == null) {
      k.aVY("errorIcon");
    }
    ((View)localObject).setTranslationX(f1);
    localObject = this.xkg;
    if (localObject == null) {
      k.aVY("errorIcon");
    }
    ((View)localObject).setTranslationY(f2);
    localObject = this.xkf;
    if (localObject == null) {
      k.aVY("noNetworkLayout");
    }
    ((View)localObject).setAlpha(0.0F);
    localObject = this.xka;
    if (localObject == null) {
      k.fOy();
    }
    localObject = ((View)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(this.xkh[1]);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationX(this.xkh[0]);
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
    if (!this.xki)
    {
      localView = this.xkg;
      if (localView == null) {
        k.aVY("errorIcon");
      }
      localView.getLocationInWindow(this.xkh);
    }
    if (!this.xke)
    {
      localView = this.xkb;
      if (localView == null) {
        k.aVY("loadingIcon");
      }
      localView.getLocationInWindow(this.xkc);
    }
    ac.d("MicroMsg.ScanNetworkMaskView", "alvinluo onMeasure errorIcon location: %d, %d, loadingIcon location: %d, %d, pendingShowNoNetwork: %b, pendingShowLoading: %b", new Object[] { Integer.valueOf(this.xkh[0]), Integer.valueOf(this.xkh[1]), Integer.valueOf(this.xkc[0]), Integer.valueOf(this.xkc[1]), Boolean.valueOf(this.xkj), Boolean.valueOf(this.xkl) });
    if ((this.xkh[0] != 0) || (this.xkh[1] != 0))
    {
      this.xki = true;
      if (!this.xkj) {
        break label228;
      }
      qe(true);
    }
    while ((this.xkc[0] != 0) || (this.xkc[1] != 0))
    {
      this.xke = true;
      if (this.xkl)
      {
        qf(true);
        AppMethodBeat.o(52415);
        return;
        label228:
        if (!this.xkk)
        {
          localView = this.xkf;
          if (localView == null) {
            k.aVY("noNetworkLayout");
          }
          localView.setVisibility(8);
        }
      }
      else if (!this.wZS)
      {
        localView = this.sDw;
        if (localView == null) {
          k.aVY("loadingLayout");
        }
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(52415);
  }
  
  public final void qe(boolean paramBoolean)
  {
    AppMethodBeat.i(52416);
    this.xkj = false;
    this.xkk = true;
    setVisibility(0);
    View localView = this.xkf;
    if (localView == null) {
      k.aVY("noNetworkLayout");
    }
    localView.setVisibility(0);
    localView = this.sDw;
    if (localView == null) {
      k.aVY("loadingLayout");
    }
    localView.setVisibility(8);
    if (!paramBoolean)
    {
      setVisibility(0);
      localView = this.xkf;
      if (localView == null) {
        k.aVY("noNetworkLayout");
      }
      localView.setAlpha(1.0F);
      AppMethodBeat.o(52416);
      return;
    }
    dBb();
    AppMethodBeat.o(52416);
  }
  
  public final void qf(final boolean paramBoolean)
  {
    AppMethodBeat.i(52419);
    ac.d("MicroMsg.ScanNetworkMaskView", "alvinluo showLoadingViewInternal withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.xkl = false;
    this.wZS = true;
    this.xkm = false;
    Object localObject1 = (a)new f(this);
    setVisibility(0);
    Object localObject2 = this.xkf;
    if (localObject2 == null) {
      k.aVY("noNetworkLayout");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = this.sDw;
    if (localObject2 == null) {
      k.aVY("loadingLayout");
    }
    ((View)localObject2).setVisibility(0);
    localObject2 = this.xkd;
    if (localObject2 != null) {
      ((Animation)localObject2).cancel();
    }
    if (!paramBoolean)
    {
      localObject2 = this.sDw;
      if (localObject2 == null) {
        k.aVY("loadingLayout");
      }
      ((View)localObject2).setAlpha(1.0F);
      ((a)localObject1).invoke();
      AppMethodBeat.o(52419);
      return;
    }
    localObject2 = this.sDw;
    if (localObject2 == null) {
      k.aVY("loadingLayout");
    }
    ((View)localObject2).setAlpha(0.0F);
    localObject2 = this.xka;
    if (localObject2 == null) {
      k.fOy();
    }
    final v.c localc;
    Object localObject3;
    if (((View)localObject2).getVisibility() == 0)
    {
      paramBoolean = true;
      localObject2 = new v.c();
      ((v.c)localObject2).KUN = 0.0F;
      localc = new v.c();
      localc.KUN = 0.0F;
      if (!paramBoolean) {
        break label532;
      }
      localObject3 = this.xka;
      if (localObject3 == null) {
        k.fOy();
      }
      ((v.c)localObject2).KUN = (((View)localObject3).getTranslationX() - this.xkc[0]);
      localObject3 = this.xka;
      if (localObject3 == null) {
        k.fOy();
      }
      localc.KUN = (((View)localObject3).getTranslationY() - this.xkc[1]);
      localObject3 = this.xkb;
      if (localObject3 == null) {
        k.aVY("loadingIcon");
      }
      ((View)localObject3).setTranslationX(((v.c)localObject2).KUN);
      localObject3 = this.xkb;
      if (localObject3 == null) {
        k.aVY("loadingIcon");
      }
      ((View)localObject3).setTranslationY(localc.KUN);
    }
    for (;;)
    {
      ac.d("MicroMsg.ScanNetworkMaskView", "alvinluo showLoadingViewInternal needDoTranslation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject3 = this.xka;
      if (localObject3 == null) {
        k.fOy();
      }
      localObject3 = ((View)localObject3).animate();
      if (localObject3 == null) {
        break label542;
      }
      if (paramBoolean)
      {
        Object localObject4 = this.xka;
        if (localObject4 == null) {
          k.fOy();
        }
        ((View)localObject4).setVisibility(0);
        localObject4 = ((ViewPropertyAnimator)localObject3).translationY(this.xkh[1]);
        if (localObject4 != null) {
          ((ViewPropertyAnimator)localObject4).translationX(this.xkh[0]);
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
      localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this, paramBoolean, (v.c)localObject2, localc));
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
    this.xka = paramView;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(ScanNetworkMaskView paramScanNetworkMaskView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52411);
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52411);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      ScanNetworkMaskView.a(this.xkp).setAlpha(f1);
      float f2 = f1;
      float f3 = f1;
      float f4 = f2;
      float f5 = f2;
      ScanNetworkMaskView.b(this.xkp).setTranslationX(f2 + (0.0F - f3) * f1);
      ScanNetworkMaskView.b(this.xkp).setTranslationY(f1 * (0.0F - f5) + f4);
      AppMethodBeat.o(52411);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView$showLoadingViewInternal$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean, a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52412);
      paramAnimator = ScanNetworkMaskView.e(this.xkp);
      if (paramAnimator == null) {
        k.fOy();
      }
      paramAnimator.setVisibility(8);
      if (paramBoolean) {
        this.xkt.invoke();
      }
      AppMethodBeat.o(52412);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(ScanNetworkMaskView paramScanNetworkMaskView, boolean paramBoolean, v.c paramc1, v.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52413);
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52413);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      ScanNetworkMaskView.f(this.xkp).setAlpha(f1);
      if (paramBoolean)
      {
        float f2 = this.xku.KUN;
        float f3 = this.xku.KUN;
        float f4 = localc.KUN;
        float f5 = localc.KUN;
        ScanNetworkMaskView.d(this.xkp).setTranslationX(f2 + (0.0F - f3) * f1);
        ScanNetworkMaskView.d(this.xkp).setTranslationY(f1 * (0.0F - f5) + f4);
      }
      AppMethodBeat.o(52413);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<y>
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