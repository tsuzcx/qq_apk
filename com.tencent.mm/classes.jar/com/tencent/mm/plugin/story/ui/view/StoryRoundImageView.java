package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "round", "getRound", "()I", "setRound", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryRoundImageView
  extends ImageView
{
  private int ePP;
  private final RectF ekW;
  private final Path path;
  
  public StoryRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120302);
    AppMethodBeat.o(120302);
  }
  
  public StoryRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120303);
    this.ekW = new RectF();
    this.path = new Path();
    AppMethodBeat.o(120303);
  }
  
  public final int getRound()
  {
    return this.ePP;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(120301);
    this.ekW.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.path.addRoundRect(this.ekW, this.ePP, this.ePP, Path.Direction.CW);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (paramCanvas != null) {
      paramCanvas.clipPath(this.path);
    }
    super.onDraw(paramCanvas);
    if (paramCanvas != null) {
      paramCanvas.restore();
    }
    AppMethodBeat.o(120301);
  }
  
  public final void setRound(int paramInt)
  {
    this.ePP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryRoundImageView
 * JD-Core Version:    0.7.0.1
 */