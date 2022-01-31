package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;

public final class c
  extends i
  implements View.OnClickListener
{
  private int fzn = 0;
  protected View ipf;
  private View.OnClickListener nCP;
  
  private c(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private c(Context paramContext, byte paramByte)
  {
    super(paramContext, a.j.mmpwddialog);
    paramByte = a.g.remittance_fee_tip_dialog;
    if (paramByte > 0) {
      this.ipf = View.inflate(paramContext, paramByte, null);
    }
    setContentView(this.ipf);
    ((Button)this.ipf.findViewById(a.f.cancel_btn)).setOnClickListener(this);
    ((Button)this.ipf.findViewById(a.f.iknow)).setOnClickListener(this);
  }
  
  public static c a(Context paramContext, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, String paramString, View.OnClickListener paramOnClickListener)
  {
    y.i("RemittanceChargeDialog", "showCostDetail");
    c localc = new c(paramContext);
    localc.fzn = paramInt;
    if (paramDouble1 == 0.0D) {
      y.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
    }
    ((TextView)localc.findViewById(a.f.remittance_used_fee)).setText(e.B(paramDouble1));
    ((TextView)localc.findViewById(a.f.excess)).setText(e.B(paramDouble2));
    if (paramDouble3 == 0.0D) {
      y.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
    }
    ((TextView)localc.findViewById(a.f.transaction_costs)).setText(e.B(paramDouble3));
    localc.findViewById(a.f.remittance_cost_detail_view).setVisibility(0);
    if (!bk.bl(paramString))
    {
      TextView localTextView = (TextView)localc.findViewById(a.f.remittance_explain);
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
    localc.findViewById(a.f.tip_pay_buttons).setVisibility(0);
    localc.nCP = paramOnClickListener;
    localc.findViewById(a.f.ok_btn).setOnClickListener(new c.1(localc));
    localc.show();
    com.tencent.mm.ui.base.h.a(paramContext, localc);
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
      return localc;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    return localc;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, double paramDouble)
  {
    y.i("RemittanceChargeDialog", "showAlert");
    c localc = new c(paramContext);
    localc.fzn = paramInt;
    y.i("RemittanceChargeDialog", "showTips");
    TextView localTextView = (TextView)localc.findViewById(a.f.remittance_explain);
    if (bk.bl(paramString)) {
      y.e("RemittanceChargeDialog", "desc is null");
    }
    for (;;)
    {
      ((TextView)localc.findViewById(a.f.infomsg)).setText(paramContext.getResources().getString(a.i.remittance_free_limit, new Object[] { e.B(paramDouble) }));
      localc.findViewById(a.f.tip_button_know).setVisibility(0);
      localc.findViewById(a.f.infomsg_container).setVisibility(0);
      localc.show();
      com.tencent.mm.ui.base.h.a(paramContext, localc);
      return;
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() != a.f.ok_btn)
    {
      y.i("RemittanceChargeDialog", "click cancel");
      dismiss();
    }
    if (paramView.getId() == a.f.cancel_btn)
    {
      if (this.fzn == 1) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
      }
    }
    else {
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */