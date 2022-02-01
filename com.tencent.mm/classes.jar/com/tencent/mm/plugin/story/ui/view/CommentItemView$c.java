package com.tencent.mm.plugin.story.ui.view;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
public final class CommentItemView$c
  implements Interpolator
{
  private final float LUR;
  private final PointF LUS;
  private final PointF LUT;
  private final PointF LUU;
  
  public CommentItemView$c(PointF paramPointF)
  {
    AppMethodBeat.i(120023);
    this.LUU = paramPointF;
    this.LUR = 0.2F;
    this.LUS = new PointF(this.LUU.x * (1.0F - this.LUR), this.LUU.y * (1.0F - this.LUR));
    this.LUT = new PointF(this.LUU.x + (1.0F - this.LUU.x) * this.LUR, this.LUU.y + (1.0F - this.LUU.y) * this.LUR);
    AppMethodBeat.o(120023);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < this.LUS.x) {
      return this.LUU.y * paramFloat / this.LUU.x;
    }
    if (paramFloat < this.LUT.x) {
      return this.LUS.y + (paramFloat - this.LUS.x) / (this.LUT.x - this.LUS.x) * (this.LUT.y - this.LUS.y);
    }
    return this.LUU.y + (paramFloat - this.LUU.x) / (1.0F - this.LUU.x) * (1.0F - this.LUU.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView.c
 * JD-Core Version:    0.7.0.1
 */