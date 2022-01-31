package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.widget.DatePicker;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;

final class EditHintView$7$1
  implements DatePickerDialog.OnDateSetListener
{
  EditHintView$7$1(EditHintView.7 param7) {}
  
  public final void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < EditHintView.i(this.wBZ.wBY)) && (paramInt2 < EditHintView.j(this.wBZ.wBY)))
    {
      h.b(this.wBZ.wBY.getContext(), this.wBZ.wBY.getContext().getString(a.i.wallet_err_expired_date), null, true);
      EditHintView.a(this.wBZ.wBY, this.wBZ.wBY.YL());
      if (EditHintView.d(this.wBZ.wBY) != null) {
        y.d("MicroMsg.EditHintView", "View:" + EditHintView.e(this.wBZ.wBY) + ", editType:" + EditHintView.f(this.wBZ.wBY) + " inputValid change to " + EditHintView.c(this.wBZ.wBY));
      }
      return;
    }
    paramDatePicker = new DecimalFormat("00");
    if (q.Gw()) {
      EditHintView.a(this.wBZ.wBY, paramDatePicker.format(paramInt2 + 1) + paramInt1);
    }
    for (;;)
    {
      EditHintView.k(this.wBZ.wBY).setText(paramDatePicker.format(paramInt2 + 1) + paramDatePicker.format(paramInt1).substring(2));
      break;
      EditHintView.a(this.wBZ.wBY, paramDatePicker.format(paramInt1).substring(2) + paramDatePicker.format(paramInt2 + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.7.1
 * JD-Core Version:    0.7.0.1
 */