package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.o.b;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScanSharedMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/TextureView;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurMaskView", "Landroid/widget/ImageView;", "contentLayout", "currentNetworkAvailable", "", "currentTab", "darkCornerMask", "flashSwitcher", "Lcom/tencent/mm/plugin/scanner/ui/ScannerFlashSwitcher;", "galleryButton", "Landroid/view/View;", "isFlashShow", "isTitleShowing", "mBottomExtraHeight", "mScanUIModel", "Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "needAnimateBackgroundView", "onFlashSwitcherClickListener", "Landroid/view/View$OnClickListener;", "onGalleryClickListener", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "scanTips", "Landroid/widget/TextView;", "scanTipsWording", "", "scanTitle", "scanToast", "showTitle", "showToast", "titleShowAnimationTask", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask;", "toastShowAnimationTask", "animateBackgroundView", "", "show", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "animateShow", "animateShowScanTips", "attachBackgroundView", "textureView", "attachScanUIModel", "scanUIModel", "cancelTitleAnimationTask", "cancelToastAnimationTask", "checkNetwork", "getFlashSwitcherView", "getGalleryButton", "getScanTipsView", "getScanTitleView", "init", "onFlashStatusChanged", "onNetworkChange", "state", "onPreviewReady", "isSwitchTab", "onScanSuccess", "needAnimation", "onShowInfoView", "onViewReady", "recycleBlurBitmap", "release", "setAnimateBackgroundView", "needAnimate", "setBottomExtraHeight", "bottomHeight", "setFlashStatus", "setOnFlashSwitcherClickListener", "onClickListener", "setOnGalleryClickListener", "setScanRequest", "request", "setScanTips", "tips", "setScanTitle", "title", "setScanToast", "toast", "setShowTitle", "setShowToast", "showGalleryButton", "showScanTips", "startTitleAnimationTask", "withShowAnimation", "startToastAnimationTask", "updateBackgroundBlurView", "updateTitleAndTips", "updateViewByNetwork", "updateViewLayoutParams", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanSharedMaskView
  extends RelativeLayout
{
  public static final ScanSharedMaskView.a Phr;
  private Bitmap NKD;
  private String OMD;
  private BaseScanRequest OXF;
  public ScannerFlashSwitcher OXj;
  private boolean OXx;
  public com.tencent.mm.plugin.scanner.model.h PbH;
  private boolean PhA;
  private View.OnClickListener PhB;
  private View.OnClickListener PhC;
  public o PhD;
  private o PhE;
  public boolean PhF;
  public boolean PhG;
  public int PhH;
  public boolean PhI;
  private boolean PhJ;
  public TextView Phs;
  public TextView Pht;
  public TextView Phu;
  private ImageView Phv;
  public View Phw;
  private ImageView Phx;
  public int Phy;
  public TextureView Phz;
  public RelativeLayout contentLayout;
  
  static
  {
    AppMethodBeat.i(52465);
    Phr = new ScanSharedMaskView.a((byte)0);
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
    this.OXx = true;
    this.PhI = true;
    this.OMD = "";
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.OKg, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(l.f.content_layout);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.content_layout)");
    this.contentLayout = ((RelativeLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.OJA);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.scan_title)");
    this.Phs = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.OJz);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.scan_tip_tv)");
    this.Pht = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.OJB);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.scan_toast_tv)");
    this.Phu = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.OIG);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.dark_corner_mask)");
    this.Phv = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.scanner_flash_switcher);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.scanner_flash_switcher)");
    this.OXj = ((ScannerFlashSwitcher)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.OJF);
    kotlin.g.b.s.s(paramAttributeSet, "view.findViewById(R.id.select_from_gallery)");
    this.Phw = paramAttributeSet;
    paramContext = paramContext.findViewById(l.f.OIw);
    kotlin.g.b.s.s(paramContext, "view.findViewById(R.id.background_blur_mask_view)");
    this.Phx = ((ImageView)paramContext);
    paramAttributeSet = this.Phw;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      kotlin.g.b.s.bIx("galleryButton");
      paramContext = null;
    }
    paramContext.setOnClickListener(new ScanSharedMaskView..ExternalSyntheticLambda0(this));
    paramAttributeSet = this.OXj;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      kotlin.g.b.s.bIx("flashSwitcher");
      paramContext = null;
    }
    paramContext.setOnClickListener(new ScanSharedMaskView..ExternalSyntheticLambda1(this));
    paramContext = this.Phs;
    if (paramContext == null)
    {
      kotlin.g.b.s.bIx("scanTitle");
      paramContext = localObject;
    }
    for (;;)
    {
      aw.a((Paint)paramContext.getPaint(), 0.8F);
      eqb();
      AppMethodBeat.o(52464);
      return;
    }
  }
  
  private final void Cs(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(314755);
    if ((paramBoolean) && (this.OXF != null))
    {
      localObject2 = this.Phw;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("galleryButton");
        localObject2 = this.OXF;
        kotlin.g.b.s.checkNotNull(localObject2);
        if ((((BaseScanRequest)localObject2).OMv) || (!paramBoolean)) {
          break label84;
        }
      }
      label84:
      for (i = 0;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        AppMethodBeat.o(314755);
        return;
        localObject1 = localObject2;
        break;
      }
    }
    localObject1 = this.Phw;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("galleryButton");
      localObject1 = localObject2;
      if (!paramBoolean) {
        break label127;
      }
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(i);
      AppMethodBeat.o(314755);
      return;
      break;
      label127:
      i = 8;
    }
  }
  
  private final void Cw(final boolean paramBoolean)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(170087);
    TextView localTextView = this.Pht;
    Object localObject1 = localTextView;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("scanTips");
      localObject1 = null;
    }
    if (((TextView)localObject1).getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.ScanSharedMaskView", "alvinluo animateScanTips show: %b, visible: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((!paramBoolean) || (this.OXF == null)) {
        break;
      }
      localObject1 = this.OXF;
      kotlin.g.b.s.checkNotNull(localObject1);
      if (!((BaseScanRequest)localObject1).OMt) {
        break;
      }
      AppMethodBeat.o(170087);
      return;
    }
    localTextView = this.Pht;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("scanTips");
      localObject1 = null;
    }
    if (((TextView)localObject1).getVisibility() == 0)
    {
      localTextView = this.Pht;
      localObject1 = localTextView;
      if (localTextView == null)
      {
        kotlin.g.b.s.bIx("scanTips");
        localObject1 = null;
      }
      if (((TextView)localObject1).getAlpha() == 1.0F) {
        i = 1;
      }
      if ((i != 0) && (paramBoolean))
      {
        AppMethodBeat.o(170087);
        return;
      }
    }
    localTextView = this.Pht;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("scanTips");
      localObject1 = null;
    }
    if ((((TextView)localObject1).getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(170087);
      return;
    }
    Cr(true);
    localObject1 = this.Pht;
    float f1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("scanTips");
      localObject1 = localObject2;
      localObject1 = (View)localObject1;
      if (!paramBoolean) {
        break label323;
      }
      f1 = 0.0F;
      label285:
      if (!paramBoolean) {
        break label328;
      }
    }
    label323:
    label328:
    for (float f2 = 1.0F;; f2 = 0.0F)
    {
      p.a((View)localObject1, f1, f2, 200L, (Animator.AnimatorListener)new c(this, paramBoolean));
      AppMethodBeat.o(170087);
      return;
      break;
      f1 = 1.0F;
      break label285;
    }
  }
  
  private static final void a(ScanSharedMaskView paramScanSharedMaskView)
  {
    AppMethodBeat.i(314781);
    kotlin.g.b.s.u(paramScanSharedMaskView, "this$0");
    paramScanSharedMaskView.gTf();
    Object localObject = paramScanSharedMaskView.Phz;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((TextureView)localObject).getBitmap())
    {
      Log.e("MicroMsg.ScanSharedMaskView", "alvinluo updateBackgroundBlurView get bitmap failed");
      AppMethodBeat.o(314781);
      return;
    }
    p.a((Bitmap)localObject, (kotlin.g.a.b)new ScanSharedMaskView.f(paramScanSharedMaskView));
    AppMethodBeat.o(314781);
  }
  
  private static final void a(ScanSharedMaskView paramScanSharedMaskView, View paramView)
  {
    AppMethodBeat.i(314773);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramScanSharedMaskView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramScanSharedMaskView, "this$0");
    paramScanSharedMaskView = paramScanSharedMaskView.PhB;
    if (paramScanSharedMaskView != null) {
      paramScanSharedMaskView.onClick(paramView);
    }
    a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314773);
  }
  
  private static final void b(ScanSharedMaskView paramScanSharedMaskView, View paramView)
  {
    AppMethodBeat.i(314777);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramScanSharedMaskView);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramScanSharedMaskView, "this$0");
    paramScanSharedMaskView = paramScanSharedMaskView.PhC;
    if (paramScanSharedMaskView != null) {
      paramScanSharedMaskView.onClick(paramView);
    }
    a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314777);
  }
  
  private final void gTf()
  {
    AppMethodBeat.i(314767);
    if (this.NKD != null)
    {
      Bitmap localBitmap = this.NKD;
      kotlin.g.b.s.checkNotNull(localBitmap);
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.NKD;
        kotlin.g.b.s.checkNotNull(localBitmap);
        localBitmap.recycle();
        this.NKD = null;
      }
    }
    AppMethodBeat.o(314767);
  }
  
  public final void Ck(boolean paramBoolean)
  {
    AppMethodBeat.i(52459);
    View localView2 = this.Phw;
    View localView1 = localView2;
    if (localView2 == null)
    {
      kotlin.g.b.s.bIx("galleryButton");
      localView1 = null;
    }
    Log.v("MicroMsg.ScanSharedMaskView", "alvinluo onPreviewReady isSwitchTab: %b, galleryButton.alpha: %s", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(localView1.getAlpha()) });
    if (!paramBoolean)
    {
      localView2 = this.Phw;
      localView1 = localView2;
      if (localView2 == null)
      {
        kotlin.g.b.s.bIx("galleryButton");
        localView1 = null;
      }
      if (localView1.getVisibility() == 0)
      {
        localView2 = this.Phw;
        localView1 = localView2;
        if (localView2 == null)
        {
          kotlin.g.b.s.bIx("galleryButton");
          localView1 = null;
        }
        if (localView1.getAlpha() < 1.0F)
        {
          localView2 = this.Phw;
          localView1 = localView2;
          if (localView2 == null)
          {
            kotlin.g.b.s.bIx("galleryButton");
            localView1 = null;
          }
          p.a(localView1, 0.0F, 1.0F, 200L, null);
        }
      }
    }
    AppMethodBeat.o(52459);
  }
  
  public final void Cr(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(314929);
    if ((paramBoolean) && (this.OXF != null))
    {
      localObject2 = this.Pht;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("scanTips");
        localObject2 = this.OXF;
        kotlin.g.b.s.checkNotNull(localObject2);
        if ((((BaseScanRequest)localObject2).OMt) || (!paramBoolean)) {
          break label84;
        }
      }
      label84:
      for (i = 0;; i = 8)
      {
        ((TextView)localObject1).setVisibility(i);
        AppMethodBeat.o(314929);
        return;
        localObject1 = localObject2;
        break;
      }
    }
    localObject1 = this.Pht;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("scanTips");
      localObject1 = localObject2;
      if (!paramBoolean) {
        break label127;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      AppMethodBeat.o(314929);
      return;
      break;
      label127:
      i = 8;
    }
  }
  
  public final void Ct(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(314948);
    Log.v("MicroMsg.ScanSharedMaskView", kotlin.g.b.s.X("alvinluo onScanSuccess needAnimation: ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      localObject3 = this.Phw;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("galleryButton");
        localObject1 = null;
      }
      p.a((View)localObject1, 1.0F, 0.0F, 200L, null);
    }
    gTA();
    gTz();
    Object localObject3 = this.Phs;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("scanTitle");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    localObject3 = this.Phu;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("scanToast");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    this.PhF = false;
    this.PhG = false;
    localObject1 = this.OXj;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("flashSwitcher");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ScannerFlashSwitcher)localObject1).setVisibility(8);
      AppMethodBeat.o(314948);
      return;
    }
  }
  
  public final void Cu(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(170086);
    Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b, isTitleShowing: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.PhF) });
    if (this.PhG != paramBoolean)
    {
      this.PhG = paramBoolean;
      if (!this.PhF) {
        if (paramBoolean) {
          break label76;
        }
      }
    }
    label76:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      Cw(paramBoolean);
      AppMethodBeat.o(170086);
      return;
    }
  }
  
  public final void Cv(boolean paramBoolean)
  {
    AppMethodBeat.i(52460);
    Log.v("MicroMsg.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(getAlpha()) });
    float f = getAlpha();
    if ((paramBoolean) && (f < 1.0F))
    {
      p.a((View)this, f, 1.0F, 200L, null);
      AppMethodBeat.o(52460);
      return;
    }
    if ((!paramBoolean) && (f > 0.0F)) {
      p.a((View)this, f, 0.0F, 200L, null);
    }
    AppMethodBeat.o(52460);
  }
  
  public final void aiB(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(314925);
    if (this.OXx)
    {
      Cs(true);
      localObject2 = this.Pht;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("scanTips");
        localObject1 = null;
      }
      ((TextView)localObject1).setText((CharSequence)this.OMD);
      AppMethodBeat.o(314925);
      return;
    }
    if ((t.aiH(paramInt)) || (t.aiI(paramInt)))
    {
      localObject1 = this.Pht;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("scanTips");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((TextView)localObject1).setText(l.i.scan_no_network_tips);
        Cs(false);
        AppMethodBeat.o(314925);
        return;
      }
    }
    if (t.aiG(paramInt))
    {
      localObject2 = this.PbH;
      if ((localObject2 != null) && (((com.tencent.mm.plugin.scanner.model.h)localObject2).gQQ() == true))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label183;
        }
        localObject2 = this.Pht;
        if (localObject2 != null) {
          break label178;
        }
        kotlin.g.b.s.bIx("scanTips");
      }
      for (;;)
      {
        ((TextView)localObject1).setText(l.i.scan_no_network_tips);
        AppMethodBeat.o(314925);
        return;
        paramInt = 0;
        break;
        label178:
        localObject1 = localObject2;
      }
    }
    label183:
    Cs(true);
    AppMethodBeat.o(314925);
  }
  
  public final void eqb()
  {
    AppMethodBeat.i(314917);
    if ((com.tencent.mm.kernel.h.aZW().bFQ() == 6) || (com.tencent.mm.kernel.h.aZW().bFQ() == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.OXx = bool;
      AppMethodBeat.o(314917);
      return;
    }
  }
  
  public final void f(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    float f2 = 1.0F;
    Object localObject1 = null;
    AppMethodBeat.i(314911);
    if (this.NKD != null)
    {
      localObject2 = this.NKD;
      kotlin.g.b.s.checkNotNull(localObject2);
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      paramAnimatorListenerAdapter = this.Phx;
      if (paramAnimatorListenerAdapter == null)
      {
        kotlin.g.b.s.bIx("blurMaskView");
        paramAnimatorListenerAdapter = localObject1;
      }
      for (;;)
      {
        paramAnimatorListenerAdapter.setVisibility(8);
        AppMethodBeat.o(314911);
        return;
      }
    }
    Object localObject2 = this.Phx;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("blurMaskView");
      localObject1 = null;
    }
    localObject1.setVisibility(0);
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label205;
      }
    }
    for (;;)
    {
      localObject2 = this.Phx;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("blurMaskView");
        localObject1 = null;
      }
      localObject1.setAlpha(f1);
      localObject2 = this.Phx;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("blurMaskView");
        localObject1 = null;
      }
      p.a((View)localObject1, f1, f2, 150L, (Animator.AnimatorListener)new ScanSharedMaskView.b(paramBoolean, this, paramAnimatorListenerAdapter));
      AppMethodBeat.o(314911);
      return;
      f1 = 1.0F;
      break;
      label205:
      f2 = 0.0F;
    }
  }
  
  public final void gTA()
  {
    AppMethodBeat.i(314936);
    o localo = this.PhE;
    if (localo != null) {
      localo.cancel();
    }
    AppMethodBeat.o(314936);
  }
  
  public final void gTz()
  {
    AppMethodBeat.i(314933);
    o localo = this.PhD;
    if (localo != null) {
      localo.cancel();
    }
    AppMethodBeat.o(314933);
  }
  
  public final ScannerFlashSwitcher getFlashSwitcherView()
  {
    AppMethodBeat.i(52455);
    ScannerFlashSwitcher localScannerFlashSwitcher = this.OXj;
    if (localScannerFlashSwitcher == null)
    {
      kotlin.g.b.s.bIx("flashSwitcher");
      AppMethodBeat.o(52455);
      return null;
    }
    AppMethodBeat.o(52455);
    return localScannerFlashSwitcher;
  }
  
  public final View getGalleryButton()
  {
    AppMethodBeat.i(52458);
    View localView = this.Phw;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("galleryButton");
      AppMethodBeat.o(52458);
      return null;
    }
    AppMethodBeat.o(52458);
    return localView;
  }
  
  public final TextView getScanTipsView()
  {
    AppMethodBeat.i(52454);
    TextView localTextView = this.Pht;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("scanTips");
      AppMethodBeat.o(52454);
      return null;
    }
    AppMethodBeat.o(52454);
    return localTextView;
  }
  
  public final TextView getScanTitleView()
  {
    AppMethodBeat.i(52452);
    TextView localTextView = this.Phs;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("scanTitle");
      AppMethodBeat.o(52452);
      return null;
    }
    AppMethodBeat.o(52452);
    return localTextView;
  }
  
  public final void setAnimateBackgroundView(boolean paramBoolean)
  {
    AppMethodBeat.i(314902);
    this.PhA = paramBoolean;
    if ((!this.PhA) || (this.Phz == null))
    {
      Log.e("MicroMsg.ScanSharedMaskView", "updateBackgroundBlurView not need show blurMaskView");
      ImageView localImageView2 = this.Phx;
      ImageView localImageView1 = localImageView2;
      if (localImageView2 == null)
      {
        kotlin.g.b.s.bIx("blurMaskView");
        localImageView1 = null;
      }
      localImageView1.setVisibility(8);
      gTf();
      AppMethodBeat.o(314902);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new ScanSharedMaskView..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(314902);
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    this.PhH = paramInt;
  }
  
  public final void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(170085);
    Log.d("MicroMsg.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.PhG = paramBoolean;
    AppMethodBeat.o(170085);
  }
  
  public final void setOnFlashSwitcherClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52457);
    kotlin.g.b.s.u(paramOnClickListener, "onClickListener");
    this.PhC = paramOnClickListener;
    AppMethodBeat.o(52457);
  }
  
  public final void setOnGalleryClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(52456);
    kotlin.g.b.s.u(paramOnClickListener, "onClickListener");
    this.PhB = paramOnClickListener;
    View localView = this.Phw;
    paramOnClickListener = localView;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("galleryButton");
      paramOnClickListener = null;
    }
    paramOnClickListener.setOnClickListener(this.PhB);
    AppMethodBeat.o(52456);
  }
  
  public final void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.OXF = paramBaseScanRequest;
  }
  
  public final void setScanTips(String paramString)
  {
    AppMethodBeat.i(52453);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      this.OMD = ((String)localObject);
      TextView localTextView = this.Pht;
      localObject = localTextView;
      if (localTextView == null)
      {
        kotlin.g.b.s.bIx("scanTips");
        localObject = null;
      }
      ((TextView)localObject).setText((CharSequence)paramString);
      AppMethodBeat.o(52453);
      return;
    }
  }
  
  public final void setScanTitle(String paramString)
  {
    AppMethodBeat.i(52451);
    TextView localTextView2 = this.Phs;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      kotlin.g.b.s.bIx("scanTitle");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(52451);
  }
  
  public final void setScanToast(String paramString)
  {
    AppMethodBeat.i(314866);
    TextView localTextView2 = this.Phu;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      kotlin.g.b.s.bIx("scanToast");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(314866);
  }
  
  public final void setShowTitle(boolean paramBoolean)
  {
    this.PhI = paramBoolean;
  }
  
  public final void setShowToast(boolean paramBoolean)
  {
    this.PhJ = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$animateShowScanTips$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(ScanSharedMaskView paramScanSharedMaskView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(170076);
      super.onAnimationCancel(paramAnimator);
      ScanSharedMaskView.b(this.PhK, paramBoolean);
      AppMethodBeat.o(170076);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170075);
      super.onAnimationEnd(paramAnimator);
      ScanSharedMaskView.b(this.PhK, paramBoolean);
      AppMethodBeat.o(170075);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startTitleAnimationTask$1", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements o.b
  {
    public d(ScanSharedMaskView paramScanSharedMaskView) {}
    
    public final void gTB()
    {
      AppMethodBeat.i(314779);
      TextView localTextView2 = ScanSharedMaskView.d(this.PhK);
      TextView localTextView1 = localTextView2;
      if (localTextView2 == null)
      {
        kotlin.g.b.s.bIx("scanTitle");
        localTextView1 = null;
      }
      localTextView1.setShadowLayer(10.0F, 0.0F, 0.0F, this.PhK.getResources().getColor(l.c.BW_0_Alpha_0_2));
      AppMethodBeat.o(314779);
    }
    
    public final void gTC()
    {
      AppMethodBeat.i(314785);
      ScanSharedMaskView.a(this.PhK, true);
      AppMethodBeat.o(314785);
    }
    
    public final void gTD()
    {
      AppMethodBeat.i(314790);
      ScanSharedMaskView.a(this.PhK, false);
      Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onShowTaskEnd isFlashShow: %b, showToast: %b", new Object[] { Boolean.valueOf(ScanSharedMaskView.e(this.PhK)), Boolean.valueOf(ScanSharedMaskView.f(this.PhK)) });
      if (ScanSharedMaskView.e(this.PhK))
      {
        AppMethodBeat.o(314790);
        return;
      }
      if (ScanSharedMaskView.f(this.PhK))
      {
        ScanSharedMaskView.g(this.PhK);
        ScanSharedMaskView.h(this.PhK);
        AppMethodBeat.o(314790);
        return;
      }
      ScanSharedMaskView.i(this.PhK);
      AppMethodBeat.o(314790);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView$startToastAnimationTask$1", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements o.b
  {
    e(ScanSharedMaskView paramScanSharedMaskView) {}
    
    public final void gTB() {}
    
    public final void gTC() {}
    
    public final void gTD()
    {
      AppMethodBeat.i(314788);
      if (ScanSharedMaskView.e(this.PhK))
      {
        AppMethodBeat.o(314788);
        return;
      }
      ScanSharedMaskView.i(this.PhK);
      AppMethodBeat.o(314788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView
 * JD-Core Version:    0.7.0.1
 */