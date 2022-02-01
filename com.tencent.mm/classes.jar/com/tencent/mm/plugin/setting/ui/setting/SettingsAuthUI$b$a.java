package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter$AuthItemVieHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "authName", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "getAuthName", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "authType", "Landroid/widget/TextView;", "getAuthType", "()Landroid/widget/TextView;", "container", "Landroid/widget/RelativeLayout;", "getContainer", "()Landroid/widget/RelativeLayout;", "scopeDesc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getScopeDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
final class SettingsAuthUI$b$a
  extends RecyclerView.v
{
  final RelativeLayout LwF;
  final MMNeat7extView Psr;
  final TextView Pss;
  final NeatTextView Pst;
  
  public SettingsAuthUI$b$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(299344);
    this.LwF = ((RelativeLayout)paramView.findViewById(b.f.settings_auth_item_container));
    this.Psr = ((MMNeat7extView)paramView.findViewById(b.f.settings_auth_item_name));
    this.Pss = ((TextView)paramView.findViewById(b.f.settings_auth_item_type));
    this.Pst = ((NeatTextView)paramView.findViewById(b.f.settings_auth_item_scope_desc));
    AppMethodBeat.o(299344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAuthUI.b.a
 * JD-Core Version:    0.7.0.1
 */