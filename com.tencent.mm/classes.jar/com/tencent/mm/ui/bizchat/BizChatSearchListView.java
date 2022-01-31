package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BizChatSearchListView
  extends ListView
{
  private BizChatSearchListView.a ztB;
  
  public BizChatSearchListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BizChatSearchListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30134);
    if (this.ztB != null) {
      this.ztB.aWA();
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(30134);
      return true;
    }
    AppMethodBeat.o(30134);
    return false;
  }
  
  public void setOnTouchListener(BizChatSearchListView.a parama)
  {
    this.ztB = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchListView
 * JD-Core Version:    0.7.0.1
 */