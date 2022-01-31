package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class am$a$2
  implements View.OnCreateContextMenuListener
{
  am$a$2(am.a parama, Context paramContext, am.f paramf) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33286);
    paramContextMenu.clear();
    paramContextMenu.add(0, 0, 0, this.val$context.getResources().getString(2131296895));
    paramView = this.zWZ.zXe.dTB();
    paramContextMenuInfo = (az)this.zWZ.zXe.getTag();
    if (paramContextMenuInfo != null) {}
    for (int i = bh.t(paramContextMenuInfo.cEE);; i = 0)
    {
      if ((i <= 0) || (i >= paramView.length())) {
        paramContextMenu.add(0, 1, 0, this.val$context.getResources().getString(2131301554));
      }
      paramContextMenu.add(0, 2, 0, this.val$context.getResources().getString(2131301553));
      paramContextMenu.add(0, 3, 0, this.val$context.getResources().getString(2131299680));
      AppMethodBeat.o(33286);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a.2
 * JD-Core Version:    0.7.0.1
 */