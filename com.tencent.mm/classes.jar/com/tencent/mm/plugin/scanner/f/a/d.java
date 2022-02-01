package com.tencent.mm.plugin.scanner.f.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/animation/ScaleImageAnimator;", "Lcom/tencent/mm/plugin/scanner/ocr/animation/BaseOCRImageAnimator;", "context", "Landroid/content/Context;", "animationType", "", "(Landroid/content/Context;I)V", "dismissStartCalled", "", "matrix", "Landroid/graphics/Matrix;", "scale", "Landroid/graphics/PointF;", "translation", "canUpdate", "computeScale", "", "factor", "", "startScale", "endScale", "computeTranslation", "startTrans", "endTrans", "isLandscape", "onDismissStart", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "onDismissUpdate", "onShowStart", "onShowUpdate", "update", "updateImageViewMatrix", "imageView", "Lcom/tencent/mm/ui/base/IZoomableImageView;", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  public static final d.a OVl;
  private final int OUN;
  private final PointF OVj;
  private final PointF OVk;
  private boolean OVm;
  private final Context context;
  private final Matrix matrix;
  
  static
  {
    AppMethodBeat.i(313544);
    OVl = new d.a((byte)0);
    AppMethodBeat.o(313544);
  }
  
  public d(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(313519);
    this.context = paramContext;
    this.OUN = paramInt;
    this.matrix = new Matrix();
    this.OVj = new PointF();
    this.OVk = new PointF();
    AppMethodBeat.o(313519);
  }
  
  private static void a(float paramFloat, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    AppMethodBeat.i(313534);
    float f3 = paramPointF2.x;
    float f4 = paramPointF2.y;
    float f5 = paramPointF3.x;
    float f6 = paramPointF3.y;
    int i;
    float f1;
    if (f3 == f5)
    {
      i = 1;
      if (i == 0) {
        break label161;
      }
      f1 = f3;
      label49:
      if (f4 != f5) {
        break label176;
      }
      i = 1;
      label60:
      if (i == 0) {
        break label182;
      }
    }
    label161:
    label176:
    label182:
    for (float f2 = f4;; f2 = (f6 - f4) * paramFloat + f4)
    {
      Log.v("MicroMsg.ScaleImageAnimator", "alvinluo computeScale scale factor: %s, start: (%s, %s), end: (%s, %s), current: (%s, %s)", new Object[] { Float.valueOf(paramFloat), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f1), Float.valueOf(f2) });
      paramPointF1.x = f1;
      paramPointF1.y = f2;
      AppMethodBeat.o(313534);
      return;
      i = 0;
      break;
      f1 = (f5 - f3) * paramFloat + f3;
      break label49;
      i = 0;
      break label60;
    }
  }
  
  private static void b(float paramFloat, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    AppMethodBeat.i(313540);
    float f3 = paramPointF2.x;
    float f4 = paramPointF2.y;
    float f5 = paramPointF3.x;
    float f6 = paramPointF3.y;
    int i;
    float f1;
    if (f3 == f5)
    {
      i = 1;
      if (i == 0) {
        break label161;
      }
      f1 = f3;
      label49:
      if (f4 != f6) {
        break label176;
      }
      i = 1;
      label60:
      if (i == 0) {
        break label182;
      }
    }
    label161:
    label176:
    label182:
    for (float f2 = f4;; f2 = (f6 - f4) * paramFloat + f4)
    {
      Log.v("MicroMsg.ScaleImageAnimator", "alvinluo computeTranslation translate factor: %s, start: (%s, %s), end: (%s, %s), current: (%s, %s)", new Object[] { Float.valueOf(paramFloat), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f1), Float.valueOf(f2) });
      paramPointF1.x = f1;
      paramPointF1.y = f2;
      AppMethodBeat.o(313540);
      return;
      i = 0;
      break;
      f1 = (f5 - f3) * paramFloat + f3;
      break label49;
      i = 0;
      break label60;
    }
  }
  
  private final void dd(float paramFloat)
  {
    AppMethodBeat.i(313526);
    if (gRJ() == null)
    {
      AppMethodBeat.o(313526);
      return;
    }
    Object localObject1 = this.OVj;
    Object localObject2 = gRJ();
    s.checkNotNull(localObject2);
    localObject2 = ((c.a)localObject2).OVh.OVj;
    c.a locala = gRJ();
    s.checkNotNull(locala);
    a(paramFloat, (PointF)localObject1, (PointF)localObject2, locala.OVi.OVj);
    localObject1 = this.OVk;
    localObject2 = gRJ();
    s.checkNotNull(localObject2);
    localObject2 = ((c.a)localObject2).OVh.OVk;
    locala = gRJ();
    s.checkNotNull(locala);
    b(paramFloat, (PointF)localObject1, (PointF)localObject2, locala.OVi.OVk);
    this.matrix.reset();
    this.matrix.setScale(this.OVj.x, this.OVj.y);
    this.matrix.postTranslate(this.OVk.x, this.OVk.y);
    localObject1 = getCurrentImageView();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      AppMethodBeat.o(313526);
      throw ((Throwable)localObject1);
    }
    ((i)localObject1).setImageViewMatrix(this.matrix);
    AppMethodBeat.o(313526);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(313549);
    s.u(parama, "animationInfo");
    super.a(parama);
    this.OVm = false;
    AppMethodBeat.o(313549);
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(313555);
    s.u(parama, "animationInfo");
    if (this.OVm)
    {
      AppMethodBeat.o(313555);
      return;
    }
    if ((getCurrentImageView() instanceof i))
    {
      parama.OVi.OVj.set(parama.OVh.OVj);
      parama.OVi.OVk.set(parama.OVh.OVk);
      Object localObject = getCurrentImageView();
      if (localObject == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313555);
        throw parama;
      }
      localObject = ((i)localObject).getImageViewMatrixScale();
      if (localObject != null) {
        parama.OVh.OVj.set((PointF)localObject);
      }
      localObject = getCurrentImageView();
      if (localObject == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313555);
        throw parama;
      }
      localObject = ((i)localObject).getImageViewMatrixTranslation();
      if (localObject != null) {
        parama.OVh.OVk.set((PointF)localObject);
      }
      c(parama);
      this.OVm = true;
      Log.d("MicroMsg.ScaleImageAnimator", "alvinluo onDismissStart start scale: %s, translation: %s, animationEndInfo.scale: %s, animationEndInfo.translation: %s", new Object[] { parama.OVh.OVj, parama.OVh.OVk, parama.OVi.OVj, parama.OVi.OVk });
    }
    AppMethodBeat.o(313555);
  }
  
  public final void db(float paramFloat)
  {
    AppMethodBeat.i(313560);
    dd(paramFloat);
    AppMethodBeat.o(313560);
  }
  
  public final void dc(float paramFloat)
  {
    AppMethodBeat.i(313565);
    dd(paramFloat);
    AppMethodBeat.o(313565);
  }
  
  public final boolean gRI()
  {
    AppMethodBeat.i(313571);
    if (this.OUN == 1)
    {
      if (this.context.getResources().getConfiguration().orientation == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(313571);
        return true;
      }
    }
    AppMethodBeat.o(313571);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a.d
 * JD-Core Version:    0.7.0.1
 */