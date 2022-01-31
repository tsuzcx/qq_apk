package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;

final class p$3
  implements View.OnClickListener
{
  p$3(p paramp) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81202);
    if (this.qAf.qzg == null)
    {
      ab.e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
      AppMethodBeat.o(81202);
      return;
    }
    h.qsU.e(11264, new Object[] { Integer.valueOf(3) });
    c.gmO.bn(this.qAf.qzg.getContext());
    AppMethodBeat.o(81202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.3
 * JD-Core Version:    0.7.0.1
 */