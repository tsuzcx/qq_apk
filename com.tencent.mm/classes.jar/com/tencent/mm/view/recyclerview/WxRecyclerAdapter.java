package com.tencent.mm.view.recyclerview;

import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "convertTypeMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "dataChangeListener", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "dataScrollListener", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener;", "isFirstViewHolder", "onItemConvertClickListener", "Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "getOnItemConvertClickListener", "()Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "setOnItemConvertClickListener", "(Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;)V", "sessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getSessionExposeMap", "()Landroid/util/LongSparseArray;", "totalExposeMap", "getTotalExposeMap", "visibleExposeMap", "getVisibleExposeMap", "wxItemShowInfoMap", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getWxItemShowInfoMap", "wxRVListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getWxRVListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "setWxRVListener", "(Lcom/tencent/mm/view/recyclerview/WxRVListener;)V", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "_onBindHeaderHolder", "_onBindViewHolder", "payloads", "", "", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "_onCreateHeaderHolder", "_onCreateViewHolder", "viewType", "bindViewListener", "itemView", "Landroid/view/View;", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/ConvertData;I)V", "clearConverter", "clearReportData", "getData", "getFooterConvert", "getHeaderConvert", "getItemConvert", "needBindClickEvent", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindFirstBodyViewHolder", "onDetachedFromRecyclerView", "onPause", "onResume", "onViewAttachedToWindow", "onViewRecycled", "wrapViewHolder", "view", "WxRecyclerOnScrollListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WxRecyclerAdapter<D extends a>
  extends i<j>
{
  private final g AKf;
  private final boolean agOK;
  public final SparseArray<f<?>> agOL;
  public final LongSparseArray<l> agOM;
  public boolean agON;
  public h<D> agOO;
  public final LongSparseArray<n> agOP;
  public final LongSparseArray<n> agOQ;
  public final LongSparseArray<n> agOR;
  public o agOS;
  public WxRecyclerAdapter<D>.a agOT;
  private RecyclerView.c agOU;
  public final ArrayList<D> data;
  
  public WxRecyclerAdapter(g paramg, ArrayList<D> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(234906);
    this.AKf = paramg;
    this.data = paramArrayList;
    this.agOK = paramBoolean;
    this.agOL = new SparseArray();
    this.agOM = new LongSparseArray();
    this.agON = true;
    this.agOP = new LongSparseArray();
    this.agOQ = new LongSparseArray();
    this.agOR = new LongSparseArray();
    AppMethodBeat.o(234906);
  }
  
  private static final void a(WxRecyclerAdapter paramWxRecyclerAdapter, View paramView1, a parama, int paramInt, View paramView2)
  {
    AppMethodBeat.i(234969);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWxRecyclerAdapter);
    localb.cH(paramView1);
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/WxRecyclerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWxRecyclerAdapter, "this$0");
    s.u(paramView1, "$itemView");
    s.u(parama, "$data");
    paramWxRecyclerAdapter = paramWxRecyclerAdapter.agOO;
    if (paramWxRecyclerAdapter != null) {
      paramWxRecyclerAdapter.a(paramView1, parama, paramInt);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/view/recyclerview/WxRecyclerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(234969);
  }
  
  private static final void a(l paraml, j paramj)
  {
    AppMethodBeat.i(234934);
    s.u(paraml, "$this_apply");
    s.u(paramj, "$holder");
    paraml.width = paramj.caK.getMeasuredWidth();
    paraml.height = paramj.caK.getMeasuredHeight();
    AppMethodBeat.o(234934);
  }
  
  private static final boolean a(WxRecyclerAdapter paramWxRecyclerAdapter, View paramView1, a parama, int paramInt, View paramView2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234959);
    s.u(paramWxRecyclerAdapter, "this$0");
    s.u(paramView1, "$itemView");
    s.u(parama, "$data");
    paramWxRecyclerAdapter = paramWxRecyclerAdapter.agOO;
    if (paramWxRecyclerAdapter == null)
    {
      AppMethodBeat.o(234959);
      return false;
    }
    s.s(paramMotionEvent, "event");
    boolean bool = paramWxRecyclerAdapter.a(paramView1, paramMotionEvent, parama);
    AppMethodBeat.o(234959);
    return bool;
  }
  
  private final f<i.b> aGk(int paramInt)
  {
    AppMethodBeat.i(164733);
    f localf = (f)this.agOL.get(paramInt);
    Object localObject = localf;
    if (localf == null)
    {
      localf = this.AKf.yF(paramInt);
      this.agOL.put(paramInt, localf);
      localObject = localf;
      if (!localf.agNV)
      {
        localf.a(getRecyclerView(), this);
        localObject = localf;
      }
    }
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
      AppMethodBeat.o(164733);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164733);
    return localObject;
  }
  
  private final f<i.b> aGl(int paramInt)
  {
    AppMethodBeat.i(164734);
    f localf = (f)this.agOL.get(paramInt);
    Object localObject = localf;
    if (localf == null)
    {
      localf = this.AKf.yF(paramInt);
      this.agOL.put(paramInt, localf);
      localObject = localf;
      if (!localf.agNV)
      {
        localf.a(getRecyclerView(), this);
        localObject = localf;
      }
    }
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
      AppMethodBeat.o(164734);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164734);
    return localObject;
  }
  
  private static final void b(WxRecyclerAdapter paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(234951);
    s.u(paramWxRecyclerAdapter, "this$0");
    paramWxRecyclerAdapter.p(paramWxRecyclerAdapter.getRecyclerView());
    AppMethodBeat.o(234951);
  }
  
  private static final void b(l paraml, j paramj)
  {
    AppMethodBeat.i(234942);
    s.u(paraml, "$this_apply");
    s.u(paramj, "$holder");
    paraml.width = paramj.caK.getMeasuredWidth();
    paraml.height = paramj.caK.getMeasuredHeight();
    AppMethodBeat.o(234942);
  }
  
  private static final boolean b(WxRecyclerAdapter paramWxRecyclerAdapter, View paramView1, a parama, int paramInt, View paramView2)
  {
    AppMethodBeat.i(234976);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWxRecyclerAdapter);
    localb.cH(paramView1);
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/WxRecyclerAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramWxRecyclerAdapter, "this$0");
    s.u(paramView1, "$itemView");
    s.u(parama, "$data");
    paramWxRecyclerAdapter = paramWxRecyclerAdapter.agOO;
    if (paramWxRecyclerAdapter == null) {}
    for (boolean bool = false;; bool = paramWxRecyclerAdapter.b(paramView1, parama, paramInt))
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, new Object(), "com/tencent/mm/view/recyclerview/WxRecyclerAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(234976);
      return bool;
    }
  }
  
  private final void c(View paramView, D paramD, int paramInt)
  {
    AppMethodBeat.i(234915);
    if (!bZD())
    {
      AppMethodBeat.o(234915);
      return;
    }
    paramView.setOnTouchListener(new WxRecyclerAdapter..ExternalSyntheticLambda2(this, paramView, paramD, paramInt));
    paramView.setOnClickListener(new WxRecyclerAdapter..ExternalSyntheticLambda0(this, paramView, paramD, paramInt));
    paramView.setOnLongClickListener(new WxRecyclerAdapter..ExternalSyntheticLambda1(this, paramView, paramD, paramInt));
    AppMethodBeat.o(234915);
  }
  
  private static final void c(WxRecyclerAdapter paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(234981);
    s.u(paramWxRecyclerAdapter, "this$0");
    WxRecyclerAdapter.a locala = paramWxRecyclerAdapter.agOT;
    if (locala != null) {
      locala.onScrollStateChanged(paramWxRecyclerAdapter.getRecyclerView(), 7);
    }
    AppMethodBeat.o(234981);
  }
  
  private static final void d(WxRecyclerAdapter paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(234984);
    s.u(paramWxRecyclerAdapter, "this$0");
    Log.i("RecyclerViewAdapterEx", "onPause visibleExposeMap.size:" + paramWxRecyclerAdapter.agOR.size() + " sessionExposeMap.size:" + paramWxRecyclerAdapter.agOQ.size());
    paramWxRecyclerAdapter.agOR.clear();
    paramWxRecyclerAdapter.agOQ.clear();
    AppMethodBeat.o(234984);
  }
  
  private f<D> yF(int paramInt)
  {
    AppMethodBeat.i(164732);
    f localf = (f)this.agOL.get(paramInt);
    Object localObject = localf;
    if (localf == null)
    {
      localf = this.AKf.yF(paramInt);
      this.agOL.put(paramInt, localf);
      localObject = localf;
      if (!localf.agNV)
      {
        localf.a(getRecyclerView(), this);
        localObject = localf;
      }
    }
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D of com.tencent.mm.view.recyclerview.WxRecyclerAdapter>");
      AppMethodBeat.o(164732);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(164732);
    return localObject;
  }
  
  public final int aGc(int paramInt)
  {
    AppMethodBeat.i(164721);
    paramInt = ((a)this.data.get(paramInt)).bZB();
    AppMethodBeat.o(164721);
    return paramInt;
  }
  
  public final long aGd(int paramInt)
  {
    AppMethodBeat.i(164722);
    long l = ((a)this.data.get(paramInt)).bZA();
    AppMethodBeat.o(164722);
    return l;
  }
  
  public boolean bZD()
  {
    return false;
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(235011);
    s.u(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    int i = 0;
    int k = this.agOL.size();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      i = this.agOL.keyAt(i);
      Object localObject = this.agOL.get(i);
      s.s(localObject, "convertTypeMap.get(key)");
      localObject = (f)localObject;
      if (!((f)localObject).agNV) {
        ((f)localObject).a(paramRecyclerView, this);
      }
      if (j >= k)
      {
        if (this.agOK)
        {
          localObject = new WxRecyclerAdapter.a(this);
          paramRecyclerView.a((RecyclerView.l)localObject);
          ah localah = ah.aiuX;
          this.agOT = ((WxRecyclerAdapter.a)localObject);
          paramRecyclerView = new WxRecyclerAdapter.b(paramRecyclerView, this);
          a((RecyclerView.c)paramRecyclerView);
          localObject = ah.aiuX;
          this.agOU = ((RecyclerView.c)paramRecyclerView);
        }
        AppMethodBeat.o(235011);
        return;
      }
      i = j;
    }
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(235012);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    int i = 0;
    int k = this.agOL.size();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      i = this.agOL.keyAt(i);
      Object localObject = this.agOL.get(i);
      s.s(localObject, "convertTypeMap.get(key)");
      localObject = (f)localObject;
      if (((f)localObject).agNV) {
        ((f)localObject).e(paramRecyclerView);
      }
      if (j >= k)
      {
        paramRecyclerView = this.agOU;
        if (paramRecyclerView != null) {
          b(paramRecyclerView);
        }
        AppMethodBeat.o(235012);
        return;
      }
      i = j;
    }
  }
  
  public void e(j paramj, int paramInt)
  {
    AppMethodBeat.i(182559);
    s.u(paramj, "holder");
    int i = getItemViewType(this.agOb.size() + paramInt);
    Object localObject = this.data.get(paramInt);
    s.s(localObject, "data[position]");
    localObject = (a)localObject;
    paramj.CSA = localObject;
    paramj.mkw = getRecyclerView();
    Log.i("RecyclerViewAdapterEx", "_onBindViewHolder pos:" + paramInt + ", item:" + localObject.hashCode() + " ry=" + paramj.getRecyclerView().hashCode());
    yF(i).a(paramj, (a)localObject, paramInt, i, false, null);
    paramj = paramj.caK;
    s.s(paramj, "holder.itemView");
    c(paramj, (a)localObject, paramInt);
    if (this.agON)
    {
      this.agON = false;
      getRecyclerView().post(new WxRecyclerAdapter..ExternalSyntheticLambda3(this));
    }
    AppMethodBeat.o(182559);
  }
  
  public final int jNl()
  {
    AppMethodBeat.i(164723);
    int i = this.data.size();
    AppMethodBeat.o(164723);
    return i;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(235039);
    getRecyclerView().post(new WxRecyclerAdapter..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(235039);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(235035);
    getRecyclerView().post(new WxRecyclerAdapter..ExternalSyntheticLambda5(this));
    AppMethodBeat.o(235035);
  }
  
  public void p(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(235029);
    s.u(paramRecyclerView, "recyclerView");
    WxRecyclerAdapter.a locala = this.agOT;
    if (locala != null) {
      locala.onScrollStateChanged(paramRecyclerView, 5);
    }
    AppMethodBeat.o(235029);
  }
  
  public void v(j paramj)
  {
    AppMethodBeat.i(235017);
    s.u(paramj, "holder");
    super.o((RecyclerView.v)paramj);
    Object localObject = paramj.caK.getLayoutParams();
    if (localObject != null)
    {
      a locala = (a)paramj.CSA;
      if (locala != null)
      {
        if ((localObject instanceof StaggeredGridLayoutManager.LayoutParams))
        {
          localObject = new l(((StaggeredGridLayoutManager.LayoutParams)localObject).Lh(), paramj.caK.getMeasuredWidth(), paramj.caK.getMeasuredHeight());
          if ((((l)localObject).width == 0) || (((l)localObject).height == 0)) {
            paramj.caK.post(new WxRecyclerAdapter..ExternalSyntheticLambda7((l)localObject, paramj));
          }
          this.agOM.put(locala.bZA(), localObject);
          AppMethodBeat.o(235017);
          return;
        }
        localObject = new l(0, paramj.caK.getMeasuredWidth(), paramj.caK.getMeasuredHeight());
        if ((((l)localObject).width == 0) || (((l)localObject).height == 0)) {
          paramj.caK.post(new WxRecyclerAdapter..ExternalSyntheticLambda6((l)localObject, paramj));
        }
        this.agOM.put(locala.bZA(), localObject);
      }
    }
    AppMethodBeat.o(235017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */