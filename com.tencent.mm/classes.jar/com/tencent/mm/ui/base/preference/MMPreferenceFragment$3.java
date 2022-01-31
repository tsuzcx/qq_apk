package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPreferenceFragment$3
  implements AdapterView.OnItemLongClickListener
{
  MMPreferenceFragment$3(MMPreferenceFragment paramMMPreferenceFragment) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107241);
    if (paramInt < MMPreferenceFragment.e(this.zrW).getHeaderViewsCount())
    {
      AppMethodBeat.o(107241);
      return false;
    }
    int i = MMPreferenceFragment.e(this.zrW).getHeaderViewsCount();
    paramAdapterView = (Preference)MMPreferenceFragment.d(this.zrW).getItem(paramInt - i);
    boolean bool = this.zrW.onPreferenceTreeLongClick(MMPreferenceFragment.d(this.zrW), paramAdapterView, MMPreferenceFragment.e(this.zrW));
    AppMethodBeat.o(107241);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreferenceFragment.3
 * JD-Core Version:    0.7.0.1
 */