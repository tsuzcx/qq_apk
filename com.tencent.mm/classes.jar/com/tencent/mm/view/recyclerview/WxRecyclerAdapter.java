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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.g.b.y.f;
import d.k.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "convertTypeMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "dataChangeListener", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "dataScrollListener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isFirstViewHolder", "sessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getSessionExposeMap", "()Landroid/util/LongSparseArray;", "totalExposeMap", "getTotalExposeMap", "visibleExposeMap", "getVisibleExposeMap", "wxItemShowInfoMap", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getWxItemShowInfoMap", "wxRVListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getWxRVListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "setWxRVListener", "(Lcom/tencent/mm/view/recyclerview/WxRVListener;)V", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "_onBindHeaderHolder", "_onBindViewHolder", "payloads", "", "", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "_onCreateHeaderHolder", "_onCreateViewHolder", "viewType", "getData", "getFooterConvert", "getHeaderConvert", "getItemConvert", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindFirstBodyViewHolder", "onDetachedFromRecyclerView", "onPause", "onResume", "onViewAttachedToWindow", "wrapViewHolder", "view", "Landroid/view/View;", "libmmui_release"})
public class WxRecyclerAdapter<D extends a>
  extends d<e>
{
  private final SparseArray<b<?>> LSC;
  public final LongSparseArray<f> LSD;
  private boolean LSE;
  public final LongSparseArray<h> LSF;
  public final LongSparseArray<h> LSG;
  final LongSparseArray<h> LSH;
  public i LSI;
  private RecyclerView.m LSJ;
  private RecyclerView.c LSK;
  private final boolean LSL;
  public final ArrayList<D> data;
  private final c sjb;
  
  public WxRecyclerAdapter(c paramc, ArrayList<D> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(193958);
    this.sjb = paramc;
    this.data = paramArrayList;
    this.LSL = paramBoolean;
    this.LSC = new SparseArray();
    this.LSD = new LongSparseArray();
    this.LSE = true;
    this.LSF = new LongSparseArray();
    this.LSG = new LongSparseArray();
    this.LSH = new LongSparseArray();
    AppMethodBeat.o(193958);
  }
  
  private final b<D> AX(int paramInt)
  {
    AppMethodBeat.i(164732);
    b localb = (b)this.LSC.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.sjb.AX(paramInt);
      if (localb == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
        AppMethodBeat.o(164732);
        throw ((Throwable)localObject);
      }
      this.LSC.put(paramInt, localb);
      localObject = localb;
      if (!localb.LRP)
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
  
  private final b<d.b> agT(int paramInt)
  {
    AppMethodBeat.i(164733);
    b localb = (b)this.LSC.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.sjb.AX(paramInt);
      this.LSC.put(paramInt, localb);
      localObject = localb;
      if (!localb.LRP)
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
  
  private final b<d.b> agU(int paramInt)
  {
    AppMethodBeat.i(164734);
    b localb = (b)this.LSC.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.sjb.AX(paramInt);
      if (localb == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
        AppMethodBeat.o(164734);
        throw ((Throwable)localObject);
      }
      this.LSC.put(paramInt, localb);
      localObject = localb;
      if (!localb.LRP)
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
    int i = getItemViewType(this.LRV.size() + paramInt);
    Object localObject = this.data.get(paramInt);
    p.g(localObject, "data[position]");
    localObject = (a)localObject;
    parame.ep(localObject);
    parame.setRecyclerView(getRecyclerView());
    long l = SystemClock.uptimeMillis();
    AX(i).a(parame, (a)localObject, paramInt, i, false, null);
    l = SystemClock.uptimeMillis() - l;
    if (l > 17L) {
      ae.i("RecyclerViewAdapterEx", "holder.setAssociatedObject pos:" + paramInt + ", item:" + localObject.hashCode() + " cost=" + l);
    }
    if (this.LSE)
    {
      this.LSE = false;
      getRecyclerView().post((Runnable)new a(this));
    }
    AppMethodBeat.o(182559);
  }
  
  public final int agO(int paramInt)
  {
    AppMethodBeat.i(164721);
    paramInt = ((a)this.data.get(paramInt)).bZz();
    AppMethodBeat.o(164721);
    return paramInt;
  }
  
  public final long agP(int paramInt)
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
    int j = this.LSC.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      int k = this.LSC.keyAt(i);
      localObject = this.LSC.get(k);
      p.g(localObject, "convertTypeMap.get(key)");
      localObject = (b)localObject;
      if (!((b)localObject).LRP) {
        ((b)localObject).a(paramRecyclerView, this);
      }
      i += 1;
    }
    if (this.LSL)
    {
      localObject = new b(this, paramRecyclerView);
      paramRecyclerView.a((RecyclerView.m)localObject);
      this.LSJ = ((RecyclerView.m)localObject);
      paramRecyclerView = new c(this, paramRecyclerView);
      a((RecyclerView.c)paramRecyclerView);
      this.LSK = ((RecyclerView.c)paramRecyclerView);
    }
    AppMethodBeat.o(182557);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182558);
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    int j = this.LSC.size();
    int i = 0;
    while (i < j)
    {
      int k = this.LSC.keyAt(i);
      Object localObject = this.LSC.get(k);
      p.g(localObject, "convertTypeMap.get(key)");
      localObject = (b)localObject;
      if (((b)localObject).LRP) {
        ((b)localObject).d(paramRecyclerView);
      }
      i += 1;
    }
    paramRecyclerView = this.LSK;
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
    AppMethodBeat.i(193953);
    p.h(parame, "holder");
    super.k((RecyclerView.w)parame);
    Object localObject1 = parame.auu;
    p.g(localObject1, "holder.itemView");
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      final a locala = (a)parame.fUY();
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
          this.LSD.put(locala.lP(), localObject2);
          AppMethodBeat.o(193953);
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
        this.LSD.put(locala.lP(), localObject2);
        AppMethodBeat.o(193953);
        return;
      }
      AppMethodBeat.o(193953);
      return;
    }
    AppMethodBeat.o(193953);
  }
  
  public final int fUW()
  {
    AppMethodBeat.i(164723);
    int i = this.data.size();
    AppMethodBeat.o(164723);
    return i;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(193957);
    getRecyclerView().post((Runnable)new d(this));
    AppMethodBeat.o(193957);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(193956);
    getRecyclerView().post((Runnable)new e(this));
    AppMethodBeat.o(193956);
  }
  
  public void t(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(193955);
    p.h(paramRecyclerView, "recyclerView");
    RecyclerView.m localm = this.LSJ;
    if (localm != null)
    {
      localm.b(paramRecyclerView, 5);
      AppMethodBeat.o(193955);
      return;
    }
    AppMethodBeat.o(193955);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class a
    implements Runnable
  {
    a(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(193936);
      this.LSM.t(this.LSM.getRecyclerView());
      AppMethodBeat.o(193936);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "libmmui_release"})
  public static final class b
    extends RecyclerView.m
  {
    private int LSN;
    private int currentState;
    int ohB;
    int ohC;
    private final int rZo;
    private int rZr;
    
    b(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(193941);
      this.ohB = -1;
      this.ohC = -1;
      paramRecyclerView = ViewConfiguration.get(localObject.getContext());
      p.g(paramRecyclerView, "ViewConfiguration.get(recyclerView.context)");
      this.rZo = paramRecyclerView.getScaledTouchSlop();
      AppMethodBeat.o(193941);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193940);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      if (this.currentState == 2)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(193940);
        return;
      }
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null) {
        p.gkB();
      }
      p.g(localObject, "recyclerView.layoutManager!!");
      if (((RecyclerView.i)localObject).kc()) {}
      for (;;)
      {
        this.LSN += paramInt1;
        if ((Math.abs(this.LSN) > this.rZo * 5) || ((this.rZr == 2) && (this.currentState == 1)))
        {
          b(paramRecyclerView, 3);
          this.LSN = 0;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(193940);
        return;
        paramInt1 = paramInt2;
      }
    }
    
    public final void b(final RecyclerView paramRecyclerView, final int paramInt)
    {
      AppMethodBeat.i(193939);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      paramRecyclerView.post((Runnable)new a(this, paramInt, paramRecyclerView));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(193939);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.b paramb, int paramInt, RecyclerView paramRecyclerView) {}
      
      public final void run()
      {
        Object localObject5 = null;
        Object localObject6 = null;
        int k = 0;
        AppMethodBeat.i(193938);
        final y.f localf = new y.f();
        localf.NiY = new g(paramInt);
        ((g)localf.NiY).ohB = this.LSO.ohB;
        ((g)localf.NiY).ohC = this.LSO.ohC;
        Object localObject4 = paramRecyclerView.getLayoutManager();
        Object localObject1;
        label187:
        int j;
        if ((localObject4 instanceof LinearLayoutManager))
        {
          ((g)localf.NiY).rZF = Math.max(0, ((LinearLayoutManager)localObject4).km());
          ((g)localf.NiY).rZH = Math.max(0, ((LinearLayoutManager)localObject4).ko());
          localObject5 = paramRecyclerView.ch(((g)localf.NiY).rZF);
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
            ae.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(193938);
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
          localObject6 = (g)localf.NiY;
          if (localObject1 != null)
          {
            i = localObject1[0];
            if (localObject1 == null) {
              break label535;
            }
            j = localObject1[1];
            label356:
            ((g)localObject6).rZF = Math.min(i, j);
            ((g)localf.NiY).rZH = Math.max(localObject4[0], localObject4[1]);
            localObject6 = paramRecyclerView.ch(((g)localf.NiY).rZF);
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
            ae.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(193938);
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
          this.LSO.ohB = ((g)localf.NiY).rZF;
          this.LSO.ohC = ((g)localf.NiY).rZH;
          try
          {
            i = ((g)localf.NiY).rZF;
            j = ((g)localf.NiY).rZH;
            if (i <= j)
            {
              if ((this.LSO.LSM.getItemCount() <= 0) || ((i < 0) && (i >= this.LSO.LSM.getItemCount()))) {
                break label1753;
              }
              m = i - this.LSO.LSM.LRV.size();
              if (m < 0) {
                localObject1 = (a)this.LSO.LSM.agQ(i);
              }
              for (;;)
              {
                localObject4 = new h((a)localObject1);
                ((h)localObject4).rZC = i;
                ((h)localObject4).rZD = ((f)this.LSO.LSM.LSD.get(((a)localObject1).lP()));
                ((g)localf.NiY).LSt.add(localObject4);
                break;
                if (m >= WxRecyclerAdapter.a(this.LSO.LSM).size())
                {
                  localObject1 = (a)this.LSO.LSM.agR(m - WxRecyclerAdapter.a(this.LSO.LSM).size());
                }
                else
                {
                  localObject1 = WxRecyclerAdapter.a(this.LSO.LSM).get(m);
                  p.g(localObject1, "data[dataIndex]");
                  localObject1 = (a)localObject1;
                }
              }
            }
            if (((g)localf.NiY).ohB != ((g)localf.NiY).rZF) {}
          }
          catch (Exception localException1)
          {
            ae.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException1, "", new Object[0]);
          }
          if ((((g)localf.NiY).ohC == ((g)localf.NiY).rZH) || ((((g)localf.NiY).ohB == -1) && (((g)localf.NiY).ohC == -1)))
          {
            ((g)localf.NiY).LSu.addAll((Collection)((g)localf.NiY).LSt);
            label976:
            localObject2 = new LongSparseArray();
            localObject4 = ((Iterable)((g)localf.NiY).LSt).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (h)((Iterator)localObject4).next();
              ((LongSparseArray)localObject2).put(((h)localObject5).LSx.lP(), localObject5);
              if (this.LSO.LSM.LSH.indexOfKey(((h)localObject5).LSx.lP()) < 0) {
                ((g)localf.NiY).LSw.add(localObject5);
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            i = j.lx(((g)localf.NiY).rZF, ((g)localf.NiY).ohB);
            j = j.lx(this.LSO.LSM.getItemCount() - 1, j.lw(((g)localf.NiY).rZH, ((g)localf.NiY).ohC));
            if (i > j) {
              break label976;
            }
            if ((this.LSO.LSM.getItemCount() <= 0) || ((i < 0) && (i >= this.LSO.LSM.getItemCount()))) {
              break label1765;
            }
            m = i - this.LSO.LSM.LRV.size();
            if (m < 0)
            {
              localObject2 = (a)this.LSO.LSM.agQ(i);
              localObject4 = new h((a)localObject2);
              ((h)localObject4).rZC = m;
              ((h)localObject4).rZD = ((f)this.LSO.LSM.LSD.get(((a)localObject2).lP()));
              ((g)localf.NiY).LSu.add(localObject4);
              break label1765;
            }
            if (m >= WxRecyclerAdapter.a(this.LSO.LSM).size())
            {
              localObject2 = (a)this.LSO.LSM.agR(m - WxRecyclerAdapter.a(this.LSO.LSM).size());
              continue;
            }
            localObject2 = WxRecyclerAdapter.a(this.LSO.LSM).get(m);
            p.g(localObject2, "data[dataIndex]");
            localObject2 = (a)localObject2;
            continue;
          }
          catch (Exception localException2)
          {
            ae.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException2, "", new Object[0]);
          }
          j = this.LSO.LSM.LSH.size();
          i = 0;
          while (i < j)
          {
            localObject4 = (h)this.LSO.LSM.LSH.valueAt(i);
            if (localException2.indexOfKey(((h)localObject4).LSx.lP()) < 0) {
              ((g)localf.NiY).LSv.add(localObject4);
            }
            i += 1;
          }
          this.LSO.LSM.LSH.clear();
          j = localException2.size();
          i = k;
          while (i < j)
          {
            localObject4 = (h)localException2.valueAt(i);
            this.LSO.LSM.LSH.put(((h)localObject4).LSx.lP(), localObject4);
            i += 1;
          }
          Object localObject3 = ((Iterable)((g)localf.NiY).LSu).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (h)((Iterator)localObject3).next();
            if (this.LSO.LSM.LSG.indexOfKey(((h)localObject4).LSx.lP()) < 0) {
              this.LSO.LSM.LSG.put(((h)localObject4).LSx.lP(), localObject4);
            }
            if (this.LSO.LSM.LSF.indexOfKey(((h)localObject4).LSx.lP()) < 0) {
              this.LSO.LSM.LSF.put(((h)localObject4).LSx.lP(), localObject4);
            }
          }
          localObject3 = com.tencent.e.h.MqF;
          localObject4 = (Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193937);
              i locali = this.LSQ.LSO.LSM.LSI;
              if (locali != null)
              {
                locali.a(this.LSQ.rWI, (g)localf.NiY);
                AppMethodBeat.o(193937);
                return;
              }
              AppMethodBeat.o(193937);
            }
          };
          localObject5 = i.LSz;
          ((com.tencent.e.i)localObject3).f((Runnable)localObject4, i.a.fUZ());
          AppMethodBeat.o(193938);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$3", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "notifyChangeEvent", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class c
    extends RecyclerView.c
  {
    c(RecyclerView paramRecyclerView) {}
    
    private void fVa()
    {
      AppMethodBeat.i(193943);
      paramRecyclerView.post((Runnable)new a(this));
      AppMethodBeat.o(193943);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193946);
      super.au(paramInt1, paramInt2);
      fVa();
      AppMethodBeat.o(193946);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193948);
      super.av(paramInt1, paramInt2);
      fVa();
      AppMethodBeat.o(193948);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(193945);
      super.f(paramInt1, paramInt2, paramObject);
      fVa();
      AppMethodBeat.o(193945);
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(193947);
      super.l(paramInt1, paramInt2, paramInt3);
      fVa();
      AppMethodBeat.o(193947);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(193944);
      super.onChanged();
      fVa();
      AppMethodBeat.o(193944);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(193942);
        RecyclerView.m localm = WxRecyclerAdapter.b(this.LSS.LSM);
        if (localm != null)
        {
          localm.b(this.LSS.rWI, 8);
          AppMethodBeat.o(193942);
          return;
        }
        AppMethodBeat.o(193942);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class d
    implements Runnable
  {
    d(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(193949);
      ae.i("RecyclerViewAdapterEx", "onPause visibleExposeMap.size:" + this.LSM.LSH.size() + " sessionExposeMap.size:" + this.LSM.LSG.size());
      this.LSM.LSH.clear();
      this.LSM.LSG.clear();
      AppMethodBeat.o(193949);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class e
    implements Runnable
  {
    e(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(193950);
      RecyclerView.m localm = WxRecyclerAdapter.b(this.LSM);
      if (localm != null)
      {
        localm.b(this.LSM.getRecyclerView(), 7);
        AppMethodBeat.o(193950);
        return;
      }
      AppMethodBeat.o(193950);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$1$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$1"})
  static final class f
    implements Runnable
  {
    f(f paramf, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(193951);
      f localf = this.LST;
      View localView = parame.auu;
      p.g(localView, "holder.itemView");
      localf.width = localView.getMeasuredWidth();
      localf = this.LST;
      localView = parame.auu;
      p.g(localView, "holder.itemView");
      localf.height = localView.getMeasuredHeight();
      AppMethodBeat.o(193951);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$2$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$2", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$2"})
  static final class g
    implements Runnable
  {
    g(f paramf, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(193952);
      f localf = this.LST;
      View localView = parame.auu;
      p.g(localView, "holder.itemView");
      localf.width = localView.getMeasuredWidth();
      localf = this.LST;
      localView = parame.auu;
      p.g(localView, "holder.itemView");
      localf.height = localView.getMeasuredHeight();
      AppMethodBeat.o(193952);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */