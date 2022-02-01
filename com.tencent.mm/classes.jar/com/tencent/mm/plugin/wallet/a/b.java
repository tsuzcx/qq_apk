package com.tencent.mm.plugin.wallet.a;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/accessibility/LQTAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "lastText", "", "getLastText", "()Ljava/lang/String;", "setLastText", "(Ljava/lang/String;)V", "initConfig", "", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public static final b.a UYY;
  private String mph;
  
  static
  {
    AppMethodBeat.i(315541);
    UYY = new b.a((byte)0);
    AppMethodBeat.o(315541);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(315538);
    this.mph = "";
    AppMethodBeat.o(315538);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(315550);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper1 = root(a.g.wallet_lqt_detail_ui);
    localConfigHelper1.view(a.f.lqt_detail_title_ll).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.lqt_detail_title_tv);
    localConfigHelper1.disable(a.f.lqt_detail_title_tv);
    localConfigHelper1.view(a.f.lqt_detail_banner_ll).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.lqt_detail_banner_text);
    localConfigHelper1.view(a.f.lqt_detail_security_container).desc((kotlin.g.a.b)new b.b(this));
    localConfigHelper1.disable(a.f.lqt_detail_security_title_tv);
    localConfigHelper1.view(a.f.lqt_detail_middle_banner_ll).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.lqt_detail_middle_banner_title_tv);
    localConfigHelper1.disable(a.f.lqt_detail_middle_banner_title_tv);
    localConfigHelper1.disable(a.f.lqt_detail_middle_banner_arrow);
    localConfigHelper1.view(a.f.lqt_detail_top_biz_layout).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.lqt_detail_top_biz_tv);
    localConfigHelper1.disable(a.f.lqt_detail_top_biz_tv);
    localConfigHelper1.view(a.f.lqt_detail_balance_ll).type(ViewType.Button).descFormat(a.i.wallet_tripple_text_accessibility).valueByView(a.f.lqt_detail_balance_tv).valueByView(a.f.mlv_money_tv).valueByView(a.f.lqt_know_detail_textView);
    root(a.g.money_loading_view).disable(a.f.mlv_money_tv);
    localConfigHelper1.disable(a.f.lqt_detail_balance_tv);
    localConfigHelper1.disable(a.f.lqt_detail_balance_title_layout);
    localConfigHelper1.disable(a.f.lqt_detail_balance_view_ll);
    localConfigHelper1.disable(a.f.lqt_detail_balance_view);
    localConfigHelper1.disable(a.f.lqt_know_detail_view_ll);
    root(a.g.lqt_detail_bottom_info_layout).view(a.f.ldbi_content_layout).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.lqt_detail_bottom_info_title_tv).valueByView(a.f.lqt_detail_bottom_info_desc_tv);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper2 = root(a.g.lqt_lct_operation_layout3);
    localConfigHelper2.disable(a.f.lqt_lct_operation_container);
    localConfigHelper2.view(a.f.lqt_lct_operation_top_ll).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.lqt_lct_operation_title_tv);
    localConfigHelper2.view(a.f.lqt_lct_operation_product_layout).type(ViewType.Button).descFormat(a.i.wallet_quadra_text_accessibility).valueByView(a.f.lqt_lct_operation_product_name_tv).valueByView(a.f.lqt_lct_operation_product_profit_tv).valueByView(a.f.lqt_lct_operation_product_desc_tv).valueByView(a.f.lqt_lct_operation_product_profit_desc_tv);
    localConfigHelper1.view(a.f.lqt_detail_financial_info_ll).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.lqt_detail_financial_info_tv);
    localConfigHelper1.view(a.f.lqt_detail_faq_link_ll).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.lqt_detail_faq_link_tv);
    localConfigHelper1.view(a.f.lqt_detail_fof_link_ll).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.lqt_detail_fof_link_tv);
    root(a.g.action_option_view).view(a.f.action_option_icon).desc(a.i.wallet_menu_more);
    localConfigHelper1 = root(a.g.wallet_lqt_save_ui);
    localConfigHelper1.view(a.f.lqt_balance_bankcard_click_layout).type(ViewType.Button).descFormat(a.i.wallet_tripple_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.lqt_balance_bankcard).valueByView(a.f.hint_1);
    localConfigHelper1.disable(a.f.lqt_balance_bankcard);
    localConfigHelper1.disable(a.f.hint_1);
    localConfigHelper1.disable(a.f.lqt_root_view_container);
    localConfigHelper1.disable(a.f.lqt_root_view);
    localConfigHelper1.disable(a.f.main_content);
    localConfigHelper1.disable(a.f.lqt_save_form);
    localConfigHelper1.disable(a.f.lqt_balance_bankcard_click_layout_container);
    localConfigHelper2 = root(a.g.wc_pay_keyboard);
    localConfigHelper2.disable(a.f.keyboard_base);
    localConfigHelper2.view(a.f.keyboard_action).type(ViewType.Button);
    localConfigHelper2.view(a.f.keyboard_animation_action).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByKey("keyboard_title_key");
    root(a.g.wallet_lqt_save_form_layout).disable(a.f.wallet_title);
    localConfigHelper1.view(a.f.lqt_save_protocol_link_tv).type(ViewType.Button);
    localConfigHelper2 = root(a.g.lqt_select_bankcard_header);
    localConfigHelper2.view(a.f.lqt_header_close_icon_iv).type(ViewType.Button);
    localConfigHelper2.focusFirst(a.f.lqt_select_bankcard_title);
    localConfigHelper1.view(a.f.lqt_fetch_strongly_remind_layout).type(ViewType.TextView).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.lqt_fetch_strongly_tip2).valueByView(a.f.lqt_fetch_strongly_tip);
    localConfigHelper1.disable(a.f.lqt_fetch_strongly_tip2);
    localConfigHelper1 = root(a.g.wallet_lqt_save_fetch_finish_ui);
    localConfigHelper1.view(a.f.amount_layout).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.amount_unit_tv).valueByView(a.f.amount_tv);
    localConfigHelper1.focusFirst(a.f.succ_wording_tv);
    AppMethodBeat.o(315550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.b
 * JD-Core Version:    0.7.0.1
 */