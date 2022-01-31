package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.ui.base.o;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    if (((paramView.getId() == a.f.popupwd_qrcode_iv) || (paramView.getId() == a.f.popupwd_barcode_iv)) && (this.wCf.fvf != null) && (this.wCf.fvf.isShowing())) {
      this.wCf.fvf.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.1
 * JD-Core Version:    0.7.0.1
 */