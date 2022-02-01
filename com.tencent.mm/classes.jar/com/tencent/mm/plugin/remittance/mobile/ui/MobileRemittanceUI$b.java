package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import kotlin.g.a.b;

public class MobileRemittanceUI$b
  extends MMBaseAccessibilityConfig
{
  public MobileRemittanceUI$b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(288910);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.f.mobile_remit_root_layout);
    localConfigHelper.disable(a.f.mobile_remit_root_layout);
    localConfigHelper.disable(a.f.mobile_remit_logo);
    localConfigHelper.view(a.f.mobile_remit_name_desc_container).desc(new b() {});
    localConfigHelper.view(a.f.mobile_remit_verify_name).expand(12, 12, 12, 12).type(ViewType.Button);
    localConfigHelper.view(a.f.remittance_desc).type(ViewType.Button);
    localConfigHelper.view(a.f.add_remittance_desc).type(ViewType.Button);
    localConfigHelper = root(a.g.wallet_remittance_form_money);
    localConfigHelper.view(a.f.wallet_content).type(ViewType.TextView).descFormat(a.i.remittance_tripple_text).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content).valueByString(a.i.remittance_edit_text_accessibility);
    localConfigHelper.disable(a.f.wallet_title);
    AppMethodBeat.o(288910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.b
 * JD-Core Version:    0.7.0.1
 */