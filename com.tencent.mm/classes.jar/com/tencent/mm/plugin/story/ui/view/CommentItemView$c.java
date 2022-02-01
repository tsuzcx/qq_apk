package com.tencent.mm.plugin.story.ui.view;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CommentItemView$c
  implements Interpolator
{
  private final PointF SwR;
  private final float SwS;
  private final PointF SwT;
  private final PointF SwU;
  
  public CommentItemView$c(PointF paramPointF)
  {
    AppMethodBeat.i(120023);
    this.SwR = paramPointF;
    this.SwS = 0.2F;
    this.SwT = new PointF(this.SwR.x * (1.0F - this.SwS), this.SwR.y * (1.0F - this.SwS));
    this.SwU = new PointF(this.SwR.x + (1.0F - this.SwR.x) * this.SwS, this.SwR.y + (1.0F - this.SwR.y) * this.SwS);
    AppMethodBeat.o(120023);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < this.SwT.x) {
      return this.SwR.y * paramFloat / this.SwR.x;
    }
    if (paramFloat < this.SwU.x) {
      return this.SwT.y + (paramFloat - this.SwT.x) / (this.SwU.x - this.SwT.x) * (this.SwU.y - this.SwT.y);
    }
    return this.SwR.y + (paramFloat - this.SwR.x) / (1.0F - this.SwR.x) * (1.0F - this.SwR.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView.c
 * JD-Core Version:    0.7.0.1
 */