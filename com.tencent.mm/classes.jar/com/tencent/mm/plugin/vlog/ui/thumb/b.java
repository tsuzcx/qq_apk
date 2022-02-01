package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "inTimeCropMode", "", "getInTimeCropMode", "()Z", "setInTimeCropMode", "(Z)V", "itemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "plugin-vlog_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final LinkedList<c> BTY;
  private int BTZ;
  private int BUa;
  public boolean BUb;
  private final String TAG;
  private int bxN;
  public m<? super Integer, ? super c, z> pVb;
  
  public b()
  {
    AppMethodBeat.i(196833);
    this.TAG = "MicroMsg.FrameListAdapter";
    this.BTY = new LinkedList();
    this.BTZ = -1;
    this.BUa = -1;
    this.bxN = -1;
    AppMethodBeat.o(196833);
  }
  
  public final c TK(int paramInt)
  {
    AppMethodBeat.i(196827);
    Object localObject = this.BTY.get(paramInt);
    p.g(localObject, "trackList[position]");
    localObject = (c)localObject;
    AppMethodBeat.o(196827);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(196829);
    int i = this.BTY.size();
    AppMethodBeat.o(196829);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(196830);
    if (((c)this.BTY.get(paramInt)).isEmpty())
    {
      AppMethodBeat.o(196830);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(196830);
    return paramInt;
  }
  
  public final void gq(List<c> paramList)
  {
    int j = -1;
    AppMethodBeat.i(196825);
    p.h(paramList, "tracks");
    this.BTY.clear();
    this.BTY.addAll((Collection)paramList);
    paramList = (List)this.BTY;
    int i = 0;
    paramList = paramList.iterator();
    if (paramList.hasNext()) {
      if (!((c)paramList.next()).isEmpty()) {}
    }
    for (;;)
    {
      this.BTZ = (i + 1);
      paramList = (List)this.BTY;
      paramList = paramList.listIterator(paramList.size());
      do
      {
        i = j;
        if (!paramList.hasPrevious()) {
          break;
        }
      } while (!((c)paramList.previous()).isEmpty());
      i = paramList.nextIndex();
      this.BUa = (i - 1);
      AppMethodBeat.o(196825);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(196826);
    Iterator localIterator;
    int i;
    if (paramInt != this.bxN)
    {
      localIterator = ((List)this.BTY).iterator();
      if (localIterator.hasNext())
      {
        if (((c)localIterator.next()).trackIndex != this.bxN) {
          break label119;
        }
        i = 1;
        label56:
        if (i == 0) {
          break label122;
        }
      }
      localIterator = ((List)this.BTY).iterator();
    }
    label119:
    label122:
    label124:
    label127:
    for (;;)
    {
      if (localIterator.hasNext()) {
        if (((c)localIterator.next()).trackIndex != paramInt) {
          break label124;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label127;
        }
        this.bxN = paramInt;
        notifyDataSetChanged();
        AppMethodBeat.o(196826);
        return;
        i = 0;
        break label56;
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void a(c paramc);
    
    public void afP() {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "plugin-vlog_release"})
  public final class b
    extends b.a
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(196820);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(196820);
    }
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(196819);
      p.h(paramc, "trackInfo");
      Object localObject = this.auu;
      p.g(localObject, "itemView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramc = new ViewGroup.LayoutParams(paramc.gLD, -1);
        localObject = this.auu;
        p.g(localObject, "itemView");
        ((View)localObject).setLayoutParams(paramc);
        AppMethodBeat.o(196819);
        return;
      }
      if (((ViewGroup.LayoutParams)localObject).width != paramc.gLD)
      {
        ((ViewGroup.LayoutParams)localObject).width = paramc.gLD;
        paramc = this.auu;
        p.g(paramc, "itemView");
        paramc.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(196819);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends b.a
  {
    private final FrameListView BUd;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(196824);
      this$1 = localObject.findViewById(2131307452);
      p.g(b.this, "itemView.findViewById(R.id.frame_list)");
      this.BUd = ((FrameListView)b.this);
      AppMethodBeat.o(196824);
    }
    
    public final void a(c paramc)
    {
      boolean bool2 = true;
      AppMethodBeat.i(196822);
      p.h(paramc, "trackInfo");
      boolean bool1;
      label55:
      Object localObject;
      if (b.this.BUb) {
        if (lN() != b.a(b.this))
        {
          bool1 = true;
          if (lN() == b.b(b.this)) {
            break label210;
          }
          bool2 = true;
          this.BUd.as(true, true);
          this.BUd.at(bool1, bool2);
          this.BUd.setTrackInfo(paramc);
          localObject = this.auu;
          p.g(localObject, "itemView");
          ((View)localObject).setBackground(null);
          localObject = this.auu;
          p.g(localObject, "itemView");
          ((View)localObject).setVisibility(0);
          if (b.c(b.this) >= 0)
          {
            if (paramc.trackIndex != b.c(b.this)) {
              break label280;
            }
            paramc = this.auu;
            p.g(paramc, "itemView");
            localObject = this.auu;
            p.g(localObject, "itemView");
            paramc.setBackground(com.tencent.mm.cc.a.l(((View)localObject).getContext(), 2131235082));
          }
        }
      }
      for (;;)
      {
        this.auu.setOnClickListener((View.OnClickListener)new a(this));
        AppMethodBeat.o(196822);
        return;
        bool1 = false;
        break;
        label210:
        bool2 = false;
        break label55;
        localObject = this.BUd;
        if (lN() == b.a(b.this))
        {
          bool1 = true;
          label237:
          if (lN() != b.b(b.this)) {
            break label275;
          }
        }
        for (;;)
        {
          ((FrameListView)localObject).as(bool1, bool2);
          this.BUd.at(false, false);
          break;
          bool1 = false;
          break label237;
          label275:
          bool2 = false;
        }
        label280:
        paramc = this.auu;
        p.g(paramc, "itemView");
        paramc.setVisibility(4);
      }
    }
    
    public final void afP()
    {
      AppMethodBeat.i(196823);
      this.BUd.release();
      AppMethodBeat.o(196823);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(b.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(196821);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramView = this.BUe.BUc.pVb;
        if (paramView != null)
        {
          int i = this.BUe.lN();
          localObject = b.d(this.BUe.BUc).get(this.BUe.lN());
          p.g(localObject, "trackList[adapterPosition]");
          paramView.p(Integer.valueOf(i), localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196821);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.b
 * JD-Core Version:    0.7.0.1
 */