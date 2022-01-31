import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class ahwa
  implements Runnable
{
  public ahwa(MessageSearchEngine paramMessageSearchEngine, ISearchListener paramISearchListener, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    ahwb localahwb = null;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null)
    {
      localahwb = new ahwb(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a.addObserver(localahwb);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if (localahwb != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a.deleteObserver(localahwb);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahwa
 * JD-Core Version:    0.7.0.1
 */