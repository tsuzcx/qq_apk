package com.tencent.mm.pluginsdk.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.k;

final class ProfileMobilePhoneView$2
  implements AdapterView.OnItemClickListener
{
  ProfileMobilePhoneView$2(ProfileMobilePhoneView paramProfileMobilePhoneView, k paramk, String paramString) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.saM != null) {
      this.saM.dismiss();
    }
    if (paramInt == 0) {
      if (bk.bl(this.saL.saA))
      {
        paramView = h.nFQ;
        paramAdapterView = new Object[1];
      }
    }
    label256:
    for (AdapterView<?> localAdapterView = paramAdapterView;; localAdapterView = paramAdapterView)
    {
      paramInt = 0;
      localAdapterView[0] = Integer.valueOf(paramInt);
      paramView.f(12043, paramAdapterView);
      paramAdapterView = new Intent("android.intent.action.DIAL");
      paramAdapterView.setFlags(268435456);
      paramAdapterView.setData(Uri.parse("tel:" + this.ixq));
      do
      {
        try
        {
          this.saL.getContext().startActivity(paramAdapterView);
          return;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          y.printErrStackTrace("MicroMsg.ProfileMobilePhoneView", paramAdapterView, "Activity not found!", new Object[0]);
          return;
        }
        paramView = h.nFQ;
        paramAdapterView = new Object[1];
        if (!this.saL.saA.equals(this.ixq.trim())) {
          break label256;
        }
        paramInt = 1;
        localAdapterView = paramAdapterView;
        break;
      } while (1 != paramInt);
      h.nFQ.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("IPCallTalkUI_phoneNumber", this.ixq);
      d.b(ProfileMobilePhoneView.a(this.saL), "ipcall", ".ui.IPCallDialUI", paramAdapterView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView.2
 * JD-Core Version:    0.7.0.1
 */