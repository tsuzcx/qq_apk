package com.tencent.weui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.ui.ao;

final class WeUIPreference$3
  implements AdapterView.OnItemLongClickListener
{
  WeUIPreference$3(WeUIPreference paramWeUIPreference) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < WeUIPreference.e(this.xfT).getHeaderViewsCount()) {
      return false;
    }
    paramInt -= WeUIPreference.e(this.xfT).getHeaderViewsCount();
    if (paramInt >= WeUIPreference.d(this.xfT).getCount())
    {
      ao.v("itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(WeUIPreference.d(this.xfT).getCount()) });
      return false;
    }
    WeUIPreference.d(this.xfT).getItem(paramInt);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.3
 * JD-Core Version:    0.7.0.1
 */