package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BizChatSearchListView
  extends ListView
{
  private a aebD;
  
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
    AppMethodBeat.i(33987);
    if (this.aebD != null) {}
    for (boolean bool = this.aebD.dcu();; bool = false)
    {
      if ((bool) || (super.onInterceptTouchEvent(paramMotionEvent)))
      {
        AppMethodBeat.o(33987);
        return true;
      }
      AppMethodBeat.o(33987);
      return false;
    }
  }
  
  public void setOnTouchListener(a parama)
  {
    this.aebD = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean dcu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchListView
 * JD-Core Version:    0.7.0.1
 */