package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;

final class ServiceAppUI$2
  implements AdapterView.OnItemClickListener
{
  ServiceAppUI$2(ServiceAppUI paramServiceAppUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25472);
    if (ServiceAppUI.a(this.sZe) == null)
    {
      ab.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
      AppMethodBeat.o(25472);
      return;
    }
    paramAdapterView = ServiceAppUI.a(this.sZe).Gn(paramInt);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
      AppMethodBeat.o(25472);
      return;
    }
    ab.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAdapterView.dke), paramAdapterView.field_packageName, paramAdapterView.field_appId });
    ServiceAppUI.a(this.sZe, paramAdapterView);
    AppMethodBeat.o(25472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI.2
 * JD-Core Version:    0.7.0.1
 */