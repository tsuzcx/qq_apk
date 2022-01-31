package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class BizChatSearchListView
  extends ListView
{
  private BizChatSearchListView.a vfc;
  
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
    if (this.vfc != null) {
      this.vfc.axC();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setOnTouchListener(BizChatSearchListView.a parama)
  {
    this.vfc = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchListView
 * JD-Core Version:    0.7.0.1
 */