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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "contentEndPos", "", "contentStartPos", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "trackThumbInfo", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onSliderTouchListener", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "getOnSliderTouchListener", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "setOnSliderTouchListener", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;)V", "selectedIndex", "trackList", "Ljava/util/LinkedList;", "clearFocus", "getItem", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "viewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "setSelection", "trackIndex", "update", "tracks", "", "BaseViewHolder", "EmptyViewHolder", "FrameViewHolder", "OnSliderTouchListener", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.a<a>
{
  private final LinkedList<h> Mbq;
  private final String TAG;
  private int UoY;
  private int UoZ;
  d Upa;
  private int dbk;
  
  public c()
  {
    AppMethodBeat.i(281609);
    this.TAG = "MicroMsg.EditFrameListAdapter";
    this.Mbq = new LinkedList();
    this.UoY = -1;
    this.UoZ = -1;
    this.dbk = -1;
    bf(true);
    AppMethodBeat.o(281609);
  }
  
  private void a(a parama, int paramInt)
  {
    AppMethodBeat.i(281616);
    s.u(parama, "viewHolder");
    Object localObject = this.Mbq.get(paramInt);
    s.s(localObject, "trackList[position]");
    parama.a((h)localObject);
    AppMethodBeat.o(281616);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(281652);
    int i = this.Mbq.size();
    AppMethodBeat.o(281652);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(281647);
    long l = ((h)this.Mbq.get(paramInt)).trackIndex;
    AppMethodBeat.o(281647);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(281659);
    if (((h)this.Mbq.get(paramInt)).isEmpty())
    {
      AppMethodBeat.o(281659);
      return 1;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(281659);
    return paramInt;
  }
  
  public final void hM(List<? extends h> paramList)
  {
    int j = -1;
    AppMethodBeat.i(281634);
    s.u(paramList, "tracks");
    this.Mbq.clear();
    this.Mbq.addAll((Collection)paramList);
    paramList = (List)this.Mbq;
    int i = 0;
    paramList = paramList.iterator();
    if (paramList.hasNext()) {
      if (!((h)paramList.next()).isEmpty()) {}
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
      } while (!((h)paramList.previous()).isEmpty());
      i = paramList.nextIndex();
      this.UoZ = (i - 1);
      AppMethodBeat.o(281634);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(281642);
    int i;
    int j;
    if (paramInt != this.dbk)
    {
      Iterator localIterator = ((List)this.Mbq).iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label163;
      }
      if (((h)localIterator.next()).trackIndex != this.dbk) {
        break label151;
      }
      j = 1;
      label62:
      if (j == 0) {
        break label156;
      }
      label66:
      if (i >= 0) {
        t(i, Boolean.FALSE);
      }
      localIterator = ((List)this.Mbq).iterator();
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
        t(i, Boolean.TRUE);
      }
      this.dbk = paramInt;
      AppMethodBeat.o(281642);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "onUpdateSelect", "select", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
    extends RecyclerView.v
  {
    public a(View paramView)
    {
      super();
    }
    
    public abstract void a(h paramh);
    
    public void aVM() {}
    
    public abstract void b(h paramh);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$EmptyViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;Landroid/view/View;)V", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUpdateSelect", "select", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends c.a
  {
    public b()
    {
      super();
      AppMethodBeat.i(281658);
      localObject.setOnClickListener(null);
      AppMethodBeat.o(281658);
    }
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(281666);
      s.u(paramh, "trackInfo");
      ViewGroup.LayoutParams localLayoutParams = this.caK.getLayoutParams();
      if (localLayoutParams == null)
      {
        paramh = new ViewGroup.LayoutParams(paramh.mWn, -1);
        this.caK.setLayoutParams(paramh);
        AppMethodBeat.o(281666);
        return;
      }
      if (localLayoutParams.width != paramh.mWn)
      {
        localLayoutParams.width = paramh.mWn;
        this.caK.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(281666);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(281673);
      s.u(paramh, "trackInfo");
      AppMethodBeat.o(281673);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$FrameViewHolder;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "parentHeight", "", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;Landroid/view/View;I)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListView;", "padding", "seekSlider", "Lcom/tencent/mm/plugin/mmsight/segment/EditSliderSeekBar;", "onBind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "onUnbind", "onUpdateSelect", "select", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends c.a
  {
    private final EditFrameListView Upc;
    private final EditSliderSeekBar Upd;
    private final int dqH;
    private final int padding;
    
    public c(int paramInt)
    {
      super();
      AppMethodBeat.i(281663);
      int i;
      this.dqH = i;
      this.padding = com.tencent.mm.cd.a.fromDPToPix(paramInt.getContext(), 8);
      this$1 = paramInt.findViewById(a.f.frame_list);
      s.s(c.this, "itemView.findViewById(R.id.frame_list)");
      this.Upc = ((EditFrameListView)c.this);
      this$1 = paramInt.findViewById(a.f.track_crop_slider_seek);
      s.s(c.this, "itemView.findViewById(R.id.track_crop_slider_seek)");
      this.Upd = ((EditSliderSeekBar)c.this);
      AppMethodBeat.o(281663);
    }
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(281692);
      s.u(paramh, "trackInfo");
      Object localObject = this.Upc;
      ((EditFrameListView)localObject).Upq = true;
      ((EditFrameListView)localObject).Upr = true;
      localObject = this.Upc;
      ((EditFrameListView)localObject).Ups = false;
      ((EditFrameListView)localObject).Upt = false;
      this.Upd.setMaskColor(1999383596);
      this.Upd.setEnableHapticAtEdge(true);
      this.Upc.a(paramh, this.dqH, true, true);
      this.Upd.setOnSliderTouchListener((EditSliderSeekBar.a)new a(paramh, this, c.this));
      if (paramh.trackIndex == c.b(c.this)) {
        this.Upd.aR(this.Upc.getShowWidth() - this.padding * 2, this.Upc.getMinWidth(), this.padding);
      }
      for (;;)
      {
        paramh = this.caK;
        localObject = this.caK.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.Upc.getValidWidth();
        ah localah = ah.aiuX;
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramh = this.Upd;
        localObject = this.Upd.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.Upc.getValidWidth();
        localah = ah.aiuX;
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramh = this.Upc;
        localObject = this.Upc.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.Upc.getValidWidth();
        localah = ah.aiuX;
        paramh.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(281692);
        return;
        this.Upd.gcN();
      }
    }
    
    public final void aVM()
    {
      AppMethodBeat.i(281702);
      EditFrameListView localEditFrameListView = this.Upc;
      com.tencent.mm.videocomposition.c localc = localEditFrameListView.FTn;
      if (localc != null) {
        localc.destroy();
      }
      localEditFrameListView.FTn = null;
      AppMethodBeat.o(281702);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(281696);
      s.u(paramh, "trackInfo");
      if (paramh.trackIndex == c.b(c.this))
      {
        int i = com.tencent.mm.cd.a.fromDPToPix(this.caK.getContext(), 8);
        if (this.Upc.getShowWidth() > 0)
        {
          this.Upd.aR(this.Upc.getShowWidth() - i * 2, this.Upc.getMinWidth(), i);
          AppMethodBeat.o(281696);
        }
      }
      else
      {
        this.Upd.gcN();
      }
      AppMethodBeat.o(281696);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$FrameViewHolder$onBind$1", "Lcom/tencent/mm/plugin/mmsight/segment/EditSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "rawX", "", "onUp", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements EditSliderSeekBar.a
    {
      a(h paramh, c.c paramc, c paramc1) {}
      
      public final void c(boolean paramBoolean, float paramFloat)
      {
        AppMethodBeat.i(281590);
        long l1;
        if (paramBoolean)
        {
          l1 = (c.c.c(jdField_this).getLeftSliderBound() / c.c.a(jdField_this).getFrameWidth() * (float)this.Upe.UoQ);
          if (!paramBoolean) {
            break label354;
          }
        }
        label354:
        for (long l2 = (c.c.c(jdField_this).getRightSliderBound() / c.c.a(jdField_this).getFrameWidth() * (float)this.Upe.UoQ);; l2 = this.Upe.UoP + (c.c.c(jdField_this).getRightSliderBound() / c.c.a(jdField_this).getFrameWidth() * (float)(this.Upe.getTotalDuration() - this.Upe.UoP)))
        {
          this.Upe.UoP = l1;
          this.Upe.UoQ = l2;
          Log.d(c.a(this.Upi), "onMove, frameStartMs:" + l1 + ", frameEndMs:" + l2 + ", leftSliderBound:" + c.c.c(jdField_this).getLeftSliderBound() + ", rightSliderBound:" + c.c.c(jdField_this).getRightSliderBound() + ", frameWidth:" + c.c.a(jdField_this).getFrameWidth());
          Object localObject1 = jdField_this.caK;
          ViewGroup.LayoutParams localLayoutParams = jdField_this.caK.getLayoutParams();
          Object localObject2 = jdField_this;
          int i = localLayoutParams.width;
          int j = c.c.a((c.c)localObject2).getValidWidth();
          localLayoutParams.width = c.c.a((c.c)localObject2).getValidWidth();
          localObject2 = ah.aiuX;
          ((View)localObject1).setLayoutParams(localLayoutParams);
          localObject1 = this.Upi.Upa;
          if (localObject1 != null) {
            ((c.d)localObject1).a(jdField_this.KJ(), i - j, paramBoolean, paramFloat);
          }
          AppMethodBeat.o(281590);
          return;
          l1 = this.Upe.UoP + (c.c.c(jdField_this).getLeftSliderBound() / c.c.a(jdField_this).getFrameWidth() * (float)(this.Upe.getTotalDuration() - this.Upe.UoP));
          break;
        }
      }
      
      public final void yx(boolean paramBoolean)
      {
        int i = 1;
        AppMethodBeat.i(281574);
        this.Upe.UoW = paramBoolean;
        Object localObject = this.Upe;
        boolean bool;
        int j;
        if (!paramBoolean)
        {
          bool = true;
          ((a)localObject).UoV = bool;
          c.c.a(jdField_this).a(this.Upe, c.c.b(jdField_this), this.Upg, this.Uph);
          c.c.c(jdField_this).aR(c.c.a(jdField_this).getShowWidth() - c.c.d(jdField_this) * 2, c.c.a(jdField_this).getMinWidth(), c.c.d(jdField_this));
          if (!paramBoolean) {
            break label430;
          }
          j = (int)((float)this.Upe.UoP / (float)this.Upe.getTotalDuration() * c.c.a(jdField_this).getTotalFrameWidth());
          c.c.c(jdField_this).b(true, j + c.c.d(jdField_this));
          c.c.c(jdField_this).b(false, c.c.d(jdField_this) + c.c.a(jdField_this).getFrameWidth());
          label199:
          localObject = c.c.c(jdField_this);
          ViewGroup.LayoutParams localLayoutParams = c.c.c(jdField_this).getLayoutParams();
          localLayoutParams.width = c.c.a(jdField_this).getShowWidth();
          ah localah = ah.aiuX;
          ((EditSliderSeekBar)localObject).setLayoutParams(localLayoutParams);
          localObject = jdField_this.caK;
          localLayoutParams = jdField_this.caK.getLayoutParams();
          localLayoutParams.width = c.c.a(jdField_this).getValidWidth();
          localah = ah.aiuX;
          ((View)localObject).setLayoutParams(localLayoutParams);
          localObject = c.c.a(jdField_this);
          localLayoutParams = c.c.a(jdField_this).getLayoutParams();
          localLayoutParams.width = c.c.a(jdField_this).getShowWidth();
          localah = ah.aiuX;
          ((EditFrameListView)localObject).setLayoutParams(localLayoutParams);
          localObject = jdField_this.caK;
          if (!paramBoolean) {
            break label506;
          }
        }
        for (;;)
        {
          ((View)localObject).setLayoutDirection(i);
          this.Upe.getTotalDuration();
          c.c.a(jdField_this).getTotalWidth();
          c.c.d(jdField_this);
          localObject = this.Upi.Upa;
          if (localObject != null) {
            ((c.d)localObject).ca(jdField_this.KJ(), paramBoolean);
          }
          AppMethodBeat.o(281574);
          return;
          bool = false;
          break;
          label430:
          j = (int)((float)this.Upe.hUo() / (float)this.Upe.getTotalDuration() * c.c.a(jdField_this).getTotalFrameWidth());
          c.c.c(jdField_this).b(true, c.c.d(jdField_this));
          c.c.c(jdField_this).b(false, j + c.c.d(jdField_this));
          break label199;
          label506:
          i = 0;
        }
      }
      
      public final void yy(boolean paramBoolean)
      {
        AppMethodBeat.i(281580);
        this.Upe.UoW = false;
        this.Upe.UoV = false;
        long l1;
        if (paramBoolean)
        {
          l1 = (c.c.c(jdField_this).getLeftSliderBound() / c.c.a(jdField_this).getFrameWidth() * (float)this.Upe.UoQ);
          if (!paramBoolean) {
            break label489;
          }
        }
        label489:
        for (long l2 = (c.c.c(jdField_this).getRightSliderBound() / c.c.a(jdField_this).getFrameWidth() * (float)this.Upe.UoQ);; l2 = this.Upe.UoP + (c.c.c(jdField_this).getRightSliderBound() / c.c.a(jdField_this).getFrameWidth() * (float)(this.Upe.getTotalDuration() - this.Upe.UoP)))
        {
          this.Upe.UoP = l1;
          this.Upe.UoQ = l2;
          Log.d(c.a(this.Upi), "onUp, frameStartMs:" + l1 + ", frameEndMs:" + l2);
          c.c.a(jdField_this).a(this.Upe, c.c.b(jdField_this), this.Upg, this.Uph);
          c.c.c(jdField_this).aR(c.c.a(jdField_this).getShowWidth() - c.c.d(jdField_this) * 2, c.c.a(jdField_this).getMinWidth(), c.c.d(jdField_this));
          Object localObject = c.c.c(jdField_this);
          ViewGroup.LayoutParams localLayoutParams = c.c.c(jdField_this).getLayoutParams();
          localLayoutParams.width = c.c.a(jdField_this).getValidWidth();
          ah localah = ah.aiuX;
          ((EditSliderSeekBar)localObject).setLayoutParams(localLayoutParams);
          localObject = jdField_this.caK;
          localLayoutParams = jdField_this.caK.getLayoutParams();
          localLayoutParams.width = c.c.a(jdField_this).getValidWidth();
          localah = ah.aiuX;
          ((View)localObject).setLayoutParams(localLayoutParams);
          localObject = c.c.a(jdField_this);
          localLayoutParams = c.c.a(jdField_this).getLayoutParams();
          localLayoutParams.width = c.c.a(jdField_this).getValidWidth();
          localah = ah.aiuX;
          ((EditFrameListView)localObject).setLayoutParams(localLayoutParams);
          jdField_this.caK.setLayoutDirection(0);
          this.Upe.getTotalDuration();
          c.c.a(jdField_this).getTotalFrameWidth();
          localObject = this.Upi.Upa;
          if (localObject != null) {
            ((c.d)localObject).cb(jdField_this.KJ(), paramBoolean);
          }
          AppMethodBeat.o(281580);
          return;
          l1 = this.Upe.UoP + (c.c.c(jdField_this).getLeftSliderBound() / c.c.a(jdField_this).getFrameWidth() * (float)(this.Upe.getTotalDuration() - this.Upe.UoP));
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "", "onDown", "", "position", "", "startAvailableSpace", "left", "", "onMove", "consumed", "rawX", "", "onUp", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat);
    
    public abstract void ca(int paramInt, boolean paramBoolean);
    
    public abstract void cb(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.c
 * JD-Core Version:    0.7.0.1
 */