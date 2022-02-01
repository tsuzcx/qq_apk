package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends com.tencent.mm.ui.widget.a.i
  implements View.OnClickListener
{
  private View.OnClickListener OpU;
  private int mScene;
  protected View plc;
  
  private g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    super(paramContext, a.j.mmpwddialog);
    AppMethodBeat.i(68111);
    this.mScene = 0;
    paramByte = a.g.remittance_fee_tip_dialog;
    if (paramByte > 0) {
      this.plc = View.inflate(paramContext, paramByte, null);
    }
    setContentView(this.plc);
    ((Button)this.plc.findViewById(a.f.cancel_btn)).setOnClickListener(this);
    ((Button)this.plc.findViewById(a.f.iknow)).setOnClickListener(this);
    AppMethodBeat.o(68111);
  }
  
  public static g a(Context paramContext, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, String paramString, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(68114);
    Log.i("RemittanceChargeDialog", "showCostDetail");
    g localg = new g(paramContext);
    localg.mScene = paramInt;
    if (paramDouble1 == 0.0D) {
      Log.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
    }
    ((TextView)localg.findViewById(a.f.remittance_used_fee)).setText(com.tencent.mm.wallet_core.ui.i.X(paramDouble1));
    ((TextView)localg.findViewById(a.f.excess)).setText(com.tencent.mm.wallet_core.ui.i.X(paramDouble2));
    if (paramDouble3 == 0.0D) {
      Log.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
    }
    ((TextView)localg.findViewById(a.f.transaction_costs)).setText(com.tencent.mm.wallet_core.ui.i.X(paramDouble3));
    localg.findViewById(a.f.remittance_cost_detail_view).setVisibility(0);
    if (!Util.isNullOrNil(paramString))
    {
      TextView localTextView = (TextView)localg.findViewById(a.f.remittance_explain);
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
    localg.findViewById(a.f.tip_pay_buttons).setVisibility(0);
    localg.OpU = paramOnClickListener;
    localg.findViewById(a.f.ok_btn).setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(289011);
        if (g.a(g.this) != null)
        {
          g.a(g.this).onClick(paramAnonymousView);
          g.this.dismiss();
        }
        AppMethodBeat.o(289011);
      }
    });
    localg.show();
    com.tencent.mm.ui.base.k.a(paramContext, localg);
    if (paramInt == 1) {
      h.OAn.b(12689, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
    }
    for (;;)
    {
      AppMethodBeat.o(68114);
      return localg;
      h.OAn.b(12689, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68112);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() != a.f.ok_btn)
    {
      Log.i("RemittanceChargeDialog", "click cancel");
      dismiss();
    }
    if (paramView.getId() == a.f.cancel_btn)
    {
      if (this.mScene != 1) {
        break label119;
      }
      h.OAn.b(12689, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68112);
      return;
      label119:
      h.OAn.b(12689, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.g
 * JD-Core Version:    0.7.0.1
 */