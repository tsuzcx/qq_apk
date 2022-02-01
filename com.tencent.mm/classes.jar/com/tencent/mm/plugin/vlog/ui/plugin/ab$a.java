package com.tencent.mm.plugin.vlog.ui.plugin;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter$TemplateListViewHolder;", "Landroid/view/View$OnClickListener;", "()V", "currentSelectedPos", "", "onItemSelected", "Lkotlin/Function1;", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "templateList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "Lkotlin/collections/ArrayList;", "currentSelectedTemplate", "getItemCount", "onBindViewHolder", "holder", "index", "onClick", "v", "Landroid/view/View;", "onCreateViewHolder", "view", "Landroid/view/ViewGroup;", "setSelected", "setTemplates", "list", "", "TemplateListViewHolder", "plugin-vlog_release"})
public final class ab$a
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  final ArrayList<a.c> GIt;
  int GIu;
  kotlin.g.a.b<? super Integer, x> wpI;
  
  public ab$a()
  {
    AppMethodBeat.i(191466);
    this.GIt = new ArrayList();
    AppMethodBeat.o(191466);
  }
  
  public final a.c fDN()
  {
    AppMethodBeat.i(191464);
    Object localObject = this.GIt.get(this.GIu);
    p.g(localObject, "templateList[currentSelectedPos]");
    localObject = (a.c)localObject;
    AppMethodBeat.o(191464);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(191462);
    int i = this.GIt.size();
    AppMethodBeat.o(191462);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191465);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView != null)
    {
      paramView = paramView.getTag();
      paramView = (Integer)paramView;
      if (paramView == null) {
        break label113;
      }
    }
    label113:
    for (int i = paramView.intValue();; i = -1)
    {
      if (i >= 0)
      {
        this.GIu = i;
        notifyDataSetChanged();
        paramView = this.wpI;
        if (paramView != null) {
          paramView.invoke(Integer.valueOf(i));
        }
      }
      a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191465);
      return;
      paramView = null;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter$TemplateListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "selectMask", "kotlin.jvm.PlatformType", "getSelectMask", "()Landroid/view/View;", "setSelected", "", "select", "", "plugin-vlog_release"})
  public static final class a
    extends RecyclerView.v
  {
    final View GIv;
    final TextView gxs;
    final ImageView puw;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(191460);
      View localView = paramView.findViewById(2131308941);
      p.g(localView, "itemView.findViewById(R.id.template_name)");
      this.gxs = ((TextView)localView);
      localView = paramView.findViewById(2131308938);
      p.g(localView, "itemView.findViewById(R.id.template_cover)");
      this.puw = ((ImageView)localView);
      this.GIv = paramView.findViewById(2131307569);
      AppMethodBeat.o(191460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ab.a
 * JD-Core Version:    0.7.0.1
 */