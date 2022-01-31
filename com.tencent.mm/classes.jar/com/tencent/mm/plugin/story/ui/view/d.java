package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import java.util.Random;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/CommentSmallConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "startX", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "reset", "plugin-story_release"})
public final class d
  extends b
{
  private final String TAG;
  private final Bitmap bitmap;
  private final int centerX;
  private final int centerY;
  private int startX;
  
  public d(Bitmap paramBitmap)
  {
    AppMethodBeat.i(110361);
    this.bitmap = paramBitmap;
    this.TAG = "MicroMsg.CommentSmallConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    if (new Random().nextBoolean()) {}
    for (int i = this.centerX;; i = -this.centerX)
    {
      this.startX = i;
      AppMethodBeat.o(110361);
      return;
    }
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 = 1.0F;
    AppMethodBeat.i(110360);
    j.q(paramCanvas, "canvas");
    j.q(paramMatrix, "matrix");
    j.q(paramPaint, "paint");
    if (paramFloat4 > 0.8D) {
      paramFloat3 = (1.0F - paramFloat4) / 0.2F;
    }
    int i = paramPaint.getAlpha();
    paramMatrix.preTranslate(paramFloat1, paramFloat2);
    paramMatrix.preScale(0.5F, 0.5F, this.centerX, this.centerY);
    paramPaint.setAlpha((int)(paramFloat3 * 255.0F));
    paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
    paramPaint.setAlpha(i);
    AppMethodBeat.o(110360);
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(110359);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(110359);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(110358);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(110358);
    return i;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(110357);
    super.reset();
    if (new Random().nextBoolean()) {}
    for (int i = this.centerX;; i = -this.centerX)
    {
      this.startX = i;
      AppMethodBeat.o(110357);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.d
 * JD-Core Version:    0.7.0.1
 */