package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.n;

public class StoryTouchImageView
  extends TouchImageView
{
  i REW;
  
  public StoryTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99695);
    this.REW = null;
    this.REW = ((e)h.az(e.class)).getStoryUIFactory().ka(paramContext);
    this.REW.g(this);
    this.REW.setOnClickListener(this.REW.huQ());
    setLayerType(1, null);
    AppMethodBeat.o(99695);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99696);
    super.onDraw(paramCanvas);
    this.REW.a(paramCanvas, true, 0);
    AppMethodBeat.o(99696);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(99697);
    super.setOnClickListener(this.REW.huQ());
    this.REW.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(99697);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(99698);
    this.REW.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(99698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.StoryTouchImageView
 * JD-Core Version:    0.7.0.1
 */