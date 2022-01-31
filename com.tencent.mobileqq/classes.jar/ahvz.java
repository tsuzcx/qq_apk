import android.os.Bundle;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ahvz
  implements Runnable
{
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private SearchRequest jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  private boolean jdField_a_of_type_Boolean;
  
  public ahvz(SearchRequest paramSearchRequest, ArrayList paramArrayList, ISearchListener paramISearchListener, String paramString, CountDownLatch paramCountDownLatch, GroupSearchEngine paramGroupSearchEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = paramCountDownLatch;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGroupSearchEngine);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(ArrayList paramArrayList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      do
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener == null);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.a.getBoolean("hasLocalPeopleOrTroop", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(paramArrayList, 5);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(paramArrayList, 4);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
    while (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.getCount() > 0L) {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    }
  }
  
  public void run()
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, begin local search at :" + l);
    }
    Object localObject1 = (GroupSearchEngine)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str;
    if (localObject1 != null)
    {
      str = GroupSearchEngine.a((GroupSearchEngine)localObject1);
      if (localObject1 == null) {
        break label105;
      }
    }
    label105:
    for (int m = GroupSearchEngine.a((GroupSearchEngine)localObject1);; m = 0)
    {
      if ((localObject1 != null) && (this.jdField_a_of_type_JavaLangString.equals(str))) {
        break label111;
      }
      a();
      return;
      str = "";
      break;
    }
    label111:
    Object localObject3 = GroupSearchEngine.a((GroupSearchEngine)localObject1);
    int i = 0;
    localObject1 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i < ((ArrayList)localObject3).size())
      {
        if ((((GroupSearchEngine.SearchEngineEntity)((ArrayList)localObject3).get(i)).a instanceof ContactSearchEngine))
        {
          localObject2 = (ContactSearchEngine)((GroupSearchEngine.SearchEngineEntity)((ArrayList)localObject3).get(i)).a;
          localObject1 = localObject2;
          if (((ContactSearchEngine)localObject2).a() == 64) {}
        }
      }
      else
      {
        if ((!this.jdField_a_of_type_Boolean) && (localObject2 != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
          break;
        }
        a();
        return;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, start search");
    }
    localObject3 = ((ContactSearchEngine)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if ((this.jdField_a_of_type_Boolean) || (localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      a();
      return;
    }
    localObject1 = new ArrayList();
    ((List)localObject1).addAll((Collection)localObject3);
    int j;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = -1;
      while (((Iterator)localObject3).hasNext())
      {
        IModel localIModel = (IModel)((Iterator)localObject3).next();
        j = i + 1;
        i = j;
        if ((localIModel instanceof GroupSearchModelLocalContact))
        {
          localObject3 = ((GroupSearchModelLocalContact)localIModel).a.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((List)localObject1).add((IContactSearchModel)((Iterator)localObject3).next());
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      localObject3 = new ArrayList();
      ((ContactSearchEngine)localObject2).a((List)localObject1, (List)localObject3, null, str);
      if ((this.jdField_a_of_type_Boolean) || (((List)localObject3).isEmpty()))
      {
        a();
        return;
      }
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject3).iterator();
      int k = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
        if ((localObject3 instanceof ContactSearchModelGlobalTroop))
        {
          int n = k + 1;
          k = n;
          if (n > 200) {
            break label534;
          }
          ((List)localObject1).add(localObject3);
          k = n;
        }
        label534:
        for (;;)
        {
          break;
          ((List)localObject1).add(localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable troopCount:" + k);
      }
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((List)localObject2).add((IContactSearchModel)((Iterator)localObject1).next());
      }
      localObject1 = new GroupSearchModelLocalContact((List)localObject2, str, m);
      if (i == 0)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(new GroupSearchModeTitle((ISearchResultGroupModel)localObject1));
        ((ArrayList)localObject2).add(localObject1);
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          ((ArrayList)localObject2).addAll(this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
      for (localObject1 = localObject2; (this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_JavaLangString.equals(str)); localObject1 = this.jdField_a_of_type_JavaUtilArrayList)
      {
        a();
        return;
        this.jdField_a_of_type_JavaUtilArrayList.remove(j);
        this.jdField_a_of_type_JavaUtilArrayList.add(j, localObject1);
        if ((this.jdField_a_of_type_JavaUtilArrayList.get(j - 1) instanceof GroupSearchModeTitle))
        {
          boolean bool1 = bool2;
          if (((ISearchResultGroupModel)localObject1).a() != null)
          {
            bool1 = bool2;
            if (((ISearchResultGroupModel)localObject1).a().size() > ((ISearchResultGroupModel)localObject1).a()) {
              bool1 = true;
            }
          }
          ((GroupSearchModeTitle)this.jdField_a_of_type_JavaUtilArrayList.get(j - 1)).a(bool1);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (!((ArrayList)localObject1).isEmpty())) {
        a((ArrayList)localObject1);
      }
      localObject1 = (GroupSearchEngine)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 == null) {
        break;
      }
      GroupSearchEngine.a((GroupSearchEngine)localObject1, System.currentTimeMillis() - l);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, end search, cost: " + GroupSearchEngine.a((GroupSearchEngine)localObject1));
      return;
      j = i;
      i = 0;
      continue;
      i = 0;
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvz
 * JD-Core Version:    0.7.0.1
 */