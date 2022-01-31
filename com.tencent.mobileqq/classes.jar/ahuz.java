import com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class ahuz
  implements Runnable
{
  public ahuz(ApproximateSearchEngine paramApproximateSearchEngine, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    List localList = ApproximateSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine, this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    ISearchListener localISearchListener = ApproximateSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine);
    if ((localISearchListener != null) && (localList != null)) {
      localISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahuz
 * JD-Core Version:    0.7.0.1
 */