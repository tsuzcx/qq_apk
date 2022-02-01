package com.tencent.mm.plugin.vlog.ui.thumb;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "inTimeCropMode", "", "getInTimeCropMode", "()Z", "setInTimeCropMode", "(Z)V", "itemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "trackThumbInfo", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "getThumbFetcherFactory", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "setThumbFetcherFactory", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;)V", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends RecyclerView.a<a>
{
  private final LinkedList<a> Mbq;
  public g Mdf;
  private final String TAG;
  private int UoY;
  private int UoZ;
  public boolean UpA;
  private int dbk;
  public m<? super Integer, ? super a, ah> ykx;
  
  public f()
  {
    AppMethodBeat.i(281614);
    this.TAG = "MicroMsg.FrameListAdapter";
    this.Mbq = new LinkedList();
    this.UoY = -1;
    this.UoZ = -1;
    this.dbk = -1;
    AppMethodBeat.o(281614);
  }
  
  public final a apO(int paramInt)
  {
    AppMethodBeat.i(281657);
    Object localObject = this.Mbq.get(paramInt);
    s.s(localObject, "trackList[position]");
    localObject = (a)localObject;
    AppMethodBeat.o(281657);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(281664);
    int i = this.Mbq.size();
    AppMethodBeat.o(281664);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(281670);
    if (((a)this.Mbq.get(paramInt)).isEmpty())
    {
      AppMethodBeat.o(281670);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(281670);
    return paramInt;
  }
  
  public final void hM(List<? extends a> paramList)
  {
    int j = -1;
    AppMethodBeat.i(281643);
    s.u(paramList, "tracks");
    this.Mbq.clear();
    this.Mbq.addAll((Collection)paramList);
    paramList = (List)this.Mbq;
    int i = 0;
    paramList = paramList.iterator();
    if (paramList.hasNext()) {
      if (!((a)paramList.next()).isEmpty()) {}
    }
    for (;;)
    {
      this.UoY = (i + 1);
      paramList = (List)this.Mbq;
      paramList = paramList.listIterator(paramList.size());
      do
      {
        i = j;
        if (!paramList.hasPrevious()) {
          break;
        }
      } while (!((a)paramList.previous()).isEmpty());
      i = paramList.nextIndex();
      this.UoZ = (i - 1);
      AppMethodBeat.o(281643);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(281649);
    Iterator localIterator;
    int i;
    if (paramInt != this.dbk)
    {
      localIterator = ((List)this.Mbq).iterator();
      if (localIterator.hasNext())
      {
        if (((a)localIterator.next()).trackIndex != this.dbk) {
          break label124;
        }
        i = 1;
        label57:
        if (i == 0) {
          break label127;
        }
      }
      localIterator = ((List)this.Mbq).iterator();
    }
    label129:
    label132:
    for (;;)
    {
      if (localIterator.hasNext()) {
        if (((a)localIterator.next()).trackIndex != paramInt) {
          break label129;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label132;
        }
        this.dbk = paramInt;
        this.bZE.notifyChanged();
        AppMethodBeat.o(281649);
        return;
        label124:
        i = 0;
        break label57;
        label127:
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "onUnbind", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
    }
    
    public void aVM() {}
    
    public abstract void c(a parama);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends f.a
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(281697);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(281697);
    }
    
    public final void c(a parama)
    {
      AppMethodBeat.i(281704);
      s.u(parama, "trackInfo");
      ViewGroup.LayoutParams localLayoutParams = this.caK.getLayoutParams();
      if (localLayoutParams == null)
      {
        parama = new ViewGroup.LayoutParams(parama.mWn, -1);
        this.caK.setLayoutParams(parama);
        AppMethodBeat.o(281704);
        return;
      }
      if (localLayoutParams.width != parama.mWn)
      {
        localLayoutParams.width = parama.mWn;
        this.caK.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(281704);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;Landroid/view/View;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "onUnbind", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends f.a
  {
    private final FrameListView Mgn;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(281699);
      this$1 = localObject.findViewById(a.f.frame_list);
      s.s(f.this, "itemView.findViewById(R.id.frame_list)");
      this.Mgn = ((FrameListView)f.this);
      AppMethodBeat.o(281699);
    }
    
    private static final void a(f paramf, c paramc, View paramView)
    {
      AppMethodBeat.i(281706);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramf);
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramf, "this$0");
      s.u(paramc, "this$1");
      paramView = paramf.ykx;
      if (paramView != null)
      {
        int i = paramc.KJ();
        paramf = f.d(paramf).get(paramc.KJ());
        s.s(paramf, "trackList[adapterPosition]");
        paramView.invoke(Integer.valueOf(i), paramf);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter$FrameViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281706);
    }
    
    public final void aVM()
    {
      AppMethodBeat.i(281728);
      this.Mgn.release();
      AppMethodBeat.o(281728);
    }
    
    public final void c(a parama)
    {
      boolean bool2 = true;
      AppMethodBeat.i(281723);
      s.u(parama, "trackInfo");
      boolean bool1;
      label55:
      Object localObject;
      if (f.this.UpA) {
        if (KJ() != f.a(f.this))
        {
          bool1 = true;
          if (KJ() == f.b(f.this)) {
            break label194;
          }
          bool2 = true;
          this.Mgn.bl(true, true);
          this.Mgn.bm(bool1, bool2);
          localObject = f.this.Mdf;
          if (localObject != null) {
            this.Mgn.setThumbFetcherFactory((g)localObject);
          }
          this.Mgn.setTrackInfo(parama);
          this.caK.setBackground(null);
          this.caK.setVisibility(0);
          if (f.c(f.this) >= 0)
          {
            if (parama.trackIndex != f.c(f.this)) {
              break label264;
            }
            this.caK.setBackground(com.tencent.mm.cd.a.m(this.caK.getContext(), a.e.vlog_single_track_selected));
          }
        }
      }
      for (;;)
      {
        this.caK.setOnClickListener(new f.c..ExternalSyntheticLambda0(f.this, this));
        AppMethodBeat.o(281723);
        return;
        bool1 = false;
        break;
        label194:
        bool2 = false;
        break label55;
        localObject = this.Mgn;
        if (KJ() == f.a(f.this))
        {
          bool1 = true;
          label221:
          if (KJ() != f.b(f.this)) {
            break label259;
          }
        }
        for (;;)
        {
          ((FrameListView)localObject).bl(bool1, bool2);
          this.Mgn.bm(false, false);
          break;
          bool1 = false;
          break label221;
          label259:
          bool2 = false;
        }
        label264:
        this.caK.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.f
 * JD-Core Version:    0.7.0.1
 */