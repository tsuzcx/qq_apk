package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.i;
import org.xwalk.core.Log;

public final class b
  extends i
{
  private ImageView Dlq;
  ViewGroup Dlr;
  private View iCR;
  TextView lCL;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(71417);
    this.iCR = View.inflate(getContext(), 2131496057, null);
    this.Dlq = ((ImageView)this.iCR.findViewById(2131307046));
    this.Dlr = ((ViewGroup)this.iCR.findViewById(2131307047));
    this.lCL = ((TextView)this.iCR.findViewById(2131306875));
    paramContext = this.Dlq;
    int i = WcPayCashierDialog.Dkv;
    int j = WcPayCashierDialog.Dkv;
    bt.n(paramContext, i, i, j, j);
    this.Dlq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71416);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        Log.i("MicroMsg.WcPayCashierFetchFavorDialog", "click back");
        b.this.cancel();
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71416);
      }
    });
    setContentView(this.iCR);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(71417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b
 * JD-Core Version:    0.7.0.1
 */