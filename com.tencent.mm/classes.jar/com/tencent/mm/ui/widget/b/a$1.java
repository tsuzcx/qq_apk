package com.tencent.mm.ui.widget.b;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import java.util.Iterator;
import java.util.List;

final class a$1
  implements AdapterView.OnItemLongClickListener
{
  a$1(a parama, View.OnCreateContextMenuListener paramOnCreateContextMenuListener) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a.a(this.woj).clear();
    ao.r("registerForPopupMenu AbsListView long click", new Object[0]);
    paramAdapterView = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    this.woi.onCreateContextMenu(a.a(this.woj), paramView, paramAdapterView);
    paramView = a.a(this.woj).uWD.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).uWG = paramAdapterView;
    }
    this.woj.ch(0, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a.1
 * JD-Core Version:    0.7.0.1
 */