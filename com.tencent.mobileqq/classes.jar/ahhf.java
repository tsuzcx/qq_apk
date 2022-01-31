import com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Comparator;
import java.util.Map;

public final class ahhf
  implements Comparator
{
  public int a(GroupSearchEngine.SearchEngineEntity paramSearchEngineEntity1, GroupSearchEngine.SearchEngineEntity paramSearchEngineEntity2)
  {
    paramSearchEngineEntity2 = (Integer)SearchConfigManager.searchEngineOrder.get(paramSearchEngineEntity2.a);
    if (paramSearchEngineEntity2 == null) {
      paramSearchEngineEntity2 = Integer.valueOf(0);
    }
    for (;;)
    {
      Integer localInteger = (Integer)SearchConfigManager.searchEngineOrder.get(paramSearchEngineEntity1.a);
      paramSearchEngineEntity1 = localInteger;
      if (localInteger == null) {
        paramSearchEngineEntity1 = Integer.valueOf(0);
      }
      return Integer.signum(paramSearchEngineEntity2.intValue() - paramSearchEngineEntity1.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahhf
 * JD-Core Version:    0.7.0.1
 */