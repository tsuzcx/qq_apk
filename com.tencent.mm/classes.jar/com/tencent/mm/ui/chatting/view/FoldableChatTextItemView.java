package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.support.v4.view.c;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FoldableChatTextItemView
  extends LinearLayout
{
  private c aqn;
  private int maxHeight;
  private FoldableChatTextItemView.a zQQ;
  
  public FoldableChatTextItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FoldableChatTextItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setTagObject(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(32758);
    setTag(2131820681, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    AppMethodBeat.o(32758);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32760);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(32760);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(32757);
    setTagObject(paramMotionEvent);
    if (this.aqn != null) {
      this.aqn.onTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(32757);
    return bool;
  }
  
  public void setFoldTextListener(FoldableChatTextItemView.a parama)
  {
    this.zQQ = parama;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public void setOnGestureListener(GestureDetector.OnGestureListener paramOnGestureListener)
  {
    AppMethodBeat.i(32759);
    this.aqn = new c(getContext(), paramOnGestureListener);
    AppMethodBeat.o(32759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.FoldableChatTextItemView
 * JD-Core Version:    0.7.0.1
 */