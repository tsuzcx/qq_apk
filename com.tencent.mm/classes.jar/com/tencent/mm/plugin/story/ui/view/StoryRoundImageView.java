package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "round", "getRound", "()I", "setRound", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-story_release"})
public final class StoryRoundImageView
  extends ImageView
{
  private final Path eyD;
  private final RectF rect;
  private int sNx;
  
  public StoryRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110467);
    AppMethodBeat.o(110467);
  }
  
  public StoryRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110468);
    this.rect = new RectF();
    this.eyD = new Path();
    AppMethodBeat.o(110468);
  }
  
  public final int getRound()
  {
    return this.sNx;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(110466);
    this.rect.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.eyD.addRoundRect(this.rect, this.sNx, this.sNx, Path.Direction.CW);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (paramCanvas != null) {
      paramCanvas.clipPath(this.eyD);
    }
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(110466);
      return;
    }
    AppMethodBeat.o(110466);
  }
  
  public final void setRound(int paramInt)
  {
    this.sNx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryRoundImageView
 * JD-Core Version:    0.7.0.1
 */