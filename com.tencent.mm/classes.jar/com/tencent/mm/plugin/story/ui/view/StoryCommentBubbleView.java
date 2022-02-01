package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bubbleLeft", "getBubbleLeft", "()I", "setBubbleLeft", "(I)V", "bubbleTop", "getBubbleTop", "setBubbleTop", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "plugin-story_release"})
public final class StoryCommentBubbleView
  extends ImageView
{
  private int BqQ;
  private int BqR;
  
  public StoryCommentBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120094);
    AppMethodBeat.o(120094);
  }
  
  public StoryCommentBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120093);
    AppMethodBeat.o(120093);
  }
  
  public final int getBubbleLeft()
  {
    AppMethodBeat.i(120090);
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    AppMethodBeat.o(120090);
    return i;
  }
  
  public final int getBubbleTop()
  {
    AppMethodBeat.i(120091);
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    AppMethodBeat.o(120091);
    return i;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(120092);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(120092);
      return bool;
      animate().scaleX(1.3F).scaleY(1.3F).setDuration(100L).start();
      continue;
      animate().scaleX(1.0F).scaleY(1.0F).setDuration(100L).start();
    }
  }
  
  public final void setBubbleLeft(int paramInt)
  {
    this.BqQ = paramInt;
  }
  
  public final void setBubbleTop(int paramInt)
  {
    this.BqR = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentBubbleView
 * JD-Core Version:    0.7.0.1
 */