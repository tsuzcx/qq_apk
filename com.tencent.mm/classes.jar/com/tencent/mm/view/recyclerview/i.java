package com.tencent.mm.view.recyclerview;

import android.database.Observable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "disableItemTouch", "", "getDisableItemTouch", "()Z", "setDisableItemTouch", "(Z)V", "footerInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lkotlin/collections/ArrayList;", "headerInfoList", "hookObservable", "Landroid/database/Observable;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "isAttachedToRecyclerView", "setAttachedToRecyclerView", "isHookRecyclerViewAdapterObservableSuccessfully", "isHookRecyclerViewAdapterObservableSuccessfully$delegate", "Lkotlin/Lazy;", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "setSupportAvoidCrashWithNotifyWhenScrollOrLayout", "itemClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "getItemClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "setItemClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;)V", "itemLongClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "getItemLongClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "setItemLongClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;)V", "itemTouchListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;", "getItemTouchListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;", "setItemTouchListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;)V", "observable", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerViewOriginalObserver", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)V", "_onBindHeaderHolder", "_onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "(Landroid/view/ViewGroup;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "_onCreateHeaderHolder", "_onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addFooter", "isNotifyAnim", "addFooterView", "resource", "Landroid/view/View;", "addHeader", "addHeaderView", "containsFooter", "containsHeader", "findViewHolderByItemId", "itemId", "isLog", "(JZ)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getContentCount", "getFixCount", "getFixPosition", "getFooterCount", "getFooterData", "footerPosition", "getHeaderCount", "getHeaderData", "headerPosition", "getItemCount", "getItemId", "getItemViewType", "hookRecyclerViewAdapterObservable", "notifyItemChanged", "notifyItemRemoved", "onAttachedToRecyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewDetachedFromWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "protectViewItemRecycleHealthy", "view", "registerAdapterDataObserver", "observer", "removeFooter", "removeHeader", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "(Ljava/lang/Exception;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)Ljava/lang/String;", "throwCreateViewHolderException", "unregisterAdapterDataObserver", "wrapViewHolder", "(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Companion", "FixedViewInfo", "OnItemClickListener", "OnItemLongClickListener", "OnItemTouchListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i<VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  public static final i.a agNW = new i.a((byte)0);
  private boolean agNV;
  boolean agNX = true;
  private Observable<RecyclerView.c> agNY;
  private final j agNZ = k.cm((kotlin.g.a.a)new h(this));
  private final ConcurrentLinkedQueue<RecyclerView.c> agOa = new ConcurrentLinkedQueue();
  public final ArrayList<b> agOb = new ArrayList();
  public final ArrayList<b> agOc = new ArrayList();
  public i.d<VH> agOd;
  public i.c<VH> agOe;
  public i.e<VH> agOf;
  public boolean agOg;
  public RecyclerView mkw;
  
  private VH AR(long paramLong)
  {
    new StringBuilder();
    int i = 0;
    int k = getRecyclerView().getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      RecyclerView.v localv = getRecyclerView().by(getRecyclerView().getChildAt(i));
      if ((localv != null) && (localv.KJ() != -1) && (paramLong == getItemId(localv.KJ()))) {
        return localv;
      }
      if (j >= k) {
        return null;
      }
      i = j;
    }
  }
  
  private static final void a(i parami, RecyclerView.v paramv, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parami);
    localb.cH(paramv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    s.u(paramv, "$holder");
    localObject = parami.getRecyclerView().by(paramView);
    if (localObject == null) {}
    for (int i = -1;; i = ((RecyclerView.v)localObject).KJ())
    {
      localObject = parami.agOe;
      if (localObject != null)
      {
        parami = (RecyclerView.a)parami;
        s.s(paramView, "it");
        ((i.c)localObject).a(parami, paramView, i, paramv);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
  }
  
  private static final boolean a(i parami, RecyclerView.v paramv, View paramView, MotionEvent paramMotionEvent)
  {
    s.u(parami, "this$0");
    s.u(paramv, "$holder");
    s.u(paramView, "view");
    s.u(paramMotionEvent, "motionEvent");
    Object localObject = parami.getRecyclerView().by(paramView);
    if (localObject == null) {}
    for (int i = -1;; i = ((RecyclerView.v)localObject).KJ())
    {
      localObject = parami.agOf;
      if (localObject != null) {
        break;
      }
      return false;
    }
    return ((i.e)localObject).a((RecyclerView.a)parami, paramView, i, paramv, paramMotionEvent);
  }
  
  private static final boolean b(i parami, RecyclerView.v paramv, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parami);
    localb.cH(paramv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(parami, "this$0");
    s.u(paramv, "$holder");
    localObject = parami.getRecyclerView().by(paramView);
    int i;
    if (localObject == null)
    {
      i = -1;
      localObject = parami.agOd;
      if (localObject != null) {
        break label139;
      }
    }
    for (boolean bool = false;; bool = ((i.d)localObject).b(parami, paramView, i, paramv))
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, new Object(), "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      return bool;
      i = ((RecyclerView.v)localObject).KJ();
      break;
      label139:
      parami = (RecyclerView.a)parami;
      s.s(paramView, "it");
    }
  }
  
  private final void fM(View paramView)
  {
    int i;
    int k;
    if ((paramView instanceof ViewGroup))
    {
      i = 0;
      k = ((ViewGroup)paramView).getChildCount();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      View localView = ((ViewGroup)paramView).getChildAt(i);
      if (localView != null)
      {
        localView.animate().cancel();
        localView.hasTransientState();
        fM(localView);
      }
      if (j >= k)
      {
        paramView.animate().cancel();
        return;
      }
      i = j;
    }
  }
  
  private final boolean jNj()
  {
    return ((Boolean)this.agNZ.getValue()).booleanValue();
  }
  
  private final boolean jNk()
  {
    Object localObject;
    try
    {
      Field localField = RecyclerView.a.class.getDeclaredField("bZE");
      localField.setAccessible(true);
      localObject = localField.get(this).getClass().getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      if (localObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.database.Observable<androidx.recyclerview.widget.RecyclerView.AdapterDataObserver>");
      }
    }
    finally
    {
      Log.printErrStackTrace("RecyclerViewAdapterEx", localThrowable, "", new Object[0]);
      return false;
    }
    this.agNY = ((Observable)localObject);
    localThrowable.set(this, this.agNY);
    Observable localObservable = this.agNY;
    return localObservable != null;
  }
  
  public final void AQ(long paramLong)
  {
    RecyclerView.v localv = AR(paramLong);
    if (localv != null) {
      fV(localv.KJ());
    }
  }
  
  public VH a(ViewGroup paramViewGroup, int paramInt, b paramb)
  {
    s.u(paramViewGroup, "parent");
    s.u(paramb, "info");
    return null;
  }
  
  public String a(Exception paramException, VH paramVH, List<Object> paramList)
  {
    s.u(paramException, "e");
    s.u(paramVH, "holder");
    s.u(paramList, "payloads");
    return "";
  }
  
  public final void a(RecyclerView.c paramc)
  {
    s.u(paramc, "observer");
    if (jNj())
    {
      this.agOa.add(paramc);
      return;
    }
    super.a(paramc);
  }
  
  public void a(VH paramVH, int paramInt, b paramb)
  {
    s.u(paramVH, "holder");
    s.u(paramb, "info");
  }
  
  public void a(VH paramVH, int paramInt, List<Object> paramList)
  {
    s.u(paramVH, "holder");
    s.u(paramList, "payloads");
    for (;;)
    {
      try
      {
        if (!((Collection)paramList).isEmpty()) {
          break label261;
        }
        i = 1;
        if (i != 0)
        {
          super.a(paramVH, paramInt, paramList);
          return;
        }
        if (paramInt < this.agOb.size())
        {
          Object localObject1 = this.agOb.get(paramInt);
          s.s(localObject1, "headerInfoList[position]");
          a(paramVH, paramInt, (b)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        paramVH = a(localException, paramVH, paramList) + " crashActivity=" + paramVH.caK.getContext().getClass().getName();
        paramVH = new RuntimeException(localException.getMessage() + '\n' + paramVH);
        paramVH.setStackTrace(localException.getStackTrace());
        throw ((Throwable)paramVH);
      }
      if (paramInt >= jNl() + this.agOb.size())
      {
        i = this.agOb.size();
        int j = jNl();
        Object localObject2 = this.agOc.get(paramInt - (i + j));
        s.s(localObject2, "footerInfoList[footerIndex]");
        b(paramVH, paramInt, (b)localObject2);
        return;
      }
      b(paramVH, paramInt - this.agOb.size(), paramList);
      return;
      label261:
      int i = 0;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean)
  {
    s.u(paramb, "info");
    if (!this.agOb.contains(paramb))
    {
      this.agOb.add(paramb);
      if (paramBoolean) {
        fW(this.agOb.size() - 1);
      }
    }
    else
    {
      return;
    }
    Log.i("RecyclerViewAdapterEx", "[addHeader] notifyDataSetChanged");
    this.bZE.notifyChanged();
  }
  
  public final boolean a(b paramb)
  {
    s.u(paramb, "info");
    return this.agOb.contains(paramb);
  }
  
  public int aGc(int paramInt)
  {
    return 0;
  }
  
  public long aGd(int paramInt)
  {
    return 0L;
  }
  
  public final b aGe(int paramInt)
  {
    Object localObject = this.agOb.get(paramInt);
    s.s(localObject, "headerInfoList[headerPosition]");
    return (b)localObject;
  }
  
  public final b aGf(int paramInt)
  {
    Object localObject = this.agOc.get(paramInt);
    s.s(localObject, "footerInfoList[footerPosition]");
    return (b)localObject;
  }
  
  public final void ae(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.agOb.iterator();
    s.s(localIterator, "headerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      s.s(localObject, "iterator.next()");
      if (((b)localObject).bZA() != paramLong) {
        break label126;
      }
      localIterator.remove();
      int k = 1;
      i = k;
      if (paramBoolean)
      {
        fX(j);
        i = k;
      }
    }
    label126:
    for (;;)
    {
      j += 1;
      break;
      if ((i != 0) && (!paramBoolean))
      {
        Log.i("RecyclerViewAdapterEx", "[removeHeader] notifyDataSetChanged");
        this.bZE.notifyChanged();
      }
      return;
    }
  }
  
  public final void af(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.agOc.iterator();
    s.s(localIterator, "footerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      s.s(localObject, "iterator.next()");
      if (((b)localObject).bZA() != paramLong) {
        break label139;
      }
      localIterator.remove();
      int k = 1;
      i = k;
      if (paramBoolean)
      {
        fX(this.agOb.size() + jNl() + j);
        i = k;
      }
    }
    label139:
    for (;;)
    {
      j += 1;
      break;
      if ((i != 0) && (!paramBoolean))
      {
        Log.i("RecyclerViewAdapterEx", "[removeFooter] notifyDataSetChanged");
        this.bZE.notifyChanged();
      }
      return;
    }
  }
  
  public final VH b(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    s.u(paramViewGroup, "parent");
    int j;
    label62:
    label78:
    int k;
    try
    {
      localObject4 = ((List)this.agOb).iterator();
      i = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label606;
      }
      if (((b)((Iterator)localObject4).next()).bZB() != paramInt) {
        break label593;
      }
      j = 1;
    }
    catch (Exception localException)
    {
      paramViewGroup = c(localException, paramInt) + " crashActivity=" + paramViewGroup.getContext().getClass().getName();
      paramViewGroup = new RuntimeException(localException.getMessage() + '\n' + paramViewGroup);
      paramViewGroup.setStackTrace(localException.getStackTrace());
      throw ((Throwable)paramViewGroup);
    }
    Object localObject4 = ((List)this.agOc).iterator();
    int i = 0;
    if (((Iterator)localObject4).hasNext()) {
      label162:
      if (((b)((Iterator)localObject4).next()).bZB() == paramInt)
      {
        k = 1;
        break label582;
        label111:
        if (j >= 0)
        {
          localObject3 = this.agOb.get(j);
          s.s(localObject3, "headerInfoList[indexH]");
          localObject3 = (b)localObject3;
          if (((b)localObject3).jNm())
          {
            localObject4 = ((b)localObject3).getView();
            if (localObject4 == null)
            {
              if (localObject1 != null) {
                break label630;
              }
              localObject1 = (i)this;
              localObject3 = af.mU(paramViewGroup.getContext()).inflate(((b)localObject3).getLayoutId(), paramViewGroup, false);
              s.s(localObject3, "getInflater(parent.conte…ayoutId(), parent, false)");
              localObject1 = ((i)localObject1).mC((View)localObject3);
            }
          }
        }
      }
    }
    label571:
    label582:
    label593:
    label599:
    label606:
    label618:
    label630:
    label633:
    for (;;)
    {
      localObject3 = ((RecyclerView.v)localObject1).caK;
      s.s(localObject3, "holder.itemView");
      Object localObject2;
      if ((!((View)localObject3).hasOnClickListeners()) && (!this.agOg))
      {
        ((View)localObject3).setOnClickListener(new i..ExternalSyntheticLambda0(this, (RecyclerView.v)localObject1));
        ((View)localObject3).setOnLongClickListener(new i..ExternalSyntheticLambda1(this, (RecyclerView.v)localObject1));
        ((View)localObject3).setOnTouchListener(new i..ExternalSyntheticLambda2(this, (RecyclerView.v)localObject1));
        return localObject1;
        localObject1 = mC((View)localObject4);
        break label162;
        localObject1 = a(paramViewGroup, paramInt, (b)localObject3);
        s.checkNotNull(localObject1);
        continue;
        if (i >= 0)
        {
          localObject2 = this.agOc.get(i);
          s.s(localObject2, "footerInfoList[indexF]");
          localObject4 = (b)localObject2;
          if (((b)localObject4).jNm())
          {
            localObject2 = ((b)localObject4).getView();
            if (localObject2 == null) {}
            for (localObject2 = localObject3;; localObject2 = mC((View)localObject2))
            {
              if (localObject2 != null) {
                break label633;
              }
              localObject2 = (i)this;
              localObject3 = af.mU(paramViewGroup.getContext()).inflate(((b)localObject4).getLayoutId(), paramViewGroup, false);
              s.s(localObject3, "getInflater(parent.conte…ayoutId(), parent, false)");
              localObject2 = ((i)localObject2).mC((View)localObject3);
              break;
            }
          }
          localObject2 = this.agOc.get(i);
          s.s(localObject2, "footerInfoList[indexF]");
          localObject2 = b(paramViewGroup, paramInt, (b)localObject2);
          s.checkNotNull(localObject2);
          continue;
        }
        localObject2 = q(paramViewGroup, paramInt);
        continue;
        if (j == 0) {
          break label599;
        }
        j = i;
        break label62;
      }
      for (;;)
      {
        if (k == 0) {
          break label618;
        }
        break label111;
        return localObject2;
        j = 0;
        break label571;
        i += 1;
        break;
        j = -1;
        break label62;
        k = 0;
      }
      i += 1;
      break label78;
      i = -1;
      break label111;
    }
  }
  
  public VH b(ViewGroup paramViewGroup, int paramInt, b paramb)
  {
    s.u(paramViewGroup, "parent");
    s.u(paramb, "info");
    return null;
  }
  
  public final void b(RecyclerView.c paramc)
  {
    s.u(paramc, "observer");
    if (jNj())
    {
      this.agOa.remove(paramc);
      return;
    }
    super.b(paramc);
  }
  
  public void b(VH paramVH, int paramInt, b paramb)
  {
    s.u(paramVH, "holder");
    s.u(paramb, "info");
  }
  
  public abstract void b(VH paramVH, int paramInt, List<Object> paramList);
  
  public final boolean b(b paramb)
  {
    s.u(paramb, "info");
    return this.agOc.contains(paramb);
  }
  
  public String c(Exception paramException, int paramInt)
  {
    s.u(paramException, "e");
    return s.X("viewType=", Integer.valueOf(paramInt));
  }
  
  public final void d(VH paramVH, int paramInt)
  {
    s.u(paramVH, "holder");
    long l = SystemClock.uptimeMillis();
    Object localObject;
    if (paramInt < this.agOb.size())
    {
      localObject = this.agOb.get(paramInt);
      s.s(localObject, "headerInfoList[position]");
      localObject = (b)localObject;
      if (!((b)localObject).jNm()) {
        a(paramVH, paramInt, (b)localObject);
      }
    }
    for (;;)
    {
      l = SystemClock.uptimeMillis() - l;
      if (l > 17L) {
        Log.i("RecyclerViewAdapterEx", "[onBindViewHolder] pos:" + paramInt + ", itemId=" + getItemId(paramInt) + " itemType=" + getItemViewType(paramInt) + " cost=" + l);
      }
      return;
      if (paramInt >= jNl() + this.agOb.size())
      {
        int i = this.agOb.size();
        int j = jNl();
        localObject = this.agOc.get(paramInt - (i + j));
        s.s(localObject, "footerInfoList[footerIndex]");
        localObject = (b)localObject;
        if (!((b)localObject).jNm()) {
          b(paramVH, paramInt, (b)localObject);
        }
      }
      else
      {
        h(paramVH, paramInt - this.agOb.size());
      }
    }
  }
  
  public void d(final RecyclerView paramRecyclerView)
  {
    s.u(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    s.u(paramRecyclerView, "<set-?>");
    this.mkw = paramRecyclerView;
    this.agNV = this.agNV;
    if (jNj())
    {
      Observable localObservable = this.agNY;
      if (localObservable != null) {
        localObservable.registerObserver(new i(this, paramRecyclerView));
      }
    }
  }
  
  public void e(RecyclerView paramRecyclerView)
  {
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    this.agNV = false;
  }
  
  public final int getItemCount()
  {
    return this.agOb.size() + jNl() + this.agOc.size();
  }
  
  public final long getItemId(int paramInt)
  {
    if ((getItemCount() <= paramInt) || (paramInt < 0))
    {
      String str = "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " headerCount=" + this.agOb.size() + " footerCount=" + this.agOc.size() + ' ' + Util.getStack();
      Log.e("RecyclerViewAdapterEx", str);
      h.OAn.b(20251, new Object[] { Integer.valueOf(3), str });
      return 0L;
    }
    if (paramInt < this.agOb.size()) {
      return ((b)this.agOb.get(paramInt)).bZA();
    }
    if (paramInt >= jNl() + this.agOb.size())
    {
      int i = this.agOb.size();
      int j = jNl();
      return ((b)this.agOc.get(paramInt - (i + j))).bZA();
    }
    return aGd(paramInt - this.agOb.size());
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt < this.agOb.size()) {
      return ((b)this.agOb.get(paramInt)).bZB();
    }
    if (paramInt >= jNl() + this.agOb.size())
    {
      int i = this.agOb.size();
      int j = jNl();
      return ((b)this.agOc.get(paramInt - (i + j))).bZB();
    }
    return aGc(paramInt - this.agOb.size());
  }
  
  public final RecyclerView getRecyclerView()
  {
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      return localRecyclerView;
    }
    s.bIx("recyclerView");
    return null;
  }
  
  public abstract void h(VH paramVH, int paramInt);
  
  public final b i(View paramView, int paramInt, boolean paramBoolean)
  {
    s.u(paramView, "resource");
    paramView = new i.g(paramView, paramInt);
    if (!this.agOb.contains(paramView))
    {
      this.agOb.add(paramView);
      Log.i("Finder.FinderTopicFeedUIContract.TopicFeedViewCallback", s.X("headerInfoList.add : ", Long.valueOf(paramView.bZA())));
      if (!paramBoolean) {
        break label78;
      }
      fW(this.agOb.size() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label78:
      Log.i("RecyclerViewAdapterEx", "[addHeaderView] notifyDataSetChanged");
      this.bZE.notifyChanged();
    }
  }
  
  public final b j(View paramView, int paramInt, boolean paramBoolean)
  {
    s.u(paramView, "resource");
    paramView = new i.f(paramView, paramInt);
    if (!this.agOc.contains(paramView))
    {
      this.agOc.add(paramView);
      if (!paramBoolean) {
        break label56;
      }
      fW(getItemCount() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label56:
      Log.i("RecyclerViewAdapterEx", "[addFooterView] notifyDataSetChanged");
      this.bZE.notifyChanged();
    }
  }
  
  public abstract int jNl();
  
  public abstract VH mC(View paramView);
  
  public final void p(VH paramVH)
  {
    s.u(paramVH, "holder");
    super.p(paramVH);
    paramVH = paramVH.caK;
    s.s(paramVH, "holder.itemView");
    fM(paramVH);
  }
  
  public abstract VH q(ViewGroup paramViewGroup, int paramInt);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "getLayoutId", "", "getView", "Landroid/view/View;", "isStatic", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class b
    implements a
  {
    public int getLayoutId()
    {
      return 0;
    }
    
    public View getView()
    {
      return null;
    }
    
    public boolean jNm()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    h(i<VH> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "checkValid", "", "preItemCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends RecyclerView.c
  {
    private final Handler mainHandler;
    
    i(i<VH> parami, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(234911);
      this.mainHandler = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(234911);
    }
    
    private static final void a(i parami, int paramInt1, i parami1, int paramInt2)
    {
      AppMethodBeat.i(234923);
      s.u(parami, "this$0");
      s.u(parami1, "this$1");
      if (!parami.aGg(paramInt1))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeChanged] preItemCount=" + paramInt1 + " but now itemCount is " + parami1.getItemCount());
        AppMethodBeat.o(234923);
        return;
      }
      parami1.t(paramInt2, Integer.valueOf(paramInt1));
      AppMethodBeat.o(234923);
    }
    
    private static final void a(i parami, int paramInt1, i parami1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(234936);
      s.u(parami, "this$0");
      s.u(parami1, "this$1");
      if (!parami.aGg(paramInt1))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeMoved] preItemCount=" + paramInt1 + " but now itemCount is " + parami1.getItemCount());
        AppMethodBeat.o(234936);
        return;
      }
      parami1.bz(paramInt2, paramInt3);
      AppMethodBeat.o(234936);
    }
    
    private static final void a(i parami, int paramInt1, i parami1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(234928);
      s.u(parami, "this$0");
      s.u(parami1, "this$1");
      if (!parami.aGg(paramInt1))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeChanged] preItemCount=" + paramInt1 + " but now itemCount is " + parami1.getItemCount());
        AppMethodBeat.o(234928);
        return;
      }
      parami1.e(paramInt2, paramInt1, paramObject);
      AppMethodBeat.o(234928);
    }
    
    private boolean aGg(int paramInt)
    {
      AppMethodBeat.i(234914);
      if (paramInt == this.agOi.getItemCount())
      {
        AppMethodBeat.o(234914);
        return true;
      }
      AppMethodBeat.o(234914);
      return false;
    }
    
    private static final void b(i parami, int paramInt1, i parami1, int paramInt2)
    {
      AppMethodBeat.i(234931);
      s.u(parami, "this$0");
      s.u(parami1, "this$1");
      if (!parami.aGg(paramInt1))
      {
        Log.e("RecyclerViewAdapterEx", "[onItemRangeInserted] preItemCount=" + paramInt1 + " but now itemCount is " + parami1.getItemCount());
        AppMethodBeat.o(234931);
        return;
      }
      parami1.bA(paramInt2, paramInt1);
      AppMethodBeat.o(234931);
    }
    
    private static final void c(i parami, int paramInt1, i parami1, int paramInt2)
    {
      AppMethodBeat.i(234945);
      s.u(parami, "this$0");
      s.u(parami1, "this$1");
      if (!parami.aGg(paramInt1))
      {
        Log.e("RecyclerViewAdapterEx", "[notifyItemRangeRemoved] preItemCount=" + paramInt1 + " but now itemCount is " + parami1.getItemCount());
        AppMethodBeat.o(234945);
        return;
      }
      parami1.bB(paramInt2, paramInt1);
      AppMethodBeat.o(234945);
    }
    
    private static final void c(i parami)
    {
      AppMethodBeat.i(234919);
      s.u(parami, "this$0");
      parami.bZE.notifyChanged();
      AppMethodBeat.o(234919);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(164712);
      if ((this.agOi.agNX) && (paramRecyclerView.Ka()))
      {
        Log.w("RecyclerViewAdapterEx", "[onChanged] Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post(new i.i..ExternalSyntheticLambda5(this.agOi));
        AppMethodBeat.o(164712);
        return;
      }
      Iterator localIterator = ((Iterable)i.a(this.agOi)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).onChanged();
      }
      AppMethodBeat.o(164712);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164713);
      if ((this.agOi.agNX) && (paramRecyclerView.Ka()))
      {
        Log.w("RecyclerViewAdapterEx", "[onItemRangeChanged] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
        paramRecyclerView.post(new i.i..ExternalSyntheticLambda2(this, paramInt2, this.agOi, paramInt1));
        AppMethodBeat.o(164713);
        return;
      }
      Iterator localIterator = ((Iterable)i.a(this.agOi)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).onItemRangeChanged(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164713);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(164714);
      if ((this.agOi.agNX) && (paramRecyclerView.Ka()))
      {
        Log.w("RecyclerViewAdapterEx", "[onItemRangeChanged] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + " payload=" + paramObject + ' ' + Util.getStack());
        paramRecyclerView.post(new i.i..ExternalSyntheticLambda4(this, paramInt2, this.agOi, paramInt1, paramObject));
        AppMethodBeat.o(164714);
        return;
      }
      Iterator localIterator = ((Iterable)i.a(this.agOi)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).onItemRangeChanged(paramInt1, paramInt2, paramObject);
      }
      AppMethodBeat.o(164714);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164715);
      if ((this.agOi.agNX) && (paramRecyclerView.Ka()))
      {
        Log.w("RecyclerViewAdapterEx", "[onItemRangeInserted] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
        paramRecyclerView.post(new i.i..ExternalSyntheticLambda1(this, paramInt2, this.agOi, paramInt1));
        AppMethodBeat.o(164715);
        return;
      }
      Iterator localIterator = ((Iterable)i.a(this.agOi)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).onItemRangeInserted(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164715);
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(164716);
      if ((this.agOi.agNX) && (paramRecyclerView.Ka()))
      {
        Log.w("RecyclerViewAdapterEx", "[onItemRangeMoved] Cannot call this method while RecyclerView is computing a layout or scrolling, fromPosition=" + paramInt1 + " toPosition=" + paramInt2 + " itemCount=" + paramInt3 + ' ' + Util.getStack());
        paramRecyclerView.post(new i.i..ExternalSyntheticLambda3(this, paramInt3, this.agOi, paramInt1, paramInt2));
        AppMethodBeat.o(164716);
        return;
      }
      Iterator localIterator = ((Iterable)i.a(this.agOi)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).onItemRangeMoved(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(164716);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164717);
      if ((this.agOi.agNX) && (paramRecyclerView.Ka()))
      {
        Log.w("RecyclerViewAdapterEx", "[onItemRangeRemoved] Cannot call this method while RecyclerView is computing a layout or scrolling, positionStart=" + paramInt1 + " itemCount=" + paramInt2 + ' ' + Util.getStack());
        paramRecyclerView.post(new i.i..ExternalSyntheticLambda0(this, paramInt2, this.agOi, paramInt1));
        AppMethodBeat.o(164717);
        return;
      }
      Iterator localIterator = ((Iterable)i.a(this.agOi)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).onItemRangeRemoved(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.i
 * JD-Core Version:    0.7.0.1
 */