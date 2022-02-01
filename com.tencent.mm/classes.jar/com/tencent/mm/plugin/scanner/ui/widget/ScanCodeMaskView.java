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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.k;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.h;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.d;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "alphaAnimationDistanceFactor", "", "canUpdateMultiCodeTipsDefaultPos", "", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "frameBitmap", "Landroid/graphics/Bitmap;", "frameImage", "Landroid/widget/ImageView;", "isMultiCode", "isShowingSuccessView", "mRect", "Landroid/graphics/Rect;", "multiCodeBgMask", "Landroid/view/View;", "multiCodeTips", "Landroid/widget/TextView;", "multiCodeTipsCurrentBottomMargin", "multiCodeTipsDefaultPosition", "Landroid/graphics/PointF;", "myQrCodeButton", "needRotate", "pointCount", "scaleAnimationHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleTimerTask", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "scanLineAnimator", "scanLineImageView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successAnimator", "successMarkClickIndex", "successMarkClickListener", "Lcom/tencent/mm/plugin/scanner/model/ScanSuccessMarkClickListener;", "successMarkViewCheckSize", "successMarkViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "successMarkViewSize", "viewWidth", "addSuccessView", "cancelScaleAnimator", "", "cancelScaleTimer", "cancelSuccessAnimator", "checkMultiCodeTipsPositionValid", "x", "y", "computeCenterPosition", "scanCodeResultPoint", "Lcom/tencent/qbar/WxQBarPoint;", "computeRealPosition", "pos", "dismissMultiCodeView", "fixMultiCodeTipsPosition", "valid", "getFrameBitmap", "frameData", "Lcom/tencent/qbar/ScanDecodeFrameData;", "getTargetSuccessMarkView", "getTipsViewText", "", "pointInfoList", "Lcom/tencent/qbar/WxQBarResult;", "init", "initDefaultRect", "initScaleAnimation", "initScanLineAnimator", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "onShowInfoView", "show", "onShowNetworkLoading", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleFrameBitmap", "release", "rotateAndScaleBitmap", "bitmap", "rotation", "targetWidth", "targetHeight", "runScaleAnimation", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setAnimationRect", "rect", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setMyQrCodeButtonVisible", "visible", "setNeedRotate", "setSuccessMarkClickListener", "showSuccessView", "pointList", "tips", "startScanLineAnimation", "stopScanLineAnimation", "updateMultiCodeTipsBottomMargin", "margin", "Companion", "plugin-scan_release"})
public final class ScanCodeMaskView
  extends BaseScanMaskView<BaseScanRequest>
{
  public static final a IXa;
  private boolean FaP;
  private MTimerHandler IAU;
  private AccelerateInterpolator IAV;
  private DecelerateInterpolator IAW;
  private int IVG;
  private d IVL;
  private ImageView IWI;
  private View IWJ;
  private View IWK;
  private TextView IWL;
  private ImageView IWM;
  private Bitmap IWN;
  private ArrayList<View> IWO;
  private int IWP;
  private ValueAnimator IWQ;
  private float IWR;
  private boolean IWS;
  private boolean IWT;
  private ae IWU;
  private int IWV;
  private final MTimerHandler.CallBack IWW;
  private int IWX;
  private PointF IWY;
  private boolean IWZ;
  private int jBZ;
  private Rect mRect;
  private int pointCount;
  private ValueAnimator uQS;
  private ValueAnimator wNi;
  
  static
  {
    AppMethodBeat.i(52406);
    IXa = new a((byte)0);
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
    this.IWO = new ArrayList();
    this.IVG = getResources().getDimensionPixelSize(l.d.ICi);
    this.IWP = (this.IVG - getResources().getDimensionPixelSize(l.d.NormalPadding) * 2 + getResources().getDimensionPixelSize(l.d.SmallestPadding) * 2);
    this.IWQ = new ValueAnimator();
    this.wNi = new ValueAnimator();
    this.mRect = new Rect(0, 0, 0, 0);
    this.IWV = -1;
    this.IWW = ((MTimerHandler.CallBack)new i(this));
    this.IAU = new MTimerHandler(Looper.getMainLooper(), this.IWW, true);
    this.IAV = new AccelerateInterpolator(1.5F);
    this.IAW = new DecelerateInterpolator(1.5F);
    this.IWX = 120;
    this.IWY = new PointF();
    this.IWZ = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(l.g.IDT, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(l.f.scan_line);
    p.j(localView, "view.findViewById(R.id.scan_line)");
    this.IWI = ((ImageView)localView);
    localView = paramAttributeSet.findViewById(l.f.my_qr_code);
    p.j(localView, "view.findViewById(R.id.my_qr_code)");
    this.IWJ = localView;
    localView = paramAttributeSet.findViewById(l.f.ICM);
    p.j(localView, "view.findViewById(R.id.multi_code_mask)");
    this.IWK = localView;
    localView = paramAttributeSet.findViewById(l.f.ICN);
    p.j(localView, "view.findViewById(R.id.multi_code_tips)");
    this.IWL = ((TextView)localView);
    localView = paramAttributeSet.findViewById(l.f.ICG);
    p.j(localView, "view.findViewById(R.id.frame_image)");
    this.IWM = ((ImageView)localView);
    paramAttributeSet = paramAttributeSet.findViewById(l.f.scan_success_dot_view);
    if (paramAttributeSet != null)
    {
      this.IWO.clear();
      this.IWO.add(paramAttributeSet);
    }
    paramAttributeSet = this.IWJ;
    if (paramAttributeSet == null) {
      p.bGy("myQrCodeButton");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new ScanCodeMaskView.b(paramContext));
    fEx();
    this.IWR = 0.16F;
    this.wNi.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.wNi.setDuration(2500L);
    this.wNi.addListener((Animator.AnimatorListener)new c(this));
    this.wNi.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new d(this));
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(-1);
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
        if (localObject1 == null) {
          p.iCn();
        }
        int i = ((com.tencent.mm.plugin.scanner.a.a)localObject1).fCt();
        localObject1 = getScanCamera();
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((com.tencent.mm.plugin.scanner.a.a)localObject1).ios();
        if (paramScanDecodeFrameData != null)
        {
          Object localObject2 = paramScanDecodeFrameData.IIA;
          if (localObject2 != null)
          {
            Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap data length: %d, size: %d, %d, rotation: %d, previewFormat: %d", new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(paramScanDecodeFrameData.width), Integer.valueOf(paramScanDecodeFrameData.height), Integer.valueOf(paramScanDecodeFrameData.wxE), Integer.valueOf(i) });
            localObject2 = new YuvImage(paramScanDecodeFrameData.IIA, i, ((Point)localObject1).x, ((Point)localObject1).y, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((Point)localObject1).x, ((Point)localObject1).y), 100, (OutputStream)localByteArrayOutputStream);
            localObject1 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
            {
              Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap bitmap width: %d, height: %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
              if (paramScanDecodeFrameData.wxE != 0)
              {
                i = paramScanDecodeFrameData.wxE;
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
                    if (((p.h(paramScanDecodeFrameData, localObject1) ^ true)) && (!((Bitmap)localObject1).isRecycled())) {
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
  
  private final void a(final float paramFloat1, final float paramFloat2, final Interpolator paramInterpolator, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(170058);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    fBI();
    this.uQS = new ValueAnimator();
    ValueAnimator localValueAnimator = this.uQS;
    if (localValueAnimator != null)
    {
      localValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
      localValueAnimator.setInterpolator((TimeInterpolator)paramInterpolator);
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new f(this, paramFloat1, paramFloat2, paramInterpolator, paramAnimatorListener));
      localValueAnimator.addListener(paramAnimatorListener);
      localValueAnimator.start();
      AppMethodBeat.o(170058);
      return;
    }
    AppMethodBeat.o(170058);
  }
  
  private final String aY(ArrayList<WxQBarResult> paramArrayList)
  {
    AppMethodBeat.i(217384);
    String str = "";
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    paramArrayList = str;
    while (localIterator.hasNext())
    {
      paramArrayList = (WxQBarResult)localIterator.next();
      int i = e.d.boV(paramArrayList.typeName);
      if (k.bY(i, paramArrayList.data))
      {
        paramArrayList = getContext().getString(l.i.IEY);
        p.j(paramArrayList, "context.getString(R.stri…_mask_view_appbrand_tips)");
        localHashSet.add(Integer.valueOf(i));
      }
      else if (!e.d.apt(i))
      {
        paramArrayList = getContext().getString(l.i.IFa);
        p.j(paramArrayList, "context.getString(R.stri…code_mask_view_tiao_tips)");
        localHashSet.add(Integer.valueOf(i));
      }
      else
      {
        paramArrayList = getContext().getString(l.i.IFb);
        p.j(paramArrayList, "context.getString(R.stri…_view_two_dimension_tips)");
        localHashSet.add(Integer.valueOf(i));
      }
    }
    if (localHashSet.size() > 1)
    {
      paramArrayList = getContext().getString(l.i.IEZ);
      p.j(paramArrayList, "context.getString(R.stri…ode_mask_view_multi_tips)");
    }
    AppMethodBeat.o(217384);
    return paramArrayList;
  }
  
  private final void adU(int paramInt)
  {
    AppMethodBeat.i(217386);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo updateMultiCodeTipsBottomMargin: %d", new Object[] { Integer.valueOf(paramInt) });
    TextView localTextView = this.IWL;
    if (localTextView == null) {
      p.bGy("multiCodeTips");
    }
    Object localObject = this.IWL;
    if (localObject == null) {
      p.bGy("multiCodeTips");
    }
    localObject = ((TextView)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      this.IWX = paramInt;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(getContext(), paramInt) + getMBottomExtraHeight());
    }
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(217386);
  }
  
  private final void adf(final int paramInt)
  {
    AppMethodBeat.i(170057);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo runZoomAnimation %d", new Object[] { Integer.valueOf(paramInt) });
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new g(this, new h(this, paramInt));
    a(1.0F, 0.8F, (Interpolator)this.IAV, localAnimatorListener);
    AppMethodBeat.o(170057);
  }
  
  private final void fBI()
  {
    AppMethodBeat.i(170061);
    ValueAnimator localValueAnimator = this.uQS;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.uQS;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    localValueAnimator = this.uQS;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.uQS = null;
    AppMethodBeat.o(170061);
  }
  
  private final void fEx()
  {
    AppMethodBeat.i(52388);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    setAnimationRect(new Rect(0, (int)(0.15F * j), i, (int)(j * 0.6F)));
    AppMethodBeat.o(52388);
  }
  
  private final void fEz()
  {
    AppMethodBeat.i(217395);
    if (this.IWS)
    {
      Object localObject = this.IWK;
      if (localObject == null) {
        p.bGy("multiCodeBgMask");
      }
      ((View)localObject).setVisibility(8);
      this.IWT = false;
      localObject = ((Iterable)this.IWO).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setAlpha(0.0F);
      }
      this.IAU.stopTimer();
      fBI();
      localObject = this.IWL;
      if (localObject == null) {
        p.bGy("multiCodeTips");
      }
      n.a((View)localObject, 1.0F, 0.0F, 200L, null);
    }
    AppMethodBeat.o(217395);
  }
  
  private final void g(ArrayList<PointF> paramArrayList, String paramString)
  {
    AppMethodBeat.i(217382);
    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView pointList %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.pointCount = 0;
    this.IWT = true;
    final aa.a locala = new aa.a();
    locala.aaBx = true;
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      final PointF localPointF = (PointF)paramArrayList.next();
      if (localPointF != null)
      {
        final aa.f localf = new aa.f();
        localf.aaBC = ((View)j.M((List)this.IWO, this.pointCount));
        if ((View)localf.aaBC == null)
        {
          localView = LayoutInflater.from(getContext()).inflate(l.g.layout_scan_code_success_mark_view, null);
          addView(localView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.IVG, this.IVG));
          p.j(localView, "view");
          localf.aaBC = localView;
          this.IWO.add((View)localf.aaBC);
        }
        View localView = (View)localf.aaBC;
        Object localObject = (ImageView)localView.findViewById(l.f.scan_success_dot_view);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(l.h.scan_success_mark_dot_with_arrow);
        }
        localView.setVisibility(0);
        localView.setPivotX(this.IVG / 2.0F);
        localView.setPivotY(this.IVG / 2.0F);
        localView.setTranslationX(localPointF.x - this.IVG / 2);
        localView.setTranslationY(localPointF.y - this.IVG / 2);
        localView.setAlpha(0.0F);
        localView.setScaleX(0.0F);
        localView.setScaleY(0.0F);
        float f2 = localPointF.x;
        float f1 = localPointF.y;
        float f3 = this.IWY.x;
        float f4 = this.IWY.y;
        localObject = this.IWL;
        if (localObject == null) {
          p.bGy("multiCodeTips");
        }
        i = ((TextView)localObject).getMeasuredWidth();
        localObject = this.IWL;
        if (localObject == null) {
          p.bGy("multiCodeTips");
        }
        Log.i("MicroMsg.ScanCodeMaskView", "alvinluo checkMultiCodeTipsPositionValid [%s, %s], multiCodeTips: [%s, %s], [%s, %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i), Integer.valueOf(((TextView)localObject).getMeasuredHeight()) });
        if (this.IWP / 2 + f2 >= this.IWY.x)
        {
          f3 = this.IWP / 2;
          f4 = this.IWY.x;
          localObject = this.IWL;
          if (localObject == null) {
            p.bGy("multiCodeTips");
          }
          if ((f2 - f3 <= f4 + ((TextView)localObject).getMeasuredWidth()) && (this.IWP / 2 + f1 >= this.IWY.y))
          {
            f2 = this.IWP / 2;
            f3 = this.IWY.y;
            localObject = this.IWL;
            if (localObject == null) {
              p.bGy("multiCodeTips");
            }
            if (f1 - f2 <= f3 + ((TextView)localObject).getMeasuredHeight()) {
              break label657;
            }
          }
        }
        label657:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            locala.aaBx = false;
          }
          localView.setOnClickListener((View.OnClickListener)new m(this.pointCount, localPointF, localf, this, locala));
          this.pointCount += 1;
          break;
        }
      }
    }
    int i = this.pointCount;
    int j = this.IWO.size();
    while (i < j)
    {
      paramArrayList = (View)j.M((List)this.IWO, i);
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
      i += 1;
    }
    boolean bool;
    if (this.pointCount > 1)
    {
      bool = true;
      this.IWS = bool;
      if (this.IWS) {
        break label1075;
      }
      paramArrayList = (View)j.lp((List)this.IWO);
      if (paramArrayList != null)
      {
        paramArrayList = (ImageView)paramArrayList.findViewById(l.f.scan_success_dot_view);
        if (paramArrayList != null) {
          paramArrayList.setImageResource(l.h.scan_success_mark_dot);
        }
      }
      paramArrayList = this.IWK;
      if (paramArrayList == null) {
        p.bGy("multiCodeBgMask");
      }
      paramArrayList.setVisibility(8);
      paramArrayList = this.IWL;
      if (paramArrayList == null) {
        p.bGy("multiCodeTips");
      }
      paramArrayList.setVisibility(4);
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView isMultiCode: %b, pointCount: %d, successMarkViewList: %d, tipsPositionValid: %b", new Object[] { Boolean.valueOf(this.IWS), Integer.valueOf(this.pointCount), Integer.valueOf(this.IWO.size()), Boolean.valueOf(locala.aaBx) });
      paramArrayList = this.IWQ;
      paramArrayList.removeAllUpdateListeners();
      paramArrayList.removeAllListeners();
      paramArrayList.setFloatValues(new float[] { 0.0F, 1.0F });
      paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
      paramArrayList.setDuration(300L);
      paramArrayList.addListener((Animator.AnimatorListener)new k(this));
      paramArrayList.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new l(this));
      paramArrayList.start();
      if (!this.IWS) {
        break label1267;
      }
      paramArrayList = this.IWK;
      if (paramArrayList == null) {
        p.bGy("multiCodeBgMask");
      }
      paramArrayList = paramArrayList.animate();
      if (paramArrayList == null) {
        break label1267;
      }
      paramArrayList = paramArrayList.alpha(1.0F);
      if (paramArrayList == null) {
        break label1267;
      }
      paramArrayList = paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
      if (paramArrayList == null) {
        break label1267;
      }
      paramArrayList = paramArrayList.setDuration(600L);
      if (paramArrayList == null) {
        break label1267;
      }
      paramArrayList = paramArrayList.setListener((Animator.AnimatorListener)new n(this));
      if (paramArrayList == null) {
        break label1267;
      }
      paramArrayList.start();
      AppMethodBeat.o(217382);
      return;
      bool = false;
      break;
      label1075:
      paramArrayList = this.IWK;
      if (paramArrayList == null) {
        p.bGy("multiCodeBgMask");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.IWK;
      if (paramArrayList == null) {
        p.bGy("multiCodeBgMask");
      }
      paramArrayList.setAlpha(0.0F);
      paramArrayList = this.IWL;
      if (paramArrayList == null) {
        p.bGy("multiCodeTips");
      }
      paramArrayList.setText((CharSequence)paramString);
      paramArrayList = this.IWL;
      if (paramArrayList == null) {
        p.bGy("multiCodeTips");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.IWL;
      if (paramArrayList == null) {
        p.bGy("multiCodeTips");
      }
      paramArrayList.setAlpha(0.0F);
      bool = locala.aaBx;
      Log.d("MicroMsg.ScanCodeMaskView", "alvinluo fixMultiCodeTipsPosition valid: %b, current: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IWX) });
      this.IWZ = false;
      if ((!bool) && (this.IWX != 32)) {
        adU(32);
      } else if ((bool) && (this.IWX != 120)) {
        adU(120);
      }
    }
    label1267:
    AppMethodBeat.o(217382);
  }
  
  public final void a(final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52399);
    super.a(paramAnimatorListener);
    this.wNi.cancel();
    if (this.IWN != null)
    {
      Bitmap localBitmap = this.IWN;
      if (localBitmap == null) {
        p.iCn();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.IWN;
        if (localBitmap == null) {
          p.iCn();
        }
        localBitmap.recycle();
      }
    }
    n.a((View)this, 1.0F, 0.0F, 200L, (Animator.AnimatorListener)new e(this, paramAnimatorListener));
    AppMethodBeat.o(52399);
  }
  
  public final void b(Object paramObject, d paramd)
  {
    AppMethodBeat.i(52400);
    p.k(paramObject, "data");
    this.IVL = paramd;
    paramd = new ArrayList();
    HashSet localHashSet = new HashSet();
    if (((paramObject instanceof ArrayList)) && ((j.lp((List)paramObject) instanceof WxQBarResult)))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((Iterable)paramObject).iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (localObject1 == null)
        {
          paramObject = new t("null cannot be cast to non-null type com.tencent.qbar.WxQBarResult");
          AppMethodBeat.o(52400);
          throw paramObject;
        }
        paramObject = ((WxQBarResult)localObject1).ZmX;
        if (paramObject != null)
        {
          Object localObject2;
          float f1;
          float f2;
          float f3;
          float f4;
          float f5;
          if ((paramObject.point_cnt == 4) && (getMPreviewRect() != null) && (getScanCamera() != null))
          {
            localObject2 = getScanCamera();
            if (localObject2 == null) {
              p.iCn();
            }
            if ((((com.tencent.mm.plugin.scanner.a.a)localObject2).ior()) && (this.FaP))
            {
              f1 = paramObject.x0;
              f2 = paramObject.x1;
              f3 = paramObject.x2;
              f4 = paramObject.x3;
              localObject2 = getMPreviewRect();
              if (localObject2 == null) {
                p.iCn();
              }
              f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject2).height() * 4);
              f2 = paramObject.y0;
              f3 = paramObject.y1;
              f4 = paramObject.y2;
              f5 = paramObject.y3;
              paramObject = getMPreviewRect();
              if (paramObject == null) {
                p.iCn();
              }
              paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.width() * 4));
              label303:
              if ((paramObject == null) || (getMScanRect() == null)) {
                break label586;
              }
              f1 = paramObject.x;
              localObject2 = getMScanRect();
              if (localObject2 == null) {
                p.iCn();
              }
              f2 = ((Rect)localObject2).width();
              localObject2 = getMScanRect();
              if (localObject2 == null) {
                p.iCn();
              }
              f3 = ((Rect)localObject2).left;
              f4 = paramObject.y;
              paramObject = getMScanRect();
              if (paramObject == null) {
                p.iCn();
              }
              f5 = paramObject.height();
              paramObject = getMScanRect();
              if (paramObject == null) {
                p.iCn();
              }
            }
          }
          label586:
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
            if (localObject2 == null) {
              p.iCn();
            }
            f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject2).width() * 4);
            f2 = paramObject.y0;
            f3 = paramObject.y1;
            f4 = paramObject.y2;
            f5 = paramObject.y3;
            paramObject = getMPreviewRect();
            if (paramObject == null) {
              p.iCn();
            }
            paramObject = new PointF(f1, (f5 + (f2 + f3 + f4)) / (paramObject.height() * 4));
            break label303;
            paramObject = null;
            break label303;
          }
        }
      }
      if ((localArrayList.size() > 1) && (localHashSet.size() == 1))
      {
        paramObject = (PointF)localArrayList.get(0);
        localArrayList.clear();
        localArrayList.add(paramObject);
      }
      g(localArrayList, aY(paramd));
    }
    AppMethodBeat.o(52400);
  }
  
  public final void dlq()
  {
    AppMethodBeat.i(52391);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo stopScanLineAnimation");
    this.wNi.cancel();
    AppMethodBeat.o(52391);
  }
  
  public final void fEr()
  {
    AppMethodBeat.i(52398);
    super.fEr();
    Log.v("MicroMsg.ScanCodeMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(52398);
  }
  
  public final void fEy()
  {
    AppMethodBeat.i(217394);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowResultInfoView show: %b", new Object[] { Boolean.TRUE });
    fEz();
    AppMethodBeat.o(217394);
  }
  
  public final View getTargetSuccessMarkView()
  {
    AppMethodBeat.i(170065);
    if (this.IWS)
    {
      localView = (View)j.M((List)this.IWO, this.IWV);
      AppMethodBeat.o(170065);
      return localView;
    }
    View localView = (View)j.M((List)this.IWO, 0);
    AppMethodBeat.o(170065);
    return localView;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52389);
    super.onMeasure(paramInt1, paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() != this.jBZ))
    {
      this.jBZ = getMeasuredWidth();
      fEx();
    }
    if (this.IWZ)
    {
      PointF localPointF = this.IWY;
      TextView localTextView = this.IWL;
      if (localTextView == null) {
        p.bGy("multiCodeTips");
      }
      localPointF.x = localTextView.getX();
      localPointF = this.IWY;
      localTextView = this.IWL;
      if (localTextView == null) {
        p.bGy("multiCodeTips");
      }
      localPointF.y = localTextView.getY();
    }
    AppMethodBeat.o(52389);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(52397);
    super.onPause();
    dlq();
    AppMethodBeat.o(52397);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(52396);
    super.onResume();
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo startScanLineAnimation");
    this.wNi.cancel();
    ImageView localImageView = this.IWI;
    if (localImageView == null) {
      p.bGy("scanLineImageView");
    }
    localImageView.setVisibility(0);
    this.wNi.start();
    AppMethodBeat.o(52396);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52402);
    super.release();
    this.IAU.stopTimer();
    fBI();
    AppMethodBeat.o(52402);
  }
  
  public final void setAnimationRect(Rect paramRect)
  {
    AppMethodBeat.i(52390);
    p.k(paramRect, "rect");
    this.mRect.set(paramRect);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo setAnimationRect %s", new Object[] { paramRect });
    ImageView localImageView = this.IWI;
    if (localImageView == null) {
      p.bGy("scanLineImageView");
    }
    paramRect = this.IWI;
    if (paramRect == null) {
      p.bGy("scanLineImageView");
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
      this.wNi.setFloatValues(new float[] { this.mRect.top, this.mRect.bottom });
      AppMethodBeat.o(52390);
      return;
      paramRect = null;
    }
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    AppMethodBeat.i(52395);
    super.setBottomExtraHeight(paramInt);
    View localView = this.IWJ;
    if (localView == null) {
      p.bGy("myQrCodeButton");
    }
    Object localObject = this.IWJ;
    if (localObject == null) {
      p.bGy("myQrCodeButton");
    }
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight());
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    adU(120);
    AppMethodBeat.o(52395);
  }
  
  public final void setDecodeSuccessFrameData(final ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170063);
    super.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    h.ZvG.be((Runnable)new j(this, paramScanDecodeFrameData));
    AppMethodBeat.o(170063);
  }
  
  public final void setMyQrCodeButtonVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(217369);
    View localView = this.IWJ;
    if (localView == null) {
      p.bGy("myQrCodeButton");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(217369);
      return;
    }
  }
  
  public final void setNeedRotate(boolean paramBoolean)
  {
    this.FaP = paramBoolean;
  }
  
  public final void setSuccessMarkClickListener(ae paramae)
  {
    AppMethodBeat.i(170062);
    p.k(paramae, "successMarkClickListener");
    this.IWU = paramae;
    AppMethodBeat.o(170062);
  }
  
  public final void xA(boolean paramBoolean)
  {
    AppMethodBeat.i(170066);
    Log.d("MicroMsg.ScanCodeMaskView", "alvinluo onShowNetworkLoading show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      fEz();
    }
    AppMethodBeat.o(170066);
  }
  
  public final void xw(boolean paramBoolean)
  {
    AppMethodBeat.i(52401);
    super.xw(paramBoolean);
    Object localObject = this.IWJ;
    if (localObject == null) {
      p.bGy("myQrCodeButton");
    }
    ((View)localObject).setAlpha(1.0F);
    localObject = ((Iterable)this.IWO).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.IWL;
    if (localObject == null) {
      p.bGy("multiCodeTips");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.IWK;
    if (localObject == null) {
      p.bGy("multiCodeBgMask");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.IWM;
    if (localObject == null) {
      p.bGy("frameImage");
    }
    ((ImageView)localObject).setVisibility(8);
    this.IWT = false;
    this.IWS = false;
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
    n.a((View)this, 0.0F, 1.0F, 200L, null);
    this.IAU.stopTimer();
    fBI();
    this.IWQ.removeAllListeners();
    this.IWQ.removeAllUpdateListeners();
    this.IWQ.cancel();
    AppMethodBeat.o(52401);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$Companion;", "", "()V", "MULTI_CODE_TIPS_DEFAULT_BOTTOM_MARGIN_DP", "", "MULTI_CODE_TIPS_MIN_BOTTOM_MARGIN_DP", "SCALE_ANIMATION_DELAY", "", "SCALE_ANIMATION_DURATION", "SCALE_ANIMATION_MAX_SCALE", "", "SCALE_ANIMATION_MIN_SCALE", "SCALE_ANIMATION_PERIOD", "SCAN_LINE_ANIMATION_DURATION", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$initScanLineAnimator$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52379);
      ScanCodeMaskView.a(this.IXb).setVisibility(8);
      AppMethodBeat.o(52379);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52380);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52380);
        throw paramValueAnimator;
      }
      float f2 = ((Float)paramValueAnimator).floatValue();
      ScanCodeMaskView.a(this.IXb).setTranslationY(f2);
      float f1 = ScanCodeMaskView.b(this.IXb).height() * ScanCodeMaskView.c(this.IXb);
      f2 -= ScanCodeMaskView.b(this.IXb).top;
      if (f2 <= f1)
      {
        f1 = (f1 - f2) / f1;
        ScanCodeMaskView.a(this.IXb).setAlpha(1.0F - f1);
        AppMethodBeat.o(52380);
        return;
      }
      if (f2 >= ScanCodeMaskView.b(this.IXb).height() * (1.0F - ScanCodeMaskView.c(this.IXb)))
      {
        f1 = (f2 - ScanCodeMaskView.b(this.IXb).height() * (1.0F - ScanCodeMaskView.c(this.IXb))) / f1;
        ScanCodeMaskView.a(this.IXb).setAlpha(1.0F - f1);
        AppMethodBeat.o(52380);
        return;
      }
      ScanCodeMaskView.a(this.IXb).setAlpha(1.0F);
      AppMethodBeat.o(52380);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$onViewDestroy$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(52383);
      this.IXb.dlq();
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
      Log.i("MicroMsg.ScanCodeMaskView", "alvinluo onViewDestroy onAnimationEnd");
      this.IXb.dlq();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$2$1"})
  static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(ScanCodeMaskView paramScanCodeMaskView, float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(170047);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(170047);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = (Iterable)ScanCodeMaskView.e(this.IXb);
      int i = 0;
      paramValueAnimator = paramValueAnimator.iterator();
      while (paramValueAnimator.hasNext())
      {
        Object localObject = paramValueAnimator.next();
        if (i < 0) {
          j.iBO();
        }
        localObject = (View)localObject;
        if (i < ScanCodeMaskView.j(this.IXb))
        {
          ((View)localObject).setScaleX(f);
          ((View)localObject).setScaleY(f);
        }
        i += 1;
      }
      AppMethodBeat.o(170047);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(ScanCodeMaskView.h paramh) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170049);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this), 50L);
      AppMethodBeat.o(170049);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(170048);
        ScanCodeMaskView.a(this.IXd.IXb, (Animator.AnimatorListener)this.IXd.IXc);
        AppMethodBeat.o(170048);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$runZoomAnimation$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170051);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this), 50L);
      AppMethodBeat.o(170051);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ScanCodeMaskView.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(170050);
        if (this.IXe.IBi < 2) {
          ScanCodeMaskView.b(this.IXe.IXb, this.IXe.IBi + 1);
        }
        AppMethodBeat.o(170050);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class i
    implements MTimerHandler.CallBack
  {
    i(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(219577);
      ScanCodeMaskView.p(this.IXb);
      AppMethodBeat.o(219577);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(ScanCodeMaskView paramScanCodeMaskView, ScanDecodeFrameData paramScanDecodeFrameData) {}
    
    public final void run()
    {
      AppMethodBeat.i(170053);
      long l = System.currentTimeMillis();
      ScanCodeMaskView.a(this.IXb, ScanCodeMaskView.a(this.IXb, paramScanDecodeFrameData));
      Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(170052);
          if ((!ScanCodeMaskView.n(this.IXg.IXb)) && (ScanCodeMaskView.m(this.IXg.IXb) != null))
          {
            Object localObject = ScanCodeMaskView.m(this.IXg.IXb);
            if (localObject == null) {
              p.iCn();
            }
            if (!((Bitmap)localObject).isRecycled())
            {
              ScanCodeMaskView.o(this.IXg.IXb).setImageBitmap(ScanCodeMaskView.m(this.IXg.IXb));
              ScanCodeMaskView.o(this.IXg.IXb).setVisibility(0);
              ScanCodeMaskView.o(this.IXg.IXb).setAlpha(0.0F);
              localObject = ScanCodeMaskView.o(this.IXg.IXb).animate();
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).cancel();
              }
              localObject = ScanCodeMaskView.o(this.IXg.IXb).animate();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class k
    implements Animator.AnimatorListener
  {
    k(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52385);
      Log.v("MicroMsg.ScanCodeMaskView", "alvinluo showSuccessView onAnimationEnd");
      paramAnimator = ScanCodeMaskView.f(this.IXb);
      if (paramAnimator != null)
      {
        if (!ScanCodeMaskView.g(this.IXb)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnimator.xs(bool);
          AppMethodBeat.o(52385);
          return;
        }
      }
      AppMethodBeat.o(52385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(52386);
      ScanCodeMaskView.f(this.IXb);
      AppMethodBeat.o(52386);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$2"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(ScanCodeMaskView paramScanCodeMaskView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52387);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52387);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ScanCodeMaskView.h(this.IXb).setAlpha(1.0F - f);
      paramValueAnimator = ScanCodeMaskView.i(this.IXb);
      if (paramValueAnimator != null) {
        paramValueAnimator.setAlpha(1.0F - f);
      }
      paramValueAnimator = (Iterable)ScanCodeMaskView.e(this.IXb);
      int i = 0;
      paramValueAnimator = paramValueAnimator.iterator();
      while (paramValueAnimator.hasNext())
      {
        Object localObject = paramValueAnimator.next();
        if (i < 0) {
          j.iBO();
        }
        localObject = (View)localObject;
        if (i < ScanCodeMaskView.j(this.IXb))
        {
          ((View)localObject).setAlpha(f);
          ((View)localObject).setScaleX(f);
          ((View)localObject).setScaleY(f);
        }
        i += 1;
      }
      if (ScanCodeMaskView.g(this.IXb)) {
        ScanCodeMaskView.k(this.IXb).setAlpha(f);
      }
      AppMethodBeat.o(52387);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$1$1$1", "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$$special$$inlined$apply$lambda$1"})
  static final class m
    implements View.OnClickListener
  {
    m(int paramInt, PointF paramPointF, aa.f paramf, ScanCodeMaskView paramScanCodeMaskView, aa.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(170054);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ScanCodeMaskView.a(jdField_this, this.nmX);
      paramView = ScanCodeMaskView.d(jdField_this);
      if (paramView != null) {
        paramView.adG(this.nmX);
      }
      paramView = ((Iterable)ScanCodeMaskView.e(jdField_this)).iterator();
      while (paramView.hasNext()) {
        ((View)paramView.next()).setOnClickListener(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(170054);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView$showSuccessView$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(170055);
      ScanCodeMaskView.l(this.IXb);
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