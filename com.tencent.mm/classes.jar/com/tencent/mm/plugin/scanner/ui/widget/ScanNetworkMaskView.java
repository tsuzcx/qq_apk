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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.c;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "errIconLocation", "", "errorIcon", "Landroid/view/View;", "hasGetErrIconLocation", "", "hasGetLoadingIconLocation", "isLoadingShow", "isNoNetworkShowing", "loadingAnimation", "Landroid/view/animation/Animation;", "loadingIcon", "loadingIconLocation", "loadingLayout", "needAnimateWeakNetworkView", "noNetworkLayout", "pendingShowLoading", "pendingShowNoNetwork", "root", "successMark", "init", "", "isShowLoadingView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setSuccessMarkView", "showBadNetworkViewInternal", "withAnimation", "showBadNetworkViewWithAnimation", "showLoadingView", "show", "showLoadingViewInternal", "showNoNetworkView", "showTips", "showWeakNetworkView", "updateNoNetworkTipsLayout", "Companion", "plugin-scan_release"})
public final class ScanNetworkMaskView
  extends LinearLayout
{
  public static final ScanNetworkMaskView.a yyp;
  private View fOB;
  public View tAl;
  public boolean ynR;
  public View yyc;
  private View yyd;
  public int[] yye;
  public Animation yyf;
  private boolean yyg;
  public View yyh;
  private View yyi;
  public int[] yyj;
  private boolean yyk;
  public boolean yyl;
  private boolean yym;
  public boolean yyn;
  public boolean yyo;
  
  static
  {
    AppMethodBeat.i(52422);
    yyp = new ScanNetworkMaskView.a((byte)0);
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
    this.yye = new int[2];
    this.yyj = new int[2];
    this.yyo = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494568, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131304241);
    p.g(paramAttributeSet, "view.findViewById(R.id.root_container)");
    this.fOB = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304316);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_layout)");
    this.tAl = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304315);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_icon)");
    this.yyd = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304325);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_no_network_layout)");
    this.yyh = paramAttributeSet;
    paramContext = paramContext.findViewById(2131304324);
    p.g(paramContext, "view.findViewById(R.id.scan_no_network_error_icon)");
    this.yyi = paramContext;
    paramContext = this.fOB;
    if (paramContext == null) {
      p.bcb("root");
    }
    paramContext.setOnTouchListener((View.OnTouchListener)ScanNetworkMaskView.b.yyq);
    AppMethodBeat.o(52421);
  }
  
  private final void dMz()
  {
    AppMethodBeat.i(52417);
    ad.i("MicroMsg.ScanNetworkMaskView", "alvinluo showBadNetworkViewWithAnimation");
    Object localObject = this.yyc;
    if (localObject == null) {
      p.gfZ();
    }
    final float f1 = ((View)localObject).getTranslationX() - this.yyj[0];
    localObject = this.yyc;
    if (localObject == null) {
      p.gfZ();
    }
    final float f2 = ((View)localObject).getTranslationY() - this.yyj[1];
    localObject = this.yyi;
    if (localObject == null) {
      p.bcb("errorIcon");
    }
    ((View)localObject).setTranslationX(f1);
    localObject = this.yyi;
    if (localObject == null) {
      p.bcb("errorIcon");
    }
    ((View)localObject).setTranslationY(f2);
    localObject = this.yyh;
    if (localObject == null) {
      p.bcb("noNetworkLayout");
    }
    ((View)localObject).setAlpha(0.0F);
    localObject = this.yyc;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((View)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(this.yyj[1]);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationX(this.yyj[0]);
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
    if (!this.yyk)
    {
      localView = this.yyi;
      if (localView == null) {
        p.bcb("errorIcon");
      }
      localView.getLocationInWindow(this.yyj);
    }
    if (!this.yyg)
    {
      localView = this.yyd;
      if (localView == null) {
        p.bcb("loadingIcon");
      }
      localView.getLocationInWindow(this.yye);
    }
    ad.d("MicroMsg.ScanNetworkMaskView", "alvinluo onMeasure errorIcon location: %d, %d, loadingIcon location: %d, %d, pendingShowNoNetwork: %b, pendingShowLoading: %b", new Object[] { Integer.valueOf(this.yyj[0]), Integer.valueOf(this.yyj[1]), Integer.valueOf(this.yye[0]), Integer.valueOf(this.yye[1]), Boolean.valueOf(this.yyl), Boolean.valueOf(this.yyn) });
    if ((this.yyj[0] != 0) || (this.yyj[1] != 0))
    {
      this.yyk = true;
      if (!this.yyl) {
        break label228;
      }
      qD(true);
    }
    while ((this.yye[0] != 0) || (this.yye[1] != 0))
    {
      this.yyg = true;
      if (this.yyn)
      {
        qE(true);
        AppMethodBeat.o(52415);
        return;
        label228:
        if (!this.yym)
        {
          localView = this.yyh;
          if (localView == null) {
            p.bcb("noNetworkLayout");
          }
          localView.setVisibility(8);
        }
      }
      else if (!this.ynR)
      {
        localView = this.tAl;
        if (localView == null) {
          p.bcb("loadingLayout");
        }
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(52415);
  }
  
  public final void qC(boolean paramBoolean)
  {
    AppMethodBeat.i(186401);
    Object localObject = this.yyh;
    if (localObject == null) {
      p.bcb("noNetworkLayout");
    }
    localObject = (TextView)((View)localObject).findViewById(2131308191);
    if (localObject != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        ((TextView)localObject).setVisibility(i);
        AppMethodBeat.o(186401);
        return;
      }
    }
    AppMethodBeat.o(186401);
  }
  
  public final void qD(boolean paramBoolean)
  {
    AppMethodBeat.i(52416);
    this.yyl = false;
    this.yym = true;
    setVisibility(0);
    View localView = this.yyh;
    if (localView == null) {
      p.bcb("noNetworkLayout");
    }
    localView.setVisibility(0);
    localView = this.tAl;
    if (localView == null) {
      p.bcb("loadingLayout");
    }
    localView.setVisibility(8);
    if (!paramBoolean)
    {
      setVisibility(0);
      localView = this.yyh;
      if (localView == null) {
        p.bcb("noNetworkLayout");
      }
      localView.setAlpha(1.0F);
      AppMethodBeat.o(52416);
      return;
    }
    dMz();
    AppMethodBeat.o(52416);
  }
  
  public final void qE(final boolean paramBoolean)
  {
    AppMethodBeat.i(52419);
    ad.d("MicroMsg.ScanNetworkMaskView", "alvinluo showLoadingViewInternal withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.yyn = false;
    this.ynR = true;
    this.yyo = false;
    Object localObject1 = (a)new f(this);
    setVisibility(0);
    Object localObject2 = this.yyh;
    if (localObject2 == null) {
      p.bcb("noNetworkLayout");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = this.tAl;
    if (localObject2 == null) {
      p.bcb("loadingLayout");
    }
    ((View)localObject2).setVisibility(0);
    localObject2 = this.yyf;
    if (localObject2 != null) {
      ((Animation)localObject2).cancel();
    }
    if (!paramBoolean)
    {
      localObject2 = this.tAl;
      if (localObject2 == null) {
        p.bcb("loadingLayout");
      }
      ((View)localObject2).setAlpha(1.0F);
      ((a)localObject1).invoke();
      AppMethodBeat.o(52419);
      return;
    }
    localObject2 = this.tAl;
    if (localObject2 == null) {
      p.bcb("loadingLayout");
    }
    ((View)localObject2).setAlpha(0.0F);
    localObject2 = this.yyc;
    if (localObject2 == null) {
      p.gfZ();
    }
    final y.c localc;
    Object localObject3;
    if (((View)localObject2).getVisibility() == 0)
    {
      paramBoolean = true;
      localObject2 = new y.c();
      ((y.c)localObject2).MLS = 0.0F;
      localc = new y.c();
      localc.MLS = 0.0F;
      if (!paramBoolean) {
        break label532;
      }
      localObject3 = this.yyc;
      if (localObject3 == null) {
        p.gfZ();
      }
      ((y.c)localObject2).MLS = (((View)localObject3).getTranslationX() - this.yye[0]);
      localObject3 = this.yyc;
      if (localObject3 == null) {
        p.gfZ();
      }
      localc.MLS = (((View)localObject3).getTranslationY() - this.yye[1]);
      localObject3 = this.yyd;
      if (localObject3 == null) {
        p.bcb("loadingIcon");
      }
      ((View)localObject3).setTranslationX(((y.c)localObject2).MLS);
      localObject3 = this.yyd;
      if (localObject3 == null) {
        p.bcb("loadingIcon");
      }
      ((View)localObject3).setTranslationY(localc.MLS);
    }
    for (;;)
    {
      ad.d("MicroMsg.ScanNetworkMaskView", "alvinluo showLoadingViewInternal needDoTranslation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject3 = this.yyc;
      if (localObject3 == null) {
        p.gfZ();
      }
      localObject3 = ((View)localObject3).animate();
      if (localObject3 == null) {
        break label542;
      }
      if (paramBoolean)
      {
        Object localObject4 = this.yyc;
        if (localObject4 == null) {
          p.gfZ();
        }
        ((View)localObject4).setVisibility(0);
        localObject4 = ((ViewPropertyAnimator)localObject3).translationY(this.yyj[1]);
        if (localObject4 != null) {
          ((ViewPropertyAnimator)localObject4).translationX(this.yyj[0]);
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
    this.yyc = paramView;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      ScanNetworkMaskView.a(this.yyr).setAlpha(f1);
      float f2 = f1;
      float f3 = f1;
      float f4 = f2;
      float f5 = f2;
      ScanNetworkMaskView.b(this.yyr).setTranslationX(f2 + (0.0F - f3) * f1);
      ScanNetworkMaskView.b(this.yyr).setTranslationY(f1 * (0.0F - f5) + f4);
      AppMethodBeat.o(52411);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView$showLoadingViewInternal$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean, a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52412);
      paramAnimator = ScanNetworkMaskView.e(this.yyr);
      if (paramAnimator == null) {
        p.gfZ();
      }
      paramAnimator.setVisibility(8);
      if (paramBoolean) {
        this.yyv.invoke();
      }
      AppMethodBeat.o(52412);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      ScanNetworkMaskView.f(this.yyr).setAlpha(f1);
      if (paramBoolean)
      {
        float f2 = this.yyw.MLS;
        float f3 = this.yyw.MLS;
        float f4 = localc.MLS;
        float f5 = localc.MLS;
        ScanNetworkMaskView.d(this.yyr).setTranslationX(f2 + (0.0F - f3) * f1);
        ScanNetworkMaskView.d(this.yyr).setTranslationY(f1 * (0.0F - f5) + f4);
      }
      AppMethodBeat.o(52413);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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