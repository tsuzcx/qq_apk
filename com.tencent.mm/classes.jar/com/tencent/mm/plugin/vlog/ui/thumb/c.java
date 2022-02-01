package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar.a;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.d;
import com.tencent.mm.videocomposition.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onSliderTouchListener", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "getOnSliderTouchListener", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "setOnSliderTouchListener", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;)V", "selectedIndex", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "OnSliderTouchListener", "plugin-vlog_release"})
public final class c
  extends RecyclerView.a<a>
{
  private final LinkedList<h> GOJ;
  private int GOK;
  private int GOL;
  d GOM;
  private final String TAG;
  private int bxP;
  
  public c()
  {
    AppMethodBeat.i(192047);
    this.TAG = "MicroMsg.EditFrameListAdapter";
    this.GOJ = new LinkedList();
    this.GOK = -1;
    this.GOL = -1;
    this.bxP = -1;
    au(true);
    AppMethodBeat.o(192047);
  }
  
  private void a(a parama, int paramInt)
  {
    AppMethodBeat.i(192043);
    p.h(parama, "viewHolder");
    Object localObject = this.GOJ.get(paramInt);
    p.g(localObject, "trackList[position]");
    parama.a((h)localObject);
    AppMethodBeat.o(192043);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(192041);
    int i = this.GOJ.size();
    AppMethodBeat.o(192041);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(192039);
    long l = ((h)this.GOJ.get(paramInt)).trackIndex;
    AppMethodBeat.o(192039);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(192042);
    if (((h)this.GOJ.get(paramInt)).isEmpty())
    {
      AppMethodBeat.o(192042);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(192042);
    return paramInt;
  }
  
  public final void hw(List<h> paramList)
  {
    int j = -1;
    AppMethodBeat.i(192037);
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
      AppMethodBeat.o(192037);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(192038);
    int i;
    int j;
    if (paramInt != this.bxP)
    {
      Iterator localIterator = ((List)this.GOJ).iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label163;
      }
      if (((h)localIterator.next()).trackIndex != this.bxP) {
        break label151;
      }
      j = 1;
      label62:
      if (j == 0) {
        break label156;
      }
      label66:
      if (i >= 0) {
        b(i, Boolean.FALSE);
      }
      localIterator = ((List)this.GOJ).iterator();
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
        b(i, Boolean.TRUE);
      }
      this.bxP = paramInt;
      AppMethodBeat.o(192038);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "onUpdateSelect", "select", "", "plugin-vlog_release"})
  public static abstract class a
    extends RecyclerView.v
  {
    public a(View paramView)
    {
      super();
    }
    
    public abstract void a(h paramh);
    
    public void avR() {}
    
    public abstract void b(h paramh);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUpdateSelect", "select", "", "plugin-vlog_release"})
  public final class b
    extends c.a
  {
    public b()
    {
      super();
      AppMethodBeat.i(192029);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(192029);
    }
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(192027);
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
        AppMethodBeat.o(192027);
        return;
      }
      if (((ViewGroup.LayoutParams)localObject).width != paramh.hEp)
      {
        ((ViewGroup.LayoutParams)localObject).width = paramh.hEp;
        paramh = this.aus;
        p.g(paramh, "itemView");
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(192027);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(192028);
      p.h(paramh, "trackInfo");
      AppMethodBeat.o(192028);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "parentHeight", "", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;Landroid/view/View;I)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView;", "padding", "seekSlider", "Lcom/tencent/mm/plugin/mmsight/segment/EditSliderSeekBar;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "onUpdateSelect", "select", "", "plugin-vlog_release"})
  public final class c
    extends c.a
  {
    private final EditFrameListView GOO;
    private final EditSliderSeekBar GOP;
    private final int oh;
    private final int padding;
    
    public c(int paramInt)
    {
      super();
      AppMethodBeat.i(192036);
      int i;
      this.oh = i;
      this.padding = com.tencent.mm.cb.a.fromDPToPix(paramInt.getContext(), 8);
      this$1 = paramInt.findViewById(2131301718);
      p.g(c.this, "itemView.findViewById(R.id.frame_list)");
      this.GOO = ((EditFrameListView)c.this);
      this$1 = paramInt.findViewById(2131309377);
      p.g(c.this, "itemView.findViewById(R.id.track_crop_slider_seek)");
      this.GOP = ((EditSliderSeekBar)c.this);
      AppMethodBeat.o(192036);
    }
    
    public final void a(final h paramh)
    {
      AppMethodBeat.i(192033);
      p.h(paramh, "trackInfo");
      Object localObject = this.GOO;
      ((EditFrameListView)localObject).GPa = true;
      ((EditFrameListView)localObject).GPb = true;
      localObject = this.GOO;
      ((EditFrameListView)localObject).GPc = false;
      ((EditFrameListView)localObject).GPd = false;
      this.GOP.setMaskColor(1999383596);
      this.GOP.setEnableHapticAtEdge(true);
      this.GOO.a(paramh, this.oh, true, true);
      this.GOP.setOnSliderTouchListener((EditSliderSeekBar.a)new a(this, paramh));
      if (paramh.trackIndex == c.b(c.this)) {
        this.GOP.ao(this.GOO.getShowWidth() - this.padding * 2, this.GOO.getMinWidth(), this.padding);
      }
      for (;;)
      {
        paramh = this.aus;
        p.g(paramh, "itemView");
        localObject = this.aus;
        p.g(localObject, "itemView");
        localObject = ((View)localObject).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.GOO.getValidWidth();
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramh = this.GOP;
        localObject = this.GOP.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.GOO.getValidWidth();
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramh = this.GOO;
        localObject = this.GOO.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.GOO.getValidWidth();
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(192033);
        return;
        this.GOP.ekn();
      }
    }
    
    public final void avR()
    {
      AppMethodBeat.i(192035);
      EditFrameListView localEditFrameListView = this.GOO;
      g localg = localEditFrameListView.vNj;
      if (localg != null) {
        localg.destroy();
      }
      localEditFrameListView.vNj = null;
      AppMethodBeat.o(192035);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(192034);
      p.h(paramh, "trackInfo");
      if (paramh.trackIndex == c.b(c.this))
      {
        paramh = this.aus;
        p.g(paramh, "itemView");
        int i = com.tencent.mm.cb.a.fromDPToPix(paramh.getContext(), 8);
        if (this.GOO.getShowWidth() > 0)
        {
          this.GOP.ao(this.GOO.getShowWidth() - i * 2, this.GOO.getMinWidth(), i);
          AppMethodBeat.o(192034);
        }
      }
      else
      {
        this.GOP.ekn();
      }
      AppMethodBeat.o(192034);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$FrameViewHolder$onBind$1", "Lcom/tencent/mm/plugin/mmsight/segment/EditSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "rawX", "", "onUp", "plugin-vlog_release"})
    public static final class a
      implements EditSliderSeekBar.a
    {
      a(h paramh, boolean paramBoolean) {}
      
      public final void c(boolean paramBoolean, float paramFloat)
      {
        AppMethodBeat.i(192032);
        long l1;
        if (paramBoolean)
        {
          l1 = (c.c.c(this.GOQ).getLeftSliderBound() / c.c.a(this.GOQ).getFrameWidth() * (float)paramh.GOE);
          if (!paramBoolean) {
            break label377;
          }
        }
        label377:
        for (long l2 = (c.c.c(this.GOQ).getRightSliderBound() / c.c.a(this.GOQ).getFrameWidth() * (float)paramh.GOE);; l2 = paramh.GOD + (c.c.c(this.GOQ).getRightSliderBound() / c.c.a(this.GOQ).getFrameWidth() * (float)(paramh.GQc.GzA.GJB - paramh.GOD)))
        {
          paramh.GOD = l1;
          paramh.GOE = l2;
          Log.d(c.a(this.GOQ.GON), "onMove, frameStartMs:" + l1 + ", frameEndMs:" + l2 + ", leftSliderBound:" + c.c.c(this.GOQ).getLeftSliderBound() + ", rightSliderBound:" + c.c.c(this.GOQ).getRightSliderBound() + ", frameWidth:" + c.c.a(this.GOQ).getFrameWidth());
          Object localObject1 = this.GOQ.aus;
          p.g(localObject1, "itemView");
          Object localObject2 = this.GOQ.aus;
          p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getLayoutParams();
          int i = ((ViewGroup.LayoutParams)localObject2).width;
          int j = c.c.a(this.GOQ).getValidWidth();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.GOQ).getValidWidth();
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.GOQ.GON.GOM;
          if (localObject1 == null) {
            break label437;
          }
          ((c.d)localObject1).a(this.GOQ.lR(), i - j, paramBoolean, paramFloat);
          AppMethodBeat.o(192032);
          return;
          l1 = paramh.GOD + (c.c.c(this.GOQ).getLeftSliderBound() / c.c.a(this.GOQ).getFrameWidth() * (float)(paramh.GQc.GzA.GJB - paramh.GOD));
          break;
        }
        label437:
        AppMethodBeat.o(192032);
      }
      
      public final void rf(boolean paramBoolean)
      {
        int i = 1;
        AppMethodBeat.i(192030);
        paramh.GQb = paramBoolean;
        Object localObject1 = paramh;
        boolean bool;
        int j;
        if (!paramBoolean)
        {
          bool = true;
          ((h)localObject1).GQa = bool;
          c.c.a(this.GOQ).a(paramh, c.c.b(this.GOQ), this.GOS, this.GOT);
          c.c.c(this.GOQ).ao(c.c.a(this.GOQ).getShowWidth() - c.c.d(this.GOQ) * 2, c.c.a(this.GOQ).getMinWidth(), c.c.d(this.GOQ));
          if (!paramBoolean) {
            break label441;
          }
          j = (int)((float)paramh.GOD / (float)paramh.GQc.GzA.GJB * c.c.a(this.GOQ).getTotalFrameWidth());
          c.c.c(this.GOQ).b(true, j + c.c.d(this.GOQ));
          c.c.c(this.GOQ).b(false, c.c.d(this.GOQ) + c.c.a(this.GOQ).getFrameWidth());
          label205:
          localObject1 = c.c.c(this.GOQ);
          Object localObject2 = c.c.c(this.GOQ).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.GOQ).getShowWidth();
          ((EditSliderSeekBar)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.GOQ.aus;
          p.g(localObject1, "itemView");
          localObject2 = this.GOQ.aus;
          p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.GOQ).getValidWidth();
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = c.c.a(this.GOQ);
          localObject2 = c.c.a(this.GOQ).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.GOQ).getShowWidth();
          ((EditFrameListView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.GOQ.aus;
          p.g(localObject1, "itemView");
          if (!paramBoolean) {
            break label523;
          }
        }
        for (;;)
        {
          ((View)localObject1).setLayoutDirection(i);
          c.c.a(this.GOQ).getTotalWidth();
          c.c.d(this.GOQ);
          localObject1 = this.GOQ.GON.GOM;
          if (localObject1 == null) {
            break label528;
          }
          ((c.d)localObject1).bf(this.GOQ.lR(), paramBoolean);
          AppMethodBeat.o(192030);
          return;
          bool = false;
          break;
          label441:
          j = (int)((float)paramh.fEu() / (float)paramh.GQc.GzA.GJB * c.c.a(this.GOQ).getTotalFrameWidth());
          c.c.c(this.GOQ).b(true, c.c.d(this.GOQ));
          c.c.c(this.GOQ).b(false, j + c.c.d(this.GOQ));
          break label205;
          label523:
          i = 0;
        }
        label528:
        AppMethodBeat.o(192030);
      }
      
      public final void rg(boolean paramBoolean)
      {
        AppMethodBeat.i(192031);
        paramh.GQb = false;
        paramh.GQa = false;
        long l1;
        if (paramBoolean)
        {
          l1 = (c.c.c(this.GOQ).getLeftSliderBound() / c.c.a(this.GOQ).getFrameWidth() * (float)paramh.GOE);
          if (!paramBoolean) {
            break label507;
          }
        }
        label507:
        for (long l2 = (c.c.c(this.GOQ).getRightSliderBound() / c.c.a(this.GOQ).getFrameWidth() * (float)paramh.GOE);; l2 = paramh.GOD + (c.c.c(this.GOQ).getRightSliderBound() / c.c.a(this.GOQ).getFrameWidth() * (float)(paramh.GQc.GzA.GJB - paramh.GOD)))
        {
          paramh.GOD = l1;
          paramh.GOE = l2;
          Log.d(c.a(this.GOQ.GON), "onUp, frameStartMs:" + l1 + ", frameEndMs:" + l2);
          c.c.a(this.GOQ).a(paramh, c.c.b(this.GOQ), this.GOS, this.GOT);
          c.c.c(this.GOQ).ao(c.c.a(this.GOQ).getShowWidth() - c.c.d(this.GOQ) * 2, c.c.a(this.GOQ).getMinWidth(), c.c.d(this.GOQ));
          Object localObject1 = c.c.c(this.GOQ);
          Object localObject2 = c.c.c(this.GOQ).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.GOQ).getValidWidth();
          ((EditSliderSeekBar)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.GOQ.aus;
          p.g(localObject1, "itemView");
          localObject2 = this.GOQ.aus;
          p.g(localObject2, "itemView");
          localObject2 = ((View)localObject2).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.GOQ).getValidWidth();
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = c.c.a(this.GOQ);
          localObject2 = c.c.a(this.GOQ).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = c.c.a(this.GOQ).getValidWidth();
          ((EditFrameListView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = this.GOQ.aus;
          p.g(localObject1, "itemView");
          ((View)localObject1).setLayoutDirection(0);
          c.c.a(this.GOQ).getTotalFrameWidth();
          localObject1 = this.GOQ.GON.GOM;
          if (localObject1 == null) {
            break label567;
          }
          ((c.d)localObject1).bg(this.GOQ.lR(), paramBoolean);
          AppMethodBeat.o(192031);
          return;
          l1 = paramh.GOD + (c.c.c(this.GOQ).getLeftSliderBound() / c.c.a(this.GOQ).getFrameWidth() * (float)(paramh.GQc.GzA.GJB - paramh.GOD));
          break;
        }
        label567:
        AppMethodBeat.o(192031);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "", "onDown", "", "position", "", "startAvailableSpace", "left", "", "onMove", "consumed", "rawX", "", "onUp", "plugin-vlog_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat);
    
    public abstract void bf(int paramInt, boolean paramBoolean);
    
    public abstract void bg(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.c
 * JD-Core Version:    0.7.0.1
 */