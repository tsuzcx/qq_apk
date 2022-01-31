package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreference$2
  implements AdapterView.OnItemClickListener
{
  MMPreference$2(MMPreference paramMMPreference) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107211);
    paramAdapterView = (Preference)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(107211);
      return;
    }
    if ((paramAdapterView.isEnabled()) && (paramAdapterView.zsi))
    {
      if ((paramAdapterView instanceof CheckBoxPreference))
      {
        AppMethodBeat.o(107211);
        return;
      }
      if ((paramAdapterView instanceof DialogPreference))
      {
        paramView = (DialogPreference)paramAdapterView;
        paramView.showDialog();
        paramView.zqG = new MMPreference.2.1(this, paramView, paramAdapterView);
      }
      if ((paramAdapterView instanceof EditPreference))
      {
        paramView = (EditPreference)paramAdapterView;
        paramView.showDialog();
        paramView.zqI = new MMPreference.2.2(this, paramView, paramAdapterView);
      }
      if (paramAdapterView.mKey != null) {
        this.zrE.onPreferenceTreeClick(MMPreference.access$300(this.zrE), paramAdapterView);
      }
    }
    AppMethodBeat.o(107211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.2
 * JD-Core Version:    0.7.0.1
 */