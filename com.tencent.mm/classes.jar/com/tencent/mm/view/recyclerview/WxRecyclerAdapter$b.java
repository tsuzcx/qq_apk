package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.LongSparseArray;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "libmmui_release"})
public final class WxRecyclerAdapter$b
  extends RecyclerView.m
{
  private final int KMd;
  private int KMe;
  private int currentState;
  int mYh;
  int mYi;
  private int qsI;
  
  WxRecyclerAdapter$b(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(203995);
    this.mYh = -1;
    this.mYi = -1;
    paramRecyclerView = ViewConfiguration.get(localObject.getContext());
    k.g(paramRecyclerView, "ViewConfiguration.get(recyclerView.context)");
    this.KMd = paramRecyclerView.getScaledTouchSlop();
    AppMethodBeat.o(203995);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203994);
    Object localObject = new b();
    ((b)localObject).be(paramRecyclerView);
    ((b)localObject).lT(paramInt1);
    ((b)localObject).lT(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).ado());
    k.h(paramRecyclerView, "recyclerView");
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if (this.currentState == 2)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(203994);
      return;
    }
    localObject = paramRecyclerView.getLayoutManager();
    if (localObject == null) {
      k.fvU();
    }
    k.g(localObject, "recyclerView.layoutManager!!");
    if (((RecyclerView.i)localObject).jE()) {}
    for (;;)
    {
      this.KMe += paramInt1;
      if ((Math.abs(this.KMe) > this.KMd * 5) || ((this.qsI == 2) && (this.currentState == 1)))
      {
        b(paramRecyclerView, 3);
        this.KMe = 0;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(203994);
      return;
      paramInt1 = paramInt2;
    }
  }
  
  public final void b(final RecyclerView paramRecyclerView, final int paramInt)
  {
    AppMethodBeat.i(203993);
    b localb = new b();
    localb.be(paramRecyclerView);
    localb.lT(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
    k.h(paramRecyclerView, "recyclerView");
    paramRecyclerView.post((Runnable)new a(this, paramInt, paramRecyclerView));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(203993);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class a
    implements Runnable
  {
    a(WxRecyclerAdapter.b paramb, int paramInt, RecyclerView paramRecyclerView) {}
    
    public final void run()
    {
      int k = 0;
      AppMethodBeat.i(203992);
      Object localObject2 = new v.e();
      ((v.e)localObject2).Jhw = new g(paramInt);
      ((g)((v.e)localObject2).Jhw).mYh = this.LEj.mYh;
      ((g)((v.e)localObject2).Jhw).mYi = this.LEj.mYi;
      Object localObject3 = paramRecyclerView.getLayoutManager();
      Object localObject1;
      int j;
      if ((localObject3 instanceof LinearLayoutManager))
      {
        ((g)((v.e)localObject2).Jhw).qsi = Math.max(0, ((LinearLayoutManager)localObject3).jO());
        localObject1 = (g)((v.e)localObject2).Jhw;
        i = ((LinearLayoutManager)localObject3).jQ();
        j = 0;
        ((g)localObject1).qsj = Math.max(j, i);
      }
      label1410:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          this.LEj.mYh = ((g)((v.e)localObject2).Jhw).qsi;
          this.LEj.mYi = ((g)((v.e)localObject2).Jhw).qsj;
          i = ((g)((v.e)localObject2).Jhw).qsi;
          j = ((g)((v.e)localObject2).Jhw).qsj;
          label210:
          int m;
          Object localObject4;
          if (i <= j)
          {
            if ((this.LEj.LEi.getItemCount() > 0) && ((i >= 0) || (i < this.LEj.LEi.getItemCount())))
            {
              m = i - this.LEj.LEi.Ibl.size();
              if (m >= 0) {
                break label455;
              }
              localObject1 = (a)this.LEj.LEi.air(i);
            }
            for (;;)
            {
              localObject3 = new h((a)localObject1);
              ((h)localObject3).KMi = i;
              ((h)localObject3).KMj = ((f)this.LEj.LEi.LDZ.get(((a)localObject1).bMs()));
              ((g)((v.e)localObject2).Jhw).LDQ.add(localObject3);
              if (i == j) {
                break label541;
              }
              i += 1;
              break label210;
              if (!(localObject3 instanceof StaggeredGridLayoutManager)) {
                break label1410;
              }
              localObject1 = ((StaggeredGridLayoutManager)localObject3).x(null);
              localObject3 = ((StaggeredGridLayoutManager)localObject3).ma();
              localObject4 = (g)((v.e)localObject2).Jhw;
              if (localObject1 != null)
              {
                i = localObject1[0];
                label402:
                if (localObject1 == null) {
                  break label450;
                }
              }
              label450:
              for (j = localObject1[1];; j = 0)
              {
                ((g)localObject4).qsi = Math.min(i, j);
                localObject1 = (g)((v.e)localObject2).Jhw;
                j = localObject3[0];
                i = localObject3[1];
                break;
                i = 0;
                break label402;
              }
              label455:
              if (m >= WxRecyclerAdapter.a(this.LEj.LEi).size())
              {
                localObject1 = (a)this.LEj.LEi.ais(m - WxRecyclerAdapter.a(this.LEj.LEi).size());
              }
              else
              {
                localObject1 = WxRecyclerAdapter.a(this.LEj.LEi).get(m);
                k.g(localObject1, "data[dataIndex]");
                localObject1 = (a)localObject1;
              }
            }
          }
          label541:
          if (((((g)((v.e)localObject2).Jhw).mYh == ((g)((v.e)localObject2).Jhw).qsi) && (((g)((v.e)localObject2).Jhw).mYi == ((g)((v.e)localObject2).Jhw).qsj)) || ((((g)((v.e)localObject2).Jhw).mYh == -1) && (((g)((v.e)localObject2).Jhw).mYi == -1))) {
            ((g)((v.e)localObject2).Jhw).LDR.addAll((Collection)((g)((v.e)localObject2).Jhw).LDQ);
          }
          do
          {
            localObject1 = new LongSparseArray();
            localObject3 = ((Iterable)((g)((v.e)localObject2).Jhw).LDQ).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (h)((Iterator)localObject3).next();
              ((LongSparseArray)localObject1).put(((h)localObject4).LDU.bMs(), localObject4);
              if (this.LEj.LEi.LEd.indexOfKey(((h)localObject4).LDU.bMs()) < 0) {
                ((g)((v.e)localObject2).Jhw).LDT.add(localObject4);
              }
            }
            i = d.k.h.kL(((g)((v.e)localObject2).Jhw).qsi, ((g)((v.e)localObject2).Jhw).mYh);
            j = d.k.h.kL(this.LEj.LEi.getItemCount() - 1, d.k.h.kK(((g)((v.e)localObject2).Jhw).qsj, ((g)((v.e)localObject2).Jhw).mYi));
          } while (i > j);
          label837:
          if ((this.LEj.LEi.getItemCount() > 0) && ((i >= 0) || (i < this.LEj.LEi.getItemCount())))
          {
            m = i - this.LEj.LEi.Ibl.size();
            if (m >= 0) {
              break label981;
            }
            localObject1 = (a)this.LEj.LEi.air(i);
          }
          for (;;)
          {
            localObject3 = new h((a)localObject1);
            ((h)localObject3).KMi = m;
            ((h)localObject3).KMj = ((f)this.LEj.LEi.LDZ.get(((a)localObject1).bMs()));
            ((g)((v.e)localObject2).Jhw).LDR.add(localObject3);
            if (i == j) {
              break;
            }
            i += 1;
            break label837;
            label981:
            if (m >= WxRecyclerAdapter.a(this.LEj.LEi).size())
            {
              localObject1 = (a)this.LEj.LEi.ais(m - WxRecyclerAdapter.a(this.LEj.LEi).size());
            }
            else
            {
              localObject1 = WxRecyclerAdapter.a(this.LEj.LEi).get(m);
              k.g(localObject1, "data[dataIndex]");
              localObject1 = (a)localObject1;
            }
          }
          j = this.LEj.LEi.LEd.size();
          i = 0;
          while (i < j)
          {
            localObject3 = (h)this.LEj.LEi.LEd.valueAt(i);
            if (((LongSparseArray)localObject1).indexOfKey(((h)localObject3).LDU.bMs()) < 0) {
              ((g)((v.e)localObject2).Jhw).LDS.add(localObject3);
            }
            i += 1;
          }
          this.LEj.LEi.LEd.clear();
          j = ((LongSparseArray)localObject1).size();
          i = k;
          while (i < j)
          {
            localObject3 = (h)((LongSparseArray)localObject1).valueAt(i);
            this.LEj.LEi.LEd.put(((h)localObject3).LDU.bMs(), localObject3);
            i += 1;
          }
          localObject1 = ((Iterable)((g)((v.e)localObject2).Jhw).LDR).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (h)((Iterator)localObject1).next();
            if (this.LEj.LEi.LEc.indexOfKey(((h)localObject3).LDU.bMs()) < 0) {
              this.LEj.LEi.LEc.put(((h)localObject3).LDU.bMs(), localObject3);
            }
            if (this.LEj.LEi.LEb.indexOfKey(((h)localObject3).LDU.bMs()) < 0) {
              this.LEj.LEi.LEb.put(((h)localObject3).LDU.bMs(), localObject3);
            }
          }
          localObject1 = com.tencent.e.h.Iye;
          localObject2 = (Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203991);
              i locali = this.LEl.LEj.LEi.LEe;
              if (locali != null)
              {
                locali.a(this.LEl.qrn, (g)this.LEm.Jhw);
                AppMethodBeat.o(203991);
                return;
              }
              AppMethodBeat.o(203991);
            }
          };
          localObject3 = i.LDW;
          ((com.tencent.e.i)localObject1).f((Runnable)localObject2, i.a.gaz());
        }
        AppMethodBeat.o(203992);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter.b
 * JD-Core Version:    0.7.0.1
 */