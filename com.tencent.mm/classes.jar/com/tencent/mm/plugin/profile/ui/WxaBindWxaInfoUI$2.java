package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;

final class WxaBindWxaInfoUI$2
  implements AdapterView.OnItemClickListener
{
  WxaBindWxaInfoUI$2(WxaBindWxaInfoUI paramWxaBindWxaInfoUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143688);
    paramAdapterView = (WxaAttributes.WxaEntryInfo)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(143688);
      return;
    }
    paramView = (j)g.E(j.class);
    if (paramView != null)
    {
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1135;
      paramView.a(this.pCY.getContext(), paramAdapterView.username, null, 0, -1, null, localAppBrandStatObject);
    }
    AppMethodBeat.o(143688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI.2
 * JD-Core Version:    0.7.0.1
 */