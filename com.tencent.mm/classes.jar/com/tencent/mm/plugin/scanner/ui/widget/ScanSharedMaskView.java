package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import d.g.b.k;
import d.l;
import java.util.Timer;
import java.util.TimerTask;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScanSharedMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "darkCornerMask", "Landroid/widget/ImageView;", "flashSwitcher", "Lcom/tencent/mm/plugin/scanner/ui/ScannerFlashSwitcher;", "galleryButton", "Landroid/view/View;", "isFlashShow", "", "isTitleTimerCancelled", "onFlashSwitcherClickListener", "Landroid/view/View$OnClickListener;", "onGalleryClickListener", "scanTips", "Landroid/widget/TextView;", "scanTitle", "showTitle", "titleTimer", "Ljava/util/Timer;", "animateAlpha", "", "view", "fromAlpha", "", "targetAlpha", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animateShow", "show", "animateShowScanTips", "cancelTitleAnimation", "cancelTitleTimer", "getFlashSwitcherView", "getGalleryButton", "getScanTipsView", "getScanTitleView", "init", "initTitleTimer", "onFlashStatusChanged", "onPreviewReady", "isSwitchTab", "onScanSuccess", "onViewReady", "release", "setFlashStatus", "setOnFlashSwitcherClickListener", "onClickListener", "setOnGalleryClickListener", "setScanTips", "tips", "", "setScanTitle", "title", "setShowTitle", "startTitleAnimation", "Companion", "plugin-scan_release"})
public final class ScanSharedMaskView
  extends RelativeLayout
{
  public static final ScanSharedMaskView.a vZL;
  public ScannerFlashSwitcher vQG;
  public TextView vZB;
  public TextView vZC;
  private ImageView vZD;
  public View vZE;
  private View.OnClickListener vZF;
  private View.OnClickListener vZG;
  private Timer vZH;
  private boolean vZI;
  public boolean vZJ;
  public boolean vZK;
  
  static
  {
    AppMethodBeat.i(52465);
    vZL = new ScanSharedMaskView.a((byte)0);
    AppMethodBeat.o(52465);
  }
  
  public ScanSharedMaskView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(52462);
    AppMethodBeat.o(52462);
  }
  
  public ScanSharedMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52463);
    AppMethodBeat.o(52463);
  }
  
  public ScanSharedMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52464);
    this.vZK = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494573, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131304333);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_title)");
    this.vZB = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131304332);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_tip_tv)");
    this.vZC = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131298922);
    k.g(paramAttributeSet, "view.findViewById(R.id.dark_corner_mask)");
    this.vZD = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131304346);
    k.g(paramAttributeSet, "view.findViewById(R.id.scanner_flash_switcher)");
    this.vQG = ((ScannerFlashSwitcher)paramAttributeSet);
    paramContext = paramContext.findViewById(2131304516);
    k.g(paramContext, "view.findViewById(R.id.select_from_gallery)");
    this.vZE = paramContext;
    paramContext = this.vZE;
    if (paramContext == null) {
      k.aPZ("galleryButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new c(this));
    paramContext = this.vQG;
    if (paramContext == null) {
      k.aPZ("flashSwitcher");
    }
    paramContext.setOnClickListener((View.OnClickListener)new d(this));
    paramContext = this.vZB;
    if (paramContext == null) {
      k.aPZ("scanTitle");
    }
    ai.a((Paint)paramContext.getPaint(), 0.8F);
    AppMethodBeat.o(52464);
  }
  
  private static void d(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(52461);
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator = localViewPropertyAnimator.setListener(null);
      if (localViewPropertyAnimator != null) {
        localViewPropertyAnimator.cancel();
      }
    }
    paramView.setAlpha(paramFloat1);
    paramView = paramView.animate();
    if (paramView != null)
    {
      paramView = paramView.alpha(paramFloat2);
      if (paramView != null)
      {
        paramView = paramView.setDuration(200L);
        if (paramView != null)
        {
          paramView = paramView.setInterpolator((TimeInterpolator)new LinearInterpolator());
          if (paramView != null)
          {
            paramView = paramView.setListener(null);
            if (paramView != null)
            {
              paramView.start();
              AppMethodBeat.o(52461);
              return;
            }
          }
        }
      }
    }
    AppMethodBeat.o(52461);
  }
  
  private final void pl(final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(170087);
    ad.d("MicroMsg.ScanSharedMaskView", "alvinluo animateScanTips show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.vZC;
    if (localObject == null) {
      k.aPZ("scanTips");
    }
    if ((((TextView)localObject).getVisibility() == 0) && (paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    localObject = this.vZC;
    if (localObject == null) {
      k.aPZ("scanTips");
    }
    if ((((TextView)localObject).getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    localObject = this.vZC;
    if (localObject == null) {
      k.aPZ("scanTips");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.vZC;
    if (localObject == null) {
      k.aPZ("scanTips");
    }
    if (paramBoolean)
    {
      f1 = 0.0F;
      ((TextView)localObject).setAlpha(f1);
      localObject = this.vZC;
      if (localObject == null) {
        k.aPZ("scanTips");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.vZC;
      if (localObject == null) {
        k.aPZ("scanTips");
      }
      localObject = ((TextView)localObject).animate();
      if (localObject == null) {
        break label308;
      }
      if (!paramBoolean) {
        break label303;
      }
    }
    label303:
    for (float f1 = f2;; f1 = 0.0F)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(f1);
      if (localObject == null) {
        break label308;
      }
      localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
      if (localObject == null) {
        break label308;
      }
      localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new b(this, paramBoolean));
      if (localObject == null) {
        break label308;
      }
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(170087);
      return;
      f1 = 1.0F;
      break;
    }
    label308:
    AppMethodBeat.o(170087);
  }
  
  public final void dmW()
  {
    AppMethodBeat.i(170081);
    ad.v("MicroMsg.ScanSharedMaskView", "alvinluo initTitleTimer");
    dmX();
    this.vZH = new Timer();
    Timer localTimer = this.vZH;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new e(this), 2000L);
    }
    this.vZI = false;
    AppMethodBeat.o(170081);
  }
  
  public final void dmX()
  {
    AppMethodBeat.i(170082);
    this.vZI = true;
    Timer localTimer = this.vZH;
    if (localTimer != null)
    {
      localTimer.cancel();
      AppMethodBeat.o(170082);
      return;
    }
    AppMethodBeat.o(170082);
  }
  
  public final void dmY()
  {
    AppMethodBeat.i(170084);
    ad.i("MicroMsg.ScanSharedMaskView", "alvinluo cancelTitleAnimation");
    Object localObject = this.vZB;
    if (localObject == null) {
      k.aPZ("scanTitle");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    dmX();
    AppMethodBeat.o(170084);
  }
  
  public final ScannerFlashSwitcher getFlashSwitcherView()
  {
    AppMethodBeat.i(52455);
    ScannerFlashSwitcher localScannerFlashSwitcher = this.vQG;
    if (localScannerFlashSwitcher == null) {
      k.aPZ("flashSwitcher");
    }
    AppMethodBeat.o(52455);
    return localScannerFlashSwitcher;
  }
  
  public final View getGalleryButton()
  {
    AppMethodBeat.i(52458);
    View localView = this.vZE;
    if (localView == null) {
      k.aPZ("galleryButton");
    }
    AppMethodBeat.o(52458);
    return localView;
  }
  
  public final TextView getScanTipsView()
  {
    AppMethodBeat.i(52454);
    TextView localTextView = this.vZC;
    if (localTextView == null) {
      k.aPZ("scanTips");
    }
    AppMethodBeat.o(52454);
    return localTextView;
  }
  
  public final TextView getScanTitleView()
  {
    AppMethodBeat.i(52452);
    TextView localTextView = this.vZB;
    if (localTextView == null) {
      k.aPZ("scanTitle");
    }
    AppMethodBeat.o(52452);
    return localTextView;
  }
  
  public final void pd(boolean paramBoolean)
  {
    AppMethodBeat.i(52459);
    if (!paramBoolean)
    {
      Object localObject = this.vZE;
      if (localObject == null) {
        k.aPZ("galleryButton");
      }
      if (((View)localObject).getVisibility() == 0)
      {
        localObject = this.vZE;
        if (localObject == null) {
          k.aPZ("galleryButton");
        }
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setListener(null);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)new LinearInterpolator());
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setUpdateListener(null);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
                  if (localObject != null)
                  {
                    ((ViewPropertyAnimator)localObject).start();
                    AppMethodBeat.o(52459);
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(52459);
  }
  
  public final void pi(final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(170083);
    ad.i("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.vZB;
    if (localObject == null) {
      k.aPZ("scanTitle");
    }
    if (paramBoolean)
    {
      f1 = 0.0F;
      ((TextView)localObject).setAlpha(f1);
      localObject = this.vZB;
      if (localObject == null) {
        k.aPZ("scanTitle");
      }
      ((TextView)localObject).setVisibility(0);
      if (!paramBoolean) {
        break label206;
      }
    }
    label206:
    for (float f1 = f2;; f1 = 0.0F)
    {
      localObject = this.vZB;
      if (localObject == null) {
        k.aPZ("scanTitle");
      }
      ((TextView)localObject).setShadowLayer(10.0F, 0.0F, 0.0F, getResources().getColor(2131099658));
      localObject = this.vZB;
      if (localObject == null) {
        k.aPZ("scanTitle");
      }
      localObject = ((TextView)localObject).animate();
      if (localObject == null) {
        break label211;
      }
      localObject = ((ViewPropertyAnimator)localObject).alpha(f1);
      if (localObject == null) {
        break label211;
      }
      localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
      if (localObject == null) {
        break label211;
      }
      ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new f(this, paramBoolean));
      AppMethodBeat.o(170083);
      return;
      f1 = 1.0F;
      break;
    }
    label211:
    AppMethodBeat.o(170083);
  }
  
  public final void pj(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(170086);
    ad.i("MicroMsg.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.vZJ != paramBoolean)
    {
      this.vZJ = paramBoolean;
      if (paramBoolean) {
        break label59;
      }
    }
    label59:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      pl(paramBoolean);
      AppMethodBeat.o(170086);
      return;
    }
  }
  
  public final void pk(boolean paramBoolean)
  {
    AppMethodBeat.i(52460);
    ad.v("MicroMsg.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(getAlpha()) });
    if (paramBoolean)
    {
      if (getAlpha() == 0.0F)
      {
        d((View)this, 0.0F, 1.0F);
        AppMethodBeat.o(52460);
      }
    }
    else if (getAlpha() == 1.0F) {
      d((View)this, 1.0F, 0.0F);
    }
    AppMethodBeat.o(52460);
  }
  
  public final void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(170085);
    ad.d("MicroMsg.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vZJ = paramBoolean;
    AppMethodBeat.o(170085);
  }
  
  public final void setOnFlashSwitcherClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52457);
    k.h(paramOnClickListener, "onClickListener");
    this.vZG = paramOnClickListener;
    AppMethodBeat.o(52457);
  }
  
  public final void setOnGalleryClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52456);
    k.h(paramOnClickListener, "onClickListener");
    this.vZF = paramOnClickListener;
    paramOnClickListener = this.vZE;
    if (paramOnClickListener == null) {
      k.aPZ("galleryButton");
    }
    paramOnClickListener.setOnClickListener(this.vZF);
    AppMethodBeat.o(52456);
  }
  
  public final void setScanTips(String paramString)
  {
    AppMethodBeat.i(52453);
    TextView localTextView = this.vZC;
    if (localTextView == null) {
      k.aPZ("scanTips");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52453);
  }
  
  public final void setScanTitle(String paramString)
  {
    AppMethodBeat.i(52451);
    TextView localTextView = this.vZB;
    if (localTextView == null) {
      k.aPZ("scanTitle");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52451);
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.vZK = paramBoolean;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateShowScanTips$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(170076);
      paramAnimator = ScanSharedMaskView.i(this.vZM);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        paramAnimator.setVisibility(i);
        AppMethodBeat.o(170076);
        return;
      }
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170075);
      paramAnimator = ScanSharedMaskView.i(this.vZM);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        paramAnimator.setVisibility(i);
        AppMethodBeat.o(170075);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ScanSharedMaskView paramScanSharedMaskView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52449);
      View.OnClickListener localOnClickListener = ScanSharedMaskView.a(this.vZM);
      if (localOnClickListener != null)
      {
        localOnClickListener.onClick(paramView);
        AppMethodBeat.o(52449);
        return;
      }
      AppMethodBeat.o(52449);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ScanSharedMaskView paramScanSharedMaskView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52450);
      View.OnClickListener localOnClickListener = ScanSharedMaskView.b(this.vZM);
      if (localOnClickListener != null)
      {
        localOnClickListener.onClick(paramView);
        AppMethodBeat.o(52450);
        return;
      }
      AppMethodBeat.o(52450);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$initTitleTimer$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class e
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(170078);
      this.vZM.post((Runnable)new a(this));
      AppMethodBeat.o(170078);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanSharedMaskView.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(170077);
        if (ScanSharedMaskView.c(this.vZN.vZM))
        {
          AppMethodBeat.o(170077);
          return;
        }
        ScanSharedMaskView.d(this.vZN.vZM);
        AppMethodBeat.o(170077);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startTitleAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(170080);
      ad.v("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationCancel show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(170080);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      int i = 0;
      AppMethodBeat.i(170079);
      ad.v("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationEnd show: %b, isFlashShow: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(ScanSharedMaskView.e(this.vZM)) });
      paramAnimator = ScanSharedMaskView.f(this.vZM);
      if (paramBoolean) {}
      for (;;)
      {
        paramAnimator.setVisibility(i);
        if (!paramBoolean) {
          break;
        }
        ScanSharedMaskView.f(this.vZM).invalidate();
        ScanSharedMaskView.g(this.vZM);
        AppMethodBeat.o(170079);
        return;
        i = 8;
      }
      if (!ScanSharedMaskView.e(this.vZM)) {
        ScanSharedMaskView.h(this.vZM);
      }
      AppMethodBeat.o(170079);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView
 * JD-Core Version:    0.7.0.1
 */