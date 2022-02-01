package com.tencent.mm.plugin.scanner.f.a;

import android.graphics.PointF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator;", "", "canUpdate", "", "onDismissStart", "", "animationInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "onDismissUpdate", "factor", "", "onShowStart", "onShowUpdate", "AnimationType", "ImageAnimationInfo", "ImageViewTransformInfo", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public abstract void a(a parama);
  
  public abstract void b(a parama);
  
  public abstract void db(float paramFloat);
  
  public abstract void dc(float paramFloat);
  
  public abstract boolean gRI();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageAnimationInfo;", "", "()V", "animationEndInfo", "Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageViewTransformInfo;", "getAnimationEndInfo", "()Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageViewTransformInfo;", "setAnimationEndInfo", "(Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageViewTransformInfo;)V", "animationStartInfo", "getAnimationStartInfo", "setAnimationStartInfo", "imageEndSize", "Landroid/graphics/PointF;", "getImageEndSize", "()Landroid/graphics/PointF;", "setImageEndSize", "(Landroid/graphics/PointF;)V", "imageStartSize", "getImageStartSize", "setImageStartSize", "isLongImage", "", "()Z", "setLongImage", "(Z)V", "targetView", "Landroid/view/View;", "getTargetView", "()Landroid/view/View;", "setTargetView", "(Landroid/view/View;)V", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public boolean OUR;
    public PointF OVf;
    public PointF OVg;
    c.b OVh;
    public c.b OVi;
    public View nmf;
    
    public a()
    {
      AppMethodBeat.i(313522);
      this.OVf = new PointF();
      this.OVg = new PointF();
      this.OVh = new c.b();
      this.OVi = new c.b();
      AppMethodBeat.o(313522);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/animation/OCRImageAnimator$ImageViewTransformInfo;", "", "()V", "scale", "Landroid/graphics/PointF;", "getScale", "()Landroid/graphics/PointF;", "translation", "getTranslation", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public final PointF OVj;
    final PointF OVk;
    
    public b()
    {
      AppMethodBeat.i(313524);
      this.OVj = new PointF();
      this.OVk = new PointF();
      AppMethodBeat.o(313524);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a.c
 * JD-Core Version:    0.7.0.1
 */