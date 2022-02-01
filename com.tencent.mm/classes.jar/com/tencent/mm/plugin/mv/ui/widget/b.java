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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeSpanDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "centerTime", "", "getCenterTime", "()J", "setCenterTime", "(J)V", "getContext", "()Landroid/content/Context;", "dotDrawable", "Landroid/graphics/drawable/Drawable;", "dotSize", "", "labelHeight", "", "getLabelHeight", "()F", "labelOffsetY", "labelSize", "paint", "Landroid/graphics/Paint;", "textSize", "timeHelper", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;", "getTimeHelper", "()Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;", "setTimeHelper", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTrackTimeHelper;)V", "totalDuration", "getTotalDuration", "setTotalDuration", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-mv_release"})
public final class b
  extends RecyclerView.h
{
  public long Glx;
  a GqA;
  private final float Gqu;
  final float Gqv;
  private final float Gqw;
  private final Drawable Gqx;
  private final int Gqy;
  long Gqz;
  private final Context context;
  private final Paint paint;
  private final int textSize;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(225247);
    this.context = paramContext;
    this.textSize = this.context.getResources().getDimensionPixelSize(b.c.CaptionTextSize);
    this.paint = new Paint(1);
    this.Glx = 1000L;
    this.paint.setColor(-1);
    this.paint.setTextSize(this.textSize);
    this.Gqu = this.paint.measureText("00:00");
    this.Gqw = this.paint.getFontMetrics().top;
    this.Gqv = (this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top);
    paramContext = this.context.getDrawable(b.d.FWq);
    if (paramContext == null) {
      p.iCn();
    }
    this.Gqx = paramContext;
    this.Gqy = com.tencent.mm.ci.a.fromDPToPix(this.context, 2);
    this.Gqx.setBounds(0, 0, this.Gqy, this.Gqy);
    AppMethodBeat.o(225247);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(225237);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    params = this.GqA;
    if (params != null)
    {
      int i = kotlin.h.a.dm((paramRecyclerView.getWidth() / 2 + this.Gqu) / params.Gqp);
      long l4 = this.Gqz;
      long l5 = kotlin.h.a.dm(paramRecyclerView.getWidth() / 2 / params.Gqp);
      long l2 = this.Gqz - i;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = this.Gqz;
      long l3 = i + l2;
      l2 = l3;
      if (l3 > this.Glx) {
        l2 = this.Glx;
      }
      l1 /= params.Gqo;
      l2 /= params.Gqo;
      if (l1 <= l2)
      {
        l3 = params.Gqo * l1;
        float f = (float)(l3 - (l4 - l5)) * params.Gqp;
        if (l1 % 2L == 1L)
        {
          this.Gqx.setBounds((int)f - this.Gqy / 2, ((int)this.Gqv - this.Gqy) / 2, (int)f + this.Gqy / 2, ((int)this.Gqv + this.Gqy) / 2);
          this.Gqx.draw(paramCanvas);
        }
        for (;;)
        {
          if (l1 == l2) {
            break label306;
          }
          l1 += 1L;
          break;
          paramCanvas.drawText(org.apache.commons.b.d.a.ag(l3, "mm:ss"), f - this.Gqu / 2.0F, -this.Gqw, this.paint);
        }
      }
      label306:
      AppMethodBeat.o(225237);
      return;
    }
    AppMethodBeat.o(225237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */