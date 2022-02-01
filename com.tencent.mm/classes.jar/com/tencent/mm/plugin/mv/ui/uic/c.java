package com.tencent.mm.plugin.mv.ui.uic;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "", "()V", "TAG", "", "changedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$ViewState;", "Lkotlin/collections/HashMap;", "parent", "Landroid/view/View;", "animate", "view", "clean", "", "gone", "ids", "", "hide", "visible", "invisible", "restore", "ViewState", "plugin-mv_release"})
public final class c
{
  public final HashMap<Integer, a> Awq;
  private final String TAG;
  private View hVd;
  
  public c()
  {
    AppMethodBeat.i(257396);
    this.TAG = "MicroMsg.VisibleRecord";
    this.Awq = new HashMap();
    AppMethodBeat.o(257396);
  }
  
  private final void a(Set<Integer> paramSet, int paramInt)
  {
    AppMethodBeat.i(257395);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      View localView = this.hVd;
      if (localView != null)
      {
        localView = localView.findViewById(i);
        if (localView != null)
        {
          int j = localView.getVisibility();
          if (j != paramInt) {}
          for (boolean bool = true;; bool = false)
          {
            final a locala = new a(i, j, localView.getAlpha(), paramInt, 0.0F, bool);
            ((Map)this.Awq).put(Integer.valueOf(i), locala);
            if (!bool) {
              break;
            }
            localView.animate().cancel();
            localView.animate().alpha(locala.Awt).setDuration(300L).withEndAction((Runnable)new b(localView, locala)).start();
            break;
          }
        }
      }
    }
    AppMethodBeat.o(257395);
  }
  
  public final c eD(View paramView)
  {
    AppMethodBeat.i(257390);
    this.hVd = paramView;
    this.Awq.clear();
    AppMethodBeat.o(257390);
    return this;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(257394);
    Iterator localIterator = this.Awq.values().iterator();
    while (localIterator.hasNext())
    {
      final a locala = (a)localIterator.next();
      if (locala.bGB)
      {
        View localView = this.hVd;
        if (localView != null)
        {
          localView = localView.findViewById(locala.id);
          if (localView != null)
          {
            localView.animate().cancel();
            if (locala.qJE == 0)
            {
              localView.setVisibility(locala.qJE);
              localView.animate().alpha(locala.Awr).setDuration(300L).start();
            }
            else
            {
              localView.animate().alpha(locala.Awr).setDuration(300L).withEndAction((Runnable)new c(localView, locala)).start();
            }
          }
        }
      }
    }
    this.Awq.clear();
    AppMethodBeat.o(257394);
  }
  
  public final c s(Set<Integer> paramSet)
  {
    AppMethodBeat.i(257391);
    p.h(paramSet, "ids");
    Log.i(this.TAG, "gone: ");
    a(paramSet, 8);
    AppMethodBeat.o(257391);
    return this;
  }
  
  public final c t(Set<Integer> paramSet)
  {
    AppMethodBeat.i(257392);
    p.h(paramSet, "ids");
    a(paramSet, 4);
    AppMethodBeat.o(257392);
    return this;
  }
  
  public final c u(Set<Integer> paramSet)
  {
    AppMethodBeat.i(257393);
    p.h(paramSet, "ids");
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      View localView = this.hVd;
      if (localView != null)
      {
        localView = localView.findViewById(i);
        if (localView != null)
        {
          int j = localView.getVisibility();
          if (j != 0) {}
          for (boolean bool = true;; bool = false)
          {
            a locala = new a(i, j, localView.getAlpha(), 0, 1.0F, bool);
            ((Map)this.Awq).put(Integer.valueOf(i), locala);
            if (!bool) {
              break;
            }
            localView.animate().cancel();
            localView.setVisibility(0);
            localView.animate().alpha(locala.Awt).setDuration(300L).start();
            break;
          }
        }
      }
    }
    AppMethodBeat.o(257393);
    return this;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$ViewState;", "", "id", "", "startState", "startAlpha", "", "endState", "endAlpha", "changed", "", "(IIFIFZ)V", "getChanged", "()Z", "getEndAlpha", "()F", "getEndState", "()I", "getId", "getStartAlpha", "getStartState", "plugin-mv_release"})
  public static final class a
  {
    final float Awr;
    final int Aws;
    final float Awt;
    final boolean bGB;
    final int id;
    final int qJE;
    
    public a(int paramInt1, int paramInt2, float paramFloat1, int paramInt3, float paramFloat2, boolean paramBoolean)
    {
      this.id = paramInt1;
      this.qJE = paramInt2;
      this.Awr = paramFloat1;
      this.Aws = paramInt3;
      this.Awt = paramFloat2;
      this.bGB = paramBoolean;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(View paramView, c.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(257388);
      this.wbW.setVisibility(locala.Aws);
      AppMethodBeat.o(257388);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView, c.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(257389);
      this.wbW.setVisibility(locala.qJE);
      AppMethodBeat.o(257389);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.c
 * JD-Core Version:    0.7.0.1
 */