package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import kotlin.g.a.b;

public class WalletDigitalCertUI$a
  extends MMBaseAccessibilityConfig
{
  public WalletDigitalCertUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(315643);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.wallet_digital_certui);
    localConfigHelper.disable(a.f.scroll_content);
    localConfigHelper.disable(a.f.cert_top_rl);
    localConfigHelper.disable(a.f.cert_tips_first);
    localConfigHelper.disable(a.f.cert_tips_first_dot);
    localConfigHelper.disable(a.f.cert_tips_second);
    localConfigHelper.disable(a.f.cert_tips_second_dot);
    localConfigHelper.disable(a.f.installed_list);
    localConfigHelper = root(a.g.wallet_cert_adapter_item);
    localConfigHelper.disable(a.f.wallet_cert_adapter_item_root);
    localConfigHelper.disable(a.f.cert_title);
    localConfigHelper.disable(a.f.cert_summary);
    localConfigHelper.disable(a.f.bottom_line);
    localConfigHelper.view(a.f.cert_top_ll).type(ViewType.TextView).desc(new b() {});
    localConfigHelper.view(a.f.del_item).type(ViewType.Button);
    AppMethodBeat.o(315643);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(315646);
    super.onResume();
    AppMethodBeat.o(315646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.a
 * JD-Core Version:    0.7.0.1
 */