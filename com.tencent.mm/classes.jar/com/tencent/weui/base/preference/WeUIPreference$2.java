package com.tencent.weui.base.preference;

import android.preference.Preference;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class WeUIPreference$2
  implements AdapterView.OnItemClickListener
{
  WeUIPreference$2(WeUIPreference paramWeUIPreference) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Preference)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null) {}
    while ((!paramAdapterView.isEnabled()) || (!paramAdapterView.isSelectable()) || ((paramAdapterView instanceof CheckBoxPreference))) {
      return;
    }
    paramAdapterView.getKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.2
 * JD-Core Version:    0.7.0.1
 */