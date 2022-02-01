package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import org.xwalk.core.Log;

public final class b
  extends i
{
  private ImageView Pey;
  ViewGroup Pez;
  private View mrI;
  TextView pPT;
  
  public b(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(71417);
    this.mrI = View.inflate(getContext(), a.g.wc_pay_cashier_fetch_favor_dialog, null);
    this.Pey = ((ImageView)this.mrI.findViewById(a.f.wpcf_back_iv));
    this.Pez = ((ViewGroup)this.mrI.findViewById(a.f.wpcf_favor_layout));
    this.pPT = ((TextView)this.mrI.findViewById(a.f.wccf_title_tv));
    paramContext = this.Pey;
    int i = WcPayCashierDialog.PdD;
    int j = WcPayCashierDialog.PdD;
    Util.expandViewTouchArea(paramContext, i, i, j, j);
    this.Pey.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71416);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.WcPayCashierFetchFavorDialog", "click back");
        b.this.cancel();
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71416);
      }
    });
    setContentView(this.mrI);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(71417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b
 * JD-Core Version:    0.7.0.1
 */