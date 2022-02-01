package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.l.b;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScanSharedMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/TextureView;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurMaskView", "Landroid/widget/ImageView;", "contentLayout", "currentNetworkAvailable", "", "currentTab", "darkCornerMask", "flashSwitcher", "Lcom/tencent/mm/plugin/scanner/ui/ScannerFlashSwitcher;", "galleryButton", "Landroid/view/View;", "isFlashShow", "isTitleShowing", "mBottomExtraHeight", "needAnimateBackgroundView", "onFlashSwitcherClickListener", "Landroid/view/View$OnClickListener;", "onGalleryClickListener", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "scanTips", "Landroid/widget/TextView;", "scanTipsWording", "", "scanTitle", "scanToast", "showTitle", "showToast", "titleShowAnimationTask", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask;", "toastShowAnimationTask", "animateBackgroundView", "", "show", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "animateShow", "animateShowScanTips", "attachBackgroundView", "textureView", "cancelTitleAnimationTask", "cancelToastAnimationTask", "checkNetwork", "getFlashSwitcherView", "getGalleryButton", "getScanTipsView", "getScanTitleView", "init", "onFlashStatusChanged", "onNetworkChange", "state", "onPreviewReady", "isSwitchTab", "onScanSuccess", "onShowInfoView", "onViewReady", "recycleBlurBitmap", "release", "setAnimateBackgroundView", "needAnimate", "setBottomExtraHeight", "bottomHeight", "setFlashStatus", "setOnFlashSwitcherClickListener", "onClickListener", "setOnGalleryClickListener", "setScanRequest", "request", "setScanTips", "tips", "setScanTitle", "title", "setScanToast", "toast", "setShowTitle", "setShowToast", "showGalleryButton", "showScanTips", "startTitleAnimationTask", "withShowAnimation", "startToastAnimationTask", "updateBackgroundBlurView", "updateTitleAndTips", "updateViewByNetwork", "updateViewLayoutParams", "Companion", "plugin-scan_release"})
public final class ScanSharedMaskView
  extends RelativeLayout
{
  public static final ScanSharedMaskView.a CSS;
  private Bitmap BQT;
  private String CAQ;
  private BaseScanRequest CJD;
  public ScannerFlashSwitcher CJh;
  private boolean CJv;
  public TextView CSA;
  public TextView CSB;
  public TextView CSC;
  private ImageView CSD;
  public View CSE;
  private ImageView CSF;
  public int CSG;
  public TextureView CSH;
  private boolean CSI;
  private View.OnClickListener CSJ;
  private View.OnClickListener CSK;
  public com.tencent.mm.plugin.scanner.util.l CSL;
  private com.tencent.mm.plugin.scanner.util.l CSM;
  public boolean CSN;
  public boolean CSO;
  public int CSP;
  public boolean CSQ;
  private boolean CSR;
  public RelativeLayout contentLayout;
  
  static
  {
    AppMethodBeat.i(52465);
    CSS = new ScanSharedMaskView.a((byte)0);
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
    this.CJv = true;
    this.CSQ = true;
    this.CAQ = "";
    paramContext = LayoutInflater.from(paramContext).inflate(2131495196, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131299205);
    p.g(paramAttributeSet, "view.findViewById(R.id.content_layout)");
    this.contentLayout = ((RelativeLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131307264);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_title)");
    this.CSA = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131307263);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_tip_tv)");
    this.CSB = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131307270);
    p.g(paramAttributeSet, "view.findViewById(R.id.scan_toast_tv)");
    this.CSC = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299406);
    p.g(paramAttributeSet, "view.findViewById(R.id.dark_corner_mask)");
    this.CSD = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131307278);
    p.g(paramAttributeSet, "view.findViewById(R.id.scanner_flash_switcher)");
    this.CJh = ((ScannerFlashSwitcher)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131307527);
    p.g(paramAttributeSet, "view.findViewById(R.id.select_from_gallery)");
    this.CSE = paramAttributeSet;
    paramContext = paramContext.findViewById(2131297173);
    p.g(paramContext, "view.findViewById(R.id.background_blur_mask_view)");
    this.CSF = ((ImageView)paramContext);
    paramContext = this.CSE;
    if (paramContext == null) {
      p.btv("galleryButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new ScanSharedMaskView.d(this));
    paramContext = this.CJh;
    if (paramContext == null) {
      p.btv("flashSwitcher");
    }
    paramContext.setOnClickListener((View.OnClickListener)new ScanSharedMaskView.e(this));
    paramContext = this.CSA;
    if (paramContext == null) {
      p.btv("scanTitle");
    }
    ao.a((Paint)paramContext.getPaint(), 0.8F);
    AppMethodBeat.o(52464);
  }
  
  private final void eRr()
  {
    AppMethodBeat.i(240696);
    if (this.BQT != null)
    {
      Bitmap localBitmap = this.BQT;
      if (localBitmap == null) {
        p.hyc();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.BQT;
        if (localBitmap == null) {
          p.hyc();
        }
        localBitmap.recycle();
        this.BQT = null;
      }
    }
    AppMethodBeat.o(240696);
  }
  
  private final void ug(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(240692);
    if ((paramBoolean) && (this.CJD != null))
    {
      localView = this.CSE;
      if (localView == null) {
        p.btv("galleryButton");
      }
      BaseScanRequest localBaseScanRequest = this.CJD;
      if (localBaseScanRequest == null) {
        p.hyc();
      }
      if ((!localBaseScanRequest.CAH) && (paramBoolean)) {}
      for (;;)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(240692);
        return;
        i = 8;
      }
    }
    View localView = this.CSE;
    if (localView == null) {
      p.btv("galleryButton");
    }
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(240692);
      return;
    }
  }
  
  private final void uj(boolean paramBoolean)
  {
    boolean bool = false;
    float f2 = 1.0F;
    AppMethodBeat.i(170087);
    Object localObject = this.CSB;
    if (localObject == null) {
      p.btv("scanTips");
    }
    if (((TextView)localObject).getVisibility() == 0) {
      bool = true;
    }
    Log.d("MicroMsg.ScanSharedMaskView", "alvinluo animateScanTips show: %b, visible: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    if ((paramBoolean) && (this.CJD != null))
    {
      localObject = this.CJD;
      if (localObject == null) {
        p.hyc();
      }
      if (((BaseScanRequest)localObject).CAF)
      {
        AppMethodBeat.o(170087);
        return;
      }
    }
    localObject = this.CSB;
    if (localObject == null) {
      p.btv("scanTips");
    }
    if (((TextView)localObject).getVisibility() == 0)
    {
      localObject = this.CSB;
      if (localObject == null) {
        p.btv("scanTips");
      }
      if ((((TextView)localObject).getAlpha() == 1.0F) && (paramBoolean))
      {
        AppMethodBeat.o(170087);
        return;
      }
    }
    localObject = this.CSB;
    if (localObject == null) {
      p.btv("scanTips");
    }
    if ((((TextView)localObject).getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    uf(true);
    localObject = this.CSB;
    if (localObject == null) {
      p.btv("scanTips");
    }
    localObject = (View)localObject;
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label279;
      }
    }
    for (;;)
    {
      m.a((View)localObject, f1, f2, 200L, (Animator.AnimatorListener)new ScanSharedMaskView.c(this, paramBoolean));
      AppMethodBeat.o(170087);
      return;
      f1 = 1.0F;
      break;
      label279:
      f2 = 0.0F;
    }
  }
  
  public final void WY(int paramInt)
  {
    AppMethodBeat.i(240690);
    TextView localTextView;
    if (this.CJv)
    {
      ug(true);
      localTextView = this.CSB;
      if (localTextView == null) {
        p.btv("scanTips");
      }
      localTextView.setText((CharSequence)this.CAQ);
      AppMethodBeat.o(240690);
      return;
    }
    if ((r.Xe(paramInt)) || (r.Xf(paramInt)))
    {
      localTextView = this.CSB;
      if (localTextView == null) {
        p.btv("scanTips");
      }
      localTextView.setText(2131764952);
      ug(false);
      AppMethodBeat.o(240690);
      return;
    }
    ug(true);
    AppMethodBeat.o(240690);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(240689);
    t localt = g.azz();
    p.g(localt, "MMKernel.getNetSceneQueue()");
    if (localt.aYS() != 6)
    {
      localt = g.azz();
      p.g(localt, "MMKernel.getNetSceneQueue()");
      if (localt.aYS() != 4) {
        break label59;
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      this.CJv = bool;
      AppMethodBeat.o(240689);
      return;
    }
  }
  
  public final void eRF()
  {
    AppMethodBeat.i(240693);
    com.tencent.mm.plugin.scanner.util.l locall = this.CSL;
    if (locall != null)
    {
      locall.cancel();
      AppMethodBeat.o(240693);
      return;
    }
    AppMethodBeat.o(240693);
  }
  
  public final void eRG()
  {
    AppMethodBeat.i(240694);
    com.tencent.mm.plugin.scanner.util.l locall = this.CSM;
    if (locall != null)
    {
      locall.cancel();
      AppMethodBeat.o(240694);
      return;
    }
    AppMethodBeat.o(240694);
  }
  
  public final void eRH()
  {
    AppMethodBeat.i(240695);
    Log.v("MicroMsg.ScanSharedMaskView", "alvinluo onScanSuccess");
    Object localObject = this.CSE;
    if (localObject == null) {
      p.btv("galleryButton");
    }
    m.a((View)localObject, 1.0F, 0.0F, 200L, null);
    eRG();
    eRF();
    localObject = this.CSA;
    if (localObject == null) {
      p.btv("scanTitle");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.CSC;
    if (localObject == null) {
      p.btv("scanToast");
    }
    ((TextView)localObject).setVisibility(8);
    this.CSN = false;
    this.CSO = false;
    localObject = this.CJh;
    if (localObject == null) {
      p.btv("flashSwitcher");
    }
    ((ScannerFlashSwitcher)localObject).setVisibility(8);
    AppMethodBeat.o(240695);
  }
  
  public final void f(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(240688);
    if (this.BQT != null)
    {
      localObject = this.BQT;
      if (localObject == null) {
        p.hyc();
      }
      if (!((Bitmap)localObject).isRecycled()) {}
    }
    else
    {
      paramAnimatorListenerAdapter = this.CSF;
      if (paramAnimatorListenerAdapter == null) {
        p.btv("blurMaskView");
      }
      paramAnimatorListenerAdapter.setVisibility(8);
      AppMethodBeat.o(240688);
      return;
    }
    Object localObject = this.CSF;
    if (localObject == null) {
      p.btv("blurMaskView");
    }
    ((ImageView)localObject).setVisibility(0);
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label178;
      }
    }
    for (;;)
    {
      localObject = this.CSF;
      if (localObject == null) {
        p.btv("blurMaskView");
      }
      ((ImageView)localObject).setAlpha(f1);
      localObject = this.CSF;
      if (localObject == null) {
        p.btv("blurMaskView");
      }
      m.a((View)localObject, f1, f2, 150L, (Animator.AnimatorListener)new ScanSharedMaskView.b(this, paramBoolean, paramAnimatorListenerAdapter));
      AppMethodBeat.o(240688);
      return;
      f1 = 1.0F;
      break;
      label178:
      f2 = 0.0F;
    }
  }
  
  public final ScannerFlashSwitcher getFlashSwitcherView()
  {
    AppMethodBeat.i(52455);
    ScannerFlashSwitcher localScannerFlashSwitcher = this.CJh;
    if (localScannerFlashSwitcher == null) {
      p.btv("flashSwitcher");
    }
    AppMethodBeat.o(52455);
    return localScannerFlashSwitcher;
  }
  
  public final View getGalleryButton()
  {
    AppMethodBeat.i(52458);
    View localView = this.CSE;
    if (localView == null) {
      p.btv("galleryButton");
    }
    AppMethodBeat.o(52458);
    return localView;
  }
  
  public final TextView getScanTipsView()
  {
    AppMethodBeat.i(52454);
    TextView localTextView = this.CSB;
    if (localTextView == null) {
      p.btv("scanTips");
    }
    AppMethodBeat.o(52454);
    return localTextView;
  }
  
  public final TextView getScanTitleView()
  {
    AppMethodBeat.i(52452);
    TextView localTextView = this.CSA;
    if (localTextView == null) {
      p.btv("scanTitle");
    }
    AppMethodBeat.o(52452);
    return localTextView;
  }
  
  public final void setAnimateBackgroundView(boolean paramBoolean)
  {
    AppMethodBeat.i(240687);
    this.CSI = paramBoolean;
    if ((!this.CSI) || (this.CSH == null))
    {
      Log.e("MicroMsg.ScanSharedMaskView", "updateBackgroundBlurView not need show blurMaskView");
      ImageView localImageView = this.CSF;
      if (localImageView == null) {
        p.btv("blurMaskView");
      }
      localImageView.setVisibility(8);
      eRr();
      AppMethodBeat.o(240687);
      return;
    }
    h.RTc.aX((Runnable)new ScanSharedMaskView.h(this));
    AppMethodBeat.o(240687);
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    this.CSP = paramInt;
  }
  
  public final void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(170085);
    Log.d("MicroMsg.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CSO = paramBoolean;
    AppMethodBeat.o(170085);
  }
  
  public final void setOnFlashSwitcherClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52457);
    p.h(paramOnClickListener, "onClickListener");
    this.CSK = paramOnClickListener;
    AppMethodBeat.o(52457);
  }
  
  public final void setOnGalleryClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52456);
    p.h(paramOnClickListener, "onClickListener");
    this.CSJ = paramOnClickListener;
    paramOnClickListener = this.CSE;
    if (paramOnClickListener == null) {
      p.btv("galleryButton");
    }
    paramOnClickListener.setOnClickListener(this.CSJ);
    AppMethodBeat.o(52456);
  }
  
  public final void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.CJD = paramBaseScanRequest;
  }
  
  public final void setScanTips(String paramString)
  {
    AppMethodBeat.i(52453);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      this.CAQ = ((String)localObject);
      localObject = this.CSB;
      if (localObject == null) {
        p.btv("scanTips");
      }
      ((TextView)localObject).setText((CharSequence)paramString);
      AppMethodBeat.o(52453);
      return;
    }
  }
  
  public final void setScanTitle(String paramString)
  {
    AppMethodBeat.i(52451);
    TextView localTextView = this.CSA;
    if (localTextView == null) {
      p.btv("scanTitle");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52451);
  }
  
  public final void setScanToast(String paramString)
  {
    AppMethodBeat.i(240686);
    TextView localTextView = this.CSC;
    if (localTextView == null) {
      p.btv("scanToast");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(240686);
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.CSQ = paramBoolean;
  }
  
  public final void setShowToast(boolean paramBoolean)
  {
    this.CSR = paramBoolean;
  }
  
  public final void tY(boolean paramBoolean)
  {
    AppMethodBeat.i(52459);
    Log.v("MicroMsg.ScanSharedMaskView", "alvinluo onPreviewReady isSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      View localView = this.CSE;
      if (localView == null) {
        p.btv("galleryButton");
      }
      if (localView.getVisibility() == 0)
      {
        localView = this.CSE;
        if (localView == null) {
          p.btv("galleryButton");
        }
        m.a(localView, 0.0F, 1.0F, 200L, null);
      }
    }
    AppMethodBeat.o(52459);
  }
  
  public final void uf(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(240691);
    if ((paramBoolean) && (this.CJD != null))
    {
      localTextView = this.CSB;
      if (localTextView == null) {
        p.btv("scanTips");
      }
      BaseScanRequest localBaseScanRequest = this.CJD;
      if (localBaseScanRequest == null) {
        p.hyc();
      }
      if ((!localBaseScanRequest.CAF) && (paramBoolean)) {}
      for (;;)
      {
        localTextView.setVisibility(i);
        AppMethodBeat.o(240691);
        return;
        i = 8;
      }
    }
    TextView localTextView = this.CSB;
    if (localTextView == null) {
      p.btv("scanTips");
    }
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(240691);
      return;
    }
  }
  
  public final void uh(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(170086);
    Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b, isTitleShowing: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.CSN) });
    if (this.CSO != paramBoolean)
    {
      this.CSO = paramBoolean;
      if (!this.CSN) {
        if (paramBoolean) {
          break label76;
        }
      }
    }
    label76:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      uj(paramBoolean);
      AppMethodBeat.o(170086);
      return;
    }
  }
  
  public final void ui(boolean paramBoolean)
  {
    AppMethodBeat.i(52460);
    Log.v("MicroMsg.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(getAlpha()) });
    if ((paramBoolean) && (getAlpha() == 0.0F))
    {
      m.a((View)this, 0.0F, 1.0F, 200L, null);
      AppMethodBeat.o(52460);
      return;
    }
    if ((!paramBoolean) && (getAlpha() == 1.0F)) {
      m.a((View)this, 1.0F, 0.0F, 200L, null);
    }
    AppMethodBeat.o(52460);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startTitleAnimationTask$1", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "plugin-scan_release"})
  public static final class f
    implements l.b
  {
    public final void eRI()
    {
      AppMethodBeat.i(240680);
      ScanSharedMaskView.e(this.CST).setShadowLayer(10.0F, 0.0F, 0.0F, this.CST.getResources().getColor(2131099660));
      AppMethodBeat.o(240680);
    }
    
    public final void eRJ()
    {
      AppMethodBeat.i(240681);
      ScanSharedMaskView.a(this.CST, true);
      AppMethodBeat.o(240681);
    }
    
    public final void eRK()
    {
      AppMethodBeat.i(240682);
      ScanSharedMaskView.a(this.CST, false);
      Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onShowTaskEnd isFlashShow: %b, showToast: %b", new Object[] { Boolean.valueOf(ScanSharedMaskView.f(this.CST)), Boolean.valueOf(ScanSharedMaskView.g(this.CST)) });
      if (ScanSharedMaskView.f(this.CST))
      {
        AppMethodBeat.o(240682);
        return;
      }
      if (ScanSharedMaskView.g(this.CST))
      {
        ScanSharedMaskView.h(this.CST);
        ScanSharedMaskView.i(this.CST);
        AppMethodBeat.o(240682);
        return;
      }
      ScanSharedMaskView.j(this.CST);
      AppMethodBeat.o(240682);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startToastAnimationTask$1", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "plugin-scan_release"})
  public static final class g
    implements l.b
  {
    public final void eRI() {}
    
    public final void eRJ() {}
    
    public final void eRK()
    {
      AppMethodBeat.i(240683);
      if (ScanSharedMaskView.f(this.CST))
      {
        AppMethodBeat.o(240683);
        return;
      }
      ScanSharedMaskView.j(this.CST);
      AppMethodBeat.o(240683);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView
 * JD-Core Version:    0.7.0.1
 */