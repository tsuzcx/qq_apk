package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.c.ad;

final class q$6
  implements View.OnClickListener
{
  q$6(q paramq) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(47592);
    if (this.utp.usW == 0) {
      if (this.utp.utm == 0) {
        q.b(this.utp);
      }
    }
    for (;;)
    {
      if (this.utp.usW == 1)
      {
        q.cVY();
        if (q.e(this.utp)) {
          q.f(this.utp);
        }
      }
      AppMethodBeat.o(47592);
      return;
      q.c(this.utp);
      continue;
      if (this.utp.usW == 1)
      {
        if (this.utp.pVo == null) {
          label102:
          if (this.utp.pVo != null) {
            break label148;
          }
        }
        label148:
        for (paramView = "";; paramView = this.utp.pVo.cnI)
        {
          ad.e(i, paramView, 19, "");
          q.d(this.utp);
          break;
          i = this.utp.pVo.cCD;
          break label102;
        }
      }
      if (this.utp.usW == 2)
      {
        q.d(this.utp);
        h.qsU.e(15817, new Object[] { Integer.valueOf(4) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.6
 * JD-Core Version:    0.7.0.1
 */