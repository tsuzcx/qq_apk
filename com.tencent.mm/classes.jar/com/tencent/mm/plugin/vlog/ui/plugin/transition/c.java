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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "transitionList", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "(Ljava/util/List;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "getTransitionList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setOnItemClickListener", "listener", "BaseViewHolder", "Companion", "NoneViewHolder", "OnItemClickListener", "TransitionViewHolder", "plugin-vlog_release"})
public final class c
  extends RecyclerView.a<a>
{
  public static final b CkQ;
  d CkO;
  private final List<d> CkP;
  
  static
  {
    AppMethodBeat.i(192272);
    CkQ = new b((byte)0);
    AppMethodBeat.o(192272);
  }
  
  public c(List<d> paramList)
  {
    AppMethodBeat.i(192271);
    this.CkP = paramList;
    AppMethodBeat.o(192271);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(192266);
    int i = this.CkP.size();
    AppMethodBeat.o(192266);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "payloads", "", "", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void agd();
    
    public abstract void b(d paramd, int paramInt);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends c.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(192261);
      AppMethodBeat.o(192261);
    }
    
    public final void agd() {}
    
    public final void b(final d paramd, final int paramInt)
    {
      AppMethodBeat.i(192260);
      p.h(paramd, "item");
      View localView = this.auu;
      p.g(localView, "itemView");
      localView.setSelected(paramd.tqA);
      this.auu.setOnClickListener((View.OnClickListener)new a(this, paramd, paramInt));
      AppMethodBeat.o(192260);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.c paramc, d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192259);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = c.a(this.CkS.CkR);
        if (paramView != null) {
          paramView.a(paramd, paramInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192259);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "", "onItemClick", "", "transitionInfo", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "plugin-vlog_release"})
  public static abstract interface d
  {
    public abstract void a(d paramd, int paramInt);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "iconImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "transNameText", "Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
  public final class e
    extends c.a
  {
    private final WeImageView CkU;
    private final TextView CkV;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(192265);
      this$1 = localObject.findViewById(2131308321);
      p.g(c.this, "itemView.findViewById(R.id.gif_iv)");
      this.CkU = ((WeImageView)c.this);
      this$1 = localObject.findViewById(2131308449);
      p.g(c.this, "itemView.findViewById(R.id.transition_name_text)");
      this.CkV = ((TextView)c.this);
      AppMethodBeat.o(192265);
    }
    
    public final void agd()
    {
      AppMethodBeat.i(192264);
      View localView = this.auu;
      p.g(localView, "itemView");
      localView.setSelected(false);
      AppMethodBeat.o(192264);
    }
    
    public final void b(final d paramd, final int paramInt)
    {
      AppMethodBeat.i(192263);
      p.h(paramd, "item");
      Object localObject2 = this.CkV.getText();
      Object localObject1 = paramd.CkX;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((a.a)localObject1).name;
        if ((p.i(localObject2, localObject1) ^ true))
        {
          localObject1 = this.CkU;
          localObject2 = this.CkU.getContext();
          a.a locala = paramd.CkX;
          if (locala == null) {
            break label181;
          }
          i = locala.BYU;
          label82:
          ((WeImageView)localObject1).setImageDrawable(com.tencent.mm.cb.a.l((Context)localObject2, i));
          localObject2 = this.CkV;
          localObject1 = paramd.CkX;
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
        ((View)localObject1).setSelected(paramd.tqA);
        this.auu.setOnClickListener((View.OnClickListener)new a(this, paramd, paramInt));
        AppMethodBeat.o(192263);
        return;
        localObject1 = null;
        break;
        i = -1;
        break label82;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.e parame, d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192262);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = c.a(this.CkW.CkR);
        if (paramView != null) {
          paramView.a(paramd, paramInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192262);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.c
 * JD-Core Version:    0.7.0.1
 */