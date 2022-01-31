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

final class BizBindWxaInfoUI$2
  implements AdapterView.OnItemClickListener
{
  BizBindWxaInfoUI$2(BizBindWxaInfoUI paramBizBindWxaInfoUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(134413);
    paramAdapterView = (WxaAttributes.WxaEntryInfo)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(134413);
      return;
    }
    paramView = new AppBrandStatObject();
    paramView.scene = 1020;
    paramView.cmF = BizBindWxaInfoUI.a(this.pxY);
    ((j)g.E(j.class)).a(this.pxY, paramAdapterView.username, null, 0, 0, null, paramView, BizBindWxaInfoUI.b(this.pxY));
    AppMethodBeat.o(134413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI.2
 * JD-Core Version:    0.7.0.1
 */