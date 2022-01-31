import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.List;

public class ahyl
  implements Runnable
{
  public ahyl(FTSMessageSearchEngine paramFTSMessageSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener) {}
  
  public void run()
  {
    if (SQLiteFTSUtils.g(FTSMessageSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsmsgFTSMessageSearchEngine)) == 1) {}
    for (List localList = this.jdField_a_of_type_ComTencentMobileqqSearchFtsmsgFTSMessageSearchEngine.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, false);; localList = this.jdField_a_of_type_ComTencentMobileqqSearchFtsmsgFTSMessageSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest, false))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localList, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahyl
 * JD-Core Version:    0.7.0.1
 */