package com.tencent.mm.plugin.scanner.f.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/animation/ScaleImageAnimator;", "Lcom/tencent/mm/plugin/scanner/ocr/animation/BaseOCRImageAnimator;", "context", "Landroid/content/Context;", "animationType", "", "(Landroid/content/Context;I)V", "dismissStartCalled", "", "matrix", "Landroid/graphics/Matrix;", "scale", "Landroid/graphics/PointF;", "translation", "canUpdate", "computeScale", "", "factor", "", "startScale", "endScale", "computeTranslation", "startTrans", "endTrans", "isLandscape", "onDismissStart", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "onDismissUpdate", "onShowStart", "onShowUpdate", "update", "updateImageViewMatrix", "imageView", "Lcom/tencent/mm/ui/base/IZoomableImageView;", "Companion", "plugin-scan_release"})
public final class d
  extends b
{
  public static final d.a IOk;
  private final int INI;
  private final PointF IOh;
  private final PointF IOi;
  private boolean IOj;
  private final Matrix aHZ;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(218622);
    IOk = new d.a((byte)0);
    AppMethodBeat.o(218622);
  }
  
  public d(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(218621);
    this.context = paramContext;
    this.INI = paramInt;
    this.aHZ = new Matrix();
    this.IOh = new PointF();
    this.IOi = new PointF();
    AppMethodBeat.o(218621);
  }
  
  private static void a(float paramFloat, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    AppMethodBeat.i(218619);
    float f3 = paramPointF2.x;
    float f4 = paramPointF2.y;
    float f5 = paramPointF3.x;
    float f6 = paramPointF3.y;
    float f1;
    if (f3 == f5)
    {
      f1 = f3;
      if (f4 != f5) {
        break label154;
      }
    }
    label154:
    for (float f2 = f4;; f2 = (f6 - f4) * paramFloat + f4)
    {
      Log.v("MicroMsg.ScaleImageAnimator", "alvinluo computeScale scale factor: %s, start: (%s, %s), end: (%s, %s), current: (%s, %s)", new Object[] { Float.valueOf(paramFloat), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f1), Float.valueOf(f2) });
      paramPointF1.x = f1;
      paramPointF1.y = f2;
      AppMethodBeat.o(218619);
      return;
      f1 = (f5 - f3) * paramFloat + f3;
      break;
    }
  }
  
  private static void b(float paramFloat, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    AppMethodBeat.i(218620);
    float f3 = paramPointF2.x;
    float f4 = paramPointF2.y;
    float f5 = paramPointF3.x;
    float f6 = paramPointF3.y;
    float f1;
    if (f3 == f5)
    {
      f1 = f3;
      if (f4 != f6) {
        break label154;
      }
    }
    label154:
    for (float f2 = f4;; f2 = (f6 - f4) * paramFloat + f4)
    {
      Log.v("MicroMsg.ScaleImageAnimator", "alvinluo computeTranslation translate factor: %s, start: (%s, %s), end: (%s, %s), current: (%s, %s)", new Object[] { Float.valueOf(paramFloat), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f1), Float.valueOf(f2) });
      paramPointF1.x = f1;
      paramPointF1.y = f2;
      AppMethodBeat.o(218620);
      return;
      f1 = (f5 - f3) * paramFloat + f3;
      break;
    }
  }
  
  private final void bX(float paramFloat)
  {
    AppMethodBeat.i(218615);
    if (fDx() == null)
    {
      AppMethodBeat.o(218615);
      return;
    }
    Object localObject1 = this.IOh;
    Object localObject2 = fDx();
    if (localObject2 == null) {
      p.iCn();
    }
    localObject2 = ((c.a)localObject2).IOf.IOh;
    c.a locala = fDx();
    if (locala == null) {
      p.iCn();
    }
    a(paramFloat, (PointF)localObject1, (PointF)localObject2, locala.IOg.IOh);
    localObject1 = this.IOi;
    localObject2 = fDx();
    if (localObject2 == null) {
      p.iCn();
    }
    localObject2 = ((c.a)localObject2).IOf.IOi;
    locala = fDx();
    if (locala == null) {
      p.iCn();
    }
    b(paramFloat, (PointF)localObject1, (PointF)localObject2, locala.IOg.IOi);
    this.aHZ.reset();
    this.aHZ.setScale(this.IOh.x, this.IOh.y);
    this.aHZ.postTranslate(this.IOi.x, this.IOi.y);
    localObject1 = getCurrentImageView();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      AppMethodBeat.o(218615);
      throw ((Throwable)localObject1);
    }
    ((g)localObject1).setImageViewMatrix(this.aHZ);
    AppMethodBeat.o(218615);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(218605);
    p.k(parama, "animationInfo");
    super.a(parama);
    this.IOj = false;
    AppMethodBeat.o(218605);
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(218609);
    p.k(parama, "animationInfo");
    if (this.IOj)
    {
      AppMethodBeat.o(218609);
      return;
    }
    if ((getCurrentImageView() instanceof g))
    {
      parama.IOg.IOh.set(parama.IOf.IOh);
      parama.IOg.IOi.set(parama.IOf.IOi);
      Object localObject = getCurrentImageView();
      if (localObject == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(218609);
        throw parama;
      }
      localObject = ((g)localObject).getImageViewMatrixScale();
      if (localObject != null) {
        parama.IOf.IOh.set((PointF)localObject);
      }
      localObject = getCurrentImageView();
      if (localObject == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(218609);
        throw parama;
      }
      localObject = ((g)localObject).getImageViewMatrixTranslation();
      if (localObject != null) {
        parama.IOf.IOi.set((PointF)localObject);
      }
      c(parama);
      this.IOj = true;
      Log.d("MicroMsg.ScaleImageAnimator", "alvinluo onDismissStart start scale: %s, translation: %s, animationEndInfo.scale: %s, animationEndInfo.translation: %s", new Object[] { parama.IOf.IOh, parama.IOf.IOi, parama.IOg.IOh, parama.IOg.IOi });
    }
    AppMethodBeat.o(218609);
  }
  
  public final void bV(float paramFloat)
  {
    AppMethodBeat.i(218610);
    bX(paramFloat);
    AppMethodBeat.o(218610);
  }
  
  public final void bW(float paramFloat)
  {
    AppMethodBeat.i(218611);
    bX(paramFloat);
    AppMethodBeat.o(218611);
  }
  
  public final boolean fDw()
  {
    AppMethodBeat.i(218612);
    if (this.INI == 1)
    {
      Resources localResources = this.context.getResources();
      p.j(localResources, "context.resources");
      if (localResources.getConfiguration().orientation == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(218612);
        return true;
      }
    }
    AppMethodBeat.o(218612);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a.d
 * JD-Core Version:    0.7.0.1
 */