package com.tencent.mm.plugin.profile.ui.tab.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "menuList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "(Ljava/util/List;)V", "onFooterViewClick", "Lkotlin/Function0;", "", "getOnFooterViewClick", "()Lkotlin/jvm/functions/Function0;", "setOnFooterViewClick", "(Lkotlin/jvm/functions/Function0;)V", "onMenuItemClick", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "menuButton", "", "position", "index", "getOnMenuItemClick", "()Lkotlin/jvm/functions/Function3;", "setOnMenuItemClick", "(Lkotlin/jvm/functions/Function3;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MenuFooterViewHolder", "MenuMultiViewHolder", "MenuSingleViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<RecyclerView.v>
{
  public static final a.a NfS;
  public q<? super rg, ? super Integer, ? super Integer, ah> NfT;
  public kotlin.g.a.a<ah> NfU;
  private final List<rg> hdq;
  
  static
  {
    AppMethodBeat.i(305968);
    NfS = new a.a((byte)0);
    AppMethodBeat.o(305968);
  }
  
  public a(List<? extends rg> paramList)
  {
    AppMethodBeat.i(305920);
    this.hdq = paramList;
    AppMethodBeat.o(305920);
  }
  
  private static final CharSequence a(RecyclerView.v paramv, a parama, int paramInt1, TextView paramTextView, int paramInt2, rg paramrg)
  {
    AppMethodBeat.i(305955);
    s.u(paramv, "$holder");
    s.u(parama, "this$0");
    o.F((View)paramTextView, 0.7F);
    paramTextView.setOnClickListener(new a..ExternalSyntheticLambda2(parama, paramrg, paramInt1, paramInt2));
    parama = am.aixg;
    String str = paramv.caK.getContext().getResources().getString(R.l.biz_timeline_service_tab_label);
    s.s(str, "holder.itemView.context.…meline_service_tab_label)");
    if (paramrg == null)
    {
      parama = null;
      parama = String.format(str, Arrays.copyOf(new Object[] { parama }, 1));
      s.s(parama, "java.lang.String.format(format, *args)");
      paramTextView.setContentDescription((CharSequence)parama);
      parama = ((c)paramv).titleView.getContext();
      if (paramrg != null) {
        break label164;
      }
    }
    label164:
    for (paramv = null;; paramv = paramrg.name)
    {
      paramv = p.b(parama, (CharSequence)paramv);
      if (paramv != null) {
        break label173;
      }
      paramv = (CharSequence)"";
      AppMethodBeat.o(305955);
      return paramv;
      parama = paramrg.name;
      break;
    }
    label173:
    paramv = (CharSequence)paramv;
    AppMethodBeat.o(305955);
    return paramv;
  }
  
  private static final void a(a parama, int paramInt, View paramView)
  {
    AppMethodBeat.i(305927);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.NfT;
    if (paramView != null) {
      paramView.invoke(parama.hdq.get(paramInt), Integer.valueOf(paramInt), Integer.valueOf(0));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305927);
  }
  
  private static final void a(a parama, int paramInt1, TextView paramTextView, Object paramObject, int paramInt2)
  {
    AppMethodBeat.i(305933);
    s.u(parama, "this$0");
    parama = parama.NfT;
    if (parama != null)
    {
      if (paramObject == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizServiceMenuButton");
        AppMethodBeat.o(305933);
        throw parama;
      }
      parama.invoke((rg)paramObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(305933);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(305961);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.NfU;
    if (parama != null) {
      parama.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305961);
  }
  
  private static final void a(a parama, rg paramrg, int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(305941);
    s.u(parama, "this$0");
    parama = parama.NfT;
    if (parama != null)
    {
      s.s(paramrg, "data");
      parama.invoke(paramrg, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(305941);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(306008);
    s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ghN, paramViewGroup, false);
      s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new a.b(paramViewGroup);
      AppMethodBeat.o(306008);
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gih, paramViewGroup, false);
      s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
      AppMethodBeat.o(306008);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gig, paramViewGroup, false);
    s.s(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
    AppMethodBeat.o(306008);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(306021);
    s.u(paramv, "holder");
    Object localObject;
    if ((paramv instanceof d))
    {
      o.F(paramv.caK, 0.7F);
      localObject = p.b(((d)paramv).titleView.getContext(), (CharSequence)((rg)this.hdq.get(paramInt)).name);
      s.s(localObject, "spanForSmiley(holder.tit… menuList[position].name)");
      localObject = (CharSequence)localObject;
      ((d)paramv).titleView.setText((CharSequence)localObject);
      paramv.caK.setOnClickListener(new a..ExternalSyntheticLambda1(this, paramInt));
      AppMethodBeat.o(306021);
      return;
    }
    if ((paramv instanceof c))
    {
      localObject = p.b(((c)paramv).titleView.getContext(), (CharSequence)((rg)this.hdq.get(paramInt)).name);
      s.s(localObject, "spanForSmiley(holder.tit… menuList[position].name)");
      localObject = (CharSequence)localObject;
      ((c)paramv).titleView.setText((CharSequence)localObject);
      ((c)paramv).NfV.setOnLabelClickListener(new a..ExternalSyntheticLambda4(this, paramInt));
      ((c)paramv).NfV.a((List)((rg)this.hdq.get(paramInt)).YWf, new a..ExternalSyntheticLambda3(paramv, this, paramInt));
      AppMethodBeat.o(306021);
      return;
    }
    if ((paramv instanceof a.b))
    {
      o.F(paramv.caK, 0.7F);
      paramv.caK.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(306021);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(306010);
    int i = this.hdq.size();
    AppMethodBeat.o(306010);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(306027);
    if (paramInt >= this.hdq.size())
    {
      AppMethodBeat.o(306027);
      return 3;
    }
    if (((rg)this.hdq.get(paramInt)).type == 0)
    {
      AppMethodBeat.o(306027);
      return 2;
    }
    AppMethodBeat.o(306027);
    return 1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuMultiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "subMenuLabel", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getSubMenuLabel", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.v
  {
    final LabelsView NfV;
    final TextView titleView;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(305910);
      View localView = paramView.findViewById(R.h.fug);
      s.s(localView, "itemView.findViewById(R.id.biz_profile_menu_title)");
      this.titleView = ((TextView)localView);
      paramView = paramView.findViewById(R.h.fuk);
      s.s(paramView, "itemView.findViewById(R.…ile_sub_menu_title_label)");
      this.NfV = ((LabelsView)paramView);
      AppMethodBeat.o(305910);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuSingleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.v
  {
    final TextView titleView;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(305913);
      paramView = paramView.findViewById(R.h.fug);
      s.s(paramView, "itemView.findViewById(R.id.biz_profile_menu_title)");
      this.titleView = ((TextView)paramView);
      AppMethodBeat.o(305913);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.a.a
 * JD-Core Version:    0.7.0.1
 */