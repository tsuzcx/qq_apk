package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.k;
import java.util.List;

final class l$7
  implements AdapterView.OnItemClickListener
{
  l$7(String paramString, List paramList, Context paramContext, k paramk, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt, Bundle paramBundle) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(28139);
    paramView = this.nWS.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
    paramAdapterView = (String)this.mwc.get(paramInt);
    ab.i("MicroMsg.MailPhoneMenuHelper", paramAdapterView);
    if (this.val$context.getString(2131298279).equals(paramAdapterView))
    {
      paramAdapterView = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramView))));
      paramAdapterView.addFlags(268435456);
      if (bo.k(this.val$context, paramAdapterView)) {
        this.val$context.startActivity(paramAdapterView);
      }
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10112, "1");
      this.wcv.dismiss();
      if (this.wcs != null) {
        this.wcs.onDismiss(null);
      }
      AppMethodBeat.o(28139);
      return;
    }
    if (this.val$context.getString(2131298280).equals(paramAdapterView))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("IPCallTalkUI_phoneNumber", paramView);
      d.b(this.val$context, "ipcall", ".ui.IPCallDialUI", paramAdapterView);
      this.wcv.dismiss();
      if (this.wcs != null) {
        this.wcs.onDismiss(null);
      }
      AppMethodBeat.o(28139);
      return;
    }
    if (this.val$context.getString(2131298271).equals(paramAdapterView))
    {
      if ((l.dpp()) && (l.dpq())) {
        paramAdapterView = this.val$context.getResources().getStringArray(2131755042);
      }
      for (;;)
      {
        this.val$context.getResources().getString(2131298277);
        com.tencent.mm.ui.base.h.a(this.val$context, this.nWS, paramAdapterView, "", new l.7.1(this, paramView), new l.7.2(this));
        this.wcv.dismiss();
        AppMethodBeat.o(28139);
        return;
        if (l.dpp())
        {
          paramAdapterView = new String[1];
          paramAdapterView[0] = this.val$context.getResources().getString(2131298270);
        }
        else
        {
          paramAdapterView = new String[1];
          paramAdapterView[0] = this.val$context.getResources().getString(2131298278);
        }
      }
    }
    if (this.val$context.getString(2131298273).equals(paramAdapterView))
    {
      a.b(paramView, paramView);
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10115, "1");
      if (this.wcs != null) {
        this.wcs.onDismiss(null);
      }
      this.wcv.dismiss();
      Toast.makeText(this.val$context, this.val$context.getString(2131296896), 1).show();
      AppMethodBeat.o(28139);
      return;
    }
    if (this.val$context.getString(2131298275).equals(paramAdapterView))
    {
      ab.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
      AppMethodBeat.o(28139);
      return;
    }
    if (l.wcr.equals(paramAdapterView))
    {
      l.a((Activity)this.val$context, this.nWS, this.wcw);
      this.wcv.dismiss();
      if (this.wcs != null)
      {
        this.wcs.onDismiss(null);
        AppMethodBeat.o(28139);
      }
    }
    else
    {
      ab.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
      this.wcv.dismiss();
      if (this.wcs != null) {
        this.wcs.onDismiss(null);
      }
    }
    AppMethodBeat.o(28139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.7
 * JD-Core Version:    0.7.0.1
 */