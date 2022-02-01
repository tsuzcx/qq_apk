package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.model.q;
import com.tencent.mm.protocal.protobuf.fuo;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsDelAuthUI$SettingsUserAuthListItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;)V", "mAuthList", "", "Lcom/tencent/mm/protocal/protobuf/UserAuthItem;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setDataList", "authItems", "", "updateAuthItem", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsDelAuthUI$SettingsUserAuthListItemAdapter$UserAuthItemVieHolder;", "authItem", "UserAuthItemVieHolder", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
final class SettingsDelAuthUI$b
  extends RecyclerView.a<RecyclerView.v>
{
  final List<fuo> Psm;
  private final Context context;
  final RecyclerView mkw;
  
  public SettingsDelAuthUI$b(Context paramContext, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(298940);
    this.context = paramContext;
    this.mkw = paramRecyclerView;
    this.Psm = ((List)new ArrayList());
    AppMethodBeat.o(298940);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(298946);
    s.u(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(this.context).inflate(b.g.layout_settings_auth_scope_item, paramViewGroup, false);
    s.s(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
    AppMethodBeat.o(298946);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(298952);
    s.u(paramv, "holder");
    if ((paramv instanceof a))
    {
      Object localObject = (a)paramv;
      paramv = (fuo)p.ae(this.Psm, paramInt);
      if (paramv != null)
      {
        ((a)localObject).PsX.setText((CharSequence)paramv.Poo);
        localObject = ((a)localObject).PsY;
        paramv = paramv.scope;
        s.s(paramv, "authItem.scope");
        ((WeImageView)localObject).setImageResource(q.aVC(paramv));
      }
    }
    AppMethodBeat.o(298952);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(298960);
    int i = this.Psm.size();
    AppMethodBeat.o(298960);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsDelAuthUI$SettingsUserAuthListItemAdapter$UserAuthItemVieHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "scopeDesc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getScopeDesc", "()Landroid/widget/TextView;", "scopeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getScopeIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends RecyclerView.v
  {
    final TextView PsX;
    final WeImageView PsY;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(298782);
      this.PsX = ((TextView)paramView.findViewById(b.f.settings_auth_item_scope_desc));
      this.PsY = ((WeImageView)paramView.findViewById(b.f.settings_auth_item_scope_icon));
      AppMethodBeat.o(298782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsDelAuthUI.b
 * JD-Core Version:    0.7.0.1
 */