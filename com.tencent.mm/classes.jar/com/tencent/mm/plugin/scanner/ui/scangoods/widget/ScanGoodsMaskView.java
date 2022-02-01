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
import com.tencent.mm.plugin.scanner.box.f;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.model.z.f;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateShowPreviewImage", "", "animationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "customMaskView", "customSuccessView", "customTipsContainer", "Landroid/widget/LinearLayout;", "customTipsImage", "customTipsImageContainer", "customTipsWording", "Landroid/widget/TextView;", "enablePlaySound", "enableVibrate", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "pendingTasks", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "previewBitmap", "previewImage", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "resourceLoadRequestId", "", "scanTipsImageAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "scanTipsImageAnimationFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "scanTipsImageAnimationTimerTask", "Ljava/util/TimerTask;", "showCustomView", "showPreviewImage", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successDecorationView", "successDecorationViewSize", "successMarkView", "successMarkViewSize", "vibrator", "Landroid/os/Vibrator;", "viewHeight", "viewWidth", "addAnimationScanDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "animateCustomSuccessView", "center", "Landroid/graphics/PointF;", "animateHideBlurView", "animationEndCallback", "Lkotlin/Function0;", "animateScanDots", "start", "attachBackgroundView", "bitmap", "async", "cancelScanTipsImageAnimation", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "doUpdatePreview", "getBackgroundTransY", "", "getMarkViewHeight", "getMarkViewTransY", "getPreviewImageSize", "getRealPosition", "centerX", "centerY", "getRealPositionForImage", "init", "initScanTipsImageAnimation", "request", "isFromCapture", "isFromGallery", "onDialogDismissAnimationEnd", "onDialogDismissAnimationStart", "onDialogShowAnimationEnd", "onDialogShowAnimationStart", "dialogHeight", "startTransY", "endTransY", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPreviewReady", "isSwitchTab", "onScanSuccess", "data", "", "scanResultAnimationListener", "onSetCustomBackgroundSuccess", "onShowCustomViewFailed", "onTouchMoveBegin", "onTouchMoveEnd", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleBlurBitmap", "release", "runPendingTasks", "setBackgroundTransY", "translationY", "setCustomBackgroundBitmap", "setCustomTipsWording", "setMarkViewTransY", "setScanRequest", "showCustomBackground", "imagePath", "", "showLoadingView", "show", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "updateBlurBitmap", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updatePreviewImageAlpha", "updateSuccessViewVisibility", "vibrate", "Companion", "plugin-scan_release"})
public final class ScanGoodsMaskView
  extends BaseScanMaskView<ScanGoodsRequest>
  implements com.tencent.mm.plugin.scanner.box.d, f
{
  public static final ScanGoodsMaskView.a IVT;
  private Bitmap HNJ;
  private LinearLayout IVA;
  private LinearLayout IVB;
  private ImageView IVC;
  private TextView IVD;
  private ArrayList<Runnable> IVE;
  private long IVF;
  private int IVG;
  private int IVH;
  private boolean IVI;
  public boolean IVJ;
  public boolean IVK;
  private com.tencent.mm.plugin.scanner.view.d IVL;
  private LinearInterpolator IVM;
  private DecelerateInterpolator IVN;
  private boolean IVO;
  private boolean IVP;
  private TimerTask IVQ;
  private com.tencent.e.i.d<?> IVR;
  private androidx.d.a.d IVS;
  public ScanAnimationDotsView IVq;
  private View IVr;
  private ImageView IVs;
  private ImageView IVt;
  private ImageView IVu;
  private ImageView IVv;
  private View IVw;
  private boolean IVx;
  private ImageView IVy;
  private ImageView IVz;
  private s iYE;
  private int jBZ;
  private int jCa;
  private Bitmap krJ;
  private View maskView;
  private Vibrator rqC;
  
  static
  {
    AppMethodBeat.i(52328);
    IVT = new ScanGoodsMaskView.a((byte)0);
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
    this.IVE = new ArrayList();
    this.IVG = getResources().getDimensionPixelSize(l.d.ICh);
    this.IVH = getResources().getDimensionPixelSize(l.d.ICc);
    this.IVM = new LinearInterpolator();
    this.IVN = new DecelerateInterpolator();
    this.IVO = true;
    this.IVP = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(l.g.IDW, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(l.f.IDi);
    p.j(localObject, "view.findViewById(R.id.scan_animation_dots_view)");
    this.IVq = ((ScanAnimationDotsView)localObject);
    localObject = paramAttributeSet.findViewById(l.f.scan_success_dot_view);
    p.j(localObject, "view.findViewById(R.id.scan_success_dot_view)");
    this.IVr = ((View)localObject);
    localObject = paramAttributeSet.findViewById(l.f.ICQ);
    p.j(localObject, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
    this.IVt = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(l.f.ICP);
    p.j(localObject, "view.findViewById(R.id.preview_blur_view)");
    this.IVv = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(l.f.mask_view);
    p.j(localObject, "view.findViewById(R.id.mask_view)");
    this.maskView = ((View)localObject);
    localObject = paramAttributeSet.findViewById(l.f.ICR);
    p.j(localObject, "view.findViewById(R.id.preview_image)");
    this.IVu = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(l.f.ICz);
    p.j(localObject, "view.findViewById(R.id.custom_mask_view)");
    this.IVy = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(l.f.ICE);
    p.j(localObject, "view.findViewById(R.id.custom_success_view)");
    this.IVz = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(l.f.IDK);
    p.j(localObject, "view.findViewById(R.id.success_decoration_view)");
    this.IVs = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(l.f.ICA);
    p.j(localObject, "view.findViewById(R.id.custom_scan_tips_container)");
    this.IVA = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(l.f.ICC);
    p.j(localObject, "view.findViewById(R.id.c…can_tips_image_container)");
    this.IVB = ((LinearLayout)localObject);
    localObject = paramAttributeSet.findViewById(l.f.ICB);
    p.j(localObject, "view.findViewById(R.id.custom_scan_tips_image)");
    this.IVC = ((ImageView)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(l.f.ICD);
    p.j(paramAttributeSet, "view.findViewById(R.id.custom_scan_tips_wording)");
    this.IVD = ((TextView)paramAttributeSet);
    if (this.rqC == null)
    {
      paramAttributeSet = paramContext.getSystemService("vibrator");
      if (paramAttributeSet != null) {
        this.rqC = ((Vibrator)paramAttributeSet);
      }
    }
    localObject = this.IVA;
    if (localObject == null) {
      p.bGy("customTipsContainer");
    }
    paramAttributeSet = this.IVA;
    if (paramAttributeSet == null) {
      p.bGy("customTipsContainer");
    }
    paramAttributeSet = paramAttributeSet.getLayoutParams();
    if (paramAttributeSet != null) {
      if ((paramAttributeSet instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramAttributeSet).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(paramContext, 154) + getMBottomExtraHeight());
      }
    }
    for (paramContext = paramAttributeSet;; paramContext = null)
    {
      ((LinearLayout)localObject).setLayoutParams(paramContext);
      AppMethodBeat.o(52327);
      return;
    }
  }
  
  private final void al(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(216915);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo setPreviewBitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      ((kotlin.g.a.a)new f(this, paramBitmap)).invoke();
    }
    AppMethodBeat.o(216915);
  }
  
  private final void fEs()
  {
    AppMethodBeat.i(52324);
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
    AppMethodBeat.o(52324);
  }
  
  private final void fEt()
  {
    AppMethodBeat.i(216961);
    try
    {
      Object localObject = this.IVS;
      if (localObject != null) {
        ((androidx.d.a.d)localObject).cancel();
      }
      localObject = this.IVQ;
      if (localObject != null) {
        ((TimerTask)localObject).cancel();
      }
      localObject = this.IVR;
      if (localObject != null)
      {
        ((com.tencent.e.i.d)localObject).cancel(false);
        AppMethodBeat.o(216961);
        return;
      }
      AppMethodBeat.o(216961);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(216961);
    }
  }
  
  private final void fEu()
  {
    AppMethodBeat.i(216962);
    Log.e("MicroMsg.ScanGoodsMaskView", "alvinluo onShowCustomViewFailed");
    this.IVx = false;
    Object localObject = this.IVB;
    if (localObject == null) {
      p.bGy("customTipsImageContainer");
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.IVy;
    if (localObject == null) {
      p.bGy("customMaskView");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.IVy;
    if (localObject == null) {
      p.bGy("customMaskView");
    }
    ((ImageView)localObject).setImageBitmap(null);
    if ((getRequest() instanceof ScanGoodsRequest))
    {
      localObject = getRequest();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
        AppMethodBeat.o(216962);
        throw ((Throwable)localObject);
      }
      ad.f((ScanGoodsRequest)localObject);
    }
    AppMethodBeat.o(216962);
  }
  
  private final Point getPreviewImageSize()
  {
    AppMethodBeat.i(216917);
    Object localObject;
    if (this.krJ != null)
    {
      localObject = this.krJ;
      if (localObject == null) {
        p.iCn();
      }
      if (!((Bitmap)localObject).isRecycled()) {}
    }
    else
    {
      localObject = new Point(0, 0);
      AppMethodBeat.o(216917);
      return localObject;
    }
    float f;
    try
    {
      localObject = this.krJ;
      if (localObject == null) {
        p.iCn();
      }
      f = ((Bitmap)localObject).getWidth();
      localObject = this.krJ;
      if (localObject == null) {
        p.iCn();
      }
      f = f * 1.0F / ((Bitmap)localObject).getHeight();
      if (f < getMeasuredWidth() * 1.0F / getMeasuredHeight())
      {
        i = getMeasuredHeight();
        localObject = new Point((int)(f * i), i);
        AppMethodBeat.o(216917);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanGoodsMaskView", (Throwable)localException, "alvinluo getPreviewImageSize exception", new Object[0]);
      localPoint = new Point(0, 0);
      AppMethodBeat.o(216917);
      return localPoint;
    }
    int i = getMeasuredWidth();
    Point localPoint = new Point(i, (int)(i / f));
    AppMethodBeat.o(216917);
    return localPoint;
  }
  
  private final void setCustomBackgroundBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(216959);
    paramBitmap = (Runnable)new p(this, paramBitmap);
    if ((this.jBZ != 0) && (this.jCa != 0))
    {
      paramBitmap.run();
      AppMethodBeat.o(216959);
      return;
    }
    this.IVE.add(paramBitmap);
    AppMethodBeat.o(216959);
  }
  
  private final void setCustomTipsWording(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(216958);
    Object localObject = (CharSequence)paramScanGoodsRequest.IGv;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = this.IVD;
      if (localObject == null) {
        p.bGy("customTipsWording");
      }
      ((TextView)localObject).setText((CharSequence)paramScanGoodsRequest.IGv);
      AppMethodBeat.o(216958);
      return;
    }
    paramScanGoodsRequest = this.IVD;
    if (paramScanGoodsRequest == null) {
      p.bGy("customTipsWording");
    }
    localObject = getContext();
    p.j(localObject, "context");
    paramScanGoodsRequest.setText((CharSequence)((Context)localObject).getResources().getString(l.i.IER));
    AppMethodBeat.o(216958);
  }
  
  private final void xz(boolean paramBoolean)
  {
    AppMethodBeat.i(52302);
    ScanAnimationDotsView localScanAnimationDotsView = this.IVq;
    if (localScanAnimationDotsView == null) {
      p.bGy("animationDotsView");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localScanAnimationDotsView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localScanAnimationDotsView = this.IVq;
      if (localScanAnimationDotsView == null) {
        p.bGy("animationDotsView");
      }
      localScanAnimationDotsView.startAnimation();
      AppMethodBeat.o(52302);
      return;
    }
    localScanAnimationDotsView = this.IVq;
    if (localScanAnimationDotsView == null) {
      p.bGy("animationDotsView");
    }
    localScanAnimationDotsView.stopAnimation();
    AppMethodBeat.o(52302);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52311);
    super.a(paramAnimatorListener);
    fEt();
    n.a((View)this, 1.0F, 0.0F, 200L, paramAnimatorListener);
    AppMethodBeat.o(52311);
  }
  
  public final void am(Bitmap paramBitmap)
  {
    AppMethodBeat.i(216935);
    fEs();
    ImageView localImageView;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreview bitmap width: %d, height: %d, showPreviewImage: %b, animateShowPreviewImage: %b", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Boolean.valueOf(this.IVJ), Boolean.valueOf(this.IVK) });
      this.krJ = paramBitmap;
      localImageView = this.IVu;
      if (localImageView == null) {
        p.bGy("previewImage");
      }
      localImageView.setImageBitmap(paramBitmap);
      if (!this.IVJ) {
        break label188;
      }
      localImageView = this.IVu;
      if (localImageView == null) {
        p.bGy("previewImage");
      }
      localImageView.setVisibility(0);
      if (!this.IVK) {
        break label165;
      }
      localImageView = this.IVu;
      if (localImageView == null) {
        p.bGy("previewImage");
      }
      localImageView.setAlpha(0.0F);
    }
    for (;;)
    {
      al(paramBitmap);
      AppMethodBeat.o(216935);
      return;
      label165:
      localImageView = this.IVu;
      if (localImageView == null) {
        p.bGy("previewImage");
      }
      localImageView.setAlpha(1.0F);
      continue;
      label188:
      localImageView = this.IVu;
      if (localImageView == null) {
        p.bGy("previewImage");
      }
      localImageView.setVisibility(8);
    }
  }
  
  public final void b(Object paramObject, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(52313);
    p.k(paramObject, "data");
    Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo onScanSuccess");
    this.IVL = paramd;
    int i;
    label132:
    float f1;
    float f2;
    float f3;
    float f4;
    if ((paramObject instanceof com.tencent.mm.plugin.scanner.model.x))
    {
      paramObject = (com.tencent.mm.plugin.scanner.model.x)paramObject;
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView with animation");
      xz(false);
      Log.v("MicroMsg.ScanGoodsMaskView", "updateSuccessViewVisibility showCustomView: %b", new Object[] { Boolean.valueOf(this.IVx) });
      paramd = this.IVz;
      if (paramd == null) {
        p.bGy("customSuccessView");
      }
      if (!this.IVx) {
        break label475;
      }
      i = 0;
      paramd.setVisibility(i);
      paramd = this.IVs;
      if (paramd == null) {
        p.bGy("successDecorationView");
      }
      if (!this.IVx) {
        break label482;
      }
      i = 0;
      paramd.setVisibility(i);
      fEt();
      f1 = paramObject.aGt;
      f2 = paramObject.aGu;
      if (getMScanSource() != 1) {
        break label489;
      }
      f3 = f1 * getMeasuredWidth();
      f4 = f2 * getMeasuredHeight();
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
      paramObject = new PointF(f3, f4);
      label236:
      paramd = this.IVr;
      if (paramd == null) {
        p.bGy("successMarkView");
      }
      paramd.setVisibility(0);
      paramd.setPivotX(this.IVG / 2.0F);
      paramd.setPivotY(this.IVG / 2.0F);
      paramd.setTranslationX(paramObject.x - this.IVG / 2);
      paramd.setTranslationY(paramObject.y - this.IVG / 2);
      paramd.setScaleX(0.0F);
      paramd.setScaleY(0.0F);
      if (this.IVx) {
        break label599;
      }
      paramObject = this.IVr;
      if (paramObject == null) {
        p.bGy("successMarkView");
      }
      h.a(paramObject, this.IVL);
    }
    for (;;)
    {
      paramObject = this.maskView;
      if (paramObject == null) {
        p.bGy("maskView");
      }
      paramObject.setAlpha(0.0F);
      paramObject.setVisibility(0);
      paramObject = this.IVv;
      if (paramObject == null) {
        p.bGy("blurView");
      }
      paramObject.setVisibility(8);
      xD(false);
      paramObject = getScanTips();
      if (paramObject != null) {
        paramObject.setAlpha(1.0F);
      }
      if (this.IVO) {
        com.tencent.e.h.ZvG.be((Runnable)new i(this));
      }
      if (this.IVP) {
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
      paramd = this.IVr;
      if (paramd == null) {
        p.bGy("successMarkView");
      }
      h.fW(paramd);
      paramd = this.IVs;
      if (paramd == null) {
        p.bGy("successDecorationView");
      }
      paramd.setVisibility(0);
      paramd.setPivotX(this.IVH / 2.0F);
      paramd.setPivotY(this.IVH / 2.0F);
      paramd.setTranslationX(paramObject.x - this.IVH / 2);
      paramd.setTranslationY(paramObject.y - this.IVH / 2);
      paramd.setScaleX(0.5F);
      paramd.setScaleY(0.5F);
      paramd.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)new b(this)).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanGoodsMaskView.c(this)).start();
    }
  }
  
  public final void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(52314);
    if (paramBoolean)
    {
      s locals = this.iYE;
      if (locals != null) {
        locals.dismiss();
      }
      this.iYE = com.tencent.mm.ui.base.h.a(getContext(), getResources().getString(l.i.IFc), true, paramOnCancelListener);
      AppMethodBeat.o(52314);
      return;
    }
    paramOnCancelListener = this.iYE;
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
        bool = this.IVI & true;
        f1 = (f1 - 0.5F) / 0.5F;
        localObject = this.IVv;
        if (localObject == null) {
          p.bGy("blurView");
        }
        ((ImageView)localObject).setAlpha(this.IVN.getInterpolation(f1));
        localObject = this.IVr;
        if (localObject == null) {
          p.bGy("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.IVu;
        if (localObject == null) {
          p.bGy("previewImage");
        }
        localImageView = this.IVv;
        if (localImageView == null) {
          p.bGy("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        localObject = this.maskView;
        if (localObject == null) {
          p.bGy("maskView");
        }
        ((View)localObject).setAlpha(0.5F);
        label189:
        localObject = this.IVv;
        if (localObject == null) {
          p.bGy("blurView");
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
        p.bGy("maskView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.IVv;
      if (localObject == null) {
        p.bGy("blurView");
      }
      f1 = ((ImageView)localObject).getAlpha();
      localObject = this.IVr;
      if (localObject == null) {
        p.bGy("successMarkView");
      }
      float f2 = ((View)localObject).getAlpha();
      localObject = this.maskView;
      if (localObject == null) {
        p.bGy("maskView");
      }
      float f3 = ((View)localObject).getAlpha();
      localObject = this.IVu;
      if (localObject == null) {
        p.bGy("previewImage");
      }
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, markView alpha: %s, maskView alpha: %s, previewImage alpha: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(((ImageView)localObject).getAlpha()) });
      AppMethodBeat.o(52323);
      return;
      if (paramInt == 2)
      {
        bool = this.IVI & true;
        localObject = this.IVv;
        if (localObject == null) {
          p.bGy("blurView");
        }
        ((ImageView)localObject).setAlpha(this.IVN.getInterpolation(f1));
        localObject = this.IVr;
        if (localObject == null) {
          p.bGy("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.IVu;
        if (localObject == null) {
          p.bGy("previewImage");
        }
        localImageView = this.IVv;
        if (localImageView == null) {
          p.bGy("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        break;
      }
      localObject = this.IVr;
      if (localObject == null) {
        p.bGy("successMarkView");
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.IVu;
      if (localObject == null) {
        p.bGy("previewImage");
      }
      ((ImageView)localObject).setAlpha(1.0F);
      bool = false;
      break;
      localObject = this.maskView;
      if (localObject == null) {
        p.bGy("maskView");
      }
      ((View)localObject).setAlpha(Math.max(0.0F, Math.min(0.5F, 1.0F - f1)));
      if (this.IVJ)
      {
        if (this.IVK)
        {
          f1 = Math.max(0.0F, Math.min(1.0F, (paramFloat2 - 0.5F) / 0.5F));
          localObject = this.IVu;
          if (localObject == null) {
            p.bGy("previewImage");
          }
          ((ImageView)localObject).setAlpha(1.0F - f1);
          localObject = this.IVu;
          if (localObject == null) {
            p.bGy("previewImage");
          }
          Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY previewImage.alpha: %f, targetFactor: %f", new Object[] { Float.valueOf(((ImageView)localObject).getAlpha()), Float.valueOf(f1) });
          bool = false;
          break label189;
        }
        localObject = this.IVu;
        if (localObject == null) {
          p.bGy("previewImage");
        }
        ((ImageView)localObject).setAlpha(1.0F);
      }
      bool = false;
      break label189;
    }
  }
  
  public final void d(int paramInt, float paramFloat1, float paramFloat2) {}
  
  public final void fCc() {}
  
  public final void fCd() {}
  
  public final void fCe() {}
  
  public final void fCf() {}
  
  public final void fCg() {}
  
  public final void fEr()
  {
    AppMethodBeat.i(52310);
    super.fEr();
    AppMethodBeat.o(52310);
  }
  
  public final void fY(final View paramView)
  {
    int i = 1;
    AppMethodBeat.i(52309);
    this.IVw = paramView;
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
        com.tencent.e.h.ZvG.be((Runnable)new r(this, paramView));
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
    View localView = this.IVw;
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
    float f = this.IVG;
    AppMethodBeat.o(52322);
    return f;
  }
  
  public final float getMarkViewTransY()
  {
    AppMethodBeat.i(52321);
    View localView = this.IVr;
    if (localView == null) {
      p.bGy("successMarkView");
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(52321);
    return f;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216952);
    super.onMeasure(paramInt1, paramInt2);
    this.jBZ = getMeasuredWidth();
    this.jCa = getMeasuredHeight();
    if ((this.jBZ != 0) && (this.jCa != 0))
    {
      Iterator localIterator = ((Iterable)this.IVE).iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.IVE.clear();
    }
    AppMethodBeat.o(216952);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52315);
    super.release();
    Object localObject = this.IVq;
    if (localObject == null) {
      p.bGy("animationDotsView");
    }
    ((ScanAnimationDotsView)localObject).release();
    localObject = z.ILG;
    long l = this.IVF;
    localObject = (ScanGoodsRequest)z.ILD.get(Long.valueOf(l));
    z.ILD.remove(Long.valueOf(l));
    z.jPb.remove(Long.valueOf(l));
    if (localObject != null)
    {
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestId: %s", new Object[] { Long.valueOf(l) });
      String str = z.c((ScanGoodsRequest)localObject);
      ((Map)z.ILF).put(str, Boolean.TRUE);
      com.tencent.e.h.ZvG.b((Runnable)new z.f(str, (ScanGoodsRequest)localObject), 10000L, "ScanResourceTag");
    }
    fEt();
    AppMethodBeat.o(52315);
  }
  
  public final void setBackgroundTransY(float paramFloat)
  {
    AppMethodBeat.i(52318);
    Object localObject = this.IVw;
    if (localObject != null) {
      ((View)localObject).setTranslationY(paramFloat);
    }
    localObject = this.IVv;
    if (localObject == null) {
      p.bGy("blurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.IVu;
    if (localObject == null) {
      p.bGy("previewImage");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.IVt;
    if (localObject == null) {
      p.bGy("bottomBlurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    AppMethodBeat.o(52318);
  }
  
  public final void setMarkViewTransY(float paramFloat)
  {
    AppMethodBeat.i(52320);
    View localView = this.IVr;
    if (localView == null) {
      p.bGy("successMarkView");
    }
    localView.setTranslationY(paramFloat);
    AppMethodBeat.o(52320);
  }
  
  public final void setScanRequest(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(216954);
    super.setScanRequest((BaseScanRequest)paramScanGoodsRequest);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(216954);
      return;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      Log.w("MicroMsg.ScanGoodsMaskView", "alvinluo setScanRequest request is not valid and ignore");
      ad.e(paramScanGoodsRequest);
      AppMethodBeat.o(216954);
      return;
    }
    Object localObject = this.IVA;
    if (localObject == null) {
      p.bGy("customTipsContainer");
    }
    ((LinearLayout)localObject).setVisibility(0);
    setCustomTipsWording(paramScanGoodsRequest);
    localObject = z.ILG;
    this.IVF = z.a(paramScanGoodsRequest, (y)new ScanGoodsMaskView.q(this, paramScanGoodsRequest));
    if (paramScanGoodsRequest.IGx)
    {
      paramScanGoodsRequest.IGx = false;
      this.IVQ = ((TimerTask)new g(this));
      paramScanGoodsRequest = com.tencent.e.h.ZvG;
      localObject = this.IVQ;
      if (localObject == null) {
        p.iCn();
      }
      this.IVR = paramScanGoodsRequest.o((Runnable)localObject, 15000L);
    }
    AppMethodBeat.o(216954);
  }
  
  public final void xw(final boolean paramBoolean)
  {
    AppMethodBeat.i(52312);
    super.xw(paramBoolean);
    Object localObject1 = (kotlin.g.a.a)new h(this, paramBoolean);
    Object localObject2 = this.IVv;
    if (localObject2 == null) {
      p.bGy("blurView");
    }
    if (((ImageView)localObject2).getVisibility() != 0)
    {
      localObject2 = this.IVu;
      if (localObject2 == null) {
        p.bGy("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0)
      {
        localObject2 = this.IVt;
        if (localObject2 == null) {
          p.bGy("bottomBlurView");
        }
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label256;
        }
      }
    }
    localObject2 = this.IVu;
    if (localObject2 == null) {
      p.bGy("previewImage");
    }
    if (((ImageView)localObject2).getAlpha() == 1.0F)
    {
      localObject2 = this.IVu;
      if (localObject2 == null) {
        p.bGy("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject2 = this.IVv;
      if (localObject2 == null) {
        p.bGy("blurView");
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
      localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)this.IVM);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new ScanGoodsMaskView.d((kotlin.g.a.a)localObject1));
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
    ((kotlin.g.a.a)localObject1).invoke();
    AppMethodBeat.o(52312);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(219587);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = ScanGoodsMaskView.a(this.IVU).animate();
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
                  AppMethodBeat.o(219587);
                  return;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(219587);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(219589);
      super.onAnimationStart(paramAnimator);
      ScanGoodsMaskView.b(this.IVU);
      AppMethodBeat.o(219589);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(218463);
        super.onAnimationEnd(paramAnimator);
        paramAnimator = ScanGoodsMaskView.b(this.IVV.IVU);
        if (paramAnimator != null)
        {
          paramAnimator.xs(false);
          AppMethodBeat.o(218463);
          return;
        }
        AppMethodBeat.o(218463);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    f(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(ScanGoodsMaskView.f paramf, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$initScanTipsImageAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class g
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(218371);
      com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      AppMethodBeat.o(218371);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanGoodsMaskView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(221176);
        if ((ScanGoodsMaskView.g(this.IWc.IVU)) && (ScanGoodsMaskView.y(this.IWc.IVU).getVisibility() == 0)) {
          ScanGoodsMaskView.a(this.IWc.IVU, h.fX((View)ScanGoodsMaskView.y(this.IWc.IVU)));
        }
        AppMethodBeat.o(221176);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    h(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52296);
      PlaySound.play(this.IVU.getContext(), l.i.qrcode_completed_2);
      AppMethodBeat.o(52296);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52297);
      ScanGoodsMaskView.q(this.IVU);
      AppMethodBeat.o(52297);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Boolean;)V"})
  static final class o<T>
    implements d.b<Boolean>
  {
    o(ScanGoodsMaskView paramScanGoodsMaskView) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(217555);
      n localn = n.IZP;
      if (n.a(paramBitmap, ScanGoodsMaskView.r(this.IVU), ScanGoodsMaskView.s(this.IVU), ScanGoodsMaskView.t(this.IVU)))
      {
        ScanGoodsMaskView.r(this.IVU).setVisibility(0);
        ScanGoodsMaskView.u(this.IVU);
        AppMethodBeat.o(217555);
        return;
      }
      ScanGoodsMaskView.v(this.IVU);
      AppMethodBeat.o(217555);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(ScanGoodsMaskView paramScanGoodsMaskView, TextureView paramTextureView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52301);
      try
      {
        ScanGoodsMaskView.p(this.IVU);
        long l = System.currentTimeMillis();
        final Bitmap localBitmap = paramView.getBitmap();
        Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52300);
            ScanGoodsMaskView.c(this.IWg.IVU, u.fCO());
            ScanGoodsMaskView.d(this.IWg.IVU, true);
            ScanGoodsMaskView.b(this.IWg.IVU, localBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView
 * JD-Core Version:    0.7.0.1
 */