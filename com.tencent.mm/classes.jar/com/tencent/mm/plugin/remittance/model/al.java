package com.tencent.mm.plugin.remittance.model;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/remittance/model/RemittanceAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends MMBaseAccessibilityConfig
{
  public static final al.a OkU;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(288791);
    OkU = new al.a((byte)0);
    TAG = "Remittance.AccessiBility";
    AppMethodBeat.o(288791);
  }
  
  public al(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(288787);
    AppMethodBeat.o(288787);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(288798);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.remittance_new_ui_mainland);
    localConfigHelper.disable(a.f.root_view);
    localConfigHelper.disable(a.f.bottom_ll);
    localConfigHelper.disable(a.f.remittance_receiver_avatar);
    localConfigHelper.disable(a.f.remittance_desc_container);
    localConfigHelper = root(a.g.wallet_remittance_form_money);
    localConfigHelper.view(a.f.wallet_content).type(ViewType.TextView).descFormat(a.i.wallet_tripple_text_accessibility).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content).valueByString(a.i.remittance_edit_text_accessibility);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper = root(a.g.wc_pay_keyboard);
    localConfigHelper.view(a.f.keyboard_action).type(ViewType.Button);
    localConfigHelper.view(a.f.keyboard_animation_action).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByKey("keyboard_title_key");
    localConfigHelper = root(a.g.remittance_remark_input_half_page);
    localConfigHelper.view(a.f.remittance_remark_limit_tv).descFormat(a.i.remittance_desc_half_page_tips_accessibility).valueByKey("desc_length_key").valueByKey("desc_max_length_key");
    localConfigHelper.view(a.f.remittance_remark_limit_tv).talkOn((b)al.b.OkV);
    localConfigHelper.view(a.f.remittance_remark_address_icon).type(ViewType.Button).desc(a.i.remittance_desc_half_page_address_tips_accessibility);
    localConfigHelper = root(a.g.remittance_new_ui_half_dialog_title_view);
    localConfigHelper.view(a.f.half_dialog_close_iv).type(ViewType.Button).desc(a.i.close_btn);
    localConfigHelper.focusFirst(a.f.half_dialog_title);
    localConfigHelper = root(a.g.remittance_detail_ui);
    localConfigHelper.view(a.f.remittance_top_ll).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.remittance_detail_result_desc).valueByView(a.f.remittance_detail_fee);
    localConfigHelper.view(a.f.next_btn).descFormat(a.i.wallet_tripple_text_accessibility).valueByView(a.f.remittance_operation_name_tv).valueByView(a.f.remittance_operation_wording_tv).valueByView(a.f.next_btn);
    localConfigHelper.disable(a.f.root_view);
    localConfigHelper.disable(a.f.remittance_detail_result_desc);
    localConfigHelper.disable(a.f.remittance_detail_fee);
    localConfigHelper.disable(a.f.remittance_operation_name_tv);
    localConfigHelper.disable(a.f.remittance_operation_wording_tv);
    localConfigHelper.focusFirst(a.f.remittance_top_ll);
    localConfigHelper = root(a.g.remittance_detail_desc_item);
    localConfigHelper.view(a.f.remittance_detail_desc_content).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.remittance_detail_desc_title).valueByView(a.f.remittance_detail_desc_content);
    localConfigHelper.disable(a.f.remittance_detail_desc_title);
    localConfigHelper = root(a.g.remittance_busi_ui);
    localConfigHelper.disable(a.f.remittance_busi_logo);
    localConfigHelper.disable(a.f.remittance_busi_warning_layout);
    localConfigHelper.disable(a.f.remittance_warning_left_logo);
    localConfigHelper.disable(a.f.remittance_warning_right_logo);
    localConfigHelper.disable(a.f.remittance_warning_tips);
    localConfigHelper.disable(a.f.root_view);
    localConfigHelper.disable(a.f.remittance_busi_root_view_top);
    localConfigHelper.disable(a.f.remittance_busi_root_view_ll);
    localConfigHelper.disable(a.f.remittance_busi_fixed_currency);
    localConfigHelper.focusFirst(a.f.wallet_content);
    localConfigHelper.view(a.f.remittance_warning_click_ll).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.remittance_warning_tips);
    localConfigHelper.view(a.f.remittance_busi_fixed_money).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.remittance_busi_fixed_currency).valueByView(a.f.remittance_busi_fixed_money);
    localConfigHelper.view(a.f.final_remittance_layout).descFormat(a.i.wallet_double_text_accessibility).valueByView(a.f.final_remittance_busi_fixed_currency).valueByView(a.f.final_remittance_busi_fixed_money);
    AppMethodBeat.o(288798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.al
 * JD-Core Version:    0.7.0.1
 */