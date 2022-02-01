package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.n;

public class StoryTouchImageView
  extends TouchImageView
{
  i yXY;
  
  public StoryTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99695);
    this.yXY = null;
    this.yXY = ((e)g.ad(e.class)).getStoryUIFactory().gq(paramContext);
    this.yXY.aZ(this);
    setLayerType(1, null);
    AppMethodBeat.o(99695);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99696);
    super.onDraw(paramCanvas);
    this.yXY.a(paramCanvas, true, 0);
    AppMethodBeat.o(99696);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(99697);
    super.setOnClickListener(this.yXY.dUH());
    this.yXY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(99697);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(99698);
    this.yXY.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(99698);
  }
  
  public final void setUserNameAndPageNumber$505cff1c(String paramString)
  {
    AppMethodBeat.i(210273);
    this.yXY.eM(paramString, 1);
    AppMethodBeat.o(210273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.StoryTouchImageView
 * JD-Core Version:    0.7.0.1
 */