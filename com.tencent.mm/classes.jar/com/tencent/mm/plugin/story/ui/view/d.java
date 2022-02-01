package com.tencent.mm.plugin.story.ui.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import d.g.b.k;
import d.l;
import java.util.Random;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/CommentSmallConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "startX", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "reset", "plugin-story_release"})
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
    AppMethodBeat.i(120042);
    this.bitmap = paramBitmap;
    this.TAG = "MicroMsg.CommentSmallConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    if (new Random().nextBoolean()) {}
    for (int i = this.centerX;; i = -this.centerX)
    {
      this.startX = i;
      AppMethodBeat.o(120042);
      return;
    }
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 = 1.0F;
    AppMethodBeat.i(120041);
    k.h(paramCanvas, "canvas");
    k.h(paramMatrix, "matrix");
    k.h(paramPaint, "paint");
    if (paramFloat4 > 0.8D) {
      paramFloat3 = (1.0F - paramFloat4) / 0.2F;
    }
    int i = paramPaint.getAlpha();
    paramMatrix.preTranslate(paramFloat1, paramFloat2);
    paramMatrix.preScale(0.5F, 0.5F, this.centerX, this.centerY);
    paramPaint.setAlpha((int)(paramFloat3 * 255.0F));
    paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
    paramPaint.setAlpha(i);
    AppMethodBeat.o(120041);
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(120040);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(120040);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(120039);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(120039);
    return i;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(120038);
    super.reset();
    if (new Random().nextBoolean()) {}
    for (int i = this.centerX;; i = -this.centerX)
    {
      this.startX = i;
      AppMethodBeat.o(120038);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.d
 * JD-Core Version:    0.7.0.1
 */