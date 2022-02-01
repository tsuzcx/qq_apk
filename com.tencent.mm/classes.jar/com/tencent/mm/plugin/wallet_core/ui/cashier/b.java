package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.i;
import org.xwalk.core.Log;

public final class b
  extends i
{
  private ImageView AsE;
  ViewGroup AsF;
  private View hIZ;
  TextView kEu;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71417);
    this.hIZ = View.inflate(getContext(), 2131496057, null);
    this.AsE = ((ImageView)this.hIZ.findViewById(2131307046));
    this.AsF = ((ViewGroup)this.hIZ.findViewById(2131307047));
    this.kEu = ((TextView)this.hIZ.findViewById(2131306875));
    paramContext = this.AsE;
    int i = WcPayCashierDialog.ArJ;
    int j = WcPayCashierDialog.ArJ;
    bt.n(paramContext, i, i, j, j);
    this.AsE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71416);
        Log.i("MicroMsg.WcPayCashierFetchFavorDialog", "click back");
        b.this.cancel();
        AppMethodBeat.o(71416);
      }
    });
    setContentView(this.hIZ);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(71417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b
 * JD-Core Version:    0.7.0.1
 */