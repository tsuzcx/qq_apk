package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "transitionList", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "(Ljava/util/List;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "getTransitionList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setOnItemClickListener", "listener", "BaseViewHolder", "Companion", "NoneViewHolder", "OnItemClickListener", "TransitionViewHolder", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.a<a>
{
  public static final b Uoi;
  private final List<d> Uoj;
  d Uok;
  
  static
  {
    AppMethodBeat.i(282881);
    Uoi = new b((byte)0);
    AppMethodBeat.o(282881);
  }
  
  public c(List<d> paramList)
  {
    AppMethodBeat.i(282871);
    this.Uoj = paramList;
    AppMethodBeat.o(282871);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(282886);
    int i = this.Uoj.size();
    AppMethodBeat.o(282886);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "payloads", "", "", "onUnbind", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void aVM();
    
    public abstract void b(d paramd, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends c.a
  {
    public c()
    {
      super(localObject);
      AppMethodBeat.i(282856);
      AppMethodBeat.o(282856);
    }
    
    private static final void a(c paramc, d paramd, int paramInt, View paramView)
    {
      AppMethodBeat.i(282868);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramc);
      localb.cH(paramd);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      s.u(paramd, "$item");
      paramc = c.a(paramc);
      if (paramc != null) {
        paramc.a(paramd, paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$NoneViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282868);
    }
    
    public final void aVM() {}
    
    public final void b(d paramd, int paramInt)
    {
      AppMethodBeat.i(282883);
      s.u(paramd, "item");
      this.caK.setSelected(paramd.Bvd);
      this.caK.setOnClickListener(new c.c..ExternalSyntheticLambda0(c.this, paramd, paramInt));
      AppMethodBeat.o(282883);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$OnItemClickListener;", "", "onItemClick", "", "transitionInfo", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(d paramd, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;Landroid/view/View;)V", "iconImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "transNameText", "Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "position", "", "onUnbind", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends c.a
  {
    private final WeImageView Uom;
    private final TextView Uon;
    
    public e()
    {
      super(localObject);
      AppMethodBeat.i(282854);
      this$1 = localObject.findViewById(a.f.gif_iv);
      s.s(c.this, "itemView.findViewById(R.id.gif_iv)");
      this.Uom = ((WeImageView)c.this);
      this$1 = localObject.findViewById(a.f.transition_name_text);
      s.s(c.this, "itemView.findViewById(R.id.transition_name_text)");
      this.Uon = ((TextView)c.this);
      AppMethodBeat.o(282854);
    }
    
    private static final void a(c paramc, d paramd, int paramInt, View paramView)
    {
      AppMethodBeat.i(282858);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramc);
      localb.cH(paramd);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      s.u(paramd, "$item");
      paramc = c.a(paramc);
      if (paramc != null) {
        paramc.a(paramd, paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter$TransitionViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282858);
    }
    
    public final void aVM()
    {
      AppMethodBeat.i(282875);
      this.caK.setSelected(false);
      AppMethodBeat.o(282875);
    }
    
    public final void b(d paramd, int paramInt)
    {
      AppMethodBeat.i(282870);
      s.u(paramd, "item");
      Object localObject2 = this.Uon.getText();
      Object localObject1 = paramd.Uoo;
      a.a locala;
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!s.p(localObject2, localObject1))
        {
          localObject1 = this.Uom;
          localObject2 = this.Uom.getContext();
          locala = paramd.Uoo;
          if (locala != null) {
            break label160;
          }
          i = -1;
          label72:
          ((WeImageView)localObject1).setImageDrawable(com.tencent.mm.cd.a.m((Context)localObject2, i));
          localObject2 = this.Uon;
          localObject1 = paramd.Uoo;
          if (localObject1 != null) {
            break label169;
          }
        }
      }
      label160:
      label169:
      for (localObject1 = null;; localObject1 = ((a.a)localObject1).name)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.caK.setSelected(paramd.Bvd);
        this.caK.setOnClickListener(new c.e..ExternalSyntheticLambda0(c.this, paramd, paramInt));
        AppMethodBeat.o(282870);
        return;
        localObject1 = ((a.a)localObject1).name;
        break;
        i = locala.UbR;
        break label72;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.c
 * JD-Core Version:    0.7.0.1
 */