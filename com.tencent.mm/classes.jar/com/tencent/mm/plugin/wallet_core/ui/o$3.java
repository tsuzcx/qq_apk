package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import java.util.HashMap;

final class o$3
  implements View.OnClickListener
{
  o$3(PayInfo paramPayInfo, View.OnClickListener paramOnClickListener, o paramo) {}
  
  public final void onClick(View paramView)
  {
    o.bWY().put(this.mMf.bMX, Boolean.valueOf(true));
    this.qGk.onClick(paramView);
    if (this.qGl.qFZ) {
      h.nFQ.f(14530, new Object[] { Integer.valueOf(2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o.3
 * JD-Core Version:    0.7.0.1
 */