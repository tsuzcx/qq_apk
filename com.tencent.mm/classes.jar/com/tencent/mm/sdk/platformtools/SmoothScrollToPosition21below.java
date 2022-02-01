package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SmoothScrollToPosition21below
  implements BackwardSupportUtil.SmoothScrollFactory.IScroll
{
  public void doScroll(ListView paramListView)
  {
    AppMethodBeat.i(215437);
    paramListView.setSelection(0);
    AppMethodBeat.o(215437);
  }
  
  public void doScroll(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(215438);
    paramListView.setSelection(paramInt);
    AppMethodBeat.o(215438);
  }
  
  public void doScrollFromTop(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(215439);
    paramListView.setSelectionFromTop(paramInt, 0);
    AppMethodBeat.o(215439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SmoothScrollToPosition21below
 * JD-Core Version:    0.7.0.1
 */