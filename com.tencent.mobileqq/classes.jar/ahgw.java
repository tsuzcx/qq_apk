import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine;
import com.tencent.mobileqq.search.util.SearchMatchResult;
import java.util.Comparator;

public final class ahgw
  implements Comparator
{
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i;
    if (paramIContactSearchModel2.a() == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      if (paramIContactSearchModel1.a() == null) {
        return 1;
      }
      j = Integer.signum(paramIContactSearchModel2.a().c - paramIContactSearchModel1.a().c);
      i = j;
    } while (j != 0);
    return ApproximateSearchEngine.a(paramIContactSearchModel1, paramIContactSearchModel2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahgw
 * JD-Core Version:    0.7.0.1
 */