package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.widget.DatePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;

final class EditHintView$7$1
  implements DatePickerDialog.OnDateSetListener
{
  EditHintView$7$1(EditHintView.7 param7) {}
  
  public final void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49183);
    if ((paramInt1 < EditHintView.i(this.AYs.AYr)) && (paramInt2 < EditHintView.j(this.AYs.AYr)))
    {
      h.b(this.AYs.AYr.getContext(), this.AYs.AYr.getContext().getString(2131305058), null, true);
      EditHintView.a(this.AYs.AYr, this.AYs.AYr.asv());
      if (EditHintView.d(this.AYs.AYr) != null)
      {
        ab.d("MicroMsg.EditHintView", "View:" + EditHintView.e(this.AYs.AYr) + ", editType:" + EditHintView.f(this.AYs.AYr) + " inputValid change to " + EditHintView.c(this.AYs.AYr));
        EditHintView.d(this.AYs.AYr);
        EditHintView.c(this.AYs.AYr);
      }
      AppMethodBeat.o(49183);
      return;
    }
    paramDatePicker = new DecimalFormat("00");
    if (r.ZB()) {
      EditHintView.a(this.AYs.AYr, paramDatePicker.format(paramInt2 + 1) + paramInt1);
    }
    for (;;)
    {
      EditHintView.k(this.AYs.AYr).setText(paramDatePicker.format(paramInt2 + 1) + paramDatePicker.format(paramInt1).substring(2));
      break;
      EditHintView.a(this.AYs.AYr, paramDatePicker.format(paramInt1).substring(2) + paramDatePicker.format(paramInt2 + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.7.1
 * JD-Core Version:    0.7.0.1
 */