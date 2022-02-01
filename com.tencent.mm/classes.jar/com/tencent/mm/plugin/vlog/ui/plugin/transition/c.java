package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "transitionList", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "(Ljava/util/List;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "getTransitionList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setOnItemClickListener", "listener", "BaseViewHolder", "Companion", "NoneViewHolder", "OnItemClickListener", "TransitionViewHolder", "plugin-vlog_release"})
public final class c
  extends RecyclerView.a<a>
{
  public static final b GNS;
  d GNQ;
  private final List<d> GNR;
  
  static
  {
    AppMethodBeat.i(192011);
    GNS = new b((byte)0);
    AppMethodBeat.o(192011);
  }
  
  public c(List<d> paramList)
  {
    AppMethodBeat.i(192010);
    this.GNR = paramList;
    AppMethodBeat.o(192010);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(192005);
    int i = this.GNR.size();
    AppMethodBeat.o(192005);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "payloads", "", "", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void avR();
    
    public abstract void b(d paramd, int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends c.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(192000);
      AppMethodBeat.o(192000);
    }
    
    public final void avR() {}
    
    public final void b(final d paramd, final int paramInt)
    {
      AppMethodBeat.i(191999);
      p.h(paramd, "item");
      View localView = this.aus;
      p.g(localView, "itemView");
      localView.setSelected(paramd.uOQ);
      this.aus.setOnClickListener((View.OnClickListener)new a(this, paramd, paramInt));
      AppMethodBeat.o(191999);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.c paramc, d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(191998);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = c.a(this.GNU.GNT);
        if (paramView != null) {
          paramView.a(paramd, paramInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191998);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "", "onItemClick", "", "transitionInfo", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "plugin-vlog_release"})
  public static abstract interface d
  {
    public abstract void a(d paramd, int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "iconImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "transNameText", "Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"})
  public final class e
    extends c.a
  {
    private final WeImageView GNW;
    private final TextView GNX;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(192004);
      this$1 = localObject.findViewById(2131302130);
      p.g(c.this, "itemView.findViewById(R.id.gif_iv)");
      this.GNW = ((WeImageView)c.this);
      this$1 = localObject.findViewById(2131309397);
      p.g(c.this, "itemView.findViewById(R.id.transition_name_text)");
      this.GNX = ((TextView)c.this);
      AppMethodBeat.o(192004);
    }
    
    public final void avR()
    {
      AppMethodBeat.i(192003);
      View localView = this.aus;
      p.g(localView, "itemView");
      localView.setSelected(false);
      AppMethodBeat.o(192003);
    }
    
    public final void b(final d paramd, final int paramInt)
    {
      AppMethodBeat.i(192002);
      p.h(paramd, "item");
      Object localObject2 = this.GNX.getText();
      Object localObject1 = paramd.GNZ;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((a.a)localObject1).name;
        if ((p.j(localObject2, localObject1) ^ true))
        {
          localObject1 = this.GNW;
          localObject2 = this.GNW.getContext();
          a.a locala = paramd.GNZ;
          if (locala == null) {
            break label181;
          }
          i = locala.GAE;
          label82:
          ((WeImageView)localObject1).setImageDrawable(com.tencent.mm.cb.a.l((Context)localObject2, i));
          localObject2 = this.GNX;
          localObject1 = paramd.GNZ;
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
        localObject1 = this.aus;
        p.g(localObject1, "itemView");
        ((View)localObject1).setSelected(paramd.uOQ);
        this.aus.setOnClickListener((View.OnClickListener)new a(this, paramd, paramInt));
        AppMethodBeat.o(192002);
        return;
        localObject1 = null;
        break;
        i = -1;
        break label82;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.e parame, d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192001);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = c.a(this.GNY.GNT);
        if (paramView != null) {
          paramView.a(paramd, paramInt);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192001);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.c
 * JD-Core Version:    0.7.0.1
 */