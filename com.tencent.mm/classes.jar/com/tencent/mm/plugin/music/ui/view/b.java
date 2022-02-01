package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.music.a.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "drawingContent", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "textPaint", "Landroid/graphics/Paint;", "textWidth", "", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "updateContent", "tickMsList", "", "", "plugin-music_release"})
public final class b
  extends RecyclerView.h
{
  private final ArrayList<String> FVq;
  private float bzI;
  private final Paint ciV;
  private final Context context;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(259551);
    this.context = paramContext;
    this.ciV = new Paint(1);
    this.FVq = new ArrayList();
    this.ciV.setColor(this.context.getResources().getColor(a.b.BW_100_Alpha_0_3));
    this.ciV.setTextSize(a.fromDPToPix(this.context, 10));
    this.bzI = this.ciV.measureText("00:00");
    AppMethodBeat.o(259551);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(259549);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      int k = RecyclerView.bh(localView);
      p.j(localView, "child");
      float f1 = localView.getBottom() - this.ciV.getFontMetrics().descent;
      int m = localView.getLeft();
      int n = localView.getRight();
      float f2;
      float f3;
      if (m > -this.bzI / 2.0F)
      {
        f2 = m;
        f3 = this.bzI / 2.0F;
        paramCanvas.drawText((String)this.FVq.get(k), f2 - f3, f1, this.ciV);
      }
      if ((i == j - 1) && (k + 1 < this.FVq.size()) && (n < paramRecyclerView.getWidth() + this.bzI / 2.0F))
      {
        f2 = n;
        f3 = this.bzI / 2.0F;
        paramCanvas.drawText((String)this.FVq.get(k + 1), f2 - f3, f1 - this.ciV.getFontMetrics().descent, this.ciV);
      }
      i += 1;
    }
    super.b(paramCanvas, paramRecyclerView, params);
    AppMethodBeat.o(259549);
  }
  
  public final void gf(List<Long> paramList)
  {
    AppMethodBeat.i(259548);
    p.k(paramList, "tickMsList");
    this.FVq.clear();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
    ArrayList localArrayList = this.FVq;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(localSimpleDateFormat.format(Long.valueOf(((Number)((Iterator)localObject).next()).longValue())));
    }
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(259548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.b
 * JD-Core Version:    0.7.0.1
 */