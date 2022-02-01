import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class aabj
  extends aabx<aabp>
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private aabd jdField_a_of_type_Aabd;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aabl(this);
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private final ConcurrentHashMap<String, aabn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<aabo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private int jdField_b_of_type_Int;
  private final ConcurrentHashMap<String, aabp> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public aabj(BlockContainer paramBlockContainer)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = paramBlockContainer;
    setHasStableIds(true);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, aabp paramaabp, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramaabp.getSpanCount(paramViewHolder.getLayoutPosition() - paramaabp.getPositionOffsetStart()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(aabp paramaabp, int paramInt)
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      ((aabp)localIterator.next()).handleBlockChange(paramaabp, paramInt);
    }
  }
  
  private void b(String paramString, aabn paramaabn)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((aabo)localIterator.next()).handleShareDataChange(paramString, paramaabn);
      }
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.mDataList.size() == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore mDataList.size() == 0" + hashCode());
      return;
    }
    aabp localaabp = (aabp)this.mDataList.get(this.mDataList.size() - 1);
    if (localaabp == null)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore adapter == null" + hashCode());
      return;
    }
    if (localaabp.getLoadInfo().b())
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore is loading:" + hashCode());
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore maxCount 0 hashCode:" + hashCode());
      return;
    }
    int i = aade.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    if (i == -1)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore not renderReady hashCode:" + hashCode());
      return;
    }
    if (i < localaabp.getItemCount() - 1)
    {
      QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore enough to scroll hashCode:" + hashCode());
      return;
    }
    if (f())
    {
      QLog.e("CMADebugTAG", 1, "isNeedTryToLoadMore invalid hashCode:" + hashCode());
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) && (!paramBoolean))
    {
      this.jdField_a_of_type_Int += 1;
      b();
      QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore try to loadMore Success hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
      return;
    }
    this.jdField_a_of_type_Int = 0;
    QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore reset hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
  }
  
  private boolean f()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int);
  }
  
  public int a()
  {
    return a(this.mDataList);
  }
  
  public int a(ArrayList<aabp> paramArrayList)
  {
    try
    {
      int m = paramArrayList.size();
      int k = 0;
      int i = 0;
      int j = i;
      if (k < m)
      {
        if (blgn.a(k, paramArrayList)) {
          return i;
        }
        aabp localaabp = (aabp)paramArrayList.get(k);
        j = i;
        if (localaabp != null) {
          if (!b()) {
            break label148;
          }
        }
        label148:
        for (j = 1;; j = 0)
        {
          localaabp.setGlobalPositionOffset(j + i);
          i += localaabp.getItemCount();
          j = i;
          if (jdField_a_of_type_Boolean)
          {
            Log.d("CMADebugTAG|" + localaabp.getClass().getSimpleName(), "size:" + localaabp.getItemCount());
            j = i;
          }
          k += 1;
          i = j;
          break;
        }
      }
      return j;
    }
    catch (Exception paramArrayList)
    {
      j = 0;
    }
  }
  
  public aabd a()
  {
    return this.jdField_a_of_type_Aabd;
  }
  
  public aabn a(String paramString)
  {
    return (aabn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public aabp a(int paramInt)
  {
    if (paramInt < a())
    {
      int k = this.mDataList.size();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < k)
      {
        aabp localaabp = (aabp)this.mDataList.get(paramInt);
        j = localaabp.getItemCount();
        if (i < j) {
          return localaabp;
        }
        i = Math.max(i - j, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  public aabp a(String paramString)
  {
    return (aabp)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public GridLayoutManager.SpanSizeLookup a()
  {
    return new aabk(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mDataList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new aabm(this, new View(paramViewGroup.getContext()));
      }
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    }
    if (paramInt == -99999) {
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    }
    int k = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt);
    int i = paramInt;
    if (k != 0)
    {
      i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((aabp)this.mDataList.get(i)).getViewTypeCount();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_a_of_type_Boolean) {
      Log.d("CMADebugTAG|" + ((aabp)this.mDataList.get(k)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i);
    }
    return ((aabp)this.mDataList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public BlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  }
  
  public void a()
  {
    super.a();
    if (this.mDataList.size() > 0) {
      a().setRefreshing(true);
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      aabp localaabp = (aabp)this.mDataList.get(i);
      if (localaabp.isEnableRefresh()) {
        localaabp.onRefreshData();
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((aabp)this.mDataList.get(i)).onActivityResult(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  public void a(aabd paramaabd)
  {
    this.jdField_a_of_type_Aabd = paramaabd;
  }
  
  public void a(aabo paramaabo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramaabo);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramaabo.handleShareDataChange(str, (aabn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  public void a(aabp paramaabp)
  {
    a(paramaabp, -1);
  }
  
  public void a(aabp paramaabp, int paramInt)
  {
    if ((paramaabp != null) && (!this.mDataList.contains(paramaabp)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.mDataList.size();
      }
      if (paramaabp.getUniqueKey() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramaabp.getUniqueKey(), paramaabp);
      }
      this.mDataList.add(i, paramaabp);
      paramaabp.setBlockMerger(this);
      paramaabp.onAttachedToRecyclerView(a().a());
      b(paramaabp, 1);
      a(paramaabp);
    }
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int k = this.mDataList.size();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      if (paramInt < k)
      {
        aabp localaabp = (aabp)this.mDataList.get(paramInt);
        j = localaabp.getItemCount();
        if (i < j) {
          localaabp.onBindViewHolder(paramViewHolder, i);
        }
      }
      else
      {
        return;
      }
      i = Math.max(i - j, 0);
      paramInt += 1;
    }
  }
  
  public void a(String paramString, aabn paramaabn)
  {
    if (paramaabn == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaabn);
    b(paramString, paramaabn);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      if (((aabp)localIterator.next()).onBackEvent()) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    aabp localaabp = (aabp)this.mDataList.get(this.mDataList.size() - 1);
    if (!a().b()) {}
    do
    {
      do
      {
        return;
      } while (localaabp.getLoadInfo().b());
      if (localaabp.getLoadInfo().a())
      {
        localaabp.getLoadInfo().a(4);
        return;
      }
    } while (this.mDataList.size() <= 0);
    f();
    localaabp.getLoadInfo().a(3);
    localaabp.loadMoreData(localaabp.getLoadInfo());
  }
  
  public void b(aabo paramaabo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaabo);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_Aabd = null;
  }
  
  public void d()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      aabp localaabp = (aabp)localIterator.next();
      if (!localaabp.isLazyLoad()) {
        localaabp.onInit();
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int getDataNumber()
  {
    return a();
  }
  
  public int getItemCount()
  {
    return a() + b();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k;
    if ((b()) && (paramInt == 0))
    {
      k = -10000;
      return k;
    }
    int j = a(paramInt);
    if (j < a())
    {
      int m = -1;
      int n = this.mDataList.size();
      paramInt = 0;
      int i = 0;
      for (;;)
      {
        k = m;
        if (paramInt >= n) {
          break;
        }
        aabp localaabp = (aabp)this.mDataList.get(paramInt);
        k = localaabp.getItemCount();
        if (j < k)
        {
          j = localaabp.getItemViewType(j);
          if (jdField_a_of_type_Boolean) {
            Log.d("CMADebugTAG|" + localaabp.getClass().getSimpleName(), "getItemViewType ViewType:" + j);
          }
          if (j < 0) {}
          for (;;)
          {
            localaabp.setViewTypeOffset(i);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, paramInt);
            return j;
            j += i;
          }
        }
        j = Math.max(j - k, 0);
        if (localaabp.getViewTypeCount() == 0) {
          throw new IllegalArgumentException("HorizontalRVBlock getViewTypeCount() has to be greater than 0");
        }
        i += localaabp.getViewTypeCount();
        paramInt += 1;
      }
    }
    return -99999;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((aabp)this.mDataList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((aabp)this.mDataList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((aabp)this.mDataList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((aabp)this.mDataList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((aabp)this.mDataList.get(i)).onActivityStopped(paramActivity);
      i += 1;
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = this.mDataList.size();
    int i = 0;
    while (i < j)
    {
      ((aabp)this.mDataList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && (((paramViewHolder instanceof aabz)) || ((paramViewHolder instanceof aaca)))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
    for (;;)
    {
      return;
      int j = a(paramViewHolder.getAdapterPosition());
      if (j >= 0)
      {
        int k = this.mDataList.size();
        int i = 0;
        while (i < k)
        {
          aabp localaabp = (aabp)this.mDataList.get(i);
          int m = localaabp.getItemCount();
          if (j < m)
          {
            if (bool) {
              a(paramViewHolder, localaabp, localLayoutParams);
            }
            localaabp.onViewAttachedToWindow(paramViewHolder);
            return;
          }
          j = Math.max(j - m, 0);
          i += 1;
        }
      }
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    int j = a(paramViewHolder.getAdapterPosition());
    if (j < 0) {}
    for (;;)
    {
      return;
      int k = this.mDataList.size();
      int i = 0;
      while (i < k)
      {
        aabs localaabs = (aabs)this.mDataList.get(i);
        int m = localaabs.getItemCount();
        if (j < m)
        {
          localaabs.onViewDetachedFromWindow(paramViewHolder);
          return;
        }
        j = Math.max(j - m, 0);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabj
 * JD-Core Version:    0.7.0.1
 */