package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.AlphabetScrollBar;

public class SortViewScrollBar
  extends AlphabetScrollBar
{
  public SortViewScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void aNw()
  {
    this.JMk = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.JMi = 1.45F;
    this.JMj = 79;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.SortViewScrollBar
 * JD-Core Version:    0.7.0.1
 */