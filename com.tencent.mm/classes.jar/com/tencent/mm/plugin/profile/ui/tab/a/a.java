package com.tencent.mm.plugin.profile.ui.tab.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.LabelsView.a;
import com.tencent.mm.ui.widget.happybubble.LabelsView.b;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "menuList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "(Ljava/util/List;)V", "onFooterViewClick", "Lkotlin/Function0;", "", "getOnFooterViewClick", "()Lkotlin/jvm/functions/Function0;", "setOnFooterViewClick", "(Lkotlin/jvm/functions/Function0;)V", "onMenuItemClick", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "menuButton", "", "position", "index", "getOnMenuItemClick", "()Lkotlin/jvm/functions/Function3;", "setOnMenuItemClick", "(Lkotlin/jvm/functions/Function3;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MenuFooterViewHolder", "MenuMultiViewHolder", "MenuSingleViewHolder", "app_release"})
public final class a
  extends RecyclerView.a<RecyclerView.v>
{
  public static final a.a BnI;
  public q<? super qa, ? super Integer, ? super Integer, x> BnG;
  public kotlin.g.a.a<x> BnH;
  private final List<qa> dij;
  
  static
  {
    AppMethodBeat.i(230867);
    BnI = new a.a((byte)0);
    AppMethodBeat.o(230867);
  }
  
  public a(List<? extends qa> paramList)
  {
    AppMethodBeat.i(230866);
    this.dij = paramList;
    AppMethodBeat.o(230866);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(230862);
    p.h(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493723, paramViewGroup, false);
      p.g(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new a.b(paramViewGroup);
      AppMethodBeat.o(230862);
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493762, paramViewGroup, false);
      p.g(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new a.d(paramViewGroup);
      AppMethodBeat.o(230862);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493761, paramViewGroup, false);
    p.g(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
    AppMethodBeat.o(230862);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.v paramv, final int paramInt)
  {
    AppMethodBeat.i(230864);
    p.h(paramv, "holder");
    Object localObject;
    if ((paramv instanceof a.d))
    {
      o.hp(paramv.aus);
      localObject = com.tencent.mm.pluginsdk.ui.span.l.c(((a.d)paramv).titleView.getContext(), (CharSequence)((qa)this.dij.get(paramInt)).name);
      p.g(localObject, "MMSpanManager.spanForSmi… menuList[position].name)");
      localObject = (CharSequence)localObject;
      ((a.d)paramv).titleView.setText((CharSequence)localObject);
      paramv.aus.setOnClickListener((View.OnClickListener)new e(this, paramInt));
      AppMethodBeat.o(230864);
      return;
    }
    if ((paramv instanceof c))
    {
      localObject = com.tencent.mm.pluginsdk.ui.span.l.c(((c)paramv).titleView.getContext(), (CharSequence)((qa)this.dij.get(paramInt)).name);
      p.g(localObject, "MMSpanManager.spanForSmi… menuList[position].name)");
      localObject = (CharSequence)localObject;
      ((c)paramv).titleView.setText((CharSequence)localObject);
      ((c)paramv).BnJ.setOnLabelClickListener((LabelsView.b)new f(this, paramInt));
      ((c)paramv).BnJ.a((List)((qa)this.dij.get(paramInt)).KWT, (LabelsView.a)new g(this, paramInt, paramv));
      AppMethodBeat.o(230864);
      return;
    }
    if ((paramv instanceof a.b))
    {
      o.hp(paramv.aus);
      paramv.aus.setOnClickListener((View.OnClickListener)new h(this));
    }
    AppMethodBeat.o(230864);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(230863);
    int i = this.dij.size();
    AppMethodBeat.o(230863);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(230865);
    if (paramInt >= this.dij.size())
    {
      AppMethodBeat.o(230865);
      return 3;
    }
    if (((qa)this.dij.get(paramInt)).type == 0)
    {
      AppMethodBeat.o(230865);
      return 2;
    }
    AppMethodBeat.o(230865);
    return 1;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuMultiViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "subMenuLabel", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getSubMenuLabel", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "app_release"})
  public static final class c
    extends RecyclerView.v
  {
    final LabelsView BnJ;
    final TextView titleView;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(230855);
      View localView = paramView.findViewById(2131297477);
      p.g(localView, "itemView.findViewById(R.id.biz_profile_menu_title)");
      this.titleView = ((TextView)localView);
      paramView = paramView.findViewById(2131297481);
      p.g(paramView, "itemView.findViewById(R.…ile_sub_menu_title_label)");
      this.BnJ = ((LabelsView)paramView);
      AppMethodBeat.o(230855);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230857);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.BnK.BnG;
      if (paramView != null) {
        paramView.d(a.a(this.BnK).get(paramInt), Integer.valueOf(paramInt), Integer.valueOf(0));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230857);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "index", "", "onLabelClick"})
  static final class f
    implements LabelsView.b
  {
    f(a parama, int paramInt) {}
    
    public final void j(Object paramObject, int paramInt)
    {
      AppMethodBeat.i(230858);
      q localq = this.BnK.BnG;
      if (localq != null)
      {
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizServiceMenuButton");
          AppMethodBeat.o(230858);
          throw paramObject;
        }
        localq.d((qa)paramObject, Integer.valueOf(paramInt), Integer.valueOf(paramInt));
        AppMethodBeat.o(230858);
        return;
      }
      AppMethodBeat.o(230858);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "index", "", "data", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "getLabelText"})
  static final class g<T>
    implements LabelsView.a<qa>
  {
    g(a parama, int paramInt, RecyclerView.v paramv) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230861);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.BnK.BnH;
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.a.a
 * JD-Core Version:    0.7.0.1
 */