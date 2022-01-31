import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ahnl
{
  private static ahnl jdField_a_of_type_Ahnl;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public final List<RecentBaseData> a;
  private ConcurrentHashMap<String, RecentBaseData> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(109);
  public boolean a;
  public List<RecentBaseData> b;
  private boolean b;
  
  private ahnl()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
  }
  
  public static ahnl a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Ahnl == null) {
        jdField_a_of_type_Ahnl = new ahnl();
      }
      return jdField_a_of_type_Ahnl;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "-" + paramInt;
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList)
  {
    bfwu.a("splitRecents");
    ArrayList localArrayList1 = new ArrayList(4);
    ArrayList localArrayList2 = new ArrayList(4);
    ArrayList localArrayList3 = new ArrayList(4);
    localArrayList1.add(paramQQAppInterface.getCurrentAccountUin());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      switch (localRecentUser.getType())
      {
      default: 
        break;
      case 0: 
        localArrayList1.add(localRecentUser.uin);
        break;
      case 1: 
        localArrayList2.add(localRecentUser.uin);
        break;
      case 3000: 
        localArrayList3.add(localRecentUser.uin);
      }
    }
    bfwu.a();
    if (localArrayList1.size() > 2) {
      ((ajxl)paramQQAppInterface.getManager(51)).a(localArrayList1);
    }
    if (localArrayList3.size() > 2) {
      ((ajvi)paramQQAppInterface.getManager(53)).a(localArrayList3);
    }
    if (localArrayList2.size() > 2) {
      ((TroopManager)paramQQAppInterface.getManager(52)).a(localArrayList2);
    }
  }
  
  public RecentBaseData a(String paramString)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = (RecentBaseData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, paramString.toString());
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)) && (paramRecentBaseData != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramRecentBaseData);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(List<RecentBaseData> paramList, String paramString)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("RecentDataListManager", 2, new Object[] { "preloadRecentBaseData, isPreloaded= ", Boolean.valueOf(this.jdField_b_of_type_Boolean), ", forUI=", Boolean.valueOf(paramBoolean2), ", loadMore=", Boolean.valueOf(paramBoolean1) });
    }
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if (paramBoolean2) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (paramQQAppInterface == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label576;
      }
    }
    label169:
    label435:
    label570:
    label576:
    for (Object localObject1 = ((aktf)localObject1).a(true);; localObject1 = null)
    {
      label107:
      int k;
      int j;
      Object localObject2;
      if (localObject1 == null)
      {
        i = 0;
        k = Math.min(10, i);
        if (k <= 0) {
          break label499;
        }
        if (!ahon.a(paramQQAppInterface)) {
          a(paramQQAppInterface, (List)localObject1);
        }
        this.jdField_b_of_type_JavaUtilList = new ArrayList(k);
        this.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
        if (!ahon.a(paramQQAppInterface)) {
          break label435;
        }
        i = 0;
        j = 0;
        if ((i >= ((List)localObject1).size()) || (i >= 10)) {
          break label289;
        }
        localObject2 = (RecentUser)((List)localObject1).get(i);
        RecentBaseData localRecentBaseData = ahon.a(paramQQAppInterface, paramContext, (RecentUser)localObject2);
        if (localRecentBaseData == null) {
          break label264;
        }
        this.jdField_b_of_type_JavaUtilList.add(localRecentBaseData);
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break label169;
        localObject1 = paramQQAppInterface.a();
        break;
        i = ((List)localObject1).size();
        break label107;
        localObject2 = ahmg.a((RecentUser)localObject2, paramQQAppInterface, paramContext, true);
        this.jdField_b_of_type_JavaUtilList.add(localObject2);
      }
      ahon.a(((List)localObject1).size(), ((List)localObject1).size() - j);
      QLog.d("RecentDataListManager", 1, new Object[] { "Recover from parcel, success size=", Integer.valueOf(j), " RU size=", Integer.valueOf(((List)localObject1).size()) });
      for (;;)
      {
        paramContext = new ahnr(paramQQAppInterface);
        if ((paramQQAppInterface.isLogin()) && (Friends.isValidUin(paramQQAppInterface.getCurrentAccountUin()))) {
          paramContext.a(0, paramQQAppInterface.getCurrentAccountUin());
        }
        i = 0;
        while (i < k)
        {
          paramQQAppInterface = (RecentUser)((List)localObject1).get(i);
          if (paramQQAppInterface != null) {
            paramContext.a(paramQQAppInterface.getType(), paramQQAppInterface.uin);
          }
          i += 1;
        }
        ahmg.a((List)localObject1, paramQQAppInterface, paramContext, this.jdField_b_of_type_JavaUtilList, k);
        QLog.d("RecentDataListManager", 1, new Object[] { "Recover from old way, success size= RU size=", Integer.valueOf(((List)localObject1).size()), " limit=", Integer.valueOf(k) });
      }
      this.jdField_a_of_type_Boolean = true;
      label499:
      paramQQAppInterface = this.jdField_b_of_type_JavaUtilList;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder().append("preloadRecentBaseData end: ").append(this.jdField_b_of_type_Boolean);
        if (paramQQAppInterface == null) {
          break label570;
        }
      }
      for (int i = paramQQAppInterface.size();; i = 0)
      {
        QLog.d("RecentDataListManager", 2, i);
        paramBoolean1 = bool;
        if (k > 0) {
          paramBoolean1 = true;
        }
        return paramBoolean1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnl
 * JD-Core Version:    0.7.0.1
 */