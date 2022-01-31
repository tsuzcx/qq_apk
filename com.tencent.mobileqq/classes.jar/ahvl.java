import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import java.util.List;

public class ahvl
  extends GroupSearchEngine.SearchEngineEntity
{
  public ahvl(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    super(paramGroupSearchEngine, paramISearchEngine, paramString, paramInt);
  }
  
  public ISearchResultGroupModel a(List paramList, String paramString)
  {
    return new GroupSearchModelMessage(paramList, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahvl
 * JD-Core Version:    0.7.0.1
 */