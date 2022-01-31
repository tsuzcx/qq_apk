package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;

public final class f
  extends i
  implements View.OnClickListener
{
  protected View iCk;
  private int mScene;
  private View.OnClickListener qoU;
  
  private f(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private f(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131493885);
    AppMethodBeat.i(44982);
    this.mScene = 0;
    this.iCk = View.inflate(paramContext, 2130970573, null);
    setContentView(this.iCk);
    ((Button)this.iCk.findViewById(2131822887)).setOnClickListener(this);
    ((Button)this.iCk.findViewById(2131827307)).setOnClickListener(this);
    AppMethodBeat.o(44982);
  }
  
  public static f a(Context paramContext, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, String paramString, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(44985);
    ab.i("RemittanceChargeDialog", "showCostDetail");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    if (paramDouble1 == 0.0D) {
      ab.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
    }
    ((TextView)localf.findViewById(2131827303)).setText(e.F(paramDouble1));
    ((TextView)localf.findViewById(2131827304)).setText(e.F(paramDouble2));
    if (paramDouble3 == 0.0D) {
      ab.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
    }
    ((TextView)localf.findViewById(2131827301)).setText(e.F(paramDouble3));
    localf.findViewById(2131827300).setVisibility(0);
    if (!bo.isNullOrNil(paramString))
    {
      TextView localTextView = (TextView)localf.findViewById(2131827297);
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
    localf.findViewById(2131827305).setVisibility(0);
    localf.qoU = paramOnClickListener;
    localf.findViewById(2131823301).setOnClickListener(new f.1(localf));
    localf.show();
    com.tencent.mm.ui.base.h.a(paramContext, localf);
    if (paramInt == 1) {
      com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
    }
    for (;;)
    {
      AppMethodBeat.o(44985);
      return localf;
      com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, double paramDouble)
  {
    AppMethodBeat.i(44984);
    ab.i("RemittanceChargeDialog", "showAlert");
    f localf = new f(paramContext);
    localf.mScene = paramInt;
    ab.i("RemittanceChargeDialog", "showTips");
    TextView localTextView = (TextView)localf.findViewById(2131827297);
    if (bo.isNullOrNil(paramString)) {
      ab.e("RemittanceChargeDialog", "desc is null");
    }
    for (;;)
    {
      ((TextView)localf.findViewById(2131827299)).setText(paramContext.getResources().getString(2131302587, new Object[] { e.F(paramDouble) }));
      localf.findViewById(2131827306).setVisibility(0);
      localf.findViewById(2131827298).setVisibility(0);
      localf.show();
      com.tencent.mm.ui.base.h.a(paramContext, localf);
      AppMethodBeat.o(44984);
      return;
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44983);
    if (paramView.getId() != 2131823301)
    {
      ab.i("RemittanceChargeDialog", "click cancel");
      dismiss();
    }
    if (paramView.getId() == 2131822887)
    {
      if (this.mScene == 1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
        AppMethodBeat.o(44983);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(12689, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    }
    AppMethodBeat.o(44983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.f
 * JD-Core Version:    0.7.0.1
 */