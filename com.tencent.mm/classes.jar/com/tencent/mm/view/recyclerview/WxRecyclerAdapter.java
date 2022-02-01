package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "convertTypeMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "dataChangeListener", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "dataScrollListener", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener;", "isFirstViewHolder", "sessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getSessionExposeMap", "()Landroid/util/LongSparseArray;", "totalExposeMap", "getTotalExposeMap", "visibleExposeMap", "getVisibleExposeMap", "wxItemShowInfoMap", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getWxItemShowInfoMap", "wxRVListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getWxRVListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "setWxRVListener", "(Lcom/tencent/mm/view/recyclerview/WxRVListener;)V", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "_onBindHeaderHolder", "_onBindViewHolder", "payloads", "", "", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "_onCreateHeaderHolder", "_onCreateViewHolder", "viewType", "clearConverter", "clearReportData", "getData", "getFooterConvert", "getHeaderConvert", "getItemConvert", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindFirstBodyViewHolder", "onDetachedFromRecyclerView", "onPause", "onResume", "onViewAttachedToWindow", "onViewRecycled", "wrapViewHolder", "view", "Landroid/view/View;", "WxRecyclerOnScrollListener", "libmmui_release"})
public class WxRecyclerAdapter<D extends a>
  extends g<h>
{
  public l RrA;
  public WxRecyclerAdapter<D>.a RrB;
  private RecyclerView.c RrC;
  private final boolean RrD;
  public final SparseArray<e<?>> Rru;
  public final LongSparseArray<i> Rrv;
  public boolean Rrw;
  public final LongSparseArray<k> Rrx;
  public final LongSparseArray<k> Rry;
  public final LongSparseArray<k> Rrz;
  public final ArrayList<D> data;
  private final f tDm;
  
  public WxRecyclerAdapter(f paramf, ArrayList<D> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(205080);
    this.tDm = paramf;
    this.data = paramArrayList;
    this.RrD = paramBoolean;
    this.Rru = new SparseArray();
    this.Rrv = new LongSparseArray();
    this.Rrw = true;
    this.Rrx = new LongSparseArray();
    this.Rry = new LongSparseArray();
    this.Rrz = new LongSparseArray();
    AppMethodBeat.o(205080);
  }
  
  private final e<D> EC(int paramInt)
  {
    AppMethodBeat.i(164732);
    e locale = (e)this.Rru.get(paramInt);
    Object localObject = locale;
    if (locale == null)
    {
      locale = this.tDm.EC(paramInt);
      if (locale == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
        AppMethodBeat.o(164732);
        throw ((Throwable)localObject);
      }
      this.Rru.put(paramInt, locale);
      localObject = locale;
      if (!locale.RqG)
      {
        locale.a(getRecyclerView(), this);
        localObject = locale;
      }
    }
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
      AppMethodBeat.o(164732);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164732);
    return localObject;
  }
  
  private final e<g.b> aqf(int paramInt)
  {
    AppMethodBeat.i(164733);
    e locale = (e)this.Rru.get(paramInt);
    Object localObject = locale;
    if (locale == null)
    {
      locale = this.tDm.EC(paramInt);
      this.Rru.put(paramInt, locale);
      localObject = locale;
      if (!locale.RqG)
      {
        locale.a(getRecyclerView(), this);
        localObject = locale;
      }
    }
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
      AppMethodBeat.o(164733);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164733);
    return localObject;
  }
  
  private final e<g.b> aqg(int paramInt)
  {
    AppMethodBeat.i(164734);
    e locale = (e)this.Rru.get(paramInt);
    Object localObject = locale;
    if (locale == null)
    {
      locale = this.tDm.EC(paramInt);
      if (locale == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
        AppMethodBeat.o(164734);
        throw ((Throwable)localObject);
      }
      this.Rru.put(paramInt, locale);
      localObject = locale;
      if (!locale.RqG)
      {
        locale.a(getRecyclerView(), this);
        localObject = locale;
      }
    }
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
      AppMethodBeat.o(164734);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164734);
    return localObject;
  }
  
  public void a(h paramh, int paramInt)
  {
    AppMethodBeat.i(182559);
    p.h(paramh, "holder");
    int i = getItemViewType(this.RqM.size() + paramInt);
    Object localObject = this.data.get(paramInt);
    p.g(localObject, "data[position]");
    localObject = (a)localObject;
    paramh.et(localObject);
    paramh.setRecyclerView(getRecyclerView());
    Log.i("RecyclerViewAdapterEx", "_onBindViewHolder pos:" + paramInt + ", item:" + localObject.hashCode() + " ry=" + paramh.getRecyclerView().hashCode());
    EC(i).a(paramh, (a)localObject, paramInt, i, false, null);
    if (this.Rrw)
    {
      this.Rrw = false;
      getRecyclerView().post((Runnable)new b(this));
    }
    AppMethodBeat.o(182559);
  }
  
  public final int apZ(int paramInt)
  {
    AppMethodBeat.i(164721);
    paramInt = ((a)this.data.get(paramInt)).cxn();
    AppMethodBeat.o(164721);
    return paramInt;
  }
  
  public final long aqa(int paramInt)
  {
    AppMethodBeat.i(164722);
    long l = ((a)this.data.get(paramInt)).lT();
    AppMethodBeat.o(164722);
    return l;
  }
  
  public final void b(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182557);
    p.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView);
    int j = this.Rru.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      int k = this.Rru.keyAt(i);
      localObject = this.Rru.get(k);
      p.g(localObject, "convertTypeMap.get(key)");
      localObject = (e)localObject;
      if (!((e)localObject).RqG) {
        ((e)localObject).a(paramRecyclerView, this);
      }
      i += 1;
    }
    if (this.RrD)
    {
      localObject = new a();
      paramRecyclerView.a((RecyclerView.l)localObject);
      this.RrB = ((a)localObject);
      paramRecyclerView = new c(this, paramRecyclerView);
      a((RecyclerView.c)paramRecyclerView);
      this.RrC = ((RecyclerView.c)paramRecyclerView);
    }
    AppMethodBeat.o(182557);
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182558);
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    int j = this.Rru.size();
    int i = 0;
    while (i < j)
    {
      int k = this.Rru.keyAt(i);
      Object localObject = this.Rru.get(k);
      p.g(localObject, "convertTypeMap.get(key)");
      localObject = (e)localObject;
      if (((e)localObject).RqG) {
        ((e)localObject).c(paramRecyclerView);
      }
      i += 1;
    }
    paramRecyclerView = this.RrC;
    if (paramRecyclerView != null)
    {
      b(paramRecyclerView);
      AppMethodBeat.o(182558);
      return;
    }
    AppMethodBeat.o(182558);
  }
  
  public final int hgt()
  {
    AppMethodBeat.i(164723);
    int i = this.data.size();
    AppMethodBeat.o(164723);
    return i;
  }
  
  public void n(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205077);
    p.h(paramRecyclerView, "recyclerView");
    a locala = this.RrB;
    if (locala != null)
    {
      locala.onScrollStateChanged(paramRecyclerView, 5);
      AppMethodBeat.o(205077);
      return;
    }
    AppMethodBeat.o(205077);
  }
  
  public void n(final h paramh)
  {
    AppMethodBeat.i(205075);
    p.h(paramh, "holder");
    super.k((RecyclerView.v)paramh);
    Object localObject1 = paramh.aus;
    p.g(localObject1, "holder.itemView");
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      final a locala = (a)paramh.hgv();
      if (locala != null)
      {
        if ((localObject1 instanceof StaggeredGridLayoutManager.LayoutParams))
        {
          i = ((StaggeredGridLayoutManager.LayoutParams)localObject1).kj();
          localObject2 = paramh.aus;
          p.g(localObject2, "holder.itemView");
          int j = ((View)localObject2).getMeasuredWidth();
          localObject2 = paramh.aus;
          p.g(localObject2, "holder.itemView");
          localObject2 = new i(i, j, ((View)localObject2).getMeasuredHeight());
          if ((((i)localObject2).width == 0) || (((i)localObject2).height == 0)) {
            paramh.aus.post((Runnable)new f((i)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, paramh));
          }
          this.Rrv.put(locala.lT(), localObject2);
          AppMethodBeat.o(205075);
          return;
        }
        Object localObject2 = paramh.aus;
        p.g(localObject2, "holder.itemView");
        int i = ((View)localObject2).getMeasuredWidth();
        localObject2 = paramh.aus;
        p.g(localObject2, "holder.itemView");
        localObject2 = new i(0, i, ((View)localObject2).getMeasuredHeight());
        if ((((i)localObject2).width == 0) || (((i)localObject2).height == 0)) {
          paramh.aus.post((Runnable)new g((i)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, paramh));
        }
        this.Rrv.put(locala.lT(), localObject2);
        AppMethodBeat.o(205075);
        return;
      }
      AppMethodBeat.o(205075);
      return;
    }
    AppMethodBeat.o(205075);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(205079);
    getRecyclerView().post((Runnable)new d(this));
    AppMethodBeat.o(205079);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205078);
    getRecyclerView().post((Runnable)new e(this));
    AppMethodBeat.o(205078);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "reset", "libmmui_release"})
  public final class a
    extends RecyclerView.l
  {
    public int RrE;
    public int currentState;
    public int ptb;
    public int ptc;
    private final int tIg;
    public int tIj;
    
    public a()
    {
      AppMethodBeat.i(205061);
      this.ptb = -1;
      this.ptc = -1;
      this$1 = ViewConfiguration.get(this$1.getRecyclerView().getContext());
      p.g(this$1, "ViewConfiguration.get(recyclerView.context)");
      this.tIg = this$1.getScaledTouchSlop();
      AppMethodBeat.o(205061);
    }
    
    public final void onScrollStateChanged(final RecyclerView paramRecyclerView, final int paramInt)
    {
      AppMethodBeat.i(205059);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      paramRecyclerView.post((Runnable)new a(this, paramInt, paramRecyclerView));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(205059);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205060);
      Object localObject = new b();
      ((b)localObject).bm(paramRecyclerView);
      ((b)localObject).pH(paramInt1);
      ((b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (this.currentState == 2)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(205060);
        return;
      }
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "recyclerView.layoutManager!!");
      if (((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {}
      for (;;)
      {
        this.RrE += paramInt1;
        if ((Math.abs(this.RrE) > this.tIg * 5) || ((this.tIj == 2) && (this.currentState == 1)))
        {
          onScrollStateChanged(paramRecyclerView, 3);
          this.RrE = 0;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(205060);
        return;
        paramInt1 = paramInt2;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.a parama, int paramInt, RecyclerView paramRecyclerView) {}
      
      public final void run()
      {
        Object localObject5 = null;
        Object localObject7 = null;
        Object localObject6 = null;
        int k = 0;
        AppMethodBeat.i(205058);
        final z.f localf = new z.f();
        localf.SYG = new j(paramInt);
        ((j)localf.SYG).ptb = this.RrG.ptb;
        ((j)localf.SYG).ptc = this.RrG.ptc;
        Object localObject1 = paramRecyclerView.getLayoutManager();
        Object localObject4;
        label190:
        int j;
        if ((localObject1 instanceof LinearLayoutManager))
        {
          ((j)localf.SYG).tIy = Math.max(0, ((LinearLayoutManager)localObject1).ks());
          ((j)localf.SYG).tIA = Math.max(0, ((LinearLayoutManager)localObject1).ku());
          localObject5 = paramRecyclerView.cg(((j)localf.SYG).tIy);
          if (localObject5 != null)
          {
            localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).lR());
            if (localObject5 == null) {
              break label288;
            }
            localObject4 = Integer.valueOf(((RecyclerView.v)localObject5).lQ());
            if (!(p.j(localObject1, localObject4) ^ true)) {
              break label804;
            }
            localObject4 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
            if (localObject5 == null) {
              break label294;
            }
          }
          label288:
          label294:
          for (localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).lR());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject6;
            if (localObject5 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).lQ());
            }
            Log.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(205058);
            return;
            localObject1 = null;
            break;
            localObject4 = null;
            break label190;
          }
        }
        else if ((localObject1 instanceof StaggeredGridLayoutManager))
        {
          localObject4 = ((StaggeredGridLayoutManager)localObject1).n(null);
          localObject1 = ((StaggeredGridLayoutManager)localObject1).o(null);
          localObject6 = (j)localf.SYG;
          if (localObject4 != null)
          {
            i = localObject4[0];
            if (localObject4 == null) {
              break label557;
            }
            j = localObject4[1];
            label360:
            ((j)localObject6).tIy = Math.min(i, j);
            localObject4 = (j)localf.SYG;
            if (localObject1 == null) {
              break label562;
            }
            i = localObject1[0];
            label390:
            if (localObject1 == null) {
              break label567;
            }
            j = localObject1[1];
            label400:
            ((j)localObject4).tIA = Math.max(i, j);
            localObject6 = paramRecyclerView.cg(((j)localf.SYG).tIy);
            if (localObject6 == null) {
              break label572;
            }
            localObject1 = Integer.valueOf(((RecyclerView.v)localObject6).lR());
            label445:
            if (localObject6 == null) {
              break label578;
            }
            localObject4 = Integer.valueOf(((RecyclerView.v)localObject6).lQ());
            label460:
            if (!(p.j(localObject1, localObject4) ^ true)) {
              break label804;
            }
            localObject4 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
            if (localObject6 == null) {
              break label584;
            }
          }
          label557:
          label562:
          label567:
          label572:
          label578:
          label584:
          for (localObject1 = Integer.valueOf(((RecyclerView.v)localObject6).lR());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject5;
            if (localObject6 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.v)localObject6).lQ());
            }
            Log.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(205058);
            return;
            i = 0;
            break;
            j = 0;
            break label360;
            i = 0;
            break label390;
            j = 0;
            break label400;
            localObject1 = null;
            break label445;
            localObject4 = null;
            break label460;
          }
        }
        else
        {
          if (!(localObject1 instanceof GridLayoutManager)) {
            break label2011;
          }
          ((j)localf.SYG).tIy = Math.max(0, ((GridLayoutManager)localObject1).ks());
          ((j)localf.SYG).tIA = Math.max(0, ((GridLayoutManager)localObject1).ku());
          localObject5 = paramRecyclerView.cg(((j)localf.SYG).tIy);
          if (localObject5 != null)
          {
            localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).lR());
            if (localObject5 == null) {
              break label792;
            }
            localObject4 = Integer.valueOf(((RecyclerView.v)localObject5).lQ());
            label694:
            if (!(p.j(localObject1, localObject4) ^ true)) {
              break label804;
            }
            localObject4 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
            if (localObject5 == null) {
              break label798;
            }
          }
          label792:
          label798:
          for (localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).lR());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject7;
            if (localObject5 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).lQ());
            }
            Log.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(205058);
            return;
            localObject1 = null;
            break;
            localObject4 = null;
            break label694;
          }
        }
        label804:
        int i = 1;
        label875:
        int m;
        label1113:
        Object localObject2;
        if (i != 0)
        {
          this.RrG.ptb = ((j)localf.SYG).tIy;
          this.RrG.ptc = ((j)localf.SYG).tIA;
          try
          {
            i = ((j)localf.SYG).tIy;
            j = ((j)localf.SYG).tIA;
            if (i <= j)
            {
              if ((this.RrG.RrF.getItemCount() <= 0) || ((i < 0) && (i >= this.RrG.RrF.getItemCount()))) {
                break label2016;
              }
              m = i - this.RrG.RrF.RqM.size();
              if (m < 0) {
                localObject1 = (a)this.RrG.RrF.aqb(i);
              }
              for (;;)
              {
                localObject4 = new k((a)localObject1);
                ((k)localObject4).tIv = i;
                ((k)localObject4).tIw = ((i)this.RrG.RrF.Rrv.get(((a)localObject1).lT()));
                ((j)localf.SYG).Rrk.add(localObject4);
                break;
                if (m >= WxRecyclerAdapter.a(this.RrG.RrF).size())
                {
                  localObject1 = (a)this.RrG.RrF.aqc(m - WxRecyclerAdapter.a(this.RrG.RrF).size());
                }
                else
                {
                  localObject1 = WxRecyclerAdapter.a(this.RrG.RrF).get(m);
                  p.g(localObject1, "data[dataIndex]");
                  localObject1 = (a)localObject1;
                }
              }
            }
            if (((j)localf.SYG).ptb != ((j)localf.SYG).tIy) {}
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException1, "", new Object[0]);
          }
          if ((((j)localf.SYG).ptc == ((j)localf.SYG).tIA) || ((((j)localf.SYG).ptb == -1) && (((j)localf.SYG).ptc == -1)))
          {
            ((j)localf.SYG).Rrl.addAll((Collection)((j)localf.SYG).Rrk);
            label1222:
            localObject2 = new LongSparseArray();
            localObject4 = ((Iterable)((j)localf.SYG).Rrk).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (k)((Iterator)localObject4).next();
              ((LongSparseArray)localObject2).put(((k)localObject5).Rrp.lT(), localObject5);
              if (this.RrG.RrF.Rrz.indexOfKey(((k)localObject5).Rrp.lT()) < 0) {
                ((j)localf.SYG).Rrn.add(localObject5);
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            i = kotlin.k.j.na(((j)localf.SYG).tIy, ((j)localf.SYG).ptb);
            j = kotlin.k.j.na(this.RrG.RrF.getItemCount() - 1, kotlin.k.j.mZ(((j)localf.SYG).tIA, ((j)localf.SYG).ptc));
            if (i > j) {
              break label1222;
            }
            if ((this.RrG.RrF.getItemCount() <= 0) || ((i < 0) && (i >= this.RrG.RrF.getItemCount()))) {
              break label2028;
            }
            m = i - this.RrG.RrF.RqM.size();
            if (m < 0)
            {
              localObject2 = (a)this.RrG.RrF.aqb(i);
              localObject4 = new k((a)localObject2);
              ((k)localObject4).tIv = m;
              ((k)localObject4).tIw = ((i)this.RrG.RrF.Rrv.get(((a)localObject2).lT()));
              ((j)localf.SYG).Rrl.add(localObject4);
              break label2028;
            }
            if (m >= WxRecyclerAdapter.a(this.RrG.RrF).size())
            {
              localObject2 = (a)this.RrG.RrF.aqc(m - WxRecyclerAdapter.a(this.RrG.RrF).size());
              continue;
            }
            localObject2 = WxRecyclerAdapter.a(this.RrG.RrF).get(m);
            p.g(localObject2, "data[dataIndex]");
            localObject2 = (a)localObject2;
            continue;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException2, "", new Object[0]);
          }
          j = this.RrG.RrF.Rrz.size();
          i = 0;
          while (i < j)
          {
            localObject4 = (k)this.RrG.RrF.Rrz.valueAt(i);
            if (localException2.indexOfKey(((k)localObject4).Rrp.lT()) < 0) {
              ((j)localf.SYG).Rrm.add(localObject4);
            }
            i += 1;
          }
          this.RrG.RrF.Rrz.clear();
          j = localException2.size();
          i = k;
          while (i < j)
          {
            localObject4 = (k)localException2.valueAt(i);
            this.RrG.RrF.Rrz.put(((k)localObject4).Rrp.lT(), localObject4);
            i += 1;
          }
          Object localObject3 = ((Iterable)((j)localf.SYG).Rrl).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (k)((Iterator)localObject3).next();
            if (this.RrG.RrF.Rry.indexOfKey(((k)localObject4).Rrp.lT()) < 0) {
              this.RrG.RrF.Rry.put(((k)localObject4).Rrp.lT(), localObject4);
            }
            if (this.RrG.RrF.Rrx.indexOfKey(((k)localObject4).Rrp.lT()) < 0)
            {
              this.RrG.RrF.Rrx.put(((k)localObject4).Rrp.lT(), localObject4);
              ((j)localf.SYG).Rro.add(localObject4);
            }
          }
          localObject3 = com.tencent.f.h.RTc;
          localObject4 = (Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205057);
              l locall = this.RrI.RrG.RrF.RrA;
              if (locall != null)
              {
                locall.a(this.RrI.tDJ, (j)localf.SYG);
                AppMethodBeat.o(205057);
                return;
              }
              AppMethodBeat.o(205057);
            }
          };
          localObject5 = l.Rrr;
          ((com.tencent.f.i)localObject3).b((Runnable)localObject4, l.a.hgw());
          AppMethodBeat.o(205058);
          return;
          label2011:
          i = 0;
          break;
          label2016:
          if (i == j) {
            break label1113;
          }
          i += 1;
          break label875;
          label2028:
          if (i == j) {
            break label1222;
          }
          i += 1;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class b
    implements Runnable
  {
    b(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(205062);
      this.RrF.n(this.RrF.getRecyclerView());
      AppMethodBeat.o(205062);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$2", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "notifyChangeEvent", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class c
    extends RecyclerView.c
  {
    c(RecyclerView paramRecyclerView) {}
    
    private void hgx()
    {
      AppMethodBeat.i(205064);
      paramRecyclerView.post((Runnable)new a(this));
      AppMethodBeat.o(205064);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(205065);
      super.onChanged();
      hgx();
      AppMethodBeat.o(205065);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(205066);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      hgx();
      AppMethodBeat.o(205066);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205067);
      super.onItemRangeInserted(paramInt1, paramInt2);
      hgx();
      AppMethodBeat.o(205067);
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205068);
      super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
      hgx();
      AppMethodBeat.o(205068);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205069);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      hgx();
      AppMethodBeat.o(205069);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(205063);
        WxRecyclerAdapter.a locala = WxRecyclerAdapter.b(this.RrK.RrF);
        if (locala != null)
        {
          locala.onScrollStateChanged(this.RrK.tDJ, 8);
          AppMethodBeat.o(205063);
          return;
        }
        AppMethodBeat.o(205063);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class d
    implements Runnable
  {
    d(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(205070);
      Log.i("RecyclerViewAdapterEx", "onPause visibleExposeMap.size:" + this.RrF.Rrz.size() + " sessionExposeMap.size:" + this.RrF.Rry.size());
      this.RrF.Rrz.clear();
      this.RrF.Rry.clear();
      AppMethodBeat.o(205070);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class e
    implements Runnable
  {
    e(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(205071);
      WxRecyclerAdapter.a locala = WxRecyclerAdapter.b(this.RrF);
      if (locala != null)
      {
        locala.onScrollStateChanged(this.RrF.getRecyclerView(), 7);
        AppMethodBeat.o(205071);
        return;
      }
      AppMethodBeat.o(205071);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$1$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$1"})
  static final class f
    implements Runnable
  {
    f(i parami, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(205072);
      i locali = this.RrL;
      View localView = paramh.aus;
      p.g(localView, "holder.itemView");
      locali.width = localView.getMeasuredWidth();
      locali = this.RrL;
      localView = paramh.aus;
      p.g(localView, "holder.itemView");
      locali.height = localView.getMeasuredHeight();
      AppMethodBeat.o(205072);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$2$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$2", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$2"})
  static final class g
    implements Runnable
  {
    g(i parami, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(205073);
      i locali = this.RrL;
      View localView = paramh.aus;
      p.g(localView, "holder.itemView");
      locali.width = localView.getMeasuredWidth();
      locali = this.RrL;
      localView = paramh.aus;
      p.g(localView, "holder.itemView");
      locali.height = localView.getMeasuredHeight();
      AppMethodBeat.o(205073);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */