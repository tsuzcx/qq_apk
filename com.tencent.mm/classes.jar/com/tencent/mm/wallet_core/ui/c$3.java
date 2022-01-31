package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.o;

final class c$3
  implements View.OnClickListener
{
  c$3(c paramc) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.OfflinePopupWindow", "root on click");
    if ((this.wCf.fvf != null) && (this.wCf.fvf.isShowing())) {
      this.wCf.fvf.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.3
 * JD-Core Version:    0.7.0.1
 */