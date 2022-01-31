package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;

final class p$2
  implements View.OnClickListener
{
  p$2(p paramp) {}
  
  public final void onClick(View paramView)
  {
    if (this.nMw.nLB == null)
    {
      y.e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
      return;
    }
    h.nFQ.f(11264, new Object[] { Integer.valueOf(3) });
    b.eUR.aO(this.nMw.nLB.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.2
 * JD-Core Version:    0.7.0.1
 */