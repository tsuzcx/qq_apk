package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;

public class StoryTouchImageView
  extends TouchImageView
{
  i sci;
  
  public StoryTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39835);
    this.sci = null;
    this.sci = ((e)g.G(e.class)).getStoryUIFactory().fc(paramContext);
    this.sci.aT(this);
    setLayerType(1, null);
    AppMethodBeat.o(39835);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39836);
    super.onDraw(paramCanvas);
    this.sci.a(paramCanvas, true, 0);
    AppMethodBeat.o(39836);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(39837);
    super.setOnClickListener(this.sci.czr());
    this.sci.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(39837);
  }
  
  public void setShowStoryHint(boolean paramBoolean)
  {
    AppMethodBeat.i(39838);
    this.sci.setShowStoryHint(paramBoolean);
    AppMethodBeat.o(39838);
  }
  
  public final void setUserNameAndPageNumber$505cff1c(String paramString)
  {
    AppMethodBeat.i(156761);
    this.sci.dw(paramString, 1);
    AppMethodBeat.o(156761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.StoryTouchImageView
 * JD-Core Version:    0.7.0.1
 */