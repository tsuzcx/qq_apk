package com.tencent.mm.plugin.story.ui.view;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
public final class CommentItemView$c
  implements Interpolator
{
  private final float AYD;
  private final PointF AYE;
  private final PointF AYF;
  private final PointF AYG;
  
  public CommentItemView$c(PointF paramPointF)
  {
    AppMethodBeat.i(120023);
    this.AYG = paramPointF;
    this.AYD = 0.2F;
    this.AYE = new PointF(this.AYG.x * (1.0F - this.AYD), this.AYG.y * (1.0F - this.AYD));
    this.AYF = new PointF(this.AYG.x + (1.0F - this.AYG.x) * this.AYD, this.AYG.y + (1.0F - this.AYG.y) * this.AYD);
    AppMethodBeat.o(120023);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < this.AYE.x) {
      return this.AYG.y * paramFloat / this.AYG.x;
    }
    if (paramFloat < this.AYF.x) {
      return this.AYE.y + (paramFloat - this.AYE.x) / (this.AYF.x - this.AYE.x) * (this.AYF.y - this.AYE.y);
    }
    return this.AYG.y + (paramFloat - this.AYG.x) / (1.0F - this.AYG.x) * (1.0F - this.AYG.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView.c
 * JD-Core Version:    0.7.0.1
 */