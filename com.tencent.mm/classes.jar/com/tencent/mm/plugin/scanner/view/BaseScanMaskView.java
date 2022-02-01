package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.qbar.ScanDecodeFrameData;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentNetworkAvailable", "", "getCurrentNetworkAvailable", "()Z", "setCurrentNetworkAvailable", "(Z)V", "flashSwitcher", "Landroid/view/View;", "getFlashSwitcher", "()Landroid/view/View;", "setFlashSwitcher", "(Landroid/view/View;)V", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getFrameData", "()Lcom/tencent/qbar/ScanDecodeFrameData;", "setFrameData", "(Lcom/tencent/qbar/ScanDecodeFrameData;)V", "isViewDestroy", "setViewDestroy", "mBottomExtraHeight", "getMBottomExtraHeight", "()I", "setMBottomExtraHeight", "(I)V", "mGalleryButton", "getMGalleryButton", "setMGalleryButton", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mScanRect", "getMScanRect", "setMScanRect", "mScanSource", "getMScanSource", "setMScanSource", "scanCamera", "Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "getScanCamera", "()Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "setScanCamera", "(Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;)V", "scanTips", "Landroid/widget/TextView;", "getScanTips", "()Landroid/widget/TextView;", "setScanTips", "(Landroid/widget/TextView;)V", "animateAlpha", "", "view", "fromAlpha", "", "targetAlpha", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animateShow", "show", "attachActivity", "attachBackgroundView", "backgroundView", "attachFlashSwitcherView", "attachGalleryButton", "galleryButton", "attachScanCamera", "attachScanTipsView", "tipsView", "checkNetwork", "getTargetSuccessMarkView", "init", "onBackPressed", "onNetworkChange", "state", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onShowNetworkLoading", "onShowNetworkUnconnectedView", "onShowNetworkWeakView", "onViewDestroy", "onViewReady", "release", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setPreviewRect", "rect", "setScanRect", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "Companion", "scan-sdk_release"})
public abstract class BaseScanMaskView
  extends RelativeLayout
  implements a
{
  public static final a wby = new a((byte)0);
  public Activity activity;
  private boolean vQX;
  public com.tencent.mm.plugin.scanner.a.a vTX;
  private TextView vZC;
  private View wbq;
  private View wbr;
  private Rect wbs;
  private Rect wbt;
  private int wbu;
  private int wbv;
  public boolean wbw;
  private ScanDecodeFrameData wbx;
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dlV();
    ad.i("MicroMsg.BaseScanMaskView", "alvinluo init networkAvailable: %b", new Object[] { Boolean.valueOf(this.vQX) });
  }
  
  private final void dlV()
  {
    q localq = g.aeS();
    k.g(localq, "MMKernel.getNetSceneQueue()");
    if (localq.auR() != 6)
    {
      localq = g.aeS();
      k.g(localq, "MMKernel.getNetSceneQueue()");
      if (localq.auR() != 4) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.vQX = bool;
      return;
    }
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    ad.d("MicroMsg.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.wbw = true;
  }
  
  protected final void a(View paramView, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    ad.v("MicroMsg.BaseScanMaskView", "alvinluo animateAlpha from: %f, to: %f, hashCode: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(hashCode()) });
    if (paramView != null)
    {
      ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.setListener(null);
        if (localViewPropertyAnimator != null)
        {
          localViewPropertyAnimator = localViewPropertyAnimator.setUpdateListener(null);
          if (localViewPropertyAnimator != null) {
            localViewPropertyAnimator.cancel();
          }
        }
      }
    }
    if (paramView != null) {
      paramView.setAlpha(paramFloat1);
    }
    if (paramView != null)
    {
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
              paramView = paramView.setUpdateListener(null);
              if (paramView != null)
              {
                paramView = paramView.setListener(paramAnimatorListener);
                if (paramView != null) {
                  paramView.start();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(Object paramObject, c paramc)
  {
    k.h(paramObject, "data");
  }
  
  public void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void dmJ()
  {
    ad.i("MicroMsg.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.wbw = false;
  }
  
  public void dmR() {}
  
  public void dmS() {}
  
  public void ek(View paramView)
  {
    k.h(paramView, "flashSwitcher");
    ad.v("MicroMsg.BaseScanMaskView", "alvinluo attachFlashSwitcherView");
    this.wbq = paramView;
  }
  
  public void el(View paramView) {}
  
  public void em(View paramView)
  {
    k.h(paramView, "galleryButton");
    this.wbr = paramView;
    View localView = this.wbr;
    if (localView != null)
    {
      paramView = this.wbr;
      if (paramView == null) {
        break label73;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null) {
        break label73;
      }
      if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramView).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 32) + this.wbv);
      }
    }
    for (;;)
    {
      localView.setLayoutParams(paramView);
      return;
      label73:
      paramView = null;
    }
  }
  
  protected final Activity getActivity()
  {
    return this.activity;
  }
  
  protected final boolean getCurrentNetworkAvailable()
  {
    return this.vQX;
  }
  
  protected final View getFlashSwitcher()
  {
    return this.wbq;
  }
  
  protected final ScanDecodeFrameData getFrameData()
  {
    return this.wbx;
  }
  
  protected final int getMBottomExtraHeight()
  {
    return this.wbv;
  }
  
  protected final View getMGalleryButton()
  {
    return this.wbr;
  }
  
  protected final Rect getMPreviewRect()
  {
    return this.wbs;
  }
  
  protected final Rect getMScanRect()
  {
    return this.wbt;
  }
  
  public final int getMScanSource()
  {
    return this.wbu;
  }
  
  protected final com.tencent.mm.plugin.scanner.a.a getScanCamera()
  {
    return this.vTX;
  }
  
  public final TextView getScanTips()
  {
    return this.vZC;
  }
  
  public View getTargetSuccessMarkView()
  {
    return null;
  }
  
  public void o(TextView paramTextView)
  {
    k.h(paramTextView, "tipsView");
    this.vZC = paramTextView;
    TextView localTextView = this.vZC;
    if (localTextView != null)
    {
      paramTextView = this.vZC;
      if (paramTextView == null) {
        break label73;
      }
      paramTextView = paramTextView.getLayoutParams();
      if (paramTextView == null) {
        break label73;
      }
      if ((paramTextView instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramTextView).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 120) + this.wbv);
      }
    }
    for (;;)
    {
      localTextView.setLayoutParams(paramTextView);
      return;
      label73:
      paramTextView = null;
    }
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onNetworkChange(int paramInt)
  {
    ad.i("MicroMsg.BaseScanMaskView", "alvinluo onNetworkChange state: %d", new Object[] { Integer.valueOf(paramInt) });
    dlV();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void pd(boolean paramBoolean)
  {
    ad.i("MicroMsg.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
  }
  
  public void pf(boolean paramBoolean) {}
  
  public final void pk(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (getAlpha() == 0.0F) {
        a((View)this, 0.0F, 1.0F, null);
      }
    }
    while (getAlpha() != 1.0F) {
      return;
    }
    a((View)this, 1.0F, 0.0F, null);
  }
  
  public void release() {}
  
  protected final void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.wbv = paramInt;
  }
  
  protected final void setCurrentNetworkAvailable(boolean paramBoolean)
  {
    this.vQX = paramBoolean;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.wbx = paramScanDecodeFrameData;
  }
  
  protected final void setFlashSwitcher(View paramView)
  {
    this.wbq = paramView;
  }
  
  protected final void setFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.wbx = paramScanDecodeFrameData;
  }
  
  protected final void setMBottomExtraHeight(int paramInt)
  {
    this.wbv = paramInt;
  }
  
  protected final void setMGalleryButton(View paramView)
  {
    this.wbr = paramView;
  }
  
  protected final void setMPreviewRect(Rect paramRect)
  {
    this.wbs = paramRect;
  }
  
  protected final void setMScanRect(Rect paramRect)
  {
    this.wbt = paramRect;
  }
  
  protected final void setMScanSource(int paramInt)
  {
    this.wbu = paramInt;
  }
  
  public final void setPreviewRect(Rect paramRect)
  {
    this.wbs = paramRect;
    postInvalidate();
  }
  
  protected final void setScanCamera(com.tencent.mm.plugin.scanner.a.a parama)
  {
    this.vTX = parama;
  }
  
  public final void setScanRect(Rect paramRect)
  {
    this.wbt = paramRect;
  }
  
  public void setScanSource(int paramInt)
  {
    this.wbu = paramInt;
  }
  
  protected final void setScanTips(TextView paramTextView)
  {
    this.vZC = paramTextView;
  }
  
  protected final void setViewDestroy(boolean paramBoolean)
  {
    this.wbw = paramBoolean;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView$Companion;", "", "()V", "ALPHA_ANIMATION_DURATION", "", "SUCCESS_MARK_VIEW_ANIMATION_DURATION", "TAG", "", "scan-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.BaseScanMaskView
 * JD-Core Version:    0.7.0.1
 */