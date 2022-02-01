package com.tencent.mm.plugin.mv.ui.free;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "previousId", "", "pagInfoList", "", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "onPreview", "Lkotlin/Function2;", "", "", "onSelected", "Lkotlin/Function1;", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "replayLayout", "Landroid/view/View;", "getReplayLayout", "()Landroid/view/View;", "replayLayout$delegate", "Lkotlin/Lazy;", "selectedId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setShowReplay", "show", "EffectViewHolder", "EffectsAdapter", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.google.android.material.bottomsheet.a
{
  private final String MbQ;
  private final List<com.tencent.mm.plugin.mv.model.a> MbR;
  private final m<com.tencent.mm.plugin.mv.model.a, Boolean, ah> MbS;
  private final kotlin.g.a.b<com.tencent.mm.plugin.mv.model.a, ah> MbT;
  private final j MbU;
  private String mlM;
  
  public b(Context paramContext, String paramString, List<com.tencent.mm.plugin.mv.model.a> paramList, m<? super com.tencent.mm.plugin.mv.model.a, ? super Boolean, ah> paramm, kotlin.g.a.b<? super com.tencent.mm.plugin.mv.model.a, ah> paramb)
  {
    super(paramContext);
    AppMethodBeat.i(286713);
    this.MbQ = paramString;
    this.MbR = paramList;
    this.MbS = paramm;
    this.MbT = paramb;
    this.mlM = this.MbQ;
    this.MbU = k.cm((kotlin.g.a.a)new c(this));
    setContentView(b.f.LVu);
    AppMethodBeat.o(286713);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(286732);
    s.u(paramb, "this$0");
    kotlin.g.a.b localb = paramb.MbT;
    Iterator localIterator = ((Iterable)paramb.MbR).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramDialogInterface = localIterator.next();
    } while (!s.p(((com.tencent.mm.plugin.mv.model.a)paramDialogInterface).id, paramb.MbQ));
    for (;;)
    {
      localb.invoke(paramDialogInterface);
      paramb.dismiss();
      AppMethodBeat.o(286732);
      return;
      paramDialogInterface = null;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(286737);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286737);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(286747);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    localObject1 = paramb.MbT;
    localObject2 = ((Iterable)paramb.MbR).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      paramView = ((Iterator)localObject2).next();
    } while (!s.p(((com.tencent.mm.plugin.mv.model.a)paramView).id, paramb.mlM));
    for (;;)
    {
      ((kotlin.g.a.b)localObject1).invoke(paramView);
      paramb.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286747);
      return;
      paramView = null;
    }
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(286752);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    localObject1 = paramb.MbS;
    localObject2 = ((Iterable)paramb.MbR).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      paramView = ((Iterator)localObject2).next();
    } while (!s.p(((com.tencent.mm.plugin.mv.model.a)paramView).id, paramb.mlM));
    for (paramb = paramView;; paramb = null)
    {
      ((m)localObject1).invoke(paramb, Boolean.TRUE);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286752);
      return;
    }
  }
  
  private final View gqm()
  {
    AppMethodBeat.i(286721);
    View localView = (View)this.MbU.getValue();
    AppMethodBeat.o(286721);
    return localView;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(286799);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.e.LSt);
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "findViewById(R.id.effects)!!");
    paramBundle = (RecyclerView)paramBundle;
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    paramBundle.setAdapter((RecyclerView.a)new b());
    setOnCancelListener(new b..ExternalSyntheticLambda0(this));
    paramBundle = findViewById(b.e.close_button);
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "findViewById(R.id.close_button)!!");
    paramBundle.setOnClickListener(new b..ExternalSyntheticLambda3(this));
    paramBundle = findViewById(b.e.confirm_button);
    s.checkNotNull(paramBundle);
    s.s(paramBundle, "findViewById(R.id.confirm_button)!!");
    paramBundle.setOnClickListener(new b..ExternalSyntheticLambda2(this));
    gqm().setVisibility(8);
    gqm().setOnClickListener(new b..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(286799);
  }
  
  public final void zY(boolean paramBoolean)
  {
    AppMethodBeat.i(286802);
    View localView = gqm();
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(286802);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "sample", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "getSample", "()Lcom/tencent/mm/plugin/gif/MMAnimateView;", "selectIndicator", "getSelectIndicator", "()Landroid/view/View;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final TextView Eoo;
    final View MbV;
    final MMAnimateView MbW;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(286797);
      View localView = paramView.findViewById(b.e.name);
      s.s(localView, "itemView.findViewById(R.id.name)");
      this.Eoo = ((TextView)localView);
      localView = paramView.findViewById(b.e.LSR);
      s.s(localView, "itemView.findViewById(R.id.indicator)");
      this.MbV = localView;
      paramView = paramView.findViewById(b.e.sample);
      s.s(paramView, "itemView.findViewById(R.id.sample)");
      this.MbW = ((MMAnimateView)paramView);
      AppMethodBeat.o(286797);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectViewHolder;", "(Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.a<b.a>
  {
    public b()
    {
      AppMethodBeat.i(286801);
      AppMethodBeat.o(286801);
    }
    
    private static final void a(b paramb, com.tencent.mm.plugin.mv.model.a parama, b paramb1, View paramView)
    {
      AppMethodBeat.i(286808);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(parama);
      localb.cH(paramb1);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectsAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      s.u(paramb1, "this$1");
      paramb.zY(false);
      if (parama == null) {}
      for (paramView = null;; paramView = parama.id)
      {
        b.a(paramb, paramView);
        paramb1.by(0, paramb1.getItemCount());
        b.c(paramb).invoke(parama, Boolean.FALSE);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectsAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286808);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(286816);
      int i = b.a(this.MbX).size();
      AppMethodBeat.o(286816);
      return i + 1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.free.b
 * JD-Core Version:    0.7.0.1
 */