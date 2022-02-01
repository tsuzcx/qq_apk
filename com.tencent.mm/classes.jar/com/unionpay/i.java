package com.unionpay;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
  implements View.OnClickListener
{
  i(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207267);
    paramView = new AlertDialog.Builder(this.aisR);
    UPPayWapActivity.a(this.aisR, paramView.create());
    paramView.setMessage(com.unionpay.utils.k.kkC().a);
    paramView.setTitle(com.unionpay.utils.k.kkC().d);
    paramView.setPositiveButton(com.unionpay.utils.k.kkC().b, new j(this));
    paramView.setNegativeButton(com.unionpay.utils.k.kkC().c, new k(this));
    paramView.create().show();
    AppMethodBeat.o(207267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.i
 * JD-Core Version:    0.7.0.1
 */