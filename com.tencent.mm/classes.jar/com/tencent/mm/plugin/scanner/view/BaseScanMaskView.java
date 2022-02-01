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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.qbar.ScanDecodeFrameData;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "T", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentNetworkAvailable", "", "getCurrentNetworkAvailable", "()Z", "setCurrentNetworkAvailable", "(Z)V", "flashSwitcher", "Landroid/view/View;", "getFlashSwitcher", "()Landroid/view/View;", "setFlashSwitcher", "(Landroid/view/View;)V", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getFrameData", "()Lcom/tencent/qbar/ScanDecodeFrameData;", "setFrameData", "(Lcom/tencent/qbar/ScanDecodeFrameData;)V", "isViewDestroy", "setViewDestroy", "mBottomExtraHeight", "getMBottomExtraHeight", "()I", "setMBottomExtraHeight", "(I)V", "mGalleryButton", "getMGalleryButton", "setMGalleryButton", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mScanRect", "getMScanRect", "setMScanRect", "mScanSource", "getMScanSource", "setMScanSource", "request", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;)V", "scanCamera", "Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "getScanCamera", "()Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "setScanCamera", "(Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;)V", "scanTips", "Landroid/widget/TextView;", "getScanTips", "()Landroid/widget/TextView;", "setScanTips", "(Landroid/widget/TextView;)V", "scanTipsWording", "", "getScanTipsWording", "()Ljava/lang/String;", "setScanTipsWording", "(Ljava/lang/String;)V", "animateAlpha", "", "view", "fromAlpha", "", "targetAlpha", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animateShow", "show", "attachActivity", "attachBackgroundView", "backgroundView", "attachFlashSwitcherView", "attachGalleryButton", "galleryButton", "attachScanCamera", "attachScanTipsView", "tipsView", "tipsWording", "checkNetwork", "getTargetSuccessMarkView", "init", "onBackPressed", "onNetworkChange", "state", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onShowNetworkLoading", "onShowNetworkUnconnectedView", "onShowNetworkWeakView", "onViewDestroy", "onViewReady", "release", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setPreviewRect", "rect", "setScanRect", "setScanRequest", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showScanTips", "Companion", "scan-sdk_release"})
public abstract class BaseScanMaskView<T extends BaseScanRequest>
  extends RelativeLayout
  implements a<T>
{
  public static final BaseScanMaskView.a yQG = new BaseScanMaskView.a((byte)0);
  public Activity activity;
  private boolean yFH;
  public com.tencent.mm.plugin.scanner.a.a yIK;
  private TextView yOK;
  private Rect yQA;
  private int yQB;
  private int yQC;
  public boolean yQD;
  private ScanDecodeFrameData yQE;
  private BaseScanRequest yQF;
  private View yQx;
  private View yQy;
  private Rect yQz;
  private String yzK = "";
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dOS();
    ae.i("MicroMsg.BaseScanMaskView", "alvinluo init networkAvailable: %b", new Object[] { Boolean.valueOf(this.yFH) });
  }
  
  private final void dOS()
  {
    q localq = g.ajj();
    p.g(localq, "MMKernel.getNetSceneQueue()");
    if (localq.aFd() != 6)
    {
      localq = g.ajj();
      p.g(localq, "MMKernel.getNetSceneQueue()");
      if (localq.aFd() != 4) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.yFH = bool;
      return;
    }
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    ae.d("MicroMsg.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.yQD = true;
  }
  
  protected final void a(View paramView, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    ae.v("MicroMsg.BaseScanMaskView", "alvinluo animateAlpha from: %f, to: %f, hashCode: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(hashCode()) });
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
  
  public void d(TextView paramTextView, String paramString)
  {
    p.h(paramTextView, "tipsView");
    this.yOK = paramTextView;
    paramTextView = paramString;
    if (paramString == null) {
      paramTextView = "";
    }
    this.yzK = paramTextView;
    paramString = this.yOK;
    if (paramString != null)
    {
      paramTextView = this.yOK;
      if (paramTextView == null) {
        break label87;
      }
      paramTextView = paramTextView.getLayoutParams();
      if (paramTextView == null) {
        break label87;
      }
      if ((paramTextView instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramTextView).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 120) + this.yQC);
      }
    }
    for (;;)
    {
      paramString.setLayoutParams(paramTextView);
      return;
      label87:
      paramTextView = null;
    }
  }
  
  public void dPG()
  {
    ae.i("MicroMsg.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.yQD = false;
  }
  
  public void dPQ() {}
  
  public void dPR() {}
  
  public void eH(View paramView)
  {
    p.h(paramView, "flashSwitcher");
    ae.v("MicroMsg.BaseScanMaskView", "alvinluo attachFlashSwitcherView");
    this.yQx = paramView;
  }
  
  public void eI(View paramView) {}
  
  public void eJ(View paramView)
  {
    p.h(paramView, "galleryButton");
    this.yQy = paramView;
    View localView = this.yQy;
    if (localView != null)
    {
      paramView = this.yQy;
      if (paramView == null) {
        break label73;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null) {
        break label73;
      }
      if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramView).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + this.yQC);
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
    return this.yFH;
  }
  
  protected final View getFlashSwitcher()
  {
    return this.yQx;
  }
  
  protected final ScanDecodeFrameData getFrameData()
  {
    return this.yQE;
  }
  
  protected final int getMBottomExtraHeight()
  {
    return this.yQC;
  }
  
  protected final View getMGalleryButton()
  {
    return this.yQy;
  }
  
  protected final Rect getMPreviewRect()
  {
    return this.yQz;
  }
  
  protected final Rect getMScanRect()
  {
    return this.yQA;
  }
  
  public final int getMScanSource()
  {
    return this.yQB;
  }
  
  public final BaseScanRequest getRequest()
  {
    return this.yQF;
  }
  
  protected final com.tencent.mm.plugin.scanner.a.a getScanCamera()
  {
    return this.yIK;
  }
  
  public final TextView getScanTips()
  {
    return this.yOK;
  }
  
  protected final String getScanTipsWording()
  {
    return this.yzK;
  }
  
  public View getTargetSuccessMarkView()
  {
    return null;
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onNetworkChange(int paramInt)
  {
    ae.i("MicroMsg.BaseScanMaskView", "alvinluo onNetworkChange state: %d", new Object[] { Integer.valueOf(paramInt) });
    dOS();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void qG(boolean paramBoolean)
  {
    ae.i("MicroMsg.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
  }
  
  public void qI(boolean paramBoolean) {}
  
  public final void qM(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    TextView localTextView;
    if ((paramBoolean) && (this.yQF != null))
    {
      localTextView = this.yOK;
      if (localTextView != null)
      {
        BaseScanRequest localBaseScanRequest = this.yQF;
        if (localBaseScanRequest == null) {
          p.gkB();
        }
        if ((localBaseScanRequest.yzB) || (!paramBoolean)) {
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
      localTextView = this.yOK;
    } while (localTextView == null);
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public final void qP(boolean paramBoolean)
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
    this.yQC = paramInt;
  }
  
  protected final void setCurrentNetworkAvailable(boolean paramBoolean)
  {
    this.yFH = paramBoolean;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.yQE = paramScanDecodeFrameData;
  }
  
  protected final void setFlashSwitcher(View paramView)
  {
    this.yQx = paramView;
  }
  
  protected final void setFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.yQE = paramScanDecodeFrameData;
  }
  
  protected final void setMBottomExtraHeight(int paramInt)
  {
    this.yQC = paramInt;
  }
  
  protected final void setMGalleryButton(View paramView)
  {
    this.yQy = paramView;
  }
  
  protected final void setMPreviewRect(Rect paramRect)
  {
    this.yQz = paramRect;
  }
  
  protected final void setMScanRect(Rect paramRect)
  {
    this.yQA = paramRect;
  }
  
  protected final void setMScanSource(int paramInt)
  {
    this.yQB = paramInt;
  }
  
  public final void setPreviewRect(Rect paramRect)
  {
    this.yQz = paramRect;
    postInvalidate();
  }
  
  protected final void setRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.yQF = paramBaseScanRequest;
  }
  
  protected final void setScanCamera(com.tencent.mm.plugin.scanner.a.a parama)
  {
    this.yIK = parama;
  }
  
  public final void setScanRect(Rect paramRect)
  {
    this.yQA = paramRect;
  }
  
  public void setScanRequest(T paramT)
  {
    this.yQF = paramT;
  }
  
  public void setScanSource(int paramInt)
  {
    this.yQB = paramInt;
  }
  
  protected final void setScanTips(TextView paramTextView)
  {
    this.yOK = paramTextView;
  }
  
  protected final void setScanTipsWording(String paramString)
  {
    p.h(paramString, "<set-?>");
    this.yzK = paramString;
  }
  
  protected final void setViewDestroy(boolean paramBoolean)
  {
    this.yQD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.BaseScanMaskView
 * JD-Core Version:    0.7.0.1
 */