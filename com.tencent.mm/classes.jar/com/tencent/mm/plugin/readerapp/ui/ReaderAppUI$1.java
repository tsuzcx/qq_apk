package com.tencent.mm.plugin.readerapp.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.g;

final class ReaderAppUI$1
  implements View.OnCreateContextMenuListener
{
  ReaderAppUI$1(ReaderAppUI paramReaderAppUI, boolean paramBoolean) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramContextMenu.clear();
    if (ReaderAppUI.a(this.noS) == 20) {
      paramContextMenu.setHeaderTitle(a.g.hardcode_plugin_readerappnews_nick);
    }
    for (;;)
    {
      if (20 == ReaderAppUI.a(this.noS))
      {
        if (this.noR) {
          paramContextMenu.add(i, 0, 1, a.g.readerapp_menu_transmit);
        }
        if (d.SP("favorite")) {
          paramContextMenu.add(i, 1, 2, a.g.plugin_favorite_opt);
        }
        ReaderAppUI.a(this.noS, ((Integer)paramView.getTag(a.d.reader_msgindex)).intValue());
      }
      paramContextMenu.add(i, 2, 3, a.g.readerapp_menu_delete);
      return;
      paramContextMenu.setHeaderTitle(a.g.hardcode_plugin_readerappweibo_nick);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.1
 * JD-Core Version:    0.7.0.1
 */