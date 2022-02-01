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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/utils/BankCardAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(301404);
    AppMethodBeat.o(301404);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(301407);
    root(a.g.wallet_bankcard_manage_ui).view(a.f.wallet_entrance_add_bankcard).type(ViewType.Button).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.wallet_entrance_add_bankcard_tv);
    root(a.g.bank_remit_sort_view).disable(a.f.listview);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.bank_remit_sort_item);
    localConfigHelper.view(a.f.contentView).descFormat(a.i.wallet_text_accessibility).valueByView(a.f.brsb_item_title);
    localConfigHelper.disable(a.f.brsb_item_title);
    localConfigHelper.disable(a.f.brsb_item_icon);
    root(a.g.actionbar_custom_menu).view(a.f.menu_search).type(ViewType.Button).desc(a.i.wallet_bankcard_select_search_title_accessibility);
    AppMethodBeat.o(301407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a
 * JD-Core Version:    0.7.0.1
 */