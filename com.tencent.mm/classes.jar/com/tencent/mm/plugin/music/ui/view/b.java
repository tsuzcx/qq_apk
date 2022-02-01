package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "drawingContent", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "textPaint", "Landroid/graphics/Paint;", "textWidth", "", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "updateContent", "tickMsList", "", "", "plugin-music_release"})
public final class b
  extends RecyclerView.h
{
  private final ArrayList<String> Aok;
  private final Paint cgU;
  private final Context context;
  private float jq;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(220037);
    this.context = paramContext;
    this.cgU = new Paint(1);
    this.Aok = new ArrayList();
    this.cgU.setColor(this.context.getResources().getColor(2131099676));
    this.cgU.setTextSize(a.fromDPToPix(this.context, 10));
    this.jq = this.cgU.measureText("00:00");
    AppMethodBeat.o(220037);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(220036);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      int k = RecyclerView.bw(localView);
      p.g(localView, "child");
      float f1 = localView.getBottom() - this.cgU.getFontMetrics().descent;
      int m = localView.getLeft();
      int n = localView.getRight();
      float f2;
      float f3;
      if (m > -this.jq / 2.0F)
      {
        f2 = m;
        f3 = this.jq / 2.0F;
        paramCanvas.drawText((String)this.Aok.get(k), f2 - f3, f1, this.cgU);
      }
      if ((i == j - 1) && (k + 1 < this.Aok.size()) && (n < paramRecyclerView.getWidth() + this.jq / 2.0F))
      {
        f2 = n;
        f3 = this.jq / 2.0F;
        paramCanvas.drawText((String)this.Aok.get(k + 1), f2 - f3, f1 - this.cgU.getFontMetrics().descent, this.cgU);
      }
      i += 1;
    }
    super.b(paramCanvas, paramRecyclerView, params);
    AppMethodBeat.o(220036);
  }
  
  public final void fD(List<Long> paramList)
  {
    AppMethodBeat.i(220035);
    p.h(paramList, "tickMsList");
    this.Aok.clear();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
    ArrayList localArrayList = this.Aok;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(localSimpleDateFormat.format(Long.valueOf(((Number)((Iterator)localObject).next()).longValue())));
    }
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(220035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.b
 * JD-Core Version:    0.7.0.1
 */