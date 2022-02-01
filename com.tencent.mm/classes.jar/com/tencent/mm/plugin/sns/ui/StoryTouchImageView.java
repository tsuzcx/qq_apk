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
  i ApJ;
  
  public StoryTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99695);
    this.ApJ = null;
    this.ApJ = ((e)g.ad(e.class)).getStoryUIFactory().gt(paramContext);
    this.ApJ.aZ(this);
    this.ApJ.setOnClickListener(this.ApJ.egV());
    setLayerType(1, null);
    AppMethodBeat.o(99695);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99696);
    super.onDraw(paramCanvas);
    this.ApJ.a(paramCanvas, true, 0);
    AppMethodBeat.o(99696);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(99697);
    super.setOnClickListener(this.ApJ.egV());
    this.ApJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(99697);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(99698);
    this.ApJ.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(99698);
  }
  
  public final void setUserNameAndPageNumber$505cff1c(String paramString)
  {
    AppMethodBeat.i(221352);
    this.ApJ.fe(paramString, 1);
    AppMethodBeat.o(221352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.StoryTouchImageView
 * JD-Core Version:    0.7.0.1
 */