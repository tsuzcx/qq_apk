package com.tencent.mm.view.recyclerview;

import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "convertTypeMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "dataChangeListener", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "dataScrollListener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isFirstViewHolder", "sessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getSessionExposeMap", "()Landroid/util/LongSparseArray;", "totalExposeMap", "getTotalExposeMap", "visibleExposeMap", "getVisibleExposeMap", "wxItemShowInfoMap", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getWxItemShowInfoMap", "wxRVListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getWxRVListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "setWxRVListener", "(Lcom/tencent/mm/view/recyclerview/WxRVListener;)V", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "_onBindHeaderHolder", "_onBindViewHolder", "payloads", "", "", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "_onCreateHeaderHolder", "_onCreateViewHolder", "viewType", "getData", "getFooterConvert", "getHeaderConvert", "getItemConvert", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindFirstBodyViewHolder", "onDetachedFromRecyclerView", "onPause", "onResume", "onViewAttachedToWindow", "wrapViewHolder", "view", "Landroid/view/View;", "libmmui_release"})
public class WxRecyclerAdapter<D extends a>
  extends d<e>
{
  private final SparseArray<b<?>> JCJ;
  public final LongSparseArray<f> JCK;
  private boolean JCL;
  public final LongSparseArray<h> JCM;
  public final LongSparseArray<h> JCN;
  final LongSparseArray<h> JCO;
  public i JCP;
  private RecyclerView.m JCQ;
  private RecyclerView.c JCR;
  private final boolean JCS;
  public final ArrayList<D> data;
  private final c rlE;
  
  public WxRecyclerAdapter(c paramc, ArrayList<D> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(197368);
    this.rlE = paramc;
    this.data = paramArrayList;
    this.JCS = paramBoolean;
    this.JCJ = new SparseArray();
    this.JCK = new LongSparseArray();
    this.JCL = true;
    this.JCM = new LongSparseArray();
    this.JCN = new LongSparseArray();
    this.JCO = new LongSparseArray();
    AppMethodBeat.o(197368);
  }
  
  private final b<D> Ac(int paramInt)
  {
    AppMethodBeat.i(164732);
    b localb = (b)this.JCJ.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.rlE.Ac(paramInt);
      if (localb == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
        AppMethodBeat.o(164732);
        throw ((Throwable)localObject);
      }
      this.JCJ.put(paramInt, localb);
      localObject = localb;
      if (!localb.JBV)
      {
        localb.a(getRecyclerView(), this);
        localObject = localb;
      }
    }
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
      AppMethodBeat.o(164732);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164732);
    return localObject;
  }
  
  private final b<d.b> adK(int paramInt)
  {
    AppMethodBeat.i(164733);
    b localb = (b)this.JCJ.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.rlE.Ac(paramInt);
      this.JCJ.put(paramInt, localb);
      localObject = localb;
      if (!localb.JBV)
      {
        localb.a(getRecyclerView(), this);
        localObject = localb;
      }
    }
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
      AppMethodBeat.o(164733);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164733);
    return localObject;
  }
  
  private final b<d.b> adL(int paramInt)
  {
    AppMethodBeat.i(164734);
    b localb = (b)this.JCJ.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.rlE.Ac(paramInt);
      if (localb == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
        AppMethodBeat.o(164734);
        throw ((Throwable)localObject);
      }
      this.JCJ.put(paramInt, localb);
      localObject = localb;
      if (!localb.JBV)
      {
        localb.a(getRecyclerView(), this);
        localObject = localb;
      }
    }
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
      AppMethodBeat.o(164734);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164734);
    return localObject;
  }
  
  public final int adF(int paramInt)
  {
    AppMethodBeat.i(164721);
    paramInt = ((a)this.data.get(paramInt)).bTF();
    AppMethodBeat.o(164721);
    return paramInt;
  }
  
  public final long adG(int paramInt)
  {
    AppMethodBeat.i(164722);
    long l = ((a)this.data.get(paramInt)).lx();
    AppMethodBeat.o(164722);
    return l;
  }
  
  public void b(e parame, int paramInt)
  {
    AppMethodBeat.i(182559);
    k.h(parame, "holder");
    int i = getItemViewType(this.JCb.size() + paramInt);
    Object localObject = this.data.get(paramInt);
    k.g(localObject, "data[position]");
    localObject = (a)localObject;
    parame.ej(localObject);
    parame.setRecyclerView(getRecyclerView());
    long l = SystemClock.uptimeMillis();
    Ac(i).a(parame, (a)localObject, paramInt, i, false, null);
    l = SystemClock.uptimeMillis() - l;
    if (l > 17L) {
      ac.i("RecyclerViewAdapterEx", "holder.setAssociatedObject pos:" + paramInt + ", item:" + localObject.hashCode() + " cost=" + l);
    }
    if (this.JCL)
    {
      this.JCL = false;
      getRecyclerView().post((Runnable)new a(this));
    }
    AppMethodBeat.o(182559);
  }
  
  public final void c(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182557);
    k.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    int j = this.JCJ.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      int k = this.JCJ.keyAt(i);
      localObject = this.JCJ.get(k);
      k.g(localObject, "convertTypeMap.get(key)");
      localObject = (b)localObject;
      if (!((b)localObject).JBV) {
        ((b)localObject).a(paramRecyclerView, this);
      }
      i += 1;
    }
    if (this.JCS)
    {
      localObject = new b(this, paramRecyclerView);
      paramRecyclerView.a((RecyclerView.m)localObject);
      this.JCQ = ((RecyclerView.m)localObject);
      paramRecyclerView = new c(this, paramRecyclerView);
      a((RecyclerView.c)paramRecyclerView);
      this.JCR = ((RecyclerView.c)paramRecyclerView);
    }
    AppMethodBeat.o(182557);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182558);
    k.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    int j = this.JCJ.size();
    int i = 0;
    while (i < j)
    {
      int k = this.JCJ.keyAt(i);
      Object localObject = this.JCJ.get(k);
      k.g(localObject, "convertTypeMap.get(key)");
      localObject = (b)localObject;
      if (((b)localObject).JBV) {
        ((b)localObject).d(paramRecyclerView);
      }
      i += 1;
    }
    paramRecyclerView = this.JCR;
    if (paramRecyclerView != null)
    {
      b(paramRecyclerView);
      AppMethodBeat.o(182558);
      return;
    }
    AppMethodBeat.o(182558);
  }
  
  public void e(final e parame)
  {
    AppMethodBeat.i(197363);
    k.h(parame, "holder");
    super.k((RecyclerView.w)parame);
    Object localObject1 = parame.asD;
    k.g(localObject1, "holder.itemView");
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      final a locala = (a)parame.fzs();
      if (locala != null)
      {
        if ((localObject1 instanceof StaggeredGridLayoutManager.LayoutParams))
        {
          i = ((StaggeredGridLayoutManager.LayoutParams)localObject1).mp();
          localObject2 = parame.asD;
          k.g(localObject2, "holder.itemView");
          int j = ((View)localObject2).getMeasuredWidth();
          localObject2 = parame.asD;
          k.g(localObject2, "holder.itemView");
          localObject2 = new f(i, j, ((View)localObject2).getMeasuredHeight());
          if ((((f)localObject2).width == 0) || (((f)localObject2).height == 0)) {
            parame.asD.post((Runnable)new f((f)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, parame));
          }
          this.JCK.put(locala.lx(), localObject2);
          AppMethodBeat.o(197363);
          return;
        }
        Object localObject2 = parame.asD;
        k.g(localObject2, "holder.itemView");
        int i = ((View)localObject2).getMeasuredWidth();
        localObject2 = parame.asD;
        k.g(localObject2, "holder.itemView");
        localObject2 = new f(0, i, ((View)localObject2).getMeasuredHeight());
        if ((((f)localObject2).width == 0) || (((f)localObject2).height == 0)) {
          parame.asD.post((Runnable)new g((f)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, parame));
        }
        this.JCK.put(locala.lx(), localObject2);
        AppMethodBeat.o(197363);
        return;
      }
      AppMethodBeat.o(197363);
      return;
    }
    AppMethodBeat.o(197363);
  }
  
  public final int fzq()
  {
    AppMethodBeat.i(164723);
    int i = this.data.size();
    AppMethodBeat.o(164723);
    return i;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(197367);
    getRecyclerView().post((Runnable)new d(this));
    AppMethodBeat.o(197367);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(197366);
    getRecyclerView().post((Runnable)new e(this));
    AppMethodBeat.o(197366);
  }
  
  public void t(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(197365);
    k.h(paramRecyclerView, "recyclerView");
    RecyclerView.m localm = this.JCQ;
    if (localm != null)
    {
      localm.b(paramRecyclerView, 5);
      AppMethodBeat.o(197365);
      return;
    }
    AppMethodBeat.o(197365);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class a
    implements Runnable
  {
    a(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(197346);
      this.JCT.t(this.JCT.getRecyclerView());
      AppMethodBeat.o(197346);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "libmmui_release"})
  public static final class b
    extends RecyclerView.m
  {
    private int JCU;
    private int currentState;
    int nAG;
    int nAH;
    private final int rdq;
    private int rdt;
    
    b(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(197351);
      this.nAG = -1;
      this.nAH = -1;
      paramRecyclerView = ViewConfiguration.get(localObject.getContext());
      k.g(paramRecyclerView, "ViewConfiguration.get(recyclerView.context)");
      this.rdq = paramRecyclerView.getScaledTouchSlop();
      AppMethodBeat.o(197351);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197350);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (this.currentState == 2)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(197350);
        return;
      }
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null) {
        k.fOy();
      }
      k.g(localObject, "recyclerView.layoutManager!!");
      if (((RecyclerView.i)localObject).jM()) {}
      for (;;)
      {
        this.JCU += paramInt1;
        if ((Math.abs(this.JCU) > this.rdq * 5) || ((this.rdt == 2) && (this.currentState == 1)))
        {
          b(paramRecyclerView, 3);
          this.JCU = 0;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(197350);
        return;
        paramInt1 = paramInt2;
      }
    }
    
    public final void b(final RecyclerView paramRecyclerView, final int paramInt)
    {
      AppMethodBeat.i(197349);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
      paramRecyclerView.post((Runnable)new a(this, paramInt, paramRecyclerView));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(197349);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.b paramb, int paramInt, RecyclerView paramRecyclerView) {}
      
      public final void run()
      {
        Object localObject5 = null;
        Object localObject6 = null;
        int k = 0;
        AppMethodBeat.i(197348);
        final v.f localf = new v.f();
        localf.KUQ = new g(paramInt);
        ((g)localf.KUQ).nAG = this.JCV.nAG;
        ((g)localf.KUQ).nAH = this.JCV.nAH;
        Object localObject4 = paramRecyclerView.getLayoutManager();
        Object localObject1;
        label187:
        int j;
        if ((localObject4 instanceof LinearLayoutManager))
        {
          ((g)localf.KUQ).rdH = Math.max(0, ((LinearLayoutManager)localObject4).jW());
          ((g)localf.KUQ).rdJ = Math.max(0, ((LinearLayoutManager)localObject4).jY());
          localObject5 = paramRecyclerView.ch(((g)localf.KUQ).rdH);
          if (localObject5 != null)
          {
            localObject1 = Integer.valueOf(((RecyclerView.w)localObject5).lv());
            if (localObject5 == null) {
              break label285;
            }
            localObject4 = Integer.valueOf(((RecyclerView.w)localObject5).lu());
            if (!(k.g(localObject1, localObject4) ^ true)) {
              break label558;
            }
            localObject4 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
            if (localObject5 == null) {
              break label291;
            }
          }
          label285:
          label291:
          for (localObject1 = Integer.valueOf(((RecyclerView.w)localObject5).lv());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject6;
            if (localObject5 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.w)localObject5).lu());
            }
            ac.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(197348);
            return;
            localObject1 = null;
            break;
            localObject4 = null;
            break label187;
          }
        }
        else
        {
          if (!(localObject4 instanceof StaggeredGridLayoutManager)) {
            break label1748;
          }
          localObject1 = ((StaggeredGridLayoutManager)localObject4).n(null);
          localObject4 = ((StaggeredGridLayoutManager)localObject4).mi();
          localObject6 = (g)localf.KUQ;
          if (localObject1 != null)
          {
            i = localObject1[0];
            if (localObject1 == null) {
              break label535;
            }
            j = localObject1[1];
            label356:
            ((g)localObject6).rdH = Math.min(i, j);
            ((g)localf.KUQ).rdJ = Math.max(localObject4[0], localObject4[1]);
            localObject6 = paramRecyclerView.ch(((g)localf.KUQ).rdH);
            if (localObject6 == null) {
              break label540;
            }
            localObject1 = Integer.valueOf(((RecyclerView.w)localObject6).lv());
            label423:
            if (localObject6 == null) {
              break label546;
            }
            localObject4 = Integer.valueOf(((RecyclerView.w)localObject6).lu());
            label438:
            if (!(k.g(localObject1, localObject4) ^ true)) {
              break label558;
            }
            localObject4 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
            if (localObject6 == null) {
              break label552;
            }
          }
          label535:
          label540:
          label546:
          label552:
          for (localObject1 = Integer.valueOf(((RecyclerView.w)localObject6).lv());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject5;
            if (localObject6 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.w)localObject6).lu());
            }
            ac.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(197348);
            return;
            i = 0;
            break;
            j = 0;
            break label356;
            localObject1 = null;
            break label423;
            localObject4 = null;
            break label438;
          }
        }
        label558:
        int i = 1;
        label629:
        int m;
        label867:
        Object localObject2;
        if (i != 0)
        {
          this.JCV.nAG = ((g)localf.KUQ).rdH;
          this.JCV.nAH = ((g)localf.KUQ).rdJ;
          try
          {
            i = ((g)localf.KUQ).rdH;
            j = ((g)localf.KUQ).rdJ;
            if (i <= j)
            {
              if ((this.JCV.JCT.getItemCount() <= 0) || ((i < 0) && (i >= this.JCV.JCT.getItemCount()))) {
                break label1753;
              }
              m = i - this.JCV.JCT.JCb.size();
              if (m < 0) {
                localObject1 = (a)this.JCV.JCT.adH(i);
              }
              for (;;)
              {
                localObject4 = new h((a)localObject1);
                ((h)localObject4).rdE = i;
                ((h)localObject4).rdF = ((f)this.JCV.JCT.JCK.get(((a)localObject1).lx()));
                ((g)localf.KUQ).JCA.add(localObject4);
                break;
                if (m >= WxRecyclerAdapter.a(this.JCV.JCT).size())
                {
                  localObject1 = (a)this.JCV.JCT.adI(m - WxRecyclerAdapter.a(this.JCV.JCT).size());
                }
                else
                {
                  localObject1 = WxRecyclerAdapter.a(this.JCV.JCT).get(m);
                  k.g(localObject1, "data[dataIndex]");
                  localObject1 = (a)localObject1;
                }
              }
            }
            if (((g)localf.KUQ).nAG != ((g)localf.KUQ).rdH) {}
          }
          catch (Exception localException1)
          {
            ac.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException1, "", new Object[0]);
          }
          if ((((g)localf.KUQ).nAH == ((g)localf.KUQ).rdJ) || ((((g)localf.KUQ).nAG == -1) && (((g)localf.KUQ).nAH == -1)))
          {
            ((g)localf.KUQ).JCB.addAll((Collection)((g)localf.KUQ).JCA);
            label976:
            localObject2 = new LongSparseArray();
            localObject4 = ((Iterable)((g)localf.KUQ).JCA).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (h)((Iterator)localObject4).next();
              ((LongSparseArray)localObject2).put(((h)localObject5).JCE.lx(), localObject5);
              if (this.JCV.JCT.JCO.indexOfKey(((h)localObject5).JCE.lx()) < 0) {
                ((g)localf.KUQ).JCD.add(localObject5);
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            i = d.k.h.lb(((g)localf.KUQ).rdH, ((g)localf.KUQ).nAG);
            j = d.k.h.lb(this.JCV.JCT.getItemCount() - 1, d.k.h.la(((g)localf.KUQ).rdJ, ((g)localf.KUQ).nAH));
            if (i > j) {
              break label976;
            }
            if ((this.JCV.JCT.getItemCount() <= 0) || ((i < 0) && (i >= this.JCV.JCT.getItemCount()))) {
              break label1765;
            }
            m = i - this.JCV.JCT.JCb.size();
            if (m < 0)
            {
              localObject2 = (a)this.JCV.JCT.adH(i);
              localObject4 = new h((a)localObject2);
              ((h)localObject4).rdE = m;
              ((h)localObject4).rdF = ((f)this.JCV.JCT.JCK.get(((a)localObject2).lx()));
              ((g)localf.KUQ).JCB.add(localObject4);
              break label1765;
            }
            if (m >= WxRecyclerAdapter.a(this.JCV.JCT).size())
            {
              localObject2 = (a)this.JCV.JCT.adI(m - WxRecyclerAdapter.a(this.JCV.JCT).size());
              continue;
            }
            localObject2 = WxRecyclerAdapter.a(this.JCV.JCT).get(m);
            k.g(localObject2, "data[dataIndex]");
            localObject2 = (a)localObject2;
            continue;
          }
          catch (Exception localException2)
          {
            ac.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException2, "", new Object[0]);
          }
          j = this.JCV.JCT.JCO.size();
          i = 0;
          while (i < j)
          {
            localObject4 = (h)this.JCV.JCT.JCO.valueAt(i);
            if (localException2.indexOfKey(((h)localObject4).JCE.lx()) < 0) {
              ((g)localf.KUQ).JCC.add(localObject4);
            }
            i += 1;
          }
          this.JCV.JCT.JCO.clear();
          j = localException2.size();
          i = k;
          while (i < j)
          {
            localObject4 = (h)localException2.valueAt(i);
            this.JCV.JCT.JCO.put(((h)localObject4).JCE.lx(), localObject4);
            i += 1;
          }
          Object localObject3 = ((Iterable)((g)localf.KUQ).JCB).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (h)((Iterator)localObject3).next();
            if (this.JCV.JCT.JCN.indexOfKey(((h)localObject4).JCE.lx()) < 0) {
              this.JCV.JCT.JCN.put(((h)localObject4).JCE.lx(), localObject4);
            }
            if (this.JCV.JCT.JCM.indexOfKey(((h)localObject4).JCE.lx()) < 0) {
              this.JCV.JCT.JCM.put(((h)localObject4).JCE.lx(), localObject4);
            }
          }
          localObject3 = com.tencent.e.h.JZN;
          localObject4 = (Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197347);
              i locali = this.JCX.JCV.JCT.JCP;
              if (locali != null)
              {
                locali.a(this.JCX.rbu, (g)localf.KUQ);
                AppMethodBeat.o(197347);
                return;
              }
              AppMethodBeat.o(197347);
            }
          };
          localObject5 = i.JCG;
          ((com.tencent.e.i)localObject3).f((Runnable)localObject4, i.a.fzt());
          AppMethodBeat.o(197348);
          return;
          label1748:
          i = 0;
          break;
          label1753:
          if (i == j) {
            break label867;
          }
          i += 1;
          break label629;
          label1765:
          if (i == j) {
            break label976;
          }
          i += 1;
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$3", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "notifyChangeEvent", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class c
    extends RecyclerView.c
  {
    c(RecyclerView paramRecyclerView) {}
    
    private void fzu()
    {
      AppMethodBeat.i(197353);
      paramRecyclerView.post((Runnable)new a(this));
      AppMethodBeat.o(197353);
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197356);
      super.at(paramInt1, paramInt2);
      fzu();
      AppMethodBeat.o(197356);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197358);
      super.au(paramInt1, paramInt2);
      fzu();
      AppMethodBeat.o(197358);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(197355);
      super.f(paramInt1, paramInt2, paramObject);
      fzu();
      AppMethodBeat.o(197355);
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(197357);
      super.l(paramInt1, paramInt2, paramInt3);
      fzu();
      AppMethodBeat.o(197357);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(197354);
      super.onChanged();
      fzu();
      AppMethodBeat.o(197354);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(197352);
        RecyclerView.m localm = WxRecyclerAdapter.b(this.JCZ.JCT);
        if (localm != null)
        {
          localm.b(this.JCZ.rbu, 8);
          AppMethodBeat.o(197352);
          return;
        }
        AppMethodBeat.o(197352);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class d
    implements Runnable
  {
    d(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(197359);
      ac.i("RecyclerViewAdapterEx", "onPause visibleExposeMap.size:" + this.JCT.JCO.size() + " sessionExposeMap.size:" + this.JCT.JCN.size());
      this.JCT.JCO.clear();
      this.JCT.JCN.clear();
      AppMethodBeat.o(197359);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class e
    implements Runnable
  {
    e(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(197360);
      RecyclerView.m localm = WxRecyclerAdapter.b(this.JCT);
      if (localm != null)
      {
        localm.b(this.JCT.getRecyclerView(), 7);
        AppMethodBeat.o(197360);
        return;
      }
      AppMethodBeat.o(197360);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$1$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$1"})
  static final class f
    implements Runnable
  {
    f(f paramf, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(197361);
      f localf = this.JDa;
      View localView = parame.asD;
      k.g(localView, "holder.itemView");
      localf.width = localView.getMeasuredWidth();
      localf = this.JDa;
      localView = parame.asD;
      k.g(localView, "holder.itemView");
      localf.height = localView.getMeasuredHeight();
      AppMethodBeat.o(197361);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$2$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$2", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$2"})
  static final class g
    implements Runnable
  {
    g(f paramf, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(197362);
      f localf = this.JDa;
      View localView = parame.asD;
      k.g(localView, "holder.itemView");
      localf.width = localView.getMeasuredWidth();
      localf = this.JDa;
      localView = parame.asD;
      k.g(localView, "holder.itemView");
      localf.height = localView.getMeasuredHeight();
      AppMethodBeat.o(197362);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */