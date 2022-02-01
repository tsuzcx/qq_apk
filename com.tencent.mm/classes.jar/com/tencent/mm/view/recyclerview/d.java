package com.tencent.mm.view.recyclerview;

import android.database.Observable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "footerInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lkotlin/collections/ArrayList;", "headerInfoList", "hookObservable", "Landroid/database/Observable;", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "isHookRecyclerViewAdapterObservableSuccessfully", "isHookRecyclerViewAdapterObservableSuccessfully$delegate", "Lkotlin/Lazy;", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "setSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "setSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "itemClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "getItemClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "setItemClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;)V", "itemLongClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "getItemLongClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "setItemLongClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;)V", "observable", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "recyclerViewOriginalObserver", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)V", "_onBindHeaderHolder", "_onBindViewHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "(Landroid/view/ViewGroup;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "_onCreateHeaderHolder", "_onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "addFooter", "isNotifyAnim", "addFooterView", "resource", "Landroid/view/View;", "addHeader", "addHeaderView", "containsFooter", "containsHeader", "findViewHolderByItemId", "itemId", "isLog", "(JZ)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getContentCount", "getFixCount", "getFixPosition", "getFooterCount", "getFooterData", "footerPosition", "getHeaderCount", "getHeaderData", "headerPosition", "getItemCount", "getItemId", "getItemViewType", "hookRecyclerViewAdapterObservable", "notifyItemChanged", "onAttachedToRecyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewDetachedFromWindow", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "protectViewItemRecycleHealthy", "view", "registerAdapterDataObserver", "observer", "removeFooter", "removeHeader", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "(Ljava/lang/Exception;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)Ljava/lang/String;", "throwCreateViewHolderException", "unregisterAdapterDataObserver", "wrapViewHolder", "(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Companion", "FixedViewInfo", "OnItemClickListener", "OnItemLongClickListener", "libmmui_release"})
public abstract class d<VH extends RecyclerView.w>
  extends RecyclerView.a<VH>
{
  public static final a Lvm = new a((byte)0);
  private boolean Lvc;
  boolean Lvd = true;
  boolean Lve = true;
  private Observable<RecyclerView.c> Lvf;
  private final f Lvg = d.g.O((d.g.a.a)new g(this));
  private final ConcurrentLinkedQueue<RecyclerView.c> Lvh = new ConcurrentLinkedQueue();
  public final ArrayList<b> Lvi = new ArrayList();
  private final ArrayList<b> Lvj = new ArrayList();
  public d<VH> Lvk;
  public c<VH> Lvl;
  public RecyclerView gmV;
  
  private final boolean fQy()
  {
    return ((Boolean)this.Lvg.getValue()).booleanValue();
  }
  
  private final boolean fQz()
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
      ad.printErrStackTrace("RecyclerViewAdapterEx", localThrowable, "", new Object[0]);
      return false;
    }
    this.Lvf = ((Observable)localObject);
    localThrowable.set(this, this.Lvf);
    ad.i("RecyclerViewAdapterEx", "[hookRecyclerViewAdapterObservable] Successfully.");
    Observable localObservable = this.Lvf;
    return localObservable != null;
  }
  
  private final void hn(View paramView)
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
          ad.i("RecyclerViewAdapterEx", "[protectViewItemRecycleHealthy] child=".concat(String.valueOf(localView)));
        }
        p.g(localView, "child");
        hn(localView);
        i += 1;
      }
      paramView.animate().cancel();
    }
  }
  
  public final void EI(long paramLong)
  {
    RecyclerView.w localw = N(paramLong, false);
    if (localw != null) {
      cj(localw.lN());
    }
  }
  
  public final void M(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.Lvi.iterator();
    p.g(localIterator, "headerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      p.g(localObject, "iterator.next()");
      if (((b)localObject).lP() != paramLong) {
        break label122;
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
    label122:
    for (;;)
    {
      j += 1;
      break;
      if ((i != 0) && (!paramBoolean))
      {
        ad.i("RecyclerViewAdapterEx", "[removeHeader] notifyDataSetChanged");
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public final VH N(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.gmV;
    if (localObject2 == null) {
      p.bcb("recyclerView");
    }
    int j = ((RecyclerView)localObject2).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject2 = this.gmV;
      if (localObject2 == null) {
        p.bcb("recyclerView");
      }
      RecyclerView localRecyclerView = this.gmV;
      if (localRecyclerView == null) {
        p.bcb("recyclerView");
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
      ad.w("RecyclerViewAdapterEx", "[findViewHolderByItemId] ".concat(String.valueOf(localObject1)));
    }
    localObject1 = null;
    label223:
    return localObject1;
  }
  
  public final VH a(final ViewGroup paramViewGroup, int paramInt)
  {
    p.h(paramViewGroup, "parent");
    int j;
    try
    {
      localObject = ((List)this.Lvi).iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label509;
      }
      if (((b)((Iterator)localObject).next()).bYk() != paramInt) {
        break label496;
      }
      j = 1;
    }
    catch (Exception paramViewGroup)
    {
      label56:
      localObject = c(paramViewGroup, paramInt);
      ad.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)paramViewGroup, (String)localObject, new Object[0]);
      throw ((Throwable)paramViewGroup);
    }
    Object localObject = ((List)this.Lvj).iterator();
    int i = 0;
    label72:
    int k;
    if (((Iterator)localObject).hasNext()) {
      if (((b)((Iterator)localObject).next()).bYk() == paramInt)
      {
        k = 1;
        break label483;
        label105:
        if (j >= 0)
        {
          localObject = this.Lvi.get(j);
          p.g(localObject, "headerInfoList[indexH]");
          localObject = (b)localObject;
          if (((b)localObject).fQB())
          {
            localObject = ((b)localObject).getView();
            if (localObject != null)
            {
              paramViewGroup = hm((View)localObject);
              break label491;
            }
          }
        }
      }
    }
    label521:
    label533:
    for (;;)
    {
      label166:
      localObject = paramViewGroup.auu;
      p.g(localObject, "holder.itemView");
      if (!((View)localObject).hasOnClickListeners())
      {
        ((View)localObject).setOnClickListener((View.OnClickListener)new i(this, paramViewGroup));
        ((View)localObject).setOnLongClickListener((View.OnLongClickListener)new j(this, paramViewGroup));
        return paramViewGroup;
        localObject = (d)this;
        paramViewGroup = z.jO(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
        p.g(paramViewGroup, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
        paramViewGroup = ((d)localObject).hm(paramViewGroup);
        break label491;
        localObject = a(paramViewGroup, paramInt, (b)localObject);
        paramViewGroup = (ViewGroup)localObject;
        if (localObject == null)
        {
          p.gfZ();
          paramViewGroup = (ViewGroup)localObject;
          break label491;
          if (i >= 0)
          {
            localObject = this.Lvj.get(i);
            p.g(localObject, "footerInfoList[indexF]");
            localObject = (b)localObject;
            if (((b)localObject).fQB())
            {
              localObject = ((b)localObject).getView();
              if (localObject != null)
              {
                paramViewGroup = hm((View)localObject);
                break label533;
              }
              localObject = (d)this;
              paramViewGroup = z.jO(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
              p.g(paramViewGroup, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
              paramViewGroup = ((d)localObject).hm(paramViewGroup);
              break label533;
            }
            localObject = this.Lvj.get(i);
            p.g(localObject, "footerInfoList[indexF]");
            localObject = b(paramViewGroup, paramInt, (b)localObject);
            paramViewGroup = (ViewGroup)localObject;
            if (localObject != null) {
              break label533;
            }
            p.gfZ();
            paramViewGroup = (ViewGroup)localObject;
            break label533;
          }
          paramViewGroup = q(paramViewGroup, paramInt);
          continue;
          label472:
          if (j == 0) {
            break label502;
          }
          j = i;
          break label56;
        }
      }
      for (;;)
      {
        label483:
        if (k == 0) {
          break label521;
        }
        break label105;
        label491:
        break label166;
        return paramViewGroup;
        label496:
        j = 0;
        break label472;
        label502:
        i += 1;
        break;
        label509:
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
    if (fQy())
    {
      this.Lvh.add(paramc);
      return;
    }
    super.a(paramc);
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    p.h(paramVH, "holder");
    Object localObject;
    if (paramInt < this.Lvi.size())
    {
      localObject = this.Lvi.get(paramInt);
      p.g(localObject, "headerInfoList[position]");
      localObject = (b)localObject;
      if (!((b)localObject).fQB()) {
        a(paramVH, paramInt, (b)localObject);
      }
    }
    do
    {
      return;
      if (paramInt < fQA() + this.Lvi.size()) {
        break;
      }
      int i = this.Lvi.size();
      int j = fQA();
      localObject = this.Lvj.get(paramInt - (i + j));
      p.g(localObject, "footerInfoList[footerIndex]");
      localObject = (b)localObject;
    } while (((b)localObject).fQB());
    b(paramVH, paramInt, (b)localObject);
    return;
    h(paramVH, paramInt - this.Lvi.size());
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
          break label199;
        }
        i = 1;
        if (i != 0)
        {
          super.a(paramVH, paramInt, paramList);
          return;
        }
        if (paramInt < this.Lvi.size())
        {
          Object localObject1 = this.Lvi.get(paramInt);
          p.g(localObject1, "headerInfoList[position]");
          a(paramVH, paramInt, (b)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        paramVH = a(localException, paramVH, paramList);
        ad.printErrStackTrace("RecyclerViewAdapterEx", (Throwable)localException, paramVH, new Object[0]);
        throw ((Throwable)localException);
      }
      if (paramInt >= fQA() + this.Lvi.size())
      {
        i = this.Lvi.size();
        int j = fQA();
        Object localObject2 = this.Lvj.get(paramInt - (i + j));
        p.g(localObject2, "footerInfoList[footerIndex]");
        b(paramVH, paramInt, (b)localObject2);
        return;
      }
      b(paramVH, paramInt - this.Lvi.size(), paramList);
      return;
      label199:
      int i = 0;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean)
  {
    p.h(paramb, "info");
    if (!this.Lvi.contains(paramb))
    {
      this.Lvi.add(paramb);
      if (paramBoolean) {
        ck(this.Lvi.size() - 1);
      }
    }
    else
    {
      return;
    }
    ad.i("RecyclerViewAdapterEx", "[addHeader] notifyDataSetChanged");
    notifyDataSetChanged();
  }
  
  public final boolean a(b paramb)
  {
    p.h(paramb, "info");
    return this.Lvi.contains(paramb);
  }
  
  public final b aV(View paramView, final int paramInt)
  {
    p.h(paramView, "resource");
    paramView = new e(paramView, paramInt);
    if (!this.Lvj.contains(paramView))
    {
      this.Lvj.add(paramView);
      ad.i("RecyclerViewAdapterEx", "[addFooterView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
    return (b)paramView;
  }
  
  public int agf(int paramInt)
  {
    return 0;
  }
  
  public long agg(int paramInt)
  {
    return 0L;
  }
  
  public final b agh(int paramInt)
  {
    Object localObject = this.Lvi.get(paramInt);
    p.g(localObject, "headerInfoList[headerPosition]");
    return (b)localObject;
  }
  
  public final b agi(int paramInt)
  {
    Object localObject = this.Lvj.get(paramInt);
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
    if (fQy())
    {
      this.Lvh.remove(paramc);
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
    return this.Lvj.contains(paramb);
  }
  
  public String c(Exception paramException, int paramInt)
  {
    p.h(paramException, "e");
    return "viewType=".concat(String.valueOf(paramInt));
  }
  
  public void c(RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    this.gmV = paramRecyclerView;
    this.Lvc = this.Lvc;
    if (fQy())
    {
      Observable localObservable = this.Lvf;
      if (localObservable != null) {
        localObservable.registerObserver(new d.h(this, paramRecyclerView));
      }
    }
  }
  
  public void d(RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    this.Lvc = false;
  }
  
  public final b f(View paramView, final int paramInt, boolean paramBoolean)
  {
    p.h(paramView, "resource");
    paramView = new f(paramView, paramInt);
    if (!this.Lvi.contains(paramView))
    {
      this.Lvi.add(paramView);
      ad.i("Finder.FinderTopicFeedUIContract.TopicFeedViewCallback", "headerInfoList.add : " + paramView.lP());
      if (!paramBoolean) {
        break label85;
      }
      ck(this.Lvi.size() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label85:
      ad.i("RecyclerViewAdapterEx", "[addHeaderView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
  }
  
  public abstract int fQA();
  
  public final int getItemCount()
  {
    return this.Lvi.size() + fQA() + this.Lvj.size();
  }
  
  public final long getItemId(int paramInt)
  {
    if ((getItemCount() <= paramInt) || (paramInt < 0))
    {
      String str = "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " headerCount=" + this.Lvi.size() + " footerCount=" + this.Lvj.size() + ' ' + bt.flS();
      ad.e("RecyclerViewAdapterEx", str);
      com.tencent.mm.plugin.report.service.g.yhR.f(20251, new Object[] { Integer.valueOf(3), str });
      return 0L;
    }
    if (paramInt < this.Lvi.size()) {
      return ((b)this.Lvi.get(paramInt)).lP();
    }
    if (paramInt >= fQA() + this.Lvi.size())
    {
      int i = this.Lvi.size();
      int j = fQA();
      return ((b)this.Lvj.get(paramInt - (i + j))).lP();
    }
    return agg(paramInt - this.Lvi.size());
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt < this.Lvi.size()) {
      return ((b)this.Lvi.get(paramInt)).bYk();
    }
    if (paramInt >= fQA() + this.Lvi.size())
    {
      int i = this.Lvi.size();
      int j = fQA();
      return ((b)this.Lvj.get(paramInt - (i + j))).bYk();
    }
    return agf(paramInt - this.Lvi.size());
  }
  
  public final RecyclerView getRecyclerView()
  {
    RecyclerView localRecyclerView = this.gmV;
    if (localRecyclerView == null) {
      p.bcb("recyclerView");
    }
    return localRecyclerView;
  }
  
  public abstract void h(VH paramVH, int paramInt);
  
  public abstract VH hm(View paramView);
  
  public final void l(VH paramVH)
  {
    p.h(paramVH, "holder");
    super.l(paramVH);
    paramVH = paramVH.auu;
    p.g(paramVH, "holder.itemView");
    hn(paramVH);
  }
  
  public abstract VH q(ViewGroup paramViewGroup, int paramInt);
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "getLayoutId", "", "getView", "Landroid/view/View;", "isStatic", "", "libmmui_release"})
  public static abstract class b
    implements a
  {
    public boolean fQB()
    {
      return false;
    }
    
    public View getView()
    {
      return null;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V", "libmmui_release"})
  public static abstract interface c<VH extends RecyclerView.w>
  {
    public abstract void a(RecyclerView.a<VH> parama, View paramView, int paramInt, VH paramVH);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)Z", "libmmui_release"})
  public static abstract interface d<VH extends RecyclerView.w>
  {
    public abstract boolean b(RecyclerView.a<VH> parama, View paramView, int paramInt, VH paramVH);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addFooterView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class e
    extends d.b
  {
    e(View paramView, int paramInt) {}
    
    public final int bYk()
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
    
    public final boolean fQB()
    {
      return true;
    }
    
    public final View getView()
    {
      return this.Lvn;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(164700);
      long l = this.Lvn.hashCode();
      AppMethodBeat.o(164700);
      return l;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addHeaderView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class f
    extends d.b
  {
    f(View paramView, int paramInt) {}
    
    public final int bYk()
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
    
    public final boolean fQB()
    {
      return true;
    }
    
    public final View getView()
    {
      return this.Lvn;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(164702);
      long l = this.Lvn.hashCode();
      AppMethodBeat.o(164702);
      return l;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<Boolean>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(d paramd, RecyclerView.w paramw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164719);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      localObject = this.Lvo.getRecyclerView().bu(paramView);
      if (localObject != null) {}
      for (int i = ((RecyclerView.w)localObject).lN();; i = -1)
      {
        localObject = this.Lvo.Lvl;
        if (localObject != null)
        {
          RecyclerView.a locala = (RecyclerView.a)this.Lvo;
          p.g(paramView, "it");
          ((d.c)localObject).a(locala, paramView, i, paramViewGroup);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164719);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class j
    implements View.OnLongClickListener
  {
    j(d paramd, RecyclerView.w paramw) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164720);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
      localObject = this.Lvo.getRecyclerView().bu(paramView);
      int i;
      RecyclerView.a locala;
      if (localObject != null)
      {
        i = ((RecyclerView.w)localObject).lN();
        localObject = this.Lvo.Lvk;
        if (localObject == null) {
          break label131;
        }
        locala = (RecyclerView.a)this.Lvo;
        p.g(paramView, "it");
      }
      label131:
      for (boolean bool = ((d.d)localObject).b(locala, paramView, i, paramViewGroup);; bool = false)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */