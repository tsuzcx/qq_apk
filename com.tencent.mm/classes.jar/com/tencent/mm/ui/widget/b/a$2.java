package com.tencent.mm.ui.widget.b;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;

final class a$2
  implements View.OnLongClickListener
{
  a$2(a parama, View.OnCreateContextMenuListener paramOnCreateContextMenuListener) {}
  
  public final boolean onLongClick(View paramView)
  {
    ao.r("registerForPopupMenu normal view long click", new Object[0]);
    a.a(this.woj).clear();
    a.a(this.woj, paramView);
    this.woi.onCreateContextMenu(a.a(this.woj), paramView, null);
    if ((paramView.getTag(a.f.touch_loc) instanceof int[]))
    {
      paramView = (int[])paramView.getTag(a.f.touch_loc);
      if (paramView == null)
      {
        this.woj.ch(0, 0);
        return true;
      }
      this.woj.ch(paramView[0], paramView[1]);
      return true;
    }
    this.woj.ch(0, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a.2
 * JD-Core Version:    0.7.0.1
 */