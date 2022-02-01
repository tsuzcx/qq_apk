package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "inTimeCropMode", "", "getInTimeCropMode", "()Z", "setInTimeCropMode", "(Z)V", "itemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "plugin-vlog_release"})
public final class f
  extends RecyclerView.a<a>
{
  private final LinkedList<h> GOJ;
  private int GOK;
  private int GOL;
  public boolean GPp;
  private final String TAG;
  private int bxP;
  public m<? super Integer, ? super h, x> rsD;
  
  public f()
  {
    AppMethodBeat.i(192080);
    this.TAG = "MicroMsg.FrameListAdapter";
    this.GOJ = new LinkedList();
    this.GOK = -1;
    this.GOL = -1;
    this.bxP = -1;
    AppMethodBeat.o(192080);
  }
  
  public final h acK(int paramInt)
  {
    AppMethodBeat.i(192074);
    Object localObject = this.GOJ.get(paramInt);
    p.g(localObject, "trackList[position]");
    localObject = (h)localObject;
    AppMethodBeat.o(192074);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(192076);
    int i = this.GOJ.size();
    AppMethodBeat.o(192076);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(192077);
    if (((h)this.GOJ.get(paramInt)).isEmpty())
    {
      AppMethodBeat.o(192077);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(192077);
    return paramInt;
  }
  
  public final void hw(List<h> paramList)
  {
    int j = -1;
    AppMethodBeat.i(192072);
    p.h(paramList, "tracks");
    this.GOJ.clear();
    this.GOJ.addAll((Collection)paramList);
    paramList = (List)this.GOJ;
    int i = 0;
    paramList = paramList.iterator();
    if (paramList.hasNext()) {
      if (!((h)paramList.next()).isEmpty()) {}
    }
    for (;;)
    {
      this.GOK = (i + 1);
      paramList = (List)this.GOJ;
      paramList = paramList.listIterator(paramList.size());
      do
      {
        i = j;
        if (!paramList.hasPrevious()) {
          break;
        }
      } while (!((h)paramList.previous()).isEmpty());
      i = paramList.nextIndex();
      this.GOL = (i - 1);
      AppMethodBeat.o(192072);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(192073);
    Iterator localIterator;
    int i;
    if (paramInt != this.bxP)
    {
      localIterator = ((List)this.GOJ).iterator();
      if (localIterator.hasNext())
      {
        if (((h)localIterator.next()).trackIndex != this.bxP) {
          break label119;
        }
        i = 1;
        label56:
        if (i == 0) {
          break label122;
        }
      }
      localIterator = ((List)this.GOJ).iterator();
    }
    label119:
    label122:
    label124:
    label127:
    for (;;)
    {
      if (localIterator.hasNext()) {
        if (((h)localIterator.next()).trackIndex != paramInt) {
          break label124;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label127;
        }
        this.bxP = paramInt;
        notifyDataSetChanged();
        AppMethodBeat.o(192073);
        return;
        i = 0;
        break label56;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public abstract void a(h paramh);
    
    public void avR() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "plugin-vlog_release"})
  public final class b
    extends f.a
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(192067);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(192067);
    }
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(192066);
      p.h(paramh, "trackInfo");
      Object localObject = this.aus;
      p.g(localObject, "itemView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramh = new ViewGroup.LayoutParams(paramh.hEp, -1);
        localObject = this.aus;
        p.g(localObject, "itemView");
        ((View)localObject).setLayoutParams(paramh);
        AppMethodBeat.o(192066);
        return;
      }
      if (((ViewGroup.LayoutParams)localObject).width != paramh.hEp)
      {
        ((ViewGroup.LayoutParams)localObject).width = paramh.hEp;
        paramh = this.aus;
        p.g(paramh, "itemView");
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(192066);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends f.a
  {
    private final FrameListView Avq;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(192071);
      this$1 = localObject.findViewById(2131301718);
      p.g(f.this, "itemView.findViewById(R.id.frame_list)");
      this.Avq = ((FrameListView)f.this);
      AppMethodBeat.o(192071);
    }
    
    public final void a(h paramh)
    {
      boolean bool2 = true;
      AppMethodBeat.i(192069);
      p.h(paramh, "trackInfo");
      boolean bool1;
      label55:
      Object localObject;
      if (f.this.GPp) {
        if (lR() != f.a(f.this))
        {
          bool1 = true;
          if (lR() == f.b(f.this)) {
            break label213;
          }
          bool2 = true;
          this.Avq.aC(true, true);
          this.Avq.aD(bool1, bool2);
          this.Avq.setTrackInfo((a)paramh);
          localObject = this.aus;
          p.g(localObject, "itemView");
          ((View)localObject).setBackground(null);
          localObject = this.aus;
          p.g(localObject, "itemView");
          ((View)localObject).setVisibility(0);
          if (f.c(f.this) >= 0)
          {
            if (paramh.trackIndex != f.c(f.this)) {
              break label283;
            }
            paramh = this.aus;
            p.g(paramh, "itemView");
            localObject = this.aus;
            p.g(localObject, "itemView");
            paramh.setBackground(com.tencent.mm.cb.a.l(((View)localObject).getContext(), 2131235432));
          }
        }
      }
      for (;;)
      {
        this.aus.setOnClickListener((View.OnClickListener)new a(this));
        AppMethodBeat.o(192069);
        return;
        bool1 = false;
        break;
        label213:
        bool2 = false;
        break label55;
        localObject = this.Avq;
        if (lR() == f.a(f.this))
        {
          bool1 = true;
          label240:
          if (lR() != f.b(f.this)) {
            break label278;
          }
        }
        for (;;)
        {
          ((FrameListView)localObject).aC(bool1, bool2);
          this.Avq.aD(false, false);
          break;
          bool1 = false;
          break label240;
          label278:
          bool2 = false;
        }
        label283:
        paramh = this.aus;
        p.g(paramh, "itemView");
        paramh.setVisibility(4);
      }
    }
    
    public final void avR()
    {
      AppMethodBeat.i(192070);
      this.Avq.release();
      AppMethodBeat.o(192070);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192068);
        Object localObject = new b();
        ((b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramView = this.GPr.GPq.rsD;
        if (paramView != null)
        {
          int i = this.GPr.lR();
          localObject = f.d(this.GPr.GPq).get(this.GPr.lR());
          p.g(localObject, "trackList[adapterPosition]");
          paramView.invoke(Integer.valueOf(i), localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192068);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.f
 * JD-Core Version:    0.7.0.1
 */