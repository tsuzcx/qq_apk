package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMPreference$3
  implements AdapterView.OnItemLongClickListener
{
  MMPreference$3(MMPreference paramMMPreference) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107212);
    if (paramInt < MMPreference.access$400(this.zrE).getHeaderViewsCount())
    {
      AppMethodBeat.o(107212);
      return false;
    }
    paramInt -= MMPreference.access$400(this.zrE).getHeaderViewsCount();
    if (paramInt >= MMPreference.access$300(this.zrE).getCount())
    {
      ab.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(MMPreference.access$300(this.zrE).getCount()) });
      AppMethodBeat.o(107212);
      return false;
    }
    paramAdapterView = (Preference)MMPreference.access$300(this.zrE).getItem(paramInt);
    boolean bool = this.zrE.onPreferenceTreeLongClick(MMPreference.access$300(this.zrE), paramAdapterView, MMPreference.access$400(this.zrE));
    AppMethodBeat.o(107212);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreference.3
 * JD-Core Version:    0.7.0.1
 */