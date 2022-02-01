package com.tencent.mm.view;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/ExposeElves;", "", "()V", "CHECK_TIME_NS", "", "TAG", "", "lastCheckTime", "", "rect", "Landroid/graphics/Rect;", "watchSize", "getWatchSize", "()I", "setWatchSize", "(I)V", "checkExpose", "", "target", "Landroid/view/View;", "exposedData", "Lcom/tencent/mm/view/ExposedData;", "checkGroupExpose", "OnRecyclerViewChildExposedListener", "OnViewExposedListener", "OnViewGroupChildExposedListener", "libmmui_release"})
public final class e
{
  private static int RiP;
  public static final e RiQ;
  private static long lastCheckTime;
  private static final Rect rect;
  
  static
  {
    AppMethodBeat.i(204929);
    RiQ = new e();
    rect = new Rect();
    a locala = (a)d.RiS;
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    if ((p.j(localThread, localLooper.getThread()) ^ true))
    {
      new Handler(Looper.getMainLooper()).post((Runnable)new e.1(locala));
      AppMethodBeat.o(204929);
      return;
    }
    locala.invoke();
    AppMethodBeat.o(204929);
  }
  
  private static void a(View paramView, g paramg)
  {
    AppMethodBeat.i(204928);
    c localc = paramg.Rjd;
    if (localc == null)
    {
      AppMethodBeat.o(204928);
      return;
    }
    if (localc.hfA())
    {
      AppMethodBeat.o(204928);
      return;
    }
    if (!(paramView instanceof ViewGroup))
    {
      AppMethodBeat.o(204928);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    long l1 = 0L;
    int i = 0;
    int j = ((ViewGroup)paramView).getChildCount();
    while (i < j)
    {
      View localView = ((ViewGroup)paramView).getChildAt(i);
      p.g(localView, "child");
      long l3 = localc.hE(localView);
      long l2 = l1;
      if (localView.isShown())
      {
        l2 = l1;
        if (localView.getAlpha() > 0.0F)
        {
          l2 = l1;
          if (localView.getGlobalVisibleRect(rect))
          {
            localLinkedList.add(localView);
            l2 = l1 + l3;
          }
        }
      }
      i += 1;
      l1 = l2;
    }
    if (paramg.Rje != l1)
    {
      paramg.Rje = l1;
      paramg = paramg.Rjd;
      if (paramg != null)
      {
        paramg.b(paramView, (List)localLinkedList);
        AppMethodBeat.o(204928);
        return;
      }
    }
    AppMethodBeat.o(204928);
  }
  
  public static void apM(int paramInt)
  {
    RiP = paramInt;
  }
  
  public static int hfy()
  {
    return RiP;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "", "()V", "getExposedId", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "libmmui_release"})
  public static abstract class a
  {
    public long ae(RecyclerView.v paramv)
    {
      if (paramv != null)
      {
        paramv = paramv.aus;
        if (paramv == null) {
          break label26;
        }
      }
      label26:
      for (int i = paramv.hashCode();; i = 0)
      {
        return i;
        paramv = null;
        break;
      }
    }
    
    public abstract void b(View paramView, List<? extends RecyclerView.v> paramList);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "", "()V", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "libmmui_release"})
  public static abstract class b
  {
    public long hE(View paramView)
    {
      p.h(paramView, "view");
      return paramView.hashCode();
    }
    
    public abstract void p(View paramView, boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "", "()V", "getExposedId", "", "view", "Landroid/view/View;", "ignoreExposeChanged", "", "onChildExposeChanged", "", "parent", "exposedChildren", "", "libmmui_release"})
  public static abstract class c
  {
    public abstract void b(View paramView, List<? extends View> paramList);
    
    public long hE(View paramView)
    {
      p.h(paramView, "view");
      return paramView.hashCode();
    }
    
    public boolean hfA()
    {
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    public static final d RiS;
    
    static
    {
      AppMethodBeat.i(204927);
      RiS = new d();
      AppMethodBeat.o(204927);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.e
 * JD-Core Version:    0.7.0.1
 */