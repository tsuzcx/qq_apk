package com.tencent.mm.view;

import android.os.SystemClock;
import com.tencent.mm.plugin.report.service.h;

public final class SmileyPanelScrollView$a
  implements Runnable
{
  long mStartTime;
  long wws;
  
  public SmileyPanelScrollView$a(SmileyPanelScrollView paramSmileyPanelScrollView) {}
  
  final void cLx()
  {
    this.wws = 300L;
    this.mStartTime = SystemClock.uptimeMillis();
    h.nFQ.f(13361, new Object[] { Integer.valueOf(0) });
  }
  
  public final void run()
  {
    cLx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelScrollView.a
 * JD-Core Version:    0.7.0.1
 */