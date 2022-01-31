package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;

final class WxaBindBizInfoUI$2
  implements AdapterView.OnItemClickListener
{
  WxaBindBizInfoUI$2(WxaBindBizInfoUI paramWxaBindBizInfoUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143680);
    paramAdapterView = (WxaAttributes.WxaEntryInfo)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(143680);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramAdapterView.username);
    paramView.putExtra("key_start_biz_profile_from_app_brand_profile", true);
    paramView.putExtra("key_use_new_contact_profile", true);
    paramView.putExtra("force_get_contact", true);
    d.b(this.pCX, "profile", ".ui.ContactInfoUI", paramView);
    AppMethodBeat.o(143680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI.2
 * JD-Core Version:    0.7.0.1
 */