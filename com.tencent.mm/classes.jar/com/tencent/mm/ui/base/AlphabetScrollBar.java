package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ac.a.h;

public class AlphabetScrollBar
  extends VerticalScrollBar
{
  public AlphabetScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int getToastLayoutId()
  {
    return a.h.show_head_toast;
  }
  
  public void xZ()
  {
    this.lvg = new String[] { "↑", "☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.lve = 1.3F;
    this.lvf = 79;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.AlphabetScrollBar
 * JD-Core Version:    0.7.0.1
 */