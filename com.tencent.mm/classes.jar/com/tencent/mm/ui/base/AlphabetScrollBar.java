package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;

public class AlphabetScrollBar
  extends VerticalScrollBar
{
  public AlphabetScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void Kr()
  {
    this.nSx = new String[] { "↑", "☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.nSv = 1.6F;
    this.nSw = 79;
  }
  
  protected int getToastLayoutId()
  {
    return 2130970734;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.AlphabetScrollBar
 * JD-Core Version:    0.7.0.1
 */