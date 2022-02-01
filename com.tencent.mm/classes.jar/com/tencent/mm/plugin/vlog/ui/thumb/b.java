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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "inTimeCropMode", "", "getInTimeCropMode", "()Z", "setInTimeCropMode", "(Z)V", "itemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "plugin-vlog_release"})
public final class b
  extends RecyclerView.a<a>
{
  private int ClA;
  private int ClB;
  public boolean ClC;
  private final LinkedList<c> Clz;
  private final String TAG;
  private int bxN;
  public m<? super Integer, ? super c, z> qbG;
  
  public b()
  {
    AppMethodBeat.i(192296);
    this.TAG = "MicroMsg.FrameListAdapter";
    this.Clz = new LinkedList();
    this.ClA = -1;
    this.ClB = -1;
    this.bxN = -1;
    AppMethodBeat.o(192296);
  }
  
  public final c Ur(int paramInt)
  {
    AppMethodBeat.i(192290);
    Object localObject = this.Clz.get(paramInt);
    p.g(localObject, "trackList[position]");
    localObject = (c)localObject;
    AppMethodBeat.o(192290);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(192292);
    int i = this.Clz.size();
    AppMethodBeat.o(192292);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(192293);
    if (((c)this.Clz.get(paramInt)).isEmpty())
    {
      AppMethodBeat.o(192293);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(192293);
    return paramInt;
  }
  
  public final void gz(List<c> paramList)
  {
    int j = -1;
    AppMethodBeat.i(192288);
    p.h(paramList, "tracks");
    this.Clz.clear();
    this.Clz.addAll((Collection)paramList);
    paramList = (List)this.Clz;
    int i = 0;
    paramList = paramList.iterator();
    if (paramList.hasNext()) {
      if (!((c)paramList.next()).isEmpty()) {}
    }
    for (;;)
    {
      this.ClA = (i + 1);
      paramList = (List)this.Clz;
      paramList = paramList.listIterator(paramList.size());
      do
      {
        i = j;
        if (!paramList.hasPrevious()) {
          break;
        }
      } while (!((c)paramList.previous()).isEmpty());
      i = paramList.nextIndex();
      this.ClB = (i - 1);
      AppMethodBeat.o(192288);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(192289);
    Iterator localIterator;
    int i;
    if (paramInt != this.bxN)
    {
      localIterator = ((List)this.Clz).iterator();
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
      localIterator = ((List)this.Clz).iterator();
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
        AppMethodBeat.o(192289);
        return;
        i = 0;
        break label56;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.w
  {
    public a()
    {
      super();
    }
    
    public abstract void a(c paramc);
    
    public void agd() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "plugin-vlog_release"})
  public final class b
    extends b.a
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(192283);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(192283);
    }
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(192282);
      p.h(paramc, "trackInfo");
      Object localObject = this.auu;
      p.g(localObject, "itemView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramc = new ViewGroup.LayoutParams(paramc.gOm, -1);
        localObject = this.auu;
        p.g(localObject, "itemView");
        ((View)localObject).setLayoutParams(paramc);
        AppMethodBeat.o(192282);
        return;
      }
      if (((ViewGroup.LayoutParams)localObject).width != paramc.gOm)
      {
        ((ViewGroup.LayoutParams)localObject).width = paramc.gOm;
        paramc = this.auu;
        p.g(paramc, "itemView");
        paramc.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(192282);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends b.a
  {
    private final FrameListView ClE;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(192287);
      this$1 = localObject.findViewById(2131307452);
      p.g(b.this, "itemView.findViewById(R.id.frame_list)");
      this.ClE = ((FrameListView)b.this);
      AppMethodBeat.o(192287);
    }
    
    public final void a(c paramc)
    {
      boolean bool2 = true;
      AppMethodBeat.i(192285);
      p.h(paramc, "trackInfo");
      boolean bool1;
      label55:
      Object localObject;
      if (b.this.ClC) {
        if (lN() != b.a(b.this))
        {
          bool1 = true;
          if (lN() == b.b(b.this)) {
            break label210;
          }
          bool2 = true;
          this.ClE.ar(true, true);
          this.ClE.as(bool1, bool2);
          this.ClE.setTrackInfo(paramc);
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
            paramc.setBackground(com.tencent.mm.cb.a.l(((View)localObject).getContext(), 2131235082));
          }
        }
      }
      for (;;)
      {
        this.auu.setOnClickListener((View.OnClickListener)new a(this));
        AppMethodBeat.o(192285);
        return;
        bool1 = false;
        break;
        label210:
        bool2 = false;
        break label55;
        localObject = this.ClE;
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
          ((FrameListView)localObject).ar(bool1, bool2);
          this.ClE.as(false, false);
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
    
    public final void agd()
    {
      AppMethodBeat.i(192286);
      this.ClE.release();
      AppMethodBeat.o(192286);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(b.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192284);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramView = this.ClF.ClD.qbG;
        if (paramView != null)
        {
          int i = this.ClF.lN();
          localObject = b.d(this.ClF.ClD).get(this.ClF.lN());
          p.g(localObject, "trackList[adapterPosition]");
          paramView.p(Integer.valueOf(i), localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192284);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.b
 * JD-Core Version:    0.7.0.1
 */