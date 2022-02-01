import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaMgrDataLogic.1;
import com.tencent.mobileqq.activity.leba.LebaMgrDataLogic.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class akgq
{
  public int a;
  public long a;
  public HashMap<Long, Integer> a;
  public final List<awkq> a;
  private boolean a;
  public final List<awkq> b;
  public final List<awkq> c;
  public final List<awkq> d;
  public final List<awkq> e;
  public final List<awkq> f;
  public final List<awkq> g;
  public final List<awkq> h;
  public final List<List<awkq>> i;
  
  public akgq()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(a());
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.i = new ArrayList();
    this.i.add(this.jdField_a_of_type_JavaUtilList);
    this.i.add(this.b);
    this.i.add(this.c);
    this.i.add(this.d);
    this.i.add(this.e);
    this.i.add(this.f);
    this.i.add(this.g);
    this.i.add(this.h);
  }
  
  private void a(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext != null) {
      this.b.add(paramContext);
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.i.iterator();
    for (int j = 0; localIterator.hasNext(); j = ((List)localIterator.next()).size() + j) {}
    return j;
  }
  
  public int a(int paramInt)
  {
    awkq localawkq = a(paramInt);
    if (localawkq == null) {
      return 1;
    }
    return localawkq.jdField_a_of_type_Int;
  }
  
  public int a(awkq paramawkq)
  {
    int j;
    if (this.jdField_a_of_type_Boolean) {
      j = this.d.size();
    }
    int k;
    do
    {
      return j;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((awkq)localIterator.next()).jdField_a_of_type_Arsh);
      }
      localArrayList.add(paramawkq.jdField_a_of_type_Arsh);
      aoaz.b(localArrayList, a());
      k = localArrayList.indexOf(paramawkq.jdField_a_of_type_Arsh);
      j = k;
    } while (k != -1);
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "findOpenInsertPosition index == -1");
    return this.d.size();
  }
  
  public int a(List<awkq> paramList)
  {
    Iterator localIterator = this.i.iterator();
    List localList;
    for (int j = 0;; j = localList.size() + j) {
      if (localIterator.hasNext())
      {
        localList = (List)localIterator.next();
        if (localList != paramList) {}
      }
      else
      {
        return j;
      }
    }
  }
  
  public awkq a()
  {
    awkq localawkq = new awkq();
    localawkq.jdField_a_of_type_Int = 1;
    return localawkq;
  }
  
  public awkq a(int paramInt)
  {
    if (paramInt < 0)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "getItem" + paramInt);
      return null;
    }
    Iterator localIterator = this.i.iterator();
    List localList;
    for (int j = 0; localIterator.hasNext(); j = localList.size() + j)
    {
      localList = (List)localIterator.next();
      if (paramInt < localList.size() + j) {
        return (awkq)localList.get(paramInt - j);
      }
    }
    return null;
  }
  
  public awkq a(Context paramContext)
  {
    if ((QzoneConfig.isQQCircleShowLebaEntrance()) && (QzoneConfig.isQQCircleShowSwitchButton()))
    {
      awkq localawkq = new awkq();
      localawkq.jdField_a_of_type_Int = 3;
      localawkq.jdField_a_of_type_JavaLangString = paramContext.getString(2131718520);
      localawkq.b = 2130845338;
      return localawkq;
    }
    return null;
  }
  
  public awkq a(Context paramContext, boolean paramBoolean)
  {
    awkq localawkq = new awkq();
    localawkq.jdField_a_of_type_Int = 1;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (paramContext = paramContext.getString(2131693214);; paramContext = paramContext.getString(2131693213))
      {
        localawkq.jdField_a_of_type_JavaLangString = paramContext;
        return localawkq;
      }
    }
    localawkq.jdField_a_of_type_JavaLangString = paramContext.getString(2131693212);
    return localawkq;
  }
  
  public awkq a(arsh paramarsh)
  {
    awkq localawkq = new awkq();
    localawkq.jdField_a_of_type_Int = 2;
    localawkq.jdField_a_of_type_Arsh = paramarsh;
    return localawkq;
  }
  
  public List<Integer> a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface)))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "getSortList AppRuntime error ");
      return null;
    }
    return aoaz.a((QQAppInterface)localAppRuntime, this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      int j = 0;
      while (j < this.d.size())
      {
        awkq localawkq = (awkq)this.d.get(j);
        if ((localawkq != null) && (localawkq.jdField_a_of_type_Arsh != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localawkq.jdField_a_of_type_Arsh.jdField_a_of_type_Long), Integer.valueOf(j));
        }
        j += 1;
      }
    }
  }
  
  public void a(Context paramContext, awkr paramawkr, awkq paramawkq, awkv paramawkv)
  {
    try
    {
      if (a())
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin isFastClick");
        return;
      }
      if ((paramawkq == null) || (paramawkq.jdField_a_of_type_Arsh == null) || (paramawkq.jdField_a_of_type_Int != 2) || (!this.g.contains(paramawkq)))
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin error ");
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin", paramContext);
      return;
    }
    long l = System.currentTimeMillis();
    int j = a(this.g) + this.g.indexOf(paramawkq);
    paramawkq.jdField_a_of_type_Arsh.a();
    paramawkr.a(paramawkv, paramawkq);
    int k = a(paramawkq);
    this.d.add(k, paramawkq);
    this.g.remove(paramawkq);
    paramawkr.notifyItemMoved(j, k + a(this.d));
    if (this.c.isEmpty())
    {
      this.c.add(a(paramContext, true));
      paramawkr.notifyItemInserted(a(this.c));
    }
    if (this.g.isEmpty())
    {
      this.f.clear();
      paramawkr.notifyItemRemoved(a(this.f));
    }
    a(paramawkr, this.d, this.e);
    a(paramawkr, this.g, this.h);
    a(paramawkq.jdField_a_of_type_Arsh, true);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin position=" + j + ", time= " + (System.currentTimeMillis() - l));
  }
  
  public void a(Context paramContext, List<arsh> paramList, List<Integer> paramList1, int paramInt, awkr paramawkr)
  {
    if (paramawkr == null)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "initShowMgrData adpter == null ");
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "initShowMgrData srcList isEmpty " + this.jdField_a_of_type_Int);
      this.b.clear();
      this.c.clear();
      this.d.clear();
      this.e.clear();
      this.f.clear();
      this.g.clear();
      this.h.clear();
      paramawkr.notifyDataSetChanged();
      a();
      return;
    }
    this.b.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.h.clear();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(localArrayList1, localArrayList2, paramList, paramList1);
    a(paramContext);
    a(paramContext, localArrayList1, true);
    a(paramContext, localArrayList2, false);
    paramawkr.notifyDataSetChanged();
    a();
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "initShowMgrData " + this.jdField_a_of_type_Int);
  }
  
  public void a(Context paramContext, List<arsh> paramList, boolean paramBoolean)
  {
    List localList1;
    List localList2;
    label20:
    List localList3;
    if (paramBoolean)
    {
      localList1 = this.c;
      if (!paramBoolean) {
        break label102;
      }
      localList2 = this.d;
      if (!paramBoolean) {
        break label111;
      }
      localList3 = this.e;
    }
    for (;;)
    {
      label30:
      if (!paramList.isEmpty())
      {
        localList1.add(a(paramContext, paramBoolean));
        paramContext = paramList.iterator();
        for (;;)
        {
          if (paramContext.hasNext())
          {
            localList2.add(a((arsh)paramContext.next()));
            continue;
            localList1 = this.f;
            break;
            label102:
            localList2 = this.g;
            break label20;
            label111:
            localList3 = this.h;
            break label30;
          }
        }
        int k = b(localList2.size());
        if (k > 0)
        {
          int j = 0;
          while (j < k)
          {
            localList3.add(a(null));
            j += 1;
          }
        }
      }
    }
  }
  
  public void a(arsh paramarsh, boolean paramBoolean)
  {
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginSwitch");
    ThreadManager.excute(new LebaMgrDataLogic.1(this, paramarsh, paramBoolean), 128, null, true);
  }
  
  public void a(awkq paramawkq, long paramLong, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "reportItemSequence mInitPosMap == null");
    }
    while ((paramawkq == null) || (paramawkq.jdField_a_of_type_Arsh == null)) {
      return;
    }
    long l2 = paramawkq.jdField_a_of_type_Arsh.jdField_a_of_type_Long;
    paramawkq = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l2));
    long l1;
    if (paramawkq != null)
    {
      l1 = paramawkq.intValue() + 1;
      if (!paramBoolean) {
        break label117;
      }
    }
    label117:
    for (paramLong = 1L + paramLong;; paramLong = 0L)
    {
      paramStringBuilder.append(l2).append("_").append(l1).append("_").append(paramLong).append(";");
      return;
      l1 = 0L;
      break;
    }
  }
  
  public void a(awkr paramawkr)
  {
    if (paramawkr != null) {}
    try
    {
      paramawkr.notifyDataSetChanged();
      b();
      return;
    }
    catch (Exception paramawkr)
    {
      for (;;)
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "onDargEnd", paramawkr);
      }
    }
  }
  
  public void a(awkr paramawkr, List<awkq> paramList1, List<awkq> paramList2)
  {
    int j = 0;
    int m = paramList2.size();
    int n = b(paramList1.size());
    int k = a(paramList2);
    if (m > n)
    {
      m -= n;
      j = 0;
      while (j < m)
      {
        paramList2.remove(0);
        j += 1;
      }
      paramawkr.notifyItemRangeRemoved(k, m);
    }
    while (m >= n) {
      return;
    }
    m = n - m;
    while (j < m)
    {
      paramList2.add(a(null));
      j += 1;
    }
    paramawkr.notifyItemRangeInserted(paramList2.size() + k - m, m);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < this.d.size())
    {
      a((awkq)this.d.get(j), j, true, localStringBuilder);
      j += 1;
    }
    j = 0;
    while (j < this.g.size())
    {
      a((awkq)this.g.get(j), j, false, localStringBuilder);
      j += 1;
    }
    bdne localbdne = awkp.a("plugin_sequence");
    localbdne.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    a(paramQQAppInterface, localbdne);
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "reportSequence " + localStringBuilder);
  }
  
  public void a(QQAppInterface paramQQAppInterface, bdne parambdne)
  {
    bdkm.a(paramQQAppInterface, parambdne);
  }
  
  public void a(List<arsh> paramList1, List<arsh> paramList2, List<arsh> paramList3, List<Integer> paramList)
  {
    paramList3 = paramList3.iterator();
    while (paramList3.hasNext())
    {
      arsh localarsh = (arsh)paramList3.next();
      if ((localarsh != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (TextUtils.isEmpty(localarsh.jdField_a_of_type_JavaLangString)) && (localarsh.b())) {
        if (localarsh.a()) {
          paramList1.add(localarsh);
        } else {
          paramList2.add(localarsh);
        }
      }
    }
    aoaz.b(paramList1, paramList);
    Collections.sort(paramList2, new aoba());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (Math.abs(this.jdField_a_of_type_Long - System.currentTimeMillis()) < 500L) {
      return true;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return false;
  }
  
  public boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    awkq localawkq1 = a(paramInt1);
    if ((localawkq1 == null) || (!this.d.contains(localawkq1))) {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "onDargMove start error " + paramInt1);
    }
    int j;
    do
    {
      awkq localawkq2;
      do
      {
        return false;
        localawkq2 = a(paramInt2);
      } while ((localawkq2 == null) || ((!this.d.contains(localawkq2)) && (!this.e.contains(localawkq2))));
      paramInt2 = this.d.indexOf(localawkq1);
      if (this.e.contains(localawkq2)) {}
      for (j = this.d.size() - 1; paramInt2 < j; j = this.d.indexOf(localawkq2))
      {
        k = paramInt2;
        while (k < j)
        {
          Collections.swap(this.d, k, k + 1);
          k += 1;
        }
      }
    } while (paramInt2 <= j);
    int k = paramInt2;
    while (k > j)
    {
      Collections.swap(this.d, k, k - 1);
      k -= 1;
    }
    if (paramRecyclerView.getAdapter() != null) {
      paramRecyclerView.getAdapter().notifyItemMoved(paramInt1, j + paramInt1 - paramInt2);
    }
    return true;
  }
  
  public int b(int paramInt)
  {
    paramInt %= 3;
    if (paramInt == 0) {
      return 0;
    }
    return 3 - paramInt;
  }
  
  public int b(awkq paramawkq)
  {
    int j = 0;
    int k = 0;
    while (j < this.g.size())
    {
      awkq localawkq = (awkq)this.g.get(j);
      int m = k;
      if (localawkq != null)
      {
        m = k;
        if (localawkq.jdField_a_of_type_Arsh != null)
        {
          if (localawkq.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) {
            break label75;
          }
          m = k;
        }
      }
      j += 1;
      k = m;
      continue;
      label75:
      if (paramawkq.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority > localawkq.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority) {}
      for (m = 1;; m = 0)
      {
        if (m == 0) {
          return k;
        }
        m = j + 1;
        break;
      }
    }
    return k;
  }
  
  public void b()
  {
    ArrayList localArrayList = new ArrayList(this.e.size());
    int j = 0;
    while (j < this.d.size())
    {
      awkq localawkq = (awkq)this.d.get(j);
      if (localawkq.jdField_a_of_type_Arsh != null)
      {
        localArrayList.add(Integer.valueOf((int)localawkq.jdField_a_of_type_Arsh.jdField_a_of_type_Long));
        localawkq.jdField_a_of_type_Arsh.b = j;
      }
      j += 1;
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginSort list = " + localArrayList);
    ThreadManager.excute(new LebaMgrDataLogic.2(this, localArrayList), 128, null, true);
  }
  
  public void b(Context paramContext, awkr paramawkr, awkq paramawkq, awkv paramawkv)
  {
    try
    {
      if (a())
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin isFastClick");
        return;
      }
      if ((paramawkq == null) || (paramawkq.jdField_a_of_type_Int != 2) || (paramawkq.jdField_a_of_type_Arsh == null) || (!this.d.contains(paramawkq)))
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin error");
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin", paramContext);
      return;
    }
    long l = System.currentTimeMillis();
    int j = a(this.d) + this.d.indexOf(paramawkq);
    paramawkq.jdField_a_of_type_Arsh.b();
    paramawkr.a(paramawkv, paramawkq);
    int k = b(paramawkq);
    this.g.add(k, paramawkq);
    this.d.remove(paramawkq);
    paramawkr.notifyItemMoved(j, k + a(this.g));
    if (this.f.isEmpty())
    {
      this.f.add(a(paramContext, false));
      paramawkr.notifyItemInserted(a(this.f));
    }
    if (this.d.isEmpty())
    {
      this.c.clear();
      paramawkr.notifyItemRemoved(a(this.c));
    }
    a(paramawkr, this.d, this.e);
    a(paramawkr, this.g, this.h);
    a(paramawkq.jdField_a_of_type_Arsh, false);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin position=" + j + ", time=" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgq
 * JD-Core Version:    0.7.0.1
 */