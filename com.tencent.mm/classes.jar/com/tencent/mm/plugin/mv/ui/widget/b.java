package com.tencent.mm.plugin.mv.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeSpanDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "centerTime", "", "getCenterTime", "()J", "setCenterTime", "(J)V", "getContext", "()Landroid/content/Context;", "dotDrawable", "Landroid/graphics/drawable/Drawable;", "dotSize", "", "labelHeight", "", "getLabelHeight", "()F", "labelOffsetY", "labelSize", "paint", "Landroid/graphics/Paint;", "textSize", "timeHelper", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;", "getTimeHelper", "()Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;", "setTimeHelper", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;)V", "totalDuration", "getTotalDuration", "setTotalDuration", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.h
{
  public long MfX;
  private final int MkA;
  long MkB;
  a MkC;
  private final float Mkw;
  final float Mkx;
  private final float Mky;
  private final Drawable Mkz;
  private final Context context;
  private final Paint paint;
  private final int textSize;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(286663);
    this.context = paramContext;
    this.textSize = this.context.getResources().getDimensionPixelSize(b.c.CaptionTextSize);
    this.paint = new Paint(1);
    this.MfX = 1000L;
    this.paint.setColor(-1);
    this.paint.setTextSize(this.textSize);
    this.Mkw = this.paint.measureText("00:00");
    this.Mky = this.paint.getFontMetrics().top;
    this.Mkx = (this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top);
    paramContext = this.context.getDrawable(b.d.LRD);
    s.checkNotNull(paramContext);
    s.s(paramContext, "context.getDrawable(R.dr…_mv_clip_time_span_dot)!!");
    this.Mkz = paramContext;
    this.MkA = com.tencent.mm.cd.a.fromDPToPix(this.context, 2);
    this.Mkz.setBounds(0, 0, this.MkA, this.MkA);
    AppMethodBeat.o(286663);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(286678);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    params = this.MkC;
    long l4;
    long l5;
    long l2;
    long l1;
    long l3;
    if (params != null)
    {
      int i = kotlin.h.a.eH((paramRecyclerView.getWidth() / 2 + this.Mkw) / params.Mks);
      l4 = this.MkB;
      l5 = kotlin.h.a.eH(paramRecyclerView.getWidth() / 2 / params.Mks);
      l2 = this.MkB - i;
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = this.MkB;
      l3 = i + l2;
      l2 = l3;
      if (l3 > this.MfX) {
        l2 = this.MfX;
      }
      l1 /= params.Mkr;
      l2 /= params.Mkr;
      if (l1 > l2) {}
    }
    for (;;)
    {
      l3 = params.Mkr * l1;
      float f = (float)(l3 - (l4 - l5)) * params.Mks;
      if (l1 % 2L == 1L)
      {
        this.Mkz.setBounds((int)f - this.MkA / 2, ((int)this.Mkx - this.MkA) / 2, (int)f + this.MkA / 2, ((int)this.Mkx + this.MkA) / 2);
        this.Mkz.draw(paramCanvas);
      }
      while (l1 == l2)
      {
        AppMethodBeat.o(286678);
        return;
        paramCanvas.drawText(org.apache.commons.c.d.a.at(l3, "mm:ss"), f - this.Mkw / 2.0F, -this.Mky, this.paint);
      }
      l1 = 1L + l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */