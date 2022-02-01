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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.f;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.model.ab.f;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateShowPreviewImage", "", "animationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "customMaskView", "customSuccessView", "customTipsContainer", "Landroid/widget/LinearLayout;", "customTipsImage", "customTipsImageContainer", "customTipsWording", "Landroid/widget/TextView;", "enablePlaySound", "enableVibrate", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "pendingTasks", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "previewBitmap", "previewImage", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "resourceLoadRequestId", "", "scanTipsImageAnimation", "Landroid/support/animation/SpringAnimation;", "scanTipsImageAnimationTimer", "Ljava/util/Timer;", "scanTipsImageAnimationTimerTask", "Ljava/util/TimerTask;", "showCustomView", "showPreviewImage", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successDecorationView", "successDecorationViewSize", "successMarkView", "successMarkViewSize", "vibrator", "Landroid/os/Vibrator;", "viewHeight", "viewWidth", "addAnimationScanDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "animateCustomSuccessView", "center", "Landroid/graphics/PointF;", "animateHideBlurView", "animationEndCallback", "Lkotlin/Function0;", "animateScanDots", "start", "attachBackgroundView", "bitmap", "async", "cancelScanTipsImageAnimation", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "doUpdatePreview", "getBackgroundTransY", "", "getMarkViewHeight", "getMarkViewTransY", "getPreviewImageSize", "getRealPosition", "centerX", "centerY", "getRealPositionForImage", "init", "initScanTipsImageAnimation", "request", "isFromCapture", "isFromGallery", "onDialogDismissAnimationEnd", "onDialogDismissAnimationStart", "onDialogShowAnimationEnd", "onDialogShowAnimationStart", "dialogHeight", "startTransY", "endTransY", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPreviewReady", "isSwitchTab", "onScanSuccess", "data", "", "scanResultAnimationListener", "onSetCustomBackgroundSuccess", "onShowCustomViewFailed", "onTouchMoveBegin", "onTouchMoveEnd", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleBlurBitmap", "release", "runPendingTasks", "setBackgroundTransY", "translationY", "setCustomBackgroundBitmap", "setCustomTipsWording", "setMarkViewTransY", "setScanRequest", "showCustomBackground", "imagePath", "", "showLoadingView", "show", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "updateBlurBitmap", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updatePreviewImageAlpha", "updateSuccessViewVisibility", "vibrate", "Companion", "plugin-scan_release"})
public final class ScanGoodsMaskView
  extends BaseScanMaskView<ScanGoodsRequest>
  implements com.tencent.mm.plugin.scanner.box.d, f
{
  public static final ScanGoodsMaskView.a CQs;
  private Bitmap BQT;
  public ScanAnimationDotsView CPO;
  private View CPP;
  private ImageView CPQ;
  private ImageView CPR;
  private ImageView CPS;
  private ImageView CPT;
  private View CPU;
  private boolean CPV;
  private ImageView CPW;
  private ImageView CPX;
  private LinearLayout CPY;
  private LinearLayout CPZ;
  private ImageView CQa;
  private TextView CQb;
  private ArrayList<Runnable> CQc;
  private long CQd;
  private int CQe;
  private int CQf;
  private boolean CQg;
  public boolean CQh;
  public boolean CQi;
  private Bitmap CQj;
  private com.tencent.mm.plugin.scanner.view.d CQk;
  private LinearInterpolator CQl;
  private DecelerateInterpolator CQm;
  private boolean CQn;
  private boolean CQo;
  private TimerTask CQp;
  private Timer CQq;
  private android.support.a.d CQr;
  private int gRD;
  private int gRE;
  private com.tencent.mm.ui.base.q gut;
  private View maskView;
  private Vibrator paT;
  
  static
  {
    AppMethodBeat.i(52328);
    CQs = new ScanGoodsMaskView.a((byte)0);
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
    this.CQc = new ArrayList();
    this.CQe = getResources().getDimensionPixelSize(2131166894);
    this.CQf = getResources().getDimensionPixelSize(2131166884);
    this.CQl = new LinearInterpolator();
    this.CQm = new DecelerateInterpolator();
    this.CQn = true;
    this.CQo = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495187, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131307229);
    p.g(localObject, "view.findViewById(R.id.scan_animation_dots_view)");
    this.CPO = ((ScanAnimationDotsView)localObject);
    localObject = paramAttributeSet.findViewById(2131307262);
    p.g(localObject, "view.findViewById(R.id.scan_success_dot_view)");
    this.CPP = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131306104);
    p.g(localObject, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
    this.CPR = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131306103);
    p.g(localObject, "view.findViewById(R.id.preview_blur_view)");
    this.CPT = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131304511);
    p.g(localObject, "view.findViewById(R.id.mask_view)");
    this.maskView = ((View)localObject);
    localObject = paramAttributeSet.findViewById(2131306110);
    p.g(localObject, "view.findViewById(R.id.preview_image)");
    this.CPS = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131299382);
    p.g(localObject, "view.findViewById(R.id.custom_mask_view)");
    this.CPW = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131299391);
    p.g(localObject, "view.findViewById(R.id.custom_success_view)");
    this.CPX = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131308749);
    p.g(localObject, "view.findViewById(R.id.success_decoration_view)");
    this.CPQ = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131299385);
    p.g(localObject, "view.findViewById(R.id.custom_scan_tips_container)");
    this.CPY = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(2131299387);
    p.g(localObject, "view.findViewById(R.id.c…can_tips_image_container)");
    this.CPZ = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(2131299386);
    p.g(localObject, "view.findViewById(R.id.custom_scan_tips_image)");
    this.CQa = ((ImageView)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131299388);
    p.g(paramAttributeSet, "view.findViewById(R.id.custom_scan_tips_wording)");
    this.CQb = ((TextView)paramAttributeSet);
    if (this.paT == null)
    {
      paramAttributeSet = paramContext.getSystemService("vibrator");
      if (paramAttributeSet != null) {
        this.paT = ((Vibrator)paramAttributeSet);
      }
    }
    localObject = this.CPY;
    if (localObject == null) {
      p.btv("customTipsContainer");
    }
    paramAttributeSet = this.CPY;
    if (paramAttributeSet == null) {
      p.btv("customTipsContainer");
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
  
  private final void ao(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(240610);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo setPreviewBitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      ((kotlin.g.a.a)new f(this, paramBitmap)).invoke();
    }
    AppMethodBeat.o(240610);
  }
  
  private final void eRr()
  {
    AppMethodBeat.i(52324);
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
    AppMethodBeat.o(52324);
  }
  
  private final void eRs()
  {
    AppMethodBeat.i(240618);
    try
    {
      Object localObject = this.CQr;
      if (localObject != null) {
        ((android.support.a.d)localObject).cancel();
      }
      localObject = this.CQp;
      if (localObject != null) {
        ((TimerTask)localObject).cancel();
      }
      localObject = this.CQq;
      if (localObject != null)
      {
        ((Timer)localObject).cancel();
        AppMethodBeat.o(240618);
        return;
      }
      AppMethodBeat.o(240618);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(240618);
    }
  }
  
  private final void eRt()
  {
    AppMethodBeat.i(240619);
    Log.e("MicroMsg.ScanGoodsMaskView", "alvinluo onShowCustomViewFailed");
    this.CPV = false;
    Object localObject = this.CPZ;
    if (localObject == null) {
      p.btv("customTipsImageContainer");
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.CPW;
    if (localObject == null) {
      p.btv("customMaskView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.CPW;
    if (localObject == null) {
      p.btv("customMaskView");
    }
    ((ImageView)localObject).setImageBitmap(null);
    if ((getRequest() instanceof ScanGoodsRequest))
    {
      localObject = getRequest();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
        AppMethodBeat.o(240619);
        throw ((Throwable)localObject);
      }
      af.f((ScanGoodsRequest)localObject);
    }
    AppMethodBeat.o(240619);
  }
  
  private final Point getPreviewImageSize()
  {
    AppMethodBeat.i(240611);
    Object localObject;
    if (this.CQj != null)
    {
      localObject = this.CQj;
      if (localObject == null) {
        p.hyc();
      }
      if (!((Bitmap)localObject).isRecycled()) {}
    }
    else
    {
      localObject = new Point(0, 0);
      AppMethodBeat.o(240611);
      return localObject;
    }
    float f;
    try
    {
      localObject = this.CQj;
      if (localObject == null) {
        p.hyc();
      }
      f = ((Bitmap)localObject).getWidth();
      localObject = this.CQj;
      if (localObject == null) {
        p.hyc();
      }
      f = f * 1.0F / ((Bitmap)localObject).getHeight();
      if (f < getMeasuredWidth() * 1.0F / getMeasuredHeight())
      {
        i = getMeasuredHeight();
        localObject = new Point((int)(f * i), i);
        AppMethodBeat.o(240611);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanGoodsMaskView", (Throwable)localException, "alvinluo getPreviewImageSize exception", new Object[0]);
      localPoint = new Point(0, 0);
      AppMethodBeat.o(240611);
      return localPoint;
    }
    int i = getMeasuredWidth();
    Point localPoint = new Point(i, (int)(i / f));
    AppMethodBeat.o(240611);
    return localPoint;
  }
  
  private final void setCustomBackgroundBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(240617);
    paramBitmap = (Runnable)new p(this, paramBitmap);
    if ((this.gRD != 0) && (this.gRE != 0))
    {
      paramBitmap.run();
      AppMethodBeat.o(240617);
      return;
    }
    this.CQc.add(paramBitmap);
    AppMethodBeat.o(240617);
  }
  
  private final void setCustomTipsWording(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(240616);
    Object localObject = (CharSequence)paramScanGoodsRequest.CAQ;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.CQb;
      if (localObject == null) {
        p.btv("customTipsWording");
      }
      ((TextView)localObject).setText((CharSequence)paramScanGoodsRequest.CAQ);
      AppMethodBeat.o(240616);
      return;
    }
    paramScanGoodsRequest = this.CQb;
    if (paramScanGoodsRequest == null) {
      p.btv("customTipsWording");
    }
    localObject = getContext();
    p.g(localObject, "context");
    paramScanGoodsRequest.setText((CharSequence)((Context)localObject).getResources().getString(2131764920));
    AppMethodBeat.o(240616);
  }
  
  private final void ub(boolean paramBoolean)
  {
    AppMethodBeat.i(52302);
    ScanAnimationDotsView localScanAnimationDotsView = this.CPO;
    if (localScanAnimationDotsView == null) {
      p.btv("animationDotsView");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localScanAnimationDotsView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localScanAnimationDotsView = this.CPO;
      if (localScanAnimationDotsView == null) {
        p.btv("animationDotsView");
      }
      localScanAnimationDotsView.startAnimation();
      AppMethodBeat.o(52302);
      return;
    }
    localScanAnimationDotsView = this.CPO;
    if (localScanAnimationDotsView == null) {
      p.btv("animationDotsView");
    }
    localScanAnimationDotsView.stopAnimation();
    AppMethodBeat.o(52302);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52311);
    super.a(paramAnimatorListener);
    eRs();
    m.a((View)this, 1.0F, 0.0F, 200L, paramAnimatorListener);
    AppMethodBeat.o(52311);
  }
  
  public final void ap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(240612);
    eRr();
    ImageView localImageView;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreview bitmap width: %d, height: %d, showPreviewImage: %b, animateShowPreviewImage: %b", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Boolean.valueOf(this.CQh), Boolean.valueOf(this.CQi) });
      this.CQj = paramBitmap;
      localImageView = this.CPS;
      if (localImageView == null) {
        p.btv("previewImage");
      }
      localImageView.setImageBitmap(paramBitmap);
      if (!this.CQh) {
        break label188;
      }
      localImageView = this.CPS;
      if (localImageView == null) {
        p.btv("previewImage");
      }
      localImageView.setVisibility(0);
      if (!this.CQi) {
        break label165;
      }
      localImageView = this.CPS;
      if (localImageView == null) {
        p.btv("previewImage");
      }
      localImageView.setAlpha(0.0F);
    }
    for (;;)
    {
      ao(paramBitmap);
      AppMethodBeat.o(240612);
      return;
      label165:
      localImageView = this.CPS;
      if (localImageView == null) {
        p.btv("previewImage");
      }
      localImageView.setAlpha(1.0F);
      continue;
      label188:
      localImageView = this.CPS;
      if (localImageView == null) {
        p.btv("previewImage");
      }
      localImageView.setVisibility(8);
    }
  }
  
  public final void b(Object paramObject, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(52313);
    p.h(paramObject, "data");
    Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo onScanSuccess");
    this.CQk = paramd;
    int i;
    label132:
    float f1;
    float f2;
    float f3;
    float f4;
    if ((paramObject instanceof z))
    {
      paramObject = (z)paramObject;
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView with animation");
      ub(false);
      Log.v("MicroMsg.ScanGoodsMaskView", "updateSuccessViewVisibility showCustomView: %b", new Object[] { Boolean.valueOf(this.CPV) });
      paramd = this.CPX;
      if (paramd == null) {
        p.btv("customSuccessView");
      }
      if (!this.CPV) {
        break label475;
      }
      i = 0;
      paramd.setVisibility(i);
      paramd = this.CPQ;
      if (paramd == null) {
        p.btv("successDecorationView");
      }
      if (!this.CPV) {
        break label482;
      }
      i = 0;
      paramd.setVisibility(i);
      eRs();
      f1 = paramObject.centerX;
      f2 = paramObject.centerY;
      if (getMScanSource() != 1) {
        break label489;
      }
      f3 = f1 * getMeasuredWidth();
      f4 = f2 * getMeasuredHeight();
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
      paramObject = new PointF(f3, f4);
      label236:
      paramd = this.CPP;
      if (paramd == null) {
        p.btv("successMarkView");
      }
      paramd.setVisibility(0);
      paramd.setPivotX(this.CQe / 2.0F);
      paramd.setPivotY(this.CQe / 2.0F);
      paramd.setTranslationX(paramObject.x - this.CQe / 2);
      paramd.setTranslationY(paramObject.y - this.CQe / 2);
      paramd.setScaleX(0.0F);
      paramd.setScaleY(0.0F);
      if (this.CPV) {
        break label599;
      }
      paramObject = this.CPP;
      if (paramObject == null) {
        p.btv("successMarkView");
      }
      h.a(paramObject, this.CQk);
    }
    for (;;)
    {
      paramObject = this.maskView;
      if (paramObject == null) {
        p.btv("maskView");
      }
      paramObject.setAlpha(0.0F);
      paramObject.setVisibility(0);
      paramObject = this.CPT;
      if (paramObject == null) {
        p.btv("blurView");
      }
      paramObject.setVisibility(8);
      uf(false);
      paramObject = getScanTips();
      if (paramObject != null) {
        paramObject.setAlpha(1.0F);
      }
      if (this.CQn) {
        com.tencent.f.h.RTc.aX((Runnable)new i(this));
      }
      if (this.CQo) {
        postDelayed((Runnable)new j(this), 100L);
      }
      AppMethodBeat.o(52313);
      return;
      label475:
      i = 8;
      break;
      label482:
      i = 8;
      break label132;
      label489:
      paramObject = getPreviewImageSize();
      i = (getMeasuredWidth() - paramObject.x) / 2;
      int j = (getMeasuredHeight() - paramObject.y) / 2;
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPositionForImage previewImageSize: %s, left: %d, top: %d", new Object[] { paramObject, Integer.valueOf(i), Integer.valueOf(j) });
      f3 = i;
      f4 = paramObject.x;
      float f5 = j;
      paramObject = new PointF(f1 * f4 + f3, f2 * paramObject.y + f5);
      break label236;
      label599:
      Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo animateCustomSuccessView");
      paramd = this.CPP;
      if (paramd == null) {
        p.btv("successMarkView");
      }
      h.eS(paramd);
      paramd = this.CPQ;
      if (paramd == null) {
        p.btv("successDecorationView");
      }
      paramd.setVisibility(0);
      paramd.setPivotX(this.CQf / 2.0F);
      paramd.setPivotY(this.CQf / 2.0F);
      paramd.setTranslationX(paramObject.x - this.CQf / 2);
      paramd.setTranslationY(paramObject.y - this.CQf / 2);
      paramd.setScaleX(0.5F);
      paramd.setScaleY(0.5F);
      paramd.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)new b(this)).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this)).start();
    }
  }
  
  public final void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(52314);
    if (paramBoolean)
    {
      com.tencent.mm.ui.base.q localq = this.gut;
      if (localq != null) {
        localq.dismiss();
      }
      this.gut = com.tencent.mm.ui.base.h.a(getContext(), getResources().getString(2131764953), true, paramOnCancelListener);
      AppMethodBeat.o(52314);
      return;
    }
    paramOnCancelListener = this.gut;
    if (paramOnCancelListener != null)
    {
      paramOnCancelListener.dismiss();
      AppMethodBeat.o(52314);
      return;
    }
    AppMethodBeat.o(52314);
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
        bool = this.CQg & true;
        f1 = (f1 - 0.5F) / 0.5F;
        localObject = this.CPT;
        if (localObject == null) {
          p.btv("blurView");
        }
        ((ImageView)localObject).setAlpha(this.CQm.getInterpolation(f1));
        localObject = this.CPP;
        if (localObject == null) {
          p.btv("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.CPS;
        if (localObject == null) {
          p.btv("previewImage");
        }
        localImageView = this.CPT;
        if (localImageView == null) {
          p.btv("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        localObject = this.maskView;
        if (localObject == null) {
          p.btv("maskView");
        }
        ((View)localObject).setAlpha(0.5F);
        label189:
        localObject = this.CPT;
        if (localObject == null) {
          p.btv("blurView");
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
      localObject = this.maskView;
      if (localObject == null) {
        p.btv("maskView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.CPT;
      if (localObject == null) {
        p.btv("blurView");
      }
      f1 = ((ImageView)localObject).getAlpha();
      localObject = this.CPP;
      if (localObject == null) {
        p.btv("successMarkView");
      }
      float f2 = ((View)localObject).getAlpha();
      localObject = this.maskView;
      if (localObject == null) {
        p.btv("maskView");
      }
      float f3 = ((View)localObject).getAlpha();
      localObject = this.CPS;
      if (localObject == null) {
        p.btv("previewImage");
      }
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, markView alpha: %s, maskView alpha: %s, previewImage alpha: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(((ImageView)localObject).getAlpha()) });
      AppMethodBeat.o(52323);
      return;
      if (paramInt == 2)
      {
        bool = this.CQg & true;
        localObject = this.CPT;
        if (localObject == null) {
          p.btv("blurView");
        }
        ((ImageView)localObject).setAlpha(this.CQm.getInterpolation(f1));
        localObject = this.CPP;
        if (localObject == null) {
          p.btv("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.CPS;
        if (localObject == null) {
          p.btv("previewImage");
        }
        localImageView = this.CPT;
        if (localImageView == null) {
          p.btv("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        break;
      }
      localObject = this.CPP;
      if (localObject == null) {
        p.btv("successMarkView");
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.CPS;
      if (localObject == null) {
        p.btv("previewImage");
      }
      ((ImageView)localObject).setAlpha(1.0F);
      bool = false;
      break;
      localObject = this.maskView;
      if (localObject == null) {
        p.btv("maskView");
      }
      ((View)localObject).setAlpha(Math.max(0.0F, Math.min(0.5F, 1.0F - f1)));
      if (this.CQh)
      {
        if (this.CQi)
        {
          f1 = Math.max(0.0F, Math.min(1.0F, (paramFloat2 - 0.5F) / 0.5F));
          localObject = this.CPS;
          if (localObject == null) {
            p.btv("previewImage");
          }
          ((ImageView)localObject).setAlpha(1.0F - f1);
          localObject = this.CPS;
          if (localObject == null) {
            p.btv("previewImage");
          }
          Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY previewImage.alpha: %f, targetFactor: %f", new Object[] { Float.valueOf(((ImageView)localObject).getAlpha()), Float.valueOf(f1) });
          bool = false;
          break label189;
        }
        localObject = this.CPS;
        if (localObject == null) {
          p.btv("previewImage");
        }
        ((ImageView)localObject).setAlpha(1.0F);
      }
      bool = false;
      break label189;
    }
  }
  
  public final void d(int paramInt, float paramFloat1, float paramFloat2) {}
  
  public final void ePg() {}
  
  public final void ePh() {}
  
  public final void ePi() {}
  
  public final void ePj() {}
  
  public final void ePk() {}
  
  public final void eRq()
  {
    AppMethodBeat.i(52310);
    super.eRq();
    AppMethodBeat.o(52310);
  }
  
  public final void eU(final View paramView)
  {
    int i = 1;
    AppMethodBeat.i(52309);
    this.CPU = paramView;
    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo attachBackgroundView source: %d", new Object[] { Integer.valueOf(getMScanSource()) });
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
        com.tencent.f.h.RTc.aX((Runnable)new r(this, paramView));
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
    View localView = this.CPU;
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
    float f = this.CQe;
    AppMethodBeat.o(52322);
    return f;
  }
  
  public final float getMarkViewTransY()
  {
    AppMethodBeat.i(52321);
    View localView = this.CPP;
    if (localView == null) {
      p.btv("successMarkView");
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(52321);
    return f;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240613);
    super.onMeasure(paramInt1, paramInt2);
    this.gRD = getMeasuredWidth();
    this.gRE = getMeasuredHeight();
    if ((this.gRD != 0) && (this.gRE != 0))
    {
      Iterator localIterator = ((Iterable)this.CQc).iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.CQc.clear();
    }
    AppMethodBeat.o(240613);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52315);
    super.release();
    Object localObject = this.CPO;
    if (localObject == null) {
      p.btv("animationDotsView");
    }
    ((ScanAnimationDotsView)localObject).release();
    localObject = ab.CGu;
    long l = this.CQd;
    localObject = (ScanGoodsRequest)ab.CGr.get(Long.valueOf(l));
    ab.CGr.remove(Long.valueOf(l));
    ab.hdu.remove(Long.valueOf(l));
    if (localObject != null)
    {
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestId: %s", new Object[] { Long.valueOf(l) });
      String str = ab.c((ScanGoodsRequest)localObject);
      ((Map)ab.CGt).put(str, Boolean.TRUE);
      com.tencent.f.h.RTc.b((Runnable)new ab.f(str, (ScanGoodsRequest)localObject), 10000L, "ScanResourceTag");
    }
    eRs();
    AppMethodBeat.o(52315);
  }
  
  public final void setBackgroundTransY(float paramFloat)
  {
    AppMethodBeat.i(52318);
    Object localObject = this.CPU;
    if (localObject != null) {
      ((View)localObject).setTranslationY(paramFloat);
    }
    localObject = this.CPT;
    if (localObject == null) {
      p.btv("blurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.CPS;
    if (localObject == null) {
      p.btv("previewImage");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.CPR;
    if (localObject == null) {
      p.btv("bottomBlurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    AppMethodBeat.o(52318);
  }
  
  public final void setMarkViewTransY(float paramFloat)
  {
    AppMethodBeat.i(52320);
    View localView = this.CPP;
    if (localView == null) {
      p.btv("successMarkView");
    }
    localView.setTranslationY(paramFloat);
    AppMethodBeat.o(52320);
  }
  
  public final void setScanRequest(final ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(240614);
    super.setScanRequest((BaseScanRequest)paramScanGoodsRequest);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(240614);
      return;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      Log.w("MicroMsg.ScanGoodsMaskView", "alvinluo setScanRequest request is not valid and ignore");
      af.e(paramScanGoodsRequest);
      AppMethodBeat.o(240614);
      return;
    }
    Object localObject = this.CPY;
    if (localObject == null) {
      p.btv("customTipsContainer");
    }
    ((LinearLayout)localObject).setVisibility(0);
    setCustomTipsWording(paramScanGoodsRequest);
    localObject = ab.CGu;
    this.CQd = ab.a(paramScanGoodsRequest, (aa)new q(this, paramScanGoodsRequest));
    if (paramScanGoodsRequest.CAS)
    {
      paramScanGoodsRequest.CAS = false;
      this.CQq = new Timer();
      this.CQp = ((TimerTask)new g(this));
      paramScanGoodsRequest = this.CQq;
      if (paramScanGoodsRequest != null)
      {
        paramScanGoodsRequest.schedule(this.CQp, 15000L);
        AppMethodBeat.o(240614);
        return;
      }
    }
    AppMethodBeat.o(240614);
  }
  
  public final void tY(final boolean paramBoolean)
  {
    AppMethodBeat.i(52312);
    super.tY(paramBoolean);
    Object localObject1 = (kotlin.g.a.a)new h(this, paramBoolean);
    Object localObject2 = this.CPT;
    if (localObject2 == null) {
      p.btv("blurView");
    }
    if (((ImageView)localObject2).getVisibility() != 0)
    {
      localObject2 = this.CPS;
      if (localObject2 == null) {
        p.btv("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0)
      {
        localObject2 = this.CPR;
        if (localObject2 == null) {
          p.btv("bottomBlurView");
        }
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label256;
        }
      }
    }
    localObject2 = this.CPS;
    if (localObject2 == null) {
      p.btv("previewImage");
    }
    if (((ImageView)localObject2).getAlpha() == 1.0F)
    {
      localObject2 = this.CPS;
      if (localObject2 == null) {
        p.btv("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject2 = this.CPT;
      if (localObject2 == null) {
        p.btv("blurView");
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
      localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)this.CQl);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new ScanGoodsMaskView.d((kotlin.g.a.a)localObject1));
      if (localObject1 == null) {
        break;
      }
      ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this, paramBoolean));
      AppMethodBeat.o(52312);
      return;
    }
    AppMethodBeat.o(52312);
    return;
    label256:
    ((kotlin.g.a.a)localObject1).invoke();
    AppMethodBeat.o(52312);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240598);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = ScanGoodsMaskView.a(this.CQt).animate();
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
                  AppMethodBeat.o(240598);
                  return;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(240598);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(240599);
      super.onAnimationStart(paramAnimator);
      ScanGoodsMaskView.b(this.CQt);
      AppMethodBeat.o(240599);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(240597);
        super.onAnimationEnd(paramAnimator);
        paramAnimator = ScanGoodsMaskView.b(this.CQu.CQt);
        if (paramAnimator != null)
        {
          paramAnimator.eQG();
          AppMethodBeat.o(240597);
          return;
        }
        AppMethodBeat.o(240597);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(240600);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(240600);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ScanGoodsMaskView.a(this.CQt).setRotation(360.0F - Math.abs(15.0F + -15.0F * f));
      ScanGoodsMaskView.a(this.CQt).setAlpha(f);
      ScanGoodsMaskView.c(this.CQt).setAlpha(1.0F - f);
      AppMethodBeat.o(240600);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52290);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ScanGoodsMaskView.d(this.CQt).setAlpha(0.5F - f * 0.5F);
      if (paramBoolean)
      {
        ScanGoodsMaskView.e(this.CQt).setAlpha(1.0F - f);
        ScanGoodsMaskView.f(this.CQt).setAlpha(1.0F - f);
      }
      if (ScanGoodsMaskView.g(this.CQt)) {
        ScanGoodsMaskView.c(this.CQt).setAlpha(f);
      }
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo animateBlurView alpha: %s, factor: %f", new Object[] { Float.valueOf(ScanGoodsMaskView.d(this.CQt).getAlpha()), Float.valueOf(f) });
      AppMethodBeat.o(52290);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(ScanGoodsMaskView.f paramf, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$initScanTipsImageAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class g
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(240602);
      com.tencent.f.h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(240602);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanGoodsMaskView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(240601);
        if ((ScanGoodsMaskView.g(this.CQB.CQt)) && (ScanGoodsMaskView.y(this.CQB.CQt).getVisibility() == 0)) {
          ScanGoodsMaskView.a(this.CQB.CQt, h.eT((View)ScanGoodsMaskView.y(this.CQB.CQt)));
        }
        AppMethodBeat.o(240601);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52296);
      PlaySound.play(this.CQt.getContext(), 2131764141);
      AppMethodBeat.o(52296);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52297);
      ScanGoodsMaskView.q(this.CQt);
      AppMethodBeat.o(52297);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Bitmap;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class k<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    k(ScanGoodsRequest paramScanGoodsRequest) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "invoke", "(Ljava/lang/Boolean;)Z"})
  static final class m
    extends kotlin.g.b.q
    implements b<Boolean, Boolean>
  {
    m(ScanGoodsMaskView paramScanGoodsMaskView, ScanGoodsRequest paramScanGoodsRequest)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$onSetCustomBackgroundSuccess$4", "Lcom/tencent/mm/vending/pipeline/PipeableTerminal$Interrupt;", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "", "onInterrupt", "", "result", "plugin-scan_release"})
  public static final class n
    implements d.a<c<Boolean, String>>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Boolean;)V"})
  static final class o<T>
    implements d.b<Boolean>
  {
    o(ScanGoodsMaskView paramScanGoodsMaskView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(240608);
      m localm = m.CUv;
      if (m.a(paramBitmap, ScanGoodsMaskView.r(this.CQt), ScanGoodsMaskView.s(this.CQt), ScanGoodsMaskView.t(this.CQt)))
      {
        ScanGoodsMaskView.r(this.CQt).setVisibility(0);
        ScanGoodsMaskView.u(this.CQt);
        AppMethodBeat.o(240608);
        return;
      }
      ScanGoodsMaskView.v(this.CQt);
      AppMethodBeat.o(240608);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$setScanRequest$1", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "onLoadResult", "", "errCode", "", "errMsg", "", "plugin-scan_release"})
  public static final class q
    implements aa
  {
    q(ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void cn(int paramInt, String paramString)
    {
      AppMethodBeat.i(240609);
      p.h(paramString, "errMsg");
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo loadResource onLoadResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
      if (paramInt == 0)
      {
        paramString = this.CQt;
        String str = paramScanGoodsRequest.CAN;
        p.g(str, "request.decorationImagePath");
        ScanGoodsMaskView.a(paramString, str);
      }
      AppMethodBeat.o(240609);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(ScanGoodsMaskView paramScanGoodsMaskView, TextureView paramTextureView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52301);
      try
      {
        ScanGoodsMaskView.p(this.CQt);
        long l = System.currentTimeMillis();
        final Bitmap localBitmap = paramView.getBitmap();
        Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        com.tencent.f.h.RTc.aV((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52300);
            ScanGoodsMaskView.c(this.CQF.CQt, w.ePU());
            ScanGoodsMaskView.d(this.CQF.CQt, true);
            ScanGoodsMaskView.b(this.CQF.CQt, localBitmap);
            AppMethodBeat.o(52300);
          }
        });
        AppMethodBeat.o(52301);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ScanGoodsMaskView", (Throwable)localException, "alvinluo updatePreviewBitmap exception", new Object[0]);
        AppMethodBeat.o(52301);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView
 * JD-Core Version:    0.7.0.1
 */