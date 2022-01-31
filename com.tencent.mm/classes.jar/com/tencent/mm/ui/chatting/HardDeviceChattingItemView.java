package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(30940);
    super.onFinishInflate();
    if (!this.mHasInit) {
      this.mHasInit = true;
    }
    AppMethodBeat.o(30940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.HardDeviceChattingItemView
 * JD-Core Version:    0.7.0.1
 */