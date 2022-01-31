package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class SnsCommentDetailUI$b$1
  implements Runnable
{
  SnsCommentDetailUI$b$1(SnsCommentDetailUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(38829);
    SnsCommentDetailUI.a(this.rPS.rPu).setSelection(SnsCommentDetailUI.a(this.rPS.rPu).getHeaderViewsCount() + this.rPS.rPQ.size() - 1);
    AppMethodBeat.o(38829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.b.1
 * JD-Core Version:    0.7.0.1
 */