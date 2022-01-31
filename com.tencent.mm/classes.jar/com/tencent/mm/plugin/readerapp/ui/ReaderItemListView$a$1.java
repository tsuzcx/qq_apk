package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;

final class ReaderItemListView$a$1
  implements View.OnLongClickListener
{
  ReaderItemListView$a$1(ReaderItemListView.a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(76857);
    new l(this.pUC.pUB.getContext()).b(paramView, ReaderItemListView.c(this.pUC.pUB), ReaderItemListView.e(this.pUC.pUB));
    AppMethodBeat.o(76857);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderItemListView.a.1
 * JD-Core Version:    0.7.0.1
 */