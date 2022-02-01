package com.tencent.mm.plugin.scanner.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.d;
import com.tencent.mm.plugin.scanner.f.a.c;
import com.tencent.mm.plugin.scanner.f.a.c.a;
import com.tencent.mm.plugin.scanner.f.a.c.b;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.WxImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRResultDialogMoveListener;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "ocrViewModel", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;)V", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "animationType", "", "currentImageView", "Landroid/view/View;", "dialogEndOffsetY", "", "dialogStartOffsetY", "gallery", "Lcom/tencent/mm/ui/base/MMViewPager;", "galleryHeight", "galleryWidth", "imageAnimator", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator;", "imageScaleInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel$ImageScaleInfo;", "isDialogAnimating", "", "isTouchMoved", "leftRightPadding", "showParams", "Lcom/tencent/mm/plugin/scanner/api/ScanBoxDialogShowParams;", "statusBarHeight", "attachGallery", "", "attachImageView", "imageView", "checkMinScale", "doUpdateGallerySize", "width", "height", "getImageScaleInfo", "getShowGalleryHeight", "getShowGalleryWidth", "isDialogMoving", "isLandscape", "needUpdateGallerySize", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDialogDismissAnimationEnd", "onDialogDismissAnimationStart", "onDialogShowAnimationEnd", "onDialogShowAnimationStart", "dialogHeight", "startTransY", "endTransY", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onDismissDialogMove", "onShowDialogMove", "onTouchMoveBegin", "onTouchMoveEnd", "release", "setAnimationType", "setCanRefresh", "canRefresh", "setDialogShowParams", "showBackgroundOpView", "show", "updateCustomScaleRate", "updateGalleryHeight", "updateGallerySize", "updateGalleryWidth", "Companion", "plugin-scan_release"})
public final class f
  implements com.tencent.mm.plugin.scanner.box.f
{
  public static final f.a INN;
  MMViewPager CcM;
  int INA;
  int INB;
  private int INC;
  private int IND;
  private float INE;
  private float INF;
  g.a ING;
  c INH;
  int INI;
  private c.a INJ;
  boolean INK;
  boolean INL;
  private final g INM;
  d INh;
  View INi;
  final Context context;
  
  static
  {
    AppMethodBeat.i(222152);
    INN = new f.a((byte)0);
    AppMethodBeat.o(222152);
  }
  
  public f(Context paramContext, g paramg)
  {
    AppMethodBeat.i(222149);
    this.context = paramContext;
    this.INM = paramg;
    this.ING = new g.a();
    this.INC = ax.getStatusBarHeight(this.context);
    this.IND = this.context.getResources().getDimensionPixelSize(l.d.Edge_A);
    AppMethodBeat.o(222149);
  }
  
  private final void adL(int paramInt)
  {
    AppMethodBeat.i(222144);
    MMViewPager localMMViewPager = this.CcM;
    if (localMMViewPager != null)
    {
      Object localObject = this.CcM;
      if (localObject != null)
      {
        localObject = ((MMViewPager)localObject).getLayoutParams();
        if (localObject != null) {
          ((ViewGroup.LayoutParams)localObject).height = paramInt;
        }
      }
      for (;;)
      {
        localMMViewPager.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(222144);
        return;
        localObject = null;
      }
    }
    AppMethodBeat.o(222144);
  }
  
  private final boolean fDs()
  {
    AppMethodBeat.i(222133);
    if ((this.INI == 1) && (!isLandscape()))
    {
      AppMethodBeat.o(222133);
      return true;
    }
    AppMethodBeat.o(222133);
    return false;
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(222131);
    Resources localResources = this.context.getResources();
    p.j(localResources, "context.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(222131);
      return true;
    }
    AppMethodBeat.o(222131);
    return false;
  }
  
  public final void c(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222071);
    paramFloat2 = Math.min(Math.max(Math.abs(this.INE - paramFloat1) * 1.0F / Math.abs(this.INF - this.INE), 0.0F), 1.0F);
    float f;
    Object localObject1;
    Object localObject2;
    if (paramInt == 0) {
      if (fDs())
      {
        int i = this.INA;
        int j = fDu();
        int k = (int)((j - i) * paramFloat2) + i;
        int m = fDt();
        f = this.INB;
        ji((int)((m - this.INB) * paramFloat2 + f), k);
        localObject1 = this.CcM;
        if (localObject1 != null)
        {
          localObject1 = ((MMViewPager)localObject1).getLayoutParams();
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((ViewGroup.LayoutParams)localObject1).width);
            localObject2 = this.CcM;
            if (localObject2 == null) {
              break label352;
            }
            localObject2 = ((MMViewPager)localObject2).getLayoutParams();
            if (localObject2 == null) {
              break label352;
            }
            localObject2 = Integer.valueOf(((ViewGroup.LayoutParams)localObject2).height);
            label174:
            Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo updateGalleryHeight dialogState: %s, start: %s, end: %s, targetHeight: %s, factor: %s, offsetY: %s, realFactor: %s, gallery: (%s, %s)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), localObject1, localObject2 });
          }
        }
      }
      else
      {
        Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onShowDialogMove factor: %s", new Object[] { Float.valueOf(paramFloat2) });
        if (!(this.INi instanceof com.tencent.mm.ui.base.g)) {
          break label361;
        }
        localObject1 = this.INH;
        if (localObject1 == null) {
          break label358;
        }
        if (((c)localObject1).fDw() != true) {
          break label361;
        }
        localObject1 = this.INH;
        if (localObject1 == null) {
          break label361;
        }
        ((c)localObject1).bV(paramFloat2);
      }
    }
    label522:
    label528:
    label531:
    for (;;)
    {
      if (paramFloat2 < 1.0F) {
        break label534;
      }
      xn(true);
      this.INK = false;
      AppMethodBeat.o(222071);
      return;
      localObject1 = null;
      break;
      label352:
      localObject2 = null;
      break label174;
      label358:
      continue;
      label361:
      continue;
      paramInt = fDt();
      paramFloat1 = this.INB;
      f = paramInt - this.INB;
      if (fDs())
      {
        paramInt = (int)(f * paramFloat2 + paramFloat1);
        localObject2 = this.CcM;
        if (localObject2 != null)
        {
          localObject1 = this.CcM;
          if (localObject1 == null) {
            break label522;
          }
          localObject1 = ((MMViewPager)localObject1).getLayoutParams();
          if (localObject1 == null) {
            break label522;
          }
          ((ViewGroup.LayoutParams)localObject1).width = paramInt;
        }
      }
      for (;;)
      {
        ((MMViewPager)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDismissDialogMove factor: %s", new Object[] { Float.valueOf(paramFloat2) });
        if (!(this.INi instanceof com.tencent.mm.ui.base.g)) {
          break label531;
        }
        localObject1 = this.INH;
        if (localObject1 == null) {
          break label528;
        }
        if (((c)localObject1).fDw() != true) {
          break label531;
        }
        localObject1 = this.INH;
        if (localObject1 == null) {
          break label531;
        }
        ((c)localObject1).bW(1.0F - paramFloat2);
        break;
        localObject1 = null;
      }
    }
    label534:
    xn(false);
    AppMethodBeat.o(222071);
  }
  
  public final void d(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222101);
    this.INL = true;
    int i = this.INC;
    Object localObject1 = this.INh;
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = Boolean.valueOf(((d)localObject1).IGq);; localObject1 = null)
    {
      Log.i("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDialogShowAnimationStart dialogHeight: %s, startTransY: %s, endTransY: %s, statusBarHeight: %s, enableFullScreen: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(i), localObject1 });
      this.INE = paramFloat1;
      this.INF = paramFloat2;
      setCanRefresh(false);
      localObject1 = new c.a();
      ((c.a)localObject1).kJL = this.INi;
      ((c.a)localObject1).IOd.set(this.INB, this.INA);
      ((c.a)localObject1).IOe.set(fDt(), fDu());
      this.INJ = ((c.a)localObject1);
      localObject1 = this.INH;
      if (localObject1 != null)
      {
        localObject2 = this.INJ;
        if (localObject2 == null) {
          p.iCn();
        }
        ((c)localObject1).a((c.a)localObject2);
      }
      localObject1 = this.ING;
      localObject2 = this.INJ;
      if (localObject2 == null) {
        p.iCn();
      }
      ((g.a)localObject1).INO = ((c.a)localObject2).INO;
      localObject2 = this.INJ;
      if (localObject2 == null) {
        p.iCn();
      }
      ((g.a)localObject1).INQ = ((c.a)localObject2).IOg.IOh.x;
      localObject2 = this.INJ;
      if (localObject2 == null) {
        p.iCn();
      }
      if ((!((c.a)localObject2).INO) || (!(this.INi instanceof com.tencent.mm.ui.base.g))) {
        break label350;
      }
      paramFloat1 = fDt();
      localObject2 = this.INi;
      if (localObject2 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      AppMethodBeat.o(222101);
      throw ((Throwable)localObject1);
    }
    ((g.a)localObject1).INP = (paramFloat1 * 1.0F / ((com.tencent.mm.ui.base.g)localObject2).getImageWidth());
    label350:
    Log.i("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDialogShowAnimationStart isLongImage: %s, showDefaultScale: %s, showDoubleScale: %s", new Object[] { Boolean.valueOf(this.ING.INO), Float.valueOf(this.ING.INQ), Float.valueOf(this.ING.INP) });
    fDr();
    fDq();
    if ((this.INi instanceof WxImageView))
    {
      localObject1 = this.INi;
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(222101);
        throw ((Throwable)localObject1);
      }
      ((WxImageView)localObject1).setAllowInterceptTouchEvent(false);
    }
    AppMethodBeat.o(222101);
  }
  
  public final void fCc()
  {
    AppMethodBeat.i(222051);
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onTouchMoveBegin");
    fCe();
    this.INK = true;
    AppMethodBeat.o(222051);
  }
  
  public final void fCd()
  {
    AppMethodBeat.i(222052);
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onTouchMoveEnd");
    this.INM.reset();
    AppMethodBeat.o(222052);
  }
  
  public final void fCe()
  {
    AppMethodBeat.i(222079);
    this.INL = true;
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDialogDismissAnimationStart isTouchMoved: %s, isDialogAnimating: %s", new Object[] { Boolean.valueOf(this.INK), Boolean.valueOf(this.INL) });
    if (this.INK)
    {
      this.INK = false;
      AppMethodBeat.o(222079);
      return;
    }
    if (this.INJ != null)
    {
      c localc = this.INH;
      if (localc != null)
      {
        c.a locala = this.INJ;
        if (locala == null) {
          p.iCn();
        }
        localc.b(locala);
      }
    }
    setCanRefresh(false);
    xn(false);
    if (fDs()) {
      adL(this.INA);
    }
    AppMethodBeat.o(222079);
  }
  
  public final void fCf()
  {
    AppMethodBeat.i(222088);
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDialogDismissAnimationEnd");
    this.INL = false;
    setCanRefresh(true);
    if ((this.INi instanceof com.tencent.mm.ui.base.g))
    {
      localObject = this.INi;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(222088);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.ui.base.g)localObject).hJA();
    }
    if ((this.INi instanceof WxImageView))
    {
      localObject = this.INi;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(222088);
        throw ((Throwable)localObject);
      }
      ((WxImageView)localObject).setAllowInterceptTouchEvent(true);
    }
    Object localObject = this.INi;
    if (localObject != null) {
      ((View)localObject).setAlpha(1.0F);
    }
    if ((this.INI == 1) && (isLandscape()) && ((this.INi instanceof com.tencent.mm.ui.base.g)))
    {
      ji(this.INA, this.INB);
      localObject = this.INi;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(222088);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.ui.base.g)localObject).hJx();
    }
    AppMethodBeat.o(222088);
  }
  
  public final void fCg()
  {
    AppMethodBeat.i(222105);
    this.INL = false;
    if ((this.INI == 1) && (isLandscape())) {
      xn(true);
    }
    AppMethodBeat.o(222105);
  }
  
  final void fDq()
  {
    AppMethodBeat.i(222118);
    if ((this.INi instanceof WxImageView))
    {
      Object localObject = this.INi;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(222118);
        throw ((Throwable)localObject);
      }
      if (((WxImageView)localObject).getMinScale() > this.ING.INQ)
      {
        localObject = this.INi;
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
          AppMethodBeat.o(222118);
          throw ((Throwable)localObject);
        }
        ((WxImageView)localObject).setMinScale(this.ING.INQ);
      }
    }
    AppMethodBeat.o(222118);
  }
  
  final void fDr()
  {
    AppMethodBeat.i(222124);
    if (((this.INi instanceof com.tencent.mm.ui.base.g)) && (this.INI == 1))
    {
      Object localObject = this.INi;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(222124);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.ui.base.g)localObject).setCustomScaleRate(Float.valueOf(this.ING.INQ));
    }
    AppMethodBeat.o(222124);
  }
  
  public final int fDt()
  {
    return this.INB - this.IND * 2;
  }
  
  public final int fDu()
  {
    d locald = this.INh;
    if (locald != null) {}
    for (boolean bool = locald.IGq; bool; bool = true) {
      return (int)(this.INF + this.INC);
    }
    return (int)this.INF;
  }
  
  final void ji(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222142);
    MMViewPager localMMViewPager = this.CcM;
    if (localMMViewPager != null)
    {
      Object localObject = this.CcM;
      if (localObject != null)
      {
        localObject = ((MMViewPager)localObject).getLayoutParams();
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).width = paramInt1;
          ((ViewGroup.LayoutParams)localObject).height = paramInt2;
        }
      }
      for (;;)
      {
        localMMViewPager.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(222142);
        return;
        localObject = null;
      }
    }
    AppMethodBeat.o(222142);
  }
  
  final void setCanRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(222128);
    Log.i("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo setCanRefresh %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), this.INi });
    if ((this.INi instanceof com.tencent.mm.ui.base.g))
    {
      Object localObject = this.INi;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(222128);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.ui.base.g)localObject).setCanRefresh(paramBoolean);
    }
    AppMethodBeat.o(222128);
  }
  
  final void xn(boolean paramBoolean)
  {
    AppMethodBeat.i(222108);
    this.INM.xn(paramBoolean);
    AppMethodBeat.o(222108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.f
 * JD-Core Version:    0.7.0.1
 */