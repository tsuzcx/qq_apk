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
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRResultDialogMoveListener;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "context", "Landroid/content/Context;", "ocrViewModel", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;)V", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "animationType", "", "currentImageView", "Landroid/view/View;", "dialogEndOffsetY", "", "dialogStartOffsetY", "gallery", "galleryHeight", "galleryWidth", "imageAnimator", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator;", "imageScaleInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel$ImageScaleInfo;", "isDialogAnimating", "", "isTouchMoved", "leftRightPadding", "showParams", "Lcom/tencent/mm/plugin/scanner/api/ScanBoxDialogShowParams;", "statusBarHeight", "attachGallery", "", "attachImageView", "imageView", "checkMinScale", "doUpdateGallerySize", "width", "height", "getImageScaleInfo", "getShowGalleryHeight", "getShowGalleryWidth", "isDialogMoving", "isLandscape", "needUpdateGallerySize", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDialogDismissAnimationEnd", "onDialogDismissAnimationStart", "onDialogShowAnimationEnd", "onDialogShowAnimationStart", "dialogHeight", "startTransY", "endTransY", "onDialogVerticalMoved", "dialogState", "offsetY", "factor", "onDismissDialogMove", "onShowDialogMove", "onTouchMoveBegin", "onTouchMoveEnd", "release", "setAnimationType", "setCanRefresh", "canRefresh", "setDialogShowParams", "showBackgroundOpView", "show", "updateCustomScaleRate", "updateGalleryHeight", "updateGallerySize", "updateGalleryWidth", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements com.tencent.mm.plugin.scanner.box.f
{
  public static final f.a OUE;
  private final g OUF;
  int OUG;
  int OUH;
  private int OUI;
  private float OUJ;
  private float OUK;
  g.a OUL;
  c OUM;
  int OUN;
  private c.a OUO;
  boolean OUP;
  boolean OUQ;
  d OUl;
  View OUm;
  View OUn;
  final Context context;
  private int vpn;
  
  static
  {
    AppMethodBeat.i(313506);
    OUE = new f.a((byte)0);
    AppMethodBeat.o(313506);
  }
  
  public f(Context paramContext, g paramg)
  {
    AppMethodBeat.i(313477);
    this.context = paramContext;
    this.OUF = paramg;
    this.OUL = new g.a();
    this.vpn = bf.getStatusBarHeight(this.context);
    this.OUI = this.context.getResources().getDimensionPixelSize(l.d.Edge_A);
    AppMethodBeat.o(313477);
  }
  
  private final void aii(int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(313502);
    View localView = this.OUn;
    Object localObject2;
    if (localView != null)
    {
      localObject2 = this.OUn;
      if (localObject2 != null) {
        break label39;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(313502);
      return;
      label39:
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 != null)
      {
        ((ViewGroup.LayoutParams)localObject2).height = paramInt;
        localObject1 = ah.aiuX;
        localObject1 = localObject2;
      }
    }
  }
  
  private final boolean gRE()
  {
    AppMethodBeat.i(313494);
    if ((this.OUN == 1) && (!isLandscape()))
    {
      AppMethodBeat.o(313494);
      return true;
    }
    AppMethodBeat.o(313494);
    return false;
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(313486);
    if (this.context.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(313486);
      return true;
    }
    AppMethodBeat.o(313486);
    return false;
  }
  
  final void Cc(boolean paramBoolean)
  {
    AppMethodBeat.i(313554);
    this.OUF.Cc(paramBoolean);
    AppMethodBeat.o(313554);
  }
  
  public final void d(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(313523);
    paramFloat2 = Math.min(Math.max(1.0F * Math.abs(this.OUJ - paramFloat1) / Math.abs(this.OUK - this.OUJ), 0.0F), 1.0F);
    Object localObject1;
    Object localObject2;
    if (paramInt == 0)
    {
      if (gRE())
      {
        int i = this.OUG;
        int j = gRG();
        int k = (int)((j - i) * paramFloat2) + i;
        int m = gRF();
        f = this.OUH;
        kP((int)((m - this.OUH) * paramFloat2 + f), k);
        localObject1 = this.OUn;
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject2 = this.OUn;
          if (localObject2 != null) {
            break label345;
          }
          localObject2 = null;
          label136:
          Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo updateGalleryHeight dialogState: %s, start: %s, end: %s, targetHeight: %s, factor: %s, offsetY: %s, realFactor: %s, gallery: (%s, %s)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), localObject1, localObject2 });
        }
      }
      else
      {
        Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onShowDialogMove factor: %s", new Object[] { Float.valueOf(paramFloat2) });
        if ((this.OUm instanceof i))
        {
          localObject1 = this.OUM;
          if ((localObject1 == null) || (((c)localObject1).gRI() != true)) {
            break label376;
          }
        }
      }
      label345:
      label376:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          localObject1 = this.OUM;
          if (localObject1 != null) {
            ((c)localObject1).db(paramFloat2);
          }
        }
        if (paramFloat2 < 1.0F) {
          break label567;
        }
        Cc(true);
        this.OUP = false;
        AppMethodBeat.o(313523);
        return;
        localObject1 = ((View)localObject1).getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((ViewGroup.LayoutParams)localObject1).width);
        break;
        localObject2 = ((View)localObject2).getLayoutParams();
        if (localObject2 == null)
        {
          localObject2 = null;
          break label136;
        }
        localObject2 = Integer.valueOf(((ViewGroup.LayoutParams)localObject2).height);
        break label136;
      }
    }
    paramInt = gRF();
    paramFloat1 = this.OUH;
    float f = paramInt - this.OUH;
    if (gRE())
    {
      paramInt = (int)(f * paramFloat2 + paramFloat1);
      localObject2 = this.OUn;
      if (localObject2 != null)
      {
        localObject1 = this.OUn;
        if (localObject1 != null) {
          break label530;
        }
        localObject1 = null;
        label441:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDismissDialogMove factor: %s", new Object[] { Float.valueOf(paramFloat2) });
    if ((this.OUm instanceof i))
    {
      localObject1 = this.OUM;
      if ((localObject1 == null) || (((c)localObject1).gRI() != true)) {
        break label562;
      }
    }
    label530:
    label562:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        localObject1 = this.OUM;
        if (localObject1 != null) {
          ((c)localObject1).dc(1.0F - paramFloat2);
        }
      }
      break;
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label441;
      }
      ((ViewGroup.LayoutParams)localObject1).width = paramInt;
      ah localah = ah.aiuX;
      break label441;
    }
    label567:
    Cc(false);
    AppMethodBeat.o(313523);
  }
  
  public final void e(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(313545);
    this.OUQ = true;
    int i = this.vpn;
    Object localObject1 = this.OUl;
    if (localObject1 == null) {}
    Object localObject2;
    for (localObject1 = null;; localObject1 = Boolean.valueOf(((d)localObject1).OMy))
    {
      Log.i("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDialogShowAnimationStart dialogHeight: %s, startTransY: %s, endTransY: %s, statusBarHeight: %s, enableFullScreen: %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(i), localObject1 });
      this.OUJ = paramFloat1;
      this.OUK = paramFloat2;
      setCanRefresh(false);
      localObject1 = new c.a();
      ((c.a)localObject1).nmf = this.OUm;
      ((c.a)localObject1).OVf.set(this.OUH, this.OUG);
      ((c.a)localObject1).OVg.set(gRF(), gRG());
      localObject2 = ah.aiuX;
      this.OUO = ((c.a)localObject1);
      localObject1 = this.OUM;
      if (localObject1 != null)
      {
        localObject2 = this.OUO;
        s.checkNotNull(localObject2);
        ((c)localObject1).a((c.a)localObject2);
      }
      localObject1 = this.OUL;
      localObject2 = this.OUO;
      s.checkNotNull(localObject2);
      ((g.a)localObject1).OUR = ((c.a)localObject2).OUR;
      localObject2 = this.OUO;
      s.checkNotNull(localObject2);
      ((g.a)localObject1).OUT = ((c.a)localObject2).OVi.OVj.x;
      localObject2 = this.OUO;
      s.checkNotNull(localObject2);
      if ((!((c.a)localObject2).OUR) || (!(this.OUm instanceof i))) {
        break label343;
      }
      paramFloat1 = gRF();
      localObject2 = this.OUm;
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      AppMethodBeat.o(313545);
      throw ((Throwable)localObject1);
    }
    ((g.a)localObject1).OUS = (paramFloat1 * 1.0F / ((i)localObject2).getImageWidth());
    label343:
    Log.i("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDialogShowAnimationStart isLongImage: %s, showDefaultScale: %s, showDoubleScale: %s", new Object[] { Boolean.valueOf(this.OUL.OUR), Float.valueOf(this.OUL.OUT), Float.valueOf(this.OUL.OUS) });
    gRD();
    gRC();
    if ((this.OUm instanceof WxImageView))
    {
      localObject1 = this.OUm;
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(313545);
        throw ((Throwable)localObject1);
      }
      ((WxImageView)localObject1).setAllowInterceptTouchEvent(false);
    }
    AppMethodBeat.o(313545);
  }
  
  public final void gPJ()
  {
    AppMethodBeat.i(313510);
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onTouchMoveBegin");
    gPL();
    this.OUP = true;
    AppMethodBeat.o(313510);
  }
  
  public final void gPK()
  {
    AppMethodBeat.i(313514);
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onTouchMoveEnd");
    this.OUF.reset();
    AppMethodBeat.o(313514);
  }
  
  public final void gPL()
  {
    AppMethodBeat.i(313530);
    this.OUQ = true;
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDialogDismissAnimationStart isTouchMoved: %s, isDialogAnimating: %s", new Object[] { Boolean.valueOf(this.OUP), Boolean.valueOf(this.OUQ) });
    if (this.OUP)
    {
      this.OUP = false;
      AppMethodBeat.o(313530);
      return;
    }
    if (this.OUO != null)
    {
      c localc = this.OUM;
      if (localc != null)
      {
        c.a locala = this.OUO;
        s.checkNotNull(locala);
        localc.b(locala);
      }
    }
    setCanRefresh(false);
    Cc(false);
    if (gRE()) {
      aii(this.OUG);
    }
    AppMethodBeat.o(313530);
  }
  
  public final void gPM()
  {
    AppMethodBeat.i(313536);
    Log.v("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo onDialogDismissAnimationEnd");
    this.OUQ = false;
    setCanRefresh(true);
    if ((this.OUm instanceof i))
    {
      localObject = this.OUm;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313536);
        throw ((Throwable)localObject);
      }
      ((i)localObject).jmd();
    }
    if ((this.OUm instanceof WxImageView))
    {
      localObject = this.OUm;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(313536);
        throw ((Throwable)localObject);
      }
      ((WxImageView)localObject).setAllowInterceptTouchEvent(true);
    }
    Object localObject = this.OUm;
    if (localObject != null) {
      ((View)localObject).setAlpha(1.0F);
    }
    if ((this.OUN == 1) && (isLandscape()) && ((this.OUm instanceof i)))
    {
      kP(this.OUG, this.OUH);
      localObject = this.OUm;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313536);
        throw ((Throwable)localObject);
      }
      ((i)localObject).jma();
    }
    AppMethodBeat.o(313536);
  }
  
  public final void gPN()
  {
    AppMethodBeat.i(313550);
    this.OUQ = false;
    if ((this.OUN == 1) && (isLandscape())) {
      Cc(true);
    }
    AppMethodBeat.o(313550);
  }
  
  final void gRC()
  {
    AppMethodBeat.i(313559);
    if ((this.OUm instanceof WxImageView))
    {
      Object localObject = this.OUm;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(313559);
        throw ((Throwable)localObject);
      }
      if (((WxImageView)localObject).getMinScale() > this.OUL.OUT)
      {
        localObject = this.OUm;
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
          AppMethodBeat.o(313559);
          throw ((Throwable)localObject);
        }
        ((WxImageView)localObject).setMinScale(this.OUL.OUT);
      }
    }
    AppMethodBeat.o(313559);
  }
  
  final void gRD()
  {
    AppMethodBeat.i(313564);
    if (((this.OUm instanceof i)) && (this.OUN == 1))
    {
      Object localObject = this.OUm;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313564);
        throw ((Throwable)localObject);
      }
      ((i)localObject).setCustomScaleRate(Float.valueOf(this.OUL.OUT));
    }
    AppMethodBeat.o(313564);
  }
  
  public final int gRF()
  {
    return this.OUH - this.OUI * 2;
  }
  
  public final int gRG()
  {
    d locald = this.OUl;
    if (locald == null) {}
    for (boolean bool = true; bool; bool = locald.OMy) {
      return (int)(this.OUK + this.vpn);
    }
    return (int)this.OUK;
  }
  
  final void kP(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(313578);
    View localView = this.OUn;
    Object localObject2;
    if (localView != null)
    {
      localObject2 = this.OUn;
      if (localObject2 != null) {
        break label43;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(313578);
      return;
      label43:
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 != null)
      {
        ((ViewGroup.LayoutParams)localObject2).width = paramInt1;
        ((ViewGroup.LayoutParams)localObject2).height = paramInt2;
        localObject1 = ah.aiuX;
        localObject1 = localObject2;
      }
    }
  }
  
  final void setCanRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(313570);
    Log.i("MicroMsg.ImageOcrResultDialogMoveListener", "alvinluo setCanRefresh %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), this.OUm });
    if ((this.OUm instanceof i))
    {
      Object localObject = this.OUm;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313570);
        throw ((Throwable)localObject);
      }
      ((i)localObject).setCanRefresh(paramBoolean);
    }
    AppMethodBeat.o(313570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.f
 * JD-Core Version:    0.7.0.1
 */