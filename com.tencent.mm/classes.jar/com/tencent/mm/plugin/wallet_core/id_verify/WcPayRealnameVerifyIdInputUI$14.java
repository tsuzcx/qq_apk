package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.picker.a;

final class WcPayRealnameVerifyIdInputUI$14
  implements View.OnClickListener
{
  WcPayRealnameVerifyIdInputUI$14(WcPayRealnameVerifyIdInputUI paramWcPayRealnameVerifyIdInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142432);
    paramView = new a(this.udw.getContext());
    paramView.AIQ = new WcPayRealnameVerifyIdInputUI.14.1(this, paramView);
    String str = (String)WcPayRealnameVerifyIdInputUI.b(this.udw).udO.getValue();
    if ((!bo.isNullOrNil(str)) && (str.length() >= 8))
    {
      int i = bo.getInt(str.substring(0, 4), 0);
      int j = bo.getInt(str.substring(4, 6), 0);
      int k = bo.getInt(str.substring(6, 8), 0);
      if ((i > 0) && (j > 0) && (k > 0)) {
        paramView.aA(i, j, k);
      }
    }
    paramView.show();
    AppMethodBeat.o(142432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.14
 * JD-Core Version:    0.7.0.1
 */