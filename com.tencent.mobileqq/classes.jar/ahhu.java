import android.os.Bundle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahhu
  extends GroupSearchEngine.SearchEngineEntity
{
  public ahhu(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
  }
  
  public ISearchResultGroupModel a(List paramList, String paramString)
  {
    return new GroupSearchModelLocalContact(paramList, paramString, GroupSearchEngine.a(this.a));
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    VADHelper.a("voice_search_accurate_cost");
    List localList = super.a(paramSearchRequest);
    VADHelper.b("voice_search_accurate_cost");
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramSearchRequest.a == null) {
        paramSearchRequest.a = new Bundle();
      }
      paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1000);
      if (localList.size() >= 2)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("GroupSearchEngine", 4, "contact search result count:" + ((ISearchResultGroupModel)localList.get(1)).a().size());
        }
        paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", ((ISearchResultGroupModel)localList.get(1)).a().size());
      }
      return localList;
    }
    paramSearchRequest.a.putInt("SEARCH_REQUEST_EXTRA_RESULT_COUNT", 0);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahhu
 * JD-Core Version:    0.7.0.1
 */