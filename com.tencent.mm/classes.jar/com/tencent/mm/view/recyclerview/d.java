package com.tencent.mm.view.recyclerview;

import android.database.Observable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "footerInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lkotlin/collections/ArrayList;", "headerInfoList", "hookObservable", "Landroid/database/Observable;", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "isHookRecyclerViewAdapterObservableSuccessfully", "isHookRecyclerViewAdapterObservableSuccessfully$delegate", "Lkotlin/Lazy;", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "setSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "setSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "itemClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "getItemClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "setItemClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;)V", "itemLongClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "getItemLongClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "setItemLongClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;)V", "observable", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "recyclerViewOriginalObserver", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)V", "_onBindHeaderHolder", "_onBindViewHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "(Landroid/view/ViewGroup;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "_onCreateHeaderHolder", "_onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "addFooter", "isNotifyAnim", "addFooterView", "resource", "Landroid/view/View;", "addHeader", "addHeaderView", "containsFooter", "containsHeader", "findViewHolderByItemId", "itemId", "isLog", "(JZ)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getContentCount", "getFixCount", "getFixPosition", "getFooterCount", "getFooterData", "footerPosition", "getHeaderCount", "getHeaderData", "headerPosition", "getItemCount", "getItemId", "getItemViewType", "hookRecyclerViewAdapterObservable", "notifyItemChanged", "onAttachedToRecyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewDetachedFromWindow", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "protectViewItemRecycleHealthy", "view", "registerAdapterDataObserver", "observer", "removeFooter", "removeHeader", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "(Ljava/lang/Exception;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)Ljava/lang/String;", "throwCreateViewHolderException", "unregisterAdapterDataObserver", "wrapViewHolder", "(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Companion", "FixedViewInfo", "OnItemClickListener", "OnItemLongClickListener", "libmmui_release"})
public abstract class d<VH extends RecyclerView.w>
  extends RecyclerView.a<VH>
{
  public static final d.a LRZ = new d.a((byte)0);
  private boolean LRP;
  boolean LRQ = true;
  boolean LRR = true;
  private Observable<RecyclerView.c> LRS;
  private final f LRT = d.g.O((d.g.a.a)new g(this));
  private final ConcurrentLinkedQueue<RecyclerView.c> LRU = new ConcurrentLinkedQueue();
  public final ArrayList<b> LRV = new ArrayList();
  private final ArrayList<b> LRW = new ArrayList();
  public d<VH> LRX;
  public c<VH> LRY;
  public RecyclerView gpr;
  
  private final boolean fUU()
  {
    return ((Boolean)this.LRT.getValue()).booleanValue();
  }
  
  private final boolean fUV()
  {
    Object localObject;
    try
    {
      Field localField = RecyclerView.a.class.getDeclaredField("asY");
      p.g(localField, "field");
      localField.setAccessible(true);
      localObject = localField.get(this).getClass().getDeclaredConstructor(new Class[0]);
      p.g(localObject, "constructor");
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      if (localObject == null) {
        throw new v("null cannot be cast to non-null type android.database.Observable<android.support.v7.widget.RecyclerView.AdapterDataObserver>");
      }
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("RecyclerViewAdapterEx", localThrowable, "", new Object[0]);
      return false;
    }
    this.LRS = ((Observable)localObject);
    localThrowable.set(this, this.LRS);
    ae.i("RecyclerViewAdapterEx", "[hookRecyclerViewAdapterObservable] Successfully.");
    Observable localObservable = this.LRS;
    return localObservable != null;
  }
  
  private final void hs(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      int j = ((ViewGroup)paramView).getChildCount();
      while (i < j)
      {
        View localView = ((ViewGroup)paramView).getChildAt(i);
        localView.animate().cancel();
        if (localView.hasTransientState()) {
          ae.i("RecyclerViewAdapterEx", "[protectViewItemRecycleHealthy] child=".concat(String.valueOf(localView)));
        }
        p.g(localView, "child");
        hs(localView);
        i += 1;
      }
      paramView.animate().cancel();
    }
  }
  
  public final void Fk(long paramLong)
  {
    RecyclerView.w localw = P(paramLong, false);
    if (localw != null) {
      cj(localw.lN());
    }
  }
  
  public final void O(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.LRV.iterator();
    p.g(localIterator, "headerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      p.g(localObject, "iterator.next()");
      if (((b)localObject).lP() != paramLong) {
        break label123;
      }
      localIterator.remove();
      int k = 1;
      i = k;
      if (paramBoolean)
      {
        cl(j);
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
        ae.i("RecyclerViewAdapterEx", "[removeHeader] notifyDataSetChanged");
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public final VH P(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.gpr;
    if (localObject2 == null) {
      p.bdF("recyclerView");
    }
    int j = ((RecyclerView)localObject2).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject2 = this.gpr;
      if (localObject2 == null) {
        p.bdF("recyclerView");
      }
      RecyclerView localRecyclerView = this.gpr;
      if (localRecyclerView == null) {
        p.bdF("recyclerView");
      }
      localObject2 = ((RecyclerView)localObject2).bu(localRecyclerView.getChildAt(i));
      if ((localObject2 != null) && (((RecyclerView.w)localObject2).lN() != -1))
      {
        long l = getItemId(((RecyclerView.w)localObject2).lN());
        if (paramBoolean) {
          ((StringBuilder)localObject1).append("adapterPosition=" + ((RecyclerView.w)localObject2).lN() + " itemId=" + l + '\n');
        }
        if (paramLong == l)
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label223;
          }
          throw new v("null cannot be cast to non-null type VH");
        }
      }
      i += 1;
    }
    if (paramBoolean) {
      ae.w("RecyclerViewAdapterEx", "[findViewHolderByItemId] ".concat(String.valueOf(localObject1)));
    }
    localObject1 = null;
    label223:
    return localObject1;
  }
  
  public final VH a(ViewGroup paramViewGroup, int paramInt)
  {
    p.h(paramViewGroup, "parent");
    int j;
    try
    {
      localObject1 = ((List)this.LRV).iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label591;
      }
      if (((b)((Iterator)localObject1).next()).bZz() != paramInt) {
        break label578;
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
    localObject1 = ((List)this.LRW).iterator();
    int i = 0;
    label72:
    int k;
    if (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).bZz() == paramInt)
      {
        k = 1;
        break label564;
        label105:
        if (j >= 0)
        {
          localObject1 = this.LRV.get(j);
          p.g(localObject1, "headerInfoList[indexH]");
          localObject1 = (b)localObject1;
          if (((b)localObject1).fUX())
          {
            localObject1 = ((b)localObject1).getView();
            if (localObject1 != null)
            {
              localObject1 = hr((View)localObject1);
              break label572;
            }
          }
        }
      }
    }
    label167:
    label553:
    label564:
    label572:
    label578:
    label584:
    label591:
    label603:
    label615:
    for (;;)
    {
      Object localObject3 = ((RecyclerView.w)localObject1).auu;
      p.g(localObject3, "holder.itemView");
      Object localObject2;
      if (!((View)localObject3).hasOnClickListeners())
      {
        ((View)localObject3).setOnClickListener((View.OnClickListener)new i(this, (RecyclerView.w)localObject1));
        ((View)localObject3).setOnLongClickListener((View.OnLongClickListener)new j(this, (RecyclerView.w)localObject1));
        return localObject1;
        localObject1 = (d)this;
        localObject3 = z.jV(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
        p.g(localObject3, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
        localObject1 = ((d)localObject1).hr((View)localObject3);
        break label572;
        localObject3 = a(paramViewGroup, paramInt, (b)localObject1);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          p.gkB();
          localObject1 = localObject3;
          break label572;
          if (i >= 0)
          {
            localObject2 = this.LRW.get(i);
            p.g(localObject2, "footerInfoList[indexF]");
            localObject2 = (b)localObject2;
            if (((b)localObject2).fUX())
            {
              localObject2 = ((b)localObject2).getView();
              if (localObject2 != null)
              {
                localObject2 = hr((View)localObject2);
                break label615;
              }
              localObject2 = (d)this;
              localObject3 = z.jV(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
              p.g(localObject3, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
              localObject2 = ((d)localObject2).hr((View)localObject3);
              break label615;
            }
            localObject2 = this.LRW.get(i);
            p.g(localObject2, "footerInfoList[indexF]");
            localObject3 = b(paramViewGroup, paramInt, (b)localObject2);
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label615;
            }
            p.gkB();
            localObject2 = localObject3;
            break label615;
          }
          localObject2 = q(paramViewGroup, paramInt);
          continue;
          if (j == 0) {
            break label584;
          }
          j = i;
          break label56;
        }
      }
      for (;;)
      {
        if (k == 0) {
          break label603;
        }
        break label105;
        break label167;
        return localObject2;
        j = 0;
        break label553;
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
  
  public VH a(ViewGroup paramViewGroup, int paramInt, b paramb)
  {
    p.h(paramViewGroup, "parent");
    p.h(paramb, "info");
    return null;
  }
  
  public String a(Exception paramException, VH paramVH, List<Object> paramList)
  {
    p.h(paramException, "e");
    p.h(paramVH, "holder");
    p.h(paramList, "payloads");
    return "";
  }
  
  public final void a(RecyclerView.c paramc)
  {
    p.h(paramc, "observer");
    if (fUU())
    {
      this.LRU.add(paramc);
      return;
    }
    super.a(paramc);
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    p.h(paramVH, "holder");
    Object localObject;
    if (paramInt < this.LRV.size())
    {
      localObject = this.LRV.get(paramInt);
      p.g(localObject, "headerInfoList[position]");
      localObject = (b)localObject;
      if (!((b)localObject).fUX()) {
        a(paramVH, paramInt, (b)localObject);
      }
    }
    do
    {
      return;
      if (paramInt < fUW() + this.LRV.size()) {
        break;
      }
      int i = this.LRV.size();
      int j = fUW();
      localObject = this.LRW.get(paramInt - (i + j));
      p.g(localObject, "footerInfoList[footerIndex]");
      localObject = (b)localObject;
    } while (((b)localObject).fUX());
    b(paramVH, paramInt, (b)localObject);
    return;
    h(paramVH, paramInt - this.LRV.size());
  }
  
  public void a(VH paramVH, int paramInt, b paramb)
  {
    p.h(paramVH, "holder");
    p.h(paramb, "info");
  }
  
  public void a(VH paramVH, int paramInt, List<Object> paramList)
  {
    p.h(paramVH, "holder");
    p.h(paramList, "payloads");
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
        if (paramInt < this.LRV.size())
        {
          Object localObject1 = this.LRV.get(paramInt);
          p.g(localObject1, "headerInfoList[position]");
          a(paramVH, paramInt, (b)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        paramList = new StringBuilder().append(a(localException, paramVH, paramList)).append(" crashActivity=");
        paramVH = paramVH.auu;
        p.g(paramVH, "holder.itemView");
        paramVH = paramVH.getContext().getClass().getName();
        paramVH = new RuntimeException(localException.getMessage() + "\n" + paramVH);
        paramVH.setStackTrace(localException.getStackTrace());
        throw ((Throwable)paramVH);
      }
      if (paramInt >= fUW() + this.LRV.size())
      {
        i = this.LRV.size();
        int j = fUW();
        Object localObject2 = this.LRW.get(paramInt - (i + j));
        p.g(localObject2, "footerInfoList[footerIndex]");
        b(paramVH, paramInt, (b)localObject2);
        return;
      }
      b(paramVH, paramInt - this.LRV.size(), paramList);
      return;
      label273:
      int i = 0;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean)
  {
    p.h(paramb, "info");
    if (!this.LRV.contains(paramb))
    {
      this.LRV.add(paramb);
      if (paramBoolean) {
        ck(this.LRV.size() - 1);
      }
    }
    else
    {
      return;
    }
    ae.i("RecyclerViewAdapterEx", "[addHeader] notifyDataSetChanged");
    notifyDataSetChanged();
  }
  
  public final boolean a(b paramb)
  {
    p.h(paramb, "info");
    return this.LRV.contains(paramb);
  }
  
  public final b aV(View paramView, final int paramInt)
  {
    p.h(paramView, "resource");
    paramView = new e(paramView, paramInt);
    if (!this.LRW.contains(paramView))
    {
      this.LRW.add(paramView);
      ae.i("RecyclerViewAdapterEx", "[addFooterView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
    return (b)paramView;
  }
  
  public int agO(int paramInt)
  {
    return 0;
  }
  
  public long agP(int paramInt)
  {
    return 0L;
  }
  
  public final b agQ(int paramInt)
  {
    Object localObject = this.LRV.get(paramInt);
    p.g(localObject, "headerInfoList[headerPosition]");
    return (b)localObject;
  }
  
  public final b agR(int paramInt)
  {
    Object localObject = this.LRW.get(paramInt);
    p.g(localObject, "footerInfoList[footerPosition]");
    return (b)localObject;
  }
  
  public VH b(ViewGroup paramViewGroup, int paramInt, b paramb)
  {
    p.h(paramViewGroup, "parent");
    p.h(paramb, "info");
    return null;
  }
  
  public final void b(RecyclerView.c paramc)
  {
    p.h(paramc, "observer");
    if (fUU())
    {
      this.LRU.remove(paramc);
      return;
    }
    super.b(paramc);
  }
  
  public void b(VH paramVH, int paramInt, b paramb)
  {
    p.h(paramVH, "holder");
    p.h(paramb, "info");
  }
  
  public abstract void b(VH paramVH, int paramInt, List<Object> paramList);
  
  public final boolean b(b paramb)
  {
    p.h(paramb, "info");
    return this.LRW.contains(paramb);
  }
  
  public String c(Exception paramException, int paramInt)
  {
    p.h(paramException, "e");
    return "viewType=".concat(String.valueOf(paramInt));
  }
  
  public void c(final RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    this.gpr = paramRecyclerView;
    this.LRP = this.LRP;
    if (fUU())
    {
      Observable localObservable = this.LRS;
      if (localObservable != null) {
        localObservable.registerObserver(new h(this, paramRecyclerView));
      }
    }
  }
  
  public void d(RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    this.LRP = false;
  }
  
  public final b f(View paramView, final int paramInt, boolean paramBoolean)
  {
    p.h(paramView, "resource");
    paramView = new f(paramView, paramInt);
    if (!this.LRV.contains(paramView))
    {
      this.LRV.add(paramView);
      ae.i("Finder.FinderTopicFeedUIContract.TopicFeedViewCallback", "headerInfoList.add : " + paramView.lP());
      if (!paramBoolean) {
        break label85;
      }
      ck(this.LRV.size() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label85:
      ae.i("RecyclerViewAdapterEx", "[addHeaderView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
  }
  
  public abstract int fUW();
  
  public final int getItemCount()
  {
    return this.LRV.size() + fUW() + this.LRW.size();
  }
  
  public final long getItemId(int paramInt)
  {
    if ((getItemCount() <= paramInt) || (paramInt < 0))
    {
      String str = "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " headerCount=" + this.LRV.size() + " footerCount=" + this.LRW.size() + ' ' + bu.fpN();
      ae.e("RecyclerViewAdapterEx", str);
      com.tencent.mm.plugin.report.service.g.yxI.f(20251, new Object[] { Integer.valueOf(3), str });
      return 0L;
    }
    if (paramInt < this.LRV.size()) {
      return ((b)this.LRV.get(paramInt)).lP();
    }
    if (paramInt >= fUW() + this.LRV.size())
    {
      int i = this.LRV.size();
      int j = fUW();
      return ((b)this.LRW.get(paramInt - (i + j))).lP();
    }
    return agP(paramInt - this.LRV.size());
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt < this.LRV.size()) {
      return ((b)this.LRV.get(paramInt)).bZz();
    }
    if (paramInt >= fUW() + this.LRV.size())
    {
      int i = this.LRV.size();
      int j = fUW();
      return ((b)this.LRW.get(paramInt - (i + j))).bZz();
    }
    return agO(paramInt - this.LRV.size());
  }
  
  public final RecyclerView getRecyclerView()
  {
    RecyclerView localRecyclerView = this.gpr;
    if (localRecyclerView == null) {
      p.bdF("recyclerView");
    }
    return localRecyclerView;
  }
  
  public abstract void h(VH paramVH, int paramInt);
  
  public abstract VH hr(View paramView);
  
  public final void l(VH paramVH)
  {
    p.h(paramVH, "holder");
    super.l(paramVH);
    paramVH = paramVH.auu;
    p.g(paramVH, "holder.itemView");
    hs(paramVH);
  }
  
  public abstract VH q(ViewGroup paramViewGroup, int paramInt);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "getLayoutId", "", "getView", "Landroid/view/View;", "isStatic", "", "libmmui_release"})
  public static abstract class b
    implements a
  {
    public boolean fUX()
    {
      return false;
    }
    
    public View getView()
    {
      return null;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V", "libmmui_release"})
  public static abstract interface c<VH extends RecyclerView.w>
  {
    public abstract void a(RecyclerView.a<VH> parama, View paramView, int paramInt, VH paramVH);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)Z", "libmmui_release"})
  public static abstract interface d<VH extends RecyclerView.w>
  {
    public abstract boolean b(RecyclerView.a<VH> parama, View paramView, int paramInt, VH paramVH);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addFooterView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class e
    extends d.b
  {
    e(View paramView, int paramInt) {}
    
    public final int bZz()
    {
      return paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(164701);
      if (((paramObject instanceof d.b)) && (lP() == ((d.b)paramObject).lP()))
      {
        AppMethodBeat.o(164701);
        return true;
      }
      AppMethodBeat.o(164701);
      return false;
    }
    
    public final boolean fUX()
    {
      return true;
    }
    
    public final View getView()
    {
      return this.LSa;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(164700);
      long l = this.LSa.hashCode();
      AppMethodBeat.o(164700);
      return l;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addHeaderView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class f
    extends d.b
  {
    f(View paramView, int paramInt) {}
    
    public final int bZz()
    {
      return paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(164703);
      if (((paramObject instanceof d.b)) && (lP() == ((d.b)paramObject).lP()))
      {
        AppMethodBeat.o(164703);
        return true;
      }
      AppMethodBeat.o(164703);
      return false;
    }
    
    public final boolean fUX()
    {
      return true;
    }
    
    public final View getView()
    {
      return this.LSa;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(164702);
      long l = this.LSa.hashCode();
      AppMethodBeat.o(164702);
      return l;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<Boolean>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class h
    extends RecyclerView.c
  {
    private final Handler aCF;
    
    h(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(164718);
      this.aCF = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(164718);
    }
    
    public final void at(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(164713);
      if ((this.LSb.LRR) && (paramRecyclerView.kW()))
      {
        ae.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new d(this, paramInt1, paramInt2));
        AppMethodBeat.o(164713);
        return;
      }
      if (this.LSb.LRQ)
      {
        localObject = paramRecyclerView.getItemAnimator();
        if (localObject != null)
        {
          ae.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
          paramRecyclerView.setItemAnimator(null);
          this.aCF.removeCallbacksAndMessages(null);
          this.aCF.postDelayed((Runnable)new b((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).ls() + 60L);
        }
      }
      Object localObject = ((Iterable)d.a(this.LSb)).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RecyclerView.c)((Iterator)localObject).next()).at(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164713);
    }
    
    public final void au(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(164715);
      if ((this.LSb.LRR) && (paramRecyclerView.kW()))
      {
        ae.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new f(this, paramInt1, paramInt2));
        AppMethodBeat.o(164715);
        return;
      }
      Iterator localIterator = ((Iterable)d.a(this.LSb)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).au(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164715);
    }
    
    public final void av(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(164717);
      if ((this.LSb.LRR) && (paramRecyclerView.kW()))
      {
        ae.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new h(this, paramInt1, paramInt2));
        AppMethodBeat.o(164717);
        return;
      }
      Iterator localIterator = ((Iterable)d.a(this.LSb)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).av(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164717);
    }
    
    public final void f(final int paramInt1, final int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(164714);
      if ((this.LSb.LRR) && (paramRecyclerView.kW()))
      {
        ae.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new e(this, paramInt1, paramInt2, paramObject));
        AppMethodBeat.o(164714);
        return;
      }
      if (this.LSb.LRQ)
      {
        localObject = paramRecyclerView.getItemAnimator();
        paramRecyclerView.setItemAnimator(null);
        if (localObject != null)
        {
          ae.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
          if (((RecyclerView.f)localObject).ls() > 0L)
          {
            this.aCF.removeCallbacksAndMessages(null);
            this.aCF.postDelayed((Runnable)new c((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).ls() + 60L);
          }
        }
      }
      Object localObject = ((Iterable)d.a(this.LSb)).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RecyclerView.c)((Iterator)localObject).next()).f(paramInt1, paramInt2, paramObject);
      }
      AppMethodBeat.o(164714);
    }
    
    public final void l(final int paramInt1, final int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(164716);
      if ((this.LSb.LRR) && (paramRecyclerView.kW()))
      {
        ae.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new g(this, paramInt1, paramInt2));
        AppMethodBeat.o(164716);
        return;
      }
      Iterator localIterator = ((Iterable)d.a(this.LSb)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).l(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(164716);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(164712);
      if ((this.LSb.LRR) && (paramRecyclerView.kW()))
      {
        ae.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new a(this));
        AppMethodBeat.o(164712);
        return;
      }
      Iterator localIterator = ((Iterable)d.a(this.LSb)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).onChanged();
      }
      AppMethodBeat.o(164712);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class a
      implements Runnable
    {
      a(d.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(164704);
        this.LSc.LSb.notifyDataSetChanged();
        AppMethodBeat.o(164704);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$2$1"})
    static final class b
      implements Runnable
    {
      b(RecyclerView.f paramf1, d.h paramh, RecyclerView.f paramf2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164705);
        jdField_this.rWI.setItemAnimator(this.LSd);
        AppMethodBeat.o(164705);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$5$1"})
    static final class c
      implements Runnable
    {
      c(RecyclerView.f paramf1, d.h paramh, RecyclerView.f paramf2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164706);
        jdField_this.rWI.setItemAnimator(this.LSd);
        AppMethodBeat.o(164706);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class d
      implements Runnable
    {
      d(d.h paramh, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164707);
        this.LSc.LSb.b(paramInt1, Integer.valueOf(paramInt2));
        AppMethodBeat.o(164707);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class e
      implements Runnable
    {
      e(d.h paramh, int paramInt1, int paramInt2, Object paramObject) {}
      
      public final void run()
      {
        AppMethodBeat.i(164708);
        this.LSc.LSb.e(paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(164708);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class f
      implements Runnable
    {
      f(d.h paramh, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164709);
        this.LSc.LSb.ar(paramInt1, paramInt2);
        AppMethodBeat.o(164709);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class g
      implements Runnable
    {
      g(d.h paramh, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164710);
        this.LSc.LSb.aq(paramInt1, paramInt2);
        AppMethodBeat.o(164710);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class h
      implements Runnable
    {
      h(d.h paramh, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164711);
        this.LSc.LSb.as(paramInt1, paramInt2);
        AppMethodBeat.o(164711);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(d paramd, RecyclerView.w paramw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164719);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = this.LSb.getRecyclerView().bu(paramView);
      if (localObject != null) {}
      for (int i = ((RecyclerView.w)localObject).lN();; i = -1)
      {
        localObject = this.LSb.LRY;
        if (localObject != null)
        {
          RecyclerView.a locala = (RecyclerView.a)this.LSb;
          p.g(paramView, "it");
          ((d.c)localObject).a(locala, paramView, i, this.sgv);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164719);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class j
    implements View.OnLongClickListener
  {
    j(d paramd, RecyclerView.w paramw) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164720);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
      localObject = this.LSb.getRecyclerView().bu(paramView);
      int i;
      RecyclerView.a locala;
      if (localObject != null)
      {
        i = ((RecyclerView.w)localObject).lN();
        localObject = this.LSb.LRX;
        if (localObject == null) {
          break label131;
        }
        locala = (RecyclerView.a)this.LSb;
        p.g(paramView, "it");
      }
      label131:
      for (boolean bool = ((d.d)localObject).b(locala, paramView, i, this.sgv);; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164720);
        return bool;
        i = -1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */