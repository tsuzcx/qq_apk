package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;

public class RealAlphabetScrollBar
  extends VerticalScrollBar
{
  public RealAlphabetScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final void ann()
  {
    this.yuX = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.yuV = 1.3F;
    this.yuW = 79;
  }
  
  protected int getToastLayoutId()
  {
    return 2131496311;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.RealAlphabetScrollBar
 * JD-Core Version:    0.7.0.1
 */