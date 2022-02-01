package com.tencent.mm.plugin.story.ui.view;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
public final class CommentItemView$c
  implements Interpolator
{
  private final float Bqb;
  private final PointF Bqc;
  private final PointF Bqd;
  private final PointF Bqe;
  
  public CommentItemView$c(PointF paramPointF)
  {
    AppMethodBeat.i(120023);
    this.Bqe = paramPointF;
    this.Bqb = 0.2F;
    this.Bqc = new PointF(this.Bqe.x * (1.0F - this.Bqb), this.Bqe.y * (1.0F - this.Bqb));
    this.Bqd = new PointF(this.Bqe.x + (1.0F - this.Bqe.x) * this.Bqb, this.Bqe.y + (1.0F - this.Bqe.y) * this.Bqb);
    AppMethodBeat.o(120023);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < this.Bqc.x) {
      return this.Bqe.y * paramFloat / this.Bqe.x;
    }
    if (paramFloat < this.Bqd.x) {
      return this.Bqc.y + (paramFloat - this.Bqc.x) / (this.Bqd.x - this.Bqc.x) * (this.Bqd.y - this.Bqc.y);
    }
    return this.Bqe.y + (paramFloat - this.Bqe.x) / (1.0F - this.Bqe.x) * (1.0F - this.Bqe.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView.c
 * JD-Core Version:    0.7.0.1
 */