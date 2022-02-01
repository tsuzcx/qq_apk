package com.tencent.mm.plugin.wallet.a;

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
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/accessibility/BalanceAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(315536);
    AppMethodBeat.o(315536);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(315545);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.wallet_balance_manager_ui);
    localConfigHelper.view(a.f.tips).disable();
    localConfigHelper.view(a.f.wallet_balance_maincontent_layout).disable();
    localConfigHelper.view(a.f.wallet_balance_view).descFormat(a.i.wallet_balance_manager_double_wording_format).valueByString(a.i.wallet_balance_manager_tips).valueByView(a.f.mlv_money_tv);
    localConfigHelper.view(a.f.balance_action_layout).expand(12, 12, 12, 12).type(ViewType.Button).desc(a.f.balance_action_tv);
    localConfigHelper.view(a.f.wallet_balance_manager_qanda).expand(12, 12, 12, 12).type(ViewType.Button);
    localConfigHelper.focusFirst(a.f.wallet_balance_view);
    localConfigHelper = root(a.g.wallet_balance_save_ui);
    localConfigHelper.view(a.f.balance_bankcard_layout).type(ViewType.Button);
    localConfigHelper.view(a.f.lqt_save_hint).disable();
    view(a.f.money_ev, a.f.wallet_title).disable();
    view(a.f.money_ev, a.f.wallet_content).desc((b)new a(this)).type(ViewType.TextView);
    localConfigHelper.view(a.f.lqt_entrance_layout).type(ViewType.Button);
    localConfigHelper = root(a.g.wallet_balance_fetch_ui);
    localConfigHelper.view(a.f.balance_bankcard_layout).type(ViewType.Button);
    localConfigHelper.view(a.f.lq_fetch_hint).disable();
    view(a.f.balance_fee, a.f.wallet_title).disable();
    view(a.f.balance_fee, a.f.wallet_content).desc((b)new b(this)).type(ViewType.TextView);
    localConfigHelper.view(a.f.fetch_desc_tips_tv).expand(12, 12, 12, 12).type(ViewType.Button);
    localConfigHelper.view(a.f.fetch_all_tv).expand(12, 12, 12, 12).type(ViewType.Button);
    localConfigHelper.view(a.f.lq_fetch_limit_guild_action).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.lq_fetch_limit_guild_desc).valueByView(a.f.lq_fetch_limit_guild_action).expand(12, 12, 12, 12).type(ViewType.Button);
    root(a.g.lqt_select_bankcard_header).view(a.f.lqt_header_close_icon_iv).type(ViewType.Button).desc(a.i.talkback_close_normal);
    root(a.g.action_option_view).view(a.f.action_option_icon).desc(a.i.wallet_menu_more);
    AppMethodBeat.o(315545);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.a
 * JD-Core Version:    0.7.0.1
 */