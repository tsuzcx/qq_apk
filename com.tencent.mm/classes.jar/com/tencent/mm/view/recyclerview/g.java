package com.tencent.mm.view.recyclerview;

import android.database.Observable;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "footerInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lkotlin/collections/ArrayList;", "headerInfoList", "hookObservable", "Landroid/database/Observable;", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "isHookRecyclerViewAdapterObservableSuccessfully", "isHookRecyclerViewAdapterObservableSuccessfully$delegate", "Lkotlin/Lazy;", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "setSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "setSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "itemClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "getItemClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "setItemClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;)V", "itemLongClickListener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "getItemLongClickListener", "()Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "setItemLongClickListener", "(Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;)V", "observable", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "recyclerViewOriginalObserver", "_getItemCount", "", "_getItemId", "", "position", "_getItemViewType", "_onBindFooterHolder", "", "holder", "info", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)V", "_onBindHeaderHolder", "_onBindViewHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "_onCreateFooterHolder", "parent", "Landroid/view/ViewGroup;", "type", "(Landroid/view/ViewGroup;ILcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "_onCreateHeaderHolder", "_onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "addFooter", "isNotifyAnim", "addFooterView", "resource", "Landroid/view/View;", "addHeader", "addHeaderView", "containsFooter", "containsHeader", "findViewHolderByItemId", "itemId", "isLog", "(JZ)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getContentCount", "getFixCount", "getFixPosition", "getFooterCount", "getFooterData", "footerPosition", "getHeaderCount", "getHeaderData", "headerPosition", "getItemCount", "getItemId", "getItemViewType", "hookRecyclerViewAdapterObservable", "notifyItemChanged", "onAttachedToRecyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewDetachedFromWindow", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "protectViewItemRecycleHealthy", "view", "registerAdapterDataObserver", "observer", "removeFooter", "removeHeader", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "(Ljava/lang/Exception;Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)Ljava/lang/String;", "throwCreateViewHolderException", "unregisterAdapterDataObserver", "wrapViewHolder", "(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Companion", "FixedViewInfo", "OnItemClickListener", "OnItemLongClickListener", "libmmui_release"})
public abstract class g<VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  public static final a RqQ = new a((byte)0);
  private boolean RqG;
  boolean RqH = true;
  boolean RqI = true;
  private Observable<RecyclerView.c> RqJ;
  private final f RqK = kotlin.g.ah((kotlin.g.a.a)new g(this));
  private final ConcurrentLinkedQueue<RecyclerView.c> RqL = new ConcurrentLinkedQueue();
  public final ArrayList<b> RqM = new ArrayList();
  public final ArrayList<b> RqN = new ArrayList();
  public d<VH> RqO;
  public c<VH> RqP;
  public RecyclerView hak;
  
  private final void dW(View paramView)
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
          dW(localView);
        }
        i += 1;
      }
      paramView.animate().cancel();
    }
  }
  
  private final boolean hgr()
  {
    return ((Boolean)this.RqK.getValue()).booleanValue();
  }
  
  private final boolean hgs()
  {
    Object localObject;
    try
    {
      Field localField = RecyclerView.a.class.getDeclaredField("atj");
      p.g(localField, "RecyclerView.Adapter::cl…laredField(\"mObservable\")");
      localField.setAccessible(true);
      localObject = localField.get(this).getClass().getDeclaredConstructor(new Class[0]);
      p.g(localObject, "origin.javaClass.getDeclaredConstructor()");
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      p.g(localObject, "constructor.newInstance()");
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type android.database.Observable<android.support.v7.widget.RecyclerView.AdapterDataObserver>");
      }
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("RecyclerViewAdapterEx", localThrowable, "", new Object[0]);
      return false;
    }
    this.RqJ = ((Observable)localObject);
    localThrowable.set(this, this.RqJ);
    Log.i("RecyclerViewAdapterEx", "[hookRecyclerViewAdapterObservable] Successfully.");
    Observable localObservable = this.RqJ;
    return localObservable != null;
  }
  
  public final void Or(long paramLong)
  {
    RecyclerView.v localv = V(paramLong, false);
    if (localv != null) {
      ci(localv.lR());
    }
  }
  
  public final void T(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.RqM.iterator();
    p.g(localIterator, "headerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      p.g(localObject, "iterator.next()");
      if (((b)localObject).lT() != paramLong) {
        break label123;
      }
      localIterator.remove();
      int k = 1;
      i = k;
      if (paramBoolean)
      {
        ck(j);
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
    Iterator localIterator = this.RqN.iterator();
    p.g(localIterator, "footerInfoList.iterator()");
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      p.g(localObject, "iterator.next()");
      if (((b)localObject).lT() != paramLong) {
        break label136;
      }
      localIterator.remove();
      int k = 1;
      i = k;
      if (paramBoolean)
      {
        ck(this.RqM.size() + hgt() + j);
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
  
  public final VH V(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.hak;
    if (localObject2 == null) {
      p.btv("recyclerView");
    }
    int j = ((RecyclerView)localObject2).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject2 = this.hak;
      if (localObject2 == null) {
        p.btv("recyclerView");
      }
      RecyclerView localRecyclerView = this.hak;
      if (localRecyclerView == null) {
        p.btv("recyclerView");
      }
      localObject2 = ((RecyclerView)localObject2).bu(localRecyclerView.getChildAt(i));
      if ((localObject2 != null) && (((RecyclerView.v)localObject2).lR() != -1))
      {
        long l = getItemId(((RecyclerView.v)localObject2).lR());
        if (paramBoolean) {
          ((StringBuilder)localObject1).append("adapterPosition=" + ((RecyclerView.v)localObject2).lR() + " itemId=" + l + '\n');
        }
        if (paramLong == l)
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label223;
          }
          throw new t("null cannot be cast to non-null type VH");
        }
      }
      i += 1;
    }
    if (paramBoolean) {
      Log.w("RecyclerViewAdapterEx", "[findViewHolderByItemId] ".concat(String.valueOf(localObject1)));
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
      localObject1 = ((List)this.RqM).iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label591;
      }
      if (((b)((Iterator)localObject1).next()).cxn() != paramInt) {
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
    localObject1 = ((List)this.RqN).iterator();
    int i = 0;
    label72:
    int k;
    if (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).cxn() == paramInt)
      {
        k = 1;
        break label564;
        label105:
        if (j >= 0)
        {
          localObject1 = this.RqM.get(j);
          p.g(localObject1, "headerInfoList[indexH]");
          localObject1 = (b)localObject1;
          if (((b)localObject1).hgu())
          {
            localObject1 = ((b)localObject1).getView();
            if (localObject1 != null)
            {
              localObject1 = hJ((View)localObject1);
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
      Object localObject3 = ((RecyclerView.v)localObject1).aus;
      p.g(localObject3, "holder.itemView");
      Object localObject2;
      if (!((View)localObject3).hasOnClickListeners())
      {
        ((View)localObject3).setOnClickListener((View.OnClickListener)new i(this, (RecyclerView.v)localObject1));
        ((View)localObject3).setOnLongClickListener((View.OnLongClickListener)new j(this, (RecyclerView.v)localObject1));
        return localObject1;
        localObject1 = (g)this;
        localObject3 = aa.jQ(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
        p.g(localObject3, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
        localObject1 = ((g)localObject1).hJ((View)localObject3);
        break label572;
        localObject3 = a(paramViewGroup, paramInt, (b)localObject1);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          p.hyc();
          localObject1 = localObject3;
          break label572;
          if (i >= 0)
          {
            localObject2 = this.RqN.get(i);
            p.g(localObject2, "footerInfoList[indexF]");
            localObject2 = (b)localObject2;
            if (((b)localObject2).hgu())
            {
              localObject2 = ((b)localObject2).getView();
              if (localObject2 != null)
              {
                localObject2 = hJ((View)localObject2);
                break label615;
              }
              localObject2 = (g)this;
              localObject3 = aa.jQ(paramViewGroup.getContext()).inflate(0, paramViewGroup, false);
              p.g(localObject3, "MMLayoutInflater.getInfl…ayoutId(), parent, false)");
              localObject2 = ((g)localObject2).hJ((View)localObject3);
              break label615;
            }
            localObject2 = this.RqN.get(i);
            p.g(localObject2, "footerInfoList[indexF]");
            localObject3 = b(paramViewGroup, paramInt, (b)localObject2);
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label615;
            }
            p.hyc();
            localObject2 = localObject3;
            break label615;
          }
          localObject2 = p(paramViewGroup, paramInt);
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
    if (hgr())
    {
      this.RqL.add(paramc);
      return;
    }
    super.a(paramc);
  }
  
  public final void a(VH paramVH, int paramInt)
  {
    p.h(paramVH, "holder");
    long l = SystemClock.uptimeMillis();
    Object localObject;
    if (paramInt < this.RqM.size())
    {
      localObject = this.RqM.get(paramInt);
      p.g(localObject, "headerInfoList[position]");
      localObject = (b)localObject;
      if (!((b)localObject).hgu()) {
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
      if (paramInt >= hgt() + this.RqM.size())
      {
        int i = this.RqM.size();
        int j = hgt();
        localObject = this.RqN.get(paramInt - (i + j));
        p.g(localObject, "footerInfoList[footerIndex]");
        localObject = (b)localObject;
        if (!((b)localObject).hgu()) {
          b(paramVH, paramInt, (b)localObject);
        }
      }
      else
      {
        h(paramVH, paramInt - this.RqM.size());
      }
    }
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
        if (paramInt < this.RqM.size())
        {
          Object localObject1 = this.RqM.get(paramInt);
          p.g(localObject1, "headerInfoList[position]");
          a(paramVH, paramInt, (b)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        paramList = new StringBuilder().append(a(localException, paramVH, paramList)).append(" crashActivity=");
        paramVH = paramVH.aus;
        p.g(paramVH, "holder.itemView");
        paramVH = paramVH.getContext().getClass().getName();
        paramVH = new RuntimeException(localException.getMessage() + "\n" + paramVH);
        paramVH.setStackTrace(localException.getStackTrace());
        throw ((Throwable)paramVH);
      }
      if (paramInt >= hgt() + this.RqM.size())
      {
        i = this.RqM.size();
        int j = hgt();
        Object localObject2 = this.RqN.get(paramInt - (i + j));
        p.g(localObject2, "footerInfoList[footerIndex]");
        b(paramVH, paramInt, (b)localObject2);
        return;
      }
      b(paramVH, paramInt - this.RqM.size(), paramList);
      return;
      label273:
      int i = 0;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean)
  {
    p.h(paramb, "info");
    if (!this.RqM.contains(paramb))
    {
      this.RqM.add(paramb);
      if (paramBoolean) {
        cj(this.RqM.size() - 1);
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
    p.h(paramb, "info");
    return this.RqM.contains(paramb);
  }
  
  public int apZ(int paramInt)
  {
    return 0;
  }
  
  public long aqa(int paramInt)
  {
    return 0L;
  }
  
  public final b aqb(int paramInt)
  {
    Object localObject = this.RqM.get(paramInt);
    p.g(localObject, "headerInfoList[headerPosition]");
    return (b)localObject;
  }
  
  public final b aqc(int paramInt)
  {
    Object localObject = this.RqN.get(paramInt);
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
    if (hgr())
    {
      this.RqL.remove(paramc);
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
  
  public void b(RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView);
    this.hak = paramRecyclerView;
    this.RqG = this.RqG;
    if (hgr())
    {
      Observable localObservable = this.RqJ;
      if (localObservable != null) {
        localObservable.registerObserver(new g.h(this, paramRecyclerView));
      }
    }
  }
  
  public final boolean b(b paramb)
  {
    p.h(paramb, "info");
    return this.RqN.contains(paramb);
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
    this.RqG = false;
  }
  
  public final b f(View paramView, final int paramInt, boolean paramBoolean)
  {
    p.h(paramView, "resource");
    paramView = new f(paramView, paramInt);
    if (!this.RqM.contains(paramView))
    {
      this.RqM.add(paramView);
      Log.i("Finder.FinderTopicFeedUIContract.TopicFeedViewCallback", "headerInfoList.add : " + paramView.lT());
      if (!paramBoolean) {
        break label85;
      }
      cj(this.RqM.size() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label85:
      Log.i("RecyclerViewAdapterEx", "[addHeaderView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
  }
  
  public final b g(View paramView, final int paramInt, boolean paramBoolean)
  {
    p.h(paramView, "resource");
    paramView = new e(paramView, paramInt);
    if (!this.RqN.contains(paramView))
    {
      this.RqN.add(paramView);
      if (!paramBoolean) {
        break label56;
      }
      cj(getItemCount() - 1);
    }
    for (;;)
    {
      return (b)paramView;
      label56:
      Log.i("RecyclerViewAdapterEx", "[addFooterView] notifyDataSetChanged");
      notifyDataSetChanged();
    }
  }
  
  public final int getItemCount()
  {
    return this.RqM.size() + hgt() + this.RqN.size();
  }
  
  public final long getItemId(int paramInt)
  {
    if ((getItemCount() <= paramInt) || (paramInt < 0))
    {
      String str = "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " headerCount=" + this.RqM.size() + " footerCount=" + this.RqN.size() + ' ' + Util.getStack();
      Log.e("RecyclerViewAdapterEx", str);
      h.CyF.a(20251, new Object[] { Integer.valueOf(3), str });
      return 0L;
    }
    if (paramInt < this.RqM.size()) {
      return ((b)this.RqM.get(paramInt)).lT();
    }
    if (paramInt >= hgt() + this.RqM.size())
    {
      int i = this.RqM.size();
      int j = hgt();
      return ((b)this.RqN.get(paramInt - (i + j))).lT();
    }
    return aqa(paramInt - this.RqM.size());
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt < this.RqM.size()) {
      return ((b)this.RqM.get(paramInt)).cxn();
    }
    if (paramInt >= hgt() + this.RqM.size())
    {
      int i = this.RqM.size();
      int j = hgt();
      return ((b)this.RqN.get(paramInt - (i + j))).cxn();
    }
    return apZ(paramInt - this.RqM.size());
  }
  
  public final RecyclerView getRecyclerView()
  {
    RecyclerView localRecyclerView = this.hak;
    if (localRecyclerView == null) {
      p.btv("recyclerView");
    }
    return localRecyclerView;
  }
  
  public abstract void h(VH paramVH, int paramInt);
  
  public abstract VH hJ(View paramView);
  
  public abstract int hgt();
  
  public final void l(VH paramVH)
  {
    p.h(paramVH, "holder");
    super.l(paramVH);
    paramVH = paramVH.aus;
    p.g(paramVH, "holder.itemView");
    dW(paramVH);
  }
  
  public abstract VH p(ViewGroup paramViewGroup, int paramInt);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "getLayoutId", "", "getView", "Landroid/view/View;", "isStatic", "", "libmmui_release"})
  public static abstract class b
    implements a
  {
    public View getView()
    {
      return null;
    }
    
    public boolean hgu()
    {
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V", "libmmui_release"})
  public static abstract interface c<VH extends RecyclerView.v>
  {
    public abstract void a(RecyclerView.a<VH> parama, View paramView, int paramInt, VH paramVH);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)Z", "libmmui_release"})
  public static abstract interface d<VH extends RecyclerView.v>
  {
    public abstract boolean b(RecyclerView.a<VH> parama, View paramView, int paramInt, VH paramVH);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addFooterView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class e
    extends g.b
  {
    e(View paramView, int paramInt) {}
    
    public final int cxn()
    {
      return paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(164701);
      if (((paramObject instanceof g.b)) && (lT() == ((g.b)paramObject).lT()))
      {
        AppMethodBeat.o(164701);
        return true;
      }
      AppMethodBeat.o(164701);
      return false;
    }
    
    public final View getView()
    {
      return this.RqR;
    }
    
    public final boolean hgu()
    {
      return true;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(164700);
      long l = this.RqR.hashCode();
      AppMethodBeat.o(164700);
      return l;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$addHeaderView$info$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "equals", "", "other", "", "getItemId", "", "getItemType", "", "getLayoutId", "getView", "Landroid/view/View;", "isStatic", "libmmui_release"})
  public static final class f
    extends g.b
  {
    f(View paramView, int paramInt) {}
    
    public final int cxn()
    {
      return paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(164703);
      if (((paramObject instanceof g.b)) && (lT() == ((g.b)paramObject).lT()))
      {
        AppMethodBeat.o(164703);
        return true;
      }
      AppMethodBeat.o(164703);
      return false;
    }
    
    public final View getView()
    {
      return this.RqR;
    }
    
    public final boolean hgu()
    {
      return true;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(164702);
      long l = this.RqR.hashCode();
      AppMethodBeat.o(164702);
      return l;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    g(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(g paramg, RecyclerView.v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(164719);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = this.RqS.getRecyclerView().bu(paramView);
      if (localObject != null) {}
      for (int i = ((RecyclerView.v)localObject).lR();; i = -1)
      {
        localObject = this.RqS.RqP;
        if (localObject != null)
        {
          RecyclerView.a locala = (RecyclerView.a)this.RqS;
          p.g(paramView, "it");
          ((g.c)localObject).a(locala, paramView, i, this.wrN);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164719);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class j
    implements View.OnLongClickListener
  {
    j(g paramg, RecyclerView.v paramv) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(164720);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
      localObject = this.RqS.getRecyclerView().bu(paramView);
      int i;
      RecyclerView.a locala;
      if (localObject != null)
      {
        i = ((RecyclerView.v)localObject).lR();
        localObject = this.RqS.RqO;
        if (localObject == null) {
          break label131;
        }
        locala = (RecyclerView.a)this.RqS;
        p.g(paramView, "it");
      }
      label131:
      for (boolean bool = ((g.d)localObject).b(locala, paramView, i, this.wrN);; bool = false)
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
 * Qualified Name:     com.tencent.mm.view.recyclerview.g
 * JD-Core Version:    0.7.0.1
 */