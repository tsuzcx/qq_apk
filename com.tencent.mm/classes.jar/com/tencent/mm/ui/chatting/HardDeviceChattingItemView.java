package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class HardDeviceChattingItemView
  extends LinearLayout
{
  private boolean mHasInit;
  
  public HardDeviceChattingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (!this.mHasInit) {
      this.mHasInit = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.HardDeviceChattingItemView
 * JD-Core Version:    0.7.0.1
 */