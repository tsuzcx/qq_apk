package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.k;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.h;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.an;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.d;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import com.tencent.threadpool.i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.ArrayList<Landroid.graphics.PointF;>;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "alphaAnimationDistanceFactor", "", "canUpdateMultiCodeTipsDefaultPos", "", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "frameBitmap", "Landroid/graphics/Bitmap;", "frameImage", "Landroid/widget/ImageView;", "isMultiCode", "isShowingSuccessView", "mRect", "Landroid/graphics/Rect;", "multiCodeBgMask", "Landroid/view/View;", "multiCodeTips", "Landroid/widget/TextView;", "multiCodeTipsCurrentBottomMargin", "multiCodeTipsDefaultPosition", "Landroid/graphics/PointF;", "myQrCodeButton", "getMyQrCodeButton", "()Landroid/view/View;", "setMyQrCodeButton", "(Landroid/view/View;)V", "needRotate", "pointCount", "scaleAnimationHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleTimerTask", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "scanLineAnimator", "scanLineImageView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "getSuccessAnimationListener", "()Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "setSuccessAnimationListener", "(Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;)V", "successAnimator", "successMarkClickIndex", "successMarkClickListener", "Lcom/tencent/mm/plugin/scanner/model/ScanSuccessMarkClickListener;", "successMarkViewCheckSize", "successMarkViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSuccessMarkViewList", "()Ljava/util/ArrayList;", "setSuccessMarkViewList", "(Ljava/util/ArrayList;)V", "successMarkViewSize", "getSuccessMarkViewSize", "()I", "setSuccessMarkViewSize", "(I)V", "viewWidth", "addSuccessView", "cancelScaleAnimator", "", "cancelScaleTimer", "cancelSuccessAnimator", "checkMultiCodeTipsPositionValid", "x", "y", "computeCenterPosition", "scanCodeResultPoint", "Lcom/tencent/qbar/WxQBarPoint;", "computeRealPosition", "pos", "dismissMultiCodeView", "fixMultiCodeTipsPosition", "valid", "getFrameBitmap", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getLayoutId", "getTargetSuccessMarkView", "getTipsViewText", "", "pointInfoList", "Lcom/tencent/qbar/WxQBarResult;", "init", "initDefaultRect", "initScaleAnimation", "initScanLineAnimator", "initView", "view", "needAnimateAlphaOnPreviewReady", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "onShowInfoView", "show", "onShowNetworkLoading", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleFrameBitmap", "release", "rotateAndScaleBitmap", "bitmap", "rotation", "targetWidth", "targetHeight", "runScaleAnimation", "runSuccessAnimator", "duration", "", "updateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setAnimationRect", "rect", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setMyQrCodeButtonVisible", "visible", "setNeedRotate", "setSuccessMarkClickListener", "showSuccessView", "pointList", "tips", "startScanLineAnimation", "stopScanLineAnimation", "updateMultiCodeTipsBottomMargin", "margin", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ScanCodeMaskView
  extends BaseScanMaskView<BaseScanRequest>
{
  public static final ScanCodeMaskView.a Pfn;
  private ValueAnimator AjF;
  private boolean KWy;
  private MTimerHandler OHe;
  private AccelerateInterpolator OHf;
  private DecelerateInterpolator OHg;
  private d PeA;
  private int Pev;
  private an PfA;
  private int PfB;
  private final MTimerHandler.CallBack PfC;
  private int PfD;
  private PointF PfE;
  private boolean PfF;
  private ImageView Pfo;
  protected View Pfp;
  private View Pfq;
  private TextView Pfr;
  private ImageView Pfs;
  private Bitmap Pft;
  private ArrayList<View> Pfu;
  private int Pfv;
  private ValueAnimator Pfw;
  private float Pfx;
  private boolean Pfy;
  private boolean Pfz;
  private Rect mRect;
  private int mbM;
  private int pointCount;
  private ValueAnimator ydD;
  
  static
  {
    AppMethodBeat.i(52406);
    Pfn = new ScanCodeMaskView.a((byte)0);
    AppMethodBeat.o(52406);
  }
  
  public ScanCodeMaskView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(52403);
    AppMethodBeat.o(52403);
  }
  
  public ScanCodeMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52404);
    AppMethodBeat.o(52404);
  }
  
  public ScanCodeMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52405);
    this.Pfu = new ArrayList();
    this.Pev = getResources().getDimensionPixelSize(l.d.OIk);
    this.Pfv = (this.Pev - getResources().getDimensionPixelSize(l.d.NormalPadding) * 2 + getResources().getDimensionPixelSize(l.d.SmallestPadding) * 2);
    this.Pfw = new ValueAnimator();
    this.AjF = new ValueAnimator();
    this.mRect = new Rect(0, 0, 0, 0);
    this.PfB = -1;
    this.PfC = new ScanCodeMaskView..ExternalSyntheticLambda5(this);
    this.OHe = new MTimerHandler(Looper.getMainLooper(), this.PfC, true);
    this.OHf = new AccelerateInterpolator(1.5F);
    this.OHg = new DecelerateInterpolator(1.5F);
    this.PfD = 120;
    this.PfE = new PointF();
    this.PfF = true;
    paramContext = LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    s.s(paramContext, "view");
    iS(paramContext);
    AppMethodBeat.o(52405);
  }
  
  private final Bitmap a(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170064);
    for (;;)
    {
      try
      {
        Object localObject1 = getScanCamera();
        s.checkNotNull(localObject1);
        int i = ((com.tencent.mm.plugin.scanner.a.a)localObject1).gQf();
        localObject1 = getScanCamera();
        s.checkNotNull(localObject1);
        localObject1 = ((com.tencent.mm.plugin.scanner.a.a)localObject1).jXF();
        if (paramScanDecodeFrameData != null)
        {
          Object localObject2 = paramScanDecodeFrameData.OOy;
          if (localObject2 != null)
          {
            Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap data length: %d, size: %d, %d, rotation: %d, previewFormat: %d", new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(paramScanDecodeFrameData.width), Integer.valueOf(paramScanDecodeFrameData.height), Integer.valueOf(paramScanDecodeFrameData.zTK), Integer.valueOf(i) });
            localObject2 = new YuvImage(paramScanDecodeFrameData.OOy, i, ((Point)localObject1).x, ((Point)localObject1).y, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((Point)localObject1).x, ((Point)localObject1).y), 100, (OutputStream)localByteArrayOutputStream);
            localObject1 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
            {
              Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap bitmap width: %d, height: %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
              if (paramScanDecodeFrameData.zTK != 0)
              {
                i = paramScanDecodeFrameData.zTK;
                int i3 = getMeasuredWidth();
                int i4 = getMeasuredHeight();
                if (localObject1 == null)
                {
                  AppMethodBeat.o(170064);
                  return null;
                }
                Log.i("MicroMsg.ScanCodeMaskView", "alvinlu rotateAndScaleBitmap rotation: %d, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4) });
                paramScanDecodeFrameData = new Matrix();
                paramScanDecodeFrameData.postRotate(i);
                if (i % 180 == 0) {
                  break label664;
                }
                n = 1;
                int i1 = ((Bitmap)localObject1).getWidth();
                int i2 = ((Bitmap)localObject1).getHeight();
                float f2;
                if (n != 0)
                {
                  i = ((Bitmap)localObject1).getHeight();
                  if (n != 0)
                  {
                    j = ((Bitmap)localObject1).getWidth();
                    k = i2;
                    m = i1;
                    if (i3 != 0)
                    {
                      k = i2;
                      m = i1;
                      if (i4 != 0)
                      {
                        float f1 = 1.0F * i / j;
                        f2 = 1.0F * i3 / i4;
                        if (f1 <= f2) {
                          continue;
                        }
                        m = (int)(j * f2);
                        k = j;
                      }
                    }
                    i = Math.max(0, (i - m) / 2);
                    j = Math.max(0, (j - k) / 2);
                    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo rotateAndScaleBitmap finalWidth: %d, finalHeight: %d, x: %d, y: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
                    if (n == 0) {
                      continue;
                    }
                    paramScanDecodeFrameData = Bitmap.createBitmap((Bitmap)localObject1, j, i, k, m, paramScanDecodeFrameData, true);
                    if ((!s.p(paramScanDecodeFrameData, localObject1)) && (!((Bitmap)localObject1).isRecycled())) {
                      ((Bitmap)localObject1).recycle();
                    }
                    AppMethodBeat.o(170064);
                    return paramScanDecodeFrameData;
                  }
                }
                else
                {
                  i = ((Bitmap)localObject1).getWidth();
                  continue;
                }
                int j = ((Bitmap)localObject1).getHeight();
                continue;
                int k = (int)(i / f2);
                int m = i;
                continue;
                paramScanDecodeFrameData = Bitmap.createBitmap((Bitmap)localObject1, i, j, m, k, paramScanDecodeFrameData, true);
                continue;
              }
              AppMethodBeat.o(170064);
              return localObject1;
            }
          }
        }
      }
      catch (Exception paramScanDecodeFrameData)
      {
        Log.printErrStackTrace("MicroMsg.ScanCodeMaskView", (Throwable)paramScanDecodeFrameData, "alvinluo getFrameBitmap exception", new Object[0]);
        AppMethodBeat.o(170064);
        return null;
      }
      label664:
      int n = 0;
    }
  }
  
  private final void a(float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(170058);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    gPl();
    this.ydD = new ValueAnimator();
    ValueAnimator localValueAnimator = this.ydD;
    if (localValueAnimator != null)
    {
      localValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
      localValueAnimator.setInterpolator((TimeInterpolator)paramInterpolator);
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new ScanCodeMaskView..ExternalSyntheticLambda1(this));
      localValueAnimator.addListener(paramAnimatorListener);
      localValueAnimator.start();
    }
    AppMethodBeat.o(170058);
  }
  
  private static final void a(ScanCodeMaskView paramScanCodeMaskView, int paramInt, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(314829);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramScanCodeMaskView);
    localb.sc(paramInt);
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramScanCodeMaskView, "this$0");
    s.u(paramf, "$view");
    paramScanCodeMaskView.PfB = paramInt;
    paramf = paramScanCodeMaskView.PfA;
    if (paramf != null) {
      paramf.aid(paramInt);
    }
    paramScanCodeMaskView = ((Iterable)paramScanCodeMaskView.getSuccessMarkViewList()).iterator();
    while (paramScanCodeMaskView.hasNext()) {
      ((View)paramScanCodeMaskView.next()).setOnClickListener(null);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314829);
  }
  
  private static final void a(ScanCodeMaskView paramScanCodeMaskView, ValueAnimator paramValueAnimator)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(314825);
    s.u(paramScanCodeMaskView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanCodeMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314825);
      throw paramScanCodeMaskView;
    }
    float f2 = ((Float)paramValueAnimator).floatValue();
    ImageView localImageView = paramScanCodeMaskView.Pfo;
    paramValueAnimator = localImageView;
    if (localImageView == null)
    {
      s.bIx("scanLineImageView");
      paramValueAnimator = null;
    }
    paramValueAnimator.setTranslationY(f2);
    float f1 = paramScanCodeMaskView.mRect.height() * paramScanCodeMaskView.Pfx;
    f2 -= paramScanCodeMaskView.mRect.top;
    if (f2 <= f1)
    {
      f1 = (f1 - f2) / f1;
      paramScanCodeMaskView = paramScanCodeMaskView.Pfo;
      if (paramScanCodeMaskView == null)
      {
        s.bIx("scanLineImageView");
        paramScanCodeMaskView = localObject1;
      }
      for (;;)
      {
        paramScanCodeMaskView.setAlpha(1.0F - f1);
        AppMethodBeat.o(314825);
        return;
      }
    }
    if (f2 >= paramScanCodeMaskView.mRect.height() * (1.0F - paramScanCodeMaskView.Pfx))
    {
      f1 = (f2 - paramScanCodeMaskView.mRect.height() * (1.0F - paramScanCodeMaskView.Pfx)) / f1;
      paramScanCodeMaskView = paramScanCodeMaskView.Pfo;
      if (paramScanCodeMaskView == null)
      {
        s.bIx("scanLineImageView");
        paramScanCodeMaskView = localObject2;
      }
      for (;;)
      {
        paramScanCodeMaskView.setAlpha(1.0F - f1);
        AppMethodBeat.o(314825);
        return;
      }
    }
    paramScanCodeMaskView = paramScanCodeMaskView.Pfo;
    if (paramScanCodeMaskView == null)
    {
      s.bIx("scanLineImageView");
      paramScanCodeMaskView = localObject3;
    }
    for (;;)
    {
      paramScanCodeMaskView.setAlpha(1.0F);
      AppMethodBeat.o(314825);
      return;
    }
  }
  
  private static final void a(ScanCodeMaskView paramScanCodeMaskView, View paramView)
  {
    AppMethodBeat.i(314816);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramScanCodeMaskView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramScanCodeMaskView, "this$0");
    com.tencent.mm.plugin.report.service.h.OAn.b(11264, new Object[] { Integer.valueOf(3) });
    com.tencent.mm.plugin.scanner.m.dFc().cK(paramScanCodeMaskView.getContext());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314816);
  }
  
  private static final void a(ScanCodeMaskView paramScanCodeMaskView, ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(314847);
    s.u(paramScanCodeMaskView, "this$0");
    long l = System.currentTimeMillis();
    paramScanCodeMaskView.Pft = paramScanCodeMaskView.a(paramScanDecodeFrameData);
    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    MMHandlerThread.postToMainThread(new ScanCodeMaskView..ExternalSyntheticLambda6(paramScanCodeMaskView));
    AppMethodBeat.o(314847);
  }
  
  private static final void a(boolean paramBoolean, ScanCodeMaskView paramScanCodeMaskView, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314831);
    s.u(paramScanCodeMaskView, "this$0");
    Object localObject = paramValueAnimator.getAnimatedValue();
    if (localObject == null)
    {
      paramScanCodeMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314831);
      throw paramScanCodeMaskView;
    }
    float f = ((Float)localObject).floatValue();
    if (paramBoolean) {
      paramScanCodeMaskView.getMyQrCodeButton().setAlpha(1.0F - f);
    }
    localObject = paramScanCodeMaskView.getScanTips();
    if (localObject != null) {
      ((TextView)localObject).setAlpha(1.0F - f);
    }
    if (paramAnimatorUpdateListener != null) {
      paramAnimatorUpdateListener.onAnimationUpdate(paramValueAnimator);
    }
    paramAnimatorUpdateListener = (Iterable)paramScanCodeMaskView.getSuccessMarkViewList();
    int i = 0;
    paramAnimatorUpdateListener = paramAnimatorUpdateListener.iterator();
    while (paramAnimatorUpdateListener.hasNext())
    {
      paramValueAnimator = paramAnimatorUpdateListener.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      paramValueAnimator = (View)paramValueAnimator;
      if (i < paramScanCodeMaskView.pointCount)
      {
        paramValueAnimator.setAlpha(f);
        paramValueAnimator.setScaleX(f);
        paramValueAnimator.setScaleY(f);
      }
      i += 1;
    }
    if (paramScanCodeMaskView.Pfy)
    {
      paramAnimatorUpdateListener = paramScanCodeMaskView.Pfr;
      paramScanCodeMaskView = paramAnimatorUpdateListener;
      if (paramAnimatorUpdateListener == null)
      {
        s.bIx("multiCodeTips");
        paramScanCodeMaskView = null;
      }
      paramScanCodeMaskView.setAlpha(f);
    }
    AppMethodBeat.o(314831);
  }
  
  private static final boolean a(ScanCodeMaskView paramScanCodeMaskView)
  {
    AppMethodBeat.i(314809);
    s.u(paramScanCodeMaskView, "this$0");
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runScaleAnimation");
    paramScanCodeMaskView.ahC(1);
    AppMethodBeat.o(314809);
    return true;
  }
  
  private final void ahC(int paramInt)
  {
    AppMethodBeat.i(170057);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation %d", new Object[] { Integer.valueOf(paramInt) });
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new e(this, new f(paramInt, this));
    a(1.0F, 0.8F, (Interpolator)this.OHf, localAnimatorListener);
    AppMethodBeat.o(170057);
  }
  
  private final void aiw(int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(314771);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo updateMultiCodeTipsBottomMargin: %d", new Object[] { Integer.valueOf(paramInt) });
    TextView localTextView = this.Pfr;
    Object localObject2;
    if (localTextView == null)
    {
      s.bIx("multiCodeTips");
      localTextView = null;
      localObject2 = this.Pfr;
      if (localObject2 != null) {
        break label119;
      }
      s.bIx("multiCodeTips");
    }
    for (;;)
    {
      localObject1 = ((TextView)localObject1).getLayoutParams();
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
      {
        this.PfD = paramInt;
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt) + getMBottomExtraHeight());
      }
      localObject2 = ah.aiuX;
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(314771);
      return;
      break;
      label119:
      localObject1 = localObject2;
    }
  }
  
  private static final void b(ScanCodeMaskView paramScanCodeMaskView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314835);
    s.u(paramScanCodeMaskView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanCodeMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314835);
      throw paramScanCodeMaskView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = (Iterable)paramScanCodeMaskView.getSuccessMarkViewList();
    int i = 0;
    paramValueAnimator = paramValueAnimator.iterator();
    while (paramValueAnimator.hasNext())
    {
      Object localObject = paramValueAnimator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject = (View)localObject;
      if (i < paramScanCodeMaskView.pointCount)
      {
        ((View)localObject).setScaleX(f);
        ((View)localObject).setScaleY(f);
      }
      i += 1;
    }
    AppMethodBeat.o(314835);
  }
  
  private final String bw(ArrayList<WxQBarResult> paramArrayList)
  {
    AppMethodBeat.i(314762);
    String str = "";
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    paramArrayList = str;
    while (localIterator.hasNext())
    {
      paramArrayList = (WxQBarResult)localIterator.next();
      int i = e.e.boP(paramArrayList.typeName);
      if (k.cK(i, paramArrayList.data))
      {
        paramArrayList = getContext().getString(l.i.OLf);
        s.s(paramArrayList, "context.getString(R.stri…_mask_view_appbrand_tips)");
        localHashSet.add(Integer.valueOf(i));
      }
      else if (!e.e.avx(i))
      {
        paramArrayList = getContext().getString(l.i.OLh);
        s.s(paramArrayList, "context.getString(R.stri…code_mask_view_tiao_tips)");
        localHashSet.add(Integer.valueOf(i));
      }
      else
      {
        paramArrayList = getContext().getString(l.i.OLi);
        s.s(paramArrayList, "context.getString(R.stri…_view_two_dimension_tips)");
        localHashSet.add(Integer.valueOf(i));
      }
    }
    if (localHashSet.size() > 1)
    {
      paramArrayList = getContext().getString(l.i.OLg);
      s.s(paramArrayList, "context.getString(R.stri…ode_mask_view_multi_tips)");
    }
    AppMethodBeat.o(314762);
    return paramArrayList;
  }
  
  private final void gPl()
  {
    AppMethodBeat.i(170061);
    ValueAnimator localValueAnimator = this.ydD;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.ydD;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    localValueAnimator = this.ydD;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.ydD = null;
    AppMethodBeat.o(170061);
  }
  
  private final void gTk()
  {
    AppMethodBeat.i(52388);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    setAnimationRect(new Rect(0, (int)(0.15F * j), i, (int)(j * 0.6F)));
    AppMethodBeat.o(52388);
  }
  
  private final void gTn()
  {
    AppMethodBeat.i(314804);
    if (this.Pfy)
    {
      Object localObject2 = this.Pfq;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("multiCodeBgMask");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(8);
      this.Pfz = false;
      localObject1 = ((Iterable)this.Pfu).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((View)((Iterator)localObject1).next()).setAlpha(0.0F);
      }
      this.OHe.stopTimer();
      gPl();
      localObject2 = this.Pfr;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("multiCodeTips");
        localObject1 = null;
      }
      com.tencent.mm.plugin.scanner.util.p.a((View)localObject1, 1.0F, 0.0F, 200L, null);
    }
    AppMethodBeat.o(314804);
  }
  
  private final void i(ArrayList<PointF> paramArrayList, String paramString)
  {
    AppMethodBeat.i(314757);
    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView pointList %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.pointCount = 0;
    this.Pfz = true;
    boolean bool1 = true;
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    ah.f localf;
    Object localObject;
    View localView;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramArrayList = (PointF)localIterator.next();
        if (paramArrayList != null)
        {
          localf = new ah.f();
          localf.aqH = kotlin.a.p.ae((List)getSuccessMarkViewList(), this.pointCount);
          if (localf.aqH == null)
          {
            localObject = LayoutInflater.from(getContext()).inflate(l.g.layout_scan_code_success_mark_view, null);
            addView((View)localObject, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.Pev, this.Pev));
            s.s(localObject, "view");
            localf.aqH = localObject;
            getSuccessMarkViewList().add(localf.aqH);
          }
          localView = (View)localf.aqH;
          localObject = (ImageView)localView.findViewById(l.f.scan_success_dot_view);
          if (localObject != null) {
            ((ImageView)localObject).setImageResource(l.h.scan_success_mark_dot_with_arrow);
          }
          localView.setVisibility(0);
          localView.setPivotX(getSuccessMarkViewSize() / 2.0F);
          localView.setPivotY(getSuccessMarkViewSize() / 2.0F);
          localView.setTranslationX(paramArrayList.x - getSuccessMarkViewSize() / 2);
          localView.setTranslationY(paramArrayList.y - getSuccessMarkViewSize() / 2);
          localView.setAlpha(0.0F);
          localView.setScaleX(0.0F);
          localView.setScaleY(0.0F);
          float f2 = paramArrayList.x;
          float f1 = paramArrayList.y;
          float f3 = this.PfE.x;
          float f4 = this.PfE.y;
          localObject = this.Pfr;
          paramArrayList = (ArrayList<PointF>)localObject;
          if (localObject == null)
          {
            s.bIx("multiCodeTips");
            paramArrayList = null;
          }
          i = paramArrayList.getMeasuredWidth();
          localObject = this.Pfr;
          paramArrayList = (ArrayList<PointF>)localObject;
          if (localObject == null)
          {
            s.bIx("multiCodeTips");
            paramArrayList = null;
          }
          Log.i("MicroMsg.ScanCodeMaskView", "alvinluo checkMultiCodeTipsPositionValid [%s, %s], multiCodeTips: [%s, %s], [%s, %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i), Integer.valueOf(paramArrayList.getMeasuredHeight()) });
          if (this.Pfv / 2 + f2 >= this.PfE.x)
          {
            f3 = this.Pfv / 2;
            f4 = this.PfE.x;
            localObject = this.Pfr;
            paramArrayList = (ArrayList<PointF>)localObject;
            if (localObject == null)
            {
              s.bIx("multiCodeTips");
              paramArrayList = null;
            }
            if ((f2 - f3 <= paramArrayList.getMeasuredWidth() + f4) && (this.Pfv / 2 + f1 >= this.PfE.y))
            {
              f2 = this.Pfv / 2;
              f3 = this.PfE.y;
              localObject = this.Pfr;
              paramArrayList = (ArrayList<PointF>)localObject;
              if (localObject == null)
              {
                s.bIx("multiCodeTips");
                paramArrayList = null;
              }
              if (f1 - f2 <= paramArrayList.getMeasuredHeight() + f3) {
                break;
              }
            }
          }
          i = 1;
          label599:
          if (i != 0) {
            break label1215;
          }
          bool1 = false;
        }
      }
    }
    label1215:
    for (;;)
    {
      localView.setOnClickListener(new ScanCodeMaskView..ExternalSyntheticLambda4(this, this.pointCount, localf));
      this.pointCount += 1;
      break;
      i = 0;
      break label599;
      i = this.pointCount;
      int k = this.Pfu.size();
      if (i < k) {}
      for (;;)
      {
        int j = i + 1;
        paramArrayList = (View)kotlin.a.p.ae((List)this.Pfu, i);
        if (paramArrayList != null) {
          paramArrayList.setVisibility(8);
        }
        if (j >= k)
        {
          boolean bool2;
          if (this.pointCount > 1)
          {
            bool2 = true;
            this.Pfy = bool2;
            if (this.Pfy) {
              break label994;
            }
            paramArrayList = (View)kotlin.a.p.oL((List)this.Pfu);
            if (paramArrayList != null)
            {
              paramArrayList = (ImageView)paramArrayList.findViewById(l.f.scan_success_dot_view);
              if (paramArrayList != null) {
                paramArrayList.setImageResource(l.h.scan_success_mark_dot);
              }
            }
            paramString = this.Pfq;
            paramArrayList = paramString;
            if (paramString == null)
            {
              s.bIx("multiCodeBgMask");
              paramArrayList = null;
            }
            paramArrayList.setVisibility(8);
            paramString = this.Pfr;
            paramArrayList = paramString;
            if (paramString == null)
            {
              s.bIx("multiCodeTips");
              paramArrayList = null;
            }
            paramArrayList.setVisibility(4);
          }
          for (;;)
          {
            Log.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView isMultiCode: %b, pointCount: %d, successMarkViewList: %d, tipsPositionValid: %b", new Object[] { Boolean.valueOf(this.Pfy), Integer.valueOf(this.pointCount), Integer.valueOf(this.Pfu.size()), Boolean.valueOf(bool1) });
            a(300L, null);
            if (this.Pfy)
            {
              paramString = this.Pfq;
              paramArrayList = paramString;
              if (paramString == null)
              {
                s.bIx("multiCodeBgMask");
                paramArrayList = null;
              }
              paramArrayList = paramArrayList.animate();
              if (paramArrayList != null)
              {
                paramArrayList = paramArrayList.alpha(1.0F);
                if (paramArrayList != null)
                {
                  paramArrayList = paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
                  if (paramArrayList != null)
                  {
                    paramArrayList = paramArrayList.setDuration(600L);
                    if (paramArrayList != null)
                    {
                      paramArrayList = paramArrayList.setListener((Animator.AnimatorListener)new g(this));
                      if (paramArrayList != null) {
                        paramArrayList.start();
                      }
                    }
                  }
                }
              }
            }
            AppMethodBeat.o(314757);
            return;
            bool2 = false;
            break;
            label994:
            localObject = this.Pfq;
            paramArrayList = (ArrayList<PointF>)localObject;
            if (localObject == null)
            {
              s.bIx("multiCodeBgMask");
              paramArrayList = null;
            }
            paramArrayList.setVisibility(0);
            localObject = this.Pfq;
            paramArrayList = (ArrayList<PointF>)localObject;
            if (localObject == null)
            {
              s.bIx("multiCodeBgMask");
              paramArrayList = null;
            }
            paramArrayList.setAlpha(0.0F);
            localObject = this.Pfr;
            paramArrayList = (ArrayList<PointF>)localObject;
            if (localObject == null)
            {
              s.bIx("multiCodeTips");
              paramArrayList = null;
            }
            paramArrayList.setText((CharSequence)paramString);
            paramString = this.Pfr;
            paramArrayList = paramString;
            if (paramString == null)
            {
              s.bIx("multiCodeTips");
              paramArrayList = null;
            }
            paramArrayList.setVisibility(0);
            paramString = this.Pfr;
            paramArrayList = paramString;
            if (paramString == null)
            {
              s.bIx("multiCodeTips");
              paramArrayList = null;
            }
            paramArrayList.setAlpha(0.0F);
            Log.d("MicroMsg.ScanCodeMaskView", "alvinluo fixMultiCodeTipsPosition valid: %b, current: %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(this.PfD) });
            this.PfF = false;
            if ((!bool1) && (this.PfD != 32)) {
              aiw(32);
            } else if ((bool1) && (this.PfD != 120)) {
              aiw(120);
            }
          }
        }
        i = j;
      }
    }
  }
  
  private static final void setDecodeSuccessFrameData$lambda-23$lambda-22(ScanCodeMaskView paramScanCodeMaskView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(314841);
    s.u(paramScanCodeMaskView, "this$0");
    if ((!paramScanCodeMaskView.Pkf) && (paramScanCodeMaskView.Pft != null))
    {
      Object localObject1 = paramScanCodeMaskView.Pft;
      s.checkNotNull(localObject1);
      if (!((Bitmap)localObject1).isRecycled())
      {
        ImageView localImageView = paramScanCodeMaskView.Pfs;
        localObject1 = localImageView;
        if (localImageView == null)
        {
          s.bIx("frameImage");
          localObject1 = null;
        }
        ((ImageView)localObject1).setImageBitmap(paramScanCodeMaskView.Pft);
        localImageView = paramScanCodeMaskView.Pfs;
        localObject1 = localImageView;
        if (localImageView == null)
        {
          s.bIx("frameImage");
          localObject1 = null;
        }
        ((ImageView)localObject1).setVisibility(0);
        localImageView = paramScanCodeMaskView.Pfs;
        localObject1 = localImageView;
        if (localImageView == null)
        {
          s.bIx("frameImage");
          localObject1 = null;
        }
        ((ImageView)localObject1).setAlpha(0.0F);
        localImageView = paramScanCodeMaskView.Pfs;
        localObject1 = localImageView;
        if (localImageView == null)
        {
          s.bIx("frameImage");
          localObject1 = null;
        }
        localObject1 = ((ImageView)localObject1).animate();
        if (localObject1 != null) {
          ((ViewPropertyAnimator)localObject1).cancel();
        }
        paramScanCodeMaskView = paramScanCodeMaskView.Pfs;
        if (paramScanCodeMaskView != null) {
          break label211;
        }
        s.bIx("frameImage");
        paramScanCodeMaskView = localObject2;
      }
    }
    label211:
    for (;;)
    {
      paramScanCodeMaskView = paramScanCodeMaskView.animate();
      if (paramScanCodeMaskView != null)
      {
        paramScanCodeMaskView = paramScanCodeMaskView.alpha(1.0F);
        if (paramScanCodeMaskView != null)
        {
          paramScanCodeMaskView = paramScanCodeMaskView.setDuration(200L);
          if (paramScanCodeMaskView != null) {
            paramScanCodeMaskView.start();
          }
        }
      }
      AppMethodBeat.o(314841);
      return;
    }
  }
  
  public void Ck(boolean paramBoolean)
  {
    AppMethodBeat.i(52401);
    super.Ck(paramBoolean);
    getMyQrCodeButton().setAlpha(1.0F);
    Object localObject1 = ((Iterable)this.Pfu).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((View)((Iterator)localObject1).next()).setVisibility(8);
    }
    Object localObject2 = this.Pfr;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("multiCodeTips");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    localObject2 = this.Pfq;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("multiCodeBgMask");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject2 = this.Pfs;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("frameImage");
      localObject1 = null;
    }
    ((ImageView)localObject1).setVisibility(8);
    this.Pfz = false;
    this.Pfy = false;
    this.pointCount = 0;
    this.PeA = null;
    if (!paramBoolean)
    {
      Cr(true);
      localObject1 = getScanTips();
      if (localObject1 != null) {
        ((TextView)localObject1).setAlpha(1.0F);
      }
    }
    if (gTl()) {
      com.tencent.mm.plugin.scanner.util.p.a((View)this, 0.0F, 1.0F, 50L, null);
    }
    this.OHe.stopTimer();
    gPl();
    this.Pfw.removeAllListeners();
    this.Pfw.removeAllUpdateListeners();
    this.Pfw.cancel();
    AppMethodBeat.o(52401);
  }
  
  public final void Co(boolean paramBoolean)
  {
    AppMethodBeat.i(170066);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkLoading show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      gTn();
    }
    AppMethodBeat.o(170066);
  }
  
  protected final void a(long paramLong, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(315008);
    if (getMyQrCodeButton().getAlpha() == 1.0F) {}
    for (boolean bool = true;; bool = false)
    {
      ValueAnimator localValueAnimator = this.Pfw;
      localValueAnimator.removeAllUpdateListeners();
      localValueAnimator.removeAllListeners();
      localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
      localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
      localValueAnimator.setDuration(paramLong);
      localValueAnimator.addListener((Animator.AnimatorListener)new d(this));
      localValueAnimator.addUpdateListener(new ScanCodeMaskView..ExternalSyntheticLambda2(bool, this, paramAnimatorUpdateListener));
      localValueAnimator.start();
      AppMethodBeat.o(315008);
      return;
    }
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52399);
    super.a(paramAnimatorListener);
    this.AjF.cancel();
    if (this.Pft != null)
    {
      Bitmap localBitmap = this.Pft;
      s.checkNotNull(localBitmap);
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.Pft;
        s.checkNotNull(localBitmap);
        localBitmap.recycle();
      }
    }
    com.tencent.mm.plugin.scanner.util.p.a((View)this, 1.0F, 0.0F, 200L, (Animator.AnimatorListener)new ScanCodeMaskView.c(paramAnimatorListener, this));
    AppMethodBeat.o(52399);
  }
  
  public void a(Object paramObject, d paramd)
  {
    AppMethodBeat.i(52400);
    s.u(paramObject, "data");
    this.PeA = paramd;
    paramd = new ArrayList();
    HashSet localHashSet = new HashSet();
    if (((paramObject instanceof ArrayList)) && ((kotlin.a.p.oL((List)paramObject) instanceof WxQBarResult)))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((Iterable)paramObject).iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (localObject1 == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.qbar.WxQBarResult");
          AppMethodBeat.o(52400);
          throw paramObject;
        }
        paramObject = ((WxQBarResult)localObject1).ahru;
        if (paramObject != null)
        {
          s.s(paramObject, "codeResultPoint");
          Object localObject2;
          float f1;
          float f2;
          float f3;
          float f4;
          float f5;
          if ((paramObject.point_cnt == 4) && (getMPreviewRect() != null) && (getScanCamera() != null))
          {
            localObject2 = getScanCamera();
            s.checkNotNull(localObject2);
            if ((((com.tencent.mm.plugin.scanner.a.a)localObject2).jXE()) && (this.KWy))
            {
              f1 = paramObject.x0;
              f2 = paramObject.x1;
              f3 = paramObject.x2;
              f4 = paramObject.x3;
              localObject2 = getMPreviewRect();
              s.checkNotNull(localObject2);
              f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject2).height() * 4);
              f2 = paramObject.y0;
              f3 = paramObject.y1;
              f4 = paramObject.y2;
              f5 = paramObject.y3;
              paramObject = getMPreviewRect();
              s.checkNotNull(paramObject);
              paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.width() * 4));
              label301:
              if ((paramObject == null) || (getMScanRect() == null)) {
                break label566;
              }
              f1 = paramObject.x;
              localObject2 = getMScanRect();
              s.checkNotNull(localObject2);
              f2 = ((Rect)localObject2).width();
              localObject2 = getMScanRect();
              s.checkNotNull(localObject2);
              f3 = ((Rect)localObject2).left;
              f4 = paramObject.y;
              paramObject = getMScanRect();
              s.checkNotNull(paramObject);
              f5 = paramObject.height();
              paramObject = getMScanRect();
              s.checkNotNull(paramObject);
            }
          }
          label566:
          for (paramObject = new PointF(f1 * f2 + f3, f4 * f5 + paramObject.top);; paramObject = null)
          {
            localArrayList.add(paramObject);
            localHashSet.add(((WxQBarResult)localObject1).data);
            paramd.add(localObject1);
            break;
            f1 = paramObject.x0;
            f2 = paramObject.x1;
            f3 = paramObject.x2;
            f4 = paramObject.x3;
            localObject2 = getMPreviewRect();
            s.checkNotNull(localObject2);
            f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject2).width() * 4);
            f2 = paramObject.y0;
            f3 = paramObject.y1;
            f4 = paramObject.y2;
            f5 = paramObject.y3;
            paramObject = getMPreviewRect();
            s.checkNotNull(paramObject);
            paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.height() * 4));
            break label301;
            paramObject = null;
            break label301;
          }
        }
      }
      if ((localArrayList.size() > 1) && (localHashSet.size() == 1))
      {
        paramObject = (PointF)localArrayList.get(0);
        localArrayList.clear();
        localArrayList.add(paramObject);
      }
      i(localArrayList, bw(paramd));
    }
    AppMethodBeat.o(52400);
  }
  
  public final void dSg()
  {
    AppMethodBeat.i(52391);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo stopScanLineAnimation");
    this.AjF.cancel();
    AppMethodBeat.o(52391);
  }
  
  public final void gTe()
  {
    AppMethodBeat.i(52398);
    super.gTe();
    Log.v("MicroMsg.ScanCodeMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(52398);
  }
  
  protected boolean gTl()
  {
    return true;
  }
  
  public final void gTm()
  {
    AppMethodBeat.i(315028);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowResultInfoView show: %b", new Object[] { Boolean.TRUE });
    gTn();
    AppMethodBeat.o(315028);
  }
  
  protected int getLayoutId()
  {
    return l.g.OJV;
  }
  
  protected final View getMyQrCodeButton()
  {
    AppMethodBeat.i(314915);
    View localView = this.Pfp;
    if (localView != null)
    {
      AppMethodBeat.o(314915);
      return localView;
    }
    s.bIx("myQrCodeButton");
    AppMethodBeat.o(314915);
    return null;
  }
  
  protected final d getSuccessAnimationListener()
  {
    return this.PeA;
  }
  
  protected final ArrayList<View> getSuccessMarkViewList()
  {
    return this.Pfu;
  }
  
  protected final int getSuccessMarkViewSize()
  {
    return this.Pev;
  }
  
  public View getTargetSuccessMarkView()
  {
    AppMethodBeat.i(170065);
    if (this.Pfy)
    {
      localView = (View)kotlin.a.p.ae((List)this.Pfu, this.PfB);
      AppMethodBeat.o(170065);
      return localView;
    }
    View localView = (View)kotlin.a.p.ae((List)this.Pfu, 0);
    AppMethodBeat.o(170065);
    return localView;
  }
  
  protected void iS(View paramView)
  {
    AppMethodBeat.i(314959);
    s.u(paramView, "view");
    View localView = paramView.findViewById(l.f.scan_line);
    s.s(localView, "view.findViewById(R.id.scan_line)");
    this.Pfo = ((ImageView)localView);
    localView = paramView.findViewById(l.f.my_qr_code);
    s.s(localView, "view.findViewById(R.id.my_qr_code)");
    setMyQrCodeButton(localView);
    localView = paramView.findViewById(l.f.OIN);
    s.s(localView, "view.findViewById(R.id.multi_code_mask)");
    this.Pfq = localView;
    localView = paramView.findViewById(l.f.OIO);
    s.s(localView, "view.findViewById(R.id.multi_code_tips)");
    this.Pfr = ((TextView)localView);
    localView = paramView.findViewById(l.f.OIH);
    s.s(localView, "view.findViewById(R.id.frame_image)");
    this.Pfs = ((ImageView)localView);
    paramView = paramView.findViewById(l.f.scan_success_dot_view);
    if (paramView != null)
    {
      getSuccessMarkViewList().clear();
      getSuccessMarkViewList().add(paramView);
    }
    getMyQrCodeButton().setOnClickListener(new ScanCodeMaskView..ExternalSyntheticLambda3(this));
    gTk();
    this.Pfx = 0.16F;
    this.AjF.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.AjF.setDuration(2500L);
    this.AjF.addListener((Animator.AnimatorListener)new b(this));
    this.AjF.addUpdateListener(new ScanCodeMaskView..ExternalSyntheticLambda0(this));
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(-1);
    AppMethodBeat.o(314959);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52389);
    super.onMeasure(paramInt1, paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() != this.mbM))
    {
      this.mbM = getMeasuredWidth();
      gTk();
    }
    Object localObject3;
    Object localObject1;
    if (this.PfF)
    {
      PointF localPointF = this.PfE;
      localObject3 = this.Pfr;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("multiCodeTips");
        localObject1 = null;
      }
      localPointF.x = ((TextView)localObject1).getX();
      localObject3 = this.PfE;
      localObject1 = this.Pfr;
      if (localObject1 != null) {
        break label129;
      }
      s.bIx("multiCodeTips");
      localObject1 = localObject2;
    }
    label129:
    for (;;)
    {
      ((PointF)localObject3).y = ((TextView)localObject1).getY();
      AppMethodBeat.o(52389);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(52397);
    super.onPause();
    dSg();
    AppMethodBeat.o(52397);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(52396);
    super.onResume();
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo startScanLineAnimation");
    this.AjF.cancel();
    ImageView localImageView2 = this.Pfo;
    ImageView localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      s.bIx("scanLineImageView");
      localImageView1 = null;
    }
    localImageView1.setVisibility(0);
    this.AjF.start();
    AppMethodBeat.o(52396);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52402);
    super.release();
    this.OHe.stopTimer();
    gPl();
    AppMethodBeat.o(52402);
  }
  
  public final void setAnimationRect(Rect paramRect)
  {
    ah localah = null;
    AppMethodBeat.i(52390);
    s.u(paramRect, "rect");
    this.mRect.set(paramRect);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo setAnimationRect %s", new Object[] { paramRect });
    paramRect = this.Pfo;
    Object localObject;
    if (paramRect == null)
    {
      s.bIx("scanLineImageView");
      paramRect = null;
      ImageView localImageView = this.Pfo;
      localObject = localImageView;
      if (localImageView == null)
      {
        s.bIx("scanLineImageView");
        localObject = null;
      }
      localObject = ((ImageView)localObject).getLayoutParams();
      if (localObject != null) {
        break label137;
      }
      localObject = localah;
    }
    for (;;)
    {
      paramRect.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.AjF.setFloatValues(new float[] { this.mRect.top, this.mRect.bottom });
      AppMethodBeat.o(52390);
      return;
      break;
      label137:
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = this.mRect.left;
      }
      localah = ah.aiuX;
    }
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    AppMethodBeat.i(52395);
    super.setBottomExtraHeight(paramInt);
    View localView = getMyQrCodeButton();
    ViewGroup.LayoutParams localLayoutParams = getMyQrCodeButton().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight());
    }
    ah localah = ah.aiuX;
    localView.setLayoutParams(localLayoutParams);
    aiw(120);
    AppMethodBeat.o(52395);
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170063);
    super.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    com.tencent.threadpool.h.ahAA.bm(new ScanCodeMaskView..ExternalSyntheticLambda7(this, paramScanDecodeFrameData));
    AppMethodBeat.o(170063);
  }
  
  protected final void setMyQrCodeButton(View paramView)
  {
    AppMethodBeat.i(314920);
    s.u(paramView, "<set-?>");
    this.Pfp = paramView;
    AppMethodBeat.o(314920);
  }
  
  public final void setMyQrCodeButtonVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(314971);
    View localView = getMyQrCodeButton();
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(314971);
      return;
    }
  }
  
  public final void setNeedRotate(boolean paramBoolean)
  {
    this.KWy = paramBoolean;
  }
  
  protected final void setSuccessAnimationListener(d paramd)
  {
    this.PeA = paramd;
  }
  
  public final void setSuccessMarkClickListener(an paraman)
  {
    AppMethodBeat.i(170062);
    s.u(paraman, "successMarkClickListener");
    this.PfA = paraman;
    AppMethodBeat.o(170062);
  }
  
  protected final void setSuccessMarkViewList(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(314931);
    s.u(paramArrayList, "<set-?>");
    this.Pfu = paramArrayList;
    AppMethodBeat.o(314931);
  }
  
  protected final void setSuccessMarkViewSize(int paramInt)
  {
    this.Pev = paramInt;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScanLineAnimator$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52379);
      ImageView localImageView = ScanCodeMaskView.b(this.PfG);
      paramAnimator = localImageView;
      if (localImageView == null)
      {
        s.bIx("scanLineImageView");
        paramAnimator = null;
      }
      paramAnimator.setVisibility(8);
      AppMethodBeat.o(52379);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runSuccessAnimator$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314814);
      Log.v("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView onAnimationEnd");
      paramAnimator = this.PfG.getSuccessAnimationListener();
      if (paramAnimator != null) {
        if (ScanCodeMaskView.d(this.PfG)) {
          break label49;
        }
      }
      label49:
      for (boolean bool = true;; bool = false)
      {
        paramAnimator.BY(bool);
        AppMethodBeat.o(314814);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(314824);
      this.PfG.getSuccessAnimationListener();
      AppMethodBeat.o(314824);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(ScanCodeMaskView paramScanCodeMaskView, ScanCodeMaskView.f paramf) {}
    
    private static final void a(ScanCodeMaskView paramScanCodeMaskView, ScanCodeMaskView.f paramf)
    {
      AppMethodBeat.i(314813);
      s.u(paramScanCodeMaskView, "this$0");
      s.u(paramf, "$animatorListener");
      ScanCodeMaskView.a(paramScanCodeMaskView, (Animator.AnimatorListener)paramf);
      AppMethodBeat.o(314813);
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170049);
      MMHandlerThread.postToMainThreadDelayed(new ScanCodeMaskView.e..ExternalSyntheticLambda0(this.PfG, this.PfH), 50L);
      AppMethodBeat.o(170049);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Animator.AnimatorListener
  {
    f(int paramInt, ScanCodeMaskView paramScanCodeMaskView) {}
    
    private static final void a(int paramInt, ScanCodeMaskView paramScanCodeMaskView)
    {
      AppMethodBeat.i(314795);
      s.u(paramScanCodeMaskView, "this$0");
      if (paramInt < 2) {
        ScanCodeMaskView.a(paramScanCodeMaskView, paramInt + 1);
      }
      AppMethodBeat.o(314795);
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170051);
      MMHandlerThread.postToMainThreadDelayed(new ScanCodeMaskView.f..ExternalSyntheticLambda0(this.OHl, jdField_this), 50L);
      AppMethodBeat.o(170051);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements Animator.AnimatorListener
  {
    g(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314812);
      ScanCodeMaskView.c(this.PfG);
      AppMethodBeat.o(314812);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView
 * JD-Core Version:    0.7.0.1
 */