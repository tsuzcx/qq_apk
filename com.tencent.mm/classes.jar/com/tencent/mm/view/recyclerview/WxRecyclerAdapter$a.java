package com.tencent.mm.view.recyclerview;

import android.util.LongSparseArray;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "reset", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxRecyclerAdapter$a
  extends RecyclerView.l
{
  public int AOc;
  public int agOV;
  public int currentState;
  private final int rfr;
  public int vIj;
  public int vIk;
  
  public WxRecyclerAdapter$a()
  {
    AppMethodBeat.i(234859);
    this.vIj = -1;
    this.vIk = -1;
    this.rfr = ViewConfiguration.get(this.agOW.getRecyclerView().getContext()).getScaledTouchSlop();
    AppMethodBeat.o(234859);
  }
  
  private static final void a(int paramInt, a parama, RecyclerView paramRecyclerView, WxRecyclerAdapter paramWxRecyclerAdapter)
  {
    RecyclerView.v localv = null;
    Object localObject4 = null;
    Object localObject3 = null;
    int j = 0;
    AppMethodBeat.i(234893);
    s.u(parama, "this$0");
    s.u(paramRecyclerView, "$recyclerView");
    s.u(paramWxRecyclerAdapter, "this$1");
    ah.f localf = new ah.f();
    localf.aqH = new m(paramInt);
    ((m)localf.aqH).vIj = parama.vIj;
    ((m)localf.aqH).vIk = parama.vIk;
    Object localObject1 = paramRecyclerView.getLayoutManager();
    Object localObject2;
    label181:
    label208:
    int i;
    if ((localObject1 instanceof LinearLayoutManager))
    {
      ((m)localf.aqH).AOr = Math.max(0, ((LinearLayoutManager)localObject1).Ju());
      ((m)localf.aqH).AOt = Math.max(0, ((LinearLayoutManager)localObject1).Jw());
      localv = paramRecyclerView.w(((m)localf.aqH).AOr, false);
      if (localv == null)
      {
        localObject1 = null;
        if (localv != null) {
          break label259;
        }
        localObject2 = null;
        if (s.p(localObject1, localObject2)) {
          break label782;
        }
        paramRecyclerView = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
        if (localv != null) {
          break label272;
        }
        parama = null;
        paramRecyclerView = paramRecyclerView.append(parama).append(", layoutPosition=");
        if (localv != null) {
          break label284;
        }
      }
      label259:
      label272:
      label284:
      for (parama = (a)localObject3;; parama = Integer.valueOf(localv.KI()))
      {
        Log.w("RecyclerViewAdapterEx", parama);
        AppMethodBeat.o(234893);
        return;
        localObject1 = Integer.valueOf(localv.KJ());
        break;
        localObject2 = Integer.valueOf(localv.KI());
        break label181;
        parama = Integer.valueOf(localv.KJ());
        break label208;
      }
    }
    else if ((localObject1 instanceof StaggeredGridLayoutManager))
    {
      localObject2 = ((StaggeredGridLayoutManager)localObject1).n(null);
      localObject1 = ((StaggeredGridLayoutManager)localObject1).o(null);
      localObject3 = (m)localf.aqH;
      if (localObject2 == null)
      {
        paramInt = 0;
        if (localObject2 != null) {
          break label504;
        }
        i = 0;
        label351:
        ((m)localObject3).AOr = Math.min(paramInt, i);
        localObject2 = (m)localf.aqH;
        if (localObject1 != null) {
          break label513;
        }
        paramInt = 0;
        label379:
        if (localObject1 != null) {
          break label521;
        }
        i = 0;
        label387:
        ((m)localObject2).AOt = Math.max(paramInt, i);
        localObject3 = paramRecyclerView.fT(((m)localf.aqH).AOr);
        if (localObject3 != null) {
          break label530;
        }
        localObject1 = null;
        label423:
        if (localObject3 != null) {
          break label543;
        }
        localObject2 = null;
        label431:
        if (s.p(localObject1, localObject2)) {
          break label782;
        }
        paramRecyclerView = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
        if (localObject3 != null) {
          break label556;
        }
        parama = null;
        label458:
        paramRecyclerView = paramRecyclerView.append(parama).append(", layoutPosition=");
        if (localObject3 != null) {
          break label568;
        }
      }
      label513:
      label521:
      label530:
      label543:
      label556:
      label568:
      for (parama = localv;; parama = Integer.valueOf(((RecyclerView.v)localObject3).KI()))
      {
        Log.w("RecyclerViewAdapterEx", parama);
        AppMethodBeat.o(234893);
        return;
        paramInt = localObject2[0];
        break;
        label504:
        i = localObject2[1];
        break label351;
        paramInt = localObject1[0];
        break label379;
        i = localObject1[1];
        break label387;
        localObject1 = Integer.valueOf(((RecyclerView.v)localObject3).KJ());
        break label423;
        localObject2 = Integer.valueOf(((RecyclerView.v)localObject3).KI());
        break label431;
        parama = Integer.valueOf(((RecyclerView.v)localObject3).KJ());
        break label458;
      }
    }
    else
    {
      if (!(localObject1 instanceof GridLayoutManager)) {
        break label1826;
      }
      ((m)localf.aqH).AOr = Math.max(0, ((GridLayoutManager)localObject1).Ju());
      ((m)localf.aqH).AOt = Math.max(0, ((GridLayoutManager)localObject1).Jw());
      localv = paramRecyclerView.fT(((m)localf.aqH).AOr);
      if (localv == null)
      {
        localObject1 = null;
        if (localv != null) {
          break label745;
        }
        localObject2 = null;
        label667:
        if (s.p(localObject1, localObject2)) {
          break label782;
        }
        paramRecyclerView = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
        if (localv != null) {
          break label758;
        }
        parama = null;
        label694:
        paramRecyclerView = paramRecyclerView.append(parama).append(", layoutPosition=");
        if (localv != null) {
          break label770;
        }
      }
      label770:
      for (parama = localObject4;; parama = Integer.valueOf(localv.KI()))
      {
        Log.w("RecyclerViewAdapterEx", parama);
        AppMethodBeat.o(234893);
        return;
        localObject1 = Integer.valueOf(localv.KJ());
        break;
        label745:
        localObject2 = Integer.valueOf(localv.KI());
        break label667;
        label758:
        parama = Integer.valueOf(localv.KJ());
        break label694;
      }
    }
    label782:
    paramInt = 1;
    label849:
    int k;
    if (paramInt != 0)
    {
      parama.vIj = ((m)localf.aqH).AOr;
      parama.vIk = ((m)localf.aqH).AOt;
      for (;;)
      {
        try
        {
          paramInt = ((m)localf.aqH).AOr;
          i = ((m)localf.aqH).AOt;
          if (paramInt <= i)
          {
            if ((paramWxRecyclerAdapter.getItemCount() > 0) && ((paramInt >= 0) || (paramInt < paramWxRecyclerAdapter.getItemCount())))
            {
              k = paramInt - paramWxRecyclerAdapter.agOb.size();
              if (k >= 0) {
                continue;
              }
              parama = (a)paramWxRecyclerAdapter.aGe(paramInt);
              localObject1 = new n(parama);
              ((n)localObject1).AOn = paramInt;
              ((n)localObject1).AOo = ((l)paramWxRecyclerAdapter.agOM.get(parama.bZA()));
              ((m)localf.aqH).agOB.add(localObject1);
            }
            if (paramInt != i) {
              break label1819;
            }
          }
        }
        catch (Exception parama)
        {
          label1062:
          Log.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)parama, "", new Object[0]);
          continue;
        }
        if (((((m)localf.aqH).vIj != ((m)localf.aqH).AOr) || (((m)localf.aqH).vIk != ((m)localf.aqH).AOt)) && ((((m)localf.aqH).vIj != -1) || (((m)localf.aqH).vIk != -1))) {
          break;
        }
        ((m)localf.aqH).agOC.addAll((Collection)((m)localf.aqH).agOB);
        parama = new LongSparseArray();
        localObject1 = ((Iterable)((m)localf.aqH).agOB).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label1495;
        }
        localObject2 = (n)((Iterator)localObject1).next();
        parama.put(((n)localObject2).agOG.bZA(), localObject2);
        if (paramWxRecyclerAdapter.agOR.indexOfKey(((n)localObject2).agOG.bZA()) < 0)
        {
          ((m)localf.aqH).agOE.add(localObject2);
          continue;
          if (k >= WxRecyclerAdapter.f(paramWxRecyclerAdapter).size())
          {
            parama = (a)paramWxRecyclerAdapter.aGf(k - WxRecyclerAdapter.f(paramWxRecyclerAdapter).size());
          }
          else
          {
            parama = WxRecyclerAdapter.f(paramWxRecyclerAdapter).get(k);
            s.s(parama, "{\n                      …                        }");
            parama = (a)parama;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramInt = k.qv(((m)localf.aqH).AOr, ((m)localf.aqH).vIj);
        i = k.qv(paramWxRecyclerAdapter.getItemCount() - 1, k.qu(((m)localf.aqH).AOt, ((m)localf.aqH).vIk));
        if (paramInt > i) {
          break label1062;
        }
        if ((paramWxRecyclerAdapter.getItemCount() <= 0) || ((paramInt < 0) && (paramInt >= paramWxRecyclerAdapter.getItemCount()))) {
          break label1831;
        }
        k = paramInt - paramWxRecyclerAdapter.agOb.size();
        if (k < 0)
        {
          parama = (a)paramWxRecyclerAdapter.aGe(paramInt);
          localObject1 = new n(parama);
          ((n)localObject1).AOn = k;
          ((n)localObject1).AOo = ((l)paramWxRecyclerAdapter.agOM.get(parama.bZA()));
          ((m)localf.aqH).agOC.add(localObject1);
          break label1831;
        }
        if (k >= WxRecyclerAdapter.f(paramWxRecyclerAdapter).size())
        {
          parama = (a)paramWxRecyclerAdapter.aGf(k - WxRecyclerAdapter.f(paramWxRecyclerAdapter).size());
          continue;
        }
        parama = WxRecyclerAdapter.f(paramWxRecyclerAdapter).get(k);
        s.s(parama, "{\n                      …                        }");
        parama = (a)parama;
        continue;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)parama, "", new Object[0]);
      }
      label1495:
      k = paramWxRecyclerAdapter.agOR.size();
      if (k > 0) {}
      for (paramInt = 0;; paramInt = i)
      {
        i = paramInt + 1;
        localObject1 = (n)paramWxRecyclerAdapter.agOR.valueAt(paramInt);
        if (parama.indexOfKey(((n)localObject1).agOG.bZA()) < 0) {
          ((m)localf.aqH).agOD.add(localObject1);
        }
        if (i >= k)
        {
          paramWxRecyclerAdapter.agOR.clear();
          k = parama.size();
          if (k > 0) {}
          for (paramInt = j;; paramInt = i)
          {
            i = paramInt + 1;
            localObject1 = (n)parama.valueAt(paramInt);
            paramWxRecyclerAdapter.agOR.put(((n)localObject1).agOG.bZA(), localObject1);
            if (i >= k)
            {
              parama = ((Iterable)((m)localf.aqH).agOC).iterator();
              while (parama.hasNext())
              {
                localObject1 = (n)parama.next();
                if (paramWxRecyclerAdapter.agOQ.indexOfKey(((n)localObject1).agOG.bZA()) < 0) {
                  paramWxRecyclerAdapter.agOQ.put(((n)localObject1).agOG.bZA(), localObject1);
                }
                if (paramWxRecyclerAdapter.agOP.indexOfKey(((n)localObject1).agOG.bZA()) < 0)
                {
                  paramWxRecyclerAdapter.agOP.put(((n)localObject1).agOG.bZA(), localObject1);
                  ((m)localf.aqH).agOF.add(localObject1);
                }
              }
              parama = h.ahAA;
              paramRecyclerView = new WxRecyclerAdapter.a..ExternalSyntheticLambda1(paramWxRecyclerAdapter, paramRecyclerView, localf);
              paramWxRecyclerAdapter = o.agOH;
              parama.g(paramRecyclerView, o.a.jNo());
              AppMethodBeat.o(234893);
              return;
            }
          }
        }
      }
      label1819:
      paramInt += 1;
      break label849;
      label1826:
      paramInt = 0;
      break;
      label1831:
      if (paramInt == i) {
        break label1062;
      }
      paramInt += 1;
    }
  }
  
  private static final void a(WxRecyclerAdapter paramWxRecyclerAdapter, RecyclerView paramRecyclerView, ah.f paramf)
  {
    AppMethodBeat.i(234867);
    s.u(paramWxRecyclerAdapter, "this$0");
    s.u(paramRecyclerView, "$recyclerView");
    s.u(paramf, "$wxRVData");
    paramWxRecyclerAdapter = paramWxRecyclerAdapter.agOS;
    if (paramWxRecyclerAdapter != null) {
      paramWxRecyclerAdapter.a(paramRecyclerView, (m)paramf.aqH);
    }
    AppMethodBeat.o(234867);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(234901);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    s.u(paramRecyclerView, "recyclerView");
    paramRecyclerView.post(new WxRecyclerAdapter.a..ExternalSyntheticLambda0(paramInt, this, paramRecyclerView, this.agOW));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
    AppMethodBeat.o(234901);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234903);
    Object localObject = new b();
    ((b)localObject).cH(paramRecyclerView);
    ((b)localObject).sc(paramInt1);
    ((b)localObject).sc(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aYj());
    s.u(paramRecyclerView, "recyclerView");
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (this.currentState == 2)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(234903);
      return;
    }
    localObject = paramRecyclerView.getLayoutManager();
    s.checkNotNull(localObject);
    s.s(localObject, "recyclerView.layoutManager!!");
    if (((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {}
    for (;;)
    {
      this.agOV += paramInt1;
      if ((Math.abs(this.agOV) > this.rfr * 5) || ((this.AOc == 2) && (this.currentState == 1)))
      {
        onScrollStateChanged(paramRecyclerView, 3);
        this.agOV = 0;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(234903);
      return;
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter.a
 * JD-Core Version:    0.7.0.1
 */