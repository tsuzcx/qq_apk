package com.tencent.mm.plugin.scanner.f.a;

import android.graphics.PointF;
import android.view.View;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/animation/BaseOCRImageAnimator;", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator;", "()V", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "getAnimationInfo", "()Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "setAnimationInfo", "(Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;)V", "currentImageView", "Landroid/view/View;", "getCurrentImageView", "()Landroid/view/View;", "setCurrentImageView", "(Landroid/view/View;)V", "onShowStart", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  implements c
{
  public static final b.a OVe = new b.a((byte)0);
  private c.a OUO;
  private View OUm;
  
  public void a(c.a parama)
  {
    s.u(parama, "animationInfo");
    this.OUO = parama;
    this.OUm = parama.nmf;
    Object localObject;
    PointF localPointF2;
    PointF localPointF1;
    float f1;
    float f2;
    label102:
    label123:
    int i;
    label130:
    int j;
    if ((this.OUm instanceof i))
    {
      localObject = this.OUm;
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      }
      localObject = (i)localObject;
      localPointF2 = ((i)localObject).getImageViewMatrixScale();
      localPointF1 = ((i)localObject).getImageViewMatrixTranslation();
      c.b localb = parama.OVh;
      PointF localPointF3 = localb.OVj;
      if (localPointF2 != null) {
        break label345;
      }
      f1 = 1.0F;
      if (localPointF2 != null) {
        break label354;
      }
      f2 = 1.0F;
      localPointF3.set(f1, f2);
      localPointF2 = localb.OVk;
      if (localPointF1 != null) {
        break label363;
      }
      f1 = 0.0F;
      if (localPointF1 != null) {
        break label372;
      }
      f2 = 0.0F;
      localPointF2.set(f1, f2);
      Log.i("MicroMsg.BaseOCRImageAnimator", "alvinluo onShowStart start scale: %s, translation: %s", new Object[] { parama.OVh.OVj, parama.OVh.OVk });
      i = ((i)localObject).getImageWidth();
      j = ((i)localObject).getImageHeight();
      f1 = parama.OVg.x;
      f2 = parama.OVg.y;
      if (i * 1.0F / j <= 1.0F * f1 / f2) {
        break label381;
      }
      parama.OUR = false;
      localObject = parama.OVi;
      ((c.b)localObject).OVj.x = (1.0F * f1 / i);
      ((c.b)localObject).OVj.y = ((c.b)localObject).OVj.x;
      ((c.b)localObject).OVk.x = 0.0F;
      localObject = ((c.b)localObject).OVk;
      f1 = parama.OVi.OVj.y;
    }
    for (((PointF)localObject).y = ((f2 - j * f1) / 2.0F);; ((c.b)localObject).OVk.y = 0.0F)
    {
      Log.i("MicroMsg.BaseOCRImageAnimator", "alvinluo onShowStart target scale: %s, translation: %s, isLongImage: %b", new Object[] { parama.OVi.OVj, parama.OVi.OVk, Boolean.valueOf(parama.OUR) });
      return;
      label345:
      f1 = localPointF2.x;
      break;
      label354:
      f2 = localPointF2.y;
      break label102;
      label363:
      f1 = localPointF1.x;
      break label123;
      label372:
      f2 = localPointF1.y;
      break label130;
      label381:
      parama.OUR = true;
      localObject = parama.OVi;
      ((c.b)localObject).OVj.x = (1.0F * f2 / j);
      ((c.b)localObject).OVj.y = ((c.b)localObject).OVj.x;
      localPointF1 = ((c.b)localObject).OVk;
      f2 = parama.OVi.OVj.x;
      localPointF1.x = ((f1 - i * f2) / 2.0F);
    }
  }
  
  protected final void c(c.a parama)
  {
    this.OUO = parama;
  }
  
  protected final c.a gRJ()
  {
    return this.OUO;
  }
  
  protected final View getCurrentImageView()
  {
    return this.OUm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a.b
 * JD-Core Version:    0.7.0.1
 */