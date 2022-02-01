package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.d;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.ui.base.p;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationDotsView", "Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationDotsView;", "backgroundView", "Landroid/view/View;", "blurBitmap", "Landroid/graphics/Bitmap;", "blurView", "Landroid/widget/ImageView;", "bottomBlurView", "canShowBlurView", "", "enablePlaySound", "enableVibrate", "hideBlurViewInterpolator", "Landroid/view/animation/LinearInterpolator;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "maskView", "previewImage", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "successMarkView", "successMarkViewSize", "vibrator", "Landroid/os/Vibrator;", "addAnimationScanDots", "", "pointsResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "animateHideBlurView", "animationEndCallback", "Lkotlin/Function0;", "animateScanDots", "start", "attachBackgroundView", "attachFlashSwitcherView", "flashSwitcher", "bitmap", "async", "computeCropSize", "Landroid/graphics/Point;", "originWidth", "originHeight", "targetWidth", "targetHeight", "getBackgroundTransY", "", "getMarkViewHeight", "getMarkViewTransY", "getRealPosition", "Landroid/graphics/PointF;", "centerX", "centerY", "init", "isFromCapture", "isFromGallery", "onDialogDismissAnimationEnd", "onDialogShowAnimationEnd", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onNetworkChange", "state", "onPreviewReady", "isSwitchTab", "onScanSuccess", "data", "", "scanResultAnimationListener", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleBlurBitmap", "release", "setBackgroundTransY", "translationY", "setMarkViewTransY", "setPreviewBitmap", "showLoadingView", "show", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showSuccessView", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "updatePreview", "updatePreviewBitmap", "textureView", "Landroid/view/TextureView;", "updateViewByNetwork", "vibrate", "Companion", "plugin-scan_release"})
public final class ScanGoodsMaskView
  extends BaseScanMaskView
  implements com.tencent.mm.plugin.scanner.box.a, d
{
  public static final ScanGoodsMaskView.a vXs;
  private p fqw;
  private View lRB;
  private Vibrator mHT;
  public ScanAnimationDotsView vXf;
  private View vXg;
  private ImageView vXh;
  public ImageView vXi;
  private ImageView vXj;
  private View vXk;
  private int vXl;
  private boolean vXm;
  private c vXn;
  private LinearInterpolator vXo;
  private DecelerateInterpolator vXp;
  private boolean vXq;
  private boolean vXr;
  private Bitmap vkz;
  
  static
  {
    AppMethodBeat.i(52328);
    vXs = new ScanGoodsMaskView.a((byte)0);
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
    this.vXl = getResources().getDimensionPixelSize(2131166771);
    this.vXo = new LinearInterpolator();
    this.vXp = new DecelerateInterpolator();
    this.vXq = true;
    this.vXr = true;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131494567, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(2131304301);
    k.g(localView, "view.findViewById(R.id.scan_animation_dots_view)");
    this.vXf = ((ScanAnimationDotsView)localView);
    localView = paramAttributeSet.findViewById(2131304331);
    k.g(localView, "view.findViewById(R.id.scan_success_dot_view)");
    this.vXg = localView;
    localView = paramAttributeSet.findViewById(2131303390);
    k.g(localView, "view.findViewById(R.id.p…ew_blur_view_for_gallery)");
    this.vXh = ((ImageView)localView);
    localView = paramAttributeSet.findViewById(2131303389);
    k.g(localView, "view.findViewById(R.id.preview_blur_view)");
    this.vXj = ((ImageView)localView);
    localView = paramAttributeSet.findViewById(2131302169);
    k.g(localView, "view.findViewById(R.id.mask_view)");
    this.lRB = localView;
    paramAttributeSet = paramAttributeSet.findViewById(2131303394);
    k.g(paramAttributeSet, "view.findViewById(R.id.preview_image)");
    this.vXi = ((ImageView)paramAttributeSet);
    if (this.mHT == null)
    {
      paramContext = paramContext.getSystemService("vibrator");
      if (paramContext != null) {
        this.mHT = ((Vibrator)paramContext);
      }
    }
    AppMethodBeat.o(52327);
  }
  
  private final void c(final Bitmap paramBitmap, final boolean paramBoolean)
  {
    AppMethodBeat.i(52305);
    paramBitmap = (d.g.a.a)new e(this, paramBitmap, paramBoolean);
    if (paramBoolean)
    {
      com.tencent.e.h.Iye.f((Runnable)new ScanGoodsMaskView.d(paramBitmap), "scan_goods_blur_bitmap");
      AppMethodBeat.o(52305);
      return;
    }
    paramBitmap.invoke();
    AppMethodBeat.o(52305);
  }
  
  private final void dmK()
  {
    AppMethodBeat.i(52317);
    if (getCurrentNetworkAvailable())
    {
      localObject = getScanTips();
      if (localObject != null) {
        ((TextView)localObject).setText(2131762823);
      }
      localObject = getMGalleryButton();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(52317);
        return;
      }
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
  
  private final void pe(boolean paramBoolean)
  {
    AppMethodBeat.i(52302);
    ScanAnimationDotsView localScanAnimationDotsView = this.vXf;
    if (localScanAnimationDotsView == null) {
      k.aPZ("animationDotsView");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localScanAnimationDotsView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localScanAnimationDotsView = this.vXf;
      if (localScanAnimationDotsView == null) {
        k.aPZ("animationDotsView");
      }
      localScanAnimationDotsView.startAnimation();
      AppMethodBeat.o(52302);
      return;
    }
    localScanAnimationDotsView = this.vXf;
    if (localScanAnimationDotsView == null) {
      k.aPZ("animationDotsView");
    }
    localScanAnimationDotsView.stopAnimation();
    AppMethodBeat.o(52302);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(52311);
    super.a(paramAnimatorListener);
    a((View)this, 1.0F, 0.0F, paramAnimatorListener);
    AppMethodBeat.o(52311);
  }
  
  public final void a(final Object paramObject, c paramc)
  {
    AppMethodBeat.i(52313);
    k.h(paramObject, "data");
    ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo onScanSuccess");
    this.vXn = paramc;
    if ((paramObject instanceof u))
    {
      paramObject = (u)paramObject;
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView with animation");
      pe(false);
      float f1 = paramObject.centerX;
      float f2 = paramObject.centerY;
      float f3 = getMeasuredWidth() * f1;
      float f4 = getMeasuredHeight() * f2;
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo getRealPosition center: %f, %f, result: %f, %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4) });
      paramObject = new PointF(f3, f4);
      paramc = this.vXg;
      if (paramc == null) {
        k.aPZ("successMarkView");
      }
      paramc.setVisibility(0);
      paramc.setPivotX(this.vXl / 2.0F);
      paramc.setPivotY(this.vXl / 2.0F);
      paramc.setTranslationX(paramObject.x - this.vXl / 2);
      paramc.setTranslationY(paramObject.y - this.vXl / 2);
      paramc.setAlpha(0.0F);
      paramc.setScaleX(0.0F);
      paramc.setScaleY(0.0F);
      paramc.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new i(this, paramObject)).setInterpolator((TimeInterpolator)new LinearInterpolator()).start();
      paramObject = this.lRB;
      if (paramObject == null) {
        k.aPZ("maskView");
      }
      paramObject.setAlpha(0.0F);
      paramObject.setVisibility(0);
      paramObject = this.vXj;
      if (paramObject == null) {
        k.aPZ("blurView");
      }
      paramObject.setVisibility(8);
      paramObject = getScanTips();
      if (paramObject != null) {
        paramObject.setVisibility(8);
      }
    }
    if (this.vXq) {
      com.tencent.e.h.Iye.aP((Runnable)new g(this));
    }
    if (this.vXr) {
      postDelayed((Runnable)new h(this), 100L);
    }
    AppMethodBeat.o(52313);
  }
  
  public final void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(52314);
    if (paramBoolean)
    {
      p localp = this.fqw;
      if (localp != null) {
        localp.dismiss();
      }
      this.fqw = com.tencent.mm.ui.base.h.b(getContext(), getResources().getString(2131762846), true, paramOnCancelListener);
      AppMethodBeat.o(52314);
      return;
    }
    paramOnCancelListener = this.fqw;
    if (paramOnCancelListener != null)
    {
      paramOnCancelListener.dismiss();
      AppMethodBeat.o(52314);
      return;
    }
    AppMethodBeat.o(52314);
  }
  
  public final void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(52303);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo setPreviewBitmap width: %d, height: %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      c(paramBitmap, paramBoolean);
    }
    AppMethodBeat.o(52303);
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
        bool = this.vXm & true;
        f1 = (f1 - 0.5F) / 0.5F;
        localObject = this.vXj;
        if (localObject == null) {
          k.aPZ("blurView");
        }
        ((ImageView)localObject).setAlpha(this.vXp.getInterpolation(f1));
        localObject = this.vXg;
        if (localObject == null) {
          k.aPZ("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.vXi;
        if (localObject == null) {
          k.aPZ("previewImage");
        }
        localImageView = this.vXj;
        if (localImageView == null) {
          k.aPZ("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        localObject = this.lRB;
        if (localObject == null) {
          k.aPZ("maskView");
        }
        ((View)localObject).setAlpha(0.5F);
        label189:
        localObject = this.vXj;
        if (localObject == null) {
          k.aPZ("blurView");
        }
        if (!bool) {
          break label656;
        }
      }
    }
    label656:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = this.lRB;
      if (localObject == null) {
        k.aPZ("maskView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.vXj;
      if (localObject == null) {
        k.aPZ("blurView");
      }
      f1 = ((ImageView)localObject).getAlpha();
      localObject = this.vXg;
      if (localObject == null) {
        k.aPZ("successMarkView");
      }
      float f2 = ((View)localObject).getAlpha();
      localObject = this.lRB;
      if (localObject == null) {
        k.aPZ("maskView");
      }
      float f3 = ((View)localObject).getAlpha();
      localObject = this.vXi;
      if (localObject == null) {
        k.aPZ("previewImage");
      }
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo onDialogMovedY dialogState: %d, offsetY: %s, factor: %f, showBlurView: %b, blurView alpha: %s, markView alpha: %s, maskView alpha: %s, previewImage alpha: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(bool), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(((ImageView)localObject).getAlpha()) });
      AppMethodBeat.o(52323);
      return;
      if (paramInt == 2)
      {
        bool = this.vXm & true;
        localObject = this.vXj;
        if (localObject == null) {
          k.aPZ("blurView");
        }
        ((ImageView)localObject).setAlpha(this.vXp.getInterpolation(f1));
        localObject = this.vXg;
        if (localObject == null) {
          k.aPZ("successMarkView");
        }
        ((View)localObject).setAlpha(1.0F - f1);
        localObject = this.vXi;
        if (localObject == null) {
          k.aPZ("previewImage");
        }
        localImageView = this.vXj;
        if (localImageView == null) {
          k.aPZ("blurView");
        }
        ((ImageView)localObject).setAlpha(1.0F - localImageView.getAlpha());
        break;
      }
      localObject = this.vXg;
      if (localObject == null) {
        k.aPZ("successMarkView");
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.vXi;
      if (localObject == null) {
        k.aPZ("previewImage");
      }
      ((ImageView)localObject).setAlpha(1.0F);
      bool = false;
      break;
      localObject = this.lRB;
      if (localObject == null) {
        k.aPZ("maskView");
      }
      ((View)localObject).setAlpha(Math.max(0.0F, Math.min(0.5F, 1.0F - f1)));
      localObject = this.vXi;
      if (localObject == null) {
        k.aPZ("previewImage");
      }
      ((ImageView)localObject).setAlpha(1.0F);
      bool = false;
      break label189;
    }
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(52310);
    super.dmJ();
    dmK();
    AppMethodBeat.o(52310);
  }
  
  public final void dmL()
  {
    AppMethodBeat.i(52324);
    if (this.vkz != null)
    {
      Bitmap localBitmap = this.vkz;
      if (localBitmap == null) {
        k.fvU();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.vkz;
        if (localBitmap == null) {
          k.fvU();
        }
        localBitmap.recycle();
        this.vkz = null;
      }
    }
    AppMethodBeat.o(52324);
  }
  
  public final void ek(View paramView)
  {
    AppMethodBeat.i(52308);
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
            ((ViewGroup.MarginLayoutParams)paramView).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 32) + getMBottomExtraHeight());
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
  
  public final void el(final View paramView)
  {
    int i = 1;
    AppMethodBeat.i(52309);
    this.vXk = paramView;
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
        com.tencent.e.h.Iye.aP((Runnable)new j(this, paramView));
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
    View localView = this.vXk;
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
    View localView = this.vXg;
    if (localView == null) {
      k.aPZ("successMarkView");
    }
    float f = localView.getMeasuredHeight();
    AppMethodBeat.o(52322);
    return f;
  }
  
  public final float getMarkViewTransY()
  {
    AppMethodBeat.i(52321);
    View localView = this.vXg;
    if (localView == null) {
      k.aPZ("successMarkView");
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(52321);
    return f;
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(52316);
    super.onNetworkChange(paramInt);
    dmK();
    AppMethodBeat.o(52316);
  }
  
  public final void pd(final boolean paramBoolean)
  {
    AppMethodBeat.i(52312);
    super.pd(paramBoolean);
    dmL();
    Object localObject1 = (d.g.a.a)new f(this, paramBoolean);
    Object localObject2 = this.vXj;
    if (localObject2 == null) {
      k.aPZ("blurView");
    }
    if (((ImageView)localObject2).getVisibility() != 0)
    {
      localObject2 = this.vXi;
      if (localObject2 == null) {
        k.aPZ("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0)
      {
        localObject2 = this.vXh;
        if (localObject2 == null) {
          k.aPZ("bottomBlurView");
        }
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label260;
        }
      }
    }
    localObject2 = this.vXi;
    if (localObject2 == null) {
      k.aPZ("previewImage");
    }
    if (((ImageView)localObject2).getAlpha() == 1.0F)
    {
      localObject2 = this.vXi;
      if (localObject2 == null) {
        k.aPZ("previewImage");
      }
      if (((ImageView)localObject2).getVisibility() != 0) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject2 = this.vXj;
      if (localObject2 == null) {
        k.aPZ("blurView");
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
      localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)this.vXo);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new ScanGoodsMaskView.b((d.g.a.a)localObject1));
      if (localObject1 == null) {
        break;
      }
      ((ViewPropertyAnimator)localObject1).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this, paramBoolean));
      AppMethodBeat.o(52312);
      return;
    }
    AppMethodBeat.o(52312);
    return;
    label260:
    ((d.g.a.a)localObject1).invoke();
    AppMethodBeat.o(52312);
  }
  
  public final void release()
  {
    AppMethodBeat.i(52315);
    super.release();
    ScanAnimationDotsView localScanAnimationDotsView = this.vXf;
    if (localScanAnimationDotsView == null) {
      k.aPZ("animationDotsView");
    }
    localScanAnimationDotsView.release();
    AppMethodBeat.o(52315);
  }
  
  public final void setBackgroundTransY(float paramFloat)
  {
    AppMethodBeat.i(52318);
    Object localObject = this.vXk;
    if (localObject != null) {
      ((View)localObject).setTranslationY(paramFloat);
    }
    localObject = this.vXj;
    if (localObject == null) {
      k.aPZ("blurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.vXi;
    if (localObject == null) {
      k.aPZ("previewImage");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    localObject = this.vXh;
    if (localObject == null) {
      k.aPZ("bottomBlurView");
    }
    ((ImageView)localObject).setTranslationY(paramFloat);
    AppMethodBeat.o(52318);
  }
  
  public final void setMarkViewTransY(float paramFloat)
  {
    AppMethodBeat.i(52320);
    View localView = this.vXg;
    if (localView == null) {
      k.aPZ("successMarkView");
    }
    localView.setTranslationY(paramFloat);
    AppMethodBeat.o(52320);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean) {}
    
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
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52290);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ScanGoodsMaskView.b(this.vXu).setAlpha(0.5F - f * 0.5F);
      if (paramBoolean)
      {
        ScanGoodsMaskView.c(this.vXu).setAlpha(1.0F - f);
        ScanGoodsMaskView.d(this.vXu).setAlpha(1.0F - f);
      }
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo animateBlurView alpha: %s, factor: %f", new Object[] { Float.valueOf(ScanGoodsMaskView.b(this.vXu).getAlpha()), Float.valueOf(f) });
      AppMethodBeat.o(52290);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(ScanGoodsMaskView paramScanGoodsMaskView, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(ScanGoodsMaskView.e parame, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(ScanGoodsMaskView paramScanGoodsMaskView, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52296);
      bd.az(this.vXu.getContext(), 2131762120);
      AppMethodBeat.o(52296);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52297);
      ScanGoodsMaskView.l(this.vXu);
      AppMethodBeat.o(52297);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$showSuccessView$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    i(ScanGoodsMaskView paramScanGoodsMaskView, PointF paramPointF) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52298);
      ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo showSuccessView onAnimationEnd");
      paramAnimator = ScanGoodsMaskView.a(this.vXu);
      if (paramAnimator != null)
      {
        paramAnimator.dlZ();
        AppMethodBeat.o(52298);
        return;
      }
      AppMethodBeat.o(52298);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(52299);
      ScanGoodsMaskView.a(this.vXu);
      AppMethodBeat.o(52299);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(ScanGoodsMaskView paramScanGoodsMaskView, TextureView paramTextureView) {}
    
    public final void run()
    {
      AppMethodBeat.i(52301);
      ScanGoodsMaskView.m(this.vXu);
      long l = System.currentTimeMillis();
      final Bitmap localBitmap = paramView.getBitmap();
      ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo updatePreviewBitmap getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52300);
          ScanGoodsMaskView.a(this.vXE.vXu, localBitmap);
          AppMethodBeat.o(52300);
        }
      });
      AppMethodBeat.o(52301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView
 * JD-Core Version:    0.7.0.1
 */