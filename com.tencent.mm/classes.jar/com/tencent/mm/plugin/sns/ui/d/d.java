package com.tencent.mm.plugin.sns.ui.d;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class d
  implements View.OnCreateContextMenuListener
{
  public abstract void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo);
  
  public abstract boolean fo(View paramView);
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (fo(paramView))
    {
      a(paramContextMenu, paramView, paramContextMenuInfo);
      return;
    }
    ad.e("MicroMsg.TimelineOnCreateContextMenuListener", "onMMCreateContextMenu error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.d
 * JD-Core Version:    0.7.0.1
 */