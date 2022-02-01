package com.tencent.mm.plugin.story.ui.view;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
public final class CommentItemView$c
  implements Interpolator
{
  private final float zHc;
  private final PointF zHd;
  private final PointF zHe;
  private final PointF zHf;
  
  public CommentItemView$c(PointF paramPointF)
  {
    AppMethodBeat.i(120023);
    this.zHf = paramPointF;
    this.zHc = 0.2F;
    this.zHd = new PointF(this.zHf.x * (1.0F - this.zHc), this.zHf.y * (1.0F - this.zHc));
    this.zHe = new PointF(this.zHf.x + (1.0F - this.zHf.x) * this.zHc, this.zHf.y + (1.0F - this.zHf.y) * this.zHc);
    AppMethodBeat.o(120023);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < this.zHd.x) {
      return this.zHf.y * paramFloat / this.zHf.x;
    }
    if (paramFloat < this.zHe.x) {
      return this.zHd.y + (paramFloat - this.zHd.x) / (this.zHe.x - this.zHd.x) * (this.zHe.y - this.zHd.y);
    }
    return this.zHf.y + (paramFloat - this.zHf.x) / (1.0F - this.zHf.x) * (1.0F - this.zHf.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView.c
 * JD-Core Version:    0.7.0.1
 */