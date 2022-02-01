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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.music.a.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "drawingContent", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "textPaint", "Landroid/graphics/Paint;", "textWidth", "", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "updateContent", "tickMsList", "", "", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.h
{
  private final ArrayList<String> LQp;
  private final Context context;
  private final Paint dZu;
  private float dsJ;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(270976);
    this.context = paramContext;
    this.dZu = new Paint(1);
    this.LQp = new ArrayList();
    this.dZu.setColor(this.context.getResources().getColor(a.b.BW_100_Alpha_0_3));
    this.dZu.setTextSize(a.fromDPToPix(this.context, 10));
    this.dsJ = this.dZu.measureText("00:00");
    AppMethodBeat.o(270976);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(270992);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    int k = paramRecyclerView.getChildCount();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      View localView = paramRecyclerView.getChildAt(i);
      int m = RecyclerView.bA(localView);
      float f1 = localView.getBottom() - this.dZu.getFontMetrics().descent;
      int n = localView.getLeft();
      int i1 = localView.getRight();
      float f2;
      float f3;
      if (n > -this.dsJ / 2.0F)
      {
        f2 = n;
        f3 = this.dsJ / 2.0F;
        paramCanvas.drawText((String)this.LQp.get(m), f2 - f3, f1, this.dZu);
      }
      if ((i == k - 1) && (m + 1 < this.LQp.size()) && (i1 < paramRecyclerView.getWidth() + this.dsJ / 2.0F))
      {
        f2 = i1;
        f3 = this.dsJ / 2.0F;
        paramCanvas.drawText((String)this.LQp.get(m + 1), f2 - f3, f1 - this.dZu.getFontMetrics().descent, this.dZu);
      }
      if (j >= k)
      {
        super.b(paramCanvas, paramRecyclerView, params);
        AppMethodBeat.o(270992);
        return;
      }
    }
  }
  
  public final void je(List<Long> paramList)
  {
    AppMethodBeat.i(270983);
    s.u(paramList, "tickMsList");
    this.LQp.clear();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
    ArrayList localArrayList = this.LQp;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(localSimpleDateFormat.format(Long.valueOf(((Number)((Iterator)localObject).next()).longValue())));
    }
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(270983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.b
 * JD-Core Version:    0.7.0.1
 */