package com.tencent.mm.plugin.remittance.ui;

import android.widget.TextView;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.h.a.ti.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceUI$4
  implements Runnable
{
  RemittanceUI$4(RemittanceUI paramRemittanceUI, ti paramti) {}
  
  public final void run()
  {
    if (!bk.bl(this.iLQ.ccV.ccW))
    {
      e.a((TextView)this.nEA.findViewById(a.f.banner_tips), this.iLQ.ccV.ccW, this.iLQ.ccV.content, this.iLQ.ccV.url);
      return;
    }
    y.i("MicroMsg.RemittanceUI", "no bulletin data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.4
 * JD-Core Version:    0.7.0.1
 */