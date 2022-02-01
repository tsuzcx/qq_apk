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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScanSharedMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/TextureView;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurMaskView", "Landroid/widget/ImageView;", "contentLayout", "currentNetworkAvailable", "", "currentTab", "darkCornerMask", "flashSwitcher", "Lcom/tencent/mm/plugin/scanner/ui/ScannerFlashSwitcher;", "galleryButton", "Landroid/view/View;", "isFlashShow", "isTitleShowing", "mBottomExtraHeight", "needAnimateBackgroundView", "onFlashSwitcherClickListener", "Landroid/view/View$OnClickListener;", "onGalleryClickListener", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "scanTips", "Landroid/widget/TextView;", "scanTipsWording", "", "scanTitle", "scanToast", "showTitle", "showToast", "titleShowAnimationTask", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask;", "toastShowAnimationTask", "animateBackgroundView", "", "show", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "animateShow", "animateShowScanTips", "attachBackgroundView", "textureView", "cancelTitleAnimationTask", "cancelToastAnimationTask", "checkNetwork", "getFlashSwitcherView", "getGalleryButton", "getScanTipsView", "getScanTitleView", "init", "onFlashStatusChanged", "onNetworkChange", "state", "onPreviewReady", "isSwitchTab", "onScanSuccess", "onShowInfoView", "onViewReady", "recycleBlurBitmap", "release", "setAnimateBackgroundView", "needAnimate", "setBottomExtraHeight", "bottomHeight", "setFlashStatus", "setOnFlashSwitcherClickListener", "onClickListener", "setOnGalleryClickListener", "setScanRequest", "request", "setScanTips", "tips", "setScanTitle", "title", "setScanToast", "toast", "setShowTitle", "setShowToast", "showGalleryButton", "showScanTips", "startTitleAnimationTask", "withShowAnimation", "startToastAnimationTask", "updateBackgroundBlurView", "updateTitleAndTips", "updateViewByNetwork", "updateViewLayoutParams", "Companion", "plugin-scan_release"})
public final class ScanSharedMaskView
  extends RelativeLayout
{
  public static final ScanSharedMaskView.a IYk;
  private Bitmap HNJ;
  private String IGv;
  public ScannerFlashSwitcher IOH;
  private boolean IOW;
  private BaseScanRequest IPe;
  public TextView IXS;
  public TextView IXT;
  public TextView IXU;
  private ImageView IXV;
  public View IXW;
  private ImageView IXX;
  public int IXY;
  public TextureView IXZ;
  private boolean IYa;
  private View.OnClickListener IYb;
  private View.OnClickListener IYc;
  public m IYd;
  private m IYe;
  public boolean IYf;
  public boolean IYg;
  public int IYh;
  public boolean IYi;
  private boolean IYj;
  public RelativeLayout contentLayout;
  
  static
  {
    AppMethodBeat.i(52465);
    IYk = new ScanSharedMaskView.a((byte)0);
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
    this.IOW = true;
    this.IYi = true;
    this.IGv = "";
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.IEd, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(l.f.content_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.content_layout)");
    this.contentLayout = ((RelativeLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.IDy);
    p.j(paramAttributeSet, "view.findViewById(R.id.scan_title)");
    this.IXS = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.IDx);
    p.j(paramAttributeSet, "view.findViewById(R.id.scan_tip_tv)");
    this.IXT = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.IDz);
    p.j(paramAttributeSet, "view.findViewById(R.id.scan_toast_tv)");
    this.IXU = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.ICF);
    p.j(paramAttributeSet, "view.findViewById(R.id.dark_corner_mask)");
    this.IXV = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.scanner_flash_switcher);
    p.j(paramAttributeSet, "view.findViewById(R.id.scanner_flash_switcher)");
    this.IOH = ((ScannerFlashSwitcher)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.IDD);
    p.j(paramAttributeSet, "view.findViewById(R.id.select_from_gallery)");
    this.IXW = paramAttributeSet;
    paramContext = paramContext.findViewById(l.f.ICv);
    p.j(paramContext, "view.findViewById(R.id.background_blur_mask_view)");
    this.IXX = ((ImageView)paramContext);
    paramContext = this.IXW;
    if (paramContext == null) {
      p.bGy("galleryButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new ScanSharedMaskView.d(this));
    paramContext = this.IOH;
    if (paramContext == null) {
      p.bGy("flashSwitcher");
    }
    paramContext.setOnClickListener((View.OnClickListener)new ScanSharedMaskView.e(this));
    paramContext = this.IXS;
    if (paramContext == null) {
      p.bGy("scanTitle");
    }
    ar.a((Paint)paramContext.getPaint(), 0.8F);
    AppMethodBeat.o(52464);
  }
  
  private final void fEs()
  {
    AppMethodBeat.i(217213);
    if (this.HNJ != null)
    {
      Bitmap localBitmap = this.HNJ;
      if (localBitmap == null) {
        p.iCn();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.HNJ;
        if (localBitmap == null) {
          p.iCn();
        }
        localBitmap.recycle();
        this.HNJ = null;
      }
    }
    AppMethodBeat.o(217213);
  }
  
  private final void xE(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(217205);
    if ((paramBoolean) && (this.IPe != null))
    {
      localView = this.IXW;
      if (localView == null) {
        p.bGy("galleryButton");
      }
      BaseScanRequest localBaseScanRequest = this.IPe;
      if (localBaseScanRequest == null) {
        p.iCn();
      }
      if ((!localBaseScanRequest.IGn) && (paramBoolean)) {}
      for (;;)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(217205);
        return;
        i = 8;
      }
    }
    View localView = this.IXW;
    if (localView == null) {
      p.bGy("galleryButton");
    }
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(217205);
      return;
    }
  }
  
  private final void xH(boolean paramBoolean)
  {
    boolean bool = false;
    float f2 = 1.0F;
    AppMethodBeat.i(170087);
    Object localObject = this.IXT;
    if (localObject == null) {
      p.bGy("scanTips");
    }
    if (((TextView)localObject).getVisibility() == 0) {
      bool = true;
    }
    Log.d("MicroMsg.ScanSharedMaskView", "alvinluo animateScanTips show: %b, visible: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    if ((paramBoolean) && (this.IPe != null))
    {
      localObject = this.IPe;
      if (localObject == null) {
        p.iCn();
      }
      if (((BaseScanRequest)localObject).IGl)
      {
        AppMethodBeat.o(170087);
        return;
      }
    }
    localObject = this.IXT;
    if (localObject == null) {
      p.bGy("scanTips");
    }
    if (((TextView)localObject).getVisibility() == 0)
    {
      localObject = this.IXT;
      if (localObject == null) {
        p.bGy("scanTips");
      }
      if ((((TextView)localObject).getAlpha() == 1.0F) && (paramBoolean))
      {
        AppMethodBeat.o(170087);
        return;
      }
    }
    localObject = this.IXT;
    if (localObject == null) {
      p.bGy("scanTips");
    }
    if ((((TextView)localObject).getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    xD(true);
    localObject = this.IXT;
    if (localObject == null) {
      p.bGy("scanTips");
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
      n.a((View)localObject, f1, f2, 200L, (Animator.AnimatorListener)new ScanSharedMaskView.c(this, paramBoolean));
      AppMethodBeat.o(170087);
      return;
      f1 = 1.0F;
      break;
      label279:
      f2 = 0.0F;
    }
  }
  
  public final void adW(int paramInt)
  {
    AppMethodBeat.i(217202);
    TextView localTextView;
    if (this.IOW)
    {
      xE(true);
      localTextView = this.IXT;
      if (localTextView == null) {
        p.bGy("scanTips");
      }
      localTextView.setText((CharSequence)this.IGv);
      AppMethodBeat.o(217202);
      return;
    }
    if ((r.aec(paramInt)) || (r.aed(paramInt)))
    {
      localTextView = this.IXT;
      if (localTextView == null) {
        p.bGy("scanTips");
      }
      localTextView.setText(l.i.scan_no_network_tips);
      xE(false);
      AppMethodBeat.o(217202);
      return;
    }
    xE(true);
    AppMethodBeat.o(217202);
  }
  
  public final void dBp()
  {
    AppMethodBeat.i(217201);
    t localt = com.tencent.mm.kernel.h.aGY();
    p.j(localt, "MMKernel.getNetSceneQueue()");
    if (localt.bih() != 6)
    {
      localt = com.tencent.mm.kernel.h.aGY();
      p.j(localt, "MMKernel.getNetSceneQueue()");
      if (localt.bih() != 4) {
        break label59;
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      this.IOW = bool;
      AppMethodBeat.o(217201);
      return;
    }
  }
  
  public final void f(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(217199);
    if (this.HNJ != null)
    {
      localObject = this.HNJ;
      if (localObject == null) {
        p.iCn();
      }
      if (!((Bitmap)localObject).isRecycled()) {}
    }
    else
    {
      paramAnimatorListenerAdapter = this.IXX;
      if (paramAnimatorListenerAdapter == null) {
        p.bGy("blurMaskView");
      }
      paramAnimatorListenerAdapter.setVisibility(8);
      AppMethodBeat.o(217199);
      return;
    }
    Object localObject = this.IXX;
    if (localObject == null) {
      p.bGy("blurMaskView");
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
      localObject = this.IXX;
      if (localObject == null) {
        p.bGy("blurMaskView");
      }
      ((ImageView)localObject).setAlpha(f1);
      localObject = this.IXX;
      if (localObject == null) {
        p.bGy("blurMaskView");
      }
      n.a((View)localObject, f1, f2, 150L, (Animator.AnimatorListener)new ScanSharedMaskView.b(this, paramBoolean, paramAnimatorListenerAdapter));
      AppMethodBeat.o(217199);
      return;
      f1 = 1.0F;
      break;
      label178:
      f2 = 0.0F;
    }
  }
  
  public final void fEE()
  {
    AppMethodBeat.i(217206);
    m localm = this.IYd;
    if (localm != null)
    {
      localm.cancel();
      AppMethodBeat.o(217206);
      return;
    }
    AppMethodBeat.o(217206);
  }
  
  public final void fEF()
  {
    AppMethodBeat.i(217207);
    m localm = this.IYe;
    if (localm != null)
    {
      localm.cancel();
      AppMethodBeat.o(217207);
      return;
    }
    AppMethodBeat.o(217207);
  }
  
  public final void fEG()
  {
    AppMethodBeat.i(217209);
    Log.v("MicroMsg.ScanSharedMaskView", "alvinluo onScanSuccess");
    Object localObject = this.IXW;
    if (localObject == null) {
      p.bGy("galleryButton");
    }
    n.a((View)localObject, 1.0F, 0.0F, 200L, null);
    fEF();
    fEE();
    localObject = this.IXS;
    if (localObject == null) {
      p.bGy("scanTitle");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.IXU;
    if (localObject == null) {
      p.bGy("scanToast");
    }
    ((TextView)localObject).setVisibility(8);
    this.IYf = false;
    this.IYg = false;
    localObject = this.IOH;
    if (localObject == null) {
      p.bGy("flashSwitcher");
    }
    ((ScannerFlashSwitcher)localObject).setVisibility(8);
    AppMethodBeat.o(217209);
  }
  
  public final ScannerFlashSwitcher getFlashSwitcherView()
  {
    AppMethodBeat.i(52455);
    ScannerFlashSwitcher localScannerFlashSwitcher = this.IOH;
    if (localScannerFlashSwitcher == null) {
      p.bGy("flashSwitcher");
    }
    AppMethodBeat.o(52455);
    return localScannerFlashSwitcher;
  }
  
  public final View getGalleryButton()
  {
    AppMethodBeat.i(52458);
    View localView = this.IXW;
    if (localView == null) {
      p.bGy("galleryButton");
    }
    AppMethodBeat.o(52458);
    return localView;
  }
  
  public final TextView getScanTipsView()
  {
    AppMethodBeat.i(52454);
    TextView localTextView = this.IXT;
    if (localTextView == null) {
      p.bGy("scanTips");
    }
    AppMethodBeat.o(52454);
    return localTextView;
  }
  
  public final TextView getScanTitleView()
  {
    AppMethodBeat.i(52452);
    TextView localTextView = this.IXS;
    if (localTextView == null) {
      p.bGy("scanTitle");
    }
    AppMethodBeat.o(52452);
    return localTextView;
  }
  
  public final void setAnimateBackgroundView(boolean paramBoolean)
  {
    AppMethodBeat.i(217196);
    this.IYa = paramBoolean;
    if ((!this.IYa) || (this.IXZ == null))
    {
      Log.e("MicroMsg.ScanSharedMaskView", "updateBackgroundBlurView not need show blurMaskView");
      ImageView localImageView = this.IXX;
      if (localImageView == null) {
        p.bGy("blurMaskView");
      }
      localImageView.setVisibility(8);
      fEs();
      AppMethodBeat.o(217196);
      return;
    }
    com.tencent.e.h.ZvG.be((Runnable)new ScanSharedMaskView.h(this));
    AppMethodBeat.o(217196);
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    this.IYh = paramInt;
  }
  
  public final void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(170085);
    Log.d("MicroMsg.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.IYg = paramBoolean;
    AppMethodBeat.o(170085);
  }
  
  public final void setOnFlashSwitcherClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52457);
    p.k(paramOnClickListener, "onClickListener");
    this.IYc = paramOnClickListener;
    AppMethodBeat.o(52457);
  }
  
  public final void setOnGalleryClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52456);
    p.k(paramOnClickListener, "onClickListener");
    this.IYb = paramOnClickListener;
    paramOnClickListener = this.IXW;
    if (paramOnClickListener == null) {
      p.bGy("galleryButton");
    }
    paramOnClickListener.setOnClickListener(this.IYb);
    AppMethodBeat.o(52456);
  }
  
  public final void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.IPe = paramBaseScanRequest;
  }
  
  public final void setScanTips(String paramString)
  {
    AppMethodBeat.i(52453);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      this.IGv = ((String)localObject);
      localObject = this.IXT;
      if (localObject == null) {
        p.bGy("scanTips");
      }
      ((TextView)localObject).setText((CharSequence)paramString);
      AppMethodBeat.o(52453);
      return;
    }
  }
  
  public final void setScanTitle(String paramString)
  {
    AppMethodBeat.i(52451);
    TextView localTextView = this.IXS;
    if (localTextView == null) {
      p.bGy("scanTitle");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(52451);
  }
  
  public final void setScanToast(String paramString)
  {
    AppMethodBeat.i(217192);
    TextView localTextView = this.IXU;
    if (localTextView == null) {
      p.bGy("scanToast");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(217192);
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.IYi = paramBoolean;
  }
  
  public final void setShowToast(boolean paramBoolean)
  {
    this.IYj = paramBoolean;
  }
  
  public final void xD(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(217203);
    if ((paramBoolean) && (this.IPe != null))
    {
      localTextView = this.IXT;
      if (localTextView == null) {
        p.bGy("scanTips");
      }
      BaseScanRequest localBaseScanRequest = this.IPe;
      if (localBaseScanRequest == null) {
        p.iCn();
      }
      if ((!localBaseScanRequest.IGl) && (paramBoolean)) {}
      for (;;)
      {
        localTextView.setVisibility(i);
        AppMethodBeat.o(217203);
        return;
        i = 8;
      }
    }
    TextView localTextView = this.IXT;
    if (localTextView == null) {
      p.bGy("scanTips");
    }
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(217203);
      return;
    }
  }
  
  public final void xF(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(170086);
    Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b, isTitleShowing: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.IYf) });
    if (this.IYg != paramBoolean)
    {
      this.IYg = paramBoolean;
      if (!this.IYf) {
        if (paramBoolean) {
          break label76;
        }
      }
    }
    label76:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      xH(paramBoolean);
      AppMethodBeat.o(170086);
      return;
    }
  }
  
  public final void xG(boolean paramBoolean)
  {
    AppMethodBeat.i(52460);
    Log.v("MicroMsg.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(getAlpha()) });
    if ((paramBoolean) && (getAlpha() == 0.0F))
    {
      n.a((View)this, 0.0F, 1.0F, 200L, null);
      AppMethodBeat.o(52460);
      return;
    }
    if ((!paramBoolean) && (getAlpha() == 1.0F)) {
      n.a((View)this, 1.0F, 0.0F, 200L, null);
    }
    AppMethodBeat.o(52460);
  }
  
  public final void xw(boolean paramBoolean)
  {
    AppMethodBeat.i(52459);
    Log.v("MicroMsg.ScanSharedMaskView", "alvinluo onPreviewReady isSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      View localView = this.IXW;
      if (localView == null) {
        p.bGy("galleryButton");
      }
      if (localView.getVisibility() == 0)
      {
        localView = this.IXW;
        if (localView == null) {
          p.bGy("galleryButton");
        }
        n.a(localView, 0.0F, 1.0F, 200L, null);
      }
    }
    AppMethodBeat.o(52459);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startTitleAnimationTask$1", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "plugin-scan_release"})
  public static final class f
    implements m.b
  {
    public final void fEH()
    {
      AppMethodBeat.i(217586);
      ScanSharedMaskView.e(this.IYl).setShadowLayer(10.0F, 0.0F, 0.0F, this.IYl.getResources().getColor(l.c.BW_0_Alpha_0_2));
      AppMethodBeat.o(217586);
    }
    
    public final void fEI()
    {
      AppMethodBeat.i(217588);
      ScanSharedMaskView.a(this.IYl, true);
      AppMethodBeat.o(217588);
    }
    
    public final void fEJ()
    {
      AppMethodBeat.i(217591);
      ScanSharedMaskView.a(this.IYl, false);
      Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onShowTaskEnd isFlashShow: %b, showToast: %b", new Object[] { Boolean.valueOf(ScanSharedMaskView.f(this.IYl)), Boolean.valueOf(ScanSharedMaskView.g(this.IYl)) });
      if (ScanSharedMaskView.f(this.IYl))
      {
        AppMethodBeat.o(217591);
        return;
      }
      if (ScanSharedMaskView.g(this.IYl))
      {
        ScanSharedMaskView.h(this.IYl);
        ScanSharedMaskView.i(this.IYl);
        AppMethodBeat.o(217591);
        return;
      }
      ScanSharedMaskView.j(this.IYl);
      AppMethodBeat.o(217591);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startToastAnimationTask$1", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "plugin-scan_release"})
  public static final class g
    implements m.b
  {
    public final void fEH() {}
    
    public final void fEI() {}
    
    public final void fEJ()
    {
      AppMethodBeat.i(218464);
      if (ScanSharedMaskView.f(this.IYl))
      {
        AppMethodBeat.o(218464);
        return;
      }
      ScanSharedMaskView.j(this.IYl);
      AppMethodBeat.o(218464);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView
 * JD-Core Version:    0.7.0.1
 */