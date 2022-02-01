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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class ajvh
{
  public int a;
  public long a;
  public HashMap<Long, Integer> a;
  public final List<avrz> a;
  private boolean a;
  public final List<avrz> b;
  public final List<avrz> c;
  public final List<avrz> d;
  public final List<avrz> e;
  public final List<avrz> f;
  public final List<avrz> g;
  public final List<List<avrz>> h;
  
  public ajvh()
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
    this.h.add(this.jdField_a_of_type_JavaUtilList);
    this.h.add(this.b);
    this.h.add(this.c);
    this.h.add(this.d);
    this.h.add(this.e);
    this.h.add(this.f);
    this.h.add(this.g);
  }
  
  public int a()
  {
    Iterator localIterator = this.h.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((List)localIterator.next()).size() + i) {}
    return i;
  }
  
  public int a(int paramInt)
  {
    avrz localavrz = a(paramInt);
    if (localavrz == null) {
      return 1;
    }
    return localavrz.jdField_a_of_type_Int;
  }
  
  public int a(avrz paramavrz)
  {
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = this.c.size();
    }
    int j;
    do
    {
      return i;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((avrz)localIterator.next()).jdField_a_of_type_Arcs);
      }
      localArrayList.add(paramavrz.jdField_a_of_type_Arcs);
      anoy.b(localArrayList, a());
      j = localArrayList.indexOf(paramavrz.jdField_a_of_type_Arcs);
      i = j;
    } while (j != -1);
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "findOpenInsertPosition index == -1");
    return this.c.size();
  }
  
  public int a(List<avrz> paramList)
  {
    Iterator localIterator = this.h.iterator();
    List localList;
    for (int i = 0;; i = localList.size() + i) {
      if (localIterator.hasNext())
      {
        localList = (List)localIterator.next();
        if (localList != paramList) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public avrz a()
  {
    avrz localavrz = new avrz();
    localavrz.jdField_a_of_type_Int = 1;
    return localavrz;
  }
  
  public avrz a(int paramInt)
  {
    if (paramInt < 0)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "getItem" + paramInt);
      return null;
    }
    Iterator localIterator = this.h.iterator();
    List localList;
    for (int i = 0; localIterator.hasNext(); i = localList.size() + i)
    {
      localList = (List)localIterator.next();
      if (paramInt < localList.size() + i) {
        return (avrz)localList.get(paramInt - i);
      }
    }
    return null;
  }
  
  public avrz a(Context paramContext, boolean paramBoolean)
  {
    avrz localavrz = new avrz();
    localavrz.jdField_a_of_type_Int = 1;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (paramContext = paramContext.getString(2131693202);; paramContext = paramContext.getString(2131693201))
      {
        localavrz.jdField_a_of_type_JavaLangString = paramContext;
        return localavrz;
      }
    }
    localavrz.jdField_a_of_type_JavaLangString = paramContext.getString(2131693200);
    return localavrz;
  }
  
  public avrz a(arcs paramarcs)
  {
    avrz localavrz = new avrz();
    localavrz.jdField_a_of_type_Int = 2;
    localavrz.jdField_a_of_type_Arcs = paramarcs;
    return localavrz;
  }
  
  public List<Integer> a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface)))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "getSortList AppRuntime error ");
      return null;
    }
    return anoy.a((QQAppInterface)localAppRuntime, this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      int i = 0;
      while (i < this.c.size())
      {
        avrz localavrz = (avrz)this.c.get(i);
        if ((localavrz != null) && (localavrz.jdField_a_of_type_Arcs != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localavrz.jdField_a_of_type_Arcs.jdField_a_of_type_Long), Integer.valueOf(i));
        }
        i += 1;
      }
    }
  }
  
  public void a(Context paramContext, avsa paramavsa, avrz paramavrz, avse paramavse)
  {
    try
    {
      if (a())
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin isFastClick");
        return;
      }
      if ((paramavrz == null) || (paramavrz.jdField_a_of_type_Arcs == null) || (paramavrz.jdField_a_of_type_Int != 2) || (!this.f.contains(paramavrz)))
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
    int i = a(this.f) + this.f.indexOf(paramavrz);
    paramavrz.jdField_a_of_type_Arcs.a();
    paramavsa.a(paramavse, paramavrz);
    int j = a(paramavrz);
    this.c.add(j, paramavrz);
    this.f.remove(paramavrz);
    paramavsa.notifyItemMoved(i, j + a(this.c));
    if (this.b.isEmpty())
    {
      this.b.add(a(paramContext, true));
      paramavsa.notifyItemInserted(a(this.b));
    }
    if (this.f.isEmpty())
    {
      this.e.clear();
      paramavsa.notifyItemRemoved(a(this.e));
    }
    a(paramavsa, this.c, this.d);
    a(paramavsa, this.f, this.g);
    a(paramavrz.jdField_a_of_type_Arcs, true);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin position=" + i + ", time= " + (System.currentTimeMillis() - l));
  }
  
  public void a(Context paramContext, List<arcs> paramList, List<Integer> paramList1, int paramInt, avsa paramavsa)
  {
    if (paramavsa == null)
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
      paramavsa.notifyDataSetChanged();
      a();
      return;
    }
    this.b.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(localArrayList1, localArrayList2, paramList, paramList1);
    a(paramContext, localArrayList1, true);
    a(paramContext, localArrayList2, false);
    paramavsa.notifyDataSetChanged();
    a();
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "initShowMgrData " + this.jdField_a_of_type_Int);
  }
  
  public void a(Context paramContext, List<arcs> paramList, boolean paramBoolean)
  {
    List localList1;
    List localList2;
    label20:
    List localList3;
    if (paramBoolean)
    {
      localList1 = this.b;
      if (!paramBoolean) {
        break label102;
      }
      localList2 = this.c;
      if (!paramBoolean) {
        break label111;
      }
      localList3 = this.d;
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
            localList2.add(a((arcs)paramContext.next()));
            continue;
            localList1 = this.e;
            break;
            label102:
            localList2 = this.f;
            break label20;
            label111:
            localList3 = this.g;
            break label30;
          }
        }
        int j = b(localList2.size());
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            localList3.add(a(null));
            i += 1;
          }
        }
      }
    }
  }
  
  public void a(arcs paramarcs, boolean paramBoolean)
  {
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginSwitch");
    ThreadManager.excute(new LebaMgrDataLogic.1(this, paramarcs, paramBoolean), 128, null, true);
  }
  
  public void a(avrz paramavrz, long paramLong, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "reportItemSequence mInitPosMap == null");
    }
    while ((paramavrz == null) || (paramavrz.jdField_a_of_type_Arcs == null)) {
      return;
    }
    long l2 = paramavrz.jdField_a_of_type_Arcs.jdField_a_of_type_Long;
    paramavrz = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l2));
    long l1;
    if (paramavrz != null)
    {
      l1 = paramavrz.intValue() + 1;
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
  
  public void a(avsa paramavsa)
  {
    if (paramavsa != null) {}
    try
    {
      paramavsa.notifyDataSetChanged();
      b();
      return;
    }
    catch (Exception paramavsa)
    {
      for (;;)
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "onDargEnd", paramavsa);
      }
    }
  }
  
  public void a(avsa paramavsa, List<avrz> paramList1, List<avrz> paramList2)
  {
    int i = 0;
    int k = paramList2.size();
    int m = b(paramList1.size());
    int j = a(paramList2);
    if (k > m)
    {
      k -= m;
      i = 0;
      while (i < k)
      {
        paramList2.remove(0);
        i += 1;
      }
      paramavsa.notifyItemRangeRemoved(j, k);
    }
    while (k >= m) {
      return;
    }
    k = m - k;
    while (i < k)
    {
      paramList2.add(a(null));
      i += 1;
    }
    paramavsa.notifyItemRangeInserted(paramList2.size() + j - k, k);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.c.size())
    {
      a((avrz)this.c.get(i), i, true, localStringBuilder);
      i += 1;
    }
    i = 0;
    while (i < this.f.size())
    {
      a((avrz)this.f.get(i), i, false, localStringBuilder);
      i += 1;
    }
    bcul localbcul = avry.a("plugin_sequence");
    localbcul.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    a(paramQQAppInterface, localbcul);
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "reportSequence " + localStringBuilder);
  }
  
  public void a(QQAppInterface paramQQAppInterface, bcul parambcul)
  {
    bcru.a(paramQQAppInterface, parambcul);
  }
  
  public void a(List<arcs> paramList1, List<arcs> paramList2, List<arcs> paramList3, List<Integer> paramList)
  {
    paramList3 = paramList3.iterator();
    while (paramList3.hasNext())
    {
      arcs localarcs = (arcs)paramList3.next();
      if ((localarcs != null) && (localarcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (TextUtils.isEmpty(localarcs.jdField_a_of_type_JavaLangString)) && (localarcs.b())) {
        if (localarcs.a()) {
          paramList1.add(localarcs);
        } else {
          paramList2.add(localarcs);
        }
      }
    }
    anoy.b(paramList1, paramList);
    Collections.sort(paramList2, new anoz());
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
    avrz localavrz1 = a(paramInt1);
    if ((localavrz1 == null) || (!this.c.contains(localavrz1))) {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "onDargMove start error " + paramInt1);
    }
    int i;
    do
    {
      avrz localavrz2;
      do
      {
        return false;
        localavrz2 = a(paramInt2);
      } while ((localavrz2 == null) || ((!this.c.contains(localavrz2)) && (!this.d.contains(localavrz2))));
      paramInt2 = this.c.indexOf(localavrz1);
      if (this.d.contains(localavrz2)) {}
      for (i = this.c.size() - 1; paramInt2 < i; i = this.c.indexOf(localavrz2))
      {
        j = paramInt2;
        while (j < i)
        {
          Collections.swap(this.c, j, j + 1);
          j += 1;
        }
      }
    } while (paramInt2 <= i);
    int j = paramInt2;
    while (j > i)
    {
      Collections.swap(this.c, j, j - 1);
      j -= 1;
    }
    if (paramRecyclerView.getAdapter() != null) {
      paramRecyclerView.getAdapter().notifyItemMoved(paramInt1, i + paramInt1 - paramInt2);
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
  
  public int b(avrz paramavrz)
  {
    int i = 0;
    int j = 0;
    while (i < this.f.size())
    {
      avrz localavrz = (avrz)this.f.get(i);
      int k = j;
      if (localavrz != null)
      {
        k = j;
        if (localavrz.jdField_a_of_type_Arcs != null)
        {
          if (localavrz.jdField_a_of_type_Arcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) {
            break label75;
          }
          k = j;
        }
      }
      i += 1;
      j = k;
      continue;
      label75:
      if (paramavrz.jdField_a_of_type_Arcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority > localavrz.jdField_a_of_type_Arcs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority) {}
      for (k = 1;; k = 0)
      {
        if (k == 0) {
          return j;
        }
        k = i + 1;
        break;
      }
    }
    return j;
  }
  
  public void b()
  {
    ArrayList localArrayList = new ArrayList(this.d.size());
    int i = 0;
    while (i < this.c.size())
    {
      avrz localavrz = (avrz)this.c.get(i);
      if (localavrz.jdField_a_of_type_Arcs != null)
      {
        localArrayList.add(Integer.valueOf((int)localavrz.jdField_a_of_type_Arcs.jdField_a_of_type_Long));
        localavrz.jdField_a_of_type_Arcs.b = i;
      }
      i += 1;
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginSort list = " + localArrayList);
    ThreadManager.excute(new LebaMgrDataLogic.2(this, localArrayList), 128, null, true);
  }
  
  public void b(Context paramContext, avsa paramavsa, avrz paramavrz, avse paramavse)
  {
    try
    {
      if (a())
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin isFastClick");
        return;
      }
      if ((paramavrz == null) || (paramavrz.jdField_a_of_type_Int != 2) || (paramavrz.jdField_a_of_type_Arcs == null) || (!this.c.contains(paramavrz)))
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
    int i = a(this.c) + this.c.indexOf(paramavrz);
    paramavrz.jdField_a_of_type_Arcs.b();
    paramavsa.a(paramavse, paramavrz);
    int j = b(paramavrz);
    this.f.add(j, paramavrz);
    this.c.remove(paramavrz);
    paramavsa.notifyItemMoved(i, j + a(this.f));
    if (this.e.isEmpty())
    {
      this.e.add(a(paramContext, false));
      paramavsa.notifyItemInserted(a(this.e));
    }
    if (this.c.isEmpty())
    {
      this.b.clear();
      paramavsa.notifyItemRemoved(a(this.b));
    }
    a(paramavsa, this.c, this.d);
    a(paramavsa, this.f, this.g);
    a(paramavrz.jdField_a_of_type_Arcs, false);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin position=" + i + ", time=" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvh
 * JD-Core Version:    0.7.0.1
 */