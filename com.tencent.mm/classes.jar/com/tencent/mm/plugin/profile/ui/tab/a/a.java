package com.tencent.mm.plugin.profile.ui.tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.LabelsView.a;
import com.tencent.mm.ui.widget.happybubble.LabelsView.b;
import java.util.List;
import kotlin.g.a.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "menuList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "(Ljava/util/List;)V", "onFooterViewClick", "Lkotlin/Function0;", "", "getOnFooterViewClick", "()Lkotlin/jvm/functions/Function0;", "setOnFooterViewClick", "(Lkotlin/jvm/functions/Function0;)V", "onMenuItemClick", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "menuButton", "", "position", "index", "getOnMenuItemClick", "()Lkotlin/jvm/functions/Function3;", "setOnMenuItemClick", "(Lkotlin/jvm/functions/Function3;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MenuFooterViewHolder", "MenuMultiViewHolder", "MenuSingleViewHolder", "app_release"})
public final class a
  extends RecyclerView.a<RecyclerView.v>
{
  public static final a Hid;
  public q<? super pw, ? super Integer, ? super Integer, x> Hib;
  public kotlin.g.a.a<x> Hic;
  private final List<pw> eZQ;
  
  static
  {
    AppMethodBeat.i(279557);
    Hid = new a((byte)0);
    AppMethodBeat.o(279557);
  }
  
  public a(List<? extends pw> paramList)
  {
    AppMethodBeat.i(279556);
    this.eZQ = paramList;
    AppMethodBeat.o(279556);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(279552);
    kotlin.g.b.p.k(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.eeU, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new a.b(paramViewGroup);
      AppMethodBeat.o(279552);
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.efm, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
      AppMethodBeat.o(279552);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.efl, paramViewGroup, false);
    kotlin.g.b.p.j(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
    AppMethodBeat.o(279552);
    return paramViewGroup;
  }
  
  public final void d(final RecyclerView.v paramv, final int paramInt)
  {
    AppMethodBeat.i(279554);
    kotlin.g.b.p.k(paramv, "holder");
    Object localObject;
    if ((paramv instanceof d))
    {
      com.tencent.mm.ui.tools.p.iF(paramv.amk);
      localObject = com.tencent.mm.pluginsdk.ui.span.l.c(((d)paramv).titleView.getContext(), (CharSequence)((pw)this.eZQ.get(paramInt)).name);
      kotlin.g.b.p.j(localObject, "MMSpanManager.spanForSmi… menuList[position].name)");
      localObject = (CharSequence)localObject;
      ((d)paramv).titleView.setText((CharSequence)localObject);
      paramv.amk.setOnClickListener((View.OnClickListener)new e(this, paramInt));
      AppMethodBeat.o(279554);
      return;
    }
    if ((paramv instanceof c))
    {
      localObject = com.tencent.mm.pluginsdk.ui.span.l.c(((c)paramv).titleView.getContext(), (CharSequence)((pw)this.eZQ.get(paramInt)).name);
      kotlin.g.b.p.j(localObject, "MMSpanManager.spanForSmi… menuList[position].name)");
      localObject = (CharSequence)localObject;
      ((c)paramv).titleView.setText((CharSequence)localObject);
      ((c)paramv).Hie.setOnLabelClickListener((LabelsView.b)new f(this, paramInt));
      ((c)paramv).Hie.a((List)((pw)this.eZQ.get(paramInt)).RYg, (LabelsView.a)new g(this, paramInt, paramv));
      AppMethodBeat.o(279554);
      return;
    }
    if ((paramv instanceof a.b))
    {
      com.tencent.mm.ui.tools.p.iF(paramv.amk);
      paramv.amk.setOnClickListener((View.OnClickListener)new h(this));
    }
    AppMethodBeat.o(279554);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(279553);
    int i = this.eZQ.size();
    AppMethodBeat.o(279553);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(279555);
    if (paramInt >= this.eZQ.size())
    {
      AppMethodBeat.o(279555);
      return 3;
    }
    if (((pw)this.eZQ.get(paramInt)).type == 0)
    {
      AppMethodBeat.o(279555);
      return 2;
    }
    AppMethodBeat.o(279555);
    return 1;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$Companion;", "", "()V", "MENU_TYPE_FOOTER", "", "MENU_TYPE_MULTI", "MENU_TYPE_SINGLE", "app_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuMultiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "subMenuLabel", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getSubMenuLabel", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "app_release"})
  public static final class c
    extends RecyclerView.v
  {
    final LabelsView Hie;
    final TextView titleView;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(287267);
      View localView = paramView.findViewById(R.h.dtP);
      kotlin.g.b.p.j(localView, "itemView.findViewById(R.id.biz_profile_menu_title)");
      this.titleView = ((TextView)localView);
      paramView = paramView.findViewById(R.h.dtT);
      kotlin.g.b.p.j(paramView, "itemView.findViewById(R.…ile_sub_menu_title_label)");
      this.Hie = ((LabelsView)paramView);
      AppMethodBeat.o(287267);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuSingleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "app_release"})
  public static final class d
    extends RecyclerView.v
  {
    final TextView titleView;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(286400);
      paramView = paramView.findViewById(R.h.dtP);
      kotlin.g.b.p.j(paramView, "itemView.findViewById(R.id.biz_profile_menu_title)");
      this.titleView = ((TextView)paramView);
      AppMethodBeat.o(286400);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279780);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Hif.Hib;
      if (paramView != null) {
        paramView.c(a.a(this.Hif).get(paramInt), Integer.valueOf(paramInt), Integer.valueOf(0));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279780);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "index", "", "onLabelClick"})
  static final class f
    implements LabelsView.b
  {
    f(a parama, int paramInt) {}
    
    public final void n(Object paramObject, int paramInt)
    {
      AppMethodBeat.i(290928);
      q localq = this.Hif.Hib;
      if (localq != null)
      {
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizServiceMenuButton");
          AppMethodBeat.o(290928);
          throw paramObject;
        }
        localq.c((pw)paramObject, Integer.valueOf(paramInt), Integer.valueOf(paramInt));
        AppMethodBeat.o(290928);
        return;
      }
      AppMethodBeat.o(290928);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "index", "", "data", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "getLabelText"})
  static final class g<T>
    implements LabelsView.a<pw>
  {
    g(a parama, int paramInt, RecyclerView.v paramv) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(275076);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Hif.Hic;
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.a.a
 * JD-Core Version:    0.7.0.1
 */