package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/CommentTipSmallConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-story_release"})
public final class e
  extends b
{
  private final String TAG;
  private final Bitmap bitmap;
  private final int centerX;
  private final int centerY;
  
  public e(Bitmap paramBitmap)
  {
    AppMethodBeat.i(110365);
    this.bitmap = paramBitmap;
    this.TAG = "MicroMsg.CommentTipSmallConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    AppMethodBeat.o(110365);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 = 1.0F;
    AppMethodBeat.i(110364);
    j.q(paramCanvas, "canvas");
    j.q(paramMatrix, "matrix");
    j.q(paramPaint, "paint");
    float f = Math.max(1.0F - paramFloat4, 0.5F);
    if (paramFloat4 < 0.3F) {
      paramFloat3 = paramFloat4 / 0.3F;
    }
    for (;;)
    {
      int i = paramPaint.getAlpha();
      paramMatrix.preTranslate(paramFloat1, paramFloat2);
      paramMatrix.preScale(f, f, this.centerX, this.centerY);
      paramPaint.setAlpha((int)(paramFloat3 * 255.0F));
      paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
      paramPaint.setAlpha(i);
      AppMethodBeat.o(110364);
      return;
      if (paramFloat4 > 0.7D) {
        paramFloat3 = (1.0F - paramFloat4) / 0.3F;
      }
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(110363);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(110363);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(110362);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(110362);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.e
 * JD-Core Version:    0.7.0.1
 */