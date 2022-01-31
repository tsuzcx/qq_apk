import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class ahim
  implements Comparator
{
  public int a(PublicAccountSearchResultModel paramPublicAccountSearchResultModel1, PublicAccountSearchResultModel paramPublicAccountSearchResultModel2)
  {
    int j = Long.signum(paramPublicAccountSearchResultModel2.b() - paramPublicAccountSearchResultModel1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramPublicAccountSearchResultModel2.a() - paramPublicAccountSearchResultModel1.a());
    }
    j = i;
    if (i == 0) {
      j = PublicAccountSearchEngine.a(paramPublicAccountSearchResultModel1, paramPublicAccountSearchResultModel2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahim
 * JD-Core Version:    0.7.0.1
 */