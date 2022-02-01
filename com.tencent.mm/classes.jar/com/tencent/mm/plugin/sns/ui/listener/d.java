package com.tencent.mm.plugin.sns.ui.listener;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d
  implements View.OnCreateContextMenuListener
{
  public abstract void b(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo);
  
  public abstract boolean jQ(View paramView);
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (jQ(paramView))
    {
      b(paramContextMenu, paramView, paramContextMenuInfo);
      return;
    }
    Log.e("MicroMsg.TimelineOnCreateContextMenuListener", "onMMCreateContextMenu error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.listener.d
 * JD-Core Version:    0.7.0.1
 */