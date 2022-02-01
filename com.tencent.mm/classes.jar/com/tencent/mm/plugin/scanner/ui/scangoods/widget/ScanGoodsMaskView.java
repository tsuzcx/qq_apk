package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
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
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.model.z.f;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.b.q;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateShowPreviewImage", "", "animationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "customMaskView", "customSuccessView", "customTipsContainer", "Landroid/widget/LinearLayout;", "customTipsImage", "customTipsImageContainer", "customTipsWording", "Landroid/widget/TextView;", "enablePlaySound", "enableVibrate", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "pendingTasks", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "previewBitmap", "previewImage", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "resourceLoadRequestId", "", "scanTipsImageAnimation", "Landroid/support/animation/SpringAnimation;", "scanTipsImageAnimationTimer", "Ljava/util/Timer;", "scanTipsImageAnimationTimerTask", "Ljava/util/TimerTask;", "showCustomView", "showPreviewImage", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successDecorationView", "successDecorationViewSize", "successMarkView", "successMarkViewSize", "vibrator", "Landroid/os/Vibrator;", "viewHeight", "viewWidth", "addAnimationScanDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "animateCustomSuccessView", "center", "Landroid/graphics/PointF;", "animateHideBlurView", "animationEndCallback", "Lkotlin/Function0;", "animateScanDots", "start", "attachBackgroundView", "attachFlashSwitcherView", "flashSwitcher", "bitmap", "async", "cancelScanTipsImageAnimation", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "doUpdatePreview", "getBackgroundTransY", "", "getMarkViewHeight", "getMarkViewTransY", "getPreviewImageSize", "getRealPosition", "centerX", "centerY", "getRealPositionForImage", "init", "initScanTipsImageAnimation", "request", "isFromCapture", "isFromGallery", "onDialogDismissAnimationEnd", "onDialogShowAnimationEnd", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNetworkChange", "state", "onPreviewReady", "isSwitchTab", "onScanSuccess", "data", "", "scanResultAnimationListener", "onSetCustomBackgroundSuccess", "onShowCustomViewFailed", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleBlurBitmap", "release", "runPendingTasks", "setBackgroundTransY", "translationY", "setCustomBackgroundBitmap", "setCustomTipsWording", "setMarkViewTransY", "setScanRequest", "showCustomBackground", "imagePath", "", "showGalleryButton", "show", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "updateBlurBitmap", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updatePreviewImageAlpha", "updateSuccessViewVisibility", "updateViewByNetwork", "vibrate", "Companion", "plugin-scan_release"})
public final class ScanGoodsMaskView
  extends BaseScanMaskView<ScanGoodsRequest>
  implements com.tencent.mm.plugin.scanner.box.a, com.tencent.mm.plugin.scanner.box.d
{
  public static final ScanGoodsMaskView.a yMA;
  private com.tencent.mm.ui.base.p fPj;
  private int gil;
  private int gim;
  private View hcH;
  private Vibrator nQa;
  private Bitmap xQW;
  public ScanAnimationDotsView yLW;
  private View yLX;
  private ImageView yLY;
  private ImageView yLZ;
  private ImageView yMa;
  private ImageView yMb;
  private View yMc;
  private boolean yMd;
  private ImageView yMe;
  private ImageView yMf;
  private LinearLayout yMg;
  private LinearLayout yMh;
  private ImageView yMi;
  private TextView yMj;
  private ArrayList<Runnable> yMk;
  private long yMl;
  private int yMm;
  private int yMn;
  private boolean yMo;
  public boolean yMp;
  public boolean yMq;
  private Bitmap yMr;
  private com.tencent.mm.plugin.scanner.view.c yMs;
  private LinearInterpolator yMt;
  private DecelerateInterpolator yMu;
  private boolean yMv;
  private boolean yMw;
  private TimerTask yMx;
  private Timer yMy;
  private android.support.a.d yMz;
  
  static
  {
    AppMethodBeat.i(52328);
    yMA = new ScanGoodsMaskView.a((byte)0);
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
    this.yMk = new ArrayList();
    this.yMm = getResources().getDimensionPixelSize(2131166771);
    this.yMn = getResources().getDimensionPixelSize(2131167048);
    this.yMt = new LinearInterpolator();
    this.yMu = new DecelerateInterpolator();
    this.yMv = true;
    this.yMw = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494567, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131304301);
    d.g.b.p.g(localObject, "view.findViewById(R.id.scan_animation_dots_view)");
    this.yLW = ((ScanAnimationDotsView)localObject);
    localObject = paramAttributeSet.findViewById(2131304331);
    d.g.b.p.g(localObject, "view.findViewById(R.id.scan_success_dot_view)");
    this.yLX = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131303390);
    d.g.b.p.g(localObject, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
    this.yLZ = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131303389);
    d.g.b.p.g(localObject, "view.findViewById(R.id.preview_blur_view)");
    this.yMb = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131302169);
    d.g.b.p.g(localObject, "view.findViewById(R.id.mask_view)");
    this.hcH = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131303394);
    d.g.b.p.g(localObject, "view.findViewById(R.id.preview_image)");
    this.yMa = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307306);
    d.g.b.p.g(localObject, "view.findViewById(R.id.custom_mask_view)");
    this.yMe = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307311);
    d.g.b.p.g(localObject, "view.findViewById(R.id.custom_success_view)");
    this.yMf = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131308017);
    d.g.b.p.g(localObject, "view.findViewById(R.id.success_decoration_view)");
    this.yLY = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307307);
    d.g.b.p.g(localObject, "view.findViewById(R.id.custom_scan_tips_container)");
    this.yMg = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(2131307309);
    d.g.b.p.g(localObject, "view.findViewById(R.id.c…can_tips_image_container)");
    this.yMh = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(2131307308);
    d.g.b.p.g(localObject, "view.findViewById(R.id.custom_scan_tips_image)");
    this.yMi = ((ImageView)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131307310);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.custom_scan_tips_wording)");
    this.yMj = ((TextView)paramAttributeSet);
    if (this.nQa == null)
    {
      paramAttributeSet = paramContext.getSystemService("vibrator");
      if (paramAttributeSet != null) {
        this.nQa = ((Vibrator)paramAttributeSet);
      }
    }
    localObject = this.yMg;
    if (localObject == null) {
      d.g.b.p.bdF("customTipsContainer");
    }
    paramAttributeSet = this.yMg;
    if (paramAttributeSet == null) {
      d.g.b.p.bdF("customTipsContainer");
    }
    paramAttributeSet = paramAttributeSet.getLayoutParams();
    if (paramAttributeSet != null) {
      if ((paramAttributeSet instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(paramContext, 154) + getMBottomExtraHeight());
      }
    }
    for (paramContext = paramAttributeSet;; paramContext = null)
    {
      ((LinearLayout)localObject).setLayoutParams(paramContext);
      AppMethodBeat.o(52327);
      return;
    }
  }
  
  private final void ae(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(189663);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ae.i("MicroMsg.ScanGoodsMaskView", "alvinluo setPreviewBitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      ((d.g.a.a)new f(this, paramBitmap)).invoke();
    }
    AppMethodBeat.o(189663);
  }
  
  private final void dPF()
  {
    int i = 0;
    AppMethodBeat.i(189662);
    if (getRequest() != null)
    {
      localView = getMGalleryButton();
      if (localView != null)
      {
        BaseScanRequest localBaseScanRequest = getRequest();
        if (localBaseScanRequest == null) {
          d.g.b.p.gkB();
        }
        if (!localBaseScanRequest.yzD) {}
        for (;;)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(189662);
          return;
          i = 8;
        }
      }
      AppMethodBeat.o(189662);
      return;
    }
    View localView = getMGalleryButton();
    if (localView != null)
    {
      localView.setVisibility(0);
      AppMethodBeat.o(189662);
      return;
    }
    AppMethodBeat.o(189662);
  }
  
  private final void dPH()
  {
    AppMethodBeat.i(52317);
    if (getCurrentNetworkAvailable())
    {
      int i;
      if (((CharSequence)getScanTipsWording()).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label70;
        }
        localObject = getScanTips();
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)getScanTipsWording());
        }
      }
      for (;;)
      {
        dPF();
        AppMethodBeat.o(52317);
        return;
        i = 0;
        break;
        label70:
        localObject = getScanTips();
        if (localObject != null) {
          ((TextView)localObject).setText(2131762823);
        }
      }
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
  
  private final void dPI()
  {
    AppMethodBeat.i(52324);
    if (this.xQW != null)
    {
      Bitmap localBitmap = this.xQW;
      if (localBitmap == null) {
        d.g.b.p.gkB();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.xQW;
        if (localBitmap == null) {
          d.g.b.p.gkB();
        }
        localBitmap.recycle();
        this.xQW = null;
      }
    }
    AppMethodBeat.o(52324);
  }
  
  private final void dPJ()
  {
    AppMethodBeat.i(189671);
    try
    {
      Object localObject = this.yMz;
      if (localObject != null) {
        ((android.support.a.d)localObject).cancel();
      }
      localObject = this.yMx;
      if (localObject != null) {
        ((TimerTask)localObject).cancel();
      }
      localObject = this.yMy;
      if (localObject != null)
      {
        ((Timer)localObject).cancel();
        AppMethodBeat.o(189671);
        return;
      }
      AppMethodBeat.o(189671);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(189671);
    }
  }
  
  private final void dPK()
  {
    AppMethodBeat.i(189672);
    ae.e("MicroMsg.ScanGoodsMaskView", "alvinluo onShowCustomViewFailed");
    this.yMd = false;
    Object localObject = this.yMh;
    if (localObject == null) {
      d.g.b.p.bdF("customTipsImageContainer");
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.yMe;
    if (localObject == null) {
      d.g.b.p.bdF("customMaskView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.yMe;
    if (localObject == null) {
      d.g.b.p.bdF("customMaskView");
    }
    ((ImageView)localObject).setImageBitmap(null);
    if ((getRequest() instanceof ScanGoodsRequest))
    {
      localObject = getRequest();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
        AppMethodBeat.o(189672);
        throw ((Throwable)localObject);
      }
      ad.f((ScanGoodsRequest)localObject);
    }
    AppMethodBeat.o(189672);
  }
  
  private final Point getPreviewImageSize()
  {
    AppMethodBeat.i(189664);
    Object localObject;
    if (this.yMr != null)
    {
      localObject = this.yMr;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      if (!((Bitmap)localObject).isRecycled()) {}
    }
    else
    {
      localObject = new Point(0, 0);
      AppMethodBeat.o(189664);
      return localObject;
    }
    float f;
    try
    {
      localObject = this.yMr;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      f = ((Bitmap)localObject).getWidth();
      localObject = this.yMr;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      f = f * 1.0F / ((Bitmap)localObject).getHeight();
      if (f < getMeasuredWidth() * 1.0F / getMeasuredHeight())
      {
        i = getMeasuredHeight();
        localObject = new Point((int)(f * i), i);
        AppMethodBeat.o(189664);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.ScanGoodsMaskView", (Throwable)localException, "alvinluo getPreviewImageSize exception", new Object[0]);
      localPoint = new Point(0, 0);
      AppMethodBeat.o(189664);
      return localPoint;
    }
    int i = getMeasuredWidth();
    Point localPoint = new Point(i, (int)(i / f));
    AppMethodBeat.o(189664);
    return localPoint;
  }
  
  private final void qH(boolean paramBoolean)
  {
    AppMethodBeat.i(52302);
    ScanAnimationDotsView localScanAnimationDotsView = this.yLW;
    if (localScanAnimationDotsView == null) {
      d.g.b.p.bdF("animationDotsView");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localScanAnimationDotsView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localScanAnimationDotsView = this.yLW;
      if (localScanAnimationDotsView == null) {
        d.g.b.p.bdF("animationDotsView");
      }
      localScanAnimationDotsView.startAnimation();
      AppMethodBeat.o(52302);
      return;
    }
    localScanAnimationDotsView = this.yLW;
    if (localScanAnimationDotsView == null) {
      d.g.b.p.bdF("animationDotsView");
    }
    localScanAnimationDotsView.stopAnimation();
    AppMethodBeat.o(52302);
  }
  
  private final void setCustomBackgroundBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(189670);
    paramBitmap = (Runnable)new ScanGoodsMaskView.p(this, paramBitmap);
    if ((this.gil != 0) && (this.gim != 0))
    {
      paramBitmap.run();
      AppMethodBeat.o(189670);
      return;
    }
    this.yMk.add(paramBitmap);
    AppMethodBeat.o(189670);
  }
  
  private final void setCustomTipsWording(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(189669);
    Object localObject = (CharSequence)paramScanGoodsRequest.yzK;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.yMj;
      if (localObject == null) {
        d.g.b.p.bdF("customTipsWording");
      }
      ((TextView)localObject).setText((CharSequence)paramScanGoodsRequest.yzK);
      AppMethodBeat.o(189669);
      return;
    }
    paramScanGoodsRequest = this.yMj;
    if (paramScanGoodsRequest == null) {
      d.g.b.p.bdF("customTipsWording");
    }
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    paramScanGoodsRequest.setText((CharSequence)((Context)localObject).getResources().getString(2131762823));
    AppMethodBeat.o(189669);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52311);
    super.a(paramAnimatorListener);
    dPJ();
    a((View)this, 1.0F, 0.0F, paramAnimatorListener);
    AppMethodBeat.o(52311);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(52313);
    d.g.b.p.h(paramObject, "data");
    ae.i("MicroMsg.ScanGoodsMaskView", "alvinluo onScanSuccess");
    this.yMs = paramc;
    int i;
    label132:
    float f1;
    float f2;
    float f3;
    float f4;
    if ((paramObject instanceof x))
    {
      paramObject = (x)paramObject;
      ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView with animation");
      qH(false);
      ae.v("MicroMsg.ScanGoodsMaskView", "updateSuccessViewVisibility showCustomView: %b", new Object[] { Boolean.valueOf(this.yMd) });
      paramc = this.yMf;
      if (paramc == null) {
        d.g.b.p.bdF("customSuccessView");
      }
      if (!this.yMd) {
        break label461;
      }
      i = 0;
      paramc.setVisibility(i);
      paramc = this.yLY;
      if (paramc == null) {
        d.g.b.p.bdF("successDecorationView");
      }
      if (!this.yMd) {
        break label468;
      }
      i = 0;
      paramc.setVisibility(i);
      dPJ();
      f1 = paramObject.centerX;
      f2 = paramObject.centerY;
      if (getMScanSource() != 1) {
        break label475;
      }
      f3 = f1 * getMeasuredWidth();
      f4 = f2 * getMeasuredHeight();
      ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
      paramObject = new PointF(f3, f4);
      label236:
      paramc = this.yLX;
      if (paramc == null) {
        d.g.b.p.bdF("successMarkView");
      }
      paramc.setVisibility(0);
      paramc.setPivotX(this.yMm / 2.0F);
      paramc.setPivotY(this.yMm / 2.0F);
      paramc.setTranslationX(paramObject.x - this.yMm / 2);
      paramc.setTranslationY(paramObject.y - this.yMm / 2);
      paramc.setScaleX(0.0F);
      paramc.setScaleY(0.0F);
      if (this.yMd) {
        break label585;
      }
      paramObject = this.yLX;
      if (paramObject == null) {
        d.g.b.p.bdF("successMarkView");
      }
      h.a(paramObject, this.yMs);
    }
    for (;;)
    {
      paramObject = this.hcH;
      if (paramObject == null) {
        d.g.b.p.bdF("maskView");
      }
      paramObject.setAlpha(0.0F);
      paramObject.setVisibility(0);
      paramObject = this.yMb;
      if (paramObject == null) {
        d.g.b.p.bdF("blurView");
      }
      paramObject.setVisibility(8);
      qM(false);
      if (this.yMv) {
        com.tencent.e.h.MqF.aO((Runnable)new i(this));
      }
      if (this.yMw) {
        postDelayed((Runnable)new j(this), 100L);
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
      ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPositionForImage previewImageSize: %s, left: %d, top: %d", new Object[] { paramObject, Integer.valueOf(i), Integer.valueOf(j) });
      f3 = i;
      f4 = paramObject.x;
      float f5 = j;
      paramObject = new PointF(f1 * f4 + f3, f2 * paramObject.y + f5);
      break label236;
      label585:
      ae.d("MicroMsg.ScanGoodsMaskView", "alvinluo animateCustomSuccessView");
      paramc = this.yLX;
      if (paramc == null) {
        d.g.b.p.bdF("successMarkView");
      }
      h.eF(paramc);
      paramc = this.yLY;
      if (paramc == null) {
        d.g.b.p.bdF("successDecorationView");
      }
      paramc.setVisibility(0);
      paramc.setPivotX(this.yMn / 2.0F);
      paramc.setPivotY(this.yMn / 2.0F);
      paramc.setTranslationX(paramObject.x - this.yMn / 2);
      paramc.setTranslationY(paramObject.y - this.yMn / 2);
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
      com.tencent.mm.ui.base.p localp = this.fPj;
      if (localp != null) {
        localp.dismiss();
      }
      this.fPj = com.tencent.mm.ui.base.h.b(getContext(), getResources().getString(2131762846), true, paramOnCancelListener);
      AppMethodBeat.o(52314);
      return;
    }
    paramOnCancelListener = this.fPj;
    if (paramOnCancelListener != null)
    {
      paramOnCancelListener.dismiss();
      AppMethodBeat.o(52314);
      return;
    }
    AppMethodBeat.o(52314);
  }
  
  public final void af(Bitmap paramBitmap)
  {
    AppMethodBeat.i(189665);
    dPI();
    ImageView localImageView;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ae.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreview bitmap width: %d, height: %d, showPreviewImage: %b, animateShowPreviewImage: %b", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Boolean.valueOf(this.yMp), Boolean.valueOf(this.yMq) });
      this.yMr = paramBitmap;
      localImageView = this.yMa;
      if (localImageView == null) {
        d.g.b.p.bdF("previewImage");
      }
      localImageView.setImageBitmap(paramBitmap);
      if (!this.yMp) {
        break label188;
      }
      localImageView = this.yMa;
      if (localImageView == null) {
        d.g.b.p.bdF("previewImage");
      }
      localImageView.setVisibility(0);
      if (!this.yMq) {
        break label165;
      }
      localImageView = this.yMa;
      if (localImageView == null) {
        d.g.b.p.bdF("previewImage");
      }
      localImageView.setAlpha(0.0F);
    }
    for (;;)
    {
      ae(paramBitmap);
      AppMethodBeat.o(189665);
      return;
      label165:
      localImageView = this.yMa;
      if (localImageView == null) {
        d.g.b.p.bdF("previewImage");
      }
      localImageView.setAlpha(1.0F);
      continue;
      label188:
      localImageView = this.yMa;
      if (localImageView == null) {
        d.g.b.p.bdF("previewImage");
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
        bool = this.yMo & true;
        f1 = (f1 - 0.5F) / 0.5F;
        localObject = this.yMb;
        if (localObject == null) {
          d.g.b.p.bdF("blurView");
        }
        ((ImageView)localObject).setAlpha(this.yMu.getInterpolation(f1));
        localObject = this.yLX;
        if (localObject == null) {
          d.g.b.p.bdF("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.yMa;
        if (localObject == null) {
          d.g.b.p.bdF("previewImage");
        }
        localImageView = this.yMb;
        if (localImageView == null) {
          d.g.b.p.bdF("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        localObject = this.hcH;
        if (localObject == null) {
          d.g.b.p.bdF("maskView");
        }
        ((View)localObject).setAlpha(0.5F);
        label189:
        localObject = this.yMb;
        if (localObject == null) {
          d.g.b.p.bdF("blurView");
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
      localObject = this.hcH;
      if (localObject == null) {
        d.g.b.p.bdF("maskView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.yMb;
      if (localObject == null) {
        d.g.b.p.bdF("blurView");
      }
      f1 = ((ImageView)localObject).getAlpha();
      localObject = this.yLX;
      if (localObject == null) {
        d.g.b.p.bdF("successMarkView");
      }
      float f2 = ((View)localObject).getAlpha();
      localObject = this.hcH;
      if (localObject == null) {
        d.g.b.p.bdF("maskView");
      }
      float f3 = ((View)localObject).getAlpha();
      localObject = this.yMa;
      if (localObject == null) {
        d.g.b.p.bdF("previewImage");
      }
      ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, markView alpha: %s, maskView alpha: %s, previewImage alpha: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(((ImageView)localObject).getAlpha()) });
      AppMethodBeat.o(52323);
      return;
      if (paramInt == 2)
      {
        bool = this.yMo & true;
        localObject = this.yMb;
        if (localObject == null) {
          d.g.b.p.bdF("blurView");
        }
        ((ImageView)localObject).setAlpha(this.yMu.getInterpolation(f1));
        localObject = this.yLX;
        if (localObject == null) {
          d.g.b.p.bdF("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.yMa;
        if (localObject == null) {
          d.g.b.p.bdF("previewImage");
        }
        localImageView = this.yMb;
        if (localImageView == null) {
          d.g.b.p.bdF("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        break;
      }
      localObject = this.yLX;
      if (localObject == null) {
        d.g.b.p.bdF("successMarkView");
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.yMa;
      if (localObject == null) {
        d.g.b.p.bdF("previewImage");
      }
      ((ImageView)localObject).setAlpha(1.0F);
      bool = false;
      break;
      localObject = this.hcH;
      if (localObject == null) {
        d.g.b.p.bdF("maskView");
      }
      ((View)localObject).setAlpha(Math.max(0.0F, Math.min(0.5F, 1.0F - f1)));
      if (this.yMp)
      {
        if (this.yMq)
        {
          f1 = Math.max(0.0F, Math.min(1.0F, (paramFloat2 - 0.5F) / 0.5F));
          localObject = this.yMa;
          if (localObject == null) {
            d.g.b.p.bdF("previewImage");
          }
          ((ImageView)localObject).setAlpha(1.0F - f1);
          localObject = this.yMa;
          if (localObject == null) {
            d.g.b.p.bdF("previewImage");
          }
          ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY previewImage.alpha: %f, targetFactor: %f", new Object[] { Float.valueOf(((ImageView)localObject).getAlpha()), Float.valueOf(f1) });
          bool = false;
          break label189;
        }
        localObject = this.yMa;
        if (localObject == null) {
          d.g.b.p.bdF("previewImage");
        }
        ((ImageView)localObject).setAlpha(1.0F);
      }
      bool = false;
      break label189;
    }
  }
  
  public final void dPG()
  {
    AppMethodBeat.i(52310);
    super.dPG();
    dPH();
    AppMethodBeat.o(52310);
  }
  
  public final void eH(View paramView)
  {
    AppMethodBeat.i(52308);
    d.g.b.p.h(paramView, "flashSwitcher");
    super.eH(paramView);
    View localView = getFlashSwitcher();
    if (localView != null)
    {
      paramView = getFlashSwitcher();
      if (paramView != null)
      {
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
          if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams)paramView).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight());
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
  
  public final void eI(final View paramView)
  {
    int i = 1;
    AppMethodBeat.i(52309);
    this.yMc = paramView;
    ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo attachBackgroundView source: %d", new Object[] { Integer.valueOf(getMScanSource()) });
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
        com.tencent.e.h.MqF.aO((Runnable)new r(this, paramView));
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
    View localView = this.yMc;
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
    float f = this.yMm;
    AppMethodBeat.o(52322);
    return f;
  }
  
  public final float getMarkViewTransY()
  {
    AppMethodBeat.i(52321);
    View localView = this.yLX;
    if (localView == null) {
      d.g.b.p.bdF("successMarkView");
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(52321);
    return f;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189666);
    super.onMeasure(paramInt1, paramInt2);
    this.gil = getMeasuredWidth();
    this.gim = getMeasuredHeight();
    if ((this.gil != 0) && (this.gim != 0))
    {
      Iterator localIterator = ((Iterable)this.yMk).iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.yMk.clear();
    }
    AppMethodBeat.o(189666);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(52316);
    super.onNetworkChange(paramInt);
    dPH();
    AppMethodBeat.o(52316);
  }
  
  public final void qG(final boolean paramBoolean)
  {
    AppMethodBeat.i(52312);
    super.qG(paramBoolean);
    Object localObject1 = (d.g.a.a)new h(this, paramBoolean);
    Object localObject2 = this.yMb;
    if (localObject2 == null) {
      d.g.b.p.bdF("blurView");
    }
    if (((ImageView)localObject2).getVisibility() != 0)
    {
      localObject2 = this.yMa;
      if (localObject2 == null) {
        d.g.b.p.bdF("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0)
      {
        localObject2 = this.yLZ;
        if (localObject2 == null) {
          d.g.b.p.bdF("bottomBlurView");
        }
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label256;
        }
      }
    }
    localObject2 = this.yMa;
    if (localObject2 == null) {
      d.g.b.p.bdF("previewImage");
    }
    if (((ImageView)localObject2).getAlpha() == 1.0F)
    {
      localObject2 = this.yMa;
      if (localObject2 == null) {
        d.g.b.p.bdF("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject2 = this.yMb;
      if (localObject2 == null) {
        d.g.b.p.bdF("blurView");
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
      localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)this.yMt);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new ScanGoodsMaskView.d((d.g.a.a)localObject1));
      if (localObject1 == null) {
        break;
      }
      ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanGoodsMaskView.e(this, paramBoolean));
      AppMethodBeat.o(52312);
      return;
    }
    AppMethodBeat.o(52312);
    return;
    label256:
    ((d.g.a.a)localObject1).invoke();
    AppMethodBeat.o(52312);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52315);
    super.release();
    Object localObject = this.yLW;
    if (localObject == null) {
      d.g.b.p.bdF("animationDotsView");
    }
    ((ScanAnimationDotsView)localObject).release();
    localObject = com.tencent.mm.plugin.scanner.model.z.yDF;
    long l = this.yMl;
    localObject = (ScanGoodsRequest)com.tencent.mm.plugin.scanner.model.z.yDC.get(Long.valueOf(l));
    com.tencent.mm.plugin.scanner.model.z.yDC.remove(Long.valueOf(l));
    com.tencent.mm.plugin.scanner.model.z.gsk.remove(Long.valueOf(l));
    if (localObject != null)
    {
      ae.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestId: %s", new Object[] { Long.valueOf(l) });
      String str = com.tencent.mm.plugin.scanner.model.z.c((ScanGoodsRequest)localObject);
      ((Map)com.tencent.mm.plugin.scanner.model.z.yDE).put(str, Boolean.TRUE);
      com.tencent.e.h.MqF.b((Runnable)new z.f(str, (ScanGoodsRequest)localObject), 10000L, "ScanResourceTag");
    }
    dPJ();
    AppMethodBeat.o(52315);
  }
  
  public final void setBackgroundTransY(float paramFloat)
  {
    AppMethodBeat.i(52318);
    Object localObject = this.yMc;
    if (localObject != null) {
      ((View)localObject).setTranslationY(paramFloat);
    }
    localObject = this.yMb;
    if (localObject == null) {
      d.g.b.p.bdF("blurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.yMa;
    if (localObject == null) {
      d.g.b.p.bdF("previewImage");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.yLZ;
    if (localObject == null) {
      d.g.b.p.bdF("bottomBlurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    AppMethodBeat.o(52318);
  }
  
  public final void setMarkViewTransY(float paramFloat)
  {
    AppMethodBeat.i(52320);
    View localView = this.yLX;
    if (localView == null) {
      d.g.b.p.bdF("successMarkView");
    }
    localView.setTranslationY(paramFloat);
    AppMethodBeat.o(52320);
  }
  
  public final void setScanRequest(final ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(189667);
    super.setScanRequest((BaseScanRequest)paramScanGoodsRequest);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(189667);
      return;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      ae.w("MicroMsg.ScanGoodsMaskView", "alvinluo setScanRequest request is not valid and ignore");
      ad.e(paramScanGoodsRequest);
      AppMethodBeat.o(189667);
      return;
    }
    Object localObject = this.yMg;
    if (localObject == null) {
      d.g.b.p.bdF("customTipsContainer");
    }
    ((LinearLayout)localObject).setVisibility(0);
    setCustomTipsWording(paramScanGoodsRequest);
    localObject = com.tencent.mm.plugin.scanner.model.z.yDF;
    this.yMl = com.tencent.mm.plugin.scanner.model.z.a(paramScanGoodsRequest, (y)new q(this, paramScanGoodsRequest));
    if (paramScanGoodsRequest.yzM)
    {
      paramScanGoodsRequest.yzM = false;
      this.yMy = new Timer();
      this.yMx = ((TimerTask)new g(this));
      paramScanGoodsRequest = this.yMy;
      if (paramScanGoodsRequest != null)
      {
        paramScanGoodsRequest.schedule(this.yMx, 15000L);
        AppMethodBeat.o(189667);
        return;
      }
    }
    AppMethodBeat.o(189667);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(189650);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = ScanGoodsMaskView.a(this.yMB).animate();
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
                  AppMethodBeat.o(189650);
                  return;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(189650);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(189651);
      super.onAnimationStart(paramAnimator);
      ScanGoodsMaskView.b(this.yMB);
      AppMethodBeat.o(189651);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(189649);
        super.onAnimationEnd(paramAnimator);
        paramAnimator = ScanGoodsMaskView.b(this.yMC.yMB);
        if (paramAnimator != null)
        {
          paramAnimator.dOW();
          AppMethodBeat.o(189649);
          return;
        }
        AppMethodBeat.o(189649);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<d.z>
  {
    f(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<d.z>
    {
      a(ScanGoodsMaskView.f paramf, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$initScanTipsImageAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class g
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(189654);
      com.tencent.e.h.MqF.aM((Runnable)new a(this));
      AppMethodBeat.o(189654);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanGoodsMaskView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(189653);
        if ((ScanGoodsMaskView.g(this.yMJ.yMB)) && (ScanGoodsMaskView.z(this.yMJ.yMB).getVisibility() == 0)) {
          ScanGoodsMaskView.a(this.yMJ.yMB, h.eG((View)ScanGoodsMaskView.z(this.yMJ.yMB)));
        }
        AppMethodBeat.o(189653);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<d.z>
  {
    h(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52296);
      be.aI(this.yMB.getContext(), 2131762120);
      AppMethodBeat.o(52296);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52297);
      ScanGoodsMaskView.q(this.yMB);
      AppMethodBeat.o(52297);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$onSetCustomBackgroundSuccess$4", "Lcom/tencent/mm/vending/pipeline/PipeableTerminal$Interrupt;", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "", "onInterrupt", "", "result", "plugin-scan_release"})
  public static final class n
    implements d.a<com.tencent.mm.vending.j.c<Boolean, String>>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Boolean;)V"})
  static final class o<T>
    implements d.b<Boolean>
  {
    o(ScanGoodsMaskView paramScanGoodsMaskView) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$setScanRequest$1", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "onLoadResult", "", "errCode", "", "errMsg", "", "plugin-scan_release"})
  public static final class q
    implements y
  {
    q(ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void bX(int paramInt, String paramString)
    {
      AppMethodBeat.i(189661);
      d.g.b.p.h(paramString, "errMsg");
      ae.i("MicroMsg.ScanGoodsMaskView", "alvinluo loadResource onLoadResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
      if (paramInt == 0)
      {
        paramString = this.yMB;
        String str = paramScanGoodsRequest.yzH;
        d.g.b.p.g(str, "request.decorationImagePath");
        ScanGoodsMaskView.a(paramString, str);
      }
      AppMethodBeat.o(189661);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(ScanGoodsMaskView paramScanGoodsMaskView, TextureView paramTextureView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52301);
      ScanGoodsMaskView.p(this.yMB);
      long l = System.currentTimeMillis();
      final Bitmap localBitmap = paramView.getBitmap();
      ae.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.e.h.MqF.aM((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52300);
          ScanGoodsMaskView.c(this.yMN.yMB, u.dOo());
          ScanGoodsMaskView.r(this.yMN.yMB);
          ScanGoodsMaskView.b(this.yMN.yMB, localBitmap);
          AppMethodBeat.o(52300);
        }
      });
      AppMethodBeat.o(52301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView
 * JD-Core Version:    0.7.0.1
 */