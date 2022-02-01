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
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.a.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.ScanDecodeFrameData;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "T", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentNetworkAvailable", "", "getCurrentNetworkAvailable", "()Z", "setCurrentNetworkAvailable", "(Z)V", "flashSwitcher", "Landroid/view/View;", "getFlashSwitcher", "()Landroid/view/View;", "setFlashSwitcher", "(Landroid/view/View;)V", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getFrameData", "()Lcom/tencent/qbar/ScanDecodeFrameData;", "setFrameData", "(Lcom/tencent/qbar/ScanDecodeFrameData;)V", "isViewDestroy", "setViewDestroy", "mBottomExtraHeight", "getMBottomExtraHeight", "()I", "setMBottomExtraHeight", "(I)V", "mGalleryButton", "getMGalleryButton", "setMGalleryButton", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mScanRect", "getMScanRect", "setMScanRect", "mScanSource", "getMScanSource", "setMScanSource", "request", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;)V", "scanCamera", "Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "getScanCamera", "()Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "setScanCamera", "(Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;)V", "scanTips", "Landroid/widget/TextView;", "getScanTips", "()Landroid/widget/TextView;", "setScanTips", "(Landroid/widget/TextView;)V", "animateShow", "", "show", "attachBackgroundView", "backgroundView", "attachScanCamera", "attachScanTipsView", "tipsView", "checkNetwork", "getTargetSuccessMarkView", "init", "onNetworkChange", "state", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onShowInfoView", "onShowNetworkLoading", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "release", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setPreviewRect", "rect", "setScanRect", "setScanRequest", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showScanTips", "Companion", "scan-sdk_release"})
public abstract class BaseScanMaskView<T extends BaseScanRequest>
  extends RelativeLayout
  implements b<T>
{
  public static final a Jap = new a((byte)0);
  private boolean IOW;
  public a IRX;
  public TextView IXT;
  private int IYh;
  private View Jai;
  private View Jaj;
  private Rect Jak;
  private int Jal;
  public boolean Jam;
  private ScanDecodeFrameData Jan;
  private BaseScanRequest Jao;
  private Activity activity;
  private Rect lcQ;
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dBp();
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo init networkAvailable: %b", new Object[] { Boolean.valueOf(this.IOW) });
  }
  
  private final void dBp()
  {
    t localt = h.aGY();
    p.j(localt, "MMKernel.getNetSceneQueue()");
    if (localt.bih() != 6)
    {
      localt = h.aGY();
      p.j(localt, "MMKernel.getNetSceneQueue()");
      if (localt.bih() != 4) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.IOW = bool;
      return;
    }
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    Log.d("MicroMsg.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.Jam = true;
  }
  
  public void b(Object paramObject, d paramd)
  {
    p.k(paramObject, "data");
  }
  
  public void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void fEr()
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.Jam = false;
  }
  
  public void fEy() {}
  
  public void fY(View paramView) {}
  
  protected final Activity getActivity()
  {
    return this.activity;
  }
  
  protected final boolean getCurrentNetworkAvailable()
  {
    return this.IOW;
  }
  
  protected final View getFlashSwitcher()
  {
    return this.Jai;
  }
  
  protected final ScanDecodeFrameData getFrameData()
  {
    return this.Jan;
  }
  
  protected final int getMBottomExtraHeight()
  {
    return this.IYh;
  }
  
  protected final View getMGalleryButton()
  {
    return this.Jaj;
  }
  
  protected final Rect getMPreviewRect()
  {
    return this.lcQ;
  }
  
  protected final Rect getMScanRect()
  {
    return this.Jak;
  }
  
  public final int getMScanSource()
  {
    return this.Jal;
  }
  
  public final BaseScanRequest getRequest()
  {
    return this.Jao;
  }
  
  protected final a getScanCamera()
  {
    return this.IRX;
  }
  
  public final TextView getScanTips()
  {
    return this.IXT;
  }
  
  public View getTargetSuccessMarkView()
  {
    return null;
  }
  
  public void onNetworkChange(int paramInt)
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onNetworkChange state: %d", new Object[] { Integer.valueOf(paramInt) });
    dBp();
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
    this.IYh = paramInt;
  }
  
  protected final void setCurrentNetworkAvailable(boolean paramBoolean)
  {
    this.IOW = paramBoolean;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.Jan = paramScanDecodeFrameData;
  }
  
  protected final void setFlashSwitcher(View paramView)
  {
    this.Jai = paramView;
  }
  
  protected final void setFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.Jan = paramScanDecodeFrameData;
  }
  
  protected final void setMBottomExtraHeight(int paramInt)
  {
    this.IYh = paramInt;
  }
  
  protected final void setMGalleryButton(View paramView)
  {
    this.Jaj = paramView;
  }
  
  protected final void setMPreviewRect(Rect paramRect)
  {
    this.lcQ = paramRect;
  }
  
  protected final void setMScanRect(Rect paramRect)
  {
    this.Jak = paramRect;
  }
  
  protected final void setMScanSource(int paramInt)
  {
    this.Jal = paramInt;
  }
  
  public final void setPreviewRect(Rect paramRect)
  {
    this.lcQ = paramRect;
    postInvalidate();
  }
  
  protected final void setRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.Jao = paramBaseScanRequest;
  }
  
  protected final void setScanCamera(a parama)
  {
    this.IRX = parama;
  }
  
  public final void setScanRect(Rect paramRect)
  {
    this.Jak = paramRect;
  }
  
  public void setScanRequest(T paramT)
  {
    this.Jao = paramT;
  }
  
  public void setScanSource(int paramInt)
  {
    this.Jal = paramInt;
  }
  
  protected final void setScanTips(TextView paramTextView)
  {
    this.IXT = paramTextView;
  }
  
  protected final void setViewDestroy(boolean paramBoolean)
  {
    this.Jam = paramBoolean;
  }
  
  public void xA(boolean paramBoolean) {}
  
  public final void xD(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    TextView localTextView;
    if ((paramBoolean) && (this.Jao != null))
    {
      localTextView = this.IXT;
      if (localTextView != null)
      {
        BaseScanRequest localBaseScanRequest = this.Jao;
        if (localBaseScanRequest == null) {
          p.iCn();
        }
        if ((localBaseScanRequest.IGl) || (!paramBoolean)) {
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
      localTextView = this.IXT;
    } while (localTextView == null);
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public final void xG(boolean paramBoolean)
  {
    if ((paramBoolean) && (getAlpha() == 0.0F)) {
      n.a((View)this, 0.0F, 1.0F, 200L, null);
    }
    while ((paramBoolean) || (getAlpha() != 1.0F)) {
      return;
    }
    n.a((View)this, 1.0F, 0.0F, 200L, null);
  }
  
  public void xw(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView$Companion;", "", "()V", "ALPHA_ANIMATION_DURATION", "", "SUCCESS_MARK_VIEW_ANIMATION_DURATION", "TAG", "", "scan-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.BaseScanMaskView
 * JD-Core Version:    0.7.0.1
 */