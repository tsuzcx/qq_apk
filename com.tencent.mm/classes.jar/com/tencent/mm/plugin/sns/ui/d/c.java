package com.tencent.mm.plugin.sns.ui.d;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class c
  implements View.OnCreateContextMenuListener
{
  public abstract void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo);
  
  public abstract boolean dU(View paramView);
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (dU(paramView))
    {
      a(paramContextMenu, paramView, paramContextMenuInfo);
      return;
    }
    ab.e("MicroMsg.TimelineOnCreateContextMenuListener", "onMMCreateContextMenu error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c
 * JD-Core Version:    0.7.0.1
 */