package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.i;

public final class b
  extends i
{
  private ImageView BKY;
  ViewGroup BKZ;
  private View ijA;
  TextView lfN;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71417);
    this.ijA = View.inflate(getContext(), 2131496057, null);
    this.BKY = ((ImageView)this.ijA.findViewById(2131307046));
    this.BKZ = ((ViewGroup)this.ijA.findViewById(2131307047));
    this.lfN = ((TextView)this.ijA.findViewById(2131306875));
    paramContext = this.BKY;
    int i = WcPayCashierDialog.BKd;
    int j = WcPayCashierDialog.BKd;
    bs.n(paramContext, i, i, j, j);
    this.BKY.setOnClickListener(new b.1(this));
    setContentView(this.ijA);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(71417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b
 * JD-Core Version:    0.7.0.1
 */