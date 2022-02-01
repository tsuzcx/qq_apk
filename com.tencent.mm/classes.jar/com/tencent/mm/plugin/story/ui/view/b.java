package com.tencent.mm.plugin.story.ui.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/CommentConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.particles.a.b
{
  private final String TAG;
  private final Bitmap bitmap;
  private final int centerX;
  private final int centerY;
  
  public b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(120017);
    this.bitmap = paramBitmap;
    this.TAG = "MicroMsg.CommentConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    AppMethodBeat.o(120017);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(120016);
    s.u(paramCanvas, "canvas");
    s.u(paramMatrix, "matrix");
    s.u(paramPaint, "paint");
    paramFloat3 = 1.0F - paramFloat4;
    int i = paramPaint.getAlpha();
    paramMatrix.preTranslate(paramFloat1, paramFloat2);
    paramMatrix.preScale(paramFloat3, paramFloat3, this.centerX, this.centerY);
    paramPaint.setAlpha((int)(255.0F * (1.0F - paramFloat4)));
    paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
    paramPaint.setAlpha(i);
    AppMethodBeat.o(120016);
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(120015);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(120015);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(120014);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(120014);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.b
 * JD-Core Version:    0.7.0.1
 */