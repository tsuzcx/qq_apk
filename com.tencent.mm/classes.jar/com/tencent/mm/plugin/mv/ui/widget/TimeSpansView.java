package com.tencent.mm.plugin.mv.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "itemDuration", "", "itemWidth", "", "layout", "Landroidx/recyclerview/widget/LinearLayoutManager;", "value", "", "progress", "getProgress", "()J", "setProgress", "(J)V", "totalDuration", "getTotalDuration", "setTotalDuration", "widthPerMills", "getWidthPerMills", "()D", "calculateItemWidth", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "fixPosition", "", "onInterceptTouchEvent", "e", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "updatePadding", "Companion", "SpanViewHolder", "SpansAdapter", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TimeSpansView
  extends RecyclerView
{
  public static final TimeSpansView.a Mms;
  private long MfX;
  private final LinearLayoutManager Mmt;
  private double Mmu;
  private final double Mmv;
  private long hQO;
  private final int wLI;
  
  static
  {
    AppMethodBeat.i(286724);
    Mms = new TimeSpansView.a((byte)0);
    AppMethodBeat.o(286724);
  }
  
  public TimeSpansView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286703);
    this.Mmt = new LinearLayoutManager(0, false);
    this.Mmu = 5000.0D;
    paramContext = LayoutInflater.from(getContext()).inflate(b.f.LVo, null, false);
    s.s(paramContext, "itemView");
    new b(paramContext).vLJ.setText((CharSequence)"00:00");
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.wLI = paramContext.getMeasuredWidth();
    this.Mmv = (this.wLI / this.Mmu);
    setAdapter((RecyclerView.a)new c());
    setLayoutManager((RecyclerView.LayoutManager)this.Mmt);
    setClipChildren(false);
    setClipToPadding(false);
    a((RecyclerView.l)new TimeSpansView.1());
    AppMethodBeat.o(286703);
  }
  
  private final void aew(int paramInt)
  {
    AppMethodBeat.i(286710);
    double d1 = this.MfX;
    RecyclerView.a locala = getAdapter();
    s.checkNotNull(locala);
    double d2 = locala.getItemCount();
    double d3 = this.Mmu;
    setPadding(paramInt / 2, 0, (int)((d1 - d2 * d3) * this.Mmv) + paramInt / 2, 0);
    AppMethodBeat.o(286710);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final long getProgress()
  {
    return this.hQO;
  }
  
  public final long getTotalDuration()
  {
    return this.MfX;
  }
  
  public final double getWidthPerMills()
  {
    return this.Mmv;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(286762);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    aew(paramInt1);
    AppMethodBeat.o(286762);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(286756);
    this.hQO = paramLong;
    int i = (int)(paramLong / this.Mmu);
    double d1 = paramLong;
    double d2 = this.Mmu;
    double d3 = i;
    double d4 = this.Mmv;
    this.Mmt.bo(i, -(int)((d1 - d2 * d3) * d4));
    AppMethodBeat.o(286756);
  }
  
  public final void setTotalDuration(long paramLong)
  {
    AppMethodBeat.i(286738);
    this.MfX = paramLong;
    Log.i("MicroMsg.TimeSpansView", s.X("setup duration: ", Long.valueOf(this.MfX)));
    int i = getWidth();
    getHeight();
    aew(i);
    AppMethodBeat.o(286738);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView$SpanViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dot", "getDot", "()Landroid/view/View;", "time", "Landroid/widget/TextView;", "getTime", "()Landroid/widget/TextView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends RecyclerView.v
  {
    final View Mmw;
    final TextView vLJ;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(286595);
      View localView = paramView.findViewById(b.e.time);
      s.s(localView, "itemView.findViewById(R.id.time)");
      this.vLJ = ((TextView)localView);
      paramView = paramView.findViewById(b.e.dot);
      s.s(paramView, "itemView.findViewById(R.id.dot)");
      this.Mmw = paramView;
      AppMethodBeat.o(286595);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView$SpansAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView$SpanViewHolder;", "(Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView;)V", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class c
    extends RecyclerView.a<TimeSpansView.b>
  {
    private final LayoutInflater pUI;
    
    public c()
    {
      AppMethodBeat.i(286589);
      this.pUI = LayoutInflater.from(this.Mmx.getContext());
      AppMethodBeat.o(286589);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(286598);
      int i = (int)Math.ceil(this.Mmx.getTotalDuration() / TimeSpansView.a(this.Mmx));
      AppMethodBeat.o(286598);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.TimeSpansView
 * JD-Core Version:    0.7.0.1
 */