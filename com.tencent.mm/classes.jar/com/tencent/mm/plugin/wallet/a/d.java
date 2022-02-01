package com.tencent.mm.plugin.wallet.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/accessibility/WalletBalancePrivacyUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MMBaseAccessibilityConfig
{
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(315539);
    AppMethodBeat.o(315539);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(315552);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.wallet_balance_privacy_ui_header);
    localConfigHelper.view(a.f.version_code_ll).disableChildren();
    localConfigHelper.focusFirst(a.f.version_code_ll);
    localConfigHelper = root(a.g.balance_privacy_switchbtn_layout);
    localConfigHelper.view(a.f.content).disable();
    localConfigHelper.view(a.f.second_content).disable();
    localConfigHelper.view(a.f.real_content).disable();
    localConfigHelper.view(a.f.title_ll).disable();
    localConfigHelper.view(a.f.multi_line_check_box).disableChildren().clickAs(a.f.checkbox).desc((b)a.UZb).checkOn((b)b.UZc);
    root(a.f.actionbar_center_layout).view(a.f.title_ll).disable();
    AppMethodBeat.o(315552);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a UZb;
    
    static
    {
      AppMethodBeat.i(315547);
      UZb = new a();
      AppMethodBeat.o(315547);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, Boolean>
  {
    public static final b UZc;
    
    static
    {
      AppMethodBeat.i(315546);
      UZc = new b();
      AppMethodBeat.o(315546);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.d
 * JD-Core Version:    0.7.0.1
 */