package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import d.a.j;
import d.g.b.k;
import d.g.b.v.a;
import d.g.b.v.f;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "alphaAnimationDistanceFactor", "", "canUpdateMultiCodeTipsDefaultPos", "", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "frameBitmap", "Landroid/graphics/Bitmap;", "frameImage", "Landroid/widget/ImageView;", "isMultiCode", "isShowingSuccessView", "mRect", "Landroid/graphics/Rect;", "multiCodeBgMask", "Landroid/view/View;", "multiCodeTips", "Landroid/widget/TextView;", "multiCodeTipsCurrentBottomMargin", "multiCodeTipsDefaultPosition", "Landroid/graphics/PointF;", "myQrCodeButton", "needRotate", "pointCount", "scaleAnimationTimer", "Ljava/util/Timer;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleTimerTask", "Ljava/util/TimerTask;", "scanLineAnimator", "scanLineImageView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successAnimator", "successMarkClickIndex", "successMarkClickListener", "Lcom/tencent/mm/plugin/scanner/model/ScanSuccessMarkClickListener;", "successMarkViewCheckSize", "successMarkViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "successMarkViewSize", "viewWidth", "addSuccessView", "attachFlashSwitcherView", "", "flashSwitcher", "cancelScaleAnimator", "cancelScaleTimer", "cancelSuccessAnimator", "checkMultiCodeTipsPositionValid", "x", "y", "computeCenterPosition", "scanCodeResultPoint", "Lcom/tencent/qbar/WxQBarPoint;", "computeRealPosition", "pos", "fixMultiCodeTipsPosition", "valid", "getFrameBitmap", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getTargetSuccessMarkView", "init", "initDefaultRect", "initScaleAnimation", "initScanLineAnimator", "onBackPressed", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "onShowNetworkLoading", "show", "onShowNetworkUnconnectedView", "onShowNetworkWeakView", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleFrameBitmap", "release", "rotateAndScaleBitmap", "bitmap", "rotation", "targetWidth", "targetHeight", "runScaleAnimation", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setAnimationRect", "rect", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setMyQrCodeButtonVisible", "visible", "setNeedRotate", "setSuccessMarkClickListener", "showSuccessView", "pointList", "startScanLineAnimation", "stopScanLineAnimation", "updateMultiCodeTipsBottomMargin", "margin", "Companion", "plugin-scan_release"})
public final class ScanCodeMaskView
  extends BaseScanMaskView<BaseScanRequest>
{
  public static final ScanCodeMaskView.a xjI;
  private int fMt;
  private Rect mRect;
  private ValueAnimator pmy;
  private int pointCount;
  private ValueAnimator qPb;
  private boolean uMf;
  private int xil;
  private c xip;
  private int xjA;
  private Timer xjB;
  private TimerTask xjC;
  private AccelerateInterpolator xjD;
  private DecelerateInterpolator xjE;
  private int xjF;
  private PointF xjG;
  private boolean xjH;
  private ImageView xjn;
  private View xjo;
  private View xjp;
  private TextView xjq;
  private ImageView xjr;
  private Bitmap xjs;
  private ArrayList<View> xjt;
  private int xju;
  private ValueAnimator xjv;
  private float xjw;
  private boolean xjx;
  private boolean xjy;
  private aa xjz;
  
  static
  {
    AppMethodBeat.i(52406);
    xjI = new ScanCodeMaskView.a((byte)0);
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
    this.xjt = new ArrayList();
    this.xil = getResources().getDimensionPixelSize(2131166772);
    this.xju = (this.xil - getResources().getDimensionPixelSize(2131165516) * 2 + getResources().getDimensionPixelSize(2131165575) * 2);
    this.xjv = new ValueAnimator();
    this.qPb = new ValueAnimator();
    this.mRect = new Rect(0, 0, 0, 0);
    this.xjA = -1;
    this.xjD = new AccelerateInterpolator(1.5F);
    this.xjE = new DecelerateInterpolator(1.5F);
    this.xjF = 120;
    this.xjG = new PointF();
    this.xjH = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494564, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(2131304314);
    k.g(localView, "view.findViewById(R.id.scan_line)");
    this.xjn = ((ImageView)localView);
    localView = paramAttributeSet.findViewById(2131302650);
    k.g(localView, "view.findViewById(R.id.my_qr_code)");
    this.xjo = localView;
    localView = paramAttributeSet.findViewById(2131302561);
    k.g(localView, "view.findViewById(R.id.multi_code_mask)");
    this.xjp = localView;
    localView = paramAttributeSet.findViewById(2131302562);
    k.g(localView, "view.findViewById(R.id.multi_code_tips)");
    this.xjq = ((TextView)localView);
    localView = paramAttributeSet.findViewById(2131300239);
    k.g(localView, "view.findViewById(R.id.frame_image)");
    this.xjr = ((ImageView)localView);
    paramAttributeSet = paramAttributeSet.findViewById(2131304331);
    if (paramAttributeSet != null)
    {
      this.xjt.clear();
      this.xjt.add(paramAttributeSet);
    }
    paramAttributeSet = this.xjo;
    if (paramAttributeSet == null) {
      k.aVY("myQrCodeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new ScanCodeMaskView.b(paramContext));
    dAW();
    this.xjw = 0.16F;
    this.qPb.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.qPb.setDuration(2500L);
    this.qPb.addListener((Animator.AnimatorListener)new ScanCodeMaskView.d(this));
    this.qPb.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanCodeMaskView.e(this));
    this.qPb.setRepeatMode(1);
    this.qPb.setRepeatCount(-1);
    AppMethodBeat.o(52405);
  }
  
  private final void Nn(int paramInt)
  {
    AppMethodBeat.i(199669);
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo updateMultiCodeTipsBottomMargin: %d", new Object[] { Integer.valueOf(paramInt) });
    TextView localTextView = this.xjq;
    if (localTextView == null) {
      k.aVY("multiCodeTips");
    }
    Object localObject = this.xjq;
    if (localObject == null) {
      k.aVY("multiCodeTips");
    }
    localObject = ((TextView)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      this.xjF = paramInt;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(getContext(), paramInt) + getMBottomExtraHeight());
    }
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(199669);
  }
  
  private final void No(final int paramInt)
  {
    AppMethodBeat.i(170057);
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation %d", new Object[] { Integer.valueOf(paramInt) });
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new h(this, new i(this, paramInt));
    a(1.0F, 0.8F, (Interpolator)this.xjD, localAnimatorListener);
    AppMethodBeat.o(170057);
  }
  
  private final Bitmap a(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170064);
    for (;;)
    {
      try
      {
        Object localObject1 = getScanCamera();
        if (localObject1 == null) {
          k.fOy();
        }
        int i = ((com.tencent.mm.plugin.scanner.a.a)localObject1).getPreviewFormat();
        localObject1 = getScanCamera();
        if (localObject1 == null) {
          k.fOy();
        }
        localObject1 = ((com.tencent.mm.plugin.scanner.a.a)localObject1).fCS();
        if (paramScanDecodeFrameData != null)
        {
          Object localObject2 = paramScanDecodeFrameData.wXN;
          if (localObject2 != null)
          {
            ac.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap data length: %d, size: %d, %d, rotation: %d, previewFormat: %d", new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(paramScanDecodeFrameData.width), Integer.valueOf(paramScanDecodeFrameData.height), Integer.valueOf(paramScanDecodeFrameData.qyr), Integer.valueOf(i) });
            localObject2 = new YuvImage(paramScanDecodeFrameData.wXN, i, ((Point)localObject1).x, ((Point)localObject1).y, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((Point)localObject1).x, ((Point)localObject1).y), 100, (OutputStream)localByteArrayOutputStream);
            localObject1 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
            {
              ac.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap bitmap width: %d, height: %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
              if (paramScanDecodeFrameData.qyr != 0)
              {
                i = paramScanDecodeFrameData.qyr;
                int i3 = getMeasuredWidth();
                int i4 = getMeasuredHeight();
                if (localObject1 == null)
                {
                  AppMethodBeat.o(170064);
                  return null;
                }
                ac.i("MicroMsg.ScanCodeMaskView", "alvinlu rotateAndScaleBitmap rotation: %d, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4) });
                paramScanDecodeFrameData = new Matrix();
                paramScanDecodeFrameData.postRotate(i);
                if (i % 180 == 0) {
                  break label672;
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
                    ac.i("MicroMsg.ScanCodeMaskView", "alvinluo rotateAndScaleBitmap finalWidth: %d, finalHeight: %d, x: %d, y: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
                    if (n == 0) {
                      continue;
                    }
                    paramScanDecodeFrameData = Bitmap.createBitmap((Bitmap)localObject1, j, i, k, m, paramScanDecodeFrameData, true);
                    if (((k.g(paramScanDecodeFrameData, localObject1) ^ true)) && (!((Bitmap)localObject1).isRecycled())) {
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
        ac.printErrStackTrace("MicroMsg.ScanCodeMaskView", (Throwable)paramScanDecodeFrameData, "alvinluo getFrameBitmap exception", new Object[0]);
        AppMethodBeat.o(170064);
        return null;
      }
      label672:
      int n = 0;
    }
  }
  
  private final void a(float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(170058);
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    dAY();
    this.pmy = new ValueAnimator();
    ValueAnimator localValueAnimator = this.pmy;
    if (localValueAnimator != null)
    {
      localValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
      localValueAnimator.setInterpolator((TimeInterpolator)paramInterpolator);
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanCodeMaskView.g(this, paramFloat1, paramFloat2, paramInterpolator, paramAnimatorListener));
      localValueAnimator.addListener(paramAnimatorListener);
      localValueAnimator.start();
      AppMethodBeat.o(170058);
      return;
    }
    AppMethodBeat.o(170058);
  }
  
  private final void ax(ArrayList<PointF> paramArrayList)
  {
    AppMethodBeat.i(170056);
    ac.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView pointList %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.pointCount = 0;
    this.xjy = true;
    final v.a locala = new v.a();
    locala.KUL = true;
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      final PointF localPointF = (PointF)paramArrayList.next();
      if (localPointF != null)
      {
        final v.f localf = new v.f();
        localf.KUQ = ((View)j.C((List)this.xjt, this.pointCount));
        if ((View)localf.KUQ == null)
        {
          localView = LayoutInflater.from(getContext()).inflate(2131494565, null);
          addView(localView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.xil, this.xil));
          k.g(localView, "view");
          localf.KUQ = localView;
          this.xjt.add((View)localf.KUQ);
        }
        View localView = (View)localf.KUQ;
        Object localObject = (ImageView)localView.findViewById(2131304331);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2131691123);
        }
        localView.setVisibility(0);
        localView.setPivotX(this.xil / 2.0F);
        localView.setPivotY(this.xil / 2.0F);
        localView.setTranslationX(localPointF.x - this.xil / 2);
        localView.setTranslationY(localPointF.y - this.xil / 2);
        localView.setAlpha(0.0F);
        localView.setScaleX(0.0F);
        localView.setScaleY(0.0F);
        float f2 = localPointF.x;
        float f1 = localPointF.y;
        float f3 = this.xjG.x;
        float f4 = this.xjG.y;
        localObject = this.xjq;
        if (localObject == null) {
          k.aVY("multiCodeTips");
        }
        i = ((TextView)localObject).getMeasuredWidth();
        localObject = this.xjq;
        if (localObject == null) {
          k.aVY("multiCodeTips");
        }
        ac.i("MicroMsg.ScanCodeMaskView", "alvinluo checkMultiCodeTipsPositionValid [%s, %s], multiCodeTips: [%s, %s], [%s, %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i), Integer.valueOf(((TextView)localObject).getMeasuredHeight()) });
        if (this.xju / 2 + f2 >= this.xjG.x)
        {
          f3 = this.xju / 2;
          f4 = this.xjG.x;
          localObject = this.xjq;
          if (localObject == null) {
            k.aVY("multiCodeTips");
          }
          if ((f2 - f3 <= f4 + ((TextView)localObject).getMeasuredWidth()) && (this.xju / 2 + f1 >= this.xjG.y))
          {
            f2 = this.xju / 2;
            f3 = this.xjG.y;
            localObject = this.xjq;
            if (localObject == null) {
              k.aVY("multiCodeTips");
            }
            if (f1 - f2 <= f3 + ((TextView)localObject).getMeasuredHeight()) {
              break label651;
            }
          }
        }
        label651:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            locala.KUL = false;
          }
          localView.setOnClickListener((View.OnClickListener)new m(this.pointCount, localPointF, localf, this, locala));
          this.pointCount += 1;
          break;
        }
      }
    }
    int i = this.pointCount;
    int j = this.xjt.size();
    while (i < j)
    {
      paramArrayList = (View)j.C((List)this.xjt, i);
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
      i += 1;
    }
    boolean bool;
    if (this.pointCount > 1)
    {
      bool = true;
      this.xjx = bool;
      if (this.xjx) {
        break label1069;
      }
      paramArrayList = (View)j.iP((List)this.xjt);
      if (paramArrayList != null)
      {
        paramArrayList = (ImageView)paramArrayList.findViewById(2131304331);
        if (paramArrayList != null) {
          paramArrayList.setImageResource(2131691122);
        }
      }
      paramArrayList = this.xjp;
      if (paramArrayList == null) {
        k.aVY("multiCodeBgMask");
      }
      paramArrayList.setVisibility(8);
      paramArrayList = this.xjq;
      if (paramArrayList == null) {
        k.aVY("multiCodeTips");
      }
      paramArrayList.setVisibility(4);
    }
    for (;;)
    {
      ac.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView isMultiCode: %b, pointCount: %d, successMarkViewList: %d, tipsPositionValid: %b", new Object[] { Boolean.valueOf(this.xjx), Integer.valueOf(this.pointCount), Integer.valueOf(this.xjt.size()), Boolean.valueOf(locala.KUL) });
      paramArrayList = this.xjv;
      paramArrayList.removeAllUpdateListeners();
      paramArrayList.removeAllListeners();
      paramArrayList.setFloatValues(new float[] { 0.0F, 1.0F });
      paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
      paramArrayList.setDuration(300L);
      paramArrayList.addListener((Animator.AnimatorListener)new k(this));
      paramArrayList.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanCodeMaskView.l(this));
      paramArrayList.start();
      if (!this.xjx) {
        break label1238;
      }
      paramArrayList = this.xjp;
      if (paramArrayList == null) {
        k.aVY("multiCodeBgMask");
      }
      paramArrayList = paramArrayList.animate();
      if (paramArrayList == null) {
        break label1238;
      }
      paramArrayList = paramArrayList.alpha(1.0F);
      if (paramArrayList == null) {
        break label1238;
      }
      paramArrayList = paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
      if (paramArrayList == null) {
        break label1238;
      }
      paramArrayList = paramArrayList.setDuration(600L);
      if (paramArrayList == null) {
        break label1238;
      }
      paramArrayList = paramArrayList.setListener((Animator.AnimatorListener)new ScanCodeMaskView.n(this));
      if (paramArrayList == null) {
        break label1238;
      }
      paramArrayList.start();
      AppMethodBeat.o(170056);
      return;
      bool = false;
      break;
      label1069:
      paramArrayList = this.xjp;
      if (paramArrayList == null) {
        k.aVY("multiCodeBgMask");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.xjp;
      if (paramArrayList == null) {
        k.aVY("multiCodeBgMask");
      }
      paramArrayList.setAlpha(0.0F);
      paramArrayList = this.xjq;
      if (paramArrayList == null) {
        k.aVY("multiCodeTips");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.xjq;
      if (paramArrayList == null) {
        k.aVY("multiCodeTips");
      }
      paramArrayList.setAlpha(0.0F);
      bool = locala.KUL;
      ac.d("MicroMsg.ScanCodeMaskView", "alvinluo fixMultiCodeTipsPosition valid: %b, current: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.xjF) });
      this.xjH = false;
      if ((!bool) && (this.xjF != 32)) {
        Nn(32);
      } else if ((bool) && (this.xjF != 120)) {
        Nn(120);
      }
    }
    label1238:
    AppMethodBeat.o(170056);
  }
  
  private final void dAW()
  {
    AppMethodBeat.i(52388);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    setAnimationRect(new Rect(0, (int)(0.15F * j), i, (int)(j * 0.6F)));
    AppMethodBeat.o(52388);
  }
  
  private final void dAX()
  {
    AppMethodBeat.i(170060);
    Object localObject = this.xjB;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.xjC;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    this.xjB = null;
    this.xjC = null;
    AppMethodBeat.o(170060);
  }
  
  private final void dAY()
  {
    AppMethodBeat.i(170061);
    ValueAnimator localValueAnimator = this.pmy;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.pmy;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    localValueAnimator = this.pmy;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.pmy = null;
    AppMethodBeat.o(170061);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52399);
    super.a(paramAnimatorListener);
    this.qPb.cancel();
    if (this.xjs != null)
    {
      Bitmap localBitmap = this.xjs;
      if (localBitmap == null) {
        k.fOy();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.xjs;
        if (localBitmap == null) {
          k.fOy();
        }
        localBitmap.recycle();
      }
    }
    a((View)this, 1.0F, 0.0F, (Animator.AnimatorListener)new ScanCodeMaskView.f(this, paramAnimatorListener));
    AppMethodBeat.o(52399);
  }
  
  public final void a(Object paramObject, c paramc)
  {
    AppMethodBeat.i(52400);
    k.h(paramObject, "data");
    this.xip = paramc;
    if (((paramObject instanceof ArrayList)) && ((j.iP((List)paramObject) instanceof WxQBarResult)))
    {
      paramc = new ArrayList();
      Iterator localIterator = ((Iterable)paramObject).iterator();
      while (localIterator.hasNext())
      {
        paramObject = localIterator.next();
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type com.tencent.qbar.WxQBarResult");
          AppMethodBeat.o(52400);
          throw paramObject;
        }
        paramObject = ((WxQBarResult)paramObject).JQY;
        if (paramObject != null)
        {
          Object localObject;
          float f1;
          float f2;
          float f3;
          float f4;
          float f5;
          if ((paramObject.point_cnt == 4) && (getMPreviewRect() != null) && (getScanCamera() != null))
          {
            localObject = getScanCamera();
            if (localObject == null) {
              k.fOy();
            }
            if ((((com.tencent.mm.plugin.scanner.a.a)localObject).fCR()) && (this.uMf))
            {
              f1 = paramObject.x0;
              f2 = paramObject.x1;
              f3 = paramObject.x2;
              f4 = paramObject.x3;
              localObject = getMPreviewRect();
              if (localObject == null) {
                k.fOy();
              }
              f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject).height() * 4);
              f2 = paramObject.y0;
              f3 = paramObject.y1;
              f4 = paramObject.y2;
              f5 = paramObject.y3;
              paramObject = getMPreviewRect();
              if (paramObject == null) {
                k.fOy();
              }
              paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.width() * 4));
              label282:
              if ((paramObject == null) || (getMScanRect() == null)) {
                break label543;
              }
              f1 = paramObject.x;
              localObject = getMScanRect();
              if (localObject == null) {
                k.fOy();
              }
              f2 = ((Rect)localObject).width();
              localObject = getMScanRect();
              if (localObject == null) {
                k.fOy();
              }
              f3 = ((Rect)localObject).left;
              f4 = paramObject.y;
              paramObject = getMScanRect();
              if (paramObject == null) {
                k.fOy();
              }
              f5 = paramObject.height();
              paramObject = getMScanRect();
              if (paramObject == null) {
                k.fOy();
              }
            }
          }
          label543:
          for (paramObject = new PointF(f1 * f2 + f3, f4 * f5 + paramObject.top);; paramObject = null)
          {
            paramc.add(paramObject);
            break;
            f1 = paramObject.x0;
            f2 = paramObject.x1;
            f3 = paramObject.x2;
            f4 = paramObject.x3;
            localObject = getMPreviewRect();
            if (localObject == null) {
              k.fOy();
            }
            f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject).width() * 4);
            f2 = paramObject.y0;
            f3 = paramObject.y1;
            f4 = paramObject.y2;
            f5 = paramObject.y3;
            paramObject = getMPreviewRect();
            if (paramObject == null) {
              k.fOy();
            }
            paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.height() * 4));
            break label282;
            paramObject = null;
            break label282;
          }
        }
      }
      ax(paramc);
    }
    AppMethodBeat.o(52400);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(52391);
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo stopScanLineAnimation");
    this.qPb.cancel();
    AppMethodBeat.o(52391);
  }
  
  public final void dAP()
  {
    AppMethodBeat.i(52398);
    super.dAP();
    ac.v("MicroMsg.ScanCodeMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(52398);
  }
  
  public final void dAZ()
  {
    AppMethodBeat.i(170067);
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkUnconnectedView show: %b", new Object[] { Boolean.TRUE });
    if (this.xjx)
    {
      Object localObject = this.xjp;
      if (localObject == null) {
        k.aVY("multiCodeBgMask");
      }
      ((View)localObject).setVisibility(8);
      this.xjy = false;
      localObject = ((Iterable)this.xjt).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setAlpha(0.0F);
      }
      dAX();
      dAY();
      localObject = this.xjq;
      if (localObject == null) {
        k.aVY("multiCodeTips");
      }
      a((View)localObject, 1.0F, 0.0F, null);
    }
    AppMethodBeat.o(170067);
  }
  
  public final void dBa()
  {
    AppMethodBeat.i(199670);
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkWeakView show: %b", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(199670);
  }
  
  public final void ev(View paramView)
  {
    AppMethodBeat.i(52394);
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
        AppMethodBeat.o(52394);
        return;
        paramView = null;
      }
    }
    AppMethodBeat.o(52394);
  }
  
  public final View getTargetSuccessMarkView()
  {
    AppMethodBeat.i(170065);
    if (this.xjx)
    {
      localView = (View)j.C((List)this.xjt, this.xjA);
      AppMethodBeat.o(170065);
      return localView;
    }
    View localView = (View)j.C((List)this.xjt, 0);
    AppMethodBeat.o(170065);
    return localView;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(170059);
    if ((this.xjx) && (this.xjy))
    {
      AppMethodBeat.o(170059);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(170059);
    return bool;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52389);
    super.onMeasure(paramInt1, paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() != this.fMt))
    {
      this.fMt = getMeasuredWidth();
      dAW();
    }
    if (this.xjH)
    {
      PointF localPointF = this.xjG;
      TextView localTextView = this.xjq;
      if (localTextView == null) {
        k.aVY("multiCodeTips");
      }
      localPointF.x = localTextView.getX();
      localPointF = this.xjG;
      localTextView = this.xjq;
      if (localTextView == null) {
        k.aVY("multiCodeTips");
      }
      localPointF.y = localTextView.getY();
    }
    AppMethodBeat.o(52389);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(52397);
    super.onPause();
    cqU();
    AppMethodBeat.o(52397);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(52396);
    super.onResume();
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo startScanLineAnimation");
    this.qPb.cancel();
    ImageView localImageView = this.xjn;
    if (localImageView == null) {
      k.aVY("scanLineImageView");
    }
    localImageView.setVisibility(0);
    this.qPb.start();
    AppMethodBeat.o(52396);
  }
  
  public final void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(52401);
    super.qb(paramBoolean);
    Object localObject = this.xjo;
    if (localObject == null) {
      k.aVY("myQrCodeButton");
    }
    ((View)localObject).setAlpha(1.0F);
    localObject = ((Iterable)this.xjt).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.xjq;
    if (localObject == null) {
      k.aVY("multiCodeTips");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.xjp;
    if (localObject == null) {
      k.aVY("multiCodeBgMask");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.xjr;
    if (localObject == null) {
      k.aVY("frameImage");
    }
    ((ImageView)localObject).setVisibility(8);
    this.xjy = false;
    this.xjx = false;
    if (!paramBoolean)
    {
      localObject = getScanTips();
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = getScanTips();
      if (localObject != null) {
        ((TextView)localObject).setAlpha(1.0F);
      }
    }
    a((View)this, 0.0F, 1.0F, null);
    dAX();
    dAY();
    this.xjv.removeAllListeners();
    this.xjv.removeAllUpdateListeners();
    this.xjv.cancel();
    AppMethodBeat.o(52401);
  }
  
  public final void qd(boolean paramBoolean)
  {
    AppMethodBeat.i(170066);
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkLoading show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (this.xjx))
    {
      Object localObject = this.xjp;
      if (localObject == null) {
        k.aVY("multiCodeBgMask");
      }
      ((View)localObject).setVisibility(8);
      this.xjy = false;
      localObject = ((Iterable)this.xjt).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setAlpha(0.0F);
      }
      dAX();
      dAY();
      localObject = this.xjq;
      if (localObject == null) {
        k.aVY("multiCodeTips");
      }
      a((View)localObject, 1.0F, 0.0F, null);
    }
    AppMethodBeat.o(170066);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52402);
    super.release();
    dAX();
    dAY();
    AppMethodBeat.o(52402);
  }
  
  public final void setAnimationRect(Rect paramRect)
  {
    AppMethodBeat.i(52390);
    k.h(paramRect, "rect");
    this.mRect.set(paramRect);
    ac.d("MicroMsg.ScanCodeMaskView", "alvinluo setAnimationRect %s", new Object[] { paramRect });
    ImageView localImageView = this.xjn;
    if (localImageView == null) {
      k.aVY("scanLineImageView");
    }
    paramRect = this.xjn;
    if (paramRect == null) {
      k.aVY("scanLineImageView");
    }
    paramRect = paramRect.getLayoutParams();
    if (paramRect != null) {
      if ((paramRect instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramRect).leftMargin = this.mRect.left;
      }
    }
    for (;;)
    {
      localImageView.setLayoutParams(paramRect);
      this.qPb.setFloatValues(new float[] { this.mRect.top, this.mRect.bottom });
      AppMethodBeat.o(52390);
      return;
      paramRect = null;
    }
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    AppMethodBeat.i(52395);
    super.setBottomExtraHeight(paramInt);
    View localView = this.xjo;
    if (localView == null) {
      k.aVY("myQrCodeButton");
    }
    Object localObject = this.xjo;
    if (localObject == null) {
      k.aVY("myQrCodeButton");
    }
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight());
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    Nn(120);
    AppMethodBeat.o(52395);
  }
  
  public final void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170063);
    super.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    h.JZN.aS((Runnable)new ScanCodeMaskView.j(this, paramScanDecodeFrameData));
    AppMethodBeat.o(170063);
  }
  
  public final void setMyQrCodeButtonVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(199668);
    View localView = this.xjo;
    if (localView == null) {
      k.aVY("myQrCodeButton");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(199668);
      return;
    }
  }
  
  public final void setNeedRotate(boolean paramBoolean)
  {
    this.uMf = paramBoolean;
  }
  
  public final void setSuccessMarkClickListener(aa paramaa)
  {
    AppMethodBeat.i(170062);
    k.h(paramaa, "successMarkClickListener");
    this.xjz = paramaa;
    AppMethodBeat.o(170062);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScaleAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class c
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(170046);
      ap.f((Runnable)new a(this));
      AppMethodBeat.o(170046);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(170045);
        ScanCodeMaskView.m(this.xjK.xjJ);
        AppMethodBeat.o(170045);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(ScanCodeMaskView.i parami) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170049);
      ap.n((Runnable)new a(this), 50L);
      AppMethodBeat.o(170049);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(170048);
        ScanCodeMaskView.a(this.xjR.xjJ, (Animator.AnimatorListener)this.xjR.xjQ);
        AppMethodBeat.o(170048);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    i(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170051);
      ap.n((Runnable)new a(this), 50L);
      AppMethodBeat.o(170051);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(170050);
        if (this.xjT.xjS < 2) {
          ScanCodeMaskView.b(this.xjT.xjJ, this.xjT.xjS + 1);
        }
        AppMethodBeat.o(170050);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class k
    implements Animator.AnimatorListener
  {
    k(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52385);
      ac.v("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView onAnimationEnd");
      paramAnimator = ScanCodeMaskView.f(this.xjJ);
      if (paramAnimator != null)
      {
        paramAnimator.dAf();
        AppMethodBeat.o(52385);
        return;
      }
      AppMethodBeat.o(52385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(52386);
      ScanCodeMaskView.f(this.xjJ);
      AppMethodBeat.o(52386);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$1$1$1", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$$special$$inlined$apply$lambda$1"})
  static final class m
    implements View.OnClickListener
  {
    m(int paramInt, PointF paramPointF, v.f paramf, ScanCodeMaskView paramScanCodeMaskView, v.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(170054);
      ScanCodeMaskView.a(jdField_this, this.nBr);
      paramView = ScanCodeMaskView.d(jdField_this);
      if (paramView != null) {
        paramView.Ne(this.nBr);
      }
      paramView = ((Iterable)ScanCodeMaskView.e(jdField_this)).iterator();
      while (paramView.hasNext()) {
        ((View)paramView.next()).setOnClickListener(null);
      }
      AppMethodBeat.o(170054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView
 * JD-Core Version:    0.7.0.1
 */