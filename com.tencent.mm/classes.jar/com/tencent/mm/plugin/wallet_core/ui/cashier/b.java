package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.i;
import com.tencent.mm.wallet_core.ui.k;
import org.xwalk.core.Log;

public final class b
  extends i
{
  private ImageView VVg;
  ViewGroup VVh;
  private View plc;
  TextView sUt;
  
  public b(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(71417);
    this.plc = View.inflate(getContext(), a.g.wc_pay_cashier_fetch_favor_dialog, null);
    this.VVg = ((ImageView)this.plc.findViewById(a.f.wpcf_back_iv));
    this.VVh = ((ViewGroup)this.plc.findViewById(a.f.wpcf_favor_layout));
    this.sUt = ((TextView)this.plc.findViewById(a.f.wccf_title_tv));
    paramContext = this.VVg;
    int i = WcPayCashierDialog.VUk;
    int j = WcPayCashierDialog.VUk;
    Util.expandViewTouchArea(paramContext, i, i, j, j);
    this.VVg.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(301341);
        Log.i("MicroMsg.WcPayCashierFetchFavorDialog", "click back");
        b.this.cancel();
        AppMethodBeat.o(301341);
      }
    });
    setContentView(this.plc);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(71417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b
 * JD-Core Version:    0.7.0.1
 */