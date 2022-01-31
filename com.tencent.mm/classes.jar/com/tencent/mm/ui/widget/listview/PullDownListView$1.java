package com.tencent.mm.ui.widget.listview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PullDownListView$1
  implements Runnable
{
  PullDownListView$1(PullDownListView paramPullDownListView, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(112724);
    if (PullDownListView.b(this.AIy) != null)
    {
      PullDownListView.a(this.AIy, -PullDownListView.b(this.AIy).getWidth());
      PullDownListView.b(this.AIy, PullDownListView.b(this.AIy).getHeight());
      PullDownListView.b(this.AIy).setVisibility(8);
    }
    this.AIx.bringToFront();
    AppMethodBeat.o(112724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.1
 * JD-Core Version:    0.7.0.1
 */