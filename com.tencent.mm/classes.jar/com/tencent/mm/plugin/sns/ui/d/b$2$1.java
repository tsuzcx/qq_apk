package com.tencent.mm.plugin.sns.ui.d;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.sns.i.j;

final class b$2$1
  implements View.OnCreateContextMenuListener
{
  b$2$1(b.2 param2) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, this.ppm.ppl.activity.getString(i.j.contact_info_op_sns_permission));
    paramContextMenu.add(1, 1, 0, this.ppm.ppl.activity.getString(i.j.sns_timeline_expose));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.2.1
 * JD-Core Version:    0.7.0.1
 */