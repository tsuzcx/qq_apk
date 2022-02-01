package com.tencent.mm.view.recyclerview;

import android.database.Observable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "footerInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lkotlin/collections/ArrayList;", "headerInfoList", "hookObservable", "Landroid/database/Observable;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "isHookRecyclerViewAdapterObservableSuccessfully", "isHookRecyclerViewAdapterObservableSuccessfully$delegate", "Lkotlin/Lazy;", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "setSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "setSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "itemClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "getItemClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "setItemClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;)V", "itemLongClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "getItemLongClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "setItemLongClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;)V", "itemTouchListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;", "getItemTouchListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;", "setItemTouchListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemTouchListener;)V", "observable", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerViewOriginalObserver", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)V", "_onBindHeaderHolder", "_onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "(Landroid/view/ViewGroup;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "_onCreateHeaderHolder", "_onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addFooter", "isNotifyAnim", "addFooterView", "resource", "Landroid/view/View;", "addHeader", "addHeaderView", "containsFooter", "containsHeader", "findViewHolderByItemId", "itemId", "isLog", "(JZ)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getContentCount", "getFixCount", "getFixPosition", "getFooterCount", "getFooterData", "footerPosition", "getHeaderCount", "getHeaderData", "headerPosition", "getItemCount", "getItemId", "getItemViewType", "hookRecyclerViewAdapterObservable", "notifyItemChanged", "onAttachedToRecyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewDetachedFromWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "protectViewItemRecycleHealthy", "view", "registerAdapterDataObserver", "observer", "removeFooter", "removeHeader", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "(Ljava/lang/Exception;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)Ljava/lang/String;", "throwCreateViewHolderException", "unregisterAdapterDataObserver", "wrapViewHolder", "(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Companion", "FixedViewInfo", "OnItemClickListener", "OnItemLongClickListener", "OnItemTouchListener", "libmmui_release"})
public abstract class h<VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  public static final a YSp = new a((byte)0);
  private boolean YSe;
  boolean YSf = true;
  boolean YSg = true;
  private Observable<RecyclerView.c> YSh;
  private final f YSi = g.ar((kotlin.g.a.a)new h(this));
  private final ConcurrentLinkedQueue<RecyclerView.c> YSj = new ConcurrentLinkedQueue();
  public final ArrayList<b> YSk = new ArrayList();
  public final ArrayList<b> YSl = new ArrayList();
  public h.d<VH> YSm;
  public h.c<VH> YSn;
  public h.e<VH> YSo;
  public RecyclerView jLl;
  
  private VH WG(long paramLong)
  {
    new StringBuilder();
    Object localObject1 = this.jLl;
    if (localObject1 == null) {
      p.bGy("recyclerView");
    }
    int j = ((RecyclerView)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject1 = this.jLl;
      if (localObject1 == null) {
        p.bGy("recyclerView");
      }
      Object localObject2 = this.jLl;
      if (localObject2 == null) {
        p.bGy("recyclerView");
      }
      localObject2 = ((RecyclerView)localObject1).bf(((RecyclerView)localObject2).getChildAt(i));
      if ((localObject2 != null) && (((RecyclerView.v)localObject2).md() != -1) && (paramLong == getItemId(((RecyclerView.v)localObject2).md())))
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label142;
        }
        throw new t("null cannot be cast to non-null type VH");
      }
      i += 1;
    }
    localObject1 = null;
    label142:
    return localObject1;
  }
  
  private final void ew(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      int j = ((ViewGroup)paramView).getChildCount();
      while (i < j)
      {
        View localView = ((ViewGroup)paramView).getChildAt(i);
        if (localView != null)
        {
          localView.animate().cancel();
          localView.hasTransientState();
          ew(localView);
        }
        i += 1;
      }
      paramView.animate().cancel();
    }
  }
  
  private final boolean ihT()
  {
    return ((Boolean)this.YSi.getValue()).booleanValue();
  }
  
  private final boolean ihU()
  {
    Object localObject;
    try
    {
      Field localField = RecyclerView.a.class.getDeclaredField("alc");
      p.j(localField, "RecyclerView.Adapter::cl…laredField(\"mObservable\")");
      localField.setAccessible(true);
      localObject = localField.get(this).getClass().getDeclaredConstructor(new Class[0]);
      p.j(localObject, "origin.javaClass.getDeclaredConstructor()");
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      p.j(localObject, "constructor.newInstance()");
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type android.database.Observable<androidx.recyclerview.widget.RecyclerView.AdapterDataObserver>");
      }
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("RecyclerViewAdapterEx", localThrowable, "", new Object[0]);
      return false;
    }
    this.YSh = ((Observable)localObject);
    localThrowable.set(this, this.YSh);
    Observable localObservable = this.YSh;
    return localObservable != null;
  }
  
  public final void T(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.YSk.iterator();
    p.j(localIterator, "headerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      p.j(localObject, "iterator.next()");
      if (((b)localObject).mf() != paramLong) {
        break label123;
      }
      localIterator.remove();
      int k = 1;
      i = k;
      if (paramBoolean)
      {
        cN(j);
        i = k;
      }
    }
    label123:
    for (;;)
    {
      j += 1;
      break;
      if ((i != 0) && (!paramBoolean))
      {
        Log.i("RecyclerViewAdapterEx", "[removeHeader] notifyDataSetChanged");
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public final void U(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.YSl.iterator();
    p.j(localIterator, "footerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      p.j(localObject, "iterator.next()");
      if (((b)localObject).mf() != paramLong) {
        break label136;
      }
      localIterator.remove();
      int k = 1;
      i = k;
      if (paramBoolean)
      {
        cN(this.YSk.size() + ihV() + j);
        i = k;
      }
    }
    label136:
    for (;;)
    {
      j += 1;
      break;
      if ((i != 0) && (!paramBoolean))
      {
        Log.i("RecyclerViewAdapterEx", "[removeFooter] notifyDataSetChanged");
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public final void WF(long paramLong)
  {
    RecyclerView.v localv = WG(paramLong);
    if (localv != null) {
      cL(localv.md());
    }
  }
  
  public VH a(ViewGroup paramViewGroup, int paramInt, b paramb)
  {
    p.k(paramViewGroup, "parent");
    p.k(paramb, "info");
    return null;
  }
  
  public String a(Exception paramException, VH paramVH, List<Object> paramList)
  {
    p.k(paramException, "e");
    p.k(paramVH, "holder");
    p.k(paramList, "payloads");
    return "";
  }
  
  public final void a(RecyclerView.c paramc)
  {
    p.k(paramc, "observer");
    if (ihT())
    {
      this.YSj.add(paramc);
      return;
    }
    super.a(paramc);
  }
  
  public void a(VH paramVH, int paramInt, b paramb)
  {
    p.k(paramVH, "holder");
    p.k(paramb, "info");
  }
  
  public void a(VH paramVH, int paramInt, List<Object> paramList)
  {
    p.k(paramVH, "holder");
    p.k(paramList, "payloads");
    for (;;)
    {
      try
      {
        if (!((Collection)paramList).isEmpty()) {
          break label273;
        }
        i = 1;
        if (i != 0)
        {
          super.a(paramVH, paramInt, paramList);
          return;
        }
        if (paramInt < this.YSk.size())
        {
          Object localObject1 = this.YSk.get(paramInt);
          p.j(localObject1, "headerInfoList[position]");
          a(paramVH, paramInt, (b)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        paramList = new StringBuilder().append(a(localException, paramVH, paramList)).append(" crashActivity=");
        paramVH = paramVH.amk;
        p.j(paramVH, "holder.itemView");
        paramVH = paramVH.getContext().getClass().getName();
        paramVH = new RuntimeException(localException.getMessage() + "\n" + paramVH);
        paramVH.setStackTrace(localException.getStackTrace());
        throw ((Throwable)paramVH);
      }
      if (paramInt >= ihV() + this.YSk.size())
      {
        i = this.YSk.size();
        int j = ihV();
        Object localObject2 = this.YSl.get(paramInt - (i + j));
        p.j(localObject2, "footerInfoList[footerIndex]");
        b(paramVH, paramInt, (b)localObject2);
        return;
      }
      b(paramVH, paramInt - this.YSk.size(), paramList);
      return;
      label273:
      int i = 0;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean)
  {
    p.k(paramb, "info");
    if (!this.YSk.contains(paramb))
    {
      this.YSk.add(paramb);
      if (paramBoolean) {
        cM(this.YSk.size() - 1);
      }
    }
    else
    {
      return;
    }
    Log.i("RecyclerViewAdapterEx", "[addHeader] notifyDataSetChanged");
    notifyDataSetChanged();
  }
  
  public final boolean a(b paramb)
  {
    p.k(paramb, "info");
    return this.YSk.contains(paramb);
  }
  
  public final b azA(int paramInt)
  {
    Object localObject = this.YSk.get(paramInt);
    p.j(localObject, "headerInfoList[headerPosition]");
    return (b)localObject;
  }
  
  public final b azB(int paramInt)
  {
    Object localObject = this.YSl.get(paramInt);
    p.j(localObject, "footerInfoList[footerPosition]");
    return (b)localObject;
  }
  
  public int azy(int paramInt)
  {
    return 0;
  }
  
  public long azz(int paramInt)
  {
    return 0L;
  }
  
  public final VH b(ViewGroup paramViewGroup, int paramInt)
  {
    p.k(paramViewGroup, "parent");
    int j;
    try
    {
      localObject1 = ((List)this.YSk).iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label609;
      }
      if (((b)((Iterator)localObject1).next()).bAQ() != paramInt) {
        break label596;
      }
      j = 1;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label56:
      paramViewGroup = c(localException, paramInt) + " crashActivity=" + paramViewGroup.getContext().getClass().getName();
      paramViewGroup = new RuntimeException(localException.getMessage() + "\n" + paramViewGroup);
      paramViewGroup.setStackTrace(localException.getStackTrace());
      throw ((Throwable)paramViewGroup);
    }
    localObject1 = ((List)this.YSl).iterator();
    int i = 0;
    label72:
    int k;
    if (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).bAQ() == paramInt)
      {
        k = 1;
        break label582;
        label105:
        if (j >= 0)
        {
          localObject1 = this.YSk.get(j);
          p.j(localObject1, "headerInfoList[indexH]");
          localObject1 = (b)localObject1;
          if (((b)localObject1).ihW())
          {
            localObject1 = ((b)localObject1).getView();
            if (localObject1 != null)
            {
              localObject1 = je((View)localObject1);
              break label590;
            }
          }
        }
      }
    }
    label167:
    label571:
    label582:
    label590:
    label596:
    label602:
    label609:
    label621:
    label633:
    for (;;)
    {
      Object localObject3 = ((RecyclerView.v)localObject1).amk;
      p.j(localObject3, "holder.itemView");
      Object localObject2;
      if (!((View)localObject3).hasOnClickListeners())
      {
        ((View)localObject3).setOnClickListener((View.OnClickListener)new j(this, (RecyclerView.v)localObject1));
        ((View)localObject3).setOnLongClickListener((View.OnLongClickListener)new k(this, (RecyclerView.v)localObject1));
        ((View)localObject3).setOnTouchListener((View.OnTouchListener)new l(this, (RecyclerView.v)localObject1));
        return localObject1;
        localObject1 = (h)this;
        localObject3 = ad.kS(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
        p.j(localObject3, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
        localObject1 = ((h)localObject1).je((View)localObject3);
        break label590;
        localObject3 = a(paramViewGroup, paramInt, (b)localObject1);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          p.iCn();
          localObject1 = localObject3;
          break label590;
          if (i >= 0)
          {
            localObject2 = this.YSl.get(i);
            p.j(localObject2, "footerInfoList[indexF]");
            localObject2 = (b)localObject2;
            if (((b)localObject2).ihW())
            {
              localObject2 = ((b)localObject2).getView();
              if (localObject2 != null)
              {
                localObject2 = je((View)localObject2);
                break label633;
              }
              localObject2 = (h)this;
              localObject3 = ad.kS(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
              p.j(localObject3, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
              localObject2 = ((h)localObject2).je((View)localObject3);
              break label633;
            }
            localObject2 = this.YSl.get(i);
            p.j(localObject2, "footerInfoList[indexF]");
            localObject3 = b(paramViewGroup, paramInt, (b)localObject2);
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label633;
            }
            p.iCn();
            localObject2 = localObject3;
            break label633;
          }
          localObject2 = q(paramViewGroup, paramInt);
          continue;
          if (j == 0) {
            break label602;
          }
          j = i;
          break label56;
        }
      }
      for (;;)
      {
        if (k == 0) {
          break label621;
        }
        break label105;
        break label167;
        return localObject2;
        j = 0;
        break label571;
        i += 1;
        break;
        j = -1;
        break label56;
        k = 0;
      }
      i += 1;
      break label72;
      i = -1;
      break label105;
    }
  }
  
  public VH b(ViewGroup paramViewGroup, int paramInt, b paramb)
  {
    p.k(paramViewGroup, "parent");
    p.k(paramb, "info");
    return null;
  }
  
  public final void b(RecyclerView.c paramc)
  {
    p.k(paramc, "observer");
    if (ihT())
    {
      this.YSj.remove(paramc);
      return;
    }
    super.b(paramc);
  }
  
  public void b(VH paramVH, int paramInt, b paramb)
  {
    p.k(paramVH, "holder");
    p.k(paramb, "info");
  }
  
  public abstract void b(VH paramVH, int paramInt, List<Object> paramList);
  
  public final boolean b(b paramb)
  {
    p.k(paramb, "info");
    return this.YSl.contains(paramb);
  }
  
  public String c(Exception paramException, int paramInt)
  {
    p.k(paramException, "e");
    return "viewType=".concat(String.valueOf(paramInt));
  }
  
  public final void d(VH paramVH, int paramInt)
  {
    p.k(paramVH, "holder");
    long l = SystemClock.uptimeMillis();
    Object localObject;
    if (paramInt < this.YSk.size())
    {
      localObject = this.YSk.get(paramInt);
      p.j(localObject, "headerInfoList[position]");
      localObject = (b)localObject;
      if (!((b)localObject).ihW()) {
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
      if (paramInt >= ihV() + this.YSk.size())
      {
        int i = this.YSk.size();
        int j = ihV();
        localObject = this.YSl.get(paramInt - (i + j));
        p.j(localObject, "footerInfoList[footerIndex]");
        localObject = (b)localObject;
        if (!((b)localObject).ihW()) {
          b(paramVH, paramInt, (b)localObject);
        }
      }
      else
      {
        h(paramVH, paramInt - this.YSk.size());
      }
    }
  }
  
  public void d(RecyclerView paramRecyclerView)
  {
    p.k(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    this.jLl = paramRecyclerView;
    this.YSe = this.YSe;
    if (ihT())
    {
      Observable localObservable = this.YSh;
      if (localObservable != null) {
        localObservable.registerObserver(new h.i(this, paramRecyclerView));
      }
    }
  }
  
  public void e(RecyclerView paramRecyclerView)
  {
    p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    this.YSe = false;
  }
  
  public final b g(View paramView, final int paramInt, boolean paramBoolean)
  {
    p.k(paramView, "resource");
    paramView = new g(paramView, paramInt);
    if (!this.YSk.contains(paramView))
    {
      this.YSk.add(paramView);
      Log.i("Finder.FinderTopicFeedUIContract.TopicFeedViewCallback", "headerInfoList.add : " + paramView.mf());
      if (!paramBoolean) {
        break label85;
      }
      cM(this.YSk.size() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label85:
      Log.i("RecyclerViewAdapterEx", "[addHeaderView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
  }
  
  public final int getItemCount()
  {
    return this.YSk.size() + ihV() + this.YSl.size();
  }
  
  public final long getItemId(int paramInt)
  {
    if ((getItemCount() <= paramInt) || (paramInt < 0))
    {
      String str = "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " headerCount=" + this.YSk.size() + " footerCount=" + this.YSl.size() + ' ' + Util.getStack();
      Log.e("RecyclerViewAdapterEx", str);
      com.tencent.mm.plugin.report.service.h.IzE.a(20251, new Object[] { Integer.valueOf(3), str });
      return 0L;
    }
    if (paramInt < this.YSk.size()) {
      return ((b)this.YSk.get(paramInt)).mf();
    }
    if (paramInt >= ihV() + this.YSk.size())
    {
      int i = this.YSk.size();
      int j = ihV();
      return ((b)this.YSl.get(paramInt - (i + j))).mf();
    }
    return azz(paramInt - this.YSk.size());
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt < this.YSk.size()) {
      return ((b)this.YSk.get(paramInt)).bAQ();
    }
    if (paramInt >= ihV() + this.YSk.size())
    {
      int i = this.YSk.size();
      int j = ihV();
      return ((b)this.YSl.get(paramInt - (i + j))).bAQ();
    }
    return azy(paramInt - this.YSk.size());
  }
  
  public final RecyclerView getRecyclerView()
  {
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView == null) {
      p.bGy("recyclerView");
    }
    return localRecyclerView;
  }
  
  public final b h(View paramView, final int paramInt, boolean paramBoolean)
  {
    p.k(paramView, "resource");
    paramView = new f(paramView, paramInt);
    if (!this.YSl.contains(paramView))
    {
      this.YSl.add(paramView);
      if (!paramBoolean) {
        break label56;
      }
      cM(getItemCount() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label56:
      Log.i("RecyclerViewAdapterEx", "[addFooterView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
  }
  
  public abstract void h(VH paramVH, int paramInt);
  
  public abstract int ihV();
  
  public abstract VH je(View paramView);
  
  public final void o(VH paramVH)
  {
    p.k(paramVH, "holder");
    super.o(paramVH);
    paramVH = paramVH.amk;
    p.j(paramVH, "holder.itemView");
    ew(paramVH);
  }
  
  public abstract VH q(ViewGroup paramViewGroup, int paramInt);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "getLayoutId", "", "getView", "Landroid/view/View;", "isStatic", "", "libmmui_release"})
  public static abstract class b
    implements a
  {
    public View getView()
    {
      return null;
    }
    
    public boolean ihW()
    {
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addFooterView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class f
    extends h.b
  {
    f(View paramView, int paramInt) {}
    
    public final int bAQ()
    {
      return paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(164701);
      if (((paramObject instanceof h.b)) && (mf() == ((h.b)paramObject).mf()))
      {
        AppMethodBeat.o(164701);
        return true;
      }
      AppMethodBeat.o(164701);
      return false;
    }
    
    public final View getView()
    {
      return this.YSq;
    }
    
    public final boolean ihW()
    {
      return true;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(164700);
      long l = this.YSq.hashCode();
      AppMethodBeat.o(164700);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addHeaderView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class g
    extends h.b
  {
    g(View paramView, int paramInt) {}
    
    public final int bAQ()
    {
      return paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(164703);
      if (((paramObject instanceof h.b)) && (mf() == ((h.b)paramObject).mf()))
      {
        AppMethodBeat.o(164703);
        return true;
      }
      AppMethodBeat.o(164703);
      return false;
    }
    
    public final View getView()
    {
      return this.YSq;
    }
    
    public final boolean ihW()
    {
      return true;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(164702);
      long l = this.YSq.hashCode();
      AppMethodBeat.o(164702);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    h(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(h paramh, RecyclerView.v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164719);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = this.YSr.getRecyclerView().bf(paramView);
      if (localObject != null) {}
      for (int i = ((RecyclerView.v)localObject).md();; i = -1)
      {
        localObject = this.YSr.YSn;
        if (localObject != null)
        {
          RecyclerView.a locala = (RecyclerView.a)this.YSr;
          p.j(paramView, "it");
          ((h.c)localObject).a(locala, paramView, i, this.BdR);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164719);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class k
    implements View.OnLongClickListener
  {
    k(h paramh, RecyclerView.v paramv) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164720);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
      localObject = this.YSr.getRecyclerView().bf(paramView);
      int i;
      RecyclerView.a locala;
      if (localObject != null)
      {
        i = ((RecyclerView.v)localObject).md();
        localObject = this.YSr.YSm;
        if (localObject == null) {
          break label131;
        }
        locala = (RecyclerView.a)this.YSr;
        p.j(paramView, "it");
      }
      label131:
      for (boolean bool = ((h.d)localObject).b(locala, paramView, i, this.BdR);; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164720);
        return bool;
        i = -1;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "onTouch"})
  static final class l
    implements View.OnTouchListener
  {
    l(h paramh, RecyclerView.v paramv) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(196017);
      p.k(paramView, "view");
      p.k(paramMotionEvent, "motionEvent");
      Object localObject = this.YSr.getRecyclerView().bf(paramView);
      if (localObject != null) {}
      for (int i = ((RecyclerView.v)localObject).md();; i = -1)
      {
        localObject = this.YSr.YSo;
        if (localObject == null) {
          break;
        }
        boolean bool = ((h.e)localObject).a((RecyclerView.a)this.YSr, paramView, i, this.BdR, paramMotionEvent);
        AppMethodBeat.o(196017);
        return bool;
      }
      AppMethodBeat.o(196017);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h
 * JD-Core Version:    0.7.0.1
 */