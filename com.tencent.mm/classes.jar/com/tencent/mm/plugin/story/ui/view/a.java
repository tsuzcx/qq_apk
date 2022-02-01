package com.tencent.mm.plugin.story.ui.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.LayerDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "avatarDrawable", "Landroid/graphics/drawable/LayerDrawable;", "(Landroid/graphics/drawable/LayerDrawable;)V", "TAG", "", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-story_release"})
public final class a
  extends com.tencent.mm.particles.a.b
{
  private final String TAG;
  private final int centerX;
  private final int centerY;
  private final LayerDrawable zGS;
  
  public a(LayerDrawable paramLayerDrawable)
  {
    AppMethodBeat.i(120006);
    this.zGS = paramLayerDrawable;
    this.TAG = "MicroMsg.CommentConfetti";
    this.centerX = (this.zGS.getIntrinsicWidth() / 2);
    this.centerY = (this.zGS.getIntrinsicHeight() / 2);
    AppMethodBeat.o(120006);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(120005);
    k.h(paramCanvas, "canvas");
    k.h(paramMatrix, "matrix");
    k.h(paramPaint, "paint");
    paramFloat3 = 1.0F - paramFloat4;
    paramFloat4 = 1.0F - paramFloat4;
    paramPaint.setAlpha((int)(paramFloat4 * 255.0F));
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramCanvas.scale(paramFloat3, paramFloat3);
    paramMatrix = this.zGS.getDrawable(1);
    if (paramMatrix == null)
    {
      paramCanvas = new v("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.AvatarRoundDrawable");
      AppMethodBeat.o(120005);
      throw paramCanvas;
    }
    ((com.tencent.mm.pluginsdk.ui.b)paramMatrix).WN((int)(paramFloat4 * 255.0F));
    this.zGS.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(120005);
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(120004);
    int i = this.zGS.getIntrinsicHeight();
    AppMethodBeat.o(120004);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(120003);
    int i = this.zGS.getIntrinsicWidth();
    AppMethodBeat.o(120003);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.a
 * JD-Core Version:    0.7.0.1
 */