package com.tencent.mm.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ExposeElves;", "", "()V", "CHECK_TIME_NS", "", "TAG", "", "checkExposedRunnable", "Lkotlin/Function0;", "", "lastCheckTime", "", "rect", "Landroid/graphics/Rect;", "watchSize", "getWatchSize", "()I", "setWatchSize", "(I)V", "checkExpose", "checkExposeImpl", "target", "Landroid/view/View;", "exposedData", "Lcom/tencent/mm/view/ExposedData;", "checkGroupExpose", "checkLeak", "", "view", "OnRecyclerViewChildExposedListener", "OnViewExposedListener", "OnViewGroupChildExposedListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e agGn;
  private static int agGo;
  private static final a<ah> agGp;
  private static long lastCheckTime;
  private static final Rect rect;
  
  static
  {
    AppMethodBeat.i(234712);
    agGn = new e();
    rect = new Rect();
    f.bt((a)1.agGq);
    agGp = (a)d.agGr;
    AppMethodBeat.o(234712);
  }
  
  private static void a(View paramView, g paramg)
  {
    AppMethodBeat.i(234696);
    e.c localc = paramg.agGF;
    if (localc == null)
    {
      AppMethodBeat.o(234696);
      return;
    }
    if (localc.jMl())
    {
      AppMethodBeat.o(234696);
      return;
    }
    if (!(paramView instanceof ViewGroup))
    {
      AppMethodBeat.o(234696);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    long l2 = 0L;
    int i = 0;
    int k = ((ViewGroup)paramView).getChildCount();
    long l1 = l2;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = ((ViewGroup)paramView).getChildAt(i);
      s.s(localView, "child");
      long l3 = localc.fq(localView);
      l1 = l2;
      if (localView.isShown())
      {
        l1 = l2;
        if (localView.getAlpha() > 0.0F)
        {
          l1 = l2;
          if (localView.getGlobalVisibleRect(rect))
          {
            l1 = l2;
            if (localc.mx(localView))
            {
              localLinkedList.add(localView);
              l1 = l2 + l3;
            }
          }
        }
      }
      if (j >= k)
      {
        if (paramg.agGG != l1)
        {
          paramg.agGG = l1;
          paramg = paramg.agGF;
          if (paramg != null) {
            paramg.b(paramView, (List)localLinkedList);
          }
        }
        AppMethodBeat.o(234696);
        return;
      }
      i = j;
      l2 = l1;
    }
  }
  
  public static void aFP(int paramInt)
  {
    agGo = paramInt;
  }
  
  public static int jMj()
  {
    return agGo;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    public static final d agGr;
    
    static
    {
      AppMethodBeat.i(234700);
      agGr = new d();
      AppMethodBeat.o(234700);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.view.e
 * JD-Core Version:    0.7.0.1
 */