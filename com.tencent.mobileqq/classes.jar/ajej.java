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

public class ajej
{
  public int a;
  public long a;
  public HashMap<Long, Integer> a;
  public final List<auxu> a;
  private boolean a;
  public final List<auxu> b;
  public final List<auxu> c;
  public final List<auxu> d;
  public final List<auxu> e;
  public final List<auxu> f;
  public final List<auxu> g;
  public final List<auxu> h;
  public final List<List<auxu>> i;
  
  public ajej()
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
    auxu localauxu = a(paramInt);
    if (localauxu == null) {
      return 1;
    }
    return localauxu.jdField_a_of_type_Int;
  }
  
  public int a(auxu paramauxu)
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
        localArrayList.add(((auxu)localIterator.next()).jdField_a_of_type_Aqmf);
      }
      localArrayList.add(paramauxu.jdField_a_of_type_Aqmf);
      amvb.b(localArrayList, a());
      k = localArrayList.indexOf(paramauxu.jdField_a_of_type_Aqmf);
      j = k;
    } while (k != -1);
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "findOpenInsertPosition index == -1");
    return this.d.size();
  }
  
  public int a(List<auxu> paramList)
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
  
  public auxu a()
  {
    auxu localauxu = new auxu();
    localauxu.jdField_a_of_type_Int = 1;
    return localauxu;
  }
  
  public auxu a(int paramInt)
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
        return (auxu)localList.get(paramInt - j);
      }
    }
    return null;
  }
  
  public auxu a(Context paramContext)
  {
    if ((QzoneConfig.isQQCircleShowLebaEntrance()) && (QzoneConfig.isQQCircleShowSwitchButton()))
    {
      auxu localauxu = new auxu();
      localauxu.jdField_a_of_type_Int = 3;
      localauxu.jdField_a_of_type_JavaLangString = paramContext.getString(2131718768);
      localauxu.b = 2130845217;
      return localauxu;
    }
    return null;
  }
  
  public auxu a(Context paramContext, boolean paramBoolean)
  {
    auxu localauxu = new auxu();
    localauxu.jdField_a_of_type_Int = 1;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (paramContext = paramContext.getString(2131693303);; paramContext = paramContext.getString(2131693302))
      {
        localauxu.jdField_a_of_type_JavaLangString = paramContext;
        return localauxu;
      }
    }
    localauxu.jdField_a_of_type_JavaLangString = paramContext.getString(2131693301);
    return localauxu;
  }
  
  public auxu a(aqmf paramaqmf)
  {
    auxu localauxu = new auxu();
    localauxu.jdField_a_of_type_Int = 2;
    localauxu.jdField_a_of_type_Aqmf = paramaqmf;
    return localauxu;
  }
  
  public List<Integer> a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface)))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "getSortList AppRuntime error ");
      return null;
    }
    return amvb.a((QQAppInterface)localAppRuntime, this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      int j = 0;
      while (j < this.d.size())
      {
        auxu localauxu = (auxu)this.d.get(j);
        if ((localauxu != null) && (localauxu.jdField_a_of_type_Aqmf != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localauxu.jdField_a_of_type_Aqmf.jdField_a_of_type_Long), Integer.valueOf(j));
        }
        j += 1;
      }
    }
  }
  
  public void a(Context paramContext, auxv paramauxv, auxu paramauxu, auxz paramauxz)
  {
    try
    {
      if (a())
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin isFastClick");
        return;
      }
      if ((paramauxu == null) || (paramauxu.jdField_a_of_type_Aqmf == null) || (paramauxu.jdField_a_of_type_Int != 2) || (!this.g.contains(paramauxu)))
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
    int j = a(this.g) + this.g.indexOf(paramauxu);
    paramauxu.jdField_a_of_type_Aqmf.a();
    paramauxv.a(paramauxz, paramauxu);
    int k = a(paramauxu);
    this.d.add(k, paramauxu);
    this.g.remove(paramauxu);
    paramauxv.notifyItemMoved(j, k + a(this.d));
    if (this.c.isEmpty())
    {
      this.c.add(a(paramContext, true));
      paramauxv.notifyItemInserted(a(this.c));
    }
    if (this.g.isEmpty())
    {
      this.f.clear();
      paramauxv.notifyItemRemoved(a(this.f));
    }
    a(paramauxv, this.d, this.e);
    a(paramauxv, this.g, this.h);
    a(paramauxu.jdField_a_of_type_Aqmf, true);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin position=" + j + ", time= " + (System.currentTimeMillis() - l));
  }
  
  public void a(Context paramContext, List<aqmf> paramList, List<Integer> paramList1, int paramInt, auxv paramauxv)
  {
    if (paramauxv == null)
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
      paramauxv.notifyDataSetChanged();
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
    paramauxv.notifyDataSetChanged();
    a();
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "initShowMgrData " + this.jdField_a_of_type_Int);
  }
  
  public void a(Context paramContext, List<aqmf> paramList, boolean paramBoolean)
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
            localList2.add(a((aqmf)paramContext.next()));
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
  
  public void a(aqmf paramaqmf, boolean paramBoolean)
  {
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginSwitch");
    ThreadManager.excute(new LebaMgrDataLogic.1(this, paramaqmf, paramBoolean), 128, null, true);
  }
  
  public void a(auxu paramauxu, long paramLong, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "reportItemSequence mInitPosMap == null");
    }
    while ((paramauxu == null) || (paramauxu.jdField_a_of_type_Aqmf == null)) {
      return;
    }
    long l2 = paramauxu.jdField_a_of_type_Aqmf.jdField_a_of_type_Long;
    paramauxu = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l2));
    long l1;
    if (paramauxu != null)
    {
      l1 = paramauxu.intValue() + 1;
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
  
  public void a(auxv paramauxv)
  {
    if (paramauxv != null) {}
    try
    {
      paramauxv.notifyDataSetChanged();
      b();
      return;
    }
    catch (Exception paramauxv)
    {
      for (;;)
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "onDargEnd", paramauxv);
      }
    }
  }
  
  public void a(auxv paramauxv, List<auxu> paramList1, List<auxu> paramList2)
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
      paramauxv.notifyItemRangeRemoved(k, m);
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
    paramauxv.notifyItemRangeInserted(paramList2.size() + k - m, m);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < this.d.size())
    {
      a((auxu)this.d.get(j), j, true, localStringBuilder);
      j += 1;
    }
    j = 0;
    while (j < this.g.size())
    {
      a((auxu)this.g.get(j), j, false, localStringBuilder);
      j += 1;
    }
    bcfp localbcfp = auxt.a("plugin_sequence");
    localbcfp.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    a(paramQQAppInterface, localbcfp);
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "reportSequence " + localStringBuilder);
  }
  
  public void a(QQAppInterface paramQQAppInterface, bcfp parambcfp)
  {
    bcdg.a(paramQQAppInterface, parambcfp);
  }
  
  public void a(List<aqmf> paramList1, List<aqmf> paramList2, List<aqmf> paramList3, List<Integer> paramList)
  {
    paramList3 = paramList3.iterator();
    while (paramList3.hasNext())
    {
      aqmf localaqmf = (aqmf)paramList3.next();
      if ((localaqmf != null) && (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (TextUtils.isEmpty(localaqmf.jdField_a_of_type_JavaLangString)) && (localaqmf.b())) {
        if (localaqmf.a()) {
          paramList1.add(localaqmf);
        } else {
          paramList2.add(localaqmf);
        }
      }
    }
    amvb.b(paramList1, paramList);
    Collections.sort(paramList2, new amvd());
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
    auxu localauxu1 = a(paramInt1);
    if ((localauxu1 == null) || (!this.d.contains(localauxu1))) {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "onDargMove start error " + paramInt1);
    }
    int j;
    do
    {
      auxu localauxu2;
      do
      {
        return false;
        localauxu2 = a(paramInt2);
      } while ((localauxu2 == null) || ((!this.d.contains(localauxu2)) && (!this.e.contains(localauxu2))));
      paramInt2 = this.d.indexOf(localauxu1);
      if (this.e.contains(localauxu2)) {}
      for (j = this.d.size() - 1; paramInt2 < j; j = this.d.indexOf(localauxu2))
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
  
  public int b(auxu paramauxu)
  {
    int j = 0;
    int k = 0;
    while (j < this.g.size())
    {
      auxu localauxu = (auxu)this.g.get(j);
      int m = k;
      if (localauxu != null)
      {
        m = k;
        if (localauxu.jdField_a_of_type_Aqmf != null)
        {
          if (localauxu.jdField_a_of_type_Aqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) {
            break label75;
          }
          m = k;
        }
      }
      j += 1;
      k = m;
      continue;
      label75:
      if (paramauxu.jdField_a_of_type_Aqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority > localauxu.jdField_a_of_type_Aqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority) {}
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
      auxu localauxu = (auxu)this.d.get(j);
      if (localauxu.jdField_a_of_type_Aqmf != null)
      {
        localArrayList.add(Integer.valueOf((int)localauxu.jdField_a_of_type_Aqmf.jdField_a_of_type_Long));
        localauxu.jdField_a_of_type_Aqmf.b = j;
      }
      j += 1;
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginSort list = " + localArrayList);
    ThreadManager.excute(new LebaMgrDataLogic.2(this, localArrayList), 128, null, true);
  }
  
  public void b(Context paramContext, auxv paramauxv, auxu paramauxu, auxz paramauxz)
  {
    try
    {
      if (a())
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin isFastClick");
        return;
      }
      if ((paramauxu == null) || (paramauxu.jdField_a_of_type_Int != 2) || (paramauxu.jdField_a_of_type_Aqmf == null) || (!this.d.contains(paramauxu)))
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
    int j = a(this.d) + this.d.indexOf(paramauxu);
    paramauxu.jdField_a_of_type_Aqmf.b();
    paramauxv.a(paramauxz, paramauxu);
    int k = b(paramauxu);
    this.g.add(k, paramauxu);
    this.d.remove(paramauxu);
    paramauxv.notifyItemMoved(j, k + a(this.g));
    if (this.f.isEmpty())
    {
      this.f.add(a(paramContext, false));
      paramauxv.notifyItemInserted(a(this.f));
    }
    if (this.d.isEmpty())
    {
      this.c.clear();
      paramauxv.notifyItemRemoved(a(this.c));
    }
    a(paramauxv, this.d, this.e);
    a(paramauxv, this.g, this.h);
    a(paramauxu.jdField_a_of_type_Aqmf, false);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin position=" + j + ", time=" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajej
 * JD-Core Version:    0.7.0.1
 */