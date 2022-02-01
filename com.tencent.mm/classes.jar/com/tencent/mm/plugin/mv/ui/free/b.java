package com.tencent.mm.plugin.mv.ui.free;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "previousId", "", "pagInfoList", "", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "onPreview", "Lkotlin/Function2;", "", "", "onSelected", "Lkotlin/Function1;", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "replayLayout", "Landroid/view/View;", "getReplayLayout", "()Landroid/view/View;", "replayLayout$delegate", "Lkotlin/Lazy;", "selectedId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setShowReplay", "show", "EffectViewHolder", "EffectsAdapter", "plugin-mv_release"})
public final class b
  extends com.google.android.material.bottomsheet.a
{
  private final f GgB;
  private final String GgC;
  private final List<com.tencent.mm.plugin.mv.model.a> GgD;
  private final m<com.tencent.mm.plugin.mv.model.a, Boolean, x> GgE;
  private final kotlin.g.a.b<com.tencent.mm.plugin.mv.model.a, x> GgF;
  private String uUZ;
  
  public b(Context paramContext, String paramString, List<com.tencent.mm.plugin.mv.model.a> paramList, m<? super com.tencent.mm.plugin.mv.model.a, ? super Boolean, x> paramm, kotlin.g.a.b<? super com.tencent.mm.plugin.mv.model.a, x> paramb)
  {
    super(paramContext);
    AppMethodBeat.i(225872);
    this.GgC = paramString;
    this.GgD = paramList;
    this.GgE = paramm;
    this.GgF = paramb;
    this.uUZ = this.GgC;
    this.GgB = g.ar((kotlin.g.a.a)new g(this));
    setContentView(com.tencent.mm.plugin.mv.b.f.FZx);
    AppMethodBeat.o(225872);
  }
  
  private final View fgG()
  {
    AppMethodBeat.i(225867);
    View localView = (View)this.GgB.getValue();
    AppMethodBeat.o(225867);
    return localView;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(225868);
    super.onCreate(paramBundle);
    paramBundle = findViewById(com.tencent.mm.plugin.mv.b.e.FXe);
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle = (RecyclerView)paramBundle;
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    paramBundle.setAdapter((RecyclerView.a)new b());
    setOnCancelListener((DialogInterface.OnCancelListener)new c(this));
    paramBundle = findViewById(com.tencent.mm.plugin.mv.b.e.close_button);
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    paramBundle = findViewById(com.tencent.mm.plugin.mv.b.e.confirm_button);
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.setOnClickListener((View.OnClickListener)new e(this));
    paramBundle = fgG();
    p.j(paramBundle, "replayLayout");
    paramBundle.setVisibility(8);
    fgG().setOnClickListener((View.OnClickListener)new f(this));
    AppMethodBeat.o(225868);
  }
  
  public final void vD(boolean paramBoolean)
  {
    AppMethodBeat.i(225869);
    View localView = fgG();
    p.j(localView, "replayLayout");
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(225869);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "sample", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "getSample", "()Lcom/tencent/mm/plugin/gif/MMAnimateView;", "selectIndicator", "getSelectIndicator", "()Landroid/view/View;", "plugin-mv_release"})
  public static final class a
    extends RecyclerView.v
  {
    final View GgG;
    final MMAnimateView GgH;
    final TextView znp;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(225994);
      View localView = paramView.findViewById(com.tencent.mm.plugin.mv.b.e.name);
      p.j(localView, "itemView.findViewById(R.id.name)");
      this.znp = ((TextView)localView);
      localView = paramView.findViewById(com.tencent.mm.plugin.mv.b.e.FXs);
      p.j(localView, "itemView.findViewById(R.id.indicator)");
      this.GgG = localView;
      paramView = paramView.findViewById(com.tencent.mm.plugin.mv.b.e.sample);
      p.j(paramView, "itemView.findViewById(R.id.sample)");
      this.GgH = ((MMAnimateView)paramView);
      AppMethodBeat.o(225994);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectViewHolder;", "(Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-mv_release"})
  public final class b
    extends RecyclerView.a<b.a>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(225106);
      int i = b.a(this.GgI).size();
      AppMethodBeat.o(225106);
      return i + 1;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(b.b paramb, com.tencent.mm.plugin.mv.model.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(225790);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        this.GgJ.GgI.vD(false);
        localObject = this.GgJ.GgI;
        paramView = this.GgK;
        if (paramView != null) {}
        for (paramView = paramView.id;; paramView = null)
        {
          b.a((b)localObject, paramView);
          this.GgJ.aE(0, this.GgJ.getItemCount());
          b.c(this.GgJ.GgI).invoke(this.GgK, Boolean.FALSE);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$EffectsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(225790);
          return;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class c
    implements DialogInterface.OnCancelListener
  {
    c(b paramb) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(226543);
      kotlin.g.a.b localb = b.d(this.GgI);
      Iterator localIterator = ((Iterable)b.a(this.GgI)).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramDialogInterface = localIterator.next();
      } while (!p.h(((com.tencent.mm.plugin.mv.model.a)paramDialogInterface).id, b.e(this.GgI)));
      for (;;)
      {
        localb.invoke(paramDialogInterface);
        this.GgI.dismiss();
        AppMethodBeat.o(226543);
        return;
        paramDialogInterface = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230867);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.GgI.cancel();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230867);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231152);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = b.d(this.GgI);
      Iterator localIterator = ((Iterable)b.a(this.GgI)).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramView = localIterator.next();
      } while (!p.h(((com.tencent.mm.plugin.mv.model.a)paramView).id, b.b(this.GgI)));
      for (;;)
      {
        ((kotlin.g.a.b)localObject).invoke(paramView);
        this.GgI.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231152);
        return;
        paramView = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235604);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = b.c(this.GgI);
      Iterator localIterator = ((Iterable)b.a(this.GgI)).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramView = localIterator.next();
      } while (!p.h(((com.tencent.mm.plugin.mv.model.a)paramView).id, b.b(this.GgI)));
      for (;;)
      {
        ((m)localObject).invoke(paramView, Boolean.TRUE);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexTransitionEditDialog$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235604);
        return;
        paramView = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<View>
  {
    g(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.free.b
 * JD-Core Version:    0.7.0.1
 */