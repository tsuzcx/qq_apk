package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

final class t$2
  implements View.OnClickListener
{
  t$2(t paramt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30736);
    switch (t.8.zAo[this.zAm.zAe.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30736);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11288, new Object[] { Integer.valueOf(6) });
      paramView = this.zAm;
      if (!at.isConnected(paramView.mContext))
      {
        com.tencent.mm.ui.base.h.a(paramView.mContext, com.tencent.mm.cb.a.aq(paramView.mContext, 2131298123), "", com.tencent.mm.cb.a.aq(paramView.mContext, 2131298118), null);
        AppMethodBeat.o(30736);
        return;
      }
      if (!at.isWifi(paramView.mContext))
      {
        com.tencent.mm.ui.base.h.a(paramView.mContext, 2131298120, 0, 2131298116, 2131298115, new t.3(paramView), null);
        AppMethodBeat.o(30736);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramView.mContext, 2131298121, 0, 2131298116, 2131298115, new t.4(paramView), null);
      AppMethodBeat.o(30736);
      return;
      paramView = this.zAm;
      ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
      f.bjl().iz(paramView.lIf);
      paramView.dGD();
      AppMethodBeat.o(30736);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11288, new Object[] { Integer.valueOf(7) });
      paramView = this.zAm;
      ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
      i.aC(paramView.mContext, paramView.zAh);
      AppMethodBeat.o(30736);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(11288, new Object[] { Integer.valueOf(5) });
      t localt = this.zAm;
      ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
      ab.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localt.zAi });
      if (bo.isNullOrNil(localt.zAi)) {
        paramView = localt.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
      }
      for (;;)
      {
        ab.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramView });
        com.tencent.mm.ch.a.post(new t.5(localt, paramView));
        AppMethodBeat.o(30736);
        return;
        Intent localIntent = new Intent();
        localIntent.setData(Uri.parse(localt.zAi));
        localIntent.addFlags(268435456);
        if (Build.VERSION.SDK_INT >= 11) {
          localIntent.addFlags(32768);
        }
        paramView = localIntent;
        if (!bo.k(localt.mContext, localIntent)) {
          paramView = localt.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
        }
      }
      if (this.zAm.zAg) {
        t.a(this.zAm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.2
 * JD-Core Version:    0.7.0.1
 */