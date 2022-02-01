package com.tencent.mm.view.recyclerview;

import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "convertTypeMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "dataChangeListener", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "dataScrollListener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isFirstViewHolder", "sessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getSessionExposeMap", "()Landroid/util/LongSparseArray;", "totalExposeMap", "getTotalExposeMap", "visibleExposeMap", "getVisibleExposeMap", "wxItemShowInfoMap", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getWxItemShowInfoMap", "wxRVListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getWxRVListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "setWxRVListener", "(Lcom/tencent/mm/view/recyclerview/WxRVListener;)V", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "_onBindHeaderHolder", "_onBindViewHolder", "payloads", "", "", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "_onCreateHeaderHolder", "_onCreateViewHolder", "viewType", "getData", "getFooterConvert", "getHeaderConvert", "getItemConvert", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindFirstBodyViewHolder", "onDetachedFromRecyclerView", "onPause", "onResume", "onViewAttachedToWindow", "wrapViewHolder", "view", "Landroid/view/View;", "libmmui_release"})
public class WxRecyclerAdapter<D extends a>
  extends d<e>
{
  private final SparseArray<b<?>> IbB;
  public final LongSparseArray<f> LDZ;
  private boolean LEa;
  public final LongSparseArray<h> LEb;
  public final LongSparseArray<h> LEc;
  final LongSparseArray<h> LEd;
  public i LEe;
  private RecyclerView.m LEf;
  private RecyclerView.c LEg;
  private final boolean LEh;
  public final ArrayList<D> data;
  private final c qxt;
  
  public WxRecyclerAdapter(c paramc, ArrayList<D> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(204012);
    this.qxt = paramc;
    this.data = paramArrayList;
    this.LEh = paramBoolean;
    this.IbB = new SparseArray();
    this.LDZ = new LongSparseArray();
    this.LEa = true;
    this.LEb = new LongSparseArray();
    this.LEc = new LongSparseArray();
    this.LEd = new LongSparseArray();
    AppMethodBeat.o(204012);
  }
  
  private final b<d.b> abr(int paramInt)
  {
    AppMethodBeat.i(164733);
    b localb = (b)this.IbB.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.qxt.zm(paramInt);
      this.IbB.put(paramInt, localb);
      localObject = localb;
      if (!localb.Ibf)
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
  
  private final b<d.b> abs(int paramInt)
  {
    AppMethodBeat.i(164734);
    b localb = (b)this.IbB.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.qxt.zm(paramInt);
      if (localb == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
        AppMethodBeat.o(164734);
        throw ((Throwable)localObject);
      }
      this.IbB.put(paramInt, localb);
      localObject = localb;
      if (!localb.Ibf)
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
  
  private final b<D> zm(int paramInt)
  {
    AppMethodBeat.i(164732);
    b localb = (b)this.IbB.get(paramInt);
    Object localObject = localb;
    if (localb == null)
    {
      localb = this.qxt.zm(paramInt);
      if (localb == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
        AppMethodBeat.o(164732);
        throw ((Throwable)localObject);
      }
      this.IbB.put(paramInt, localb);
      localObject = localb;
      if (!localb.Ibf)
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
  
  public final int abn(int paramInt)
  {
    AppMethodBeat.i(164721);
    paramInt = ((a)this.data.get(paramInt)).bMt();
    AppMethodBeat.o(164721);
    return paramInt;
  }
  
  public final long abo(int paramInt)
  {
    AppMethodBeat.i(164722);
    long l = ((a)this.data.get(paramInt)).bMs();
    AppMethodBeat.o(164722);
    return l;
  }
  
  public void b(e parame, int paramInt)
  {
    AppMethodBeat.i(182559);
    k.h(parame, "holder");
    int i = getItemViewType(this.Ibl.size() + paramInt);
    Object localObject = this.data.get(paramInt);
    k.g(localObject, "data[position]");
    localObject = (a)localObject;
    parame.ei(localObject);
    parame.setRecyclerView(getRecyclerView());
    long l = SystemClock.uptimeMillis();
    zm(i).a(parame, (a)localObject, paramInt, i, false, null);
    l = SystemClock.uptimeMillis() - l;
    if (l > 17L) {
      ad.i("RecyclerViewAdapterEx", "holder.setAssociatedObject pos:" + paramInt + ", item:" + localObject.hashCode() + " cost=" + l);
    }
    if (this.LEa)
    {
      this.LEa = false;
      getRecyclerView().post((Runnable)new WxRecyclerAdapter.a(this));
    }
    AppMethodBeat.o(182559);
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182557);
    k.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    int j = this.IbB.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      int k = this.IbB.keyAt(i);
      localObject = this.IbB.get(k);
      k.g(localObject, "convertTypeMap.get(key)");
      localObject = (b)localObject;
      if (!((b)localObject).Ibf) {
        ((b)localObject).a(paramRecyclerView, this);
      }
      i += 1;
    }
    if (this.LEh)
    {
      localObject = new WxRecyclerAdapter.b(this, paramRecyclerView);
      paramRecyclerView.a((RecyclerView.m)localObject);
      this.LEf = ((RecyclerView.m)localObject);
      paramRecyclerView = new WxRecyclerAdapter.c(this, paramRecyclerView);
      a((RecyclerView.c)paramRecyclerView);
      this.LEg = ((RecyclerView.c)paramRecyclerView);
    }
    AppMethodBeat.o(182557);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(182558);
    k.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    int j = this.IbB.size();
    int i = 0;
    while (i < j)
    {
      int k = this.IbB.keyAt(i);
      Object localObject = this.IbB.get(k);
      k.g(localObject, "convertTypeMap.get(key)");
      localObject = (b)localObject;
      if (((b)localObject).Ibf) {
        ((b)localObject).d(paramRecyclerView);
      }
      i += 1;
    }
    paramRecyclerView = this.LEg;
    if (paramRecyclerView != null)
    {
      b(paramRecyclerView);
      AppMethodBeat.o(182558);
      return;
    }
    AppMethodBeat.o(182558);
  }
  
  public void e(e parame)
  {
    AppMethodBeat.i(204007);
    k.h(parame, "holder");
    super.k((RecyclerView.v)parame);
    Object localObject1 = parame.arI;
    k.g(localObject1, "holder.itemView");
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      a locala = (a)parame.fjf();
      if (locala != null)
      {
        if ((localObject1 instanceof StaggeredGridLayoutManager.LayoutParams))
        {
          i = ((StaggeredGridLayoutManager.LayoutParams)localObject1).mg();
          localObject2 = parame.arI;
          k.g(localObject2, "holder.itemView");
          int j = ((View)localObject2).getMeasuredWidth();
          localObject2 = parame.arI;
          k.g(localObject2, "holder.itemView");
          localObject2 = new f(i, j, ((View)localObject2).getMeasuredHeight());
          if ((((f)localObject2).width == 0) || (((f)localObject2).height == 0)) {
            parame.arI.post((Runnable)new WxRecyclerAdapter.f((f)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, parame));
          }
          this.LDZ.put(locala.bMs(), localObject2);
          AppMethodBeat.o(204007);
          return;
        }
        Object localObject2 = parame.arI;
        k.g(localObject2, "holder.itemView");
        int i = ((View)localObject2).getMeasuredWidth();
        localObject2 = parame.arI;
        k.g(localObject2, "holder.itemView");
        localObject2 = new f(0, i, ((View)localObject2).getMeasuredHeight());
        if ((((f)localObject2).width == 0) || (((f)localObject2).height == 0)) {
          parame.arI.post((Runnable)new WxRecyclerAdapter.g((f)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, parame));
        }
        this.LDZ.put(locala.bMs(), localObject2);
        AppMethodBeat.o(204007);
        return;
      }
      AppMethodBeat.o(204007);
      return;
    }
    AppMethodBeat.o(204007);
  }
  
  public final int fjd()
  {
    AppMethodBeat.i(164723);
    int i = this.data.size();
    AppMethodBeat.o(164723);
    return i;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204011);
    getRecyclerView().post((Runnable)new WxRecyclerAdapter.d(this));
    AppMethodBeat.o(204011);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204010);
    getRecyclerView().post((Runnable)new WxRecyclerAdapter.e(this));
    AppMethodBeat.o(204010);
  }
  
  public void w(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(204009);
    k.h(paramRecyclerView, "recyclerView");
    RecyclerView.m localm = this.LEf;
    if (localm != null)
    {
      localm.b(paramRecyclerView, 5);
      AppMethodBeat.o(204009);
      return;
    }
    AppMethodBeat.o(204009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */