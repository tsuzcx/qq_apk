package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class u$2
  implements View.OnClickListener
{
  u$2(u paramu) {}
  
  public final void onClick(View paramView)
  {
    switch (u.8.vkN[this.vkL.vkD.ordinal()])
    {
    }
    do
    {
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.f(11288, new Object[] { Integer.valueOf(6) });
      paramView = this.vkL;
      if (!aq.isConnected(paramView.mContext))
      {
        com.tencent.mm.ui.base.h.a(paramView.mContext, com.tencent.mm.cb.a.ac(paramView.mContext, R.l.chatfooter_mail_offline_tip), "", com.tencent.mm.cb.a.ac(paramView.mContext, R.l.chatfooter_mail_i_know), null);
        return;
      }
      if (!aq.isWifi(paramView.mContext))
      {
        com.tencent.mm.ui.base.h.a(paramView.mContext, R.l.chatfooter_mail_install_mobile_tip, 0, R.l.chatfooter_mail_download, R.l.chatfooter_mail_cancel, new u.3(paramView), null);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramView.mContext, R.l.chatfooter_mail_install_tip, 0, R.l.chatfooter_mail_download, R.l.chatfooter_mail_cancel, new u.4(paramView), null);
      return;
      paramView = this.vkL;
      y.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
      d.aFP().dc(paramView.jyG);
      paramView.cCR();
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.f(11288, new Object[] { Integer.valueOf(7) });
      paramView = this.vkL;
      y.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
      bk.j(paramView.vkG, paramView.mContext);
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.f(11288, new Object[] { Integer.valueOf(5) });
      u localu = this.vkL;
      y.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
      y.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[] { localu.vkH });
      if (bk.bl(localu.vkH)) {
        paramView = localu.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
      }
      for (;;)
      {
        y.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[] { paramView });
        com.tencent.mm.cg.a.post(new u.5(localu, paramView));
        return;
        Intent localIntent = new Intent();
        localIntent.setData(Uri.parse(localu.vkH));
        localIntent.addFlags(268435456);
        if (Build.VERSION.SDK_INT >= 11) {
          localIntent.addFlags(32768);
        }
        paramView = localIntent;
        if (!bk.i(localu.mContext, localIntent)) {
          paramView = localu.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
        }
      }
    } while (!this.vkL.vkF);
    u.a(this.vkL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.2
 * JD-Core Version:    0.7.0.1
 */