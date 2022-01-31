package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreferenceFragment$2
  implements AdapterView.OnItemClickListener
{
  MMPreferenceFragment$2(MMPreferenceFragment paramMMPreferenceFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107240);
    if (paramInt < MMPreferenceFragment.e(this.zrW).getHeaderViewsCount())
    {
      AppMethodBeat.o(107240);
      return;
    }
    int i = MMPreferenceFragment.e(this.zrW).getHeaderViewsCount();
    paramAdapterView = (Preference)MMPreferenceFragment.d(this.zrW).getItem(paramInt - i);
    if ((paramAdapterView.isEnabled()) && (paramAdapterView.zsi))
    {
      if ((paramAdapterView instanceof CheckBoxPreference))
      {
        AppMethodBeat.o(107240);
        return;
      }
      if ((paramAdapterView instanceof DialogPreference))
      {
        paramView = (DialogPreference)paramAdapterView;
        paramView.showDialog();
        paramView.zqG = new MMPreferenceFragment.2.1(this, paramView, paramAdapterView);
      }
      if ((paramAdapterView instanceof EditPreference))
      {
        paramView = (EditPreference)paramAdapterView;
        paramView.showDialog();
        paramView.zqI = new MMPreferenceFragment.2.2(this, paramView, paramAdapterView);
      }
      if (paramAdapterView.mKey != null) {
        this.zrW.onPreferenceTreeClick(MMPreferenceFragment.d(this.zrW), paramAdapterView);
      }
    }
    AppMethodBeat.o(107240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreferenceFragment.2
 * JD-Core Version:    0.7.0.1
 */