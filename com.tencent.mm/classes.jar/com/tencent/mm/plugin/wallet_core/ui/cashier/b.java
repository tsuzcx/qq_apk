package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;

public final class b
  extends i
{
  private View iCk;
  TextView iJG;
  private ImageView uvJ;
  ViewGroup uvK;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(142569);
    this.iCk = View.inflate(getContext(), 2130971280, null);
    this.uvJ = ((ImageView)this.iCk.findViewById(2131829468));
    this.uvK = ((ViewGroup)this.iCk.findViewById(2131829470));
    this.iJG = ((TextView)this.iCk.findViewById(2131829469));
    paramContext = this.uvJ;
    int i = WcPayCashierDialog.uuP;
    int j = WcPayCashierDialog.uuP;
    bo.n(paramContext, i, i, j, j);
    this.uvJ.setOnClickListener(new b.1(this));
    setContentView(this.iCk);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(142569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b
 * JD-Core Version:    0.7.0.1
 */