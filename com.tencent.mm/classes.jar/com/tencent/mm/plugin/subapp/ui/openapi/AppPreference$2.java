package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppPreference$2
  implements AdapterView.OnItemLongClickListener
{
  AppPreference$2(AppPreference paramAppPreference) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25442);
    paramAdapterView = this.sYT;
    if (paramAdapterView.sYN != null)
    {
      paramView = paramAdapterView.sYN;
      if (paramAdapterView.sYN.sYK) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      paramView.mv(bool);
      AppMethodBeat.o(25442);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference.2
 * JD-Core Version:    0.7.0.1
 */