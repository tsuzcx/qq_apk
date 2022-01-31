package com.tencent.mm.ui;

import android.database.DataSetObserver;
import android.view.View;
import com.tencent.mm.R.h;

final class ServiceNotifySettingsUI$3
  extends DataSetObserver
{
  ServiceNotifySettingsUI$3(ServiceNotifySettingsUI paramServiceNotifySettingsUI) {}
  
  public final void onChanged()
  {
    View localView = this.uQG.findViewById(R.h.listTitleTv);
    if (ServiceNotifySettingsUI.a(this.uQG).isEmpty()) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.3
 * JD-Core Version:    0.7.0.1
 */