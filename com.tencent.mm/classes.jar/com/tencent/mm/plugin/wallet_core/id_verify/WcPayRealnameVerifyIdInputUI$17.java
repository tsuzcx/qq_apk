package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WcPayRealnameVerifyIdInputUI$17
  implements View.OnClickListener
{
  WcPayRealnameVerifyIdInputUI$17(WcPayRealnameVerifyIdInputUI paramWcPayRealnameVerifyIdInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142437);
    paramView = new Intent();
    paramView.setClassName(this.udw.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
    if (WcPayRealnameVerifyIdInputUI.e(this.udw) != null) {
      paramView.putExtra("exclude_countries_iso", WcPayRealnameVerifyIdInputUI.e(this.udw));
    }
    paramView.putExtra("CountryCodeUI_isShowCountryCode", false);
    paramView.putExtra("ui_title", this.udw.getString(2131305640));
    this.udw.startActivityForResult(paramView, 3);
    AppMethodBeat.o(142437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.17
 * JD-Core Version:    0.7.0.1
 */