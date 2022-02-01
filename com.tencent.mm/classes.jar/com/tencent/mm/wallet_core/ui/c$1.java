package com.tencent.mm.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.ui.base.v;

final class c$1
  extends k
{
  c$1(c paramc) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(242174);
    if (((paramView.getId() == a.f.popupwd_qrcode_iv) || (paramView.getId() == a.f.popupwd_barcode_iv)) && (this.agUO.qjH != null) && (this.agUO.qjH.isShowing())) {
      this.agUO.qjH.dismiss();
    }
    AppMethodBeat.o(242174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.1
 * JD-Core Version:    0.7.0.1
 */