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
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import d.l;
import java.util.Timer;
import java.util.TimerTask;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScanSharedMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "darkCornerMask", "Landroid/widget/ImageView;", "flashSwitcher", "Lcom/tencent/mm/plugin/scanner/ui/ScannerFlashSwitcher;", "galleryButton", "Landroid/view/View;", "isFlashShow", "", "isTitleTimerCancelled", "onFlashSwitcherClickListener", "Landroid/view/View$OnClickListener;", "onGalleryClickListener", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "scanTips", "Landroid/widget/TextView;", "scanTitle", "showTitle", "titleTimer", "Ljava/util/Timer;", "animateAlpha", "", "view", "fromAlpha", "", "targetAlpha", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animateShow", "show", "animateShowScanTips", "cancelTitleAnimation", "cancelTitleTimer", "getFlashSwitcherView", "getGalleryButton", "getScanTipsView", "getScanTitleView", "init", "initTitleTimer", "onFlashStatusChanged", "onPreviewReady", "isSwitchTab", "onScanSuccess", "onViewReady", "release", "setFlashStatus", "setOnFlashSwitcherClickListener", "onClickListener", "setOnGalleryClickListener", "setScanRequest", "request", "setScanTips", "tips", "", "setScanTitle", "title", "setShowTitle", "showGalleryButton", "showScanTips", "startTitleAnimation", "Companion", "plugin-scan_release"})
public final class ScanSharedMaskView
  extends RelativeLayout
{
  public static final ScanSharedMaskView.a xkR;
  public BaseScanRequest xbO;
  public ScannerFlashSwitcher xbo;
  public TextView xkH;
  private TextView xkI;
  private ImageView xkJ;
  public View xkK;
  private View.OnClickListener xkL;
  private View.OnClickListener xkM;
  private Timer xkN;
  private boolean xkO;
  public boolean xkP;
  public boolean xkQ;
  
  static
  {
    AppMethodBeat.i(52465);
    xkR = new ScanSharedMaskView.a((byte)0);
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
    this.xkQ = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494573, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131304333);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_title)");
    this.xkH = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131304332);
    k.g(paramAttributeSet, "view.findViewById(R.id.scan_tip_tv)");
    this.xkI = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131298922);
    k.g(paramAttributeSet, "view.findViewById(R.id.dark_corner_mask)");
    this.xkJ = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131304346);
    k.g(paramAttributeSet, "view.findViewById(R.id.scanner_flash_switcher)");
    this.xbo = ((ScannerFlashSwitcher)paramAttributeSet);
    paramContext = paramContext.findViewById(2131304516);
    k.g(paramContext, "view.findViewById(R.id.select_from_gallery)");
    this.xkK = paramContext;
    paramContext = this.xkK;
    if (paramContext == null) {
      k.aVY("galleryButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new ScanSharedMaskView.c(this));
    paramContext = this.xbo;
    if (paramContext == null) {
      k.aVY("flashSwitcher");
    }
    paramContext.setOnClickListener((View.OnClickListener)new ScanSharedMaskView.d(this));
    paramContext = this.xkH;
    if (paramContext == null) {
      k.aVY("scanTitle");
    }
    aj.a((Paint)paramContext.getPaint(), 0.8F);
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
  
  private final void qk(final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(170087);
    ac.d("MicroMsg.ScanSharedMaskView", "alvinluo animateScanTips show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (this.xbO != null))
    {
      localObject = this.xbO;
      if (localObject == null) {
        k.fOy();
      }
      if (((BaseScanRequest)localObject).wVY)
      {
        AppMethodBeat.o(170087);
        return;
      }
    }
    Object localObject = this.xkI;
    if (localObject == null) {
      k.aVY("scanTips");
    }
    if ((((TextView)localObject).getVisibility() == 0) && (paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    localObject = this.xkI;
    if (localObject == null) {
      k.aVY("scanTips");
    }
    if ((((TextView)localObject).getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    localObject = this.xkI;
    if (localObject == null) {
      k.aVY("scanTips");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.xkI;
    if (localObject == null) {
      k.aVY("scanTips");
    }
    if (paramBoolean)
    {
      f1 = 0.0F;
      ((TextView)localObject).setAlpha(f1);
      qg(true);
      localObject = this.xkI;
      if (localObject == null) {
        k.aVY("scanTips");
      }
      localObject = ((TextView)localObject).animate();
      if (localObject == null) {
        break label330;
      }
      if (!paramBoolean) {
        break label325;
      }
    }
    label325:
    for (float f1 = f2;; f1 = 0.0F)
    {
      localObject = ((ViewPropertyAnimator)localObject).alpha(f1);
      if (localObject == null) {
        break label330;
      }
      localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
      if (localObject == null) {
        break label330;
      }
      localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new b(this, paramBoolean));
      if (localObject == null) {
        break label330;
      }
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(170087);
      return;
      f1 = 1.0F;
      break;
    }
    label330:
    AppMethodBeat.o(170087);
  }
  
  public final void dBe()
  {
    AppMethodBeat.i(170081);
    ac.v("MicroMsg.ScanSharedMaskView", "alvinluo initTitleTimer");
    dBf();
    this.xkN = new Timer();
    Timer localTimer = this.xkN;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new e(this), 2000L);
    }
    this.xkO = false;
    AppMethodBeat.o(170081);
  }
  
  public final void dBf()
  {
    AppMethodBeat.i(170082);
    this.xkO = true;
    Timer localTimer = this.xkN;
    if (localTimer != null)
    {
      localTimer.cancel();
      AppMethodBeat.o(170082);
      return;
    }
    AppMethodBeat.o(170082);
  }
  
  public final void dBg()
  {
    AppMethodBeat.i(170084);
    ac.i("MicroMsg.ScanSharedMaskView", "alvinluo cancelTitleAnimation");
    Object localObject = this.xkH;
    if (localObject == null) {
      k.aVY("scanTitle");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    dBf();
    AppMethodBeat.o(170084);
  }
  
  public final ScannerFlashSwitcher getFlashSwitcherView()
  {
    AppMethodBeat.i(52455);
    ScannerFlashSwitcher localScannerFlashSwitcher = this.xbo;
    if (localScannerFlashSwitcher == null) {
      k.aVY("flashSwitcher");
    }
    AppMethodBeat.o(52455);
    return localScannerFlashSwitcher;
  }
  
  public final View getGalleryButton()
  {
    AppMethodBeat.i(52458);
    View localView = this.xkK;
    if (localView == null) {
      k.aVY("galleryButton");
    }
    AppMethodBeat.o(52458);
    return localView;
  }
  
  public final TextView getScanTipsView()
  {
    AppMethodBeat.i(52454);
    TextView localTextView = this.xkI;
    if (localTextView == null) {
      k.aVY("scanTips");
    }
    AppMethodBeat.o(52454);
    return localTextView;
  }
  
  public final TextView getScanTitleView()
  {
    AppMethodBeat.i(52452);
    TextView localTextView = this.xkH;
    if (localTextView == null) {
      k.aVY("scanTitle");
    }
    AppMethodBeat.o(52452);
    return localTextView;
  }
  
  public final void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(52459);
    if (!paramBoolean)
    {
      Object localObject = this.xkK;
      if (localObject == null) {
        k.aVY("galleryButton");
      }
      if (((View)localObject).getVisibility() == 0)
      {
        localObject = this.xkK;
        if (localObject == null) {
          k.aVY("galleryButton");
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
  
  public final void qg(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(199675);
    if ((paramBoolean) && (this.xbO != null))
    {
      localTextView = this.xkI;
      if (localTextView == null) {
        k.aVY("scanTips");
      }
      BaseScanRequest localBaseScanRequest = this.xbO;
      if (localBaseScanRequest == null) {
        k.fOy();
      }
      if ((!localBaseScanRequest.wVY) && (paramBoolean)) {}
      for (;;)
      {
        localTextView.setVisibility(i);
        AppMethodBeat.o(199675);
        return;
        i = 8;
      }
    }
    TextView localTextView = this.xkI;
    if (localTextView == null) {
      k.aVY("scanTips");
    }
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(199675);
      return;
    }
  }
  
  public final void qh(final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(170083);
    ac.i("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.xkH;
    if (localObject == null) {
      k.aVY("scanTitle");
    }
    if (paramBoolean)
    {
      f1 = 0.0F;
      ((TextView)localObject).setAlpha(f1);
      localObject = this.xkH;
      if (localObject == null) {
        k.aVY("scanTitle");
      }
      ((TextView)localObject).setVisibility(0);
      if (!paramBoolean) {
        break label206;
      }
    }
    label206:
    for (float f1 = f2;; f1 = 0.0F)
    {
      localObject = this.xkH;
      if (localObject == null) {
        k.aVY("scanTitle");
      }
      ((TextView)localObject).setShadowLayer(10.0F, 0.0F, 0.0F, getResources().getColor(2131099658));
      localObject = this.xkH;
      if (localObject == null) {
        k.aVY("scanTitle");
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
  
  public final void qi(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(170086);
    ac.i("MicroMsg.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.xkP != paramBoolean)
    {
      this.xkP = paramBoolean;
      if (paramBoolean) {
        break label59;
      }
    }
    label59:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      qk(paramBoolean);
      AppMethodBeat.o(170086);
      return;
    }
  }
  
  public final void qj(boolean paramBoolean)
  {
    AppMethodBeat.i(52460);
    ac.v("MicroMsg.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(getAlpha()) });
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
    ac.d("MicroMsg.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.xkP = paramBoolean;
    AppMethodBeat.o(170085);
  }
  
  public final void setOnFlashSwitcherClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52457);
    k.h(paramOnClickListener, "onClickListener");
    this.xkM = paramOnClickListener;
    AppMethodBeat.o(52457);
  }
  
  public final void setOnGalleryClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52456);
    k.h(paramOnClickListener, "onClickListener");
    this.xkL = paramOnClickListener;
    paramOnClickListener = this.xkK;
    if (paramOnClickListener == null) {
      k.aVY("galleryButton");
    }
    paramOnClickListener.setOnClickListener(this.xkL);
    AppMethodBeat.o(52456);
  }
  
  public final void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.xbO = paramBaseScanRequest;
  }
  
  public final void setScanTips(String paramString)
  {
    AppMethodBeat.i(52453);
    TextView localTextView = this.xkI;
    if (localTextView == null) {
      k.aVY("scanTips");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52453);
  }
  
  public final void setScanTitle(String paramString)
  {
    AppMethodBeat.i(52451);
    TextView localTextView = this.xkH;
    if (localTextView == null) {
      k.aVY("scanTitle");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52451);
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.xkQ = paramBoolean;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateShowScanTips$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(170076);
      ScanSharedMaskView.a(this.xkS, paramBoolean);
      AppMethodBeat.o(170076);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170075);
      ScanSharedMaskView.a(this.xkS, paramBoolean);
      AppMethodBeat.o(170075);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$initTitleTimer$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class e
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(170078);
      this.xkS.post((Runnable)new a(this));
      AppMethodBeat.o(170078);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanSharedMaskView.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(170077);
        if (ScanSharedMaskView.c(this.xkT.xkS))
        {
          AppMethodBeat.o(170077);
          return;
        }
        ScanSharedMaskView.d(this.xkT.xkS);
        AppMethodBeat.o(170077);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startTitleAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(170080);
      ac.v("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationCancel show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(170080);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      int i = 0;
      AppMethodBeat.i(170079);
      ac.v("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationEnd show: %b, isFlashShow: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(ScanSharedMaskView.e(this.xkS)) });
      paramAnimator = ScanSharedMaskView.f(this.xkS);
      if (paramBoolean) {}
      for (;;)
      {
        paramAnimator.setVisibility(i);
        if (!paramBoolean) {
          break;
        }
        ScanSharedMaskView.f(this.xkS).invalidate();
        ScanSharedMaskView.g(this.xkS);
        AppMethodBeat.o(170079);
        return;
        i = 8;
      }
      if (!ScanSharedMaskView.e(this.xkS)) {
        ScanSharedMaskView.h(this.xkS);
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