package com.tencent.mm.wallet_core.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpayreport.a.b;
import com.tencent.mm.plugin.wxpayreport.a.b.a;
import com.tencent.mm.plugin.wxpayreport.a.c.a;
import com.tencent.mm.plugin.wxpayreport.j;
import com.tencent.mm.plugin.wxpayreport.j.b;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wallet_core/ui/WalletBaseReportUIC;", "Lcom/tencent/mm/plugin/wxpayreport/WcPayReportUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onWcKeyboardHide", "", "hideType", "", "onWcKeyboardShow", "showType", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
  extends j
{
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(242189);
    b.a locala = new b.a();
    b localb = locala.a(a.f.keyboard_action, c.a.XJA.toString(), (MMFragmentActivity)paramAppCompatActivity);
    localb.hnM = 500L;
    s.s(localb, "options");
    addCustomReportEvent("keyboard_show_1", localb);
    paramAppCompatActivity = locala.a(a.f.keyboard_action, c.a.XJA.toString(), (MMFragmentActivity)paramAppCompatActivity);
    localb.hnM = 500L;
    s.s(paramAppCompatActivity, "options2");
    addCustomReportEvent("keyboard_show_2", paramAppCompatActivity);
    AppMethodBeat.o(242189);
  }
  
  public final void aGw(int paramInt)
  {
    AppMethodBeat.i(242192);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(242192);
      return;
      triggerReport(j.b.XJg, "keyboard_show_1");
      AppMethodBeat.o(242192);
      return;
      triggerReport(j.b.XJg, "keyboard_show_2");
    }
  }
  
  public final void aGx(int paramInt)
  {
    AppMethodBeat.i(242193);
    if (paramInt == 1)
    {
      Em(c.a.XJA.toString());
      AppMethodBeat.o(242193);
      return;
    }
    Em(c.a.XJA.toString());
    Em(c.a.XJB.toString());
    AppMethodBeat.o(242193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.h
 * JD-Core Version:    0.7.0.1
 */