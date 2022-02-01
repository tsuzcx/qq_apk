package com.tencent.mm.plugin.mv.ui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.c.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$Callback;", "provider", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$Provider;", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$Callback;Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$Provider;)V", "updateSliderProgress", "Lkotlin/Function1;", "", "", "getUpdateSliderProgress", "()Lkotlin/jvm/functions/Function1;", "setUpdateSliderProgress", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "getItemViewType", "position", "indexToPosition", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "positionToIndex", "tracksCount", "Callback", "Companion", "FillingViewHolder", "Provider", "SpacingViewHolder", "TrackViewHolder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.a<RecyclerView.v>
{
  public static final c.b MkD;
  private final a MkE;
  final d MkF;
  public kotlin.g.a.b<? super Long, ah> MkG;
  
  static
  {
    AppMethodBeat.i(286723);
    MkD = new c.b((byte)0);
    AppMethodBeat.o(286723);
  }
  
  public c(a parama, d paramd)
  {
    AppMethodBeat.i(286693);
    this.MkE = parama;
    this.MkF = paramd;
    AppMethodBeat.o(286693);
  }
  
  public static int aeo(int paramInt)
  {
    return paramInt - 1;
  }
  
  public static int aep(int paramInt)
  {
    return paramInt + 1;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(286735);
    s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    case 2: 
    default: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.f.LVy, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new f(paramViewGroup);
      AppMethodBeat.o(286735);
      return paramViewGroup;
    case 1: 
    case 3: 
      paramViewGroup = (RecyclerView.v)new c.e(paramViewGroup);
      AppMethodBeat.o(286735);
      return paramViewGroup;
    }
    paramViewGroup = (RecyclerView.v)new c.c(paramViewGroup);
    AppMethodBeat.o(286735);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(286743);
    s.u(paramv, "holder");
    if ((paramv instanceof f))
    {
      ((f)paramv).b((com.tencent.mm.plugin.vlog.ui.thumb.a)this.MkF.getTracks().get(paramInt - 1));
      AppMethodBeat.o(286743);
      return;
    }
    if ((paramv instanceof c.c))
    {
      paramv = (c.c)paramv;
      if (this.MkF.getDraggingIndex() == -1) {}
      for (paramInt = this.MkF.getFillingWidth();; paramInt = 0)
      {
        Log.i("MicroMsg.MvTracksAdapter", s.X("filling ", Integer.valueOf(paramInt)));
        paramv.caK.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramv.parent.getHeight() - paramv.parent.getPaddingTop() - paramv.parent.getPaddingBottom()));
        AppMethodBeat.o(286743);
        return;
      }
    }
    if ((paramv instanceof c.e))
    {
      paramv = (c.e)paramv;
      paramv.caK.setLayoutParams(new ViewGroup.LayoutParams(paramv.parent.getWidth() / 2, paramv.parent.getHeight() - paramv.parent.getPaddingTop() - paramv.parent.getPaddingBottom()));
    }
    AppMethodBeat.o(286743);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(286759);
    int i = this.MkF.getTracks().size();
    AppMethodBeat.o(286759);
    return i + 3;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(286766);
    if (paramInt == 0)
    {
      AppMethodBeat.o(286766);
      return 1;
    }
    if (paramInt == this.MkF.getTracks().size() + 1)
    {
      AppMethodBeat.o(286766);
      return 4;
    }
    if (paramInt == this.MkF.getTracks().size() + 2)
    {
      AppMethodBeat.o(286766);
      return 3;
    }
    AppMethodBeat.o(286766);
    return 2;
  }
  
  public final void n(RecyclerView.v paramv)
  {
    AppMethodBeat.i(286754);
    s.u(paramv, "holder");
    super.n(paramv);
    if ((paramv instanceof f))
    {
      paramv = ((f)paramv).MkH;
      Object localObject1 = paramv.Mkg;
      Log.i("MicroMsg.MvFrameListView", localObject1 + " stop");
      if (localObject1 != null)
      {
        Object localObject2 = paramv.Mkh;
        if (localObject2 != null)
        {
          s.u(localObject1, "track");
          Log.i("MicroMsg.ThumbCachedLoader", s.X("stop ", localObject1));
          localObject1 = ((com.tencent.mm.plugin.mv.ui.c.b)localObject2).a((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1);
          ((b.b)localObject1).Mdh.clear();
          ((b.b)localObject1).Mdi.clear();
          localObject2 = ((b.b)localObject1).job;
          if (localObject2 != null) {
            ((cb)localObject2).a(null);
          }
          ((b.b)localObject1).job = null;
          localObject2 = ((b.b)localObject1).FTn;
          if (localObject2 != null) {
            ((com.tencent.mm.videocomposition.c)localObject2).destroy();
          }
          ((b.b)localObject1).FTn = null;
        }
      }
      localObject1 = paramv.Mki;
      if (localObject1 != null) {
        ((cb)localObject1).a(null);
      }
      paramv.Mki = null;
    }
    AppMethodBeat.o(286754);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$Callback;", "", "onTrackClicked", "", "index", "", "onTrackEndChanged", "time", "", "onTrackSlidingStarted", "startTime", "endTime", "onTrackSlidingStopped", "onTrackStartChanged", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void aM(int paramInt, long paramLong);
    
    public abstract void aN(int paramInt, long paramLong);
    
    public abstract void aeq(int paramInt);
    
    public abstract void r(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void s(int paramInt, long paramLong1, long paramLong2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$Provider;", "", "draggingIndex", "", "getDraggingIndex", "()I", "fillingWidth", "getFillingWidth", "selectedIndex", "getSelectedIndex", "spaceSize", "getSpaceSize", "thumbLoader", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "getThumbLoader", "()Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "tracks", "", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "getTracks", "()Ljava/util/List;", "widthPerMills", "", "getWidthPerMills", "()F", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract int getDraggingIndex();
    
    public abstract int getFillingWidth();
    
    public abstract int getSelectedIndex();
    
    public abstract int getSpaceSize();
    
    public abstract com.tencent.mm.plugin.mv.ui.c.b getThumbLoader();
    
    public abstract List<com.tencent.mm.plugin.vlog.ui.thumb.a> getTracks();
    
    public abstract float getWidthPerMills();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$TrackViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter;Landroid/view/View;)V", "border", "debug", "Landroid/widget/TextView;", "frameList", "Lcom/tencent/mm/plugin/mv/ui/widget/MvFrameListView;", "slider", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView;", "bind", "", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "index", "", "unbind", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class f
    extends RecyclerView.v
  {
    final MvFrameListView MkH;
    private final RangeSliderView MkI;
    private final View MkJ;
    private final TextView MkK;
    
    public f()
    {
      super();
      AppMethodBeat.i(286649);
      this$1 = localObject.findViewById(b.e.frame_list);
      s.s(c.this, "itemView.findViewById(R.id.frame_list)");
      this.MkH = ((MvFrameListView)c.this);
      this$1 = localObject.findViewById(b.e.LUF);
      s.s(c.this, "itemView.findViewById(R.id.slider_layout)");
      this.MkI = ((RangeSliderView)c.this);
      this$1 = localObject.findViewById(b.e.eXB);
      s.s(c.this, "itemView.findViewById(R.id.border)");
      this.MkJ = c.this;
      this$1 = localObject.findViewById(b.e.fEu);
      s.s(c.this, "itemView.findViewById(R.id.debug)");
      this.MkK = ((TextView)c.this);
      AppMethodBeat.o(286649);
    }
    
    private static final void a(final com.tencent.mm.plugin.vlog.ui.thumb.a parama, final c paramc, int paramInt, f paramf, View paramView)
    {
      AppMethodBeat.i(286658);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramc);
      localb.sc(paramInt);
      localb.cH(paramf);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$TrackViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "$trackInfo");
      s.u(paramc, "this$0");
      s.u(paramf, "this$1");
      Log.i("MicroMsg.MvTracksAdapter", s.X("clicked ", parama));
      c.b(paramc).aeq(paramInt);
      paramc.MkG = ((kotlin.g.a.b)new a(paramf, parama, paramc));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$TrackViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286658);
    }
    
    public final void b(com.tencent.mm.plugin.vlog.ui.thumb.a parama)
    {
      boolean bool2 = true;
      AppMethodBeat.i(286690);
      s.u(parama, "trackInfo");
      final int j = c.aeo(KJ());
      this.caK.setOnClickListener(new c.f..ExternalSyntheticLambda0(parama, c.this, j, this));
      Object localObject1 = c.a(c.this).getThumbLoader();
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = this.MkH;
        s.u(parama, "info");
        s.u(localObject1, "loader");
        ((MvFrameListView)localObject2).Mkg = parama;
        ((MvFrameListView)localObject2).Mkh = ((com.tencent.mm.plugin.mv.ui.c.b)localObject1);
        ((MvFrameListView)localObject2).bounds.right = parama.width;
        ((MvFrameListView)localObject2).bounds.bottom = parama.height;
        float f = parama.width * parama.UoR / (float)parama.getTotalDuration();
        ((MvFrameListView)localObject2).setDrawStart((int)((float)parama.UoP * f));
        ((MvFrameListView)localObject2).setDrawEnd((int)(f * (float)parama.UoQ));
        cb localcb = ((MvFrameListView)localObject2).Mki;
        if (localcb != null) {
          localcb.a(null);
        }
        ((MvFrameListView)localObject2).Mki = j.a((aq)bu.ajwo, (f)bg.kCh(), null, (m)new MvFrameListView.b((com.tencent.mm.plugin.mv.ui.c.b)localObject1, parama, (MvFrameListView)localObject2, null), 2);
      }
      int i;
      boolean bool1;
      if (c.aeo(KJ()) == c.a(c.this).getTracks().size() - 1)
      {
        i = 1;
        localObject1 = new ah.d();
        if ((i == 0) || (c.a(c.this).getFillingWidth() > 0)) {
          ((ah.d)localObject1).aixb += c.a(c.this).getSpaceSize();
        }
        localObject2 = this.MkI;
        if (j != c.a(c.this).getSelectedIndex()) {
          break label631;
        }
        bool1 = true;
        label329:
        ((RangeSliderView)localObject2).setActive(bool1);
        this.MkI.setMaxEnd((int)((float)parama.getTotalDuration() * c.a(c.this).getWidthPerMills()) - ((ah.d)localObject1).aixb);
        this.MkI.setMinWidth((int)(2000.0F * c.a(c.this).getWidthPerMills()) - ((ah.d)localObject1).aixb);
        this.MkI.setStart((int)((float)parama.UoP * c.a(c.this).getWidthPerMills()));
        if (c.a(c.this).getDraggingIndex() == -1) {
          break label637;
        }
        this.MkI.setEnd(parama.width);
        label451:
        localObject2 = this.MkI;
        if (j != 0) {
          break label672;
        }
        bool1 = bool2;
        label466:
        ((RangeSliderView)localObject2).setKeepSizeOnStartChanged(bool1);
        this.MkI.setCallback((RangeSliderView.a)new b(c.this, j, (ah.d)localObject1, this));
        if (j != c.a(c.this).getDraggingIndex()) {
          break label678;
        }
        this.MkJ.setVisibility(0);
      }
      for (;;)
      {
        Log.i("MicroMsg.MvTracksAdapter", "bind[" + gsh() + "]: time=" + parama.UoU + ", duration=" + parama.hUo() + ", width=" + (this.MkI.getEnd() - this.MkI.getStart()) + ", clipWidth=" + ((ah.d)localObject1).aixb);
        this.caK.requestLayout();
        AppMethodBeat.o(286690);
        return;
        i = 0;
        break;
        label631:
        bool1 = false;
        break label329;
        label637:
        this.MkI.setEnd((int)((float)parama.UoQ * c.a(c.this).getWidthPerMills()) - ((ah.d)localObject1).aixb);
        break label451;
        label672:
        bool1 = false;
        break label466;
        label678:
        this.MkJ.setVisibility(8);
      }
    }
    
    public final int gsh()
    {
      AppMethodBeat.i(369819);
      int i = c.aeo(KJ());
      AppMethodBeat.o(369819);
      return i;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Long, ah>
    {
      a(c.f paramf, com.tencent.mm.plugin.vlog.ui.thumb.a parama, c paramc)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$TrackViewHolder$bind$3", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;", "downStart", "", "onRangeEndChanged", "", "oldValue", "newValue", "onRangeStartChanged", "onSlidingStarted", "edge", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Edge;", "start", "end", "onSlidingStopped", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements RangeSliderView.a
    {
      private int MkP;
      
      b(c paramc, int paramInt, ah.d paramd, c.f paramf) {}
      
      private static final void c(c paramc)
      {
        AppMethodBeat.i(286580);
        s.u(paramc, "this$0");
        paramc.fV(c.aep(c.a(paramc).getTracks().size()));
        AppMethodBeat.o(286580);
      }
      
      public final void a(RangeSliderView.c paramc, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(286597);
        s.u(paramc, "edge");
        Log.i("MicroMsg.MvTracksAdapter", "onSlidingStarted: " + paramInt1 + ", " + paramInt2);
        this.MkP = paramInt1;
        long l1 = (paramInt1 / c.a(this.MkL).getWidthPerMills());
        long l2 = (paramInt2 / c.a(this.MkL).getWidthPerMills());
        c.b(this.MkL).r(j, l1, l2);
        AppMethodBeat.o(286597);
      }
      
      public final void aer(int paramInt)
      {
        AppMethodBeat.i(286616);
        long l = (paramInt / c.a(this.MkL).getWidthPerMills());
        c.b(this.MkL).aN(j, l);
        Log.i("MicroMsg.MvTracksAdapter", s.X("onRangeStartChanged: ", Integer.valueOf(paramInt)));
        AppMethodBeat.o(286616);
      }
      
      public final void aes(int paramInt)
      {
        AppMethodBeat.i(286626);
        long l = ((this.MkQ.aixb + paramInt) / c.a(this.MkL).getWidthPerMills());
        c.b(this.MkL).aM(j, l);
        Log.i("MicroMsg.MvTracksAdapter", s.X("onRangeEndChanged: ", Integer.valueOf(paramInt)));
        AppMethodBeat.o(286626);
      }
      
      public final void b(RangeSliderView.c paramc, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(286608);
        s.u(paramc, "edge");
        Log.i("MicroMsg.MvTracksAdapter", "onSlidingStopped: " + paramInt1 + ", " + paramInt2);
        long l1 = (paramInt1 / c.a(this.MkL).getWidthPerMills());
        long l2 = ((this.MkQ.aixb + paramInt2) / c.a(this.MkL).getWidthPerMills());
        c.f.a(jdField_this).post(new c.f.b..ExternalSyntheticLambda0(this.MkL));
        c.b(this.MkL).s(j, l1, l2);
        AppMethodBeat.o(286608);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */