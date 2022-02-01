package com.tencent.mm.view.recyclerview;

import android.annotation.SuppressLint;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "convertTypeMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "dataChangeListener", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "dataScrollListener", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener;", "isFirstViewHolder", "onItemConvertClickListener", "Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "getOnItemConvertClickListener", "()Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "setOnItemConvertClickListener", "(Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;)V", "sessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getSessionExposeMap", "()Landroid/util/LongSparseArray;", "totalExposeMap", "getTotalExposeMap", "visibleExposeMap", "getVisibleExposeMap", "wxItemShowInfoMap", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getWxItemShowInfoMap", "wxRVListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getWxRVListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "setWxRVListener", "(Lcom/tencent/mm/view/recyclerview/WxRVListener;)V", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "_onBindHeaderHolder", "_onBindViewHolder", "payloads", "", "", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "_onCreateHeaderHolder", "_onCreateViewHolder", "viewType", "bindViewListener", "itemView", "Landroid/view/View;", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/ConvertData;I)V", "clearConverter", "clearReportData", "getData", "getFooterConvert", "getHeaderConvert", "getItemConvert", "needBindClickEvent", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindFirstBodyViewHolder", "onDetachedFromRecyclerView", "onPause", "onResume", "onViewAttachedToWindow", "onViewRecycled", "wrapViewHolder", "view", "WxRecyclerOnScrollListener", "libmmui_release"})
public class WxRecyclerAdapter<D extends a>
  extends h<i>
{
  public final SparseArray<e<?>> YST;
  public final LongSparseArray<j> YSU;
  public boolean YSV;
  public g<D> YSW;
  public final LongSparseArray<l> YSX;
  public final LongSparseArray<l> YSY;
  public final LongSparseArray<l> YSZ;
  public m YTa;
  public WxRecyclerAdapter<D>.a YTb;
  private RecyclerView.c YTc;
  private final boolean YTd;
  public final ArrayList<D> data;
  private final f xlM;
  
  public WxRecyclerAdapter(f paramf, ArrayList<D> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(193904);
    this.xlM = paramf;
    this.data = paramArrayList;
    this.YTd = paramBoolean;
    this.YST = new SparseArray();
    this.YSU = new LongSparseArray();
    this.YSV = true;
    this.YSX = new LongSparseArray();
    this.YSY = new LongSparseArray();
    this.YSZ = new LongSparseArray();
    AppMethodBeat.o(193904);
  }
  
  private final e<h.b> azD(int paramInt)
  {
    AppMethodBeat.i(164733);
    e locale = (e)this.YST.get(paramInt);
    Object localObject = locale;
    if (locale == null)
    {
      locale = this.xlM.yx(paramInt);
      this.YST.put(paramInt, locale);
      localObject = locale;
      if (!locale.YSe)
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
  
  private final e<h.b> azE(int paramInt)
  {
    AppMethodBeat.i(164734);
    e locale = (e)this.YST.get(paramInt);
    Object localObject = locale;
    if (locale == null)
    {
      locale = this.xlM.yx(paramInt);
      if (locale == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx.FixedViewInfo>");
        AppMethodBeat.o(164734);
        throw ((Throwable)localObject);
      }
      this.YST.put(paramInt, locale);
      localObject = locale;
      if (!locale.YSe)
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
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void b(final View paramView, final D paramD, final int paramInt)
  {
    AppMethodBeat.i(193895);
    if (!bAS())
    {
      AppMethodBeat.o(193895);
      return;
    }
    paramView.setOnTouchListener((View.OnTouchListener)new c(this, paramView, paramD, paramInt));
    paramView.setOnClickListener((View.OnClickListener)new d(this, paramView, paramD, paramInt));
    paramView.setOnLongClickListener((View.OnLongClickListener)new e(this, paramView, paramD, paramInt));
    AppMethodBeat.o(193895);
  }
  
  private final e<D> yx(int paramInt)
  {
    AppMethodBeat.i(164732);
    e locale = (e)this.YST.get(paramInt);
    Object localObject = locale;
    if (locale == null)
    {
      locale = this.xlM.yx(paramInt);
      if (locale == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.ItemConvert<D>");
        AppMethodBeat.o(164732);
        throw ((Throwable)localObject);
      }
      this.YST.put(paramInt, locale);
      localObject = locale;
      if (!locale.YSe)
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
  
  public final int azy(int paramInt)
  {
    AppMethodBeat.i(164721);
    paramInt = ((a)this.data.get(paramInt)).bAQ();
    AppMethodBeat.o(164721);
    return paramInt;
  }
  
  public final long azz(int paramInt)
  {
    AppMethodBeat.i(164722);
    long l = ((a)this.data.get(paramInt)).mf();
    AppMethodBeat.o(164722);
    return l;
  }
  
  public void b(i parami, int paramInt)
  {
    AppMethodBeat.i(182559);
    p.k(parami, "holder");
    int i = getItemViewType(this.YSk.size() + paramInt);
    Object localObject = this.data.get(paramInt);
    p.j(localObject, "data[position]");
    localObject = (a)localObject;
    parami.ez(localObject);
    parami.setRecyclerView(getRecyclerView());
    Log.i("RecyclerViewAdapterEx", "_onBindViewHolder pos:" + paramInt + ", item:" + localObject.hashCode() + " ry=" + parami.getRecyclerView().hashCode());
    yx(i).a(parami, (a)localObject, paramInt, i, false, null);
    parami = parami.amk;
    p.j(parami, "holder.itemView");
    b(parami, (a)localObject, paramInt);
    if (this.YSV)
    {
      this.YSV = false;
      getRecyclerView().post((Runnable)new b(this));
    }
    AppMethodBeat.o(182559);
  }
  
  public boolean bAS()
  {
    return false;
  }
  
  public final void d(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(193871);
    p.k(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    int j = this.YST.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      int k = this.YST.keyAt(i);
      localObject = this.YST.get(k);
      p.j(localObject, "convertTypeMap.get(key)");
      localObject = (e)localObject;
      if (!((e)localObject).YSe) {
        ((e)localObject).a(paramRecyclerView, this);
      }
      i += 1;
    }
    if (this.YTd)
    {
      localObject = new a();
      paramRecyclerView.a((RecyclerView.l)localObject);
      this.YTb = ((a)localObject);
      paramRecyclerView = new f(this, paramRecyclerView);
      a((RecyclerView.c)paramRecyclerView);
      this.YTc = ((RecyclerView.c)paramRecyclerView);
    }
    AppMethodBeat.o(193871);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(193872);
    p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    int j = this.YST.size();
    int i = 0;
    while (i < j)
    {
      int k = this.YST.keyAt(i);
      Object localObject = this.YST.get(k);
      p.j(localObject, "convertTypeMap.get(key)");
      localObject = (e)localObject;
      if (((e)localObject).YSe) {
        ((e)localObject).e(paramRecyclerView);
      }
      i += 1;
    }
    paramRecyclerView = this.YTc;
    if (paramRecyclerView != null)
    {
      b(paramRecyclerView);
      AppMethodBeat.o(193872);
      return;
    }
    AppMethodBeat.o(193872);
  }
  
  public final int ihV()
  {
    AppMethodBeat.i(164723);
    int i = this.data.size();
    AppMethodBeat.o(164723);
    return i;
  }
  
  public void l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(193890);
    p.k(paramRecyclerView, "recyclerView");
    a locala = this.YTb;
    if (locala != null)
    {
      locala.onScrollStateChanged(paramRecyclerView, 5);
      AppMethodBeat.o(193890);
      return;
    }
    AppMethodBeat.o(193890);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(193903);
    getRecyclerView().post((Runnable)new g(this));
    AppMethodBeat.o(193903);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(193902);
    getRecyclerView().post((Runnable)new h(this));
    AppMethodBeat.o(193902);
  }
  
  public void p(final i parami)
  {
    AppMethodBeat.i(193875);
    p.k(parami, "holder");
    super.n((RecyclerView.v)parami);
    Object localObject1 = parami.amk;
    p.j(localObject1, "holder.itemView");
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      final a locala = (a)parami.ihX();
      if (locala != null)
      {
        if ((localObject1 instanceof StaggeredGridLayoutManager.LayoutParams))
        {
          i = ((StaggeredGridLayoutManager.LayoutParams)localObject1).kv();
          localObject2 = parami.amk;
          p.j(localObject2, "holder.itemView");
          int j = ((View)localObject2).getMeasuredWidth();
          localObject2 = parami.amk;
          p.j(localObject2, "holder.itemView");
          localObject2 = new j(i, j, ((View)localObject2).getMeasuredHeight());
          if ((((j)localObject2).width == 0) || (((j)localObject2).height == 0)) {
            parami.amk.post((Runnable)new i((j)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, parami));
          }
          this.YSU.put(locala.mf(), localObject2);
          AppMethodBeat.o(193875);
          return;
        }
        Object localObject2 = parami.amk;
        p.j(localObject2, "holder.itemView");
        int i = ((View)localObject2).getMeasuredWidth();
        localObject2 = parami.amk;
        p.j(localObject2, "holder.itemView");
        localObject2 = new j(0, i, ((View)localObject2).getMeasuredHeight());
        if ((((j)localObject2).width == 0) || (((j)localObject2).height == 0)) {
          parami.amk.post((Runnable)new j((j)localObject2, locala, (ViewGroup.LayoutParams)localObject1, this, parami));
        }
        this.YSU.put(locala.mf(), localObject2);
        AppMethodBeat.o(193875);
        return;
      }
      AppMethodBeat.o(193875);
      return;
    }
    AppMethodBeat.o(193875);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "currentState", "", "getCurrentState", "()I", "setCurrentState", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastState", "getLastState", "setLastState", "scaledTouchSlop", "getScaledTouchSlop", "sumOffset", "getSumOffset", "setSumOffset", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "reset", "libmmui_release"})
  public final class a
    extends RecyclerView.l
  {
    public int YTe;
    public int currentState;
    public int sCr;
    public int sCs;
    private final int xqP;
    public int xqS;
    
    public a()
    {
      AppMethodBeat.i(197184);
      this.sCr = -1;
      this.sCs = -1;
      this$1 = ViewConfiguration.get(this$1.getRecyclerView().getContext());
      p.j(this$1, "ViewConfiguration.get(recyclerView.context)");
      this.xqP = this$1.getScaledTouchSlop();
      AppMethodBeat.o(197184);
    }
    
    public final void onScrollStateChanged(final RecyclerView paramRecyclerView, final int paramInt)
    {
      AppMethodBeat.i(197173);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      paramRecyclerView.post((Runnable)new a(this, paramInt, paramRecyclerView));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(197173);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197180);
      Object localObject = new b();
      ((b)localObject).bn(paramRecyclerView);
      ((b)localObject).sg(paramInt1);
      ((b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (this.currentState == 2)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(197180);
        return;
      }
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null) {
        p.iCn();
      }
      p.j(localObject, "recyclerView.layoutManager!!");
      if (((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {}
      for (;;)
      {
        this.YTe += paramInt1;
        if ((Math.abs(this.YTe) > this.xqP * 5) || ((this.xqS == 2) && (this.currentState == 1)))
        {
          onScrollStateChanged(paramRecyclerView, 3);
          this.YTe = 0;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$WxRecyclerOnScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(197180);
        return;
        paramInt1 = paramInt2;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
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
        AppMethodBeat.i(191040);
        final aa.f localf = new aa.f();
        localf.aaBC = new k(paramInt);
        ((k)localf.aaBC).sCr = this.YTg.sCr;
        ((k)localf.aaBC).sCs = this.YTg.sCs;
        Object localObject1 = paramRecyclerView.getLayoutManager();
        Object localObject4;
        label190:
        int j;
        if ((localObject1 instanceof LinearLayoutManager))
        {
          ((k)localf.aaBC).xrh = Math.max(0, ((LinearLayoutManager)localObject1).kJ());
          ((k)localf.aaBC).xrj = Math.max(0, ((LinearLayoutManager)localObject1).kL());
          localObject5 = paramRecyclerView.cJ(((k)localf.aaBC).xrh);
          if (localObject5 != null)
          {
            localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).md());
            if (localObject5 == null) {
              break label288;
            }
            localObject4 = Integer.valueOf(((RecyclerView.v)localObject5).mc());
            if (!(p.h(localObject1, localObject4) ^ true)) {
              break label804;
            }
            localObject4 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
            if (localObject5 == null) {
              break label294;
            }
          }
          label288:
          label294:
          for (localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).md());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject6;
            if (localObject5 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).mc());
            }
            Log.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(191040);
            return;
            localObject1 = null;
            break;
            localObject4 = null;
            break label190;
          }
        }
        else if ((localObject1 instanceof StaggeredGridLayoutManager))
        {
          localObject4 = ((StaggeredGridLayoutManager)localObject1).k(null);
          localObject1 = ((StaggeredGridLayoutManager)localObject1).l(null);
          localObject6 = (k)localf.aaBC;
          if (localObject4 != null)
          {
            i = localObject4[0];
            if (localObject4 == null) {
              break label557;
            }
            j = localObject4[1];
            label360:
            ((k)localObject6).xrh = Math.min(i, j);
            localObject4 = (k)localf.aaBC;
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
            ((k)localObject4).xrj = Math.max(i, j);
            localObject6 = paramRecyclerView.cJ(((k)localf.aaBC).xrh);
            if (localObject6 == null) {
              break label572;
            }
            localObject1 = Integer.valueOf(((RecyclerView.v)localObject6).md());
            label445:
            if (localObject6 == null) {
              break label578;
            }
            localObject4 = Integer.valueOf(((RecyclerView.v)localObject6).mc());
            label460:
            if (!(p.h(localObject1, localObject4) ^ true)) {
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
          for (localObject1 = Integer.valueOf(((RecyclerView.v)localObject6).md());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject5;
            if (localObject6 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.v)localObject6).mc());
            }
            Log.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(191040);
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
          ((k)localf.aaBC).xrh = Math.max(0, ((GridLayoutManager)localObject1).kJ());
          ((k)localf.aaBC).xrj = Math.max(0, ((GridLayoutManager)localObject1).kL());
          localObject5 = paramRecyclerView.cJ(((k)localf.aaBC).xrh);
          if (localObject5 != null)
          {
            localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).md());
            if (localObject5 == null) {
              break label792;
            }
            localObject4 = Integer.valueOf(((RecyclerView.v)localObject5).mc());
            label694:
            if (!(p.h(localObject1, localObject4) ^ true)) {
              break label804;
            }
            localObject4 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
            if (localObject5 == null) {
              break label798;
            }
          }
          label792:
          label798:
          for (localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).md());; localObject1 = null)
          {
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", layoutPosition=");
            localObject1 = localObject7;
            if (localObject5 != null) {
              localObject1 = Integer.valueOf(((RecyclerView.v)localObject5).mc());
            }
            Log.w("RecyclerViewAdapterEx", localObject1);
            AppMethodBeat.o(191040);
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
          this.YTg.sCr = ((k)localf.aaBC).xrh;
          this.YTg.sCs = ((k)localf.aaBC).xrj;
          try
          {
            i = ((k)localf.aaBC).xrh;
            j = ((k)localf.aaBC).xrj;
            if (i <= j)
            {
              if ((this.YTg.YTf.getItemCount() <= 0) || ((i < 0) && (i >= this.YTg.YTf.getItemCount()))) {
                break label2016;
              }
              m = i - this.YTg.YTf.YSk.size();
              if (m < 0) {
                localObject1 = (a)this.YTg.YTf.azA(i);
              }
              for (;;)
              {
                localObject4 = new l((a)localObject1);
                ((l)localObject4).xre = i;
                ((l)localObject4).xrf = ((j)this.YTg.YTf.YSU.get(((a)localObject1).mf()));
                ((k)localf.aaBC).YSK.add(localObject4);
                break;
                if (m >= WxRecyclerAdapter.a(this.YTg.YTf).size())
                {
                  localObject1 = (a)this.YTg.YTf.azB(m - WxRecyclerAdapter.a(this.YTg.YTf).size());
                }
                else
                {
                  localObject1 = WxRecyclerAdapter.a(this.YTg.YTf).get(m);
                  p.j(localObject1, "data[dataIndex]");
                  localObject1 = (a)localObject1;
                }
              }
            }
            if (((k)localf.aaBC).sCr != ((k)localf.aaBC).xrh) {}
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException1, "", new Object[0]);
          }
          if ((((k)localf.aaBC).sCs == ((k)localf.aaBC).xrj) || ((((k)localf.aaBC).sCr == -1) && (((k)localf.aaBC).sCs == -1)))
          {
            ((k)localf.aaBC).YSL.addAll((Collection)((k)localf.aaBC).YSK);
            label1222:
            localObject2 = new LongSparseArray();
            localObject4 = ((Iterable)((k)localf.aaBC).YSK).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (l)((Iterator)localObject4).next();
              ((LongSparseArray)localObject2).put(((l)localObject5).YSP.mf(), localObject5);
              if (this.YTg.YTf.YSZ.indexOfKey(((l)localObject5).YSP.mf()) < 0) {
                ((k)localf.aaBC).YSN.add(localObject5);
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            i = kotlin.k.i.ow(((k)localf.aaBC).xrh, ((k)localf.aaBC).sCr);
            j = kotlin.k.i.ow(this.YTg.YTf.getItemCount() - 1, kotlin.k.i.ov(((k)localf.aaBC).xrj, ((k)localf.aaBC).sCs));
            if (i > j) {
              break label1222;
            }
            if ((this.YTg.YTf.getItemCount() <= 0) || ((i < 0) && (i >= this.YTg.YTf.getItemCount()))) {
              break label2028;
            }
            m = i - this.YTg.YTf.YSk.size();
            if (m < 0)
            {
              localObject2 = (a)this.YTg.YTf.azA(i);
              localObject4 = new l((a)localObject2);
              ((l)localObject4).xre = m;
              ((l)localObject4).xrf = ((j)this.YTg.YTf.YSU.get(((a)localObject2).mf()));
              ((k)localf.aaBC).YSL.add(localObject4);
              break label2028;
            }
            if (m >= WxRecyclerAdapter.a(this.YTg.YTf).size())
            {
              localObject2 = (a)this.YTg.YTf.azB(m - WxRecyclerAdapter.a(this.YTg.YTf).size());
              continue;
            }
            localObject2 = WxRecyclerAdapter.a(this.YTg.YTf).get(m);
            p.j(localObject2, "data[dataIndex]");
            localObject2 = (a)localObject2;
            continue;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException2, "", new Object[0]);
          }
          j = this.YTg.YTf.YSZ.size();
          i = 0;
          while (i < j)
          {
            localObject4 = (l)this.YTg.YTf.YSZ.valueAt(i);
            if (localException2.indexOfKey(((l)localObject4).YSP.mf()) < 0) {
              ((k)localf.aaBC).YSM.add(localObject4);
            }
            i += 1;
          }
          this.YTg.YTf.YSZ.clear();
          j = localException2.size();
          i = k;
          while (i < j)
          {
            localObject4 = (l)localException2.valueAt(i);
            this.YTg.YTf.YSZ.put(((l)localObject4).YSP.mf(), localObject4);
            i += 1;
          }
          Object localObject3 = ((Iterable)((k)localf.aaBC).YSL).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (l)((Iterator)localObject3).next();
            if (this.YTg.YTf.YSY.indexOfKey(((l)localObject4).YSP.mf()) < 0) {
              this.YTg.YTf.YSY.put(((l)localObject4).YSP.mf(), localObject4);
            }
            if (this.YTg.YTf.YSX.indexOfKey(((l)localObject4).YSP.mf()) < 0)
            {
              this.YTg.YTf.YSX.put(((l)localObject4).YSP.mf(), localObject4);
              ((k)localf.aaBC).YSO.add(localObject4);
            }
          }
          localObject3 = com.tencent.e.h.ZvG;
          localObject4 = (Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221660);
              m localm = this.YTh.YTg.YTf.YTa;
              if (localm != null)
              {
                localm.a(this.YTh.xmk, (k)localf.aaBC);
                AppMethodBeat.o(221660);
                return;
              }
              AppMethodBeat.o(221660);
            }
          };
          localObject5 = m.YSQ;
          ((com.tencent.e.i)localObject3).d((Runnable)localObject4, m.a.ihY());
          AppMethodBeat.o(191040);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class b
    implements Runnable
  {
    b(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(191828);
      this.YTf.l(this.YTf.getRecyclerView());
      AppMethodBeat.o(191828);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(WxRecyclerAdapter paramWxRecyclerAdapter, View paramView, a parama, int paramInt) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200520);
      paramView = this.YTf.YSW;
      if (paramView != null)
      {
        View localView = paramView;
        p.j(paramMotionEvent, "event");
        boolean bool = paramView.a(localView, paramMotionEvent, paramD);
        AppMethodBeat.o(200520);
        return bool;
      }
      AppMethodBeat.o(200520);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(WxRecyclerAdapter paramWxRecyclerAdapter, View paramView, a parama, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199767);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$bindViewListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.YTf.YSW;
      if (paramView != null) {
        paramView.a(paramView, paramD);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$bindViewListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199767);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class e
    implements View.OnLongClickListener
  {
    e(WxRecyclerAdapter paramWxRecyclerAdapter, View paramView, a parama, int paramInt) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(202589);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/WxRecyclerAdapter$bindViewListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      paramView = this.YTf.YSW;
      if (paramView != null) {}
      for (boolean bool = paramView.a(paramView, paramD, paramInt);; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$bindViewListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(202589);
        return bool;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onAttachedToRecyclerView$2", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "notifyChangeEvent", "", "onChanged", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class f
    extends RecyclerView.c
  {
    f(RecyclerView paramRecyclerView) {}
    
    private void ihZ()
    {
      AppMethodBeat.i(220718);
      paramRecyclerView.post((Runnable)new a(this));
      AppMethodBeat.o(220718);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(220720);
      super.onChanged();
      ihZ();
      AppMethodBeat.o(220720);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(220722);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      ihZ();
      AppMethodBeat.o(220722);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(220725);
      super.onItemRangeInserted(paramInt1, paramInt2);
      ihZ();
      AppMethodBeat.o(220725);
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220727);
      super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
      ihZ();
      AppMethodBeat.o(220727);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(220730);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      ihZ();
      AppMethodBeat.o(220730);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
    static final class a
      implements Runnable
    {
      a(WxRecyclerAdapter.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(208607);
        WxRecyclerAdapter.a locala = WxRecyclerAdapter.b(this.YTk.YTf);
        if (locala != null)
        {
          locala.onScrollStateChanged(this.YTk.xmk, 8);
          AppMethodBeat.o(208607);
          return;
        }
        AppMethodBeat.o(208607);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class g
    implements Runnable
  {
    g(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(189396);
      Log.i("RecyclerViewAdapterEx", "onPause visibleExposeMap.size:" + this.YTf.YSZ.size() + " sessionExposeMap.size:" + this.YTf.YSY.size());
      this.YTf.YSZ.clear();
      this.YTf.YSY.clear();
      AppMethodBeat.o(189396);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run"})
  static final class h
    implements Runnable
  {
    h(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(206391);
      WxRecyclerAdapter.a locala = WxRecyclerAdapter.b(this.YTf);
      if (locala != null)
      {
        locala.onScrollStateChanged(this.YTf.getRecyclerView(), 7);
        AppMethodBeat.o(206391);
        return;
      }
      AppMethodBeat.o(206391);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$1$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$1"})
  static final class i
    implements Runnable
  {
    i(j paramj, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(198666);
      j localj = this.YTl;
      View localView = parami.amk;
      p.j(localView, "holder.itemView");
      localj.width = localView.getMeasuredWidth();
      localj = this.YTl;
      localView = parami.amk;
      p.j(localView, "holder.itemView");
      localj.height = localView.getMeasuredHeight();
      AppMethodBeat.o(198666);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "run", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$onViewAttachedToWindow$1$1$2$1", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$apply$lambda$2", "com/tencent/mm/view/recyclerview/WxRecyclerAdapter$$special$$inlined$let$lambda$2"})
  static final class j
    implements Runnable
  {
    j(j paramj, a parama, ViewGroup.LayoutParams paramLayoutParams, WxRecyclerAdapter paramWxRecyclerAdapter, i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(198877);
      j localj = this.YTl;
      View localView = parami.amk;
      p.j(localView, "holder.itemView");
      localj.width = localView.getMeasuredWidth();
      localj = this.YTl;
      localView = parami.amk;
      p.j(localView, "holder.itemView");
      localj.height = localView.getMeasuredHeight();
      AppMethodBeat.o(198877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */