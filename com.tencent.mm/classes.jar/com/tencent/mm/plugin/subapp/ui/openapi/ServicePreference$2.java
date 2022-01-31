package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ServicePreference$2
  implements AdapterView.OnItemLongClickListener
{
  ServicePreference$2(ServicePreference paramServicePreference) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25484);
    paramAdapterView = this.sZi;
    if (paramAdapterView.sZh != null)
    {
      paramView = paramAdapterView.sZh;
      if (paramAdapterView.sZh.sYK) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      paramView.mv(bool);
      AppMethodBeat.o(25484);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference.2
 * JD-Core Version:    0.7.0.1
 */