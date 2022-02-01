package com.tencent.mm.plugin.scanner.f.a;

import android.graphics.PointF;
import android.view.View;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/animation/BaseOCRImageAnimator;", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator;", "()V", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "getAnimationInfo", "()Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "setAnimationInfo", "(Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;)V", "currentImageView", "Landroid/view/View;", "getCurrentImageView", "()Landroid/view/View;", "setCurrentImageView", "(Landroid/view/View;)V", "onShowStart", "", "Companion", "plugin-scan_release"})
public abstract class b
  implements c
{
  public static final b.a IOc = new b.a((byte)0);
  private c.a INJ;
  private View INi;
  
  public void a(c.a parama)
  {
    p.k(parama, "animationInfo");
    this.INJ = parama;
    this.INi = parama.kJL;
    Object localObject;
    PointF localPointF1;
    float f1;
    float f2;
    label110:
    int i;
    label135:
    label146:
    int j;
    if ((this.INi instanceof g))
    {
      localObject = this.INi;
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      }
      localObject = (g)localObject;
      PointF localPointF2 = ((g)localObject).getImageViewMatrixScale();
      localPointF1 = ((g)localObject).getImageViewMatrixTranslation();
      c.b localb = parama.IOf;
      PointF localPointF3 = localb.IOh;
      if (localPointF2 == null) {
        break label361;
      }
      f1 = localPointF2.x;
      if (localPointF2 == null) {
        break label366;
      }
      f2 = localPointF2.y;
      localPointF3.set(f1, f2);
      localPointF2 = localb.IOi;
      if (localPointF1 == null) {
        break label371;
      }
      f1 = localPointF1.x;
      if (localPointF1 == null) {
        break label376;
      }
      f2 = localPointF1.y;
      localPointF2.set(f1, f2);
      Log.i("MicroMsg.BaseOCRImageAnimator", "alvinluo onShowStart start scale: %s, translation: %s", new Object[] { parama.IOf.IOh, parama.IOf.IOi });
      i = ((g)localObject).getImageWidth();
      j = ((g)localObject).getImageHeight();
      f1 = parama.IOe.x;
      f2 = parama.IOe.y;
      if (i * 1.0F / j <= 1.0F * f1 / f2) {
        break label381;
      }
      parama.INO = false;
      localObject = parama.IOg;
      ((c.b)localObject).IOh.x = (1.0F * f1 / i);
      ((c.b)localObject).IOh.y = ((c.b)localObject).IOh.x;
      ((c.b)localObject).IOi.x = 0.0F;
      localObject = ((c.b)localObject).IOi;
      f1 = parama.IOg.IOh.y;
    }
    for (((PointF)localObject).y = ((f2 - j * f1) / 2.0F);; ((c.b)localObject).IOi.y = 0.0F)
    {
      Log.i("MicroMsg.BaseOCRImageAnimator", "alvinluo onShowStart target scale: %s, translation: %s, isLongImage: %b", new Object[] { parama.IOg.IOh, parama.IOg.IOi, Boolean.valueOf(parama.INO) });
      return;
      label361:
      f1 = 1.0F;
      break;
      label366:
      f2 = 1.0F;
      break label110;
      label371:
      f1 = 0.0F;
      break label135;
      label376:
      f2 = 0.0F;
      break label146;
      label381:
      parama.INO = true;
      localObject = parama.IOg;
      ((c.b)localObject).IOh.x = (1.0F * f2 / j);
      ((c.b)localObject).IOh.y = ((c.b)localObject).IOh.x;
      localPointF1 = ((c.b)localObject).IOi;
      f2 = parama.IOg.IOh.x;
      localPointF1.x = ((f1 - i * f2) / 2.0F);
    }
  }
  
  protected final void c(c.a parama)
  {
    this.INJ = parama;
  }
  
  protected final c.a fDx()
  {
    return this.INJ;
  }
  
  protected final View getCurrentImageView()
  {
    return this.INi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a.b
 * JD-Core Version:    0.7.0.1
 */