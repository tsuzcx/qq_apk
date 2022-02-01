package com.tencent.mm.plugin.mv.ui.widget;

import android.annotation.SuppressLint;
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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "itemDuration", "", "itemWidth", "", "layout", "Landroidx/recyclerview/widget/LinearLayoutManager;", "value", "", "progress", "getProgress", "()J", "setProgress", "(J)V", "totalDuration", "getTotalDuration", "setTotalDuration", "widthPerMills", "getWidthPerMills", "()D", "calculateItemWidth", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "fixPosition", "", "onInterceptTouchEvent", "e", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "updatePadding", "Companion", "SpanViewHolder", "SpansAdapter", "plugin-mv_release"})
public final class TimeSpansView
  extends RecyclerView
{
  public static final a Gst;
  private long Glx;
  private final LinearLayoutManager Gsq;
  private double Gsr;
  private final double Gss;
  private long progress;
  private final int tHY;
  
  static
  {
    AppMethodBeat.i(231677);
    Gst = new a((byte)0);
    AppMethodBeat.o(231677);
  }
  
  public TimeSpansView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(231676);
    this.Gsq = new LinearLayoutManager(0, false);
    this.Gsr = 5000.0D;
    paramContext = LayoutInflater.from(getContext()).inflate(b.f.FZr, null, false);
    p.j(paramContext, "itemView");
    new b(paramContext).sGk.setText((CharSequence)"00:00");
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.tHY = paramContext.getMeasuredWidth();
    this.Gss = (this.tHY / this.Gsr);
    setAdapter((RecyclerView.a)new c());
    setLayoutManager((RecyclerView.LayoutManager)this.Gsq);
    setClipChildren(false);
    setClipToPadding(false);
    a((RecyclerView.l)new TimeSpansView.1());
    AppMethodBeat.o(231676);
  }
  
  private final void aad(int paramInt)
  {
    AppMethodBeat.i(231666);
    double d1 = this.Glx;
    RecyclerView.a locala = getAdapter();
    if (locala == null) {
      p.iCn();
    }
    p.j(locala, "adapter!!");
    double d2 = locala.getItemCount();
    double d3 = this.Gsr;
    setPadding(paramInt / 2, 0, (int)((d1 - d2 * d3) * this.Gss) + paramInt / 2, 0);
    AppMethodBeat.o(231666);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final long getProgress()
  {
    return this.progress;
  }
  
  public final long getTotalDuration()
  {
    return this.Glx;
  }
  
  public final double getWidthPerMills()
  {
    return this.Gss;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(231662);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    aad(paramInt1);
    AppMethodBeat.o(231662);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(231661);
    this.progress = paramLong;
    int i = (int)(paramLong / this.Gsr);
    double d1 = paramLong;
    double d2 = this.Gsr;
    double d3 = i;
    double d4 = this.Gss;
    this.Gsq.au(i, -(int)((d1 - d2 * d3) * d4));
    AppMethodBeat.o(231661);
  }
  
  public final void setTotalDuration(long paramLong)
  {
    AppMethodBeat.i(231659);
    this.Glx = paramLong;
    Log.i("MicroMsg.TimeSpansView", "setup duration: " + this.Glx);
    int i = getWidth();
    getHeight();
    aad(i);
    AppMethodBeat.o(231659);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView$SpanViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dot", "getDot", "()Landroid/view/View;", "time", "Landroid/widget/TextView;", "getTime", "()Landroid/widget/TextView;", "plugin-mv_release"})
  static final class b
    extends RecyclerView.v
  {
    final View Gsu;
    final TextView sGk;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(229154);
      View localView = paramView.findViewById(b.e.time);
      p.j(localView, "itemView.findViewById(R.id.time)");
      this.sGk = ((TextView)localView);
      paramView = paramView.findViewById(b.e.dot);
      p.j(paramView, "itemView.findViewById(R.id.dot)");
      this.Gsu = paramView;
      AppMethodBeat.o(229154);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView$SpansAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView$SpanViewHolder;", "(Lcom/tencent/mm/plugin/mv/ui/widget/TimeSpansView;)V", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-mv_release"})
  final class c
    extends RecyclerView.a<TimeSpansView.b>
  {
    private final LayoutInflater mYa;
    
    public c()
    {
      AppMethodBeat.i(227825);
      this.mYa = LayoutInflater.from(this$1.getContext());
      AppMethodBeat.o(227825);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(227823);
      int i = (int)Math.ceil(this.Gsv.getTotalDuration() / TimeSpansView.a(this.Gsv));
      AppMethodBeat.o(227823);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.TimeSpansView
 * JD-Core Version:    0.7.0.1
 */