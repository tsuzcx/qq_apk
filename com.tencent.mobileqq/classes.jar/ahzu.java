import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.CreateDiscussionSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class ahzu
  implements Runnable
{
  public ahzu(ContactSearchEngine paramContactSearchEngine, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    List localList1 = ContactSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    ISearchListener localISearchListener = ContactSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine);
    if ((localISearchListener != null) && (localList1 != null))
    {
      if (ContactSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine) == null) {
        localISearchListener.a(localList1, 1);
      }
    }
    else {
      return;
    }
    localISearchListener.a(localList1);
    List localList2 = ContactSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine).a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localISearchListener.a(localList1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahzu
 * JD-Core Version:    0.7.0.1
 */