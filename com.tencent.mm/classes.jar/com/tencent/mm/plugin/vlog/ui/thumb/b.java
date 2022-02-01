package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "()V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "trackList", "Ljava/util/LinkedList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "plugin-vlog_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final LinkedList<d> AuM;
  public m<? super Integer, ? super d, y> prv;
  
  public b()
  {
    AppMethodBeat.i(207911);
    this.AuM = new LinkedList();
    AppMethodBeat.o(207911);
  }
  
  public final d RS(int paramInt)
  {
    AppMethodBeat.i(207905);
    Object localObject = this.AuM.get(paramInt);
    k.g(localObject, "trackList[position]");
    localObject = (d)localObject;
    AppMethodBeat.o(207905);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(207907);
    int i = this.AuM.size();
    AppMethodBeat.o(207907);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(207908);
    if (((d)this.AuM.get(paramInt)).AvB.size() == 0)
    {
      AppMethodBeat.o(207908);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(207908);
    return paramInt;
  }
  
  public final void gf(List<d> paramList)
  {
    AppMethodBeat.i(207904);
    k.h(paramList, "tracks");
    this.AuM.clear();
    this.AuM.addAll((Collection)paramList);
    AppMethodBeat.o(207904);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void a(d paramd);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "plugin-vlog_release"})
  public final class b
    extends b.a
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(207900);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(207900);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(207899);
      k.h(paramd, "trackInfo");
      Object localObject = this.asD;
      k.g(localObject, "itemView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramd = new ViewGroup.LayoutParams(paramd.grV, -1);
        localObject = this.asD;
        k.g(localObject, "itemView");
        ((View)localObject).setLayoutParams(paramd);
        AppMethodBeat.o(207899);
        return;
      }
      if (((ViewGroup.LayoutParams)localObject).width != paramd.grV)
      {
        ((ViewGroup.LayoutParams)localObject).width = paramd.grV;
        paramd = this.asD;
        k.g(paramd, "itemView");
        paramd.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(207899);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends b.a
  {
    private final FrameListView AuO;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(207903);
      this$1 = localObject.findViewById(2131307452);
      k.g(b.this, "itemView.findViewById(R.id.frame_list)");
      this.AuO = ((FrameListView)b.this);
      AppMethodBeat.o(207903);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(207902);
      k.h(paramd, "trackInfo");
      this.AuO.setTrackInfo(paramd);
      this.asD.setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(207902);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(b.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(207901);
        paramView = this.AuP.AuN.prv;
        if (paramView != null)
        {
          int i = this.AuP.lv();
          Object localObject = b.a(this.AuP.AuN).get(this.AuP.lv());
          k.g(localObject, "trackList[adapterPosition]");
          paramView.n(Integer.valueOf(i), localObject);
          AppMethodBeat.o(207901);
          return;
        }
        AppMethodBeat.o(207901);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.b
 * JD-Core Version:    0.7.0.1
 */