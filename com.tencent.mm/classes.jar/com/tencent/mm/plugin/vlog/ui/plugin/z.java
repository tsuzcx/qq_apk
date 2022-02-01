package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "templateAdapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter;", "templateList", "Landroidx/recyclerview/widget/RecyclerView;", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "currentSelectedTemplate", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "enable", "", "setVisibility", "", "visibility", "", "TemplateListAdapter", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  private final RecyclerView Ujq;
  public final a Ujr;
  private ViewGroup parent;
  private final View view;
  
  public z(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282431);
    this.parent = paramViewGroup;
    this.view = this.parent.findViewById(a.f.template_mode_container);
    paramViewGroup = this.parent.findViewById(a.f.template_list);
    s.s(paramViewGroup, "parent.findViewById(R.id.template_list)");
    this.Ujq = ((RecyclerView)paramViewGroup);
    this.Ujr = new a();
    this.parent.getContext();
    paramViewGroup = new LinearLayoutManager();
    paramViewGroup.setOrientation(0);
    paramViewGroup.setItemPrefetchEnabled(true);
    this.Ujq.setLayoutManager((RecyclerView.LayoutManager)paramViewGroup);
    this.Ujq.setItemAnimator((RecyclerView.f)new f());
    this.Ujq.setHasFixedSize(true);
    paramViewGroup = this.Ujr;
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    localObject = (List)com.tencent.mm.plugin.vlog.model.local.a.hRs();
    s.u(localObject, "list");
    paramViewGroup.Ujs.clear();
    paramViewGroup.Ujs.addAll((Collection)localObject);
    paramViewGroup.bZE.notifyChanged();
    this.Ujq.setAdapter((RecyclerView.a)this.Ujr);
    this.Ujr.Uju = ((kotlin.g.a.b)new u(parama) {});
    paramViewGroup = this.Ujr;
    paramViewGroup.Ujt = 0;
    paramViewGroup.bZE.notifyChanged();
    AppMethodBeat.o(282431);
  }
  
  public final a.c hTA()
  {
    AppMethodBeat.i(369779);
    a.c localc = this.Ujr.hTA();
    AppMethodBeat.o(369779);
    return localc;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282441);
    this.view.setVisibility(paramInt);
    AppMethodBeat.o(282441);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter$TemplateListViewHolder;", "Landroid/view/View$OnClickListener;", "()V", "currentSelectedPos", "", "onItemSelected", "Lkotlin/Function1;", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "templateList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "Lkotlin/collections/ArrayList;", "currentSelectedTemplate", "getItemCount", "onBindViewHolder", "holder", "index", "onClick", "v", "Landroid/view/View;", "onCreateViewHolder", "view", "Landroid/view/ViewGroup;", "setSelected", "setTemplates", "list", "", "TemplateListViewHolder", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.a<a>
    implements View.OnClickListener
  {
    final ArrayList<a.c> Ujs;
    int Ujt;
    kotlin.g.a.b<? super Integer, ah> Uju;
    
    public a()
    {
      AppMethodBeat.i(282663);
      this.Ujs = new ArrayList();
      AppMethodBeat.o(282663);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(282668);
      int i = this.Ujs.size();
      AppMethodBeat.o(282668);
      return i;
    }
    
    public final a.c hTA()
    {
      AppMethodBeat.i(282673);
      Object localObject = this.Ujs.get(this.Ujt);
      s.s(localObject, "templateList[currentSelectedPos]");
      localObject = (a.c)localObject;
      AppMethodBeat.o(282673);
      return localObject;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282680);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (paramView == null)
      {
        paramView = null;
        paramView = (Integer)paramView;
        if (paramView != null) {
          break label113;
        }
      }
      label113:
      for (int i = -1;; i = paramView.intValue())
      {
        if (i >= 0)
        {
          this.Ujt = i;
          this.bZE.notifyChanged();
          paramView = this.Uju;
          if (paramView != null) {
            paramView.invoke(Integer.valueOf(i));
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(282680);
        return;
        paramView = paramView.getTag();
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter$TemplateListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "selectMask", "kotlin.jvm.PlatformType", "getSelectMask", "()Landroid/view/View;", "setSelected", "", "select", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends RecyclerView.v
    {
      final View Ujv;
      final ImageView coverIv;
      final TextView lDF;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(282719);
        View localView = paramView.findViewById(a.f.template_name);
        s.s(localView, "itemView.findViewById(R.id.template_name)");
        this.lDF = ((TextView)localView);
        localView = paramView.findViewById(a.f.template_cover);
        s.s(localView, "itemView.findViewById(R.id.template_cover)");
        this.coverIv = ((ImageView)localView);
        this.Ujv = paramView.findViewById(a.f.selected_mask);
        AppMethodBeat.o(282719);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.z
 * JD-Core Version:    0.7.0.1
 */