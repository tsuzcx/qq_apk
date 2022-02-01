package com.tencent.mm.view;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/ExposeElves;", "", "()V", "CHECK_TIME_NS", "", "TAG", "", "lastCheckTime", "", "rect", "Landroid/graphics/Rect;", "watchSize", "getWatchSize", "()I", "setWatchSize", "(I)V", "checkExpose", "", "checkExposeImpl", "target", "Landroid/view/View;", "exposedData", "Lcom/tencent/mm/view/ExposedData;", "checkGroupExpose", "checkLeak", "", "view", "OnRecyclerViewChildExposedListener", "OnViewExposedListener", "OnViewGroupChildExposedListener", "libmmui_release"})
public final class e
{
  private static int YKw;
  public static final e YKx;
  private static final Rect byG;
  private static long lastCheckTime;
  
  static
  {
    AppMethodBeat.i(188576);
    YKx = new e();
    byG = new Rect();
    a locala = (a)e.d.YKz;
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    if ((p.h(localThread, localLooper.getThread()) ^ true))
    {
      f.igY().post((Runnable)new e.1(locala));
      AppMethodBeat.o(188576);
      return;
    }
    locala.invoke();
    AppMethodBeat.o(188576);
  }
  
  private static void a(View paramView, g paramg)
  {
    AppMethodBeat.i(188575);
    c localc = paramg.YKQ;
    if (localc == null)
    {
      AppMethodBeat.o(188575);
      return;
    }
    if (localc.igW())
    {
      AppMethodBeat.o(188575);
      return;
    }
    if (!(paramView instanceof ViewGroup))
    {
      AppMethodBeat.o(188575);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    long l1 = 0L;
    int i = 0;
    int j = ((ViewGroup)paramView).getChildCount();
    while (i < j)
    {
      View localView = ((ViewGroup)paramView).getChildAt(i);
      p.j(localView, "child");
      long l3 = localc.er(localView);
      long l2 = l1;
      if (localView.isShown())
      {
        l2 = l1;
        if (localView.getAlpha() > 0.0F)
        {
          l2 = l1;
          if (localView.getGlobalVisibleRect(byG))
          {
            localLinkedList.add(localView);
            l2 = l1 + l3;
          }
        }
      }
      i += 1;
      l1 = l2;
    }
    if (paramg.YKR != l1)
    {
      paramg.YKR = l1;
      paramg = paramg.YKQ;
      if (paramg != null)
      {
        paramg.b(paramView, (List)localLinkedList);
        AppMethodBeat.o(188575);
        return;
      }
    }
    AppMethodBeat.o(188575);
  }
  
  public static void azl(int paramInt)
  {
    YKw = paramInt;
  }
  
  public static int igU()
  {
    return YKw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "", "()V", "getExposedId", "", "view", "Landroid/view/View;", "ignoreExposeChanged", "", "onChildExposeChanged", "", "parent", "exposedChildren", "", "libmmui_release"})
  public static abstract class c
  {
    public abstract void b(View paramView, List<? extends View> paramList);
    
    public long er(View paramView)
    {
      p.k(paramView, "view");
      return paramView.hashCode();
    }
    
    public boolean igW()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.e
 * JD-Core Version:    0.7.0.1
 */