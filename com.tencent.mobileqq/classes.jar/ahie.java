import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ahie
  implements ISearchListener
{
  public ahie(NetSearchEngine paramNetSearchEngine, List paramList) {}
  
  public void a(List paramList) {}
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    SearchUtils.a();
    NetSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine).a.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahie
 * JD-Core Version:    0.7.0.1
 */