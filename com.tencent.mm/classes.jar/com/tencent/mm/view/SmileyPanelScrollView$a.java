package com.tencent.mm.view;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class SmileyPanelScrollView$a
  implements Runnable
{
  long ARu;
  long mStartTime;
  
  public SmileyPanelScrollView$a(SmileyPanelScrollView paramSmileyPanelScrollView) {}
  
  final void dQP()
  {
    AppMethodBeat.i(62942);
    this.ARu = 300L;
    this.mStartTime = SystemClock.uptimeMillis();
    h.qsU.e(13361, new Object[] { Integer.valueOf(0) });
    AppMethodBeat.o(62942);
  }
  
  public final void run()
  {
    AppMethodBeat.i(62943);
    dQP();
    AppMethodBeat.o(62943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelScrollView.a
 * JD-Core Version:    0.7.0.1
 */