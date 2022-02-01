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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.z;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "footerInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lkotlin/collections/ArrayList;", "headerInfoList", "hookObservable", "Landroid/database/Observable;", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "isHookRecyclerViewAdapterObservableSuccessfully", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "setSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "setSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "itemClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "getItemClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "setItemClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;)V", "itemLongClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "getItemLongClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "setItemLongClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;)V", "observable", "Ljava/util/LinkedList;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "recyclerViewOriginalObserver", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)V", "_onBindHeaderHolder", "_onBindViewHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "(Landroid/view/ViewGroup;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "_onCreateHeaderHolder", "_onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "addFooter", "isNotifyAnim", "addFooterView", "resource", "Landroid/view/View;", "addHeader", "addHeaderView", "containsFooter", "containsHeader", "findViewHolderByItemId", "itemId", "isLog", "(JZ)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getContentCount", "getFixCount", "getFixPosition", "getFooterCount", "getFooterData", "footerPosition", "getHeaderCount", "getHeaderData", "headerPosition", "getItemCount", "getItemId", "getItemViewType", "hookRecyclerViewAdapterObservable", "notifyItemChanged", "onAttachedToRecyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewDetachedFromWindow", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "protectViewItemRecycleHealthy", "view", "registerAdapterDataObserver", "observer", "removeFooter", "removeHeader", "unregisterAdapterDataObserver", "wrapViewHolder", "(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Companion", "FixedViewInfo", "OnItemClickListener", "OnItemLongClickListener", "libmmui_release"})
public abstract class d<VH extends RecyclerView.w>
  extends RecyclerView.a<VH>
{
  public static final d.a JCf = new d.a((byte)0);
  private boolean JBV;
  boolean JBW = true;
  boolean JBX = true;
  private Observable<RecyclerView.c> JBY;
  private final boolean JBZ = fzp();
  private final LinkedList<RecyclerView.c> JCa = new LinkedList();
  public final ArrayList<b> JCb = new ArrayList();
  private final ArrayList<b> JCc = new ArrayList();
  public d JCd;
  public c JCe;
  public RecyclerView fTr;
  
  private final boolean fzp()
  {
    Object localObject;
    try
    {
      Field localField = RecyclerView.a.class.getDeclaredField("arg");
      k.g(localField, "field");
      localField.setAccessible(true);
      localObject = localField.get(this).getClass().getDeclaredConstructor(new Class[0]);
      k.g(localObject, "constructor");
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      if (localObject == null) {
        throw new v("null cannot be cast to non-null type android.database.Observable<android.support.v7.widget.RecyclerView.AdapterDataObserver>");
      }
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("RecyclerViewAdapterEx", localThrowable, "", new Object[0]);
      return false;
    }
    this.JBY = ((Observable)localObject);
    localThrowable.set(this, this.JBY);
    ac.i("RecyclerViewAdapterEx", "[hookRecyclerViewAdapterObservable] Successfully.");
    Observable localObservable = this.JBY;
    return localObservable != null;
  }
  
  private final void gW(View paramView)
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
          ac.i("RecyclerViewAdapterEx", "[protectViewItemRecycleHealthy] child=".concat(String.valueOf(localView)));
        }
        k.g(localView, "child");
        gW(localView);
        i += 1;
      }
      paramView.animate().cancel();
    }
  }
  
  public final void BN(long paramLong)
  {
    RecyclerView.w localw = N(paramLong, false);
    if (localw != null) {
      cj(localw.lv());
    }
  }
  
  public final void L(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.JCb.iterator();
    k.g(localIterator, "headerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      k.g(localObject, "iterator.next()");
      if (((b)localObject).lx() != paramLong) {
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
        ac.i("RecyclerViewAdapterEx", "[removeHeader] notifyDataSetChanged");
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public final void M(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.JCc.iterator();
    k.g(localIterator, "footerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      k.g(localObject, "iterator.next()");
      if (((b)localObject).lx() != paramLong) {
        break label136;
      }
      localIterator.remove();
      int k = 1;
      i = k;
      if (paramBoolean)
      {
        cl(this.JCb.size() + fzq() + j);
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
        ac.i("RecyclerViewAdapterEx", "[removeFooter] notifyDataSetChanged");
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public final VH N(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.fTr;
    if (localObject2 == null) {
      k.aVY("recyclerView");
    }
    int j = ((RecyclerView)localObject2).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject2 = this.fTr;
      if (localObject2 == null) {
        k.aVY("recyclerView");
      }
      RecyclerView localRecyclerView = this.fTr;
      if (localRecyclerView == null) {
        k.aVY("recyclerView");
      }
      localObject2 = ((RecyclerView)localObject2).bu(localRecyclerView.getChildAt(i));
      if ((localObject2 != null) && (((RecyclerView.w)localObject2).lv() != -1))
      {
        long l = getItemId(((RecyclerView.w)localObject2).lv());
        if (paramBoolean) {
          ((StringBuilder)localObject1).append("adapterPosition=" + ((RecyclerView.w)localObject2).lv() + " itemId=" + l + '\n');
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
      ac.w("RecyclerViewAdapterEx", "[findViewHolderByItemId] ".concat(String.valueOf(localObject1)));
    }
    localObject1 = null;
    label223:
    return localObject1;
  }
  
  public final VH a(ViewGroup paramViewGroup, int paramInt)
  {
    k.h(paramViewGroup, "parent");
    Object localObject = ((List)this.JCb).iterator();
    int i = 0;
    int j;
    label53:
    label61:
    label77:
    int k;
    if (((Iterator)localObject).hasNext()) {
      if (((b)((Iterator)localObject).next()).bTF() == paramInt)
      {
        j = 1;
        if (j == 0) {
          break label232;
        }
        j = i;
        localObject = ((List)this.JCc).iterator();
        i = 0;
        if (!((Iterator)localObject).hasNext()) {
          break label258;
        }
        if (((b)((Iterator)localObject).next()).bTF() != paramInt) {
          break label245;
        }
        k = 1;
        label107:
        if (k == 0) {
          break label251;
        }
        label112:
        if (j < 0) {
          break label327;
        }
        localObject = this.JCb.get(j);
        k.g(localObject, "headerInfoList[indexH]");
        localObject = (b)localObject;
        if (!((b)localObject).fzr()) {
          break label300;
        }
        localObject = ((b)localObject).getView();
        if (localObject == null) {
          break label263;
        }
        paramViewGroup = gV((View)localObject);
      }
    }
    for (;;)
    {
      localObject = paramViewGroup.asD;
      k.g(localObject, "holder.itemView");
      if (!((View)localObject).hasOnClickListeners())
      {
        ((View)localObject).setOnClickListener((View.OnClickListener)new h(this));
        ((View)localObject).setOnLongClickListener((View.OnLongClickListener)new i(this));
      }
      return paramViewGroup;
      j = 0;
      break label53;
      label232:
      i += 1;
      break;
      j = -1;
      break label61;
      label245:
      k = 0;
      break label107;
      label251:
      i += 1;
      break label77;
      label258:
      i = -1;
      break label112;
      label263:
      localObject = (d)this;
      paramViewGroup = z.jD(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
      k.g(paramViewGroup, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
      paramViewGroup = ((d)localObject).gV(paramViewGroup);
      continue;
      label300:
      localObject = a(paramViewGroup, paramInt, (b)localObject);
      paramViewGroup = (ViewGroup)localObject;
      if (localObject == null)
      {
        k.fOy();
        paramViewGroup = (ViewGroup)localObject;
        continue;
        label327:
        if (i >= 0)
        {
          localObject = this.JCc.get(i);
          k.g(localObject, "footerInfoList[indexF]");
          localObject = (b)localObject;
          if (((b)localObject).fzr())
          {
            localObject = ((b)localObject).getView();
            if (localObject != null) {
              paramViewGroup = gV((View)localObject);
            }
          }
          for (;;)
          {
            break;
            localObject = (d)this;
            paramViewGroup = z.jD(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
            k.g(paramViewGroup, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
            paramViewGroup = ((d)localObject).gV(paramViewGroup);
            continue;
            localObject = this.JCc.get(i);
            k.g(localObject, "footerInfoList[indexF]");
            localObject = b(paramViewGroup, paramInt, (b)localObject);
            paramViewGroup = (ViewGroup)localObject;
            if (localObject == null)
            {
              k.fOy();
              paramViewGroup = (ViewGroup)localObject;
            }
          }
        }
        paramViewGroup = o(paramViewGroup, paramInt);
      }
    }
  }
  
  public VH a(ViewGroup paramViewGroup, int paramInt, b paramb)
  {
    k.h(paramViewGroup, "parent");
    k.h(paramb, "info");
    return null;
  }
  
  public final void a(RecyclerView.c paramc)
  {
    k.h(paramc, "observer");
    if (this.JBZ)
    {
      this.JCa.add(paramc);
      return;
    }
    super.a(paramc);
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    k.h(paramVH, "holder");
    Object localObject;
    if (paramInt < this.JCb.size())
    {
      localObject = this.JCb.get(paramInt);
      k.g(localObject, "headerInfoList[position]");
      localObject = (b)localObject;
      if (!((b)localObject).fzr()) {
        a(paramVH, paramInt, (b)localObject);
      }
    }
    do
    {
      return;
      if (paramInt < fzq() + this.JCb.size()) {
        break;
      }
      int i = this.JCb.size();
      int j = fzq();
      localObject = this.JCc.get(paramInt - (i + j));
      k.g(localObject, "footerInfoList[footerIndex]");
      localObject = (b)localObject;
    } while (((b)localObject).fzr());
    b(paramVH, paramInt, (b)localObject);
    return;
    h(paramVH, paramInt - this.JCb.size());
  }
  
  public void a(VH paramVH, int paramInt, b paramb)
  {
    k.h(paramVH, "holder");
    k.h(paramb, "info");
  }
  
  public final void a(VH paramVH, int paramInt, List<Object> paramList)
  {
    k.h(paramVH, "holder");
    k.h(paramList, "payloads");
    if (((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.a(paramVH, paramInt, paramList);
      return;
    }
    if (paramInt < this.JCb.size())
    {
      paramList = this.JCb.get(paramInt);
      k.g(paramList, "headerInfoList[position]");
      a(paramVH, paramInt, (b)paramList);
      return;
    }
    if (paramInt >= fzq() + this.JCb.size())
    {
      i = this.JCb.size();
      int j = fzq();
      paramList = this.JCc.get(paramInt - (i + j));
      k.g(paramList, "footerInfoList[footerIndex]");
      b(paramVH, paramInt, (b)paramList);
      return;
    }
    b(paramVH, paramInt - this.JCb.size(), paramList);
  }
  
  public final void a(b paramb, boolean paramBoolean)
  {
    k.h(paramb, "info");
    if (!this.JCb.contains(paramb))
    {
      this.JCb.add(paramb);
      if (paramBoolean) {
        ck(this.JCb.size() - 1);
      }
    }
    else
    {
      return;
    }
    ac.i("RecyclerViewAdapterEx", "[addHeader] notifyDataSetChanged");
    notifyDataSetChanged();
  }
  
  public final boolean a(b paramb)
  {
    k.h(paramb, "info");
    return this.JCb.contains(paramb);
  }
  
  public int adF(int paramInt)
  {
    return 0;
  }
  
  public long adG(int paramInt)
  {
    return 0L;
  }
  
  public final b adH(int paramInt)
  {
    Object localObject = this.JCb.get(paramInt);
    k.g(localObject, "headerInfoList[headerPosition]");
    return (b)localObject;
  }
  
  public final b adI(int paramInt)
  {
    Object localObject = this.JCc.get(paramInt);
    k.g(localObject, "footerInfoList[footerPosition]");
    return (b)localObject;
  }
  
  public VH b(ViewGroup paramViewGroup, int paramInt, b paramb)
  {
    k.h(paramViewGroup, "parent");
    k.h(paramb, "info");
    return null;
  }
  
  public final void b(RecyclerView.c paramc)
  {
    k.h(paramc, "observer");
    if (this.JBZ)
    {
      this.JCa.remove(paramc);
      return;
    }
    super.b(paramc);
  }
  
  public void b(VH paramVH, int paramInt, b paramb)
  {
    k.h(paramVH, "holder");
    k.h(paramb, "info");
  }
  
  public abstract void b(VH paramVH, int paramInt, List<Object> paramList);
  
  public final boolean b(b paramb)
  {
    k.h(paramb, "info");
    return this.JCc.contains(paramb);
  }
  
  public void c(final RecyclerView paramRecyclerView)
  {
    k.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    this.fTr = paramRecyclerView;
    this.JBV = this.JBV;
    if (this.JBZ)
    {
      Observable localObservable = this.JBY;
      if (localObservable != null) {
        localObservable.registerObserver(new g(this, paramRecyclerView));
      }
    }
  }
  
  public void d(RecyclerView paramRecyclerView)
  {
    k.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    this.JBV = false;
  }
  
  public final b f(View paramView, final int paramInt, boolean paramBoolean)
  {
    k.h(paramView, "resource");
    paramView = new f(paramView, paramInt);
    if (!this.JCb.contains(paramView))
    {
      this.JCb.add(paramView);
      ac.i("Finder.FinderTopicFeedUIContract.TopicFeedViewCallback", "headerInfoList.add : " + paramView.lx());
      if (!paramBoolean) {
        break label85;
      }
      ck(this.JCb.size() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label85:
      ac.i("RecyclerViewAdapterEx", "[addHeaderView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
  }
  
  public abstract int fzq();
  
  public final b g(View paramView, final int paramInt, boolean paramBoolean)
  {
    k.h(paramView, "resource");
    paramView = new e(paramView, paramInt);
    if (!this.JCc.contains(paramView))
    {
      this.JCc.add(paramView);
      if (!paramBoolean) {
        break label56;
      }
      ck(getItemCount() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label56:
      ac.i("RecyclerViewAdapterEx", "[addFooterView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
  }
  
  public abstract VH gV(View paramView);
  
  public final int getItemCount()
  {
    return this.JCb.size() + fzq() + this.JCc.size();
  }
  
  public final long getItemId(int paramInt)
  {
    if ((getItemCount() <= paramInt) || (paramInt < 0))
    {
      String str = "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " headerCount=" + this.JCb.size() + " footerCount=" + this.JCc.size() + ' ' + bs.eWi();
      ac.e("RecyclerViewAdapterEx", str);
      h.wUl.f(20251, new Object[] { Integer.valueOf(3), str });
      return 0L;
    }
    if (paramInt < this.JCb.size()) {
      return ((b)this.JCb.get(paramInt)).lx();
    }
    if (paramInt >= fzq() + this.JCb.size())
    {
      int i = this.JCb.size();
      int j = fzq();
      return ((b)this.JCc.get(paramInt - (i + j))).lx();
    }
    return adG(paramInt - this.JCb.size());
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt < this.JCb.size()) {
      return ((b)this.JCb.get(paramInt)).bTF();
    }
    if (paramInt >= fzq() + this.JCb.size())
    {
      int i = this.JCb.size();
      int j = fzq();
      return ((b)this.JCc.get(paramInt - (i + j))).bTF();
    }
    return adF(paramInt - this.JCb.size());
  }
  
  public final RecyclerView getRecyclerView()
  {
    RecyclerView localRecyclerView = this.fTr;
    if (localRecyclerView == null) {
      k.aVY("recyclerView");
    }
    return localRecyclerView;
  }
  
  public abstract void h(VH paramVH, int paramInt);
  
  public final void l(VH paramVH)
  {
    k.h(paramVH, "holder");
    super.l(paramVH);
    paramVH = paramVH.asD;
    k.g(paramVH, "holder.itemView");
    gW(paramVH);
  }
  
  public abstract VH o(ViewGroup paramViewGroup, int paramInt);
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "getLayoutId", "", "getView", "Landroid/view/View;", "isStatic", "", "libmmui_release"})
  public static abstract class b
    implements a
  {
    public boolean fzr()
    {
      return false;
    }
    
    public View getView()
    {
      return null;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void b(RecyclerView.a<?> parama, View paramView, int paramInt);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "libmmui_release"})
  public static abstract interface d
  {
    public abstract boolean c(RecyclerView.a<?> parama, View paramView, int paramInt);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addFooterView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class e
    extends d.b
  {
    e(View paramView, int paramInt) {}
    
    public final int bTF()
    {
      return paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(164701);
      if (((paramObject instanceof d.b)) && (lx() == ((d.b)paramObject).lx()))
      {
        AppMethodBeat.o(164701);
        return true;
      }
      AppMethodBeat.o(164701);
      return false;
    }
    
    public final boolean fzr()
    {
      return true;
    }
    
    public final View getView()
    {
      return this.JCg;
    }
    
    public final long lx()
    {
      AppMethodBeat.i(164700);
      long l = this.JCg.hashCode();
      AppMethodBeat.o(164700);
      return l;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addHeaderView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class f
    extends d.b
  {
    f(View paramView, int paramInt) {}
    
    public final int bTF()
    {
      return paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(164703);
      if (((paramObject instanceof d.b)) && (lx() == ((d.b)paramObject).lx()))
      {
        AppMethodBeat.o(164703);
        return true;
      }
      AppMethodBeat.o(164703);
      return false;
    }
    
    public final boolean fzr()
    {
      return true;
    }
    
    public final View getView()
    {
      return this.JCg;
    }
    
    public final long lx()
    {
      AppMethodBeat.i(164702);
      long l = this.JCg.hashCode();
      AppMethodBeat.o(164702);
      return l;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class g
    extends RecyclerView.c
  {
    private final Handler aAO;
    
    g(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(164718);
      this.aAO = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(164718);
    }
    
    public final void as(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(164713);
      if ((this.JCh.JBX) && (paramRecyclerView.kG()))
      {
        ac.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new d(this, paramInt1, paramInt2));
        AppMethodBeat.o(164713);
        return;
      }
      if (this.JCh.JBW)
      {
        localObject = paramRecyclerView.getItemAnimator();
        if (localObject != null)
        {
          ac.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
          paramRecyclerView.setItemAnimator(null);
          this.aAO.removeCallbacksAndMessages(null);
          this.aAO.postDelayed((Runnable)new b((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).la() + 60L);
        }
      }
      Object localObject = ((Iterable)d.a(this.JCh)).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RecyclerView.c)((Iterator)localObject).next()).as(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164713);
    }
    
    public final void at(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(164715);
      if ((this.JCh.JBX) && (paramRecyclerView.kG()))
      {
        ac.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new f(this, paramInt1, paramInt2));
        AppMethodBeat.o(164715);
        return;
      }
      Iterator localIterator = ((Iterable)d.a(this.JCh)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).at(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164715);
    }
    
    public final void au(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(164717);
      if ((this.JCh.JBX) && (paramRecyclerView.kG()))
      {
        ac.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new h(this, paramInt1, paramInt2));
        AppMethodBeat.o(164717);
        return;
      }
      Iterator localIterator = ((Iterable)d.a(this.JCh)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).au(paramInt1, paramInt2);
      }
      AppMethodBeat.o(164717);
    }
    
    public final void f(final int paramInt1, final int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(164714);
      if ((this.JCh.JBX) && (paramRecyclerView.kG()))
      {
        ac.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new e(this, paramInt1, paramInt2, paramObject));
        AppMethodBeat.o(164714);
        return;
      }
      if (this.JCh.JBW)
      {
        localObject = paramRecyclerView.getItemAnimator();
        paramRecyclerView.setItemAnimator(null);
        if (localObject != null)
        {
          ac.w("RecyclerViewAdapterEx", "originItemAnimator=".concat(String.valueOf(localObject)));
          if (((RecyclerView.f)localObject).la() > 0L)
          {
            this.aAO.removeCallbacksAndMessages(null);
            this.aAO.postDelayed((Runnable)new c((RecyclerView.f)localObject, this, (RecyclerView.f)localObject), ((RecyclerView.f)localObject).la() + 60L);
          }
        }
      }
      Object localObject = ((Iterable)d.a(this.JCh)).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RecyclerView.c)((Iterator)localObject).next()).f(paramInt1, paramInt2, paramObject);
      }
      AppMethodBeat.o(164714);
    }
    
    public final void l(final int paramInt1, final int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(164716);
      if ((this.JCh.JBX) && (paramRecyclerView.kG()))
      {
        ac.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new g(this, paramInt1, paramInt2));
        AppMethodBeat.o(164716);
        return;
      }
      Iterator localIterator = ((Iterable)d.a(this.JCh)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).l(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(164716);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(164712);
      if ((this.JCh.JBX) && (paramRecyclerView.kG()))
      {
        ac.w("RecyclerViewAdapterEx", "Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramRecyclerView.post((Runnable)new a(this));
        AppMethodBeat.o(164712);
        return;
      }
      Iterator localIterator = ((Iterable)d.a(this.JCh)).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.c)localIterator.next()).onChanged();
      }
      AppMethodBeat.o(164712);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class a
      implements Runnable
    {
      a(d.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(164704);
        this.JCi.JCh.notifyDataSetChanged();
        AppMethodBeat.o(164704);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$2$1"})
    static final class b
      implements Runnable
    {
      b(RecyclerView.f paramf1, d.g paramg, RecyclerView.f paramf2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164705);
        jdField_this.rbu.setItemAnimator(this.JCj);
        AppMethodBeat.o(164705);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run", "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onAttachedToRecyclerView$1$onItemRangeChanged$5$1"})
    static final class c
      implements Runnable
    {
      c(RecyclerView.f paramf1, d.g paramg, RecyclerView.f paramf2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164706);
        jdField_this.rbu.setItemAnimator(this.JCj);
        AppMethodBeat.o(164706);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class d
      implements Runnable
    {
      d(d.g paramg, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164707);
        this.JCi.JCh.b(paramInt1, Integer.valueOf(paramInt2));
        AppMethodBeat.o(164707);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class e
      implements Runnable
    {
      e(d.g paramg, int paramInt1, int paramInt2, Object paramObject) {}
      
      public final void run()
      {
        AppMethodBeat.i(164708);
        this.JCi.JCh.e(paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(164708);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class f
      implements Runnable
    {
      f(d.g paramg, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164709);
        this.JCi.JCh.aq(paramInt1, paramInt2);
        AppMethodBeat.o(164709);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class g
      implements Runnable
    {
      g(d.g paramg, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164710);
        this.JCi.JCh.ap(paramInt1, paramInt2);
        AppMethodBeat.o(164710);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "run"})
    static final class h
      implements Runnable
    {
      h(d.g paramg, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(164711);
        this.JCi.JCh.ar(paramInt1, paramInt2);
        AppMethodBeat.o(164711);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164719);
      Object localObject = this.JCh.getRecyclerView().bu(paramView);
      if (localObject != null) {}
      for (int i = ((RecyclerView.w)localObject).lv();; i = -1)
      {
        localObject = this.JCh.JCe;
        if (localObject == null) {
          break;
        }
        RecyclerView.a locala = (RecyclerView.a)this.JCh;
        k.g(paramView, "it");
        ((d.c)localObject).b(locala, paramView, i);
        AppMethodBeat.o(164719);
        return;
      }
      AppMethodBeat.o(164719);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class i
    implements View.OnLongClickListener
  {
    i(d paramd) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164720);
      Object localObject = this.JCh.getRecyclerView().bu(paramView);
      if (localObject != null) {}
      for (int i = ((RecyclerView.w)localObject).lv();; i = -1)
      {
        localObject = this.JCh.JCd;
        if (localObject == null) {
          break;
        }
        RecyclerView.a locala = (RecyclerView.a)this.JCh;
        k.g(paramView, "it");
        boolean bool = ((d.d)localObject).c(locala, paramView, i);
        AppMethodBeat.o(164720);
        return bool;
      }
      AppMethodBeat.o(164720);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */