package com.tencent.mm.plugin.vlog.ui.thumb;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.a.e;
import com.tencent.mm.plugin.vlog.a.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "inTimeCropMode", "", "getInTimeCropMode", "()Z", "setInTimeCropMode", "(Z)V", "itemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "trackThumbInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "getThumbFetcherFactory", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "setThumbFetcherFactory", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;)V", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "plugin-vlog_release"})
public final class f
  extends RecyclerView.a<a>
{
  private final LinkedList<a> Ggf;
  public g GhV;
  public boolean NCV;
  private int NCs;
  private int NCt;
  private final String TAG;
  private int bhr;
  public m<? super Integer, ? super a, x> uYj;
  
  public f()
  {
    AppMethodBeat.i(234968);
    this.TAG = "MicroMsg.FrameListAdapter";
    this.Ggf = new LinkedList();
    this.NCs = -1;
    this.NCt = -1;
    this.bhr = -1;
    AppMethodBeat.o(234968);
  }
  
  public final a akt(int paramInt)
  {
    AppMethodBeat.i(234959);
    Object localObject = this.Ggf.get(paramInt);
    p.j(localObject, "trackList[position]");
    localObject = (a)localObject;
    AppMethodBeat.o(234959);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(234962);
    int i = this.Ggf.size();
    AppMethodBeat.o(234962);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(234964);
    if (((a)this.Ggf.get(paramInt)).isEmpty())
    {
      AppMethodBeat.o(234964);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(234964);
    return paramInt;
  }
  
  public final void gg(List<? extends a> paramList)
  {
    int j = -1;
    AppMethodBeat.i(234956);
    p.k(paramList, "tracks");
    this.Ggf.clear();
    this.Ggf.addAll((Collection)paramList);
    paramList = (List)this.Ggf;
    int i = 0;
    paramList = paramList.iterator();
    if (paramList.hasNext()) {
      if (!((a)paramList.next()).isEmpty()) {}
    }
    for (;;)
    {
      this.NCs = (i + 1);
      paramList = (List)this.Ggf;
      paramList = paramList.listIterator(paramList.size());
      do
      {
        i = j;
        if (!paramList.hasPrevious()) {
          break;
        }
      } while (!((a)paramList.previous()).isEmpty());
      i = paramList.nextIndex();
      this.NCt = (i - 1);
      AppMethodBeat.o(234956);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(234958);
    Iterator localIterator;
    int i;
    if (paramInt != this.bhr)
    {
      localIterator = ((List)this.Ggf).iterator();
      if (localIterator.hasNext())
      {
        if (((a)localIterator.next()).trackIndex != this.bhr) {
          break label119;
        }
        i = 1;
        label56:
        if (i == 0) {
          break label122;
        }
      }
      localIterator = ((List)this.Ggf).iterator();
    }
    label119:
    label122:
    label124:
    label127:
    for (;;)
    {
      if (localIterator.hasNext()) {
        if (((a)localIterator.next()).trackIndex != paramInt) {
          break label124;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label127;
        }
        this.bhr = paramInt;
        notifyDataSetChanged();
        AppMethodBeat.o(234958);
        return;
        i = 0;
        break label56;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public void aCO() {}
    
    public abstract void b(a parama);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "plugin-vlog_release"})
  public final class b
    extends f.a
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(246475);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(246475);
    }
    
    public final void b(a parama)
    {
      AppMethodBeat.i(246474);
      p.k(parama, "trackInfo");
      Object localObject = this.amk;
      p.j(localObject, "itemView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        parama = new ViewGroup.LayoutParams(parama.ksu, -1);
        localObject = this.amk;
        p.j(localObject, "itemView");
        ((View)localObject).setLayoutParams(parama);
        AppMethodBeat.o(246474);
        return;
      }
      if (((ViewGroup.LayoutParams)localObject).width != parama.ksu)
      {
        ((ViewGroup.LayoutParams)localObject).width = parama.ksu;
        parama = this.amk;
        p.j(parama, "itemView");
        parama.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(246474);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "onUnbind", "plugin-vlog_release"})
  public final class c
    extends f.a
  {
    private final FrameListView GlO;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(227907);
      this$1 = localObject.findViewById(a.f.frame_list);
      p.j(f.this, "itemView.findViewById(R.id.frame_list)");
      this.GlO = ((FrameListView)f.this);
      AppMethodBeat.o(227907);
    }
    
    public final void aCO()
    {
      AppMethodBeat.i(227904);
      this.GlO.release();
      AppMethodBeat.o(227904);
    }
    
    public final void b(a parama)
    {
      boolean bool2 = true;
      AppMethodBeat.i(227902);
      p.k(parama, "trackInfo");
      boolean bool1;
      label55:
      Object localObject;
      if (f.this.NCV) {
        if (md() != f.a(f.this))
        {
          bool1 = true;
          if (md() == f.b(f.this)) {
            break label234;
          }
          bool2 = true;
          this.GlO.aO(true, true);
          this.GlO.aP(bool1, bool2);
          localObject = f.this.GhV;
          if (localObject != null) {
            this.GlO.setThumbFetcherFactory((g)localObject);
          }
          this.GlO.setTrackInfo(parama);
          localObject = this.amk;
          p.j(localObject, "itemView");
          ((View)localObject).setBackground(null);
          localObject = this.amk;
          p.j(localObject, "itemView");
          ((View)localObject).setVisibility(0);
          if (f.c(f.this) >= 0)
          {
            if (parama.trackIndex != f.c(f.this)) {
              break label304;
            }
            parama = this.amk;
            p.j(parama, "itemView");
            localObject = this.amk;
            p.j(localObject, "itemView");
            parama.setBackground(com.tencent.mm.ci.a.m(((View)localObject).getContext(), a.e.vlog_single_track_selected));
          }
        }
      }
      for (;;)
      {
        this.amk.setOnClickListener((View.OnClickListener)new a(this));
        AppMethodBeat.o(227902);
        return;
        bool1 = false;
        break;
        label234:
        bool2 = false;
        break label55;
        localObject = this.GlO;
        if (md() == f.a(f.this))
        {
          bool1 = true;
          label261:
          if (md() != f.b(f.this)) {
            break label299;
          }
        }
        for (;;)
        {
          ((FrameListView)localObject).aO(bool1, bool2);
          this.GlO.aP(false, false);
          break;
          bool1 = false;
          break label261;
          label299:
          bool2 = false;
        }
        label304:
        parama = this.amk;
        p.j(parama, "itemView");
        parama.setVisibility(4);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(f.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(238194);
        Object localObject = new b();
        ((b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramView = this.NCX.NCW.uYj;
        if (paramView != null)
        {
          int i = this.NCX.md();
          localObject = f.d(this.NCX.NCW).get(this.NCX.md());
          p.j(localObject, "trackList[adapterPosition]");
          paramView.invoke(Integer.valueOf(i), localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238194);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.f
 * JD-Core Version:    0.7.0.1
 */