import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import java.util.Comparator;

public final class ahwn
  implements Comparator
{
  public int a(PublicAccountSearchResultModel paramPublicAccountSearchResultModel1, PublicAccountSearchResultModel paramPublicAccountSearchResultModel2)
  {
    int j = Long.signum(paramPublicAccountSearchResultModel2.b() - paramPublicAccountSearchResultModel1.b());
    int i = j;
    if (j == 0) {
      i = PublicAccountSearchEngine.a(paramPublicAccountSearchResultModel1, paramPublicAccountSearchResultModel2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahwn
 * JD-Core Version:    0.7.0.1
 */