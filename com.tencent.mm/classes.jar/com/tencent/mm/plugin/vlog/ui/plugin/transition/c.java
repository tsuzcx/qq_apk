package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "transitionList", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "(Ljava/util/List;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "getTransitionList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setOnItemClickListener", "listener", "BaseViewHolder", "Companion", "NoneViewHolder", "OnItemClickListener", "TransitionViewHolder", "plugin-vlog_release"})
public final class c
  extends RecyclerView.a<a>
{
  public static final b BTp;
  d BTn;
  private final List<d> BTo;
  
  static
  {
    AppMethodBeat.i(196809);
    BTp = new b((byte)0);
    AppMethodBeat.o(196809);
  }
  
  public c(List<d> paramList)
  {
    AppMethodBeat.i(196808);
    this.BTo = paramList;
    AppMethodBeat.o(196808);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(196803);
    int i = this.BTo.size();
    AppMethodBeat.o(196803);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "payloads", "", "", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void afP();
    
    public abstract void b(d paramd, int paramInt);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends c.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(196798);
      AppMethodBeat.o(196798);
    }
    
    public final void afP() {}
    
    public final void b(final d paramd, final int paramInt)
    {
      AppMethodBeat.i(196797);
      p.h(paramd, "item");
      View localView = this.auu;
      p.g(localView, "itemView");
      localView.setSelected(paramd.tfH);
      this.auu.setOnClickListener((View.OnClickListener)new a(this, paramd, paramInt));
      AppMethodBeat.o(196797);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.c paramc, d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(196796);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView = c.a(this.BTr.BTq);
        if (paramView != null) {
          paramView.a(paramd, paramInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196796);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "", "onItemClick", "", "transitionInfo", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "plugin-vlog_release"})
  public static abstract interface d
  {
    public abstract void a(d paramd, int paramInt);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "iconImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "transNameText", "Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
  public final class e
    extends c.a
  {
    private final WeImageView BTt;
    private final TextView BTu;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(196802);
      this$1 = localObject.findViewById(2131308321);
      p.g(c.this, "itemView.findViewById(R.id.gif_iv)");
      this.BTt = ((WeImageView)c.this);
      this$1 = localObject.findViewById(2131308449);
      p.g(c.this, "itemView.findViewById(R.id.transition_name_text)");
      this.BTu = ((TextView)c.this);
      AppMethodBeat.o(196802);
    }
    
    public final void afP()
    {
      AppMethodBeat.i(196801);
      View localView = this.auu;
      p.g(localView, "itemView");
      localView.setSelected(false);
      AppMethodBeat.o(196801);
    }
    
    public final void b(final d paramd, final int paramInt)
    {
      AppMethodBeat.i(196800);
      p.h(paramd, "item");
      Object localObject2 = this.BTu.getText();
      Object localObject1 = paramd.BTw;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((a.a)localObject1).name;
        if ((p.i(localObject2, localObject1) ^ true))
        {
          localObject1 = this.BTt;
          localObject2 = this.BTt.getContext();
          a.a locala = paramd.BTw;
          if (locala == null) {
            break label181;
          }
          i = locala.BHv;
          label82:
          ((WeImageView)localObject1).setImageDrawable(com.tencent.mm.cc.a.l((Context)localObject2, i));
          localObject2 = this.BTu;
          localObject1 = paramd.BTw;
          if (localObject1 == null) {
            break label186;
          }
        }
      }
      label181:
      label186:
      for (localObject1 = ((a.a)localObject1).name;; localObject1 = null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject1 = this.auu;
        p.g(localObject1, "itemView");
        ((View)localObject1).setSelected(paramd.tfH);
        this.auu.setOnClickListener((View.OnClickListener)new a(this, paramd, paramInt));
        AppMethodBeat.o(196800);
        return;
        localObject1 = null;
        break;
        i = -1;
        break label82;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.e parame, d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(196799);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView = c.a(this.BTv.BTq);
        if (paramView != null) {
          paramView.a(paramd, paramInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196799);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.c
 * JD-Core Version:    0.7.0.1
 */