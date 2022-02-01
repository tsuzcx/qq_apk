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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.b.k;
import d.g.b.v.b;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "errIconLocation", "", "errorIcon", "Landroid/view/View;", "hasGetErrIconLocation", "", "hasGetLoadingIconLocation", "isLoadingShow", "isNoNetworkShowing", "loadingAnimation", "Landroid/view/animation/Animation;", "loadingIcon", "loadingIconLocation", "loadingLayout", "needAnimateWeakNetworkView", "noNetworkLayout", "pendingShowLoading", "pendingShowNoNetwork", "root", "successMark", "init", "", "isShowLoadingView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setSuccessMarkView", "showBadNetworkViewInternal", "withAnimation", "showBadNetworkViewWithAnimation", "showLoadingView", "show", "showLoadingViewInternal", "showNoNetworkView", "showWeakNetworkView", "Companion", "plugin-scan_release"})
public final class ScanNetworkMaskView
  extends LinearLayout
{
  public static final a vZh;
  private View frN;
  public View ruE;
  public boolean vPm;
  public View vYU;
  private View vYV;
  public int[] vYW;
  public Animation vYX;
  private boolean vYY;
  public View vYZ;
  private View vZa;
  public int[] vZb;
  private boolean vZc;
  public boolean vZd;
  private boolean vZe;
  public boolean vZf;
  public boolean vZg;
  
  static
  {
    AppMethodBeat.i(52422);
    vZh = new a((byte)0);
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
    this.vYW = new int[2];
    this.vZb = new int[2];
    this.vZg = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494568, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131304241);
    k.g(paramAttributeSet, "view.findViewById(R.id.root_container)");
    this.frN = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304316);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_layout)");
    this.ruE = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304315);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_loading_icon)");
    this.vYV = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131304325);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_no_network_layout)");
    this.vYZ = paramAttributeSet;
    paramContext = paramContext.findViewById(2131304324);
    k.g(paramContext, "view.findViewById(R.id.scan_no_network_error_icon)");
    this.vZa = paramContext;
    paramContext = this.frN;
    if (paramContext == null) {
      k.aPZ("root");
    }
    paramContext.setOnTouchListener((View.OnTouchListener)ScanNetworkMaskView.b.vZi);
    AppMethodBeat.o(52421);
  }
  
  private final void dmT()
  {
    AppMethodBeat.i(52417);
    ad.i("MicroMsg.ScanNetworkMaskView", "alvinluo showBadNetworkViewWithAnimation");
    Object localObject = this.vYU;
    if (localObject == null) {
      k.fvU();
    }
    final float f1 = ((View)localObject).getTranslationX() - this.vZb[0];
    localObject = this.vYU;
    if (localObject == null) {
      k.fvU();
    }
    final float f2 = ((View)localObject).getTranslationY() - this.vZb[1];
    localObject = this.vZa;
    if (localObject == null) {
      k.aPZ("errorIcon");
    }
    ((View)localObject).setTranslationX(f1);
    localObject = this.vZa;
    if (localObject == null) {
      k.aPZ("errorIcon");
    }
    ((View)localObject).setTranslationY(f2);
    localObject = this.vYZ;
    if (localObject == null) {
      k.aPZ("noNetworkLayout");
    }
    ((View)localObject).setAlpha(0.0F);
    localObject = this.vYU;
    if (localObject == null) {
      k.fvU();
    }
    localObject = ((View)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(this.vZb[1]);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationX(this.vZb[0]);
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
    if (!this.vZc)
    {
      localView = this.vZa;
      if (localView == null) {
        k.aPZ("errorIcon");
      }
      localView.getLocationInWindow(this.vZb);
    }
    if (!this.vYY)
    {
      localView = this.vYV;
      if (localView == null) {
        k.aPZ("loadingIcon");
      }
      localView.getLocationInWindow(this.vYW);
    }
    ad.d("MicroMsg.ScanNetworkMaskView", "alvinluo onMeasure errorIcon location: %d, %d, loadingIcon location: %d, %d, pendingShowNoNetwork: %b, pendingShowLoading: %b", new Object[] { Integer.valueOf(this.vZb[0]), Integer.valueOf(this.vZb[1]), Integer.valueOf(this.vYW[0]), Integer.valueOf(this.vYW[1]), Boolean.valueOf(this.vZd), Boolean.valueOf(this.vZf) });
    if ((this.vZb[0] != 0) || (this.vZb[1] != 0))
    {
      this.vZc = true;
      if (!this.vZd) {
        break label228;
      }
      pg(true);
    }
    while ((this.vYW[0] != 0) || (this.vYW[1] != 0))
    {
      this.vYY = true;
      if (this.vZf)
      {
        ph(true);
        AppMethodBeat.o(52415);
        return;
        label228:
        if (!this.vZe)
        {
          localView = this.vYZ;
          if (localView == null) {
            k.aPZ("noNetworkLayout");
          }
          localView.setVisibility(8);
        }
      }
      else if (!this.vPm)
      {
        localView = this.ruE;
        if (localView == null) {
          k.aPZ("loadingLayout");
        }
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(52415);
  }
  
  public final void pg(boolean paramBoolean)
  {
    AppMethodBeat.i(52416);
    this.vZd = false;
    this.vZe = true;
    setVisibility(0);
    View localView = this.vYZ;
    if (localView == null) {
      k.aPZ("noNetworkLayout");
    }
    localView.setVisibility(0);
    localView = this.ruE;
    if (localView == null) {
      k.aPZ("loadingLayout");
    }
    localView.setVisibility(8);
    if (!paramBoolean)
    {
      setVisibility(0);
      localView = this.vYZ;
      if (localView == null) {
        k.aPZ("noNetworkLayout");
      }
      localView.setAlpha(1.0F);
      AppMethodBeat.o(52416);
      return;
    }
    dmT();
    AppMethodBeat.o(52416);
  }
  
  public final void ph(final boolean paramBoolean)
  {
    AppMethodBeat.i(52419);
    ad.d("MicroMsg.ScanNetworkMaskView", "alvinluo showLoadingViewInternal withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vZf = false;
    this.vPm = true;
    this.vZg = false;
    Object localObject1 = (a)new f(this);
    setVisibility(0);
    Object localObject2 = this.vYZ;
    if (localObject2 == null) {
      k.aPZ("noNetworkLayout");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = this.ruE;
    if (localObject2 == null) {
      k.aPZ("loadingLayout");
    }
    ((View)localObject2).setVisibility(0);
    localObject2 = this.vYX;
    if (localObject2 != null) {
      ((Animation)localObject2).cancel();
    }
    if (!paramBoolean)
    {
      localObject2 = this.ruE;
      if (localObject2 == null) {
        k.aPZ("loadingLayout");
      }
      ((View)localObject2).setAlpha(1.0F);
      ((a)localObject1).invoke();
      AppMethodBeat.o(52419);
      return;
    }
    localObject2 = this.ruE;
    if (localObject2 == null) {
      k.aPZ("loadingLayout");
    }
    ((View)localObject2).setAlpha(0.0F);
    localObject2 = this.vYU;
    if (localObject2 == null) {
      k.fvU();
    }
    final v.b localb;
    Object localObject3;
    if (((View)localObject2).getVisibility() == 0)
    {
      paramBoolean = true;
      localObject2 = new v.b();
      ((v.b)localObject2).Jht = 0.0F;
      localb = new v.b();
      localb.Jht = 0.0F;
      if (!paramBoolean) {
        break label532;
      }
      localObject3 = this.vYU;
      if (localObject3 == null) {
        k.fvU();
      }
      ((v.b)localObject2).Jht = (((View)localObject3).getTranslationX() - this.vYW[0]);
      localObject3 = this.vYU;
      if (localObject3 == null) {
        k.fvU();
      }
      localb.Jht = (((View)localObject3).getTranslationY() - this.vYW[1]);
      localObject3 = this.vYV;
      if (localObject3 == null) {
        k.aPZ("loadingIcon");
      }
      ((View)localObject3).setTranslationX(((v.b)localObject2).Jht);
      localObject3 = this.vYV;
      if (localObject3 == null) {
        k.aPZ("loadingIcon");
      }
      ((View)localObject3).setTranslationY(localb.Jht);
    }
    for (;;)
    {
      ad.d("MicroMsg.ScanNetworkMaskView", "alvinluo showLoadingViewInternal needDoTranslation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject3 = this.vYU;
      if (localObject3 == null) {
        k.fvU();
      }
      localObject3 = ((View)localObject3).animate();
      if (localObject3 == null) {
        break label542;
      }
      if (paramBoolean)
      {
        Object localObject4 = this.vYU;
        if (localObject4 == null) {
          k.fvU();
        }
        ((View)localObject4).setVisibility(0);
        localObject4 = ((ViewPropertyAnimator)localObject3).translationY(this.vZb[1]);
        if (localObject4 != null) {
          ((ViewPropertyAnimator)localObject4).translationX(this.vZb[0]);
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
      localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this, paramBoolean, (v.b)localObject2, localb));
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
    this.vYU = paramView;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      ScanNetworkMaskView.a(this.vZj).setAlpha(f1);
      float f2 = f1;
      float f3 = f1;
      float f4 = f2;
      float f5 = f2;
      ScanNetworkMaskView.b(this.vZj).setTranslationX(f2 + (0.0F - f3) * f1);
      ScanNetworkMaskView.b(this.vZj).setTranslationY(f1 * (0.0F - f5) + f4);
      AppMethodBeat.o(52411);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView$showLoadingViewInternal$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(boolean paramBoolean, a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52412);
      paramAnimator = ScanNetworkMaskView.e(this.vZj);
      if (paramAnimator == null) {
        k.fvU();
      }
      paramAnimator.setVisibility(8);
      if (paramBoolean) {
        this.vZn.invoke();
      }
      AppMethodBeat.o(52412);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(ScanNetworkMaskView paramScanNetworkMaskView, boolean paramBoolean, v.b paramb1, v.b paramb2) {}
    
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
      ScanNetworkMaskView.f(this.vZj).setAlpha(f1);
      if (paramBoolean)
      {
        float f2 = this.vZo.Jht;
        float f3 = this.vZo.Jht;
        float f4 = localb.Jht;
        float f5 = localb.Jht;
        ScanNetworkMaskView.d(this.vZj).setTranslationX(f2 + (0.0F - f3) * f1);
        ScanNetworkMaskView.d(this.vZj).setTranslationY(f1 * (0.0F - f5) + f4);
      }
      AppMethodBeat.o(52413);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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