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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "alphaAnimationDistanceFactor", "", "canUpdateMultiCodeTipsDefaultPos", "", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "frameBitmap", "Landroid/graphics/Bitmap;", "frameImage", "Landroid/widget/ImageView;", "isMultiCode", "isShowingSuccessView", "mRect", "Landroid/graphics/Rect;", "multiCodeBgMask", "Landroid/view/View;", "multiCodeTips", "Landroid/widget/TextView;", "multiCodeTipsCurrentBottomMargin", "multiCodeTipsDefaultPosition", "Landroid/graphics/PointF;", "myQrCodeButton", "needRotate", "pointCount", "scaleAnimationTimer", "Ljava/util/Timer;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleTimerTask", "Ljava/util/TimerTask;", "scanLineAnimator", "scanLineImageView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successAnimator", "successMarkClickIndex", "successMarkClickListener", "Lcom/tencent/mm/plugin/scanner/model/ScanSuccessMarkClickListener;", "successMarkViewCheckSize", "successMarkViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "successMarkViewSize", "viewWidth", "addSuccessView", "cancelScaleAnimator", "", "cancelScaleTimer", "cancelSuccessAnimator", "checkMultiCodeTipsPositionValid", "x", "y", "computeCenterPosition", "scanCodeResultPoint", "Lcom/tencent/qbar/WxQBarPoint;", "computeRealPosition", "pos", "dismissMultiCodeView", "fixMultiCodeTipsPosition", "valid", "getFrameBitmap", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getTargetSuccessMarkView", "init", "initDefaultRect", "initScaleAnimation", "initScanLineAnimator", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "onShowInfoView", "show", "onShowNetworkLoading", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleFrameBitmap", "release", "rotateAndScaleBitmap", "bitmap", "rotation", "targetWidth", "targetHeight", "runScaleAnimation", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setAnimationRect", "rect", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setMyQrCodeButtonVisible", "visible", "setNeedRotate", "setSuccessMarkClickListener", "showSuccessView", "pointList", "startScanLineAnimation", "stopScanLineAnimation", "updateMultiCodeTipsBottomMargin", "margin", "Companion", "plugin-scan_release"})
public final class ScanCodeMaskView
  extends BaseScanMaskView<BaseScanRequest>
{
  public static final ScanCodeMaskView.a CRC;
  private int CQe;
  private d CQk;
  private PointF CRA;
  private boolean CRB;
  private ImageView CRh;
  private View CRi;
  private View CRj;
  private TextView CRk;
  private ImageView CRl;
  private Bitmap CRm;
  private ArrayList<View> CRn;
  private int CRo;
  private ValueAnimator CRp;
  private float CRq;
  private boolean CRr;
  private boolean CRs;
  private ag CRt;
  private int CRu;
  private Timer CRv;
  private TimerTask CRw;
  private AccelerateInterpolator CRx;
  private DecelerateInterpolator CRy;
  private int CRz;
  private int gRD;
  private Rect mRect;
  private int pointCount;
  private ValueAnimator rnC;
  private ValueAnimator tgS;
  private boolean zvq;
  
  static
  {
    AppMethodBeat.i(52406);
    CRC = new ScanCodeMaskView.a((byte)0);
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
    this.CRn = new ArrayList();
    this.CQe = getResources().getDimensionPixelSize(2131166895);
    this.CRo = (this.CQe - getResources().getDimensionPixelSize(2131165534) * 2 + getResources().getDimensionPixelSize(2131165593) * 2);
    this.CRp = new ValueAnimator();
    this.tgS = new ValueAnimator();
    this.mRect = new Rect(0, 0, 0, 0);
    this.CRu = -1;
    this.CRx = new AccelerateInterpolator(1.5F);
    this.CRy = new DecelerateInterpolator(1.5F);
    this.CRz = 120;
    this.CRA = new PointF();
    this.CRB = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495183, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(2131307243);
    p.g(localView, "view.findViewById(R.id.scan_line)");
    this.CRh = ((ImageView)localView);
    localView = paramAttributeSet.findViewById(2131305204);
    p.g(localView, "view.findViewById(R.id.my_qr_code)");
    this.CRi = localView;
    localView = paramAttributeSet.findViewById(2131304992);
    p.g(localView, "view.findViewById(R.id.multi_code_mask)");
    this.CRj = localView;
    localView = paramAttributeSet.findViewById(2131304993);
    p.g(localView, "view.findViewById(R.id.multi_code_tips)");
    this.CRk = ((TextView)localView);
    localView = paramAttributeSet.findViewById(2131301716);
    p.g(localView, "view.findViewById(R.id.frame_image)");
    this.CRl = ((ImageView)localView);
    paramAttributeSet = paramAttributeSet.findViewById(2131307262);
    if (paramAttributeSet != null)
    {
      this.CRn.clear();
      this.CRn.add(paramAttributeSet);
    }
    paramAttributeSet = this.CRi;
    if (paramAttributeSet == null) {
      p.btv("myQrCodeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new ScanCodeMaskView.b(paramContext));
    eRw();
    this.CRq = 0.16F;
    this.tgS.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.tgS.setDuration(2500L);
    this.tgS.addListener((Animator.AnimatorListener)new ScanCodeMaskView.d(this));
    this.tgS.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanCodeMaskView.e(this));
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(-1);
    AppMethodBeat.o(52405);
  }
  
  private final void WV(int paramInt)
  {
    AppMethodBeat.i(240636);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo updateMultiCodeTipsBottomMargin: %d", new Object[] { Integer.valueOf(paramInt) });
    TextView localTextView = this.CRk;
    if (localTextView == null) {
      p.btv("multiCodeTips");
    }
    Object localObject = this.CRk;
    if (localObject == null) {
      p.btv("multiCodeTips");
    }
    localObject = ((TextView)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      this.CRz = paramInt;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt) + getMBottomExtraHeight());
    }
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(240636);
  }
  
  private final void WW(final int paramInt)
  {
    AppMethodBeat.i(170057);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation %d", new Object[] { Integer.valueOf(paramInt) });
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new h(this, new i(this, paramInt));
    a(1.0F, 0.8F, (Interpolator)this.CRx, localAnimatorListener);
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
          p.hyc();
        }
        int i = ((com.tencent.mm.plugin.scanner.a.a)localObject1).getPreviewFormat();
        localObject1 = getScanCamera();
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((com.tencent.mm.plugin.scanner.a.a)localObject1).hkU();
        if (paramScanDecodeFrameData != null)
        {
          Object localObject2 = paramScanDecodeFrameData.CDY;
          if (localObject2 != null)
          {
            Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap data length: %d, size: %d, %d, rotation: %d, previewFormat: %d", new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(paramScanDecodeFrameData.width), Integer.valueOf(paramScanDecodeFrameData.height), Integer.valueOf(paramScanDecodeFrameData.sRI), Integer.valueOf(i) });
            localObject2 = new YuvImage(paramScanDecodeFrameData.CDY, i, ((Point)localObject1).x, ((Point)localObject1).y, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((Point)localObject1).x, ((Point)localObject1).y), 100, (OutputStream)localByteArrayOutputStream);
            localObject1 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
            {
              Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap bitmap width: %d, height: %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
              if (paramScanDecodeFrameData.sRI != 0)
              {
                i = paramScanDecodeFrameData.sRI;
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
                    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo rotateAndScaleBitmap finalWidth: %d, finalHeight: %d, x: %d, y: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
                    if (n == 0) {
                      continue;
                    }
                    paramScanDecodeFrameData = Bitmap.createBitmap((Bitmap)localObject1, j, i, k, m, paramScanDecodeFrameData, true);
                    if (((p.j(paramScanDecodeFrameData, localObject1) ^ true)) && (!((Bitmap)localObject1).isRecycled())) {
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
      label672:
      int n = 0;
    }
  }
  
  private final void a(float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(170058);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    eRy();
    this.rnC = new ValueAnimator();
    ValueAnimator localValueAnimator = this.rnC;
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
  
  private final void aN(ArrayList<PointF> paramArrayList)
  {
    AppMethodBeat.i(170056);
    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView pointList %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.pointCount = 0;
    this.CRs = true;
    z.a locala = new z.a();
    locala.SYB = true;
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      PointF localPointF = (PointF)paramArrayList.next();
      if (localPointF != null)
      {
        z.f localf = new z.f();
        localf.SYG = ((View)j.L((List)this.CRn, this.pointCount));
        if ((View)localf.SYG == null)
        {
          localView = LayoutInflater.from(getContext()).inflate(2131495184, null);
          addView(localView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.CQe, this.CQe));
          p.g(localView, "view");
          localf.SYG = localView;
          this.CRn.add((View)localf.SYG);
        }
        View localView = (View)localf.SYG;
        Object localObject = (ImageView)localView.findViewById(2131307262);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2131691431);
        }
        localView.setVisibility(0);
        localView.setPivotX(this.CQe / 2.0F);
        localView.setPivotY(this.CQe / 2.0F);
        localView.setTranslationX(localPointF.x - this.CQe / 2);
        localView.setTranslationY(localPointF.y - this.CQe / 2);
        localView.setAlpha(0.0F);
        localView.setScaleX(0.0F);
        localView.setScaleY(0.0F);
        float f2 = localPointF.x;
        float f1 = localPointF.y;
        float f3 = this.CRA.x;
        float f4 = this.CRA.y;
        localObject = this.CRk;
        if (localObject == null) {
          p.btv("multiCodeTips");
        }
        i = ((TextView)localObject).getMeasuredWidth();
        localObject = this.CRk;
        if (localObject == null) {
          p.btv("multiCodeTips");
        }
        Log.i("MicroMsg.ScanCodeMaskView", "alvinluo checkMultiCodeTipsPositionValid [%s, %s], multiCodeTips: [%s, %s], [%s, %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i), Integer.valueOf(((TextView)localObject).getMeasuredHeight()) });
        if (this.CRo / 2 + f2 >= this.CRA.x)
        {
          f3 = this.CRo / 2;
          f4 = this.CRA.x;
          localObject = this.CRk;
          if (localObject == null) {
            p.btv("multiCodeTips");
          }
          if ((f2 - f3 <= f4 + ((TextView)localObject).getMeasuredWidth()) && (this.CRo / 2 + f1 >= this.CRA.y))
          {
            f2 = this.CRo / 2;
            f3 = this.CRA.y;
            localObject = this.CRk;
            if (localObject == null) {
              p.btv("multiCodeTips");
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
            locala.SYB = false;
          }
          localView.setOnClickListener((View.OnClickListener)new ScanCodeMaskView.m(this.pointCount, localPointF, localf, this, locala));
          this.pointCount += 1;
          break;
        }
      }
    }
    int i = this.pointCount;
    int j = this.CRn.size();
    while (i < j)
    {
      paramArrayList = (View)j.L((List)this.CRn, i);
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
      i += 1;
    }
    boolean bool;
    if (this.pointCount > 1)
    {
      bool = true;
      this.CRr = bool;
      if (this.CRr) {
        break label1069;
      }
      paramArrayList = (View)j.kt((List)this.CRn);
      if (paramArrayList != null)
      {
        paramArrayList = (ImageView)paramArrayList.findViewById(2131307262);
        if (paramArrayList != null) {
          paramArrayList.setImageResource(2131691430);
        }
      }
      paramArrayList = this.CRj;
      if (paramArrayList == null) {
        p.btv("multiCodeBgMask");
      }
      paramArrayList.setVisibility(8);
      paramArrayList = this.CRk;
      if (paramArrayList == null) {
        p.btv("multiCodeTips");
      }
      paramArrayList.setVisibility(4);
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView isMultiCode: %b, pointCount: %d, successMarkViewList: %d, tipsPositionValid: %b", new Object[] { Boolean.valueOf(this.CRr), Integer.valueOf(this.pointCount), Integer.valueOf(this.CRn.size()), Boolean.valueOf(locala.SYB) });
      paramArrayList = this.CRp;
      paramArrayList.removeAllUpdateListeners();
      paramArrayList.removeAllListeners();
      paramArrayList.setFloatValues(new float[] { 0.0F, 1.0F });
      paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
      paramArrayList.setDuration(300L);
      paramArrayList.addListener((Animator.AnimatorListener)new k(this));
      paramArrayList.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ScanCodeMaskView.l(this));
      paramArrayList.start();
      if (!this.CRr) {
        break label1238;
      }
      paramArrayList = this.CRj;
      if (paramArrayList == null) {
        p.btv("multiCodeBgMask");
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
      paramArrayList = this.CRj;
      if (paramArrayList == null) {
        p.btv("multiCodeBgMask");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.CRj;
      if (paramArrayList == null) {
        p.btv("multiCodeBgMask");
      }
      paramArrayList.setAlpha(0.0F);
      paramArrayList = this.CRk;
      if (paramArrayList == null) {
        p.btv("multiCodeTips");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.CRk;
      if (paramArrayList == null) {
        p.btv("multiCodeTips");
      }
      paramArrayList.setAlpha(0.0F);
      bool = locala.SYB;
      Log.d("MicroMsg.ScanCodeMaskView", "alvinluo fixMultiCodeTipsPosition valid: %b, current: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.CRz) });
      this.CRB = false;
      if ((!bool) && (this.CRz != 32)) {
        WV(32);
      } else if ((bool) && (this.CRz != 120)) {
        WV(120);
      }
    }
    label1238:
    AppMethodBeat.o(170056);
  }
  
  private final void eRA()
  {
    AppMethodBeat.i(240638);
    if (this.CRr)
    {
      Object localObject = this.CRj;
      if (localObject == null) {
        p.btv("multiCodeBgMask");
      }
      ((View)localObject).setVisibility(8);
      this.CRs = false;
      localObject = ((Iterable)this.CRn).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setAlpha(0.0F);
      }
      eRx();
      eRy();
      localObject = this.CRk;
      if (localObject == null) {
        p.btv("multiCodeTips");
      }
      m.a((View)localObject, 1.0F, 0.0F, 200L, null);
    }
    AppMethodBeat.o(240638);
  }
  
  private final void eRw()
  {
    AppMethodBeat.i(52388);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    setAnimationRect(new Rect(0, (int)(0.15F * j), i, (int)(j * 0.6F)));
    AppMethodBeat.o(52388);
  }
  
  private final void eRx()
  {
    AppMethodBeat.i(170060);
    Object localObject = this.CRv;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.CRw;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    this.CRv = null;
    this.CRw = null;
    AppMethodBeat.o(170060);
  }
  
  private final void eRy()
  {
    AppMethodBeat.i(170061);
    ValueAnimator localValueAnimator = this.rnC;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.rnC;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    localValueAnimator = this.rnC;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.rnC = null;
    AppMethodBeat.o(170061);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52399);
    super.a(paramAnimatorListener);
    this.tgS.cancel();
    if (this.CRm != null)
    {
      Bitmap localBitmap = this.CRm;
      if (localBitmap == null) {
        p.hyc();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.CRm;
        if (localBitmap == null) {
          p.hyc();
        }
        localBitmap.recycle();
      }
    }
    m.a((View)this, 1.0F, 0.0F, 200L, (Animator.AnimatorListener)new ScanCodeMaskView.f(this, paramAnimatorListener));
    AppMethodBeat.o(52399);
  }
  
  public final void b(Object paramObject, d paramd)
  {
    AppMethodBeat.i(52400);
    p.h(paramObject, "data");
    this.CQk = paramd;
    if (((paramObject instanceof ArrayList)) && ((j.kt((List)paramObject) instanceof WxQBarResult)))
    {
      paramd = new ArrayList();
      Iterator localIterator = ((Iterable)paramObject).iterator();
      while (localIterator.hasNext())
      {
        paramObject = localIterator.next();
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type com.tencent.qbar.WxQBarResult");
          AppMethodBeat.o(52400);
          throw paramObject;
        }
        paramObject = ((WxQBarResult)paramObject).RKp;
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
              p.hyc();
            }
            if ((((com.tencent.mm.plugin.scanner.a.a)localObject).hkT()) && (this.zvq))
            {
              f1 = paramObject.x0;
              f2 = paramObject.x1;
              f3 = paramObject.x2;
              f4 = paramObject.x3;
              localObject = getMPreviewRect();
              if (localObject == null) {
                p.hyc();
              }
              f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject).height() * 4);
              f2 = paramObject.y0;
              f3 = paramObject.y1;
              f4 = paramObject.y2;
              f5 = paramObject.y3;
              paramObject = getMPreviewRect();
              if (paramObject == null) {
                p.hyc();
              }
              paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.width() * 4));
              label282:
              if ((paramObject == null) || (getMScanRect() == null)) {
                break label543;
              }
              f1 = paramObject.x;
              localObject = getMScanRect();
              if (localObject == null) {
                p.hyc();
              }
              f2 = ((Rect)localObject).width();
              localObject = getMScanRect();
              if (localObject == null) {
                p.hyc();
              }
              f3 = ((Rect)localObject).left;
              f4 = paramObject.y;
              paramObject = getMScanRect();
              if (paramObject == null) {
                p.hyc();
              }
              f5 = paramObject.height();
              paramObject = getMScanRect();
              if (paramObject == null) {
                p.hyc();
              }
            }
          }
          label543:
          for (paramObject = new PointF(f1 * f2 + f3, f4 * f5 + paramObject.top);; paramObject = null)
          {
            paramd.add(paramObject);
            break;
            f1 = paramObject.x0;
            f2 = paramObject.x1;
            f3 = paramObject.x2;
            f4 = paramObject.x3;
            localObject = getMPreviewRect();
            if (localObject == null) {
              p.hyc();
            }
            f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject).width() * 4);
            f2 = paramObject.y0;
            f3 = paramObject.y1;
            f4 = paramObject.y2;
            f5 = paramObject.y3;
            paramObject = getMPreviewRect();
            if (paramObject == null) {
              p.hyc();
            }
            paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.height() * 4));
            break label282;
            paramObject = null;
            break label282;
          }
        }
      }
      aN(paramd);
    }
    AppMethodBeat.o(52400);
  }
  
  public final void cWj()
  {
    AppMethodBeat.i(52391);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo stopScanLineAnimation");
    this.tgS.cancel();
    AppMethodBeat.o(52391);
  }
  
  public final void eRq()
  {
    AppMethodBeat.i(52398);
    super.eRq();
    Log.v("MicroMsg.ScanCodeMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(52398);
  }
  
  public final void eRz()
  {
    AppMethodBeat.i(240637);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowResultInfoView show: %b", new Object[] { Boolean.TRUE });
    eRA();
    AppMethodBeat.o(240637);
  }
  
  public final View getTargetSuccessMarkView()
  {
    AppMethodBeat.i(170065);
    if (this.CRr)
    {
      localView = (View)j.L((List)this.CRn, this.CRu);
      AppMethodBeat.o(170065);
      return localView;
    }
    View localView = (View)j.L((List)this.CRn, 0);
    AppMethodBeat.o(170065);
    return localView;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52389);
    super.onMeasure(paramInt1, paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() != this.gRD))
    {
      this.gRD = getMeasuredWidth();
      eRw();
    }
    if (this.CRB)
    {
      PointF localPointF = this.CRA;
      TextView localTextView = this.CRk;
      if (localTextView == null) {
        p.btv("multiCodeTips");
      }
      localPointF.x = localTextView.getX();
      localPointF = this.CRA;
      localTextView = this.CRk;
      if (localTextView == null) {
        p.btv("multiCodeTips");
      }
      localPointF.y = localTextView.getY();
    }
    AppMethodBeat.o(52389);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(52397);
    super.onPause();
    cWj();
    AppMethodBeat.o(52397);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(52396);
    super.onResume();
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo startScanLineAnimation");
    this.tgS.cancel();
    ImageView localImageView = this.CRh;
    if (localImageView == null) {
      p.btv("scanLineImageView");
    }
    localImageView.setVisibility(0);
    this.tgS.start();
    AppMethodBeat.o(52396);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52402);
    super.release();
    eRx();
    eRy();
    AppMethodBeat.o(52402);
  }
  
  public final void setAnimationRect(Rect paramRect)
  {
    AppMethodBeat.i(52390);
    p.h(paramRect, "rect");
    this.mRect.set(paramRect);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo setAnimationRect %s", new Object[] { paramRect });
    ImageView localImageView = this.CRh;
    if (localImageView == null) {
      p.btv("scanLineImageView");
    }
    paramRect = this.CRh;
    if (paramRect == null) {
      p.btv("scanLineImageView");
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
      this.tgS.setFloatValues(new float[] { this.mRect.top, this.mRect.bottom });
      AppMethodBeat.o(52390);
      return;
      paramRect = null;
    }
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    AppMethodBeat.i(52395);
    super.setBottomExtraHeight(paramInt);
    View localView = this.CRi;
    if (localView == null) {
      p.btv("myQrCodeButton");
    }
    Object localObject = this.CRi;
    if (localObject == null) {
      p.btv("myQrCodeButton");
    }
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight());
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    WV(120);
    AppMethodBeat.o(52395);
  }
  
  public final void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170063);
    super.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    h.RTc.aX((Runnable)new ScanCodeMaskView.j(this, paramScanDecodeFrameData));
    AppMethodBeat.o(170063);
  }
  
  public final void setMyQrCodeButtonVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(240635);
    View localView = this.CRi;
    if (localView == null) {
      p.btv("myQrCodeButton");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(240635);
      return;
    }
  }
  
  public final void setNeedRotate(boolean paramBoolean)
  {
    this.zvq = paramBoolean;
  }
  
  public final void setSuccessMarkClickListener(ag paramag)
  {
    AppMethodBeat.i(170062);
    p.h(paramag, "successMarkClickListener");
    this.CRt = paramag;
    AppMethodBeat.o(170062);
  }
  
  public final void tY(boolean paramBoolean)
  {
    AppMethodBeat.i(52401);
    super.tY(paramBoolean);
    Object localObject = this.CRi;
    if (localObject == null) {
      p.btv("myQrCodeButton");
    }
    ((View)localObject).setAlpha(1.0F);
    localObject = ((Iterable)this.CRn).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.CRk;
    if (localObject == null) {
      p.btv("multiCodeTips");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.CRj;
    if (localObject == null) {
      p.btv("multiCodeBgMask");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.CRl;
    if (localObject == null) {
      p.btv("frameImage");
    }
    ((ImageView)localObject).setVisibility(8);
    this.CRs = false;
    this.CRr = false;
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
    m.a((View)this, 0.0F, 1.0F, 200L, null);
    eRx();
    eRy();
    this.CRp.removeAllListeners();
    this.CRp.removeAllUpdateListeners();
    this.CRp.cancel();
    AppMethodBeat.o(52401);
  }
  
  public final void uc(boolean paramBoolean)
  {
    AppMethodBeat.i(170066);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkLoading show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      eRA();
    }
    AppMethodBeat.o(170066);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScaleAnimation$1", "Ljava/util/TimerTask;", "run", "", "plugin-scan_release"})
  public static final class c
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(170046);
      MMHandlerThread.postToMainThread((Runnable)new a(this));
      AppMethodBeat.o(170046);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(170045);
        ScanCodeMaskView.m(this.CRE.CRD);
        AppMethodBeat.o(170045);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(ScanCodeMaskView.i parami) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170049);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this), 50L);
      AppMethodBeat.o(170049);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(170048);
        ScanCodeMaskView.a(this.CRK.CRD, (Animator.AnimatorListener)this.CRK.CRJ);
        AppMethodBeat.o(170048);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    i(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170051);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this), 50L);
      AppMethodBeat.o(170051);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(170050);
        if (this.CRM.CRL < 2) {
          ScanCodeMaskView.b(this.CRM.CRD, this.CRM.CRL + 1);
        }
        AppMethodBeat.o(170050);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class k
    implements Animator.AnimatorListener
  {
    k(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52385);
      Log.v("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView onAnimationEnd");
      paramAnimator = ScanCodeMaskView.f(this.CRD);
      if (paramAnimator != null)
      {
        paramAnimator.eQG();
        AppMethodBeat.o(52385);
        return;
      }
      AppMethodBeat.o(52385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(52386);
      ScanCodeMaskView.f(this.CRD);
      AppMethodBeat.o(52386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView
 * JD-Core Version:    0.7.0.1
 */