package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import kotlin.g.a.b;

public class BankRemitSelectArriveTimeUI$a
  extends MMBaseAccessibilityConfig
{
  public BankRemitSelectArriveTimeUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(288776);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.bank_remit_select_arrive_preference);
    localConfigHelper.view(a.f.content_layout).disableChildren().desc(new b() {});
    localConfigHelper.view(16908310).desc(new b() {});
    AppMethodBeat.o(288776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI.a
 * JD-Core Version:    0.7.0.1
 */