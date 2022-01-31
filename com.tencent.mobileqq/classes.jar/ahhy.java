import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class ahhy
  implements Runnable
{
  public ahhy(MessageSearchEngine paramMessageSearchEngine, ISearchListener paramISearchListener, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    ahhz localahhz = null;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null)
    {
      localahhz = new ahhz(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a.addObserver(localahhz);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if (localahhz != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a.deleteObserver(localahhz);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahhy
 * JD-Core Version:    0.7.0.1
 */