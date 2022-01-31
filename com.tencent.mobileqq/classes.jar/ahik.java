import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class ahik
  implements Runnable
{
  public ahik(PublicAccountSearchEngine paramPublicAccountSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqSearchSearchenginePublicAccountSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahik
 * JD-Core Version:    0.7.0.1
 */