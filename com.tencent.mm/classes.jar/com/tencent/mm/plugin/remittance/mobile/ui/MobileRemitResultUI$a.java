package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import kotlin.g.a.b;

public class MobileRemitResultUI$a
  extends MMBaseAccessibilityConfig
{
  public MobileRemitResultUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(288880);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.f.mobile_remit_result_root_layout);
    localConfigHelper.disable(a.f.mobile_remit_result_root_layout);
    localConfigHelper.view(a.f.mobile_remit_result_desc_container).desc(new b() {});
    root(a.g.actionbar_title_center).disable(a.f.actionbar_up_indicator);
    AppMethodBeat.o(288880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI.a
 * JD-Core Version:    0.7.0.1
 */