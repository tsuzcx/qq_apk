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
import com.tencent.mm.plugin.scanner.a.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.ScanDecodeFrameData;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "T", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "currentNetworkAvailable", "", "getCurrentNetworkAvailable", "()Z", "setCurrentNetworkAvailable", "(Z)V", "flashSwitcher", "Landroid/view/View;", "getFlashSwitcher", "()Landroid/view/View;", "setFlashSwitcher", "(Landroid/view/View;)V", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getFrameData", "()Lcom/tencent/qbar/ScanDecodeFrameData;", "setFrameData", "(Lcom/tencent/qbar/ScanDecodeFrameData;)V", "isFlashShow", "setFlashShow", "isViewDestroy", "setViewDestroy", "mBottomExtraHeight", "getMBottomExtraHeight", "()I", "setMBottomExtraHeight", "(I)V", "mGalleryButton", "getMGalleryButton", "setMGalleryButton", "mPreviewRect", "Landroid/graphics/Rect;", "getMPreviewRect", "()Landroid/graphics/Rect;", "setMPreviewRect", "(Landroid/graphics/Rect;)V", "mScanRect", "getMScanRect", "setMScanRect", "mScanSource", "getMScanSource", "setMScanSource", "request", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;)V", "scanCamera", "Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "getScanCamera", "()Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "setScanCamera", "(Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;)V", "scanTips", "Landroid/widget/TextView;", "getScanTips", "()Landroid/widget/TextView;", "setScanTips", "(Landroid/widget/TextView;)V", "scanUIModel", "Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "getScanUIModel", "()Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "setScanUIModel", "(Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;)V", "animateAlphaShow", "", "show", "attachBackgroundView", "backgroundView", "attachScanCamera", "attachScanTipsView", "tipsView", "attachScanUI", "checkNetwork", "getTargetSuccessMarkView", "init", "onFlashStatusChanged", "onNetworkChange", "state", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onShowInfoView", "onShowNetworkLoading", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "release", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setPreviewRect", "rect", "setScanRect", "setScanRequest", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showScanTips", "Companion", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseScanMaskView<T extends BaseScanRequest>
  extends RelativeLayout
  implements b<T>
{
  public static final BaseScanMaskView.a Pka = new BaseScanMaskView.a((byte)0);
  public com.tencent.mm.plugin.scanner.model.h OSW;
  private boolean OXx;
  public a PaS;
  public boolean PhG;
  private int PhH;
  public TextView Pht;
  private View Pkb;
  private View Pkc;
  private Rect Pkd;
  private int Pke;
  public boolean Pkf;
  private ScanDecodeFrameData Pkg;
  private BaseScanRequest Pkh;
  private Activity activity;
  private Rect nHF;
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseScanMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    eqb();
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo init networkAvailable: %b", new Object[] { Boolean.valueOf(this.OXx) });
  }
  
  private final void eqb()
  {
    if ((com.tencent.mm.kernel.h.aZW().bFQ() == 6) || (com.tencent.mm.kernel.h.aZW().bFQ() == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.OXx = bool;
      return;
    }
  }
  
  public final void CB(boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBoolean) {
      if (getAlpha() == 0.0F)
      {
        i = 1;
        if (i == 0) {
          break label40;
        }
        p.a((View)this, 0.0F, 1.0F, 200L, null);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label40:
      if (!paramBoolean)
      {
        if (getAlpha() == 1.0F) {}
        for (i = j; i != 0; i = 0)
        {
          p.a((View)this, 1.0F, 0.0F, 200L, null);
          return;
        }
      }
    }
  }
  
  public void Ck(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
  }
  
  public void Co(boolean paramBoolean) {}
  
  public final void Cr(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo showScanTips show: %s, flash: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.PhG) });
    TextView localTextView;
    if ((this.PhG) && (paramBoolean))
    {
      localTextView = this.Pht;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return;
        if ((!paramBoolean) || (this.Pkh == null)) {
          break;
        }
        localTextView = this.Pht;
      } while (localTextView == null);
      BaseScanRequest localBaseScanRequest = this.Pkh;
      kotlin.g.b.s.checkNotNull(localBaseScanRequest);
      if ((!localBaseScanRequest.OMt) && (paramBoolean)) {}
      for (;;)
      {
        localTextView.setVisibility(i);
        return;
        i = 8;
      }
      localTextView = this.Pht;
    } while (localTextView == null);
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    Log.d("MicroMsg.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.Pkf = true;
  }
  
  public void a(Object paramObject, d paramd)
  {
    kotlin.g.b.s.u(paramObject, "data");
  }
  
  public void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void gTe()
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.Pkf = false;
  }
  
  public void gTm() {}
  
  protected final Activity getActivity()
  {
    return this.activity;
  }
  
  protected final boolean getCurrentNetworkAvailable()
  {
    return this.OXx;
  }
  
  protected final View getFlashSwitcher()
  {
    return this.Pkb;
  }
  
  protected final ScanDecodeFrameData getFrameData()
  {
    return this.Pkg;
  }
  
  public final int getMBottomExtraHeight()
  {
    return this.PhH;
  }
  
  protected final View getMGalleryButton()
  {
    return this.Pkc;
  }
  
  protected final Rect getMPreviewRect()
  {
    return this.nHF;
  }
  
  protected final Rect getMScanRect()
  {
    return this.Pkd;
  }
  
  public final int getMScanSource()
  {
    return this.Pke;
  }
  
  public final BaseScanRequest getRequest()
  {
    return this.Pkh;
  }
  
  protected final a getScanCamera()
  {
    return this.PaS;
  }
  
  public final TextView getScanTips()
  {
    return this.Pht;
  }
  
  protected final com.tencent.mm.plugin.scanner.model.h getScanUIModel()
  {
    return this.OSW;
  }
  
  public View getTargetSuccessMarkView()
  {
    return null;
  }
  
  public void iZ(View paramView) {}
  
  public void onNetworkChange(int paramInt)
  {
    Log.i("MicroMsg.BaseScanMaskView", "alvinluo onNetworkChange state: %d", new Object[] { Integer.valueOf(paramInt) });
    eqb();
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
    this.PhH = paramInt;
  }
  
  protected final void setCurrentNetworkAvailable(boolean paramBoolean)
  {
    this.OXx = paramBoolean;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.Pkg = paramScanDecodeFrameData;
  }
  
  protected final void setFlashShow(boolean paramBoolean)
  {
    this.PhG = paramBoolean;
  }
  
  protected final void setFlashSwitcher(View paramView)
  {
    this.Pkb = paramView;
  }
  
  protected final void setFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    this.Pkg = paramScanDecodeFrameData;
  }
  
  protected final void setMBottomExtraHeight(int paramInt)
  {
    this.PhH = paramInt;
  }
  
  protected final void setMGalleryButton(View paramView)
  {
    this.Pkc = paramView;
  }
  
  protected final void setMPreviewRect(Rect paramRect)
  {
    this.nHF = paramRect;
  }
  
  protected final void setMScanRect(Rect paramRect)
  {
    this.Pkd = paramRect;
  }
  
  protected final void setMScanSource(int paramInt)
  {
    this.Pke = paramInt;
  }
  
  public final void setPreviewRect(Rect paramRect)
  {
    this.nHF = paramRect;
    postInvalidate();
  }
  
  protected final void setRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.Pkh = paramBaseScanRequest;
  }
  
  protected final void setScanCamera(a parama)
  {
    this.PaS = parama;
  }
  
  public final void setScanRect(Rect paramRect)
  {
    this.Pkd = paramRect;
  }
  
  public void setScanRequest(T paramT)
  {
    this.Pkh = paramT;
  }
  
  public void setScanSource(int paramInt)
  {
    this.Pke = paramInt;
  }
  
  protected final void setScanTips(TextView paramTextView)
  {
    this.Pht = paramTextView;
  }
  
  protected final void setScanUIModel(com.tencent.mm.plugin.scanner.model.h paramh)
  {
    this.OSW = paramh;
  }
  
  protected final void setViewDestroy(boolean paramBoolean)
  {
    this.Pkf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.BaseScanMaskView
 * JD-Core Version:    0.7.0.1
 */