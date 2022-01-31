package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.plugin.c;
import com.tencent.mm.plugin.record.b.u;

final class d$2$1
  implements View.OnCreateContextMenuListener
{
  d$2$1(d.2 param2) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(153639);
    paramContextMenu.add(this.qay.qau.context.getString(2131296895));
    if ((!c.Cc()) || (this.qay.qav == null))
    {
      AppMethodBeat.o(153639);
      return;
    }
    if (this.qay.qaw)
    {
      if (this.qay.qax.status == 2)
      {
        paramContextMenu.add(this.qay.qau.context.getString(2131298249));
        AppMethodBeat.o(153639);
        return;
      }
      paramContextMenu.add(this.qay.qau.context.getString(2131298251));
      AppMethodBeat.o(153639);
      return;
    }
    if (this.qay.qax.cKx == 1) {
      paramContextMenu.add(this.qay.qau.context.getString(2131298243));
    }
    AppMethodBeat.o(153639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.2.1
 * JD-Core Version:    0.7.0.1
 */