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
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import d.a.j;
import d.g.b.k;
import d.g.b.v.a;
import d.g.b.v.e;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "alphaAnimationDistanceFactor", "", "canUpdateMultiCodeTipsDefaultPos", "", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "frameBitmap", "Landroid/graphics/Bitmap;", "frameImage", "Landroid/widget/ImageView;", "isMultiCode", "isShowingSuccessView", "mRect", "Landroid/graphics/Rect;", "multiCodeBgMask", "Landroid/view/View;", "multiCodeTips", "Landroid/widget/TextView;", "multiCodeTipsCurrentBottomMargin", "multiCodeTipsDefaultPosition", "Landroid/graphics/PointF;", "myQrCodeButton", "needRotate", "pointCount", "scaleAnimationTimer", "Ljava/util/Timer;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleTimerTask", "Ljava/util/TimerTask;", "scanLineAnimator", "scanLineImageView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successAnimator", "successMarkClickIndex", "successMarkClickListener", "Lcom/tencent/mm/plugin/scanner/model/ScanSuccessMarkClickListener;", "successMarkViewCheckSize", "successMarkViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "successMarkViewSize", "viewWidth", "addSuccessView", "attachFlashSwitcherView", "", "flashSwitcher", "cancelScaleAnimator", "cancelScaleTimer", "cancelSuccessAnimator", "checkMultiCodeTipsPositionValid", "x", "y", "computeCenterPosition", "scanCodeResultPoint", "Lcom/tencent/qbar/WxQBarPoint;", "computeRealPosition", "pos", "fixMultiCodeTipsPosition", "valid", "getFrameBitmap", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getTargetSuccessMarkView", "init", "initDefaultRect", "initScaleAnimation", "initScanLineAnimator", "onBackPressed", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "onShowNetworkLoading", "show", "onShowNetworkUnconnectedView", "onShowNetworkWeakView", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleFrameBitmap", "release", "rotateAndScaleBitmap", "bitmap", "rotation", "targetWidth", "targetHeight", "runScaleAnimation", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setAnimationRect", "rect", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setNeedRotate", "setSuccessMarkClickListener", "showSuccessView", "pointList", "startScanLineAnimation", "stopScanLineAnimation", "updateMultiCodeTipsBottomMargin", "margin", "Companion", "plugin-scan_release"})
public final class ScanCodeMaskView
  extends BaseScanMaskView
{
  public static final a vYB;
  private int fIN;
  private Rect mRect;
  private ValueAnimator oIY;
  private int pointCount;
  private ValueAnimator qgz;
  private boolean tDK;
  private int vXl;
  private c vXn;
  private boolean vYA;
  private ImageView vYg;
  private View vYh;
  private View vYi;
  private TextView vYj;
  private ImageView vYk;
  private Bitmap vYl;
  private ArrayList<View> vYm;
  private int vYn;
  private ValueAnimator vYo;
  private float vYp;
  private boolean vYq;
  private boolean vYr;
  private y vYs;
  private int vYt;
  private Timer vYu;
  private TimerTask vYv;
  private AccelerateInterpolator vYw;
  private DecelerateInterpolator vYx;
  private int vYy;
  private PointF vYz;
  
  static
  {
    AppMethodBeat.i(52406);
    vYB = new a((byte)0);
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
    this.vYm = new ArrayList();
    this.vXl = getResources().getDimensionPixelSize(2131166772);
    this.vYn = (this.vXl - getResources().getDimensionPixelSize(2131165516) * 2 + getResources().getDimensionPixelSize(2131165575) * 2);
    this.vYo = new ValueAnimator();
    this.qgz = new ValueAnimator();
    this.mRect = new Rect(0, 0, 0, 0);
    this.vYt = -1;
    this.vYw = new AccelerateInterpolator(1.5F);
    this.vYx = new DecelerateInterpolator(1.5F);
    this.vYy = 120;
    this.vYz = new PointF();
    this.vYA = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494564, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(2131304314);
    k.g(localView, "view.findViewById(R.id.scan_line)");
    this.vYg = ((ImageView)localView);
    localView = paramAttributeSet.findViewById(2131302650);
    k.g(localView, "view.findViewById(R.id.my_qr_code)");
    this.vYh = localView;
    localView = paramAttributeSet.findViewById(2131302561);
    k.g(localView, "view.findViewById(R.id.multi_code_mask)");
    this.vYi = localView;
    localView = paramAttributeSet.findViewById(2131302562);
    k.g(localView, "view.findViewById(R.id.multi_code_tips)");
    this.vYj = ((TextView)localView);
    localView = paramAttributeSet.findViewById(2131300239);
    k.g(localView, "view.findViewById(R.id.frame_image)");
    this.vYk = ((ImageView)localView);
    paramAttributeSet = paramAttributeSet.findViewById(2131304331);
    if (paramAttributeSet != null)
    {
      this.vYm.clear();
      this.vYm.add(paramAttributeSet);
    }
    paramAttributeSet = this.vYh;
    if (paramAttributeSet == null) {
      k.aPZ("myQrCodeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new ScanCodeMaskView.b(paramContext));
    dmO();
    this.vYp = 0.16F;
    this.qgz.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.qgz.setDuration(2500L);
    this.qgz.addListener((Animator.AnimatorListener)new d(this));
    this.qgz.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(this));
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(-1);
    AppMethodBeat.o(52405);
  }
  
  private final void Ln(int paramInt)
  {
    AppMethodBeat.i(195456);
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo updateMultiCodeTipsBottomMargin: %d", new Object[] { Integer.valueOf(paramInt) });
    TextView localTextView = this.vYj;
    if (localTextView == null) {
      k.aPZ("multiCodeTips");
    }
    Object localObject = this.vYj;
    if (localObject == null) {
      k.aPZ("multiCodeTips");
    }
    localObject = ((TextView)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      this.vYy = paramInt;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt) + getMBottomExtraHeight());
    }
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(195456);
  }
  
  private final void Lo(final int paramInt)
  {
    AppMethodBeat.i(170057);
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation %d", new Object[] { Integer.valueOf(paramInt) });
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new h(this, new i(this, paramInt));
    a(1.0F, 0.8F, (Interpolator)this.vYw, localAnimatorListener);
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
          k.fvU();
        }
        int i = ((com.tencent.mm.plugin.scanner.a.a)localObject1).getPreviewFormat();
        localObject1 = getScanCamera();
        if (localObject1 == null) {
          k.fvU();
        }
        localObject1 = ((com.tencent.mm.plugin.scanner.a.a)localObject1).fmC();
        if (paramScanDecodeFrameData != null)
        {
          Object localObject2 = paramScanDecodeFrameData.vNs;
          if (localObject2 != null)
          {
            ad.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap data length: %d, size: %d, %d, rotation: %d, previewFormat: %d", new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(paramScanDecodeFrameData.width), Integer.valueOf(paramScanDecodeFrameData.height), Integer.valueOf(paramScanDecodeFrameData.pPJ), Integer.valueOf(i) });
            localObject2 = new YuvImage(paramScanDecodeFrameData.vNs, i, ((Point)localObject1).x, ((Point)localObject1).y, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((Point)localObject1).x, ((Point)localObject1).y), 100, (OutputStream)localByteArrayOutputStream);
            localObject1 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
            {
              ad.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap bitmap width: %d, height: %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
              if (paramScanDecodeFrameData.pPJ != 0)
              {
                i = paramScanDecodeFrameData.pPJ;
                int i3 = getMeasuredWidth();
                int i4 = getMeasuredHeight();
                if (localObject1 == null)
                {
                  AppMethodBeat.o(170064);
                  return null;
                }
                ad.i("MicroMsg.ScanCodeMaskView", "alvinlu rotateAndScaleBitmap rotation: %d, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4) });
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
                    ad.i("MicroMsg.ScanCodeMaskView", "alvinluo rotateAndScaleBitmap finalWidth: %d, finalHeight: %d, x: %d, y: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
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
        ad.printErrStackTrace("MicroMsg.ScanCodeMaskView", (Throwable)paramScanDecodeFrameData, "alvinluo getFrameBitmap exception", new Object[0]);
        AppMethodBeat.o(170064);
        return null;
      }
      label672:
      int n = 0;
    }
  }
  
  private final void a(final float paramFloat1, final float paramFloat2, final Interpolator paramInterpolator, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(170058);
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    dmQ();
    this.oIY = new ValueAnimator();
    ValueAnimator localValueAnimator = this.oIY;
    if (localValueAnimator != null)
    {
      localValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
      localValueAnimator.setInterpolator((TimeInterpolator)paramInterpolator);
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new g(this, paramFloat1, paramFloat2, paramInterpolator, paramAnimatorListener));
      localValueAnimator.addListener(paramAnimatorListener);
      localValueAnimator.start();
      AppMethodBeat.o(170058);
      return;
    }
    AppMethodBeat.o(170058);
  }
  
  private final void al(ArrayList<PointF> paramArrayList)
  {
    AppMethodBeat.i(170056);
    ad.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView pointList %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.pointCount = 0;
    this.vYr = true;
    final v.a locala = new v.a();
    locala.Jhs = true;
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      final PointF localPointF = (PointF)paramArrayList.next();
      if (localPointF != null)
      {
        final v.e locale = new v.e();
        locale.Jhw = ((View)j.C((List)this.vYm, this.pointCount));
        if ((View)locale.Jhw == null)
        {
          localView = LayoutInflater.from(getContext()).inflate(2131494565, null);
          addView(localView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.vXl, this.vXl));
          k.g(localView, "view");
          locale.Jhw = localView;
          this.vYm.add((View)locale.Jhw);
        }
        View localView = (View)locale.Jhw;
        Object localObject = (ImageView)localView.findViewById(2131304331);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2131691123);
        }
        localView.setVisibility(0);
        localView.setPivotX(this.vXl / 2.0F);
        localView.setPivotY(this.vXl / 2.0F);
        localView.setTranslationX(localPointF.x - this.vXl / 2);
        localView.setTranslationY(localPointF.y - this.vXl / 2);
        localView.setAlpha(0.0F);
        localView.setScaleX(0.0F);
        localView.setScaleY(0.0F);
        float f2 = localPointF.x;
        float f1 = localPointF.y;
        float f3 = this.vYz.x;
        float f4 = this.vYz.y;
        localObject = this.vYj;
        if (localObject == null) {
          k.aPZ("multiCodeTips");
        }
        i = ((TextView)localObject).getMeasuredWidth();
        localObject = this.vYj;
        if (localObject == null) {
          k.aPZ("multiCodeTips");
        }
        ad.i("MicroMsg.ScanCodeMaskView", "alvinluo checkMultiCodeTipsPositionValid [%s, %s], multiCodeTips: [%s, %s], [%s, %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i), Integer.valueOf(((TextView)localObject).getMeasuredHeight()) });
        if (this.vYn / 2 + f2 >= this.vYz.x)
        {
          f3 = this.vYn / 2;
          f4 = this.vYz.x;
          localObject = this.vYj;
          if (localObject == null) {
            k.aPZ("multiCodeTips");
          }
          if ((f2 - f3 <= f4 + ((TextView)localObject).getMeasuredWidth()) && (this.vYn / 2 + f1 >= this.vYz.y))
          {
            f2 = this.vYn / 2;
            f3 = this.vYz.y;
            localObject = this.vYj;
            if (localObject == null) {
              k.aPZ("multiCodeTips");
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
            locala.Jhs = false;
          }
          localView.setOnClickListener((View.OnClickListener)new m(this.pointCount, localPointF, locale, this, locala));
          this.pointCount += 1;
          break;
        }
      }
    }
    int i = this.pointCount;
    int j = this.vYm.size();
    while (i < j)
    {
      paramArrayList = (View)j.C((List)this.vYm, i);
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
      i += 1;
    }
    boolean bool;
    if (this.pointCount > 1)
    {
      bool = true;
      this.vYq = bool;
      if (this.vYq) {
        break label1069;
      }
      paramArrayList = (View)j.iz((List)this.vYm);
      if (paramArrayList != null)
      {
        paramArrayList = (ImageView)paramArrayList.findViewById(2131304331);
        if (paramArrayList != null) {
          paramArrayList.setImageResource(2131691122);
        }
      }
      paramArrayList = this.vYi;
      if (paramArrayList == null) {
        k.aPZ("multiCodeBgMask");
      }
      paramArrayList.setVisibility(8);
      paramArrayList = this.vYj;
      if (paramArrayList == null) {
        k.aPZ("multiCodeTips");
      }
      paramArrayList.setVisibility(4);
    }
    for (;;)
    {
      ad.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView isMultiCode: %b, pointCount: %d, successMarkViewList: %d, tipsPositionValid: %b", new Object[] { Boolean.valueOf(this.vYq), Integer.valueOf(this.pointCount), Integer.valueOf(this.vYm.size()), Boolean.valueOf(locala.Jhs) });
      paramArrayList = this.vYo;
      paramArrayList.removeAllUpdateListeners();
      paramArrayList.removeAllListeners();
      paramArrayList.setFloatValues(new float[] { 0.0F, 1.0F });
      paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
      paramArrayList.setDuration(300L);
      paramArrayList.addListener((Animator.AnimatorListener)new k(this));
      paramArrayList.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new l(this));
      paramArrayList.start();
      if (!this.vYq) {
        break label1238;
      }
      paramArrayList = this.vYi;
      if (paramArrayList == null) {
        k.aPZ("multiCodeBgMask");
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
      paramArrayList = paramArrayList.setListener((Animator.AnimatorListener)new n(this));
      if (paramArrayList == null) {
        break label1238;
      }
      paramArrayList.start();
      AppMethodBeat.o(170056);
      return;
      bool = false;
      break;
      label1069:
      paramArrayList = this.vYi;
      if (paramArrayList == null) {
        k.aPZ("multiCodeBgMask");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.vYi;
      if (paramArrayList == null) {
        k.aPZ("multiCodeBgMask");
      }
      paramArrayList.setAlpha(0.0F);
      paramArrayList = this.vYj;
      if (paramArrayList == null) {
        k.aPZ("multiCodeTips");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.vYj;
      if (paramArrayList == null) {
        k.aPZ("multiCodeTips");
      }
      paramArrayList.setAlpha(0.0F);
      bool = locala.Jhs;
      ad.d("MicroMsg.ScanCodeMaskView", "alvinluo fixMultiCodeTipsPosition valid: %b, current: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.vYy) });
      this.vYA = false;
      if ((!bool) && (this.vYy != 32)) {
        Ln(32);
      } else if ((bool) && (this.vYy != 120)) {
        Ln(120);
      }
    }
    label1238:
    AppMethodBeat.o(170056);
  }
  
  private final void dmO()
  {
    AppMethodBeat.i(52388);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    setAnimationRect(new Rect(0, (int)(0.15F * j), i, (int)(j * 0.6F)));
    AppMethodBeat.o(52388);
  }
  
  private final void dmP()
  {
    AppMethodBeat.i(170060);
    Object localObject = this.vYu;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.vYv;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    this.vYu = null;
    this.vYv = null;
    AppMethodBeat.o(170060);
  }
  
  private final void dmQ()
  {
    AppMethodBeat.i(170061);
    ValueAnimator localValueAnimator = this.oIY;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.oIY;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    localValueAnimator = this.oIY;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.oIY = null;
    AppMethodBeat.o(170061);
  }
  
  public final void a(final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52399);
    super.a(paramAnimatorListener);
    this.qgz.cancel();
    if (this.vYl != null)
    {
      Bitmap localBitmap = this.vYl;
      if (localBitmap == null) {
        k.fvU();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.vYl;
        if (localBitmap == null) {
          k.fvU();
        }
        localBitmap.recycle();
      }
    }
    a((View)this, 1.0F, 0.0F, (Animator.AnimatorListener)new f(this, paramAnimatorListener));
    AppMethodBeat.o(52399);
  }
  
  public final void a(Object paramObject, c paramc)
  {
    AppMethodBeat.i(52400);
    k.h(paramObject, "data");
    this.vXn = paramc;
    if (((paramObject instanceof ArrayList)) && ((j.iz((List)paramObject) instanceof WxQBarResult)))
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
        paramObject = ((WxQBarResult)paramObject).Ipo;
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
              k.fvU();
            }
            if ((((com.tencent.mm.plugin.scanner.a.a)localObject).fmB()) && (this.tDK))
            {
              f1 = paramObject.x0;
              f2 = paramObject.x1;
              f3 = paramObject.x2;
              f4 = paramObject.x3;
              localObject = getMPreviewRect();
              if (localObject == null) {
                k.fvU();
              }
              f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject).height() * 4);
              f2 = paramObject.y0;
              f3 = paramObject.y1;
              f4 = paramObject.y2;
              f5 = paramObject.y3;
              paramObject = getMPreviewRect();
              if (paramObject == null) {
                k.fvU();
              }
              paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.width() * 4));
              label282:
              if ((paramObject == null) || (getMScanRect() == null)) {
                break label543;
              }
              f1 = paramObject.x;
              localObject = getMScanRect();
              if (localObject == null) {
                k.fvU();
              }
              f2 = ((Rect)localObject).width();
              localObject = getMScanRect();
              if (localObject == null) {
                k.fvU();
              }
              f3 = ((Rect)localObject).left;
              f4 = paramObject.y;
              paramObject = getMScanRect();
              if (paramObject == null) {
                k.fvU();
              }
              f5 = paramObject.height();
              paramObject = getMScanRect();
              if (paramObject == null) {
                k.fvU();
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
              k.fvU();
            }
            f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject).width() * 4);
            f2 = paramObject.y0;
            f3 = paramObject.y1;
            f4 = paramObject.y2;
            f5 = paramObject.y3;
            paramObject = getMPreviewRect();
            if (paramObject == null) {
              k.fvU();
            }
            paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.height() * 4));
            break label282;
            paramObject = null;
            break label282;
          }
        }
      }
      al(paramc);
    }
    AppMethodBeat.o(52400);
  }
  
  public final void cjn()
  {
    AppMethodBeat.i(52391);
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo stopScanLineAnimation");
    this.qgz.cancel();
    AppMethodBeat.o(52391);
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(52398);
    super.dmJ();
    ad.v("MicroMsg.ScanCodeMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(52398);
  }
  
  public final void dmR()
  {
    AppMethodBeat.i(170067);
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkUnconnectedView show: %b", new Object[] { Boolean.TRUE });
    if (this.vYq)
    {
      Object localObject = this.vYi;
      if (localObject == null) {
        k.aPZ("multiCodeBgMask");
      }
      ((View)localObject).setVisibility(8);
      this.vYr = false;
      localObject = ((Iterable)this.vYm).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setAlpha(0.0F);
      }
      dmP();
      dmQ();
      localObject = this.vYj;
      if (localObject == null) {
        k.aPZ("multiCodeTips");
      }
      a((View)localObject, 1.0F, 0.0F, null);
    }
    AppMethodBeat.o(170067);
  }
  
  public final void dmS()
  {
    AppMethodBeat.i(195457);
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkWeakView show: %b", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(195457);
  }
  
  public final void ek(View paramView)
  {
    AppMethodBeat.i(52394);
    k.h(paramView, "flashSwitcher");
    super.ek(paramView);
    View localView = getFlashSwitcher();
    if (localView != null)
    {
      paramView = getFlashSwitcher();
      if (paramView != null)
      {
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
          if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams)paramView).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 120) + getMBottomExtraHeight());
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
    if (this.vYq)
    {
      localView = (View)j.C((List)this.vYm, this.vYt);
      AppMethodBeat.o(170065);
      return localView;
    }
    View localView = (View)j.C((List)this.vYm, 0);
    AppMethodBeat.o(170065);
    return localView;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(170059);
    if ((this.vYq) && (this.vYr))
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
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() != this.fIN))
    {
      this.fIN = getMeasuredWidth();
      dmO();
    }
    if (this.vYA)
    {
      PointF localPointF = this.vYz;
      TextView localTextView = this.vYj;
      if (localTextView == null) {
        k.aPZ("multiCodeTips");
      }
      localPointF.x = localTextView.getX();
      localPointF = this.vYz;
      localTextView = this.vYj;
      if (localTextView == null) {
        k.aPZ("multiCodeTips");
      }
      localPointF.y = localTextView.getY();
    }
    AppMethodBeat.o(52389);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(52397);
    super.onPause();
    cjn();
    AppMethodBeat.o(52397);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(52396);
    super.onResume();
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo startScanLineAnimation");
    this.qgz.cancel();
    ImageView localImageView = this.vYg;
    if (localImageView == null) {
      k.aPZ("scanLineImageView");
    }
    localImageView.setVisibility(0);
    this.qgz.start();
    AppMethodBeat.o(52396);
  }
  
  public final void pd(boolean paramBoolean)
  {
    AppMethodBeat.i(52401);
    super.pd(paramBoolean);
    Object localObject = this.vYh;
    if (localObject == null) {
      k.aPZ("myQrCodeButton");
    }
    ((View)localObject).setAlpha(1.0F);
    localObject = ((Iterable)this.vYm).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.vYj;
    if (localObject == null) {
      k.aPZ("multiCodeTips");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.vYi;
    if (localObject == null) {
      k.aPZ("multiCodeBgMask");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.vYk;
    if (localObject == null) {
      k.aPZ("frameImage");
    }
    ((ImageView)localObject).setVisibility(8);
    this.vYr = false;
    this.vYq = false;
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
    dmP();
    dmQ();
    this.vYo.removeAllListeners();
    this.vYo.removeAllUpdateListeners();
    this.vYo.cancel();
    AppMethodBeat.o(52401);
  }
  
  public final void pf(boolean paramBoolean)
  {
    AppMethodBeat.i(170066);
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkLoading show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (this.vYq))
    {
      Object localObject = this.vYi;
      if (localObject == null) {
        k.aPZ("multiCodeBgMask");
      }
      ((View)localObject).setVisibility(8);
      this.vYr = false;
      localObject = ((Iterable)this.vYm).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setAlpha(0.0F);
      }
      dmP();
      dmQ();
      localObject = this.vYj;
      if (localObject == null) {
        k.aPZ("multiCodeTips");
      }
      a((View)localObject, 1.0F, 0.0F, null);
    }
    AppMethodBeat.o(170066);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52402);
    super.release();
    dmP();
    dmQ();
    AppMethodBeat.o(52402);
  }
  
  public final void setAnimationRect(Rect paramRect)
  {
    AppMethodBeat.i(52390);
    k.h(paramRect, "rect");
    this.mRect.set(paramRect);
    ad.d("MicroMsg.ScanCodeMaskView", "alvinluo setAnimationRect %s", new Object[] { paramRect });
    ImageView localImageView = this.vYg;
    if (localImageView == null) {
      k.aPZ("scanLineImageView");
    }
    paramRect = this.vYg;
    if (paramRect == null) {
      k.aPZ("scanLineImageView");
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
      this.qgz.setFloatValues(new float[] { this.mRect.top, this.mRect.bottom });
      AppMethodBeat.o(52390);
      return;
      paramRect = null;
    }
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    AppMethodBeat.i(52395);
    super.setBottomExtraHeight(paramInt);
    View localView = this.vYh;
    if (localView == null) {
      k.aPZ("myQrCodeButton");
    }
    Object localObject = this.vYh;
    if (localObject == null) {
      k.aPZ("myQrCodeButton");
    }
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight());
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    Ln(120);
    AppMethodBeat.o(52395);
  }
  
  public final void setDecodeSuccessFrameData(final ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170063);
    super.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    h.Iye.aP((Runnable)new j(this, paramScanDecodeFrameData));
    AppMethodBeat.o(170063);
  }
  
  public final void setNeedRotate(boolean paramBoolean)
  {
    this.tDK = paramBoolean;
  }
  
  public final void setSuccessMarkClickListener(y paramy)
  {
    AppMethodBeat.i(170062);
    k.h(paramy, "successMarkClickListener");
    this.vYs = paramy;
    AppMethodBeat.o(170062);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$Companion;", "", "()V", "MULTI_CODE_TIPS_DEFAULT_BOTTOM_MARGIN_DP", "", "MULTI_CODE_TIPS_MIN_BOTTOM_MARGIN_DP", "SCALE_ANIMATION_DELAY", "", "SCALE_ANIMATION_DURATION", "SCALE_ANIMATION_MAX_SCALE", "", "SCALE_ANIMATION_MIN_SCALE", "SCALE_ANIMATION_PERIOD", "SCAN_LINE_ANIMATION_DURATION", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScaleAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class c
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(170046);
      aq.f((Runnable)new a(this));
      AppMethodBeat.o(170046);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(170045);
        ScanCodeMaskView.m(this.vYD.vYC);
        AppMethodBeat.o(170045);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScanLineAnimator$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52379);
      ScanCodeMaskView.a(this.vYC).setVisibility(8);
      AppMethodBeat.o(52379);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52380);
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52380);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      ScanCodeMaskView.a(this.vYC).setTranslationY(f2);
      float f1 = ScanCodeMaskView.b(this.vYC).height() * ScanCodeMaskView.c(this.vYC);
      f2 -= ScanCodeMaskView.b(this.vYC).top;
      if (f2 <= f1)
      {
        f1 = (f1 - f2) / f1;
        ScanCodeMaskView.a(this.vYC).setAlpha(1.0F - f1);
        AppMethodBeat.o(52380);
        return;
      }
      if (f2 >= ScanCodeMaskView.b(this.vYC).height() * (1.0F - ScanCodeMaskView.c(this.vYC)))
      {
        f1 = (f2 - ScanCodeMaskView.b(this.vYC).height() * (1.0F - ScanCodeMaskView.c(this.vYC))) / f1;
        ScanCodeMaskView.a(this.vYC).setAlpha(1.0F - f1);
        AppMethodBeat.o(52380);
        return;
      }
      ScanCodeMaskView.a(this.vYC).setAlpha(1.0F);
      AppMethodBeat.o(52380);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$onViewDestroy$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    f(Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(52383);
      this.vYC.cjn();
      Animator.AnimatorListener localAnimatorListener = paramAnimatorListener;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationCancel(paramAnimator);
        AppMethodBeat.o(52383);
        return;
      }
      AppMethodBeat.o(52383);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52382);
      ad.i("MicroMsg.ScanCodeMaskView", "alvinluo onViewDestroy onAnimationEnd");
      this.vYC.cjn();
      Animator.AnimatorListener localAnimatorListener = paramAnimatorListener;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationEnd(paramAnimator);
        AppMethodBeat.o(52382);
        return;
      }
      AppMethodBeat.o(52382);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(52381);
      Animator.AnimatorListener localAnimatorListener = paramAnimatorListener;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationRepeat(paramAnimator);
        AppMethodBeat.o(52381);
        return;
      }
      AppMethodBeat.o(52381);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(52384);
      Animator.AnimatorListener localAnimatorListener = paramAnimatorListener;
      if (localAnimatorListener != null)
      {
        localAnimatorListener.onAnimationStart(paramAnimator);
        AppMethodBeat.o(52384);
        return;
      }
      AppMethodBeat.o(52384);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$2$1"})
  static final class g
    implements ValueAnimator.AnimatorUpdateListener
  {
    g(ScanCodeMaskView paramScanCodeMaskView, float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(170047);
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(170047);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = (Iterable)ScanCodeMaskView.e(this.vYC);
      int i = 0;
      paramValueAnimator = paramValueAnimator.iterator();
      while (paramValueAnimator.hasNext())
      {
        Object localObject = paramValueAnimator.next();
        if (i < 0) {
          j.fvx();
        }
        localObject = (View)localObject;
        if (i < ScanCodeMaskView.i(this.vYC))
        {
          ((View)localObject).setScaleX(f);
          ((View)localObject).setScaleY(f);
        }
        i += 1;
      }
      AppMethodBeat.o(170047);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(ScanCodeMaskView.i parami) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170049);
      aq.n((Runnable)new a(this), 50L);
      AppMethodBeat.o(170049);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(170048);
        ScanCodeMaskView.a(this.vYK.vYC, (Animator.AnimatorListener)this.vYK.vYJ);
        AppMethodBeat.o(170048);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    i(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170051);
      aq.n((Runnable)new a(this), 50L);
      AppMethodBeat.o(170051);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(170050);
        if (this.vYM.vYL < 2) {
          ScanCodeMaskView.b(this.vYM.vYC, this.vYM.vYL + 1);
        }
        AppMethodBeat.o(170050);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(ScanCodeMaskView paramScanCodeMaskView, ScanDecodeFrameData paramScanDecodeFrameData) {}
    
    public final void run()
    {
      AppMethodBeat.i(170053);
      long l = System.currentTimeMillis();
      ScanCodeMaskView.a(this.vYC, ScanCodeMaskView.a(this.vYC, paramScanDecodeFrameData));
      ad.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(170052);
          if ((!ScanCodeMaskView.o(this.vYO.vYC)) && (ScanCodeMaskView.n(this.vYO.vYC) != null))
          {
            Object localObject = ScanCodeMaskView.n(this.vYO.vYC);
            if (localObject == null) {
              k.fvU();
            }
            if (!((Bitmap)localObject).isRecycled())
            {
              ScanCodeMaskView.p(this.vYO.vYC).setImageBitmap(ScanCodeMaskView.n(this.vYO.vYC));
              ScanCodeMaskView.p(this.vYO.vYC).setVisibility(0);
              ScanCodeMaskView.p(this.vYO.vYC).setAlpha(0.0F);
              localObject = ScanCodeMaskView.p(this.vYO.vYC).animate();
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).cancel();
              }
              localObject = ScanCodeMaskView.p(this.vYO.vYC).animate();
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
                  if (localObject != null)
                  {
                    ((ViewPropertyAnimator)localObject).start();
                    AppMethodBeat.o(170052);
                    return;
                  }
                }
              }
            }
          }
          AppMethodBeat.o(170052);
        }
      });
      AppMethodBeat.o(170053);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class k
    implements Animator.AnimatorListener
  {
    k(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52385);
      ad.v("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView onAnimationEnd");
      paramAnimator = ScanCodeMaskView.f(this.vYC);
      if (paramAnimator != null)
      {
        paramAnimator.dlZ();
        AppMethodBeat.o(52385);
        return;
      }
      AppMethodBeat.o(52385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(52386);
      ScanCodeMaskView.f(this.vYC);
      AppMethodBeat.o(52386);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$2"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52387);
      k.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52387);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ScanCodeMaskView.g(this.vYC).setAlpha(1.0F - f);
      paramValueAnimator = ScanCodeMaskView.h(this.vYC);
      if (paramValueAnimator != null) {
        paramValueAnimator.setAlpha(1.0F - f);
      }
      paramValueAnimator = (Iterable)ScanCodeMaskView.e(this.vYC);
      int i = 0;
      paramValueAnimator = paramValueAnimator.iterator();
      while (paramValueAnimator.hasNext())
      {
        Object localObject = paramValueAnimator.next();
        if (i < 0) {
          j.fvx();
        }
        localObject = (View)localObject;
        if (i < ScanCodeMaskView.i(this.vYC))
        {
          ((View)localObject).setAlpha(f);
          ((View)localObject).setScaleX(f);
          ((View)localObject).setScaleY(f);
        }
        i += 1;
      }
      if (ScanCodeMaskView.j(this.vYC)) {
        ScanCodeMaskView.k(this.vYC).setAlpha(f);
      }
      AppMethodBeat.o(52387);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$1$1$1", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$$special$$inlined$apply$lambda$1"})
  static final class m
    implements View.OnClickListener
  {
    m(int paramInt, PointF paramPointF, v.e parame, ScanCodeMaskView paramScanCodeMaskView, v.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(170054);
      ScanCodeMaskView.a(jdField_this, this.mYS);
      paramView = ScanCodeMaskView.d(jdField_this);
      if (paramView != null) {
        paramView.Lf(this.mYS);
      }
      paramView = ((Iterable)ScanCodeMaskView.e(jdField_this)).iterator();
      while (paramView.hasNext()) {
        ((View)paramView.next()).setOnClickListener(null);
      }
      AppMethodBeat.o(170054);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170055);
      ScanCodeMaskView.l(this.vYC);
      AppMethodBeat.o(170055);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView
 * JD-Core Version:    0.7.0.1
 */