package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class SnsUIAction$9
  implements MMPullDownView.c
{
  SnsUIAction$9(SnsUIAction paramSnsUIAction) {}
  
  public final boolean bim()
  {
    AppMethodBeat.i(145646);
    View localView = this.sbh.list.getChildAt(this.sbh.list.getChildCount() - 1);
    if ((localView != null) && (localView.getBottom() <= this.sbh.list.getHeight()) && (this.sbh.list.getLastVisiblePosition() == this.sbh.list.getAdapter().getCount() - 1))
    {
      AppMethodBeat.o(145646);
      return true;
    }
    AppMethodBeat.o(145646);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.9
 * JD-Core Version:    0.7.0.1
 */