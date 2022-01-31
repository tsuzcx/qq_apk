package com.tencent.weui.base.preference;

import android.preference.Preference;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WeUIPreference$2
  implements AdapterView.OnItemClickListener
{
  WeUIPreference$2(WeUIPreference paramWeUIPreference) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(113261);
    paramAdapterView = (Preference)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(113261);
      return;
    }
    if ((paramAdapterView.isEnabled()) && (paramAdapterView.isSelectable()))
    {
      if ((paramAdapterView instanceof CheckBoxPreference))
      {
        AppMethodBeat.o(113261);
        return;
      }
      if (paramAdapterView.getKey() != null) {
        WeUIPreference.d(this.BCz);
      }
    }
    AppMethodBeat.o(113261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.2
 * JD-Core Version:    0.7.0.1
 */