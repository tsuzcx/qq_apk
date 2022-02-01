package com.tencent.mm.plugin.scanner.f.a;

import android.graphics.PointF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator;", "", "canUpdate", "", "onDismissStart", "", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "onDismissUpdate", "factor", "", "onShowStart", "onShowUpdate", "AnimationType", "ImageAnimationInfo", "ImageViewTransformInfo", "plugin-scan_release"})
public abstract interface c
{
  public abstract void a(a parama);
  
  public abstract void b(a parama);
  
  public abstract void bV(float paramFloat);
  
  public abstract void bW(float paramFloat);
  
  public abstract boolean fDw();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "", "()V", "animationEndInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageViewTransformInfo;", "getAnimationEndInfo", "()Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageViewTransformInfo;", "setAnimationEndInfo", "(Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageViewTransformInfo;)V", "animationStartInfo", "getAnimationStartInfo", "setAnimationStartInfo", "imageEndSize", "Landroid/graphics/PointF;", "getImageEndSize", "()Landroid/graphics/PointF;", "setImageEndSize", "(Landroid/graphics/PointF;)V", "imageStartSize", "getImageStartSize", "setImageStartSize", "isLongImage", "", "()Z", "setLongImage", "(Z)V", "targetView", "Landroid/view/View;", "getTargetView", "()Landroid/view/View;", "setTargetView", "(Landroid/view/View;)V", "plugin-scan_release"})
  public static final class a
  {
    public boolean INO;
    public PointF IOd;
    public PointF IOe;
    c.b IOf;
    public c.b IOg;
    public View kJL;
    
    public a()
    {
      AppMethodBeat.i(218971);
      this.IOd = new PointF();
      this.IOe = new PointF();
      this.IOf = new c.b();
      this.IOg = new c.b();
      AppMethodBeat.o(218971);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageViewTransformInfo;", "", "()V", "scale", "Landroid/graphics/PointF;", "getScale", "()Landroid/graphics/PointF;", "translation", "getTranslation", "plugin-scan_release"})
  public static final class b
  {
    public final PointF IOh;
    final PointF IOi;
    
    public b()
    {
      AppMethodBeat.i(218713);
      this.IOh = new PointF();
      this.IOi = new PointF();
      AppMethodBeat.o(218713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a.c
 * JD-Core Version:    0.7.0.1
 */