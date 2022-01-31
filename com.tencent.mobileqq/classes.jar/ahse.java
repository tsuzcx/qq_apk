import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.base.CardViewController.2;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ahse
{
  private long jdField_a_of_type_Long;
  private ahsh jdField_a_of_type_Ahsh;
  private altm jdField_a_of_type_Altm;
  private alto jdField_a_of_type_Alto;
  private alwd jdField_a_of_type_Alwd;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<MayKnowRecommend> jdField_a_of_type_JavaUtilArrayList;
  
  public ahse(QQAppInterface paramQQAppInterface, ahsh paramahsh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "CardViewController create");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Alwd = ((alwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159));
    this.jdField_a_of_type_Alto = ((alto)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_Ahsh = paramahsh;
    this.jdField_a_of_type_Altm = new ahsf(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
  }
  
  private int a()
  {
    long l1 = a().getLong("CardViewControllerdisplay_not_2", 0L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (l1 + a() < l2) {
      c();
    }
    int j = 2 - b();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "loadCardSize = " + i);
    }
    return i;
  }
  
  private long a()
  {
    long l = this.jdField_a_of_type_Alwd.a(2);
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getCardDisplayInterval = " + l);
    }
    return l;
  }
  
  private SharedPreferences.Editor a()
  {
    return a().edit();
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CardViewControllermay_know_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "decreaseCurrentDelCount " + paramInt);
    }
    int i = b();
    SharedPreferences.Editor localEditor = a();
    i -= paramInt;
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    localEditor.putInt("CardViewControllerdelete_count", paramInt);
    if (paramInt == 0) {
      localEditor.putLong("CardViewControllerdisplay_not_2", 0L);
    }
    localEditor.apply();
  }
  
  private void a(ArrayList<MayKnowRecommend> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ??? = new ArrayList(2);
      long l1 = a();
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject2).next();
        if (localMayKnowRecommend != null) {
          ((List)???).add(localMayKnowRecommend.uin);
        }
      }
      this.jdField_a_of_type_Alwd.a((List)???, l2, l1, true);
      ??? = paramArrayList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (MayKnowRecommend)((Iterator)???).next();
        if ((localObject2 != null) && (((MayKnowRecommend)localObject2).cardDisplayTimestamp + l1 < l2)) {
          ((MayKnowRecommend)localObject2).cardDisplayTimestamp = l2;
        }
      }
    }
    a(paramArrayList);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "displayMayKnowList done");
      }
      return;
    }
  }
  
  private void a(List<MayKnowRecommend> paramList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshCardData: ");
      if (paramList != null) {
        break label51;
      }
    }
    label51:
    for (String str = "NULL";; str = paramList.toString())
    {
      QLog.d("CardViewController", 2, str);
      this.jdField_a_of_type_Ahsh.a(paramList);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "reallyCheckLocalUpdate, fromNetwork = " + paramBoolean1 + ", isSuccess = " + paramBoolean2);
    }
    ThreadManagerV2.excute(new CardViewController.2(this), 16, null, true);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "isTimeToUpdateMKRDataFromNetwork");
    }
    return this.jdField_a_of_type_Alwd.b(2);
  }
  
  private boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getMKRDataFromNetwork");
    }
    if (!bdin.g(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getMKRDataFromNetwork when network error, abort");
      }
      return false;
    }
    return this.jdField_a_of_type_Alwd.a(2, paramBundle);
  }
  
  private boolean a(MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend != null)
    {
      if (!this.jdField_a_of_type_Alto.b(paramMayKnowRecommend.uin))
      {
        boolean bool = this.jdField_a_of_type_Alto.a(paramMayKnowRecommend.uin, false, true);
        if (bool) {}
        for (int i = 1;; i = 0)
        {
          paramMayKnowRecommend.friendStatus = i;
          if (bool) {
            break;
          }
          return true;
        }
        return false;
      }
      paramMayKnowRecommend.friendStatus = 2;
    }
    return false;
  }
  
  private boolean a(String paramString, List<MayKnowRecommend> paramList)
  {
    if ((paramString != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramList.next();
        if ((localMayKnowRecommend != null) && (paramString.equals(localMayKnowRecommend.uin))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private int b()
  {
    int i = 0;
    int j = a().getInt("CardViewControllerdelete_count", 0);
    if (j < 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "loadCurrentDelCount = " + i);
      }
      return i;
      i = j;
    }
  }
  
  private ArrayList<MayKnowRecommend> b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "calcDisplayingMKRList");
    }
    ArrayList localArrayList1 = c();
    int k = a();
    int j = localArrayList1.size();
    ArrayList localArrayList2 = new ArrayList(k);
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = a();
    int i = 0;
    if ((i >= j) || (localArrayList2.size() >= k))
    {
      label69:
      i = 0;
      localArrayList1.removeAll(localArrayList2);
      j = localArrayList1.size() - 1;
      if ((j < 0) || (localArrayList2.size() >= k))
      {
        if ((i == 0) || (a() == 2)) {
          break label242;
        }
        c();
        return b();
      }
    }
    else
    {
      localMayKnowRecommend = (MayKnowRecommend)localArrayList1.get(i);
      if (a(localMayKnowRecommend))
      {
        if ((localMayKnowRecommend.cardDisplayTimestamp + l2 <= l1) || (a(localMayKnowRecommend.uin, localArrayList2))) {
          break label184;
        }
        localArrayList2.add(localMayKnowRecommend);
      }
      for (;;)
      {
        i += 1;
        break;
        label184:
        if (localMayKnowRecommend.cardDisplayTimestamp != 0L) {
          break label69;
        }
        localArrayList2.add(localMayKnowRecommend);
      }
    }
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localArrayList1.get(j);
    if (a(localMayKnowRecommend))
    {
      localArrayList2.add(localMayKnowRecommend);
      i = 1;
    }
    for (;;)
    {
      j -= 1;
      break;
      label242:
      return localArrayList2;
    }
  }
  
  private ArrayList<MayKnowRecommend> c()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Alwd.c();
    Collections.sort(localArrayList, new ahsg(this));
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getOrderedMKRListFromLocal = " + localArrayList);
    }
    return localArrayList;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "resetCurrentDelCount");
    }
    SharedPreferences.Editor localEditor = a();
    localEditor.putInt("CardViewControllerdelete_count", 0);
    localEditor.putLong("CardViewControllerdisplay_not_2", 0L);
    localEditor.apply();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "increaseCurrentDelCount");
    }
    int i = b();
    SharedPreferences.Editor localEditor = a();
    i += 1;
    localEditor.putInt("CardViewControllerdelete_count", i);
    if (i == 1) {
      localEditor.putLong("CardViewControllerdisplay_not_2", NetConnInfoCenter.getServerTimeMillis());
    }
    localEditor.apply();
  }
  
  public ArrayList<MayKnowRecommend> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getCurrentDisplayingMKRList");
    }
    ArrayList localArrayList = new ArrayList();
    if (a() == 0) {}
    for (;;)
    {
      return localArrayList;
      int i = 0;
      int j = 0;
      Object localObject2;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject2 = this.jdField_a_of_type_JavaLangObject;
        i = j;
      }
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          i = j;
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
          {
            localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
            i = 1;
          }
        }
        if (i != 0) {
          continue;
        }
        localObject2 = b();
        a((ArrayList)localObject2);
        localArrayList.addAll((Collection)localObject2);
        return localArrayList;
      }
      finally {}
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "deleteMayKnowRecommend, uin = " + paramString);
    }
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.f(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "try checkUpdate");
    }
    if (this.jdField_a_of_type_Ahsh.a())
    {
      if (a())
      {
        int i;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1800000L)
        {
          i = 1;
          if (i == 0) {
            break label124;
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("from", "fetch");
          if (a(localBundle)) {
            break label108;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Time is not up, network update is not allowed or network error [1]\"");
          }
          a(false, true);
        }
        label108:
        while (!QLog.isColorLevel())
        {
          return;
          i = 0;
          break;
        }
        QLog.d("CardViewController", 2, "do network checkUpdate. msg: \"send network request done\"");
        return;
        label124:
        if (QLog.isColorLevel()) {
          QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Update too frequently, network update is not allowed\"");
        }
        a(false, true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Time is not up, network update is not allowed [2]\"");
      }
      a(false, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "try checkUpdate， closed");
    }
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahse
 * JD-Core Version:    0.7.0.1
 */