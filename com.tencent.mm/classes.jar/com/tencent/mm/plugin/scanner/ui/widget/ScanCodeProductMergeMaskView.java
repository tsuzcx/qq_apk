package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.box.f;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ab;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeProductMergeMaskView;", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeMaskView;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateShowPreviewImage", "", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "canUpdateMaskViewAlphaWhenShowDialog", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "previewBitmap", "previewImage", "productListState", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "scanProductListView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView;", "scanProductViewCloseAnimating", "showPreviewImage", "successMarkView", "vibrator", "Landroid/os/Vibrator;", "animateHideBlurView", "", "animationEndCallback", "Lkotlin/Function0;", "attachBackgroundView", "bitmap", "async", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "doUpdatePreview", "getBackgroundTransY", "", "getLayoutId", "getMarkViewHeight", "getMarkViewTransY", "getPreviewImageSize", "getRealPosition", "Landroid/graphics/PointF;", "centerX", "centerY", "getRealPositionForImage", "getScanProductView", "initScanProductListView", "initView", "view", "isFromCapture", "isFromGallery", "isProductListViewExpand", "needAnimateAlphaOnPreviewReady", "notifyUpdateProductItemList", "productItemList", "", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "onDialogDismissAnimationEnd", "onDialogDismissAnimationStart", "onDialogShowAnimationEnd", "onDialogShowAnimationStart", "dialogHeight", "startTransY", "endTransY", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onGalleryImageProcessStart", "onPreviewReady", "isSwitchTab", "onScanProductSuccess", "data", "needSuccessMarkAnimation", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onScanSuccess", "", "onTouchMoveBegin", "onTouchMoveEnd", "recycleBlurBitmap", "setBackgroundTransY", "translationY", "setBottomExtraHeight", "bottomHeight", "setMarkViewTransY", "setScanProductCallBack", "scanProductCallBack", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ScanProductCallBack;", "setScanProductOnItemClickListener", "listener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ScanProductOnItemClickListener;", "showLoadingView", "show", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "successAnimationListener", "switchScanProductViewClose", "switchScanProductViewExpand", "updateBlurBitmap", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updatePreviewImageAlpha", "vibrate", "Companion", "ScanMergeSuccessDataWrapper", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanCodeProductMergeMaskView
  extends ScanCodeMaskView
  implements com.tencent.mm.plugin.scanner.box.d, f
{
  public static final ScanCodeProductMergeMaskView.a PfI;
  private Bitmap NKD;
  private LinearInterpolator PeB;
  private DecelerateInterpolator PeC;
  private View Peg;
  private ImageView Pei;
  private ImageView Pej;
  private ImageView Pek;
  private View Pel;
  private boolean Pex;
  private boolean Pey;
  private boolean Pez;
  private ScanProductMaskDecorView PfJ;
  private boolean PfK;
  private boolean PfL;
  private int PfM;
  private Bitmap mVG;
  private View maskView;
  private w psR;
  private Vibrator uAL;
  
  static
  {
    AppMethodBeat.i(315016);
    PfI = new ScanCodeProductMergeMaskView.a((byte)0);
    AppMethodBeat.o(315016);
  }
  
  public ScanCodeProductMergeMaskView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(314853);
    AppMethodBeat.o(314853);
  }
  
  public ScanCodeProductMergeMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(314858);
    AppMethodBeat.o(314858);
  }
  
  public ScanCodeProductMergeMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(314863);
    this.PeB = new LinearInterpolator();
    this.PeC = new DecelerateInterpolator();
    this.PfL = true;
    AppMethodBeat.o(314863);
  }
  
  private static final void a(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView)
  {
    AppMethodBeat.i(314916);
    s.u(paramScanCodeProductMergeMaskView, "this$0");
    PlaySound.play(paramScanCodeProductMergeMaskView.getContext(), l.i.qrcode_completed_2);
    AppMethodBeat.o(314916);
  }
  
  private static final void a(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(314927);
    s.u(paramScanCodeProductMergeMaskView, "this$0");
    paramScanCodeProductMergeMaskView.Pey = ab.gQV();
    paramScanCodeProductMergeMaskView.Pez = true;
    paramScanCodeProductMergeMaskView.aA(paramBitmap);
    AppMethodBeat.o(314927);
  }
  
  private static final void a(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView, TextureView paramTextureView)
  {
    AppMethodBeat.i(314934);
    s.u(paramScanCodeProductMergeMaskView, "this$0");
    s.u(paramTextureView, "$textureView");
    try
    {
      paramScanCodeProductMergeMaskView.gTf();
      long l = System.currentTimeMillis();
      paramTextureView = paramTextureView.getBitmap();
      Log.i("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.threadpool.h.ahAA.bk(new ScanCodeProductMergeMaskView..ExternalSyntheticLambda5(paramScanCodeProductMergeMaskView, paramTextureView));
      AppMethodBeat.o(314934);
      return;
    }
    catch (Exception paramScanCodeProductMergeMaskView)
    {
      Log.printErrStackTrace("MicroMsg.ScanCodeProductMergeMaskView", (Throwable)paramScanCodeProductMergeMaskView, "alvinluo updatePreviewBitmap exception", new Object[0]);
      AppMethodBeat.o(314934);
    }
  }
  
  private static final void a(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView, View paramView)
  {
    AppMethodBeat.i(314905);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramScanCodeProductMergeMaskView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/ScanCodeProductMergeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramScanCodeProductMergeMaskView, "this$0");
    paramView = paramScanCodeProductMergeMaskView.PfJ;
    paramScanCodeProductMergeMaskView = paramView;
    if (paramView == null)
    {
      s.bIx("scanProductListView");
      paramScanCodeProductMergeMaskView = null;
    }
    paramScanCodeProductMergeMaskView.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/widget/ScanCodeProductMergeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314905);
  }
  
  private static final void a(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView, boolean paramBoolean1, boolean paramBoolean2, ValueAnimator paramValueAnimator)
  {
    Object localObject1 = null;
    AppMethodBeat.i(314939);
    s.u(paramScanCodeProductMergeMaskView, "this$0");
    if (paramValueAnimator == null)
    {
      AppMethodBeat.o(314939);
      return;
    }
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanCodeProductMergeMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314939);
      throw paramScanCodeProductMergeMaskView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    Object localObject2 = paramScanCodeProductMergeMaskView.maskView;
    paramValueAnimator = (ValueAnimator)localObject2;
    if (localObject2 == null)
    {
      s.bIx("maskView");
      paramValueAnimator = null;
    }
    paramValueAnimator.setAlpha(0.5F - f * 0.5F);
    if (paramBoolean1)
    {
      localObject2 = paramScanCodeProductMergeMaskView.Pej;
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
      localObject2 = paramScanCodeProductMergeMaskView.Pei;
      paramValueAnimator = (ValueAnimator)localObject2;
      if (localObject2 == null)
      {
        s.bIx("bottomBlurView");
        paramValueAnimator = null;
      }
      paramValueAnimator.setAlpha(1.0F - f);
    }
    paramScanCodeProductMergeMaskView = paramScanCodeProductMergeMaskView.maskView;
    if (paramScanCodeProductMergeMaskView == null)
    {
      s.bIx("maskView");
      paramScanCodeProductMergeMaskView = localObject1;
    }
    for (;;)
    {
      Log.v("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo animateBlurView alpha: %s, factor: %f", new Object[] { Float.valueOf(paramScanCodeProductMergeMaskView.getAlpha()), Float.valueOf(f) });
      AppMethodBeat.o(314939);
      return;
    }
  }
  
  private static final void a(boolean paramBoolean, ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314910);
    s.u(paramScanCodeProductMergeMaskView, "this$0");
    if (paramBoolean)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramScanCodeProductMergeMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(314910);
        throw paramScanCodeProductMergeMaskView;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = paramScanCodeProductMergeMaskView.PfJ;
      paramScanCodeProductMergeMaskView = paramValueAnimator;
      if (paramValueAnimator == null)
      {
        s.bIx("scanProductListView");
        paramScanCodeProductMergeMaskView = null;
      }
      paramScanCodeProductMergeMaskView.setAlpha(1.0F - f);
    }
    AppMethodBeat.o(314910);
  }
  
  private final void aA(Bitmap paramBitmap)
  {
    Object localObject3 = null;
    ImageView localImageView1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(314882);
    gTf();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo updatePreview bitmap width: %d, height: %d, showPreviewImage: %b, animateShowPreviewImage: %b", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Boolean.valueOf(this.Pey), Boolean.valueOf(this.Pez) });
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
      AppMethodBeat.o(314882);
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
  
  private final void aB(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(314897);
    ((kotlin.g.a.a)new d(this, paramBitmap, false)).invoke();
    AppMethodBeat.o(314897);
  }
  
  private final void ay(Bitmap paramBitmap)
  {
    AppMethodBeat.i(314893);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.ScanCodeProductMergeMaskView", "setPreviewBitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      aB(paramBitmap);
    }
    AppMethodBeat.o(314893);
  }
  
  private static final void b(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView)
  {
    AppMethodBeat.i(314922);
    s.u(paramScanCodeProductMergeMaskView, "this$0");
    paramScanCodeProductMergeMaskView = paramScanCodeProductMergeMaskView.uAL;
    if (paramScanCodeProductMergeMaskView != null) {
      paramScanCodeProductMergeMaskView.vibrate(10L);
    }
    AppMethodBeat.o(314922);
  }
  
  private final void gTf()
  {
    AppMethodBeat.i(314888);
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
    AppMethodBeat.o(314888);
  }
  
  private final boolean gTo()
  {
    return this.PfM == 1;
  }
  
  private final Point getPreviewImageSize()
  {
    AppMethodBeat.i(314873);
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
      AppMethodBeat.o(314873);
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
        AppMethodBeat.o(314873);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanCodeProductMergeMaskView", (Throwable)localException, "alvinluo getPreviewImageSize exception", new Object[0]);
      localPoint = new Point(0, 0);
      AppMethodBeat.o(314873);
      return localPoint;
    }
    int i = getMeasuredWidth();
    Point localPoint = new Point(i, (int)(i / f));
    AppMethodBeat.o(314873);
    return localPoint;
  }
  
  public final void Ck(final boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject2 = null;
    AppMethodBeat.i(315082);
    kotlin.g.a.a locala = (kotlin.g.a.a)new f(this, paramBoolean);
    Object localObject3 = this.Pek;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("blurView");
      localObject1 = null;
    }
    if (((ImageView)localObject1).getVisibility() != 0)
    {
      localObject3 = this.Pej;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("previewImage");
        localObject1 = null;
      }
      if (((ImageView)localObject1).getVisibility() != 0)
      {
        localObject3 = this.Pei;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("bottomBlurView");
          localObject1 = null;
        }
        if (((ImageView)localObject1).getVisibility() != 0) {
          break label502;
        }
      }
    }
    localObject3 = this.PfJ;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("scanProductListView");
      localObject1 = null;
    }
    ((ScanProductMaskDecorView)localObject1).setAlpha(1.0F);
    super.Ck(paramBoolean);
    localObject3 = this.Pej;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("previewImage");
      localObject1 = null;
    }
    int i;
    if (((ImageView)localObject1).getAlpha() == 1.0F)
    {
      i = 1;
      if (i == 0) {
        break label476;
      }
      localObject3 = this.Pej;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("previewImage");
        localObject1 = null;
      }
      if (((ImageView)localObject1).getVisibility() != 0) {
        break label476;
      }
      paramBoolean = true;
      label230:
      localObject3 = this.Pei;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("bottomBlurView");
        localObject1 = null;
      }
      if (((ImageView)localObject1).getAlpha() != 1.0F) {
        break label481;
      }
      i = 1;
      label266:
      if (i == 0) {
        break label486;
      }
      localObject3 = this.Pei;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("bottomBlurView");
        localObject1 = null;
      }
      if (((ImageView)localObject1).getVisibility() != 0) {
        break label486;
      }
      label302:
      localObject3 = this.Pek;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("blurView");
        localObject1 = null;
      }
      ((ImageView)localObject1).setAlpha(1.0F);
      localObject1 = this.Pek;
      if (localObject1 != null) {
        break label491;
      }
      s.bIx("blurView");
      localObject1 = localObject2;
      label353:
      localObject1 = ((ImageView)localObject1).animate();
      if (localObject1 != null)
      {
        localObject1 = ((ViewPropertyAnimator)localObject1).alpha(0.0F);
        if (localObject1 != null) {
          if (!this.PfK) {
            break label494;
          }
        }
      }
    }
    label476:
    label481:
    label486:
    label491:
    label494:
    for (long l = 500L;; l = 300L)
    {
      localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(l);
      if (localObject1 != null)
      {
        localObject1 = ((ViewPropertyAnimator)localObject1).setInterpolator((TimeInterpolator)this.PeB);
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).setListener((Animator.AnimatorListener)new c(locala, this));
          if (localObject1 != null) {
            ((ViewPropertyAnimator)localObject1).setUpdateListener(new ScanCodeProductMergeMaskView..ExternalSyntheticLambda0(this, paramBoolean, bool));
          }
        }
      }
      AppMethodBeat.o(315082);
      return;
      i = 0;
      break;
      paramBoolean = false;
      break label230;
      i = 0;
      break label266;
      bool = false;
      break label302;
      break label353;
    }
    label502:
    super.Ck(paramBoolean);
    locala.invoke();
    AppMethodBeat.o(315082);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(315090);
    s.u(paramObject, "data");
    Log.v("MicroMsg.ScanCodeProductMergeMaskView", "onScanSuccess data: %s", new Object[] { paramObject });
    if ((paramObject instanceof ScanCodeProductMergeMaskView.b))
    {
      localObject2 = ((ScanCodeProductMergeMaskView.b)paramObject).PfN;
      boolean bool2 = ((ScanCodeProductMergeMaskView.b)paramObject).PfO;
      boolean bool1;
      float f1;
      float f2;
      float f3;
      float f4;
      if (!gTo())
      {
        localObject1 = this.PfJ;
        paramObject = localObject1;
        if (localObject1 == null)
        {
          s.bIx("scanProductListView");
          paramObject = null;
        }
        if (paramObject.getAlpha() == 1.0F)
        {
          bool1 = true;
          a(200L, new ScanCodeProductMergeMaskView..ExternalSyntheticLambda1(bool1, this));
        }
      }
      else
      {
        if (!bool2) {
          break label613;
        }
        setSuccessAnimationListener(paramd);
        paramObject = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject2).OWc;
        if (paramObject != null)
        {
          f1 = (paramObject.left + paramObject.right) / 2.0F;
          f2 = paramObject.top;
          f2 = (paramObject.bottom + f2) / 2.0F;
          Log.v("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo showSuccessView with animation");
          if (getMScanSource() != 3) {
            break label488;
          }
          f3 = f1 * getMeasuredWidth();
          f4 = f2 * getMeasuredHeight();
          Log.v("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
        }
      }
      label488:
      float f5;
      for (paramObject = new PointF(f3, f4);; paramObject = new PointF(f1 * f4 + f3, f2 * paramObject.y + f5))
      {
        localObject1 = this.Peg;
        paramd = (com.tencent.mm.plugin.scanner.view.d)localObject1;
        if (localObject1 == null)
        {
          s.bIx("successMarkView");
          paramd = null;
        }
        paramd.setVisibility(0);
        paramd.setPivotX(getSuccessMarkViewSize() / 2.0F);
        paramd.setPivotY(getSuccessMarkViewSize() / 2.0F);
        paramd.setTranslationX(paramObject.x - getSuccessMarkViewSize() / 2);
        paramd.setTranslationY(paramObject.y - getSuccessMarkViewSize() / 2);
        paramd.setScaleX(0.0F);
        paramd.setScaleY(0.0F);
        paramd = this.Peg;
        paramObject = paramd;
        if (paramd == null)
        {
          s.bIx("successMarkView");
          paramObject = null;
        }
        com.tencent.mm.plugin.scanner.ui.scangoods.widget.h.a(paramObject, null);
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
        com.tencent.threadpool.h.ahAA.bm(new ScanCodeProductMergeMaskView..ExternalSyntheticLambda3(this));
        postDelayed(new ScanCodeProductMergeMaskView..ExternalSyntheticLambda4(this), 100L);
        AppMethodBeat.o(315090);
        return;
        bool1 = false;
        break;
        paramObject = getPreviewImageSize();
        int i = (getMeasuredWidth() - paramObject.x) / 2;
        int j = (getMeasuredHeight() - paramObject.y) / 2;
        Log.v("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo getRealPositionForImage previewImageSize: %s, centerX: %s, centerY: %s, left: %d, top: %d", new Object[] { paramObject, Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
        f3 = i;
        f4 = paramObject.x;
        f5 = j;
      }
      label613:
      if (paramd != null) {
        paramd.BY(false);
      }
      AppMethodBeat.o(315090);
      return;
    }
    Object localObject2 = this.PfJ;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("scanProductListView");
      localObject1 = null;
    }
    if (((ScanProductMaskDecorView)localObject1).getVisibility() == 0)
    {
      localObject2 = this.PfJ;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("scanProductListView");
        localObject1 = null;
      }
      p.a((View)localObject1, 1.0F, 0.0F, 200L, null);
    }
    super.a(paramObject, paramd);
    AppMethodBeat.o(315090);
  }
  
  public final void az(Bitmap paramBitmap)
  {
    AppMethodBeat.i(315112);
    this.Pey = true;
    this.Pez = false;
    aA(paramBitmap);
    AppMethodBeat.o(315112);
  }
  
  public final void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(315100);
    if (paramBoolean)
    {
      w localw = this.psR;
      if (localw != null) {
        localw.dismiss();
      }
      this.psR = k.a(getContext(), getResources().getString(l.i.OLj), true, paramOnCancelListener);
      AppMethodBeat.o(315100);
      return;
    }
    paramOnCancelListener = this.psR;
    if (paramOnCancelListener != null) {
      paramOnCancelListener.dismiss();
    }
    AppMethodBeat.o(315100);
  }
  
  public final void d(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(315108);
    if (gTo())
    {
      AppMethodBeat.o(315108);
      return;
    }
    float f1 = Math.max(0.0F, Math.min(1.0F, paramFloat2));
    Object localObject2;
    Object localObject1;
    boolean bool;
    label244:
    int i;
    label252:
    float f2;
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
          Log.v("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo onDialogMovedY previewImage.alpha: %f, targetFactor: %f", new Object[] { Float.valueOf(((ImageView)localObject1).getAlpha()), Float.valueOf(f1) });
          bool = false;
          localObject1 = this.Pek;
          if (localObject1 != null) {
            break label895;
          }
          s.bIx("blurView");
          localObject1 = null;
          if (!bool) {
            break label898;
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
          localObject2 = this.maskView;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("maskView");
            localObject1 = null;
          }
          f2 = ((View)localObject1).getAlpha();
          localObject1 = this.Pej;
          if (localObject1 != null) {
            break label905;
          }
          s.bIx("previewImage");
          localObject1 = localObject3;
        }
      }
      break;
    }
    label898:
    label905:
    for (;;)
    {
      Log.v("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, maskView alpha: %s, previewImage alpha: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((ImageView)localObject1).getAlpha()) });
      AppMethodBeat.o(315108);
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
      label895:
      break label244;
      i = 8;
      break label252;
    }
  }
  
  public final void e(int paramInt, float paramFloat1, float paramFloat2) {}
  
  public final void gPJ() {}
  
  public final void gPK() {}
  
  public final void gPL() {}
  
  public final void gPM() {}
  
  public final void gPN() {}
  
  protected final boolean gTl()
  {
    return false;
  }
  
  public final void gTp()
  {
    AppMethodBeat.i(315103);
    getMyQrCodeButton().setAlpha(0.0F);
    ScanProductMaskDecorView localScanProductMaskDecorView2 = this.PfJ;
    ScanProductMaskDecorView localScanProductMaskDecorView1 = localScanProductMaskDecorView2;
    if (localScanProductMaskDecorView2 == null)
    {
      s.bIx("scanProductListView");
      localScanProductMaskDecorView1 = null;
    }
    localScanProductMaskDecorView1.setAlpha(0.0F);
    AppMethodBeat.o(315103);
  }
  
  public final float getBackgroundTransY()
  {
    AppMethodBeat.i(315123);
    View localView = this.Pel;
    if (localView == null)
    {
      AppMethodBeat.o(315123);
      return 0.0F;
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(315123);
    return f;
  }
  
  protected final int getLayoutId()
  {
    return l.g.OJW;
  }
  
  public final float getMarkViewHeight()
  {
    AppMethodBeat.i(315127);
    float f = getSuccessMarkViewSize();
    AppMethodBeat.o(315127);
    return f;
  }
  
  public final float getMarkViewTransY()
  {
    AppMethodBeat.i(315126);
    View localView2 = this.Peg;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("successMarkView");
      localView1 = null;
    }
    float f = localView1.getTranslationY();
    AppMethodBeat.o(315126);
    return f;
  }
  
  public final ScanProductMaskDecorView getScanProductView()
  {
    AppMethodBeat.i(315041);
    ScanProductMaskDecorView localScanProductMaskDecorView = this.PfJ;
    if (localScanProductMaskDecorView == null)
    {
      s.bIx("scanProductListView");
      AppMethodBeat.o(315041);
      return null;
    }
    AppMethodBeat.o(315041);
    return localScanProductMaskDecorView;
  }
  
  protected final void iS(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(315062);
    s.u(paramView, "view");
    super.iS(paramView);
    Object localObject2 = paramView.findViewById(l.f.OIR);
    s.s(localObject2, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
    this.Pei = ((ImageView)localObject2);
    localObject2 = paramView.findViewById(l.f.OIQ);
    s.s(localObject2, "view.findViewById(R.id.preview_blur_view)");
    this.Pek = ((ImageView)localObject2);
    localObject2 = paramView.findViewById(l.f.mask_view);
    s.s(localObject2, "view.findViewById(R.id.mask_view)");
    this.maskView = ((View)localObject2);
    localObject2 = paramView.findViewById(l.f.OIS);
    s.s(localObject2, "view.findViewById(R.id.preview_image)");
    this.Pej = ((ImageView)localObject2);
    localObject2 = paramView.findViewById(l.f.scan_success_dot_view);
    s.s(localObject2, "view.findViewById(R.id.scan_success_dot_view)");
    this.Peg = ((View)localObject2);
    paramView = paramView.findViewById(l.f.OJs);
    s.s(paramView, "view.findViewById(R.id.scan_product_list_view)");
    this.PfJ = ((ScanProductMaskDecorView)paramView);
    if (this.uAL == null)
    {
      paramView = getContext().getSystemService("vibrator");
      if (paramView != null) {
        this.uAL = ((Vibrator)paramView);
      }
    }
    localObject2 = this.PfJ;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("scanProductListView");
      paramView = null;
    }
    paramView.setVisibility(0);
    paramView = this.PfJ;
    if (paramView == null)
    {
      s.bIx("scanProductListView");
      paramView = localObject1;
    }
    for (;;)
    {
      paramView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new e(this));
      AppMethodBeat.o(315062);
      return;
    }
  }
  
  public final void iZ(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(315096);
    this.Pel = paramView;
    Log.v("MicroMsg.ScanCodeProductMergeMaskView", "alvinluo attachBackgroundView source: %d", new Object[] { Integer.valueOf(getMScanSource()) });
    if ((paramView instanceof TextureView)) {
      if (getMScanSource() != 3) {
        break label85;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramView = (TextureView)paramView;
        com.tencent.threadpool.h.ahAA.bm(new ScanCodeProductMergeMaskView..ExternalSyntheticLambda6(this, paramView));
      }
      AppMethodBeat.o(315096);
      return;
      label85:
      i = 0;
    }
  }
  
  public final void setBackgroundTransY(float paramFloat)
  {
    Object localObject2 = null;
    AppMethodBeat.i(315121);
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
      AppMethodBeat.o(315121);
      return;
    }
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    AppMethodBeat.i(315071);
    super.setBottomExtraHeight(paramInt);
    if (this.PfJ == null) {
      s.bIx("scanProductListView");
    }
    ScanProductMaskDecorView localScanProductMaskDecorView2 = this.PfJ;
    ScanProductMaskDecorView localScanProductMaskDecorView1 = localScanProductMaskDecorView2;
    if (localScanProductMaskDecorView2 == null)
    {
      s.bIx("scanProductListView");
      localScanProductMaskDecorView1 = null;
    }
    localScanProductMaskDecorView1.aiy(getMBottomExtraHeight());
    AppMethodBeat.o(315071);
  }
  
  public final void setMarkViewTransY(float paramFloat)
  {
    AppMethodBeat.i(315124);
    View localView2 = this.Peg;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("successMarkView");
      localView1 = null;
    }
    localView1.setTranslationY(paramFloat);
    AppMethodBeat.o(315124);
  }
  
  public final void setScanProductCallBack(ScanProductMaskDecorView.e parame)
  {
    AppMethodBeat.i(315046);
    s.u(parame, "scanProductCallBack");
    ScanProductMaskDecorView localScanProductMaskDecorView = this.PfJ;
    if (localScanProductMaskDecorView == null)
    {
      s.bIx("scanProductListView");
      localScanProductMaskDecorView = null;
    }
    for (;;)
    {
      localScanProductMaskDecorView.setScanProductCallBack((ScanProductMaskDecorView.e)new g(parame, this));
      AppMethodBeat.o(315046);
      return;
    }
  }
  
  public final void setScanProductOnItemClickListener(ScanProductMaskDecorView.f paramf)
  {
    AppMethodBeat.i(315053);
    s.u(paramf, "listener");
    ScanProductMaskDecorView localScanProductMaskDecorView2 = this.PfJ;
    ScanProductMaskDecorView localScanProductMaskDecorView1 = localScanProductMaskDecorView2;
    if (localScanProductMaskDecorView2 == null)
    {
      s.bIx("scanProductListView");
      localScanProductMaskDecorView1 = null;
    }
    localScanProductMaskDecorView1.setScanProductOnItemClickListener(paramf);
    AppMethodBeat.o(315053);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeProductMergeMaskView$animateHideBlurView$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(kotlin.g.a.a<ah> parama, ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314874);
      this.PeJ.invoke();
      ScanCodeProductMergeMaskView.s(jdField_this);
      AppMethodBeat.o(314874);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
    
    private static final void ar(kotlin.g.a.a parama)
    {
      AppMethodBeat.i(314868);
      s.u(parama, "$setImageBitmapAction");
      parama.invoke();
      AppMethodBeat.o(314868);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeProductMergeMaskView$initScanProductListView$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    e(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView) {}
    
    public final void onGlobalLayout()
    {
      Object localObject2 = null;
      AppMethodBeat.i(314859);
      ScanProductMaskDecorView localScanProductMaskDecorView = ScanCodeProductMergeMaskView.e(this.PfP);
      Object localObject1 = localScanProductMaskDecorView;
      if (localScanProductMaskDecorView == null)
      {
        s.bIx("scanProductListView");
        localObject1 = null;
      }
      ((ScanProductMaskDecorView)localObject1).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (ScanCodeProductMergeMaskView.e(this.PfP) == null) {
        s.bIx("scanProductListView");
      }
      localObject1 = ScanCodeProductMergeMaskView.e(this.PfP);
      if (localObject1 == null)
      {
        s.bIx("scanProductListView");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((ScanProductMaskDecorView)localObject1).aiy(ScanCodeProductMergeMaskView.f(this.PfP));
        AppMethodBeat.o(314859);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeProductMergeMaskView$setScanProductCallBack$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ScanProductCallBack;", "onAddScanProduct", "", "scanImageType", "", "detectSession", "", "productCardCount", "onProductListStateChange", "state", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ScanProductMaskDecorView.e
  {
    g(ScanProductMaskDecorView.e parame, ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView) {}
    
    public final void air(int paramInt)
    {
      AppMethodBeat.i(314842);
      ScanCodeProductMergeMaskView.a(jdField_this, paramInt);
      this.PfQ.air(paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(314842);
        return;
        ScanCodeProductMergeMaskView.c(jdField_this);
        AppMethodBeat.o(314842);
        return;
        ScanCodeProductMergeMaskView.d(jdField_this);
      }
    }
    
    public final void b(int paramInt1, long paramLong, int paramInt2)
    {
      AppMethodBeat.i(314836);
      this.PfQ.b(paramInt1, paramLong, paramInt2);
      AppMethodBeat.o(314836);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanCodeProductMergeMaskView$switchScanProductViewExpand$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends AnimatorListenerAdapter
  {
    h(ScanCodeProductMergeMaskView paramScanCodeProductMergeMaskView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      Object localObject = null;
      AppMethodBeat.i(314844);
      View localView = ScanCodeProductMergeMaskView.j(this.PfP);
      paramAnimator = localView;
      if (localView == null)
      {
        s.bIx("maskView");
        paramAnimator = null;
      }
      paramAnimator.setAlpha(0.7F);
      paramAnimator = ScanCodeProductMergeMaskView.j(this.PfP);
      if (paramAnimator == null)
      {
        s.bIx("maskView");
        paramAnimator = localObject;
      }
      for (;;)
      {
        paramAnimator.setVisibility(0);
        AppMethodBeat.o(314844);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeProductMergeMaskView
 * JD-Core Version:    0.7.0.1
 */