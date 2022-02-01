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
  private a KtU;
  private c aAA;
  private int maxHeight;
  
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
    AppMethodBeat.i(36700);
    setTag(2131306044, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    AppMethodBeat.o(36700);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36702);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(36702);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(36699);
    setTagObject(paramMotionEvent);
    if (this.aAA != null) {
      this.aAA.onTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(36699);
    return bool;
  }
  
  public void setFoldTextListener(a parama)
  {
    this.KtU = parama;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public void setOnGestureListener(GestureDetector.OnGestureListener paramOnGestureListener)
  {
    AppMethodBeat.i(36701);
    this.aAA = new c(getContext(), paramOnGestureListener);
    AppMethodBeat.o(36701);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.FoldableChatTextItemView
 * JD-Core Version:    0.7.0.1
 */