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
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.qbar.ScanDecodeFrameData;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "T", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentNetworkAvailable", "", "getCurrentNetworkAvailable", "()Z", "setCurrentNetworkAvailable", "(Z)V", "flashSwitcher", "Landroid/view/View;", "getFlashSwitcher", "()Landroid/view/View;", "setFlashSwitcher", "(Landroid/view/View;)V", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getFrameData", "()Lcom/tencent/qbar/ScanDecodeFrameData;", "setFrameData", "(Lcom/tencent/qbar/ScanDecodeFrameData;)V", "isViewDestroy", "setViewDestroy", "mBottomExtraHeight", "getMBottomExtraHeight", "()I", "setMBottomExtraHeight", "(I)V", "mGalleryButton", "getMGalleryButton", "setMGalleryButton", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mScanRect", "getMScanRect", "setMScanRect", "mScanSource", "getMScanSource", "setMScanSource", "request", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;)V", "scanCamera", "Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "getScanCamera", "()Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "setScanCamera", "(Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;)V", "scanTips", "Landroid/widget/TextView;", "getScanTips", "()Landroid/widget/TextView;", "setScanTips", "(Landroid/widget/TextView;)V", "animateAlpha", "", "view", "fromAlpha", "", "targetAlpha", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animateShow", "show", "attachActivity", "attachBackgroundView", "backgroundView", "attachFlashSwitcherView", "attachGalleryButton", "galleryButton", "attachScanCamera", "attachScanTipsView", "tipsView", "checkNetwork", "getTargetSuccessMarkView", "init", "onBackPressed", "onNetworkChange", "state", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onShowNetworkLoading", "onShowNetworkUnconnectedView", "onShowNetworkWeakView", "onViewDestroy", "onViewReady", "release", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setPreviewRect", "rect", "setScanRect", "setScanRequest", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showScanTips", "Companion", "scan-sdk_release"})
public abstract class BaseScanMaskView<T extends BaseScanRequest>
  extends RelativeLayout
  implements a<T>
{
  public static final BaseScanMaskView.a yAG = new BaseScanMaskView.a((byte)0);
  public Activity activity;
  private Rect yAA;
  private int yAB;
  private int yAC;
  public boolean yAD;
  private ScanDecodeFrameData yAE;
  private BaseScanRequest yAF;
  private View yAx;
  private View yAy;
  private Rect yAz;
  private boolean ypI;
  public com.tencent.mm.plugin.scanner.a.a ysK;
  private TextView yyK;
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dLz();
    ad.i("MicroMsg.BaseScanMaskView", "alvinluo init networkAvailable: %b", new Object[] { Boolean.valueOf(this.ypI) });
  }
  
  private final void dLz()
  {
    q localq = g.aiU();
    p.g(localq, "MMKernel.getNetSceneQueue()");
    if (localq.aEN() != 6)
    {
      localq = g.aiU();
      p.g(localq, "MMKernel.getNetSceneQueue()");
      if (localq.aEN() != 4) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.ypI = bool;
      return;
    }
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    ad.d("MicroMsg.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.yAD = true;
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
    p.h(paramObject, "data");
  }
  
  public void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void dMn()
  {
    ad.i("MicroMsg.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.yAD = false;
  }
  
  public void dMx() {}
  
  public void dMy() {}
  
  public void eH(View paramView)
  {
    p.h(paramView, "flashSwitcher");
    ad.v("MicroMsg.BaseScanMaskView", "alvinluo attachFlashSwitcherView");
    this.yAx = paramView;
  }
  
  public void eI(View paramView) {}
  
  public void eJ(View paramView)
  {
    p.h(paramView, "galleryButton");
    this.yAy = paramView;
    View localView = this.yAy;
    if (localView != null)
    {
      paramView = this.yAy;
      if (paramView == null) {
        break label73;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null) {
        break label73;
      }
      if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramView).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(getContext(), 32) + this.yAC);
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
    return this.ypI;
  }
  
  protected final View getFlashSwitcher()
  {
    return this.yAx;
  }
  
  protected final ScanDecodeFrameData getFrameData()
  {
    return this.yAE;
  }
  
  protected final int getMBottomExtraHeight()
  {
    return this.yAC;
  }
  
  protected final View getMGalleryButton()
  {
    return this.yAy;
  }
  
  protected final Rect getMPreviewRect()
  {
    return this.yAz;
  }
  
  protected final Rect getMScanRect()
  {
    return this.yAA;
  }
  
  public final int getMScanSource()
  {
    return this.yAB;
  }
  
  public final BaseScanRequest getRequest()
  {
    return this.yAF;
  }
  
  protected final com.tencent.mm.plugin.scanner.a.a getScanCamera()
  {
    return this.ysK;
  }
  
  public final TextView getScanTips()
  {
    return this.yyK;
  }
  
  public View getTargetSuccessMarkView()
  {
    return null;
  }
  
  public void o(TextView paramTextView)
  {
    p.h(paramTextView, "tipsView");
    this.yyK = paramTextView;
    TextView localTextView = this.yyK;
    if (localTextView != null)
    {
      paramTextView = this.yyK;
      if (paramTextView == null) {
        break label73;
      }
      paramTextView = paramTextView.getLayoutParams();
      if (paramTextView == null) {
        break label73;
      }
      if ((paramTextView instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramTextView).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(getContext(), 120) + this.yAC);
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
    dLz();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void qB(boolean paramBoolean) {}
  
  public final void qF(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    TextView localTextView;
    if ((paramBoolean) && (this.yAF != null))
    {
      localTextView = this.yyK;
      if (localTextView != null)
      {
        BaseScanRequest localBaseScanRequest = this.yAF;
        if (localBaseScanRequest == null) {
          p.gfZ();
        }
        if ((localBaseScanRequest.yjF) || (!paramBoolean)) {
          break label59;
        }
        localTextView.setVisibility(i);
      }
    }
    label59:
    do
    {
      return;
      i = 8;
      break;
      localTextView = this.yyK;
    } while (localTextView == null);
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public final void qI(boolean paramBoolean)
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
  
  public void qz(boolean paramBoolean)
  {
    ad.i("MicroMsg.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
  }
  
  public void release() {}
  
  protected final void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.yAC = paramInt;
  }
  
  protected final void setCurrentNetworkAvailable(boolean paramBoolean)
  {
    this.ypI = paramBoolean;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.yAE = paramScanDecodeFrameData;
  }
  
  protected final void setFlashSwitcher(View paramView)
  {
    this.yAx = paramView;
  }
  
  protected final void setFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.yAE = paramScanDecodeFrameData;
  }
  
  protected final void setMBottomExtraHeight(int paramInt)
  {
    this.yAC = paramInt;
  }
  
  protected final void setMGalleryButton(View paramView)
  {
    this.yAy = paramView;
  }
  
  protected final void setMPreviewRect(Rect paramRect)
  {
    this.yAz = paramRect;
  }
  
  protected final void setMScanRect(Rect paramRect)
  {
    this.yAA = paramRect;
  }
  
  protected final void setMScanSource(int paramInt)
  {
    this.yAB = paramInt;
  }
  
  public final void setPreviewRect(Rect paramRect)
  {
    this.yAz = paramRect;
    postInvalidate();
  }
  
  protected final void setRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.yAF = paramBaseScanRequest;
  }
  
  protected final void setScanCamera(com.tencent.mm.plugin.scanner.a.a parama)
  {
    this.ysK = parama;
  }
  
  public final void setScanRect(Rect paramRect)
  {
    this.yAA = paramRect;
  }
  
  public void setScanRequest(T paramT)
  {
    this.yAF = paramT;
  }
  
  public void setScanSource(int paramInt)
  {
    this.yAB = paramInt;
  }
  
  protected final void setScanTips(TextView paramTextView)
  {
    this.yyK = paramTextView;
  }
  
  protected final void setViewDestroy(boolean paramBoolean)
  {
    this.yAD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.BaseScanMaskView
 * JD-Core Version:    0.7.0.1
 */