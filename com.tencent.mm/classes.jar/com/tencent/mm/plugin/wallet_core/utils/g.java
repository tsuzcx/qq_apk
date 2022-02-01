package com.tencent.mm.plugin.wallet_core.utils;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/utils/RealNameProcessAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends MMBaseAccessibilityConfig
{
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(301416);
    AppMethodBeat.o(301416);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(301432);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.wc_pay_realname_verify_main_ui);
    localConfigHelper.disable(a.f.wprv_security_tv);
    localConfigHelper.view(a.f.wprv_security_layout).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.wprv_security_tv);
    localConfigHelper.focusFirst(a.f.wprv_title_tv);
    localConfigHelper = root(a.g.wc_pay_realname_verify_id_input_ui);
    localConfigHelper.disable(a.f.wc_pay_realname_verify_id_root_view);
    localConfigHelper.disable(a.f.wc_pay_realname_verify_id_input_container);
    localConfigHelper.disable(a.f.wc_pay_realname_verify_id_input_top_ll);
    localConfigHelper.disable(a.f.wpri_name_et);
    localConfigHelper.disable(a.f.wpri_crenum_et);
    localConfigHelper.disable(a.f.wpri_mobile_et);
    localConfigHelper = root(a.f.wpri_sex_et);
    localConfigHelper.view(a.f.wpri_sex_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.f.wpri_nationality_et);
    localConfigHelper.view(a.f.wpri_nationality_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.f.wpri_cretype_et);
    localConfigHelper.view(a.f.wpri_cretype_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.f.wpri_cre_valid_date_et);
    localConfigHelper.view(a.f.wpri_cre_valid_date_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.f.wpri_cre_invalid_date_et);
    localConfigHelper.view(a.f.wpri_cre_invalid_date_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.f.wpri_cre_change_times_et);
    localConfigHelper.view(a.f.wpri_cre_change_times_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.f.wpri_birthday_et);
    localConfigHelper.view(a.f.wpri_birthday_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.f.wpri_profession_et);
    localConfigHelper.view(a.f.wpri_profession_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.f.wpri_address_et);
    localConfigHelper.view(a.f.wpri_address_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.g.wc_pay_realname_input_address_ui);
    localConfigHelper.focusFirst(a.f.wpra_title_tv);
    localConfigHelper.disable(a.f.wpra_root_content_layout);
    localConfigHelper.disable(a.f.wpra_address_et);
    localConfigHelper = root(a.f.wpra_zone_et);
    localConfigHelper.view(a.f.wpra_zone_et).type(ViewType.Button).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    localConfigHelper = root(a.g.wc_pay_realname_verify_code_ui);
    localConfigHelper.focusFirst(a.f.wc_pay_realname_verify_title);
    localConfigHelper.disable(a.f.wc_pay_realname_verify_container);
    localConfigHelper.disable(a.f.wc_pay_realname_verify_top_ll);
    localConfigHelper.disable(a.f.wprc_verify_code_et);
    root(a.f.wprc_phone_et).disable(a.f.wallet_title);
    root(a.g.wallet_set_pwd).focusFirst(a.f.wallet_pwd_title);
    AppMethodBeat.o(301432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g
 * JD-Core Version:    0.7.0.1
 */