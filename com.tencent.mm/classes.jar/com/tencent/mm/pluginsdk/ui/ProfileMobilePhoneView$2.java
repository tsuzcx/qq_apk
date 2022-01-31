package com.tencent.mm.pluginsdk.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.k;

final class ProfileMobilePhoneView$2
  implements AdapterView.OnItemClickListener
{
  ProfileMobilePhoneView$2(ProfileMobilePhoneView paramProfileMobilePhoneView, k paramk, String paramString) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(27533);
    if (this.vRF != null) {
      this.vRF.dismiss();
    }
    if (paramInt == 0) {
      if (bo.isNullOrNil(this.vRE.vRr))
      {
        paramView = h.qsU;
        paramAdapterView = new Object[1];
      }
    }
    label280:
    for (AdapterView<?> localAdapterView = paramAdapterView;; localAdapterView = paramAdapterView)
    {
      paramInt = 0;
      for (;;)
      {
        localAdapterView[0] = Integer.valueOf(paramInt);
        paramView.e(12043, paramAdapterView);
        paramAdapterView = new Intent("android.intent.action.DIAL");
        paramAdapterView.setFlags(268435456);
        paramAdapterView.setData(Uri.parse("tel:" + this.kyt));
        try
        {
          this.vRE.getContext().startActivity(paramAdapterView);
          AppMethodBeat.o(27533);
          return;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          ab.printErrStackTrace("MicroMsg.ProfileMobilePhoneView", paramAdapterView, "Activity not found!", new Object[0]);
          AppMethodBeat.o(27533);
          return;
        }
        paramView = h.qsU;
        paramAdapterView = new Object[1];
        if (!this.vRE.vRr.equals(this.kyt.trim())) {
          break label280;
        }
        paramInt = 1;
        localAdapterView = paramAdapterView;
      }
      if (1 == paramInt)
      {
        h.qsU.e(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("IPCallTalkUI_phoneNumber", this.kyt);
        d.b(ProfileMobilePhoneView.b(this.vRE), "ipcall", ".ui.IPCallDialUI", paramAdapterView);
      }
      AppMethodBeat.o(27533);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView.2
 * JD-Core Version:    0.7.0.1
 */