package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

final class i$3
  implements AdapterView.OnItemLongClickListener
{
  i$3(i parami) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < i.e(this.vdw).getHeaderViewsCount()) {
      return false;
    }
    int i = i.e(this.vdw).getHeaderViewsCount();
    paramAdapterView = (Preference)i.d(this.vdw).getItem(paramInt - i);
    return this.vdw.a(i.d(this.vdw), paramAdapterView, i.e(this.vdw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.i.3
 * JD-Core Version:    0.7.0.1
 */