package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;

@TargetApi(11)
final class HorizontalListViewV2$b
{
  static
  {
    if (Build.VERSION.SDK_INT < 11) {
      throw new RuntimeException("sdk is >= 11!");
    }
  }
  
  public static void a(Scroller paramScroller)
  {
    if (paramScroller != null) {
      paramScroller.setFriction(0.009F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.b
 * JD-Core Version:    0.7.0.1
 */