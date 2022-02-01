package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "()V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "trackList", "Ljava/util/LinkedList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "plugin-vlog_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final LinkedList<d> Lvc;
  public m<? super Integer, ? super d, y> oOb;
  
  public b()
  {
    AppMethodBeat.i(201226);
    this.Lvc = new LinkedList();
    AppMethodBeat.o(201226);
  }
  
  public final d aii(int paramInt)
  {
    AppMethodBeat.i(201220);
    Object localObject = this.Lvc.get(paramInt);
    k.g(localObject, "trackList[position]");
    localObject = (d)localObject;
    AppMethodBeat.o(201220);
    return localObject;
  }
  
  public final void fX(List<d> paramList)
  {
    AppMethodBeat.i(201219);
    k.h(paramList, "tracks");
    this.Lvc.clear();
    this.Lvc.addAll((Collection)paramList);
    AppMethodBeat.o(201219);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(201222);
    int i = this.Lvc.size();
    AppMethodBeat.o(201222);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(201223);
    if (((d)this.Lvc.get(paramInt)).LvO.size() == 0)
    {
      AppMethodBeat.o(201223);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(201223);
    return paramInt;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void a(d paramd);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "plugin-vlog_release"})
  public final class b
    extends b.a
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(201215);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(201215);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(201214);
      k.h(paramd, "trackInfo");
      Object localObject = this.arI;
      k.g(localObject, "itemView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramd = new ViewGroup.LayoutParams(paramd.guK, -1);
        localObject = this.arI;
        k.g(localObject, "itemView");
        ((View)localObject).setLayoutParams(paramd);
        AppMethodBeat.o(201214);
        return;
      }
      if (((ViewGroup.LayoutParams)localObject).width != paramd.guK)
      {
        ((ViewGroup.LayoutParams)localObject).width = paramd.guK;
        paramd = this.arI;
        k.g(paramd, "itemView");
        paramd.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(201214);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends b.a
  {
    private final FrameListView Lve;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(201218);
      this$1 = localObject.findViewById(2131307383);
      k.g(b.this, "itemView.findViewById(R.id.frame_list)");
      this.Lve = ((FrameListView)b.this);
      AppMethodBeat.o(201218);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(201217);
      k.h(paramd, "trackInfo");
      this.Lve.setTrackInfo(paramd);
      this.arI.setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(201217);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(b.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201216);
        paramView = this.Lvf.Lvd.oOb;
        if (paramView != null)
        {
          int i = this.Lvf.ln();
          Object localObject = b.a(this.Lvf.Lvd).get(this.Lvf.ln());
          k.g(localObject, "trackList[adapterPosition]");
          paramView.n(Integer.valueOf(i), localObject);
          AppMethodBeat.o(201216);
          return;
        }
        AppMethodBeat.o(201216);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.b
 * JD-Core Version:    0.7.0.1
 */