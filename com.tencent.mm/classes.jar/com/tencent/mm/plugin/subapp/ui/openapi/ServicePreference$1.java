package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ServicePreference$1
  implements AdapterView.OnItemClickListener
{
  ServicePreference$1(ServicePreference paramServicePreference) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25483);
    if (ServicePreference.a(this.sZi).xj(paramInt))
    {
      ServicePreference.a(this.sZi).mv(false);
      AppMethodBeat.o(25483);
      return;
    }
    if (ServicePreference.a(this.sZi).sYK)
    {
      if (ServicePreference.b(this.sZi) != null)
      {
        ServicePreference.b(this.sZi).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        AppMethodBeat.o(25483);
      }
    }
    else if (ServicePreference.c(this.sZi) != null) {
      ServicePreference.c(this.sZi).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(25483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference.1
 * JD-Core Version:    0.7.0.1
 */