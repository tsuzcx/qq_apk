package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class MMPreference$2
  implements AdapterView.OnItemClickListener
{
  MMPreference$2(MMPreference paramMMPreference) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Preference)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramAdapterView.isEnabled()) || (!paramAdapterView.vdI) || ((paramAdapterView instanceof CheckBoxPreference)));
      if ((paramAdapterView instanceof DialogPreference))
      {
        paramView = (DialogPreference)paramAdapterView;
        paramView.showDialog();
        paramView.vcf = new MMPreference.2.1(this, paramView, paramAdapterView);
      }
      if ((paramAdapterView instanceof EditPreference))
      {
        paramView = (EditPreference)paramAdapterView;
        paramView.showDialog();
        paramView.vch = new MMPreference.2.2(this, paramView, paramAdapterView);
      }
    } while (paramAdapterView.mKey == null);
    this.vdh.a(MMPreference.d(this.vdh), paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.2
 * JD-Core Version:    0.7.0.1
 */