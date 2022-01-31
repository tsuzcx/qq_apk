package com.tencent.mm.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AllRemindMsgUI$c$3$1
  implements View.OnCreateContextMenuListener
{
  AllRemindMsgUI$c$3$1(AllRemindMsgUI.c.3 param3) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(29123);
    paramContextMenu.add(0, 0, 0, this.yTJ.yTI.yTD.getContext().getString(2131298232));
    AppMethodBeat.o(29123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c.3.1
 * JD-Core Version:    0.7.0.1
 */