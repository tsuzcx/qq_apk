package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import java.util.HashMap;

final class q$2
  implements View.OnClickListener
{
  q$2(PayInfo paramPayInfo, View.OnClickListener paramOnClickListener, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47588);
    q.cVZ().put(this.pmv.cnI, Boolean.TRUE);
    this.utq.onClick(paramView);
    if (this.utr.ute) {
      h.qsU.e(14530, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(47588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.2
 * JD-Core Version:    0.7.0.1
 */