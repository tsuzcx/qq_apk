package com.tencent.mm.ui;

import android.database.DataSetObserver;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ServiceNotifySettingsUI$3
  extends DataSetObserver
{
  ServiceNotifySettingsUI$3(ServiceNotifySettingsUI paramServiceNotifySettingsUI) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(29852);
    View localView = this.zeQ.findViewById(2131827579);
    if (ServiceNotifySettingsUI.a(this.zeQ).isEmpty()) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(29852);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.3
 * JD-Core Version:    0.7.0.1
 */