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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "", "()V", "TAG", "", "changedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$ViewState;", "Lkotlin/collections/HashMap;", "parent", "Landroid/view/View;", "animate", "view", "clean", "", "gone", "ids", "", "hide", "visible", "invisible", "restore", "Companion", "ViewState", "plugin-mv_release"})
public final class z
{
  public static final z.a Gnb;
  public final HashMap<Integer, b> Gna;
  private final String TAG;
  private View kJC;
  
  static
  {
    AppMethodBeat.i(239093);
    Gnb = new z.a((byte)0);
    AppMethodBeat.o(239093);
  }
  
  public z()
  {
    AppMethodBeat.i(239091);
    this.TAG = "MicroMsg.VisibleRecord";
    this.Gna = new HashMap();
    AppMethodBeat.o(239091);
  }
  
  private final void u(Set<Integer> paramSet)
  {
    AppMethodBeat.i(239090);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      View localView = this.kJC;
      if (localView != null)
      {
        localView = localView.findViewById(i);
        if (localView != null)
        {
          int j = localView.getVisibility();
          if (j != 8) {}
          for (boolean bool = true;; bool = false)
          {
            final b localb = new b(i, j, localView.getAlpha(), 8, 0.0F, bool);
            ((Map)this.Gna).put(Integer.valueOf(i), localb);
            if (!bool) {
              break;
            }
            localView.animate().cancel();
            localView.animate().alpha(localb.Gne).setDuration(150L).withEndAction((Runnable)new c(localView, localb)).start();
            break;
          }
        }
      }
    }
    AppMethodBeat.o(239090);
  }
  
  public final z fF(View paramView)
  {
    AppMethodBeat.i(239078);
    this.kJC = paramView;
    this.Gna.clear();
    AppMethodBeat.o(239078);
    return this;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(239089);
    Iterator localIterator = this.Gna.values().iterator();
    while (localIterator.hasNext())
    {
      final b localb = (b)localIterator.next();
      if (localb.bqf)
      {
        View localView = this.kJC;
        if (localView != null)
        {
          localView = localView.findViewById(localb.id);
          if (localView != null)
          {
            localView.animate().cancel();
            if (localb.uiJ == 0)
            {
              localView.setVisibility(localb.uiJ);
              localView.animate().alpha(localb.Gnc).setDuration(150L).start();
            }
            else
            {
              localView.animate().alpha(localb.Gnc).setDuration(150L).withEndAction((Runnable)new d(localView, localb)).start();
            }
          }
        }
      }
    }
    this.Gna.clear();
    AppMethodBeat.o(239089);
  }
  
  public final z s(Set<Integer> paramSet)
  {
    AppMethodBeat.i(239081);
    p.k(paramSet, "ids");
    Log.i(this.TAG, "gone: ");
    u(paramSet);
    AppMethodBeat.o(239081);
    return this;
  }
  
  public final z t(Set<Integer> paramSet)
  {
    AppMethodBeat.i(239087);
    p.k(paramSet, "ids");
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      int i = ((Number)paramSet.next()).intValue();
      View localView = this.kJC;
      if (localView != null)
      {
        localView = localView.findViewById(i);
        if (localView != null)
        {
          int j = localView.getVisibility();
          if (j != 0) {}
          for (boolean bool = true;; bool = false)
          {
            b localb = new b(i, j, localView.getAlpha(), 0, 1.0F, bool);
            ((Map)this.Gna).put(Integer.valueOf(i), localb);
            if (!bool) {
              break;
            }
            localView.animate().cancel();
            localView.setVisibility(0);
            localView.animate().alpha(localb.Gne).setDuration(150L).start();
            break;
          }
        }
      }
    }
    AppMethodBeat.o(239087);
    return this;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$ViewState;", "", "id", "", "startState", "startAlpha", "", "endState", "endAlpha", "changed", "", "(IIFIFZ)V", "getChanged", "()Z", "getEndAlpha", "()F", "getEndState", "()I", "getId", "getStartAlpha", "getStartState", "plugin-mv_release"})
  public static final class b
  {
    final float Gnc;
    final int Gnd;
    final float Gne;
    final boolean bqf;
    final int id;
    final int uiJ;
    
    public b(int paramInt1, int paramInt2, float paramFloat1, int paramInt3, float paramFloat2, boolean paramBoolean)
    {
      this.id = paramInt1;
      this.uiJ = paramInt2;
      this.Gnc = paramFloat1;
      this.Gnd = paramInt3;
      this.Gne = paramFloat2;
      this.bqf = paramBoolean;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView, z.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(226019);
      this.AKP.setVisibility(localb.Gnd);
      AppMethodBeat.o(226019);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(View paramView, z.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(225399);
      this.AKP.setVisibility(localb.uiJ);
      AppMethodBeat.o(225399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.z
 * JD-Core Version:    0.7.0.1
 */