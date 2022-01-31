package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;

final class g$67
  implements View.OnCreateContextMenuListener
{
  g$67(g paramg) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 1, 0, g.i(this.rzi).getString(R.l.app_field_mmsight));
    paramContextMenu.add(0, 2, 1, g.i(this.rzi).getString(R.l.app_field_select_new_pic));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.67
 * JD-Core Version:    0.7.0.1
 */