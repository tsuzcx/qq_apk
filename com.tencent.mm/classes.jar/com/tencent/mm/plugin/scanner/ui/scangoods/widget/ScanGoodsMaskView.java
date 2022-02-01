package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.f;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.am;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.g;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateShowPreviewImage", "", "animationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "customMaskView", "customSuccessView", "customTipsContainer", "Landroid/widget/LinearLayout;", "customTipsImage", "customTipsImageContainer", "customTipsWording", "Landroid/widget/TextView;", "enablePlaySound", "enableVibrate", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "pendingTasks", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "previewBitmap", "previewImage", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "resourceLoadRequestId", "", "scanTipsImageAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "scanTipsImageAnimationFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "scanTipsImageAnimationTimerTask", "Ljava/util/TimerTask;", "showCustomView", "showPreviewImage", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successDecorationView", "successDecorationViewSize", "successMarkView", "successMarkViewSize", "vibrator", "Landroid/os/Vibrator;", "viewHeight", "viewWidth", "addAnimationScanDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "animateCustomSuccessView", "center", "Landroid/graphics/PointF;", "animateHideBlurView", "animationEndCallback", "Lkotlin/Function0;", "animateScanDots", "start", "attachBackgroundView", "bitmap", "async", "cancelScanTipsImageAnimation", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "doUpdatePreview", "getBackgroundTransY", "", "getMarkViewHeight", "getMarkViewTransY", "getPreviewImageSize", "getRealPosition", "centerX", "centerY", "getRealPositionForImage", "init", "initScanTipsImageAnimation", "request", "isFromCapture", "isFromGallery", "onDialogDismissAnimationEnd", "onDialogDismissAnimationStart", "onDialogShowAnimationEnd", "onDialogShowAnimationStart", "dialogHeight", "startTransY", "endTransY", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPreviewReady", "isSwitchTab", "onScanSuccess", "data", "", "scanResultAnimationListener", "onSetCustomBackgroundSuccess", "onShowCustomViewFailed", "onTouchMoveBegin", "onTouchMoveEnd", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleBlurBitmap", "release", "runPendingTasks", "setBackgroundTransY", "translationY", "setCustomBackgroundBitmap", "setCustomTipsWording", "setMarkViewTransY", "setScanRequest", "showCustomBackground", "imagePath", "", "showLoadingView", "show", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "updateBlurBitmap", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updatePreviewImageAlpha", "updateSuccessViewVisibility", "vibrate", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanGoodsMaskView
  extends BaseScanMaskView<ScanGoodsRequest>
  implements com.tencent.mm.plugin.scanner.box.d, f
{
  public static final ScanGoodsMaskView.a Pee;
  private Bitmap NKD;
  private com.tencent.mm.plugin.scanner.view.d PeA;
  private LinearInterpolator PeB;
  private DecelerateInterpolator PeC;
  private boolean PeD;
  private boolean PeE;
  private TimerTask PeF;
  private com.tencent.threadpool.i.d<?> PeG;
  private androidx.e.a.d PeH;
  public ScanAnimationDotsView Pef;
  private View Peg;
  private ImageView Peh;
  private ImageView Pei;
  private ImageView Pej;
  private ImageView Pek;
  private View Pel;
  private boolean Pem;
  private ImageView Pen;
  private ImageView Peo;
  private LinearLayout Pep;
  private LinearLayout Peq;
  private ImageView Per;
  private TextView Pes;
  private ArrayList<Runnable> Pet;
  private long Peu;
  private int Pev;
  private int Pew;
  private boolean Pex;
  private boolean Pey;
  private boolean Pez;
  private Bitmap mVG;
  private View maskView;
  private int mbM;
  private int mbN;
  private w psR;
  private Vibrator uAL;
  
  static
  {
    AppMethodBeat.i(52328);
    Pee = new ScanGoodsMaskView.a((byte)0);
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
    this.Pet = new ArrayList();
    this.Pev = getResources().getDimensionPixelSize(l.d.OIj);
    this.Pew = getResources().getDimensionPixelSize(l.d.OIe);
    this.PeB = new LinearInterpolator();
    this.PeC = new DecelerateInterpolator();
    this.PeD = true;
    this.PeE = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(l.g.OJZ, (ViewGroup)this, true);
    Object localObject1 = paramAttributeSet.findViewById(l.f.OJj);
    s.s(localObject1, "view.findViewById(R.id.scan_animation_dots_view)");
    this.Pef = ((ScanAnimationDotsView)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.scan_success_dot_view);
    s.s(localObject1, "view.findViewById(R.id.scan_success_dot_view)");
    this.Peg = ((View)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OIR);
    s.s(localObject1, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
    this.Pei = ((ImageView)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OIQ);
    s.s(localObject1, "view.findViewById(R.id.preview_blur_view)");
    this.Pek = ((ImageView)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.mask_view);
    s.s(localObject1, "view.findViewById(R.id.mask_view)");
    this.maskView = ((View)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OIS);
    s.s(localObject1, "view.findViewById(R.id.preview_image)");
    this.Pej = ((ImageView)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OIA);
    s.s(localObject1, "view.findViewById(R.id.custom_mask_view)");
    this.Pen = ((ImageView)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OIF);
    s.s(localObject1, "view.findViewById(R.id.custom_success_view)");
    this.Peo = ((ImageView)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OJM);
    s.s(localObject1, "view.findViewById(R.id.success_decoration_view)");
    this.Peh = ((ImageView)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OIB);
    s.s(localObject1, "view.findViewById(R.id.custom_scan_tips_container)");
    this.Pep = ((LinearLayout)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OID);
    s.s(localObject1, "view.findViewById(R.id.c…can_tips_image_container)");
    this.Peq = ((LinearLayout)localObject1);
    localObject1 = paramAttributeSet.findViewById(l.f.OIC);
    s.s(localObject1, "view.findViewById(R.id.custom_scan_tips_image)");
    this.Per = ((ImageView)localObject1);
    paramAttributeSet = paramAttributeSet.findViewById(l.f.OIE);
    s.s(paramAttributeSet, "view.findViewById(R.id.custom_scan_tips_wording)");
    this.Pes = ((TextView)paramAttributeSet);
    if (this.uAL == null)
    {
      paramAttributeSet = paramContext.getSystemService("vibrator");
      if (paramAttributeSet != null) {
        this.uAL = ((Vibrator)paramAttributeSet);
      }
    }
    paramAttributeSet = this.Pep;
    if (paramAttributeSet == null)
    {
      s.bIx("customTipsContainer");
      paramAttributeSet = null;
      LinearLayout localLinearLayout = this.Pep;
      localObject1 = localLinearLayout;
      if (localLinearLayout == null)
      {
        s.bIx("customTipsContainer");
        localObject1 = null;
      }
      localObject1 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject1 != null) {
        break label537;
      }
    }
    for (paramContext = localObject2;; paramContext = (Context)localObject1)
    {
      paramAttributeSet.setLayoutParams(paramContext);
      AppMethodBeat.o(52327);
      return;
      break;
      label537:
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(paramContext, 154) + getMBottomExtraHeight());
      }
      paramContext = ah.aiuX;
    }
  }
  
  private final void Cn(boolean paramBoolean)
  {
    ScanAnimationDotsView localScanAnimationDotsView2 = null;
    AppMethodBeat.i(52302);
    ScanAnimationDotsView localScanAnimationDotsView1 = this.Pef;
    if (localScanAnimationDotsView1 == null)
    {
      s.bIx("animationDotsView");
      localScanAnimationDotsView1 = null;
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = 8)
    {
      localScanAnimationDotsView1.setVisibility(i);
      if (!paramBoolean) {
        break label83;
      }
      localScanAnimationDotsView2 = this.Pef;
      localScanAnimationDotsView1 = localScanAnimationDotsView2;
      if (localScanAnimationDotsView2 == null)
      {
        s.bIx("animationDotsView");
        localScanAnimationDotsView1 = null;
      }
      localScanAnimationDotsView1.startAnimation();
      AppMethodBeat.o(52302);
      return;
      break;
    }
    label83:
    localScanAnimationDotsView1 = this.Pef;
    if (localScanAnimationDotsView1 == null)
    {
      s.bIx("animationDotsView");
      localScanAnimationDotsView1 = localScanAnimationDotsView2;
    }
    for (;;)
    {
      localScanAnimationDotsView1.stopAnimation();
      AppMethodBeat.o(52302);
      return;
    }
  }
  
  private static final Bitmap a(ScanGoodsRequest paramScanGoodsRequest, Void paramVoid)
  {
    AppMethodBeat.i(314699);
    s.u(paramScanGoodsRequest, "$req");
    paramVoid = ag.OSF;
    paramScanGoodsRequest = ag.aUJ(paramScanGoodsRequest.OMC);
    if ((paramScanGoodsRequest != null) && (!paramScanGoodsRequest.isRecycled()))
    {
      Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo showCustomTipsImage getRoundBitmap");
      paramVoid = p.PjH;
      paramScanGoodsRequest = p.aD(paramScanGoodsRequest);
      AppMethodBeat.o(314699);
      return paramScanGoodsRequest;
    }
    g.jJL().gM(g.T(Boolean.FALSE, "tipsImage getResource failed"));
    AppMethodBeat.o(314699);
    return null;
  }
  
  private static final void a(Bitmap paramBitmap, ScanGoodsMaskView paramScanGoodsMaskView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(314696);
    s.u(paramScanGoodsMaskView, "this$0");
    Object localObject1 = p.PjH;
    ImageView localImageView = paramScanGoodsMaskView.Pen;
    localObject1 = localImageView;
    if (localImageView == null)
    {
      s.bIx("customMaskView");
      localObject1 = null;
    }
    if (p.a(paramBitmap, (ImageView)localObject1, paramScanGoodsMaskView.mbM, paramScanGoodsMaskView.mbN))
    {
      paramBitmap = paramScanGoodsMaskView.Pen;
      if (paramBitmap == null)
      {
        s.bIx("customMaskView");
        paramBitmap = localObject2;
      }
      for (;;)
      {
        paramBitmap.setVisibility(0);
        if (!(paramScanGoodsMaskView.getRequest() instanceof ScanGoodsRequest)) {
          break label224;
        }
        paramBitmap = paramScanGoodsMaskView.getRequest();
        if (paramBitmap != null) {
          break;
        }
        paramBitmap = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
        AppMethodBeat.o(314696);
        throw paramBitmap;
      }
      paramBitmap = (ScanGoodsRequest)paramBitmap;
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo onSetCustomBackgroundSuccess");
      localObject1 = g.jJU().e(new ScanGoodsMaskView..ExternalSyntheticLambda2(paramBitmap)).NM(true);
      s.s(localObject1, "pipeline().`$heavyWork` …           }.serial(true)");
      com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.b((c)localObject1, (kotlin.g.a.b)new ScanGoodsMaskView.g(paramScanGoodsMaskView)), (kotlin.g.a.b)new ScanGoodsMaskView.h(paramBitmap, paramScanGoodsMaskView)).a((d.a)new ScanGoodsMaskView.i(paramScanGoodsMaskView)).a(new ScanGoodsMaskView..ExternalSyntheticLambda3(paramScanGoodsMaskView));
      label224:
      AppMethodBeat.o(314696);
      return;
    }
    paramScanGoodsMaskView.gTh();
    AppMethodBeat.o(314696);
  }
  
  private static final void a(ScanGoodsMaskView paramScanGoodsMaskView)
  {
    AppMethodBeat.i(314682);
    s.u(paramScanGoodsMaskView, "this$0");
    PlaySound.play(paramScanGoodsMaskView.getContext(), l.i.qrcode_completed_2);
    AppMethodBeat.o(314682);
  }
  
  private static final void a(ScanGoodsMaskView paramScanGoodsMaskView, ValueAnimator paramValueAnimator)
  {
    Object localObject = null;
    AppMethodBeat.i(314673);
    s.u(paramScanGoodsMaskView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanGoodsMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314673);
      throw paramScanGoodsMaskView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    ImageView localImageView = paramScanGoodsMaskView.Peh;
    paramValueAnimator = localImageView;
    if (localImageView == null)
    {
      s.bIx("successDecorationView");
      paramValueAnimator = null;
    }
    paramValueAnimator.setRotation(360.0F - Math.abs(-15.0F * f + 15.0F));
    localImageView = paramScanGoodsMaskView.Peh;
    paramValueAnimator = localImageView;
    if (localImageView == null)
    {
      s.bIx("successDecorationView");
      paramValueAnimator = null;
    }
    paramValueAnimator.setAlpha(f);
    paramScanGoodsMaskView = paramScanGoodsMaskView.Pep;
    if (paramScanGoodsMaskView == null)
    {
      s.bIx("customTipsContainer");
      paramScanGoodsMaskView = localObject;
    }
    for (;;)
    {
      paramScanGoodsMaskView.setAlpha(1.0F - f);
      AppMethodBeat.o(314673);
      return;
    }
  }
  
  private static final void a(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(314687);
    s.u(paramScanGoodsMaskView, "this$0");
    paramScanGoodsMaskView.Pey = ab.gQV();
    paramScanGoodsMaskView.Pez = true;
    paramScanGoodsMaskView.aA(paramBitmap);
    AppMethodBeat.o(314687);
  }
  
  private static final void a(ScanGoodsMaskView paramScanGoodsMaskView, TextureView paramTextureView)
  {
    AppMethodBeat.i(314691);
    s.u(paramScanGoodsMaskView, "this$0");
    s.u(paramTextureView, "$textureView");
    try
    {
      paramScanGoodsMaskView.gTf();
      long l = System.currentTimeMillis();
      paramTextureView = paramTextureView.getBitmap();
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.threadpool.h.ahAA.bk(new ScanGoodsMaskView..ExternalSyntheticLambda7(paramScanGoodsMaskView, paramTextureView));
      AppMethodBeat.o(314691);
      return;
    }
    catch (Exception paramScanGoodsMaskView)
    {
      Log.printErrStackTrace("MicroMsg.ScanGoodsMaskView", (Throwable)paramScanGoodsMaskView, "alvinluo updatePreviewBitmap exception", new Object[0]);
      AppMethodBeat.o(314691);
    }
  }
  
  private static final void a(ScanGoodsMaskView paramScanGoodsMaskView, Boolean paramBoolean)
  {
    AppMethodBeat.i(314704);
    s.u(paramScanGoodsMaskView, "this$0");
    Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo showCustomView finish result: %b", new Object[] { paramBoolean });
    paramScanGoodsMaskView.Pem = true;
    Object localObject = paramScanGoodsMaskView.Peq;
    paramBoolean = (Boolean)localObject;
    if (localObject == null)
    {
      s.bIx("customTipsImageContainer");
      paramBoolean = null;
    }
    paramBoolean.setVisibility(0);
    localObject = paramScanGoodsMaskView.Pen;
    paramBoolean = (Boolean)localObject;
    if (localObject == null)
    {
      s.bIx("customMaskView");
      paramBoolean = null;
    }
    paramBoolean.setVisibility(0);
    paramScanGoodsMaskView.Pev = paramScanGoodsMaskView.getResources().getDimensionPixelSize(l.d.OIf);
    localObject = paramScanGoodsMaskView.Peg;
    paramBoolean = (Boolean)localObject;
    if (localObject == null)
    {
      s.bIx("successMarkView");
      paramBoolean = null;
    }
    paramBoolean.setVisibility(8);
    localObject = paramScanGoodsMaskView.Peo;
    paramBoolean = (Boolean)localObject;
    if (localObject == null)
    {
      s.bIx("customSuccessView");
      paramBoolean = null;
    }
    paramScanGoodsMaskView.Peg = ((View)paramBoolean);
    AppMethodBeat.o(314704);
  }
  
  private static final void a(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean1, boolean paramBoolean2, ValueAnimator paramValueAnimator)
  {
    Object localObject1 = null;
    AppMethodBeat.i(314678);
    s.u(paramScanGoodsMaskView, "this$0");
    if (paramValueAnimator == null)
    {
      AppMethodBeat.o(314678);
      return;
    }
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanGoodsMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314678);
      throw paramScanGoodsMaskView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    Object localObject2 = paramScanGoodsMaskView.maskView;
    paramValueAnimator = (ValueAnimator)localObject2;
    if (localObject2 == null)
    {
      s.bIx("maskView");
      paramValueAnimator = null;
    }
    paramValueAnimator.setAlpha(0.5F - f * 0.5F);
    if (paramBoolean1)
    {
      localObject2 = paramScanGoodsMaskView.Pej;
      paramValueAnimator = (ValueAnimator)localObject2;
      if (localObject2 == null)
      {
        s.bIx("previewImage");
        paramValueAnimator = null;
      }
      paramValueAnimator.setAlpha(1.0F - f);
    }
    if (paramBoolean2)
    {
      localObject2 = paramScanGoodsMaskView.Pei;
      paramValueAnimator = (ValueAnimator)localObject2;
      if (localObject2 == null)
      {
        s.bIx("bottomBlurView");
        paramValueAnimator = null;
      }
      paramValueAnimator.setAlpha(1.0F - f);
    }
    if (paramScanGoodsMaskView.Pem)
    {
      localObject2 = paramScanGoodsMaskView.Pep;
      paramValueAnimator = (ValueAnimator)localObject2;
      if (localObject2 == null)
      {
        s.bIx("customTipsContainer");
        paramValueAnimator = null;
      }
      paramValueAnimator.setAlpha(f);
    }
    paramScanGoodsMaskView = paramScanGoodsMaskView.maskView;
    if (paramScanGoodsMaskView == null)
    {
      s.bIx("maskView");
      paramScanGoodsMaskView = localObject1;
    }
    for (;;)
    {
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo animateBlurView alpha: %s, factor: %f", new Object[] { Float.valueOf(paramScanGoodsMaskView.getAlpha()), Float.valueOf(f) });
      AppMethodBeat.o(314678);
      return;
    }
  }
  
  private final void aA(Bitmap paramBitmap)
  {
    Object localObject3 = null;
    ImageView localImageView1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(314645);
    gTf();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreview bitmap width: %d, height: %d, showPreviewImage: %b, animateShowPreviewImage: %b", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Boolean.valueOf(this.Pey), Boolean.valueOf(this.Pez) });
      this.mVG = paramBitmap;
      ImageView localImageView2 = this.Pej;
      localObject1 = localImageView2;
      if (localImageView2 == null)
      {
        s.bIx("previewImage");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageBitmap(paramBitmap);
      if (!this.Pey) {
        break label221;
      }
      localImageView1 = this.Pej;
      localObject1 = localImageView1;
      if (localImageView1 == null)
      {
        s.bIx("previewImage");
        localObject1 = null;
      }
      ((ImageView)localObject1).setVisibility(0);
      if (!this.Pez) {
        break label192;
      }
      localObject1 = this.Pej;
      if (localObject1 != null) {
        break label189;
      }
      s.bIx("previewImage");
      localObject1 = localObject2;
    }
    label189:
    for (;;)
    {
      ((ImageView)localObject1).setAlpha(0.0F);
      ay(paramBitmap);
      AppMethodBeat.o(314645);
      return;
    }
    label192:
    Object localObject1 = this.Pej;
    if (localObject1 == null)
    {
      s.bIx("previewImage");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((ImageView)localObject1).setAlpha(1.0F);
      break;
    }
    label221:
    localObject1 = this.Pej;
    if (localObject1 == null)
    {
      s.bIx("previewImage");
      localObject1 = localImageView1;
    }
    for (;;)
    {
      ((ImageView)localObject1).setVisibility(8);
      break;
    }
  }
  
  private final void ay(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(314631);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo setPreviewBitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      ((kotlin.g.a.a)new d(this, paramBitmap)).invoke();
    }
    AppMethodBeat.o(314631);
  }
  
  private static final void b(ScanGoodsMaskView paramScanGoodsMaskView)
  {
    AppMethodBeat.i(314684);
    s.u(paramScanGoodsMaskView, "this$0");
    paramScanGoodsMaskView = paramScanGoodsMaskView.uAL;
    if (paramScanGoodsMaskView != null) {
      paramScanGoodsMaskView.vibrate(10L);
    }
    AppMethodBeat.o(314684);
  }
  
  private final void gTf()
  {
    AppMethodBeat.i(52324);
    if (this.NKD != null)
    {
      Bitmap localBitmap = this.NKD;
      s.checkNotNull(localBitmap);
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.NKD;
        s.checkNotNull(localBitmap);
        localBitmap.recycle();
        this.NKD = null;
      }
    }
    AppMethodBeat.o(52324);
  }
  
  private final void gTg()
  {
    AppMethodBeat.i(314663);
    try
    {
      Object localObject = this.PeH;
      if (localObject != null) {
        ((androidx.e.a.d)localObject).cancel();
      }
      localObject = this.PeF;
      if (localObject != null) {
        ((TimerTask)localObject).cancel();
      }
      localObject = this.PeG;
      if (localObject != null)
      {
        ((com.tencent.threadpool.i.d)localObject).cancel(false);
        AppMethodBeat.o(314663);
        return;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(314663);
    }
  }
  
  private final void gTh()
  {
    AppMethodBeat.i(314666);
    Log.e("MicroMsg.ScanGoodsMaskView", "alvinluo onShowCustomViewFailed");
    this.Pem = false;
    Object localObject2 = this.Peq;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("customTipsImageContainer");
      localObject1 = null;
    }
    ((LinearLayout)localObject1).setVisibility(8);
    localObject2 = this.Pen;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("customMaskView");
      localObject1 = null;
    }
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = this.Pen;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("customMaskView");
      localObject1 = null;
    }
    ((ImageView)localObject1).setImageBitmap(null);
    if ((getRequest() instanceof ScanGoodsRequest))
    {
      localObject1 = getRequest();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.api.ScanGoodsRequest");
        AppMethodBeat.o(314666);
        throw ((Throwable)localObject1);
      }
      am.e((ScanGoodsRequest)localObject1);
    }
    AppMethodBeat.o(314666);
  }
  
  private final Point getPreviewImageSize()
  {
    AppMethodBeat.i(314637);
    Object localObject;
    if (this.mVG != null)
    {
      localObject = this.mVG;
      s.checkNotNull(localObject);
      if (!((Bitmap)localObject).isRecycled()) {}
    }
    else
    {
      localObject = new Point(0, 0);
      AppMethodBeat.o(314637);
      return localObject;
    }
    float f;
    try
    {
      localObject = this.mVG;
      s.checkNotNull(localObject);
      f = ((Bitmap)localObject).getWidth();
      localObject = this.mVG;
      s.checkNotNull(localObject);
      f = f * 1.0F / ((Bitmap)localObject).getHeight();
      if (f < getMeasuredWidth() * 1.0F / getMeasuredHeight())
      {
        i = getMeasuredHeight();
        localObject = new Point((int)(f * i), i);
        AppMethodBeat.o(314637);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanGoodsMaskView", (Throwable)localException, "alvinluo getPreviewImageSize exception", new Object[0]);
      localPoint = new Point(0, 0);
      AppMethodBeat.o(314637);
      return localPoint;
    }
    int i = getMeasuredWidth();
    Point localPoint = new Point(i, (int)(i / f));
    AppMethodBeat.o(314637);
    return localPoint;
  }
  
  private final void setCustomBackgroundBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(314656);
    paramBitmap = new ScanGoodsMaskView..ExternalSyntheticLambda4(paramBitmap, this);
    if ((this.mbM != 0) && (this.mbN != 0))
    {
      paramBitmap.run();
      AppMethodBeat.o(314656);
      return;
    }
    this.Pet.add(paramBitmap);
    AppMethodBeat.o(314656);
  }
  
  private final void setCustomTipsWording(ScanGoodsRequest paramScanGoodsRequest)
  {
    TextView localTextView2 = null;
    TextView localTextView1 = null;
    AppMethodBeat.i(314652);
    CharSequence localCharSequence = (CharSequence)paramScanGoodsRequest.OMD;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label87;
      }
      localTextView2 = this.Pes;
      if (localTextView2 != null) {
        break label81;
      }
      s.bIx("customTipsWording");
    }
    for (;;)
    {
      localTextView1.setText((CharSequence)paramScanGoodsRequest.OMD);
      AppMethodBeat.o(314652);
      return;
      i = 0;
      break;
      label81:
      localTextView1 = localTextView2;
    }
    label87:
    paramScanGoodsRequest = this.Pes;
    if (paramScanGoodsRequest == null)
    {
      s.bIx("customTipsWording");
      paramScanGoodsRequest = localTextView2;
    }
    for (;;)
    {
      paramScanGoodsRequest.setText((CharSequence)getContext().getResources().getString(l.i.OKY));
      AppMethodBeat.o(314652);
      return;
    }
  }
  
  public final void Ck(final boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject2 = null;
    AppMethodBeat.i(52312);
    super.Ck(paramBoolean);
    kotlin.g.a.a locala = (kotlin.g.a.a)new f(this, paramBoolean);
    ImageView localImageView = this.Pek;
    Object localObject1 = localImageView;
    if (localImageView == null)
    {
      s.bIx("blurView");
      localObject1 = null;
    }
    if (((ImageView)localObject1).getVisibility() != 0)
    {
      localImageView = this.Pej;
      localObject1 = localImageView;
      if (localImageView == null)
      {
        s.bIx("previewImage");
        localObject1 = null;
      }
      if (((ImageView)localObject1).getVisibility() != 0)
      {
        localImageView = this.Pei;
        localObject1 = localImageView;
        if (localImageView == null)
        {
          s.bIx("bottomBlurView");
          localObject1 = null;
        }
        if (((ImageView)localObject1).getVisibility() != 0) {
          break label422;
        }
      }
    }
    localImageView = this.Pej;
    localObject1 = localImageView;
    if (localImageView == null)
    {
      s.bIx("previewImage");
      localObject1 = null;
    }
    int i;
    if (((ImageView)localObject1).getAlpha() == 1.0F)
    {
      i = 1;
      if (i == 0) {
        break label404;
      }
      localImageView = this.Pej;
      localObject1 = localImageView;
      if (localImageView == null)
      {
        s.bIx("previewImage");
        localObject1 = null;
      }
      if (((ImageView)localObject1).getVisibility() != 0) {
        break label404;
      }
      paramBoolean = true;
      label200:
      localImageView = this.Pei;
      localObject1 = localImageView;
      if (localImageView == null)
      {
        s.bIx("bottomBlurView");
        localObject1 = null;
      }
      if (((ImageView)localObject1).getAlpha() != 1.0F) {
        break label409;
      }
      i = 1;
      label236:
      if (i == 0) {
        break label414;
      }
      localImageView = this.Pei;
      localObject1 = localImageView;
      if (localImageView == null)
      {
        s.bIx("bottomBlurView");
        localObject1 = null;
      }
      if (((ImageView)localObject1).getVisibility() != 0) {
        break label414;
      }
      label272:
      localObject1 = this.Pek;
      if (localObject1 != null) {
        break label419;
      }
      s.bIx("blurView");
      localObject1 = localObject2;
    }
    label404:
    label409:
    label414:
    label419:
    for (;;)
    {
      localObject1 = ((ImageView)localObject1).animate();
      if (localObject1 != null)
      {
        localObject1 = ((ViewPropertyAnimator)localObject1).alpha(0.0F);
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(300L);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setInterpolator((TimeInterpolator)this.PeB);
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).setListener((Animator.AnimatorListener)new ScanGoodsMaskView.c(locala));
              if (localObject1 != null) {
                ((ViewPropertyAnimator)localObject1).setUpdateListener(new ScanGoodsMaskView..ExternalSyntheticLambda1(this, paramBoolean, bool));
              }
            }
          }
        }
      }
      AppMethodBeat.o(52312);
      return;
      i = 0;
      break;
      paramBoolean = false;
      break label200;
      i = 0;
      break label236;
      bool = false;
      break label272;
    }
    label422:
    locala.invoke();
    AppMethodBeat.o(52312);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52311);
    super.a(paramAnimatorListener);
    gTg();
    p.a((View)this, 1.0F, 0.0F, 200L, paramAnimatorListener);
    AppMethodBeat.o(52311);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(52313);
    s.u(paramObject, "data");
    Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo onScanSuccess");
    this.PeA = paramd;
    Object localObject;
    int i;
    label141:
    float f1;
    float f2;
    float f3;
    float f4;
    if ((paramObject instanceof ae))
    {
      localObject = (ae)paramObject;
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView with animation");
      Cn(false);
      Log.v("MicroMsg.ScanGoodsMaskView", "updateSuccessViewVisibility showCustomView: %b", new Object[] { Boolean.valueOf(this.Pem) });
      paramd = this.Peo;
      paramObject = paramd;
      if (paramd == null)
      {
        s.bIx("customSuccessView");
        paramObject = null;
      }
      if (!this.Pem) {
        break label499;
      }
      i = 0;
      paramObject.setVisibility(i);
      paramd = this.Peh;
      paramObject = paramd;
      if (paramd == null)
      {
        s.bIx("successDecorationView");
        paramObject = null;
      }
      if (!this.Pem) {
        break label506;
      }
      i = 0;
      paramObject.setVisibility(i);
      gTg();
      f1 = ((ae)localObject).centerX;
      f2 = ((ae)localObject).centerY;
      if (getMScanSource() != 1) {
        break label513;
      }
      f3 = f1 * getMeasuredWidth();
      f4 = f2 * getMeasuredHeight();
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
      paramObject = new PointF(f3, f4);
      label247:
      localObject = this.Peg;
      paramd = (com.tencent.mm.plugin.scanner.view.d)localObject;
      if (localObject == null)
      {
        s.bIx("successMarkView");
        paramd = null;
      }
      paramd.setVisibility(0);
      paramd.setPivotX(this.Pev / 2.0F);
      paramd.setPivotY(this.Pev / 2.0F);
      paramd.setTranslationX(paramObject.x - this.Pev / 2);
      paramd.setTranslationY(paramObject.y - this.Pev / 2);
      paramd.setScaleX(0.0F);
      paramd.setScaleY(0.0F);
      if (this.Pem) {
        break label638;
      }
      paramd = this.Peg;
      paramObject = paramd;
      if (paramd == null)
      {
        s.bIx("successMarkView");
        paramObject = null;
      }
      h.a(paramObject, this.PeA);
    }
    for (;;)
    {
      paramd = this.maskView;
      paramObject = paramd;
      if (paramd == null)
      {
        s.bIx("maskView");
        paramObject = null;
      }
      paramObject.setAlpha(0.0F);
      paramObject.setVisibility(0);
      paramd = this.Pek;
      paramObject = paramd;
      if (paramd == null)
      {
        s.bIx("blurView");
        paramObject = null;
      }
      paramObject.setVisibility(8);
      Cr(false);
      paramObject = getScanTips();
      if (paramObject != null) {
        paramObject.setAlpha(1.0F);
      }
      if (this.PeD) {
        com.tencent.threadpool.h.ahAA.bm(new ScanGoodsMaskView..ExternalSyntheticLambda6(this));
      }
      if (this.PeE) {
        postDelayed(new ScanGoodsMaskView..ExternalSyntheticLambda5(this), 100L);
      }
      AppMethodBeat.o(52313);
      return;
      label499:
      i = 8;
      break;
      label506:
      i = 8;
      break label141;
      label513:
      paramObject = getPreviewImageSize();
      i = (getMeasuredWidth() - paramObject.x) / 2;
      int j = (getMeasuredHeight() - paramObject.y) / 2;
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPositionForImage previewImageSize: %s, centerX: %s, centerY: %s, left: %d, top: %d", new Object[] { paramObject, Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      f3 = i;
      f4 = paramObject.x;
      float f5 = j;
      paramObject = new PointF(f1 * f4 + f3, f2 * paramObject.y + f5);
      break label247;
      label638:
      Log.d("MicroMsg.ScanGoodsMaskView", "alvinluo animateCustomSuccessView");
      localObject = this.Peg;
      paramd = (com.tencent.mm.plugin.scanner.view.d)localObject;
      if (localObject == null)
      {
        s.bIx("successMarkView");
        paramd = null;
      }
      h.iX(paramd);
      localObject = this.Peh;
      paramd = (com.tencent.mm.plugin.scanner.view.d)localObject;
      if (localObject == null)
      {
        s.bIx("successDecorationView");
        paramd = null;
      }
      paramd.setVisibility(0);
      paramd.setPivotX(this.Pew / 2.0F);
      paramd.setPivotY(this.Pew / 2.0F);
      paramd.setTranslationX(paramObject.x - this.Pew / 2);
      paramd.setTranslationY(paramObject.y - this.Pew / 2);
      paramd.setScaleX(0.5F);
      paramd.setScaleY(0.5F);
      paramd.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)new ScanGoodsMaskView.b(this)).setUpdateListener(new ScanGoodsMaskView..ExternalSyntheticLambda0(this)).start();
    }
  }
  
  public final void az(Bitmap paramBitmap)
  {
    AppMethodBeat.i(314864);
    this.Pey = true;
    this.Pez = false;
    aA(paramBitmap);
    AppMethodBeat.o(314864);
  }
  
  public final void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(52314);
    if (paramBoolean)
    {
      w localw = this.psR;
      if (localw != null) {
        localw.dismiss();
      }
      this.psR = k.a(getContext(), getResources().getString(l.i.OLj), true, paramOnCancelListener);
      AppMethodBeat.o(52314);
      return;
    }
    paramOnCancelListener = this.psR;
    if (paramOnCancelListener != null) {
      paramOnCancelListener.dismiss();
    }
    AppMethodBeat.o(52314);
  }
  
  public final void d(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(52323);
    float f1 = Math.max(0.0F, Math.min(1.0F, paramFloat2));
    Object localObject2;
    Object localObject1;
    boolean bool;
    label232:
    int i;
    label240:
    float f2;
    float f3;
    switch (paramInt)
    {
    default: 
      localObject2 = this.maskView;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("maskView");
        localObject1 = null;
      }
      ((View)localObject1).setAlpha(Math.max(0.0F, Math.min(0.5F, 1.0F - f1)));
      if (this.Pey) {
        if (this.Pez)
        {
          f1 = Math.max(0.0F, Math.min(1.0F, (paramFloat2 - 0.5F) / 0.5F));
          localObject2 = this.Pej;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("previewImage");
            localObject1 = null;
          }
          ((ImageView)localObject1).setAlpha(1.0F - f1);
          localObject2 = this.Pej;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("previewImage");
            localObject1 = null;
          }
          Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY previewImage.alpha: %f, targetFactor: %f", new Object[] { Float.valueOf(((ImageView)localObject1).getAlpha()), Float.valueOf(f1) });
          bool = false;
          localObject1 = this.Pek;
          if (localObject1 != null) {
            break label923;
          }
          s.bIx("blurView");
          localObject1 = null;
          if (!bool) {
            break label926;
          }
          i = 0;
          ((ImageView)localObject1).setVisibility(i);
          localObject2 = this.maskView;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("maskView");
            localObject1 = null;
          }
          ((View)localObject1).setVisibility(0);
          localObject2 = this.Pek;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("blurView");
            localObject1 = null;
          }
          f1 = ((ImageView)localObject1).getAlpha();
          localObject2 = this.Peg;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("successMarkView");
            localObject1 = null;
          }
          f2 = ((View)localObject1).getAlpha();
          localObject2 = this.maskView;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("maskView");
            localObject1 = null;
          }
          f3 = ((View)localObject1).getAlpha();
          localObject1 = this.Pej;
          if (localObject1 != null) {
            break label933;
          }
          s.bIx("previewImage");
          localObject1 = localObject3;
        }
      }
      break;
    }
    label923:
    label926:
    label933:
    for (;;)
    {
      Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, markView alpha: %s, maskView alpha: %s, previewImage alpha: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(((ImageView)localObject1).getAlpha()) });
      AppMethodBeat.o(52323);
      return;
      ImageView localImageView;
      if ((f1 >= 0.5F) && (paramInt == 1))
      {
        bool = this.Pex;
        f1 = (f1 - 0.5F) / 0.5F;
        localObject2 = this.Pek;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("blurView");
          localObject1 = null;
        }
        ((ImageView)localObject1).setAlpha(this.PeC.getInterpolation(f1));
        localObject2 = this.Peg;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("successMarkView");
          localObject1 = null;
        }
        ((View)localObject1).setAlpha(1.0F - f1);
        localObject2 = this.Pej;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("previewImage");
          localObject1 = null;
        }
        localImageView = this.Pek;
        localObject2 = localImageView;
        if (localImageView == null)
        {
          s.bIx("blurView");
          localObject2 = null;
        }
        ((ImageView)localObject1).setAlpha(1.0F - ((ImageView)localObject2).getAlpha());
      }
      for (;;)
      {
        localObject2 = this.maskView;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("maskView");
          localObject1 = null;
        }
        ((View)localObject1).setAlpha(0.5F);
        break;
        if (paramInt == 2)
        {
          bool = this.Pex;
          localObject2 = this.Pek;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("blurView");
            localObject1 = null;
          }
          ((ImageView)localObject1).setAlpha(this.PeC.getInterpolation(f1));
          localObject2 = this.Peg;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("successMarkView");
            localObject1 = null;
          }
          ((View)localObject1).setAlpha(1.0F - f1);
          localObject2 = this.Pej;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("previewImage");
            localObject1 = null;
          }
          localImageView = this.Pek;
          localObject2 = localImageView;
          if (localImageView == null)
          {
            s.bIx("blurView");
            localObject2 = null;
          }
          ((ImageView)localObject1).setAlpha(1.0F - ((ImageView)localObject2).getAlpha());
        }
        else
        {
          localObject2 = this.Peg;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("successMarkView");
            localObject1 = null;
          }
          ((View)localObject1).setAlpha(1.0F);
          localObject2 = this.Pej;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("previewImage");
            localObject1 = null;
          }
          ((ImageView)localObject1).setAlpha(1.0F);
          bool = false;
        }
      }
      localObject2 = this.Pej;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("previewImage");
        localObject1 = null;
      }
      ((ImageView)localObject1).setAlpha(1.0F);
      bool = false;
      break;
      break label232;
      i = 8;
      break label240;
    }
  }
  
  public final void e(int paramInt, float paramFloat1, float paramFloat2) {}
  
  public final void gPJ() {}
  
  public final void gPK() {}
  
  public final void gPL() {}
  
  public final void gPM() {}
  
  public final void gPN() {}
  
  public final void gTe()
  {
    AppMethodBeat.i(52310);
    super.gTe();
    AppMethodBeat.o(52310);
  }
  
  public final float getBackgroundTransY()
  {
    AppMethodBeat.i(52319);
    View localView = this.Pel;
    if (localView == null)
    {
      AppMethodBeat.o(52319);
      return 0.0F;
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(52319);
    return f;
  }
  
  public final float getMarkViewHeight()
  {
    AppMethodBeat.i(52322);
    float f = this.Pev;
    AppMethodBeat.o(52322);
    return f;
  }
  
  public final float getMarkViewTransY()
  {
    AppMethodBeat.i(52321);
    View localView2 = this.Peg;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("successMarkView");
      localView1 = null;
    }
    float f = localView1.getTranslationY();
    AppMethodBeat.o(52321);
    return f;
  }
  
  public final void iZ(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(52309);
    this.Pel = paramView;
    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo attachBackgroundView source: %d", new Object[] { Integer.valueOf(getMScanSource()) });
    if ((paramView instanceof TextureView)) {
      if (getMScanSource() != 1) {
        break label85;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramView = (TextureView)paramView;
        com.tencent.threadpool.h.ahAA.bm(new ScanGoodsMaskView..ExternalSyntheticLambda8(this, paramView));
      }
      AppMethodBeat.o(52309);
      return;
      label85:
      i = 0;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314932);
    super.onMeasure(paramInt1, paramInt2);
    this.mbM = getMeasuredWidth();
    this.mbN = getMeasuredHeight();
    if ((this.mbM != 0) && (this.mbN != 0))
    {
      Iterator localIterator = ((Iterable)this.Pet).iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.Pet.clear();
    }
    AppMethodBeat.o(314932);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52315);
    super.release();
    ScanAnimationDotsView localScanAnimationDotsView = this.Pef;
    Object localObject = localScanAnimationDotsView;
    if (localScanAnimationDotsView == null)
    {
      s.bIx("animationDotsView");
      localObject = null;
    }
    ((ScanAnimationDotsView)localObject).release();
    localObject = ag.OSF;
    ag.tW(this.Peu);
    gTg();
    AppMethodBeat.o(52315);
  }
  
  public final void setBackgroundTransY(float paramFloat)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52318);
    Object localObject1 = this.Pel;
    if (localObject1 != null) {
      ((View)localObject1).setTranslationY(paramFloat);
    }
    ImageView localImageView = this.Pek;
    localObject1 = localImageView;
    if (localImageView == null)
    {
      s.bIx("blurView");
      localObject1 = null;
    }
    ((ImageView)localObject1).setTranslationY(paramFloat);
    localImageView = this.Pej;
    localObject1 = localImageView;
    if (localImageView == null)
    {
      s.bIx("previewImage");
      localObject1 = null;
    }
    ((ImageView)localObject1).setTranslationY(paramFloat);
    localObject1 = this.Pei;
    if (localObject1 == null)
    {
      s.bIx("bottomBlurView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ImageView)localObject1).setTranslationY(paramFloat);
      AppMethodBeat.o(52318);
      return;
    }
  }
  
  public final void setMarkViewTransY(float paramFloat)
  {
    AppMethodBeat.i(52320);
    View localView2 = this.Peg;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("successMarkView");
      localView1 = null;
    }
    localView1.setTranslationY(paramFloat);
    AppMethodBeat.o(52320);
  }
  
  public final void setScanRequest(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(314937);
    super.setScanRequest((BaseScanRequest)paramScanGoodsRequest);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(314937);
      return;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      Log.w("MicroMsg.ScanGoodsMaskView", "alvinluo setScanRequest request is not valid and ignore");
      am.d(paramScanGoodsRequest);
      AppMethodBeat.o(314937);
      return;
    }
    LinearLayout localLinearLayout = this.Pep;
    Object localObject = localLinearLayout;
    if (localLinearLayout == null)
    {
      s.bIx("customTipsContainer");
      localObject = null;
    }
    ((LinearLayout)localObject).setVisibility(0);
    setCustomTipsWording(paramScanGoodsRequest);
    localObject = ag.OSF;
    this.Peu = ag.a(paramScanGoodsRequest, (af)new ScanGoodsMaskView.j(this, paramScanGoodsRequest));
    if (paramScanGoodsRequest.OMF)
    {
      paramScanGoodsRequest.OMF = false;
      this.PeF = ((TimerTask)new e(this));
      paramScanGoodsRequest = com.tencent.threadpool.h.ahAA;
      localObject = this.PeF;
      s.checkNotNull(localObject);
      this.PeG = paramScanGoodsRequest.p((Runnable)localObject, 15000L);
    }
    AppMethodBeat.o(314937);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap)
    {
      super();
    }
    
    private static final void ar(kotlin.g.a.a parama)
    {
      AppMethodBeat.i(314613);
      s.u(parama, "$setImageBitmapAction");
      parama.invoke();
      AppMethodBeat.o(314613);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$initScanTipsImageAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends TimerTask
  {
    e(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    private static final void w(ScanGoodsMaskView paramScanGoodsMaskView)
    {
      AppMethodBeat.i(314606);
      s.u(paramScanGoodsMaskView, "this$0");
      if (ScanGoodsMaskView.u(paramScanGoodsMaskView))
      {
        LinearLayout localLinearLayout2 = ScanGoodsMaskView.v(paramScanGoodsMaskView);
        LinearLayout localLinearLayout1 = localLinearLayout2;
        if (localLinearLayout2 == null)
        {
          s.bIx("customTipsImageContainer");
          localLinearLayout1 = null;
        }
        if (localLinearLayout1.getVisibility() == 0)
        {
          localLinearLayout2 = ScanGoodsMaskView.v(paramScanGoodsMaskView);
          localLinearLayout1 = localLinearLayout2;
          if (localLinearLayout2 == null)
          {
            s.bIx("customTipsImageContainer");
            localLinearLayout1 = null;
          }
          ScanGoodsMaskView.a(paramScanGoodsMaskView, h.iY((View)localLinearLayout1));
        }
      }
      AppMethodBeat.o(314606);
    }
    
    public final void run()
    {
      AppMethodBeat.i(314612);
      com.tencent.threadpool.h.ahAA.bk(new ScanGoodsMaskView.e..ExternalSyntheticLambda0(this.PeI));
      AppMethodBeat.o(314612);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView
 * JD-Core Version:    0.7.0.1
 */