package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ac.a.h;

public class RealAlphabetScrollBar
  extends VerticalScrollBar
{
  public RealAlphabetScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int getToastLayoutId()
  {
    return a.h.show_head_toast;
  }
  
  protected final void xZ()
  {
    this.lvg = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.lve = 1.3F;
    this.lvf = 79;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.RealAlphabetScrollBar
 * JD-Core Version:    0.7.0.1
 */