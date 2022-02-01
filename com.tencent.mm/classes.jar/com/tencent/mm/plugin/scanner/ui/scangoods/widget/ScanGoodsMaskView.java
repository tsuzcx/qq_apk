package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.model.w.f;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vending.g.d.b;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateShowPreviewImage", "", "animationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "customMaskView", "customSuccessView", "customTipsContainer", "Landroid/widget/LinearLayout;", "customTipsImage", "customTipsImageContainer", "customTipsWording", "Landroid/widget/TextView;", "enablePlaySound", "enableVibrate", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "pendingTasks", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "previewBitmap", "previewImage", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "resourceLoadRequestId", "", "scanTipsImageAnimation", "Landroid/support/animation/SpringAnimation;", "scanTipsImageAnimationTimer", "Ljava/util/Timer;", "scanTipsImageAnimationTimerTask", "Ljava/util/TimerTask;", "showCustomView", "showPreviewImage", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successDecorationView", "successDecorationViewSize", "successMarkView", "successMarkViewSize", "vibrator", "Landroid/os/Vibrator;", "viewHeight", "viewWidth", "addAnimationScanDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "animateCustomSuccessView", "center", "Landroid/graphics/PointF;", "animateHideBlurView", "animationEndCallback", "Lkotlin/Function0;", "animateScanDots", "start", "attachBackgroundView", "attachFlashSwitcherView", "flashSwitcher", "bitmap", "async", "cancelScanTipsImageAnimation", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "doUpdatePreview", "getBackgroundTransY", "", "getMarkViewHeight", "getMarkViewTransY", "getPreviewImageSize", "getRealPosition", "centerX", "centerY", "getRealPositionForImage", "init", "initScanTipsImageAnimation", "request", "isFromCapture", "isFromGallery", "onDialogDismissAnimationEnd", "onDialogShowAnimationEnd", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNetworkChange", "state", "onPreviewReady", "isSwitchTab", "onScanSuccess", "data", "", "scanResultAnimationListener", "onSetCustomBackgroundSuccess", "onShowCustomViewFailed", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleBlurBitmap", "release", "runPendingTasks", "setBackgroundTransY", "translationY", "setCustomBackgroundBitmap", "setCustomTipsWording", "setMarkViewTransY", "setScanRequest", "showCustomBackground", "imagePath", "", "showGalleryButton", "show", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "updateBlurBitmap", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updatePreviewImageAlpha", "updateSuccessViewVisibility", "updateViewByNetwork", "vibrate", "Companion", "plugin-scan_release"})
public final class ScanGoodsMaskView
  extends BaseScanMaskView<ScanGoodsRequest>
  implements com.tencent.mm.plugin.scanner.box.a, com.tencent.mm.plugin.scanner.box.d
{
  public static final ScanGoodsMaskView.a xix;
  public boolean BZo;
  public boolean ByW;
  private int fMt;
  private int fMu;
  private p fua;
  private View gGk;
  private Vibrator njY;
  private Bitmap wtb;
  public ScanAnimationDotsView xhV;
  private View xhW;
  private ImageView xhX;
  private ImageView xhY;
  private ImageView xhZ;
  private ImageView xia;
  private View xib;
  private boolean xic;
  private ImageView xid;
  private ImageView xie;
  private LinearLayout xif;
  private LinearLayout xig;
  private ImageView xih;
  private TextView xii;
  private ArrayList<Runnable> xij;
  private long xik;
  private int xil;
  private int xim;
  private boolean xin;
  private Bitmap xio;
  private c xip;
  private LinearInterpolator xiq;
  private DecelerateInterpolator xir;
  private boolean xis;
  private boolean xit;
  private TimerTask xiu;
  private Timer xiv;
  private android.support.a.d xiw;
  
  static
  {
    AppMethodBeat.i(52328);
    xix = new ScanGoodsMaskView.a((byte)0);
    AppMethodBeat.o(52328);
  }
  
  public ScanGoodsMaskView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(52325);
    AppMethodBeat.o(52325);
  }
  
  public ScanGoodsMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52326);
    AppMethodBeat.o(52326);
  }
  
  public ScanGoodsMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52327);
    this.xij = new ArrayList();
    this.xil = getResources().getDimensionPixelSize(2131166771);
    this.xim = getResources().getDimensionPixelSize(2131167048);
    this.xiq = new LinearInterpolator();
    this.xir = new DecelerateInterpolator();
    this.xis = true;
    this.xit = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494567, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131304301);
    k.g(localObject, "view.findViewById(R.id.scan_animation_dots_view)");
    this.xhV = ((ScanAnimationDotsView)localObject);
    localObject = paramAttributeSet.findViewById(2131304331);
    k.g(localObject, "view.findViewById(R.id.scan_success_dot_view)");
    this.xhW = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131303390);
    k.g(localObject, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
    this.xhY = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131303389);
    k.g(localObject, "view.findViewById(R.id.preview_blur_view)");
    this.xia = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131302169);
    k.g(localObject, "view.findViewById(R.id.mask_view)");
    this.gGk = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131303394);
    k.g(localObject, "view.findViewById(R.id.preview_image)");
    this.xhZ = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307306);
    k.g(localObject, "view.findViewById(R.id.custom_mask_view)");
    this.xid = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307311);
    k.g(localObject, "view.findViewById(R.id.custom_success_view)");
    this.xie = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131308017);
    k.g(localObject, "view.findViewById(R.id.success_decoration_view)");
    this.xhX = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307307);
    k.g(localObject, "view.findViewById(R.id.custom_scan_tips_container)");
    this.xif = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(2131307309);
    k.g(localObject, "view.findViewById(R.id.c…can_tips_image_container)");
    this.xig = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(2131307308);
    k.g(localObject, "view.findViewById(R.id.custom_scan_tips_image)");
    this.xih = ((ImageView)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131307310);
    k.g(paramAttributeSet, "view.findViewById(R.id.custom_scan_tips_wording)");
    this.xii = ((TextView)paramAttributeSet);
    if (this.njY == null)
    {
      paramAttributeSet = paramContext.getSystemService("vibrator");
      if (paramAttributeSet != null) {
        this.njY = ((Vibrator)paramAttributeSet);
      }
    }
    localObject = this.xif;
    if (localObject == null) {
      k.aVY("customTipsContainer");
    }
    paramAttributeSet = this.xif;
    if (paramAttributeSet == null) {
      k.aVY("customTipsContainer");
    }
    paramAttributeSet = paramAttributeSet.getLayoutParams();
    if (paramAttributeSet != null) {
      if ((paramAttributeSet instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(paramContext, 154) + getMBottomExtraHeight());
      }
    }
    for (paramContext = paramAttributeSet;; paramContext = null)
    {
      ((LinearLayout)localObject).setLayoutParams(paramContext);
      AppMethodBeat.o(52327);
      return;
    }
  }
  
  private final void aJ(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(210229);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ac.i("MicroMsg.ScanGoodsMaskView", "alvinluo setPreviewBitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      ((d.g.a.a)new g(this, paramBitmap)).invoke();
    }
    AppMethodBeat.o(210229);
  }
  
  private final void dAO()
  {
    int i = 0;
    AppMethodBeat.i(199649);
    if (getRequest() != null)
    {
      localView = getMGalleryButton();
      if (localView != null)
      {
        BaseScanRequest localBaseScanRequest = getRequest();
        if (localBaseScanRequest == null) {
          k.fOy();
        }
        if (!localBaseScanRequest.wWa) {}
        for (;;)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(199649);
          return;
          i = 8;
        }
      }
      AppMethodBeat.o(199649);
      return;
    }
    View localView = getMGalleryButton();
    if (localView != null)
    {
      localView.setVisibility(0);
      AppMethodBeat.o(199649);
      return;
    }
    AppMethodBeat.o(199649);
  }
  
  private final void dAQ()
  {
    AppMethodBeat.i(52317);
    if (getCurrentNetworkAvailable())
    {
      localObject = getScanTips();
      if (localObject != null) {
        ((TextView)localObject).setText(2131762823);
      }
      dAO();
      AppMethodBeat.o(52317);
      return;
    }
    Object localObject = getScanTips();
    if (localObject != null) {
      ((TextView)localObject).setText(2131762845);
    }
    localObject = getMGalleryButton();
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(52317);
      return;
    }
    AppMethodBeat.o(52317);
  }
  
  private final void dAR()
  {
    AppMethodBeat.i(52324);
    if (this.wtb != null)
    {
      Bitmap localBitmap = this.wtb;
      if (localBitmap == null) {
        k.fOy();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.wtb;
        if (localBitmap == null) {
          k.fOy();
        }
        localBitmap.recycle();
        this.wtb = null;
      }
    }
    AppMethodBeat.o(52324);
  }
  
  private final void dAS()
  {
    AppMethodBeat.i(199656);
    try
    {
      Object localObject = this.xiw;
      if (localObject != null) {
        ((android.support.a.d)localObject).cancel();
      }
      localObject = this.xiu;
      if (localObject != null) {
        ((TimerTask)localObject).cancel();
      }
      localObject = this.xiv;
      if (localObject != null)
      {
        ((Timer)localObject).cancel();
        AppMethodBeat.o(199656);
        return;
      }
      AppMethodBeat.o(199656);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(199656);
    }
  }
  
  private final void dAT()
  {
    AppMethodBeat.i(199657);
    ac.e("MicroMsg.ScanGoodsMaskView", "alvinluo onShowCustomViewFailed");
    this.xic = false;
    Object localObject = this.xig;
    if (localObject == null) {
      k.aVY("customTipsImageContainer");
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.xid;
    if (localObject == null) {
      k.aVY("customMaskView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.xid;
    if (localObject == null) {
      k.aVY("customMaskView");
    }
    ((ImageView)localObject).setImageBitmap(null);
    if ((getRequest() instanceof ScanGoodsRequest))
    {
      localObject = getRequest();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
        AppMethodBeat.o(199657);
        throw ((Throwable)localObject);
      }
      z.d((ScanGoodsRequest)localObject);
    }
    AppMethodBeat.o(199657);
  }
  
  private final Point getPreviewImageSize()
  {
    AppMethodBeat.i(199650);
    Object localObject;
    if (this.xio != null)
    {
      localObject = this.xio;
      if (localObject == null) {
        k.fOy();
      }
      if (!((Bitmap)localObject).isRecycled()) {}
    }
    else
    {
      localObject = new Point(0, 0);
      AppMethodBeat.o(199650);
      return localObject;
    }
    float f;
    try
    {
      localObject = this.xio;
      if (localObject == null) {
        k.fOy();
      }
      f = ((Bitmap)localObject).getWidth();
      localObject = this.xio;
      if (localObject == null) {
        k.fOy();
      }
      f = f * 1.0F / ((Bitmap)localObject).getHeight();
      if (f < getMeasuredWidth() * 1.0F / getMeasuredHeight())
      {
        i = getMeasuredHeight();
        localObject = new Point((int)(f * i), i);
        AppMethodBeat.o(199650);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.ScanGoodsMaskView", (Throwable)localException, "alvinluo getPreviewImageSize exception", new Object[0]);
      localPoint = new Point(0, 0);
      AppMethodBeat.o(199650);
      return localPoint;
    }
    int i = getMeasuredWidth();
    Point localPoint = new Point(i, (int)(i / f));
    AppMethodBeat.o(199650);
    return localPoint;
  }
  
  private final void qc(boolean paramBoolean)
  {
    AppMethodBeat.i(52302);
    ScanAnimationDotsView localScanAnimationDotsView = this.xhV;
    if (localScanAnimationDotsView == null) {
      k.aVY("animationDotsView");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localScanAnimationDotsView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localScanAnimationDotsView = this.xhV;
      if (localScanAnimationDotsView == null) {
        k.aVY("animationDotsView");
      }
      localScanAnimationDotsView.startAnimation();
      AppMethodBeat.o(52302);
      return;
    }
    localScanAnimationDotsView = this.xhV;
    if (localScanAnimationDotsView == null) {
      k.aVY("animationDotsView");
    }
    localScanAnimationDotsView.stopAnimation();
    AppMethodBeat.o(52302);
  }
  
  private final void setCustomBackgroundBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(199655);
    paramBitmap = (Runnable)new q(this, paramBitmap);
    if ((this.fMt != 0) && (this.fMu != 0))
    {
      paramBitmap.run();
      AppMethodBeat.o(199655);
      return;
    }
    this.xij.add(paramBitmap);
    AppMethodBeat.o(199655);
  }
  
  private final void setCustomTipsWording(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(199654);
    Object localObject = (CharSequence)paramScanGoodsRequest.wWg;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.xii;
      if (localObject == null) {
        k.aVY("customTipsWording");
      }
      ((TextView)localObject).setText((CharSequence)paramScanGoodsRequest.wWg);
      AppMethodBeat.o(199654);
      return;
    }
    paramScanGoodsRequest = this.xii;
    if (paramScanGoodsRequest == null) {
      k.aVY("customTipsWording");
    }
    localObject = getContext();
    k.g(localObject, "context");
    paramScanGoodsRequest.setText((CharSequence)((Context)localObject).getResources().getString(2131762823));
    AppMethodBeat.o(199654);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52311);
    super.a(paramAnimatorListener);
    dAS();
    a((View)this, 1.0F, 0.0F, paramAnimatorListener);
    AppMethodBeat.o(52311);
  }
  
  public final void a(Object paramObject, c paramc)
  {
    AppMethodBeat.i(52313);
    k.h(paramObject, "data");
    ac.i("MicroMsg.ScanGoodsMaskView", "alvinluo onScanSuccess");
    this.xip = paramc;
    int i;
    label132:
    float f1;
    float f2;
    float f3;
    float f4;
    if ((paramObject instanceof u))
    {
      paramObject = (u)paramObject;
      ac.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView with animation");
      qc(false);
      ac.v("MicroMsg.ScanGoodsMaskView", "updateSuccessViewVisibility showCustomView: %b", new Object[] { Boolean.valueOf(this.xic) });
      paramc = this.xie;
      if (paramc == null) {
        k.aVY("customSuccessView");
      }
      if (!this.xic) {
        break label461;
      }
      i = 0;
      paramc.setVisibility(i);
      paramc = this.xhX;
      if (paramc == null) {
        k.aVY("successDecorationView");
      }
      if (!this.xic) {
        break label468;
      }
      i = 0;
      paramc.setVisibility(i);
      dAS();
      f1 = paramObject.centerX;
      f2 = paramObject.centerY;
      if (getMScanSource() != 1) {
        break label475;
      }
      f3 = f1 * getMeasuredWidth();
      f4 = f2 * getMeasuredHeight();
      ac.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
      paramObject = new PointF(f3, f4);
      label236:
      paramc = this.xhW;
      if (paramc == null) {
        k.aVY("successMarkView");
      }
      paramc.setVisibility(0);
      paramc.setPivotX(this.xil / 2.0F);
      paramc.setPivotY(this.xil / 2.0F);
      paramc.setTranslationX(paramObject.x - this.xil / 2);
      paramc.setTranslationY(paramObject.y - this.xil / 2);
      paramc.setScaleX(0.0F);
      paramc.setScaleY(0.0F);
      if (this.xic) {
        break label585;
      }
      paramObject = this.xhW;
      if (paramObject == null) {
        k.aVY("successMarkView");
      }
      h.a(paramObject, this.xip);
    }
    for (;;)
    {
      paramObject = this.gGk;
      if (paramObject == null) {
        k.aVY("maskView");
      }
      paramObject.setAlpha(0.0F);
      paramObject.setVisibility(0);
      paramObject = this.xia;
      if (paramObject == null) {
        k.aVY("blurView");
      }
      paramObject.setVisibility(8);
      qg(false);
      if (this.xis) {
        com.tencent.e.h.JZN.aS((Runnable)new j(this));
      }
      if (this.xit) {
        postDelayed((Runnable)new k(this), 100L);
      }
      AppMethodBeat.o(52313);
      return;
      label461:
      i = 8;
      break;
      label468:
      i = 8;
      break label132;
      label475:
      paramObject = getPreviewImageSize();
      i = (getMeasuredWidth() - paramObject.x) / 2;
      int j = (getMeasuredHeight() - paramObject.y) / 2;
      ac.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPositionForImage previewImageSize: %s, left: %d, top: %d", new Object[] { paramObject, Integer.valueOf(i), Integer.valueOf(j) });
      f3 = i;
      f4 = paramObject.x;
      float f5 = j;
      paramObject = new PointF(f1 * f4 + f3, f2 * paramObject.y + f5);
      break label236;
      label585:
      ac.d("MicroMsg.ScanGoodsMaskView", "alvinluo animateCustomSuccessView");
      paramc = this.xhW;
      if (paramc == null) {
        k.aVY("successMarkView");
      }
      h.et(paramc);
      paramc = this.xhX;
      if (paramc == null) {
        k.aVY("successDecorationView");
      }
      paramc.setVisibility(0);
      paramc.setPivotX(this.xim / 2.0F);
      paramc.setPivotY(this.xim / 2.0F);
      paramc.setTranslationX(paramObject.x - this.xim / 2);
      paramc.setTranslationY(paramObject.y - this.xim / 2);
      paramc.setScaleX(0.5F);
      paramc.setScaleY(0.5F);
      paramc.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)new b(this)).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanGoodsMaskView.c(this)).start();
    }
  }
  
  public final void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(52314);
    if (paramBoolean)
    {
      p localp = this.fua;
      if (localp != null) {
        localp.dismiss();
      }
      this.fua = com.tencent.mm.ui.base.h.b(getContext(), getResources().getString(2131762846), true, paramOnCancelListener);
      AppMethodBeat.o(52314);
      return;
    }
    paramOnCancelListener = this.fua;
    if (paramOnCancelListener != null)
    {
      paramOnCancelListener.dismiss();
      AppMethodBeat.o(52314);
      return;
    }
    AppMethodBeat.o(52314);
  }
  
  public final void aK(Bitmap paramBitmap)
  {
    AppMethodBeat.i(210230);
    dAR();
    ImageView localImageView;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ac.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreview bitmap width: %d, height: %d, showPreviewImage: %b, animateShowPreviewImage: %b", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Boolean.valueOf(this.ByW), Boolean.valueOf(this.BZo) });
      this.xio = paramBitmap;
      localImageView = this.xhZ;
      if (localImageView == null) {
        k.aVY("previewImage");
      }
      localImageView.setImageBitmap(paramBitmap);
      if (!this.ByW) {
        break label188;
      }
      localImageView = this.xhZ;
      if (localImageView == null) {
        k.aVY("previewImage");
      }
      localImageView.setVisibility(0);
      if (!this.BZo) {
        break label165;
      }
      localImageView = this.xhZ;
      if (localImageView == null) {
        k.aVY("previewImage");
      }
      localImageView.setAlpha(0.0F);
    }
    for (;;)
    {
      aJ(paramBitmap);
      AppMethodBeat.o(210230);
      return;
      label165:
      localImageView = this.xhZ;
      if (localImageView == null) {
        k.aVY("previewImage");
      }
      localImageView.setAlpha(1.0F);
      continue;
      label188:
      localImageView = this.xhZ;
      if (localImageView == null) {
        k.aVY("previewImage");
      }
      localImageView.setVisibility(8);
    }
  }
  
  public final void c(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(52323);
    float f1 = Math.max(0.0F, Math.min(1.0F, paramFloat2));
    boolean bool;
    Object localObject;
    ImageView localImageView;
    if ((paramInt == 1) || (paramInt == 2)) {
      if ((f1 >= 0.5F) && (paramInt == 1))
      {
        bool = this.xin & true;
        f1 = (f1 - 0.5F) / 0.5F;
        localObject = this.xia;
        if (localObject == null) {
          k.aVY("blurView");
        }
        ((ImageView)localObject).setAlpha(this.xir.getInterpolation(f1));
        localObject = this.xhW;
        if (localObject == null) {
          k.aVY("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.xhZ;
        if (localObject == null) {
          k.aVY("previewImage");
        }
        localImageView = this.xia;
        if (localImageView == null) {
          k.aVY("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        localObject = this.gGk;
        if (localObject == null) {
          k.aVY("maskView");
        }
        ((View)localObject).setAlpha(0.5F);
        label189:
        localObject = this.xia;
        if (localObject == null) {
          k.aVY("blurView");
        }
        if (!bool) {
          break label770;
        }
      }
    }
    label770:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = this.gGk;
      if (localObject == null) {
        k.aVY("maskView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.xia;
      if (localObject == null) {
        k.aVY("blurView");
      }
      f1 = ((ImageView)localObject).getAlpha();
      localObject = this.xhW;
      if (localObject == null) {
        k.aVY("successMarkView");
      }
      float f2 = ((View)localObject).getAlpha();
      localObject = this.gGk;
      if (localObject == null) {
        k.aVY("maskView");
      }
      float f3 = ((View)localObject).getAlpha();
      localObject = this.xhZ;
      if (localObject == null) {
        k.aVY("previewImage");
      }
      ac.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, markView alpha: %s, maskView alpha: %s, previewImage alpha: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(((ImageView)localObject).getAlpha()) });
      AppMethodBeat.o(52323);
      return;
      if (paramInt == 2)
      {
        bool = this.xin & true;
        localObject = this.xia;
        if (localObject == null) {
          k.aVY("blurView");
        }
        ((ImageView)localObject).setAlpha(this.xir.getInterpolation(f1));
        localObject = this.xhW;
        if (localObject == null) {
          k.aVY("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.xhZ;
        if (localObject == null) {
          k.aVY("previewImage");
        }
        localImageView = this.xia;
        if (localImageView == null) {
          k.aVY("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        break;
      }
      localObject = this.xhW;
      if (localObject == null) {
        k.aVY("successMarkView");
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.xhZ;
      if (localObject == null) {
        k.aVY("previewImage");
      }
      ((ImageView)localObject).setAlpha(1.0F);
      bool = false;
      break;
      localObject = this.gGk;
      if (localObject == null) {
        k.aVY("maskView");
      }
      ((View)localObject).setAlpha(Math.max(0.0F, Math.min(0.5F, 1.0F - f1)));
      if (this.ByW)
      {
        if (this.BZo)
        {
          f1 = Math.max(0.0F, Math.min(1.0F, (paramFloat2 - 0.5F) / 0.5F));
          localObject = this.xhZ;
          if (localObject == null) {
            k.aVY("previewImage");
          }
          ((ImageView)localObject).setAlpha(1.0F - f1);
          localObject = this.xhZ;
          if (localObject == null) {
            k.aVY("previewImage");
          }
          ac.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY previewImage.alpha: %f, targetFactor: %f", new Object[] { Float.valueOf(((ImageView)localObject).getAlpha()), Float.valueOf(f1) });
          bool = false;
          break label189;
        }
        localObject = this.xhZ;
        if (localObject == null) {
          k.aVY("previewImage");
        }
        ((ImageView)localObject).setAlpha(1.0F);
      }
      bool = false;
      break label189;
    }
  }
  
  public final void dAP()
  {
    AppMethodBeat.i(52310);
    super.dAP();
    dAQ();
    AppMethodBeat.o(52310);
  }
  
  public final void ev(View paramView)
  {
    AppMethodBeat.i(52308);
    k.h(paramView, "flashSwitcher");
    super.ev(paramView);
    View localView = getFlashSwitcher();
    if (localView != null)
    {
      paramView = getFlashSwitcher();
      if (paramView != null)
      {
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
          if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams)paramView).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight());
          }
        }
      }
      for (;;)
      {
        localView.setLayoutParams(paramView);
        AppMethodBeat.o(52308);
        return;
        paramView = null;
      }
    }
    AppMethodBeat.o(52308);
  }
  
  public final void ew(final View paramView)
  {
    int i = 1;
    AppMethodBeat.i(52309);
    this.xib = paramView;
    ac.v("MicroMsg.ScanGoodsMaskView", "alvinluo attachBackgroundView source: %d", new Object[] { Integer.valueOf(getMScanSource()) });
    if ((paramView instanceof TextureView)) {
      if (getMScanSource() != 1) {
        break label88;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramView = (TextureView)paramView;
        com.tencent.e.h.JZN.aS((Runnable)new s(this, paramView));
      }
      AppMethodBeat.o(52309);
      return;
      label88:
      i = 0;
    }
  }
  
  public final float getBackgroundTransY()
  {
    AppMethodBeat.i(52319);
    View localView = this.xib;
    if (localView != null)
    {
      float f = localView.getTranslationY();
      AppMethodBeat.o(52319);
      return f;
    }
    AppMethodBeat.o(52319);
    return 0.0F;
  }
  
  public final float getMarkViewHeight()
  {
    AppMethodBeat.i(52322);
    float f = this.xil;
    AppMethodBeat.o(52322);
    return f;
  }
  
  public final float getMarkViewTransY()
  {
    AppMethodBeat.i(52321);
    View localView = this.xhW;
    if (localView == null) {
      k.aVY("successMarkView");
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(52321);
    return f;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199651);
    super.onMeasure(paramInt1, paramInt2);
    this.fMt = getMeasuredWidth();
    this.fMu = getMeasuredHeight();
    if ((this.fMt != 0) && (this.fMu != 0))
    {
      Iterator localIterator = ((Iterable)this.xij).iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.xij.clear();
    }
    AppMethodBeat.o(199651);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(52316);
    super.onNetworkChange(paramInt);
    dAQ();
    AppMethodBeat.o(52316);
  }
  
  public final void qb(final boolean paramBoolean)
  {
    AppMethodBeat.i(52312);
    super.qb(paramBoolean);
    dAR();
    Object localObject1 = (d.g.a.a)new i(this, paramBoolean);
    Object localObject2 = this.xia;
    if (localObject2 == null) {
      k.aVY("blurView");
    }
    if (((ImageView)localObject2).getVisibility() != 0)
    {
      localObject2 = this.xhZ;
      if (localObject2 == null) {
        k.aVY("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0)
      {
        localObject2 = this.xhY;
        if (localObject2 == null) {
          k.aVY("bottomBlurView");
        }
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label260;
        }
      }
    }
    localObject2 = this.xhZ;
    if (localObject2 == null) {
      k.aVY("previewImage");
    }
    if (((ImageView)localObject2).getAlpha() == 1.0F)
    {
      localObject2 = this.xhZ;
      if (localObject2 == null) {
        k.aVY("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject2 = this.xia;
      if (localObject2 == null) {
        k.aVY("blurView");
      }
      localObject2 = ((ImageView)localObject2).animate();
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((ViewPropertyAnimator)localObject2).alpha(0.0F);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((ViewPropertyAnimator)localObject2).setDuration(300L);
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)this.xiq);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new ScanGoodsMaskView.d((d.g.a.a)localObject1));
      if (localObject1 == null) {
        break;
      }
      ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this, paramBoolean));
      AppMethodBeat.o(52312);
      return;
    }
    AppMethodBeat.o(52312);
    return;
    label260:
    ((d.g.a.a)localObject1).invoke();
    AppMethodBeat.o(52312);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52315);
    super.release();
    Object localObject = this.xhV;
    if (localObject == null) {
      k.aVY("animationDotsView");
    }
    ((ScanAnimationDotsView)localObject).release();
    localObject = w.wZI;
    long l = this.xik;
    localObject = (ScanGoodsRequest)w.wZF.get(Long.valueOf(l));
    w.wZF.remove(Long.valueOf(l));
    w.fWm.remove(Long.valueOf(l));
    if (localObject != null)
    {
      ac.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestId: %s", new Object[] { Long.valueOf(l) });
      String str = w.a((ScanGoodsRequest)localObject);
      ((Map)w.wZH).put(str, Boolean.TRUE);
      com.tencent.e.h.JZN.b((Runnable)new w.f(str, (ScanGoodsRequest)localObject), 10000L, "ScanResourceTag");
    }
    dAS();
    AppMethodBeat.o(52315);
  }
  
  public final void setBackgroundTransY(float paramFloat)
  {
    AppMethodBeat.i(52318);
    Object localObject = this.xib;
    if (localObject != null) {
      ((View)localObject).setTranslationY(paramFloat);
    }
    localObject = this.xia;
    if (localObject == null) {
      k.aVY("blurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.xhZ;
    if (localObject == null) {
      k.aVY("previewImage");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.xhY;
    if (localObject == null) {
      k.aVY("bottomBlurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    AppMethodBeat.o(52318);
  }
  
  public final void setMarkViewTransY(float paramFloat)
  {
    AppMethodBeat.i(52320);
    View localView = this.xhW;
    if (localView == null) {
      k.aVY("successMarkView");
    }
    localView.setTranslationY(paramFloat);
    AppMethodBeat.o(52320);
  }
  
  public final void setScanRequest(final ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(199652);
    super.setScanRequest((BaseScanRequest)paramScanGoodsRequest);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(199652);
      return;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      ac.w("MicroMsg.ScanGoodsMaskView", "alvinluo setScanRequest request is not valid and ignore");
      z.c(paramScanGoodsRequest);
      AppMethodBeat.o(199652);
      return;
    }
    Object localObject = this.xif;
    if (localObject == null) {
      k.aVY("customTipsContainer");
    }
    ((LinearLayout)localObject).setVisibility(0);
    setCustomTipsWording(paramScanGoodsRequest);
    localObject = w.wZI;
    this.xik = w.a(paramScanGoodsRequest, (com.tencent.mm.plugin.scanner.model.v)new r(this, paramScanGoodsRequest));
    if (paramScanGoodsRequest.wWi)
    {
      paramScanGoodsRequest.wWi = false;
      this.xiv = new Timer();
      this.xiu = ((TimerTask)new h(this));
      paramScanGoodsRequest = this.xiv;
      if (paramScanGoodsRequest != null)
      {
        paramScanGoodsRequest.schedule(this.xiu, 15000L);
        AppMethodBeat.o(199652);
        return;
      }
    }
    AppMethodBeat.o(199652);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(199637);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = ScanGoodsMaskView.a(this.xiy).animate();
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.alpha(0.0F);
        if (paramAnimator != null)
        {
          paramAnimator = paramAnimator.setDuration(200L);
          if (paramAnimator != null)
          {
            paramAnimator = paramAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
            if (paramAnimator != null)
            {
              paramAnimator = paramAnimator.setListener((Animator.AnimatorListener)new a(this));
              if (paramAnimator != null)
              {
                paramAnimator = paramAnimator.setUpdateListener(null);
                if (paramAnimator != null)
                {
                  paramAnimator.start();
                  AppMethodBeat.o(199637);
                  return;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(199637);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(199638);
      super.onAnimationStart(paramAnimator);
      ScanGoodsMaskView.b(this.xiy);
      AppMethodBeat.o(199638);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(199636);
        super.onAnimationEnd(paramAnimator);
        paramAnimator = ScanGoodsMaskView.b(this.xiz.xiy);
        if (paramAnimator != null)
        {
          paramAnimator.dAf();
          AppMethodBeat.o(199636);
          return;
        }
        AppMethodBeat.o(199636);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52290);
      if (paramValueAnimator == null)
      {
        AppMethodBeat.o(52290);
        return;
      }
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52290);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ScanGoodsMaskView.d(this.xiy).setAlpha(0.5F - f * 0.5F);
      if (paramBoolean)
      {
        ScanGoodsMaskView.e(this.xiy).setAlpha(1.0F - f);
        ScanGoodsMaskView.f(this.xiy).setAlpha(1.0F - f);
      }
      if (ScanGoodsMaskView.g(this.xiy)) {
        ScanGoodsMaskView.c(this.xiy).setAlpha(f);
      }
      ac.v("MicroMsg.ScanGoodsMaskView", "alvinluo animateBlurView alpha: %s, factor: %f", new Object[] { Float.valueOf(ScanGoodsMaskView.d(this.xiy).getAlpha()), Float.valueOf(f) });
      AppMethodBeat.o(52290);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(ScanGoodsMaskView.g paramg, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$initScanTipsImageAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class h
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(199641);
      com.tencent.e.h.JZN.aQ((Runnable)new a(this));
      AppMethodBeat.o(199641);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanGoodsMaskView.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(199640);
        if ((ScanGoodsMaskView.g(this.xiH.xiy)) && (ScanGoodsMaskView.y(this.xiH.xiy).getVisibility() == 0)) {
          ScanGoodsMaskView.a(this.xiH.xiy, h.eu((View)ScanGoodsMaskView.y(this.xiH.xiy)));
        }
        AppMethodBeat.o(199640);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52296);
      bc.aF(this.xiy.getContext(), 2131762120);
      AppMethodBeat.o(52296);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52297);
      ScanGoodsMaskView.p(this.xiy);
      AppMethodBeat.o(52297);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/graphics/Bitmap;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class l<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    l(ScanGoodsRequest paramScanGoodsRequest) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "invoke", "(Ljava/lang/Boolean;)Z"})
  static final class n
    extends d.g.b.l
    implements b<Boolean, Boolean>
  {
    n(ScanGoodsMaskView paramScanGoodsMaskView, ScanGoodsRequest paramScanGoodsRequest)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Boolean;)V"})
  static final class p<T>
    implements d.b<Boolean>
  {
    p(ScanGoodsMaskView paramScanGoodsMaskView) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(199647);
      com.tencent.mm.plugin.scanner.ui.h localh = com.tencent.mm.plugin.scanner.ui.h.xgk;
      if (com.tencent.mm.plugin.scanner.ui.h.a(paramBitmap, ScanGoodsMaskView.r(this.xiy), ScanGoodsMaskView.s(this.xiy), ScanGoodsMaskView.t(this.xiy)))
      {
        ScanGoodsMaskView.r(this.xiy).setVisibility(0);
        ScanGoodsMaskView.u(this.xiy);
        AppMethodBeat.o(199647);
        return;
      }
      ScanGoodsMaskView.v(this.xiy);
      AppMethodBeat.o(199647);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$setScanRequest$1", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "onLoadResult", "", "errCode", "", "errMsg", "", "plugin-scan_release"})
  public static final class r
    implements com.tencent.mm.plugin.scanner.model.v
  {
    r(ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void bQ(int paramInt, String paramString)
    {
      AppMethodBeat.i(199648);
      k.h(paramString, "errMsg");
      ac.i("MicroMsg.ScanGoodsMaskView", "alvinluo loadResource onLoadResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
      if (paramInt == 0)
      {
        paramString = this.xiy;
        String str = paramScanGoodsRequest.wWd;
        k.g(str, "request.decorationImagePath");
        ScanGoodsMaskView.a(paramString, str);
      }
      AppMethodBeat.o(199648);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(ScanGoodsMaskView paramScanGoodsMaskView, TextureView paramTextureView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52301);
      ScanGoodsMaskView.q(this.xiy);
      long l = System.currentTimeMillis();
      final Bitmap localBitmap = paramView.getBitmap();
      ac.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.e.h.JZN.aQ((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52300);
          ScanGoodsMaskView.c(this.xiL.xiy, r.eBv());
          ScanGoodsMaskView.z(this.xiL.xiy);
          ScanGoodsMaskView.a(this.xiL.xiy, localBitmap);
          AppMethodBeat.o(52300);
        }
      });
      AppMethodBeat.o(52301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView
 * JD-Core Version:    0.7.0.1
 */