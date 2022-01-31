package com.tencent.mm.plugin.readerapp.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class ReaderAppUI$1
  implements View.OnCreateContextMenuListener
{
  ReaderAppUI$1(ReaderAppUI paramReaderAppUI, boolean paramBoolean) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(76813);
    int i = ((Integer)paramView.getTag()).intValue();
    paramContextMenu.clear();
    if (ReaderAppUI.a(this.pUg) == 20) {
      paramContextMenu.setHeaderTitle(2131300614);
    }
    for (;;)
    {
      if (20 == ReaderAppUI.a(this.pUg))
      {
        if (this.pUf) {
          paramContextMenu.add(i, 0, 1, 2131302296);
        }
        if (d.ahR("favorite")) {
          paramContextMenu.add(i, 1, 2, 2131302102);
        }
        ReaderAppUI.a(this.pUg, ((Integer)paramView.getTag(2131820655)).intValue());
      }
      paramContextMenu.add(i, 2, 3, 2131302295);
      AppMethodBeat.o(76813);
      return;
      paramContextMenu.setHeaderTitle(2131300617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.1
 * JD-Core Version:    0.7.0.1
 */