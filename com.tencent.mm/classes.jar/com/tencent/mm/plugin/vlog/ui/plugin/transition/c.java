package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "transitionList", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "(Ljava/util/List;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "getTransitionList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setOnItemClickListener", "listener", "BaseViewHolder", "Companion", "NoneViewHolder", "OnItemClickListener", "TransitionViewHolder", "plugin-vlog_release"})
public final class c
  extends RecyclerView.a<a>
{
  public static final b NBA;
  d NBy;
  private final List<d> NBz;
  
  static
  {
    AppMethodBeat.i(234566);
    NBA = new b((byte)0);
    AppMethodBeat.o(234566);
  }
  
  public c(List<d> paramList)
  {
    AppMethodBeat.i(234565);
    this.NBz = paramList;
    AppMethodBeat.o(234565);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(234555);
    int i = this.NBz.size();
    AppMethodBeat.o(234555);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "payloads", "", "", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void aCO();
    
    public abstract void b(d paramd, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends c.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(227748);
      AppMethodBeat.o(227748);
    }
    
    public final void aCO() {}
    
    public final void b(final d paramd, final int paramInt)
    {
      AppMethodBeat.i(227747);
      p.k(paramd, "item");
      View localView = this.amk;
      p.j(localView, "itemView");
      localView.setSelected(paramd.xUg);
      this.amk.setOnClickListener((View.OnClickListener)new a(this, paramd, paramInt));
      AppMethodBeat.o(227747);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.c paramc, d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(229286);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = c.a(this.NBC.NBB);
        if (paramView != null) {
          paramView.a(paramd, paramInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229286);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "", "onItemClick", "", "transitionInfo", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "plugin-vlog_release"})
  public static abstract interface d
  {
    public abstract void a(d paramd, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "iconImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "transNameText", "Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
  public final class e
    extends c.a
  {
    private final WeImageView NBE;
    private final TextView NBF;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(246364);
      this$1 = localObject.findViewById(a.f.gif_iv);
      p.j(c.this, "itemView.findViewById(R.id.gif_iv)");
      this.NBE = ((WeImageView)c.this);
      this$1 = localObject.findViewById(a.f.transition_name_text);
      p.j(c.this, "itemView.findViewById(R.id.transition_name_text)");
      this.NBF = ((TextView)c.this);
      AppMethodBeat.o(246364);
    }
    
    public final void aCO()
    {
      AppMethodBeat.i(246363);
      View localView = this.amk;
      p.j(localView, "itemView");
      localView.setSelected(false);
      AppMethodBeat.o(246363);
    }
    
    public final void b(final d paramd, final int paramInt)
    {
      AppMethodBeat.i(246360);
      p.k(paramd, "item");
      Object localObject2 = this.NBF.getText();
      Object localObject1 = paramd.NBH;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((a.a)localObject1).name;
        if ((p.h(localObject2, localObject1) ^ true))
        {
          localObject1 = this.NBE;
          localObject2 = this.NBE.getContext();
          a.a locala = paramd.NBH;
          if (locala == null) {
            break label181;
          }
          i = locala.Nom;
          label82:
          ((WeImageView)localObject1).setImageDrawable(com.tencent.mm.ci.a.m((Context)localObject2, i));
          localObject2 = this.NBF;
          localObject1 = paramd.NBH;
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
        localObject1 = this.amk;
        p.j(localObject1, "itemView");
        ((View)localObject1).setSelected(paramd.xUg);
        this.amk.setOnClickListener((View.OnClickListener)new a(this, paramd, paramInt));
        AppMethodBeat.o(246360);
        return;
        localObject1 = null;
        break;
        i = -1;
        break label82;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.e parame, d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(233418);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = c.a(this.NBG.NBB);
        if (paramView != null) {
          paramView.a(paramd, paramInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233418);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.c
 * JD-Core Version:    0.7.0.1
 */