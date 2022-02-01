package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.a.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.ScanDecodeFrameData;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "T", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentNetworkAvailable", "", "getCurrentNetworkAvailable", "()Z", "setCurrentNetworkAvailable", "(Z)V", "flashSwitcher", "Landroid/view/View;", "getFlashSwitcher", "()Landroid/view/View;", "setFlashSwitcher", "(Landroid/view/View;)V", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getFrameData", "()Lcom/tencent/qbar/ScanDecodeFrameData;", "setFrameData", "(Lcom/tencent/qbar/ScanDecodeFrameData;)V", "isViewDestroy", "setViewDestroy", "mBottomExtraHeight", "getMBottomExtraHeight", "()I", "setMBottomExtraHeight", "(I)V", "mGalleryButton", "getMGalleryButton", "setMGalleryButton", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mScanRect", "getMScanRect", "setMScanRect", "mScanSource", "getMScanSource", "setMScanSource", "request", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;)V", "scanCamera", "Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "getScanCamera", "()Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "setScanCamera", "(Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;)V", "scanTips", "Landroid/widget/TextView;", "getScanTips", "()Landroid/widget/TextView;", "setScanTips", "(Landroid/widget/TextView;)V", "animateShow", "", "show", "attachBackgroundView", "backgroundView", "attachScanCamera", "attachScanTipsView", "tipsView", "checkNetwork", "getTargetSuccessMarkView", "init", "onNetworkChange", "state", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onShowInfoView", "onShowNetworkLoading", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "release", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setPreviewRect", "rect", "setScanRect", "setScanRequest", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showScanTips", "Companion", "scan-sdk_release"})
public abstract class BaseScanMaskView<T extends BaseScanRequest>
  extends RelativeLayout
  implements b<T>
{
  public static final BaseScanMaskView.a CUQ = new BaseScanMaskView.a((byte)0);
  private boolean CJv;
  public a CMx;
  public TextView CSB;
  private int CSP;
  private View CUI;
  private View CUJ;
  private Rect CUK;
  private Rect CUL;
  private int CUM;
  public boolean CUN;
  private ScanDecodeFrameData CUO;
  private BaseScanRequest CUP;
  private Activity activity;
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    eQC();
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo init networkAvailable: %b", new Object[] { Boolean.valueOf(this.CJv) });
  }
  
  private final void eQC()
  {
    t localt = g.azz();
    p.g(localt, "MMKernel.getNetSceneQueue()");
    if (localt.aYS() != 6)
    {
      localt = g.azz();
      p.g(localt, "MMKernel.getNetSceneQueue()");
      if (localt.aYS() != 4) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.CJv = bool;
      return;
    }
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    Log.d("MicroMsg.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.CUN = true;
  }
  
  public void b(Object paramObject, d paramd)
  {
    p.h(paramObject, "data");
  }
  
  public void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void eRq()
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.CUN = false;
  }
  
  public void eRz() {}
  
  public void eU(View paramView) {}
  
  protected final Activity getActivity()
  {
    return this.activity;
  }
  
  protected final boolean getCurrentNetworkAvailable()
  {
    return this.CJv;
  }
  
  protected final View getFlashSwitcher()
  {
    return this.CUI;
  }
  
  protected final ScanDecodeFrameData getFrameData()
  {
    return this.CUO;
  }
  
  protected final int getMBottomExtraHeight()
  {
    return this.CSP;
  }
  
  protected final View getMGalleryButton()
  {
    return this.CUJ;
  }
  
  protected final Rect getMPreviewRect()
  {
    return this.CUK;
  }
  
  protected final Rect getMScanRect()
  {
    return this.CUL;
  }
  
  public final int getMScanSource()
  {
    return this.CUM;
  }
  
  public final BaseScanRequest getRequest()
  {
    return this.CUP;
  }
  
  protected final a getScanCamera()
  {
    return this.CMx;
  }
  
  public final TextView getScanTips()
  {
    return this.CSB;
  }
  
  public View getTargetSuccessMarkView()
  {
    return null;
  }
  
  public void onNetworkChange(int paramInt)
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onNetworkChange state: %d", new Object[] { Integer.valueOf(paramInt) });
    eQC();
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void release() {}
  
  protected final void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.CSP = paramInt;
  }
  
  protected final void setCurrentNetworkAvailable(boolean paramBoolean)
  {
    this.CJv = paramBoolean;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.CUO = paramScanDecodeFrameData;
  }
  
  protected final void setFlashSwitcher(View paramView)
  {
    this.CUI = paramView;
  }
  
  protected final void setFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.CUO = paramScanDecodeFrameData;
  }
  
  protected final void setMBottomExtraHeight(int paramInt)
  {
    this.CSP = paramInt;
  }
  
  protected final void setMGalleryButton(View paramView)
  {
    this.CUJ = paramView;
  }
  
  protected final void setMPreviewRect(Rect paramRect)
  {
    this.CUK = paramRect;
  }
  
  protected final void setMScanRect(Rect paramRect)
  {
    this.CUL = paramRect;
  }
  
  protected final void setMScanSource(int paramInt)
  {
    this.CUM = paramInt;
  }
  
  public final void setPreviewRect(Rect paramRect)
  {
    this.CUK = paramRect;
    postInvalidate();
  }
  
  protected final void setRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.CUP = paramBaseScanRequest;
  }
  
  protected final void setScanCamera(a parama)
  {
    this.CMx = parama;
  }
  
  public final void setScanRect(Rect paramRect)
  {
    this.CUL = paramRect;
  }
  
  public void setScanRequest(T paramT)
  {
    this.CUP = paramT;
  }
  
  public void setScanSource(int paramInt)
  {
    this.CUM = paramInt;
  }
  
  protected final void setScanTips(TextView paramTextView)
  {
    this.CSB = paramTextView;
  }
  
  protected final void setViewDestroy(boolean paramBoolean)
  {
    this.CUN = paramBoolean;
  }
  
  public void tY(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
  }
  
  public void uc(boolean paramBoolean) {}
  
  public final void uf(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    TextView localTextView;
    if ((paramBoolean) && (this.CUP != null))
    {
      localTextView = this.CSB;
      if (localTextView != null)
      {
        BaseScanRequest localBaseScanRequest = this.CUP;
        if (localBaseScanRequest == null) {
          p.hyc();
        }
        if ((localBaseScanRequest.CAF) || (!paramBoolean)) {
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
      localTextView = this.CSB;
    } while (localTextView == null);
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public final void ui(boolean paramBoolean)
  {
    if ((paramBoolean) && (getAlpha() == 0.0F)) {
      m.a((View)this, 0.0F, 1.0F, 200L, null);
    }
    while ((paramBoolean) || (getAlpha() != 1.0F)) {
      return;
    }
    m.a((View)this, 1.0F, 0.0F, 200L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.BaseScanMaskView
 * JD-Core Version:    0.7.0.1
 */