package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.r;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.y;

final class ServiceAppUI$2
  implements AdapterView.OnItemClickListener
{
  ServiceAppUI$2(ServiceAppUI paramServiceAppUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (ServiceAppUI.a(this.pxq) == null)
    {
      y.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
      return;
    }
    paramAdapterView = ServiceAppUI.a(this.pxq).zn(paramInt);
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
      return;
    }
    y.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAdapterView.cvT), paramAdapterView.field_packageName, paramAdapterView.field_appId });
    ServiceAppUI.a(this.pxq, paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI.2
 * JD-Core Version:    0.7.0.1
 */