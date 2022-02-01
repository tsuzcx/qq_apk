package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.g;

public final class f
  extends i
  implements View.OnClickListener
{
  private View.OnClickListener Ism;
  private int mScene;
  protected View mrI;
  
  private f(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private f(Context paramContext, byte paramByte)
  {
    super(paramContext, a.j.mmpwddialog);
    AppMethodBeat.i(68111);
    this.mScene = 0;
    paramByte = a.g.remittance_fee_tip_dialog;
    if (paramByte > 0) {
      this.mrI = View.inflate(paramContext, paramByte, null);
    }
    setContentView(this.mrI);
    ((Button)this.mrI.findViewById(a.f.cancel_btn)).setOnClickListener(this);
    ((Button)this.mrI.findViewById(a.f.iknow)).setOnClickListener(this);
    AppMethodBeat.o(68111);
  }
  
  public static f a(Context paramContext, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, String paramString, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(68114);
    Log.i("RemittanceChargeDialog", "showCostDetail");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    if (paramDouble1 == 0.0D) {
      Log.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
    }
    ((TextView)localf.findViewById(a.f.remittance_used_fee)).setText(g.F(paramDouble1));
    ((TextView)localf.findViewById(a.f.excess)).setText(g.F(paramDouble2));
    if (paramDouble3 == 0.0D) {
      Log.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
    }
    ((TextView)localf.findViewById(a.f.transaction_costs)).setText(g.F(paramDouble3));
    localf.findViewById(a.f.remittance_cost_detail_view).setVisibility(0);
    if (!Util.isNullOrNil(paramString))
    {
      TextView localTextView = (TextView)localf.findViewById(a.f.remittance_explain);
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
    localf.findViewById(a.f.tip_pay_buttons).setVisibility(0);
    localf.Ism = paramOnClickListener;
    localf.findViewById(a.f.ok_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68110);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (f.a(f.this) != null)
        {
          f.a(f.this).onClick(paramAnonymousView);
          f.this.dismiss();
        }
        a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68110);
      }
    });
    localf.show();
    com.tencent.mm.ui.base.h.a(paramContext, localf);
    if (paramInt == 1) {
      com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
    }
    for (;;)
    {
      AppMethodBeat.o(68114);
      return localf;
      com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68112);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68112);
      return;
      label119:
      com.tencent.mm.plugin.report.service.h.IzE.a(12689, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.f
 * JD-Core Version:    0.7.0.1
 */