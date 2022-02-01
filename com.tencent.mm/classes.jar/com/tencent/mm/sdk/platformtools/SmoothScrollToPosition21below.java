package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SmoothScrollToPosition21below
  implements BackwardSupportUtil.SmoothScrollFactory.IScroll
{
  public void doScroll(ListView paramListView)
  {
    AppMethodBeat.i(263042);
    paramListView.setSelection(0);
    AppMethodBeat.o(263042);
  }
  
  public void doScroll(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(263044);
    paramListView.setSelection(paramInt);
    AppMethodBeat.o(263044);
  }
  
  public void doScrollFromTop(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(263045);
    paramListView.setSelectionFromTop(paramInt, 0);
    AppMethodBeat.o(263045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SmoothScrollToPosition21below
 * JD-Core Version:    0.7.0.1
 */