package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

final class i$2
  implements AdapterView.OnItemClickListener
{
  i$2(i parami) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < i.e(this.vdw).getHeaderViewsCount()) {}
    do
    {
      do
      {
        return;
        int i = i.e(this.vdw).getHeaderViewsCount();
        paramAdapterView = (Preference)i.d(this.vdw).getItem(paramInt - i);
      } while ((!paramAdapterView.isEnabled()) || (!paramAdapterView.vdI) || ((paramAdapterView instanceof CheckBoxPreference)));
      if ((paramAdapterView instanceof DialogPreference))
      {
        paramView = (DialogPreference)paramAdapterView;
        paramView.showDialog();
        paramView.vcf = new i.2.1(this, paramView, paramAdapterView);
      }
      if ((paramAdapterView instanceof EditPreference))
      {
        paramView = (EditPreference)paramAdapterView;
        paramView.showDialog();
        paramView.vch = new i.2.2(this, paramView, paramAdapterView);
      }
    } while (paramAdapterView.mKey == null);
    this.vdw.a(i.d(this.vdw), paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.i.2
 * JD-Core Version:    0.7.0.1
 */