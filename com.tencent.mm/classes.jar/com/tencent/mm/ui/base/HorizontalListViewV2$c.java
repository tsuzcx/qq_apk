package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;

@TargetApi(14)
final class HorizontalListViewV2$c
{
  static
  {
    if (Build.VERSION.SDK_INT < 14) {
      throw new RuntimeException("sdk is >= 14!");
    }
  }
  
  public static float b(Scroller paramScroller)
  {
    return paramScroller.getCurrVelocity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.c
 * JD-Core Version:    0.7.0.1
 */