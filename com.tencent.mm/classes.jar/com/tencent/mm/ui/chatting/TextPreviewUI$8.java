package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.ui.widget.textview.b;

final class TextPreviewUI$8
  implements View.OnCreateContextMenuListener
{
  TextPreviewUI$8(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(31051);
    paramContextMenu.clear();
    paramContextMenu.add(0, 0, 0, this.zCJ.getResources().getString(2131296895));
    int i = bh.t(TextPreviewUI.b(this.zCJ));
    if ((i <= 0) || (i >= b.fz(TextPreviewUI.a(this.zCJ)).length())) {
      paramContextMenu.add(1, 1, 0, this.zCJ.getResources().getString(2131301554));
    }
    paramContextMenu.add(1, 2, 0, this.zCJ.getResources().getString(2131301553));
    AppMethodBeat.o(31051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.8
 * JD-Core Version:    0.7.0.1
 */