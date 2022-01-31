import android.os.Bundle;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class ahvv
  extends GroupSearchEngine.SearchEngineEntity
{
  public ahvv(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
  }
  
  public ISearchResultGroupModel a(List paramList, String paramString)
  {
    return null;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", 16);
    paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    ArrayList localArrayList = new ArrayList();
    paramSearchRequest = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a(paramSearchRequest);
    if (paramSearchRequest != null) {
      localArrayList.addAll(paramSearchRequest);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvv
 * JD-Core Version:    0.7.0.1
 */