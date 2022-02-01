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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;
import java.util.Timer;
import java.util.TimerTask;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScanSharedMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "darkCornerMask", "Landroid/widget/ImageView;", "flashSwitcher", "Lcom/tencent/mm/plugin/scanner/ui/ScannerFlashSwitcher;", "galleryButton", "Landroid/view/View;", "isFlashShow", "", "isTitleTimerCancelled", "onFlashSwitcherClickListener", "Landroid/view/View$OnClickListener;", "onGalleryClickListener", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "scanTips", "Landroid/widget/TextView;", "scanTitle", "showTitle", "titleTimer", "Ljava/util/Timer;", "animateAlpha", "", "view", "fromAlpha", "", "targetAlpha", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animateShow", "show", "animateShowScanTips", "cancelTitleAnimation", "cancelTitleTimer", "getFlashSwitcherView", "getGalleryButton", "getScanTipsView", "getScanTitleView", "init", "initTitleTimer", "onFlashStatusChanged", "onPreviewReady", "isSwitchTab", "onScanSuccess", "onViewReady", "release", "setFlashStatus", "setOnFlashSwitcherClickListener", "onClickListener", "setOnGalleryClickListener", "setScanRequest", "request", "setScanTips", "tips", "", "setScanTitle", "title", "setShowTitle", "showGalleryButton", "showScanTips", "startTitleAnimation", "Companion", "plugin-scan_release"})
public final class ScanSharedMaskView
  extends RelativeLayout
{
  public static final ScanSharedMaskView.a yOT;
  public BaseScanRequest yFP;
  public ScannerFlashSwitcher yFp;
  public TextView yOJ;
  private TextView yOK;
  private ImageView yOL;
  public View yOM;
  private View.OnClickListener yON;
  private View.OnClickListener yOO;
  private Timer yOP;
  private boolean yOQ;
  public boolean yOR;
  public boolean yOS;
  
  static
  {
    AppMethodBeat.i(52465);
    yOT = new ScanSharedMaskView.a((byte)0);
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
    this.yOS = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131494573, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131304333);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_title)");
    this.yOJ = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131304332);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_tip_tv)");
    this.yOK = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131298922);
    p.g(paramAttributeSet, "view.findViewById(R.id.dark_corner_mask)");
    this.yOL = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131304346);
    p.g(paramAttributeSet, "view.findViewById(R.id.scanner_flash_switcher)");
    this.yFp = ((ScannerFlashSwitcher)paramAttributeSet);
    paramContext = paramContext.findViewById(2131304516);
    p.g(paramContext, "view.findViewById(R.id.select_from_gallery)");
    this.yOM = paramContext;
    paramContext = this.yOM;
    if (paramContext == null) {
      p.bdF("galleryButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new ScanSharedMaskView.c(this));
    paramContext = this.yFp;
    if (paramContext == null) {
      p.bdF("flashSwitcher");
    }
    paramContext.setOnClickListener((View.OnClickListener)new ScanSharedMaskView.d(this));
    paramContext = this.yOJ;
    if (paramContext == null) {
      p.bdF("scanTitle");
    }
    al.a((Paint)paramContext.getPaint(), 0.8F);
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
  
  private final void qQ(final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(170087);
    ae.d("MicroMsg.ScanSharedMaskView", "alvinluo animateScanTips show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (this.yFP != null))
    {
      localObject = this.yFP;
      if (localObject == null) {
        p.gkB();
      }
      if (((BaseScanRequest)localObject).yzB)
      {
        AppMethodBeat.o(170087);
        return;
      }
    }
    Object localObject = this.yOK;
    if (localObject == null) {
      p.bdF("scanTips");
    }
    if ((((TextView)localObject).getVisibility() == 0) && (paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    localObject = this.yOK;
    if (localObject == null) {
      p.bdF("scanTips");
    }
    if ((((TextView)localObject).getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    localObject = this.yOK;
    if (localObject == null) {
      p.bdF("scanTips");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.yOK;
    if (localObject == null) {
      p.bdF("scanTips");
    }
    if (paramBoolean)
    {
      f1 = 0.0F;
      ((TextView)localObject).setAlpha(f1);
      qM(true);
      localObject = this.yOK;
      if (localObject == null) {
        p.bdF("scanTips");
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
  
  public final void dPV()
  {
    AppMethodBeat.i(170081);
    ae.v("MicroMsg.ScanSharedMaskView", "alvinluo initTitleTimer");
    dPW();
    this.yOP = new Timer();
    Timer localTimer = this.yOP;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new e(this), 2000L);
    }
    this.yOQ = false;
    AppMethodBeat.o(170081);
  }
  
  public final void dPW()
  {
    AppMethodBeat.i(170082);
    this.yOQ = true;
    Timer localTimer = this.yOP;
    if (localTimer != null)
    {
      localTimer.cancel();
      AppMethodBeat.o(170082);
      return;
    }
    AppMethodBeat.o(170082);
  }
  
  public final void dPX()
  {
    AppMethodBeat.i(170084);
    ae.i("MicroMsg.ScanSharedMaskView", "alvinluo cancelTitleAnimation");
    Object localObject = this.yOJ;
    if (localObject == null) {
      p.bdF("scanTitle");
    }
    localObject = ((TextView)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setListener(null);
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    dPW();
    AppMethodBeat.o(170084);
  }
  
  public final ScannerFlashSwitcher getFlashSwitcherView()
  {
    AppMethodBeat.i(52455);
    ScannerFlashSwitcher localScannerFlashSwitcher = this.yFp;
    if (localScannerFlashSwitcher == null) {
      p.bdF("flashSwitcher");
    }
    AppMethodBeat.o(52455);
    return localScannerFlashSwitcher;
  }
  
  public final View getGalleryButton()
  {
    AppMethodBeat.i(52458);
    View localView = this.yOM;
    if (localView == null) {
      p.bdF("galleryButton");
    }
    AppMethodBeat.o(52458);
    return localView;
  }
  
  public final TextView getScanTipsView()
  {
    AppMethodBeat.i(52454);
    TextView localTextView = this.yOK;
    if (localTextView == null) {
      p.bdF("scanTips");
    }
    AppMethodBeat.o(52454);
    return localTextView;
  }
  
  public final TextView getScanTitleView()
  {
    AppMethodBeat.i(52452);
    TextView localTextView = this.yOJ;
    if (localTextView == null) {
      p.bdF("scanTitle");
    }
    AppMethodBeat.o(52452);
    return localTextView;
  }
  
  public final void qG(boolean paramBoolean)
  {
    AppMethodBeat.i(52459);
    if (!paramBoolean)
    {
      Object localObject = this.yOM;
      if (localObject == null) {
        p.bdF("galleryButton");
      }
      if (((View)localObject).getVisibility() == 0)
      {
        localObject = this.yOM;
        if (localObject == null) {
          p.bdF("galleryButton");
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
  
  public final void qM(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(189697);
    if ((paramBoolean) && (this.yFP != null))
    {
      localTextView = this.yOK;
      if (localTextView == null) {
        p.bdF("scanTips");
      }
      BaseScanRequest localBaseScanRequest = this.yFP;
      if (localBaseScanRequest == null) {
        p.gkB();
      }
      if ((!localBaseScanRequest.yzB) && (paramBoolean)) {}
      for (;;)
      {
        localTextView.setVisibility(i);
        AppMethodBeat.o(189697);
        return;
        i = 8;
      }
    }
    TextView localTextView = this.yOK;
    if (localTextView == null) {
      p.bdF("scanTips");
    }
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(189697);
      return;
    }
  }
  
  public final void qN(final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(170083);
    ae.i("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.yOJ;
    if (localObject == null) {
      p.bdF("scanTitle");
    }
    if (paramBoolean)
    {
      f1 = 0.0F;
      ((TextView)localObject).setAlpha(f1);
      localObject = this.yOJ;
      if (localObject == null) {
        p.bdF("scanTitle");
      }
      ((TextView)localObject).setVisibility(0);
      if (!paramBoolean) {
        break label206;
      }
    }
    label206:
    for (float f1 = f2;; f1 = 0.0F)
    {
      localObject = this.yOJ;
      if (localObject == null) {
        p.bdF("scanTitle");
      }
      ((TextView)localObject).setShadowLayer(10.0F, 0.0F, 0.0F, getResources().getColor(2131099658));
      localObject = this.yOJ;
      if (localObject == null) {
        p.bdF("scanTitle");
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
  
  public final void qO(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(170086);
    ae.i("MicroMsg.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.yOR != paramBoolean)
    {
      this.yOR = paramBoolean;
      if (paramBoolean) {
        break label59;
      }
    }
    label59:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      qQ(paramBoolean);
      AppMethodBeat.o(170086);
      return;
    }
  }
  
  public final void qP(boolean paramBoolean)
  {
    AppMethodBeat.i(52460);
    ae.v("MicroMsg.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(getAlpha()) });
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
    ae.d("MicroMsg.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.yOR = paramBoolean;
    AppMethodBeat.o(170085);
  }
  
  public final void setOnFlashSwitcherClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52457);
    p.h(paramOnClickListener, "onClickListener");
    this.yOO = paramOnClickListener;
    AppMethodBeat.o(52457);
  }
  
  public final void setOnGalleryClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52456);
    p.h(paramOnClickListener, "onClickListener");
    this.yON = paramOnClickListener;
    paramOnClickListener = this.yOM;
    if (paramOnClickListener == null) {
      p.bdF("galleryButton");
    }
    paramOnClickListener.setOnClickListener(this.yON);
    AppMethodBeat.o(52456);
  }
  
  public final void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.yFP = paramBaseScanRequest;
  }
  
  public final void setScanTips(String paramString)
  {
    AppMethodBeat.i(52453);
    TextView localTextView = this.yOK;
    if (localTextView == null) {
      p.bdF("scanTips");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52453);
  }
  
  public final void setScanTitle(String paramString)
  {
    AppMethodBeat.i(52451);
    TextView localTextView = this.yOJ;
    if (localTextView == null) {
      p.bdF("scanTitle");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52451);
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.yOS = paramBoolean;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateShowScanTips$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(170076);
      ScanSharedMaskView.a(this.yOU, paramBoolean);
      AppMethodBeat.o(170076);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170075);
      ScanSharedMaskView.a(this.yOU, paramBoolean);
      AppMethodBeat.o(170075);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$initTitleTimer$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class e
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(170078);
      this.yOU.post((Runnable)new a(this));
      AppMethodBeat.o(170078);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanSharedMaskView.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(170077);
        if (ScanSharedMaskView.c(this.yOV.yOU))
        {
          AppMethodBeat.o(170077);
          return;
        }
        ScanSharedMaskView.d(this.yOV.yOU);
        AppMethodBeat.o(170077);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startTitleAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(170080);
      ae.v("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationCancel show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(170080);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      int i = 0;
      AppMethodBeat.i(170079);
      ae.v("MicroMsg.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationEnd show: %b, isFlashShow: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(ScanSharedMaskView.e(this.yOU)) });
      paramAnimator = ScanSharedMaskView.f(this.yOU);
      if (paramBoolean) {}
      for (;;)
      {
        paramAnimator.setVisibility(i);
        if (!paramBoolean) {
          break;
        }
        ScanSharedMaskView.f(this.yOU).invalidate();
        ScanSharedMaskView.g(this.yOU);
        AppMethodBeat.o(170079);
        return;
        i = 8;
      }
      if (!ScanSharedMaskView.e(this.yOU)) {
        ScanSharedMaskView.h(this.yOU);
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