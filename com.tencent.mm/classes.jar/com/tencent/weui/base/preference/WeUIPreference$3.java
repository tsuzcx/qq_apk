package com.tencent.weui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class WeUIPreference$3
  implements AdapterView.OnItemLongClickListener
{
  WeUIPreference$3(WeUIPreference paramWeUIPreference) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(113262);
    if (paramInt < WeUIPreference.e(this.BCz).getHeaderViewsCount())
    {
      AppMethodBeat.o(113262);
      return false;
    }
    paramInt -= WeUIPreference.e(this.BCz).getHeaderViewsCount();
    if (paramInt >= WeUIPreference.d(this.BCz).getCount())
    {
      ak.e("MicroMsg.mmui.WeUIPreference", "itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(WeUIPreference.d(this.BCz).getCount()) });
      AppMethodBeat.o(113262);
      return false;
    }
    WeUIPreference.d(this.BCz).getItem(paramInt);
    WeUIPreference.d(this.BCz);
    WeUIPreference.e(this.BCz);
    AppMethodBeat.o(113262);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.3
 * JD-Core Version:    0.7.0.1
 */