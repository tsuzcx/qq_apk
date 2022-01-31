package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class EditHintView$8
  implements View.OnClickListener
{
  EditHintView$8(EditHintView paramEditHintView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49185);
    if (EditHintView.l(this.AYr).getVisibility() == 0)
    {
      if ((this.AYr.gLP) && (!bo.isNullOrNil(this.AYr.getText())))
      {
        this.AYr.AYg.ClearInput();
        AppMethodBeat.o(49185);
        return;
      }
      if (EditHintView.f(this.AYr) == 1)
      {
        if ((EditHintView.m(this.AYr) != null) && (EditHintView.n(this.AYr)))
        {
          EditHintView.m(this.AYr);
          AppMethodBeat.o(49185);
        }
      }
      else {
        EditHintView.o(this.AYr);
      }
    }
    AppMethodBeat.o(49185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.8
 * JD-Core Version:    0.7.0.1
 */