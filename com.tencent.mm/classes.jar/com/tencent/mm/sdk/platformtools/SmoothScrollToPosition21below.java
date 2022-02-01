package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SmoothScrollToPosition21below
  implements BackwardSupportUtil.SmoothScrollFactory.IScroll
{
  public void doScroll(ListView paramListView)
  {
    AppMethodBeat.i(244022);
    paramListView.setSelection(0);
    AppMethodBeat.o(244022);
  }
  
  public void doScroll(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(244029);
    paramListView.setSelection(paramInt);
    AppMethodBeat.o(244029);
  }
  
  public void doScrollFromTop(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(244036);
    paramListView.setSelectionFromTop(paramInt, 0);
    AppMethodBeat.o(244036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SmoothScrollToPosition21below
 * JD-Core Version:    0.7.0.1
 */