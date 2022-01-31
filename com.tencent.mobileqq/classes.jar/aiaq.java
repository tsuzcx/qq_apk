import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public class aiaq
  implements Runnable
{
  public aiaq(MessageSearchEngine paramMessageSearchEngine, ISearchListener paramISearchListener, SearchRequest paramSearchRequest) {}
  
  public void run()
  {
    aiar localaiar = null;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null)
    {
      localaiar = new aiar(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a.addObserver(localaiar);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest);
    if (localaiar != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineMessageSearchEngine.a.deleteObserver(localaiar);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiaq
 * JD-Core Version:    0.7.0.1
 */