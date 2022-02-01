package com.tencent.mm.plugin.remittance.mobile.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.plugin.wxpay.a.f;

public class MobileRemitWelcomeUI$a
  extends MMBaseAccessibilityConfig
{
  public MobileRemitWelcomeUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(288912);
    root(a.f.mobile_remit_welcome_root_layout).disable(a.f.mobile_remit_welcome_root_layout);
    focusFirst(a.f.mobile_remit_welcome_title_tv);
    AppMethodBeat.o(288912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitWelcomeUI.a
 * JD-Core Version:    0.7.0.1
 */