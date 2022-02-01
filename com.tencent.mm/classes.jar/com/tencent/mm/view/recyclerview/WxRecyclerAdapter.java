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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "convertTypeMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "dataChangeListener", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "dataScrollListener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isFirstViewHolder", "sessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getSessionExposeMap", "()Landroid/util/LongSparseArray;", "totalExposeMap", "getTotalExposeMap", "visibleExposeMap", "getVisibleExposeMap", "wxItemShowInfoMap", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getWxItemShowInfoMap", "wxRVListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getWxRVListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "setWxRVListener", "(Lcom/tencent/mm/view/recyclerview/WxRVListener;)V", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "_onBindHeaderHolder", "_onBindViewHolder", "payloads", "", "", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "_onCreateHeaderHolder", "_onCreateViewHolder", "viewType", "getData", "getFooterConvert", "getHeaderConvert", "getItemConvert", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindFirstBodyViewHolder", "onDetachedFromRecyclerView", "onPause", "onResume", "onViewAttachedToWindow", "wrapViewHolder", "view", "Landroid/view/View;", "libmmui_release"})
public class WxRecyclerAdapter<D extends a>
  extends d<e>
{
  private final SparseArray<b<?>> LvP;
  public final LongSparseArray<f> LvQ;
  private boolean LvR;
  public final LongSparseArray<h> LvS;
  public final LongSparseArray<h> LvT;
  final LongSparseArray<h> LvU;
  public i LvV;
  private RecyclerView.m LvW;
  private RecyclerView.c LvX;
  private final boolean LvY;
  public final ArrayList<D> data;
  private final c sam;
  
  public WxRecyclerAdapter(c paramc, ArrayList<D> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(186701);
    this.sam = paramc;
    this.data = paramArrayList;
    this.LvY = paramBoolean;
    this.LvP = new SparseArray();
    this.LvQ = new LongSparseArray();
    this.LvR = true;
    this.LvS = new LongSparseArray();
    this.LvT = new LongSparseArray();
    this.LvU = new LongSparseArray();
    AppMethodBeat.o(186701);
  }
  
  private final b<D> AL(int paramInt)
  {
    AppMethodBeat.i(164732);
    b localb = (b)this.LvP.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.sam.AL(paramInt);
      if (localb == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
        AppMethodBeat.o(164732);
        throw ((Throwable)localObject);
      }
      this.LvP.put(paramInt, localb);
      localObject = localb;
      if (!localb.Lvc)
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
  
  private final b<d.b> agk(int paramInt)
  {
    AppMethodBeat.i(164733);
    b localb = (b)this.LvP.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.sam.AL(paramInt);
      this.LvP.put(paramInt, localb);
      localObject = localb;
      if (!localb.Lvc)
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
  
  private final b<d.b> agl(int paramInt)
  {
    AppMethodBeat.i(164734);
    b localb = (b)this.LvP.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.sam.AL(paramInt);
      if (localb == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
        AppMethodBeat.o(164734);
        throw ((Throwable)localObject);
      }
      this.LvP.put(paramInt, localb);
      localObject = localb;
      if (!localb.Lvc)
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
  
  public void a(e parame, int paramInt)
  {
    AppMethodBeat.i(182559);
    p.h(parame, "holder");
    int i = getItemViewType(this.Lvi.size() + paramInt);
    Object localObject = this.data.get(paramInt);
    p.g(localObject, "data[position]");
    localObject = (a)localObject;
    parame.em(localObject);
    parame.setRecyclerView(getRecyclerView());
    long l = SystemClock.uptimeMillis();
    AL(i).a(parame, (a)localObject, paramInt, i, false, null);
    l = SystemClock.uptimeMillis() - l;
    if (l > 17L) {
      ad.i("RecyclerViewAdapterEx", "holder.setAssociatedObject pos:" + paramInt + ", item:" + localObject.hashCode() + " cost=" + l);
    }
    if (this.LvR)
    {
      this.LvR = false;
      getRecyclerView().post((Runnable)new a(this));
    }
    AppMethodBeat.o(182559);
  }
  
  public final int agf(int paramInt)
  {
    AppMethodBeat.i(164721);
    paramInt = ((a)this.data.get(paramInt)).bYk();
    AppMethodBeat.o(164721);
    return paramInt;
  }
  
  public final long agg(int paramInt)
  {
    AppMethodBeat.i(164722);
    long l = ((a)this.data.get(paramInt)).lP();
    AppMethodBeat.o(164722);
    return l;
  }
  
  public final void c(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182557);
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    int j = this.LvP.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      int k = this.LvP.keyAt(i);
      localObject = this.LvP.get(k);
      p.g(localObject, "convertTypeMap.get(key)");
      localObject = (b)localObject;
      if (!((b)localObject).Lvc) {
        ((b)localObject).a(paramRecyclerView, this);
      }
      i += 1;
    }
    if (this.LvY)
    {
      localObject = new b(this, paramRecyclerView);
      paramRecyclerView.a((RecyclerView.m)localObject);
      this.LvW = ((RecyclerView.m)localObject);
      paramRecyclerView = new c(this, paramRecyclerView);
      a((RecyclerView.c)paramRecyclerView);
      this.LvX = ((RecyclerView.c)paramRecyclerView);
    }
    AppMethodBeat.o(182557);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182558);
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    int j = this.LvP.size();
    int i = 0;
    while (i < j)
    {
      int k = this.LvP.keyAt(i);
      Object localObject = this.LvP.get(k);
      p.g(localObject, "convertTypeMap.get(key)");
      localObject = (b)localObject;
      if (((b)localObject).Lvc) {
        ((b)localObject).d(paramRecyclerView);
      }
      i += 1;
    }
    paramRecyclerView = this.LvX;
    if (paramRecyclerView != null)
    {
      b(paramRecyclerView);
      AppMethodBeat.o(182558);
      return;
    }
    AppMethodBeat.o(182558);
  }
  
  public void f(final e parame)
  {
    AppMethodBeat.i(186696);
    p.h(parame, "holder");
    super.k((RecyclerView.w)parame);
    Object localObject1 = parame.auu;
    p.g(localObject1, "holder.itemView");
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      final a locala = (a)parame.fQC();
      if (locala != null)
      {
        if ((localObject1 instanceof StaggeredGridLayoutManager.LayoutParams))
        {
          i = ((StaggeredGridLayoutManager.LayoutParams)localObject1).mH();
          localObject2 = parame.auu;
          p.g(localObject2, "holder.itemView");
          int j = ((View)localObject2).getMeasuredWidth();
          localObject2 = parame.auu;
          p.g(localObject2, "holder.itemView");
          localObject2 = new f(i, j, ((View)localObject2).getMeasuredHeight());
          if ((((f)localObject2).width == 0) || (((f)localObject2).height == 0)) {
            parame.auu.post((Runnable)new f((f)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, parame));
          }
          this.LvQ.put(locala.lP(), localObject2);
          AppMethodBeat.o(186696);
          return;
        }
        Object localObject2 = parame.auu;
        p.g(localObject2, "holder.itemView");
        int i = ((View)localObject2).getMeasuredWidth();
        localObject2 = parame.auu;
        p.g(localObject2, "holder.itemView");
        localObject2 = new f(0, i, ((View)localObject2).getMeasuredHeight());
        if ((((f)localObject2).width == 0) || (((f)localObject2).height == 0)) {
          parame.auu.post((Runnable)new g((f)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, parame));
        }
        this.LvQ.put(locala.lP(), localObject2);
        AppMethodBeat.o(186696);
        return;
      }
      AppMethodBeat.o(186696);
      return;
    }
    AppMethodBeat.o(186696);
  }
  
  public final int fQA()
  {
    AppMethodBeat.i(164723);
    int i = this.data.size();
    AppMethodBeat.o(164723);
    return i;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(186700);
    getRecyclerView().post((Runnable)new d(this));
    AppMethodBeat.o(186700);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(186699);
    getRecyclerView().post((Runnable)new e(this));
    AppMethodBeat.o(186699);
  }
  
  public void t(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(186698);
    p.h(paramRecyclerView, "recyclerView");
    RecyclerView.m localm = this.LvW;
    if (localm != null)
    {
      localm.b(paramRecyclerView, 5);
      AppMethodBeat.o(186698);
      return;
    }
    AppMethodBeat.o(186698);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class a
    implements Runnable
  {
    a(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(186679);
      this.LvZ.t(this.LvZ.getRecyclerView());
      AppMethodBeat.o(186679);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "libmmui_release"})
  public static final class b
    extends RecyclerView.m
  {
    private int Lwa;
    private int currentState;
    int obN;
    int obO;
    private final int rQM;
    private int rQP;
    
    b(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(186684);
      this.obN = -1;
      this.obO = -1;
      paramRecyclerView = ViewConfiguration.get(localObject.getContext());
      p.g(paramRecyclerView, "ViewConfiguration.get(recyclerView.context)");
      this.rQM = paramRecyclerView.getScaledTouchSlop();
      AppMethodBeat.o(186684);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186683);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (this.currentState == 2)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(186683);
        return;
      }
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null) {
        p.gfZ();
      }
      p.g(localObject, "recyclerView.layoutManager!!");
      if (((RecyclerView.i)localObject).kc()) {}
      for (;;)
      {
        this.Lwa += paramInt1;
        if ((Math.abs(this.Lwa) > this.rQM * 5) || ((this.rQP == 2) && (this.currentState == 1)))
        {
          b(paramRecyclerView, 3);
          this.Lwa = 0;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(186683);
        return;
        paramInt1 = paramInt2;
      }
    }
    
    public final void b(final RecyclerView paramRecyclerView, final int paramInt)
    {
      AppMethodBeat.i(186682);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      paramRecyclerView.post((Runnable)new a(this, paramInt, paramRecyclerView));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(186682);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.b paramb, int paramInt, RecyclerView paramRecyclerView) {}
      
      public final void run()
      {
        Object localObject5 = null;
        Object localObject6 = null;
        int k = 0;
        AppMethodBeat.i(186681);
        final y.f localf = new y.f();
        localf.MLV = new g(paramInt);
        ((g)localf.MLV).obN = this.Lwb.obN;
        ((g)localf.MLV).obO = this.Lwb.obO;
        Object localObject4 = paramRecyclerView.getLayoutManager();
        Object localObject1;
        label187:
        int j;
        if ((localObject4 instanceof LinearLayoutManager))
        {
          ((g)localf.MLV).rRd = Math.max(0, ((LinearLayoutManager)localObject4).km());
          ((g)localf.MLV).rRf = Math.max(0, ((LinearLayoutManager)localObject4).ko());
          localObject5 = paramRecyclerView.ch(((g)localf.MLV).rRd);
          if (localObject5 != null)
          {
            localObject1 = Integer.valueOf(((RecyclerView.w)localObject5).lN());
            if (localObject5 == null) {
              break label285;
            }
            localObject4 = Integer.valueOf(((RecyclerView.w)localObject5).lM());
            if (!(p.i(localObject1, localObject4) ^ true)) {
              break label558;
            }
            localObject4 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
            if (localObject5 == null) {
              break label291;
            }
          }
          label285:
          label291:
          for (localObject1 = Integer.valueOf(((RecyclerView.w)localObject5).lN());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject6;
            if (localObject5 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.w)localObject5).lM());
            }
            ad.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(186681);
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
          localObject4 = ((StaggeredGridLayoutManager)localObject4).mA();
          localObject6 = (g)localf.MLV;
          if (localObject1 != null)
          {
            i = localObject1[0];
            if (localObject1 == null) {
              break label535;
            }
            j = localObject1[1];
            label356:
            ((g)localObject6).rRd = Math.min(i, j);
            ((g)localf.MLV).rRf = Math.max(localObject4[0], localObject4[1]);
            localObject6 = paramRecyclerView.ch(((g)localf.MLV).rRd);
            if (localObject6 == null) {
              break label540;
            }
            localObject1 = Integer.valueOf(((RecyclerView.w)localObject6).lN());
            label423:
            if (localObject6 == null) {
              break label546;
            }
            localObject4 = Integer.valueOf(((RecyclerView.w)localObject6).lM());
            label438:
            if (!(p.i(localObject1, localObject4) ^ true)) {
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
          for (localObject1 = Integer.valueOf(((RecyclerView.w)localObject6).lN());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject5;
            if (localObject6 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.w)localObject6).lM());
            }
            ad.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(186681);
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
          this.Lwb.obN = ((g)localf.MLV).rRd;
          this.Lwb.obO = ((g)localf.MLV).rRf;
          try
          {
            i = ((g)localf.MLV).rRd;
            j = ((g)localf.MLV).rRf;
            if (i <= j)
            {
              if ((this.Lwb.LvZ.getItemCount() <= 0) || ((i < 0) && (i >= this.Lwb.LvZ.getItemCount()))) {
                break label1753;
              }
              m = i - this.Lwb.LvZ.Lvi.size();
              if (m < 0) {
                localObject1 = (a)this.Lwb.LvZ.agh(i);
              }
              for (;;)
              {
                localObject4 = new h((a)localObject1);
                ((h)localObject4).rRa = i;
                ((h)localObject4).rRb = ((f)this.Lwb.LvZ.LvQ.get(((a)localObject1).lP()));
                ((g)localf.MLV).LvG.add(localObject4);
                break;
                if (m >= WxRecyclerAdapter.a(this.Lwb.LvZ).size())
                {
                  localObject1 = (a)this.Lwb.LvZ.agi(m - WxRecyclerAdapter.a(this.Lwb.LvZ).size());
                }
                else
                {
                  localObject1 = WxRecyclerAdapter.a(this.Lwb.LvZ).get(m);
                  p.g(localObject1, "data[dataIndex]");
                  localObject1 = (a)localObject1;
                }
              }
            }
            if (((g)localf.MLV).obN != ((g)localf.MLV).rRd) {}
          }
          catch (Exception localException1)
          {
            ad.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException1, "", new Object[0]);
          }
          if ((((g)localf.MLV).obO == ((g)localf.MLV).rRf) || ((((g)localf.MLV).obN == -1) && (((g)localf.MLV).obO == -1)))
          {
            ((g)localf.MLV).LvH.addAll((Collection)((g)localf.MLV).LvG);
            label976:
            localObject2 = new LongSparseArray();
            localObject4 = ((Iterable)((g)localf.MLV).LvG).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (h)((Iterator)localObject4).next();
              ((LongSparseArray)localObject2).put(((h)localObject5).LvK.lP(), localObject5);
              if (this.Lwb.LvZ.LvU.indexOfKey(((h)localObject5).LvK.lP()) < 0) {
                ((g)localf.MLV).LvJ.add(localObject5);
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            i = d.k.h.lq(((g)localf.MLV).rRd, ((g)localf.MLV).obN);
            j = d.k.h.lq(this.Lwb.LvZ.getItemCount() - 1, d.k.h.lp(((g)localf.MLV).rRf, ((g)localf.MLV).obO));
            if (i > j) {
              break label976;
            }
            if ((this.Lwb.LvZ.getItemCount() <= 0) || ((i < 0) && (i >= this.Lwb.LvZ.getItemCount()))) {
              break label1765;
            }
            m = i - this.Lwb.LvZ.Lvi.size();
            if (m < 0)
            {
              localObject2 = (a)this.Lwb.LvZ.agh(i);
              localObject4 = new h((a)localObject2);
              ((h)localObject4).rRa = m;
              ((h)localObject4).rRb = ((f)this.Lwb.LvZ.LvQ.get(((a)localObject2).lP()));
              ((g)localf.MLV).LvH.add(localObject4);
              break label1765;
            }
            if (m >= WxRecyclerAdapter.a(this.Lwb.LvZ).size())
            {
              localObject2 = (a)this.Lwb.LvZ.agi(m - WxRecyclerAdapter.a(this.Lwb.LvZ).size());
              continue;
            }
            localObject2 = WxRecyclerAdapter.a(this.Lwb.LvZ).get(m);
            p.g(localObject2, "data[dataIndex]");
            localObject2 = (a)localObject2;
            continue;
          }
          catch (Exception localException2)
          {
            ad.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException2, "", new Object[0]);
          }
          j = this.Lwb.LvZ.LvU.size();
          i = 0;
          while (i < j)
          {
            localObject4 = (h)this.Lwb.LvZ.LvU.valueAt(i);
            if (localException2.indexOfKey(((h)localObject4).LvK.lP()) < 0) {
              ((g)localf.MLV).LvI.add(localObject4);
            }
            i += 1;
          }
          this.Lwb.LvZ.LvU.clear();
          j = localException2.size();
          i = k;
          while (i < j)
          {
            localObject4 = (h)localException2.valueAt(i);
            this.Lwb.LvZ.LvU.put(((h)localObject4).LvK.lP(), localObject4);
            i += 1;
          }
          Object localObject3 = ((Iterable)((g)localf.MLV).LvH).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (h)((Iterator)localObject3).next();
            if (this.Lwb.LvZ.LvT.indexOfKey(((h)localObject4).LvK.lP()) < 0) {
              this.Lwb.LvZ.LvT.put(((h)localObject4).LvK.lP(), localObject4);
            }
            if (this.Lwb.LvZ.LvS.indexOfKey(((h)localObject4).LvK.lP()) < 0) {
              this.Lwb.LvZ.LvS.put(((h)localObject4).LvK.lP(), localObject4);
            }
          }
          localObject3 = com.tencent.e.h.LTJ;
          localObject4 = (Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186680);
              i locali = this.Lwd.Lwb.LvZ.LvV;
              if (locali != null)
              {
                locali.a(this.Lwd.rOk, (g)localf.MLV);
                AppMethodBeat.o(186680);
                return;
              }
              AppMethodBeat.o(186680);
            }
          };
          localObject5 = i.LvM;
          ((com.tencent.e.i)localObject3).f((Runnable)localObject4, i.a.fQD());
          AppMethodBeat.o(186681);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$3", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "notifyChangeEvent", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class c
    extends RecyclerView.c
  {
    c(RecyclerView paramRecyclerView) {}
    
    private void fQE()
    {
      AppMethodBeat.i(186686);
      paramRecyclerView.post((Runnable)new a(this));
      AppMethodBeat.o(186686);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186689);
      super.au(paramInt1, paramInt2);
      fQE();
      AppMethodBeat.o(186689);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(186691);
      super.av(paramInt1, paramInt2);
      fQE();
      AppMethodBeat.o(186691);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(186688);
      super.f(paramInt1, paramInt2, paramObject);
      fQE();
      AppMethodBeat.o(186688);
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(186690);
      super.l(paramInt1, paramInt2, paramInt3);
      fQE();
      AppMethodBeat.o(186690);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(186687);
      super.onChanged();
      fQE();
      AppMethodBeat.o(186687);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(186685);
        RecyclerView.m localm = WxRecyclerAdapter.b(this.Lwf.LvZ);
        if (localm != null)
        {
          localm.b(this.Lwf.rOk, 8);
          AppMethodBeat.o(186685);
          return;
        }
        AppMethodBeat.o(186685);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class d
    implements Runnable
  {
    d(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(186692);
      ad.i("RecyclerViewAdapterEx", "onPause visibleExposeMap.size:" + this.LvZ.LvU.size() + " sessionExposeMap.size:" + this.LvZ.LvT.size());
      this.LvZ.LvU.clear();
      this.LvZ.LvT.clear();
      AppMethodBeat.o(186692);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class e
    implements Runnable
  {
    e(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(186693);
      RecyclerView.m localm = WxRecyclerAdapter.b(this.LvZ);
      if (localm != null)
      {
        localm.b(this.LvZ.getRecyclerView(), 7);
        AppMethodBeat.o(186693);
        return;
      }
      AppMethodBeat.o(186693);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$1$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$1"})
  static final class f
    implements Runnable
  {
    f(f paramf, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(186694);
      f localf = this.Lwg;
      View localView = parame.auu;
      p.g(localView, "holder.itemView");
      localf.width = localView.getMeasuredWidth();
      localf = this.Lwg;
      localView = parame.auu;
      p.g(localView, "holder.itemView");
      localf.height = localView.getMeasuredHeight();
      AppMethodBeat.o(186694);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$2$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$2", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$2"})
  static final class g
    implements Runnable
  {
    g(f paramf, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(186695);
      f localf = this.Lwg;
      View localView = parame.auu;
      p.g(localView, "holder.itemView");
      localf.width = localView.getMeasuredWidth();
      localf = this.Lwg;
      localView = parame.auu;
      p.g(localView, "holder.itemView");
      localf.height = localView.getMeasuredHeight();
      AppMethodBeat.o(186695);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */