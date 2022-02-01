package com.tencent.mm.plugin.vlog.ui.thumb;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar.a;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onSliderTouchListener", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "getOnSliderTouchListener", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "setOnSliderTouchListener", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;)V", "selectedIndex", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "OnSliderTouchListener", "plugin-vlog_release"})
public final class c
  extends RecyclerView.a<a>
{
  private final LinkedList<h> Ggf;
  private int NCs;
  private int NCt;
  d NCu;
  private final String TAG;
  private int bhr;
  
  public c()
  {
    AppMethodBeat.i(224179);
    this.TAG = "MicroMsg.EditFrameListAdapter";
    this.Ggf = new LinkedList();
    this.NCs = -1;
    this.NCt = -1;
    this.bhr = -1;
    aw(true);
    AppMethodBeat.o(224179);
  }
  
  private void a(a parama, int paramInt)
  {
    AppMethodBeat.i(224166);
    p.k(parama, "viewHolder");
    Object localObject = this.Ggf.get(paramInt);
    p.j(localObject, "trackList[position]");
    parama.a((h)localObject);
    AppMethodBeat.o(224166);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(224159);
    int i = this.Ggf.size();
    AppMethodBeat.o(224159);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(224152);
    long l = ((h)this.Ggf.get(paramInt)).trackIndex;
    AppMethodBeat.o(224152);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(224162);
    if (((h)this.Ggf.get(paramInt)).isEmpty())
    {
      AppMethodBeat.o(224162);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(224162);
    return paramInt;
  }
  
  public final void gg(List<? extends h> paramList)
  {
    int j = -1;
    AppMethodBeat.i(224136);
    p.k(paramList, "tracks");
    this.Ggf.clear();
    this.Ggf.addAll((Collection)paramList);
    paramList = (List)this.Ggf;
    int i = 0;
    paramList = paramList.iterator();
    if (paramList.hasNext()) {
      if (!((h)paramList.next()).isEmpty()) {}
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
      } while (!((h)paramList.previous()).isEmpty());
      i = paramList.nextIndex();
      this.NCt = (i - 1);
      AppMethodBeat.o(224136);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(224149);
    int i;
    int j;
    if (paramInt != this.bhr)
    {
      Iterator localIterator = ((List)this.Ggf).iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label163;
      }
      if (((h)localIterator.next()).trackIndex != this.bhr) {
        break label151;
      }
      j = 1;
      label62:
      if (j == 0) {
        break label156;
      }
      label66:
      if (i >= 0) {
        d(i, Boolean.FALSE);
      }
      localIterator = ((List)this.Ggf).iterator();
      i = 0;
      label94:
      if (!localIterator.hasNext()) {
        break label180;
      }
      if (((h)localIterator.next()).trackIndex != paramInt) {
        break label168;
      }
      j = 1;
      label123:
      if (j == 0) {
        break label173;
      }
    }
    for (;;)
    {
      if (i >= 0) {
        d(i, Boolean.TRUE);
      }
      this.bhr = paramInt;
      AppMethodBeat.o(224149);
      return;
      label151:
      j = 0;
      break label62;
      label156:
      i += 1;
      break;
      label163:
      i = -1;
      break label66;
      label168:
      j = 0;
      break label123;
      label173:
      i += 1;
      break label94;
      label180:
      i = -1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "onUpdateSelect", "select", "", "plugin-vlog_release"})
  public static abstract class a
    extends RecyclerView.v
  {
    public a(View paramView)
    {
      super();
    }
    
    public abstract void a(h paramh);
    
    public void aCO() {}
    
    public abstract void b(h paramh);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUpdateSelect", "select", "", "plugin-vlog_release"})
  public final class b
    extends c.a
  {
    public b()
    {
      super();
      AppMethodBeat.i(227035);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(227035);
    }
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(227031);
      p.k(paramh, "trackInfo");
      Object localObject = this.amk;
      p.j(localObject, "itemView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramh = new ViewGroup.LayoutParams(paramh.ksu, -1);
        localObject = this.amk;
        p.j(localObject, "itemView");
        ((View)localObject).setLayoutParams(paramh);
        AppMethodBeat.o(227031);
        return;
      }
      if (((ViewGroup.LayoutParams)localObject).width != paramh.ksu)
      {
        ((ViewGroup.LayoutParams)localObject).width = paramh.ksu;
        paramh = this.amk;
        p.j(paramh, "itemView");
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(227031);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(227033);
      p.k(paramh, "trackInfo");
      AppMethodBeat.o(227033);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "parentHeight", "", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;Landroid/view/View;I)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView;", "padding", "seekSlider", "Lcom/tencent/mm/plugin/mmsight/segment/EditSliderSeekBar;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "onUpdateSelect", "select", "", "plugin-vlog_release"})
  public final class c
    extends c.a
  {
    private final EditFrameListView NCw;
    private final EditSliderSeekBar NCx;
    private final int bxE;
    private final int padding;
    
    public c(int paramInt)
    {
      super();
      AppMethodBeat.i(232667);
      int i;
      this.bxE = i;
      this.padding = com.tencent.mm.ci.a.fromDPToPix(paramInt.getContext(), 8);
      this$1 = paramInt.findViewById(a.f.frame_list);
      p.j(c.this, "itemView.findViewById(R.id.frame_list)");
      this.NCw = ((EditFrameListView)c.this);
      this$1 = paramInt.findViewById(a.f.track_crop_slider_seek);
      p.j(c.this, "itemView.findViewById(R.id.track_crop_slider_seek)");
      this.NCx = ((EditSliderSeekBar)c.this);
      AppMethodBeat.o(232667);
    }
    
    public final void a(final h paramh)
    {
      AppMethodBeat.i(232654);
      p.k(paramh, "trackInfo");
      Object localObject = this.NCw;
      ((EditFrameListView)localObject).NCI = true;
      ((EditFrameListView)localObject).NCJ = true;
      localObject = this.NCw;
      ((EditFrameListView)localObject).NCK = false;
      ((EditFrameListView)localObject).NCL = false;
      this.NCx.setMaskColor(1999383596);
      this.NCx.setEnableHapticAtEdge(true);
      this.NCw.a(paramh, this.bxE, true, true);
      this.NCx.setOnSliderTouchListener((EditSliderSeekBar.a)new a(this, paramh));
      if (paramh.trackIndex == c.b(c.this)) {
        this.NCx.at(this.NCw.getShowWidth() - this.padding * 2, this.NCw.getMinWidth(), this.padding);
      }
      for (;;)
      {
        paramh = this.amk;
        p.j(paramh, "itemView");
        localObject = this.amk;
        p.j(localObject, "itemView");
        localObject = ((View)localObject).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.NCw.getValidWidth();
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramh = this.NCx;
        localObject = this.NCx.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.NCw.getValidWidth();
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramh = this.NCw;
        localObject = this.NCw.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.NCw.getValidWidth();
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(232654);
        return;
        this.NCx.eTV();
      }
    }
    
    public final void aCO()
    {
      AppMethodBeat.i(232662);
      EditFrameListView localEditFrameListView = this.NCw;
      com.tencent.mm.videocomposition.c localc = localEditFrameListView.Aub;
      if (localc != null) {
        localc.destroy();
      }
      localEditFrameListView.Aub = null;
      AppMethodBeat.o(232662);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(232658);
      p.k(paramh, "trackInfo");
      if (paramh.trackIndex == c.b(c.this))
      {
        paramh = this.amk;
        p.j(paramh, "itemView");
        int i = com.tencent.mm.ci.a.fromDPToPix(paramh.getContext(), 8);
        if (this.NCw.getShowWidth() > 0)
        {
          this.NCx.at(this.NCw.getShowWidth() - i * 2, this.NCw.getMinWidth(), i);
          AppMethodBeat.o(232658);
        }
      }
      else
      {
        this.NCx.eTV();
      }
      AppMethodBeat.o(232658);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$FrameViewHolder$onBind$1", "Lcom/tencent/mm/plugin/mmsight/segment/EditSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "rawX", "", "onUp", "plugin-vlog_release"})
    public static final class a
      implements EditSliderSeekBar.a
    {
      a(h paramh) {}
      
      public final void c(boolean paramBoolean, float paramFloat)
      {
        AppMethodBeat.i(245747);
        long l1;
        if (paramBoolean)
        {
          l1 = (c.c.c(this.NCy).getLeftSliderBound() / c.c.a(this.NCy).getFrameWidth() * (float)paramh.NCk);
          if (!paramBoolean) {
            break label371;
          }
        }
        label371:
        for (long l2 = (c.c.c(this.NCy).getRightSliderBound() / c.c.a(this.NCy).getFrameWidth() * (float)paramh.NCk);; l2 = paramh.NCj + (c.c.c(this.NCy).getRightSliderBound() / c.c.a(this.NCy).getFrameWidth() * (float)(paramh.getTotalDuration() - paramh.NCj)))
        {
          paramh.NCj = l1;
          paramh.NCk = l2;
          Log.d(c.a(this.NCy.NCv), "onMove, frameStartMs:" + l1 + ", frameEndMs:" + l2 + ", leftSliderBound:" + c.c.c(this.NCy).getLeftSliderBound() + ", rightSliderBound:" + c.c.c(this.NCy).getRightSliderBound() + ", frameWidth:" + c.c.a(this.NCy).getFrameWidth());
          Object localObject1 = this.NCy.amk;
          p.j(localObject1, "itemView");
          Object localObject2 = this.NCy.amk;
          p.j(localObject2, "itemView");
          localObject2 = ((View)localObject2).getLayoutParams();
          int i = ((ViewGroup.LayoutParams)localObject2).width;
          int j = c.c.a(this.NCy).getValidWidth();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.NCy).getValidWidth();
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.NCy.NCv.NCu;
          if (localObject1 == null) {
            break label425;
          }
          ((c.d)localObject1).a(this.NCy.md(), i - j, paramBoolean, paramFloat);
          AppMethodBeat.o(245747);
          return;
          l1 = paramh.NCj + (c.c.c(this.NCy).getLeftSliderBound() / c.c.a(this.NCy).getFrameWidth() * (float)(paramh.getTotalDuration() - paramh.NCj));
          break;
        }
        label425:
        AppMethodBeat.o(245747);
      }
      
      public final void uj(boolean paramBoolean)
      {
        int i = 1;
        AppMethodBeat.i(245742);
        paramh.NCq = paramBoolean;
        Object localObject1 = paramh;
        boolean bool;
        int j;
        if (!paramBoolean)
        {
          bool = true;
          ((a)localObject1).NCp = bool;
          c.c.a(this.NCy).a(paramh, c.c.b(this.NCy), this.NCA, this.NCB);
          c.c.c(this.NCy).at(c.c.a(this.NCy).getShowWidth() - c.c.d(this.NCy) * 2, c.c.a(this.NCy).getMinWidth(), c.c.d(this.NCy));
          if (!paramBoolean) {
            break label443;
          }
          j = (int)((float)paramh.NCj / (float)paramh.getTotalDuration() * c.c.a(this.NCy).getTotalFrameWidth());
          c.c.c(this.NCy).b(true, j + c.c.d(this.NCy));
          c.c.c(this.NCy).b(false, c.c.d(this.NCy) + c.c.a(this.NCy).getFrameWidth());
          label199:
          localObject1 = c.c.c(this.NCy);
          Object localObject2 = c.c.c(this.NCy).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.NCy).getShowWidth();
          ((EditSliderSeekBar)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.NCy.amk;
          p.j(localObject1, "itemView");
          localObject2 = this.NCy.amk;
          p.j(localObject2, "itemView");
          localObject2 = ((View)localObject2).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.NCy).getValidWidth();
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = c.c.a(this.NCy);
          localObject2 = c.c.a(this.NCy).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.NCy).getShowWidth();
          ((EditFrameListView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.NCy.amk;
          p.j(localObject1, "itemView");
          if (!paramBoolean) {
            break label519;
          }
        }
        for (;;)
        {
          ((View)localObject1).setLayoutDirection(i);
          paramh.getTotalDuration();
          c.c.a(this.NCy).getTotalWidth();
          c.c.d(this.NCy);
          localObject1 = this.NCy.NCv.NCu;
          if (localObject1 == null) {
            break label524;
          }
          ((c.d)localObject1).bs(this.NCy.md(), paramBoolean);
          AppMethodBeat.o(245742);
          return;
          bool = false;
          break;
          label443:
          j = (int)((float)paramh.gwv() / (float)paramh.getTotalDuration() * c.c.a(this.NCy).getTotalFrameWidth());
          c.c.c(this.NCy).b(true, c.c.d(this.NCy));
          c.c.c(this.NCy).b(false, j + c.c.d(this.NCy));
          break label199;
          label519:
          i = 0;
        }
        label524:
        AppMethodBeat.o(245742);
      }
      
      public final void uk(boolean paramBoolean)
      {
        AppMethodBeat.i(245744);
        paramh.NCq = false;
        paramh.NCp = false;
        long l1;
        if (paramBoolean)
        {
          l1 = (c.c.c(this.NCy).getLeftSliderBound() / c.c.a(this.NCy).getFrameWidth() * (float)paramh.NCk);
          if (!paramBoolean) {
            break label509;
          }
        }
        label509:
        for (long l2 = (c.c.c(this.NCy).getRightSliderBound() / c.c.a(this.NCy).getFrameWidth() * (float)paramh.NCk);; l2 = paramh.NCj + (c.c.c(this.NCy).getRightSliderBound() / c.c.a(this.NCy).getFrameWidth() * (float)(paramh.getTotalDuration() - paramh.NCj)))
        {
          paramh.NCj = l1;
          paramh.NCk = l2;
          Log.d(c.a(this.NCy.NCv), "onUp, frameStartMs:" + l1 + ", frameEndMs:" + l2);
          c.c.a(this.NCy).a(paramh, c.c.b(this.NCy), this.NCA, this.NCB);
          c.c.c(this.NCy).at(c.c.a(this.NCy).getShowWidth() - c.c.d(this.NCy) * 2, c.c.a(this.NCy).getMinWidth(), c.c.d(this.NCy));
          Object localObject1 = c.c.c(this.NCy);
          Object localObject2 = c.c.c(this.NCy).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.NCy).getValidWidth();
          ((EditSliderSeekBar)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.NCy.amk;
          p.j(localObject1, "itemView");
          localObject2 = this.NCy.amk;
          p.j(localObject2, "itemView");
          localObject2 = ((View)localObject2).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.NCy).getValidWidth();
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = c.c.a(this.NCy);
          localObject2 = c.c.a(this.NCy).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.NCy).getValidWidth();
          ((EditFrameListView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.NCy.amk;
          p.j(localObject1, "itemView");
          ((View)localObject1).setLayoutDirection(0);
          paramh.getTotalDuration();
          c.c.a(this.NCy).getTotalFrameWidth();
          localObject1 = this.NCy.NCv.NCu;
          if (localObject1 == null) {
            break label563;
          }
          ((c.d)localObject1).bt(this.NCy.md(), paramBoolean);
          AppMethodBeat.o(245744);
          return;
          l1 = paramh.NCj + (c.c.c(this.NCy).getLeftSliderBound() / c.c.a(this.NCy).getFrameWidth() * (float)(paramh.getTotalDuration() - paramh.NCj));
          break;
        }
        label563:
        AppMethodBeat.o(245744);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "", "onDown", "", "position", "", "startAvailableSpace", "left", "", "onMove", "consumed", "rawX", "", "onUp", "plugin-vlog_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat);
    
    public abstract void bs(int paramInt, boolean paramBoolean);
    
    public abstract void bt(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.c
 * JD-Core Version:    0.7.0.1
 */