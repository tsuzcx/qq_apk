package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;

final class j$2
  implements View.OnLongClickListener
{
  j$2(j paramj, View.OnCreateContextMenuListener paramOnCreateContextMenuListener) {}
  
  public final boolean onLongClick(View paramView)
  {
    y.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
    j.a(this.wdu).clear();
    this.wdt.onCreateContextMenu(j.a(this.wdu), paramView, null);
    this.wdu.bJQ();
    return j.a(this.wdu).size() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.j.2
 * JD-Core Version:    0.7.0.1
 */