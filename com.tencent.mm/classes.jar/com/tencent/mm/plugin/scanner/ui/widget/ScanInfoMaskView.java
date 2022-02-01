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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.c;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasGetInfoIconLocation", "", "hasGetLoadingIconLocation", "infoIcon", "Landroid/widget/ImageView;", "infoIconLocation", "", "infoLayout", "Landroid/view/View;", "isInfoLayoutShowing", "isLoadingShow", "loadingAnimation", "Landroid/view/animation/Animation;", "loadingIcon", "loadingIconLocation", "loadingIconTranslating", "loadingLayout", "needTranslateInfoIcon", "opButton", "Landroid/widget/TextView;", "pendingShowInfoLayout", "pendingShowLoading", "pendingShowLoadingWithAnimation", "root", "successMark", "animateSwitch", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "animateViewAlpha", "view", "show", "duration", "", "cancelLoadingAnimation", "dismissInfoView", "withAnimation", "init", "isShowLoadingView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "showInfoView", "viewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "showInfoViewInternal", "showInfoViewWithAnimation", "showLoadingView", "showLoadingViewInternal", "updateInfoLayout", "updateOpButton", "Companion", "plugin-scan_release"})
public final class ScanInfoMaskView
  extends LinearLayout
  implements com.tencent.mm.plugin.scanner.view.a
{
  public static final ScanInfoMaskView.a CSg;
  public View BCP;
  public boolean CGG;
  private View CRS;
  private View CRT;
  public TextView CRU;
  private int[] CRV;
  private Animation CRW;
  public boolean CRX;
  private boolean CRY;
  private int[] CRZ;
  public boolean CSa;
  public boolean CSb;
  private boolean CSc;
  public boolean CSd;
  public boolean CSe;
  public boolean CSf;
  private View gvQ;
  public ImageView jBH;
  public View xcd;
  
  static
  {
    AppMethodBeat.i(240665);
    CSg = new ScanInfoMaskView.a((byte)0);
    AppMethodBeat.o(240665);
  }
  
  public ScanInfoMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(240663);
    AppMethodBeat.o(240663);
  }
  
  public ScanInfoMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240664);
    this.CRV = new int[2];
    this.CRZ = new int[2];
    this.CSf = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495190, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131307160);
    p.g(paramAttributeSet, "view.findViewById(R.id.root_container)");
    this.gvQ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131307245);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_layout)");
    this.xcd = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131307244);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_icon)");
    this.CRT = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131307256);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_result_info_layout)");
    this.BCP = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131307255);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_result_info_icon)");
    this.jBH = ((ImageView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131307257);
    p.g(paramContext, "view.findViewById(R.id.scan_result_info_op_button)");
    this.CRU = ((TextView)paramContext);
    paramContext = this.gvQ;
    if (paramContext == null) {
      p.btv("root");
    }
    paramContext.setOnTouchListener((View.OnTouchListener)ScanInfoMaskView.c.CSi);
    paramContext = this.BCP;
    if (paramContext == null) {
      p.btv("infoLayout");
    }
    paramContext = (TextView)paramContext.findViewById(2131307259);
    if (paramContext != null) {
      ao.a((Paint)paramContext.getPaint(), 0.8F);
    }
    paramContext = this.CRU;
    if (paramContext == null) {
      p.btv("opButton");
    }
    ao.a((Paint)paramContext.getPaint(), 0.8F);
    AppMethodBeat.o(240664);
  }
  
  public static void a(View paramView, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(240658);
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
          paramView = localViewPropertyAnimator.setListener((Animator.AnimatorListener)new b(paramView, paramAnimatorListenerAdapter));
          if (paramView != null)
          {
            paramView.start();
            AppMethodBeat.o(240658);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(240658);
  }
  
  private final void eRB()
  {
    AppMethodBeat.i(240660);
    Log.v("MicroMsg.ScanInfoMaskView", "alvinluo showInfoViewWithAnimation");
    if (this.CRS == null)
    {
      AppMethodBeat.o(240660);
      return;
    }
    Object localObject = this.CRS;
    if (localObject == null) {
      p.hyc();
    }
    final float f1 = ((View)localObject).getTranslationX();
    final float f2 = this.CRZ[0];
    localObject = this.CRS;
    if (localObject == null) {
      p.hyc();
    }
    f1 = ((View)localObject).getPaddingLeft() + (f1 - f2);
    localObject = this.CRS;
    if (localObject == null) {
      p.hyc();
    }
    f2 = ((View)localObject).getTranslationY();
    float f3 = this.CRZ[1];
    localObject = this.CRS;
    if (localObject == null) {
      p.hyc();
    }
    f2 = ((View)localObject).getPaddingTop() + (f2 - f3);
    localObject = this.jBH;
    if (localObject == null) {
      p.btv("infoIcon");
    }
    ((ImageView)localObject).setTranslationX(f1);
    localObject = this.jBH;
    if (localObject == null) {
      p.btv("infoIcon");
    }
    ((ImageView)localObject).setTranslationY(f2);
    localObject = this.BCP;
    if (localObject == null) {
      p.btv("infoLayout");
    }
    ((View)localObject).setAlpha(0.0F);
    localObject = this.CRS;
    if (localObject == null) {
      p.hyc();
    }
    ((View)localObject).setVisibility(0);
    ((View)localObject).setAlpha(1.0F);
    ((View)localObject).setScaleX(1.0F);
    ((View)localObject).setScaleY(1.0F);
    localObject = this.CRS;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((View)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
      if (localObject != null)
      {
        f3 = this.CRZ[1];
        View localView = this.CRS;
        if (localView == null) {
          p.hyc();
        }
        localObject = ((ViewPropertyAnimator)localObject).translationY(f3 - localView.getPaddingTop());
        if (localObject != null)
        {
          f3 = this.CRZ[0];
          localView = this.CRS;
          if (localView == null) {
            p.hyc();
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
                  AppMethodBeat.o(240660);
                  return;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(240660);
  }
  
  public final void eRC()
  {
    AppMethodBeat.i(240661);
    Object localObject = this.CRW;
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    localObject = this.CRT;
    if (localObject == null) {
      p.btv("loadingIcon");
    }
    ((View)localObject).clearAnimation();
    AppMethodBeat.o(240661);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240657);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject;
    if (!this.CSa)
    {
      localObject = this.jBH;
      if (localObject == null) {
        p.btv("infoIcon");
      }
      ((ImageView)localObject).getLocationInWindow(this.CRZ);
    }
    if (!this.CRX)
    {
      localObject = this.CRT;
      if (localObject == null) {
        p.btv("loadingIcon");
      }
      ((View)localObject).getLocationInWindow(this.CRV);
    }
    Log.d("MicroMsg.ScanInfoMaskView", "alvinluo onMeasure infoIcon location: %d, %d, loadingIcon location: %d, %d, pendingShowInfoLayout: %b, pendingShowLoading: %b, hasGetInfoIconLocation: %b, hasGetLoadingIconLocation: %b", new Object[] { Integer.valueOf(this.CRZ[0]), Integer.valueOf(this.CRZ[1]), Integer.valueOf(this.CRV[0]), Integer.valueOf(this.CRV[1]), Boolean.valueOf(this.CSb), Boolean.valueOf(this.CSd), Boolean.valueOf(this.CSa), Boolean.valueOf(this.CRX) });
    if ((this.CRZ[0] != 0) || (this.CRZ[1] != 0))
    {
      this.CSa = true;
      if (!this.CSb) {
        break label255;
      }
      ud(true);
    }
    while ((this.CRV[0] != 0) || (this.CRV[1] != 0))
    {
      this.CRX = true;
      if (this.CSd)
      {
        ue(this.CSe);
        AppMethodBeat.o(240657);
        return;
        label255:
        if (!this.CSc)
        {
          localObject = this.BCP;
          if (localObject == null) {
            p.btv("infoLayout");
          }
          ((View)localObject).setVisibility(8);
        }
      }
      else if (!this.CGG)
      {
        localObject = this.xcd;
        if (localObject == null) {
          p.btv("loadingLayout");
        }
        ((View)localObject).setVisibility(8);
      }
    }
    AppMethodBeat.o(240657);
  }
  
  public final void setAnchorView(View paramView)
  {
    this.CRS = paramView;
  }
  
  public final void ud(boolean paramBoolean)
  {
    AppMethodBeat.i(240659);
    this.CSb = false;
    this.CSc = true;
    setVisibility(0);
    View localView = this.BCP;
    if (localView == null) {
      p.btv("infoLayout");
    }
    localView.setVisibility(0);
    localView = this.xcd;
    if (localView == null) {
      p.btv("loadingLayout");
    }
    localView.setVisibility(8);
    localView = this.CRS;
    if (localView != null) {
      localView.setVisibility(8);
    }
    if (!paramBoolean)
    {
      setVisibility(0);
      localView = this.BCP;
      if (localView == null) {
        p.btv("infoLayout");
      }
      localView.setAlpha(1.0F);
      AppMethodBeat.o(240659);
      return;
    }
    eRB();
    AppMethodBeat.o(240659);
  }
  
  public final void ue(final boolean paramBoolean)
  {
    AppMethodBeat.i(240662);
    Log.d("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingViewInternal withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CSd = false;
    this.CSe = false;
    this.CGG = true;
    this.CSf = false;
    Object localObject1 = (kotlin.g.a.a)new i(this);
    setVisibility(0);
    Object localObject2 = this.BCP;
    if (localObject2 == null) {
      p.btv("infoLayout");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = this.xcd;
    if (localObject2 == null) {
      p.btv("loadingLayout");
    }
    ((View)localObject2).setVisibility(0);
    localObject2 = this.CRW;
    if (localObject2 != null) {
      ((Animation)localObject2).cancel();
    }
    if (!paramBoolean)
    {
      localObject2 = this.xcd;
      if (localObject2 == null) {
        p.btv("loadingLayout");
      }
      ((View)localObject2).setAlpha(1.0F);
      if (!this.CRY) {
        ((kotlin.g.a.a)localObject1).invoke();
      }
      AppMethodBeat.o(240662);
      return;
    }
    localObject2 = this.xcd;
    if (localObject2 == null) {
      p.btv("loadingLayout");
    }
    ((View)localObject2).setAlpha(0.0F);
    final z.c localc;
    Object localObject3;
    float f1;
    if (this.CRS != null)
    {
      localObject2 = this.CRS;
      if (localObject2 == null) {
        p.hyc();
      }
      if (((View)localObject2).getVisibility() == 0)
      {
        paramBoolean = true;
        localObject2 = new z.c();
        ((z.c)localObject2).SYD = 0.0F;
        localc = new z.c();
        localc.SYD = 0.0F;
        if (!paramBoolean) {
          break label721;
        }
        localObject3 = this.CRS;
        if (localObject3 == null) {
          p.hyc();
        }
        f1 = ((View)localObject3).getTranslationX();
        float f2 = this.CRV[0];
        localObject3 = this.CRS;
        if (localObject3 == null) {
          p.hyc();
        }
        ((z.c)localObject2).SYD = (f1 - f2 + ((View)localObject3).getPaddingLeft());
        localObject3 = this.CRS;
        if (localObject3 == null) {
          p.hyc();
        }
        f1 = ((View)localObject3).getTranslationY();
        f2 = this.CRV[1];
        localObject3 = this.CRS;
        if (localObject3 == null) {
          p.hyc();
        }
        localc.SYD = (f1 - f2 + ((View)localObject3).getPaddingTop());
        localObject3 = this.CRT;
        if (localObject3 == null) {
          p.btv("loadingIcon");
        }
        ((View)localObject3).setTranslationX(((z.c)localObject2).SYD);
        localObject3 = this.CRT;
        if (localObject3 == null) {
          p.btv("loadingIcon");
        }
        ((View)localObject3).setTranslationY(localc.SYD);
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingViewInternal needDoTranslation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject3 = this.CRS;
      if (localObject3 != null)
      {
        ((View)localObject3).setVisibility(0);
        ((View)localObject3).setAlpha(1.0F);
        ((View)localObject3).setScaleX(1.0F);
        ((View)localObject3).setScaleY(1.0F);
      }
      localObject3 = this.CRS;
      if (localObject3 != null)
      {
        localObject3 = ((View)localObject3).animate();
        if (localObject3 != null) {
          ((ViewPropertyAnimator)localObject3).cancel();
        }
      }
      localObject3 = this.CRS;
      if (localObject3 == null) {
        break label732;
      }
      localObject3 = ((View)localObject3).animate();
      if (localObject3 == null) {
        break label732;
      }
      if (paramBoolean)
      {
        f1 = this.CRV[1];
        Object localObject4 = this.CRS;
        if (localObject4 == null) {
          p.hyc();
        }
        localObject4 = ((ViewPropertyAnimator)localObject3).translationY(f1 - ((View)localObject4).getPaddingTop());
        if (localObject4 != null)
        {
          f1 = this.CRV[0];
          View localView = this.CRS;
          if (localView == null) {
            p.hyc();
          }
          ((ViewPropertyAnimator)localObject4).translationX(f1 - localView.getPaddingLeft());
        }
      }
      if (localObject3 == null) {
        break label732;
      }
      localObject3 = ((ViewPropertyAnimator)localObject3).alpha(0.0F);
      if (localObject3 == null) {
        break label732;
      }
      localObject3 = ((ViewPropertyAnimator)localObject3).setDuration(300L);
      if (localObject3 == null) {
        break label732;
      }
      localObject1 = ((ViewPropertyAnimator)localObject3).setListener((Animator.AnimatorListener)new g(this, paramBoolean, (kotlin.g.a.a)localObject1));
      if (localObject1 == null) {
        break label732;
      }
      localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new h(this, paramBoolean, (z.c)localObject2, localc));
      if (localObject1 == null) {
        break label732;
      }
      ((ViewPropertyAnimator)localObject1).start();
      AppMethodBeat.o(240662);
      return;
      paramBoolean = false;
      break;
      label721:
      ((kotlin.g.a.a)localObject1).invoke();
    }
    label732:
    AppMethodBeat.o(240662);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$animateViewAlpha$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(240644);
      AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationCancel(paramAnimator);
        AppMethodBeat.o(240644);
        return;
      }
      AppMethodBeat.o(240644);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240643);
      Object localObject = this.hCI;
      if (this.rti) {}
      for (int i = 0;; i = 8)
      {
        ((View)localObject).setVisibility(i);
        localObject = paramAnimatorListenerAdapter;
        if (localObject == null) {
          break;
        }
        ((AnimatorListenerAdapter)localObject).onAnimationEnd(paramAnimator);
        AppMethodBeat.o(240643);
        return;
      }
      AppMethodBeat.o(240643);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(240647);
      AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationPause(paramAnimator);
        AppMethodBeat.o(240647);
        return;
      }
      AppMethodBeat.o(240647);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(240645);
      AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationRepeat(paramAnimator);
        AppMethodBeat.o(240645);
        return;
      }
      AppMethodBeat.o(240645);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(240648);
      AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationResume(paramAnimator);
        AppMethodBeat.o(240648);
        return;
      }
      AppMethodBeat.o(240648);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(240646);
      AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationStart(paramAnimator);
        AppMethodBeat.o(240646);
        return;
      }
      AppMethodBeat.o(240646);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(ScanInfoMaskView paramScanInfoMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(240650);
      this.CSj.requestLayout();
      AppMethodBeat.o(240650);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(ScanInfoMaskView paramScanInfoMaskView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(240651);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(240651);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      ScanInfoMaskView.a(this.CSj).setAlpha(f1);
      ScanInfoMaskView.b(this.CSj).setAlpha(f1);
      float f2 = f1;
      float f3 = f1;
      float f4 = f2;
      float f5 = f2;
      ScanInfoMaskView.c(this.CSj).setTranslationX(f2 + (0.0F - f3) * f1);
      ScanInfoMaskView.c(this.CSj).setTranslationY(f1 * (0.0F - f5) + f4);
      AppMethodBeat.o(240651);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(ScanInfoMaskView paramScanInfoMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(240652);
      this.CSj.requestLayout();
      AppMethodBeat.o(240652);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$showLoadingViewInternal$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-scan_release"})
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(boolean paramBoolean, kotlin.g.a.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(240654);
      super.onAnimationCancel(paramAnimator);
      ScanInfoMaskView.a(this.CSj, false);
      AppMethodBeat.o(240654);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240653);
      paramAnimator = ScanInfoMaskView.g(this.CSj);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = ScanInfoMaskView.g(this.CSj);
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.animate();
        if (paramAnimator != null) {
          paramAnimator.setListener(null);
        }
      }
      ScanInfoMaskView.a(this.CSj, false);
      if (paramBoolean) {
        this.CSm.invoke();
      }
      AppMethodBeat.o(240653);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    h(ScanInfoMaskView paramScanInfoMaskView, boolean paramBoolean, z.c paramc1, z.c paramc2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(240655);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(240655);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      ScanInfoMaskView.h(this.CSj).setAlpha(f1);
      paramValueAnimator = ScanInfoMaskView.g(this.CSj);
      if (paramValueAnimator != null) {
        paramValueAnimator.setVisibility(0);
      }
      if (paramBoolean)
      {
        ScanInfoMaskView.a(this.CSj, true);
        float f2 = this.CSn.SYD;
        float f3 = this.CSn.SYD;
        float f4 = localc.SYD;
        float f5 = localc.SYD;
        ScanInfoMaskView.f(this.CSj).setTranslationX(f2 + (0.0F - f3) * f1);
        ScanInfoMaskView.f(this.CSj).setTranslationY(f1 * (0.0F - f5) + f4);
      }
      AppMethodBeat.o(240655);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView
 * JD-Core Version:    0.7.0.1
 */