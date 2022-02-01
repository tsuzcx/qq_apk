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
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.model.y.f;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateShowPreviewImage", "", "animationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "customMaskView", "customSuccessView", "customTipsContainer", "Landroid/widget/LinearLayout;", "customTipsImage", "customTipsImageContainer", "customTipsWording", "Landroid/widget/TextView;", "enablePlaySound", "enableVibrate", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "pendingTasks", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "previewBitmap", "previewImage", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "resourceLoadRequestId", "", "scanTipsImageAnimation", "Landroid/support/animation/SpringAnimation;", "scanTipsImageAnimationTimer", "Ljava/util/Timer;", "scanTipsImageAnimationTimerTask", "Ljava/util/TimerTask;", "showCustomView", "showPreviewImage", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successDecorationView", "successDecorationViewSize", "successMarkView", "successMarkViewSize", "vibrator", "Landroid/os/Vibrator;", "viewHeight", "viewWidth", "addAnimationScanDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "animateCustomSuccessView", "center", "Landroid/graphics/PointF;", "animateHideBlurView", "animationEndCallback", "Lkotlin/Function0;", "animateScanDots", "start", "attachBackgroundView", "attachFlashSwitcherView", "flashSwitcher", "bitmap", "async", "cancelScanTipsImageAnimation", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "doUpdatePreview", "getBackgroundTransY", "", "getMarkViewHeight", "getMarkViewTransY", "getPreviewImageSize", "getRealPosition", "centerX", "centerY", "getRealPositionForImage", "init", "initScanTipsImageAnimation", "request", "isFromCapture", "isFromGallery", "onDialogDismissAnimationEnd", "onDialogShowAnimationEnd", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNetworkChange", "state", "onPreviewReady", "isSwitchTab", "onScanSuccess", "data", "", "scanResultAnimationListener", "onSetCustomBackgroundSuccess", "onShowCustomViewFailed", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleBlurBitmap", "release", "runPendingTasks", "setBackgroundTransY", "translationY", "setCustomBackgroundBitmap", "setCustomTipsWording", "setMarkViewTransY", "setScanRequest", "showCustomBackground", "imagePath", "", "showGalleryButton", "show", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "updateBlurBitmap", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updatePreviewImageAlpha", "updateSuccessViewVisibility", "updateViewByNetwork", "vibrate", "Companion", "plugin-scan_release"})
public final class ScanGoodsMaskView
  extends BaseScanMaskView<ScanGoodsRequest>
  implements com.tencent.mm.plugin.scanner.box.a, com.tencent.mm.plugin.scanner.box.d
{
  public static final ScanGoodsMaskView.a ywA;
  private com.tencent.mm.ui.base.p fNb;
  private View gZU;
  private int gfT;
  private int gfU;
  private Vibrator nKv;
  private Bitmap xBb;
  public ScanAnimationDotsView yvW;
  private View yvX;
  private ImageView yvY;
  private ImageView yvZ;
  private ImageView ywa;
  private ImageView ywb;
  private View ywc;
  private boolean ywd;
  private ImageView ywe;
  private ImageView ywf;
  private LinearLayout ywg;
  private LinearLayout ywh;
  private ImageView ywi;
  private TextView ywj;
  private ArrayList<Runnable> ywk;
  private long ywl;
  private int ywm;
  private int ywn;
  private boolean ywo;
  public boolean ywp;
  public boolean ywq;
  private Bitmap ywr;
  private com.tencent.mm.plugin.scanner.view.c yws;
  private LinearInterpolator ywt;
  private DecelerateInterpolator ywu;
  private boolean ywv;
  private boolean yww;
  private TimerTask ywx;
  private Timer ywy;
  private android.support.a.d ywz;
  
  static
  {
    AppMethodBeat.i(52328);
    ywA = new ScanGoodsMaskView.a((byte)0);
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
    this.ywk = new ArrayList();
    this.ywm = getResources().getDimensionPixelSize(2131166771);
    this.ywn = getResources().getDimensionPixelSize(2131167048);
    this.ywt = new LinearInterpolator();
    this.ywu = new DecelerateInterpolator();
    this.ywv = true;
    this.yww = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494567, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131304301);
    d.g.b.p.g(localObject, "view.findViewById(R.id.scan_animation_dots_view)");
    this.yvW = ((ScanAnimationDotsView)localObject);
    localObject = paramAttributeSet.findViewById(2131304331);
    d.g.b.p.g(localObject, "view.findViewById(R.id.scan_success_dot_view)");
    this.yvX = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131303390);
    d.g.b.p.g(localObject, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
    this.yvZ = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131303389);
    d.g.b.p.g(localObject, "view.findViewById(R.id.preview_blur_view)");
    this.ywb = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131302169);
    d.g.b.p.g(localObject, "view.findViewById(R.id.mask_view)");
    this.gZU = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131303394);
    d.g.b.p.g(localObject, "view.findViewById(R.id.preview_image)");
    this.ywa = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307306);
    d.g.b.p.g(localObject, "view.findViewById(R.id.custom_mask_view)");
    this.ywe = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307311);
    d.g.b.p.g(localObject, "view.findViewById(R.id.custom_success_view)");
    this.ywf = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131308017);
    d.g.b.p.g(localObject, "view.findViewById(R.id.success_decoration_view)");
    this.yvY = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131307307);
    d.g.b.p.g(localObject, "view.findViewById(R.id.custom_scan_tips_container)");
    this.ywg = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(2131307309);
    d.g.b.p.g(localObject, "view.findViewById(R.id.c…can_tips_image_container)");
    this.ywh = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(2131307308);
    d.g.b.p.g(localObject, "view.findViewById(R.id.custom_scan_tips_image)");
    this.ywi = ((ImageView)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131307310);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.custom_scan_tips_wording)");
    this.ywj = ((TextView)paramAttributeSet);
    if (this.nKv == null)
    {
      paramAttributeSet = paramContext.getSystemService("vibrator");
      if (paramAttributeSet != null) {
        this.nKv = ((Vibrator)paramAttributeSet);
      }
    }
    localObject = this.ywg;
    if (localObject == null) {
      d.g.b.p.bcb("customTipsContainer");
    }
    paramAttributeSet = this.ywg;
    if (paramAttributeSet == null) {
      d.g.b.p.bcb("customTipsContainer");
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
  
  private final void ad(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(186368);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo setPreviewBitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      ((d.g.a.a)new f(this, paramBitmap)).invoke();
    }
    AppMethodBeat.o(186368);
  }
  
  private final void dMm()
  {
    int i = 0;
    AppMethodBeat.i(186367);
    if (getRequest() != null)
    {
      localView = getMGalleryButton();
      if (localView != null)
      {
        BaseScanRequest localBaseScanRequest = getRequest();
        if (localBaseScanRequest == null) {
          d.g.b.p.gfZ();
        }
        if (!localBaseScanRequest.yjH) {}
        for (;;)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(186367);
          return;
          i = 8;
        }
      }
      AppMethodBeat.o(186367);
      return;
    }
    View localView = getMGalleryButton();
    if (localView != null)
    {
      localView.setVisibility(0);
      AppMethodBeat.o(186367);
      return;
    }
    AppMethodBeat.o(186367);
  }
  
  private final void dMo()
  {
    AppMethodBeat.i(52317);
    if (getCurrentNetworkAvailable())
    {
      localObject = getScanTips();
      if (localObject != null) {
        ((TextView)localObject).setText(2131762823);
      }
      dMm();
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
  
  private final void dMp()
  {
    AppMethodBeat.i(52324);
    if (this.xBb != null)
    {
      Bitmap localBitmap = this.xBb;
      if (localBitmap == null) {
        d.g.b.p.gfZ();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.xBb;
        if (localBitmap == null) {
          d.g.b.p.gfZ();
        }
        localBitmap.recycle();
        this.xBb = null;
      }
    }
    AppMethodBeat.o(52324);
  }
  
  private final void dMq()
  {
    AppMethodBeat.i(186376);
    try
    {
      Object localObject = this.ywz;
      if (localObject != null) {
        ((android.support.a.d)localObject).cancel();
      }
      localObject = this.ywx;
      if (localObject != null) {
        ((TimerTask)localObject).cancel();
      }
      localObject = this.ywy;
      if (localObject != null)
      {
        ((Timer)localObject).cancel();
        AppMethodBeat.o(186376);
        return;
      }
      AppMethodBeat.o(186376);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(186376);
    }
  }
  
  private final void dMr()
  {
    AppMethodBeat.i(186377);
    ad.e("MicroMsg.ScanGoodsMaskView", "alvinluo onShowCustomViewFailed");
    this.ywd = false;
    Object localObject = this.ywh;
    if (localObject == null) {
      d.g.b.p.bcb("customTipsImageContainer");
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.ywe;
    if (localObject == null) {
      d.g.b.p.bcb("customMaskView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.ywe;
    if (localObject == null) {
      d.g.b.p.bcb("customMaskView");
    }
    ((ImageView)localObject).setImageBitmap(null);
    if ((getRequest() instanceof ScanGoodsRequest))
    {
      localObject = getRequest();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
        AppMethodBeat.o(186377);
        throw ((Throwable)localObject);
      }
      ac.f((ScanGoodsRequest)localObject);
    }
    AppMethodBeat.o(186377);
  }
  
  private final Point getPreviewImageSize()
  {
    AppMethodBeat.i(186369);
    Object localObject;
    if (this.ywr != null)
    {
      localObject = this.ywr;
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      if (!((Bitmap)localObject).isRecycled()) {}
    }
    else
    {
      localObject = new Point(0, 0);
      AppMethodBeat.o(186369);
      return localObject;
    }
    float f;
    try
    {
      localObject = this.ywr;
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      f = ((Bitmap)localObject).getWidth();
      localObject = this.ywr;
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      f = f * 1.0F / ((Bitmap)localObject).getHeight();
      if (f < getMeasuredWidth() * 1.0F / getMeasuredHeight())
      {
        i = getMeasuredHeight();
        localObject = new Point((int)(f * i), i);
        AppMethodBeat.o(186369);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ScanGoodsMaskView", (Throwable)localException, "alvinluo getPreviewImageSize exception", new Object[0]);
      localPoint = new Point(0, 0);
      AppMethodBeat.o(186369);
      return localPoint;
    }
    int i = getMeasuredWidth();
    Point localPoint = new Point(i, (int)(i / f));
    AppMethodBeat.o(186369);
    return localPoint;
  }
  
  private final void qA(boolean paramBoolean)
  {
    AppMethodBeat.i(52302);
    ScanAnimationDotsView localScanAnimationDotsView = this.yvW;
    if (localScanAnimationDotsView == null) {
      d.g.b.p.bcb("animationDotsView");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localScanAnimationDotsView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localScanAnimationDotsView = this.yvW;
      if (localScanAnimationDotsView == null) {
        d.g.b.p.bcb("animationDotsView");
      }
      localScanAnimationDotsView.startAnimation();
      AppMethodBeat.o(52302);
      return;
    }
    localScanAnimationDotsView = this.yvW;
    if (localScanAnimationDotsView == null) {
      d.g.b.p.bcb("animationDotsView");
    }
    localScanAnimationDotsView.stopAnimation();
    AppMethodBeat.o(52302);
  }
  
  private final void setCustomBackgroundBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(186375);
    paramBitmap = (Runnable)new p(this, paramBitmap);
    if ((this.gfT != 0) && (this.gfU != 0))
    {
      paramBitmap.run();
      AppMethodBeat.o(186375);
      return;
    }
    this.ywk.add(paramBitmap);
    AppMethodBeat.o(186375);
  }
  
  private final void setCustomTipsWording(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(186374);
    Object localObject = (CharSequence)paramScanGoodsRequest.yjO;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.ywj;
      if (localObject == null) {
        d.g.b.p.bcb("customTipsWording");
      }
      ((TextView)localObject).setText((CharSequence)paramScanGoodsRequest.yjO);
      AppMethodBeat.o(186374);
      return;
    }
    paramScanGoodsRequest = this.ywj;
    if (paramScanGoodsRequest == null) {
      d.g.b.p.bcb("customTipsWording");
    }
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    paramScanGoodsRequest.setText((CharSequence)((Context)localObject).getResources().getString(2131762823));
    AppMethodBeat.o(186374);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52311);
    super.a(paramAnimatorListener);
    dMq();
    a((View)this, 1.0F, 0.0F, paramAnimatorListener);
    AppMethodBeat.o(52311);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(52313);
    d.g.b.p.h(paramObject, "data");
    ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo onScanSuccess");
    this.yws = paramc;
    int i;
    label132:
    float f1;
    float f2;
    float f3;
    float f4;
    if ((paramObject instanceof w))
    {
      paramObject = (w)paramObject;
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView with animation");
      qA(false);
      ad.v("MicroMsg.ScanGoodsMaskView", "updateSuccessViewVisibility showCustomView: %b", new Object[] { Boolean.valueOf(this.ywd) });
      paramc = this.ywf;
      if (paramc == null) {
        d.g.b.p.bcb("customSuccessView");
      }
      if (!this.ywd) {
        break label461;
      }
      i = 0;
      paramc.setVisibility(i);
      paramc = this.yvY;
      if (paramc == null) {
        d.g.b.p.bcb("successDecorationView");
      }
      if (!this.ywd) {
        break label468;
      }
      i = 0;
      paramc.setVisibility(i);
      dMq();
      f1 = paramObject.centerX;
      f2 = paramObject.centerY;
      if (getMScanSource() != 1) {
        break label475;
      }
      f3 = f1 * getMeasuredWidth();
      f4 = f2 * getMeasuredHeight();
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
      paramObject = new PointF(f3, f4);
      label236:
      paramc = this.yvX;
      if (paramc == null) {
        d.g.b.p.bcb("successMarkView");
      }
      paramc.setVisibility(0);
      paramc.setPivotX(this.ywm / 2.0F);
      paramc.setPivotY(this.ywm / 2.0F);
      paramc.setTranslationX(paramObject.x - this.ywm / 2);
      paramc.setTranslationY(paramObject.y - this.ywm / 2);
      paramc.setScaleX(0.0F);
      paramc.setScaleY(0.0F);
      if (this.ywd) {
        break label585;
      }
      paramObject = this.yvX;
      if (paramObject == null) {
        d.g.b.p.bcb("successMarkView");
      }
      h.a(paramObject, this.yws);
    }
    for (;;)
    {
      paramObject = this.gZU;
      if (paramObject == null) {
        d.g.b.p.bcb("maskView");
      }
      paramObject.setAlpha(0.0F);
      paramObject.setVisibility(0);
      paramObject = this.ywb;
      if (paramObject == null) {
        d.g.b.p.bcb("blurView");
      }
      paramObject.setVisibility(8);
      qF(false);
      if (this.ywv) {
        com.tencent.e.h.LTJ.aR((Runnable)new i(this));
      }
      if (this.yww) {
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
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPositionForImage previewImageSize: %s, left: %d, top: %d", new Object[] { paramObject, Integer.valueOf(i), Integer.valueOf(j) });
      f3 = i;
      f4 = paramObject.x;
      float f5 = j;
      paramObject = new PointF(f1 * f4 + f3, f2 * paramObject.y + f5);
      break label236;
      label585:
      ad.d("MicroMsg.ScanGoodsMaskView", "alvinluo animateCustomSuccessView");
      paramc = this.yvX;
      if (paramc == null) {
        d.g.b.p.bcb("successMarkView");
      }
      h.eF(paramc);
      paramc = this.yvY;
      if (paramc == null) {
        d.g.b.p.bcb("successDecorationView");
      }
      paramc.setVisibility(0);
      paramc.setPivotX(this.ywn / 2.0F);
      paramc.setPivotY(this.ywn / 2.0F);
      paramc.setTranslationX(paramObject.x - this.ywn / 2);
      paramc.setTranslationY(paramObject.y - this.ywn / 2);
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
      com.tencent.mm.ui.base.p localp = this.fNb;
      if (localp != null) {
        localp.dismiss();
      }
      this.fNb = com.tencent.mm.ui.base.h.b(getContext(), getResources().getString(2131762846), true, paramOnCancelListener);
      AppMethodBeat.o(52314);
      return;
    }
    paramOnCancelListener = this.fNb;
    if (paramOnCancelListener != null)
    {
      paramOnCancelListener.dismiss();
      AppMethodBeat.o(52314);
      return;
    }
    AppMethodBeat.o(52314);
  }
  
  public final void ae(Bitmap paramBitmap)
  {
    AppMethodBeat.i(186370);
    dMp();
    ImageView localImageView;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreview bitmap width: %d, height: %d, showPreviewImage: %b, animateShowPreviewImage: %b", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Boolean.valueOf(this.ywp), Boolean.valueOf(this.ywq) });
      this.ywr = paramBitmap;
      localImageView = this.ywa;
      if (localImageView == null) {
        d.g.b.p.bcb("previewImage");
      }
      localImageView.setImageBitmap(paramBitmap);
      if (!this.ywp) {
        break label188;
      }
      localImageView = this.ywa;
      if (localImageView == null) {
        d.g.b.p.bcb("previewImage");
      }
      localImageView.setVisibility(0);
      if (!this.ywq) {
        break label165;
      }
      localImageView = this.ywa;
      if (localImageView == null) {
        d.g.b.p.bcb("previewImage");
      }
      localImageView.setAlpha(0.0F);
    }
    for (;;)
    {
      ad(paramBitmap);
      AppMethodBeat.o(186370);
      return;
      label165:
      localImageView = this.ywa;
      if (localImageView == null) {
        d.g.b.p.bcb("previewImage");
      }
      localImageView.setAlpha(1.0F);
      continue;
      label188:
      localImageView = this.ywa;
      if (localImageView == null) {
        d.g.b.p.bcb("previewImage");
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
        bool = this.ywo & true;
        f1 = (f1 - 0.5F) / 0.5F;
        localObject = this.ywb;
        if (localObject == null) {
          d.g.b.p.bcb("blurView");
        }
        ((ImageView)localObject).setAlpha(this.ywu.getInterpolation(f1));
        localObject = this.yvX;
        if (localObject == null) {
          d.g.b.p.bcb("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.ywa;
        if (localObject == null) {
          d.g.b.p.bcb("previewImage");
        }
        localImageView = this.ywb;
        if (localImageView == null) {
          d.g.b.p.bcb("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        localObject = this.gZU;
        if (localObject == null) {
          d.g.b.p.bcb("maskView");
        }
        ((View)localObject).setAlpha(0.5F);
        label189:
        localObject = this.ywb;
        if (localObject == null) {
          d.g.b.p.bcb("blurView");
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
      localObject = this.gZU;
      if (localObject == null) {
        d.g.b.p.bcb("maskView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.ywb;
      if (localObject == null) {
        d.g.b.p.bcb("blurView");
      }
      f1 = ((ImageView)localObject).getAlpha();
      localObject = this.yvX;
      if (localObject == null) {
        d.g.b.p.bcb("successMarkView");
      }
      float f2 = ((View)localObject).getAlpha();
      localObject = this.gZU;
      if (localObject == null) {
        d.g.b.p.bcb("maskView");
      }
      float f3 = ((View)localObject).getAlpha();
      localObject = this.ywa;
      if (localObject == null) {
        d.g.b.p.bcb("previewImage");
      }
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, markView alpha: %s, maskView alpha: %s, previewImage alpha: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(((ImageView)localObject).getAlpha()) });
      AppMethodBeat.o(52323);
      return;
      if (paramInt == 2)
      {
        bool = this.ywo & true;
        localObject = this.ywb;
        if (localObject == null) {
          d.g.b.p.bcb("blurView");
        }
        ((ImageView)localObject).setAlpha(this.ywu.getInterpolation(f1));
        localObject = this.yvX;
        if (localObject == null) {
          d.g.b.p.bcb("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.ywa;
        if (localObject == null) {
          d.g.b.p.bcb("previewImage");
        }
        localImageView = this.ywb;
        if (localImageView == null) {
          d.g.b.p.bcb("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        break;
      }
      localObject = this.yvX;
      if (localObject == null) {
        d.g.b.p.bcb("successMarkView");
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.ywa;
      if (localObject == null) {
        d.g.b.p.bcb("previewImage");
      }
      ((ImageView)localObject).setAlpha(1.0F);
      bool = false;
      break;
      localObject = this.gZU;
      if (localObject == null) {
        d.g.b.p.bcb("maskView");
      }
      ((View)localObject).setAlpha(Math.max(0.0F, Math.min(0.5F, 1.0F - f1)));
      if (this.ywp)
      {
        if (this.ywq)
        {
          f1 = Math.max(0.0F, Math.min(1.0F, (paramFloat2 - 0.5F) / 0.5F));
          localObject = this.ywa;
          if (localObject == null) {
            d.g.b.p.bcb("previewImage");
          }
          ((ImageView)localObject).setAlpha(1.0F - f1);
          localObject = this.ywa;
          if (localObject == null) {
            d.g.b.p.bcb("previewImage");
          }
          ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY previewImage.alpha: %f, targetFactor: %f", new Object[] { Float.valueOf(((ImageView)localObject).getAlpha()), Float.valueOf(f1) });
          bool = false;
          break label189;
        }
        localObject = this.ywa;
        if (localObject == null) {
          d.g.b.p.bcb("previewImage");
        }
        ((ImageView)localObject).setAlpha(1.0F);
      }
      bool = false;
      break label189;
    }
  }
  
  public final void dMn()
  {
    AppMethodBeat.i(52310);
    super.dMn();
    dMo();
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
  
  public final void eI(final View paramView)
  {
    int i = 1;
    AppMethodBeat.i(52309);
    this.ywc = paramView;
    ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo attachBackgroundView source: %d", new Object[] { Integer.valueOf(getMScanSource()) });
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
        com.tencent.e.h.LTJ.aR((Runnable)new r(this, paramView));
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
    View localView = this.ywc;
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
    float f = this.ywm;
    AppMethodBeat.o(52322);
    return f;
  }
  
  public final float getMarkViewTransY()
  {
    AppMethodBeat.i(52321);
    View localView = this.yvX;
    if (localView == null) {
      d.g.b.p.bcb("successMarkView");
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(52321);
    return f;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186371);
    super.onMeasure(paramInt1, paramInt2);
    this.gfT = getMeasuredWidth();
    this.gfU = getMeasuredHeight();
    if ((this.gfT != 0) && (this.gfU != 0))
    {
      Iterator localIterator = ((Iterable)this.ywk).iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.ywk.clear();
    }
    AppMethodBeat.o(186371);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(52316);
    super.onNetworkChange(paramInt);
    dMo();
    AppMethodBeat.o(52316);
  }
  
  public final void qz(final boolean paramBoolean)
  {
    AppMethodBeat.i(52312);
    super.qz(paramBoolean);
    Object localObject1 = (d.g.a.a)new h(this, paramBoolean);
    Object localObject2 = this.ywb;
    if (localObject2 == null) {
      d.g.b.p.bcb("blurView");
    }
    if (((ImageView)localObject2).getVisibility() != 0)
    {
      localObject2 = this.ywa;
      if (localObject2 == null) {
        d.g.b.p.bcb("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0)
      {
        localObject2 = this.yvZ;
        if (localObject2 == null) {
          d.g.b.p.bcb("bottomBlurView");
        }
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label256;
        }
      }
    }
    localObject2 = this.ywa;
    if (localObject2 == null) {
      d.g.b.p.bcb("previewImage");
    }
    if (((ImageView)localObject2).getAlpha() == 1.0F)
    {
      localObject2 = this.ywa;
      if (localObject2 == null) {
        d.g.b.p.bcb("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject2 = this.ywb;
      if (localObject2 == null) {
        d.g.b.p.bcb("blurView");
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
      localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)this.ywt);
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
    Object localObject = this.yvW;
    if (localObject == null) {
      d.g.b.p.bcb("animationDotsView");
    }
    ((ScanAnimationDotsView)localObject).release();
    localObject = y.ynG;
    long l = this.ywl;
    localObject = (ScanGoodsRequest)y.ynD.get(Long.valueOf(l));
    y.ynD.remove(Long.valueOf(l));
    y.gpP.remove(Long.valueOf(l));
    if (localObject != null)
    {
      ad.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestId: %s", new Object[] { Long.valueOf(l) });
      String str = y.c((ScanGoodsRequest)localObject);
      ((Map)y.ynF).put(str, Boolean.TRUE);
      com.tencent.e.h.LTJ.b((Runnable)new y.f(str, (ScanGoodsRequest)localObject), 10000L, "ScanResourceTag");
    }
    dMq();
    AppMethodBeat.o(52315);
  }
  
  public final void setBackgroundTransY(float paramFloat)
  {
    AppMethodBeat.i(52318);
    Object localObject = this.ywc;
    if (localObject != null) {
      ((View)localObject).setTranslationY(paramFloat);
    }
    localObject = this.ywb;
    if (localObject == null) {
      d.g.b.p.bcb("blurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.ywa;
    if (localObject == null) {
      d.g.b.p.bcb("previewImage");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.yvZ;
    if (localObject == null) {
      d.g.b.p.bcb("bottomBlurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    AppMethodBeat.o(52318);
  }
  
  public final void setMarkViewTransY(float paramFloat)
  {
    AppMethodBeat.i(52320);
    View localView = this.yvX;
    if (localView == null) {
      d.g.b.p.bcb("successMarkView");
    }
    localView.setTranslationY(paramFloat);
    AppMethodBeat.o(52320);
  }
  
  public final void setScanRequest(final ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(186372);
    super.setScanRequest((BaseScanRequest)paramScanGoodsRequest);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(186372);
      return;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      ad.w("MicroMsg.ScanGoodsMaskView", "alvinluo setScanRequest request is not valid and ignore");
      ac.e(paramScanGoodsRequest);
      AppMethodBeat.o(186372);
      return;
    }
    Object localObject = this.ywg;
    if (localObject == null) {
      d.g.b.p.bcb("customTipsContainer");
    }
    ((LinearLayout)localObject).setVisibility(0);
    setCustomTipsWording(paramScanGoodsRequest);
    localObject = y.ynG;
    this.ywl = y.a(paramScanGoodsRequest, (x)new q(this, paramScanGoodsRequest));
    if (paramScanGoodsRequest.yjQ)
    {
      paramScanGoodsRequest.yjQ = false;
      this.ywy = new Timer();
      this.ywx = ((TimerTask)new g(this));
      paramScanGoodsRequest = this.ywy;
      if (paramScanGoodsRequest != null)
      {
        paramScanGoodsRequest.schedule(this.ywx, 15000L);
        AppMethodBeat.o(186372);
        return;
      }
    }
    AppMethodBeat.o(186372);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(186355);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = ScanGoodsMaskView.a(this.ywB).animate();
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
                  AppMethodBeat.o(186355);
                  return;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(186355);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(186356);
      super.onAnimationStart(paramAnimator);
      ScanGoodsMaskView.b(this.ywB);
      AppMethodBeat.o(186356);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(186354);
        super.onAnimationEnd(paramAnimator);
        paramAnimator = ScanGoodsMaskView.b(this.ywC.ywB);
        if (paramAnimator != null)
        {
          paramAnimator.dLD();
          AppMethodBeat.o(186354);
          return;
        }
        AppMethodBeat.o(186354);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(ScanGoodsMaskView.f paramf, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$initScanTipsImageAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class g
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(186359);
      com.tencent.e.h.LTJ.aP((Runnable)new a(this));
      AppMethodBeat.o(186359);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanGoodsMaskView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(186358);
        if ((ScanGoodsMaskView.g(this.ywJ.ywB)) && (ScanGoodsMaskView.z(this.ywJ.ywB).getVisibility() == 0)) {
          ScanGoodsMaskView.a(this.ywJ.ywB, h.eG((View)ScanGoodsMaskView.z(this.ywJ.ywB)));
        }
        AppMethodBeat.o(186358);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52296);
      bd.aI(this.ywB.getContext(), 2131762120);
      AppMethodBeat.o(52296);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52297);
      ScanGoodsMaskView.q(this.ywB);
      AppMethodBeat.o(52297);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/Bitmap;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class k<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    k(ScanGoodsRequest paramScanGoodsRequest) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "roundBitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class l
    extends q
    implements b<Bitmap, Boolean>
  {
    l(ScanGoodsMaskView paramScanGoodsMaskView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "invoke", "(Ljava/lang/Boolean;)Z"})
  static final class m
    extends q
    implements b<Boolean, Boolean>
  {
    m(ScanGoodsMaskView paramScanGoodsMaskView, ScanGoodsRequest paramScanGoodsRequest)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$onSetCustomBackgroundSuccess$4", "Lcom/tencent/mm/vending/pipeline/PipeableTerminal$Interrupt;", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "", "onInterrupt", "", "result", "plugin-scan_release"})
  public static final class n
    implements d.a<com.tencent.mm.vending.j.c<Boolean, String>>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Boolean;)V"})
  static final class o<T>
    implements d.b<Boolean>
  {
    o(ScanGoodsMaskView paramScanGoodsMaskView) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(186365);
      com.tencent.mm.plugin.scanner.ui.h localh = com.tencent.mm.plugin.scanner.ui.h.yul;
      if (com.tencent.mm.plugin.scanner.ui.h.a(paramBitmap, ScanGoodsMaskView.s(this.ywB), ScanGoodsMaskView.t(this.ywB), ScanGoodsMaskView.u(this.ywB)))
      {
        ScanGoodsMaskView.s(this.ywB).setVisibility(0);
        ScanGoodsMaskView.v(this.ywB);
        AppMethodBeat.o(186365);
        return;
      }
      ScanGoodsMaskView.w(this.ywB);
      AppMethodBeat.o(186365);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$setScanRequest$1", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "onLoadResult", "", "errCode", "", "errMsg", "", "plugin-scan_release"})
  public static final class q
    implements x
  {
    q(ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void bX(int paramInt, String paramString)
    {
      AppMethodBeat.i(186366);
      d.g.b.p.h(paramString, "errMsg");
      ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo loadResource onLoadResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
      if (paramInt == 0)
      {
        paramString = this.ywB;
        String str = paramScanGoodsRequest.yjL;
        d.g.b.p.g(str, "request.decorationImagePath");
        ScanGoodsMaskView.a(paramString, str);
      }
      AppMethodBeat.o(186366);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(ScanGoodsMaskView paramScanGoodsMaskView, TextureView paramTextureView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52301);
      ScanGoodsMaskView.p(this.ywB);
      long l = System.currentTimeMillis();
      final Bitmap localBitmap = paramView.getBitmap();
      ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.e.h.LTJ.aP((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52300);
          ScanGoodsMaskView.c(this.ywN.ywB, t.dKW());
          ScanGoodsMaskView.r(this.ywN.ywB);
          ScanGoodsMaskView.b(this.ywN.ywB, localBitmap);
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