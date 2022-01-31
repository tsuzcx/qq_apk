import android.os.Bundle;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ahhw
  implements Runnable
{
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private SearchRequest jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest;
  private boolean jdField_a_of_type_Boolean;
  
  public ahhw(GroupSearchEngine paramGroupSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
  }
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "begin local search at :" + l1);
    }
    int j = 0;
    int k = 0;
    for (;;)
    {
      if (k >= GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).size()) {
        break label821;
      }
      Object localObject3 = (GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).get(k);
      if ((((GroupSearchEngine.SearchEngineEntity)localObject3).a instanceof NetSearchEngine)) {}
      try
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        Thread.sleep(300L);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject4;
          ArrayList localArrayList2;
          localInterruptedException.printStackTrace();
          continue;
          int i = 1;
          continue;
          localObject2 = (GroupSearchModelLocalContact)localInterruptedException.get(1);
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "start search : " + ((GroupSearchEngine.SearchEngineEntity)localObject3).a.getClass().getSimpleName());
      }
      localObject1 = ((GroupSearchEngine.SearchEngineEntity)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "end search : " + ((GroupSearchEngine.SearchEngineEntity)localObject3).a.getClass().getSimpleName());
      }
      i = j;
      if ((((GroupSearchEngine.SearchEngineEntity)localObject3).a instanceof MessageSearchEngine)) {
        if (localObject1 != null)
        {
          i = j;
          if (!((List)localObject1).isEmpty()) {}
        }
        else
        {
          if (localArrayList1.isEmpty()) {
            break;
          }
          localObject4 = new GroupSearchModelMessage(null, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_JavaLangString);
          localArrayList1.add(new GroupSearchModeTitle((ISearchResultGroupModel)localObject4));
          localArrayList1.add(localObject4);
          SearchStatisticsConstants.a(40);
          i = j;
        }
      }
      j = i;
      if (localObject1 != null)
      {
        j = i;
        if (!((List)localObject1).isEmpty())
        {
          j = i;
          if ((((GroupSearchEngine.SearchEngineEntity)localObject3).a instanceof NetSearchEngine))
          {
            j = i;
            if (localArrayList1.isEmpty()) {
              j = 0;
            }
          }
          i = j;
          if (j != 0)
          {
            localObject4 = new GroupSearchModelMessage(null, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_JavaLangString);
            localArrayList1.add(new GroupSearchModeTitle((ISearchResultGroupModel)localObject4));
            localArrayList1.add(localObject4);
            SearchStatisticsConstants.a(40);
            i = 0;
          }
          localArrayList1.addAll((Collection)localObject1);
          j = i;
          if (!(((GroupSearchEngine.SearchEngineEntity)localObject3).a instanceof NetSearchEngine))
          {
            SearchStatisticsConstants.a(((GroupSearchEngine.SearchEngineEntity)localObject3).b);
            j = i;
          }
        }
      }
      if (((((GroupSearchEngine.SearchEngineEntity)localObject3).a instanceof ContactSearchEngine)) && (((ContactSearchEngine)((GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).get(k)).a).a() != 64))
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (!localArrayList1.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchCreateDiscussion", true);
        localObject3 = ((GroupSearchEngine.SearchEngineEntity)localObject3).a.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          localObject4 = (ISearchResultModel)((List)localObject3).get(0);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label805;
          }
          localArrayList2 = new ArrayList();
          localObject3 = new GroupSearchModelLocalContact(null, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine), GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
          localArrayList2.add(new GroupSearchModeTitle((ISearchResultGroupModel)localObject3));
          localArrayList2.add(localObject3);
          localArrayList1.addAll(localArrayList2);
          localObject1 = localObject3;
          if (localArrayList2.size() > 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
            localObject1 = localObject3;
          }
          ((GroupSearchModelLocalContact)localObject1).a((ISearchResultModel)localObject4);
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (!localArrayList1.isEmpty())) {
            this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList1);
          }
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) && (!localArrayList1.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList1);
      }
      k += 1;
    }
    label805:
    Object localObject2;
    label821:
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember");
      localObject2 = new CountDownLatch(1);
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchCreateDiscussion", false);
        if (GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine) == null) {
          GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1));
        }
        GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, new ahhx(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, (ArrayList)((ArrayList)localArrayList1).clone(), this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine), (CountDownLatch)localObject2, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
        GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine).schedule(GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine), 0L, TimeUnit.MILLISECONDS));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null)
      {
        if (!bool) {
          break label1088;
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList1, 1);
        ((CountDownLatch)localObject2).countDown();
      }
      while (!this.jdField_a_of_type_Boolean)
      {
        long l2 = System.currentTimeMillis();
        GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine, l2 - l1);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("GroupSearchEngine", 4, "search process cost:" + GroupSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine));
        return;
        label1088:
        if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("hasLocalPeopleOrTroop", false)) {
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList1, 5);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList1, 4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahhw
 * JD-Core Version:    0.7.0.1
 */