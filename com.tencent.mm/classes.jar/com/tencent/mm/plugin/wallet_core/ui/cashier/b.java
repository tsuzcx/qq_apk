package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.i;

public final class b
  extends i
{
  private ImageView DCU;
  ViewGroup DCV;
  private View iFK;
  TextView lHk;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71417);
    this.iFK = View.inflate(getContext(), 2131496057, null);
    this.DCU = ((ImageView)this.iFK.findViewById(2131307046));
    this.DCV = ((ViewGroup)this.iFK.findViewById(2131307047));
    this.lHk = ((TextView)this.iFK.findViewById(2131306875));
    paramContext = this.DCU;
    int i = WcPayCashierDialog.DBZ;
    int j = WcPayCashierDialog.DBZ;
    bu.n(paramContext, i, i, j, j);
    this.DCU.setOnClickListener(new b.1(this));
    setContentView(this.iFK);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(71417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b
 * JD-Core Version:    0.7.0.1
 */